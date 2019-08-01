/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.runner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EPackage;

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

	private List<String> pluginDependencies;

	private Map<String, String> packageClassNames;

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

	/**
	 * Constructor.
	 * 
	 * @param projectName
	 *            the project name
	 * @param basePackage
	 *            the base package name
	 */
	public CreatePluginData(String projectName, String basePackage) {
		this.projectName = projectName;
		this.basePackage = basePackage;
	}

	/**
	 * Sets the runnable data and initializes metamodel dependencies.
	 * 
	 * @param runnableData
	 *            the runnable data
	 */
	public void setRunnableData(CreateRunnableData runnableData) {
		this.runnableData = runnableData;
		computeMetamodelDependencies();
	}

	/**
	 * Computes plug-in dependency with the given metamodel.
	 * 
	 * @param metamodel
	 *            is the metamodel
	 */
	private void computeMetamodelDependencies() {
		pluginDependencies = new ArrayList<String>();
		packageClassNames = new HashMap<String, String>();
		for (String metamodelName : runnableData.getAllMetamodelsNames()) {
			EPackage regValue = EPackage.Registry.INSTANCE.getEPackage(runnableData.getMetamodelLocations()
					.get(metamodelName));
			if (regValue != null) {
				computeMetamodelDependencies(metamodelName, regValue);
			}
		}
	}

	/**
	 * Computes plug-in dependency with the given metamodel.
	 * 
	 * @param metamodel
	 *            is the metamodel
	 */
	private void computeMetamodelDependencies(String metamodelName, EPackage metamodel) {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = registry
				.getExtensionPoint("org.eclipse.emf.ecore.generated_package"); //$NON-NLS-1$
		if (extensionPoint != null && extensionPoint.getExtensions().length > 0) {
			IExtension[] extensions = extensionPoint.getExtensions();
			for (int i = 0; i < extensions.length; i++) {
				IExtension extension = extensions[i];
				IConfigurationElement[] members = extension.getConfigurationElements();
				for (int j = 0; j < members.length; j++) {
					IConfigurationElement member = members[j];
					String mURI = member.getAttribute("uri"); //$NON-NLS-1$
					if (mURI != null && mURI.equals(metamodel.getNsURI())) {
						if (!pluginDependencies.contains(member.getNamespaceIdentifier())) {
							pluginDependencies.add(member.getNamespaceIdentifier());
						}
						// uri can differ between versions
						packageClassNames.put(metamodelName, member.getAttribute("class")); //$NON-NLS-1$
					}
				}
			}
		}
	}

	public CreateRunnableData getRunnableData() {
		return runnableData;
	}

	public String getProjectName() {
		return projectName;
	}

	public Object getBasePackage() {
		return basePackage;
	}

	public List<String> getPluginDependencies() {
		return pluginDependencies;
	}

	public Map<String, String> getPackageClassNames() {
		return packageClassNames;
	}
}
