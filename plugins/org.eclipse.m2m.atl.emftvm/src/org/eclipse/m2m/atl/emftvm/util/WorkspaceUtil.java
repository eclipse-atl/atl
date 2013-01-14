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

/**
 * Eclipse workspace utility.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public interface WorkspaceUtil {

	/**
	 * Returns the workspace location (absolute path) of <code>path</code> if it is a workspace path, otherwise <code>null</code>.
	 * 
	 * @param path
	 *            the workspace path
	 * @return the workspace location (absolute path) of <code>path</code> or <code>null</code>
	 */
	String getWorkspaceLocation(String path);

}
