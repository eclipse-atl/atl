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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * @author Frédéric Jouault
 */
public class ASMSequence extends ASMCollection {

	public static ASMOclType myType = ASMOclParametrizedType.getASMOclParametrizedType("Sequence", getOclAnyType(), ASMCollection.myType);

	public ASMSequence() {
		super(myType);
		s = new ArrayList();
	}

	public ASMSequence(ASMSequence init) {
		super(myType);
		s = new ArrayList(init.s);
	}

	public ASMSequence(Collection init) {
		super(myType);
		s = new ArrayList(init);
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();

		ret.append("Sequence {");
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

	public void add(int index, ASMOclAny o) {
		s.add(index, o);
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
		return (o instanceof ASMSequence) && (((ASMSequence)o).s.equals(s));
	}

	public int hashCode() {
		return s.hashCode();
	}
	
	// Native Operations below
	
	// count already in ASMCollection
	
	// = already in ASMOclAny

	public static ASMSequence union(StackFrame frame, ASMSequence self, ASMCollection other) {
		ASMSequence ret = new ASMSequence(self);

		ret.s.addAll(other.collection());

		return ret;
	}

	public static ASMSequence flatten(StackFrame frame, ASMSequence self) {
		List base = null;
		List ret = new ArrayList(self.collection());
		boolean containsCollection;
		do {
			base = ret;
			ret = new ArrayList();
			containsCollection = false;
			for (int i = 0; i < base.size(); i++) {
				ASMOclAny object = (ASMOclAny) base.get(i);
				if (object instanceof ASMCollection) {
					ASMCollection subCollection = (ASMCollection) object;
					ret.addAll(subCollection.collection());
					Iterator iterator = subCollection.iterator();
					while (containsCollection == false && iterator.hasNext()) {
						ASMOclAny subCollectionObject = (ASMOclAny) iterator.next();
						if (subCollectionObject instanceof ASMCollection) {
							containsCollection = true;
						}
					}
				} else {
					ret.add(object);
				}
			}
		} while (containsCollection);
		return new ASMSequence(ret);
	}
	
	public static ASMSequence append(StackFrame frame, ASMSequence self, ASMOclAny o) {
		return including(frame, self, o);
	}

	public static ASMSequence prepend(StackFrame frame, ASMSequence self, ASMOclAny o) {
		return insertAt(frame, self, new ASMInteger(1), o);
	}

	public static ASMSequence insertAt(StackFrame frame, ASMSequence self, ASMInteger index, ASMOclAny o) {
		ASMSequence ret = new ASMSequence(self);

		ret.s.add(index.getSymbol() - 1, o);

		return ret;
	}

	public static ASMSequence subSequence(StackFrame frame, ASMSequence self, ASMInteger lower, ASMInteger upper) {
		ASMSequence ret = new ASMSequence();
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

	public static ASMOclAny at(StackFrame frame, ASMSequence self, ASMInteger i) {
		return (ASMOclAny)self.s.get(i.getSymbol() - 1);
	}

	public static ASMInteger indexOf(StackFrame frame, ASMSequence self, ASMOclAny o) {
		return new ASMInteger(self.s.indexOf(o) + 1);
	}

	public static ASMOclAny first(StackFrame frame, ASMSequence self) {
		return (self.s.size() == 0) ? new ASMOclUndefined() : (ASMOclAny)self.s.get(0);
	}

	public static ASMOclAny last(StackFrame frame, ASMSequence self) {
		return (self.s.size() == 0) ? new ASMOclUndefined() : (ASMOclAny)self.s.get(self.s.size() - 1);
	}

	public static ASMSequence including(StackFrame frame, ASMSequence self, ASMOclAny o) {
		ASMSequence ret = new ASMSequence(self);

		ret.s.add(o);

		return ret;
	}

	public static ASMSequence excluding(StackFrame frame, ASMSequence self, ASMOclAny o) {
		ASMSequence ret = new ASMSequence(self);

		ret.s.removeAll(Arrays.asList(new ASMOclAny[] {o}));

		return ret;
	}

	public static ASMSequence asSequence(StackFrame frame, ASMSequence self) {
		return self;
	}

	private ArrayList s;
}

