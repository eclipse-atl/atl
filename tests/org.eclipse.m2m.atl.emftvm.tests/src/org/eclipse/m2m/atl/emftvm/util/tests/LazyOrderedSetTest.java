/*******************************************************************************
 * Copyright (c) 2012 Dennis Wagelaar.
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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.util.LazyBag;
import org.eclipse.m2m.atl.emftvm.util.LazyCollection;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet;
import org.eclipse.m2m.atl.emftvm.util.LazySet;
import org.eclipse.m2m.atl.emftvm.util.NativeCodeBlock;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;

/**
 * Tests {@link LazyOrderedSet}.
 * 
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class LazyOrderedSetTest extends LazyCollectionTest {

	private final Set<String> dataSource = new LinkedHashSet<String>();
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
	protected Set<String> getDataSource() {
		return dataSource;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected LazyOrderedSet<String> getTestLazyCollection() {
		// Don't reuse lazy collections because their cache takes over when it
		// is complete
		return new LazyOrderedSet<String>(getDataSource());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected <T> LazyOrderedSet<T> getEmptyLazyCollection() {
		return new LazyOrderedSet<T>();
	}

	/**
	 * Tests {@link LazyOrderedSet#asString()}.
	 */
	public void testAsString() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertEquals(
				new LinkedHashSet<String>(getDataSource()).toString().replace("[", "OrderedSet{'").replace(", ", "', '").replace("]", "'}"),
				list.asString(EmftvmFactory.eINSTANCE.createExecEnv()));
	}

	/**
	 * Tests {@link LazyOrderedSet#add(int, Object)}.
	 */
	public void testAdd__int() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		try {
			ordSet.add(0, "Four");
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyOrderedSet#addAll(int, java.util.Collection)}.
	 */
	public void testAddAll__int() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		try {
			ordSet.addAll(0, getDataSource());
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyOrderedSet#append(Object)}.
	 */
	public void testAppend() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		final LazyOrderedSet<String> appended = ordSet.append("Four");
		assertEquals(ordSet.size() + 1, appended.size());
		assertTrue(appended.contains("Four"));
		assertEquals("Four", appended.get(appended.size() - 1));
		assertEquals(appended, appended.append("Four"));
	}

	/**
	 * Tests {@link LazyOrderedSet#at(int)}.
	 */
	public void testAt() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		final Iterator<String> dsIt = getDataSource().iterator();
		final String first = dsIt.next();
		String last = dsIt.next();
		while (dsIt.hasNext()) {
			last = dsIt.next();
		}
		assertEquals(first, ordSet.at(1));
		assertEquals(last, ordSet.at(getDataSource().size()));
		try {
			String at = ordSet.at(0);
			fail("Expected IndexOutOfBoundsException, but got \"" + at + "\"");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		try {
			String at = ordSet.at(getDataSource().size() + 1);
			fail("Expected IndexOutOfBoundsException, but got \"" + at + "\"");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyOrderedSet#collect(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testCollect() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		final LazyList<Integer> lengths = ordSet.collect(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return ((String) frame.getLocal(0)).length();
			}

		});
		assertEquals(ordSet.size(), lengths.size());
		for (int i = 0; i < ordSet.size(); i++) {
			assertEquals(ordSet.get(i).length(), lengths.get(i).intValue());
		}

		final LazyList<Object> nulls = ordSet.collect(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}
		});
		assertEquals(ordSet.size(), nulls.size());
		for (int i = 0; i < ordSet.size(); i++) {
			assertNull(nulls.get(i));
		}
	}

	/**
	 * Tests {@link LazyOrderedSet#equals(Object)}.
	 */
	public void testEquals() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		assertTrue(ordSet.equals(ordSet));
		assertTrue(ordSet.equals(ordSet.asOrderedSet()));
		assertFalse(ordSet.equals(this));
		assertFalse(ordSet.equals(null));
		assertFalse(ordSet.equals(getDataSource()));
		assertTrue(ordSet.equals(new LazyOrderedSet<String>(getDataSource())));
		assertFalse(ordSet.equals(ordSet.asBag()));
		assertFalse(ordSet.equals(ordSet.append(null)));
		assertFalse(ordSet.equals(ordSet.prepend(null)));
		assertFalse(ordSet.equals(ordSet.excluding(ordSet.first())));
		assertFalse(ordSet.equals(ordSet.excluding(ordSet.last())));
	}

	/**
	 * Tests {@link LazyOrderedSet#first()}.
	 */
	public void testFirst() {
		final LazyOrderedSet<String> list = getTestLazyCollection();
		assertEquals(getDataSource().iterator().next(), list.first());

		try {
			String first = new LazyOrderedSet<String>().first();
			fail("Expected NoSuchElementException, but got \"" + first + "\"");
		} catch (NoSuchElementException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyOrderedSet#flatten()}.
	 */
	public void testFlatten() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		final LazyOrderedSet<?> newOrdSet = ordSet.flatten();
		assertEquals(ordSet, newOrdSet);

		final LazyOrderedSet<LazyOrderedSet<String>> setSet = new LazyOrderedSet<LazyOrderedSet<String>>().append(ordSet);
		assertEquals(ordSet, setSet.flatten());

		final LazyOrderedSet<LazyOrderedSet<LazyOrderedSet<String>>> setSetSet = new LazyOrderedSet<LazyOrderedSet<LazyOrderedSet<String>>>()
				.append(setSet);
		assertEquals(ordSet, setSetSet.flatten());

		final LazyOrderedSet<LazySet<LazyOrderedSet<String>>> ordSetSetOrdSet = new LazyOrderedSet<LazySet<LazyOrderedSet<String>>>()
				.append(new LazySet<LazyOrderedSet<String>>().including(ordSet).including(ordSet));
		assertEquals(ordSet, ordSetSetOrdSet.flatten());
	}

	/**
	 * Tests {@link LazyOrderedSet#get(int)}.
	 */
	public void testGet() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		final Iterator<String> dsIt = getDataSource().iterator();
		final String first = dsIt.next();
		String last = dsIt.next();
		while (dsIt.hasNext()) {
			last = dsIt.next();
		}
		assertEquals(first, ordSet.get(0));
		assertEquals(last, ordSet.get(getDataSource().size() - 1));
		try {
			String at = ordSet.get(-1);
			fail("Expected IndexOutOfBoundsException, but got \"" + at + "\"");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		try {
			String at = ordSet.get(getDataSource().size());
			fail("Expected IndexOutOfBoundsException, but got \"" + at + "\"");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyOrderedSet#hashCode()}.
	 */
	public void testHashCode() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		assertFalse(getDataSource().hashCode() == ordSet.hashCode());
		assertFalse(new ArrayList<String>(getDataSource()).hashCode() == ordSet.hashCode());
		assertEquals(new LazyOrderedSet<String>(getDataSource()).hashCode(), ordSet.hashCode());
		assertFalse(ordSet.hashCode() == ordSet.append("Four").hashCode());
		assertFalse(ordSet.hashCode() == ordSet.append(null).hashCode());
	}

	/**
	 * Tests {@link LazyOrderedSet#indexOf(Object)}.
	 */
	public void testIndexOf() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		assertEquals(0, ordSet.indexOf(ordSet.first()));
		assertTrue(ordSet.indexOf(ordSet.last()) >= 0);
		assertTrue(ordSet.indexOf(ordSet.last()) < ordSet.size());
		assertEquals(-1, ordSet.indexOf("NotContained"));
		assertEquals(-1, ordSet.indexOf(null));
	}

	/**
	 * Tests {@link LazyOrderedSet#indexOf2(Object)}.
	 */
	public void testIndexOf2() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		assertEquals(1, ordSet.indexOf2(ordSet.first()));
		assertTrue(ordSet.indexOf2(ordSet.last()) >= 1);
		assertTrue(ordSet.indexOf2(ordSet.last()) <= ordSet.size());
		try {
			final int index = ordSet.indexOf2("NotContained");
			fail("Expected IndexOutOfBoundsException, but got " + index);
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		try {
			final int index = ordSet.indexOf2(null);
			fail("Expected IndexOutOfBoundsException, but got " + index);
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyOrderedSet#insertAt(int, Object)}.
	 */
	public void testInsertAt() {
		final LazyOrderedSet<String> orderedSet = getTestLazyCollection();
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
	 * Tests {@link LazyOrderedSet#intersection(LazyOrderedSet)}.
	 */
	public void testIntersection() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		final LazyOrderedSet<String> intersection = ordSet.intersection(ordSet);
		assertEquals(ordSet, intersection);
		assertEquals(ordSet.excluding("Three"), ordSet.intersection(ordSet.excluding("Three")));
		assertEquals(new LazyOrderedSet<String>(), ordSet.intersection(new LazyOrderedSet<String>()));
		assertEquals(new LazyOrderedSet<String>(), new LazyOrderedSet<String>().intersection(ordSet));
		final LazyOrderedSet<String> otherSet = new LazyOrderedSet<String>().including("One").including("Two");
		assertEquals(otherSet, ordSet.intersection(otherSet));
		assertEquals(otherSet, otherSet.intersection(ordSet));
	}

	/**
	 * Tests {@link LazyOrderedSet#intersection(LazySet)}.
	 */
	public void testIntersection_LazySet() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		final LazySet<String> set = ordSet.asSet();
		final LazyOrderedSet<String> intersection = ordSet.intersection(set);
		assertEquals(ordSet, intersection);
		assertEquals(ordSet.excluding("Three"), ordSet.intersection(set.excluding("Three")));
		assertEquals(new LazyOrderedSet<String>(), ordSet.intersection(new LazySet<String>()));
		assertEquals(new LazyOrderedSet<String>(), new LazyOrderedSet<String>().intersection(set));
		final LazySet<String> otherSet = new LazySet<String>().including("One").including("Two");
		assertEquals(otherSet.asOrderedSet(), ordSet.intersection(otherSet));
	}

	/**
	 * Tests {@link LazySet#intersection(LazyBag)}.
	 */
	public void testIntersection_LazyBag() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		final LazyBag<String> bag = ordSet.asBag();
		final LazyOrderedSet<String> intersection = ordSet.intersection(bag);
		assertEquals(ordSet, intersection);
		assertEquals(ordSet.excluding("Three"), ordSet.intersection(bag.excluding("Three")));
		assertEquals(new LazyOrderedSet<String>(), ordSet.intersection(new LazyBag<String>()));
		assertEquals(new LazyOrderedSet<String>(), new LazyOrderedSet<String>().intersection(bag));
		final LazyBag<String> otherBag = new LazyBag<String>().including("One").including("Two");
		assertEquals(otherBag.asSet(), ordSet.intersection(otherBag));
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
		assertTrue(list.isUnique(new NativeCodeBlock() {
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
	 * Tests {@link LazyOrderedSet#last()}.
	 */
	public void testLast() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		final Iterator<String> dsIt = getDataSource().iterator();
		String lastDs = dsIt.next();
		while (dsIt.hasNext()) {
			lastDs = dsIt.next();
		}
		assertSame(lastDs, ordSet.last());

		try {
			String last = new LazyOrderedSet<String>().last();
			fail("Expected NoSuchElementException, but got \"" + last + "\"");
		} catch (NoSuchElementException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyOrderedSet#lastIndexOf(Object)}.
	 */
	public void testLastIndexOf() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		assertEquals(ordSet.size() - 1, ordSet.lastIndexOf(ordSet.last()));
		assertTrue(ordSet.lastIndexOf(ordSet.first()) >= 0);
		assertTrue(ordSet.lastIndexOf(ordSet.first()) < ordSet.size());
		assertEquals(-1, ordSet.lastIndexOf("NotContained"));
		assertEquals(-1, ordSet.lastIndexOf(null));
	}

	/**
	 * Tests {@link LazyOrderedSet#lastIndexOf2(Object)}.
	 */
	public void testLastIndexOf2() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		assertEquals(ordSet.size(), ordSet.lastIndexOf2(ordSet.last()));
		assertTrue(ordSet.lastIndexOf2(ordSet.first()) >= 1);
		assertTrue(ordSet.lastIndexOf2(ordSet.first()) <= ordSet.size());
		try {
			final int index = ordSet.lastIndexOf2("NotContained");
			fail("Expected IndexOutOfBoundsException, but got " + index);
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		try {
			final int index = ordSet.lastIndexOf2(null);
			fail("Expected IndexOutOfBoundsException, but got " + index);
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyOrderedSet#listIterator()}.
	 */
	public void testListIterator() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		final ListIterator<String> listIt = ordSet.listIterator();
		final ListIterator<String> dsIt = new ArrayList<String>(getDataSource()).listIterator();
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
		assertEquals(ordSet.size(), listIt.nextIndex());
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
	 * Tests {@link LazyOrderedSet#listIterator(int)}.
	 */
	public void testListIterator__int() {
		try {
			getTestLazyCollection().listIterator(-1);
			fail("Expected IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		try {
			final LazyOrderedSet<String> list = getTestLazyCollection();
			list.listIterator(list.size() + 1);
			fail("Expected IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			// expected
		} catch (NoSuchElementException e) {
			// expected
		}

		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		final ListIterator<String> listIt = ordSet.listIterator(ordSet.size() - 1);
		final ListIterator<String> dsIt = new ArrayList<String>(getDataSource()).listIterator(getDataSource().size() - 1);
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
		assertEquals(ordSet.size(), listIt.nextIndex());
	}

	/**
	 * Tests {@link LazyOrderedSet#prepend(Object)}.
	 */
	public void testPrepend() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		final LazyOrderedSet<String> prepended = ordSet.prepend("Four");
		assertEquals(ordSet.size() + 1, prepended.size());
		assertTrue(prepended.contains("Four"));
		assertEquals("Four", prepended.get(0));
	}

	/**
	 * Tests {@link LazyOrderedSet#reject(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testReject() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		final LazyOrderedSet<String> rejected = ordSet.reject(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return ((String) frame.getLocal(0)).equals(ordSet.first());
			}

		});
		assertEquals(ordSet.size() - 1, rejected.size());
		assertFalse(rejected.contains(ordSet.first()));
		assertEquals(ordSet.excluding(ordSet.first()), rejected);

		assertEquals(0, ordSet.reject(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return true;
			}

		}).size());

		assertEquals(ordSet.size(), ordSet.reject(new NativeCodeBlock() {
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
	 * Tests {@link LazyOrderedSet#remove(int)}.
	 */
	public void testRemove__int() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		try {
			ordSet.remove(1);
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyOrderedSet#reverse()}.
	 */
	public void testReverse() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		final LazyOrderedSet<String> reverse = ordSet.reverse();
		final ListIterator<String> listIt = ordSet.listIterator(ordSet.size());
		for (String s : reverse) {
			assertTrue(listIt.hasPrevious());
			assertSame(listIt.previous(), s);
		}
		assertFalse(listIt.hasPrevious());
	}

	/**
	 * Tests {@link LazyOrderedSet#select(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testSelect() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		final LazyOrderedSet<String> selected = ordSet.select(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return ((String) frame.getLocal(0)).equals(ordSet.first());
			}

		});
		assertEquals(1, selected.size());
		assertTrue(selected.contains(ordSet.first()));
		for (String s : selected) {
			assertEquals(ordSet.first(), s);
		}

		assertEquals(0, ordSet.select(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return false;
			}

		}).size());

		assertEquals(ordSet.size(), ordSet.select(new NativeCodeBlock() {
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
	 * Tests {@link LazyOrderedSet#set(int, Object)}.
	 */
	public void testSet() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		try {
			ordSet.set(0, "Four");
			fail("Expected UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
			// expected
		}
	}

	/**
	 * Tests {@link LazyOrderedSet#subList(int, int)}.
	 */
	public void testSubList() {
		final LazyOrderedSet<String> orderedSet = getTestLazyCollection();
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
	 * Tests {@link LazyOrderedSet#subSequence(int, int).
	 */
	public void testSubSequence() {
		final LazyOrderedSet<String> orderedSet = getTestLazyCollection();
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

	/**
	 * Tests {@link LazyOrderedSet#subtract(LazyOrderedSet)}.
	 */
	public void testSubtract() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		assertEquals(new LazyOrderedSet<String>(), ordSet.subtract(ordSet));
		assertEquals(ordSet, ordSet.subtract(new LazyOrderedSet<String>()));
		assertEquals(ordSet, ordSet.subtract(new LazyOrderedSet<String>().including("other")));
		final LazyOrderedSet<String> otherSet = ordSet.excluding(ordSet.first());
		assertFalse(ordSet.equals(ordSet.subtract(otherSet)));
		assertFalse(otherSet.equals(ordSet.subtract(otherSet)));
	}

	/**
	 * Tests {@link LazyOrderedSet#subtract(LazySet)}.
	 */
	public void testSubtract_LazySet() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		assertEquals(new LazyOrderedSet<String>(), ordSet.subtract(ordSet.asSet()));
		assertEquals(ordSet, ordSet.subtract(new LazySet<String>()));
		assertEquals(ordSet, ordSet.subtract(new LazySet<String>().including("other")));
		final LazySet<String> otherSet = ordSet.excluding(ordSet.first()).asSet();
		assertFalse(ordSet.equals(ordSet.subtract(otherSet)));
	}

	/**
	 * Tests {@link LazyOrderedSet#symmetricDifference(LazySet)}.
	 */
	public void testSymmetricDifference() {
		final LazyOrderedSet<String> set = getTestLazyCollection();
		assertEquals(new LazySet<String>(), set.symmetricDifference(set));
		assertEquals(set, set.symmetricDifference(new LazyOrderedSet<String>()));
		assertEquals(set.including("other"), set.symmetricDifference(new LazyOrderedSet<String>().including("other")));
		final String element = set.first();
		final LazyOrderedSet<String> otherSet = set.excluding(element);
		assertEquals(new LazyOrderedSet<String>().including(element), set.symmetricDifference(otherSet));
		assertEquals(new LazyOrderedSet<String>().including(element), set.symmetricDifference(otherSet));
	}

	/**
	 * Tests {@link LazyOrderedSet#union(LazyOrderedSet)}.
	 */
	public void testUnion() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		assertEquals(ordSet, ordSet.union(ordSet));
		assertEquals(ordSet, ordSet.union(new LazyOrderedSet<String>()));
		assertEquals(ordSet, new LazyOrderedSet<String>().union(ordSet));
	}

	/**
	 * Tests {@link LazyOrderedSet#union(LazySet)}.
	 */
	public void testUnion_LazySet() {
		final LazyOrderedSet<String> ordSet = getTestLazyCollection();
		final LazySet<String> set = ordSet.asSet();
		assertEquals(set, ordSet.union(set));
		assertEquals(set, ordSet.union(new LazySet<String>()));
		assertEquals(set, new LazyOrderedSet<String>().union(set));
	}

	/**
	 * Tests {@link LazyOrderedSet#union(LazyBag)}.
	 */
	public void testUnion_LazyBag() {
		final LazyOrderedSet<String> set = getTestLazyCollection();
		final LazyBag<String> bag = set.asBag();
		final LazyBag<String> union = set.union(bag);
		assertEquals(set.size() + bag.size(), union.size());
		for (String s : set) {
			assertEquals(2, union.count(s));
		}
		assertEquals(bag, set.union(new LazyBag<String>()));
		assertEquals(bag, new LazyOrderedSet<String>().union(bag));
	}

	/**
	 * Tests {@link LazyOrderedSet#sortedBy(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testSortedBy() {
		final LazyOrderedSet<String> set = getTestLazyCollection();
		final List<String> expected = new ArrayList<String>(getDataSource());
		Collections.sort(expected);
		final LazyOrderedSet<String> sortedSet = set.sortedBy(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return frame.getLocal(0);
			}

		});
		assertEquals(expected, sortedSet);
		
		final List<Object> data = new ArrayList<Object>();
		for (int i = 1; i < 100; i++) {
			Iterator<EObject> contents = EmftvmPackage.eINSTANCE.eResource().getAllContents();
			while (contents.hasNext()) {
				data.add(contents.next());
			}
		}
		final List<Object> expected2 = new ArrayList<Object>(data);
		final LazyOrderedSet<Object> set2 = new LazyOrderedSet<Object>(data);
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
			public int compare(Object o1, Object o2) {
				return ((Integer) byHashCode.execute(byHashCode.getParentFrame().getSubFrame(byHashCode, o1))).compareTo( 
						((Integer) byHashCode.execute(byHashCode.getParentFrame().getSubFrame(byHashCode, o2))));
			}
		});
		final long refEnd2 = System.nanoTime();
		final LazyOrderedSet<Object> sortedSet2 = set2.sortedBy(byHashCode);
		sortedSet2.last(); // force eval
		final long lazyEnd2 = System.nanoTime();
		assertEquals(new LazyOrderedSet<Object>(expected2), sortedSet2);
		ATLLogger.info(String.format("Collections.sort() : %d ms, LazyOrderedSet.sortedBy() : %d ms", (refEnd2 - refStart2) / 1000000L, (lazyEnd2 - refEnd2) / 1000000L)); 
	}

}
