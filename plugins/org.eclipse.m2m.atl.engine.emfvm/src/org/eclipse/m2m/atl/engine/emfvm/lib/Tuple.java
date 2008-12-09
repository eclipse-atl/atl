/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm.lib;

import java.util.HashMap;
import java.util.Map;

/**
 * Abstract OCLtype.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class Tuple implements HasFields {

	private Map values;

	/**
	 * Creates an new tuple.
	 */
	public Tuple() {
		values = new HashMap();
	}

	/**
	 * Creates an new tuple initialized with the given map.
	 * 
	 * @param map
	 *            the given map
	 */
	public Tuple(Map map) {
		values = new HashMap(map);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.HasFields#set(org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame,
	 *      java.lang.Object, java.lang.Object)
	 */
	public void set(AbstractStackFrame frame, Object name, Object value) {
		values.put(name, value);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.HasFields#get(org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame,
	 *      java.lang.Object)
	 */
	public Object get(AbstractStackFrame frame, Object name) {
		return values.get(name);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Tuple " + values.toString(); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		return (o instanceof Tuple) ? values.equals(((Tuple)o).values) : false;
	}

	public Map getMap() {
		return values;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return values.hashCode();
	}
}
