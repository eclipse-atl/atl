/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util;

/**
 * EMFTVM runtime exception class.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class VMException extends RuntimeException {

	private static final long serialVersionUID = 2284514635131328170L;

	private final StackFrame frame;

	/**
	 * Creates a new {@link VMException}.
	 * @param frame
	 */
	public VMException(StackFrame frame) {
		super();
		this.frame = frame;
	}

	/**
	 * Creates a new {@link VMException}.
	 * @param frame
	 * @param message
	 */
	public VMException(StackFrame frame, String message) {
		super(message);
		this.frame = frame;
	}

	/**
	 * Creates a new {@link VMException}.
	 * @param frame
	 * @param cause
	 */
	public VMException(StackFrame frame, Throwable cause) {
		super(cause);
		this.frame = frame;
	}

	/**
	 * Creates a new {@link VMException}.
	 * @param frame
	 * @param message
	 * @param cause
	 */
	public VMException(StackFrame frame, String message, Throwable cause) {
		super(message, cause);
		this.frame = frame;
	}

	/**
	 * @return the frame
	 */
	public StackFrame getFrame() {
		return frame;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (getFrame() != null) {
			return super.toString() + '\n' + getFrame();
		} else {
			return super.toString();
		}
	}

}
