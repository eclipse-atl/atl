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

import org.eclipse.m2m.atl.emftvm.util.LazyListOnCollection;

/**
 * Tests {@link LazyListOnCollection}.
 * 
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class LazyListOnCollectionTest extends LazyListTest {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected LazyListOnCollection<String> getTestLazyCollection() {
		// Don't reuse lazy collections because their cache takes over when it
		// is complete
		return new LazyListOnCollection<String>(getDataSource());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected <T> LazyListOnCollection<T> getEmptyLazyCollection() {
		return new LazyListOnCollection<T>(null);
	}

}
