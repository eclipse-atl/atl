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
import java.util.Collections;
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
	 * @param dataSource the underlying collection
	 */
	public LazySetOnSet(final Set<E> dataSource) {
		super(dataSource);
	}

	/* *********************************************************************
	 * Non-lazy operations                                                 *
	 * *********************************************************************/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<E> iterator() {
		if (dataSource == null) {
			return Collections.unmodifiableCollection(cache).iterator();
		}
		return Collections.unmodifiableCollection((Collection<E>) dataSource).iterator(); // don't cache
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains(final Object o) {
		if (dataSource == null) {
			return cache.contains(o);
		}
		return ((Collection<?>)dataSource).contains(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		if (dataSource == null) {
			return cache.isEmpty();
		}
		return ((Collection<E>)dataSource).isEmpty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		if (dataSource == null) {
			return cache.size();
		}
		return ((Collection<E>)dataSource).size();
	}

}
