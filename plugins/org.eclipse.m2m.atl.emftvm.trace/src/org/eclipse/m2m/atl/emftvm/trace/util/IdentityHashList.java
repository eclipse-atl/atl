/*******************************************************************************
 * Copyright (c) 2017 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.trace.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * {@link List} that uses object identity equality and shallow identity hashes
 * for its elements.
 * 
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class IdentityHashList<E> implements List<E> {

	private final List<E> inner;

	/**
	 * Creates a new {@link IdentityHashList}.
	 * 
	 * @param inner
	 *            the inner {@link List} to delegate to
	 */
	public IdentityHashList(final List<E> inner) {
		this.inner = inner;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object o) {
		if (o == this)
			return true;
		if (!(o instanceof List))
			return false;

		final ListIterator<E> e1 = listIterator();
		final ListIterator<?> e2 = ((List<?>) o).listIterator();
		while (e1.hasNext() && e2.hasNext()) {
			E o1 = e1.next();
			Object o2 = e2.next();
			if (o1 != o2) {
				return false;
			}
		}
		return !(e1.hasNext() || e2.hasNext());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		int hashCode = 1;
		final Iterator<E> i = iterator();
		while (i.hasNext()) {
			E obj = i.next();
			hashCode = 31 * hashCode + (obj == null ? 0 : System.identityHashCode(obj));
		}
		return hashCode;
	}

	/**
	 * {@inheritDoc}
	 */
	public int size() {
		return inner.size();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isEmpty() {
		return inner.isEmpty();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean contains(Object o) {
		return inner.contains(o);
	}

	/**
	 * {@inheritDoc}
	 */
	public Iterator<E> iterator() {
		return inner.iterator();
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] toArray() {
		return inner.toArray();
	}

	/**
	 * {@inheritDoc}
	 */
	public <T> T[] toArray(T[] a) {
		return inner.toArray(a);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean add(E o) {
		return inner.add(o);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean remove(Object o) {
		return inner.remove(o);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean containsAll(Collection<?> c) {
		return inner.containsAll(c);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean addAll(Collection<? extends E> c) {
		return inner.addAll(c);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean addAll(int index, Collection<? extends E> c) {
		return inner.addAll(index, c);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean removeAll(Collection<?> c) {
		return inner.removeAll(c);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean retainAll(Collection<?> c) {
		return inner.retainAll(c);
	}

	/**
	 * {@inheritDoc}
	 */
	public void clear() {
		inner.clear();
	}

	/**
	 * {@inheritDoc}
	 */
	public E get(int index) {
		return inner.get(index);
	}

	/**
	 * {@inheritDoc}
	 */
	public E set(int index, E element) {
		return inner.set(index, element);
	}

	/**
	 * {@inheritDoc}
	 */
	public void add(int index, E element) {
		inner.add(index, element);
	}

	/**
	 * {@inheritDoc}
	 */
	public E remove(int index) {
		return inner.remove(index);
	}

	/**
	 * {@inheritDoc}
	 */
	public int indexOf(Object o) {
		return inner.indexOf(o);
	}

	/**
	 * {@inheritDoc}
	 */
	public int lastIndexOf(Object o) {
		return inner.lastIndexOf(o);
	}

	/**
	 * {@inheritDoc}
	 */
	public ListIterator<E> listIterator() {
		return inner.listIterator();
	}

	/**
	 * {@inheritDoc}
	 */
	public ListIterator<E> listIterator(int index) {
		return inner.listIterator(index);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<E> subList(int fromIndex, int toIndex) {
		return inner.subList(fromIndex, toIndex);
	}

}
