/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.wizard.atlfile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.Messages;
import org.eclipse.m2m.atl.common.ATLLaunchConstants;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

/**
 * The ATL new file wizard.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlFileWizard extends Wizard implements INewWizard, IExecutableExtension {

	private static final String DEFAULT_VM_NAME = ATLLaunchConstants.EMF_VM_NAME;

	private IConfigurationElement configElement;

	private WizardNewFileCreationPage simplePage;

	private AtlFileScreen advancedPage;

	private IStructuredSelection selection;

	private IWorkbench workbench;

	/**
	 * Constructor.
	 */
	public AtlFileWizard() {
		super();
		setNeedsProgressMonitor(true);
		setWindowTitle(Messages.getString("AtlFileWizard.Title")); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		simplePage = new WizardNewFileCreationPage(Messages.getString("AtlFileWizard.Page.Name"), selection); //$NON-NLS-1$
		simplePage.setImageDescriptor(AtlUIPlugin.getImageDescriptor("ATLWizard.png")); //$NON-NLS-1$
		simplePage.setTitle(Messages.getString("AtlFileWizard.Title")); //$NON-NLS-1$
		simplePage.setDescription(Messages.getString("AtlFileWizard.Page.Description")); //$NON-NLS-1$
		simplePage.setFileExtension("atl"); //$NON-NLS-1$
		addPage(simplePage);
		advancedPage = new AtlFileScreen(selection);
		addPage(advancedPage);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		try {
			final IFile file = simplePage.createNewFile();
			WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
				@Override
				protected void execute(IProgressMonitor progressMonitor) {
					try {
						buildFile(file);
						buildConfiguration(file);
						BasicNewProjectResourceWizard.updatePerspective(configElement);
					} catch (Exception exception) {
						exception.printStackTrace();
					} finally {
						progressMonitor.done();
					}
				}
			};
			getContainer().run(false, false, operation);

			// Select the new file resource in the current view.
			//
			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = workbenchWindow.getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			if (activePart instanceof ISetSelectionTarget) {
				final ISelection targetSelection = new StructuredSelection(file);
				getShell().getDisplay().asyncExec(new Runnable() {
					public void run() {
						((ISetSelectionTarget)activePart).selectReveal(targetSelection);
					}
				});
			}

			// Open editor on new file.
			IWorkbenchWindow dw = workbench.getActiveWorkbenchWindow();
			try {
				if (dw != null) {
					if (page != null) {
						IDE.openEditor(page, file, true);
					}
				}
			} catch (PartInitException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#getNextPage(org.eclipse.jface.wizard.IWizardPage)
	 */
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page instanceof WizardNewFileCreationPage) {
			advancedPage.setModuleName(getModuleNameFromFile());
		}
		return super.getNextPage(page);
	}

	/**
	 * This method creates an ATL project in the workspace with : the ATL transformation file the toString
	 * file (if the project needs it) the toString query file (if the project needs it).
	 */
	private void buildFile(IFile file) throws IOException, CoreException {
		StringBuffer fileContent = new StringBuffer();
		if (advancedPage.isCurrentPage()) {
			// Completion helpers
			Map<String, String> paths = advancedPage.getPaths();
			if (!paths.isEmpty()) {
				for (Iterator<String> iterator = paths.keySet().iterator(); iterator.hasNext();) {
					String metamodelName = iterator.next();
					String path = paths.get(metamodelName);
					String tag;
					if (path.startsWith("platform:/resource")) { //$NON-NLS-1$
						path = path.replaceFirst("platform:/resource", ""); //$NON-NLS-1$ //$NON-NLS-2$
						tag = "-- @path "; //$NON-NLS-1$
					} else if (path.startsWith("file:/") || path.startsWith("platform:/plugin")) { //$NON-NLS-1$ //$NON-NLS-2$
						tag = "-- @path "; //$NON-NLS-1$
					} else {
						tag = "-- @nsURI "; //$NON-NLS-1$
					}
					fileContent.append(tag + metamodelName + "=" + path + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
				}
				fileContent.append("\n"); //$NON-NLS-1$
			}
		}
		// Type header
		String unitType = advancedPage.getUnitType();
		String unitName = advancedPage.getUnitName();
		if (unitType.equals(AtlFileScreen.TYPE_REFINING_MODULE)) {
			fileContent.append(AtlFileScreen.TYPE_MODULE + " " + unitName + ";\n"); //$NON-NLS-1$ //$NON-NLS-2$			
		} else if (unitType.equals(AtlFileScreen.TYPE_QUERY)) {
			fileContent.append(AtlFileScreen.TYPE_QUERY + " " + unitName + " = true;\n"); //$NON-NLS-1$ //$NON-NLS-2$
		} else {
			fileContent.append(unitType + " " + unitName + ";\n"); //$NON-NLS-1$ //$NON-NLS-2$
		}

		if (advancedPage.isCurrentPage()) {
			// Module header
			if (unitType.equals(AtlFileScreen.TYPE_MODULE)
					|| unitType.equals(AtlFileScreen.TYPE_REFINING_MODULE)) {
				Map<String, String> inputModels = advancedPage.getInput();
				Map<String, String> outputModels = advancedPage.getOutput();
				if (!inputModels.isEmpty() && !outputModels.isEmpty()) {
					fileContent.append("create "); //$NON-NLS-1$
					fileContent.append(createModelDeclarationFromMap(outputModels));
					if (unitType.equals(AtlFileScreen.TYPE_MODULE)) {
						fileContent.append(" from "); //$NON-NLS-1$
					} else {
						fileContent.append(" refining "); //$NON-NLS-1$
					}
					fileContent.append(createModelDeclarationFromMap(inputModels));
					fileContent.append(";\n"); //$NON-NLS-1$
				}
			}
			fileContent.append("\n"); //$NON-NLS-1$

			// Library imports
			Map<String, String> libraries = advancedPage.getLibraries();
			if (!libraries.isEmpty()) {
				for (Iterator<String> iterator = libraries.keySet().iterator(); iterator.hasNext();) {
					String library = iterator.next();
					fileContent.append("uses " + library + ";\n"); //$NON-NLS-1$ //$NON-NLS-2$
				}
				fileContent.append("\n"); //$NON-NLS-1$
			}
		}
		InputStream stream = openContentStream(fileContent.toString());
		if (file.exists()) {
			file.setContents(stream, true, true, null);
		} else {
			file.create(stream, true, null);
		}
		stream.close();
	}

	private void buildConfiguration(IFile file) throws CoreException {
		if (advancedPage.isCurrentPage()) {
			if (advancedPage.generateLaunchConfig()) {
				ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
				String unitName = advancedPage.getUnitName();
				String name = manager.generateUniqueLaunchConfigurationNameFrom(unitName);
				ILaunchConfigurationType type = manager
						.getLaunchConfigurationType(ATLLaunchConstants.LAUNCH_CONFIGURATION_TYPE);
				ILaunchConfigurationWorkingCopy editableConfiguration = type.newInstance(null, name);
				editableConfiguration.setAttribute(ATLLaunchConstants.ATL_VM, DEFAULT_VM_NAME);
				editableConfiguration.setAttribute(ATLLaunchConstants.ATL_FILE_NAME, file.getFullPath()
						.toString());
				editableConfiguration.setAttribute(ATLLaunchConstants.IS_REFINING, advancedPage.getUnitType()
						.equals(AtlFileScreen.TYPE_REFINING_MODULE));
				editableConfiguration.setAttribute(ATLLaunchConstants.INPUT, advancedPage.getInput());
				editableConfiguration.setAttribute(ATLLaunchConstants.OUTPUT, advancedPage.getOutput());
				editableConfiguration.setAttribute(ATLLaunchConstants.LIBS, advancedPage.getLibraries());
				editableConfiguration.setAttribute(ATLLaunchConstants.PATH, convertPaths(advancedPage
						.getPaths()));

				editableConfiguration.doSave();
			}
		}
	}

	private StringBuffer createModelDeclarationFromMap(Map<String, String> models) {
		StringBuffer declaration = new StringBuffer();
		for (Iterator<String> iterator = models.keySet().iterator(); iterator.hasNext();) {
			String modelName = iterator.next();
			declaration.append(modelName + " : " + models.get(modelName)); //$NON-NLS-1$
			if (iterator.hasNext()) {
				declaration.append(", "); //$NON-NLS-1$
			}
		}
		return declaration;
	}

	/**
	 * This method transforms string into inputstream.
	 * 
	 * @param contents
	 *            content of the file to cast in InputStream
	 * @return the InputStream content
	 */
	private InputStream openContentStream(String contents) {
		return new ByteArrayInputStream(contents.getBytes());
	}

	/**
	 * Returns the default module name.
	 * 
	 * @return the default module name
	 */
	public String getModuleNameFromFile() {
		String fileName = simplePage.getFileName();
		if (fileName.endsWith(".atl")) { //$NON-NLS-1$
			fileName = fileName.substring(0, fileName.length() - 4);
		}
		return fileName;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench currentWorkbench, IStructuredSelection structuredSelection) {
		this.workbench = currentWorkbench;
		this.selection = structuredSelection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org.eclipse.core.runtime.IConfigurationElement,
	 *      java.lang.String, java.lang.Object)
	 */
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		this.configElement = config;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#canFinish()
	 */
	@Override
	public boolean canFinish() {
		if (advancedPage.isCurrentPage()) {
			return advancedPage.isPageComplete();
		}
		return simplePage.isPageComplete();
	}

	/**
	 * Convert model map paths.
	 * 
	 * @param modelPaths
	 *            the model path map
	 * @return the converted map
	 */
	private static Map<String, String> convertPaths(Map<String, String> modelPaths) {
		Map<String, String> result = new HashMap<String, String>();
		for (Iterator<String> iterator = modelPaths.keySet().iterator(); iterator.hasNext();) {
			String modelName = iterator.next();
			String modelPath = modelPaths.get(modelName);
			result.put(modelName, convertPath(modelPath));
		}
		return result;
	}

	private static String convertPath(String path) {
		if (path.startsWith("file:/")) { //$NON-NLS-1$
			return path.replaceFirst("file:/", "ext:"); //$NON-NLS-1$ //$NON-NLS-2$
		} else if (path.startsWith("platform:/resource")) { //$NON-NLS-1$
			return path.substring(18);
		} else if (path.startsWith("platform:/plugin") || path.startsWith("pathmap")) { //$NON-NLS-1$ //$NON-NLS-2$
			return path;
		}
		return "uri:" + path; //$NON-NLS-1$
	}
}
