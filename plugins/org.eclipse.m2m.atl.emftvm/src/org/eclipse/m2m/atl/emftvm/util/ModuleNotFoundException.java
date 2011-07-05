/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util;

/**
 * Module not found.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class ModuleNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3439404058385123603L;

	/**
	 * Creates a new {@link ModuleNotFoundException}.
	 */
	public ModuleNotFoundException() {
		super();
	}

	/**
	 * Creates a new {@link ModuleNotFoundException}.
	 * @param message the error message
	 * @param cause the nested exception
	 */
	public ModuleNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Creates a new {@link ModuleNotFoundException}.
	 * @param message the error message
	 */
	public ModuleNotFoundException(String message) {
		super(message);
	}

	/**
	 * Creates a new {@link ModuleNotFoundException}.
	 * @param cause the nested exception
	 */
	public ModuleNotFoundException(Throwable cause) {
		super(cause);
	}

}
