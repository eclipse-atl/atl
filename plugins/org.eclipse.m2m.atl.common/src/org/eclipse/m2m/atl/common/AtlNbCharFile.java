/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Freddy Allilaire (INRIA) - initial API and implementation
 *     Frederic Jouault (INRIA)
 *******************************************************************************/
package org.eclipse.m2m.atl.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

/**
 * This class is used by a stackframe to compute char position in a file With the file name and project name,
 * this structure build a list for each line the position of its first char and the position of the tabs.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class AtlNbCharFile {

	private static final int ANTLR_TAB_WIDTH = 1;

	/**
	 * This class corresponding to the structure Line : for each line : index of first char and position of
	 * tabs.
	 * 
	 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
	 */
	class Line {
		/** Absolute offset of the first char of the line. */
		int indexFirstChar;

		/** Relative offset of each tab in the current line. */
		List indexTabs;

		/**
		 * Actual width of each tab (using ANTLR_TAB_WIDTH as standard tab size). Seems useless (to remove? if
		 * so, also remove computation in computePosition).
		 */
		List tabsWidth;

		public Line(int indexFirstChar, List indexTabs, List tabsWidth) {
			this.indexFirstChar = indexFirstChar;
			this.indexTabs = indexTabs;
			this.tabsWidth = tabsWidth;
		}
	}

	/**
	 * List of structures Line for the file.
	 */
	private List lines;

	/**
	 * The AtlNbCharFile constructor.
	 * 
	 * @param in
	 *            the input stream
	 */
	public AtlNbCharFile(InputStream in) {
		computePosition(in);
	}

	/**
	 * This is the main method which compute for each line of the file the index of the first char and the
	 * index of the tabs.
	 * 
	 * @param is
	 *            the input stream
	 */
	private void computePosition(InputStream is) {
		lines = new ArrayList();

		try {
			int currentChar;
			int currentLineCharIndex = 0;
			int currentCharIndex = 0;
			int currentCharInLine = 0; // first char of a line has index 0
			int nbCharsSinceLastTab = 0;
			List indexTabs = new ArrayList();
			List tabsWidth = new ArrayList();
			while (true) {
				currentChar = is.read();
				if (((char)currentChar == '\n') || (currentChar == -1)) {
					lines.add(new Line(currentLineCharIndex, indexTabs, tabsWidth));
					currentLineCharIndex = currentCharIndex;
					indexTabs = new ArrayList();
					tabsWidth = new ArrayList();
					currentCharInLine = -1; // first char of a line has index 0 (see currentCharInLine++
					// below)
					nbCharsSinceLastTab = -1;

					if (currentChar == -1) {
						break;
					}
				} else if ((char)currentChar == '\t') {
					indexTabs.add(new Integer(currentCharInLine));
					tabsWidth.add(new Integer(ANTLR_TAB_WIDTH - (nbCharsSinceLastTab % ANTLR_TAB_WIDTH)));
					nbCharsSinceLastTab = -1;
				}
				currentCharIndex++;
				currentCharInLine++;
				nbCharsSinceLastTab++;
			}
			lines.add(new Line(currentLineCharIndex, indexTabs, tabsWidth));
			is.close();
		} catch (IOException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	/**
	 * With the current line and index of the column this method returns the position to select in the file
	 * For example, the debugUI needs to know the index the start char and the last char of the current
	 * AtlStackFrame To compute start char and last char, AtlStackFrame calls this method.
	 * 
	 * @param lineNumber
	 *            the line number
	 * @param column
	 *            the column number
	 * @param tabWidth
	 *            the width of the tab
	 * @return the position to select in the file
	 */
	private int getIndexChar(int lineNumber, int column, int tabWidth) {
		int ret = 0;

		if (!((lineNumber == 1) && (column == 1))) {
			int indexOffset = 0;
			// When editor is dirty(changed and not saved), outline is not synchronised with editor
			if (lineNumber > lines.size()) {
				return -1;
			}
			Line line = (Line)lines.get(lineNumber - 1);

			for (Iterator i = line.indexTabs.iterator(); i.hasNext();) {
				int index = ((Integer)i.next()).intValue() + indexOffset;
				int actualTabWidth = tabWidth - (index % tabWidth);
				if (column > index) {
					ret -= actualTabWidth - 1;
					indexOffset += actualTabWidth - 1;
				} else {
					break;
				}
			}
			ret += line.indexFirstChar + column + 1;
			if (lineNumber == 1) {
				ret--;
			}
		}
		return ret;
	}

	/**
	 * Returns the index char in the source location.
	 * 
	 * @param sourceLocation
	 *            the source
	 * @return the index char in the source location
	 */
	public int[] getIndexChar(String sourceLocation) {
		return getIndexChar(sourceLocation, ANTLR_TAB_WIDTH);
	}

	/**
	 * Returns an array of int: first element is startChar, second element is endChar. *
	 * 
	 * @param sourceLocation
	 *            the string representing "startLine:startColumn-endLine:endColumn" the location given by
	 *            antlr (tabs are 8 chars long)
	 * @param tabWidth
	 *            the width of the tab
	 * @return An array of int: first element is startChar, second element is endChar
	 */
	public int[] getIndexChar(String sourceLocation, int tabWidth) {
		int[] ret = new int[2];
		int currentTabWidth = tabWidth;
		if (currentTabWidth < 0) {
			currentTabWidth = ANTLR_TAB_WIDTH;
		}

		String locRegex = "^(-?\\d{1,9}):(-?\\d{1,9})-(-?\\d{1,9}):(-?\\d{1,9})$"; //$NON-NLS-1$
		if (sourceLocation.matches(locRegex)) {
			ret[0] = getIndexChar(Integer.parseInt(sourceLocation.replaceFirst(locRegex, "$1")), //$NON-NLS-1$
					Integer.parseInt(sourceLocation.replaceFirst(locRegex, "$2")) - 1, //$NON-NLS-1$
					currentTabWidth);
			ret[1] = getIndexChar(Integer.parseInt(sourceLocation.replaceFirst(locRegex, "$3")), //$NON-NLS-1$
					Integer.parseInt(sourceLocation.replaceFirst(locRegex, "$4")) - 1, //$NON-NLS-1$
					currentTabWidth);
		} else {
			ret[0] = 0;
			ret[1] = -1;
		}
		return ret;
	}

	/**
	 * Returns computes the char start position from the string "cursorLine:cursorColumn" given by Eclipse
	 * (tabs are 4 chars long by default, but it is user-configurable).
	 * 
	 * @param cursorPosition
	 *            the string representing the cursor position
	 * @return computes the char start position from the string "cursorLine:cursorColumn" given by Eclipse
	 *         (tabs are 4 chars long by default, but it is user-configurable)
	 */
	public int getIndex(String cursorPosition) {
		int ret = 0;
		String[] starts = cursorPosition.split(":"); //$NON-NLS-1$
		int startLine = Integer.parseInt(starts[0].trim());
		int startColumn = Integer.parseInt(starts[1].trim()) - 1; // Eclipse assigns index 1 to first char

		ret = getIndexChar(startLine, startColumn, 4);
		return ret;
	}

}
