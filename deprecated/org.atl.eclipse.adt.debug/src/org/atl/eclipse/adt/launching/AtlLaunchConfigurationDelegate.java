/*
 * Created on 26 avr. 2004
 *
 */
package org.atl.eclipse.adt.launching;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import org.atl.eclipse.adt.debug.core.AtlDebugTarget;
import org.atl.eclipse.adt.debug.core.AtlRunTarget;
import org.atl.eclipse.adt.launching.sourcelookup.AtlSourceLocator;
import org.atl.eclipse.engine.AtlLauncher;
import org.atl.eclipse.engine.AtlModelHandler;
import org.atl.engine.vm.nativelib.ASMModel;
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

/**
 * The method "launch" is launched when you click on the button "Run" or "Debug"
 * 
 * @author allilaire
 *
 */
public class AtlLaunchConfigurationDelegate implements ILaunchConfigurationDelegate {
	
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
			String projectName = configuration.getAttribute(AtlLauncherTools.PROJECTNAME, AtlLauncherTools.NULLPARAMETER);
			Map input = configuration.getAttribute(AtlLauncherTools.INPUT, new HashMap());
			Map output = configuration.getAttribute(AtlLauncherTools.OUTPUT, new HashMap());
			Map path = configuration.getAttribute(AtlLauncherTools.PATH, new HashMap());
			Map modelType = configuration.getAttribute(AtlLauncherTools.MODELTYPE, new HashMap());
			Map libsFromConfig = configuration.getAttribute(AtlLauncherTools.LIBS, new HashMap());
			Map modelHandler = configuration.getAttribute(AtlLauncherTools.MODELHANDLER, new HashMap());

