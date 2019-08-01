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
 * The String implementation of the debugger value.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public final class StringValue extends Value {

	private static Map<String, StringValue> values = new HashMap<String, StringValue>();

	private String value;

	private StringValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return value;
	}

	/**
	 * Converts a string into a {@link StringValue}.
	 * 
	 * @param stringValue
	 *            the string
	 * @return the {@link StringValue}
	 */
	public static StringValue valueOf(String stringValue) {
		String tmp = stringValue;
		if (tmp == null) {
			tmp = "<null>"; //$NON-NLS-1$
		}
		tmp = tmp.intern();
		StringValue ret = values.get(tmp);

		if (ret == null) {
			ret = new StringValue(tmp);
			values.put(tmp, ret);
		}

		return ret;
	}
}
