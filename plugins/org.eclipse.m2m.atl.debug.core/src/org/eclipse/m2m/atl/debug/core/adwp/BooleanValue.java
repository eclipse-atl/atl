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
 * The boolean implementation of the debugger value.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public final class BooleanValue extends Value {

	private static Map<Boolean, BooleanValue> values = new HashMap<Boolean, BooleanValue>();

	private boolean value;

	/**
	 * creates a new {@link BooleanValue} from the given boolean.
	 * 
	 * @param bool
	 *            the boolean
	 */
	private BooleanValue(boolean bool) {
		this.value = bool;
	}

	public boolean getValue() {
		return value;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return value ? "true" : "false"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Converts a boolean into a {@link BooleanValue}.
	 * 
	 * @param bool
	 *            the boolean
	 * @return the {@link BooleanValue}
	 */
	public static BooleanValue valueOf(boolean bool) {
		Boolean value = Boolean.valueOf(bool);
		BooleanValue ret = values.get(value);
		if (ret == null) {
			ret = new BooleanValue(bool);
			values.put(value, ret);
		}
		return ret;
	}
}
