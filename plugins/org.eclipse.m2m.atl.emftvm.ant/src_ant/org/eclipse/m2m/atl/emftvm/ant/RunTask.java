/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * Copyright (c) 2021 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.ant;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.util.StringUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.TimingData;

/**
 * Runs a model transformation in the EMFTVM.
 *
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class RunTask extends EMFTVMTask {

	private static final Pattern FILE_EXT = Pattern.compile("\\.\\w+$");

	private static String getBaseName(final org.apache.tools.ant.types.Resource resource) {
		return FILE_EXT.matcher(resource.getName()).replaceAll("");
	}

	private static String generateFilename(final List<String> inputFileNames, String suffix) {
		if (StringUtils.trimToNull(suffix) == null) {
			return StringUtils.join(inputFileNames, "-");
		} else {
			return StringUtils.join(inputFileNames, "-").concat(suffix);
		}
	}

	private String module;
	private String modulePath;
	private boolean disableJIT;
	private final List<MetaModel> metaModels = new ArrayList<MetaModel>();
	private final List<InModel> inputModels = new ArrayList<InModel>();
	private final List<InOutModel> inoutModels = new ArrayList<InOutModel>();
	private final List<OutModel> outputModels = new ArrayList<OutModel>();
	private final List<InModelSet> inputModelSets = new ArrayList<InModelSet>();
	private final List<InOutModelSet> inoutModelSets = new ArrayList<InOutModelSet>();
	private final List<OutModelSet> outputModelSets = new ArrayList<OutModelSet>();

	/**
	 * Sets the module name.
	 *
	 * @param module the module to set
	 */
	public void setModule(String module) {
		this.module = module;
	}

	/**
	 * Returns the module name.
	 *
	 * @return the module
	 */
	public String getModule() {
		return module;
	}

	/**
	 * Sets the module path.
	 *
	 * @param modulePath the modulePath to set
	 */
	public void setModulePath(String modulePath) {
		this.modulePath = modulePath;
	}

	/**
	 * Returns the module path.
	 *
	 * @return the modulePath
	 */
	public String getModulePath() {
		return modulePath;
	}

	/**
	 * Returns whether to disable the JIT compiler.
	 *
	 * @return whether to disable the JIT compiler
	 */
	public boolean isDisableJIT() {
		return disableJIT;
	}

	/**
	 * Sets whether to disable the JIT compiler
	 *
	 * @param disableJIT whether to disable the JIT compiler
	 */
	public void setDisableJIT(boolean disableJIT) {
		this.disableJIT = disableJIT;
	}

	/**
	 * Returns the list of metamodels.
	 *
	 * @return the metaModels
	 */
	public List<MetaModel> getMetaModels() {
		return metaModels;
	}

	/**
	 * Returns the list of input models.
	 *
	 * @return the inputModels
	 */
	public List<InModel> getInputModels() {
		return inputModels;
	}

	/**
	 * Returns the list of in/out models.
	 *
	 * @return the inoutModels
	 */
	public List<InOutModel> getInoutModels() {
		return inoutModels;
	}

	/**
	 * Returns the list of output models.
	 *
	 * @return the outputModels
	 */
	public List<OutModel> getOutputModels() {
		return outputModels;
	}

	/**
	 * Returns the list of input model sets.
	 *
	 * @return the inModelSets
	 */
	public List<InModelSet> getInputModelSets() {
		return inputModelSets;
	}

	/**
	 * Returns the list of input/output model sets.
	 *
	 * @return the inOutModelSets
	 */
	public List<InOutModelSet> getInoutModelSets() {
		return inoutModelSets;
	}

	/**
	 * Returns the list of output model sets.
	 *
	 * @return the outModelSets
	 */
	public List<OutModelSet> getOutputModelSets() {
		return outputModelSets;
	}

	/**
	 * Adds metamodel to the run task.
	 *
	 * @param metamodel the metamodel
	 */
	public void addConfiguredMetamodel(MetaModel metamodel) {
		getMetaModels().add(metamodel);
	}

	/**
	 * Adds model as input model to the run task.
	 *
	 * @param model the input model
	 */
	public void addConfiguredInputModel(InModel model) {
		getInputModels().add(model);
	}

	/**
	 * Adds model as input/output model to the run task.
	 *
	 * @param model the in/out model
	 */
	public void addConfiguredInoutModel(InOutModel model) {
		getInoutModels().add(model);
	}

	/**
	 * Adds model as output model to the run task.
	 *
	 * @param model the output model
	 */
	public void addConfiguredOutputModel(OutModel model) {
		getOutputModels().add(model);
	}

	/**
	 * Adds model set as input model set to the run task.
	 *
	 * @param modelSet the input model set
	 */
	public void addConfiguredInputModelSet(InModelSet modelSet) {
		getInputModelSets().add(modelSet);
	}

	/**
	 * Adds model as input/output model to the run task.
	 *
	 * @param modelSet the in/out model set
	 */
	public void addConfiguredInoutModelSet(InOutModelSet modelSet) {
		getInoutModelSets().add(modelSet);
	}

	/**
	 * Adds model as output model to the run task.
	 *
	 * @param modelSet the output model set
	 */
	public void addConfiguredOutputModelSet(OutModelSet modelSet) {
		getOutputModelSets().add(modelSet);
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

		runForInputModelSet(env, timingData, getInputModelSets().iterator(), new LazyList<String>());

		timingData.finish();
		log(timingData.toString());
	}

	private void runForInputModelSet(final ExecEnv env, final TimingData timingData,
			final Iterator<InModelSet> inModelSets, final LazyList<String> inputFileNames) {
		if (inModelSets.hasNext()) {
			final ModelElementSet modelSet = inModelSets.next();
			for (final org.apache.tools.ant.types.Resource modelResource : modelSet) {
				if (!modelResource.isDirectory()) {
					final Model model = loadFromResource(modelSet.getDir(), modelResource);
					env.registerInputModel(getModelKey(modelSet), model);
					runForInputModelSet(env, timingData, inModelSets,
							inputFileNames.append(getBaseName(modelResource)));
				}
			}
		} else {
			runForInOutModelSet(env, timingData, getInoutModelSets().iterator(), inputFileNames);
		}
	}

	private void runForInOutModelSet(final ExecEnv env, final TimingData timingData,
			final Iterator<InOutModelSet> inOutModelSets, final LazyList<String> inputFileNames) {
		if (inOutModelSets.hasNext()) {
			final InOutModelSet modelSet = inOutModelSets.next();
			for (final org.apache.tools.ant.types.Resource modelResource : modelSet) {
				if (!modelResource.isDirectory()) {
					final Model model = modelResource.isExists() ? loadFromResource(modelSet.getDir(), modelResource)
							: createFromResource(modelSet.getDir(), modelResource);
					model.setAllowInterModelReferences(modelSet.isAllowInterModelReferences());
					env.registerInOutModel(getModelKey(modelSet), model);

					runForInOutModelSet(env, timingData, inOutModelSets,
							inputFileNames.append(getBaseName(modelResource)));
				}
			}
		} else {
			runForOutputModelSet(env, timingData, getOutputModelSets().iterator(), inputFileNames);

			for (final InOutModelSet inOutModelSet : getInoutModelSets()) {
				final Model model = env.getInoutModels().get(getModelKey(inOutModelSet));
				final String suffix = inOutModelSet.getSuffix();
				model.getResource().setURI(URI.createFileURI(new File(inOutModelSet.getEffectiveOutputDir(),
						generateFilename(inputFileNames, StringUtils.trimToNull(suffix) != null ? suffix
								: "." + model.getResource().getURI().fileExtension())).getPath()));
				try {
					model.getResource().save(Collections.emptyMap());
				} catch (final IOException e) {
					throw new BuildException(e);
				}
			}
		}
	}

	private void runForOutputModelSet(final ExecEnv env, final TimingData timingData,
			final Iterator<OutModelSet> outModelSets, final LazyList<String> inputFileNames) {
		if (outModelSets.hasNext()) {
			final OutModelSet outModelSet = outModelSets.next();
			final org.apache.tools.ant.types.Resource resource = new org.apache.tools.ant.types.Resource(
					generateFilename(inputFileNames, outModelSet.getSuffix()));
			final Model model = createFromResource(outModelSet.getDir(), resource);
			model.setAllowInterModelReferences(outModelSet.isAllowInterModelReferences());
			env.registerOutputModel(getModelKey(outModelSet), model);

			runForOutputModelSet(env, timingData, outModelSets, inputFileNames);

			try {
				model.getResource().save(Collections.emptyMap());
			} catch (final IOException e) {
				throw new BuildException(e);
			}
		} else {
			env.run(timingData);
		}
	}

	/**
	 * Returns the {@link Model} for <code>me</code>.
	 *
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
	 *
	 * @param mm the {@link MetaModel} task parameter
	 * @return the {@link Metamodel}
	 */
	private Metamodel getMetamodel(final MetaModel mm) {
		return getMetamodel(mm.getName());
	}

	/**
	 * Returns the model name key to use in the {@link ExecEnv} for <code>me</code>.
	 *
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

	/**
	 * Returns the model name key to use in the {@link ExecEnv} for <code>me</code>.
	 *
	 * @param me the {@link ModelElementSet} task parameter
	 * @return the model name key
	 */
	private String getModelKey(final ModelElementSet me) {
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
					getProject().log(this, String.format(
							"Changing the URI of in/out model '%s' before executing a transformation will break inter-model references ('%s' -> '%s')",
							m.getName(), model.getResource().getURI(), uri), Project.MSG_WARN);
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

	private Model loadFromResource(final File dir, final org.apache.tools.ant.types.Resource resource) {
		if (dir == null || !dir.isDirectory()) {
			throw new IllegalArgumentException("Not a directory: " + dir);
		}
		final ResourceSet rs = getResourceSet();
		final Resource r = rs.getResource(URI.createFileURI(new File(dir, resource.getName()).getPath()), true);
		if (r == null) {
			throw new IllegalArgumentException(
					String.format("Model with filename %s could not be found", resource.getName()));
		}
		final Model m = EmftvmFactory.eINSTANCE.createModel();
		m.setResource(r);
		return m;
	}

	private Model createFromResource(final File dir, final org.apache.tools.ant.types.Resource resource) {
		if (dir == null || !dir.isDirectory()) {
			throw new IllegalArgumentException("Not a directory: " + dir);
		}
		final ResourceSet rs = getResourceSet();
		final Resource r = rs.createResource(URI.createFileURI(new File(dir, resource.getName()).getPath()));
		final Model m = EmftvmFactory.eINSTANCE.createModel();
		m.setResource(r);
		return m;
	}
}
