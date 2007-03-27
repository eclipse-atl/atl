/*
 * Created on 24 juin 2004
 * @author idrissi
 */
package org.eclipse.m2m.atl.adt.startup;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.IStartup;

/**
 * @author idrissi
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
