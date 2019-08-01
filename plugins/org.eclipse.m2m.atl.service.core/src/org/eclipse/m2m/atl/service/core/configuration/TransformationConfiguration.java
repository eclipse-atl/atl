/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.service.core.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.m2m.atl.service.core.exception.ServiceException;
import org.eclipse.m2m.atl.service.core.nestedElements.Model;
import org.eclipse.m2m.atl.service.core.nestedElements.Transformation;

/**
 * Abstract class for TransformationConfiguration It contains models used by the transformations, and metadata
 * transformation TransformationConfiguration are built and stocked by the ServiceExtensionManager UI parts
 * can execute a transformationConfiguration with method execute().
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public abstract class TransformationConfiguration {
	/**
	 * PluginId where resources are located for this transformationConfiguration.
	 */
	protected String pluginId;

	/**
	 * Models used by the transformations.
	 */
	protected Map models;

	/**
	 * Value to display in UI.
	 */
	private String configurationName;

	/**
	 * file extensions to match to launch this transformation configuration.
	 */
	private List fileExtensions = new ArrayList();

	/**
	 * Constructor.
	 * 
	 * @param configurationName
	 *            the configuration name
	 * @param pluginId
	 *            the plugin id
	 */
	public TransformationConfiguration(String configurationName, String pluginId) {
		this.configurationName = configurationName;
		this.pluginId = pluginId;
		models = new HashMap();
	}

	/**
	 * Executes the transformation.
	 * 
	 * @param projectPath
	 *            the project path
	 * @param pathInModel
	 *            the in model path
	 * @throws ServiceException
	 * @throws IOException 
	 */
	public abstract void execute(String projectPath, String pathInModel) throws ServiceException, IOException;

	/**
	 * Adds a file extension.
	 * 
	 * @param fileExtension
	 *            the extension to add
	 */
	public void addFileExtension(String fileExtension) {
		fileExtensions.add(fileExtension);
	}

	public List getFileExtensions() {
		return fileExtensions;
	}

	/**
	 * Returns return true if extension is contained is the extensions list.
	 * 
	 * @param extension
	 *            the given extension
	 * @return return true if extension is contained is the extensions list
	 */
	public boolean isMatchingExtension(String extension) {
		for (Iterator it = fileExtensions.iterator(); it.hasNext();) {
			if (((String)it.next()).equals(extension)) {
				return true;
			}
		}
		return false;
	}

	public String getConfigurationName() {
		return configurationName;
	}

	/**
	 * This map contains asmModels for an ATL transformation.
	 * 
	 * @param t
	 *            the transformation
	 * @return a Map [modelNameInTransformationHeader, asmModel]
	 */
	public Map getModelsForTransformation(Transformation t) {
		Map ret = new HashMap();

		for (Iterator it = t.getInModels().keySet().iterator(); it.hasNext();) {
			String modelNameInTransformationHeader = (String)it.next();
			ret.put(modelNameInTransformationHeader, ((Model)models.get(t.getInModels().get(
					modelNameInTransformationHeader))).getAsmModel());
		}

		for (Iterator it = t.getOutModels().keySet().iterator(); it.hasNext();) {
			String modelNameInConfiguration = (String)it.next();
			ret.put(modelNameInConfiguration, ((Model)models.get(t.getOutModels().get(
					modelNameInConfiguration))).getAsmModel());
		}

		return ret;
	}

}
