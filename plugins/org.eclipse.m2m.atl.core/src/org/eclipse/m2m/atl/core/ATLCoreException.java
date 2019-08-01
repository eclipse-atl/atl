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
package org.eclipse.m2m.atl.core;

/**
 * Exceptions thrown by an ATL Core operation.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ATLCoreException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new execution exception with the specified detail message.
	 * 
	 * @param message
	 *            the detail message
	 */
	public ATLCoreException(String message) {
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
	public ATLCoreException(String message, Throwable cause) {
		super(message, cause);
	}

}
