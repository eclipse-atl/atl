/*
 * Created on 22 juin 2004
 * @author idrissi
 */
package org.atl.eclipse.adt.startup;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;

/**
 * @author idrissi
 *
 */
public class ResourceChangeListener implements IResourceChangeListener {
	
	/** 
	 * The visitor used to visit an Atl project that has been changed and take some actions. 
	 * For instance, if an atl file has been remove, it will remove its associated asm file if it exists. 
	 */
	private IResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
	
	/**
	 * @see org.eclipse.core.resources.IResourceChangeListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)
	 */
	public void resourceChanged(IResourceChangeEvent event) {
//		IResource res = event.getResource();		
		try {
			event.getDelta().accept(visitor);
		} catch (CoreException e) {		
			e.printStackTrace();
		}
	}	
}
