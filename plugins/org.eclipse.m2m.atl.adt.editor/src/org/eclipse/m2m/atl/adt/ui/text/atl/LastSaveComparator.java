/*******************************************************************************
 * Copyright (c) 2010, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl;

import org.eclipse.compare.contentmergeviewer.TokenComparator;
import org.eclipse.compare.rangedifferencer.RangeDifference;
import org.eclipse.compare.rangedifferencer.RangeDifferencer;
import org.eclipse.jface.text.IDocument;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditor;

/**
 * It compares the current input of an editor with the last saved input.
 * 
 * @author www.obeo.fr
 */
public class LastSaveComparator {

	/**
	 * The editor to compare.
	 */
	private AtlEditor editor;

	/**
	 * The save comparator.
	 */
	private TokenComparator saveComparator;

	/**
	 * The current comparator.
	 */
	private TokenComparator currentComparator;

	/**
	 * Range differences.
	 */
	private RangeDifference[] ranges;

	/**
	 * Constructor.
	 * 
	 * @param editor
	 *            is the editor to compare
	 */
	public LastSaveComparator(AtlEditor editor) {
		this.editor = editor;
	}

	/**
	 * Marks the last saved input.
	 */
	public void markAsSave() {
		saveComparator = new TokenComparator(getDocument().get());
		markAsCurrent();
	}

	/**
	 * Marks the current input.
	 */
	private void markAsCurrent() {
		String content = getDocument().get();
		if (this.content == null || !this.content.equals(content)) {
			this.content = content;
			currentComparator = new TokenComparator(getDocument().get());
			ranges = RangeDifferencer.findRanges(currentComparator, saveComparator);
		}
	}

	private String content = null;

	private IDocument getDocument() {
		return editor.getDocumentProvider().getDocument(editor.getEditorInput());
	}

	/**
	 * An indexed position.
	 */
	private static class IndexedPos {

		/**
		 * Number of the range.
		 */
		protected int rangeIndex;

		/**
		 * Position.
		 */
		protected int position;

		/**
		 * Constructor.
		 * 
		 * @param rangeIndex
		 * @param position
		 */
		protected IndexedPos(int rangeIndex, int position) {
			this.rangeIndex = rangeIndex;
			this.position = position;
		}

	}

	/**
	 * Gets the current position for the save position.
	 * 
	 * @param save
	 *            is the save position
	 * @return the current position
	 */
	public int[] save2currentPosition(int[] save) {
		markAsCurrent();
		if (save[0] > -1) {
			IndexedPos b = save2currentPosition(save[0], null);
			IndexedPos e = save2currentPosition(save[1], b);
			return new int[] {b.position, e.position};
		} else {
			return null;
		}
	}

	private IndexedPos save2currentPosition(int saveIndex, IndexedPos first) {
		int begin = (first != null) ? first.rangeIndex : 0;
		for (int i = begin; i < ranges.length; i++) {
			RangeDifference range = ranges[i];
			int saveStart = saveComparator.getTokenStart(range.rightStart());
			int saveEnd = saveComparator.getTokenStart(range.rightEnd());
			if (saveIndex >= saveStart && saveIndex < saveEnd) {
				int currentStart = currentComparator.getTokenStart(range.leftStart());
				int currentEnd = currentComparator.getTokenStart(range.leftEnd());
				int diff = saveIndex - saveStart;
				if ((currentStart + diff) < currentEnd) {
					return new IndexedPos(i, currentStart + diff);
				} else {
					return new IndexedPos(i, currentEnd);
				}
			}
		}
		return new IndexedPos(ranges.length, -1);
	}

	/**
	 * Gets the save position for the current position.
	 * 
	 * @param current
	 *            is the current position
	 * @return the save position
	 */
	public int[] current2savePosition(int[] current) {
		markAsCurrent();
		if (current[0] > -1) {
			IndexedPos b = current2savePosition(current[0], null);
			IndexedPos e = current2savePosition(current[1], b);
			return new int[] {b.position, e.position};
		} else {
			return null;
		}
	}

	private IndexedPos current2savePosition(int currentIndex, IndexedPos first) {
		int begin = (first != null) ? first.rangeIndex : 0;
		for (int i = begin; i < ranges.length; i++) {
			RangeDifference range = ranges[i];
			int currentStart = currentComparator.getTokenStart(range.leftStart());
			int currentEnd = currentComparator.getTokenStart(range.leftEnd());
			if (currentIndex >= currentStart && currentIndex < currentEnd) {
				int saveStart = saveComparator.getTokenStart(range.rightStart());
				int saveEnd = saveComparator.getTokenStart(range.rightEnd());
				int diff = currentIndex - currentStart;
				if ((saveStart + diff) < saveEnd) {
					return new IndexedPos(i, saveStart + diff);
				} else {
					return new IndexedPos(i, saveEnd);
				}
			}
		}
		return new IndexedPos(ranges.length, -1);
	}

}
