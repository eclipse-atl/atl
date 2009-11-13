/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.editor;

import org.eclipse.m2m.atl.adt.ui.actions.IAtlActionConstants;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.editors.text.TextEditorActionContributor;
import org.eclipse.ui.texteditor.ITextEditor;

public class AtlEditorActionContributor extends TextEditorActionContributor {

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.editors.text.TextEditorActionContributor#setActiveEditor(org.eclipse.ui.IEditorPart)
	 */
	public void setActiveEditor(IEditorPart part) {
		super.setActiveEditor(part);
		ITextEditor textEditor = part instanceof ITextEditor ? (ITextEditor)part : null;

		// Source menu.
		IActionBars bars = getActionBars();
		bars.setGlobalActionHandler(IAtlActionConstants.INDENT, getAction(textEditor,
				"org.eclipse.m2m.atl.adt.ui.actions.indentAction")); //$NON-NLS-1$
		bars.setGlobalActionHandler(IAtlActionConstants.TOGGLE_COMMENT, getAction(textEditor, "ToggleComment")); //$NON-NLS-1$
		bars.setGlobalActionHandler(IAtlActionConstants.GOTO_MATCHING_BRACKET, getAction(textEditor, "GoToMatchingBracket")); //$NON-NLS-1$
	}

}
