/*******************************************************************************
 * Copyright (c) 2008,2009 Communication & Systems.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Arnaud Giuliani - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.profiler.core.exception;

/**
 * An thrown when an operation isn't found.
 * 
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 */
public class NoRegisteredOperationFoundException extends Exception {

	private static final long serialVersionUID = 7505403891018091898L;

	/**
	 * Creates an exception with the given message.
	 * 
	 * @param msg
	 *            the message
	 */
	public NoRegisteredOperationFoundException(String msg) {
		super(msg);
	}

}
