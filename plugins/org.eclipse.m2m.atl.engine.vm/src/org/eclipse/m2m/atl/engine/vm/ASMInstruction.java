/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frédéric Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm;

/**
 * @author Frédéric Jouault
 */
public class ASMInstruction {

	public ASMInstruction(String mnemonic) {
		this.mnemonic = mnemonic.intern();
	}

	public String getMnemonic() {
		return mnemonic;
	}

	public String toString() {
		return mnemonic;
	}

	protected String mnemonic;
}

