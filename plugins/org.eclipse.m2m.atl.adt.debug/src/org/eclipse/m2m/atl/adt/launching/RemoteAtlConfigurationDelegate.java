/*
 * Created on 10 juin 2004
 */
package org.eclipse.m2m.atl.adt.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.m2m.atl.adt.debug.core.AtlDebugTarget;
import org.eclipse.m2m.atl.adt.launching.sourcelookup.AtlSourceLocator;

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
