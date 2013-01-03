/*******************************************************************************
 * Copyright (c) 2012 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.m2m.atl.emftvm.util;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * {@link LazyCollection}s utility class.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public final class LazyCollections {

	/**
	 * Private constructor.
	 */
	private LazyCollections() {
		super();
	}

	/**
	 * Returns <code>source</code> wrapped as a {@link LazyList}.
	 * 
	 * @param source
	 *            the source collection to wrap
	 * @return <code>source</code> wrapped as a {@link LazyList}
	 */
	public static <T> LazyList<T> asLazyList(final Collection<T> source) {
		if (source instanceof LazyCollection<?>) {
			return ((LazyCollection<T>) source).asSequence();
		} else if (source instanceof List<?>) {
			return new LazyListOnList<T>((List<T>) source);
		} else {
			return new LazyListOnCollection<T>((Collection<T>) source);
		}
	}

	/**
	 * Returns <code>source</code> wrapped as a {@link LazyOrderedSet}.
	 * 
	 * @param source
	 *            the source collection to wrap
	 * @return <code>source</code> wrapped as a {@link LazyList}
	 */
	public static <T> LazyOrderedSet<T> asLazyOrderedSet(final Collection<T> source) {
		if (source instanceof LazyCollection<?>) {
			return ((LazyCollection<T>) source).asOrderedSet();
		} else {
			return new LazyOrderedSet<T>((Collection<T>) source);
		}
	}

	/**
	 * Returns <code>source</code> wrapped as a {@link LazyBag}.
	 * 
	 * @param source
	 *            the source collection to wrap
	 * @return <code>source</code> wrapped as a {@link LazyBag}
	 */
	public static <T> LazyBag<T> asLazyBag(final Collection<T> source) {
		if (source instanceof LazyCollection<?>) {
			return ((LazyCollection<T>) source).asBag();
		} else {
			return new LazyBagOnCollection<T>((Collection<T>) source);
		}
	}

	/**
	 * Returns <code>source</code> wrapped as a {@link LazySet}.
	 * 
	 * @param source
	 *            the source collection to wrap
	 * @return <code>source</code> wrapped as a {@link LazySet}
	 */
	public static <T> LazySet<T> asLazySet(final Collection<T> source) {
		if (source instanceof LazyCollection<?>) {
			return ((LazyCollection<T>) source).asSet();
		} else if (source instanceof Set<?>) {
			return new LazySetOnSet<T>((Set<T>) source);
		} else {
			return new LazySet<T>((Collection<T>) source);
		}
	}

}
