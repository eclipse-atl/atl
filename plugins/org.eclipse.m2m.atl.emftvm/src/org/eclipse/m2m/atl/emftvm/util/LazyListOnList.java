/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * {@link LazyList} that passes method calls through to the underlying
 * {@link List}, where possible, instead of going via iterators. 
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 *
 * @param <E>
 */
public class LazyListOnList<E> extends LazyListOnCollection<E> {

	/**
	 * Creates a new {@link LazyListOnList} around <code>dataSource</code>.
	 * @param dataSource the underlying collection
	 */
	public LazyListOnList(final List<E> dataSource) {
		super(dataSource);
	}

	/* *********************************************************************
	 * Non-lazy operations                                                 *
	 * *********************************************************************/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E get(final int index) {
		if (dataSource == null) {
			return ((List<E>) cache).get(index);
		}
		return ((List<E>)dataSource).get(index);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int indexOf(final Object o) {
		return ((List<E>)dataSource).indexOf(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int lastIndexOf(final Object o) {
		return ((List<E>)dataSource).lastIndexOf(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ListIterator<E> listIterator() {
		if (dataSource == null) {
			return Collections.unmodifiableList((List<E>) cache).listIterator();
		}
		return Collections.unmodifiableList((List<E>) dataSource).listIterator(); // don't cache
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ListIterator<E> listIterator(final int index) {
		if (dataSource == null) {
			return Collections.unmodifiableList((List<E>) cache).listIterator(index);
		}
		return Collections.unmodifiableList((List<E>) dataSource).listIterator(index); // don't cache
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] toArray() {
		if (dataSource == null) {
			return ((List<E>) cache).toArray();
		}
		return ((List<E>)dataSource).toArray();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		if (dataSource == null) {
			return ((List<E>) cache).toArray(a);
		}
		return ((List<E>)dataSource).toArray(a);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E first() {
		return get(0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E last() {
		return get(size() - 1);
	}

}
