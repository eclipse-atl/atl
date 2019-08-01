/*******************************************************************************
 * Copyright (c) 2017 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dennis Wagelaar - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.launcher.compat;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.common.ATLLaunchConstants;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.core.service.CoreService;
import org.eclipse.m2m.atl.core.service.LauncherService;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Messages;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.EMFTVMUtil;
import org.eclipse.m2m.atl.emftvm.util.LazyCollections;
import org.eclipse.m2m.atl.emftvm.util.ModuleNotFoundException;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
import org.eclipse.m2m.atl.emftvm.util.VMException;
import org.eclipse.m2m.atl.emftvm.util.VMMonitor;

/**
 * The EMFVM implementation of the {@link ILauncher} interface.
 * 
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class EMFTVMLauncher implements ILauncher {

	/** The Default model factory name to use. */
	public static final String MODEL_FACTORY_NAME = "EMF"; //$NON-NLS-1$

	private static final String EMF_URI_PREFIX = "emftvm://"; //$NON-NLS-1$

	protected Map<String, IModel> models;

	protected Map<String, Module> libraries;

	protected ResourceSet moduleResourceSet;

	protected ModuleResolver moduleResolver;

	protected ExecEnv execEnv;

	protected ResourceSet outputResourceSet;

	protected TimingData timingData;

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return ATLLaunchConstants.EMFTVM_NAME;
	}

	/**
	 * Adds any model to the local map.
	 * 
	 * @param model
	 *            the {@link IModel}
	 * @param name
	 *            the model name
	 * @param referenceModelName
	 *            the model reference model name
	 * @return the EMFTVM {@link Model}
	 */
	protected Model addModel(IModel model, String name, String referenceModelName) {
		final Model emftvmModel;
		if (models.containsKey(name)) {
			ATLLogger.warning(Messages.getString("EMFTVMLauncher.MODEL_REGISTERED", name)); //$NON-NLS-1$
			emftvmModel = null;
		} else {
			models.put(name, model);
			final EMFModel emfModel = (EMFModel) model;
			final Resource resource = emfModel.getResource();
			if (resource == null) {
				final EMFInjector emfInjector;
				try {
					emfInjector = (EMFInjector) CoreService.getInjector(MODEL_FACTORY_NAME);
				} catch (ATLCoreException e) {
					throw new VMException(null, e.getLocalizedMessage(), e);
				}
				emfInjector.inject(emfModel, outputResourceSet.createResource(URI.createURI(name + ".xmi"))); //$NON-NLS-1$
			}
			emftvmModel = EmftvmFactory.eINSTANCE.createModel();
			emftvmModel.setResource(emfModel.getResource()); 
		}
		if (!models.containsKey(referenceModelName)) {
			models.put(referenceModelName, model.getReferenceModel());
			final Metamodel metamodel = EmftvmFactory.eINSTANCE.createMetamodel();
			metamodel.setResource(((EMFReferenceModel) model.getReferenceModel()).getResource());
			execEnv.registerMetaModel(referenceModelName, metamodel);
		}
		return emftvmModel;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#addInModel(org.eclipse.m2m.atl.core.IModel,
	 *      java.lang.String, java.lang.String)
	 */
	public void addInModel(IModel model, String name, String referenceModelName) {
		model.setIsTarget(false);
		final Model emftvmModel = addModel(model, name, referenceModelName);
		if (emftvmModel != null) {
			execEnv.registerInputModel(name, emftvmModel);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#addInOutModel(org.eclipse.m2m.atl.core.IModel,
	 *      java.lang.String, java.lang.String)
	 */
	public void addInOutModel(IModel model, String name, String referenceModelName) {
		model.setIsTarget(true);
		final Model emftvmModel = addModel(model, name, referenceModelName);
		if (emftvmModel != null) {
			execEnv.registerInOutModel(name, emftvmModel);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#addOutModel(org.eclipse.m2m.atl.core.IModel,
	 *      java.lang.String, java.lang.String)
	 */
	public void addOutModel(IModel model, String name, String referenceModelName) {
		model.setIsTarget(true);
		final Model emftvmModel = addModel(model, name, referenceModelName);
		if (emftvmModel != null) {
			execEnv.registerOutputModel(name, emftvmModel);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#addLibrary(java.lang.String,
	 *      java.lang.Object)
	 */
	public void addLibrary(String name, Object library) {
		if (libraries.containsKey(name)) {
			ATLLogger.warning(Messages.getString("EMFTVMLauncher.LIBRARY_REGISTERED", name)); //$NON-NLS-1$
		} else {
			libraries.put(name, getModuleFromObject(library));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#initialize(java.util.Map)
	 */
	public void initialize(Map<String, Object> parameters) {
		models = new HashMap<String, IModel>();
		libraries = new HashMap<String, Module>();
		moduleResourceSet = new ResourceSetImpl();
		moduleResolver = new DefaultModuleResolver(EMF_URI_PREFIX, moduleResourceSet);
		execEnv = EmftvmFactory.eINSTANCE.createExecEnv();
		outputResourceSet = new ResourceSetImpl();
		timingData = new TimingData();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#launch(java.lang.String,
	 *      org.eclipse.core.runtime.IProgressMonitor, java.util.Map,
	 *      java.lang.Object[])
	 */
	public Object launch(final String mode, final IProgressMonitor monitor, final Map<String, Object> options,
			final Object... modules) {
		return internalLaunch(null, monitor, options, modules);
	}

	/**
	 * Launches the transformation with preloaded modules.
	 * 
	 * @param tool
	 *            the execution tool
	 * @param monitor
	 *            the progression monitor
	 * @param options
	 *            the launching options
	 * @param modules
	 *            the transformation modules
	 * @return the execution result
	 */
	protected Object internalLaunch(final VMMonitor tool, final IProgressMonitor monitor,
			final Map<String, Object> options, Object... modules) {
		getModuleFromObject(modules[0]);
		for (int i = 1; i < modules.length; i++) {
			getModuleFromObject(modules[i]);
		}

		for (Model model : LazyCollections.asLazySet(execEnv.getInoutModels().values())
				.union(LazyCollections.asLazySet(execEnv.getOutputModels().values()))) {
			model.setAllowInterModelReferences(
					LauncherService.getBooleanOption(options.get("allowInterModelReferences"), false)); //$NON-NLS-1$
		}

		execEnv.setMonitor(tool);
		execEnv.setJitDisabled(LauncherService.getBooleanOption(options.get("jitDisabled"), false)); //$NON-NLS-1$
		timingData.finishLoading();
		
		final Object result = execEnv.run(timingData);

		timingData.finish();
		if (LauncherService.getBooleanOption(options.get("printExecutionTime"), false)) { //$NON-NLS-1$
			ATLLogger.info(timingData.toString());
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#loadModule(java.io.InputStream)
	 */
	public Module loadModule(final InputStream inputStream) {
		final Resource resource = moduleResourceSet
				.createResource(URI.createURI(UUID.randomUUID().toString() + DefaultModuleResolver.FILE_EXT));
		try {
			resource.load(inputStream, Collections.emptyMap());
			final Module module = findModule(resource);
			final Matcher matcher = EMFTVMUtil.DELIM_PATTERN.matcher(module.getName());
			final String path = matcher.replaceAll("/");
			resource.setURI(URI.createURI(EMF_URI_PREFIX + path + DefaultModuleResolver.FILE_EXT));
			execEnv.loadModule(moduleResolver, module.getName());
			return module;
		} catch (IOException e) {
			throw new VMException(null, e.getLocalizedMessage(), e);
		}
	}

	/**
	 * Load a module if necessary.
	 * 
	 * @param module
	 *            the given {@link Module} or {@link InputStream}.
	 * @return the {@link Module}
	 */
	protected Module getModuleFromObject(Object module) {
		if (module instanceof InputStream) {
			return loadModule((InputStream) module);
		} else if (module instanceof Module) {
			return (Module) module;
		}
		return null;
	}

	/**
	 * Finds the first module in {@link Resource}
	 * 
	 * <pre>
	 * r
	 * </pre>
	 * 
	 * .
	 * 
	 * @param r
	 * @return the module with the given name inside
	 * 
	 *         <pre>
	 *         r
	 *         </pre>
	 * 
	 *         , or <code>null</code>
	 */
	private Module findModule(final Resource r) throws ModuleNotFoundException {
		for (EObject o : r.getContents()) {
			if (o instanceof Module) {
				return (Module) o;
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#getModel(java.lang.String)
	 */
	public IModel getModel(String modelName) {
		return models.get(modelName);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#getLibrary(java.lang.String)
	 */
	public Object getLibrary(String libraryName) {
		return libraries.get(libraryName);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#getDefaultModelFactoryName()
	 */
	public String getDefaultModelFactoryName() {
		return MODEL_FACTORY_NAME;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#getModes()
	 */
	public String[] getModes() {
		return new String[] { RUN_MODE };
	}
}
