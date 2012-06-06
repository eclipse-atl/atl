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
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
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
	 * Tests {@link LazyCollection#asString()}.
	 */
	@Override
	public void testAsString() {
		final LazyCollection<String> list = getTestLazyCollection();
		assertEquals(new LinkedHashSet<String>(getDataSource()).toString(), list.asString());
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

	/*
	 * TODO all other operations.
	 */

}
