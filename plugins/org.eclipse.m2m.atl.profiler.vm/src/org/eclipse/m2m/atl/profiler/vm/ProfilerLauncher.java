/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.profiler.vm;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.common.ATLLaunchConstants;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.ui.vm.RegularVMLauncher;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import org.eclipse.m2m.atl.engine.vm.AtlSuperimposeModule.AtlSuperimposeModuleException;
import org.eclipse.m2m.atl.profiler.core.Messages;

/**
 * RegularVM Profiler launcher.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ProfilerLauncher extends RegularVMLauncher {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.ui.vm.RegularVMLauncher#launch(java.lang.String,
	 *      org.eclipse.core.runtime.IProgressMonitor, java.util.Map, java.lang.Object[])
	 */
	@Override
	public Object launch(String mode, IProgressMonitor monitor, Map<String, Object> options,
			Object... modules) {
		if (options.get(ATLLaunchConstants.OPTION_ATL_FILE_PATH) != null) {
			String fileName = options.get(ATLLaunchConstants.OPTION_ATL_FILE_PATH).toString();
			IFile currentAtlFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
					Path.fromOSString(fileName));
			try {
				EObject atlModel = AtlParser.getDefault().parse(currentAtlFile.getContents());
				if (atlModel == null) {
					throw new RuntimeException(Messages.getString("ProfilerLauncher_INVALID_ATL_FILE")); //$NON-NLS-1$
				} else {
					return internalLaunch(new ProfilingDebugger(atlModel), options, modules);
				}
			} catch (ATLCoreException e) {
				throw new RuntimeException(Messages.getString("ProfilerLauncher_INVALID_ATL_FILE")); //$NON-NLS-1$
			} catch (CoreException e) {
				throw new RuntimeException(Messages.getString("ProfilerLauncher_INVALID_ATL_FILE")); //$NON-NLS-1$
			} catch (AtlSuperimposeModuleException e) {
				throw new RuntimeException(Messages.getString("ProfilerLauncher_INVALID_ATL_FILE")); //$NON-NLS-1$
			}
		} else {
			throw new RuntimeException(Messages.getString("ProfilerLauncher_INVALID_ATL_FILE")); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.ui.vm.RegularVMLauncher#getName()
	 */
	@Override
	public String getName() {
		return super.getName() + " Profiler"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#getModes()
	 */
	@Override
	public String[] getModes() {
		return new String[] {RUN_MODE,};
	}
}
