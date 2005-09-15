package org.atl.engine.vm.nativelib;

import org.atl.engine.vm.NativeOperation;
import org.atl.engine.vm.StackFrame;

/**
 * @author Frédéric Jouault
 */
public class ASMBoolean extends ASMOclAny {

	public static ASMOclType myType = new ASMOclSimpleType("Boolean", getOclAnyType());
	static {
		NativeOperation.registerOperations(myType, ASMBoolean.class);
	}

	public ASMBoolean(boolean s) {
		super(myType);
		this.s = s;
	}

	public String toString() {
		return "" + s;
	}

	public boolean getSymbol() {
		return s;
	}

	public int hashCode() {
		return s ? 1 : 0;
	}

	public boolean equals(Object o) {
		return (o instanceof ASMBoolean) && (((ASMBoolean)o).s == s);
	}

	// Native Operations below

	public static ASMBoolean not(StackFrame frame, ASMBoolean self) {
		return new ASMBoolean(!self.s);
	}

	public static ASMBoolean and(StackFrame frame, ASMBoolean self, ASMBoolean o) {
		return new ASMBoolean(self.s && o.s);
	}

	public static ASMBoolean or(StackFrame frame, ASMBoolean self, ASMBoolean o) {
		return new ASMBoolean(self.s || o.s);
	}

	public static ASMBoolean xor(StackFrame frame, ASMBoolean self, ASMBoolean o) {
		return new ASMBoolean(self.s ^ o.s);
	}

	public static ASMBoolean implies(StackFrame frame, ASMBoolean self, ASMBoolean o) {
		return new ASMBoolean((!self.s) || (self.s && o.s));
	}

	public static ASMString toString(StackFrame frame, ASMBoolean self) {
		return new ASMString(self.s ? "true" : "false");
	}

	private boolean s;
}

