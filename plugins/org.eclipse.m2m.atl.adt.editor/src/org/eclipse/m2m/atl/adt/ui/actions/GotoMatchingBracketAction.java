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

import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.Assert;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditor;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditorMessages;


public class GotoMatchingBracketAction extends Action {

	public final static String ID = "org.eclipse.m2m.atl.adt.ui.actions.GotoMatchingBracket";
	private final AtlEditor editor;
	
	public GotoMatchingBracketAction(AtlEditor editor) {
		super(AtlEditorMessages.getString(ID + ".label"));
		Assert.isNotNull(editor);
		this.editor = editor;
		setEnabled(true);
		// TODO WorkbenchHelp
		//WorkbenchHelp.setHelp(this, IJavaHelpContextIds.GOTO_MATCHING_BRACKET_ACTION);
	}
	
	public void run() {
		editor.gotoMatchingBracket();
	}
}
