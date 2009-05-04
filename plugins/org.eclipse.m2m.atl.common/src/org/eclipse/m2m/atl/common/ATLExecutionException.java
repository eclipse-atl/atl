/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
