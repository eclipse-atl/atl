package org.atl.eclipse.adt.ui.actions;

import org.atl.eclipse.adt.ui.editor.AtlEditor;
import org.atl.eclipse.adt.ui.editor.AtlEditorMessages;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.Assert;


public class GotoMatchingBracketAction extends Action {

	public final static String ID = "org.atl.eclipse.adt.ui.actions.GotoMatchingBracket";
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
