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
 * The Real implementation of the debugger value.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public final class RealValue extends Value {

	private static Map<Double, RealValue> values = new HashMap<Double, RealValue>();

	private double value;

	private RealValue(double value) {
		this.value = value;
	}

	public double getValue() {
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
	 * Converts a double into a {@link RealValue}.
	 * 
	 * @param realValue
	 *            the double
	 * @return the {@link RealValue}
	 */
	public static RealValue valueOf(double realValue) {
		Double value = new Double(realValue);
		RealValue ret = values.get(value);

		if (ret == null) {
			ret = new RealValue(realValue);
			values.put(value, ret);
		}

		return ret;
	}
}
