package org.eclipse.m2m.atl.engine.vm.nativelib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.m2m.atl.engine.vm.ASMExecEnv;
import org.eclipse.m2m.atl.engine.vm.Operation;
import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * @author Frédéric Jouault
 */
public class ASMOclAny extends ASMNativeObject {

	public static ASMOclType myType = getOclAnyType();

	static {
		ASMOclType.myType.addSupertype(getOclAnyType());
	}

	private static ASMOclType oclAnyType = null;
	protected static ASMOclType getOclAnyType() {
		if(oclAnyType == null)
			oclAnyType = new ASMOclSimpleType("OclAny");
		return oclAnyType;
	}
	public ASMOclAny(ASMOclType type) {
		this.type = type;
	}

	public void setType(ASMOclType type) {
		this.type = type;
	}

	public ASMOclType getType() {
		return type;
	}

	public Operation findOperation(StackFrame frame, String opName, List arguments) {
		return findOperation(frame, opName, arguments, getType());
	}

	public Operation findOperation(StackFrame frame, String opName, List arguments, ASMOclType type) {
		return ((ASMExecEnv)frame.getExecEnv()).getOperation(type, opName);
	}

	// The Operation to execute on this object is searched for in its type.
	public ASMOclAny invoke(StackFrame frame, String opName, List arguments) {
		return invoke(frame, opName, arguments, getType());
	}
	
	public ASMOclAny invoke(StackFrame frame, String opName, List arguments, ASMOclType type) {
		ASMOclAny ret = null;
		
		Operation oper = findOperation(frame, opName, arguments, type);

		if(oper != null) {
			arguments.add(0, this);	// self
			ret = oper.exec(frame.enterFrame(oper, arguments));
		} else {
			frame.printStackTrace("ERROR: could not find operation " + opName + " on " + getType() + " having supertypes: " + getType().getSupertypes());
		}

		return ret;
	}

	public ASMOclAny get(StackFrame frame, String name) {
		if(isHelper(frame, name)) {
			return getHelper(frame, name);
		}
		frame.printStackTrace("ERROR: get unsupported on OclAny.");
		return null;
	}

	public void set(StackFrame frame, String name, ASMOclAny value) {
		frame.printStackTrace("ERROR: set unsupported on OclAny");
	}
	
	public ASMOclAny refImmediateComposite() {
		return new ASMOclUndefined();
	}
	
	public boolean isHelper(StackFrame frame, String name) {
		//return type.getHelperAttributes().containsKey(name);
		return ((ASMExecEnv)frame.getExecEnv()).getAttributeInitializer(type, name) != null;
	}
	
	public ASMOclAny getHelper(StackFrame frame, String name) {
		return ((ASMExecEnv)frame.getExecEnv()).getHelperValue(frame, this, name);
	}

	// Native Operations below

	public static ASMBoolean oclIsUndefined(StackFrame frame, ASMOclAny self) {
		return new ASMBoolean(false);
	}

	public static ASMString toString(StackFrame frame, ASMOclAny self) {
		return new ASMString(self.toString());
	}

	public static ASMOclType oclType(StackFrame frame, ASMOclAny self) {
		return self.type;
	}

	public static ASMBoolean oclIsKindOf(StackFrame frame, ASMOclAny self, ASMOclType otherType) {
		return self.type.conformsTo(otherType);
	}

	public static ASMBoolean oclIsTypeOf(StackFrame frame, ASMOclAny self, ASMOclType otherType) {
		return new ASMBoolean(self.type.equals(otherType));
	}

	public static ASMOclAny refSetValue(StackFrame frame, ASMOclAny self, ASMString name, ASMOclAny value) {
		self.set(frame, name.getSymbol(), value);
		return self;
	}

	public static ASMOclAny refGetValue(StackFrame frame, ASMOclAny self, ASMString name) {
		return self.get(frame, name.getSymbol());
	}

	public static ASMOclAny refImmediateComposite(StackFrame frame, ASMOclAny self) {
		return self.refImmediateComposite();
	}

	public static ASMOclAny refInvokeOperation(StackFrame frame, ASMOclAny self, ASMString opName_, ASMSequence arguments_) {
		ASMOclAny ret = null;

		String opName = opName_.getSymbol();
		ArrayList arguments = new ArrayList();
		for(Iterator i = arguments_.iterator() ; i.hasNext() ; )
			arguments.add(i.next());

		ret = self.invoke(frame, opName, arguments);
		
		return ret;
	}
	
	public static ASMOclAny operatorEQ(StackFrame frame, ASMOclAny self, ASMOclAny other) {
		return new ASMBoolean(self.equals(other));
	}

	public static ASMOclAny operatorNE(StackFrame frame, ASMOclAny self, ASMOclAny other) {
		return new ASMBoolean(!self.equals(other));
	}

	public static ASMSequence asSequence(StackFrame frame, ASMOclAny self) {
		ASMSequence ret = new ASMSequence();

		ret.add(self);

		return ret;
	}

	public static ASMSet asSet(StackFrame frame, ASMOclAny self) {
		ASMSet ret = new ASMSet();

		ret.add(self);

		return ret;
	}

	public static ASMBag asBag(StackFrame frame, ASMOclAny self) {
		ASMBag ret = new ASMBag();

		ret.add(self);

		return ret;
	}

	public static void output(StackFrame frame, ASMOclAny self) {
		System.out.println(self);
	}

	public static ASMOclAny debug(StackFrame frame, ASMOclAny self, ASMString msg) {
		System.out.println(msg.getSymbol() + ": " + self.toString());
		return self;
	}

	public static ASMOclAny check(StackFrame frame, ASMOclAny self, ASMString msg, ASMBoolean cond) {
		if(!cond.getSymbol()) {
			System.out.println(msg.getSymbol());
		}
		return self;
	}

	private ASMOclType type;
}

