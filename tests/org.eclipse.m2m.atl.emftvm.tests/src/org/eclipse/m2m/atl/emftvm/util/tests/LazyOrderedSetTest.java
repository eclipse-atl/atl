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

import junit.framework.TestCase;

import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet;

/**
 * Tests {@link LazyList}.
 * 
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class LazyOrderedSetTest extends TestCase {

	final List<String> dataSource = new ArrayList<String>();
	{
		dataSource.add("One");
		dataSource.add("Two");
		dataSource.add("Three");
		dataSource.add("Three");
	}

	/**
	 * Returns a {@link LazyOrderedSet} for testing.
	 * 
	 * @return a {@link LazyOrderedSet}
	 */
	protected LazyOrderedSet<String> getTestLazyOrderedSet() {
		// Don't reuse lazy collections because their cache takes over when it
		// is complete
		return new LazyOrderedSet<String>(dataSource);
	}

	/**
	 * Tests {@link LazyOrderedSet#insertAt(int, Object)}.
	 */
	public void testInsertAt() {
		final LazyOrderedSet<String> orderedSet = getTestLazyOrderedSet();
		{
			final LazyOrderedSet<String> inserted = orderedSet.insertAt(2,
					"Four");
			assertEquals(orderedSet.size() + 1, inserted.size());
			assertTrue(inserted.contains("Four"));
			assertEquals("Four", inserted.get(1));
		}
		{
			final LazyOrderedSet<String> inserted = orderedSet.insertAt(1,
					"Four");
			assertEquals(orderedSet.size() + 1, inserted.size());
			assertTrue(inserted.contains("Four"));
			assertEquals("Four", inserted.get(0));
		}
		{
			final LazyOrderedSet<String> inserted = orderedSet.insertAt(
					orderedSet.size(), "Four");
			assertEquals(orderedSet.size() + 1, inserted.size());
			assertTrue(inserted.contains("Four"));
			assertEquals("Four", inserted.get(orderedSet.size() - 1));
		}
		{
			final LazyOrderedSet<String> inserted = orderedSet.insertAt(
					orderedSet.size() + 1, "Four");
			assertEquals(orderedSet.size() + 1, inserted.size());
			assertTrue(inserted.contains("Four"));
			assertEquals("Four", inserted.get(orderedSet.size()));
		}
		try {
			orderedSet.insertAt(0, "Four");
			fail("Expected IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		try {
			orderedSet.insertAt(orderedSet.size() + 2, "Four").last();
			fail("Expected IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#subList(int, int)}.
	 */
	public void testSubList() {
		final LazyOrderedSet<String> orderedSet = getTestLazyOrderedSet();
		assertTrue(orderedSet.subList(0, 0).isEmpty());
		assertTrue(orderedSet.subList(orderedSet.size() - 1, orderedSet.size() - 1).isEmpty());
		assertEquals(orderedSet.first(), orderedSet.subList(0, 1).get(0));
		assertEquals(orderedSet, orderedSet.subList(0, orderedSet.size()));
		try {
			orderedSet.subList(-1, orderedSet.size());
			fail("Expected IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		try {
			orderedSet.subList(orderedSet.size(), orderedSet.size() - 1);
			fail("Expected IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		try {
			orderedSet.subList(0, orderedSet.size() + 1).get(orderedSet.size());
			fail("Expected IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#subSequence(int, int).
	 */
	public void testSubSequence() {
		final LazyOrderedSet<String> orderedSet = getTestLazyOrderedSet();
		assertTrue(orderedSet.subSequence(1, 0).isEmpty());
		assertTrue(orderedSet.subSequence(orderedSet.size(), orderedSet.size() - 1).isEmpty());
		assertEquals(orderedSet.first(), orderedSet.subSequence(1, 1).first());
		assertEquals(orderedSet, orderedSet.subSequence(1, orderedSet.size()));
		try {
			orderedSet.subSequence(0, orderedSet.size());
			fail("Expected IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		try {
			orderedSet.subSequence(orderedSet.size() + 1, orderedSet.size() - 1);
			fail("Expected IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		try {
			orderedSet.subSequence(1, orderedSet.size() + 1).at(orderedSet.size() + 1);
			fail("Expected IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
	}

	/*
	 * TODO all other operations.
	 */

}
