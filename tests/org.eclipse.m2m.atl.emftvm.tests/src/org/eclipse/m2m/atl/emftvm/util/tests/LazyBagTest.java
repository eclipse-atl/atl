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

package org.eclipse.m2m.atl.emftvm.util.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.m2m.atl.emftvm.util.LazyBag;

/**
 * Tests {@link LazyBag}.
 * 
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class LazyBagTest extends LazyCollectionTest {

	private final List<String> dataSource = new ArrayList<String>();
	{
		dataSource.add("One");
		dataSource.add("Two");
		dataSource.add("Three");
		dataSource.add("Three");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<String> getDataSource() {
		return dataSource;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected LazyBag<String> getTestLazyCollection() {
		// Don't reuse lazy collections because their cache takes over when it
		// is complete
		return new LazyBag<String>(getDataSource());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected <T> LazyBag<T> getEmptyLazyCollection() {
		return new LazyBag<T>(null);
	}

	/*
	 * TODO all other operations.
	 */

}
