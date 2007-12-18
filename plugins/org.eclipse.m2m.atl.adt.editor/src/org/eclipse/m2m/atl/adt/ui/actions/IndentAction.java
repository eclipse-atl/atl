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

import java.util.ResourceBundle;

import org.eclipse.jface.text.Assert;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.IRewriteTarget;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.m2m.atl.adt.ui.AtlPreferenceConstants;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditor;
import org.eclipse.m2m.atl.adt.ui.text.AtlHeuristicScanner;
import org.eclipse.m2m.atl.adt.ui.text.AtlIndenter;
import org.eclipse.m2m.atl.adt.ui.text.IAtlPartitions;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorExtension3;
import org.eclipse.ui.texteditor.TextEditorAction;

/**
 * Indents a line or range of lines in a Java document to its correct position. No complete
 * AST must be present, the indentation is computed using heuristics. The algorith used is fast for
 * single lines, but does not store any information and therefore not so efficient for large line
 * ranges.
 */
public class IndentAction extends TextEditorAction {
	
	/** The caret offset after an indent operation. */
	private int fCaretOffset;
	
	/** 
	 * Whether this is the action invoked by TAB. When <code>true</code>, indentation behaves 
	 * differently to accomodate normal TAB operation.
	 */
	private final boolean fIsTabAction;
	
	/**
	 * Creates a new instance.
	 * 
	 * @param bundle the resource bundle
	 * @param prefix the prefix to use for keys in <code>bundle</code>
	 * @param editor the text editor
	 * @param isTabAction whether the action should insert tabs if over the indentation
	 */
	public IndentAction(ResourceBundle bundle, String prefix, ITextEditor editor, boolean isTabAction) {
		super(bundle, prefix, editor);
		fIsTabAction= isTabAction;
	}
	
	/**
	 * Returns the document currently displayed in the editor, or <code>null</code> if none can be 
	 * obtained.
	 * 
	 * @return the current document or <code>null</code>
	 */
	private IDocument getDocument() {
		
		ITextEditor editor= getTextEditor();
		if (editor != null) {
			
			IDocumentProvider provider= editor.getDocumentProvider();
			IEditorInput input= editor.getEditorInput();
			if (provider != null && input != null)
				return provider.getDocument(input);
			
		}
		return null;
	}
	
	/**
	 * Returns the selection on the editor or an invalid selection if none can be obtained. Returns
	 * never <code>null</code>.
	 * 
	 * @return the current selection, never <code>null</code>
	 */
	private ITextSelection getSelection() {
		ISelectionProvider provider= getSelectionProvider();
		if (provider != null) {
			
			ISelection selection= provider.getSelection();
			if (selection instanceof ITextSelection)
				return (ITextSelection) selection;
		}
		
		// null object
		return TextSelection.emptySelection();
	}
	
	/**
	 * Returns the editor's selection provider.
	 * 
	 * @return the editor's selection provider or <code>null</code>
	 */
	private ISelectionProvider getSelectionProvider() {
		ITextEditor editor= getTextEditor();
		if (editor != null) {
			return editor.getSelectionProvider();
		}
		return null;
	}
	
	/**
	 * Returns a tab equivalent, either as a tab character or as spaces, depending on the editor and
	 * formatter preferences.
	 * 
	 * @return a string representing one tab in the editor, never <code>null</code>
	 */
	private String getTabEquivalent() {
		String tab;
		if (AtlUIPlugin.getDefault().getPreferenceStore().getBoolean(AtlPreferenceConstants.TYPING_SPACES_FOR_TABS)) {
			int size= AtlUIPlugin.getDefault().getPreferenceStore().getInt(AtlPreferenceConstants.APPEARANCE_TAB_WIDTH);
			StringBuffer buf= new StringBuffer();
			for (int i= 0; i< size; i++)
				buf.append(' ');
			tab= buf.toString();
		} else
			tab= "\t";//$NON-NLS-1$
		
		return tab;
	}
	
