/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.service.core.configuration;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.m2m.atl.engine.AtlLauncher;
import org.eclipse.m2m.atl.engine.AtlModelHandler;
import org.eclipse.m2m.atl.service.core.ServiceMessages;
import org.eclipse.m2m.atl.service.core.ServiceTransformationUtil;
import org.eclipse.m2m.atl.service.core.exception.ServiceException;
import org.eclipse.m2m.atl.service.core.nestedElements.Model;
import org.eclipse.m2m.atl.service.core.nestedElements.ModelToSave;
import org.eclipse.m2m.atl.service.core.nestedElements.Transformation;

/**
 * ComposedTransformationConfiguration (i.e. a chain of transformations to execute)
 * It contains models used by the transformations, and metadata transformation
 * TransformationConfiguration are built and stocked by the ServiceExtensionManager
 * UI parts can execute a transformationConfiguration with method execute()
 * 
 * @author Freddy Allilaire
 *
 */
public class ComposedTransformationConfiguration extends TransformationConfiguration {

	private List transformations;
	private List applyMarker;
	private Map modelsToSave;
	
	public ComposedTransformationConfiguration(String configurationName, String pluginId) {
		super(configurationName, pluginId);
		transformations = new ArrayList();
		modelsToSave = new HashMap();
		applyMarker = new ArrayList();
	}
	
	public void addTransformation(Transformation t) {
		transformations.add(t);
	}
	
	public void addInModel(String name, String path, String metamodel, boolean inWorkspace) {
		// TODO
		if (inWorkspace) {
			models.put(name, new Model(name, metamodel, "EMF"));//$NON-NLS-1$
		}
		else
			try {
				models.put(name, new Model(name, ((Model)models.get(metamodel)).getAsmModel(), path, null, false, "EMF", pluginId));//$NON-NLS-1$
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void addMetamodel(String name, String path, String nsUri, boolean isM3, String modelHandler) {
		// TODO
		try {
			models.put(name, new Model(name, AtlModelHandler.getDefault(modelHandler).getMof(), path, nsUri, isM3, modelHandler, pluginId));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addModelToSave(String name, String fileName) {
		modelsToSave.put(name, new ModelToSave(name, fileName));
	}
	
	public void addModelToSave(String name, String fileName, String extractorType, Map extractorParams) {
		modelsToSave.put(name, new ModelToSave(name, fileName, extractorType, extractorParams));
	}
	
	public void addApplyMarker(String modelProblemName) {
		applyMarker.add(modelProblemName);
	}
	
	/**
	 * Main method launchs by UI
	 */
	public void execute(String pathFolder, String pathInModel) throws ServiceException {
		for (Iterator it = transformations.iterator(); it.hasNext();) {
			Transformation t = (Transformation)it.next();
			if (t.getModelsNotPreloaded().size() == 1)
				loadModel(t, pathInModel);
			executeTransformation(t);
		}
		
		for (Iterator it = applyMarker.iterator(); it.hasNext();) {
			String modelName = (String)it.next();
			Model currentOutModel = (Model)models.get(modelName);
			try {
				ServiceTransformationUtil.applyMarkers(pathInModel, currentOutModel.getAsmModel());
			} catch (CoreException e) {
				throw new ServiceException(IStatus.ERROR, e);
			}
		}
		
		for (Iterator it = modelsToSave.keySet().iterator(); it.hasNext();) {
			String modelName = (String)it.next();
			saveModel(pathFolder, modelName);
		}
	}
	
	/**
	 * Load a model selected from the workspace
	 * @param transformation
	 * @param pathInModel
	 * @throws ServiceException
	 */
	public void loadModel(Transformation transformation, String pathInModel) throws ServiceException {
		((Model)models.get(transformation.getModelsNotPreloaded().get(0))).loadModel(pathInModel, ((Model)models.get(((Model)models.get(transformation.getModelsNotPreloaded().get(0))).getMetamodelName())).getAsmModel(), pluginId);		
	}
	
	/**
	 * execute a transformation
	 * output models are loaded before running the transformation
	 * @param transformation
	 * @throws ServiceException
	 */
	public void executeTransformation(Transformation transformation) throws ServiceException {
		Map params = Collections.EMPTY_MAP;
		Map libs = new HashMap();
        List superimps = new ArrayList();
        
		URL asmUrl = ServiceTransformationUtil.getURLFromASMFile(transformation.getTransformationPath(), pluginId);
		
		for (Iterator it = transformation.getOutModelsForLoading().keySet().iterator(); it.hasNext();) {
			String modelName = (String)it.next();
			models.put(modelName, new Model(modelName, ((Model)models.get(transformation.getOutModelsForLoading().get(modelName))).getAsmModel(), modelName, "EMF"));//$NON-NLS-1$
		}
		
		// TODO Nouvelle API
		AtlLauncher.getDefault().launch(asmUrl, libs, getModelsForTransformation(transformation), params, superimps, Collections.EMPTY_MAP);		
	}
	
	/**
	 * Save a model in the workspace
	 * @param pathFolder location to save the created model
	 * @param modelName modelName for the created model
	 */
	public void saveModel(String pathFolder, String modelName) throws ServiceException {
		ModelToSave mts = (ModelToSave)modelsToSave.get(modelName);
		Model currentOutModel = (Model)models.get(modelName);
		if (mts.isExtractor() == false)
			AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF).saveModel(currentOutModel.getAsmModel(), pathFolder + "/" + mts.getFileName());//$NON-NLS-1$
		else if (mts.getExtractorType().equals(ServiceTransformationUtil.XMLExtractor))
			ServiceTransformationUtil.xmlExtraction(currentOutModel.getAsmModel(), pathFolder + "/" + mts.getFileName(), AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF));//$NON-NLS-1$
		else if (mts.getExtractorType().equals(ServiceTransformationUtil.EBNFExtractor)) {
			Map params = mts.getExtractorParams();
			ServiceTransformationUtil.ebnfExtraction(currentOutModel.getAsmModel(), pathFolder + "/" + mts.getFileName(), AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF), params);//$NON-NLS-1$
		}
		else
			throw new ServiceException(IStatus.ERROR,ServiceMessages.getString("ComposedTransformationConfiguration.0",new Object[]{mts.getExtractorType()}));//$NON-NLS-1$

	}
}
