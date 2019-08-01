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
package org.eclipse.m2m.atl.debug.core.adwp;

import java.util.HashMap;
import java.util.Map;

/**
 * The Integer implementation of the debugger value.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public final class IntegerValue extends Value {

	private static Map<Integer, IntegerValue> values = new HashMap<Integer, IntegerValue>();

	private int value;

	private IntegerValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "" + value; //$NON-NLS-1$
	}

	/**
	 * Converts an int into a {@link IntegerValue}.
	 * 
	 * @param integerValue
	 *            the int
	 * @return the {@link IntegerValue}
	 */
	public static IntegerValue valueOf(int integerValue) {
		Integer value = Integer.valueOf(integerValue);
		IntegerValue ret = values.get(value);
	
		if (ret == null) {
			ret = new IntegerValue(integerValue);
			values.put(value, ret);
		}
	
		return ret;
	}
}
