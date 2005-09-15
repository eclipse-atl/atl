package org.atl.engine.vm.nativelib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.atl.engine.vm.ASMExecEnv;
import org.atl.engine.vm.NativeOperation;
import org.atl.engine.vm.Operation;
import org.atl.engine.vm.StackFrame;

/**
 * @author Frédéric Jouault
 */
public abstract class ASMOclType extends ASMOclAny {

	private static Map typeOperations = new HashMap();
	
	public static Map getVMOperations() {
		return typeOperations;
	}

	public static ASMOclType myType = new ASMOclSimpleType("OclType");
	static {
		NativeOperation.registerOperations(myType, ASMOclType.class);
		myType.setType(myType);
		NativeOperation.registerOperations(myType, ASMOclSimpleType.class);
	}


	public ASMOclType(ASMOclType type) {
		super(type);
		supertypes = new ArrayList();
		subtypes = new ArrayList();
	}

	private static Map getVMOperations(ASMOclType type) {
		Map ret = (Map)typeOperations.get(type);

		if(ret == null) {
			ret = new HashMap();
			typeOperations.put(type, ret);
		}

		return ret;
	}

	// Only for VM operations
	public void registerVMOperation(Operation op) {
		getVMOperations(this).put(op.getName(), op);
	}

	public void addSupertype(ASMOclType supertype) {
		if(supertype != null) {
			supertypes.add(0, supertype);
			supertype.subtypes.add(this);
		}
	}

	public List getSupertypes() {
		return supertypes;
	}

	public List getSubtypes() {
		return subtypes;
	}

	public abstract ASMBoolean conformsTo(ASMOclType other);

	public abstract String getName();
	
	public ASMOclAny get(StackFrame frame, String name) {
		ASMOclAny ret = null;
		
		if(name.equals("name")) {
			ret = getName(frame, this);
		} else {
			ret = super.get(frame, name);
		}
		
		return ret;
	}

	// Native Operations below

	public static ASMString getName(StackFrame frame, ASMOclType self) {
		return new ASMString(self.getName());
	}
	
	public static ASMBoolean conformsTo(StackFrame frame, ASMOclType self, ASMOclType other) {
		return self.conformsTo(other);
	}
	
	public static void registerHelperAttribute(StackFrame frame, ASMOclType self, ASMString name, ASMString initOperationName) {
		ASMExecEnv aee = ((ASMExecEnv)frame.getExecEnv());
		aee.registerAttributeHelper(self, name.getSymbol(), aee.getOperation(self, initOperationName.getSymbol()));
	}

	private List supertypes;
	private List subtypes;
}

