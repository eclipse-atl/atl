/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frédéric Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm.lib;

import java.util.HashMap;
import java.util.Map;


public class Tuple implements HasFields {

	private Map values;
	
	public Tuple() {
		values = new HashMap();
	}
	
	public Tuple(Map map) {
		values = new HashMap(map);
	}
	
	public void set(StackFrame frame, Object name, Object value) {
		values.put(name, value);
	}

	public Object get(StackFrame frame, Object name) {
		return values.get(name);
	}

	public String toString() {
		return "Tuple " + values.toString();
	}	
	
	public boolean equals(Object o) {
		return (o instanceof Tuple) ? values.equals(((Tuple)o).values) : false;
	}
	
	public int hashCode() {
		return values.hashCode();
	}
}
