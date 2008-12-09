/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tarik Idrissi (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.perspective;

import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;

/**
 * The ATL perspective class.
 * 
 * @author <a href="mailto:tarik.idrissi@laposte.net">Tarik Idrissi</a>
 */
public class AtlPerspective implements IPerspectiveFactory {

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
	 */
	public void createInitialLayout(IPageLayout layout) {
		defineActions(layout);
		defineLayout(layout);
	}

	/**
	 * Defines the ATL perspective actions.
	 * 
	 * @param layout
	 *            the given layout
	 */
	public void defineActions(IPageLayout layout) {
		// Add "new wizards".
		layout.addNewWizardShortcut("atlProjectWizard"); //$NON-NLS-1$
		layout.addNewWizardShortcut("atlFileWizard"); //$NON-NLS-1$

		// Add "show views".
		layout.addShowViewShortcut(IPageLayout.ID_RES_NAV);

		layout.addPerspectiveShortcut("org.eclipse.m2m.atl.adt.atlPerspective"); //$NON-NLS-1$
	}

	/**
	 * Defines the ATL perspective layout.
	 * 
	 * @param layout
	 *            the given layout
	 */
	public void defineLayout(IPageLayout layout) {
		// editors are placed for free.
		String editorArea = layout.getEditorArea();

		// place navigator to the left (of editor area)
		IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT, (float)0.25, editorArea); //$NON-NLS-1$
		left.addView(IPageLayout.ID_RES_NAV);

		// problem view at the bottom (of editor area)
		IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, (float)0.75, editorArea); //$NON-NLS-1$
		bottom.addView(IPageLayout.ID_PROBLEM_VIEW);
		bottom.addView(IPageLayout.ID_PROP_SHEET);
		bottom.addView("org.eclipse.pde.runtime.LogView"); //$NON-NLS-1$
		bottom.addView(IConsoleConstants.ID_CONSOLE_VIEW);

		// outline view to right (of editor area)
		IFolderLayout right = layout.createFolder("right", IPageLayout.RIGHT, (float)0.75, editorArea); //$NON-NLS-1$
		right.addView(IPageLayout.ID_OUTLINE);

		// add shortcuts
		layout.addNewWizardShortcut("atlProjectWizard"); //$NON-NLS-1$
		layout.addNewWizardShortcut("atlFileWizard"); //$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder"); //$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.file"); //$NON-NLS-1$
		layout.addActionSet(IDebugUIConstants.LAUNCH_ACTION_SET);

		layout.addShowViewShortcut(IPageLayout.ID_RES_NAV);

		layout.addPerspectiveShortcut("org.eclipse.m2m.atl.adt.atlPerspective"); //$NON-NLS-1$
	}

}
