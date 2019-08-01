/*******************************************************************************
 * Copyright (c) 2006 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.ocl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.engine.asm.ASM;

/**
 * The Ocl query management class.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class OclQuery extends OclEvaluator {

	private String query;

	private ASM compiledQuery;

	/**
	 * Constructor.
	 * 
	 * @param query
	 *            the query to manage
	 */
	public OclQuery(String query) {
		this.query = query;
		this.compiledQuery = null;
	}

	/**
	 * Evaluates a given query.
	 * 
	 * @param query
	 *            the query to evaluate
	 * @return the query result
	 * @throws Exception
	 */
	public static Object eval(String query) throws Exception {
		return new OclQuery(query).eval();
	}

	/**
	 * Evaluates a given query.
	 * 
	 * @param query
	 *            the query to evaluate
	 * @param models
	 *            the models map
	 * @return the result
	 * @throws Exception
	 */
	public static Object eval(String query, Map models) throws Exception {
		return new OclQuery(query).eval(models);
	}

	/**
	 * Compiles the given query.
	 * 
	 * @return the compiled query
	 * @throws Exception
	 */
	public EObject[] compile() throws Exception {
		compiledQuery = compile("query test = \n" + query + "\n;"); //$NON-NLS-1$//$NON-NLS-2$
		return pbs;
	}

	/**
	 * Returns the current query evaluation result.
	 * 
	 * @return the current query evaluation result
	 * @throws Exception
	 */
	public Object eval() throws Exception {
		Map models = new HashMap();
		// TODO
		//		models.put("MOF", ASMEMFModel.getMOF()); //$NON-NLS-1$
		return eval(models);
	}

	// TODO
	// /**
	// * Evaluates the current query and returns the result as String.
	// *
	// * @param models
	// * the models map
	// * @return the result as String
	// * @throws Exception
	// */
	// public String evalString(Map models) throws Exception {
	// return ((ASMString)eval(models)).getSymbol();
	// }
	//
	// /**
	// * Evaluates the current query and returns the result as Integer.
	// *
	// * @param models
	// * the models map
	// * @return the result as Integer
	// * @throws Exception
	// */
	// public int evalInteger(Map models) throws Exception {
	// return ((ASMInteger)eval(models)).getSymbol();
	// }
	//
	// /**
	// * Evaluates the current query and returns the result as Boolean.
	// *
	// * @param models
	// * the models map
	// * @return the result as Boolean
	// * @throws Exception
	// */
	// public boolean evalBoolean(Map models) throws Exception {
	// return ((ASMBoolean)eval(models)).getSymbol();
	// }

	/**
	 * Evaluates the current query and returns the result.
	 * 
	 * @param models
	 *            the models map
	 * @return the result
	 * @throws Exception
	 */
	public Object eval(Map models) throws Exception {
		return eval(models, Collections.EMPTY_MAP);
	}

	/**
	 * Evaluates the current query and returns the result.
	 * 
	 * @param models
	 *            the models map
	 * @param libraries
	 *            the libraries map
	 * @return the result
	 * @throws Exception
	 */
	public Object eval(Map models, Map libraries) throws Exception {
		if (compiledQuery == null) {
			compile();
		}
		return interpretQuery(compiledQuery, models, libraries);
	}

	private Object interpretQuery(ASM asm, Map models, Map libraries) throws Exception {
		Object ret = null;

		// TODO
		// AtlLauncher al = AtlLauncher.getDefault();
		// Map asmParams = Collections.EMPTY_MAP;
		//
		// ITool debugger = new SimpleDebugger(
		// /* step = */false,
		// /* stepops = */new ArrayList(),
		// /* deepstepops = */new ArrayList(),
		// /* nostepops = */new ArrayList(),
		// /* deepnostepops = */new ArrayList(),
		// /* showStackTrace = */true);
		// ret = (ASMOclAny)al.launch(asm, libraries, models, asmParams, Collections.EMPTY_LIST,
		// Collections.EMPTY_MAP, debugger);

		return ret;
	}
}
