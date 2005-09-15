package org.atl.engine.vm;

/**
 * @author Frédéric Jouault
 */
public class ASMInstruction {

	public ASMInstruction(String mnemonic) {
		this.mnemonic = mnemonic;
	}

	public String getMnemonic() {
		return mnemonic;
	}

	public String toString() {
		return mnemonic;
	}

	protected String mnemonic;
}

