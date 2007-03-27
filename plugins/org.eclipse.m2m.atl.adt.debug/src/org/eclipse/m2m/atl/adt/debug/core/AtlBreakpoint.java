/*
 * Created on 6 mai 2004 
 */
package org.eclipse.m2m.atl.adt.debug.core;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.LineBreakpoint;
import org.eclipse.m2m.atl.adt.debug.AtlDebugPlugin;

/**
 * @author idrissi
 *
 */
public class AtlBreakpoint extends LineBreakpoint 
{
	public static final String ATL_BREAKPOINT_MARKER = "org.eclipse.m2m.atl.adt.debug.atlBreakpointMarker";
	
	public AtlBreakpoint() {}
	
	public AtlBreakpoint(final IResource resource, final String location, final int lineNumber, final int charStart, final int charEnd) throws DebugException {
		IWorkspaceRunnable wr= new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {				
				// create the marker
				setMarker(resource.createMarker(ATL_BREAKPOINT_MARKER));
				// add attributes
				addBreakpointAttributes(getModelIdentifier(), location, true, lineNumber, charStart, charEnd);			
				// add to breakpoint manager
				setRegistered(true);				
			}
		};
		run(wr);
	}

	
	/**
	 * Adds the standard attributes of a line breakpoint
	 * The standard attributes are:
	 * <ol>
	 * <li>IBreakpoint.ID</li>
	 * <li>IBreakpoint.ENABLED</li>
	 * <li>IMarker.LINE_NUMBER</li>
	 * <li>IMarker.CHAR_START</li>
	 * <li>IMarker.CHAR_END</li>
	 * </ol>	
	 * 
	 */	
	private void addBreakpointAttributes(String modelIdentifier, String location, boolean enabled, int lineNumber, int charStart, int charEnd) 
	{
		try {
			IMarker marker = ensureMarker();
			marker.setAttribute(IBreakpoint.ID, modelIdentifier);
			marker.setAttribute(IMarker.LOCATION, location);
			marker.setAttribute(IBreakpoint.ENABLED, new Boolean(enabled));
			marker.setAttribute(IMarker.LINE_NUMBER, new Integer(lineNumber));
			marker.setAttribute(IMarker.CHAR_START, new Integer(charStart));
			marker.setAttribute(IMarker.CHAR_END, new Integer(charEnd));
			marker.setAttribute(IBreakpoint.REGISTERED, false); // breakpoint has not been registered yet
		} catch(CoreException e) {
			System.err.println(e);
		}
	}	
	
	
	/**
	 * @see org.eclipse.debug.core.model.IBreakpoint#getModelIdentifier()
	 */
	public String getModelIdentifier() 
	{
		// return "org.eclipse.m2m.atl.adt.debug";		
		 return AtlDebugPlugin.getUniqueIdentifier();
	}
	
	/**
	 * Execute the given workspace runnable
	 */
	protected void run(IWorkspaceRunnable wr) throws DebugException {
		try {
			ResourcesPlugin.getWorkspace().run(wr, null);
		} catch (CoreException e) {
			throw new DebugException(e.getStatus());
		}
	}
}
