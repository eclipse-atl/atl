/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - ATL tester
 *******************************************************************************/
package org.eclipse.m2m.atl.tests.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.m2m.atl.engine.AtlEMFModelHandler;
import org.eclipse.m2m.atl.engine.AtlModelHandler;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * Provide utilities to use models into atl.
 * 
 * @author William Piers <a href="mailto:william.piers@obeo.fr">william.piers@obeo.fr</a>
 */
public class AtlUtils {

	/**
	 * Get source models of a transformation.
	 * @param arg the (model_name,metamodel_name) tuples to load
	 * @param path the paths of each model
	 * @param modelHandler
	 * @param atlModelHandler
	 * @param checkSameModel
	 * @param toDispose
	 * @return a map containing loaded ASMModels
	 * @throws CoreException
	 */
	public static Map getSourceModels(Map arg, Map path, Map modelHandler, Map atlModelHandler, boolean checkSameModel, Collection toDispose) throws CoreException {
		Map toReturn = new HashMap();
		try {
			for(Iterator i = arg.keySet().iterator() ; i.hasNext() ; ) {
				String mName = (String)i.next();
				String mmName = (String)arg.get(mName);

				AtlModelHandler amh = (AtlModelHandler)atlModelHandler.get(modelHandler.get(mmName));
				ASMModel mofmm = amh.getMof();
				toReturn.put("%" + modelHandler.get(mmName), mofmm); //$NON-NLS-1$
				mofmm.setIsTarget(false);
				ASMModel inputModel;
				if (((String)path.get(mmName)).startsWith("#")) { //$NON-NLS-1$
					toReturn.put(mmName, mofmm);
					inputModel = (ASMModel)toReturn.get(mName);
					if(inputModel == null)
						inputModel = loadModel(amh, mName, mofmm, (String)path.get(mName), toDispose);
				}
				else {
					ASMModel inputMetaModel = (ASMModel)toReturn.get(mmName);
					if(inputMetaModel == null) {
						inputMetaModel = loadModel(amh, mmName, mofmm, (String)path.get(mmName), toDispose);
						toReturn.put(mmName, inputMetaModel);
					}
					inputMetaModel.setIsTarget(false);
					inputModel = loadModel(amh, mName, inputMetaModel, (String)path.get(mName), toDispose);
				}
				inputModel.setIsTarget(false);
				if (inputModel instanceof ASMEMFModel)
					((ASMEMFModel)inputModel).setCheckSameModel(checkSameModel);
				toReturn.put(mName, inputModel);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return toReturn;
	}
	
	/**
	 * Get target models of a transformation.
	 * @param arg the (model_name,metamodel_name) tuples to load
	 * @param path the paths of each model
	 * @param modelHandler the model handlers
	 * @param atlModelHandler
	 * @param checkSameModel
	 * @param toDispose
	 * @return a map containing loaded ASMModels
	 * @throws CoreException
	 */
	public static Map getTargetModels(Map arg, Map path, Map modelHandler, Map atlModelHandler, Map input, boolean checkSameModel, Collection toDispose) throws CoreException {
		Map toReturn = new HashMap();
		try {
			for(Iterator i = arg.keySet().iterator() ; i.hasNext() ; ) {
				String mName = (String)i.next();
				String mmName = (String)arg.get(mName);

				AtlModelHandler amh = (AtlModelHandler)atlModelHandler.get(modelHandler.get(mmName));
				ASMModel mofmm = amh.getMof();
				mofmm.setIsTarget(false);
				ASMModel outputModel;

				if (((String)path.get(mmName)).startsWith("#")) {//$NON-NLS-1$
					if (input.get(mmName) == null)
						toReturn.put(mmName, mofmm);
					outputModel = (ASMModel)toReturn.get(mName);
					if(outputModel == null)
						outputModel = newModel(amh, mName, mofmm, (String)path.get(mName), toDispose);
				}
				else {
					ASMModel outputMetaModel = (ASMModel)input.get(mmName);
					if (outputMetaModel == null)
						outputMetaModel = (ASMModel)toReturn.get(mmName);
					if(outputMetaModel == null) {
						outputMetaModel = loadModel(amh, mmName, mofmm, (String)path.get(mmName), toDispose);
						toReturn.put(mmName, outputMetaModel);
					}
					outputMetaModel.setIsTarget(false);
					outputModel = newModel(amh, mName, outputMetaModel, (String)path.get(mName), toDispose);
				}
				outputModel.setIsTarget(true);
				if (outputModel instanceof ASMEMFModel)
					((ASMEMFModel)outputModel).setCheckSameModel(checkSameModel);
				toReturn.put(mName, outputModel);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return toReturn;
	}

	/**
	 * Load a model.
	 * @param amh the model handler to use
	 * @param mName the name of the model
	 * @param metamodel the metamodel
	 * @param path the path of the model
	 * @param toDispose
	 * @returnn the loaded model
	 * @throws IOException
	 * @throws CoreException
	 * @throws FileNotFoundException
	 */
	public static ASMModel loadModel(AtlModelHandler amh, String mName, ASMModel metamodel, String path, Collection toDispose) throws IOException, CoreException, FileNotFoundException {
		ASMModel ret = null;

		if(amh instanceof AtlEMFModelHandler) {
			if(path.startsWith("uri:")) { //$NON-NLS-1$
				ret = ((AtlEMFModelHandler)amh).loadModel(mName, metamodel, path);
				// this model should not be disposed of because we did not load it
			} else {
				ret = ((AtlEMFModelHandler)amh).loadModel(mName, metamodel, FileUtils.fileNameToURI(path));				
				toDispose.add(ret);
			}
		}

		return ret;
	}

	/**
	 * Creates a new model.
	 * @param amh the model handler to use
	 * @param mName the name of the model
	 * @param metamodel the metamodel
	 * @param path the path of the new model
	 * @param toDispose
	 * @return the new ASMModel
	 * @throws IOException
	 */
	public static ASMModel newModel(AtlModelHandler amh, String mName, ASMModel metamodel, String path, Collection toDispose) throws IOException {
		ASMModel ret = amh.newModel(mName, FileUtils.fileNameToURI(path).toString(), metamodel);
		toDispose.add(ret);
		return ret;
	}

}
