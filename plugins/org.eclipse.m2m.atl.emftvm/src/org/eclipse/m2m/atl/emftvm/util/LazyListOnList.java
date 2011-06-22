/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * {@link LazyList} that passes method calls through to the underlying
 * {@link List}, where possible, instead of going via {@link Iterator}s. 
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 *
 * @param <E>
 */
public class LazyListOnList<E> extends LazyListOnCollection<E> {

	/**
	 * Creates a new {@link LazyListOnList} around <code>dataSource</code>.
	 * @param dataSource
	 */
	public LazyListOnList(final List<E> dataSource) {
		super(dataSource);
	}

	/* *********************************************************************
	 * Non-lazy operations                                                 *
	 * *********************************************************************/

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.LazyList#get(int)
	 */
	public E get(final int index) {
		return ((List<E>) dataSource).get(index);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.LazyList#indexOf(java.lang.Object)
	 */
	public int indexOf(final Object o) {
		return ((List<E>) dataSource).indexOf(o);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.LazyList#lastIndexOf(java.lang.Object)
	 */
	public int lastIndexOf(final Object o) {
		return ((List<E>) dataSource).lastIndexOf(o);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.LazyList#listIterator()
	 */
	public ListIterator<E> listIterator() {
		return ((List<E>) dataSource).listIterator();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.LazyList#listIterator(int)
	 */
	public ListIterator<E> listIterator(final int index) {
		return ((List<E>) dataSource).listIterator(index);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.LazyList#subList(int, int)
	 */
	public List<E> subList(final int fromIndex, final int toIndex) {
		return ((List<E>) dataSource).subList(fromIndex, toIndex);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#toArray()
	 */
	public Object[] toArray() {
		return ((List<E>) dataSource).toArray();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#toArray(T[])
	 */
	public <T> T[] toArray(T[] a) {
		return ((List<E>) dataSource).toArray(a);
	}

	/**
	 * Returns the first element in self.
	 * @return The first element in self.
	 */
	public E first() {
		return get(0);
	}

	/**
	 * Returns the last element in self.
	 * @return The last element in self.
	 */
	public E last() {
		return get(size() - 1);
	}

}