			runAtlLauncher(fileName, libsFromConfig, input, output, path, modelType, modelHandler, mode);
		} catch (CoreException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 
	 * @param filePath		: path of the ATL Transformation
	 * @param libsFromConfig: Map {lib_name --> URI}
	 * @param input			: Map {model_input --> metamodel_input}
	 * @param output		: Map {model_output --> metamodel_output}
	 * @param path			: Map {model_name --> URI}
	 * @param modelType		: Map {model_name --> type if the model(mIn, mmIn, ...)}
	 * @param modelHandler	: modelHandler (MDR or EMF)
	 * @param mode			: mode (DEBUG or RUN)
	 */
	public static void runAtlLauncher(String filePath, Map libsFromConfig, Map input, Map output, Map path, Map modelType, Map modelHandler, String mode) {
		runAtlLauncher(filePath, libsFromConfig, input, output, path, modelType, modelHandler, mode, Collections.EMPTY_MAP);
	}

	/**
	 * 
	 * @param filePath		: path of the ATL Transformation
	 * @param libsFromConfig: Map {lib_name --> URI}
	 * @param input			: Map {model_input --> metamodel_input}
	 * @param output		: Map {model_output --> metamodel_output}
	 * @param path			: Map {model_name --> URI}
	 * @param modelType		: Map {model_name --> type if the model(mIn, mmIn, ...)}
	 * @param modelHandler	: modelHandler (MDR or EMF)
	 * @param mode			: mode (DEBUG or RUN)
	 * @param linkWithNextTransformation
	 * @return
	 */
	public static Map runAtlLauncher(String filePath, Map libsFromConfig, Map input, Map output, Map path, Map modelType, Map modelHandler, String mode, Map linkWithNextTransformation) {
		return runAtlLauncher(filePath, libsFromConfig, input, output, path, modelType, modelHandler, mode, linkWithNextTransformation, Collections.EMPTY_MAP);
	}
	
	public static Map runAtlLauncher(String filePath, Map libsFromConfig, Map input, Map output, Map path, Map modelType, Map modelHandler, String mode, Map linkWithNextTransformation, Map inModel) {
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
				if (!atlModelHandler.containsKey(currentModelHandler) && !currentModelHandler.equals(""))
					atlModelHandler.put(currentModelHandler, AtlModelHandler.getDefault(currentModelHandler));
			}
			
			//libs
			Map libs = new HashMap();
			for(Iterator i = libsFromConfig.keySet().iterator() ; i.hasNext() ; ) {
				String libName = (String)i.next();
				URL stringsUrl = fileNameToURL((String)libsFromConfig.get(libName));
				libs.put(libName, stringsUrl);
			}

			//models
			if (inModel.isEmpty())
				inModel = getSourceModels(input, path, modelHandler, atlModelHandler);
			Map outModel = getTargetModels(output, path, modelHandler, atlModelHandler, inModel);

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
				myLauncher.debug(asmUrl, libs, models, params);
			else
				myLauncher.launch(asmUrl, libs, models, params);
			
			for(Iterator i = outModel.keySet().iterator(); i.hasNext() ; ) {
				String mName = (String)i.next();
				ASMModel currentOutModel = (ASMModel)outModel.get(mName);
				if (linkWithNextTransformation.containsKey(mName))
					toReturn.put(linkWithNextTransformation.get(mName), currentOutModel);

				if ((modelType.get(mName) != null) && ((String)modelType.get(mName)).equals(ModelChoiceTab.MODEL_OUTPUT)) {
					// TODO mettre un boolean peut gérer la non sauvegarde
					String mmName = (String)output.get(mName);
					((AtlModelHandler)atlModelHandler.get(modelHandler.get(mmName))).saveModel(currentOutModel, (String)path.get(mName));
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (CoreException e1) {
			e1.printStackTrace();
		}
		return toReturn;
	}
	
	/**
	 * @param param
	 * @return Returns the property value of the project
	 */
	private String getAtlProjectProperties(String param) {
		// TODO getAtlProjectProperties
		return null;
	}
	
	/**
	 * Returns the input stream from a path for metamodel
	 * @param metamodelPath
	 * @return
	 * @throws CoreException
	 */
	private static Map getSourceModels(Map arg, Map path, Map modelHandler, Map atlModelHandler) throws CoreException {
		Map toReturn = new HashMap();
		try {
			for(Iterator i = arg.keySet().iterator() ; i.hasNext() ; ) {
				String mName = (String)i.next();
				String mmName = (String)arg.get(mName);

//				AtlModelHandler amh = AtlModelHandler.getDefault(modelHandler);
				AtlModelHandler amh = (AtlModelHandler)atlModelHandler.get(modelHandler.get(mmName));
				ASMModel mofmm = amh.getMof();
				mofmm.setIsTarget(false);
				ASMModel inputModel;
				if (((String)path.get(mmName)).startsWith("#")) {
					toReturn.put(mmName, mofmm);
					inputModel = amh.loadModel(mName, mofmm, fileNameToInputStream((String)path.get(mName)));
				}
				else {
					ASMModel inputMetaModel = (ASMModel)toReturn.get(mmName);
					if(inputMetaModel == null) {
						inputMetaModel = amh.loadModel(mmName, mofmm, fileNameToInputStream((String)path.get(mmName)));
						toReturn.put(mmName, inputMetaModel);
					}
					inputMetaModel.setIsTarget(false);
					inputModel = amh.loadModel(mName, inputMetaModel, fileNameToInputStream((String)path.get(mName)));
				}
				inputModel.setIsTarget(false);
				toReturn.put(mName, inputModel);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return toReturn;
	}

	/**
	 * Returns the input stream from a path for metamodel
	 * @param metamodelPath
	 * @return
	 * @throws CoreException
	 */
	private static Map getTargetModels(Map arg, Map path, Map modelHandler, Map atlModelHandler, Map input) throws CoreException {
		Map toReturn = new HashMap();
		try {
			for(Iterator i = arg.keySet().iterator() ; i.hasNext() ; ) {
				String mName = (String)i.next();
				String mmName = (String)arg.get(mName);

//				AtlModelHandler amh = AtlModelHandler.getDefault(modelHandler);
				AtlModelHandler amh = (AtlModelHandler)atlModelHandler.get(modelHandler.get(mmName));
				ASMModel mofmm = amh.getMof();
				mofmm.setIsTarget(false);
				ASMModel outputModel;
				
				if (((String)path.get(mmName)).startsWith("#")) {
					if (input.get(mmName) == null)
						toReturn.put(mmName, mofmm);
					outputModel = amh.newModel(mName, mofmm);
				}
				else {
					ASMModel outputMetaModel = (ASMModel)input.get(mmName);
					if (outputMetaModel == null)
						outputMetaModel = (ASMModel)toReturn.get(mmName);
					if(outputMetaModel == null) {
						outputMetaModel = amh.loadModel(mmName, mofmm, fileNameToInputStream((String)path.get(mmName)));
						toReturn.put(mmName, outputMetaModel);
					}
					outputMetaModel.setIsTarget(false);
					outputModel = amh.newModel(mName, outputMetaModel);
				}
				outputModel.setIsTarget(true);
				toReturn.put(mName, outputModel);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return toReturn;
	}
	
	/**
	 * With the path of a file, the input stream of the file is returned
	 * @param filePath
	 * @return the input stream corresponding to the file
	 * @throws FileNotFoundException
	 */
	private static InputStream fileNameToInputStream(String filePath) throws FileNotFoundException, CoreException {
		if (filePath.startsWith("ext:")) {
			File f = new File(filePath.substring(4));
			return new FileInputStream(f);
		}
		else {
			IWorkspaceRoot iwr = ResourcesPlugin.getWorkspace().getRoot();
			filePath = filePath.replace('#', '/');
			return iwr.getFile(new Path(filePath)).getContents();
		}
	}
	
	private static URL fileNameToURL(String filePath) throws MalformedURLException {
		if (filePath.startsWith("ext:")) {
			File f = new File(filePath.substring(4));
			return f.toURL();
		}
		else {
			IFile file = getASMFile(filePath);
			return file.getLocation().toFile().toURL();
		}
	}
	
	/**
	 * From the path of an ATL File, this method returns 
	 * the ASM File corresponding to the ATL File
	 * @param atlFilePath name of the ATL File
	 * @return ASM File corresponding to the ATL File
	 */
	private static IFile getASMFile(String atlFilePath) {
		atlFilePath = atlFilePath.replace('#', '/');
		
		IWorkspace wks = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot wksroot = wks.getRoot();

		// TODO Get properties of the project
		// know where bin files are, then choose good ASM File for ATL File

		StringTokenizer st = new StringTokenizer(atlFilePath, ".");
		atlFilePath = st.nextToken() + ".asm";
		return wksroot.getFile(new Path(atlFilePath));
	}

}

