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
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * This class does not compile as of now. Consider it unimplemented.
 * @author Frédéric Jouault
 */
public class ASMOrderedSet extends ASMCollection {

	public static ASMOclType myType = ASMOclParametrizedType.getASMOclParametrizedType("OrderedSet", getOclAnyType(), ASMSet.myType);

	public ASMOrderedSet() {
		super(myType);
		s = new LinkedHashSet();
	}

	public ASMOrderedSet(ASMOrderedSet init) {
		super(myType);
		s = new LinkedHashSet(init.s);
	}

	public ASMOrderedSet(Collection init) {
		super(myType);
		s = new LinkedHashSet(init);
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();

		ret.append("OrderedSet {");
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

	public void add(Iterator i) {
		for( ; i.hasNext() ; ) {
			add((ASMOclAny)i.next());
		}
	}

	public Iterator iterator() {
		return s.iterator();
	}

	public Collection collection() {
		return s;
	}

	public boolean equals(Object o) {
		return (o instanceof ASMOrderedSet) && (((ASMOrderedSet)o).s.equals(s));
	}

	public int hashCode() {
		return s.hashCode();
	}
	
	// Native Operations below
	
	public static ASMOrderedSet append(StackFrame frame, ASMOrderedSet self, ASMOclAny o) {
		return including(frame, self, o);
	}

	public static ASMOrderedSet prepend(StackFrame frame, ASMOrderedSet self, ASMOclAny o) {
		return insertAt(frame, self, new ASMInteger(1), o);
	}

	public static ASMOrderedSet insertAt(StackFrame frame, ASMOrderedSet self, ASMInteger index, ASMOclAny o) {
		Set ret = new LinkedHashSet();
		
		int k = 0;
		int idx = index.getSymbol() - 1;
		for(Iterator i = self.s.iterator() ; i.hasNext() ; ) {
			if(k++ == idx)
				ret.add(o);
			ret.add(i.next());
		}

		return new ASMOrderedSet(ret);
	}

	public static ASMOrderedSet subOrderedSet(StackFrame frame, ASMOrderedSet self, ASMInteger lower, ASMInteger upper) {
		ASMOrderedSet ret = new ASMOrderedSet();
		int l = lower.getSymbol();
		int u = upper.getSymbol();

		int k = 1;
		for(Iterator i = self.iterator() ; i.hasNext() && (k <= u) ; ) {
			ASMOclAny object = (ASMOclAny)i.next();

			if(k >= l) {
				ret.add(object);
			}

			k++;
		}

		return ret;
	}

	public static ASMOclAny at(StackFrame frame, ASMOrderedSet self, ASMInteger i) {
		ASMOclAny ret = null;
		
		int k = 0;
		int idx = i.getSymbol() - 1;
		for(Iterator j = self.s.iterator() ; j.hasNext() && (ret == null) ; ) {
			if(k++ == idx)
				ret = (ASMOclAny)j.next();
			else
				j.next();
		}
		
		return ret;
	}

	public static ASMInteger indexOf(StackFrame frame, ASMOrderedSet self, ASMOclAny o) {
		int i = -2;
		
		int k = 1;
		for(Iterator j = self.s.iterator() ; j.hasNext() && (i < 0) ; ) {
			ASMOclAny p = (ASMOclAny)j.next(); 
			if(o.equals(p))
				i = k;
			k++;
		}
		
		return new ASMInteger(i);
	}

	public static ASMOclAny first(StackFrame frame, ASMOrderedSet self) {
		return (self.s.size() == 0) ? new ASMOclUndefined() : (ASMOclAny)self.s.iterator().next();
	}

	public static ASMOclAny last(StackFrame frame, ASMOrderedSet self) {
		ASMOclAny ret = null;

		if(self.s.size() == 0) {
			ret = new ASMOclUndefined();
		} else {		
			for(Iterator j = self.s.iterator() ; j.hasNext() ; ) {
				ret = (ASMOclAny)j.next();
			}
		}
		
		return ret;
	}

		
	// count already in ASMCollection
	
	// = already in ASMOclAny

	public static ASMOrderedSet union(StackFrame frame, ASMOrderedSet self, ASMCollection other) {
		ASMOrderedSet ret = new ASMOrderedSet(self);

		ret.s.addAll(other.collection());

		return ret;
	}
	
	public static ASMOrderedSet flatten(StackFrame frame, ASMOrderedSet self) {
		Set base = null;
		Set ret = new LinkedHashSet(self.collection());
		boolean containsCollection;
		do {
			base = ret;
			ret = new LinkedHashSet();
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
		return new ASMOrderedSet(ret);
	}

	public static ASMOrderedSet including(StackFrame frame, ASMOrderedSet self, ASMOclAny o) {
		ASMOrderedSet ret = new ASMOrderedSet(self);

		ret.s.add(o);

		return ret;
	}

	public static ASMOrderedSet excluding(StackFrame frame, ASMOrderedSet self, ASMOclAny o) {
		ASMOrderedSet ret = new ASMOrderedSet(self);

		ret.s.remove(o);

		return ret;
	}

	public static ASMOrderedSet asOrderedSet(StackFrame frame, ASMOrderedSet self) {
		return self;
	}

	private Set s;
}

