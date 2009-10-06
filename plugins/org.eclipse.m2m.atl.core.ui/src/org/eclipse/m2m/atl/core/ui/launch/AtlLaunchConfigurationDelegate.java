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
package org.eclipse.m2m.atl.core.ui.launch;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.m2m.atl.common.ATLExecutionException;
import org.eclipse.m2m.atl.common.ATLLaunchConstants;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.core.service.CoreService;
import org.eclipse.m2m.atl.core.service.LauncherService;
import org.eclipse.m2m.atl.core.ui.ATLCoreUIPlugin;
import org.eclipse.m2m.atl.core.ui.Messages;
import org.eclipse.m2m.atl.debug.core.AtlDebugTarget;
import org.eclipse.m2m.atl.debug.core.AtlRunTarget;
import org.eclipse.m2m.atl.debug.core.AtlSourceLocator;

/**
 * The method "launch" is launched when you click on the button "Run" or "Debug".
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class AtlLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

	private static Map<String, IFile> moduleFilesByModuleName;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration,
	 *      java.lang.String, org.eclipse.debug.core.ILaunch, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@SuppressWarnings("unchecked")
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch,
			IProgressMonitor monitor) throws CoreException {

		moduleFilesByModuleName = new HashMap<String, IFile>();
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}

		String launcherName = configuration.getAttribute(ATLLaunchConstants.ATL_VM, ""); //$NON-NLS-1$		
		String atlCompiler = configuration.getAttribute(ATLLaunchConstants.ATL_COMPILER, ""); //$NON-NLS-1$
		boolean isRefining = configuration.getAttribute(ATLLaunchConstants.IS_REFINING, false);

		Map<String, Object> options = new HashMap<String, Object>();
		boolean isRefiningTraceMode = "atl2006".equals(atlCompiler) && isRefining; //$NON-NLS-1$
		options.put("isRefiningTraceMode", Boolean.valueOf(isRefiningTraceMode).toString()); //$NON-NLS-1$
		options.put("launch", launch); //$NON-NLS-1$
		options.put("monitor", monitor); //$NON-NLS-1$

		// Launch configuration analysis
		String fileName = configuration.getAttribute(ATLLaunchConstants.ATL_FILE_NAME,
				ATLLaunchConstants.NULL_PARAMETER);
		Map<String, String> sourceModels = configuration.getAttribute(ATLLaunchConstants.INPUT,
				Collections.EMPTY_MAP);
		Map<String, String> targetModels = configuration.getAttribute(ATLLaunchConstants.OUTPUT,
				Collections.EMPTY_MAP);
		Map<String, String> launchConfigModelPaths = configuration.getAttribute(ATLLaunchConstants.PATH,
				Collections.EMPTY_MAP);
		Map<String, String> modelPaths = convertPaths(launchConfigModelPaths);

		Map<String, String> libs = configuration.getAttribute(ATLLaunchConstants.LIBS, Collections.EMPTY_MAP);
		List<String> superimps = configuration.getAttribute(ATLLaunchConstants.SUPERIMPOSE,
				Collections.EMPTY_LIST);
		options.putAll(configuration.getAttribute(ATLLaunchConstants.OPTIONS, Collections.EMPTY_MAP));
		Map<String, String> modelHandlers = configuration.getAttribute(ATLLaunchConstants.MODEL_HANDLER,
				Collections.EMPTY_MAP);
		options.put(ATLLaunchConstants.OPTION_MODEL_HANDLER, modelHandlers);

		Object clearConsole = options.get(AdvancedTab.OPTION_CLEAR);
		if (clearConsole != null && "true".equals(clearConsole)) { //$NON-NLS-1$
			ATLCoreUIPlugin.clearConsole();
		}

		ILauncher launcher = null;
		try {
			// API extensions management
			launcher = CoreService.getLauncher(launcherName);
		} catch (ATLCoreException e) {
			ATLLogger.log(Level.SEVERE, e.getMessage(), e);
		}

		if (launcher == null) {
			String[] registeredLaunchers = CoreService.getLaunchersNames();
			ATLLogger
					.severe(Messages
							.getString(
									"AtlLaunchConfigurationDelegate.LAUNCHER_NOT_FOUND", launcherName, Arrays.asList(registeredLaunchers))); //$NON-NLS-1$
			return;
		}

		// ATL modules
		IFile currentAtlFile = ResourcesPlugin.getWorkspace().getRoot().getFile(Path.fromOSString(fileName));
		String currentExtension = currentAtlFile.getFileExtension().toLowerCase();
		if (currentExtension.equals("atl")) { //$NON-NLS-1$
			options.put(ATLLaunchConstants.OPTION_ATL_FILE_PATH, fileName);
			String currentAsmPath = currentAtlFile.getFullPath().toString().substring(0,
					currentAtlFile.getFullPath().toString().length() - currentExtension.length())
					+ "asm"; //$NON-NLS-1$
			currentAtlFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(currentAsmPath));
		}

		if (!addLaunchedModule(currentAtlFile)) {
			return;
		}

		InputStream asmInputStream = currentAtlFile.getContents();
		InputStream[] modules = new InputStream[superimps.size() + 1];
		modules[0] = asmInputStream;
		for (int i = 1; i < modules.length; i++) {
			String moduleFileName = superimps.get(i - 1);
			IFile moduleFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
					Path.fromOSString(moduleFileName));
			if (!addLaunchedModule(moduleFile)) {
				return;
			}
			modules[i] = moduleFile.getContents();
		}

		// Libraries
		Map<String, InputStream> libraries = new HashMap<String, InputStream>();
		for (Iterator<String> i = libs.keySet().iterator(); i.hasNext();) {
			String libName = i.next();
			IFile libFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
					Path.fromOSString(libs.get(libName)));
			if (!addLaunchedModule(libFile)) {
				return;
			}
			libraries.put(libName, libFile.getContents());
		}

		// check for cancellation
		if (monitor.isCanceled()) {
			return;
		}

		if (isRefiningTraceMode) {
			/*
			 * TODO: improve ATL header syntax to recognize inout models. Apply those changes to launch
			 * config. Current workaround: refined models list must match output models list to be saved, with
			 * respect to the declaration order.
			 */
			Iterator<String> sourceIterator = sourceModels.keySet().iterator();
			Iterator<String> targetIterator = targetModels.keySet().iterator();

			List<String> orderedInput = configuration.getAttribute(ATLLaunchConstants.ORDERED_INPUT,
					Collections.EMPTY_LIST);
			if (!orderedInput.isEmpty()) {
				sourceIterator = orderedInput.iterator();
			}

			List<String> orderedOutput = configuration.getAttribute(ATLLaunchConstants.ORDERED_OUTPUT,
					Collections.EMPTY_LIST);
			if (!orderedOutput.isEmpty()) {
				targetIterator = orderedOutput.iterator();
			}

			Map<String, String> newTargetModels = new HashMap<String, String>();
			newTargetModels.putAll(targetModels);
			List<String> targetToRemove = new ArrayList<String>();

			while (sourceIterator.hasNext()) {
				String sourceModelName = sourceIterator.next();
				String sourceMetamodelName = sourceModels.get(sourceModelName);

				// Lookup for a matching target model (same metamodel)
				while (targetIterator.hasNext()) {
					String targetModelName = targetIterator.next();
					String targetMetamodelName = targetModels.get(targetModelName);

					// Ignore previously used target models
					if (targetMetamodelName.equals(sourceMetamodelName)
							&& !targetToRemove.contains(targetModelName)) {
						String targetModelPath = modelPaths.get(targetModelName);

						// Compute the inout model path (for extraction)
						String refinedModelPathName = LauncherService.getRefinedModelName(sourceModelName);
						modelPaths.put(refinedModelPathName, targetModelPath);
						targetToRemove.add(targetModelName);
						break;
					}
				}
			}

			for (String key : targetToRemove) {
				newTargetModels.remove(key);
			}

			launchOrDebug(mode, monitor, launcher, Collections.EMPTY_MAP, sourceModels, newTargetModels,
					modelPaths, options, libraries, launch, modules);
		} else {
			launchOrDebug(mode, monitor, launcher, sourceModels, Collections.EMPTY_MAP, targetModels,
					modelPaths, options, libraries, launch, modules);
		}

		if ("true".equals(options.get(AdvancedTab.OPTION_DERIVED.toString()))) { //$NON-NLS-1$
			// Set generated files as derived
			for (String targetModel : targetModels.keySet()) {
				String path = launchConfigModelPaths.get(targetModel);
				setDerived(path);
			}
		}

	}

	private static Object launchOrDebug(final String mode, final IProgressMonitor monitor,
			final ILauncher launcher, final Map<String, String> sourceModels,
			final Map<String, String> sourceTargetModels, final Map<String, String> targetModels,
			final Map<String, String> modelPaths, final Map<String, Object> options,
			final Map<String, InputStream> libraries, ILaunch launchParam, final InputStream... modules) {
		final String realMode;
		if (!Arrays.asList(launcher.getModes()).contains(mode)) {
			ATLLogger.info(Messages.getString(
					"AtlLaunchConfigurationDelegate.UNSUPPORTED_MODE", mode, launcher.getName())); //$NON-NLS-1$
			realMode = ILauncher.RUN_MODE;
		} else {
			realMode = mode;
		}
		/*
		 * If the mode chosen was Debug, an ATLDebugTarget was created
		 */
		if (realMode.equals(ILaunchManager.DEBUG_MODE)) {
			launchParam.setSourceLocator(new AtlSourceLocator());
			final AtlDebugTarget mTarget = new AtlDebugTarget(launchParam);
			Thread th = new Thread() {
				@Override
				public void run() {
					try {
						LauncherService.launch(realMode, monitor, launcher, sourceModels, sourceTargetModels,
								targetModels, modelPaths, options, libraries, modules);
						// mTarget.terminate();
						// } catch (DebugException e) {
						// ATLLogger.severe(e.getMessage());
					} catch (ATLCoreException e) {
						ATLLogger.severe(e.getMessage());
						return;
					} catch (ATLExecutionException e) {
						ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
					} finally {
						monitor.done();
					}
				}
			};
			th.start();

			if (options.get(ATLLaunchConstants.STOP_IN_MAIN) != null) {
				mTarget.setStopInMain(Boolean.valueOf(options.get(ATLLaunchConstants.STOP_IN_MAIN).toString())
						.booleanValue());
			}
			mTarget.start();
			launchParam.addDebugTarget(mTarget);

		} else {

			// Run mode
			launchParam.setSourceLocator(new AtlSourceLocator());
			AtlRunTarget mTarget = new AtlRunTarget(launchParam);
			launchParam.addDebugTarget(mTarget);
			try {
				LauncherService.launch(realMode, monitor, launcher, sourceModels, sourceTargetModels,
						targetModels, modelPaths, options, libraries, modules);
				mTarget.terminate();
			} catch (ATLCoreException e) {
				ATLLogger.severe(e.getMessage());
				return null;
			} catch (DebugException e) {
				ATLLogger.severe(e.getMessage());
				return null;
			} catch (ATLExecutionException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			} finally {
				monitor.done();
			}
		}
		return null;
	}

	private static boolean addLaunchedModule(IFile file) {
		if (!file.exists()) {
			ATLLogger.severe(Messages.getString(
					"AtlLaunchConfigurationDelegate.FILE_NOT_EXIST", file.getFullPath())); //$NON-NLS-1$
			return false;
		}
		IFile atlFile = file;
		String ext = atlFile.getFileExtension().toLowerCase();
		if (ext.equals("asm")) { //$NON-NLS-1$
			String path = atlFile.getFullPath().toString().substring(0,
					atlFile.getFullPath().toString().length() - ext.length())
					+ "atl"; //$NON-NLS-1$
			atlFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));
		}
		if (atlFile.isAccessible()) {
			moduleFilesByModuleName.put(computeModuleName(file), atlFile);
		}
		return true;
	}

	/**
	 * Returns the file matching the given module name.
	 * 
	 * @param moduleName
	 *            the module name
	 * @return the file
	 */
	public static IFile getFileFromModuleName(String moduleName) {
		if (moduleFilesByModuleName != null) {
			return moduleFilesByModuleName.get(moduleName);
		}
		return null;
	}

	private static String computeModuleName(IFile file) {
		String res = file.getName();
		try {
			InputStreamReader streamReader = new InputStreamReader(file.getContents());
			BufferedReader buffer = new BufferedReader(streamReader);
			String line = ""; //$NON-NLS-1$
			while (null != (line = buffer.readLine())) {
				if (line.contains("<constant value=")) { //$NON-NLS-1$
					res = line.split("\\\"")[1]; //$NON-NLS-1$
					buffer.close();
					streamReader.close();
					return res;
				}
			}
			buffer.close();
			streamReader.close();
		} catch (Throwable e) {
			// DO NOTHING
		}
		return res;
	}

	/**
	 * Convert model map paths.
	 * 
	 * @param modelPaths
	 *            the model path map
	 * @return the converted map
	 */
	public static Map<String, String> convertPaths(Map<String, String> modelPaths) {
		Map<String, String> result = new HashMap<String, String>();
		for (Iterator<String> iterator = modelPaths.keySet().iterator(); iterator.hasNext();) {
			String modelName = iterator.next();
			String modelPath = modelPaths.get(modelName);
			result.put(modelName, convertPath(modelPath));
		}
		return result;
	}

	/**
	 * Convert "launch configuration style" paths to EMF uris:
	 * <ul>
	 * <li>ext:<i>path</i> => file:<i>path</i> (file system resource)</li>
	 * <li>uri:<i>uri</i> => <i>uri</i> (EMF uri)</li>
	 * <li><i>path</i> => platform:/resource/<i>path</i> (workspace resource)</li>
	 * </ul>
	 * Unchanged paths:
	 * <ul>
	 * <li>platform:/plugin/<i>path</i> (plugin resource)</li>
	 * <li>pathmap:<i>path</i> (pathmap resource, e.g. UML2 profile)</li>
	 * </ul>
	 * 
	 * @param path
	 *            the path as created by the launchConfiguration
	 * @return the converted path
	 */
	public static String convertPath(String path) {
		if (path.startsWith("ext:")) { //$NON-NLS-1$
			return path.replaceFirst("ext:", "file:/"); //$NON-NLS-1$ //$NON-NLS-2$
		} else if (path.startsWith("uri:")) { //$NON-NLS-1$
			return path.substring(4);
		} else if (path.startsWith("#") || path.startsWith("platform:") || path.startsWith("pathmap")) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			return path;
		}
		return "platform:/resource" + path; //$NON-NLS-1$
	}

	private void setDerived(String filePath) {
		if (Platform.isRunning()) {
			try {
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(filePath));
				if (file.exists()) {
					file.setDerived(true);
				}
			} catch (IllegalStateException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			} catch (CoreException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
		}
	}

}
