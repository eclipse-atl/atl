/*******************************************************************************
 * Copyright (c) 2004 INRIA and other.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Matthias Bohlen - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.compiler;

/**
 * Compiler not found exception.
 * 
 * @author <a href="mailto:mbohlen@mbohlen.de">Matthias Bohlen</a>
 */
public class CompilerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a CompilerNotFoundException with the given message.
	 * 
	 * @param message the error message
	 */
	public CompilerNotFoundException(String message) {
		super(message);
	}

}
