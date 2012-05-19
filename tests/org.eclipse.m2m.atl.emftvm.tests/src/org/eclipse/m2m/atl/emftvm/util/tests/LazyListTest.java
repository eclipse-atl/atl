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
package org.eclipse.m2m.atl.emftvm.util.tests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.LazySet;

/**
 * Tests {@link LazyList}.
 * 
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class LazyListTest extends TestCase {

	final List<String> dataSource = new ArrayList<String>();
	{
		dataSource.add("One");
		dataSource.add("Two");
		dataSource.add("Three");
	}

	/**
	 * Tests {@link LazyList#add(Object)}.
	 */
	public void testAdd() {
		final LazyList<String> list = new LazyList<String>(dataSource);
		try {
			list.add("Four");
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#add(int, Object)}.
	 */
	public void testAdd__int() {
		final LazyList<String> list = new LazyList<String>(dataSource);
		try {
			list.add(0, "Four");
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
	}

	/*
	 * TODO all other operations.
	 */

	/**
	 * Tests {@link LazyList#flatten()}.
	 */
	public void testFlatten() {
		final LazyList<String> list = new LazyList<String>(dataSource);
		final LazyList<?> newList = list.flatten();
		assertEquals(list, newList);

		final LazyList<LazyList<String>> listList = new LazyList<LazyList<String>>()
				.append(list);
		assertEquals(list, listList.flatten());

		final LazyList<LazyList<LazyList<String>>> listListList = new LazyList<LazyList<LazyList<String>>>()
				.append(listList);
		assertEquals(list, listListList.flatten());

		final LazyList<LazySet<LazyList<String>>> listSetList = new LazyList<LazySet<LazyList<String>>>()
				.append(new LazySet<LazyList<String>>().including(list).including(list));
		assertEquals(list, listSetList.flatten());
	}

}
