package org.atl.engine.vm;

import org.atl.engine.vm.nativelib.ASMOclAny;
import org.atl.engine.vm.nativelib.ASMOclSimpleType;
import org.atl.engine.vm.nativelib.ASMOclType;
import org.atl.engine.vm.nativelib.ASMOclUndefined;
import org.atl.engine.vm.nativelib.ASMSequence;
import org.atl.engine.vm.nativelib.ASMString;
import org.atl.engine.vm.nativelib.ASMTuple;

import java.util.Iterator;
import java.util.List;

/**
 * @author Frédéric Jouault
 */
public abstract class Operation extends ASMOclAny {

	public static ASMOclType myType = new ASMOclSimpleType("Operation", getOclAnyType());
	static {
		//NativeOperation.registerOperations(myType, ASMOperation.class, true, false, true, true);
	}

	public Operation() {
		super(myType);
	}


	public abstract String getName();

	public abstract String getContext();

	public abstract List getParameters();
	
	public abstract ASMOclType getReturnType();

	public abstract String getSignature();

	public abstract ASMOclAny exec(StackFrame frame);
	
	public ASMOclAny get(StackFrame frame, String name) {
		ASMOclAny ret = null;
		
		if(name.equals("parameters")) {
			List params = getParameters();
			if(params != null) {
				ret = new ASMSequence();
				int paramId = 1;
				for(Iterator i = params.iterator() ; i.hasNext() ; ) {
					Object o = i.next();
					String paramName = "p" + paramId++;
					ASMOclAny type = new ASMOclUndefined();
					if(o instanceof ASMParameter) {
						ASMParameter param = (ASMParameter)o;
						paramName = param.getName();
					} else if(o instanceof ASMOclType) {
						type = (ASMOclType)o;
					}
					ASMTuple t = new ASMTuple();
					t.set(frame, "varName", new ASMString(paramName));
					t.set(frame, "operation", this);
					t.set(frame, "type", type);	// TODO
					((ASMSequence)ret).add(t);
				}
			} else {
				ret = new ASMSequence();
			}
		} else if(name.equals("returnType")) {
			ASMOclType rt = getReturnType();
			if(rt == null) {
				ret = new ASMOclUndefined();
			} else {
				ret = rt;
			}
		} else if(name.equals("name")) {
			ret = new ASMString(getName());
		} else if(name.equals("definition")) {
			ASMTuple t = new ASMTuple();
			ASMTuple t2 = new ASMTuple();
			t.set(frame, "feature", this);
			t.set(frame, "context_", t2);
			t2.set(frame, "context_", new ASMOclUndefined());	// TODO
			t2.set(frame, "definition", t);	// TODO
			ret = t;
		} else {
			ret = super.get(frame, name);
		}
		
		return ret;
	}
}

