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

import java.util.List;

/**
 * A reference to an object.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public abstract class ObjectReference extends Value {

	protected int id;

	/**
	 * Creates a new reference with the given id.
	 * 
	 * @param id
	 *            the id
	 */
	protected ObjectReference(int id) {
		this.id = id;
	}

	/**
	 * Gets a value for the given property.
	 * 
	 * @param propName
	 *            the property name
	 * @return the value
	 */
	public abstract Value get(String propName);

	/**
	 * Sets a value for the given property.
	 * 
	 * @param propName
	 *            the property name
	 * @param value
	 *            the value to set
	 */
	public abstract void set(String propName, Value value);

	/**
	 * Calls an operation with the given arguments.
	 * 
	 * @param opName
	 *            the operation name
	 * @param args
	 *            the arguments
	 * @return the operation call result
	 */
	public abstract Value call(String opName, List<Value> args);

	public int getId() {
		return id;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Object " + id; //$NON-NLS-1$
	}
}
