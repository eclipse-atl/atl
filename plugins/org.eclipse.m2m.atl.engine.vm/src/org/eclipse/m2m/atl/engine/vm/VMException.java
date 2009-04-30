/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
		s.println("ATL VM Stack:");
		s.println(frame);
		if (getCause() != null) {
			s.println("Java Stack:");
			// Java stack trace :
			super.printStackTrace(s);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintWriter)
	 */
	public void printStackTrace(PrintWriter s) {
		s.println("ATL VM Stack:");
		s.println(frame);
		if (getCause() != null) {
			s.println("Java Stack:");
			// Java stack trace :
			super.printStackTrace(s);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.common.ATLExecutionException#getModuleName()
	 */
	public String getModuleName() {
		ASMOperation operation = getASMOperation(frame);
		if (operation != null) {
			return operation.getASM().getName();
		}
		return null;
	}

	private static ASMOperation getASMOperation(StackFrame frame) {
		if (frame == null) {
			return null;
		} else {
			Operation operation = frame.getOperation();
			if (operation instanceof ASMOperation) {
				return (ASMOperation)operation;
			} else {
				return getASMOperation(frame.getParent());
			}
		}
	}
}