	/**
	 * Indents a single line using the java heuristic scanner. Javadoc and multiline comments are 
	 * indented as specified by the <code>JavaDocAutoIndentStrategy</code>.
	 * 
	 * @param document the document
	 * @param line the line to be indented
	 * @param caret the caret position
	 * @param indenter the java indenter
	 * @param scanner the heuristic scanner
	 * @return <code>true</code> if <code>document</code> was modified, <code>false</code> otherwise
	 * @throws BadLocationException if the document got changed concurrently 
	 */
	private boolean indentLine(IDocument document, int line, int caret, AtlIndenter indenter, AtlHeuristicScanner scanner) throws BadLocationException {
		IRegion currentLine= document.getLineInformation(line);
		int offset= currentLine.getOffset();
		int wsStart= offset; // where we start searching for non-WS; after the "//" in single line comments
		
		String indent= null;
		if (offset < document.getLength()) {
			ITypedRegion partition= TextUtilities.getPartition(document, IAtlPartitions.PARTITIONING, offset, true);
			String type= partition.getType();
			if (type.equals(IAtlPartitions.DOC) || type.equals(IAtlPartitions.SINGLE_LINE_COMMENT)) {
				
				// TODO this is a hack
				// what I want to do
				//				new JavaDocAutoIndentStrategy().indentLineAtOffset(document, offset);
				//				return;
				
				int start= 0;
				if (line > 0) {
					
					IRegion previousLine= document.getLineInformation(line - 1);
					start= previousLine.getOffset() + previousLine.getLength();
				}
				
				DocumentCommand command= new DocumentCommand() {};
				command.text= "\n";//$NON-NLS-1$
				command.offset= start;
				// TODO atl documentation auto indent strategy
//				new AtlDocAutoIndentStrategy(IAtlPartitions.PARTITIONING).customizeDocumentCommand(document, command);
				int to= 1;
				while (to < command.text.length() && Character.isWhitespace(command.text.charAt(to)))
					to++;
				indent= command.text.substring(1, to);
				
			} else if (!fIsTabAction && partition.getOffset() == offset && type.equals(IAtlPartitions.SINGLE_LINE_COMMENT)) {
				
				// line comment starting at position 0 -> indent inside
				int slashes= 2;
				while (slashes < document.getLength() - 1 && document.get(offset + slashes, 2).equals("//")) //$NON-NLS-1$
					slashes+= 2;
				
				wsStart= offset + slashes;
				
				StringBuffer computed= indenter.computeIndentation(offset);
				int tabSize= AtlUIPlugin.getDefault().getPreferenceStore().getInt(AtlPreferenceConstants.APPEARANCE_TAB_WIDTH);
				while (slashes > 0 && computed.length() > 0) {
					char c= computed.charAt(0);
					if (c == '\t')
						if (slashes > tabSize)
							slashes-= tabSize;
						else
							break;
					else if (c == ' ')
						slashes--;
					else break;
					
					computed.deleteCharAt(0);
				}
				
				indent= document.get(offset, wsStart - offset) + computed;
				
			}
		} 
		
		// standard java indentation
		if (indent == null) {
			StringBuffer computed= indenter.computeIndentation(offset);
			if (computed != null)
				indent= computed.toString();
			else
				indent= new String();
		}
		
		// change document:
		// get current white space
		int lineLength= currentLine.getLength();
		int end= scanner.findNonWhitespaceForwardInAnyPartition(wsStart, offset + lineLength);
		if (end == AtlHeuristicScanner.NOT_FOUND)
			end= offset + lineLength;
		int length= end - offset;
		String currentIndent= document.get(offset, length);
		
		// if we are right before the text start / line end, and already after the insertion point
		// then just insert a tab.
		if (fIsTabAction && caret == end && whiteSpaceLength(currentIndent) >= whiteSpaceLength(indent)) {
			String tab= getTabEquivalent();
			document.replace(caret, 0, tab);
			fCaretOffset= caret + tab.length();
			return true;
		}
		
		// set the caret offset so it can be used when setting the selection
		if (caret >= offset && caret <= end)
			fCaretOffset= offset + indent.length();
		else
			fCaretOffset= -1;
		
		// only change the document if it is a real change
		if (!indent.equals(currentIndent)) {
//			String deletedText= document.get(offset, length);
			document.replace(offset, length, indent);
			
			if (fIsTabAction && indent.length() > currentIndent.length() && AtlUIPlugin.getDefault().getPreferenceStore().getBoolean(AtlPreferenceConstants.EDITOR_SMART_BACKSPACE)) {
				ITextEditor editor= getTextEditor();
				if (editor != null) {
					// TODO create smart backspace manager to enable indent action
//					final SmartBackspaceManager manager= (SmartBackspaceManager) editor.getAdapter(SmartBackspaceManager.class);
//					if (manager != null) {
//						try {
//							// restore smart portion
//							ReplaceEdit smart= new ReplaceEdit(offset, indent.length(), deletedText);
//							
//							final UndoSpec spec= new UndoSpec(
//									offset + indent.length(),
//									new Region(caret, 0),
//									new TextEdit[] { smart },
//									2,
//									null);
//							manager.register(spec);
//						} catch (MalformedTreeException e) {
//							// log & ignore
//							System.out.println(new Status(IStatus.ERROR, AtlUIPlugin.getPluginId(), IStatus.OK, "Illegal smart backspace action", e));
//						}
//					}
				}
			}
			
			
			return true;
		} else
			return false;
	}
	
