/*
 * Created on 10 juin 2004
 */
package org.atl.eclipse.adt.launching;

import org.atl.eclipse.adt.debug.core.AtlDebugTarget;
import org.atl.eclipse.adt.launching.sourcelookup.AtlSourceLocator;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

/**
 * @author allilaire
 */
public class RemoteAtlConfigurationDelegate	implements ILaunchConfigurationDelegate {

	AtlDebugTarget mTarget;
	ILaunchConfiguration configuration;
	ILaunch launch;
	
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		
		this.configuration = configuration;
		this.launch = launch;
		
		if (launch.getLaunchMode().equals(ILaunchManager.DEBUG_MODE)) {
			launch.setSourceLocator(new AtlSourceLocator());
			
			mTarget = new AtlDebugTarget(launch);
			mTarget.start();
			launch.addDebugTarget(mTarget);
		}			
		
	}
}
