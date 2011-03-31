/*******************************************************************************
 * Copyright (c) 2009, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.wizard.atlplugin;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.m2m.atl.adt.runner.CreateModuleActivatorWriter;
import org.eclipse.m2m.atl.adt.runner.CreateModuleBuildWriter;
import org.eclipse.m2m.atl.adt.runner.CreateModuleClasspathWriter;
import org.eclipse.m2m.atl.adt.runner.CreateModuleMANIFESTWriter;
import org.eclipse.m2m.atl.adt.runner.CreateModuleProjectWriter;
import org.eclipse.m2m.atl.adt.runner.CreateModulePropertiesWriter;
import org.eclipse.m2m.atl.adt.runner.CreateModuleSettingsWriter;
import org.eclipse.m2m.atl.adt.runner.CreatePluginData;
import org.eclipse.m2m.atl.adt.runner.CreateRunnableData;
import org.eclipse.m2m.atl.adt.runner.CreateRunnableJavaWriter;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.Messages;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

/**
 * The ATL plugin creation wizard.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlPluginCreator extends Wizard implements INewWizard, IExecutableExtension {

	private static final String PROJECT_NAME_PREFIX = "org.eclipse.m2m.atl."; //$NON-NLS-1$

	private static final String DEFAULT_PROJECT_NAME_SUFFIX = "sample"; //$NON-NLS-1$

	protected WizardNewProjectCreationPage newProjectPage;

	protected AtlPluginScreen parametersPage;

	protected IConfigurationElement configElement;

	private IStructuredSelection selection;

	/**
	 * Constructor.
	 */
	public AtlPluginCreator() {
		super();
		setNeedsProgressMonitor(true);
		setWindowTitle(Messages.getString("AtlPluginCreator.Title")); //$NON-NLS-1$
	}

	public WizardNewProjectCreationPage getNewProjectPage() {
		return newProjectPage;
	}

	public AtlPluginScreen getParametersPage() {
		return parametersPage;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		newProjectPage = new WizardNewProjectCreationPage(Messages.getString("AtlPluginCreator.Page.Name")); //$NON-NLS-1$
		newProjectPage.setTitle(Messages.getString("AtlPluginCreator.Title")); //$NON-NLS-1$
		newProjectPage.setDescription(Messages.getString("AtlProjectCreator.Page.Description")); //$NON-NLS-1$
		newProjectPage.setImageDescriptor(AtlUIPlugin.getImageDescriptor("ATLWizard.png")); //$NON-NLS-1$

		parametersPage = new AtlPluginScreen(getClosestATLFile());

		String initialName = PROJECT_NAME_PREFIX;
		IFile atlFile = getClosestATLFile();
		if (atlFile == null) {
			initialName += DEFAULT_PROJECT_NAME_SUFFIX;
		} else {
			initialName += atlFile.getFullPath().removeFileExtension().lastSegment().toLowerCase();
		}
		newProjectPage.setInitialProjectName(initialName);
		newProjectPage.isPageComplete();

		addPage(newProjectPage);
		addPage(parametersPage);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection s) {
		this.selection = s;
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
		if (getContainer().getCurrentPage() == newProjectPage) {
			return newProjectPage.isPageComplete();
		}
		return parametersPage.isPageComplete();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		IWorkspaceRunnable create = new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				CreatePluginData pluginData = new CreatePluginData(newProjectPage.getProjectName());
				pluginData.setRunnableData(parametersPage.getRunnableData());

				IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(
						newProjectPage.getProjectName());
				IPath location = newProjectPage.getLocationPath();
				if (!project.exists()) {
					IProjectDescription desc = project.getWorkspace().newProjectDescription(
							newProjectPage.getProjectName());
					if (location != null
							&& ResourcesPlugin.getWorkspace().getRoot().getLocation().equals(location)) {
						location = null;
					}
					desc.setLocation(location);
					project.create(desc, monitor);
					project.open(monitor);

					convert(project, pluginData, monitor);
				}
				if (!project.isOpen()) {
					project.open(monitor);
				}
			}
		};
		try {
			ResourcesPlugin.getWorkspace().run(create, null);
			return true;
		} catch (CoreException e) {
			IStatus status = new Status(IStatus.ERROR, AtlUIPlugin.PLUGIN_ID, IStatus.OK, e.getMessage(), e);
			AtlUIPlugin.getDefault().getLog().log(status);
			return false;
		}
	}

	private IFile getClosestATLFile() {
		if (selection != null) {
			Object element = selection.getFirstElement();
			if (element instanceof IFile) {
				IFile file = (IFile)element;
				if ("atl".equals(file.getFileExtension())) { //$NON-NLS-1$
					return file;
				}
			}
		}
		return null;
	}

	/**
	 * Converts the given project to ATL Plugin project.
	 * 
	 * @param project
	 *            is the project to convert
	 * @param pluginData
	 *            is the class used to configure all the JET generations
	 * @param monitor
	 *            is the monitor
	 */
	public void convert(IProject project, CreatePluginData pluginData, IProgressMonitor monitor) {
		CreateModuleActivatorWriter activatorWriter = new CreateModuleActivatorWriter();
		String text = activatorWriter.generate(pluginData);
		IPath file = new Path(
				"/src/" + pluginData.getProjectName().replaceAll("\\.", "/") + "/Activator.java"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		createFile(project, file, text, monitor);
		CreateModuleBuildWriter buildWriter = new CreateModuleBuildWriter();
		text = buildWriter.generate(pluginData);
		file = new Path("build.properties"); //$NON-NLS-1$
		createFile(project, file, text, monitor);
		CreateModuleClasspathWriter classpathWriter = new CreateModuleClasspathWriter();
		text = classpathWriter.generate(pluginData);
		file = new Path(".classpath"); //$NON-NLS-1$
		createFile(project, file, text, monitor);
		CreateModuleMANIFESTWriter manifestWriter = new CreateModuleMANIFESTWriter();
		text = manifestWriter.generate(pluginData);
		file = new Path("META-INF/MANIFEST.MF"); //$NON-NLS-1$
		createFile(project, file, text, monitor);
		CreateModuleProjectWriter projectWriter = new CreateModuleProjectWriter();
		text = projectWriter.generate(pluginData);
		file = new Path(".project"); //$NON-NLS-1$
		createFile(project, file, text, monitor);
		CreateModuleSettingsWriter settingsWriter = new CreateModuleSettingsWriter();
		text = settingsWriter.generate(pluginData);
		file = new Path("/.settings/org.eclipse.jdt.core.prefs"); //$NON-NLS-1$
		createFile(project, file, text, monitor);

		CreateRunnableData runnableData = pluginData.getRunnableData();
		if (runnableData != null) {
			CreateRunnableJavaWriter runnableWriter = new CreateRunnableJavaWriter();
			text = runnableWriter.generate(pluginData);
			file = new Path(
					"/src/"	+ project.getName().replaceAll("\\.", "/") + "/files/" + runnableData.getClassShortName() + ".java"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			createFile(project, file, text, monitor);

			CreateModulePropertiesWriter propertiesWriter = new CreateModulePropertiesWriter();
			text = propertiesWriter.generate(runnableData);
			file = new Path(
					"/src/"	+ project.getName().replaceAll("\\.", "/") + "/files/" + runnableData.getClassShortName() + ".properties"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			createFile(project, file, text, monitor);

			// ATL files copy
			for (int i = 0; i < runnableData.getTransformationFiles().length; i++) {
				IFile transfoFile = runnableData.getTransformationFiles()[i];
				copyAtlFile(
						project,
						transfoFile,
						new Path(
								"/src/"	+ project.getName().replaceAll("\\.", "/") + "/files/" + transfoFile.getName()), monitor); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			}

			// ATL libraries copy
			for (String libraryName : runnableData.getAllLibrariesNames()) {
				IFile libraryFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
						new Path(runnableData.getLibraryLocations().get(libraryName)));
				copyAtlFile(
						project,
						libraryFile,
						new Path(
								"/src/"	+ project.getName().replaceAll("\\.", "/") + "/files/" + libraryFile.getName()), monitor); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			}
		}
	}

	/**
	 * Creates a file and its content.
	 * 
	 * @param project
	 *            is the project
	 * @param projectRelativePath
	 *            is the path of the file to create, relative to the project
	 * @param content
	 *            is the content of the new file
	 * @param monitor
	 *            is the monitor
	 */
	public static void createFile(IProject project, IPath projectRelativePath, String content,
			IProgressMonitor monitor) {
		try {
			ByteArrayInputStream javaStream = new ByteArrayInputStream(content.getBytes("UTF8")); //$NON-NLS-1$
			IContainer container = project;
			String[] folders = projectRelativePath.removeLastSegments(1).segments();
			for (int i = 0; i < folders.length; i++) {
				container = container.getFolder(new Path(folders[i]));
				if (!container.exists()) {
					((IFolder)container).create(true, true, monitor);
				}
			}
			IFile file = container.getFile(new Path(projectRelativePath.lastSegment()));
			if (!file.exists() && file.getParent().exists()) {
				IResource[] members = file.getParent().members(IResource.FILE);
				for (int i = 0; i < members.length; i++) {
					if (members[i] instanceof IFile
							&& file.getName().toLowerCase().equals(members[i].getName().toLowerCase())) {
						file = (IFile)members[i];
						break;
					}
				}
			}
			if (!file.exists()) {
				file.create(javaStream, true, monitor);
			} else {
				file.setContents(javaStream, true, false, monitor);
			}
		} catch (CoreException e) {
			IStatus status = new Status(IStatus.ERROR, AtlUIPlugin.PLUGIN_ID, IStatus.OK, e.getMessage(), e);
			AtlUIPlugin.getDefault().getLog().log(status);
		} catch (UnsupportedEncodingException e) {
			IStatus status = new Status(IStatus.ERROR, AtlUIPlugin.PLUGIN_ID, IStatus.OK, e.getMessage(), e);
			AtlUIPlugin.getDefault().getLog().log(status);
		}
	}

	/**
	 * Copies an ATL file: in case of a .asm, attempt to copy the .atl instead if present.
	 * 
	 * @param project
	 *            the current project
	 * @param fileToCopy
	 *            is the file
	 * @param targetDirRelativePath
	 *            is the path of the copy
	 * @param monitor
	 *            is the monitor
	 */
	public static void copyAtlFile(IProject project, IFile fileToCopy, IPath targetDirRelativePath,
			IProgressMonitor monitor) {
		if ("asm".equals(fileToCopy.getFileExtension())) { //$NON-NLS-1$
			IFile atlFile = fileToCopy.getProject().getParent().getFile(
					fileToCopy.getFullPath().removeFileExtension().addFileExtension("atl")); //$NON-NLS-1$
			if (atlFile != null && atlFile.isAccessible()) {
				copyFile(project, atlFile, targetDirRelativePath, monitor);
				return;
			}
		}
		copyFile(project, fileToCopy, targetDirRelativePath, monitor);
	}

	/**
	 * Copies a file.
	 * 
	 * @param project
	 *            the current project
	 * @param fileToCopy
	 *            is the file
	 * @param targetDirRelativePath
	 *            is the path of the copy
	 * @param monitor
	 *            is the monitor
	 */
	public static void copyFile(IProject project, IFile fileToCopy, IPath targetDirRelativePath,
			IProgressMonitor monitor) {
		try {
			IContainer container = project;
			String[] folders = targetDirRelativePath.removeLastSegments(1).segments();
			for (int i = 0; i < folders.length; i++) {
				container = container.getFolder(new Path(folders[i]));
				if (!container.exists()) {
					((IFolder)container).create(true, true, monitor);
				}
			}
			fileToCopy.copy(container.getFullPath().append(fileToCopy.getName()), true, monitor);

		} catch (CoreException e) {
			IStatus status = new Status(IStatus.ERROR, AtlUIPlugin.PLUGIN_ID, IStatus.OK, e.getMessage(), e);
			AtlUIPlugin.getDefault().getLog().log(status);
		}
	}
}
