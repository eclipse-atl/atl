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
	
	private MessageConsoleStream consoleStream = null;
	
	public OutputStreamRedirector (MessageConsoleStream cStream) {		
		super (System.out);
		consoleStream = cStream;
	}
	
	public void print (String s) {
		consoleStream.print(s);
	}
	public void print (Object o) {
		consoleStream.print(o.toString());
	}
	public void println (String s) {
		consoleStream.println(s);
	}
	
	public void println (Object o) {
		consoleStream.println(o.toString());
	}

}
