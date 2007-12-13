/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frédéric Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm.nativelib;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.m2m.atl.engine.vm.ASM;
import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * @author Frédéric Jouault
 */
public class ASMModule extends ASMOclAny {

	public static ASMOclType myType = new ASMOclSimpleType("Module", getOclAnyType());
	public ASMModule(ASM asm) {
		super(myType);
		this.asm = asm;
	}

	public ASMOclAny get(StackFrame frame, String name) {
		ASMOclAny ret = (ASMOclAny)fields.get(name);
		
		if(ret == null) {
			frame.printStackTrace("transformation module \"" + asm.getName() +
					"\" does not have an initialized field named \"" + name + "\"");
		}
		
		return ret;
	}

	public void set(StackFrame frame, String name, ASMOclAny value) {
		fields.put(name, value);
	}

	public String toString() {
		return asm.getName() + " : ASMModule";
	}

	public String getName() {
		return asm.getName();
	}

	private Map fields = new HashMap();
	private ASM asm;
}

