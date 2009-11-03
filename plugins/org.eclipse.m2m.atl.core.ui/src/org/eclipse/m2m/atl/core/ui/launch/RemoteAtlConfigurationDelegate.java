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
package org.eclipse.m2m.atl.core.ui.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.m2m.atl.debug.core.AtlDebugTarget;
import org.eclipse.m2m.atl.debug.core.AtlSourceLocator;

/**
 * This configuration delegate connection to remote debuggees.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class RemoteAtlConfigurationDelegate implements ILaunchConfigurationDelegate {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration,
	 *      java.lang.String, org.eclipse.debug.core.ILaunch, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch,
			IProgressMonitor monitor) throws CoreException {
		AtlDebugTarget mTarget;
		if (launch.getLaunchMode().equals(ILaunchManager.DEBUG_MODE)) {
			launch.setSourceLocator(new AtlSourceLocator());

			mTarget = new AtlDebugTarget(launch);
			mTarget.start();
			launch.addDebugTarget(mTarget);
		}

	}
}
