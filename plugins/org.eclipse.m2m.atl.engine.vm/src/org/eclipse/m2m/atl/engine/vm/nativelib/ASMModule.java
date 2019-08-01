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
package org.eclipse.m2m.atl.engine.vm.nativelib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.m2m.atl.engine.vm.ASM;
import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
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
			frame.printStackTrace("Transformation module \"" + asm.getName() +
					"\" does not have an initialized field named \"" + name + "\"");
		}
		
		return ret;
	}

	public void set(StackFrame frame, String name, ASMOclAny value) {
		fields.put(name, value);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny#unset(org.eclipse.m2m.atl.engine.vm.StackFrame, java.lang.String)
	 */
	public void unset(StackFrame frame, String name) {
		fields.remove(name);
	}
	
	public String toString() {
		return asm.getName() + " : ASMModule";
	}

	public String getName() {
		return asm.getName();
	}

	// Native Operations below
	
	public static ASMMap asMap(StackFrame frame, ASMModule self) {
		Map ret = new HashMap();
		for(Iterator i = self.fields.entrySet().iterator() ; i.hasNext() ; ) {
			Map.Entry e = (Map.Entry)i.next();
			ret.put(new ASMString((String)e.getKey()), e.getValue());
		}
		return new ASMMap(ret);
	}

	private Map fields = new HashMap();
	private ASM asm;
}
