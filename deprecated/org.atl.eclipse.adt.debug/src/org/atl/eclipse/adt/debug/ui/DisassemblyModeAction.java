package org.atl.eclipse.adt.debug.ui;

import org.atl.eclipse.adt.debug.core.AtlDebugTarget;
import org.atl.eclipse.adt.debug.core.AtlStackFrame;
import org.atl.eclipse.adt.debug.core.AtlThread;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * 
 * @author allilaire
 *
 * DisassemblyModeAction is the action runned by the popup menu Disassembly Mode for IElement
 * @see extension point="org.eclipse.ui.popupMenus" in plugin.xml
 * This action allows to switch between normal and disassembly mode.
 */
public class DisassemblyModeAction implements IObjectActionDelegate {

	/**
	 * Constructor for DisassemblyModeAction
	 */
	public DisassemblyModeAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	/**
	 * Main method of the action, when the action is selected => "run" is launched
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		boolean checked = action.isChecked();
		
		Object elem = ((IStructuredSelection)selection).getFirstElement();
		AtlDebugTarget adt = null;
		if(elem instanceof AtlThread) {
			adt = (AtlDebugTarget)((AtlThread)elem).getDebugTarget();
		} else if(elem instanceof AtlStackFrame) {
				adt = (AtlDebugTarget)((AtlStackFrame)elem).getDebugTarget();
		} else if(elem instanceof AtlDebugTarget) {
			adt = (AtlDebugTarget)elem;
		}

		if(adt != null) {
			adt.setDisassemblyMode(checked);
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;

		Object elem = ((IStructuredSelection)selection).getFirstElement();
		AtlDebugTarget adt = null;
		
		if(elem instanceof AtlThread) {
			adt = (AtlDebugTarget)((AtlThread)elem).getDebugTarget();
		} else if(elem instanceof AtlStackFrame) {
				adt = (AtlDebugTarget)((AtlStackFrame)elem).getDebugTarget();
		} else if(elem instanceof AtlDebugTarget) {
			adt = (AtlDebugTarget)elem;
		}
		
		if(adt != null) {
			action.setChecked(adt.isDisassemblyMode());
		}
	}

	private ISelection selection;
}
