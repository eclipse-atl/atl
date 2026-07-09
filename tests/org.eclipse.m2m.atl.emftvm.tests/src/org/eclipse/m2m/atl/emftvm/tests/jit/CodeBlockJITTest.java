/*******************************************************************************
 * Copyright (c) 2026 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.tests.jit;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.jit.CodeBlockJIT;
import org.eclipse.m2m.atl.emftvm.jit.JITCodeBlock;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
import org.eclipse.m2m.atl.emftvm.util.VMException;
import org.eclipse.m2m.atl.emftvm.util.VMMonitor;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 *
 */
public class CodeBlockJITTest extends TestCase {

	private CodeBlockJIT jit;
	private ExecEnv env;

	/**
	 * @throws java.lang.Exception
	 */
	@Override
	@Before
	public void setUp() {
		env = EmftvmFactory.eINSTANCE.createExecEnv();
		jit = new CodeBlockJIT(env);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.m2m.atl.emftvm.jit.CodeBlockJIT#jit(org.eclipse.m2m.atl.emftvm.CodeBlock)}.
	 *
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	@Test
	public void testJitCompilation() throws ClassNotFoundException, IllegalArgumentException, SecurityException,
	InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		final CodeBlock cb = EmftvmFactory.eINSTANCE.createCodeBlock();
		cb.getCode().add(EmftvmFactory.eINSTANCE.createPusht()); // Add some instructions to the code block

		final JITCodeBlock jitCodeBlock = jit.jit(cb);

		assertNotNull(jitCodeBlock);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.m2m.atl.emftvm.jit.JITCodeBlock#execute(org.eclipse.m2m.atl.emftvm.util.StackFrame)}.
	 *
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws VMException
	 */
	@Test
	public void testExecute() throws ClassNotFoundException, IllegalArgumentException, SecurityException,
	InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, VMException {
		final CodeBlock cb = EmftvmFactory.eINSTANCE.createCodeBlock();
		cb.getCode().add(EmftvmFactory.eINSTANCE.createPusht()); // Add some instructions to the code block

		final JITCodeBlock jitCodeBlock = jit.jit(cb);
		final StackFrame frame = new StackFrame(env, cb);

		final Object result = jitCodeBlock.execute(frame);

		assertNotNull(result);
		assertEquals(Boolean.TRUE, result);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.m2m.atl.emftvm.jit.JITCodeBlock#execute(org.eclipse.m2m.atl.emftvm.util.StackFrame)}
	 * with a {@link org.eclipse.m2m.atl.emftvm.util.VMMonitor} attached.
	 *
	 * @throws Exception
	 */
	@Test
	public void testCheckMonitor() throws Exception {
		final CodeBlock cb = EmftvmFactory.eINSTANCE.createCodeBlock();
		cb.getCode().add(EmftvmFactory.eINSTANCE.createPusht()); // Add some instructions to the code block

		// Assuming a way to mock or set up monitor in the environment
		env.setMonitor(new VMMonitor() {
			@Override
			public boolean isTerminated() {
				return false;
			}

			@Override
			public void enter(final StackFrame frame) {
			}

			@Override
			public void leave(final StackFrame frame) {
				throw new VMException(frame, "Execution terminated.");
			}

			@Override
			public void step(final StackFrame frame) {
			}

			@Override
			public void terminated() {
			}

			@Override
			public void error(final StackFrame frame, final String msg, final Exception e) {
			}
		});

		final JITCodeBlock jitCodeBlock = jit.jit(cb);
		final StackFrame frame = new StackFrame(env, cb);

		try {
			jitCodeBlock.execute(frame);
			fail("Expected VMException");
		} catch (final VMException e) {
			assertEquals("Execution terminated.", e.getMessage());
		}
	}

}