/*******************************************************************************
 * Copyright (c) 2013 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.constraints;


/**
 * Validator interface for EMFTVM.
 * @param <T> the element type to validate
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public interface Validator<T> {

	/**
	 * Validates <code>object</code>.
	 * 
	 * @param object
	 *            the object to validate
	 * @return <code>true</code> if <code>object</code> is valid
	 */
	public abstract boolean validate(T object);

}