/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Frederic Jouault - initial API and implementation
 * 	  William Piers - ATL Regular VM adaptation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm;

import java.io.PrintStream;
import java.io.PrintWriter;

import org.eclipse.m2m.atl.common.ATLExecutionException;

/**
 * Exceptions thrown by the VM.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class VMException extends ATLExecutionException {

	private static final long serialVersionUID = 1L;

	private final StackFrame frame;

	/**
	 * Creates a VM exception with the given message and cause.
	 * 
	 * @param frame
	 *            the frame context
	 * @param message
	 *            the message
	 */
	public VMException(StackFrame frame, String message, Throwable cause) {
		super(message, cause);
		this.frame = frame;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintStream)
	 */
	public void printStackTrace(PrintStream s) {
        synchronized (s) {
            s.println(this);
    		if (frame != null) {
    			s.println(frame);
    		}
    		if (getCause() != null) {
    			s.println("Java Stack:"); //$NON-NLS-1$
    			// Java stack trace :
    			super.printStackTrace(s);
    		}
        }
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintWriter)
	 */
	public void printStackTrace(PrintWriter s) {
        synchronized (s) {
            s.println(this);
    		if (frame != null) {
    			s.println(frame);
    		}
    		if (getCause() != null) {
    			s.println("Java Stack:"); //$NON-NLS-1$
    			// Java stack trace :
    			super.printStackTrace(s);
    		}
        }
	}

}
