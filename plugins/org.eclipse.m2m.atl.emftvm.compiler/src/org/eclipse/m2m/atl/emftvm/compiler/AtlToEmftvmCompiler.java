/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * Copyright (c) 2017, 2018, 2021 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.compiler;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.util.ClassModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolverFactory;
import org.eclipse.m2m.atl.emftvm.util.ExecEnvPool;
import org.eclipse.m2m.atl.emftvm.util.ModuleNotFoundException;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolverFactory;
import org.eclipse.m2m.atl.emftvm.util.VMException;
import org.eclipse.m2m.atl.engine.ProblemConverter;
import org.eclipse.m2m.atl.engine.compiler.AtlStandaloneCompiler;
import org.eclipse.m2m.atl.engine.compiler.CompileTimeError;
import org.eclipse.m2m.atl.engine.parser.AtlParser;

/**
 * Invokes the ATL to EMFTVM compiler.
 *
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class AtlToEmftvmCompiler implements AtlStandaloneCompiler {

	protected final ResourceSet rs = new ResourceSetImpl();
	protected final Metamodel pbmm;
	protected final ExecEnvPool atlWfrPool = new ExecEnvPool();
	protected final ExecEnvPool atlToEmftvmPool = new ExecEnvPool();
	protected final ExecEnvPool inlineCodeblocksPool = new ExecEnvPool();

	/**
	 * Creates a new {@link AtlToEmftvmCompiler}.
	 */
	public AtlToEmftvmCompiler() {
		super();
		/*
		 * Explicitly register the EMFTVMResourceFactoryImpl for .emftvm files for
		 * standalone compiler use.
		 */
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("emftvm", new EMFTVMResourceFactoryImpl());

		final Metamodel atlmm = EmftvmFactory.eINSTANCE
				.createMetamodel(((EMFReferenceModel) AtlParser.getDefault().getAtlMetamodel()).getResource());
		pbmm = EmftvmFactory.eINSTANCE
				.createMetamodel(((EMFReferenceModel) AtlParser.getDefault().getProblemMetamodel()).getResource());
		final ModuleResolverFactory mrf = createModuleResolverFactory();

		atlWfrPool.setModuleResolverFactory(mrf);
		atlWfrPool.registerMetaModel("ATL", atlmm);
		atlWfrPool.registerMetaModel("Problem", pbmm);
		atlWfrPool.loadModule("ATLWFR");

		atlToEmftvmPool.setModuleResolverFactory(mrf);
		atlToEmftvmPool.registerMetaModel("ATL", atlmm);
		atlToEmftvmPool.registerMetaModel("Problem", pbmm);
		atlToEmftvmPool.loadModule("ATLtoEMFTVM");

		inlineCodeblocksPool.setModuleResolverFactory(mrf);
		inlineCodeblocksPool.registerMetaModel("Problem", pbmm);
		inlineCodeblocksPool.loadModule("InlineCodeblocks");
	}

	/**
	 * Creates a new {@link ModuleResolverFactory}.
	 *
	 * @return a new {@link ModuleResolverFactory}
	 */
	protected ModuleResolverFactory createModuleResolverFactory() {
		ModuleResolverFactory moduleResolverFactory = new DefaultModuleResolverFactory(
				"platform:/plugin/" + EmftvmCompilerPlugin.PLUGIN_ID + "/transformations/");
		try {
			moduleResolverFactory.createModuleResolver().resolveModule("ATLWFR");
		} catch (final ModuleNotFoundException e) {
			moduleResolverFactory = new ModuleResolverFactory() {
				public ModuleResolver createModuleResolver() {
					return new ClassModuleResolver(getClass()) {
						@Override
						public Module resolveModule(final String module) throws ModuleNotFoundException {
							return super.resolveModule("/transformations/" + module);
						}
					};
				}
			};
		}
		return moduleResolverFactory;
	}

	/**
	 * {@inheritDoc}
	 */
	public final CompileTimeError[] compile(final InputStream in, final String outputFileName) {
		return compile(new InputStreamReader(in), outputFileName);
	}

	/**
	 * {@inheritDoc}
	 */
	public EObject[] compileWithProblemModel(final InputStream in, final String outputFileName) {
		return compileWithProblemModel(new InputStreamReader(in), outputFileName);
	}

	/**
	 * {@inheritDoc}
	 */
	public EObject[] compileWithProblemModel(final InputStream in, final OutputStream outputStream) {
		return compileWithProblemModel(new InputStreamReader(in), outputStream);
	}

	/**
	 * {@inheritDoc}
	 */
	public CompileTimeError[] compile(final Reader in, final String outputFileName) {
		final EObject[] eObjects = compileWithProblemModel(in, outputFileName);

		// convert the EObjects into an easily readable form (instances of CompileTimeError).
		final CompileTimeError[] result = new CompileTimeError[eObjects.length];
		for (int i = 0; i < eObjects.length; i++) {
			result[i] = ProblemConverter.convertProblem(eObjects[i]);
		}

		// return them to caller
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public EObject[] compileWithProblemModel(final Reader in, final String outputFileName) {
		EObject[] result = new EObject[0];
		try {
			final String emftvmOutputFileName = outputFileName.substring(0, outputFileName.lastIndexOf('.')) + ".emftvm";
			final OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(emftvmOutputFileName));
			try {
				result = compileWithProblemModel(in, outputStream);
			} finally {
				outputStream.close();
			}
		} catch (final IOException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			EmftvmCompilerPlugin.log(e);
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public EObject[] compileWithProblemModel(final Reader in, final OutputStream outputStream) {
		final List<EObject> pbs = new ArrayList<EObject>();
		try {
			final IModel[] parsed = AtlParser.getDefault().inject(in, null);
			final IModel atlmodel = parsed[0];
			final IModel problems = parsed[1];

			if (getProblems(problems, pbs) == 0) {
				final EObject[] cpbs = compileWithProblemModel(atlmodel, outputStream);
				for (final EObject cpb : cpbs) {
					pbs.add(cpb);
				}
			}
		} catch (final ATLCoreException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			EmftvmCompilerPlugin.log(e);
		}
		return pbs.toArray(new EObject[pbs.size()]);
	}

	/**
	 * {@inheritDoc}
	 */
	public EObject[] compileWithProblemModel(final IModel atlModel, final OutputStream outputStream) {
		final List<EObject> pbs = new ArrayList<EObject>();

		final Model atlm = EmftvmFactory.eINSTANCE.createModel(((EMFModel) atlModel).getResource());

		final Resource pr = rs.createResource(URI.createFileURI("problems.xmi"));
		final Model pbm = EmftvmFactory.eINSTANCE.createModel(pr);

		final Resource r = rs.createResource(URI.createFileURI("out.emftvm"), "org.eclipse.m2m.atl.emftvm");
		final Model emftvmm = EmftvmFactory.eINSTANCE.createModel(r);

		final ExecEnv atlWfrEnv = atlWfrPool.getExecEnv();
		final ExecEnv atlToEmftvmEnv = atlToEmftvmPool.getExecEnv();
		final ExecEnv inlineCodeblocksEnv = inlineCodeblocksPool.getExecEnv();
		try {
			atlWfrEnv.registerInputModel("IN", atlm);
			atlWfrEnv.registerOutputModel("OUT", pbm);
			atlWfrEnv.run(null);

			if (getProblems(pbm, pbs) == 0) {
				atlToEmftvmEnv.registerInputModel("IN", atlm);
				atlToEmftvmEnv.registerOutputModel("OUT", emftvmm);
				atlToEmftvmEnv.registerOutputModel("PBS", pbm);
				atlToEmftvmEnv.run(null);

				if (getProblems(pbm, pbs) == 0) {
					inlineCodeblocksEnv.registerInOutModel("IN", emftvmm);
					inlineCodeblocksEnv.run(null);

					r.save(outputStream, Collections.emptyMap());
				}
			}
		} catch (final VMException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			EmftvmCompilerPlugin.log(e);
		} catch (final IOException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			EmftvmCompilerPlugin.log(e);
		} finally {
			atlWfrPool.returnExecEnv(atlWfrEnv);
			atlToEmftvmPool.returnExecEnv(atlToEmftvmEnv);
			inlineCodeblocksPool.returnExecEnv(inlineCodeblocksEnv);
			rs.getResources().remove(pr); // unload
			rs.getResources().remove(r); // unload
		}

		return pbs.toArray(new EObject[pbs.size()]);
	}

	/**
	 * {@inheritDoc}
	 */
	public EObject[] compileWithProblemModel(final IModel atlModel, final String outputFileName) {
		try {
			final String emftvmOutputFileName = outputFileName.substring(0, outputFileName.lastIndexOf('.')) + ".emftvm";
			final OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(emftvmOutputFileName));
			try {
				return compileWithProblemModel(atlModel, outputStream);
			} finally {
				outputStream.close();
			}
		} catch (final IOException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			EmftvmCompilerPlugin.log(e);
		}
		return new EObject[0];
	}

	/**
	 * Retrieves problem elements from <code>problems</code>.
	 *
	 * @param problems
	 *            the problems model
	 * @param pbElements
	 *            the collection of problem elements to augment
	 * @return the number of error problems
	 */
	@SuppressWarnings("unchecked")
	protected int getProblems(final IModel problems, final Collection<EObject> pbElements) {
		final Collection<EObject> pbs = (Collection<EObject>) problems.getElementsByType(problems.getReferenceModel().getMetaElementByName(
				"Problem")); //$NON-NLS-1$

		int nbErrors = 0;
		if (pbs != null) {
			for (final EObject pb : pbs) {
				final EStructuralFeature severityFeature = pb.eClass().getEStructuralFeature("severity"); //$NON-NLS-1$
				if (severityFeature != null && "error".equals(((Enumerator) pb.eGet(severityFeature)).getName())) { //$NON-NLS-1$
					nbErrors++;
				}
			}
			pbElements.addAll(pbs);
		}

		return nbErrors;
	}

	/**
	 * Retrieves problem elements from <code>problems</code>.
	 *
	 * @param problems
	 *            the problems model
	 * @param pbElements
	 *            the collection of problem elements to augment
	 * @return the number of error problems
	 */
	protected int getProblems(final Model problems, final Collection<EObject> pbElements) {
		final Collection<EObject> pbs = problems.allInstancesOf((EClass) pbmm.findType("Problem")); //$NON-NLS-1$

		int nbErrors = 0;
		if (pbs != null) {
			for (final EObject pb : pbs) {
				final EStructuralFeature severityFeature = pb.eClass().getEStructuralFeature("severity"); //$NON-NLS-1$
				if (severityFeature != null && "error".equals(((Enumerator) pb.eGet(severityFeature)).getName())) { //$NON-NLS-1$
					nbErrors++;
				}
			}
			pbElements.addAll(pbs);
		}

		return nbErrors;
	}

}
