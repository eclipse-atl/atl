/*
 * Created on 22 juil. 2004
 * @author idrissi
 */
package org.atl.eclipse.adt.ui.viewsupport;

import org.eclipse.core.resources.IResource;

/**
 * @author idrissi
 * Can be added to a ProblemMarkerManager to get notified about problem
 * marker changes. Used to update error ticks.
 */
public interface IProblemChangedListener {
	
	/**
	 * Called when problems changed.
	 * @param changedElements  A set with elements of type <code>IResource</code> that
	 * describe the resources that had a problem change.
	 */
	void problemsChanged(IResource[] changedResources, boolean isMarkerChange);
	
}
