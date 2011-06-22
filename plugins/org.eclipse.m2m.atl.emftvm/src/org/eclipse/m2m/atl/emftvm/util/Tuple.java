/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util;

import java.util.Collections;
import java.util.Map;

/**
 * Reflective, immutable implementation of OCL Tuples.
 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
 */
public final class Tuple {

	private final Map<String, Object> values;

	/**
	 * Creates a new empty {@link Tuple}.
	 */
	public Tuple() {
		values = Collections.emptyMap();
	}

	/**
	 * Creates a new {@link Tuple} initialized with the given <code>map</code>.
	 * @param map the map with tuple key-value pairs
	 */
	public Tuple(Map<String, Object> map) {
		values = Collections.unmodifiableMap(map);
	}

	public Object get(Object name) {
		return values.get(name);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tuple " + values.toString(); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		return (o instanceof Tuple) ? values.equals(((Tuple)o).values) : false;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return values.hashCode();
	}

	/**
	 * @return This {@link Tuple}'s value map
	 */
	public Map<String, Object> asMap() {
		return values;
	}
}
