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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.util.LazyBag;
import org.eclipse.m2m.atl.emftvm.util.LazyCollection;
import org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet;
import org.eclipse.m2m.atl.emftvm.util.LazySet;
import org.eclipse.m2m.atl.emftvm.util.NativeCodeBlock;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
import org.eclipse.m2m.atl.emftvm.util.Tuple;

/**
 * Tests for {@link LazyCollection} subclasses.
 * 
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public abstract class LazyCollectionTest extends TestCase {

	/**
	 * Returns an underlying source {@link Collection} for testing.
	 * 
	 * @return a {@link Collection}
	 */
	protected abstract Collection<String> getDataSource();

	/**
	 * Returns a {@link LazyCollection} for testing.
	 * 
	 * @return a {@link LazyCollection}
	 */
	protected abstract LazyCollection<String> getTestLazyCollection();

	/**
	 * Returns an empty {@link LazyCollection} for testing.
	 * 
	 * @return an empty {@link LazyCollection}
	 */
	protected abstract <T> LazyCollection<T> getEmptyLazyCollection();

	/**
	 * Tests {@link LazyCollection#add(Object)}.
	 */
	public void testAdd() {
		final LazyCollection<String> list = getTestLazyCollection();
		try {
			list.add("Four");
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyCollection#addAll(java.util.Collection)}.
	 */
	public void testAddAll() {
		final LazyCollection<String> list = getTestLazyCollection();
		try {
			list.addAll(getDataSource());
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyCollection#any(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testAny() {
		final LazyCollection<String> list = getTestLazyCollection();
		final String any = list.any(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return frame.getLocal(0).equals("Two");
			}

		});
		assertEquals("Two", any);

		final String none = list.any(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return frame.getLocal(0).equals("None");
			}

		});
		assertNull(none);
	}

	/**
	 * Tests {@link LazyCollection#asBag()}.
	 */
	public void testAsBag() {
		final LazyCollection<String> list = getTestLazyCollection();
		final LazyBag<String> bag = list.asBag();
		assertEquals(list.size(), bag.size());
		assertTrue(bag.containsAll(list));
	}

	/**
	 * Tests {@link LazyCollection#asOrderedSet()}.
	 */
	public void testAsOrderedSet() {
		final LazyCollection<String> list = getTestLazyCollection();
		final Set<String> referenceSet = new LinkedHashSet<String>(list);
		final LazyOrderedSet<String> set = list.asOrderedSet();
		assertTrue(list.size() >= set.size());
		assertEquals(referenceSet.size(), set.size());
		assertTrue(set.containsAll(list));
		int i = 0;
		for (String s : referenceSet) {
			assertEquals(s, set.get(i++));
		}
	}

	/**
	 * Tests {@link LazyCollection#asSequence()}.
	 */
	public void testAsSequence() {
		final LazyCollection<String> list = getTestLazyCollection();
		final LazyCollection<String> seq = list.asSequence();
		assertEquals(list.size(), seq.size());
		assertTrue(seq.containsAll(list));
	}

	/**
	 * Tests {@link LazyCollection#asSet()}.
	 */
	public void testAsSet() {
		final LazyCollection<String> list = getTestLazyCollection();
		final Set<String> referenceSet = new HashSet<String>(list);
		final LazySet<String> set = list.asSet();
		assertTrue(list.size() >= set.size());
		assertEquals(referenceSet.size(), set.size());
		assertTrue(set.containsAll(list));
	}

	/**
	 * Tests {@link LazyCollection#clear()}.
	 */
	public void testClear() {
		final LazyCollection<String> list = getTestLazyCollection();
		try {
			list.clear();
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyCollection#contains(Object)}.
	 */
	public void testContains() {
		final LazyCollection<String> list = getTestLazyCollection();
		for (String s : getDataSource()) {
			assertTrue(list.contains(s));
		}
		assertFalse(list.contains(null));
		assertFalse(list.contains(this));
	}

	/**
	 * Tests {@link LazyCollection#containsAll(java.util.Collection)}.
	 */
	public void testContainsAll() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertTrue(list.containsAll(list));
		assertFalse(list.containsAll(list.including("NotContained")));
		assertTrue(list.containsAll(new ArrayList<String>()));
		assertFalse(list.containsAll(getEmptyLazyCollection().including("NotContained")));
		try {
			list.containsAll(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyCollection#containsAny(java.util.Collection)}.
	 */
	public void testContainsAny() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertTrue(list.containsAny(list));
		assertTrue(list.containsAny(list.including("NotContained")));
		assertFalse(list.containsAny(new ArrayList<String>()));
		assertFalse(list.containsAny(getEmptyLazyCollection().including("NotContained")));
		try {
			list.containsAny(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyCollection#count(Object)}.
	 */
	public void testCount() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertEquals(0, list.count("NotContained"));
		assertEquals(0, list.count(null));
		Map<String, Integer> counts = new HashMap<String, Integer>();
		for (String s : list) {
			counts.put(s, counts.containsKey(s) ? counts.get(s) + 1 : 1);
		}
		for (String s : list) {
			assertEquals(counts.get(s).intValue(), list.count(s));
		}
	}

	/**
	 * Tests {@link LazyCollection#excludes(Object)}.
	 */
	public void testExcludes() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertTrue(list.excludes("NotContained"));
		assertTrue(list.excludes(null));
		for (String s : list) {
			assertFalse(list.excludes(s));
		}
	}

	/**
	 * Tests {@link LazyCollection#excludesAll(java.util.Collection)}.
	 */
	public void testExcludesAll() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertFalse(list.excludesAll(list));
		for (String s : list) {
			assertFalse(list.excludesAll(list.excluding(s)));
		}
		final LazyCollection<String> empty = getEmptyLazyCollection();
		assertTrue(list.excludesAll(empty));
		assertTrue(list.excludesAll(empty.including("NotContained")));
		assertTrue(list.excludesAll(empty.including(null)));
		try {
			list.excludesAll(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyCollection#excluding(Object)}.
	 */
	public void testExcluding() {
		final LazyCollection<String> list = getTestLazyCollection();
		for (String s : list) {
			final LazyCollection<String> excluding = list.excluding(s);
			assertEquals(list.size() - list.count(s), excluding.size());
			final Iterator<String> exclIt = excluding.iterator();
			for (String s1 : list) {
				if (!s1.equals(s)) {
					assertSame(s1, exclIt.next());
				}
			}
			assertFalse(exclIt.hasNext());
		}
	}

	/**
	 * Tests {@link LazyCollection#exists(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testExists() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertTrue(list.exists(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return frame.getLocal(0).equals("One");
			}

		}));
		assertFalse(list.exists(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return !list.contains(frame.getLocal(0));
			}

		}));
		assertTrue(list.exists(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return true;
			}

		}));
		assertFalse(list.exists(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return false;
			}

		}));
	}

	/**
	 * Tests {@link LazyCollection#exists2(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testExists2() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertTrue(list.exists2(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return frame.getLocal(0).equals(frame.getLocal(1));
			}

		}));
		assertFalse(list.exists2(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return !list.contains(frame.getLocal(0)) || !list.contains(frame.getLocal(1));
			}

		}));
		assertTrue(list.exists2(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return true;
			}

		}));
		assertFalse(list.exists2(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return false;
			}

		}));
	}

	/**
	 * Tests {@link LazyCollection#forAll(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testForAll() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertFalse(list.forAll(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return frame.getLocal(0).equals("One");
			}

		}));
		assertTrue(list.forAll(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return list.contains(frame.getLocal(0));
			}

		}));
		assertTrue(list.forAll(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return true;
			}

		}));
		assertFalse(list.forAll(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return false;
			}

		}));
	}

	/**
	 * Tests {@link LazyCollection#forAll2(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testForAll2() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertFalse(list.forAll2(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return frame.getLocal(0).equals(frame.getLocal(1));
			}

		}));
		assertTrue(list.forAll2(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return list.contains(frame.getLocal(0)) && list.contains(frame.getLocal(1));
			}

		}));
		assertTrue(list.forAll2(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return true;
			}

		}));
		assertFalse(list.forAll2(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return false;
			}

		}));
	}

	/**
	 * Tests {@link LazyCollection#includes(Object)}.
	 */
	public void testIncludes() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertFalse(list.includes("NotContained"));
		assertFalse(list.includes(null));
		for (String s : list) {
			assertTrue(list.includes(s));
		}
	}

	/**
	 * Tests {@link LazyCollection#includesAll(java.util.Collection)}.
	 */
	public void testIncludesAll() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertTrue(list.includesAll(list));
		for (String s : list) {
			assertTrue(list.includesAll(list.excluding(s)));
		}
		final LazyCollection<String> empty = getEmptyLazyCollection();
		assertTrue(list.includesAll(empty));
		assertFalse(list.includesAll(empty.including("NotContained")));
		assertFalse(list.includesAll(empty.including(null)));
		try {
			list.includesAll(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyCollection#including(Object)}.
	 */
	public void testIncluding() {
		final LazyCollection<String> list = getTestLazyCollection();
		final LazyCollection<String> appended = list.including("Four");
		assertEquals(list.size() + 1, appended.size());
		assertTrue(appended.contains("Four"));
	}

	/**
	 * Tests {@link LazyCollection#includingRange(Object, Object)}.
	 */
	public void testIncludingRange() {
		final LazyCollection<String> list = getTestLazyCollection();
		try {
			final LazyCollection<String> appended = list.includingRange("One", "Four");
			fail("Expected IllegalArgumentException, but got " + appended);
		} catch (IllegalArgumentException e) {
			// expected
		}
		{
			final LazyCollection<Integer> intlist = getEmptyLazyCollection();
			final LazyCollection<Integer> appended = intlist.includingRange(300, 400);
			assertEquals(intlist.size() + 400 - 300 + 1, appended.size());
			assertTrue(appended.contains(300));
			assertTrue(appended.contains(301));
			assertTrue(appended.contains(349));
			assertTrue(appended.contains(399));
			assertTrue(appended.contains(400));
			// Test iterator
			int index = 0;
			for (Integer element : appended) {
				assertEquals(index + 300, element.intValue());
				index++;
			}
			assertEquals(appended.size(), index);
		}
		{
			final LazyCollection<Long> longlist = getEmptyLazyCollection();
			final LazyCollection<Long> appended = longlist.includingRange(300L, 400L);
			assertEquals(longlist.size() + 400 - 300 + 1, appended.size());
			assertTrue(appended.contains(300L));
			assertTrue(appended.contains(301L));
			assertTrue(appended.contains(349L));
			assertTrue(appended.contains(399L));
			assertTrue(appended.contains(400L));
			// Test iterator
			int index = 0;
			for (Long element : appended) {
				assertEquals(index + 300, element.intValue());
				index++;
			}
			assertEquals(appended.size(), index);
		}
	}

	/**
	 * Tests {@link LazyCollection#isEmpty()}.
	 */
	public void testIsEmpty() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertFalse(list.isEmpty());
		assertTrue(getEmptyLazyCollection().isEmpty());
	}

	/**
	 * Tests {@link LazyCollection#isUnique(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testIsUnique() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertFalse(list.isUnique(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return null;
			}

		}));
		assertFalse(list.isUnique(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return frame.getLocal(0);
			}

		}));
		assertTrue(list.excluding("Three").isUnique(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return frame.getLocal(0);
			}

		}));
	}

	/**
	 * Tests {@link LazyCollection#iterate(Object, org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testIterate() {
		final LazyCollection<String> list = getTestLazyCollection();
		final String result = list.iterate("", new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return ((String) frame.getLocal(1)) + ((String) frame.getLocal(0));
			}

		});
		final StringBuffer expected = new StringBuffer();
		for (String s : list) {
			expected.append(s);
		}
		assertEquals(expected.toString(), result);
	}

	/**
	 * Tests {@link LazyCollection#iterator()}.
	 */
	public void testIterator() {
		final LazyCollection<String> list = getTestLazyCollection();
		final Iterator<String> listIt = list.iterator();
		final Iterator<String> dsIt = getDataSource().iterator();
		while (dsIt.hasNext()) {
			assertTrue(listIt.hasNext());
			assertSame(dsIt.next(), listIt.next());
		}
		assertFalse(listIt.hasNext());
		try {
			listIt.remove();
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
		try {
			listIt.next();
			fail("Expected NoSuchElementException");
		} catch (NoSuchElementException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyCollection#max()}.
	 */
	public void testMax() {
		final LazyCollection<String> list = getTestLazyCollection();
		try {
			String max = list.max();
			fail("Expected IllegalArgumentException, but got \"" + max + "\"");
		} catch (IllegalArgumentException e) {
			// expected
		}

		final LazyCollection<Integer> empty = getEmptyLazyCollection();
		final LazyCollection<Integer> intList = empty.including(1).including(2).including(3);
		assertEquals(3, intList.max().intValue());
	}

	/**
	 * Tests {@link LazyCollection#min()}.
	 */
	public void testMin() {
		final LazyCollection<String> list = getTestLazyCollection();
		try {
			String min = list.min();
			fail("Expected IllegalArgumentException, but got \"" + min + "\"");
		} catch (IllegalArgumentException e) {
			// expected
		}

		final LazyCollection<Integer> empty = getEmptyLazyCollection();
		final LazyCollection<Integer> intList = empty.including(1).including(2).including(3);
		assertEquals(1, intList.min().intValue());
	}

	/**
	 * Tests {@link LazyCollection#notEmpty()}.
	 */
	public void testNotEmpty() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertTrue(list.notEmpty());
		assertFalse(getEmptyLazyCollection().notEmpty());
	}

	/**
	 * Tests {@link LazyCollection#one(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testOne() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertTrue(list.one(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return frame.getLocal(0).equals("One");
			}

		}));
		assertFalse(list.one(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return !list.contains(frame.getLocal(0));
			}

		}));
		assertFalse(list.one(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return true;
			}

		}));
		assertFalse(list.one(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return false;
			}

		}));
	}

	/**
	 * Tests {@link LazyCollection#product(Iterable)}.
	 */
	public void testProduct() {
		final LazyCollection<String> list = getTestLazyCollection();
		final LazySet<Tuple> product = list.product(list);
		assertEquals(list.asSet().size() * list.asSet().size(), product.size());
		for (Tuple t : product) {
			assertEquals(2, t.asMap().size());
			assertTrue(list.contains(t.get("first")));
			assertTrue(list.contains(t.get("second")));
		}
		final LazyCollection<String> empty = getEmptyLazyCollection();
		assertEquals(0, list.product(empty).size());
	}

	/**
	 * Tests {@link LazyCollection#remove(Object)}.
	 */
	public void testRemove() {
		final LazyCollection<String> list = getTestLazyCollection();
		try {
			list.remove("One");
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyCollection#removeAll(java.util.Collection)}.
	 */
	public void testRemoveAll() {
		final LazyCollection<String> list = getTestLazyCollection();
		try {
			list.removeAll(Collections.emptyList());
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
		try {
			list.removeAll(getDataSource());
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyCollection#retainAll(java.util.Collection)}.
	 */
	public void testRetainAll() {
		final LazyCollection<String> list = getTestLazyCollection();
		try {
			list.retainAll(Collections.emptyList());
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
		try {
			list.retainAll(getDataSource());
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyCollection#size()}.
	 */
	public void testSize() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertEquals(getDataSource().size(), list.size());
		assertEquals(0, getEmptyLazyCollection().size());
	}

	/**
	 * Tests {@link LazyCollection#sum()}.
	 */
	public void testSum() {
		final LazyCollection<String> list = getTestLazyCollection();
		try {
			list.sum();
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// expected
		}
		final LazyCollection<Integer> emptyInt = getEmptyLazyCollection();
		assertEquals(0, emptyInt.sum().intValue());
		assertEquals(4, emptyInt.including(1).including(-2).including(3).including(2).sum().intValue());
		final LazyCollection<Long> emptyLong = getEmptyLazyCollection();
		assertEquals(4L, emptyLong.including(1L).including(-2L).including(3L).including(2L).sum().longValue());
		final LazyCollection<Float> emptyFloat = getEmptyLazyCollection();
		assertEquals(4.0f, emptyFloat.including(1.0f).including(-2.0f).including(3.0f).including(2.0f).sum().floatValue());
		final LazyCollection<Double> emptyDouble = getEmptyLazyCollection();
		assertEquals(4.0, emptyDouble.including(1.0).including(-2.0).including(3.0).including(2.0).sum().doubleValue());
	}

	/**
	 * Tests {@link LazyCollection#toArray()}.
	 */
	public void testToArray() {
		final LazyCollection<String> list = getTestLazyCollection();
		final Object[] array = list.toArray();
		assertEquals(list.size(), array.length);
		int i = 0;
		for (String s : list) {
			assertSame(s, array[i++]);
		}
	}

	/**
	 * Tests {@link LazyCollection#toArray(Object[])}.
	 */
	public void testToArray__Object() {
		final LazyCollection<String> list = getTestLazyCollection();
		final String[] array = list.toArray(new String[0]);
		assertEquals(list.size(), array.length);
		int i = 0;
		for (String s : list) {
			assertSame(s, array[i++]);
		}
		assertSame(array, list.toArray(array));
	}

	/**
	 * Tests {@link LazyCollection#toString()}.
	 */
	public void testToString() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertTrue(list.toString().length() > 0);
		assertFalse(list.toString().equals(getEmptyLazyCollection().toString()));
		assertEquals(getDataSource().toString(), list.toString());
	}

	/**
	 * Tests {@link LazyCollection#mappedBy(CodeBlock)}.
	 */
	public void testMappedBy() {
		final LazyCollection<String> list = getTestLazyCollection();
		// Test for single return value
		final Map<Object, LazySet<String>> result = list.mappedBy(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return ((String) frame.getLocal(0)).length();
			}

		});
		for (Object key : result.keySet()) {
			for (String value : result.get(key)) {
				assertEquals(key, Integer.valueOf(value.length()));
			}
		}
		// Test for collection return value
		final Map<Object, LazySet<String>> result2 = list.mappedBy(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				final String self = ((String) frame.getLocal(0));
				final List<Character> chars = new ArrayList<Character>(self.length());
				for (char c : (self.toCharArray())) {
					chars.add(c);
				}
				return chars;
			}

		});
		for (Object key : result2.keySet()) {
			for (String value : result2.get(key)) {
				assertTrue(String.format("Expected \"%s\" to contain \'%s\'", value, key), 
						value.indexOf((Character) key) >= 0);
			}
		}
	}

	/**
	 * Tests {@link LazyCollection#mappedBySingle(CodeBlock)}.
	 */
	public void testMappedBySingle() {
		final LazyCollection<String> list = getTestLazyCollection();
		// Test for single return value
		final Map<Object, String> result = list.mappedBySingle(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return ((String) frame.getLocal(0)).length();
			}

		});
		for (Object key : result.keySet()) {
			String value = result.get(key);
			assertEquals(key, Integer.valueOf(value.length()));
		}
		// Test for collection return value
		final Map<Object, String> result2 = list.mappedBySingle(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				final String self = ((String) frame.getLocal(0));
				final List<Character> chars = new ArrayList<Character>(self.length());
				for (char c : (self.toCharArray())) {
					chars.add(c);
				}
				return chars;
			}

		});
		for (Object key : result2.keySet()) {
			String value = result2.get(key);
			assertTrue(String.format("Expected \"%s\" to contain \'%s\'", value, key), 
					value.indexOf((Character) key) >= 0);
		}
	}

}