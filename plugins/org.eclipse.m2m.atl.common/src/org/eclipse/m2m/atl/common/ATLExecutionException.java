/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo
 *******************************************************************************/
package org.eclipse.m2m.atl.common;

/**
 * Exceptions thrown by an ATL execution.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public abstract class ATLExecutionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new execution exception with the specified detail message.
	 * 
	 * @param message
	 *            the detail message
	 */
	public ATLExecutionException(String message) {
		super(message);
	}

	/**
	 * Constructs a new execution exception with the specified detail message.
	 * 
	 * @param message
	 *            the detail message
	 * @param cause
	 *            the cause
	 */
	public ATLExecutionException(String message, Throwable cause) {
		super(message, cause);
	}

}
