/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.launching;

import java.util.logging.Level;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.adt.debug.AtlDebugMessages;

/**
 * The method "launch" is launched when you click on the button "Run" or "Debug".
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class AtlLaunchConfigurationDelegate implements ILaunchConfigurationDelegate {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration,
	 *      java.lang.String, org.eclipse.debug.core.ILaunch, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch,
			IProgressMonitor monitor) throws CoreException {
		String atlVMName = configuration.getAttribute(AtlLauncherTools.ATLVM, ""); //$NON-NLS-1$
		AtlVM atlVM = AtlVM.getVM(atlVMName);

		boolean printExecutionTime = launch.getLaunchConfiguration().getAttribute(
				AtlLauncherTools.OPTION_PRINT_EXECUTION_TIME, false);

		long startTime = System.currentTimeMillis();
		try {		
		atlVM.launch(configuration, mode, launch, monitor);
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		long endTime = System.currentTimeMillis();
		if (printExecutionTime && !mode.equals(ILaunchManager.DEBUG_MODE)) {
			ATLLogger
					.info(launch
							.getLaunchConfiguration()
							.getAttribute(
									AtlLauncherTools.ATLFILENAME,
									AtlDebugMessages
											.getString(
													"AtlLaunchConfigurationDelegate.RESULT", new Object[] {new Double((endTime - startTime) / 1000.)}))); //$NON-NLS-1$
		}
	}

}
