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

import java.util.List;

import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclSimpleType;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclType;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class NativeStackFrame extends StackFrame {

	public static ASMOclType myType = new ASMOclSimpleType("NativeStackFrame", StackFrame.myType);

	public NativeStackFrame(ExecEnv execEnv, NativeOperation operation, List args) {
		super(myType, execEnv, operation, args);
	}

	public ASMOclAny leaveFrame() {
		super.leaveFrame();

		getExecEnv().pop();

		return ret;
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();

		ret.append(getOperation());
		ret.append("\n\targs = ");
		ret.append(getArgs());

		return ret.toString();
	}

	public void setRet(ASMOclAny ret) {
		this.ret = ret;
	}

	public ASMOclAny getRet() {
		return ret;
	}

	private ASMOclAny ret = null;
}

