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
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.util.LazyBag;
import org.eclipse.m2m.atl.emftvm.util.LazyBagOnCollection;
import org.eclipse.m2m.atl.emftvm.util.LazyCollection;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.LazySet;
import org.eclipse.m2m.atl.emftvm.util.NativeCodeBlock;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;

/**
 * Tests {@link LazyBag}.
 * 
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class LazyBagTest extends LazyCollectionTest {

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
	protected LazyBag<String> getTestLazyCollection() {
		// Don't reuse lazy collections because their cache takes over when it
		// is complete
		return new LazyBag<String>(getDataSource());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected <T> LazyBag<T> getEmptyLazyCollection() {
		return new LazyBag<T>(null);
	}

	/**
	 * Tests {@link LazyBag#collect(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testCollect() {
		final LazyBag<String> bag = getTestLazyCollection();
		final LazyBag<Integer> lengths = bag.collect(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}
	
			@Override
			public Object execute(final StackFrame frame) {
				return ((String) frame.getLocal(0)).length();
			}
	
		});
		assertEquals(bag.size(), lengths.size());
		final Iterator<Integer> lengthIt = lengths.iterator();
		for (String element : bag) {
			assertEquals(element.length(), lengthIt.next().intValue());
		}
		assertFalse(lengthIt.hasNext());
	
		final LazyBag<Object> nulls = bag.collect(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}
		});
		assertEquals(bag.size(), nulls.size());
		final Iterator<Object> nullIt = nulls.iterator();
		for (@SuppressWarnings("unused")
		String element : bag) {
			assertNull(nullIt.next());
		}
		assertFalse(nullIt.hasNext());
	}

	/**
	 * Tests {@link LazyBag#equals(Object)}.
	 */
	public void testEquals() {
		final LazyBag<String> bag = getTestLazyCollection();
		assertTrue(bag.equals(bag));
		assertFalse(bag.equals(this));
		assertFalse(bag.equals(null));
		assertFalse(bag.equals(getDataSource()));
		assertTrue(bag.equals(bag.asBag()));
		assertFalse(bag.equals(bag.including(null)));
		assertFalse(bag.equals(bag.excluding(bag.asSequence().first())));
		assertFalse(bag.equals(bag.excluding(bag.asSequence().last())));
	}

	/**
	 * Tests {@link LazyBag#flatten()}.
	 */
	public void testFlatten() {
		final LazyBag<String> bag = getTestLazyCollection();
		final LazyBag<?> newBag = bag.flatten();
		assertEquals(bag, newBag);
	
		final LazyBag<LazyBag<String>> bagBag = new LazyBag<LazyBag<String>>().including(bag);
		assertEquals(bag, bagBag.flatten());
	
		final LazyBag<LazyBag<LazyBag<String>>> bagBagBag = new LazyBag<LazyBag<LazyBag<String>>>().including(bagBag);
		assertEquals(bag, bagBagBag.flatten());
	
		final LazyBag<LazySet<LazyBag<String>>> bagSetBag = new LazyBag<LazySet<LazyBag<String>>>()
				.including(new LazySet<LazyBag<String>>().including(bag).including(bag));
		assertEquals(bag, bagSetBag.flatten());
	}

	/**
	 * Tests {@link LazyBag#hashCode()}.
	 */
	public void testHashCode() {
		final LazyBag<String> bag = getTestLazyCollection();
		assertEquals(bag.asBag().hashCode(), bag.hashCode());
		assertFalse(getDataSource().hashCode() == bag.hashCode());
		assertFalse(bag.hashCode() == bag.including("Four").hashCode());
	}

	/**
	 * Tests {@link LazyBag#asString()}.
	 */
	public void testAsString() {
		final LazyCollection<String> bag = getTestLazyCollection();
		assertEquals(getDataSource().toString().replace("[", "Bag{'").replace(", ", "', '").replace("]", "'}"),
				bag.asString(EmftvmFactory.eINSTANCE.createExecEnv()));
	}

	/**
	 * Tests {@link LazyBag#intersection(LazyBag)}.
	 */
	public void testIntersection() {
		final LazyBag<String> bag = getTestLazyCollection();
		final LazyBag<String> intersection = bag.intersection(bag);
		assertEquals(bag, intersection);
		assertEquals(bag.excluding("Three"), bag.intersection(bag.excluding("Three")));
		assertEquals(new LazyBag<String>(), bag.intersection(new LazyBag<String>()));
		assertEquals(new LazyBag<String>(), new LazyBag<String>().intersection(bag));
		final LazyBag<String> otherBag = new LazyBag<String>().including("One").including("Two").including("Three");
		assertEquals(otherBag, bag.intersection(otherBag));
		assertEquals(otherBag, otherBag.intersection(bag));
	}

	/**
	 * Tests {@link LazyBag#intersection(LazySet)}.
	 */
	public void testIntersection_LazySet() {
		final LazyBag<String> bag = getTestLazyCollection();
		final LazySet<String> set = bag.asSet();
		final LazySet<String> intersection = bag.intersection(set);
		assertEquals(set, intersection);
		assertEquals(set.excluding("Three"), bag.intersection(set.excluding("Three")));
		assertEquals(new LazySet<String>(), bag.intersection(new LazySet<String>()));
		assertEquals(new LazySet<String>(), new LazyBag<String>().intersection(set));
		final LazySet<String> otherSet = new LazySet<String>().including("One").including("Two").including("Three");
		assertEquals(otherSet, bag.intersection(otherSet));
	}

	/**
	 * Tests {@link LazyBag#reject(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testReject() {
		final LazyBag<String> bag = getTestLazyCollection();
		final String element = bag.asSequence().last();
		final LazyBag<String> rejected = bag.reject(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}
	
			@Override
			public Object execute(final StackFrame frame) {
				return ((String) frame.getLocal(0)).equals(element);
			}
	
		});
		assertEquals(bag.size() - bag.count(element), rejected.size());
		assertFalse(rejected.contains(element));
		assertEquals(bag.excluding(element), rejected);
	
		assertEquals(0, bag.reject(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}
	
			@Override
			public Object execute(final StackFrame frame) {
				return true;
			}
	
		}).size());
	
		assertEquals(bag.size(), bag.reject(new NativeCodeBlock() {
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
	 * Tests {@link LazyBag#select(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testSelect() {
		final LazyBag<String> bag = getTestLazyCollection();
		final String element = bag.asSequence().last();
		final LazyBag<String> selected = bag.select(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}
	
			@Override
			public Object execute(final StackFrame frame) {
				return ((String) frame.getLocal(0)).equals(element);
			}
	
		});
		assertEquals(bag.count(element), selected.size());
		assertTrue(selected.contains(element));
		for (String s : selected) {
			assertEquals(element, s);
		}
	
		assertEquals(0, bag.select(new NativeCodeBlock() {
			{
				setParentFrame(new StackFrame(EmftvmFactory.eINSTANCE.createExecEnv(), this));
				getLocalVariables().add(EmftvmFactory.eINSTANCE.createLocalVariable());
			}
	
			@Override
			public Object execute(final StackFrame frame) {
				return false;
			}
	
		}).size());
	
		assertEquals(bag.size(), bag.select(new NativeCodeBlock() {
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
	 * Tests {@link LazyBag#union(LazyBag)}.
	 */
	public void testUnion() {
		final LazyBag<String> bag = getTestLazyCollection();
		final LazyBag<String> union = bag.union(bag);
		assertEquals(bag.size() * 2, union.size());
		for (String s : bag) {
			assertEquals(bag.count(s) * 2, union.count(s));
		}
		assertEquals(bag, bag.union(new LazyBag<String>()));
		assertEquals(bag, new LazyBag<String>().union(bag));
	}

	/**
	 * Tests {@link LazyBag#union(LazySet)}.
	 */
	public void testUnion_LazySet() {
		final LazyBag<String> bag = getTestLazyCollection();
		final LazySet<String> set = bag.asSet();
		final LazyBag<String> union = bag.union(set);
		assertEquals(bag.size() + set.size(), union.size());
		for (String s : bag) {
			assertEquals(bag.count(s) + 1, union.count(s));
		}
		assertEquals(bag, bag.union(new LazySet<String>()));
	}

	/**
	 * Tests {@link LazyBag#sortedBy(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 */
	public void testSortedBy() {
		final LazyBag<String> bag = getTestLazyCollection();
		final List<String> expected = new ArrayList<String>(getDataSource());
		Collections.sort(expected);
		final LazyList<String> sortedList = bag.sortedBy(new NativeCodeBlock() {
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
			Iterator<EObject> contents = EmftvmPackage.eINSTANCE.eResource().getAllContents();
			while (contents.hasNext()) {
				data.add(contents.next());
			}
		}
		final List<Object> expected2 = new ArrayList<Object>(data);
		final LazyBag<Object> bag2 = new LazyBagOnCollection<Object>(data);
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
				return Integer.compare(
						(Integer) byHashCode.execute(byHashCode.getParentFrame().getSubFrame(byHashCode, o1)), 
						(Integer) byHashCode.execute(byHashCode.getParentFrame().getSubFrame(byHashCode, o2)));
			}
		});
		final long refEnd2 = System.nanoTime();
		final LazyList<Object> sortedList2 = bag2.sortedBy(byHashCode);
		sortedList2.last(); // force eval
		final long lazyEnd2 = System.nanoTime();
		assertEquals(expected2, sortedList2);
		ATLLogger.info(String.format("Collections.sort() : %d ms, LazyBag.sortedBy() : %d ms", (refEnd2 - refStart2) / 1000000L, (lazyEnd2 - refEnd2) / 1000000L)); 
	}

}
