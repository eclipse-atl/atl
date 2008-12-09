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

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

/**
 * The ATL new file wizard.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class AtlFileWizard extends Wizard implements INewWizard, IExecutableExtension {

	private IConfigurationElement configElement;

	private AtlFileScreen page;

	private ISelection selectionInterface;

	private IContainer modelProject;

	/**
	 * Constructor.
	 */
	public AtlFileWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	/**
	 * Adding the page to the wizard.
	 */
	@Override
	public void addPages() {
		page = new AtlFileScreen(selectionInterface);
		addPage(page);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		newProjectBuilder();
		BasicNewProjectResourceWizard.updatePerspective(configElement);
		return true;
	}

	/**
	 * This method creates an ATL project in the workspace with : the ATL transformation file the toString
	 * file (if the project needs it) the toString query file (if the project needs it).
	 */
	public void newProjectBuilder() {
		String fileName = page.getParameter(AtlFileScreen.NAME);
		String fileType = page.getParameter(AtlFileScreen.TYPE);
		modelProject = (IContainer)ResourcesPlugin.getWorkspace().getRoot().findMember(
				new Path(page.getParameter(AtlFileScreen.CONTAINER)));
		String contentFile = ""; //$NON-NLS-1$

		if (fileType.equals(AtlFileScreen.MODULE)) {
			contentFile = AtlFileScreen.MODULE + " " + fileName + ";\n"; //$NON-NLS-1$ //$NON-NLS-2$
			contentFile += "create " + page.getParameter(AtlFileScreen.OUT); //$NON-NLS-1$
			contentFile += " from " + page.getParameter(AtlFileScreen.IN) + ";\n"; //$NON-NLS-1$ //$NON-NLS-2$
			contentFile += page.getParameter(AtlFileScreen.LIB);
		} else if (fileType.equals(AtlFileScreen.QUERY)) {
			contentFile = AtlFileScreen.QUERY + " " + fileName + " = ;\n"; //$NON-NLS-1$ //$NON-NLS-2$
			contentFile += page.getParameter(AtlFileScreen.LIB);
		} else if (fileType.equals(AtlFileScreen.LIBRARY)) {
			contentFile = AtlFileScreen.LIBRARY + " " + fileName + ";\n"; //$NON-NLS-1$ //$NON-NLS-2$
		}

		createFile(fileName + ".atl", contentFile); //$NON-NLS-1$

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
	private void createFile(String fileName, String content) {
		IFile file = modelProject.getFile(new Path(fileName));
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
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selectionInterface = selection;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org.eclipse.core.runtime.IConfigurationElement, java.lang.String, java.lang.Object)
	 */
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		this.configElement = config;
	}
}
