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

import org.eclipse.m2m.atl.emftvm.util.LazySet;

/**
 * Tests {@link LazySet} without initial cache.
 *
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class LazySetNoCacheTest extends LazySetTest {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected LazySet<String> getTestLazyCollection() {
		// Don't reuse lazy collections because their cache takes over when it
		// is complete
		LazySet<String> testLazySet = new LazySet<String>();
		for (final String string : getDataSource()) {
			testLazySet = testLazySet.including(string);
		}
		return testLazySet;
	}

}
