/*
 * Created on 21 mai 2004
 */
package org.atl.eclipse.adt.ui.outline;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author allilaire
 * 
 * This class is used by a stackframe to compute char position in a file
 * With the file name and project name, this structure build a list
 * for each line the position of its first char and the position of the tabs
 */
public class AtlNbCharFile {

	/**
	 * This class corresponding to the structure Line : 
	 * for each line : index of first char and position of tabs
	 * @author allilaire
	 */
	class Line {
		int indexFirstChar;
		List indexTabs;
		
		public Line(int indexFirstChar, List indexTabs) {
			this.indexFirstChar = indexFirstChar;
			this.indexTabs = indexTabs;
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
			int currentColumn = 0;
			List indexTabs = new ArrayList();
			while (true) {
				currentChar = is.read();
				if (((char) currentChar == '\n') || (currentChar == -1)) {
					lines.add(new Line(currentLineCharIndex, indexTabs));
					currentLineCharIndex = currentCharIndex;
					indexTabs = new ArrayList();
					currentColumn = 0;
					
					if(currentChar == -1) break;
				}
				else if ((char) currentChar == '\t') {
					indexTabs.add(new Integer(currentColumn));
				}
				currentCharIndex++;
				currentColumn++;
			}
		} catch (IOException e) {
			e.printStackTrace();
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
	private int getIndexChar(int lineNumber, int column, int tabWidth) {
		int ret = 0;
		
		if(!((lineNumber == 1) && (column == 1))) {
			int indexOffset = 0;
			Line line = (Line)lines.get(lineNumber - 1);

			for ( Iterator i = line.indexTabs.iterator() ; i.hasNext() ; ) {
				int index = ((Integer)i.next()).intValue() + indexOffset;
				if(column > index) {
					ret -= tabWidth - 1;
					indexOffset += tabWidth;
				}
				else {
					break;
				}
			}
			ret += line.indexFirstChar + column;
		}		
		return ret;
	}
	
	/**
	 * @return An array of int: first element is startChar, second element is endChar
	 */
	public int[] getIndexChar(String sourceLocation) {
		int ret[] = new int[2];
		
		String ss[] = sourceLocation.split("-");
		String starts[] = ss[0].split(":");
		int startLine = Integer.parseInt(starts[0]);
		int startColumn = Integer.parseInt(starts[1]);
		String ends[] = ss[1].split(":");
		int endLine = Integer.parseInt(ends[0]);
		int endColumn = Integer.parseInt(ends[1]);
		
		ret[0] = getIndexChar(startLine, startColumn, 8);
		ret[1] = getIndexChar(endLine, endColumn, 8);
		
		return ret;
	}
	
	/**
	 * @return computes the char start position from the string "cursorLine:cursorColumn"
	 * @param cursorPosition the string representing the cursor position
	 */
	public int getIndex(String cursorPosition) {
		String starts[] = cursorPosition.split(":");
		int startLine = Integer.parseInt(starts[0].trim());
		int startColumn = Integer.parseInt(starts[1].trim());
		return getIndexChar(startLine, startColumn, 4);
	}
	
}
