/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault - initial API and implementation
 *    Obeo - refactoring
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm;

import java.io.PrintStream;
import java.io.PrintWriter;

import org.eclipse.m2m.atl.common.ATLExecutionException;
import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame;

/**
 * Exceptions thrown by the VM.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class VMException extends ATLExecutionException {

	private static final long serialVersionUID = 1L;

	private final AbstractStackFrame frame;

	/**
	 * Creates a VM exception with the given message.
	 * 
	 * @param frame
	 *            the frame context
	 * @param message
	 *            the message
	 */
	public VMException(AbstractStackFrame frame, String message) {
		super(message);
		this.frame = frame;
	}

	/**
	 * Creates a VM exception with the given message and cause.
	 * 
	 * @param frame
	 *            the frame context
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public VMException(AbstractStackFrame frame, String message, Throwable cause) {
		super(message, cause);
		this.frame = frame;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintStream)
	 */
	@Override
	public void printStackTrace(PrintStream s) {
		if (frame != null) {
			//s.println("ATL VM Stack:"); //$NON-NLS-1$
			s.println(frame);
		}
		if (getCause() != null) {
			s.println("Java Stack:"); //$NON-NLS-1$
			// Java stack trace :
			super.printStackTrace(s);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintWriter)
	 */
	@Override
	public void printStackTrace(PrintWriter s) {
		if (frame != null) {
			//s.println("ATL VM Stack:"); //$NON-NLS-1$
			s.println(frame);
		}
		if (getCause() != null) {
			s.println("Java Stack:"); //$NON-NLS-1$
			// Java stack trace :
			super.printStackTrace(s);
		}
	}

}
