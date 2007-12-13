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
import java.util.Iterator;
import java.util.Map;

import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * @author Frédéric Jouault
 */
public class ASMTuple extends ASMOclAny {

	public static ASMOclType myType = new ASMOclSimpleType("Tuple", getOclAnyType());	// TODO : type parametre

	public ASMTuple() {
		super(myType);
		s = new HashMap();
	}

	public ASMTuple(Map init) {
		super(myType);
		s = new HashMap(init);
	}

	public ASMTuple(ASMTuple init) {
		super(myType);
		s = new HashMap(init.s);
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();

		ret.append("Tuple {");
		for(Iterator i = s.keySet().iterator() ; i.hasNext() ; ) {
			Object n = i.next();
			Object o = s.get(n);
			ret.append(((ASMString)n).getSymbol());
			ret.append(" = ");
			ret.append(o);
			if(i.hasNext()) ret.append(", ");
		}
		ret.append("}");

		return ret.toString();
	}

	public boolean equals(Object o) {
		return (o instanceof ASMTuple) && (((ASMTuple)o).s.equals(s));
	}
	
	public int hashCode() {
		return s.hashCode();
	}

	public ASMOclAny get(StackFrame frame, String name) {
		ASMOclAny ret = null;

		if((frame != null) && isHelper(frame, name)) {
			ret = getHelper(frame, name);
		} else {
			ret = (ASMOclAny)s.get(new ASMString(name));
			if(ret == null) ret = new ASMOclUndefined();
		}

		return ret;
	}

	public void set(StackFrame frame, String name, ASMOclAny value) {
		s.put(new ASMString(name), value);
		Map attrs = new HashMap();
		for(Iterator i = s.keySet().iterator() ; i.hasNext() ; ) {
			ASMString n = (ASMString)i.next();
			attrs.put(n.getSymbol(), ASMOclAny.myType);		// TODO: correct type
		}
		setType(new ASMTupleType(attrs));
	}

	public Map getMap() {
		return s;
	}

	// Native Operations below
	
	public static ASMMap asMap(StackFrame frame, ASMTuple self) {
		return new ASMMap(self.s);
	}

	private Map s;
}

