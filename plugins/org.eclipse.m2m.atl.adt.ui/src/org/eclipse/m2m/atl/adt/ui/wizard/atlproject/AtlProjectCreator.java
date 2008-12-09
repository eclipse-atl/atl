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
package org.eclipse.m2m.atl.adt.ui.wizard.atlproject;

import java.util.logging.Level;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.adt.AtlNature;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

/**
 * The ATL project creation wizard.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class AtlProjectCreator extends Wizard implements INewWizard, IExecutableExtension {

	private AtlDescriptionProjectScreen page;

	private IConfigurationElement configElement;

	private ISelection selectionInterface;

	private IProject modelProject;

	/**
	 * Constructor.
	 */
	public AtlProjectCreator() {
		super();
		setNeedsProgressMonitor(true);
	}

	/**
	 * Adding the page to the wizard.
	 */
	@Override
	public void addPages() {
		page = new AtlDescriptionProjectScreen(selectionInterface);
		addPage(page);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		String projectName = page.getProjectName();

		try {
			// Get the worskspace container (IWorkspaceRoot)
			IWorkspace wks = ResourcesPlugin.getWorkspace();
			IWorkspaceRoot wksroot = wks.getRoot();

			// Create a project model instance
			modelProject = wksroot.getProject(projectName);
			if (!modelProject.exists()) {
				modelProject.create(null);
			}

			// open project if necessary
			if (!modelProject.isOpen()) {
				modelProject.open(null);
			}

			// What's this good for?!
			// modelProject.setLocal(true, IResource.DEPTH_ZERO, null);

			addNature(modelProject, AtlNature.ATL_NATURE_ID);
			BasicNewProjectResourceWizard.updatePerspective(configElement);
		} catch (CoreException ce) {
			System.err.println(ce);
		}

		return true;
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
	 * Adds a nature to a project.
	 * 
	 * @param project
	 *            the project to add a nature to
	 * @param natureId
	 *            the natureId of the nature to be added to the project
	 */
	public void addNature(IProject project, String natureId) {
		try {
			IProjectDescription description = project.getDescription();
			String[] natures = description.getNatureIds();
			String[] newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 0, natures.length);
			newNatures[natures.length] = natureId;
			description.setNatureIds(newNatures);
			project.setDescription(description, null);
		} catch (CoreException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
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
