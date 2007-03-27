package org.eclipse.m2m.atl.engine.vm.nativelib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * @author Frédéric Jouault
 */
public class ASMBag extends ASMCollection {

	public static ASMOclType myType = ASMOclParametrizedType.getASMOclParametrizedType("Bag", getOclAnyType(), ASMCollection.myType);

	public ASMBag() {
		super(myType);
		s = new ArrayList();
	}

	public ASMBag(ASMBag init) {
		super(myType);
		s = new ArrayList(init.s);
	}

	public ASMBag(Collection init) {
		super(myType);
		s = new ArrayList(init);
	}

	public ASMBag including(ASMOclAny o) {
		ASMBag ret = new ASMBag(this);

		ret.s.add(o);

		return ret;
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();

		ret.append("Bag {");
		for(Iterator i = s.iterator() ; i.hasNext() ; ) {
			ret.append(i.next());
			if(i.hasNext()) ret.append(", ");
		}
		ret.append("}");

		return ret.toString();
	}

	public void add(ASMOclAny o) {
		s.add(o);
	}

	public Iterator iterator() {
		return s.iterator();
	}

	public Collection collection() {
		return s;
	}

	public boolean equals(Object o) {
		return (o instanceof ASMBag) && (((ASMBag)o).s.equals(s));
	}

	public int hashCode() {
		return s.hashCode();
	}
	
	// Native operations below
	
	public static ASMBag asBag(StackFrame frame, ASMBag self) {
		return self;
	}
	
	private List s;
}

