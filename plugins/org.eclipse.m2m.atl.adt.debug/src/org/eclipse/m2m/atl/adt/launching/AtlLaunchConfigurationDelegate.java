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


import java.util.logging.Logger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.m2m.atl.engine.vm.ATLVMPlugin;

/**
 * The method "launch" is launched when you click on the button "Run" or "Debug"
 * 
 * @author Freddy Allilaire
 *
 */
public class AtlLaunchConfigurationDelegate implements ILaunchConfigurationDelegate {

	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);

	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		String atlVMName = configuration.getAttribute(AtlLauncherTools.ATLVM, "");
		AtlVM atlVM = AtlVM.getVM(atlVMName);
		
		boolean printExecutionTime = launch.getLaunchConfiguration().getAttribute(AtlLauncherTools.OPTION_PRINT_EXECUTION_TIME, false);

		long startTime = System.currentTimeMillis();
		atlVM.launch(configuration, mode, launch, monitor);
		long endTime = System.currentTimeMillis();
		if(printExecutionTime && !mode.equals(ILaunchManager.DEBUG_MODE)) {
			logger.info(launch.getLaunchConfiguration().getAttribute(AtlLauncherTools.ATLFILENAME, "Transformation") + " executed in " + ((endTime - startTime) / 1000.) + " s (including model loading and saving).");
//			System.out.println(launch.getLaunchConfiguration().getAttribute(AtlLauncherTools.ATLFILENAME, "Transformation") + " executed in " + ((endTime - startTime) / 1000.) + " s (including model loading and saving).");
		}
	}

}

