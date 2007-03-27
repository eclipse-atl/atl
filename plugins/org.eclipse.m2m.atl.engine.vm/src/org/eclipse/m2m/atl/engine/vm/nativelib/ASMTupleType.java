package org.eclipse.m2m.atl.engine.vm.nativelib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * @author Frédéric Jouault
 */
public class ASMTupleType extends ASMOclType {

	public static ASMOclType myType = new ASMOclSimpleType("TupleType", ASMOclType.myType);

	public ASMTupleType() {
		this(new HashMap());
	}

	public ASMTupleType(Map attributes) {
		super(myType);
		this.attributes = attributes;
		addSupertype(ASMTuple.myType);
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();

		ret.append("TupleType(");
		for(Iterator i = attributes.keySet().iterator() ; i.hasNext() ; ) {
			Object n = i.next();
			Object o = attributes.get(n);
			ret.append((String)n);
			ret.append(" : ");
			ret.append(o);
			if(i.hasNext()) ret.append(", ");
		}
		ret.append(")");

		return ret.toString();
	}

	public boolean equals(Object o) {
		return (o instanceof ASMTupleType) && (((ASMTupleType)o).attributes.equals(attributes));
	}
	
	public int hashCode() {
		return attributes.hashCode();
	}

	private Map attributes;

	public ASMBoolean conformsTo(ASMOclType other) {
		boolean ret = equals(other);
		
		if(!ret) {
			
		}
		
		return new ASMBoolean(ret);
	}

	public String getName() {
		return toString();
	}
	
	// Native Operations below

	public static void addAttribute(StackFrame frame, ASMTupleType self, ASMString name, ASMOclType type) {
		self.attributes.put(name.getSymbol(), type);
	}
}
