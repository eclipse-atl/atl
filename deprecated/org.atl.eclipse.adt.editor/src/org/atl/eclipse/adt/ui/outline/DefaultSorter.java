/*
 * Created on 3 juin 2004
 */
package org.atl.eclipse.adt.ui.outline;

import org.atl.eclipse.engine.AtlNbCharFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @author idrissi
 */
public class DefaultSorter extends ViewerSorter 
{
	/** Used to compute index of start character and end character from a location String
	 * the location String is structured as follows : <line_start>:<column_start>-<lined_End>:<column_end>
	 * @see AtlNbCharFile
	 */
	private AtlNbCharFile help;
	
	
	/**
	 * @see org.eclipse.jface.viewers.ViewerSorter#category(java.lang.Object)
	 */
	public int category(Object element) 
	{
		if (element instanceof Root)
			return super.category(element);
			
		EObject eo = (EObject)element;
		String location = (String)eo.eGet(AtlEMFConstants.sfLocation);
		if (location == null)
			return super.category(element);
		
		int pos[] = help.getIndexChar(location);			
		return pos[0];
	}
		
	public void setHelp(AtlNbCharFile help) 
	{
		this.help = help;
	}
}
