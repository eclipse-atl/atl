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

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Exceptions thrown by the VM.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class VMException extends RuntimeException {

	private static final long serialVersionUID = 8297602709605088805L;

	private final StackFrame frame;

	/**
	 * Creates a VM exception with the given message.
	 * 
	 * @param frame
	 *            the frame context
	 * @param message
	 *            the message
	 */
	public VMException(StackFrame frame, String message) {
		super(message);
		this.frame = frame;
	}

	/**
	 * Creates a VM exception with the given Exception.
	 * 
	 * @param frame
	 *            the frame context
	 * @param cause
	 *            the exception
	 */
	public VMException(StackFrame frame, Exception cause) {
		super(cause);
		this.frame = frame;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintStream)
	 */
	public void printStackTrace(PrintStream s) {
		super.printStackTrace(s);
		s.println(frame);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintWriter)
	 */
	public void printStackTrace(PrintWriter s) {
		super.printStackTrace(s);
		s.println(frame);
	}
}
