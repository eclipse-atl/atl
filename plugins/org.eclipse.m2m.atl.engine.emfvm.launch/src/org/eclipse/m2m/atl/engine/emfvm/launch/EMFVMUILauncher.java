/*******************************************************************************
 * Copyright (c) 2008, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Dennis Wagelaar (Vrije Universiteit Brussel)
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm.launch;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.m2m.atl.common.ATLLaunchConstants;
import org.eclipse.m2m.atl.engine.emfvm.VMException;
import org.eclipse.m2m.atl.engine.emfvm.launch.debug.NetworkDebugger;

/**
 * The EMFVM UI extension of the {@link EMFVMLauncher}, which supports debug.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class EMFVMUILauncher extends EMFVMLauncher {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher#launch(java.lang.String,
	 *      org.eclipse.core.runtime.IProgressMonitor, java.util.Map, java.lang.Object[])
	 */
	@Override
	public Object launch(final String mode, final IProgressMonitor monitor,
			final Map<String, Object> options, final Object... modules) {
		try {
			if (mode.equals(ILaunchManager.DEBUG_MODE)) {
				return internalLaunch(new ITool[] {new NetworkDebugger(
						getPort((ILaunch)options.get("launch")), true),}, monitor, options, modules); //$NON-NLS-1$
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
		return new String[]{RUN_MODE, DEBUG_MODE,};
	}

}
