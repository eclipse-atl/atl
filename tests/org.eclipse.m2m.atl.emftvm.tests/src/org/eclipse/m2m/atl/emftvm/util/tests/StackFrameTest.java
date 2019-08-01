/*******************************************************************************
 * Copyright (c) 2016 Dennis Wagelaar.
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

import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.LocalVariable;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.NativeCodeBlock;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
import org.eclipse.m2m.atl.emftvm.util.VMException;

import junit.framework.TestCase;

/**
 * Tests {@link StackFrame}.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class StackFrameTest extends TestCase {

	/**
	 * Test method for
	 * {@link org.eclipse.m2m.atl.emftvm.util.StackFrame#toString()}. Tests for
	 * regression of Bug # 499982.
	 */
	public void testToString_Bug499982() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final CodeBlock codeBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		final LocalVariable localVariable = EmftvmFactory.eINSTANCE.createLocalVariable();
		localVariable.setName("exceptionList");
		localVariable.setType("Sequence(Integer)");
		codeBlock.getLocalVariables().add(localVariable);
		final StackFrame rootFrame = new StackFrame(env, codeBlock);
		final NativeCodeBlock function = new NativeCodeBlock() {
			@Override
			public Object execute(StackFrame frame) {
				throw new VMException(frame, "testToString_Bug499982");
			}
		};
		function.setParentFrame(rootFrame);
		function.setMaxLocals(1);
		final LazyList<Integer> exceptionList = new LazyList<Integer>().append(3).collect(function);
		rootFrame.setLocal(exceptionList, 0);

		final String result = rootFrame.toString();

		assertEquals("at @uncontained(<unknown>)\n\tLocal variables: <VMException>", result);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.m2m.atl.emftvm.util.StackFrame#toString()}. Tests for
	 * regression of Bug # 499982.
	 */
	public void testToString_Bug499982_withCodeBlock() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final CodeBlock codeBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		final LocalVariable localVariable = EmftvmFactory.eINSTANCE.createLocalVariable();
		localVariable.setName("exceptionList");
		localVariable.setType("Sequence(Integer)");
		codeBlock.getLocalVariables().add(localVariable);
		final StackFrame rootFrame = new StackFrame(env, codeBlock);
		final NativeCodeBlock function = new NativeCodeBlock() {
			@Override
			public Object execute(StackFrame frame) {
				throw new VMException(frame, "testToString_Bug499982_withCodeBlock");
			}
		};
		function.setParentFrame(rootFrame);
		function.setMaxLocals(1);
		function.getCode().add(EmftvmFactory.eINSTANCE.createPusht());
		final LazyList<Integer> exceptionList = new LazyList<Integer>().append(3).collect(function);
		rootFrame.setLocal(exceptionList, 0);
		final StackFrame subFrame = rootFrame.getSubFrame(function, 3);
		subFrame.setPc(1);

		final String result = subFrame.toString();

		assertEquals(
				"at @uncontained#0(<unknown>)\n\tLocal variables: []\nat @uncontained(<unknown>)\n\tLocal variables: <VMException>",
				result);
	}

}
