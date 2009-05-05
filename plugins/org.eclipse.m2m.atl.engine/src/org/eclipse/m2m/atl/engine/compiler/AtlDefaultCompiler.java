/*******************************************************************************
 * Copyright (c) 2004 INRIA and other.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *    Matthias Bohlen - refactoring to eliminate duplicate code
 *    Dennis Wagelaar (Vrije Universiteit Brussel)
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.compiler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.atl.common.ATLExecutionException;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.core.service.CoreService;
import org.eclipse.m2m.atl.engine.ProblemConverter;
import org.eclipse.m2m.atl.engine.asm.ASMEmitter;
import org.eclipse.m2m.atl.engine.parser.AtlParser;

/**
 * Default implementation of methods necessary for all ATL compilers. Attention: This class MUST NOT reference
 * any types of the platform (e.g. IFile), because it must be usable stand-alone, without Eclipse, too.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:mbohlen@mbohlen.de">Matthias Bohlen</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public abstract class AtlDefaultCompiler implements AtlStandaloneCompiler {

	private static ILauncher launcher;

	static {
		try {
			launcher = CoreService.getLauncher("EMF-specific VM"); //$NON-NLS-1$		
		} catch (ATLCoreException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.compiler.AtlStandaloneCompiler#compile(java.io.InputStream,
	 *      java.lang.String)
	 */
	public final CompileTimeError[] compile(InputStream in, String outputFileName) {
		EObject[] eObjects = internalCompile(in, outputFileName);

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
	 * 
	 * @see org.eclipse.m2m.atl.engine.compiler.AtlStandaloneCompiler#compileWithProblemModel(java.io.InputStream,
	 *      java.lang.String)
	 */
	public EObject[] compileWithProblemModel(InputStream in, String outputFileName) {
		return internalCompile(in, outputFileName);
	}

	/**
	 * Returns the ATL WFR URL (whatever that may be); to be implemented by concrete subclass.
	 * 
	 * @return the URL
	 */
	protected abstract URL getSemanticAnalyzerURL();

	/**
	 * Returns the URL of the ATL compiler transformation; to be implemented by concrete subclass.
	 * 
	 * @return the URL of the compiler itself
	 */
	protected abstract URL getCodegeneratorURL();

	private Object[] getProblems(IModel problems, EObject[] prev) {
		Object[] ret = new Object[2];
		EObject[] pbsa = null;
		Collection pbs = problems.getElementsByType(problems.getReferenceModel().getMetaElementByName(
				"Problem")); //$NON-NLS-1$

		int nbErrors = 0;
		if (pbs != null) {
			pbsa = new EObject[pbs.size() + prev.length];
			System.arraycopy(prev, 0, pbsa, 0, prev.length);
			int k = prev.length;
			for (Iterator i = pbs.iterator(); i.hasNext();) {
				EObject ame = (EObject)i.next();
				pbsa[k++] = ame;
				EStructuralFeature severityFeature = ame.eClass().getEStructuralFeature("severity"); //$NON-NLS-1$
				if ("error".equals(((EEnumLiteral)ame.eGet(severityFeature)).getName())) { //$NON-NLS-1$
					nbErrors++;
				}
			}
		}

		ret[0] = new Integer(nbErrors);
		ret[1] = pbsa;

		return ret;
	}

	/**
	 * Compiles an ATL source file.
	 * 
	 * @param in
	 *            The InputStream to get atl source from.
	 * @param outputFileName
	 *            The name of the file to which the ATL compiled program will be saved.
	 * @return A List of EObject instance of Problem.
	 */
	public EObject[] internalCompile(InputStream in, String outputFileName) {
		EObject[] ret = null;
		IModel[] parsed = null;
		// Parsing + Semantic Analysis
		try {
			parsed = AtlParser.getDefault().parseToModelWithProblems(in, true);
		} catch (ATLCoreException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		IModel atlmodel = parsed[0];
		IModel problems = parsed[1];

		Object[] a = getProblems(problems, new EObject[0]);
		int nbErrors = ((Integer)a[0]).intValue();
		ret = (EObject[])a[1];

		if (nbErrors == 0) {
			try {
				problems = problems.getModelFactory().newModel(problems.getReferenceModel());
			} catch (ATLCoreException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
			launcher.initialize(null);
			launcher.addInModel(atlmodel, "IN", "ATL"); //$NON-NLS-1$ //$NON-NLS-2$
			launcher.addOutModel(problems, "OUT", "Problem"); //$NON-NLS-1$ //$NON-NLS-2$
			Map params = new HashMap();
			if (!Platform.isRunning()) {
				Map typeextensions = new HashMap();
				typeextensions.put("ASMEmitter", ASMEmitter.class); //$NON-NLS-1$
				params.put("typeextensions", typeextensions); //$NON-NLS-1$
			}
			try {

				launcher.launch(ILauncher.RUN_MODE, null, params, new Object[] {launcher
						.loadModule(getSemanticAnalyzerURL().openStream()),});

			} catch (IOException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			} catch (ATLExecutionException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
			a = getProblems(problems, ret);
			nbErrors = ((Integer)a[0]).intValue();
			ret = (EObject[])a[1];
		}

		if (nbErrors == 0) {
			launcher.initialize(null);
			launcher.addInModel(atlmodel, "IN", "ATL"); //$NON-NLS-1$ //$NON-NLS-2$
			launcher.addOutModel(problems, "OUT", "Problem"); //$NON-NLS-1$ //$NON-NLS-2$

			Map params = new HashMap();
			params.put("debug", "false"); //$NON-NLS-1$//$NON-NLS-2$			
			params.put("WriteTo", outputFileName); //$NON-NLS-1$
			if (!Platform.isRunning()) {
				Map typeextensions = new HashMap();
				typeextensions.put("ASMEmitter", ASMEmitter.class); //$NON-NLS-1$
				params.put("typeextensions", typeextensions); //$NON-NLS-1$
			}
			try {
				launcher.addLibrary("typeencoding", launcher.loadModule(AtlDefaultCompiler.class.getResource(//$NON-NLS-1$
						"resources/typeencoding.asm").openStream())); //$NON-NLS-1$
				launcher.addLibrary("strings", launcher.loadModule(AtlDefaultCompiler.class.getResource(//$NON-NLS-1$
						"resources/strings.asm").openStream())); //$NON-NLS-1$

				launcher.launch(ILauncher.RUN_MODE, null, params, new Object[] {launcher
						.loadModule(getCodegeneratorURL().openStream()),});

			} catch (IOException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			} catch (ATLExecutionException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
			a = getProblems(problems, ret);
			nbErrors = ((Integer)a[0]).intValue();
			ret = (EObject[])a[1];
		}

		return ret;
	}

	/**
	 * Compiles an ATL model.
	 * 
	 * @param atlmodel
	 *            The atl Model
	 * @param outputFileName
	 *            The name of the file to which the ATL compiled program will be saved.
	 * @return A List of EObject instance of Problem.
	 */
	public EObject[] internalCompile(IModel atlmodel, String outputFileName) throws ATLCoreException,
			IOException, ATLExecutionException {
		IModel problems = AtlParser.getDefault().getModelFactory().newModel(
				AtlParser.getDefault().getProblemMetamodel());
		launcher.initialize(null);
		launcher.addInModel(atlmodel, "IN", "ATL"); //$NON-NLS-1$ //$NON-NLS-2$
		launcher.addOutModel(problems, "OUT", "Problem"); //$NON-NLS-1$ //$NON-NLS-2$
		Map params = new HashMap();
		params.put("compilation", "true"); //$NON-NLS-1$//$NON-NLS-2$

		launcher.launch(ILauncher.RUN_MODE, null, params, new Object[] {launcher
				.loadModule(getSemanticAnalyzerURL().openStream()),});

		Object[] a = getProblems(problems, new EObject[0]);
		int nbErrors = ((Integer)a[0]).intValue();
		EObject[] ret = (EObject[])a[1];

		if (nbErrors == 0) {
			launcher.initialize(null);
			launcher.addInModel(atlmodel, "IN", "ATL"); //$NON-NLS-1$ //$NON-NLS-2$
			launcher.addOutModel(problems, "OUT", "Problem"); //$NON-NLS-1$ //$NON-NLS-2$

			params = new HashMap();
			params.put("compilation", "true"); //$NON-NLS-1$//$NON-NLS-2$
			params.put("debug", "false"); //$NON-NLS-1$//$NON-NLS-2$			
			params.put("WriteTo", outputFileName); //$NON-NLS-1$

			launcher.addLibrary("typeencoding", launcher.loadModule(AtlDefaultCompiler.class.getResource(//$NON-NLS-1$
					"resources/typeencoding.asm").openStream())); //$NON-NLS-1$
			launcher.addLibrary("strings", launcher.loadModule(AtlDefaultCompiler.class.getResource(//$NON-NLS-1$
					"resources/strings.asm").openStream())); //$NON-NLS-1$

			launcher.launch(ILauncher.RUN_MODE, null, params, new Object[] {launcher
					.loadModule(getCodegeneratorURL().openStream()),});

			a = getProblems(problems, ret);
			nbErrors = ((Integer)a[0]).intValue();
			ret = (EObject[])a[1];
		}

		return ret;
	}

}
