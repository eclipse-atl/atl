/*******************************************************************************
 * Copyright (c) 2006 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.debug.core.ocl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.m2m.atl.engine.vm.ASM;
import org.eclipse.m2m.atl.engine.vm.ASMExecEnv;
import org.eclipse.m2m.atl.engine.vm.ASMOperation;
import org.eclipse.m2m.atl.engine.vm.ASMStackFrame;
import org.eclipse.m2m.atl.engine.vm.Debugger;
import org.eclipse.m2m.atl.engine.vm.SimpleDebugger;
import org.eclipse.m2m.atl.engine.vm.StackFrame;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModule;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny;

/**
 * An helper for the OCL evaluator.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class OclHelper extends OclEvaluator {

	private String helper;

	private List parameters;

	private ASM compiledHelper;

	/**
	 * Constructor.
	 * 
	 * @param helper
	 *            the helper code
	 * @param parameters
	 *            the helper parameters
	 */
	public OclHelper(String helper, List parameters) {
		this.helper = helper;
		this.parameters = parameters;
		this.compiledHelper = null;
	}

	/**
	 * Evaluates the helper with the given arguments.
	 * 
	 * @param helper
	 *            the helper
	 * @param arguments
	 *            the values map
	 * @return the helper evaluation result
	 * @throws Exception
	 */
	public static ASMOclAny eval(String helper, Map arguments) throws Exception {
		List params = new ArrayList(arguments.keySet());
		List args = new ArrayList();
		for (Iterator i = params.iterator(); i.hasNext();) {
			args.add(arguments.get(i.next()));
		}
		OclHelper oh = new OclHelper(helper, params);
		return oh.eval(args);
	}

	/**
	 * Compiles the current helper.
	 * 
	 * @return the compiled helper in an ASM form
	 * @throws IOException
	 */
	public ASM compile() throws IOException {
		String params = ""; //$NON-NLS-1$
		for (Iterator i = parameters.iterator(); i.hasNext();) {
			if (!params.equals("")) { //$NON-NLS-1$
				params += ", "; //$NON-NLS-1$
			}
			params += i.next() + " : OclAny"; //$NON-NLS-1$
		}
		String query = "library test; helper def: test(" + params + ") : OclAny = " + helper + ";"; //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
		compiledHelper = compile(query);
		return compiledHelper;
	}

	/**
	 * Evaluates the helper with the given arguments.
	 * 
	 * @param arguments
	 *            the given arguments
	 * @return the result
	 * @throws Exception
	 */
	public ASMOclAny eval(List arguments) throws Exception {
		return eval(arguments, Collections.EMPTY_MAP);
	}

	/**
	 * Evaluates the helper with the given arguments and a models map.
	 * 
	 * @param arguments
	 *            the given arguments
	 * @param models
	 *            the models map
	 * @return the result
	 * @throws Exception
	 */
	public ASMOclAny eval(List arguments, Map models) throws Exception {
		ASMOclAny ret = null;

		List computationArguments = new ArrayList(arguments);

		if (compiledHelper == null) {
			compile();
		}

		Debugger debugger = new SimpleDebugger(
		/* step = */false,
		/* stepops = */new ArrayList(),
		/* deepstepops = */new ArrayList(),
		/* nostepops = */new ArrayList(),
		/* deepnostepops = */new ArrayList(),
		/* showStackTrace = */true,
		/* continueAfterErrors = */false);
		ASMOperation op = compiledHelper.getOperation("test"); //$NON-NLS-1$
		ASMModule asmModule = new ASMModule(compiledHelper);
		computationArguments.add(0, asmModule);
		ASMExecEnv env = new ASMExecEnv(asmModule, debugger);
		for (Iterator i = models.keySet().iterator(); i.hasNext();) {
			String mname = (String)i.next();
			env.addModel(mname, (ASMModel)models.get(mname));
		}
		env.registerOperations(compiledHelper);
		StackFrame frame = ASMStackFrame.rootFrame(env, op, computationArguments);
		ret = op.exec(frame);

		return ret;
	}
}
