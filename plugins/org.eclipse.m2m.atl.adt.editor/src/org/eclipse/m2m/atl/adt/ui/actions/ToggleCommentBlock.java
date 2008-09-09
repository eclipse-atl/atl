/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

public class ToggleCommentBlock implements IEditorActionDelegate {

	/**
	 * The constructor.
	 */
	public ToggleCommentBlock() {
	}

	/*
	 * The action has been activated. The argument of the method represents the 'real' action sitting in the
	 * workbench UI.
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();

		IEditorPart part = page.getActiveEditor();
		if (!(part instanceof AbstractTextEditor))
			return;
		ITextEditor editor = (ITextEditor)part;
		ISelectionProvider sp = editor.getSelectionProvider();
		ISelection selection = sp.getSelection();
		ITextSelection text = (ITextSelection)selection;

		IDocumentProvider dp = editor.getDocumentProvider();
		IDocument doc = dp.getDocument(editor.getEditorInput());

		if (text.getText().startsWith("--"))//$NON-NLS-1$
			// Uncomment
			shiftLeft(text.getStartLine(), text.getEndLine(), new String[] {"--"}, false, doc); //$NON-NLS-1$
		else
			// Comment
			shiftRight(text.getStartLine(), text.getEndLine(), "--", doc); //$NON-NLS-1$
	}

	/**
	 * Shifts the specified lines to the right or to the left. On shifting to the right it insert
	 * <code>prefixes[0]</code> at the beginning of each line. On shifting to the left it tests whether each
	 * of the specified lines starts with one of the specified prefixes and if so, removes the prefix.
	 * 
	 * @param startLine
	 *            the first line to shift
	 * @param endLine
	 *            the last line to shift
	 * @param prefixes
	 *            the prefixes to be used for shifting
	 * @param ignoreWhitespace
	 *            <code>true</code> if whitespace should be ignored, <code>false</code> otherwise
	 * @since 2.0
	 */
	private void shiftLeft(int startLine, int endLine, String[] prefixes, boolean ignoreWhitespace,
			IDocument d) {
		try {
			IRegion[] occurrences = new IRegion[endLine - startLine + 1];
			// find all the first occurrences of prefix in the given lines
			for (int i = 0; i < occurrences.length; i++) {
				IRegion line = d.getLineInformation(startLine + i);
				String text = d.get(line.getOffset(), line.getLength());
				int index = -1;
				int[] found = TextUtilities.indexOf(prefixes, text, 0);
				if (found[0] != -1) {
					if (ignoreWhitespace) {
						String s = d.get(line.getOffset(), found[0]);
						s = s.trim();
						if (s.length() == 0)
							index = line.getOffset() + found[0];
					} else if (found[0] == 0)
						index = line.getOffset();
				}
				if (index > -1) {
					// remember where prefix is in line, so that it can be removed
					int length = prefixes[found[1]].length();
					if (length == 0 && !ignoreWhitespace && line.getLength() > 0) {
						// found a non-empty line which cannot be shifted
						return;
					} else
						occurrences[i] = new Region(index, length);
				} else {
					// found a line which cannot be shifted
					return;
				}
			}
			// OK - change the document
			int decrement = 0;
			for (int i = 0; i < occurrences.length; i++) {
				IRegion r = occurrences[i];
				d.replace(r.getOffset() - decrement, r.getLength(), ""); //$NON-NLS-1$
				decrement += r.getLength();
			}
		} catch (BadLocationException x) {
		}
	}

	/**
	 * Shifts the specified lines to the right inserting the given prefix at the beginning of each line
	 * 
	 * @param prefix
	 *            the prefix to be inserted
	 * @param startLine
	 *            the first line to shift
	 * @param endLine
	 *            the last line to shift
	 * @since 2.0
	 */
	private void shiftRight(int startLine, int endLine, String prefix, IDocument d) {
		try {
			while (startLine <= endLine) {
				d.replace(d.getLineOffset(startLine++), 0, prefix);
			}
		} catch (BadLocationException x) {
		}
	}

	/**
	 * Selection in the workbench has been changed. We can change the state of the 'real' action here if we
	 * want, but this can only happen after the delegate has been created.
	 * 
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * We can use this method to dispose of any system resources we previously allocated.
	 * 
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}

	/**
	 * We will cache window object in order to be able to provide parent shell for the message dialog.
	 * 
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
	}

	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		// TODO Auto-generated method stub

	}
}
