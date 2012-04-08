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
package org.eclipse.m2m.atl.emftvm.launcher;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
import org.eclipse.m2m.atl.emftvm.util.VMMonitor;

/**
 * Adapts an {@link ILaunch} object to the {@link VMMonitor} interface.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class LaunchAdapter implements VMMonitor {

	private final ILaunch launch;
	private boolean terminated;

	/**
	 * Creates a new {@link LaunchAdapter}.
	 * @param launch the launch object to wrap
	 */
	public LaunchAdapter(final ILaunch launch) {
		if (launch == null) {
			throw new IllegalArgumentException("launch cannot be null.");
		}
		this.launch = launch;
		new Thread() {
			@Override
			public void run() {
				// This runs until the launch is terminated
				while (!isTerminated()) {
					setTerminated(launch.isTerminated()); // very slow
					try {
						sleep(500);
					} catch (InterruptedException e) {
						// do nothing
					}
				}
			}
		}.start();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.emftvm.util.VMMonitor#isTerminated()
	 */
	public boolean isTerminated() {
		return terminated;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.util.VMMonitor#enter(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 */
	public void enter(final StackFrame frame) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.util.VMMonitor#leave(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 */
	public void leave(final StackFrame frame) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.util.VMMonitor#step(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 */
	public void step(final StackFrame frame) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.util.VMMonitor#terminated()
	 */
	public void terminated() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.util.VMMonitor#error(StackFrame, String, Exception)
	 */
	public void error(final StackFrame frame, final String msg, final Exception e) {
	}

	/**
	 * Returns the Eclipse launch object.
	 * @return the launch
	 */
	public ILaunch getLaunch() {
		return launch;
	}

	/**
	 * Sets whether this launch is terminated.
	 * @param terminated whether this launch is terminated
	 */
	protected void setTerminated(final boolean terminated) {
		this.terminated = terminated;
	}

}
