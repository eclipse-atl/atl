/*
 * Created on 22 juin 2004
 * @author idrissi
 */
package org.eclipse.m2m.atl.adt.startup;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.m2m.atl.engine.vm.ATLVMPlugin;

/**
 * @author idrissi
 *
 */
public class ResourceChangeListener implements IResourceChangeListener {
	
	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);

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
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
		}
	}	
}
