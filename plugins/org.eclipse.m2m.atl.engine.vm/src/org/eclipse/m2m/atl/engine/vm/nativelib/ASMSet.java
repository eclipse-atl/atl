package org.eclipse.m2m.atl.engine.vm.nativelib;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * @author Frédéric Jouault
 */
public class ASMSet extends ASMCollection {

	public static ASMOclType myType = ASMOclParametrizedType.getASMOclParametrizedType("Set", getOclAnyType(), ASMCollection.myType);

	public ASMSet() {
		super(myType);
		s = new HashSet();
	}

	public ASMSet(ASMSet init) {
		super(myType);
		s = new HashSet(init.s);
	}

	public ASMSet(Collection init) {
		super(myType);
		s = new HashSet(init);
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();

		ret.append("Set {");
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
		return (o instanceof ASMSet) && (((ASMSet)o).s.equals(s));
	}

	public int hashCode() {
		return s.hashCode();
	}

	// Native Operations below

	// TODO: union(s : Set(T)) : Set(T)
	// TODO: union(bag : Bag(T)) : Bag(T)
	public static ASMSet union(StackFrame frame, ASMSet self, ASMCollection other) {
		ASMSet ret = new ASMSet(self);

		ret.s.addAll(other.collection());

		return ret;
	}

	// = already in ASMOclAny
	
	// TODO: intersection(s : Set(T)) : Set(T)
	// TODO: intersection(bag : Bag(T)) : Set(T)
	public static ASMSet intersection(StackFrame frame, ASMSet self, ASMCollection other) {
		ASMSet ret = new ASMSet(self);

		ret.s.retainAll(other.collection());

		return ret;
	}

	
	public static ASMSet operatorMinus(StackFrame frame, ASMSet self, ASMSet other) {
		ASMSet ret = new ASMSet(self);
		
		ret.s.removeAll(other.s);
		
		return ret;
	}

	public static ASMSet including(StackFrame frame, ASMSet self, ASMOclAny o) {
		ASMSet ret = new ASMSet(self);

		ret.s.add(o);

		return ret;
	}

	public static ASMSet excluding(StackFrame frame, ASMSet self, ASMOclAny o) {
		ASMSet ret = new ASMSet(self);

		ret.s.remove(o);

		return ret;
	}
	
	// symmetricDifference(s : Set(T)) : Set(T)
	public static ASMSet symetricDifference(StackFrame frame, ASMSet self, ASMSet other) {
		ASMSet ret = new ASMSet(self);
		
		Set t = new HashSet(other.s);
		t.removeAll(self.s);
		
		ret.s.removeAll(other.s);
		ret.s.addAll(t);
		
		return ret;
	}

	
	
	// count already in ASMCollection
	
	// TODO: flatten() : Set(T2)

	public static ASMSet asSet(StackFrame frame, ASMSet self) {
		return self;
	}

	private Set s;
}
