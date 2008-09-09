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
import java.io.IOException;
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
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.adt.debug.core.AtlDebugTarget;
import org.eclipse.m2m.atl.adt.debug.core.AtlRunTarget;
import org.eclipse.m2m.atl.adt.launching.sourcelookup.AtlSourceLocator;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.m2m.atl.engine.AtlEMFModelHandler;
import org.eclipse.m2m.atl.engine.AtlLauncher;
import org.eclipse.m2m.atl.engine.AtlModelHandler;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * The ATL Regular VM launcher class.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class AtlRegularVM extends AtlVM {

	private static final boolean USE_EMF_URIS = true;

	/**
	 * With the path of a file, the input stream of the file is returned.
	 * 
	 * @param filePath
	 * @return the input stream corresponding to the file
	 * @throws FileNotFoundException
	 */
	private static InputStream fileNameToInputStream(String filePath) throws FileNotFoundException,
			CoreException {
		String usedFilePath = filePath;
		if (usedFilePath.startsWith("ext:")) { //$NON-NLS-1$
			File f = new File(usedFilePath.substring(4));
			return new FileInputStream(f);
		} else {
			IWorkspaceRoot iwr = ResourcesPlugin.getWorkspace().getRoot();
			usedFilePath = usedFilePath.replace('#', '/');
			return iwr.getFile(new Path(usedFilePath)).getContents();
		}
	}

	private static URI fileNameToURI(String filePath) throws IllegalArgumentException {
		if (filePath.startsWith("ext:")) { //$NON-NLS-1$
			File f = new File(filePath.substring(4));
			return URI.createFileURI(f.getPath());
		} else {
			return URI.createPlatformResourceURI(filePath, true);
		}
	}

	private static URL fileNameToURL(String filePath) throws MalformedURLException {
		if (filePath.startsWith("ext:")) { //$NON-NLS-1$
			File f = new File(filePath.substring(4));
			return f.toURI().toURL();
		} else {
			IWorkspace wks = ResourcesPlugin.getWorkspace();
			IWorkspaceRoot wksroot = wks.getRoot();

			IFile currentLib = wksroot.getFile(new Path(filePath));
			return currentLib.getLocation().toFile().toURI().toURL();
		}
	}

	/**
	 * From the path of an ATL File, this method returns the ASM File corresponding to the ATL File.
	 * 
	 * @param atlFilePath
	 *            name of the ATL File
	 * @return ASM File corresponding to the ATL File
	 */
	private static IFile getASMFile(String atlFilePath) {

		// TODO Get properties of the project
		// know where bin files are, then choose good ASM File for ATL File

		IFile currentAtlFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
				Path.fromOSString(atlFilePath));

		String extension = currentAtlFile.getFileExtension().toLowerCase();
		if (AtlLauncherTools.getExtensions().contains(extension)) {
			String currentAsmPath = currentAtlFile.getFullPath().toString().substring(0,
					currentAtlFile.getFullPath().toString().length() - extension.length())
					+ "asm"; //$NON-NLS-1$
			return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(currentAsmPath));
		} else {
			return null;
		}
	}

	/**
	 * Returns the input stream from a path for metamodel.
	 * 
	 * @param metamodelPath
	 * @return
	 * @throws CoreException
	 */
	private static Map getSourceModels(Map arg, Map path, Map modelHandler, Map atlModelHandler,
			boolean checkSameModel, Collection toDispose) throws CoreException {
		Map toReturn = new HashMap();
		try {
			for (Iterator i = arg.keySet().iterator(); i.hasNext();) {
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
					if (inputModel == null) {
						inputModel = loadModel(amh, mName, mofmm, (String)path.get(mName), toDispose);
					}
				} else {
					ASMModel inputMetaModel = (ASMModel)toReturn.get(mmName);
					if (inputMetaModel == null) {
						inputMetaModel = loadModel(amh, mmName, mofmm, (String)path.get(mmName), toDispose);
						toReturn.put(mmName, inputMetaModel);
					}
					inputMetaModel.setIsTarget(false);
					inputModel = loadModel(amh, mName, inputMetaModel, (String)path.get(mName), toDispose);
				}
				inputModel.setIsTarget(false);
				if (inputModel instanceof ASMEMFModel) {
					((ASMEMFModel)inputModel).setCheckSameModel(checkSameModel);
				}
				toReturn.put(mName, inputModel);
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		return toReturn;
	}

	/**
	 * Returns the input stream from a path for metamodel.
	 * 
	 * @param metamodelPath
	 * @return
	 * @throws CoreException
	 */
	private static Map getTargetModels(Map arg, Map path, Map modelHandler, Map atlModelHandler, Map input,
			boolean checkSameModel, Collection toDispose) throws CoreException {
		Map toReturn = new HashMap();
		try {
			for (Iterator i = arg.keySet().iterator(); i.hasNext();) {
				String mName = (String)i.next();
				String mmName = (String)arg.get(mName);

				AtlModelHandler amh = (AtlModelHandler)atlModelHandler.get(modelHandler.get(mmName));
				ASMModel mofmm = amh.getMof();
				mofmm.setIsTarget(false);
				ASMModel outputModel;

				if (((String)path.get(mmName)).startsWith("#")) { //$NON-NLS-1$
					if (input.get(mmName) == null) {
						toReturn.put(mmName, mofmm);
					}
					outputModel = (ASMModel)toReturn.get(mName);
					if (outputModel == null) {
						outputModel = newModel(amh, mName, mofmm, (String)path.get(mName), toDispose);
					}
				} else {
					ASMModel outputMetaModel = (ASMModel)input.get(mmName);
					if (outputMetaModel == null) {
						outputMetaModel = (ASMModel)toReturn.get(mmName);
					}
					if (outputMetaModel == null) {
						outputMetaModel = loadModel(amh, mmName, mofmm, (String)path.get(mmName), toDispose);
						toReturn.put(mmName, outputMetaModel);
					}
					outputMetaModel.setIsTarget(false);
					outputModel = newModel(amh, mName, outputMetaModel, (String)path.get(mName), toDispose);
				}
				outputModel.setIsTarget(true);
				if (outputModel instanceof ASMEMFModel) {
					((ASMEMFModel)outputModel).setCheckSameModel(checkSameModel);
				}
				toReturn.put(mName, outputModel);
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		return toReturn;
	}

	private static ASMModel loadModel(AtlModelHandler amh, String mName, ASMModel metamodel, String path,
			Collection toDispose) throws CoreException, FileNotFoundException {
		ASMModel ret = null;

		if (USE_EMF_URIS && (amh instanceof AtlEMFModelHandler)) {
			if (path.startsWith("uri:")) { //$NON-NLS-1$
				ret = ((AtlEMFModelHandler)amh).loadModel(mName, metamodel, path);
				// this model should not be disposed of because we did not load it
			} else {
				ret = ((AtlEMFModelHandler)amh).loadModel(mName, metamodel, fileNameToURI(path));
				toDispose.add(ret);
			}
		} else {
			ret = amh.loadModel(mName, metamodel, fileNameToInputStream(path));
			toDispose.add(ret);
		}

		return ret;
	}

	/**
	 * Returns a new ASMModel.
	 * 
	 * @param amh
	 * @param mName
	 * @param metamodel
	 * @param path
	 *            Project file path. Used to derive a platform:/... URI.
	 * @param toDispose
	 * @return A new ASMModel.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	private static ASMModel newModel(AtlModelHandler amh, String mName, ASMModel metamodel, String path,
			Collection toDispose) {
		ASMModel ret = amh.newModel(mName, fileNameToURI(path).toString(), metamodel);
		toDispose.add(ret);
		return ret;
	}

	/**
	 * Runs an ATL transformation.
	 * 
	 * @param filePath
	 *            path of the ATL Transformation
	 * @param libsFromConfig
	 *            Map {lib_name --> URI}
	 * @param input
	 *            Map {model_input --> metamodel_input}
	 * @param output
	 *            Map {model_output --> metamodel_output}
	 * @param path
	 *            Map {model_name --> URI}
	 * @param modelType
	 *            Map {model_name --> type if the model(mIn, mmIn, ...)}
	 * @param modelHandler
	 *            modelHandler (MDR or EMF)
	 * @param mode
	 *            (DEBUG or RUN)
	 * @param superimpose
	 *            list of module URIs to superimpose
	 * @param options
	 *            transformation options
	 * @return unused (TODO)
	 */
	public static Map runAtlLauncher(String filePath, Map libsFromConfig, Map input, Map output, Map path,
			Map modelType, Map modelHandler, String mode, /* Map linkWithNextTransformation, Map inModel, */
			List superimpose, Map options) {
		boolean checkSameModel = "true".equals(options.get("checkSameModel")); //$NON-NLS-1$//$NON-NLS-2$
		Map toReturn = new HashMap();
		try {
			// asmUrl
			IFile asmFile = getASMFile(filePath);
			URL asmUrl;
			asmUrl = asmFile.getLocation().toFile().toURI().toURL();

			// model handler
			Map atlModelHandler = new HashMap();
			for (Iterator i = modelHandler.keySet().iterator(); i.hasNext();) {
				String currentModelHandler = (String)modelHandler.get(i.next());
				if (!atlModelHandler.containsKey(currentModelHandler) && !currentModelHandler.equals("")) { //$NON-NLS-1$
					atlModelHandler.put(currentModelHandler, AtlModelHandler.getDefault(currentModelHandler));
				}
			}

			// libs
			Map libs = new HashMap();
			for (Iterator i = libsFromConfig.keySet().iterator(); i.hasNext();) {
				String libName = (String)i.next();
				URL stringsUrl = fileNameToURL((String)libsFromConfig.get(libName));
				libs.put(libName, stringsUrl);
			}

			// superimpose
			List superimposeURLs = new ArrayList();
			for (Iterator i = superimpose.iterator(); i.hasNext();) {
				URL moduleUrl = fileNameToURL((String)i.next());
				superimposeURLs.add(moduleUrl);
			}

			Collection toDispose = new HashSet();
			// models
			// if (inModel.isEmpty())
			Map inModel = getSourceModels(input, path, modelHandler, atlModelHandler, checkSameModel,
					toDispose);
			Map outModel = getTargetModels(output, path, modelHandler, atlModelHandler, inModel,
					checkSameModel, toDispose);

			Map models = new HashMap();

			for (Iterator i = inModel.keySet().iterator(); i.hasNext();) {
				String mName = (String)i.next();
				models.put(mName, inModel.get(mName));
			}

			for (Iterator i = outModel.keySet().iterator(); i.hasNext();) {
				String mName = (String)i.next();
				models.put(mName, outModel.get(mName));
			}

			// models.put("ATL", amh.getAtl());
			// models.put("MOF", amh.getMof());

			// params
			Map params = Collections.EMPTY_MAP;

			AtlLauncher myLauncher = AtlLauncher.getDefault();
			if (mode.equals(ILaunchManager.DEBUG_MODE)) {
				myLauncher.debug(asmUrl, libs, models, params, superimposeURLs, options);
			} else {
				myLauncher.launch(asmUrl, libs, models, params, superimposeURLs, options);
			}

			for (Iterator i = outModel.keySet().iterator(); i.hasNext();) {
				String mName = (String)i.next();
				ASMModel currentOutModel = (ASMModel)outModel.get(mName);
				// if (linkWithNextTransformation.containsKey(mName))
				// toReturn.put(linkWithNextTransformation.get(mName), currentOutModel);

				if ((modelType.get(mName) != null)
						&& ((String)modelType.get(mName)).equals(ModelChoiceTab.MODEL_OUTPUT)) {
					// TODO mettre un boolean peut gérer la non sauvegarde
					String mmName = (String)output.get(mName);
					((AtlModelHandler)atlModelHandler.get(modelHandler.get(mmName))).saveModel(
							currentOutModel, (String)path.get(mName));
				}
			}

			for (Iterator i = toDispose.iterator(); i.hasNext();) {
				ASMModel model = (ASMModel)i.next();
				AtlModelHandler.getHandler(model).disposeOfModel(model);
			}
		} catch (MalformedURLException e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			// e.printStackTrace();
		} catch (CoreException e1) {
			logger.log(Level.SEVERE, e1.getLocalizedMessage(), e1);

		}
		return toReturn;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration,
	 *      java.lang.String, org.eclipse.debug.core.ILaunch, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void launch(ILaunchConfiguration configurationParam, String mode, ILaunch launchParam,
			IProgressMonitor monitor) throws CoreException {

		final String currentMode = mode;
		final ILaunchConfiguration configuration = configurationParam;
		final ILaunch launch = launchParam;

		/*
		 * If the mode choosen was Debug, an ATLDebugTarget was created
		 */
		if (mode.equals(ILaunchManager.DEBUG_MODE)) {
			// link between the debug target and the source locator
			launch.setSourceLocator(new AtlSourceLocator());
			AtlDebugTarget mTarget = new AtlDebugTarget(launchParam);

			Thread th = new Thread() {
				public void run() {
					runAtlLauncher(configuration, launch, currentMode);
				}
			};
			th.start();

			mTarget.start();
			launchParam.addDebugTarget(mTarget);
		} else {
			// Run mode
			launchParam.setSourceLocator(new AtlSourceLocator());
			AtlRunTarget mTarget = new AtlRunTarget(launchParam);
			launchParam.addDebugTarget(mTarget);
			runAtlLauncher(configurationParam, launchParam, currentMode);
			mTarget.terminate();
		}
	}

	/**
	 * Launcher of the debuggee with AtlLauncher.
	 * 
	 * @param configuration
	 *            the launch configuration
	 * @param launch
	 *            the launch interface
	 */
	private void runAtlLauncher(ILaunchConfiguration configuration, ILaunch launch, String mode) {
		try {
			String fileName = configuration.getAttribute(AtlLauncherTools.ATLFILENAME,
					AtlLauncherTools.NULLPARAMETER);
			Map input = configuration.getAttribute(AtlLauncherTools.INPUT, new HashMap());
			Map output = configuration.getAttribute(AtlLauncherTools.OUTPUT, new HashMap());
			Map path = configuration.getAttribute(AtlLauncherTools.PATH, new HashMap());
			Map modelType = configuration.getAttribute(AtlLauncherTools.MODELTYPE, new HashMap());
			Map libsFromConfig = configuration.getAttribute(AtlLauncherTools.LIBS, new HashMap());
			Map modelHandler = configuration.getAttribute(AtlLauncherTools.MODELHANDLER, new HashMap());
			List superimpose = configuration.getAttribute(AtlLauncherTools.SUPERIMPOSE, new ArrayList());

			Map options = new HashMap();
			for (int i = 0; i < AtlLauncherTools.ADDITIONAL_PARAM_IDS.length; i++) {
				boolean value = configuration.getAttribute(AtlLauncherTools.ADDITIONAL_PARAM_IDS[i], false);
				options.put(AtlLauncherTools.ADDITIONAL_PARAM_IDS[i], value ? "true" : "false"); //$NON-NLS-1$//$NON-NLS-2$
			}

			runAtlLauncher(fileName, libsFromConfig, input, output, path, modelType, modelHandler, mode,
					superimpose, options);
		} catch (CoreException e1) {
			logger.log(Level.SEVERE, e1.getLocalizedMessage(), e1);

		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.launching.AtlVM#launch(java.net.URL, java.util.Map, java.util.Map,
	 *      java.util.Map, java.util.List, java.util.Map)
	 */
	public Object launch(URL asmUrl, Map libs, Map models, Map params, List superimps, Map options) {
		return AtlLauncher.getDefault().launch(asmUrl, libs, models, params, superimps, options);
	}

}
