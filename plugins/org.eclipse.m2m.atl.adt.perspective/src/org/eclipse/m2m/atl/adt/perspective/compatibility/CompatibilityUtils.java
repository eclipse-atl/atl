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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;

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
	public static IProject[] getProjects(String natureId) throws CoreException {
		List res = new ArrayList();
		IProject[] projects = ResourcesPlugin.getPlugin().getWorkspace().getRoot().getProjects();
		for (int i = 0; i < projects.length; i++) {
			IProject project = projects[i];
			if (project.isOpen()) {
				String[] ids = project.getDescription().getNatureIds();
				for (int j = 0; j < ids.length; j++) {
					String string = ids[j];
					if (string.equals(natureId)) {
						res.add(project);
						break;
					}
				}
			}
		}
		return (IProject[]) res.toArray(new IProject[res.size()]);		
	}

	/**
	 * @return
	 * @throws CoreException
	 */
	public static ILaunchConfiguration[] getConfigurations(String configId) throws CoreException {
		List res = new ArrayList();
		ILaunchConfiguration[] configurations = DebugPlugin.getDefault().getLaunchManager().getLaunchConfigurations();
		for (int i = 0; i < configurations.length; i++) {
			ILaunchConfiguration configuration = configurations[i];
			if (configuration.getType().getIdentifier().equals(configId)) {
				res.add(configuration);			
			}
		}
		return (ILaunchConfiguration[]) res.toArray(new ILaunchConfiguration[res.size()]);	
	}

	/**
	 * @param projects
	 * @throws CoreException
	 */
	public static void convertProjects(Object[] projects, String preNatureId, String preBuilderId, String postNatureId, String postBuilderId) throws CoreException {
		for (int i = 0; i < projects.length; i++) {
			IProject project = (IProject) projects[i];
			IProjectDescription oldDescription = project.getDescription();
			//ProjectDescription newDescription =
			oldDescription.getNatureIds();
			//TODO
			oldDescription.getBuildSpec();
			System.out.println("need to change project "+project.getName());
		}
	}

	/**
	 * @param configurations
	 */
	public static void convertConfigs(Object[] configurations, String preConfId, String postConfId){
		for (int i = 0; i < configurations.length; i++) {
			ILaunchConfiguration launchConfiguration = (ILaunchConfiguration) configurations[i];
			System.out.println("need to change config "+launchConfiguration.getName());
			//TODO
		}
	}
}
