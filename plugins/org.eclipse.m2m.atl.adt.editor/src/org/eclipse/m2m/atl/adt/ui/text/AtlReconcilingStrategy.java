/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotation;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditor;
import org.eclipse.swt.widgets.Display;

/**
 * This reconciling strategy will allow us to enable folding support in the Atl editor.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public final class AtlReconcilingStrategy implements IReconcilingStrategy, IReconcilingStrategyExtension {

	private final String RULE_BLOCK_START = "rule"; //$NON-NLS-1$

	private final String HELPER_BLOCK_START = "helper"; //$NON-NLS-1$

	/**
	 * This will hold the list of all annotations that have been added since the last reconciling.
	 */
	protected final Map addedAnnotations = new HashMap();

	/** Current known positions of foldable block. */
	protected final Map currentAnnotations = new HashMap();

	/**
	 * This will hold the list of all annotations that have been removed since the last reconciling.
	 */
	protected final List deletedAnnotations = new ArrayList();

	/** Editor this provides folding support to. */
	protected final AtlEditor editor;

	/**
	 * This will hold the list of all annotations that have been modified since the last reconciling.
	 */
	protected final Map modifiedAnnotations = new HashMap();

	/** The document we'll seek foldable blocks in. */
	private IDocument document;

	/** Current offset. */
	private int offset;

	/**
	 * Instantiates the reconciling strategy for a given editor.
	 * 
	 * @param editor
	 *            Editor which we seek to provide folding support for.
	 */
	public AtlReconcilingStrategy(AtlEditor editor) {
		this.editor = editor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension#initialReconcile()
	 */
	public void initialReconcile() {
		offset = 0;
		computePositions();
		updateFoldingStructure();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.reconciler.IReconcilingStrategy#reconcile(org.eclipse.jface.text.reconciler.DirtyRegion,
	 *      org.eclipse.jface.text.IRegion)
	 */
	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
		reconcile(subRegion);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.reconciler.IReconcilingStrategy#reconcile(org.eclipse.jface.text.IRegion)
	 */
	public void reconcile(IRegion partition) {
		offset = partition.getOffset();
		computePositions();
		updateFoldingStructure();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.reconciler.IReconcilingStrategy#setDocument(org.eclipse.jface.text.IDocument)
	 */
	public void setDocument(IDocument document) {
		this.document = document;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension#setProgressMonitor(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void setProgressMonitor(IProgressMonitor monitor) {
		// none
	}

	private AtlCodeReader reader = new AtlCodeReader();

	/**
	 * This will compute the current block positions. The offset at which computations start is determined by
	 * {@link #offset}.
	 */
	private void computePositions() {
		deletedAnnotations.clear();
		modifiedAnnotations.clear();
		addedAnnotations.clear();
		deletedAnnotations.addAll(currentAnnotations.keySet());
		for (Iterator iterator = currentAnnotations.entrySet().iterator(); iterator.hasNext();) {
			Entry entry = (Entry)iterator.next();
			final Position position = (Position)entry.getValue();
			if (position.getOffset() + position.getLength() < offset) {
				deletedAnnotations.remove(entry.getKey());
			}
		}
		try {
			boolean eof = seekChars(new char[] {RULE_BLOCK_START.charAt(0), HELPER_BLOCK_START.charAt(0),});
			int startOffset = offset;
			while (!eof) {
				offset++;
				if (RULE_BLOCK_START.equals(document.get(startOffset, RULE_BLOCK_START.length()))) {

					// Rule detected: computing rule scope using brackets

					eof = seekChars(new char[] {'{',});
					offset++;
					IRegion region = editor.getBracketMatcher().match(document, offset);
					if (region != null) {
						offset = region.getOffset() + region.getLength();
						eof = seekChars(new char[] {'\n',});
						final int endOffset = offset + 1;
						if (document.getNumberOfLines(startOffset, endOffset - startOffset) > 2) {
							createOrUpdateAnnotation(startOffset, (endOffset) - startOffset, false);
						}
					}
				} else if (HELPER_BLOCK_START.equals(document.get(startOffset, HELPER_BLOCK_START.length()))) {
					offset++;

					// Helper detected, looking for helper end: new rule, new helper or eof

					eof = seekChars(new char[] {RULE_BLOCK_START.charAt(0), HELPER_BLOCK_START.charAt(0),});
					while (!(eof
							|| RULE_BLOCK_START.equals(document.get(offset, RULE_BLOCK_START.length())) || HELPER_BLOCK_START
							.equals(document.get(offset, HELPER_BLOCK_START.length())))) {
						offset++;
						eof = seekChars(new char[] {RULE_BLOCK_START.charAt(0), HELPER_BLOCK_START.charAt(0),});
					}
					 eof = backwardSeekChars(new char[] {';',}, startOffset);
					 eof = seekChars(new char[] {'\n',});
					final int endOffset = offset + 1;
					if (document.getNumberOfLines(startOffset, endOffset - startOffset) > 2) {
						createOrUpdateAnnotation(startOffset, (endOffset) - startOffset, false);
					}
				}
				eof = seekChars(new char[] {RULE_BLOCK_START.charAt(0), HELPER_BLOCK_START.charAt(0),});
				startOffset = offset;
			}
		} catch (BadLocationException e) {
			// Nothing to do
		} catch (IOException e) {
			// Nothing to do
		}
		for (Iterator iterator = deletedAnnotations.iterator(); iterator.hasNext();) {
			currentAnnotations.remove(iterator.next());
		}
	}

	private boolean seekChars(char[] startChars) throws BadLocationException, IOException {
		reader.configureForwardReader(document, offset, document.getLength(), true, true);
		int c = reader.read();
		offset = reader.getOffset();
		while (c != AtlCodeReader.EOF && !contains(startChars, document.getChar(offset))) {
			c = reader.read();
			offset = reader.getOffset();
		}
		return c == AtlCodeReader.EOF;
	}

	private boolean backwardSeekChars(char[] startChars, int start) throws BadLocationException, IOException {
		reader.configureBackwardReader(document, offset, true, true);
		int c = reader.read();
		offset = reader.getOffset();
		while (offset > start && c != AtlCodeReader.EOF && !contains(startChars, document.getChar(offset))) {
			c = reader.read();
			offset = reader.getOffset();
		}
		return c == AtlCodeReader.EOF;
	}

	private boolean contains(char[] chars, char test) {
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == test) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This will update lists {@link #deletedAnnotations}, {@link #addedAnnotations} and
	 * {@link #modifiedAnnotations} according to the given values.
	 * 
	 * @param newOffset
	 *            Offset of the text we want the annotation updated of.
	 * @param newLength
	 *            Length of the text we want the annotation updated of.
	 * @param initiallyCollapsed
	 *            Indicates that the created annotation should be folded from start.
	 * @throws BadLocationException
	 *             Thrown if we try and get an out of range character. Should not happen.
	 */
	private void createOrUpdateAnnotation(int newOffset, int newLength, boolean initiallyCollapsed)
			throws BadLocationException {
		boolean createAnnotation = true;
		final Map copy = new HashMap(currentAnnotations);
		final String text = document.get(newOffset, newLength);
		for (Iterator iterator = copy.entrySet().iterator(); iterator.hasNext();) {
			Entry entry = (Entry)iterator.next();
			if (((Annotation)entry.getKey()).getText().equals(text)) {
				createAnnotation = false;
				final Position oldPosition = (Position)entry.getValue();
				if (oldPosition.getOffset() != newOffset || oldPosition.getLength() != newLength) {
					final Position newPosition = new Position(newOffset, newLength);
					modifiedAnnotations.put(entry.getKey(), newPosition);
					currentAnnotations.put(entry.getKey(), newPosition);
				}
				deletedAnnotations.remove(entry.getKey());
				break;
			}
		}
		if (createAnnotation) {
			final Annotation annotation = new ProjectionAnnotation(initiallyCollapsed);
			annotation.setText(text);
			final Position position = new Position(newOffset, newLength);
			currentAnnotations.put(annotation, position);
			addedAnnotations.put(annotation, position);
		}
	}

	/**
	 * Updates the editor's folding structure.
	 */
	private void updateFoldingStructure() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				editor.updateFoldingStructure(addedAnnotations, deletedAnnotations, modifiedAnnotations);
			}
		});
	}
}
