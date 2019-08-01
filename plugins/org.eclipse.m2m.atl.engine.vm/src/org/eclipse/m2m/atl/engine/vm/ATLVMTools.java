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
package org.eclipse.m2m.atl.engine.vm;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclType;

/**
 * ATL VM utilities.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public abstract class ATLVMTools {

	private ATLVMTools() {
	}

	/**
	 * Converts an operation to a VM operation.
	 * 
	 * @param cl the class which contains the operation
	 * @param name the operation name
	 * @return the VM operation
	 */
	public static Operation toVMOperation(Class cl, String name) {
		Operation ret = null;

		Method m = null;

		for (Iterator i = Arrays.asList(cl.getDeclaredMethods()).iterator(); i.hasNext() && (m == null);) {
			Method me = (Method)i.next();
			if (me.getName().equals(name)) {
				m = me;
			}
		}

		if (m != null) {
			ret = new ClassNativeOperation(m);
		}

		return ret;
	}

	/**
	 * Adds a VM operation to a context.
	 * 
	 * @param context the context
	 * @param op operation
	 */
	public static void addVMOperation(ASMOclType context, Operation op) {
		((Map)ASMOclType.getVMOperations().get(context)).put(op.getName(), op);
	}
}
