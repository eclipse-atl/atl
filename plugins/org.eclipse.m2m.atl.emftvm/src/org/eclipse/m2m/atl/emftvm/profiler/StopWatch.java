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
package org.eclipse.m2m.atl.emftvm.profiler;

/**
 * Stopwatch utility class.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class StopWatch {

	private long duration;
	private long start;
	private boolean started;

	/**
	 * Returns <code>true</code> if the stopwatch is started.
	 * 
	 * @return <code>true</code> if the stopwatch is started
	 */
	public boolean isStarted() {
		return started;
	}

	/**
	 * Starts the stopwatch.
	 */
	public void start() {
		if (!isStarted()) {
			start = System.nanoTime();
			started = true;
		}
	}

	/**
	 * Stops the stopwatch.
	 */
	public void stop() {
		if (isStarted()) {
			duration += System.nanoTime() - start;
			started = false;
		}
	}

	/**
	 * Resets the stopwatch to "0".
	 */
	public void reset() {
		duration = 0L;
		start = System.nanoTime();
	}

	/**
	 * Returns the measured duration in nanoseconds.
	 * 
	 * @return the measured duration in nanoseconds
	 */
	public long getDuration() {
		return duration;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "StopWatch [isStarted()=" + isStarted() + ", getDuration()=" + getDuration() + "]";
	}

}
