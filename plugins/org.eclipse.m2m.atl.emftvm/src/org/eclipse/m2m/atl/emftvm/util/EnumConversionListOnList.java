/*******************************************************************************
 * Copyright (c) 2011-2013 Vrije Universiteit Brussel.
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

import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.emf.common.util.Enumerator;

/**
 * Converts {@link Enumerator}s to {@link EnumLiteral}s.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class EnumConversionListOnList extends EnumConversionList {

	/**
	 * Creates a new {@link EnumConversionListOnList} around <code>dataSource</code>.
	 * 
	 * @param dataSource
	 *            the collection to wrap
	 */
	public EnumConversionListOnList(List<Object> dataSource) {
		super(dataSource);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object get(final int index) {
		if (index < cache.size()) {
			return ((List<Object>)cache).get(index);
		}
		return convert(((List<Object>)dataSource).get(index));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object last() {
		final int size = size();
		if (size < 1) {
			throw new NoSuchElementException();
		}
		if (dataSource == null) {
			return ((List<Object>) cache).get(size - 1);
		}
		return convert(((List<Object>) dataSource).get(size - 1));
	}

}