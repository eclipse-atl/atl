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
import org.eclipse.m2m.atl.emftvm.util.VMMonitor;

/**
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class LaunchAdapter implements VMMonitor {

	private final ILaunch launch;

	/**
	 * Creates a new {@link LaunchAdapter}.
	 * @param monitor the progress monitor to wrap
	 * @param launch the launch object to wrap
	 */
	public LaunchAdapter(ILaunch launch) {
		if (launch == null) {
			throw new IllegalArgumentException("launch cannot be null.");
		}
		this.launch = launch;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.emftvm.util.VMMonitor#isTerminated()
	 */
	public boolean isTerminated() {
		return launch.isTerminated();
	}

	/**
	 * Returns the Eclipse launch object.
	 * @return the launch
	 */
	public ILaunch getLaunch() {
		return launch;
	}

}
