/*
 * Created on 13 juil. 2004
 */
package org.atl.eclipse.adt.ui.editor;

import org.atl.eclipse.adt.ui.actions.IAtlActionConstants;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.editors.text.TextEditorActionContributor;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * @author C. MONTI for ATL team
 */
public class AtlEditorActionContributor extends TextEditorActionContributor {
    
    /* (non-Javadoc)
     * @see org.eclipse.ui.IEditorActionBarContributor#setActiveEditor(org.eclipse.ui.IEditorPart)
     */
    public void setActiveEditor(IEditorPart part) {
        // TODO Auto-generated method stub
        super.setActiveEditor(part);
		ITextEditor textEditor = (part instanceof ITextEditor ? (ITextEditor) part : null);
		
		// Source menu.
		IActionBars bars= getActionBars();
//		bars.setGlobalActionHandler(JdtActionConstants.COMMENT, getAction(textEditor, "Comment"));
//		bars.setGlobalActionHandler(JdtActionConstants.UNCOMMENT, getAction(textEditor, "Uncomment"));
//		bars.setGlobalActionHandler(JdtActionConstants.TOGGLE_COMMENT, getAction(textEditor, "ToggleComment"));
//		bars.setGlobalActionHandler(JdtActionConstants.FORMAT, getAction(textEditor, "Format"));
//		bars.setGlobalActionHandler(JdtActionConstants.FORMAT_ELEMENT, getAction(textEditor, "QuickFormat"));
//		bars.setGlobalActionHandler(JdtActionConstants.ADD_BLOCK_COMMENT, getAction(textEditor, "AddBlockComment"));
//		bars.setGlobalActionHandler(JdtActionConstants.REMOVE_BLOCK_COMMENT, getAction(textEditor, "RemoveBlockComment"));
		bars.setGlobalActionHandler(IAtlActionConstants.INDENT, getAction(textEditor, "org.atl.eclipse.adt.ui.actions.indentAction"));
    }

}
