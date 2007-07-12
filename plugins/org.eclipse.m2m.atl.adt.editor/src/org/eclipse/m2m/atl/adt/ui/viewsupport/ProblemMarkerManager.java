/*
 * Created on 22 juil. 2004
 * @author idrissi
 */
package org.eclipse.m2m.atl.adt.ui.viewsupport;

import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.m2m.atl.engine.vm.ATLVMPlugin;

/**
 * @author idrissi
 *
 * Listens to resource deltas and filters for marker changes of type IMarker.PROBLEM
 * Viewers showing error ticks should register as listener to
 * this type.
 */
public class ProblemMarkerManager implements IResourceChangeListener {

	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);

	/**
	 * Visitors used to look if the element change delta contains a marker change.
	 */
	private static class ProjectErrorVisitor implements IResourceDeltaVisitor {

		private HashSet changedElements; 
		
		public ProjectErrorVisitor(HashSet changedElements) {
			this.changedElements = changedElements;
		}
			
		public boolean visit(IResourceDelta delta) throws CoreException {
			IResource res = delta.getResource();
			if (res instanceof IProject && delta.getKind() == IResourceDelta.CHANGED) {
				IProject project = (IProject) res;
				if (!project.isAccessible()) {
					// only track open projects
					return false;
				}
			}
			checkInvalidate(delta, res);
			return true;
		}
		
		private void checkInvalidate(IResourceDelta delta, IResource resource) {
			int kind = delta.getKind();
			if (kind == IResourceDelta.REMOVED || kind == IResourceDelta.ADDED || (kind == IResourceDelta.CHANGED && isErrorDelta(delta))) {
				// invalidate the resource and all parents
				while (resource.getType() != IResource.ROOT && changedElements.add(resource)) {
					resource = resource.getParent();
				}
			} 
		}	
		
		private boolean isErrorDelta(IResourceDelta delta) {	
			if ((delta.getFlags() & IResourceDelta.MARKERS) != 0) {
				IMarkerDelta[] markerDeltas = delta.getMarkerDeltas();
				for (int i= 0; i < markerDeltas.length; i++) {
					if (markerDeltas[i].isSubtypeOf(IMarker.PROBLEM)) {
						int kind = markerDeltas[i].getKind();
						if (kind == IResourceDelta.ADDED || kind == IResourceDelta.REMOVED)
							return true;
						int severity= markerDeltas[i].getAttribute(IMarker.SEVERITY, -1);
						int newSeverity= markerDeltas[i].getMarker().getAttribute(IMarker.SEVERITY, -1);
						if (newSeverity != severity)
							return true; 
					}
				}
			}
			return false;
		}
	}

	private ListenerList fListeners;
	
	
	public ProblemMarkerManager() {
		fListeners = new ListenerList();
	}

	/*
	 * @see IResourceChangeListener#resourceChanged
	 */	
	public void resourceChanged(IResourceChangeEvent event) {
		HashSet changedElements = new HashSet();
		
		try {
			IResourceDelta delta = event.getDelta();
			if (delta != null)
				delta.accept(new ProjectErrorVisitor(changedElements));
		} catch (CoreException e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
		}

		if (!changedElements.isEmpty()) {
			IResource[] changes = (IResource[]) changedElements.toArray(new IResource[changedElements.size()]);
			fireChanges(changes, true);
		}
	}			
	
	/**
	 * Adds a listener for problem marker changes.
	 */
	public void addListener(IProblemChangedListener listener) {
		if (fListeners.isEmpty()) { 
			ResourcesPlugin.getWorkspace().addResourceChangeListener(this);			
		}
		fListeners.add(listener);
	}

	/**
	 * Removes a <code>IProblemChangedListener</code>.
	 */	
	public void removeListener(IProblemChangedListener listener) {
		fListeners.remove(listener);
		if (fListeners.isEmpty()) {
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);			
		}
	}
	
	private void fireChanges(final IResource[] changes, final boolean isMarkerChange) {		
		Thread fireChange = new Thread() {
			public void run() {		
				Object[] listeners = fListeners.getListeners();
				for (int i= 0; i < listeners.length; i++) {
					IProblemChangedListener curr = (IProblemChangedListener) listeners[i];
					curr.problemsChanged(changes, isMarkerChange);
				}	
			}
		};
		fireChange.start();
	}
	
}
