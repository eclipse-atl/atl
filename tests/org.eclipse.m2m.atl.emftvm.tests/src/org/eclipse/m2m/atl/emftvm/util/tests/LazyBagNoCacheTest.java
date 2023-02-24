/*******************************************************************************
 * Copyright (c) 2023 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.m2m.atl.emftvm.util.tests;

import org.eclipse.m2m.atl.emftvm.util.LazyBag;

/**
 * Tests {@link LazyBag} without initial cache.
 *
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class LazyBagNoCacheTest extends LazyBagTest {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected LazyBag<String> getTestLazyCollection() {
		// Don't reuse lazy collections because their cache takes over when it
		// is complete
		LazyBag<String> testLazyBag = new LazyBag<String>();
		for (final String string : getDataSource()) {
			testLazyBag = testLazyBag.including(string);
		}
		return testLazyBag;
	}

}
