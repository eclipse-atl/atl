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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

//import org.atl.eclipse.emf4amc.AmcModelHandler;
//import org.atl.eclipse.adt.amc.model.AMCRepository;
//import org.atl.eclipse.adt.amc.model.AMCRepositoryModel;
//import org.atl.eclipse.adt.amc.model.IModel;
import org.atl.eclipse.adt.debug.core.AtlDebugTarget;
import org.atl.eclipse.adt.debug.core.AtlRunTarget;
import org.atl.eclipse.adt.launching.sourcelookup.AtlSourceLocator;
import org.atl.eclipse.engine.AtlLauncher;
import org.atl.eclipse.engine.AtlModelHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
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
import org.mda.asm.nativeimpl.ASMModel;

/**
 * The method "launch" is launched when you click on the button "Run" or "Debug"
 * 
 * @author allilaire
 *
 */
public class AtlLaunchConfigurationDelegate implements ILaunchConfigurationDelegate {
	
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
					startDebuggee(configuration, launch, currentMode);
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
			startDebuggee(configurationParam, launchParam, currentMode);
			mTarget.terminate();
		}
	}

	/**
	 * Launcher of the debuggee with AtlLauncher
	 * @param configuration
	 * @param launch
	 */
	private void startDebuggee(ILaunchConfiguration configuration, ILaunch launch, String mode) {
		try {
			String fileName = configuration.getAttribute(AtlLauncherTools.ATLFILENAME, AtlLauncherTools.NULLPARAMETER);
			String projectName = configuration.getAttribute(AtlLauncherTools.PROJECTNAME, AtlLauncherTools.NULLPARAMETER);
			Map input = configuration.getAttribute(AtlLauncherTools.INPUT, new HashMap());
			Map output = configuration.getAttribute(AtlLauncherTools.OUTPUT, new HashMap());
			Map path = configuration.getAttribute(AtlLauncherTools.PATH, new HashMap());
			Map modelType = configuration.getAttribute(AtlLauncherTools.MODELTYPE, new HashMap());
			Map libsFromConfig = configuration.getAttribute(AtlLauncherTools.LIBS, new HashMap());
			String modelHandler = configuration.getAttribute(AtlLauncherTools.MODELHANDLER, "");
			
			//asmUrl
			IFile asmFile = getASMFile(fileName);
			URL asmUrl;
			asmUrl = asmFile.getLocation().toFile().toURL();

			//libs
			Map libs = new HashMap();
			for(Iterator i = libsFromConfig.keySet().iterator() ; i.hasNext() ; ) {
				String libName = (String)i.next();
				URL stringsUrl = fileNameToURL((String)libsFromConfig.get(libName));
				libs.put(libName, stringsUrl);
			}

			//models
			Map inModel = getModelInput(input, path, modelHandler);
			Map outModel = getModelOutput(output, path, getProject(projectName), modelHandler, inModel);

			Map models = new HashMap();

			for(Iterator i = inModel.keySet().iterator() ; i.hasNext() ; ) {
				String mName = (String)i.next();
				models.put(mName, inModel.get(mName));
			}
			
			for(Iterator i = outModel.keySet().iterator() ; i.hasNext() ; ) {
				String mName = (String)i.next();
				models.put(mName, outModel.get(mName));
			}

			//params
			Map params = new HashMap();

			AtlLauncher myLauncher = AtlLauncher.getDefault();
			if (mode.equals(ILaunchManager.DEBUG_MODE))
				myLauncher.debug(asmUrl, libs, models, params);
			else
				myLauncher.launch(asmUrl, libs, models, params);

			for(Iterator i = outModel.keySet().iterator() ; i.hasNext() ; ) {
				String mName = (String)i.next();
				if ((modelType.get(mName) != null) && ((String)modelType.get(mName)).equals(ModelChoiceTab.MODEL_OUTPUT))
					AtlModelHandler.getDefault(modelHandler).saveModel((ASMModel)outModel.get(mName), getProject(projectName));
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (CoreException e1) {
			e1.printStackTrace();
		}
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
	private Map getModelInput(Map arg, Map path, String modelHandler) throws CoreException {
		Map toReturn = new HashMap();
		try {
			for(Iterator i = arg.keySet().iterator() ; i.hasNext() ; ) {
				String mName = (String)i.next();
				String mmName = (String)arg.get(mName);

				AtlModelHandler amh = AtlModelHandler.getDefault(modelHandler);
				ASMModel mofmm = amh.getMof();
				ASMModel inputModel;
				if (mmName.equals("MOF")) {
					toReturn.put("MOF", mofmm);
					inputModel = amh.loadModel(mName, mofmm, fileNameToInputStream((String)path.get(mName)));
				}
				else {
					ASMModel inputMetaModel = (ASMModel)toReturn.get(mmName);
					if(inputMetaModel == null) {
						inputMetaModel = amh.loadModel(mmName, mofmm, fileNameToInputStream((String)path.get(mmName)));
						toReturn.put(mmName, inputMetaModel);
					}
					inputModel = amh.loadModel(mName, inputMetaModel, fileNameToInputStream((String)path.get(mName)));
				}
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
	private Map getModelOutput(Map arg, Map path, IProject project, String modelHandler, Map input) throws CoreException {
		Map toReturn = new HashMap();
		try {
			for(Iterator i = arg.keySet().iterator() ; i.hasNext() ; ) {
				String mName = (String)i.next();
				String mmName = (String)arg.get(mName);

				AtlModelHandler amh = AtlModelHandler.getDefault(modelHandler);
				ASMModel mofmm = amh.getMof();
				ASMModel outputModel;
				
				if (mmName.equals("MOF")) {
					if (input.get(mmName) == null)
						toReturn.put("MOF", mofmm);
					outputModel = amh.newModel(mName, mofmm);
				}
				else {
					ASMModel outputMetaModel = amh.loadModel(mmName, mofmm, fileNameToInputStream((String)path.get(mmName)));
					if (input.get(mmName) == null)
						toReturn.put(mmName, outputMetaModel);
					String mNamePath = (String)path.get(mName);
					outputModel = amh.newModel(mNamePath, outputMetaModel);
				}
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
	private InputStream fileNameToInputStream(String filePath) throws FileNotFoundException, CoreException {
		if (filePath.startsWith("ext:")) {
			File f = new File(filePath.substring(4));
			return new FileInputStream(f);
		}

		else {
			StringTokenizer st = new StringTokenizer(filePath, "/\\");
			String projectName = "";
			String fileName = "";
			
			while (projectName.equals("") && st.hasMoreTokens())
				projectName = st.nextToken();

			IWorkspace wks = ResourcesPlugin.getWorkspace();
			IWorkspaceRoot wksroot = wks.getRoot();
			IProject modelProject = wksroot.getProject(projectName);
			IFolder folder = null;
			
			while (st.hasMoreTokens()) {
				fileName = st.nextToken();
				if ((st.hasMoreTokens()) && (folder == null))
					folder = modelProject.getFolder(fileName);
				else if (st.hasMoreTokens())
					folder = folder.getFolder(fileName);
			}
			
			IFile file;
			if (folder == null)
				file = modelProject.getFile(fileName);
			else
				file = folder.getFile(fileName);
			return file.getContents();
		}
	}
	
	private URL fileNameToURL(String filePath) throws MalformedURLException {
		if (filePath.startsWith("ext:")) {
			File f = new File(filePath.substring(4));
			return f.toURL();
		}
		else {
			StringTokenizer st = new StringTokenizer(filePath, "/\\");
			String projectName = "";
			String fileName = "";
			
			while (projectName.equals("") && st.hasMoreTokens())
				projectName = st.nextToken();
			
			while (st.hasMoreTokens())
				fileName = st.nextToken();
			
			IWorkspace wks = ResourcesPlugin.getWorkspace();
			IWorkspaceRoot wksroot = wks.getRoot();
			IProject modelProject = wksroot.getProject(projectName);

			IFile file = modelProject.getFile(fileName);
			return file.getLocation().toFile().toURL();
		}
	}
	
	private IProject getProject(String projectName) {
		
		IWorkspace wks = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot wksroot = wks.getRoot();

		IProject project = wksroot.getProject(projectName);
		return project;
	}
	
	private IFile getFile(String atlFileName, String projectName) {
		
		IWorkspace wks = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot wksroot = wks.getRoot();

		IFile file = wksroot.getProject(projectName).getFile(atlFileName);
		return file;
	}
	
	/**
	 * From the path of an ATL File, this method returns 
	 * the ASM File corresponding to the ATL File
	 * @param atlFilePath name of the ATL File
	 * @return ASM File corresponding to the ATL File
	 */
	private IFile getASMFile(String atlFilePath) {
		
		IWorkspace wks = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot wksroot = wks.getRoot();

		// TODO Get properties of the project
		// know where bin files are, then choose good ASM File for ATL File

		StringTokenizer st = new StringTokenizer(atlFilePath, ".");
		atlFilePath = st.nextToken() + ".asm";
		return wksroot.getFile(new Path(atlFilePath));
	}

}

