package org.eclipse.m2m.atl.engine.vm.nativelib;

import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * An OclType for parameterized types, principally collections.
 * @author Frédéric Jouault
 */
public class ASMOclParametrizedType extends ASMOclType {

	public static ASMOclType myType = new ASMOclSimpleType("OclParametrizedType", ASMOclType.myType);

	public static ASMOclParametrizedType getASMOclParametrizedType(String name, ASMOclType elementType, ASMOclType supertype) {
		return new ASMOclParametrizedType(name, elementType, supertype);
	}

	public ASMOclParametrizedType() {
		super(myType);
	}

	public ASMOclParametrizedType(String name, ASMOclType elementType, ASMOclType supertype) {
		super(myType);
		this.name = name;
		this.elementType = elementType;
		addSupertype(supertype);
	}

	public String toString() {
		return name + "(" + elementType + ")";
	}

	public String getName() {
		return name;
	}

	public ASMOclType getElementType() {
		return elementType;
	}

	private boolean equals(Object o1, Object o2) {
		boolean ret = false;

		if(o1 == null) {
			ret = (o2 == null);
		} else {
			ret = o1.equals(o2);
		}

		return ret;
	}

	public boolean equals(Object other) {
		boolean ret = false;

		if(other instanceof ASMOclParametrizedType) {
			if(equals(name, ((ASMOclParametrizedType)other).name)) {
				ret = equals(elementType, ((ASMOclParametrizedType)other).elementType);
			}
		}

		return ret;
	}

	public ASMBoolean conformsTo(ASMOclType other) {
		boolean ret = false;

		if(other instanceof ASMOclParametrizedType) {
			ASMOclParametrizedType aopt = (ASMOclParametrizedType)other;
			if(aopt.name.equals("Collection")) {
				ret = elementType.conformsTo(aopt.elementType).getSymbol();
			} else {
				ret = aopt.name.equals(name) && elementType.conformsTo(aopt.elementType).getSymbol();
			}
		}
		return new ASMBoolean(ret);
	}

	// Native Operations below

	public static ASMBoolean conformsTo(StackFrame frame, ASMOclParametrizedType self, ASMOclType other) {
		return self.conformsTo(other);
	}

	public static void setName(StackFrame frame, ASMOclParametrizedType self, ASMString name) {
		self.name = name.getSymbol();
	}

	public static void setElementType(StackFrame frame, ASMOclParametrizedType self, ASMOclType elementType) {
		self.elementType = elementType;
	}

	private String name = "<unamedyet>";
	private ASMOclType elementType;
}

