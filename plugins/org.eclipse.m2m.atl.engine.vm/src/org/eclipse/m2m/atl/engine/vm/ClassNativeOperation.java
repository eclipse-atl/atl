/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclType;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ClassNativeOperation extends NativeOperation {

	// The Method must be static and must have <type> self as a first parameter.
	public ClassNativeOperation(Method method, List parameters, ASMOclType returnType, ASMOclType contextType) {
		super(method, parameters, returnType, contextType);
	}

	public ClassNativeOperation(Method method) {
		super(method, getParameters(method), getReturnType(method), getContextType(method));
	}

	private static List getParameters(Method method) {
		List ret = new ArrayList();

		Class[] paramTypes = method.getParameterTypes();
		for (int i = 2; i < paramTypes.length; i++) { // paramTypes[0] is a StackFrame
			// paramTypes[1] is self
			ret.add(getASMType(paramTypes[i], false));
		}

		return ret;
	}

	private static ASMOclType getReturnType(Method method) {
		ASMOclType ret = null;

		ret = getASMType(method.getReturnType(), false);

		return ret;
	}

	private static ASMOclType getContextType(Method method) {
		ASMOclType ret = null;

		ret = getASMType(method.getParameterTypes()[1], false);

		return ret;
	}

	public ASMOclAny exec(StackFrame frame) {
		ASMOclAny ret = null;

		try {
			List args = new ArrayList(frame.getArgs());
			args.add(0, frame);
			ret = (ASMOclAny)getMethod().invoke(null, args.toArray());
		} catch (IllegalAccessException iae) {
			frame.printStackTrace(iae);
		} catch (IllegalArgumentException iae2) {
			frame.printStackTrace(iae2);
		} catch (InvocationTargetException ite) {
			frame.printStackTrace(ite);
		}
		((NativeStackFrame)frame).setRet(ret);
		frame.leaveFrame();

		return ret;
	}
}
