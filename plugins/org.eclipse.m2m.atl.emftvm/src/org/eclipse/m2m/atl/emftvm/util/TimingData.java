/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util;

/**
 * Records time data during the execution of the EMFTVM. 
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class TimingData {

	private static final double divisor = 1E9;

	private final long start;
	private long finishedLoading;
	private long finishedMatch;
	private long finishedApply;
	private long finishedPostApply;
	private long finishedRecursive;
	private long finished;

	/**
	 * Creates a new {@link TimingData} object, and starts time measurement.
	 */
	public TimingData() {
		super();
		this.start = System.nanoTime();
	}

	/**
	 * @return the period until loading was finished in nanoseconds
	 */
	public long getFinishedLoading() {
		return finishedLoading - start;
	}

	/**
	 * @return the period until matching was finished in nanoseconds
	 */
	public long getFinishedMatch() {
		return finishedMatch - start;
	}

	/**
	 * @return the period until applying was finished in nanoseconds
	 */
	public long getFinishedApply() {
		return finishedApply - start;
	}

	/**
	 * @return the period until post-applying was finished in nanoseconds
	 */
	public long getFinishedPostApply() {
		return finishedPostApply - start;
	}

	/**
	 * @return the period until the recursive stage was finished in nanoseconds
	 */
	public long getFinishedRecursive() {
		return finishedRecursive - start;
	}

	/**
	 * @return the period until execution was finished in nanoseconds
	 */
	public long getFinished() {
		return finished - start;
	}

	/**
	 * @param finishedLoading the finishedLoading to set
	 */
	protected void setFinishedLoading(long finishedLoading) {
		this.finishedLoading = finishedLoading;
	}

	/**
	 * @param finishedMatch the finishedMatch to set
	 */
	protected void setFinishedMatch(long finishedMatch) {
		this.finishedMatch = finishedMatch;
	}

	/**
	 * @param finishedApply the finishedApply to set
	 */
	protected void setFinishedApply(long finishedApply) {
		this.finishedApply = finishedApply;
	}

	/**
	 * @param finishedPostApply the finishedPostApply to set
	 */
	protected void setFinishedPostApply(long finishedPostApply) {
		this.finishedPostApply = finishedPostApply;
	}

	/**
	 * @param finishedRecursive the finishedRecursive to set
	 */
	protected void setFinishedRecursive(long finishedRecursive) {
		this.finishedRecursive = finishedRecursive;
	}

	/**
	 * @param finished the finished to set
	 */
	protected void setFinished(long finished) {
		this.finished = finished;
	}

	/**
	 * Marks the time when loading finishes.
	 */
	public void finishLoading() {
		this.finishedLoading = System.nanoTime();
	}

	/**
	 * Marks the time when matching finishes.
	 */
	public void finishMatch() {
		this.finishedMatch = System.nanoTime();
	}

	/**
	 * Marks the time when applying finishes.
	 */
	public void finishApply() {
		this.finishedApply = System.nanoTime();
	}

	/**
	 * Marks the time when post-applying finishes.
	 */
	public void finishPostApply() {
		this.finishedPostApply = System.nanoTime();
	}

	/**
	 * Marks the time when the recursive stage finishes.
	 */
	public void finishRecursive() {
		this.finishedRecursive = System.nanoTime();
	}

	/**
	 * Marks the time when execution finishes.
	 */
	public void finish() {
		this.finished = System.nanoTime();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("Timing data:\n");
		sb.append(String.format("\tLoading finished at %f seconds (duration: %f seconds)\n", 
				getFinishedLoading() / divisor, getFinishedLoading() / divisor));
		sb.append(String.format("\tMatching finished at %f seconds (duration: %f seconds)\n", 
				getFinishedMatch() / divisor, (getFinishedMatch() - getFinishedLoading()) / divisor));
		sb.append(String.format("\tApplying finished at %f seconds (duration: %f seconds)\n", 
				getFinishedApply() / divisor, (getFinishedApply() - getFinishedMatch()) / divisor));
		sb.append(String.format("\tPost-applying finished at %f seconds (duration: %f seconds)\n", 
				getFinishedPostApply() / divisor, (getFinishedPostApply() - getFinishedApply()) / divisor));
		sb.append(String.format("\tRecursive stage finished at %f seconds (duration: %f seconds)\n", 
				getFinishedRecursive() / divisor, (getFinishedRecursive() - getFinishedPostApply()) / divisor));
		sb.append(String.format("\tExecution finished at %f seconds (duration: %f seconds)\n", 
				getFinished() / divisor, (getFinished() - getFinishedPostApply()) / divisor));
		return sb.toString();
	}
}
