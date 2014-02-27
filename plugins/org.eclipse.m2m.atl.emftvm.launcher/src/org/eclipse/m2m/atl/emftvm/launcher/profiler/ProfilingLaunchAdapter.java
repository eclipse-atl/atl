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

import org.eclipse.debug.core.ILaunch;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.emftvm.launcher.LaunchAdapter;
import org.eclipse.m2m.atl.emftvm.profiler.Profiler;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;

/**
 * Profiling {@link LaunchAdapter} for EMFTVM.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class ProfilingLaunchAdapter extends LaunchAdapter {

	private final Profiler profiler = new Profiler();

	/**
	 * Creates a new {@link ProfilingLaunchAdapter}.
	 * 
	 * @param launch
	 *            the launch object to wrap
	 */
	public ProfilingLaunchAdapter(ILaunch launch) {
		super(launch);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void enter(final StackFrame frame) {
		profiler.enter(frame);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void leave(final StackFrame frame) {
		profiler.leave(frame);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void terminated() {
		profiler.terminated();
		ATLLogger.info(profiler.toString());
	}

	/**
	 * Returns the embedded profiler.
	 * 
	 * @return the profiler
	 */
	public Profiler getProfiler() {
		return profiler;
	}

}
