/*
 * Created on 21 avr. 2004
 */
package org.atl.eclipse.adt.ui.outline;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * @author idrissi
 */
public class HideHelperFilter extends ViewerFilter 
{
	
	/**
	 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public boolean select(Viewer viewer, Object parentElement, Object element) 
	{
		/*return (parentElement instanceof Root || 
				(AtlEMFConstants.clModule.isInstance(parentElement) && !(AtlEMFConstants.clHelper.isInstance(element))));*/
		return !(AtlEMFConstants.clHelper.isInstance(element));
	}
}
