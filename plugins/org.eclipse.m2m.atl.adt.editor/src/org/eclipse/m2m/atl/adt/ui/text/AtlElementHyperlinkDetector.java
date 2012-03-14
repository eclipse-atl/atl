/*******************************************************************************
 * Copyright (c) 2010, 2012 Obeo.
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
import org.eclipse.jface.text.hyperlink.AbstractHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditor;
import org.eclipse.m2m.atl.adt.ui.editor.Messages;
import org.eclipse.m2m.atl.adt.ui.text.atl.OpenDeclarationUtils;
import org.eclipse.m2m.atl.adt.ui.text.atl.types.Feature;
import org.eclipse.m2m.atl.adt.ui.text.atl.types.UnitType;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * This will allow us to plug the CTRL+click "open declaration" into Atl editors.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:thierry.fortin@obeo.fr">Thierry Fortin</a>
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
		if (region == null || !(textEditor instanceof AtlEditor) ||
				textEditor.getEditorInput() == null)
			return null;
		IDocument document = textEditor.getDocumentProvider().getDocument(textEditor.getEditorInput());
		IRegion wordRegion = OpenDeclarationUtils.findWord(document, region.getOffset());
		if (wordRegion == null || wordRegion.getLength() == 0) {
			return null;
		}
		String currentLine = AtlEditor.getCurrentLine(document, wordRegion.getOffset());
		if(currentLine == null || currentLine.contains("--")) //$NON-NLS-1$
			return null;
		try {
			Object declaration = OpenDeclarationUtils.getDeclaration((AtlEditor)textEditor, wordRegion
					.getOffset(), wordRegion.getLength());
			if (declaration instanceof EObject) {
				return new IHyperlink[] {new AtlElementHyperlink((AtlEditor)textEditor, null, wordRegion,
						(EObject)declaration),};
			} else if (declaration instanceof Feature) {
				Feature feature = (Feature)declaration;
				if (feature.getDeclaration() != null) {
					return new IHyperlink[] {new AtlElementHyperlink((AtlEditor)textEditor,
							feature.getUnit(), wordRegion, feature.getDeclaration()),};
				}

			}
		} catch (BadLocationException e) {
			return null;
		}
		return null;
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

		private final UnitType unit;

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
		public AtlElementHyperlink(AtlEditor editor, UnitType unit, IRegion region, EObject linkTarget) {
			this.sourceEditor = editor;
			this.hyperLinkRegion = region;
			this.target = linkTarget;
			this.unit = unit;
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
			if (target != null) {
				try {
					OpenDeclarationUtils.openDeclaration(unit, target, sourceEditor);
				} catch (BadLocationException e) {
					// do nothing
				}
			}
		}
	}
}
