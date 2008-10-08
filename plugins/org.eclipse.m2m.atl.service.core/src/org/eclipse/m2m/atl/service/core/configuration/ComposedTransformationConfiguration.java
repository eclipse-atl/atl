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

import java.io.IOException;
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
import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.service.core.ServiceMessages;
import org.eclipse.m2m.atl.service.core.ServiceTransformationUtil;
import org.eclipse.m2m.atl.service.core.exception.ServiceException;
import org.eclipse.m2m.atl.service.core.nestedElements.Model;
import org.eclipse.m2m.atl.service.core.nestedElements.ModelToSave;
import org.eclipse.m2m.atl.service.core.nestedElements.Transformation;

/**
 * ComposedTransformationConfiguration (i.e. a chain of transformations to execute) It contains models used by
 * the transformations, and metadata transformation TransformationConfiguration are built and stocked by the
 * ServiceExtensionManager UI parts can execute a transformationConfiguration with method execute().
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class ComposedTransformationConfiguration extends TransformationConfiguration {

	private List transformations;

	private List applyMarker;

	private Map modelsToSave;

	/**
	 * Creates a new configuration to compose transformations.
	 * 
	 * @param configurationName
	 *            the configuration name
	 * @param pluginId
	 *            the plugin id
	 */
	public ComposedTransformationConfiguration(String configurationName, String pluginId) {
		super(configurationName, pluginId);
		transformations = new ArrayList();
		modelsToSave = new HashMap();
		applyMarker = new ArrayList();
	}

	/**
	 * Adds a transformation to the configuration.
	 * 
	 * @param t
	 *            the transformation to add
	 */
	public void addTransformation(Transformation t) {
		transformations.add(t);
	}

	/**
	 * Adds an input model to the configuration.
	 * 
	 * @param name
	 *            the model name
	 * @param path
	 *            the model path
	 * @param metamodel
	 *            the metamodel name
	 * @param inWorkspace
	 *            true if the model is in the workspace
	 */
	public void addInModel(String name, String path, String metamodel, ModelLoader ml, boolean inWorkspace) {
		// TODO
		if (inWorkspace) {
			models.put(name, new Model(name, metamodel, "EMF")); //$NON-NLS-1$
		} else {
			try {
				models.put(name, new Model(name, ((Model)models.get(metamodel)).getAsmModel(), ml, path,
						null, false, pluginId)); //$NON-NLS-1$
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Adds a Metamodel to the configuration.
	 * 
	 * @param name
	 *            the metamodel name
	 * @param path
	 *            the metamodel path
	 * @param nsUri
	 *            the metamodel uri
	 * @param isM3
	 *            true is it is a metametamodel
	 * @param modelHandler
	 *            the model handler
	 */
	public void addMetamodel(String name, String path, String nsUri, boolean isM3, ModelLoader ml) {
		try {
			models.put(name, new Model(name, ml.getMOF(), ml, path, nsUri, isM3, pluginId));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Adds a {@link ModelToSave} to the configuration.
	 * 
	 * @param name
	 *            the model name
	 * @param fileName
	 *            the file where to save the model
	 */
	public void addModelToSave(String name, String fileName) {
		modelsToSave.put(name, new ModelToSave(name, fileName));
	}

	/**
	 * Adds a {@link ModelToSave} to the configuration.
	 * 
	 * @param name
	 *            the model name
	 * @param fileName
	 *            the file where to save the model
	 * @param extractorType
	 *            the extractor type
	 * @param extractorParams
	 *            the extractor parameters
	 */
	public void addModelToSave(String name, String fileName, String extractorType, Map extractorParams) {
		modelsToSave.put(name, new ModelToSave(name, fileName, extractorType, extractorParams));
	}

	/**
	 * Adds marker.
	 * 
	 * @param modelProblemName
	 *            the problem name
	 */
	public void addApplyMarker(String modelProblemName) {
		applyMarker.add(modelProblemName);
	}

	/**
	 * {@inheritDoc}
	 * @throws IOException 
	 * 
	 * @see org.eclipse.m2m.atl.service.core.configuration.TransformationConfiguration#execute(java.lang.String,
	 *      java.lang.String)
	 */
	public void execute(String pathFolder, String pathInModel) throws ServiceException, IOException {
		for (Iterator it = transformations.iterator(); it.hasNext();) {
			Transformation t = (Transformation)it.next();
			if (t.getModelsNotPreloaded().size() == 1) {
				loadModel(t, pathInModel);
			}
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
	 * Load a model selected from the workspace.
	 * 
	 * @param transformation
	 *            the transformation
	 * @param pathInModel
	 *            the model in path
	 * @throws ServiceException
	 * @throws IOException 
	 */
	public void loadModel(Transformation transformation, String pathInModel) throws ServiceException, IOException {
		final Model m = (Model) models.get(transformation.getModelsNotPreloaded().get(0));
		final Model mm = (Model) models.get(m.getMetamodelName());
		final ModelLoader ml = AtlModelHandler.getDefault(m.getAtlModelHandlerId()).createModelLoader();
		m.loadModel(pathInModel, mm.getAsmModel(), ml, pluginId);
	}

	/**
	 * Executes a transformation. Output models are loaded before running the transformation.
	 * 
	 * @param transformation
	 *            the transformation
	 * @throws ServiceException
	 */
	public void executeTransformation(Transformation transformation) throws ServiceException {
		Map params = Collections.EMPTY_MAP;
		Map libs = new HashMap();
		List superimps = new ArrayList();

		URL asmUrl = ServiceTransformationUtil.getURLFromASMFile(transformation.getTransformationPath(),
				pluginId);

		for (Iterator it = transformation.getOutModelsForLoading().keySet().iterator(); it.hasNext();) {
			String modelName = (String)it.next();
			ASMModel mm = ((Model)models.get(transformation.getOutModelsForLoading().get(modelName))).getAsmModel();
			AtlModelHandler amh = AtlModelHandler.getHandler(mm);
			ModelLoader ml = amh.createModelLoader();
			models.put(modelName, new Model(modelName, mm, ml, modelName));
		}

		// TODO Nouvelle API
		AtlLauncher.getDefault().launch(asmUrl, libs, getModelsForTransformation(transformation), params,
				superimps, Collections.EMPTY_MAP);
	}

	/**
	 * Save a model in the workspace.
	 * 
	 * @param pathFolder
	 *            location to save the created model
	 * @param modelName
	 *            modelName for the created model
	 * @throws IOException 
	 */
	public void saveModel(String pathFolder, String modelName) throws ServiceException, IOException {
		final ModelToSave mts = (ModelToSave)modelsToSave.get(modelName);
		final Model currentOutModel = (Model)models.get(modelName);
		final ModelLoader ml = currentOutModel.getAsmModel().getModelLoader();
		if (!mts.isExtractor()) {
			ml.save(currentOutModel.getAsmModel(), pathFolder + "/" + mts.getFileName());//$NON-NLS-1$
		} else if (mts.getExtractorType().equals(ServiceTransformationUtil.XML_EXTRACTOR)) {
			ServiceTransformationUtil.xmlExtraction(currentOutModel.getAsmModel(), pathFolder
					+ "/" + mts.getFileName()); //$NON-NLS-1$
		} else if (mts.getExtractorType().equals(ServiceTransformationUtil.EBNF_EXTRACTOR)) {
			Map params = mts.getExtractorParams();
			ServiceTransformationUtil.ebnfExtraction(currentOutModel.getAsmModel(), pathFolder
					+ "/" + mts.getFileName(), params);//$NON-NLS-1$
		} else {
			throw new ServiceException(IStatus.ERROR, ServiceMessages.getString(
					"ComposedTransformationConfiguration.0", new Object[] {mts.getExtractorType()})); //$NON-NLS-1$
		}

	}
}
