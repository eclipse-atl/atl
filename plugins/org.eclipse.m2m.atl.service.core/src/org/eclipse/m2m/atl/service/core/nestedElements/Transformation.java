package org.eclipse.m2m.atl.service.core.nestedElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This class contains metadata for a single ATL transformation
 * @author Freddy Allilaire
 *
 */
public class Transformation {
	
	private class OutModel {
		private String globalModelName;
		private String globalMetamodelName;
		
		public OutModel(String modelName, String metamodelName) {
			this.globalModelName = modelName;
			this.globalMetamodelName = metamodelName;
		}
	}
	
	/**
	 * Transformation path
	 */
	private String transformationPath;
	/**
	 * Map <modelNameInTransformationHeader, globalModelName>
	 */
	private Map inModels;
	/**
	 * Map <modelNameInTransformationHeader, OutModel(globalModelName, globalMetamodelName)>
	 */
	private Map outModels;
	/**
	 * List of models not preloaded (i.e. models selected from the workspace)
	 */
	private List modelsNotPreloaded;
	
	public Transformation(String transformationPath) {
		super();
		inModels = new HashMap();
		outModels = new HashMap();
		modelsNotPreloaded = new ArrayList();
		this.transformationPath = transformationPath;
	}
	
	public void addInModel(String modelNameInTransformationHeader, String globalModelName) {
		inModels.put(modelNameInTransformationHeader, globalModelName);
	}
	
	public void addInNotPreloadedList(String modelName) {
		modelsNotPreloaded.add(modelName);
	}

	public void addOutModel(String modelNameInConfiguration, String modelName, String metamodelName) {
		outModels.put(modelNameInConfiguration, new OutModel(modelName, metamodelName));
	}
	
	public String getTransformationPath() {
		return transformationPath;
	}
	
	/**
	 * 
	 * @return Map <modelNameInTransformationHeader, globalModelName>
	 */
	public Map getInModels() {
		return inModels;
	}

	/**
	 * 
	 * @return Map <modelNameInTransformationHeader, globalModelName>
	 */
	public Map getOutModels() {
		Map ret = new HashMap();
		for (Iterator it = outModels.keySet().iterator(); it.hasNext();) {
			String modelNameInConfiguration = (String)it.next();
			ret.put(modelNameInConfiguration, ((OutModel)outModels.get(modelNameInConfiguration)).globalModelName);
		}
		return ret;
	}
	
	/**
	 * 
	 * @return Map <globalModelName, globalMetamodelName>
	 */
	public Map getOutModelsForLoading() {
		Map ret = new HashMap();
		for (Iterator it = outModels.keySet().iterator(); it.hasNext();) {
			String modelNameInConfiguration = (String)it.next();
			ret.put(((OutModel)outModels.get(modelNameInConfiguration)).globalModelName, ((OutModel)outModels.get(modelNameInConfiguration)).globalMetamodelName);
		}
		return ret;
	}

	public List getModelsNotPreloaded() {
		return modelsNotPreloaded;
	}
}
