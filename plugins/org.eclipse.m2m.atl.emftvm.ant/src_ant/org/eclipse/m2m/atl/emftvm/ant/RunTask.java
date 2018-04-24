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
package org.eclipse.m2m.atl.emftvm.ant;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.tools.ant.Project;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;


/**
 * Runs a model transformation in the EMFTVM.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class RunTask extends EMFTVMTask {

	private String module;
	private String modulePath;
	private boolean disableJIT;
	private final List<MetaModel> metaModels = new ArrayList<MetaModel>();
	private final List<InModel> inputModels = new ArrayList<InModel>();
	private final List<InOutModel> inoutModels = new ArrayList<InOutModel>();
	private final List<OutModel> outputModels = new ArrayList<OutModel>();

	/**
	 * Sets the module name.
	 * @param module the module to set
	 */
	public void setModule(String module) {
		this.module = module;
	}

	/**
	 * Returns the module name.
	 * @return the module
	 */
	public String getModule() {
		return module;
	}

	/**
	 * Sets the module path.
	 * @param modulePath the modulePath to set
	 */
	public void setModulePath(String modulePath) {
		this.modulePath = modulePath;
	}

	/**
	 * Returns the module path.
	 * @return the modulePath
	 */
	public String getModulePath() {
		return modulePath;
	}

	/**
	 * Returns whether to disable the JIT compiler.
	 * @return whether to disable the JIT compiler
	 */
	public boolean isDisableJIT() {
		return disableJIT;
	}

	/**
	 * Sets whether to disable the JIT compiler
	 * @param disableJIT whether to disable the JIT compiler
	 */
	public void setDisableJIT(boolean disableJIT) {
		this.disableJIT = disableJIT;
	}

	/**
	 * Returns the list of metamodels.
	 * @return the metaModels
	 */
	public List<MetaModel> getMetaModels() {
		return metaModels;
	}

	/**
	 * Returns the list of input models.
	 * @return the inputModels
	 */
	public List<InModel> getInputModels() {
		return inputModels;
	}

	/**
	 * Returns the list of in/out models.
	 * @return the inoutModels
	 */
	public List<InOutModel> getInoutModels() {
		return inoutModels;
	}

	/**
	 * Returns the list of output models.
	 * @return the outputModels
	 */
	public List<OutModel> getOutputModels() {
		return outputModels;
	}

	/**
	 * Adds metamodel to the run task.
	 * @param metamodel the metamodel
	 */
	public void addConfiguredMetamodel(MetaModel metamodel) {
		getMetaModels().add(metamodel);
	}

	/**
	 * Adds model as input model to the run task.
	 * @param model the input model
	 */
	public void addConfiguredInputModel(InModel model) {
		getInputModels().add(model);
	}

	/**
	 * Adds model as input/output model to the run task.
	 * @param model the in/out model
	 */
	public void addConfiguredInoutModel(InOutModel model) {
		getInoutModels().add(model);
	}

	/**
	 * Adds model as output model to the run task.
	 * @param model the output model
	 */
	public void addConfiguredOutputModel(OutModel model) {
		getOutputModels().add(model);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void innerExecute() throws Exception {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		env.setJitDisabled(isDisableJIT());
		addMetamodelsToEnv(env);
		addInputModelsToEnv(env);
		addInoutModelsToEnv(env);
		addOutputModelsToEnv(env);
		final StringTokenizer pathElements = new StringTokenizer(getModulePath(), ",");
		final DefaultModuleResolver resolver = new DefaultModuleResolver(pathElements.nextToken().replace('\\', '/'),
				getResourceSet());
		while (pathElements.hasMoreTokens()) {
			resolver.addUriPrefix(pathElements.nextToken().replace('\\', '/'));
		}
		final TimingData timingData = new TimingData();
		env.loadModule(resolver, getModule());
		timingData.finishLoading();
		env.run(timingData);
		timingData.finish();
		log(timingData.toString());
	}

	/**
	 * Returns the {@link Model} for <code>me</code>.
	 * @param me the {@link ModelElement} task parameter
	 * @return the {@link Model}
	 */
	private Model getModel(final ModelElement me) {
		final Model model = getModel(me.getName());
		if (model != null) {
			model.setAllowInterModelReferences(me.isAllowInterModelReferences());
		}
		return model;
	}

	/**
	 * Returns the {@link Metamodel} for <code>me</code>.
	 * @param mm the {@link MetaModel} task parameter
	 * @return the {@link Metamodel}
	 */
	private Metamodel getMetamodel(final MetaModel mm) {
		return getMetamodel(mm.getName());
	}

	/**
	 * Returns the model name key to use in the {@link ExecEnv} for <code>me</code>.
	 * @param me the {@link ModelElement} task parameter
	 * @return the model name key
	 */
	private String getModelKey(final ModelElement me) {
		String as = me.getAs();
		if (as == null) {
			as = me.getName();
		}
		return as;
	}

	private void addInputModelsToEnv(final ExecEnv env) {
		for (final ModelElement me : getInputModels()) {
			env.registerInputModel(getModelKey(me), getModel(me));
		}
	}

	private void addInoutModelsToEnv(final ExecEnv env) {
		final ResourceSet rs = getResourceSet();
		for (final InOutModel m : getInoutModels()) {
			Model model = getModel(m);
			if (model == null) {
				// Create new in/out model
				final String u = m.getUri();
				final URI uri = u == null ? URI.createPlatformResourceURI(m.getWspath(), true) : URI.createURI(u);
				final Resource r = rs.createResource(uri);
				model = EmftvmFactory.eINSTANCE.createModel();
				model.setResource(r);
				model.setAllowInterModelReferences(m.isAllowInterModelReferences());
				setModel(m.getName(), model);
			} else {
				// Use existing in/out model, but override URI if given
				final String u = m.getUri();
				URI uri = null;
				if (u != null) {
					uri = URI.createURI(u);
				}
				final String wsp = m.getWspath();
				if (wsp != null) {
					uri = URI.createPlatformResourceURI(wsp, true);
				}
				if (uri != null) {
					getProject().log(this, String.format("Changing the URI of in/out model '%s' before executing a transformation will break inter-model references ('%s' -> '%s')", m.getName(), model.getResource().getURI(), uri), Project.MSG_WARN);
					model.getResource().setURI(uri);
				}
			}
			env.registerInOutModel(getModelKey(m), model);
		}
	}

	private void addOutputModelsToEnv(final ExecEnv env) {
		final ResourceSet rs = getResourceSet();
		for (final OutModel m : getOutputModels()) {
			final String u = m.getUri();
			final URI uri = u == null ? URI.createPlatformResourceURI(m.getWspath(), true) : URI.createURI(u);
			final Resource r = rs.createResource(uri);
			final Model model = EmftvmFactory.eINSTANCE.createModel();
			model.setResource(r);
			model.setAllowInterModelReferences(m.isAllowInterModelReferences());
			setModel(m.getName(), model);
			env.registerOutputModel(getModelKey(m), model);
		}
	}

	private void addMetamodelsToEnv(final ExecEnv env) {
		for (final MetaModel m : getMetaModels()) {
			env.registerMetaModel(getModelKey(m), getMetamodel(m));
		}
	}

}
