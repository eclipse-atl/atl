/*
 * Created on 2 juil. 2004
 * @author idrissi
 */
package org.atl.eclipse.adt.wizard;

import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * @author idrissi
 *
 */
public class Utils {

	/**
	 * Replaces the current perspective with the new one.
	 * @param the perspective descriptor of the new perspective
	 */
	private static void replaceCurrentPerspective(IPerspectiveDescriptor persp) {

		//Get the active page.
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window == null) {
			return;
		}
		
		IWorkbenchPage page = window.getActivePage();
		if (page == null) {
			return;
		}
		
		// Set the perspective.
		page.setPerspective(persp);
	}
		
}
