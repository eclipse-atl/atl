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
import java.util.logging.Level;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.Messages;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

/**
 * The ATL new file wizard.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class AtlFileWizard extends Wizard implements INewWizard, IExecutableExtension {

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
		newModuleBuilder();
		BasicNewProjectResourceWizard.updatePerspective(configElement);
		return true;
	}

	/**
	 * This method creates an ATL project in the workspace with : the ATL transformation file the toString
	 * file (if the project needs it) the toString query file (if the project needs it).
	 */
	public void newModuleBuilder() {
		String fileContent = ""; //$NON-NLS-1$
		if (advancedPage.isPageComplete()) {
			String unitType = advancedPage.getParameter(AtlFileScreen.TYPE);
			String unitName = advancedPage.getParameter(AtlFileScreen.NAME);
			if (unitType.equals(AtlFileScreen.MODULE)) {
				fileContent = AtlFileScreen.MODULE + " " + unitName + ";\n"; //$NON-NLS-1$ //$NON-NLS-2$
				String in = advancedPage.getParameter(AtlFileScreen.IN);
				String out = advancedPage.getParameter(AtlFileScreen.OUT);
				if (in != null && out != null) {
					fileContent += "create " + advancedPage.getParameter(AtlFileScreen.OUT); //$NON-NLS-1$
					fileContent += " from " + advancedPage.getParameter(AtlFileScreen.IN) + ";\n"; //$NON-NLS-1$ //$NON-NLS-2$
				}
				fileContent += advancedPage.getParameter(AtlFileScreen.LIB);
			} else if (unitType.equals(AtlFileScreen.QUERY)) {
				fileContent = AtlFileScreen.QUERY + " " + unitName + " = ;\n"; //$NON-NLS-1$ //$NON-NLS-2$
				fileContent += advancedPage.getParameter(AtlFileScreen.LIB);
			} else if (unitType.equals(AtlFileScreen.LIBRARY)) {
				fileContent = AtlFileScreen.LIBRARY + " " + unitName + ";\n"; //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		createFile(fileContent);

	}

	/**
	 * This method creates a file with its content in the project There is two cases : the project has
	 * external location the project has local location In the first case, a file is created in the file
	 * system and there is a link between this file and the ATL project. In the second case, a file is created
	 * in the project
	 * 
	 * @param fileName
	 *            name of the file to create
	 * @param content
	 *            content of the file to create
	 */
	private void createFile(String content) {
		IFile file = simplePage.createNewFile();
		try {
			InputStream stream = openContentStream(content);
			if (file.exists()) {
				file.setContents(stream, true, true, null);
			} else {
				file.create(stream, true, null);
			}
			stream.close();
		} catch (IOException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (CoreException e1) {
			ATLLogger.log(Level.SEVERE, e1.getLocalizedMessage(), e1);
		}

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
}
