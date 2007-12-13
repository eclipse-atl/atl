/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frédéric Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm.adwp;

import java.util.List;

/**
 * @author Frédéric Jouault
 */
public abstract class ObjectReference extends Value {

	protected ObjectReference(int id) {
		this.id = id;
	}

	public abstract Value get(String propName);

	public abstract void set(String propName, Value value);

	public abstract Value call(String opName, List args);

	public int getId() {
		return id;
	}

	public String toString() {
		return "Object " + id;
	}

	protected int id;
}

