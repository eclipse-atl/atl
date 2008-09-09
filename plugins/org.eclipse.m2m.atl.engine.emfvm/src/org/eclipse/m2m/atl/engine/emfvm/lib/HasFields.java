/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm.lib;

/**
 * Abstract definition of type having fields.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public interface HasFields {

	/**
	 * Sets a value to the object.
	 * 
	 * @param frame
	 *            the frame context
	 * @param name
	 *            the value name
	 * @param value
	 *            the value
	 */
	void set(StackFrame frame, Object name, Object value);

	/**
	 * Gets a value.
	 * 
	 * @param frame
	 *            the frame context
	 * @param name
	 *            the value name
	 * @return the value
	 */
	Object get(StackFrame frame, Object name);

}
