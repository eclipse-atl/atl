/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.debug.ui;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.m2m.atl.adt.debug.core.AtlDebugTarget;
import org.eclipse.m2m.atl.adt.debug.core.AtlStackFrame;
import org.eclipse.m2m.atl.adt.debug.core.AtlThread;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * DisassemblyModeAction is the action runned by the popup menu Disassembly Mode for IElement.
 * 
 * @see extension point="org.eclipse.ui.popupMenus" in plugin.xml This action allows to switch between normal
 *      and disassembly mode.
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class DisassemblyModeAction implements IObjectActionDelegate {

	private ISelection selectionInterface;

	/**
	 * Constructor for DisassemblyModeAction.
	 */
	public DisassemblyModeAction() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction,
	 *      org.eclipse.ui.IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		boolean checked = action.isChecked();

		Object elem = ((IStructuredSelection)selectionInterface).getFirstElement();
		AtlDebugTarget adt = null;
		if (elem instanceof AtlThread) {
			adt = (AtlDebugTarget)((AtlThread)elem).getDebugTarget();
		} else if (elem instanceof AtlStackFrame) {
			adt = (AtlDebugTarget)((AtlStackFrame)elem).getDebugTarget();
		} else if (elem instanceof AtlDebugTarget) {
			adt = (AtlDebugTarget)elem;
		}

		if (adt != null) {
			adt.setDisassemblyMode(checked);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selectionInterface = selection;

		Object elem = ((IStructuredSelection)selection).getFirstElement();
		AtlDebugTarget adt = null;

		if (elem instanceof AtlThread) {
			adt = (AtlDebugTarget)((AtlThread)elem).getDebugTarget();
		} else if (elem instanceof AtlStackFrame) {
			adt = (AtlDebugTarget)((AtlStackFrame)elem).getDebugTarget();
		} else if (elem instanceof AtlDebugTarget) {
			adt = (AtlDebugTarget)elem;
		}

		if (adt != null) {
			action.setChecked(adt.isDisassemblyMode());
		}
	}

}
