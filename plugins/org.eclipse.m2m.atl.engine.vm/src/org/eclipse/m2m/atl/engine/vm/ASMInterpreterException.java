/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm;

public class ASMInterpreterException extends Exception {

	private static final long serialVersionUID = -3193419539765709743L;

	public ASMInterpreterException() {
	}

	public ASMInterpreterException(String arg0) {
		super(arg0);
	}

	public ASMInterpreterException(Throwable arg0) {
		super(arg0);
	}

	public ASMInterpreterException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
