/*******************************************************************************
 * Copyright (c) 2011 Dennis Wagelaar, Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.tests.fib;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.Operation;
import org.eclipse.m2m.atl.emftvm.util.EMFTVMUtil;
import org.eclipse.m2m.atl.emftvm.util.NativeCodeBlock;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
import org.eclipse.m2m.atl.emftvm.util.VMException;
import org.eclipse.m2m.atl.emftvm.util.VMMonitor;

/**
 * Viability test for developing a JIT compiler.
 * Implements the fib() operation from Fibonacci.emftvm.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class Fibonacci extends NativeCodeBlock {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StackFrame execute(final StackFrame frame) {
		final VMMonitor monitor = frame.getEnv().getMonitor();
		try {
			if (monitor != null) {
				if (monitor.isTerminated()) {
					throw new VMException(frame, "Execution terminated.");
				} else {
					frame.setPc(2);
					monitor.step(frame);
				}
			}
			if ((Boolean)invoke("<", frame.getLocal(0, 0), new Object[]{2}, frame)) {
				frame.load(0, 0);
			} else {
				if (monitor != null) {
					if (monitor.isTerminated()) {
						throw new VMException(frame, "Execution terminated.");
					} else {
						frame.setPc(14);
						monitor.step(frame);
					}
				}
				frame.push(invoke("+", 
						invoke("fib", invoke("-", frame.getLocal(0, 0), new Object[]{1}, frame), new Object[0], frame),
						new Object[] {
							invoke("fib",	invoke("-", frame.getLocal(0, 0), new Object[]{2}, frame), new Object[0], frame)
						}, frame));
			}
		} catch (VMException e) {
			throw e;
		} catch (Exception e) {
			throw new VMException(frame, e);
		}
		return frame;
	}

	private static Object invoke(final String opname, final Object self, final Object[] args,
			final StackFrame frame) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		final Operation op = frame.getEnv().findOperation(
				EMFTVMUtil.getArgumentType(self), 
				opname, 
				EMFTVMUtil.getArgumentTypes(args));
		if (op != null) {
			final CodeBlock body = op.getBody();
			final StackFrame rFrame = body.execute(frame.getSubFrame(body, self, args));
			return rFrame.stackEmpty() ? null : rFrame.pop();
		}
		return EMFTVMUtil.invokeNative(frame, self, opname, args);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getMaxLocals() {
		return 1;
	}

	/**
	 * Fibonacci in plain Java.
	 * @param n
	 * @return fibonacci of <code>n</code>
	 */
	public int fib(final int n) {
		if (n < 2) {
			return n;
		} else {
			return fib(n-1) + fib(n-2);
		}
	}
}
