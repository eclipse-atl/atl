/*
 * Created on 2 juil. 2004
 * @author idrissi
 */
package org.eclipse.m2m.atl.adt.ui.outline;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * @author idrissi
 *
 */
public class DefaultFilter extends ViewerFilter {

	/**
	 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public boolean select(Viewer viewer, Object parentElement, Object element) {		
		return true;
	}
	
}
