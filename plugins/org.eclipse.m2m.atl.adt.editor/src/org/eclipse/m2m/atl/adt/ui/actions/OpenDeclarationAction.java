/*******************************************************************************
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditor;
import org.eclipse.m2m.atl.adt.ui.text.atl.OpenDeclarationUtils;
import org.eclipse.m2m.atl.adt.ui.text.atl.types.Feature;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;

/**
 * The ATL Open declaration action.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class OpenDeclarationAction extends Action implements IWorkbenchWindowActionDelegate, IObjectActionDelegate {

	/**
	 * The action id
	 */
	public final static String ACTION_ID = "org.eclipse.m2m.atl.adt.ui.actions.OpenDeclaration"; //$NON-NLS-1$

	/**
	 * The associated command ID
	 */
	public final static String COMMAND_ID = "atlCommands.openDeclaration"; //$NON-NLS-1$

	/* (non-Javadoc) */
	public void dispose() {
		// nothing to do

	}

	/* (non-Javadoc) */
	public void init(IWorkbenchWindow window) {
		// nothing to do
	}

	/* (non-Javadoc) */
	public void run(IAction action) {
		super.run();
		if (PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null
				&& PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage() != null
				&& PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor() instanceof AtlEditor) {
			AtlEditor textEditor = (AtlEditor)PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().getActiveEditor();
			if (textEditor.getSelectionProvider() != null) {
				ITextSelection selection = (ITextSelection)textEditor.getSelectionProvider().getSelection();
				if (selection != null) {
					try {
						Object declaration = OpenDeclarationUtils.getDeclaration(textEditor, selection
								.getOffset(), selection.getLength());
						if (declaration != null) {
							if (declaration instanceof EObject) {
								OpenDeclarationUtils.openDeclaration(null, (EObject)declaration, textEditor);
							} else if (declaration instanceof Feature) {
								OpenDeclarationUtils.openDeclaration(((Feature)declaration).getUnit(),
										((Feature)declaration).getDeclaration(), textEditor);
							}
						}
					} catch (BadLocationException e) {
						// continue
					}
				}
			}
		}
	}

	/* (non-Javadoc) */
	public void selectionChanged(IAction action, ISelection selection) {
	}

	/* (non-Javadoc) */
	public void setActivePart(IAction action, IWorkbenchPart part) {
	}

}
