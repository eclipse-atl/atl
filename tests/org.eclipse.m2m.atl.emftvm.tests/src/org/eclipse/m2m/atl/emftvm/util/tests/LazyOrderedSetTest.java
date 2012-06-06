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

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.util.LazyCollection;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet;
import org.eclipse.m2m.atl.emftvm.util.NativeCodeBlock;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;

/**
 * Tests {@link LazyList}.
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
	 * Tests {@link LazyCollection#asString()}.
	 */
	@Override
	public void testAsString() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertEquals(new LinkedHashSet<String>(getDataSource()).toString(), list.asString());
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
	 * Tests {@link LazyCollection#isUnique(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testIsUnique() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertFalse(list.isUnique(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this);
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(null);
				return frame;
			}

		}));
		assertTrue(list.isUnique(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this);
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(frame.getLocal(0));
				return frame;
			}

		}));
		assertTrue(list.excluding("Three").isUnique(new NativeCodeBlock() {
			{
				parentFrame = new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this);
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public StackFrame execute(final StackFrame frame) {
				frame.push(frame.getLocal(0));
				return frame;
			}

		}));
	}

	/**
	 * Tests {@link LazyList#subList(int, int)}.
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
	 * Tests {@link LazyList#subSequence(int, int).
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

	/*
	 * TODO all other operations.
	 */

}
