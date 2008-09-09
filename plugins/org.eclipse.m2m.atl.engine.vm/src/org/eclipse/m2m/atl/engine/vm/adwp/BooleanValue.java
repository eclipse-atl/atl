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
public class BooleanValue extends Value {

	private static Map values = new HashMap();

	private boolean value;

	public static BooleanValue valueOf(boolean value_) {
		Boolean value = new Boolean(value_);
		BooleanValue ret = (BooleanValue)values.get(value);

		if (ret == null) {
			ret = new BooleanValue(value_);
			values.put(value, ret);
		}

		return ret;
	}

	private BooleanValue(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return value ? "true" : "false";
	}
}
