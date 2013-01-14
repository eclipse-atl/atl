/*******************************************************************************
 * Copyright (c) 2012 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.m2m.atl.common.ATLLogger;

/**
 * {@link WorkspaceUtil} implementation class.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class WorkspaceUtilImpl implements WorkspaceUtil {

	/**
	 * {@inheritDoc}
	 */
	public String getWorkspaceLocation(String path) {
		if (Platform.isRunning()) {
			IPath location = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path)).getLocation();
			if (location != null) {
				return location.toString();
			} else {
				ATLLogger.info(String.format(
						"Could not find a workspace location for %s; falling back to native java.io.File path resolution", path));
			}
		} else {
			ATLLogger.info("Could not find workspace root; falling back to native java.io.File path resolution");
		}
		return null;
	}

}
