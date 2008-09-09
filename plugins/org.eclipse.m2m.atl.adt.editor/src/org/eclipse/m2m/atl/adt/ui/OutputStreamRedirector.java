/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *    Jon Oldevik (SINTEF) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui;

import java.io.PrintStream;

import org.eclipse.ui.console.MessageConsoleStream;

public class OutputStreamRedirector extends PrintStream {

	private MessageConsoleStream consoleStream;

	public OutputStreamRedirector(MessageConsoleStream cStream) {
		super(System.out);
		consoleStream = cStream;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see java.io.PrintStream#print(java.lang.String)
	 */
	public void print(String s) {
		consoleStream.print(s);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see java.io.PrintStream#print(java.lang.Object)
	 */
	public void print(Object o) {
		consoleStream.print(o.toString());
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see java.io.PrintStream#println(java.lang.String)
	 */
	public void println(String s) {
		consoleStream.println(s);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see java.io.PrintStream#println(java.lang.Object)
	 */
	public void println(Object o) {
		consoleStream.println(o.toString());
	}

}
