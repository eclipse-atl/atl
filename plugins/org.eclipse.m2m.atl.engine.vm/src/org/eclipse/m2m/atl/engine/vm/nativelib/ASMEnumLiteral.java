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

import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * @author Frédéric Jouault
 */
public class ASMEnumLiteral extends ASMOclAny {

	public static ASMOclType myType = new ASMOclSimpleType("EnumLiteral", getOclAnyType());	// TODO: type is Enumeration...

	public ASMEnumLiteral() {
		super(myType);
		this.name = null;
	}

	public ASMEnumLiteral(String name) {
		this();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void set(StackFrame frame, String name, ASMOclAny value) {
		if(name.equals("name")) {
			this.name = ((ASMString)value).getSymbol();
		} else {
			super.set(frame, name, value);
		}
	}

	public boolean equals(Object o) {
		if(!(o instanceof ASMEnumLiteral))
			return false;
		if(name != null) {
			return  name.equals(((ASMEnumLiteral)o).name);
		} else {
			return ((ASMEnumLiteral)o).name == null;
		}
	}
	
	public int hashCode() {
		if(name != null) {
			return name.hashCode();
		} else {
			return super.hashCode();
		}
	}

	public String toString() {
		return "#" + ((name == null) ? "<unnamed_yet>" : name);
	}

	// Native Operations below

	public static ASMString toString(StackFrame frame, ASMEnumLiteral self) {
		return new ASMString(self.name);
	}

	private String name;
}

