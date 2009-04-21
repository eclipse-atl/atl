/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *     Obeo - Compiler refactoring
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.asm;

/**
 * Stores an {@link ASM} instruction with an operand.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ASMInstructionWithOperand extends ASMInstruction {

	private String operand;

	/**
	 * Creates a new {@link ASMInstruction} with the given mnemonic and operand.
	 * 
	 * @param mnemonic
	 *            the mnemonic
	 * @param operand
	 *            the operand
	 */
	public ASMInstructionWithOperand(String mnemonic, String operand) {
		super(mnemonic);
		this.operand = operand;
	}

	public String getOperand() {
		return operand;
	}

	public void setOperand(String operand) {
		this.operand = operand;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.asm.ASMInstruction#toString()
	 */
	public String toString() {
		return mnemonic + " " + operand; //$NON-NLS-1$
	}
}
