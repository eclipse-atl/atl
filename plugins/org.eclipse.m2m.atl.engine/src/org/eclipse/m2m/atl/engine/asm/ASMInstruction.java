/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 * 	   Obeo - Compiler refactoring
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.asm;

/**
 * Stores an {@link ASM} instruction.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ASMInstruction {

	protected String mnemonic;

	/**
	 * Creates a new {@link ASMInstruction} with the given mnemonic.
	 * 
	 * @param mnemonic the mnemonic
	 */
	public ASMInstruction(String mnemonic) {
		this.mnemonic = mnemonic.intern();
	}

	public String getMnemonic() {
		return mnemonic;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return mnemonic;
	}
}
