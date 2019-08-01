/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm.nativelib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
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

	public static ASMBag including(StackFrame frame, ASMBag self, ASMOclAny o) {
		ASMBag ret = new ASMBag(self);

		ret.s.add(o);

		return ret;
	}
	
	public static ASMBag excluding(StackFrame frame, ASMBag self, ASMOclAny o) {
		ASMBag ret = new ASMBag(self);

		ret.s.removeAll(Arrays.asList(new ASMOclAny[] {o}));

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
	
	public static ASMBag flatten(StackFrame frame, ASMBag self) {
		List base = null;
		List ret = new ArrayList(self.collection());
		boolean containsCollection;
		do {
			containsCollection = false;
			base = ret;
			ret = new ArrayList();
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
		return new ASMBag(ret);
	}
	
	private List s;
}

