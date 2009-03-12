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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModelElement;
import org.eclipse.m2m.atl.engine.ProblemConverter;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import org.eclipse.m2m.atl.engine.vm.AtlLauncher;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMEnumLiteral;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * Default implementation of methods necessary for all ATL compilers. Attention: This class MUST NOT reference
 * any types of the platform (e.g. IFile), because it must be usable stand-alone, without Eclipse, too.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:mbohlen@mbohlen.de">Matthias Bohlen</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public abstract class AtlDefaultCompiler implements AtlStandaloneCompiler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.compiler.AtlStandaloneCompiler#compile(java.io.InputStream, java.lang.String)
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
	 * @see org.eclipse.m2m.atl.engine.compiler.AtlStandaloneCompiler#compileWithProblemModel(java.io.InputStream, java.lang.String)
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

	private Object[] getProblems(ASMModel problems, EObject[] prev) {
		Object[] ret = new Object[2];
		EObject[] pbsa = null;
		Collection pbs = problems.getElementsByType("Problem"); //$NON-NLS-1$

		int nbErrors = 0;
		if (pbs != null) {
			pbsa = new EObject[pbs.size() + prev.length];
			System.arraycopy(prev, 0, pbsa, 0, prev.length);
			int k = prev.length;
			for (Iterator i = pbs.iterator(); i.hasNext();) {
				ASMEMFModelElement ame = (ASMEMFModelElement)i.next();
				pbsa[k++] = ame.getObject();
				if ("error".equals(((ASMEnumLiteral)ame.get(null, "severity")).getName())) { //$NON-NLS-1$//$NON-NLS-2$
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
	private EObject[] internalCompile(InputStream in, String outputFileName) {
		EObject[] ret = null;
		ASMModel[] parsed = null;
		// Parsing + Semantic Analysis
		try {
			parsed = AtlParser.getDefault().parseToModelWithProblems(in, true);
		} catch (IOException e) {
			//fail silently
		}
		ASMModel atlmodel = parsed[0];
		ASMModel problems = parsed[1];

		Object[] a = getProblems(problems, new EObject[0]);
		int nbErrors = ((Integer)a[0]).intValue();
		ret = (EObject[])a[1];

		if (nbErrors == 0) {
			Map models = new HashMap();
			models.put("MOF", atlmodel.getModelLoader().getMOF()); //$NON-NLS-1$
			models.put("ATL", atlmodel.getMetamodel()); //$NON-NLS-1$
			models.put("IN", atlmodel); //$NON-NLS-1$
			models.put("Problem", problems.getMetamodel()); //$NON-NLS-1$
			models.put("OUT", problems); //$NON-NLS-1$

			Map params = Collections.EMPTY_MAP;

			Map libs = Collections.EMPTY_MAP;

			AtlLauncher.getDefault().launch(getSemanticAnalyzerURL(), libs, models, params,
					Collections.EMPTY_LIST, Collections.EMPTY_MAP);

			a = getProblems(problems, ret);
			nbErrors = ((Integer)a[0]).intValue();
			ret = (EObject[])a[1];
		}

		if (nbErrors == 0) {
			// Generating code
			Map models = new HashMap();
			models.put("MOF", atlmodel.getModelLoader().getMOF()); //$NON-NLS-1$
			models.put("ATL", atlmodel.getMetamodel()); //$NON-NLS-1$
			models.put("IN", atlmodel); //$NON-NLS-1$
			models.put("Problem", problems.getMetamodel()); //$NON-NLS-1$
			models.put("OUT", problems); //$NON-NLS-1$

			Map params = new HashMap();
			params.put("debug", "false"); //$NON-NLS-1$//$NON-NLS-2$
			params.put("WriteTo", outputFileName); //$NON-NLS-1$

			Map libs = new HashMap();
			libs.put("typeencoding", AtlDefaultCompiler.class.getResource("resources/typeencoding.asm")); //$NON-NLS-1$//$NON-NLS-2$
			libs.put("strings", AtlDefaultCompiler.class.getResource("resources/strings.asm")); //$NON-NLS-1$//$NON-NLS-2$

			AtlLauncher.getDefault().launch(getCodegeneratorURL(), libs, models, params,
					Collections.EMPTY_LIST, Collections.EMPTY_MAP);

			a = getProblems(problems, ret);
			nbErrors = ((Integer)a[0]).intValue();
			ret = (EObject[])a[1];
		}

		return ret;
	}

}
