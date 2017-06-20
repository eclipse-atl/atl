/*******************************************************************************
 * Copyright (c) 2017 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dennis Wagelaar - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.launcher.compat;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.m2m.atl.common.ATLLaunchConstants;
import org.eclipse.m2m.atl.emftvm.launcher.debug.NetworkDebugger;
import org.eclipse.m2m.atl.emftvm.util.VMException;

/**
 * The EMFTVM UI extension of the {@link EMFTVMLauncher}, which supports debug.
 * 
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class EMFTVMUILauncher extends EMFTVMLauncher {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.launcher.compat.EMFTVMLauncher#launch(java.lang.String,
	 *      org.eclipse.core.runtime.IProgressMonitor, java.util.Map,
	 *      java.lang.Object[])
	 */
	@Override
	public Object launch(final String mode, final IProgressMonitor monitor, final Map<String, Object> options,
			final Object... modules) {
		try {
			if (mode.equals(ILaunchManager.DEBUG_MODE)) {
				final ILaunch launch = (ILaunch) options.get("launch");
				return internalLaunch(new NetworkDebugger(launch, getPort(launch), true), monitor, options, modules); // $NON-NLS-1$
			} else {
				return internalLaunch(null, monitor, options, modules);
			}
		} catch (CoreException e) {
			throw new VMException(null, e.getLocalizedMessage(), e);
		}
	}

	private int getPort(ILaunch launch) throws CoreException {
		String portOption = ""; //$NON-NLS-1$
		if (launch != null) {
			portOption = launch.getLaunchConfiguration().getAttribute(ATLLaunchConstants.PORT,
					Integer.valueOf(ATLLaunchConstants.DEFAULT_PORT).toString());
		}
		if (portOption.equals("")) { //$NON-NLS-1$
			portOption = Integer.valueOf(ATLLaunchConstants.DEFAULT_PORT).toString();
		}
		return new Integer(portOption).intValue();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#getModes()
	 */
	@Override
	public String[] getModes() {
		return new String[] { RUN_MODE, DEBUG_MODE };
	}

}
