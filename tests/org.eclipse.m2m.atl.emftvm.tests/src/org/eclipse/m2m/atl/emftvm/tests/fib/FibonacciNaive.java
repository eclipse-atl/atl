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
public class FibonacciNaive extends NativeCodeBlock {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StackFrame execute(final StackFrame frame) {
		final VMMonitor monitor = frame.getEnv().getMonitor();
		try {
			checkMonitor(monitor, frame, 1);
			frame.push(2);
			checkMonitor(monitor, frame, 2);
			frame.load(0, 0);
			checkMonitor(monitor, frame, 3);
			frame.setPc(3);
			frame.push(invoke(frame, "<", frame.pop(), frame.pop()));
			checkMonitor(monitor, frame, 4);
			if ((Boolean)frame.pop()) {
				checkMonitor(monitor, frame, 5);
				frame.load(0, 0);
			} else {
				checkMonitor(monitor, frame, 6);
				checkMonitor(monitor, frame, 7);
				frame.push(2);
				checkMonitor(monitor, frame, 8);
				frame.load(0, 0);
				checkMonitor(monitor, frame, 9);
				frame.setPc(9);
				frame.push(invoke(frame, "-", frame.pop(), frame.pop()));
				checkMonitor(monitor, frame, 10);
				frame.setPc(10);
				frame.push(invoke(frame, "fib", frame.pop()));
				checkMonitor(monitor, frame, 11);
				frame.push(1);
				checkMonitor(monitor, frame, 12);
				frame.load(0, 0);
				checkMonitor(monitor, frame, 13);
				frame.setPc(13);
				frame.push(invoke(frame, "-", frame.pop(), frame.pop()));
				checkMonitor(monitor, frame, 14);
				frame.setPc(14);
				frame.push(invoke(frame, "fib", frame.pop()));
				checkMonitor(monitor, frame, 15);
				frame.setPc(15);
				frame.push(invoke(frame, "+", frame.pop(), frame.pop(), frame));
			}
		} catch (VMException e) {
			throw e;
		} catch (Exception e) {
			throw new VMException(frame, e);
		}
		return frame;
	}

	private static Object invoke(final StackFrame frame, final String opname, final Object self, final Object... args) 
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
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
	 * Gets argcount objects off the stack and returns them.
	 * @param argcount
	 * @param frame
	 * @return the arguments
	 */
	private static Object[] getArguments(final int argcount, final StackFrame frame) {
		final Object[] args = new Object[argcount];
		for (int i = 0; i < argcount; i++) {
			args[i] = frame.pop();
		}
		return args;
	}

	private static void checkMonitor(final VMMonitor monitor, final StackFrame frame, final int pc) {
		if (monitor != null) {
			if (monitor.isTerminated()) {
				throw new VMException(frame, "Execution terminated.");
			} else {
				frame.setPc(pc);
				monitor.step(frame);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getMaxLocals() {
		return 1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getMaxStack() {
		return 3;
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
