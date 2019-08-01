/*******************************************************************************
 * Copyright (c) 2014 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.profiler;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
import org.eclipse.m2m.atl.emftvm.util.VMMonitor;

/**
 * Profiler for EMFTVM.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class Profiler implements VMMonitor {

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

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String toString() {
			return "Pair [key=" + key + ", value=" + value + "]";
		}

	}

	/**
	 * Profiling data for a single operation ({@link CodeBlock} or {@link Method}).
	 * 
	 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
	 */
	public static class ProfilingData {

		private final CodeBlock codeBlock;
		private final Method method;
		private final long duration;
		private final double durationRatio;
		private final long invocations;

		/**
		 * Creates a new {@link ProfilingData}.
		 * 
		 * @param codeBlock
		 *            the {@link CodeBlock}, if applicable
		 * @param method
		 *            the native {@link Method}, if applicable
		 * @param duration
		 *            the duration spent in nanoseconds
		 * @param durationRatio
		 *            the duration ratio to the total execution time
		 * @param invocations
		 *            the amount of invocations
		 */
		public ProfilingData(CodeBlock codeBlock, Method method, long duration, double durationRatio, long invocations) {
			this.codeBlock = codeBlock;
			this.method = method;
			this.duration = duration;
			this.durationRatio = durationRatio;
			this.invocations = invocations;
		}

		/**
		 * Returns the {@link CodeBlock}, if applicable.
		 * 
		 * @return the codeBlock, or <code>null</code>
		 */
		public CodeBlock getCodeBlock() {
			return codeBlock;
		}

		/**
		 * Returns the native {@link Method}, if applicable.
		 * 
		 * @return the method, or <code>null</code>
		 */
		public Method getMethod() {
			return method;
		}

		/**
		 * Returns the duration spent in nanoseconds.
		 * 
		 * @return the duration
		 */
		public long getDuration() {
			return duration;
		}

		/**
		 * Returns the duration ratio to the total execution time.
		 * 
		 * @return the durationRatio
		 */
		public double getDurationRatio() {
			return durationRatio;
		}

		/**
		 * Returns the amount of invocations.
		 * 
		 * @return the invocations
		 */
		public long getInvocations() {
			return invocations;
		}
		
		/**
		 * Returns {@link #getCodeBlock()} or {@link #getMethod()}, whichever is not <code>null</code>.
		 * @return {@link #getCodeBlock()}, {@link #getMethod()}, or <code>null</code>
		 */
		public Object getOperation() {
			Object operation = getCodeBlock();
			if (operation == null) {
				operation = getMethod();
			}
			return operation;
		}

	}

	private static final double DIVISOR = 1E9;
	private static final double HUNDRED = 1E2;

	private final StopWatch stopWatch = new StopWatch();
	private final Map<CodeBlock, Pair<Long, StopWatch>> codeBlockTimings = new HashMap<CodeBlock, Pair<Long, StopWatch>>();
	private final Map<Method, Pair<Long, StopWatch>> nativeMethodTimings = new HashMap<Method, Pair<Long, StopWatch>>();
	private final Stack<Pair<Long, StopWatch>> timingStack = new Stack<Pair<Long, StopWatch>>();
	private final List<ProfilingData> results = new ArrayList<ProfilingData>();

	/**
	 * {@inheritDoc}
	 */
	public boolean isTerminated() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void enter(final StackFrame frame) {
		// Start global stopwatch on first entry
		if (timingStack.isEmpty()) {
			stopWatch.start();
		}
		// Process current operation timings, and pause parent operation timings
		final Pair<Long, StopWatch> timings = getTimings(frame);
		if (timings != null) {
			if (!timingStack.isEmpty()) {
				Pair<Long, StopWatch> currentTimings = timingStack.peek();
				if (currentTimings != timings) {
					currentTimings.getValue().stop();
				}
			}
			timings.setKey(timings.getKey() + 1L);
			timings.getValue().start();
			timingStack.push(timings);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void leave(final StackFrame frame) {
		if (!timingStack.isEmpty()) {
			final Pair<Long, StopWatch> timings = timingStack.pop();
			assert timings == getTimings(frame);
			if (!timingStack.isEmpty()) {
				Pair<Long, StopWatch> parentTimings = timingStack.peek();
				if (parentTimings != timings) {
					timings.getValue().stop();
					parentTimings.getValue().start();
				}
			} else {
				timings.getValue().stop();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void step(StackFrame frame) {
	}

	/**
	 * {@inheritDoc}
	 */
	public void terminated() {
		// Stop any running stopwatches
		while (!timingStack.isEmpty()) {
			timingStack.pop().getValue().stop();
		}
		stopWatch.stop();
		final long globalDuration = stopWatch.getDuration();
		stopWatch.reset();

		// Sort results by descending duration
		final List<Object> sorted = new ArrayList<Object>(codeBlockTimings.size() + nativeMethodTimings.size());
		sorted.addAll(codeBlockTimings.keySet());
		sorted.addAll(nativeMethodTimings.keySet());
		Collections.sort(sorted, new Comparator<Object>() {
			public int compare(final Object o1, final Object o2) {
				return -Long.valueOf(getTimings(o1).getValue().getDuration()).compareTo(
						Long.valueOf(getTimings(o2).getValue().getDuration()));
			}
		});

		// Compile profiling results
		for (Object op : sorted) {
			ProfilingData profilingData;
			Pair<Long, StopWatch> timings = getTimings(op);
			long duration = timings.getValue().getDuration();
			double ratio = (double) duration / (double) globalDuration;
			if (op instanceof CodeBlock) {
				profilingData = new ProfilingData((CodeBlock) op, null, duration, ratio, timings.getKey());
			} else {
				profilingData = new ProfilingData(null, (Method) op, duration, ratio, timings.getKey());
			}
			results.add(profilingData);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void error(StackFrame frame, String msg, Exception e) {
	}

	/**
	 * Returns the profiling results.
	 * 
	 * @return the results
	 */
	public List<ProfilingData> getResults() {
		return results;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Profiling results:\n\tDuration (sec.)\tDuration (%)\tInvocations\tOperation\n");
		for (ProfilingData profilingData : getResults()) {
			sb.append(String.format("\t%15.6f\t%12.2f\t%11d\t%s\n", profilingData.getDuration() / DIVISOR, profilingData.getDurationRatio() * HUNDRED, profilingData.getInvocations(), profilingData.getOperation()));
		}
		return sb.toString();
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
