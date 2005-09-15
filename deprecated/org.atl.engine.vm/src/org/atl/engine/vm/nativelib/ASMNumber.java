package org.atl.engine.vm.nativelib;


/**
 * @author Frédéric Jouault
 */
public abstract class ASMNumber extends ASMOclAny {

	public ASMNumber(ASMOclType myType) {
		super(myType);
	}

	public abstract double asDouble();
}

