/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.tests;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * A Test Exception.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class TestException extends Exception {

    private static final long serialVersionUID = 200809111654L;
    
	private final String message;

	/**
	 * Creates a new {@link TestException}.
	 * 
	 * @param message
	 *            the exception message
	 */
	public TestException(String message) {
		super();
		this.message = message;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintStream)
	 */
	public void printStackTrace(PrintStream s) {
		super.printStackTrace(s);
		s.println(message);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintWriter)
	 */
	public void printStackTrace(PrintWriter s) {
		super.printStackTrace(s);
		s.println(message);
	}

}
