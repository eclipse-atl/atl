/*
 * Created on 26 avr. 2004
 *
 */
package org.eclipse.m2m.atl.adt.launching;


import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

/**
 * The method "launch" is launched when you click on the button "Run" or "Debug"
 * 
 * @author Freddy Allilaire
 *
 */
public class AtlLaunchConfigurationDelegate implements ILaunchConfigurationDelegate {

	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		String atlVMName = configuration.getAttribute(AtlLauncherTools.ATLVM, "");
		AtlVM atlVM = AtlVM.getVM(atlVMName);
		
		boolean printExecutionTime = launch.getLaunchConfiguration().getAttribute(AtlLauncherTools.PRINT_EXECUTION_TIME, false);

		long startTime = System.currentTimeMillis();
		atlVM.launch(configuration, mode, launch, monitor);
		long endTime = System.currentTimeMillis();
		if(printExecutionTime)
			System.out.println(launch.getLaunchConfiguration().getAttribute(AtlLauncherTools.ATLFILENAME, "Transformation") + " executed in " + ((endTime - startTime) / 1000.) + " s (including model loading and saving).");
	}

}

