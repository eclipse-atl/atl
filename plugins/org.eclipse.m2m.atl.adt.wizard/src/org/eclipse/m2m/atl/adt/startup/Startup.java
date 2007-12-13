/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tarik Idrissi (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.startup;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.IStartup;

/**
 * @author Tarik Idrissi
 *
 */
public class Startup implements IStartup {
	
	/**
	 * @see org.eclipse.ui.IStartup#earlyStartup()
	 */
	public void earlyStartup() {
		// listen for change in the workspace. It is then possible to take action such as deleting an asm file when its associated atl file is deleted.
		ResourcesPlugin.getWorkspace().addResourceChangeListener(new ResourceChangeListener(), IResourceChangeEvent.POST_CHANGE);
	}
}
