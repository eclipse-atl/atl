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
package org.eclipse.m2m.atl.service.core.nestedElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This class contains metadata for a single ATL transformation.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class Transformation {

	/**
	 * The out model.
	 * 
	 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
	 */
	private final class OutModel {
		private String globalModelName;

		private String globalMetamodelName;

		private OutModel(String modelName, String metamodelName) {
			this.globalModelName = modelName;
			this.globalMetamodelName = metamodelName;
		}
	}

	/**
	 * Transformation path.
	 */
	private String transformationPath;

	/**
	 * Map [modelNameInTransformationHeader, globalModelName].
	 */
	private Map inModels;

	/**
	 * Map [modelNameInTransformationHeader, OutModel(globalModelName, globalMetamodelName)>.
	 */
	private Map outModels;

	/**
	 * List of models not preloaded (i.e. models selected from the workspace).
	 */
	private List modelsNotPreloaded;

	/**
	 * Constructor.
	 * 
	 * @param transformationPath
	 *            the transformation path
	 */
	public Transformation(String transformationPath) {
		super();
		inModels = new HashMap();
		outModels = new HashMap();
		modelsNotPreloaded = new ArrayList();
		this.transformationPath = transformationPath;
	}

	/**
	 * Adds an input model.
	 * 
	 * @param modelNameInTransformationHeader
	 *            the "simple" model name
	 * @param globalModelName
	 *            the model name
	 */
	public void addInModel(String modelNameInTransformationHeader, String globalModelName) {
		inModels.put(modelNameInTransformationHeader, globalModelName);
	}

	/**
	 * Adds a model which is not preloaded.
	 * 
	 * @param modelName
	 *            the model name
	 */
	public void addInNotPreloadedList(String modelName) {
		modelsNotPreloaded.add(modelName);
	}

	/**
	 * Adds an output model.
	 * 
	 * @param modelNameInConfiguration
	 *            the in model configuration
	 * @param modelName
	 *            the out model name
	 * @param metamodelName
	 *            the metamodel name
	 */
	public void addOutModel(String modelNameInConfiguration, String modelName, String metamodelName) {
		outModels.put(modelNameInConfiguration, new OutModel(modelName, metamodelName));
	}

	public String getTransformationPath() {
		return transformationPath;
	}

	/**
	 * Returns Map [modelNameInTransformationHeader, globalModelName].
	 * 
	 * @return Map [modelNameInTransformationHeader, globalModelName]
	 */
	public Map getInModels() {
		return inModels;
	}

	/**
	 * Returns Map [modelNameInTransformationHeader, globalModelName].
	 * 
	 * @return Map [modelNameInTransformationHeader, globalModelName]
	 */
	public Map getOutModels() {
		Map ret = new HashMap();
		for (Iterator it = outModels.keySet().iterator(); it.hasNext();) {
			String modelNameInConfiguration = (String)it.next();
			ret.put(modelNameInConfiguration,
					((OutModel)outModels.get(modelNameInConfiguration)).globalModelName);
		}
		return ret;
	}

	/**
	 * Returns a map of [globalModelName, globalMetamodelName].
	 * 
	 * @return a map of [globalModelName, globalMetamodelName]
	 */
	public Map getOutModelsForLoading() {
		Map ret = new HashMap();
		for (Iterator it = outModels.keySet().iterator(); it.hasNext();) {
			String modelNameInConfiguration = (String)it.next();
			ret.put(((OutModel)outModels.get(modelNameInConfiguration)).globalModelName, ((OutModel)outModels
					.get(modelNameInConfiguration)).globalMetamodelName);
		}
		return ret;
	}

	public List getModelsNotPreloaded() {
		return modelsNotPreloaded;
	}
}
