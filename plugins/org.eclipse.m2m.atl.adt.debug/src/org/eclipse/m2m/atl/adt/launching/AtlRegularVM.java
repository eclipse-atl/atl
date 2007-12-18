/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.launching;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.adt.debug.core.AtlDebugTarget;
import org.eclipse.m2m.atl.adt.debug.core.AtlRunTarget;
import org.eclipse.m2m.atl.adt.launching.sourcelookup.AtlSourceLocator;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.m2m.atl.engine.AtlEMFModelHandler;
import org.eclipse.m2m.atl.engine.AtlLauncher;
import org.eclipse.m2m.atl.engine.AtlModelHandler;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

public class AtlRegularVM extends AtlVM {

	private final static boolean useEMFURIs = true;

	/**
	 * With the path of a file, the input stream of the file is returned
	 * @param filePath
	 * @return the input stream corresponding to the file
	 * @throws FileNotFoundException
	 */
	private static InputStream fileNameToInputStream(String filePath) throws FileNotFoundException, CoreException {
		if (filePath.startsWith("ext:")) {//$NON-NLS-1$
			File f = new File(filePath.substring(4));
			return new FileInputStream(f);
		}
		else {
			IWorkspaceRoot iwr = ResourcesPlugin.getWorkspace().getRoot();
			filePath = filePath.replace('#', '/');
			return iwr.getFile(new Path(filePath)).getContents();
		}
	}

	private static URI fileNameToURI(String filePath) throws IllegalArgumentException {
		if (filePath.startsWith("ext:")) {//$NON-NLS-1$
			File f = new File(filePath.substring(4));
			return URI.createFileURI(f.getPath());
		} else {
			return URI.createPlatformResourceURI(filePath, true);
		}
	}

	private static URL fileNameToURL(String filePath) throws MalformedURLException {
		if (filePath.startsWith("ext:")) {//$NON-NLS-1$
			File f = new File(filePath.substring(4));
			return f.toURL();
		}
		else {
			IWorkspace wks = ResourcesPlugin.getWorkspace();
			IWorkspaceRoot wksroot = wks.getRoot();
	
			IFile currentLib = wksroot.getFile(new Path(filePath));
			return currentLib.getLocation().toFile().toURL();
		}
	}

