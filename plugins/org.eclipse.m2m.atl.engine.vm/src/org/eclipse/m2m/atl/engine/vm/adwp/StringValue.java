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
package org.eclipse.m2m.atl.engine.vm.adwp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class StringValue extends Value {

	private static Map values = new HashMap();

	public static StringValue valueOf(String value) {
		if(value == null) value = "<null>";
		value = value.intern();
		StringValue ret = (StringValue)values.get(value);

		if(ret == null) {
			ret = new StringValue(value);
			values.put(value, ret);
		}

		return ret;
	}

	private StringValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String toString() {
		return value;
	}

	private String value;
}

