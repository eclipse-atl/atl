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
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;


/**
 * Runs a model transformation in the EMFTVM.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class RunTask extends EMFTVMTask {

	private String module;
	private String modulePath;
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
		addMetamodelsToMap(getMetaModels(), env.getMetaModels());
		addModelsToMap(getInputModels(), env.getInputModels());
		addModelsToMap(getInoutModels(), env.getInoutModels());
		addOutModelsToMap(getOutputModels(), env.getOutputModels());
		final ModuleResolver resolver = new DefaultModuleResolver(getModulePath(), getResourceSet());
		final TimingData timingData = new TimingData();
		env.loadModule(resolver, getModule());
		timingData.finishLoading();
		env.run(timingData);
		timingData.finish();
		log(timingData.toString());
	}

	private void addModelsToMap(final Collection<? extends ModelElement> ms, final Map<String, Model> map) {
		for (ModelElement m : ms) {
			String name = m.getName();
			String as = m.getAs();
			if (as == null) {
				as = name;
			}
			map.put(as, getModel(name));
		}
	}

	private void addMetamodelsToMap(final Collection<? extends ModelElement> ms, final Map<String, Metamodel> map) {
		for (ModelElement m : ms) {
			String name = m.getName();
			String as = m.getAs();
			if (as == null) {
				as = name;
			}
			map.put(as, getMetamodel(name));
		}
	}

	private void addOutModelsToMap(final Collection<? extends OutModel> ms, final Map<String, Model> map) {
		for (OutModel m : ms) {
			String name = m.getName();
			String as = m.getAs();
			if (as == null) {
				as = name;
			}
			String wspath = m.getWspath();
			final ResourceSet rs = getResourceSet();
			final Resource r = rs.createResource(URI.createPlatformResourceURI(wspath, true));
			final Model model = EmftvmFactory.eINSTANCE.createModel();
			model.setResource(r);
			setModel(name, model);
			map.put(as, model);
		}
	}

}
