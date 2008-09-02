/*******************************************************************************
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - bag implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm.lib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Bag collection implementation
 *
 * @author William Piers <a href="mailto:william.piers@obeo.fr">william.piers@obeo.fr</a>
 */
public class Bag implements Collection {

	/**
	 * An internal map storing objects and the number of their occurences
	 */
	private Map map;

	/**
	 * Constructor.
	 */
	public Bag() {
		map = new HashMap();
	}

	/**
	 * Constructor parametriezd with an existing collection.
	 * @param arg0
	 */
	public Bag(Collection arg0) {
		map = new HashMap();
		addAll(arg0);
	}
	
	/* (non-Javadoc)
	 * @see java.util.Collection#add(E)
	 */
	private static final Integer ONE = new Integer(1);
	public boolean add(Object arg0) {
		if (!contains(arg0)) {
			map.put(arg0, ONE);
		}
		else {
			Integer val = (Integer)map.get(arg0);
			int prev = val.intValue();
			int cur = prev + 1;
			map.put(arg0, new Integer(cur));
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#addAll(java.util.Collection)
	 */
	public boolean addAll(Collection arg0) {
		for (Iterator iterator = arg0.iterator(); iterator.hasNext();) {
			Object object = iterator.next();
			add(object);
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#clear()
	 */
	public void clear() {
		map = Collections.EMPTY_MAP;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#contains(java.lang.Object)
	 */
	public boolean contains(Object arg0) {
		return map.containsKey(arg0);
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#containsAll(java.util.Collection)
	 */
	public boolean containsAll(Collection arg0) {
		for (Iterator iterator = arg0.iterator(); iterator.hasNext();) {
			Object object = iterator.next();
			if (!contains(object)) {
				return false;				
			}
		}
		return true;
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#remove(java.lang.Object)
	 */
	public boolean remove(Object arg0) {
		if (!contains(arg0))
		{
			return false;
		}
		Integer val = (Integer)map.get(arg0);
		int prev = val.intValue();
		int cur = prev - 1;
		if (cur >= 1)
		{
			map.put(arg0, new Integer(cur));
		}
		else
		{
			map.remove(arg0);
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.util.Collection#removeAll(java.util.Collection)
	 */
	public boolean removeAll(Collection arg0) {
		for (Iterator iterator = arg0.iterator(); iterator.hasNext();) {
			Object object = iterator.next();
			remove(object);
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#size()
	 */
	public int size() {
		int res = 0;
		for (Iterator iterator = map.values().iterator(); iterator.hasNext();) {
			Integer value = (Integer) iterator.next();
			res+=value.intValue();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see java.util.Collection#iterator()
	 */
	public Iterator iterator(){
		List iterable = new ArrayList();
		for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
			Entry entry = (Entry) iterator.next();
			for (int i = 0; i < ((Integer)entry.getValue()).intValue(); i++) {
				iterable.add(entry.getKey());				
			}
		}		
		return iterable.iterator();
	}
	
	/* (non-Javadoc)
	 * @see java.util.Collection#retainAll(java.util.Collection)
	 */
	public boolean retainAll(Collection arg0) {
		for (Iterator iterator = iterator(); iterator.hasNext();) {
			Object object = iterator.next();
			if (!arg0.contains(object)) {
				remove(object);
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#toArray()
	 */
	public Object[] toArray() {
		Object[] res = new Object[size()];
		int i = 0;
		for (Iterator iterator = iterator(); iterator.hasNext();) {
			Object object = iterator.next();
			res[i] = object;
			i++;
		}
		return res;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#toArray(T[])
	 */
	public Object[] toArray(Object[] arg0) {
		int i = 0;
		for (Iterator iterator = iterator(); iterator.hasNext();) {
			Object object = iterator.next();
			arg0[i] = object;
			i++;
		}
		return arg0;
	}
	
}