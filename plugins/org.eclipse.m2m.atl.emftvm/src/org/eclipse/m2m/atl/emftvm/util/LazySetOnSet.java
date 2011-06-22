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

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * {@link LazySet} that passes method calls through to the underlying
 * {@link Set}, where possible, instead of going via {@link Iterator}s. 
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 *
 * @param <E>
 */
public class LazySetOnSet<E> extends LazySet<E> {

	/**
	 * Creates a new {@link LazySetOnSet} around <code>dataSource</code>.
	 * @param dataSource
	 */
	public LazySetOnSet(final Set<E> dataSource) {
		super(dataSource);
	}

	/* *********************************************************************
	 * Non-lazy operations                                                 *
	 * *********************************************************************/

	/*
	 * (non-Javadoc)
	 * @see java.util.Collection#iterator()
	 */
	public Iterator<E> iterator() {
		return dataSource.iterator(); // don't cache
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#contains(java.lang.Object)
	 */
	public boolean contains(final Object o) {
		return ((Collection<?>) dataSource).contains(o);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#isEmpty()
	 */
	public boolean isEmpty() {
		return ((Collection<E>) dataSource).isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#size()
	 */
	public int size() {
		return ((Collection<E>) dataSource).size();
	}

}
