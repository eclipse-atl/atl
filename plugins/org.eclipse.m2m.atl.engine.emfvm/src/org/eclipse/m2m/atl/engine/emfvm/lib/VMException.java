/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frédéric Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm.lib;

import java.io.PrintStream;
import java.io.PrintWriter;


public class VMException extends RuntimeException {

	private static final long serialVersionUID = 8297602709605088805L;

	public VMException(StackFrame frame, String message) {
		super(message);
		this.frame = frame;
	}
	
	public VMException(StackFrame frame, String message, Exception cause) {
		super(message, cause);
		this.frame = frame;
	}
	
	public VMException(StackFrame frame, Exception cause) {
		super(cause);
		this.frame = frame;
	}
	
	private StackFrame frame;

	public void printStackTrace(PrintStream s) {
		super.printStackTrace(s);
		s.println(frame);
	}

	public void printStackTrace(PrintWriter s) {
		super.printStackTrace(s);
		s.println(frame);
	}
}
