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

/**
 * {@link LazyBag} that passes method calls through to the underlying
 * {@link Collection}, where possible, instead of going via {@link Iterator}s. 
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 *
 * @param <E>
 */
public class LazyBagOnCollection<E> extends LazyBag<E> {

	/**
	 * Creates a new {@link LazyBagOnCollection} around <code>dataSource</code>.
	 * @param dataSource the underlying collection
	 */
	public LazyBagOnCollection(final Collection<E> dataSource) {
		super(dataSource);
	}

	/* *********************************************************************
	 * Non-lazy operations                                                 *
	 * *********************************************************************/

	/**
	 * {@inheritDoc}
	 */
	public Iterator<E> iterator() {
		if (dataSource == null) {
			return Collections.unmodifiableCollection(cache).iterator();
		}
		return Collections.unmodifiableCollection((Collection<E>) dataSource).iterator(); // don't cache
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean contains(final Object o) {
		if (dataSource == null) {
			return cache.contains(o);
		}
		return ((Collection<?>)dataSource).contains(o);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isEmpty() {
		if (dataSource == null) {
			return cache.isEmpty();
		}
		return ((Collection<E>)dataSource).isEmpty();
	}

	/**
	 * {@inheritDoc}
	 */
	public int size() {
		if (dataSource == null) {
			return cache.size();
		}
		return ((Collection<E>)dataSource).size();
	}

}
