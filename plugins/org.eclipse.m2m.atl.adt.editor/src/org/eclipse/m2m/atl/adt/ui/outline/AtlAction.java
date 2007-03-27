/*
 * Created on 20 avr. 2004
 */
package org.eclipse.m2m.atl.adt.ui.outline;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * @author idrissi
 * 
 * This class should be extended 
 */
public abstract class AtlAction
{
	protected ISelection theSelection;
	
	public AtlAction(ISelection its)
	{
		this.theSelection = its;
	}
	
	abstract public void run(); 
		
	/**
	 * returns the element to rename
	 * @return the element to rename
	 */
	public Object getElement()
	{
		if (theSelection instanceof IStructuredSelection)
			return (Object)((IStructuredSelection)theSelection).getFirstElement();
		// else if (theSelection instanceof ITextSelection)
		return null;
	}
}
