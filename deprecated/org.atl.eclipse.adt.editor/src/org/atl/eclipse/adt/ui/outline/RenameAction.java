/*
 * Created on 20 avr. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package org.atl.eclipse.adt.ui.outline;

import org.eclipse.jface.viewers.ISelection;


/**
 * @author idrissi
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class RenameAction extends AtlAction
{	
	RenameFrame rf;
	
	public RenameAction(ISelection is)
	{
		super(is);
	}
	
	public void run()
	{
		rf = new RenameFrame(this);
	}
}
