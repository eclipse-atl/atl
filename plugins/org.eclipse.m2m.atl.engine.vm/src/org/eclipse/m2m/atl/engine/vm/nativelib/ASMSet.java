/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frédéric Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
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
		
	public static ASMSet flatten(StackFrame frame, ASMSet self) {
		Set base = null;
		Set ret = new HashSet(self.collection());
		boolean containsCollection;
		do {
			base = ret;
			ret = new HashSet();
			containsCollection = false;
			Iterator iterator = base.iterator();
			while (iterator.hasNext()) {
				ASMOclAny object = (ASMOclAny) iterator.next();
				if (object instanceof ASMCollection) {
					ASMCollection subCollection = (ASMCollection) object;
					ret.addAll(subCollection.collection());
					Iterator subIterator = subCollection.iterator();
					while (containsCollection == false && subIterator.hasNext()) {
						ASMOclAny subCollectionObject = (ASMOclAny) subIterator.next();
						if (subCollectionObject instanceof ASMCollection) {
							containsCollection = true;
						}
					}
				} else {
					ret.add(object);
				}
			}
		} while (containsCollection);
		return new ASMSet(ret);
	}
	

	public static ASMSet asSet(StackFrame frame, ASMSet self) {
		return self;
	}

	private Set s;
}
