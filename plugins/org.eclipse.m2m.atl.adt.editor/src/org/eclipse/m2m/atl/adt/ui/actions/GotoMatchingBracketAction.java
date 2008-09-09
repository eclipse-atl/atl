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
package org.eclipse.m2m.atl.adt.ui.actions;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.Action;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditor;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditorMessages;

public class GotoMatchingBracketAction extends Action {

	public static final String ID = "org.eclipse.m2m.atl.adt.ui.actions.GotoMatchingBracket"; //$NON-NLS-1$

	private final AtlEditor editor;

	public GotoMatchingBracketAction(AtlEditor editor) {
		super(AtlEditorMessages.getString(ID + ".label")); //$NON-NLS-1$
		Assert.isNotNull(editor);
		this.editor = editor;
		setEnabled(true);
		// TODO WorkbenchHelp
		// WorkbenchHelp.setHelp(this, IJavaHelpContextIds.GOTO_MATCHING_BRACKET_ACTION);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		editor.gotoMatchingBracket();
	}
}
