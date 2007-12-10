/*******************************************************************************
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - ATL compatibility converter
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.perspective.compatibility;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class RevertCompatibility implements IWorkbenchWindowActionDelegate {

	private Shell shell = null;


	public void dispose() {
		// TODO Auto-generated method stub

	}


	public void init(IWorkbenchWindow window) {
		this.shell = window.getShell();
	}


	public void run(IAction action) {
		CompatibilityDialog dialog = new CompatibilityDialog(shell, false);
		dialog.open();
	}


	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub
	}

}
