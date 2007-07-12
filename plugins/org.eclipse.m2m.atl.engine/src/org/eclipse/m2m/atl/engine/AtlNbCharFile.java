/*
 * Created on 21 mai 2004
 */
package org.eclipse.m2m.atl.engine;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.m2m.atl.engine.vm.ATLVMPlugin;

/**
 * @author allilaire
 * 
 * This class is used by a stackframe to compute char position in a file
 * With the file name and project name, this structure build a list
 * for each line the position of its first char and the position of the tabs
 */
public class AtlNbCharFile {
	
	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);

	private static final int ANTLR_TAB_WIDTH = 1;

	/**
	 * This class corresponding to the structure Line : 
	 * for each line : index of first char and position of tabs
	 * @author allilaire
	 */
	class Line {
		/** Absolute offset of the first char of the line. */
		int indexFirstChar;
		
		/** Relative offset of each tab in the current line. */
		List indexTabs;
		
		/**
		 * Actual width of each tab (using ANTLR_TAB_WIDTH as standard tab size).
		 * Seems useless (to remove? if so, also remove computation in computePosition).
		 * */
		List tabsWidth;
		
		public Line(int indexFirstChar, List indexTabs, List tabsWidth) {
			this.indexFirstChar = indexFirstChar;
			this.indexTabs = indexTabs;
			this.tabsWidth = tabsWidth;
		}
	}

	/**
	 * List of structures Line for the file
	 */
	private List lines;

	/**
	 * @param projectName
	 * @param fileName
	 */
	public AtlNbCharFile(InputStream in) {
		computePosition(in);
	}

	/**
	 * This is the main method which compute for each line of the file
	 * the index of the first char and the index of the tabs
	 *
	 */
	private void computePosition(InputStream is) {
		lines = new ArrayList();

		try {
			int currentChar;
			int currentLineCharIndex = 0;
			int currentCharIndex = 0;
			int currentCharInLine = 0;	// first char of a line has index 0
			int nbCharsSinceLastTab = 0;
			List indexTabs = new ArrayList();
			List tabsWidth = new ArrayList();
			while (true) {
				currentChar = is.read();
				if (((char) currentChar == '\n') || (currentChar == -1)) {
					lines.add(new Line(currentLineCharIndex, indexTabs, tabsWidth));
					currentLineCharIndex = currentCharIndex;
					indexTabs = new ArrayList();
					tabsWidth = new ArrayList();
					currentCharInLine = -1;		// first char of a line has index 0 (see currentCharInLine++ below)
					nbCharsSinceLastTab = -1;
					
					if(currentChar == -1) break;
				}
				else if ((char) currentChar == '\t') {
					indexTabs.add(new Integer(currentCharInLine));
					tabsWidth.add(new Integer(ANTLR_TAB_WIDTH - (nbCharsSinceLastTab % ANTLR_TAB_WIDTH)));
					nbCharsSinceLastTab = -1;
				}
				currentCharIndex++;
				currentCharInLine++;
				nbCharsSinceLastTab++;
			}
			lines.add(new Line(currentLineCharIndex, indexTabs, tabsWidth));
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
		}
	}

	/**
	 * With the current line and index of the column this method returns
	 * the position to select in the file
	 * 
	 * For example, the debugUI needs to know the index the start char and
	 * the last char of the current AtlStackFrame
	 * To compute start char and last char, AtlStackFrame calls this method
	 * @param lineNumber
	 * @param column
	 * @return
	 */
	public int getIndexChar(int lineNumber, int column, int tabWidth) {
		int ret = 0;
		
		if(!((lineNumber == 1) && (column == 1))) {
			int indexOffset = 0;
			// When editor is dirty(changed and not saved), outline is not synchronised with editor
			if ((lineNumber) > lines.size())
				return -1;
			Line line = (Line)lines.get(lineNumber - 1);

			for ( Iterator i = line.indexTabs.iterator() ; i.hasNext() ; ) {
				int index = ((Integer)i.next()).intValue() + indexOffset;
				int actualTabWidth = tabWidth - (index % tabWidth);
				if(column > index) {
					ret -= actualTabWidth - 1;
					indexOffset += actualTabWidth - 1;
				}
				else {
					break;
				}
			}
			ret += line.indexFirstChar + column + 1;
			if (lineNumber == 1)
				ret--;
		}
		return ret;
	}
/*	
	private int getIndexChar(int lineNumber, int column) {
		int ret = 0;
		
		if(!((lineNumber == 1) && (column == 1))) {
			int indexOffset = 0;
			// When editor is dirty(changed and not saved), outline is not synchronised with editor
			if ((lineNumber) > lines.size())
				return -1;
			Line line = (Line)lines.get(lineNumber - 1);

			for ( Iterator i = line.indexTabs.iterator(), j = line.tabsWidth.iterator() ; i.hasNext() ; ) {
				int index = ((Integer)i.next()).intValue() + indexOffset;
				int tabWidth = ((Integer)j.next()).intValue();
				if(column > index) {
					ret -= tabWidth - 1;
					indexOffset += tabWidth - 1;
				}
				else {
					break;
				}
			}
			ret += line.indexFirstChar + column;
			if (lineNumber == 1)
				ret--;
		}
		return ret;
	}
*/
	public int[] getIndexChar(String sourceLocation) {
		return getIndexChar(sourceLocation, ANTLR_TAB_WIDTH);
	}
	/**
	 * @return An array of int: first element is startChar, second element is endChar.
	 * @param sourceLocation the string representing "startLine:startColumn-endLine:endColumn" the location given by antlr (tabs are 8 chars long)
	 */
	public int[] getIndexChar(String sourceLocation, int tabWidth) {
		int ret[] = new int[2];
		
		if(tabWidth < 0) tabWidth = ANTLR_TAB_WIDTH;

		String ss[] = sourceLocation.split("-");
		String starts[] = ss[0].split(":");
		int startLine = Integer.parseInt(starts[0]);
		int startColumn = Integer.parseInt(starts[1]) - 1;	// ANTLR assigns index 1 to first char
		String ends[] = ss[1].split(":");
		int endLine = Integer.parseInt(ends[0]);
		int endColumn = Integer.parseInt(ends[1]) - 1;
		
//		ret[0] = getIndexChar(startLine, startColumn);
//		ret[1] = getIndexChar(endLine, endColumn);
		ret[0] = getIndexChar(startLine, startColumn, tabWidth);
		ret[1] = getIndexChar(endLine, endColumn, tabWidth);

		return ret;
	}
	
	/**
	 * @return computes the char start position from the string "cursorLine:cursorColumn" given by Eclipse (tabs are 4 chars long by default, but it is user-configurable)
	 * @param cursorPosition the string representing the cursor position
	 */
	public int getIndex(String cursorPosition) {
		int ret = 0;
		String starts[] = cursorPosition.split(":");
		int startLine = Integer.parseInt(starts[0].trim());
		int startColumn = Integer.parseInt(starts[1].trim()) - 1;	// Eclipse assigns index 1 to first char

		ret = getIndexChar(startLine, startColumn, 4);
		return ret;
	}
	
}