	/**
	 * Returns the smart preference state.
	 * 
	 * @return <code>true</code> if smart mode is on, <code>false</code> otherwise
	 */
	private boolean isSmartMode() {
		ITextEditor editor= getTextEditor();
		
		if (editor instanceof ITextEditorExtension3)
			return ((ITextEditorExtension3) editor).getInsertMode() == ITextEditorExtension3.SMART_INSERT;
		
		return false;
	}
	
	/**
	 * Returns if the current selection is valid, i.e. whether it is empty and the caret in the 
	 * whitespace at the start of a line, or covers multiple lines.
	 * 
	 * @return <code>true</code> if the selection is valid for an indent operation
	 */
	private boolean isValidSelection() {
		ITextSelection selection= getSelection();
		if (selection.isEmpty())
			return false;
		
		int offset= selection.getOffset();
		int length= selection.getLength();
		
		IDocument document= getDocument();
		if (document == null)
			return false;
		
		try {
			IRegion firstLine= document.getLineInformationOfOffset(offset);
			int lineOffset= firstLine.getOffset();
			
			// either the selection has to be empty and the caret in the WS at the line start
			// or the selection has to extend over multiple lines
			if (length == 0)
				return document.get(lineOffset, offset - lineOffset).trim().length() == 0;
			else
				//				return lineOffset + firstLine.getLength() < offset + length;
				return false; // only enable for empty selections for now
			
		} catch (BadLocationException e) {
		}
		
		return false;
	}
	
