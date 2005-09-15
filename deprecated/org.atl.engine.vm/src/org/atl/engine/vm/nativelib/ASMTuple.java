package org.atl.engine.vm.nativelib;

import org.atl.engine.vm.NativeOperation;
import org.atl.engine.vm.StackFrame;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Frédéric Jouault
 */
public class ASMTuple extends ASMOclAny {

	public static ASMOclType myType = new ASMOclSimpleType("Tuple", getOclAnyType());	// TODO : type parametre
	static {
		NativeOperation.registerOperations(myType, ASMTuple.class);
	}

	public ASMTuple() {
		super(myType);
		s = new HashMap();
	}

	public ASMTuple(ASMTuple init) {
		super(myType);
		s = new HashMap(init.s);
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();

		ret.append("Tuple {");
		for(Iterator i = s.keySet().iterator() ; i.hasNext() ; ) {
			Object n = i.next();
			Object o = s.get(n);
			ret.append(((ASMString)n).getSymbol());
			ret.append(" = ");
			ret.append(o);
			if(i.hasNext()) ret.append(", ");
		}
		ret.append("}");

		return ret.toString();
	}

	public boolean equals(Object o) {
		return (o instanceof ASMTuple) && (((ASMTuple)o).s.equals(s));
	}
	
	public int hashCode() {
		return s.hashCode();
	}

	public ASMOclAny get(StackFrame frame, String name) {
		ASMOclAny ret = null;

		if(isHelper(frame, name)) {
			ret = getHelper(frame, name);
		} else {
			ret = (ASMOclAny)s.get(new ASMString(name));
			if(ret == null) ret = new ASMOclUndefined();
		}

		return ret;
	}

	public void set(StackFrame frame, String name, ASMOclAny value) {
		s.put(new ASMString(name), value);
		Map attrs = new HashMap();
		for(Iterator i = s.keySet().iterator() ; i.hasNext() ; ) {
			ASMString n = (ASMString)i.next();
			attrs.put(n.getSymbol(), ASMOclAny.myType);		// TODO: correct type
		}
		setType(new ASMTupleType(attrs));
	}

	// Native Operations below
	
	public static ASMMap asMap(StackFrame frame, ASMTuple self) {
		return new ASMMap(self.s);
	}

	private Map s;
}

