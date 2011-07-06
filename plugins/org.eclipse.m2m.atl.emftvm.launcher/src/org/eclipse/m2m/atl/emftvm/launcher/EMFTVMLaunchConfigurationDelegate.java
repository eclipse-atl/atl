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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
import org.eclipse.m2m.atl.emftvm.util.VMException;


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
	@SuppressWarnings("unchecked")
	public void launch(final ILaunchConfiguration configuration, final String mode,
			final ILaunch launch, final IProgressMonitor monitor) throws CoreException {
		AtlUIPlugin.getDefault(); // force ATL console startup
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();
		
		final Map<String, String> metamodelLocations = configuration.getAttribute(EMFTVMLaunchConstants.METAMODELS, Collections.emptyMap());
		final Map<String, String> metamodelOptions = configuration.getAttribute(EMFTVMLaunchConstants.METAMODEL_OPTIONS, Collections.emptyMap());
		loadFileMetaModels(rs, metamodelLocations, metamodelOptions, env.getMetaModels());
		
		final Map<String, String> inputModelLocations = configuration.getAttribute(EMFTVMLaunchConstants.INPUT_MODELS, Collections.emptyMap());
		final Map<String, String> inputModelOptions = configuration.getAttribute(EMFTVMLaunchConstants.INPUT_MODEL_OPTIONS, Collections.emptyMap());
		loadModels(rs, inputModelLocations, inputModelOptions, env.getInputModels());
		
		final Map<String, String> inoutModelLocations = configuration.getAttribute(EMFTVMLaunchConstants.INOUT_MODELS, Collections.emptyMap());
		final Map<String, String> inoutModelOptions = configuration.getAttribute(EMFTVMLaunchConstants.INOUT_MODEL_OPTIONS, Collections.emptyMap());
		loadModels(rs, inoutModelLocations, inoutModelOptions, env.getInoutModels());
		
		final Map<String, String> outputModelLocations = configuration.getAttribute(EMFTVMLaunchConstants.OUTPUT_MODELS, Collections.emptyMap());
		final Map<String, String> outputModelOptions = configuration.getAttribute(EMFTVMLaunchConstants.OUTPUT_MODEL_OPTIONS, Collections.emptyMap());
		createModels(rs, outputModelLocations, outputModelOptions, env.getOutputModels());
		
		loadOtherMetaModels(rs, metamodelLocations, metamodelOptions, env.getMetaModels());
		
		final String wspath = configuration.getAttribute(EMFTVMLaunchConstants.MODULE_FILE_NAME, "");
		final int index = wspath.lastIndexOf('/');
		final String wsfolder = wspath.substring(0, index + 1);
		final String name = wspath.substring(index + 1, wspath.lastIndexOf('.')); // strip file extension
		final ModuleResolver resolver = new DefaultModuleResolver(
				(wsfolder.startsWith("/") ? "platform:/resource" : "platform:/resource/") + wsfolder, 
				new ResourceSetImpl());

		try {
			final TimingData timingData = new TimingData();
			env.loadModule(resolver, name);
			timingData.finishLoading();
			env.run(timingData);
			timingData.finish();
			if (configuration.getAttribute(EMFTVMLaunchConstants.DISPLAY_TIMING, true)) {
				ATLLogger.info(timingData.toString());
			}
			saveModels(env.getInoutModels(), inoutModelOptions);
			saveModels(env.getOutputModels(), outputModelOptions);
		} catch (VMException e) {
			ATLLogger.severe(e.toString());
		} catch (IOException e) {
			ATLLogger.severe(e.toString());
		}
	}
	
	/**
	 * Loads all metamodels that have a file or platform URI from <code>modelLocations</code> into <code>models</code>.
	 * @param rs the resource set to use
	 * @param modelLocations the input map of model names to locations
	 * @param modelOptions map of additional model options
	 * @param models the map of model names to loaded models to write to
	 */
	private void loadFileMetaModels(final ResourceSet rs, final Map<String, String> modelLocations, 
			final Map<String, String> modelOptions,
			final Map<String, Metamodel> models) {
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
				models.put((String)entry.getKey(), m);
			}
		}
	}
	
	/**
	 * Loads all metamodels that don't have a file or platform URI from <code>modelLocations</code> into <code>models</code>.
	 * @param rs the resource set to use
	 * @param modelLocations the input map of model names to locations
	 * @param modelOptions map of additional model options
	 * @param models the map of model names to loaded models to write to
	 */
	private void loadOtherMetaModels(final ResourceSet rs, final Map<String, String> modelLocations, 
			final Map<String, String> modelOptions,
			final Map<String, Metamodel> models) {
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
				models.put((String)entry.getKey(), m);
			}
		}
	}
	
	/**
	 * Loads all models from <code>modelLocations</code> into <code>models</code>.
	 * @param rs the resource set to use
	 * @param modelLocations the input map of model names to locations
	 * @param modelOptions map of additional model options
	 * @param models the map of model names to loaded models to write to
	 */
	private void loadModels(final ResourceSet rs, final Map<String, String> modelLocations,
			final Map<String, String> modelOptions,
			final Map<String, Model> models) {
		for (Entry<String, String> entry : modelLocations.entrySet()) {
			Resource r;
			if (getBoolOption(
					modelOptions, 
					entry.getKey(), 
					EMFTVMLaunchConstants.OPT_CREATE_NEW_MODEL)) {
				r = rs.createResource(URI.createURI(entry.getValue()));
			} else {
				r = rs.getResource(URI.createURI(entry.getValue()), true);
			}
			Model m = EmftvmFactory.eINSTANCE.createModel();
			m.setResource(r);
			m.setAllowInterModelReferences(getBoolOption(
					modelOptions, 
					entry.getKey(), 
					EMFTVMLaunchConstants.OPT_ALLOW_INTER_MODEL_REFERENCES));
			models.put(entry.getKey(), m);
		}
	}
	
	/**
	 * Creates new models for all models from <code>modelLocations</code> in <code>models</code>.
	 * @param rs the resource set to use
	 * @param modelLocations the input map of model names to locations
	 * @param modelOptions map of additional model options
	 * @param models the map of model names to loaded models to write to
	 */
	private void createModels(final ResourceSet rs, final Map<String, String> modelLocations, 
			final Map<String, String> modelOptions,
			final Map<String, Model> models) {
		for (Entry<String, String> entry : modelLocations.entrySet()) {
			Resource r = rs.createResource(URI.createURI(entry.getValue()));
			Model m = EmftvmFactory.eINSTANCE.createModel();
			m.setResource(r);
			m.setAllowInterModelReferences(getBoolOption(
					modelOptions, 
					entry.getKey(), 
					EMFTVMLaunchConstants.OPT_ALLOW_INTER_MODEL_REFERENCES));
			models.put(entry.getKey(), m);
		}
	}

	/**
	 * Saves <code>models</code> to file.
	 * @param models
	 * @param modelOptions map of additional model options
	 * @throws IOException 
	 * @throws CoreException 
	 */
	@SuppressWarnings("deprecation")
	private void saveModels(final Map<String, Model> models, 
			final Map<String, String> modelOptions) throws IOException, CoreException {
		final IWorkspaceRoot wr = ResourcesPlugin.getWorkspace().getRoot();
		for (Entry<String, Model> model : models.entrySet()) {
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
	
}
