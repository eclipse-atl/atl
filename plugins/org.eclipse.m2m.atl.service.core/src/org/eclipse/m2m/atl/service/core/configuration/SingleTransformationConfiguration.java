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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.m2m.atl.drivers.emf4atl.AtlEMFModelHandler;
import org.eclipse.m2m.atl.engine.vm.AtlLauncher;
import org.eclipse.m2m.atl.engine.vm.AtlModelHandler;
import org.eclipse.m2m.atl.service.core.ServiceMessages;
import org.eclipse.m2m.atl.service.core.ServiceTransformationUtil;
import org.eclipse.m2m.atl.service.core.exception.ServiceException;
import org.eclipse.m2m.atl.service.core.nestedElements.Model;
import org.eclipse.m2m.atl.service.core.nestedElements.Transformation;

/**
 * SingleTransformationConfiguration (i.e. only one transformation to execute) It contains models used by the
 * transformations, and metadata transformation TransformationConfiguration are built and stocked by the
 * ServiceExtensionManager UI parts can execute a transformationConfiguration with method execute()
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class SingleTransformationConfiguration extends TransformationConfiguration {

	private Transformation transformation;

	/**
	 * Creates a single transformation configuration.
	 * 
	 * @param path
	 *            the transformation path
	 * @param name
	 *            the transformation name
	 * @param pluginId
	 *            the plugin id
	 */
	public SingleTransformationConfiguration(String path, String name, String pluginId) {
		super(name, pluginId);
		transformation = new Transformation(path);
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
	public void addInModel(String name, String path, String metamodel, boolean inWorkspace) {
		// TODO
		try {
			if (inWorkspace) {
				models.put(name, new Model(name, metamodel, "EMF")); //$NON-NLS-1$
				transformation.addInNotPreloadedList(name);
			} else {
				models.put(name, new Model(name, ((Model)models.get(metamodel)).getAsmModel(), path, null,
						false, "EMF", pluginId)); //$NON-NLS-1$
			}
			transformation.addInModel(name, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Adds an output model.
	 * 
	 * @param name
	 *            the model name
	 * @param fileName
	 *            the model file
	 * @param metamodel
	 *            the metamodel name
	 */
	public void addOutModel(String name, String fileName, String metamodel) {
		// TODO
		models.put(name, new Model(name, ((Model)models.get(metamodel)).getAsmModel(), fileName, "EMF")); //$NON-NLS-1$
		transformation.addOutModel(name, name, metamodel);
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
	public void addMetamodel(String name, String path, String nsUri, boolean isM3, String modelHandler) {
		// TODO
		try {
			models.put(name, new Model(name, AtlModelHandler.getDefault(modelHandler).getMof(), path, nsUri,
					isM3, modelHandler, pluginId));
			transformation.addInModel(name, name);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.service.core.configuration.TransformationConfiguration#execute(java.lang.String,
	 *      java.lang.String)
	 */
	public void execute(String pathFolder, String pathInModel) throws ServiceException {
		Map params = Collections.EMPTY_MAP;
		Map libs = new HashMap();
		List superimps = new ArrayList();

		URL asmUrl = ServiceTransformationUtil.getURLFromASMFile(transformation.getTransformationPath(),
				pluginId);

		// TODO
		if (transformation.getModelsNotPreloaded().size() == 1) {
			((Model)models.get(transformation.getModelsNotPreloaded().get(0))).loadModel(pathInModel,
					((Model)models.get(((Model)models.get(transformation.getModelsNotPreloaded().get(0)))
							.getMetamodelName())).getAsmModel(), pluginId);
		} else {
			throw new ServiceException(IStatus.CANCEL, ServiceMessages
					.getString("SingleTransformationConfiguration.0")); //$NON-NLS-1$
		}

		// TODO nouvelle API
		AtlLauncher.getDefault().launch(asmUrl, libs, getModelsForTransformation(transformation), params,
				superimps, Collections.EMPTY_MAP);

		for (Iterator it = transformation.getOutModels().keySet().iterator(); it.hasNext();) {
			String modelName = (String)it.next();
			Model currentOutModel = (Model)models.get(modelName);
			new AtlEMFModelHandler().saveModel(currentOutModel.getAsmModel(), pathFolder
					+ "/" + currentOutModel.getFileName()); //$NON-NLS-1$
		}
	}

}