	/**
	 * From the path of an ATL File, this method returns 
	 * the ASM File corresponding to the ATL File
	 * @param atlFilePath name of the ATL File
	 * @return ASM File corresponding to the ATL File
	 */
	private static IFile getASMFile(String atlFilePath) {
	
		// TODO Get properties of the project
		// know where bin files are, then choose good ASM File for ATL File
	
		IFile currentAtlFile = ResourcesPlugin.getWorkspace().getRoot().getFile(Path.fromOSString(atlFilePath));
		
		String extension = currentAtlFile.getFileExtension().toLowerCase();
		if (AtlLauncherTools.EXTENSIONS.contains(extension)) {
			String currentAsmPath = currentAtlFile.getFullPath().toString().substring(0, currentAtlFile.getFullPath().toString().length() - extension.length()) + "asm";//$NON-NLS-1$
			return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(currentAsmPath));
		}
		else
			return null;
	}

	/**
	 * Returns the input stream from a path for metamodel
	 * @param metamodelPath
	 * @return
	 * @throws CoreException
	 */
	private static Map getSourceModels(Map arg, Map path, Map modelHandler, Map atlModelHandler, boolean checkSameModel, Collection toDispose) throws CoreException {
		Map toReturn = new HashMap();
		try {
			for(Iterator i = arg.keySet().iterator() ; i.hasNext() ; ) {
				String mName = (String)i.next();
				String mmName = (String)arg.get(mName);
	
				AtlModelHandler amh = (AtlModelHandler)atlModelHandler.get(modelHandler.get(mmName));
				ASMModel mofmm = amh.getMof();
				toReturn.put("%" + modelHandler.get(mmName), mofmm);//$NON-NLS-1$
				mofmm.setIsTarget(false);
				ASMModel inputModel;
				if (((String)path.get(mmName)).startsWith("#")) {//$NON-NLS-1$
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
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
		}
		return toReturn;
	}

	/**
	 * Returns the input stream from a path for metamodel
	 * @param metamodelPath
	 * @return
	 * @throws CoreException
	 */
	private static Map getTargetModels(Map arg, Map path, Map modelHandler, Map atlModelHandler, Map input, boolean checkSameModel, Collection toDispose) throws CoreException {
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
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
		}
		return toReturn;
	}

	/**
		 * @param param
		 * @return Returns the property value of the project
		 */
	//	private String getAtlProjectProperties(String param) {
	//		// TODO getAtlProjectProperties
	//		return null;
	//	}
		
		
		private static ASMModel loadModel(AtlModelHandler amh, String mName, ASMModel metamodel, String path, Collection toDispose) throws CoreException, FileNotFoundException {
			ASMModel ret = null;
			
			if(useEMFURIs && (amh instanceof AtlEMFModelHandler)) {
				if(path.startsWith("uri:")) {//$NON-NLS-1$
					ret = ((AtlEMFModelHandler)amh).loadModel(mName, metamodel, path);
					// this model should not be disposed of because we did not load it
				} else {
					ret = ((AtlEMFModelHandler)amh).loadModel(mName, metamodel, fileNameToURI(path));				
					toDispose.add(ret);
				}
			}
			else {
				ret = amh.loadModel(mName, metamodel, fileNameToInputStream(path));
				toDispose.add(ret);
			}
	
			return ret;
		}

	/**
	 * @param amh
	 * @param mName
	 * @param metamodel
	 * @param path Project file path. Used to derive a platform:/... URI.
	 * @param toDispose
	 * @return A new ASMModel.
	 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
	 */
	private static ASMModel newModel(AtlModelHandler amh, String mName, ASMModel metamodel, String path, Collection toDispose) {
	    ASMModel ret = amh.newModel(mName, fileNameToURI(path).toString(), metamodel);
	    toDispose.add(ret);
	    return ret;
	}

	/**
	 * 
	 * @param filePath		: path of the ATL Transformation
	 * @param input			: Map {model_input --> metamodel_input}
	 * @param output		: Map {model_output --> metamodel_output}
	 * @param path			: Map {model_name --> URI}
	 * @param modelType		: Map {model_name --> type if the model(mIn, mmIn, ...)}
	 * @param modelHandler	: modelHandler (MDR or EMF)
	 * @param mode			: mode (DEBUG or RUN)
	 * @param ckeckSameModel TODO
	 * @param libsFromConfig: Map {lib_name --> URI}
	 * @param superimpose   : list of module URIs to superimpose 
	 */
//	public static void runAtlLauncher(String filePath, Map libsFromConfig, Map input, Map output, Map path, Map modelType, Map modelHandler, String mode, boolean checkSameModel, List superimpose) {
//		runAtlLauncher(filePath, libsFromConfig, input, output, path, modelType, modelHandler, mode, Collections.EMPTY_MAP, checkSameModel, superimpose);
//	}
//
//	public static void runAtlLauncher(String filePath, Map libsFromConfig, Map input, Map output, Map path, Map modelType, Map modelHandler, String mode, boolean checkSameModel, List superimpose, boolean continueAfterErrors) {
//		runAtlLauncher(filePath, libsFromConfig, input, output, path, modelType, modelHandler, mode, Collections.EMPTY_MAP, checkSameModel, superimpose, continueAfterErrors);
//	}

	/**
	 * 
	 * @param filePath		: path of the ATL Transformation
	 * @param input			: Map {model_input --> metamodel_input}
	 * @param output		: Map {model_output --> metamodel_output}
	 * @param path			: Map {model_name --> URI}
	 * @param modelType		: Map {model_name --> type if the model(mIn, mmIn, ...)}
	 * @param modelHandler	: modelHandler (MDR or EMF)
	 * @param mode			: mode (DEBUG or RUN)
	 * @param linkWithNextTransformation
	 * @param checkSameModel TODO
	 * @param libsFromConfig: Map {lib_name --> URI}
	 * @param superimpose   : list of module URIs to superimpose 
	 * @return
	 */
//	public static Map runAtlLauncher(String filePath, Map libsFromConfig, Map input, Map output, Map path, Map modelType, Map modelHandler, String mode, Map linkWithNextTransformation, boolean checkSameModel, List superimpose) {
//		return runAtlLauncher(filePath, libsFromConfig, input, output, path, modelType, modelHandler, mode, linkWithNextTransformation, Collections.EMPTY_MAP, checkSameModel, superimpose, false);
//	}
//
//	public static Map runAtlLauncher(String filePath, Map libsFromConfig, Map input, Map output, Map path, Map modelType, Map modelHandler, String mode, Map linkWithNextTransformation, boolean checkSameModel, List superimpose, boolean continueAfterErrors) {
//		return runAtlLauncher(filePath, libsFromConfig, input, output, path, modelType, modelHandler, mode, linkWithNextTransformation, Collections.EMPTY_MAP, checkSameModel, superimpose, continueAfterErrors);
//	}

	public static Map runAtlLauncher(String filePath, Map libsFromConfig, Map input, Map output, Map path, Map modelType, Map modelHandler, String mode, /*Map linkWithNextTransformation, Map inModel, */List superimpose, Map options) {
			boolean checkSameModel = "true".equals(options.get("checkSameModel"));//$NON-NLS-1$//$NON-NLS-2$
			Map toReturn = new HashMap();
			try {
				//asmUrl
				IFile asmFile = getASMFile(filePath);
				URL asmUrl;
				asmUrl = asmFile.getLocation().toFile().toURL();
	
				//model handler
				Map atlModelHandler = new HashMap();
				for (Iterator i = modelHandler.keySet().iterator(); i.hasNext();) {
					String currentModelHandler = (String)modelHandler.get(i.next());
					if (!atlModelHandler.containsKey(currentModelHandler) && !currentModelHandler.equals(""))//$NON-NLS-1$
						atlModelHandler.put(currentModelHandler, AtlModelHandler.getDefault(currentModelHandler));
				}
				
				//libs
				Map libs = new HashMap();
				for(Iterator i = libsFromConfig.keySet().iterator() ; i.hasNext() ; ) {
					String libName = (String)i.next();
					URL stringsUrl = fileNameToURL((String)libsFromConfig.get(libName));
					libs.put(libName, stringsUrl);
				}
	
	            //superimpose
	            List superimposeURLs = new ArrayList();
	            for(Iterator i = superimpose.iterator() ; i.hasNext() ; ) {
	                URL moduleUrl = fileNameToURL((String)i.next());
	                superimposeURLs.add(moduleUrl);
	            }
	
				Collection toDispose = new HashSet();
				//models
				//if (inModel.isEmpty())
				Map inModel = getSourceModels(input, path, modelHandler, atlModelHandler, checkSameModel, toDispose);
				Map outModel = getTargetModels(output, path, modelHandler, atlModelHandler, inModel, checkSameModel, toDispose);
	
				Map models = new HashMap();
	
				for(Iterator i = inModel.keySet().iterator() ; i.hasNext() ; ) {
					String mName = (String)i.next();
					models.put(mName, inModel.get(mName));
				}
				
				for(Iterator i = outModel.keySet().iterator() ; i.hasNext() ; ) {
					String mName = (String)i.next();
					models.put(mName, outModel.get(mName));
				}
	
	//			models.put("ATL", amh.getAtl());
	//			models.put("MOF", amh.getMof());
				
				//params
				Map params = Collections.EMPTY_MAP;
	
				AtlLauncher myLauncher = AtlLauncher.getDefault();
				if (mode.equals(ILaunchManager.DEBUG_MODE))
					myLauncher.debug(asmUrl, libs, models, params, superimposeURLs, options);
				else
					myLauncher.launch(asmUrl, libs, models, params, superimposeURLs, options);
				
				for(Iterator i = outModel.keySet().iterator(); i.hasNext() ; ) {
					String mName = (String)i.next();
					ASMModel currentOutModel = (ASMModel)outModel.get(mName);
//					if (linkWithNextTransformation.containsKey(mName))
//						toReturn.put(linkWithNextTransformation.get(mName), currentOutModel);
	
					if ((modelType.get(mName) != null) && ((String)modelType.get(mName)).equals(ModelChoiceTab.MODEL_OUTPUT)) {
						// TODO mettre un boolean peut gérer la non sauvegarde
						String mmName = (String)output.get(mName);
						((AtlModelHandler)atlModelHandler.get(modelHandler.get(mmName))).saveModel(currentOutModel, (String)path.get(mName));
					}
				}
				
				for(Iterator i = toDispose.iterator() ; i.hasNext() ; ) {
					ASMModel model = (ASMModel)i.next();
					AtlModelHandler.getHandler(model).disposeOfModel(model);
				}
			} catch (MalformedURLException e) {
				logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//				e.printStackTrace();
			} catch (CoreException e1) {
				logger.log(Level.SEVERE, e1.getLocalizedMessage(), e1);
//				e1.printStackTrace();
			}
			return toReturn;
		}

	//	private static AtlModelHandler amh;
	
	/**
	 * Launches the given configuration in the specified mode, contributing
	 * debug targets to the given launch object. The
	 * launch object has already been registered with the launch manager.
	 * 
	 * @param configuration the configuration to launch
	 * @param mode the mode in which to launch, one of the mode constants
	 * defined by ILaunchManager - RUN_MODE or DEBUG_MODE.
	 * @param launch the launch object to contribute processes and debug
	 *  targets to
	 * @param monitor progress monitor, not is used here
	 * @exception CoreException if launching fails
	 * 
	 * @see ILaunchConfigurationDelegate#launch(ILaunchConfiguration, String, ILaunch, IProgressMonitor) 
	 */
	public void launch(ILaunchConfiguration configurationParam, String mode, ILaunch launchParam, IProgressMonitor monitor) throws CoreException {
	
		final String currentMode = mode;
		final ILaunchConfiguration configuration = configurationParam;
		final ILaunch launch = launchParam;
		
		/*
		 * If the mode choosen was Debug, an ATLDebugTarget was created
		 * */
		if (mode.equals(ILaunchManager.DEBUG_MODE)) {
			// link between the debug target and the source locator
			launch.setSourceLocator(new AtlSourceLocator());
			AtlDebugTarget mTarget = new AtlDebugTarget(launchParam);
	
			new Thread() {
				public void run() {
					runAtlLauncher(configuration, launch, currentMode);
				}
			}.start();
			
			mTarget.start();
			launchParam.addDebugTarget(mTarget);
		}
		else {
			// Run mode
			launchParam.setSourceLocator(new AtlSourceLocator());
			AtlRunTarget mTarget = new AtlRunTarget(launchParam);
			launchParam.addDebugTarget(mTarget);
			runAtlLauncher(configurationParam, launchParam, currentMode);
			mTarget.terminate();
		}
	}

	/**
		 * Launcher of the debuggee with AtlLauncher
		 * @param configuration
		 * @param launch
		 */
		private void runAtlLauncher(ILaunchConfiguration configuration, ILaunch launch, String mode) {
			try {
				String fileName = configuration.getAttribute(AtlLauncherTools.ATLFILENAME, AtlLauncherTools.NULLPARAMETER);
	//			String projectName = configuration.getAttribute(AtlLauncherTools.PROJECTNAME, AtlLauncherTools.NULLPARAMETER);
				Map input = configuration.getAttribute(AtlLauncherTools.INPUT, new HashMap());
				Map output = configuration.getAttribute(AtlLauncherTools.OUTPUT, new HashMap());
				Map path = configuration.getAttribute(AtlLauncherTools.PATH, new HashMap());
				Map modelType = configuration.getAttribute(AtlLauncherTools.MODELTYPE, new HashMap());
				Map libsFromConfig = configuration.getAttribute(AtlLauncherTools.LIBS, new HashMap());
				Map modelHandler = configuration.getAttribute(AtlLauncherTools.MODELHANDLER, new HashMap());
	            List superimpose = configuration.getAttribute(AtlLauncherTools.SUPERIMPOSE, new ArrayList());
	
				Map options = new HashMap();
				for(int i = 0 ; i < AtlLauncherTools.additionalParamIds.length ; i++) {
					boolean value = configuration.getAttribute(AtlLauncherTools.additionalParamIds[i], false);
					options.put(AtlLauncherTools.additionalParamIds[i], value ? "true" : "false");//$NON-NLS-1$//$NON-NLS-2$
				}
				
				runAtlLauncher(fileName, libsFromConfig, input, output, path, modelType, modelHandler, mode, superimpose, options);
			} catch (CoreException e1) {
				logger.log(Level.SEVERE, e1.getLocalizedMessage(), e1);
//				e1.printStackTrace();
			}
		}

	public void launch(URL asmUrl, Map libs, Map models, Map params, List superimps, Map options) {
		AtlLauncher.getDefault().launch(asmUrl, libs, models, params, superimps, options);
	}

}
