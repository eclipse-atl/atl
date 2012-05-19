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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
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
		dataSource.add("Three");
	}

	private LazyList<String> testLazyList;

	/**
	 * Returns a {@link LazyList} for testing.
	 * 
	 * @return a {@link LazyList}
	 */
	protected LazyList<String> getTestLazyList() {
		if (testLazyList == null) {
			testLazyList = new LazyList<String>(dataSource);
		}
		return testLazyList;
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
					assertEquals(s, wfi.next());
				}
			}
			assertFalse(wfi.hasNext());
		}
		{
			final Iterator<String> wli = withoutLast.iterator();
			for (String s : list) {
				if (!s.equals(last)) {
					assertEquals(s, wli.next());
				}
			}
			assertFalse(wli.hasNext());
		}
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
	 * Tests {@link LazyList#last()}.
	 */
	public void testLast() {
		final LazyList<String> list = getTestLazyList();
		assertEquals(dataSource.get(dataSource.size() - 1), list.last());

		try {
			String last = new LazyList<String>().last();
			fail("Expected NoSuchElementException, but got \"" + last + "\"");
		} catch (NoSuchElementException e) {
			// expected
		}
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
	 * Tests {@link LazyList#removeAll(java.util.Collection)}.
	 */
	public void testRemoveAll() {
		final LazyList<String> list = getTestLazyList();
		try {
			list.removeAll(dataSource);
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

}