	/*
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		// update has been called by the framework
		if (!isEnabled() || !validateEditorInputState())
			return;
		
		ITextSelection selection= getSelection();
		final IDocument document= getDocument();
		
		if (document != null) {
			
			final int offset= selection.getOffset();
			final int length= selection.getLength();
			final Position end= new Position(offset + length);
			final int firstLine, nLines;
			fCaretOffset= -1;
			
			try {
				document.addPosition(end);
				firstLine= document.getLineOfOffset(offset);
				// check for marginal (zero-length) lines
				int minusOne= length == 0 ? 0 : 1;
				nLines= document.getLineOfOffset(offset + length - minusOne) - firstLine + 1;
			} catch (BadLocationException e) {
				// will only happen on concurrent modification
				AtlUIPlugin.log(e);
//				System.out.println(new Status(IStatus.ERROR, AtlUIPlugin.getPluginId(), IStatus.OK, "", e));
				return;
			}
			
			Runnable runnable= new Runnable() {
				public void run() {
					IRewriteTarget target= (IRewriteTarget)getTextEditor().getAdapter(IRewriteTarget.class);
					if (target != null) {
						target.beginCompoundChange();
						target.setRedraw(false);
					}
					
					try {
						AtlHeuristicScanner scanner= new AtlHeuristicScanner(document);
						AtlIndenter indenter= new AtlIndenter(document, scanner);
						boolean hasChanged= false;
						for (int i= 0; i < nLines; i++) {
							hasChanged |= indentLine(document, firstLine + i, offset, indenter, scanner);
						}
						
						// update caret position: move to new position when indenting just one line
						// keep selection when indenting multiple
						int newOffset, newLength;
						if (fIsTabAction) {
							newOffset= fCaretOffset;
							newLength= 0;
						} else if (nLines > 1) {
							newOffset= offset;
							newLength= end.getOffset() - offset;
						} else {
							newOffset= fCaretOffset;
							newLength= 0;
						}
						
						// always reset the selection if anything was replaced
						// but not when we had a singleline nontab invocation
						if (newOffset != -1 && (hasChanged || newOffset != offset || newLength != length))
							selectAndReveal(newOffset, newLength);
						
						document.removePosition(end);
					} catch (BadLocationException e) {
						// will only happen on concurrent modification
						AtlUIPlugin.log(e);
//						System.out.println(new Status(IStatus.ERROR, AtlUIPlugin.getPluginId(), IStatus.OK, "ConcurrentModification in IndentAction", e));
					} finally {
						if (target != null) {
							target.endCompoundChange();
							target.setRedraw(true);
						}
					}
				}
			};
			
			if (nLines > 50) {
				Display display= getTextEditor().getEditorSite().getWorkbenchWindow().getShell().getDisplay();
				BusyIndicator.showWhile(display, runnable);
			} else
				runnable.run();
			
		}
	}
	
	/**
	 * Selects the given range on the editor.
	 * 
	 * @param newOffset the selection offset
	 * @param newLength the selection range
	 */
	private void selectAndReveal(int newOffset, int newLength) {
		Assert.isTrue(newOffset >= 0);
		Assert.isTrue(newLength >= 0);
		ITextEditor editor= getTextEditor();
		if (editor instanceof AtlEditor) {
			ISourceViewer viewer= ((AtlEditor)editor).getViewer();
			if (viewer != null)
				viewer.setSelectedRange(newOffset, newLength);
		} else
			// this is too intrusive, but will never get called anyway
			getTextEditor().selectAndReveal(newOffset, newLength);
		
	}
	
	/*
	 * @see org.eclipse.ui.texteditor.IUpdate#update()
	 */
	public void update() {
		super.update();
		
		if (isEnabled())
			if (fIsTabAction)
				setEnabled(canModifyEditor() && isSmartMode() && isValidSelection());
			else
				setEnabled(canModifyEditor() && !getSelection().isEmpty());
	}
	
	/**
	 * Returns the size in characters of a string. All characters count one, tabs count the editor's
	 * preference for the tab display 
	 * 
	 * @param indent the string to be measured.
	 * @return
	 */
	private int whiteSpaceLength(String indent) {
		if (indent == null)
			return 0;
		else {
			int size= 0;
			int l= indent.length();
			int tabSize= AtlUIPlugin.getDefault().getPreferenceStore().getInt(AtlPreferenceConstants.APPEARANCE_TAB_WIDTH);
			
			for (int i= 0; i < l; i++)
				size += indent.charAt(i) == '\t' ? tabSize : 1;
			return size;
		}
	}
	
}
