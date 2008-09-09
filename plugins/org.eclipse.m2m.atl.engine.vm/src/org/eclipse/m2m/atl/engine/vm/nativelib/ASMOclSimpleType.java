/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm.nativelib;

import java.util.Iterator;

import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * An OclType for simple types.
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ASMOclSimpleType extends ASMOclType {

	public ASMOclSimpleType() {
		super(myType);
	}

	public ASMOclSimpleType(String name) {
		this();
		setName(name);
	}

	public ASMOclSimpleType(String name, ASMOclType supertype) {
		this();
		this.name = name;
		addSupertype(supertype);
	}

	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public int hashCode() {
		return ("OST" + name).hashCode();
	}
	
	public boolean equals(Object other) {
		return (other instanceof ASMOclSimpleType) && (name.equals(((ASMOclSimpleType)other).name));
	}

	public ASMBoolean conformsTo(ASMOclType other) {
		boolean ret = equals(other);
		
		if(!ret) {
			for(Iterator i = getSupertypes().iterator() ; i.hasNext() && !ret; ) {
				ASMOclType t = (ASMOclType)i.next();
				ret = t.conformsTo(other).getSymbol();
			}
		}
		
		return new ASMBoolean(ret);	// TODO
	}
	
	public void setName(String name) {
		this.name = name;
	}

	// Native Operations below

	public static void setName(StackFrame frame, ASMOclSimpleType self, ASMString name) {
		self.setName(name.getSymbol());
	}

	private String name = "<unnamedyet>";
}

