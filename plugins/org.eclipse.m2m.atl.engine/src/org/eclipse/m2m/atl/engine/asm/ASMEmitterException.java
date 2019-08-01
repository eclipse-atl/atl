/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.asm;

/**
 * ASM emitter exception.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ASMEmitterException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates an ASMEmitterException with the given message.
	 * 
	 * @param message
	 *            the error message
	 */
	public ASMEmitterException(String message) {
		super(message);
	}

	/**
	 * Creates an ASMEmitterException with the given message and the given cause.
	 * 
	 * @param message
	 *            the error message
	 * @param cause
	 *            the error
	 */
	public ASMEmitterException(String message, Throwable cause) {
		super(message, cause);
	}

}
