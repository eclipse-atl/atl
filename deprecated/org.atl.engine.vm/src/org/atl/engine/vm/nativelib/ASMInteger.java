package org.atl.engine.vm.nativelib;

import org.atl.engine.vm.NativeOperation;
import org.atl.engine.vm.StackFrame;

/**
 * @author Frédéric Jouault
 */
public class ASMInteger extends ASMNumber {

	public static ASMOclType myType = new ASMOclSimpleType("Integer", ASMReal.myType);
	static {
		NativeOperation.registerOperations(myType, ASMInteger.class);
	}

	public ASMInteger(int s) {
		super(myType);
		this.s = s;
	}

	public String toString() {
		return "" + s;
	}

	public int getSymbol() {
		return s;
	}
	
	public double asDouble() {
		return s;
	}

	public boolean equals(Object o) {
		return (o instanceof ASMInteger) && (((ASMInteger)o).s == s);
	}
	
	public int hashCode() {
		return s;
	}

	// Native Operations below

	public static ASMInteger abs(StackFrame frame, ASMInteger self) {
		return new ASMInteger((self.s < 0) ? -self.s : self.s);
	}

	public static ASMInteger mod(StackFrame frame, ASMInteger self, ASMInteger o) {
		return new ASMInteger(self.s % o.s);
	}

	public static ASMInteger div(StackFrame frame, ASMInteger self, ASMInteger o) {
		return new ASMInteger(self.s / o.s);
	}
	
	public static ASMInteger max(StackFrame frame, ASMInteger self, ASMInteger o) {
		return new ASMInteger(Math.max(self.s, o.s));
	}

	public static ASMInteger min(StackFrame frame, ASMInteger self, ASMInteger o) {
		return new ASMInteger(Math.max(self.s, o.s));
	}
	
/* TODO: operation overloading is not supported yet.
	public static ASMInteger operatorMinus(StackFrame frame, ASMInteger self) {
		return new ASMInteger(-self.s);
	}
*/
	public static ASMNumber operatorMinus(StackFrame frame, ASMInteger self, ASMNumber o) {
		if(o instanceof ASMInteger) {
			return new ASMInteger(self.s - ((ASMInteger)o).s);
		}
	    return new ASMReal(self.s - o.asDouble());
	}

	public static ASMNumber operatorPlus(StackFrame frame, ASMInteger self, ASMNumber o) {
		if(o instanceof ASMInteger) {
			return new ASMInteger(self.s + ((ASMInteger)o).s);
		}
	    return new ASMReal(self.s + o.asDouble());
	}

	public static ASMNumber operatorMul(StackFrame frame, ASMInteger self, ASMNumber o) {
		if(o instanceof ASMInteger) {
			return new ASMInteger(self.s * ((ASMInteger)o).s);
		}
		return new ASMReal(self.s * o.asDouble());
	}

	public static ASMReal operatorDiv(StackFrame frame, ASMInteger self, ASMNumber o) {//Second parameter should be ASMReal
		return new ASMReal(self.s / o.asDouble());
	}
	
	public static ASMBoolean operatorEQ(StackFrame frame, ASMInteger self, ASMNumber o) {
		if(o instanceof ASMInteger) {
			return new ASMBoolean(self.s == ((ASMInteger)o).s);
		}
		return new ASMBoolean(self.s == o.asDouble());			
	}

	public static ASMBoolean operatorNE(StackFrame frame, ASMInteger self, ASMNumber o) {
		if(o instanceof ASMInteger) {
			return new ASMBoolean(self.s != ((ASMInteger)o).s);
		}
		return new ASMBoolean(self.s != o.asDouble());			
	}

	public static ASMBoolean operatorLT(StackFrame frame, ASMInteger self, ASMNumber o) {
		if(o instanceof ASMInteger) {
			return new ASMBoolean(self.s < ((ASMInteger)o).s);
		}
		return new ASMBoolean(self.s < o.asDouble());			
	}

	public static ASMBoolean operatorLE(StackFrame frame, ASMInteger self, ASMNumber o) {
		if(o instanceof ASMInteger) {
			return new ASMBoolean(self.s <= ((ASMInteger)o).s);
		}
		return new ASMBoolean(self.s <= o.asDouble());			
	}

	public static ASMBoolean operatorGT(StackFrame frame, ASMInteger self, ASMNumber o) {
		if(o instanceof ASMInteger) {
			return new ASMBoolean(self.s > ((ASMInteger)o).s);
		}
		return new ASMBoolean(self.s > o.asDouble());			
	}

	public static ASMBoolean operatorGE(StackFrame frame, ASMInteger self, ASMNumber o) {
		if(o instanceof ASMInteger) {
			return new ASMBoolean(self.s >= ((ASMInteger)o).s);
		}
		return new ASMBoolean(self.s >= o.asDouble());			
	}

	public static ASMString toString(StackFrame frame, ASMInteger self) {
		return new ASMString("" + self.s);
	}

	// additional operations, not in OCL standard library
	
	public static ASMString toHexString(StackFrame frame, ASMInteger self) {
		return new ASMString(Integer.toHexString(self.s));
	}
	
	public static ASMString toBinaryString(StackFrame frame, ASMInteger self) {
		return new ASMString(Integer.toBinaryString(self.s));
	}
	
	private int s;
}

