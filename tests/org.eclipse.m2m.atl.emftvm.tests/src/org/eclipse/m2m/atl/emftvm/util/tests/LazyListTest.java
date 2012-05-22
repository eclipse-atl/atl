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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.util.LazyBag;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet;
import org.eclipse.m2m.atl.emftvm.util.LazySet;
import org.eclipse.m2m.atl.emftvm.util.NativeCodeBlock;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
import org.eclipse.m2m.atl.emftvm.util.Tuple;

/**
 * Tests {@link LazyList}.
 * 
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class LazyListTest extends TestCase {

	final List<String> dataSource = new ArrayList<String>();
	{
		dataSource.add("One");
		dataSource.add("Two");
		dataSource.add("Three");
		dataSource.add("Three");
	}

	/**
	 * Returns a {@link LazyList} for testing.
	 * 
	 * @return a {@link LazyList}
	 */
	protected LazyList<String> getTestLazyList() {
		// Don't reuse lazy collections because their cache takes over when it
		// is complete
		return new LazyList<String>(dataSource);
	}

	/**
	 * Tests {@link LazyList#add(Object)}.
	 */
	public void testAdd() {
		final LazyList<String> list = getTestLazyList();
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
		final LazyList<String> list = getTestLazyList();
		try {
			list.add(0, "Four");
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#addAll(java.util.Collection)}.
	 */
	public void testAddAll() {
		final LazyList<String> list = getTestLazyList();
		try {
			list.addAll(dataSource);
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#addAll(int, java.util.Collection)}.
	 */
	public void testAddAll__int() {
		final LazyList<String> list = getTestLazyList();
		try {
			list.addAll(0, dataSource);
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#any(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testAny() {
		final LazyList<String> list = getTestLazyList();
		final String any = list.any(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(frame.getLocal(0).equals("Two"));
				return frame;
			}

		});
		assertEquals("Two", any);

		try {
			final String none = list.any(new NativeCodeBlock() {
				{
					parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
							.createExecEnv(), this);
					getLocalVariables().add(
							EmftvmFactory.eINSTANCE.createLocalVariable());
				}

				@Override
				public StackFrame execute(final StackFrame frame) {
					frame.push(frame.getLocal(0).equals("None"));
					return frame;
				}

			});
			fail("Expected NoSuchElementException, but got \"" + none + "\"");
		} catch (NoSuchElementException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#append(Object)}.
	 */
	public void testAppend() {
		final LazyList<String> list = getTestLazyList();
		final LazyList<String> appended = list.append("Four");
		assertEquals(list.size() + 1, appended.size());
		assertTrue(appended.contains("Four"));
		assertEquals("Four", appended.get(appended.size() - 1));
	}

	/**
	 * Tests {@link LazyList#asBag()}.
	 */
	public void testAsBag() {
		final LazyList<String> list = getTestLazyList();
		final LazyBag<String> bag = list.asBag();
		assertEquals(list.size(), bag.size());
		assertTrue(bag.containsAll(list));
	}

	/**
	 * Tests {@link LazyList#asOrderedSet()}.
	 */
	public void testAsOrderedSet() {
		final LazyList<String> list = getTestLazyList();
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
	 * Tests {@link LazyList#asSequence()}.
	 */
	public void testAsSequence() {
		final LazyList<String> list = getTestLazyList();
		final LazyList<String> seq = list.asSequence();
		assertEquals(list, seq);
	}

	/**
	 * Tests {@link LazyList#asSet()}.
	 */
	public void testAsSet() {
		final LazyList<String> list = getTestLazyList();
		final Set<String> referenceSet = new HashSet<String>(list);
		final LazySet<String> set = list.asSet();
		assertTrue(list.size() >= set.size());
		assertEquals(referenceSet.size(), set.size());
		assertTrue(set.containsAll(list));
	}

	/**
	 * Tests {@link LazyList#asString()}.
	 */
	public void testAsString() {
		final LazyList<String> list = getTestLazyList();
		assertEquals(dataSource.toString(), list.asString());
	}

	/**
	 * Tests {@link LazyList#at(int)}.
	 */
	public void testAt() {
		final LazyList<String> list = getTestLazyList();
		assertEquals(dataSource.get(0), list.at(1));
		assertEquals(dataSource.get(dataSource.size() - 1),
				list.at(dataSource.size()));
		try {
			String at = list.at(0);
			fail("Expected IndexOutOfBoundsException, but got \"" + at + "\"");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		try {
			String at = list.at(dataSource.size() + 1);
			fail("Expected IndexOutOfBoundsException, but got \"" + at + "\"");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#clear()}.
	 */
	public void testClear() {
		final LazyList<String> list = getTestLazyList();
		try {
			list.clear();
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#collect(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testCollect() {
		final LazyList<String> list = getTestLazyList();
		final LazyList<Integer> lengths = list.collect(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(((String) frame.getLocal(0)).length());
				return frame;
			}

		});
		assertEquals(list.size(), lengths.size());
		for (int i = 0; i < list.size(); i++) {
			assertEquals(list.get(i).length(), lengths.get(i).intValue());
		}

		final LazyList<Object> nulls = list.collect(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}
		});
		assertEquals(list.size(), lengths.size());
		for (int i = 0; i < list.size(); i++) {
			assertNull(nulls.get(i));
		}
	}

	/**
	 * Tests {@link LazyList#contains(Object)}.
	 */
	public void testContains() {
		final LazyList<String> list = getTestLazyList();
		assertTrue(list.contains(list.first()));
		assertTrue(list.contains(list.last()));
		assertFalse(list.contains(null));
		assertFalse(list.contains(this));
	}

	/**
	 * Tests {@link LazyList#containsAll(java.util.Collection)}.
	 */
	public void testContainsAll() {
		final LazyList<String> list = getTestLazyList();
		assertTrue(list.containsAll(list));
		assertFalse(list.containsAll(list.append("NotContained")));
		assertTrue(list.containsAll(new ArrayList<String>()));
		assertFalse(list.containsAll(new LazyList<String>()
				.append("NotContained")));
		try {
			list.containsAll(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#containsAny(java.util.Collection)}.
	 */
	public void testContainsAny() {
		final LazyList<String> list = getTestLazyList();
		assertTrue(list.containsAny(list));
		assertTrue(list.containsAny(list.append("NotContained")));
		assertFalse(list.containsAny(new ArrayList<String>()));
		assertFalse(list.containsAny(new LazyList<String>()
				.append("NotContained")));
		try {
			list.containsAny(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#count(Object)}.
	 */
	public void testCount() {
		final LazyList<String> list = getTestLazyList();
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
	 * Tests {@link LazyList#equals(Object)}.
	 */
	public void testEquals() {
		final LazyList<String> list = getTestLazyList();
		assertTrue(list.equals(list));
		assertFalse(list.equals(this));
		assertFalse(list.equals(null));
		assertTrue(list.equals(dataSource));
		assertFalse(list.equals(list.asBag()));
		assertFalse(list.equals(list.append(null)));
		assertFalse(list.equals(list.prepend(null)));
		assertFalse(list.equals(list.excluding(list.first())));
		assertFalse(list.equals(list.excluding(list.last())));
	}

	/**
	 * Tests {@link LazyList#excludes(Object)}.
	 */
	public void testExcludes() {
		final LazyList<String> list = getTestLazyList();
		assertTrue(list.excludes("NotContained"));
		assertTrue(list.excludes(null));
		assertFalse(list.excludes(list.first()));
		assertFalse(list.excludes(list.last()));
	}

	/**
	 * Tests {@link LazyList#excludesAll(java.util.Collection)}.
	 */
	public void testExcludesAll() {
		final LazyList<String> list = getTestLazyList();
		assertFalse(list.excludesAll(list));
		assertFalse(list.excludesAll(list.excluding(list.first())));
		assertFalse(list.excludesAll(list.excluding(list.last())));
		assertTrue(list.excludesAll(new LazyList<String>()));
		assertTrue(list.excludesAll(new LazyList<String>()
				.append("NotContained")));
		assertTrue(list.excludesAll(new LazyList<String>().append(null)));
		try {
			list.excludesAll(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#excluding(Object)}.
	 */
	public void testExcluding() {
		final LazyList<String> list = getTestLazyList();
		final String first = list.first();
		final String last = list.last();
		final LazyList<String> withoutFirst = list.excluding(first);
		final LazyList<String> withoutLast = list.excluding(last);
		assertEquals(list.size() - list.count(first), withoutFirst.size());
		assertEquals(list.size() - list.count(last), withoutLast.size());
		{
			final Iterator<String> wfi = withoutFirst.iterator();
			for (String s : list) {
				if (!s.equals(first)) {
					assertSame(s, wfi.next());
				}
			}
			assertFalse(wfi.hasNext());
		}
		{
			final Iterator<String> wli = withoutLast.iterator();
			for (String s : list) {
				if (!s.equals(last)) {
					assertSame(s, wli.next());
				}
			}
			assertFalse(wli.hasNext());
		}
	}

	/**
	 * Tests {@link LazyList#exists(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testExists() {
		final LazyList<String> list = getTestLazyList();
		assertTrue(list.exists(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(frame.getLocal(0).equals("One"));
				return frame;
			}

		}));
		assertFalse(list.exists(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(!list.contains(frame.getLocal(0)));
				return frame;
			}

		}));
		assertTrue(list.exists(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(true);
				return frame;
			}

		}));
		assertFalse(list.exists(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(false);
				return frame;
			}

		}));
	}

	/**
	 * Tests {@link LazyList#exists2(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testExists2() {
		final LazyList<String> list = getTestLazyList();
		assertTrue(list.exists2(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(frame.getLocal(0).equals(frame.getLocal(1)));
				return frame;
			}

		}));
		assertFalse(list.exists2(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(!list.contains(frame.getLocal(0))
						|| !list.contains(frame.getLocal(1)));
				return frame;
			}

		}));
		assertTrue(list.exists2(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(true);
				return frame;
			}

		}));
		assertFalse(list.exists2(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(false);
				return frame;
			}

		}));
	}

	/**
	 * Tests {@link LazyList#first()}.
	 */
	public void testFirst() {
		final LazyList<String> list = getTestLazyList();
		assertEquals(dataSource.get(0), list.first());

		try {
			String first = new LazyList<String>().first();
			fail("Expected NoSuchElementException, but got \"" + first + "\"");
		} catch (NoSuchElementException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#flatten()}.
	 */
	public void testFlatten() {
		final LazyList<String> list = getTestLazyList();
		final LazyList<?> newList = list.flatten();
		assertEquals(list, newList);

		final LazyList<LazyList<String>> listList = new LazyList<LazyList<String>>()
				.append(list);
		assertEquals(list, listList.flatten());

		final LazyList<LazyList<LazyList<String>>> listListList = new LazyList<LazyList<LazyList<String>>>()
				.append(listList);
		assertEquals(list, listListList.flatten());

		final LazyList<LazySet<LazyList<String>>> listSetList = new LazyList<LazySet<LazyList<String>>>()
				.append(new LazySet<LazyList<String>>().including(list)
						.including(list));
		assertEquals(list, listSetList.flatten());
	}

	/**
	 * Tests {@link LazyList#forAll(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testForAll() {
		final LazyList<String> list = getTestLazyList();
		assertFalse(list.forAll(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(frame.getLocal(0).equals("One"));
				return frame;
			}

		}));
		assertTrue(list.forAll(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(list.contains(frame.getLocal(0)));
				return frame;
			}

		}));
		assertTrue(list.forAll(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(true);
				return frame;
			}

		}));
		assertFalse(list.forAll(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(false);
				return frame;
			}

		}));
	}

	/**
	 * Tests {@link LazyList#forAll2(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testForAll2() {
		final LazyList<String> list = getTestLazyList();
		assertFalse(list.forAll2(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(frame.getLocal(0).equals(frame.getLocal(1)));
				return frame;
			}

		}));
		assertTrue(list.forAll2(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(list.contains(frame.getLocal(0))
						&& list.contains(frame.getLocal(1)));
				return frame;
			}

		}));
		assertTrue(list.forAll2(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(true);
				return frame;
			}

		}));
		assertFalse(list.forAll2(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(false);
				return frame;
			}

		}));
	}

	/**
	 * Tests {@link LazyList#get(int)}.
	 */
	public void testGet() {
		final LazyList<String> list = getTestLazyList();
		assertEquals(dataSource.get(0), list.get(0));
		assertEquals(dataSource.get(dataSource.size() - 1),
				list.get(dataSource.size() - 1));
		try {
			String at = list.get(-1);
			fail("Expected IndexOutOfBoundsException, but got \"" + at + "\"");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		try {
			String at = list.get(dataSource.size());
			fail("Expected IndexOutOfBoundsException, but got \"" + at + "\"");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#hashCode()}.
	 */
	public void testHashCode() {
		final LazyList<String> list = getTestLazyList();
		assertEquals(dataSource.hashCode(), list.hashCode());
		assertFalse(list.hashCode() == list.append("Four").hashCode());
		assertFalse(list.hashCode() == list.append(null).hashCode());
	}

	/**
	 * Tests {@link LazyList#includes(Object)}.
	 */
	public void testIncludes() {
		final LazyList<String> list = getTestLazyList();
		assertFalse(list.includes("NotContained"));
		assertFalse(list.includes(null));
		assertTrue(list.includes(list.first()));
		assertTrue(list.includes(list.last()));
	}

	/**
	 * Tests {@link LazyList#includesAll(java.util.Collection)}.
	 */
	public void testIncludesAll() {
		final LazyList<String> list = getTestLazyList();
		assertTrue(list.includesAll(list));
		assertTrue(list.includesAll(list.excluding(list.first())));
		assertTrue(list.includesAll(list.excluding(list.last())));
		assertTrue(list.includesAll(new LazyList<String>()));
		assertFalse(list.includesAll(new LazyList<String>()
				.append("NotContained")));
		assertFalse(list.includesAll(new LazyList<String>().append(null)));
		try {
			list.includesAll(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#including(Object)}.
	 */
	public void testIncluding() {
		final LazyList<String> list = getTestLazyList();
		final LazyList<String> appended = list.including("Four");
		assertEquals(list.size() + 1, appended.size());
		assertTrue(appended.contains("Four"));
	}

	/**
	 * Tests {@link LazyList#indexOf(Object)}.
	 */
	public void testIndexOf() {
		final LazyList<String> list = getTestLazyList();
		assertEquals(0, list.indexOf(list.first()));
		assertTrue(list.indexOf(list.last()) >= 0);
		assertTrue(list.indexOf(list.last()) < list.size());
		assertEquals(-1, list.indexOf("NotContained"));
		assertEquals(-1, list.indexOf(null));
	}

	/**
	 * Tests {@link LazyList#indexOf2(Object)}.
	 */
	public void testIndexOf2() {
		final LazyList<String> list = getTestLazyList();
		assertEquals(1, list.indexOf2(list.first()));
		assertTrue(list.indexOf2(list.last()) >= 1);
		assertTrue(list.indexOf2(list.last()) <= list.size());
		try {
			final int index = list.indexOf2("NotContained");
			fail("Expected IndexOutOfBoundsException, but got " + index);
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		try {
			final int index = list.indexOf2(null);
			fail("Expected IndexOutOfBoundsException, but got " + index);
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#insertAt(int, Object)}.
	 */
	public void testInsertAt() {
		final LazyList<String> list = getTestLazyList();
		{
			final LazyList<String> inserted = list.insertAt(2, "Four");
			assertEquals(list.size() + 1, inserted.size());
			assertTrue(inserted.contains("Four"));
			assertEquals("Four", inserted.get(1));
		}
		{
			final LazyList<String> inserted = list.insertAt(1, "Four");
			assertEquals(list.size() + 1, inserted.size());
			assertTrue(inserted.contains("Four"));
			assertEquals("Four", inserted.get(0));
		}
		{
			final LazyList<String> inserted = list
					.insertAt(list.size(), "Four");
			assertEquals(list.size() + 1, inserted.size());
			assertTrue(inserted.contains("Four"));
			assertEquals("Four", inserted.get(list.size() - 1));
		}
		{
			final LazyList<String> inserted = list.insertAt(list.size() + 1,
					"Four");
			assertEquals(list.size() + 1, inserted.size());
			assertTrue(inserted.contains("Four"));
			assertEquals("Four", inserted.get(list.size()));
		}
		try {
			list.insertAt(0, "Four");
			fail("Expected IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		try {
			list.insertAt(list.size() + 2, "Four").last();
			fail("Expected IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#isEmpty()}.
	 */
	public void testIsEmpty() {
		final LazyList<String> list = getTestLazyList();
		assertFalse(list.isEmpty());
		assertTrue(new LazyList<Object>().isEmpty());
	}

	/**
	 * Tests {@link LazyList#isUnique(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testIsUnique() {
		final LazyList<String> list = getTestLazyList();
		assertFalse(list.isUnique(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(null);
				return frame;
			}

		}));
		assertFalse(list.isUnique(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(frame.getLocal(0));
				return frame;
			}

		}));
		assertTrue(list.excluding("Three").isUnique(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(frame.getLocal(0));
				return frame;
			}

		}));
	}

	/**
	 * Tests
	 * {@link LazyList#iterate(Object, org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testIterate() {
		final LazyList<String> list = getTestLazyList();
		final String result = list.iterate("", new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(((String) frame.getLocal(1))
						+ ((String) frame.getLocal(0)));
				return frame;
			}

		});
		final StringBuffer expected = new StringBuffer();
		for (String s : list) {
			expected.append(s);
		}
		assertEquals(expected.toString(), result);
	}

	/**
	 * Tests {@link LazyList#iterator()}.
	 */
	public void testIterator() {
		final LazyList<String> list = getTestLazyList();
		final Iterator<String> listIt = list.iterator();
		final Iterator<String> dsIt = dataSource.iterator();
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
	 * Tests {@link LazyList#last()}.
	 */
	public void testLast() {
		final LazyList<String> list = getTestLazyList();
		assertSame(dataSource.get(dataSource.size() - 1), list.last());

		try {
			String last = new LazyList<String>().last();
			fail("Expected NoSuchElementException, but got \"" + last + "\"");
		} catch (NoSuchElementException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#lastIndexOf(Object)}.
	 */
	public void testLastIndexOf() {
		final LazyList<String> list = getTestLazyList();
		assertEquals(list.size() - 1, list.lastIndexOf(list.last()));
		assertTrue(list.lastIndexOf(list.first()) >= 0);
		assertTrue(list.lastIndexOf(list.first()) < list.size());
		assertEquals(-1, list.lastIndexOf("NotContained"));
		assertEquals(-1, list.lastIndexOf(null));
	}

	/**
	 * Tests {@link LazyList#lastIndexOf2(Object)}.
	 */
	public void testLastIndexOf2() {
		final LazyList<String> list = getTestLazyList();
		assertEquals(list.size(), list.lastIndexOf2(list.last()));
		assertTrue(list.lastIndexOf2(list.first()) >= 1);
		assertTrue(list.lastIndexOf2(list.first()) <= list.size());
		try {
			final int index = list.lastIndexOf2("NotContained");
			fail("Expected IndexOutOfBoundsException, but got " + index);
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		try {
			final int index = list.lastIndexOf2(null);
			fail("Expected IndexOutOfBoundsException, but got " + index);
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#listIterator()}.
	 */
	public void testListIterator() {
		final LazyList<String> list = getTestLazyList();
		final ListIterator<String> listIt = list.listIterator();
		final ListIterator<String> dsIt = dataSource.listIterator();
		while (dsIt.hasNext()) {
			assertTrue(listIt.hasNext());
			assertEquals(dsIt.nextIndex(), listIt.nextIndex());
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
			listIt.add("Four");
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
		try {
			listIt.set("Four");
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
		assertEquals(list.size(), listIt.nextIndex());
		while (dsIt.hasPrevious()) {
			assertTrue(listIt.hasPrevious());
			assertEquals(dsIt.previousIndex(), listIt.previousIndex());
			assertSame(dsIt.previous(), listIt.previous());
		}
		assertFalse(listIt.hasPrevious());
		try {
			listIt.previous();
			fail("Expected NoSuchElementException");
		} catch (NoSuchElementException e) {
			// expected
		}
		assertEquals(-1, listIt.previousIndex());
	}

	/**
	 * Tests {@link LazyList#listIterator(int)}.
	 */
	public void testListIterator__int() {
		try {
			getTestLazyList().listIterator(-1);
			fail("Expected IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		try {
			final LazyList<String> list = getTestLazyList();
			list.listIterator(list.size() + 1);
			fail("Expected IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}

		final LazyList<String> list = getTestLazyList();
		final ListIterator<String> listIt = list.listIterator(list.size() - 1);
		final ListIterator<String> dsIt = dataSource.listIterator(dataSource
				.size() - 1);
		while (dsIt.hasPrevious()) {
			assertTrue(listIt.hasPrevious());
			assertEquals(dsIt.previousIndex(), listIt.previousIndex());
			assertSame(dsIt.previous(), listIt.previous());
		}
		assertFalse(listIt.hasPrevious());
		try {
			listIt.previous();
			fail("Expected NoSuchElementException");
		} catch (NoSuchElementException e) {
			// expected
		}
		assertEquals(-1, listIt.previousIndex());
		while (dsIt.hasNext()) {
			assertTrue(listIt.hasNext());
			assertEquals(dsIt.nextIndex(), listIt.nextIndex());
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
			listIt.add("Four");
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
		try {
			listIt.set("Four");
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
		assertEquals(list.size(), listIt.nextIndex());
	}

	/**
	 * Tests {@link LazyList#max()}.
	 */
	public void testMax() {
		final LazyList<String> list = getTestLazyList();
		try {
			String max = list.max();
			fail("Expected IllegalArgumentException, but got \"" + max + "\"");
		} catch (IllegalArgumentException e) {
			// expected
		}

		@SuppressWarnings("serial")
		final LazyList<Integer> intList = new LazyList<Integer>(
				new ArrayList<Integer>() {
					{
						add(1);
						add(2);
						add(3);
					}
				});
		assertEquals(3, intList.max().intValue());
	}

	/**
	 * Tests {@link LazyList#min()}.
	 */
	public void testMin() {
		final LazyList<String> list = getTestLazyList();
		try {
			String min = list.min();
			fail("Expected IllegalArgumentException, but got \"" + min + "\"");
		} catch (IllegalArgumentException e) {
			// expected
		}

		@SuppressWarnings("serial")
		final LazyList<Integer> intList = new LazyList<Integer>(
				new ArrayList<Integer>() {
					{
						add(1);
						add(2);
						add(3);
					}
				});
		assertEquals(1, intList.min().intValue());
	}

	/**
	 * Tests {@link LazyList#notEmpty()}.
	 */
	public void testNotEmpty() {
		final LazyList<String> list = getTestLazyList();
		assertTrue(list.notEmpty());
		assertFalse(new LazyList<Object>().notEmpty());
	}

	/**
	 * Tests {@link LazyList#one(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testOne() {
		final LazyList<String> list = getTestLazyList();
		assertTrue(list.one(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(frame.getLocal(0).equals("One"));
				return frame;
			}

		}));
		assertFalse(list.one(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(!list.contains(frame.getLocal(0)));
				return frame;
			}

		}));
		assertFalse(list.one(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(true);
				return frame;
			}

		}));
		assertFalse(list.one(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(false);
				return frame;
			}

		}));
	}

	/**
	 * Tests {@link LazyList#prepend(Object)}.
	 */
	public void testPrepend() {
		final LazyList<String> list = getTestLazyList();
		final LazyList<String> prepended = list.prepend("Four");
		assertEquals(list.size() + 1, prepended.size());
		assertTrue(prepended.contains("Four"));
		assertEquals("Four", prepended.get(0));
	}

	/**
	 * Tests {@link LazyList#product(Iterable)}.
	 */
	public void testProduct() {
		final LazyList<String> list = getTestLazyList();
		final LazySet<Tuple> product = list.product(list);
		assertEquals(list.asSet().size() * list.asSet().size(), product.size());
		for (Tuple t : product) {
			assertEquals(2, t.asMap().size());
			assertTrue(list.contains(t.get("first")));
			assertTrue(list.contains(t.get("second")));
		}
		assertEquals(0, list.product(new LazyList<String>()).size());
	}

	/**
	 * Tests {@link LazyList#reject(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testReject() {
		final LazyList<String> list = getTestLazyList();
		final LazyList<String> rejected = list.reject(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(((String) frame.getLocal(0)).equals(list.first()));
				return frame;
			}

		});
		assertEquals(list.size() - list.count(list.first()), rejected.size());
		assertFalse(rejected.contains(list.first()));
		assertEquals(list.excluding(list.first()), rejected);

		assertEquals(0, list.reject(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(true);
				return frame;
			}

		}).size());

		assertEquals(list.size(), list.reject(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(false);
				return frame;
			}

		}).size());
	}

	/**
	 * Tests {@link LazyList#remove(Object)}.
	 */
	public void testRemove() {
		final LazyList<String> list = getTestLazyList();
		try {
			list.remove("One");
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#remove(int)}.
	 */
	public void testRemove__int() {
		final LazyList<String> list = getTestLazyList();
		try {
			list.remove(1);
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#removeAll(java.util.Collection)}.
	 */
	public void testRemoveAll() {
		final LazyList<String> list = getTestLazyList();
		try {
			list.removeAll(Collections.emptyList());
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
		try {
			list.removeAll(dataSource);
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#retainAll(java.util.Collection)}.
	 */
	public void testRetainAll() {
		final LazyList<String> list = getTestLazyList();
		try {
			list.retainAll(Collections.emptyList());
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
		try {
			list.retainAll(dataSource);
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#reverse()}.
	 */
	public void testReverse() {
		final LazyList<String> list = getTestLazyList();
		final LazyList<String> reverse = list.reverse();
		final ListIterator<String> listIt = list.listIterator(list.size());
		for (String s : reverse) {
			assertTrue(listIt.hasPrevious());
			assertSame(listIt.previous(), s);
		}
		assertFalse(listIt.hasPrevious());
	}

	/**
	 * Tests {@link LazyList#select(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testSelect() {
		final LazyList<String> list = getTestLazyList();
		final LazyList<String> selected = list.select(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(((String) frame.getLocal(0)).equals(list.first()));
				return frame;
			}

		});
		assertEquals(list.count(list.first()), selected.size());
		assertTrue(selected.contains(list.first()));
		for (String s : selected) {
			assertEquals(list.first(), s);
		}

		assertEquals(0, list.select(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(false);
				return frame;
			}

		}).size());

		assertEquals(list.size(), list.select(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE
						.createExecEnv(), this);
				getLocalVariables().add(
						EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(true);
				return frame;
			}

		}).size());
	}

	/**
	 * Tests {@link LazyList#set(int, Object)}.
	 */
	public void testSet() {
		final LazyList<String> list = getTestLazyList();
		try {
			list.set(0, "Four");
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#size()}.
	 */
	public void testSize() {
		final LazyList<String> list = getTestLazyList();
		assertEquals(dataSource.size(), list.size());
		assertEquals(0, new LazyList<Object>().size());
	}

	/**
	 * Tests {@link LazyList#subList(int, int)}.
	 */
	public void testSubList() {
		final LazyList<String> list = getTestLazyList();
		assertTrue(list.subList(0, 0).isEmpty());
		assertTrue(list.subList(list.size() - 1, list.size() - 1).isEmpty());
		assertEquals(list.first(), list.subList(0, 1).get(0));
		assertEquals(list, list.subList(0, list.size()));
		try {
			list.subList(-1, list.size());
			fail("Expected IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		try {
			list.subList(list.size(), list.size() - 1);
			fail("Expected IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		try {
			list.subList(0, list.size() + 1).get(list.size());
			fail("Expected IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#subSequence(int, int).
	 */
	public void testSubSequence() {
		final LazyList<String> list = getTestLazyList();
		assertTrue(list.subSequence(1, 0).isEmpty());
		assertTrue(list.subSequence(list.size(), list.size() - 1).isEmpty());
		assertEquals(list.first(), list.subSequence(1, 1).first());
		assertEquals(list, list.subSequence(1, list.size()));
		try {
			list.subSequence(0, list.size());
			fail("Expected IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		try {
			list.subSequence(list.size() + 1, list.size() - 1);
			fail("Expected IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		try {
			list.subSequence(1, list.size() + 1).at(list.size() + 1);
			fail("Expected IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#sum()}.
	 */
	public void testSum() {
		final LazyList<String> list = getTestLazyList();
		try {
			list.sum();
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// expected
		}
		assertEquals(0, new LazyList<Integer>().sum().intValue());
		assertEquals(4, new LazyList<Integer>().including(1).including(-2)
				.including(3).including(2).sum().intValue());
		assertEquals(4L, new LazyList<Long>().including(1L).including(-2L)
				.including(3L).including(2L).sum().longValue());
		assertEquals(4.0f,
				new LazyList<Float>().including(1.0f).including(-2.0f)
						.including(3.0f).including(2.0f).sum().floatValue());
		assertEquals(4.0, new LazyList<Double>().including(1.0).including(-2.0)
				.including(3.0).including(2.0).sum().doubleValue());
	}

	/**
	 * Tests {@link LazyList#toArray()}.
	 */
	public void testToArray() {
		final LazyList<String> list = getTestLazyList();
		final Object[] array = list.toArray();
		assertEquals(list.size(), array.length);
		for (int i = 0; i < list.size(); i++) {
			assertSame(list.get(i), array[i]);
		}
	}

	/**
	 * Tests {@link LazyList#toArray(Object[])}.
	 */
	public void testToArray__Object() {
		final LazyList<String> list = getTestLazyList();
		final String[] array = list.toArray(new String[0]);
		assertEquals(list.size(), array.length);
		for (int i = 0; i < list.size(); i++) {
			assertSame(list.get(i), array[i]);
		}
		assertSame(array, list.toArray(array));
	}
	
	/**
	 * Tests {@link LazyList#toString()}.
	 */
	public void testToString() {
		final LazyList<String> list = getTestLazyList();
		assertTrue(list.toString().length() > 0);
		assertFalse(list.toString().equals(new LazyList<String>().toString()));
		assertEquals(dataSource.toString(), list.toString());
	}
	
	/**
	 * Tests {@link LazyList#union(LazyList)}.
	 */
	public void testUnion() {
		final LazyList<String> list = getTestLazyList();
		final LazyList<String> union = list.union(list);
		assertEquals(list.size() * 2, union.size());
		final Iterator<String> unionIt = union.iterator();
		for (String s : list) {
			assertTrue(unionIt.hasNext());
			assertSame(s, unionIt.next());
		}
		for (String s : list) {
			assertTrue(unionIt.hasNext());
			assertSame(s, unionIt.next());
		}
		assertFalse(unionIt.hasNext());
		assertEquals(list, list.union(new LazyList<String>()));
		assertEquals(list, new LazyList<String>().union(list));
	}

}
