/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.runner;

/**
 * The class used to configure all the JET generations of the 'AtlPluginCreator' wizard. The purpose of the
 * wizard is to create a new ATL plugin (i.e an eclipse plug-in).
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class CreatePluginData {

	/**
	 * New project name.
	 */
	private String projectName;

	private String basePackage;

	private CreateRunnableData runnableData;

	/**
	 * Constructor.
	 * 
	 * @param projectName
	 *            the project name
	 */
	public CreatePluginData(String projectName) {
		this.projectName = projectName;
		this.basePackage = projectName + ".files"; //$NON-NLS-1$
	}

	public CreateRunnableData getRunnableData() {
		return runnableData;
	}

	public void setRunnableData(CreateRunnableData runnableData) {
		this.runnableData = runnableData;
	}

	public String getProjectName() {
		return projectName;
	}

	public Object getBasePackage() {
		return basePackage;
	}

}
