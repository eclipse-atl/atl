/*******************************************************************************
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.AbstractHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditor;
import org.eclipse.m2m.atl.adt.ui.editor.Messages;
import org.eclipse.m2m.atl.adt.ui.text.atl.OpenDeclarationUtils;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * This will allow us to plug the CTRL+click "open declaration" in Atl editors.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlElementHyperlinkDetector extends AbstractHyperlinkDetector {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.hyperlink.IHyperlinkDetector#detectHyperlinks(org.eclipse.jface.text.ITextViewer,
	 *      org.eclipse.jface.text.IRegion, boolean)
	 */
	public IHyperlink[] detectHyperlinks(ITextViewer textViewer, IRegion region,
			boolean canShowMultipleHyperlinks) {
		ITextEditor textEditor = (ITextEditor)getAdapter(ITextEditor.class);
		if (region == null || !(textEditor instanceof AtlEditor))
			return null;
		IDocument document = textEditor.getDocumentProvider().getDocument(textEditor.getEditorInput());
		IRegion wordRegion = findWord(document, region.getOffset());
		if (wordRegion == null || wordRegion.getLength() == 0) {
			return null;
		}
		try {
			EObject declaration = OpenDeclarationUtils.getDeclaration((AtlEditor)textEditor, wordRegion
					.getOffset(), wordRegion.getLength());
			if (declaration != null) {
				return new IHyperlink[] {new AtlElementHyperlink((AtlEditor)textEditor, wordRegion,
						declaration),};
			}
		} catch (BadLocationException e) {
			return null;
		}
		return null;
	}

	private static IRegion findWord(IDocument document, int offset) {
		int start = -2;
		int end = -1;
		try {
			int pos = offset;
			char c;
			while (pos >= 0) {
				c = document.getChar(pos);
				if (!isAtlIdentifierPart(c)) {
					break;
				}
				--pos;
			}
			start = pos;
			pos = offset;
			int length = document.getLength();

			while (pos < length) {
				c = document.getChar(pos);
				if (!isAtlIdentifierPart(c)) {
					break;
				}
				++pos;
			}
			end = pos;
		} catch (BadLocationException x) {
		}
		if (start >= -1 && end > -1) {
			if (start == offset && end == offset)
				return new Region(offset, 0);
			else if (start == offset)
				return new Region(start, end - start);
			else
				return new Region(start + 1, end - start - 1);
		}
		return null;
	}

	/**
	 * Checks whether the given char is an ATL identifier part or not.
	 * 
	 * @param ch
	 *            the char
	 * @return <code>true</code> if the given char is an ATL identifier part
	 */
	private static boolean isAtlIdentifierPart(char ch) {
		return !Character.isWhitespace(ch) && ch != '.' && ch != '(' && ch != ')' && ch != '{' && ch != '}'
				&& ch != '.' && ch != ';' && ch != ',' && ch != ':' && ch != '|' && ch != '+' && ch != '-'
				&& ch != '<' && ch != '=' && ch != '>' && ch != '*' && ch != '/' && ch != '!';
	}

	/**
	 * This implementation of an hyperlink allows for the opening of ATL elements declarations.
	 * 
	 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
	 */
	private class AtlElementHyperlink implements IHyperlink {
		/** Region of this hyperlink. */
		private final IRegion hyperLinkRegion;

		/** EObject that will be opened via this hyperlink. */
		private final EObject target;

		/** Editor on which this link appears. */
		private final AtlEditor sourceEditor;

		/**
		 * Instantiates an ATL hyperlink given the editor it appears on, the text region it spans to, and the
		 * link's target.
		 * 
		 * @param editor
		 *            Editor on which this hyperlink is shown.
		 * @param region
		 *            Region of the editor where this hyperlink appears.
		 * @param linkTarget
		 *            Target of the hyperlink.
		 */
		public AtlElementHyperlink(AtlEditor editor, IRegion region, EObject linkTarget) {
			sourceEditor = editor;
			hyperLinkRegion = region;
			target = linkTarget;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.text.hyperlink.IHyperlink#getHyperlinkRegion()
		 */
		public IRegion getHyperlinkRegion() {
			return hyperLinkRegion;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.text.hyperlink.IHyperlink#getHyperlinkText()
		 */
		public String getHyperlinkText() {
			return Messages.getString("AtlElementHyperLinkDetector.OPEN_DECLARATION") + target; //$NON-NLS-1$
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.text.hyperlink.IHyperlink#getTypeLabel()
		 */
		public String getTypeLabel() {
			return null;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.text.hyperlink.IHyperlink#open()
		 */
		public void open() {
			try {
				OpenDeclarationUtils.openDeclaration(target, sourceEditor);
			} catch (BadLocationException e) {
				// do nothing
			}
		}
	}
}
