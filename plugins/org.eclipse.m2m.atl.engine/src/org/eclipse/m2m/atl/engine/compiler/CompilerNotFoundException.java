/*******************************************************************************
 * Copyright (c) 2004 INRIA and other.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
