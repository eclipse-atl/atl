package org.atl.eclipse.adt.debug.ui;

import org.atl.eclipse.adt.debug.core.AtlDebugTarget;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
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
		IDebugTarget dt[] = DebugPlugin.getDefault().getLaunchManager().getDebugTargets();
		for (int i=0; i < dt.length; i++) {
			if (dt[i] instanceof AtlDebugTarget) {
				AtlDebugTarget adt = (AtlDebugTarget)dt[i];
				adt.setDisassemblyMode(!adt.isDisassemblyMode());
			}
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

}
