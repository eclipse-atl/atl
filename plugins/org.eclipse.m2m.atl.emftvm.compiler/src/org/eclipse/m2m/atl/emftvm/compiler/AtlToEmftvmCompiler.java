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
package org.eclipse.m2m.atl.emftvm.compiler;

import java.io.BufferedOutputStream;
import java.io.File;
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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
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
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolverFactory;
import org.eclipse.m2m.atl.emftvm.util.ExecEnvPool;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolverFactory;
import org.eclipse.m2m.atl.emftvm.util.VMException;
import org.eclipse.m2m.atl.engine.ProblemConverter;
import org.eclipse.m2m.atl.engine.compiler.AtlStandaloneCompiler;
import org.eclipse.m2m.atl.engine.compiler.CompileTimeError;
import org.eclipse.m2m.atl.engine.parser.AtlParser;

/**
 * Invokes the ATL to EMFTVM compiler.
 * 
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class AtlToEmftvmCompiler implements AtlStandaloneCompiler {

	protected final ResourceSet rs = new ResourceSetImpl();
	protected final Metamodel pbmm = EmftvmFactory.eINSTANCE.createMetamodel();
	protected final ExecEnvPool atlWfrPool = new ExecEnvPool();
	protected final ExecEnvPool atlToEmftvmPool = new ExecEnvPool();
	protected final ExecEnvPool inlineCodeblocksPool = new ExecEnvPool();

	/**
	 * Creates a new {@link AtlToEmftvmCompiler}.
	 */
	public AtlToEmftvmCompiler() {
		super();

		final Metamodel atlmm = EmftvmFactory.eINSTANCE.createMetamodel();
		atlmm.setResource(((EMFReferenceModel) AtlParser.getDefault().getAtlMetamodel()).getResource());
		pbmm.setResource(((EMFReferenceModel) AtlParser.getDefault().getProblemMetamodel()).getResource());
		final ModuleResolverFactory mrf = new DefaultModuleResolverFactory("platform:/plugin/" + EmftvmCompilerPlugin.PLUGIN_ID
				+ "/transformations/");

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
	 * {@inheritDoc}
	 */
	public final CompileTimeError[] compile(InputStream in, String outputFileName) {
		return compile(new InputStreamReader(in), outputFileName);
	}

	/**
	 * {@inheritDoc}
	 */
	public EObject[] compileWithProblemModel(InputStream in, String outputFileName) {
		return compileWithProblemModel(new InputStreamReader(in), outputFileName);
	}

	/**
	 * {@inheritDoc}
	 */
	public EObject[] compileWithProblemModel(InputStream in, OutputStream outputStream) {
		return compileWithProblemModel(new InputStreamReader(in), outputStream);
	}

	/**
	 * {@inheritDoc}
	 */
	public CompileTimeError[] compile(final Reader in, final String outputFileName) {
		EObject[] eObjects = compileWithProblemModel(in, outputFileName);

		// convert the EObjects into an easily readable form (instances of CompileTimeError).
		CompileTimeError[] result = new CompileTimeError[eObjects.length];
		for (int i = 0; i < eObjects.length; i++) {
			result[i] = ProblemConverter.convertProblem(eObjects[i]);
		}

		// return them to caller
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("deprecation")
	public EObject[] compileWithProblemModel(final Reader in, final String outputFileName) {
		EObject[] result = new EObject[0];
		try {
			File asm = new File(outputFileName);
			if (asm.exists()) {
				asm.delete();
			}
			asm.createNewFile();
			// TODO Refactor ATL's compiler framework to support multiple file extensions
			final String emftvmOutputFileName = outputFileName.substring(0, outputFileName.lastIndexOf('.')) + ".emftvm";
			final OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(emftvmOutputFileName));
			try {
				result = compileWithProblemModel(in, outputStream);
			} finally {
				outputStream.close();
			}
			final IFile[] outputFiles = ResourcesPlugin.getWorkspace().getRoot()
					.findFilesForLocationURI(java.net.URI.create("file:/" + emftvmOutputFileName.replace(' ', '+')));
			for (IFile file : outputFiles) {
				file.getParent().refreshLocal(IResource.DEPTH_ONE, null);
				if (file.exists()) {
					file.setDerived(true);
				}
			}
		} catch (IOException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			EmftvmCompilerPlugin.log(e);
		} catch (CoreException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			EmftvmCompilerPlugin.log(e.getStatus());
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
				for (EObject cpb : cpbs) {
					pbs.add(cpb);
				}
			}
		} catch (ATLCoreException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			EmftvmCompilerPlugin.log(e);
		}
		return pbs.toArray(new EObject[pbs.size()]);
	}

	/**
	 * {@inheritDoc}
	 */
	public EObject[] compileWithProblemModel(IModel atlModel, OutputStream outputStream) {
		final List<EObject> pbs = new ArrayList<EObject>();

		final Model atlm = EmftvmFactory.eINSTANCE.createModel();
		atlm.setResource(((EMFModel) atlModel).getResource());

		final Resource pr = rs.createResource(URI.createFileURI("problems.xmi"));
		final Model pbm = EmftvmFactory.eINSTANCE.createModel();
		pbm.setResource(pr);

		final Resource r = rs.createResource(URI.createFileURI("out.emftvm"), "org.eclipse.m2m.atl.emftvm");
		final Model emftvmm = EmftvmFactory.eINSTANCE.createModel();
		emftvmm.setResource(r);

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
		} catch (VMException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			EmftvmCompilerPlugin.log(e);
		} catch (IOException e) {
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
			File asm = new File(outputFileName);
			if (asm.exists()) {
				asm.delete();
			}
			asm.createNewFile();
			final String emftvmOutputFileName = outputFileName.substring(0, outputFileName.lastIndexOf('.')) + ".emftvm";
			final OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(emftvmOutputFileName));
			try {
				return compileWithProblemModel(atlModel, outputStream);
			} finally {
				outputStream.close();
			}
		} catch (IOException e) {
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
	protected int getProblems(IModel problems, Collection<EObject> pbElements) {
		final Collection<EObject> pbs = (Collection<EObject>) problems.getElementsByType(problems.getReferenceModel().getMetaElementByName(
				"Problem")); //$NON-NLS-1$

		int nbErrors = 0;
		if (pbs != null) {
			for (EObject pb : pbs) {
				EStructuralFeature severityFeature = pb.eClass().getEStructuralFeature("severity"); //$NON-NLS-1$
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
	protected int getProblems(Model problems, Collection<EObject> pbElements) {
		final Collection<EObject> pbs = (Collection<EObject>) problems.allInstancesOf((EClass) pbmm.findType("Problem")); //$NON-NLS-1$

		int nbErrors = 0;
		if (pbs != null) {
			for (EObject pb : pbs) {
				EStructuralFeature severityFeature = pb.eClass().getEStructuralFeature("severity"); //$NON-NLS-1$
				if (severityFeature != null && "error".equals(((Enumerator) pb.eGet(severityFeature)).getName())) { //$NON-NLS-1$
					nbErrors++;
				}
			}
			pbElements.addAll(pbs);
		}

		return nbErrors;
	}

}
