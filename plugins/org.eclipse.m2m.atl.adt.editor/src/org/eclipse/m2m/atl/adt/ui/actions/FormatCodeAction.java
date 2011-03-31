/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.actions;

import java.util.ResourceBundle;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditor;
import org.eclipse.m2m.atl.adt.ui.editor.Messages;
import org.eclipse.m2m.atl.adt.ui.editor.formatter.AtlCodeFormatter;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.TextEditorAction;

/**
 * ATL formatter action.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class FormatCodeAction extends TextEditorAction implements IEditorActionDelegate {

	private AtlEditor editor;

	public FormatCodeAction() {
		super(Messages.getResourceBundle(), "FormatCode.", null); //$NON-NLS-1$
	}

	public FormatCodeAction(ResourceBundle bundle, String prefix, ITextEditor editor) {
		super(bundle, prefix, editor);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		try {
			new AtlCodeFormatter().format(editor);
		} catch (BadLocationException e) {
			// Location problem, the model may not be up-to-date (not saved)
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		run();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.texteditor.TextEditorAction#update()
	 */
	public void update() {
		super.update();
		if (!canModifyEditor()) {
			setEnabled(false);
			return;
		}
		ITextEditor editor = getTextEditor();
		boolean isEnabled = false;
		if(editor instanceof AtlEditor) {
			this.editor = (AtlEditor)editor;
			isEnabled = true;
		}
		setEnabled(isEnabled);
	}

	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.IEditorActionDelegate#setActiveEditor(org.eclipse.jface.action.IAction, org.eclipse.ui.IEditorPart)
	 */
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		if (targetEditor instanceof AtlEditor) {
			this.editor = (AtlEditor)targetEditor;
			setEditor((AtlEditor)targetEditor);
			update();
		}
	}

}
