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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.util.LazyBag;
import org.eclipse.m2m.atl.emftvm.util.LazyCollection;
import org.eclipse.m2m.atl.emftvm.util.LazySet;
import org.eclipse.m2m.atl.emftvm.util.NativeCodeBlock;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;

/**
 * Tests {@link LazySet}.
 * 
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class LazySetTest extends LazyCollectionTest {

	private final Set<String> dataSource = new HashSet<String>();
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
	protected LazySet<String> getTestLazyCollection() {
		// Don't reuse lazy collections because their cache takes over when it
		// is complete
		return new LazySet<String>(getDataSource());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected <T> LazySet<T> getEmptyLazyCollection() {
		return new LazySet<T>(null);
	}

	/**
	 * Tests {@link LazySet#collect(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testCollect() {
		final LazySet<String> set = getTestLazyCollection();
		final LazyBag<Integer> lengths = set.collect(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return ((String) frame.getLocal(0)).length();
			}

		});
		assertEquals(set.size(), lengths.size());
		final Iterator<Integer> lengthIt = lengths.iterator();
		for (String element : set) {
			assertEquals(element.length(), lengthIt.next().intValue());
		}
		assertFalse(lengthIt.hasNext());

		final LazyBag<Object> nulls = set.collect(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}
		});
		assertEquals(set.size(), nulls.size());
		final Iterator<Object> nullIt = nulls.iterator();
		for (@SuppressWarnings("unused")
		String element : set) {
			assertNull(nullIt.next());
		}
		assertFalse(nullIt.hasNext());
	}

	/**
	 * Tests {@link LazySet#equals(Object)}.
	 */
	public void testEquals() {
		final LazySet<String> set = getTestLazyCollection();
		assertTrue(set.equals(set));
		assertFalse(set.equals(this));
		assertFalse(set.equals(null));
		assertTrue(set.equals(getDataSource()));
		assertTrue(set.equals(set.asSet()));
		assertFalse(set.equals(set.including(null)));
		assertFalse(set.equals(set.excluding(set.asSequence().first())));
		assertFalse(set.equals(set.excluding(set.asSequence().last())));
	}

	/**
	 * Tests {@link LazySet#flatten()}.
	 */
	public void testFlatten() {
		final LazySet<String> set = getTestLazyCollection();
		final LazySet<?> newSet = set.flatten();
		assertEquals(set, newSet);
	
		final LazySet<LazySet<String>> setSet = new LazySet<LazySet<String>>().including(set);
		assertEquals(set, setSet.flatten());
	
		final LazySet<LazySet<LazySet<String>>> setSetSet = new LazySet<LazySet<LazySet<String>>>().including(setSet);
		assertEquals(set, setSetSet.flatten());
	
		final LazySet<LazyBag<LazySet<String>>> setBagSet = new LazySet<LazyBag<LazySet<String>>>()
				.including(new LazyBag<LazySet<String>>().including(set).including(set));
		assertEquals(set, setBagSet.flatten());
	}

	/**
	 * Tests {@link LazySet#hashCode()}.
	 */
	public void testHashCode() {
		final LazySet<String> set = getTestLazyCollection();
		assertEquals(set.asSet().hashCode(), set.hashCode());
		assertEquals(getDataSource().hashCode(), set.hashCode());
		assertFalse(set.hashCode() == set.including("Four").hashCode());
	}

	/**
	 * Tests {@link LazySet#asString()}.
	 */
	public void testAsString() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertEquals(getDataSource().toString().replace("[", "Set{'").replace(", ", "', '").replace("]", "'}"),
				list.asString(EmftvmFactory.eINSTANCE.createExecEnv()));
	}

	/**
	 * Tests {@link LazySet#intersection(LazySet)}.
	 */
	public void testIntersection() {
		final LazySet<String> set = getTestLazyCollection();
		final LazySet<String> intersection = set.intersection(set);
		assertEquals(set, intersection);
		assertEquals(set.excluding("Three"), set.intersection(set.excluding("Three")));
		assertEquals(new LazySet<String>(), set.intersection(new LazySet<String>()));
		assertEquals(new LazySet<String>(), new LazySet<String>().intersection(set));
		final LazySet<String> otherSet = new LazySet<String>().including("One").including("Two");
		assertEquals(otherSet, set.intersection(otherSet));
		assertEquals(otherSet, otherSet.intersection(set));
	}

	/**
	 * Tests {@link LazySet#intersection(LazyBag)}.
	 */
	public void testIntersection_LazyBag() {
		final LazySet<String> set = getTestLazyCollection();
		final LazyBag<String> bag = set.asBag();
		final LazySet<String> intersection = set.intersection(bag);
		assertEquals(set, intersection);
		assertEquals(set.excluding("Three"), set.intersection(bag.excluding("Three")));
		assertEquals(new LazySet<String>(), set.intersection(new LazyBag<String>()));
		assertEquals(new LazySet<String>(), new LazySet<String>().intersection(bag));
		final LazyBag<String> otherBag = new LazyBag<String>().including("One").including("Two");
		assertEquals(otherBag.asSet(), set.intersection(otherBag));
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
	 * Tests {@link LazySet#reject(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testReject() {
		final LazySet<String> set = getTestLazyCollection();
		final String element = set.asSequence().last();
		final LazySet<String> rejected = set.reject(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return ((String) frame.getLocal(0)).equals(element);
			}

		});
		assertEquals(set.size() - 1, rejected.size());
		assertFalse(rejected.contains(element));
		assertEquals(set.excluding(element), rejected);

		assertEquals(0, set.reject(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return true;
			}

		}).size());

		assertEquals(set.size(), set.reject(new NativeCodeBlock() {
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
	 * Tests {@link LazySet#select(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testSelect() {
		final LazySet<String> set = getTestLazyCollection();
		final String element = set.asSequence().last();
		final LazySet<String> selected = set.select(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return ((String) frame.getLocal(0)).equals(element);
			}

		});
		assertEquals(1, selected.size());
		assertTrue(selected.contains(element));
		for (String s : selected) {
			assertEquals(element, s);
		}

		assertEquals(0, set.select(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}

			@Override
			public Object execute(final StackFrame frame) {
				return false;
			}

		}).size());

		assertEquals(set.size(), set.select(new NativeCodeBlock() {
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
	 * Tests {@link LazySet#subtract(LazySet)}.
	 */
	public void testSubtract() {
		final LazySet<String> set = getTestLazyCollection();
		assertEquals(new LazySet<String>(), set.subtract(set));
		assertEquals(set, set.subtract(new LazySet<String>()));
		assertEquals(set, set.subtract(new LazySet<String>().including("other")));
		final LazySet<String> otherSet = set.excluding(set.asSequence().first());
		assertFalse(set.equals(set.subtract(otherSet)));
		assertFalse(otherSet.equals(set.subtract(otherSet)));
	}

	/**
	 * Tests {@link LazySet#symmetricDifference(LazySet)}.
	 */
	public void testSymmetricDifference() {
		final LazySet<String> set = getTestLazyCollection();
		assertEquals(new LazySet<String>(), set.symmetricDifference(set));
		assertEquals(set, set.symmetricDifference(new LazySet<String>()));
		assertEquals(set.including("other"), set.symmetricDifference(new LazySet<String>().including("other")));
		final String element = set.asSequence().first();
		final LazySet<String> otherSet = set.excluding(element);
		assertEquals(new LazySet<String>().including(element), set.symmetricDifference(otherSet));
		assertEquals(new LazySet<String>().including(element), set.symmetricDifference(otherSet));
	}

	/**
	 * Tests {@link LazySet#union(LazySet)}.
	 */
	public void testUnion() {
		final LazySet<String> set = getTestLazyCollection();
		assertEquals(set, set.union(set));
		assertEquals(set, set.union(new LazySet<String>()));
		assertEquals(set, new LazySet<String>().union(set));
	}

	/**
	 * Tests {@link LazySet#union(LazyBag)}.
	 */
	public void testUnion_LazyBag() {
		final LazySet<String> set = getTestLazyCollection();
		final LazyBag<String> bag = set.asBag();
		final LazyBag<String> union = set.union(bag);
		assertEquals(set.size() + bag.size(), union.size());
		for (String s : set) {
			assertEquals(2, union.count(s));
		}
		assertEquals(bag, set.union(new LazyBag<String>()));
		assertEquals(bag, new LazySet<String>().union(bag));
	}

	/*
	 * TODO all other operations.
	 */

}
