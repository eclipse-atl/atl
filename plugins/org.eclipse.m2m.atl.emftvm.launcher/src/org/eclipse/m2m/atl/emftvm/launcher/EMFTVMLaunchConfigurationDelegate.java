/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.launcher;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.common.ATLLaunchConstants;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.core.ui.ATLConsole;
import org.eclipse.m2m.atl.debug.core.AtlDebugTarget;
import org.eclipse.m2m.atl.debug.core.AtlRunTarget;
import org.eclipse.m2m.atl.debug.core.AtlSourceLocator;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.launcher.debug.NetworkDebugger;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
import org.eclipse.m2m.atl.emftvm.util.VMException;
import org.eclipse.m2m.atl.emftvm.util.VMMonitor;


/**
 * Launches EMFTVM transformation modules.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class EMFTVMLaunchConfigurationDelegate implements
		ILaunchConfigurationDelegate {

	/**
	 * Creates a new {@link EMFTVMLaunchConfigurationDelegate}.
	 */
	public EMFTVMLaunchConfigurationDelegate() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	public void launch(final ILaunchConfiguration configuration, final String mode,
			final ILaunch launch, final IProgressMonitor monitor) throws CoreException {
		ATLConsole.findConsole(); // force ATL console startup
		final IDebugTarget target;
		launch.setSourceLocator(new AtlSourceLocator());

		if (ILaunchManager.DEBUG_MODE.equals(mode)) {
			target = new AtlDebugTarget(launch);
			((AtlDebugTarget)target).setStopInMain(true);
		} else {
			target = new AtlRunTarget(launch);
		}

		final Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					try {
						internalLaunch(configuration, mode, launch, monitor);
					} catch (CoreException e) {
						EmftvmLauncherPlugin.log(e.getStatus());
					} catch (VMException e) {
						ATLLogger.severe(e.toString());
					} catch (Exception e) {
						ATLLogger.severe(e.toString());
						EmftvmLauncherPlugin.log(e);
					} catch (AssertionError e) {
						ATLLogger.severe(e.toString());
						EmftvmLauncherPlugin.log(e);
					} finally {
						target.terminate();
					}
				} catch (CoreException e) {
					EmftvmLauncherPlugin.log(e.getStatus());
				}
			}
		};
		thread.start();

		if (target instanceof AtlDebugTarget) {
			((AtlDebugTarget)target).start();
		}
		launch.addDebugTarget(target);
		monitor.done();
	}
	
	@SuppressWarnings("unchecked")
	private void internalLaunch(final ILaunchConfiguration configuration, final String mode,
			final ILaunch launch, final IProgressMonitor monitor) throws CoreException, IOException {
		ATLConsole.findConsole(); // force ATL console startup

		final VMMonitor vmmon; // Create monitor/debugger before any exceptions can be thrown
		if (ILaunchManager.DEBUG_MODE.equals(mode)) {
			vmmon = new NetworkDebugger(launch, getPort(launch), true);
		} else {
			vmmon = new LaunchAdapter(launch);
		}

		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		env.setJitDisabled(configuration.getAttribute(EMFTVMLaunchConstants.DISABLE_JIT, false));
		env.setMonitor(vmmon);
		final ResourceSet rs = new ResourceSetImpl();
		
		final Map<String, String> metamodelLocations = configuration.getAttribute(EMFTVMLaunchConstants.METAMODELS, Collections.emptyMap());
		final Map<String, String> metamodelOptions = configuration.getAttribute(EMFTVMLaunchConstants.METAMODEL_OPTIONS, Collections.emptyMap());
		loadFileMetaModels(rs, metamodelLocations, metamodelOptions, env);
		
		final Map<String, String> inputModelLocations = configuration.getAttribute(EMFTVMLaunchConstants.INPUT_MODELS, Collections.emptyMap());
		final Map<String, String> inputModelOptions = configuration.getAttribute(EMFTVMLaunchConstants.INPUT_MODEL_OPTIONS, Collections.emptyMap());
		loadInputModels(rs, inputModelLocations, inputModelOptions, env);
		
		final Map<String, String> inoutModelLocations = configuration.getAttribute(EMFTVMLaunchConstants.INOUT_MODELS, Collections.emptyMap());
		final Map<String, String> inoutModelOutLocations = configuration.getAttribute(EMFTVMLaunchConstants.INOUT_OUT_MODELS, Collections.emptyMap());
		final Map<String, String> inoutModelOptions = configuration.getAttribute(EMFTVMLaunchConstants.INOUT_MODEL_OPTIONS, Collections.emptyMap());
		loadInOutModels(rs, inoutModelLocations, inoutModelOptions, env);
		
		final Map<String, String> outputModelLocations = configuration.getAttribute(EMFTVMLaunchConstants.OUTPUT_MODELS, Collections.emptyMap());
		final Map<String, String> outputModelOptions = configuration.getAttribute(EMFTVMLaunchConstants.OUTPUT_MODEL_OPTIONS, Collections.emptyMap());
		createOutputModels(rs, outputModelLocations, outputModelOptions, env);

		loadOtherMetaModels(rs, metamodelLocations, metamodelOptions, env);

		String name = configuration.getAttribute(EMFTVMLaunchConstants.MODULE_NAME, "");
		String path = configuration.getAttribute(EMFTVMLaunchConstants.MODULE_PATH, "");
		final String oldPath = configuration.getAttribute(EMFTVMLaunchConstants.MODULE_FILE_NAME, "");
		if ((name.equals("") || path.equals("")) && !oldPath.equals("")) {
			// convert legacy path to new path and module name
			final int index = oldPath.lastIndexOf('/') + 1;
			path = oldPath.substring(0, index);
			final int dotIndex = oldPath.lastIndexOf('.');
			name = dotIndex < 0 ? oldPath.substring(index) : oldPath.substring(index, dotIndex); // strip file extension
		}
		final ModuleResolver resolver = createModuleResolver(path);

		final TimingData timingData = new TimingData();
		env.loadModule(resolver, name);
		timingData.finishLoading();
		env.run(timingData);
		timingData.finish();
		if (configuration.getAttribute(EMFTVMLaunchConstants.DISPLAY_TIMING, true)) {
			ATLLogger.info(timingData.toString());
		}
		if (ILaunchManager.DEBUG_MODE.equals(mode)) {
			ATLLogger.info(vmmon.toString()); // display debugger statistics
		}
		saveModels(env.getInoutModels(), inoutModelOptions, inoutModelOutLocations);
		final Map<String, String> emptyMap = Collections.emptyMap();
		saveModels(env.getOutputModels(), outputModelOptions, emptyMap);
	}
	
	/**
	 * Loads all metamodels that have a file or platform URI from <code>modelLocations</code> into <code>env</code>.
	 * @param rs the resource set to use
	 * @param modelLocations the input map of model names to locations
	 * @param modelOptions map of additional model options
	 * @param env the {@link ExecEnv} to register the metamodels in
	 */
	private void loadFileMetaModels(final ResourceSet rs, final Map<String, String> modelLocations, 
			final Map<String, String> modelOptions,
			final ExecEnv env) {
		for (Entry<String, String> entry : modelLocations.entrySet()) {
			URI uri = URI.createURI((String)entry.getValue());
			if (uri.isFile() || uri.isPlatform()) {
				Resource r;
				if (getBoolOption(modelOptions, entry.getKey(), EMFTVMLaunchConstants.OPT_IS_METAMETAMODEL)) {
					r = EcorePackage.eINSTANCE.eResource();
				} else {
					r = rs.getResource(uri, true);
				}
				Metamodel m = EmftvmFactory.eINSTANCE.createMetamodel();
				m.setResource(r);
				env.registerMetaModel((String)entry.getKey(), m);
			}
		}
	}
	
	/**
	 * Loads all metamodels that don't have a file or platform URI from <code>modelLocations</code> into <code>env</code>.
	 * @param rs the resource set to use
	 * @param modelLocations the input map of model names to locations
	 * @param modelOptions map of additional model options
	 * @param env the {@link ExecEnv} to register the metamodels in
	 */
	private void loadOtherMetaModels(final ResourceSet rs, final Map<String, String> modelLocations, 
			final Map<String, String> modelOptions,
			final ExecEnv env) {
		for (Entry<String, String> entry : modelLocations.entrySet()) {
			URI uri = URI.createURI((String)entry.getValue());
			if (!uri.isFile() && !uri.isPlatform()) {
				Resource r;
				if (getBoolOption(modelOptions, entry.getKey(), EMFTVMLaunchConstants.OPT_IS_METAMETAMODEL)) {
					r = EcorePackage.eINSTANCE.eResource();
				} else {
					r = rs.getResource(uri, true);
				}
				Metamodel m = EmftvmFactory.eINSTANCE.createMetamodel();
				m.setResource(r);
				env.registerMetaModel((String)entry.getKey(), m);
			}
		}
	}

	/**
	 * Creates and loads a {@link Model} for the given <code>entry</code>.
	 * @param rs the {@link ResourceSet} to load the model into
	 * @param entry the model name and URI to load
	 * @param modelOptions the map of model options
	 * @return the loaded {@link Model}
	 */
	private Model loadModel(final ResourceSet rs, final Entry<String, String> entry, 
			final Map<String, String> modelOptions) {
		final Resource r;
		if (getBoolOption(
				modelOptions, 
				entry.getKey(), 
				EMFTVMLaunchConstants.OPT_CREATE_NEW_MODEL)) {
			r = rs.createResource(URI.createURI(entry.getValue()));
		} else {
			r = rs.getResource(URI.createURI(entry.getValue()), true);
		}
		final Model m = EmftvmFactory.eINSTANCE.createModel();
		m.setResource(r);
		m.setAllowInterModelReferences(getBoolOption(
				modelOptions, 
				entry.getKey(), 
				EMFTVMLaunchConstants.OPT_ALLOW_INTER_MODEL_REFERENCES));
		return m;
	}
	
	/**
	 * Loads all models from <code>modelLocations</code> into <code>env</code>.
	 * @param rs the resource set to use
	 * @param modelLocations the input map of model names to locations
	 * @param modelOptions map of additional model options
	 * @param env the {@link ExecEnv} to register the models in
	 */
	private void loadInputModels(final ResourceSet rs, final Map<String, String> modelLocations,
			final Map<String, String> modelOptions,
			final ExecEnv env) {
		for (Entry<String, String> entry : modelLocations.entrySet()) {
			env.registerInputModel(entry.getKey(), loadModel(rs, entry, modelOptions));
		}
	}
	
	/**
	 * Loads all models from <code>modelLocations</code> into <code>env</code>.
	 * @param rs the resource set to use
	 * @param modelLocations the input map of model names to locations
	 * @param modelOptions map of additional model options
	 * @param env the {@link ExecEnv} to register the models in
	 */
	private void loadInOutModels(final ResourceSet rs, final Map<String, String> modelLocations,
			final Map<String, String> modelOptions,
			final ExecEnv env) {
		for (Entry<String, String> entry : modelLocations.entrySet()) {
			env.registerInOutModel(entry.getKey(), loadModel(rs, entry, modelOptions));
		}
	}
	
	/**
	 * Creates new models for all models from <code>modelLocations</code> in <code>env</code>.
	 * @param rs the resource set to use
	 * @param modelLocations the input map of model names to locations
	 * @param modelOptions map of additional model options
	 * @param env the {@link ExecEnv} to register the models in
	 */
	private void createOutputModels(final ResourceSet rs, final Map<String, String> modelLocations, 
			final Map<String, String> modelOptions,
			final ExecEnv env) {
		for (Entry<String, String> entry : modelLocations.entrySet()) {
			Resource r = rs.createResource(URI.createURI(entry.getValue()));
			Model m = EmftvmFactory.eINSTANCE.createModel();
			m.setResource(r);
			m.setAllowInterModelReferences(getBoolOption(
					modelOptions, 
					entry.getKey(), 
					EMFTVMLaunchConstants.OPT_ALLOW_INTER_MODEL_REFERENCES));
			env.registerOutputModel(entry.getKey(), m);
		}
	}

	/**
	 * Saves <code>models</code> to file.
	 * @param models
	 * @param modelOptions map of additional model options
	 * @param modelLocations map of alternative model output locations
	 * @throws IOException 
	 * @throws CoreException 
	 */
	@SuppressWarnings("deprecation")
	private void saveModels(final Map<String, Model> models, 
			final Map<String, String> modelOptions,
			final Map<String, String> modelLocations) throws IOException, CoreException {
		final IWorkspaceRoot wr = ResourcesPlugin.getWorkspace().getRoot();
		for (Entry<String, Model> model : models.entrySet()) {
			if (modelLocations.containsKey(model.getKey())) {
				model.getValue().getResource().setURI(URI.createURI(modelLocations.get(model.getKey())));
			}
			model.getValue().getResource().save(Collections.emptyMap());
			URI uri = model.getValue().getResource().getURI();
			if (uri.isPlatformResource()) {
				IResource r = wr.findMember(uri.toPlatformString(true));
				if (r instanceof IFile && getBoolOption(
							modelOptions, 
							model.getKey(), 
							EMFTVMLaunchConstants.OPT_DERIVED_FILE)) {
					((IFile)r).setDerived(true);
				}
			}
		}
	}

	/**
	 * Retrieves the boolean value of <code>option</code> for <code>modelName</code> from <code>modelOptions</code>.
	 * @param modelOptions the model options map
	 * @param modelName the model name
	 * @param option the option to retrieve
	 * @return the option value
	 */
	public static boolean getBoolOption(final Map<String, String> modelOptions,
			final String modelName, final String option) {
		final String options = modelOptions.get(modelName);
		if (options == null) {
			return false;
		}
		return options.contains(option);
	}

	/**
	 * Sets the boolean value of <code>option</code> for <code>modelName</code> from <code>modelOptions</code>.
	 * @param modelOptions the model options map
	 * @param modelName the model name
	 * @param option the option to set
	 */
	public static void setBoolOption(final Map<String, String> modelOptions,
			final String modelName, final String option) {
		final String options = modelOptions.get(modelName);
		if (options == null) {
			modelOptions.put(modelName, option);
		} else if (!options.contains(option)) {
			modelOptions.put(modelName, (options + ' ' + option).trim());
		}
	}
	
	/**
	 * Unsets the boolean value of <code>option</code> for <code>modelName</code> from <code>modelOptions</code>.
	 * @param modelOptions the model options map
	 * @param modelName the model name
	 * @param option the option to unset
	 */
	public static void unsetBoolOption(final Map<String, String> modelOptions,
			final String modelName, final String option) {
		final String options = modelOptions.get(modelName);
		if (options != null && options.contains(option)) {
			modelOptions.put(modelName, options.replace(option, "").trim());
		}
	}

	/**
	 * Returns the {@link NetworkDebugger} port.
	 * @param launch the launch object
	 * @return the {@link NetworkDebugger} port.
	 * @throws CoreException
	 */
	public static int getPort(ILaunch launch) throws CoreException {
		String portOption = ""; //$NON-NLS-1$
		if (launch != null) {
			portOption = launch.getLaunchConfiguration().getAttribute(ATLLaunchConstants.PORT,
					String.valueOf(ATLLaunchConstants.DEFAULT_PORT));
		}
		return portOption.equals("") ? ATLLaunchConstants.DEFAULT_PORT : Integer.parseInt(portOption); //$NON-NLS-1$
	}

	/**
	 * Creates a {@link ModuleResolver} using the comma-separated module <code>path</code>.
	 * @param path the module path
	 * @return the {@link ModuleResolver}.
	 */
	public static ModuleResolver createModuleResolver(final String path) {
		final StringTokenizer pathElements = new StringTokenizer(path, ",");
		final DefaultModuleResolver resolver = new DefaultModuleResolver(
				"platform:/resource/" + pathElements.nextToken(), new ResourceSetImpl());
		while (pathElements.hasMoreTokens()) {
			resolver.addUriPrefix("platform:/resource/" + pathElements.nextToken());
		}
		return resolver;
	}
	
}
