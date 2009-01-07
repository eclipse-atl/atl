/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
