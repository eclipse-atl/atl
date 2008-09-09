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
public class IntegerValue extends Value {

	private static Map values = new HashMap();

	public static IntegerValue valueOf(int value_) {
		Integer value = new Integer(value_);
		IntegerValue ret = (IntegerValue)values.get(value);

		if(ret == null) {
			ret = new IntegerValue(value_);
			values.put(value, ret);
		}

		return ret;
	}

	private IntegerValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return "" + value;
	}

	private int value;
}

