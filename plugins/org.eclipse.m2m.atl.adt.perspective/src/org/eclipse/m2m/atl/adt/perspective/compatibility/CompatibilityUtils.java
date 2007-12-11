/*******************************************************************************
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - ATL compatibility converter
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.perspective.compatibility;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;

/**
 * An utility class for old ATL projects conversion.
 * 
 * @author William Piers <a href="mailto:william.piers@obeo.fr">william.piers@obeo.fr</a>
 * @author Freddy Allilaire
 */
public class CompatibilityUtils {

	public static final String oldNatureId = "org.atl.eclipse.adt.builder.atlNature";
	public static final String newNatureId = "org.eclipse.m2m.atl.adt.builder.atlNature";

	public static final String oldBuilderId = "org.atl.eclipse.adt.builder.atlBuilder";
	public static final String newBuilderId = "org.eclipse.m2m.atl.adt.builder.atlBuilder";

	public static final String oldConfigId = "org.atl.eclipse.adt.launching.atlTransformation";
	public static final String newConfigId = "org.eclipse.m2m.atl.adt.launching.atlTransformation";

	/**
	 * @return
	 * @throws CoreException
	 */
	public static IProject[] getProjects() throws CoreException {
		List res = new ArrayList();
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (int i = 0; i < projects.length; i++) {
			IProject project = projects[i];
			if (project.isOpen()) {
				String[] ids = project.getDescription().getNatureIds();
				if (arrayContains(ids, oldNatureId) && ! arrayContains(ids, newNatureId)) {
					res.add(project);	
				}
			}
		}
		return (IProject[]) res.toArray(new IProject[res.size()]);		
	}

	private static boolean arrayContains(Object[] array,Object o){
		for (int i = 0; i < array.length; i++) {
			if (o.equals(array[i]))	return true;
		}
		return false;
	}
	
	/**
	 * @param projects
	 * @throws CoreException
	 */
	public static void convertProjects(Object[] projects) throws Exception {
		//TODO The NullProgressMonitor does nothing, it could be interesting to catch a ProgressMonitor or to add one.
		NullProgressMonitor monitor = new NullProgressMonitor();
		monitor.beginTask("Starting update of old ATL projects and configurations", IProgressMonitor.UNKNOWN);
		for (int i = 0; i < projects.length; i++) {
			IProject project = (IProject) projects[i];
			monitor.subTask("Inspecting project " + project.getName());
			
			IProjectDescription desc = project.getDescription();
			ICommand[] commands = desc.getBuildSpec();
			String[] natures = desc.getNatureIds();
			
			ICommand[] newCommands = new ICommand[commands.length];
			for (int j = 0; j < commands.length; j++) {
				ICommand command = commands[j];
				if (command.getBuilderName().equals(oldBuilderId)) {
					command.setBuilderName(newBuilderId);
					monitor.subTask("Updating builder id");
				}
				newCommands[j] = command;
			}		
			desc.setBuildSpec(newCommands);
			
			String[] newNatures = new String[natures.length];
			for (int j = 0; j < natures.length; j++) {
				String nature = natures[j];
				if (nature.equals(oldNatureId)) {
					nature = newNatureId;
					monitor.subTask("Updating nature id");
				}
				newNatures[j] = nature;
			}
			desc.setNatureIds(newNatures);
			
			project.setDescription(desc, IProject.AVOID_NATURE_CONFIG, null);

			project.accept(new UpdateCompatibilityVisitor(monitor));

			project.refreshLocal(IProject.DEPTH_INFINITE,null);
			monitor.done();
		}
	}

}
