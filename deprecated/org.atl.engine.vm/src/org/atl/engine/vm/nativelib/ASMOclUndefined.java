package org.atl.engine.vm.nativelib;

import org.atl.engine.vm.StackFrame;

/**
 * @author Frédéric Jouault
 */
public class ASMOclUndefined extends ASMOclAny {

	public static ASMOclType myType = new ASMOclSimpleType("Void", getOclAnyType());

	public ASMOclUndefined() {
		super(myType);
	}

	public String toString() {
		return "OclUndefined";
	}

	public boolean equals(Object o) {
		return o instanceof ASMOclUndefined;
	}
	
	public int hashCode() {
		return 0;
	}

	public ASMOclAny get(StackFrame frame, String name) {
		frame.printStackTrace("ERROR: OclUndefined has no property");
		return null;
	}

	// Native Operations Below

	public static ASMBoolean oclIsUndefined(StackFrame frame, ASMOclUndefined self) {
		return new ASMBoolean(true);
	}

	public static ASMBoolean operatorEQ(StackFrame frame, ASMOclUndefined self, ASMOclAny o) {
		return new ASMBoolean(o instanceof ASMOclUndefined);
	}

	public static ASMBoolean operatorNE(StackFrame frame, ASMOclUndefined self, ASMOclAny o) {
		return new ASMBoolean(!(o instanceof ASMOclUndefined));
	}

	public static ASMSequence asSequence(StackFrame frame, ASMOclAny self) {
		ASMSequence ret = new ASMSequence();

		return ret;
	}

	public static ASMSet asSet(StackFrame frame, ASMOclAny self) {
		ASMSet ret = new ASMSet();

		return ret;
	}

	public static ASMBag asBag(StackFrame frame, ASMOclAny self) {
		ASMBag ret = new ASMBag();

		return ret;
	}
}

