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
 * An exception thrown when incorrectly leaving an stack frame.
 * 
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 */
public class InterceptedLeavingStackFrameException extends Exception {

	private static final long serialVersionUID = -9080827774715601824L;

	/**
	 * Creates an exception with the given message.
	 * 
	 * @param msg
	 *            the message
	 */
	public InterceptedLeavingStackFrameException(String msg) {
		super(msg);
	}

}
