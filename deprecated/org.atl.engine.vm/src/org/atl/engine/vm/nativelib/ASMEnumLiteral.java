package org.atl.engine.vm.nativelib;

import org.atl.engine.vm.NativeOperation;
import org.atl.engine.vm.StackFrame;

/**
 * @author Frédéric Jouault
 */
public class ASMEnumLiteral extends ASMOclAny {

	public static ASMOclType myType = new ASMOclSimpleType("EnumLiteral", getOclAnyType());	// TODO: type is Enumeration...
	static {
		NativeOperation.registerOperations(myType, ASMEnumLiteral.class);
	}

	public ASMEnumLiteral() {
		super(myType);
		this.name = null;
	}

	public ASMEnumLiteral(String name) {
		this();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void set(StackFrame frame, String name, ASMOclAny value) {
		if(name.equals("name")) {
			this.name = ((ASMString)value).getSymbol();
		} else {
			super.set(frame, name, value);
		}
	}

	public boolean equals(Object o) {
		return (o instanceof ASMEnumLiteral) && (((ASMEnumLiteral)o).name.equals(name));
	}

	public String toString() {
		return "#" + ((name == null) ? "<unnamed_yet>" : name);
	}

	// Native Operations below

	public static ASMString toString(StackFrame frame, ASMEnumLiteral self) {
		return new ASMString(self.name);
	}

	private String name;
}

