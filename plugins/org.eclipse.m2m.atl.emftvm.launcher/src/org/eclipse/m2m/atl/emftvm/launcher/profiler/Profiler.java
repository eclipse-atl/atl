/*******************************************************************************
 * Copyright (c) 2014 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.launcher.profiler;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.launcher.LaunchAdapter;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;

/**
 * Profiler for EMFTVM.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 * 
 */
public class Profiler extends LaunchAdapter {

	/**
	 * Key-value pair.
	 * 
	 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
	 * 
	 * @param <K>
	 *            the key type
	 * @param <V>
	 *            the value type
	 */
	static class Pair<K, V> {

		private K key;
		private V value;

		public Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * @return the key
		 */
		public K getKey() {
			return key;
		}

		/**
		 * @param key
		 *            the key to set
		 */
		public void setKey(K key) {
			this.key = key;
		}

		/**
		 * @return the value
		 */
		public V getValue() {
			return value;
		}

		/**
		 * @param value
		 *            the value to set
		 */
		public void setValue(V value) {
			this.value = value;
		}

	}

	private static final double DIVISOR = 1E9;

	private final Map<CodeBlock, Pair<Long, StopWatch>> codeBlockTimings = new HashMap<CodeBlock, Pair<Long, StopWatch>>();
	private final Map<Method, Pair<Long, StopWatch>> nativeMethodTimings = new HashMap<Method, Pair<Long, StopWatch>>();
	private final Stack<Pair<Long, StopWatch>> timingStack = new Stack<Pair<Long, StopWatch>>();

	/**
	 * Creates a new {@link Profiler}.
	 * 
	 * @param launch
	 *            the launch object to wrap
	 */
	public Profiler(ILaunch launch) {
		super(launch);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void enter(final StackFrame frame) {
		final Pair<Long, StopWatch> timings = getTimings(frame);
		if (timings != null) {
			if (!timingStack.isEmpty()) {
				timingStack.peek().getValue().stop();
			}
			timings.setKey(timings.getKey() + 1L);
			timings.getValue().start();
			timingStack.push(timings);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void leave(final StackFrame frame) {
		if (!timingStack.isEmpty()) {
			final Pair<Long, StopWatch> timings = timingStack.pop();
			assert timings == getTimings(frame);
			timings.getValue().stop();
			if (!timingStack.isEmpty()) {
				timingStack.peek().getValue().start();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void terminated() {
		while (!timingStack.isEmpty()) {
			timingStack.pop().getValue().stop();
		}

		final List<Object> sorted = new ArrayList<Object>(codeBlockTimings.size() + nativeMethodTimings.size());
		sorted.addAll(codeBlockTimings.keySet());
		sorted.addAll(nativeMethodTimings.keySet());
		Collections.sort(sorted, new Comparator<Object>() {
			public int compare(final Object o1, final Object o2) {
				return -Long.valueOf(getTimings(o1).getValue().getDuration()).compareTo(
						Long.valueOf(getTimings(o2).getValue().getDuration()));
			}
		});
		final StringBuilder sb = new StringBuilder("Profiling results:\n\tDuration (sec.)\tInvocations\tOperation\n");
		for (Object op : sorted) {
			Pair<Long, StopWatch> timings = getTimings(op);
			sb.append(String.format("\t%15.6f\t%11d\t%s\n", timings.getValue().getDuration() / DIVISOR, timings.getKey(), op));
		}
		ATLLogger.info(sb.toString());
	}

	/**
	 * Returns the timings for the given stack frame.
	 * 
	 * @param frame
	 *            the stack frame
	 * @return the timings for the given stack frame, or <code>null</code> if no operation is linked to the stack frame
	 */
	private Pair<Long, StopWatch> getTimings(final StackFrame frame) {
		final CodeBlock cb = frame.getCodeBlock();
		if (cb != null) {
			Pair<Long, StopWatch> timings = codeBlockTimings.get(cb);
			if (timings == null) {
				timings = new Pair<Long, StopWatch>(0L, new StopWatch());
				codeBlockTimings.put(cb, timings);
			}
			return timings;
		}
		final Method m = frame.getNativeMethod();
		if (m != null) {
			Pair<Long, StopWatch> timings = nativeMethodTimings.get(m);
			if (timings == null) {
				timings = new Pair<Long, StopWatch>(0L, new StopWatch());
				nativeMethodTimings.put(m, timings);
			}
			return timings;
		}
		return null;
	}

	/**
	 * Returns the timings for the given codeblock or native method.
	 * 
	 * @param operation
	 *            the codeblock or native method
	 * @return the timings for the given codeblock or native method, or <code>null</code> if no operation is linked to the stack frame
	 */
	private Pair<Long, StopWatch> getTimings(final Object operation) {
		Pair<Long, StopWatch> timings = codeBlockTimings.get(operation);
		if (timings == null) {
			timings = nativeMethodTimings.get(operation);
		}
		return timings;
	}

}
