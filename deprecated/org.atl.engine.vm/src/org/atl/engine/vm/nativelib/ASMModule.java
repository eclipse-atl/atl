package org.atl.engine.vm.nativelib;

import java.util.HashMap;
import java.util.Map;

import org.atl.engine.vm.ASM;
import org.atl.engine.vm.StackFrame;

/**
 * @author Frédéric Jouault
 */
public class ASMModule extends ASMOclAny {

	public static ASMOclType myType = new ASMOclSimpleType("Module", getOclAnyType());
	public ASMModule(ASM asm) {
		super(myType);
		this.asm = asm;
	}

	public ASMOclAny get(StackFrame frame, String name) {
		return (ASMOclAny)fields.get(name);
	}

	public void set(StackFrame frame, String name, ASMOclAny value) {
		fields.put(name, value);
	}

	public String toString() {
		return asm.getName() + " : ASMModule";
	}

	public String getName() {
		return asm.getName();
	}

	private Map fields = new HashMap();
	private ASM asm;
}

