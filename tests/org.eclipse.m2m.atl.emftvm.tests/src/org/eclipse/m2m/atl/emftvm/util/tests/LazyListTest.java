/*******************************************************************************
 * Copyright (c) 2012, 2023 Dennis Wagelaar.
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.util.LazyCollection;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.LazyListOnList;
import org.eclipse.m2m.atl.emftvm.util.LazySet;
import org.eclipse.m2m.atl.emftvm.util.NativeCodeBlock;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;

/**
 * Tests {@link LazyList}.
 *
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class LazyListTest extends LazyCollectionTest {

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
	protected LazyList<String> getTestLazyCollection() {
		// Don't reuse lazy collections because their cache takes over when it
		// is complete
		return new LazyList<String>(getDataSource());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected <T> LazyList<T> getEmptyLazyCollection() {
		return new LazyList<T>();
	}

	/**
	 * Tests {@link LazyList#add(int, Object)}.
	 */
	public void testAdd__int() {
		final LazyList<String> list = getTestLazyCollection();
		try {
			list.add(0, "Four");
			fail("Expected UnsupportedOperationException");
		} catch (final UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#addAll(int, java.util.Collection)}.
	 */
	public void testAddAll__int() {
		final LazyList<String> list = getTestLazyCollection();
		try {
			list.addAll(0, getDataSource());
			fail("Expected UnsupportedOperationException");
		} catch (final UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#move(int, int)}.
	 */
	public void testMove__int_int() {
		final LazyList<String> list = getTestLazyCollection();
		try {
			list.move(0, 1);
			fail("Expected UnsupportedOperationException");
		} catch (final UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#move(int, int)}.
	 */
	public void testMove__int_Object() {
		final LazyList<String> list = getTestLazyCollection();
		try {
			list.move(1, list.first());
			fail("Expected UnsupportedOperationException");
		} catch (final UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#append(Object)}.
	 */
	public void testAppend() {
		final LazyList<String> list = getTestLazyCollection();
		final LazyList<String> appended = list.append("Four");
		assertEquals(list.size() + 1, appended.size());
		assertTrue(appended.contains("Four"));
		assertEquals("Four", appended.get(appended.size() - 1));

		ListIterator<String> listIterator = appended.listIterator();
		int count = 0;
		while (listIterator.hasNext()) {
			listIterator.next();
			count++;
		}
		assertEquals(appended.size(), count);

		listIterator = appended.listIterator(1);
		count = 1;
		while (listIterator.hasNext()) {
			listIterator.next();
			count++;
		}
		assertEquals(appended.size(), count);
	}

	/**
	 * Tests {@link LazyList#append(Object)} with many elements.
	 */
	public void testAppend_Many() {
		final LazyList<String> list = getTestLazyCollection();
		LazyList<String> appended = list;
		for (int i = 0; i < 100000; i++) {
			appended = appended.append("Four");
		}
		assertEquals(list.size() + 100000, appended.size());
		assertTrue(appended.contains("Four"));
		assertEquals("Four", appended.get(appended.size() - 1));

		final List<String> copyList = new ArrayList<String>(appended);
		assertEquals(appended, copyList);

		ListIterator<String> listIterator = appended.listIterator();
		int count = 0;
		while (listIterator.hasNext()) {
			listIterator.next();
			count++;
		}
		assertEquals(appended.size(), count);

		listIterator = appended.listIterator(1);
		count = 1;
		while (listIterator.hasNext()) {
			listIterator.next();
			count++;
		}
		assertEquals(appended.size(), count);
	}

	/**
	 * Tests {@link LazyList#at(int)}.
	 */
	public void testAt() {
		final LazyList<String> list = getTestLazyCollection();
		assertEquals(getDataSource().get(0), list.at(1));
		assertEquals(getDataSource().get(getDataSource().size() - 1), list.at(getDataSource().size()));
		try {
			final String at = list.at(0);
			fail("Expected IndexOutOfBoundsException, but got \"" + at + "\"");
		} catch (final IndexOutOfBoundsException e) {
			// expected
		}
		try {
			final String at = list.at(getDataSource().size() + 1);
			fail("Expected IndexOutOfBoundsException, but got \"" + at + "\"");
		} catch (final IndexOutOfBoundsException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#collect(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testCollect() {
		final LazyList<String> list = getTestLazyCollection();
		final LazyList<Integer> lengths = list.collect(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return ((String) frame.getLocal(0)).length();
			}

		});
		assertEquals(list.size(), lengths.size());
		for (int i = 0; i < list.size(); i++) {
			assertEquals(list.get(i).length(), lengths.get(i).intValue());
		}

		final LazyList<Object> nulls = list.collect(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}
		});
		assertEquals(list.size(), nulls.size());
		for (int i = 0; i < list.size(); i++) {
			assertNull(nulls.get(i));
		}
	}

	/**
	 * Tests {@link LazyList#equals(Object)}.
	 */
	public void testEquals() {
		final LazyList<String> list = getTestLazyCollection();
		assertTrue(list.equals(list));
		assertFalse(list.equals(this));
		assertFalse(list.equals(null));
		assertTrue(list.equals(getDataSource()));
		assertFalse(list.equals(list.asBag()));
		assertFalse(list.equals(list.append(null)));
		assertFalse(list.equals(list.prepend(null)));
		assertFalse(list.equals(list.excluding(list.first())));
		assertFalse(list.equals(list.excluding(list.last())));
	}

	/**
	 * Tests {@link LazyList#first()}.
	 */
	public void testFirst() {
		final LazyList<String> list = getTestLazyCollection();
		assertEquals(getDataSource().get(0), list.first());

		try {
			final String first = new LazyList<String>().first();
			fail("Expected NoSuchElementException, but got \"" + first + "\"");
		} catch (final NoSuchElementException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#flatten()}.
	 */
	public void testFlatten() {
		final LazyList<String> list = getTestLazyCollection();
		final LazyList<?> newList = list.flatten();
		assertEquals(list, newList);

		final LazyList<LazyList<String>> listList = new LazyList<LazyList<String>>().append(list);
		assertEquals(list, listList.flatten());

		final LazyList<LazyList<LazyList<String>>> listListList = new LazyList<LazyList<LazyList<String>>>().append(listList);
		assertEquals(list, listListList.flatten());

		final LazyList<LazySet<LazyList<String>>> listSetList = new LazyList<LazySet<LazyList<String>>>()
				.append(new LazySet<LazyList<String>>().including(list).including(list));
		assertEquals(list, listSetList.flatten());
	}

	/**
	 * Tests {@link LazyList#get(int)}.
	 */
	public void testGet() {
		final LazyList<String> list = getTestLazyCollection();
		assertEquals(getDataSource().get(0), list.get(0));
		assertEquals(getDataSource().get(getDataSource().size() - 1), list.get(getDataSource().size() - 1));
		try {
			final String at = list.get(-1);
			fail("Expected IndexOutOfBoundsException, but got \"" + at + "\"");
		} catch (final IndexOutOfBoundsException e) {
			// expected
		}
		try {
			final String at = list.get(getDataSource().size());
			fail("Expected IndexOutOfBoundsException, but got \"" + at + "\"");
		} catch (final IndexOutOfBoundsException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#hashCode()}.
	 */
	public void testHashCode() {
		final LazyList<String> list = getTestLazyCollection();
		assertEquals(getDataSource().hashCode(), list.hashCode());
		assertFalse(list.hashCode() == list.append("Four").hashCode());
		assertFalse(list.hashCode() == list.append(null).hashCode());
	}

	/**
	 * Tests {@link LazyList#asString()}.
	 */
	public void testAsString() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertEquals(getDataSource().toString().replace("[", "Sequence{'").replace(", ", "', '").replace("]", "'}"),
				list.asString(EmftvmFactory.eINSTANCE.createExecEnv()));
	}

	/**
	 * Tests {@link LazyList#indexOf(Object)}.
	 */
	public void testIndexOf() {
		final LazyList<String> list = getTestLazyCollection();
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
		final LazyList<String> list = getTestLazyCollection();
		assertEquals(1, list.indexOf2(list.first()));
		assertTrue(list.indexOf2(list.last()) >= 1);
		assertTrue(list.indexOf2(list.last()) <= list.size());
		try {
			final int index = list.indexOf2("NotContained");
			fail("Expected IndexOutOfBoundsException, but got " + index);
		} catch (final IndexOutOfBoundsException e) {
			// expected
		}
		try {
			final int index = list.indexOf2(null);
			fail("Expected IndexOutOfBoundsException, but got " + index);
		} catch (final IndexOutOfBoundsException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#insertAt(int, Object)}.
	 */
	public void testInsertAt() {
		final LazyList<String> list = getTestLazyCollection();
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
			final LazyList<String> inserted = list.insertAt(list.size(), "Four");
			assertEquals(list.size() + 1, inserted.size());
			assertTrue(inserted.contains("Four"));
			assertEquals("Four", inserted.get(list.size() - 1));
		}
		{
			final LazyList<String> inserted = list.insertAt(list.size() + 1, "Four");
			assertEquals(list.size() + 1, inserted.size());
			assertTrue(inserted.contains("Four"));
			assertEquals("Four", inserted.get(list.size()));
		}
		try {
			list.insertAt(0, "Four");
			fail("Expected IndexOutOfBoundsException");
		} catch (final IndexOutOfBoundsException e) {
			// expected
		}
		try {
			list.insertAt(list.size() + 2, "Four").last();
			fail("Expected IndexOutOfBoundsException");
		} catch (final IndexOutOfBoundsException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#last()}.
	 */
	public void testLast() {
		final LazyList<String> list = getTestLazyCollection();
		assertSame(getDataSource().get(getDataSource().size() - 1), list.last());

		try {
			final String last = new LazyList<String>().last();
			fail("Expected NoSuchElementException, but got \"" + last + "\"");
		} catch (final NoSuchElementException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#lastIndexOf(Object)}.
	 */
	public void testLastIndexOf() {
		final LazyList<String> list = getTestLazyCollection();
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
		final LazyList<String> list = getTestLazyCollection();
		assertEquals(list.size(), list.lastIndexOf2(list.last()));
		assertTrue(list.lastIndexOf2(list.first()) >= 1);
		assertTrue(list.lastIndexOf2(list.first()) <= list.size());
		try {
			final int index = list.lastIndexOf2("NotContained");
			fail("Expected IndexOutOfBoundsException, but got " + index);
		} catch (final IndexOutOfBoundsException e) {
			// expected
		}
		try {
			final int index = list.lastIndexOf2(null);
			fail("Expected IndexOutOfBoundsException, but got " + index);
		} catch (final IndexOutOfBoundsException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#listIterator()}.
	 */
	public void testListIterator() {
		final LazyList<String> list = getTestLazyCollection();
		final ListIterator<String> listIt = list.listIterator();
		final ListIterator<String> dsIt = getDataSource().listIterator();
		while (dsIt.hasNext()) {
			assertTrue(listIt.hasNext());
			assertEquals(dsIt.nextIndex(), listIt.nextIndex());
			assertSame(dsIt.next(), listIt.next());
		}
		assertFalse(listIt.hasNext());
		try {
			listIt.remove();
			fail("Expected UnsupportedOperationException");
		} catch (final UnsupportedOperationException e) {
			// expected
		}
		try {
			listIt.add("Four");
			fail("Expected UnsupportedOperationException");
		} catch (final UnsupportedOperationException e) {
			// expected
		}
		try {
			listIt.set("Four");
			fail("Expected UnsupportedOperationException");
		} catch (final UnsupportedOperationException e) {
			// expected
		}
		try {
			listIt.next();
			fail("Expected NoSuchElementException");
		} catch (final NoSuchElementException e) {
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
		} catch (final NoSuchElementException e) {
			// expected
		}
		assertEquals(-1, listIt.previousIndex());
	}

	/**
	 * Tests {@link LazyList#listIterator(int)}.
	 */
	public void testListIterator__int() {
		try {
			getTestLazyCollection().listIterator(-1);
			fail("Expected IndexOutOfBoundsException");
		} catch (final IndexOutOfBoundsException e) {
			// expected
		}
		try {
			final LazyList<String> list = getTestLazyCollection();
			list.listIterator(list.size() + 1);
			fail("Expected IndexOutOfBoundsException");
		} catch (final IndexOutOfBoundsException e) {
			// expected
		} catch (final NoSuchElementException e) {
			// expected
		}

		final LazyList<String> list = getTestLazyCollection();
		final ListIterator<String> listIt = list.listIterator(list.size() - 1);
		final ListIterator<String> dsIt = getDataSource().listIterator(getDataSource().size() - 1);
		while (dsIt.hasPrevious()) {
			assertTrue(listIt.hasPrevious());
			assertEquals(dsIt.previousIndex(), listIt.previousIndex());
			assertSame(dsIt.previous(), listIt.previous());
		}
		assertFalse(listIt.hasPrevious());
		try {
			listIt.previous();
			fail("Expected NoSuchElementException");
		} catch (final NoSuchElementException e) {
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
		} catch (final UnsupportedOperationException e) {
			// expected
		}
		try {
			listIt.add("Four");
			fail("Expected UnsupportedOperationException");
		} catch (final UnsupportedOperationException e) {
			// expected
		}
		try {
			listIt.set("Four");
			fail("Expected UnsupportedOperationException");
		} catch (final UnsupportedOperationException e) {
			// expected
		}
		try {
			listIt.next();
			fail("Expected NoSuchElementException");
		} catch (final NoSuchElementException e) {
			// expected
		}
		assertEquals(list.size(), listIt.nextIndex());
	}

	/**
	 * Tests {@link LazyList#prepend(Object)}.
	 */
	public void testPrepend() {
		final LazyList<String> list = getTestLazyCollection();
		final LazyList<String> prepended = list.prepend("Four");
		assertEquals(list.size() + 1, prepended.size());
		assertTrue(prepended.contains("Four"));
		assertEquals("Four", prepended.get(0));
	}

	/**
	 * Tests {@link LazyList#reject(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testReject() {
		final LazyList<String> list = getTestLazyCollection();
		final LazyList<String> rejected = list.reject(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return ((String) frame.getLocal(0)).equals(list.first());
			}

		});
		assertEquals(list.size() - list.count(list.first()), rejected.size());
		assertFalse(rejected.contains(list.first()));
		assertEquals(list.excluding(list.first()), rejected);

		assertEquals(0, list.reject(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return true;
			}

		}).size());

		assertEquals(list.size(), list.reject(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return false;
			}

		}).size());
	}

	/**
	 * Tests {@link LazyList#remove(int)}.
	 */
	public void testRemove__int() {
		final LazyList<String> list = getTestLazyCollection();
		try {
			list.remove(1);
			fail("Expected UnsupportedOperationException");
		} catch (final UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#reverse()}.
	 */
	public void testReverse() {
		final LazyList<String> list = getTestLazyCollection();
		final LazyList<String> reverse = list.reverse();
		final ListIterator<String> listIt = list.listIterator(list.size());
		for (final String s : reverse) {
			assertTrue(listIt.hasPrevious());
			assertSame(listIt.previous(), s);
		}
		assertFalse(listIt.hasPrevious());
	}

	/**
	 * Tests {@link LazyList#select(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testSelect() {
		final LazyList<String> list = getTestLazyCollection();
		final LazyList<String> selected = list.select(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return ((String) frame.getLocal(0)).equals(list.first());
			}

		});
		assertEquals(list.count(list.first()), selected.size());
		assertTrue(selected.contains(list.first()));
		for (final String s : selected) {
			assertEquals(list.first(), s);
		}

		assertEquals(0, list.select(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return false;
			}

		}).size());

		assertEquals(list.size(), list.select(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return true;
			}

		}).size());
	}

	/**
	 * Tests {@link LazyList#set(int, Object)}.
	 */
	public void testSet() {
		final LazyList<String> list = getTestLazyCollection();
		try {
			list.set(0, "Four");
			fail("Expected UnsupportedOperationException");
		} catch (final UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#subList(int, int)}.
	 */
	public void testSubList() {
		final LazyList<String> list = getTestLazyCollection();
		assertTrue(list.subList(0, 0).isEmpty());
		assertTrue(list.subList(list.size() - 1, list.size() - 1).isEmpty());
		assertEquals(list.first(), list.subList(0, 1).get(0));
		assertEquals(list, list.subList(0, list.size()));
		try {
			list.subList(-1, list.size());
			fail("Expected IndexOutOfBoundsException");
		} catch (final IndexOutOfBoundsException e) {
			// expected
		}
		try {
			list.subList(list.size(), list.size() - 1);
			fail("Expected IndexOutOfBoundsException");
		} catch (final IllegalArgumentException e) {
			// expected
		} catch (final IndexOutOfBoundsException e) {
			// expected
		}
		try {
			list.subList(0, list.size() + 1).get(list.size());
			fail("Expected IndexOutOfBoundsException");
		} catch (final IndexOutOfBoundsException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#subSequence(int, int).
	 */
	public void testSubSequence() {
		final LazyList<String> list = getTestLazyCollection();
		assertTrue(list.subSequence(1, 0).isEmpty());
		assertTrue(list.subSequence(list.size(), list.size() - 1).isEmpty());
		assertEquals(list.first(), list.subSequence(1, 1).first());
		assertEquals(list, list.subSequence(1, list.size()));
		try {
			list.subSequence(0, list.size());
			fail("Expected IndexOutOfBoundsException");
		} catch (final IndexOutOfBoundsException e) {
			// expected
		}
		try {
			list.subSequence(list.size() + 1, list.size() - 1);
			fail("Expected IndexOutOfBoundsException");
		} catch (final IndexOutOfBoundsException e) {
			// expected
		}
		try {
			list.subSequence(1, list.size() + 1).at(list.size() + 1);
			fail("Expected IndexOutOfBoundsException");
		} catch (final IndexOutOfBoundsException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyList#union(LazyList)}.
	 */
	public void testUnion() {
		final LazyList<String> list = getTestLazyCollection();
		final LazyList<String> union = list.union(list);
		assertEquals(list.size() * 2, union.size());
		final Iterator<String> unionIt = union.iterator();
		for (final String s : list) {
			assertTrue(unionIt.hasNext());
			assertSame(s, unionIt.next());
		}
		for (final String s : list) {
			assertTrue(unionIt.hasNext());
			assertSame(s, unionIt.next());
		}
		assertFalse(unionIt.hasNext());
		assertEquals(list, list.union(new LazyList<String>()));
		assertEquals(list, new LazyList<String>().union(list));
	}

	/**
	 * Tests {@link LazyList#sortedBy(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testSortedBy() {
		final LazyList<String> list = getTestLazyCollection();
		final List<String> expected = new ArrayList<String>(getDataSource());
		Collections.sort(expected);
		final LazyList<String> sortedList = list.sortedBy(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return frame.getLocal(0);
			}

		});
		assertEquals(expected, sortedList);

		final List<Object> data = new ArrayList<Object>();
		for (int i = 1; i < 100; i++) {
			final Iterator<EObject> contents = EmftvmPackage.eINSTANCE.eResource().getAllContents();
			while (contents.hasNext()) {
				data.add(contents.next());
			}
		}
		final List<Object> expected2 = new ArrayList<Object>(data);
		final LazyList<Object> list2 = new LazyListOnList<Object>(data);
		final CodeBlock byHashCode = new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return frame.getLocal(0).hashCode();
			}

		};
		final long refStart2 = System.nanoTime();
		Collections.sort(expected2, new Comparator<Object>() {
			@Override
			public int compare(final Object o1, final Object o2) {
				return ((Integer) byHashCode.execute(byHashCode.getParentFrame().getSubFrame(byHashCode, o1))).compareTo(
						((Integer) byHashCode.execute(byHashCode.getParentFrame().getSubFrame(byHashCode, o2))));
			}
		});
		final long refEnd2 = System.nanoTime();
		final LazyList<Object> sortedList2 = list2.sortedBy(byHashCode);
		sortedList2.last(); // force eval
		final long lazyEnd2 = System.nanoTime();
		assertEquals(expected2, sortedList2);
		ATLLogger.info(String.format("Collections.sort() : %d ms, LazyList.sortedBy() : %d ms", (refEnd2 - refStart2) / 1000000L, (lazyEnd2 - refEnd2) / 1000000L));
	}

}
