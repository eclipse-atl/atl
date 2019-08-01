/*******************************************************************************
 * Copyright (c) 2008,2009 Communication & Systems.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Arnaud Giuliani - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.profiler.core;

/**
 * ASM Operation constants.
 * 
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 */
public final class ASMConstants {

	/** ASM exec operation. */
	public static final String EXEC = "__exec__"; //$NON-NLS-1$

	/** ASM resolve operation. */
	public static final String RESOLVE = "__resolve__"; //$NON-NLS-1$

	/** ASM matcher operation. */
	public static final String MATCHER = "__matcher__"; //$NON-NLS-1$

	/** ASM apply operation. */
	public static final String APPLY = "__apply"; //$NON-NLS-1$

	/** ASM match operation. */
	public static final String MATCH = "__match"; //$NON-NLS-1$

	/** ASM init operation. */
	public static final String INIT = "__init"; //$NON-NLS-1$

	private ASMConstants() {
		super();
		// prevents instantiation
	}
}
