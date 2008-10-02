/*******************************************************************************
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - completion system
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.m2m.atl.engine.AtlParser;

/**
 * Completion helper, dedicated to document parsing.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlCompletionHelper {

	/** ATL parsing triggers. */
	private static final String[] PARSING_KEYWORDS = {"rule", "helper"}; //$NON-NLS-1$ //$NON-NLS-2$

	/** Context indicators. */
	private static final String[] HIGH_LEVEL_KEYWORDS = {"rule", "helper", //$NON-NLS-1$ //$NON-NLS-2$
			"from", "to", "do", "using", "module",}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

	/** Observed document. */
	private IDocument document;

	/**
	 * Configures the IDocument for this helper.
	 * 
	 * @param document the current document
	 */
	public void setDocument(IDocument document) {
		this.document = document;
	}

	/**
	 * Computes the document part to analyze, process the analysis.
	 * 
	 * @param offset the current offset
	 * @param prefix the current prefix
	 * @return an analyser which purposes contextual informations.
	 * @throws BadLocationException
	 */
	public AtlModelAnalyser computeContext(int offset, String prefix) throws BadLocationException {
		// parsed zone computation
		int begin = 0;
		int[] lastParsingKeyWordLocation = getLastKeyWordLocation(offset - prefix.length(), PARSING_KEYWORDS);
		begin = lastParsingKeyWordLocation[0];
		String lastParsingKeyWord = null;
		if (begin > 0) {
			lastParsingKeyWord = document.get(lastParsingKeyWordLocation[0], lastParsingKeyWordLocation[1]);
			// take the line from beginning
			int lineNumber = document.getLineOfOffset(begin);
			begin = document.getLineOffset(lineNumber);
		}
		int end = offset;

		// gets the zone and correct it
		String text = document.get(begin, end - begin);
		if (prefix.equals("")) { //$NON-NLS-1$
			text += "a"; //$NON-NLS-1$
		} else if (prefix.startsWith("'")) { //$NON-NLS-1$
			text += "'"; //$NON-NLS-1$
		}

		// if no context available, don't process parsing
		if (lastParsingKeyWord == null) {
			return new AtlModelAnalyser(this, null, begin, getLastKeyWord(offset - prefix.length()), offset);
		}

		// code fragment parsing
		EObject[] ret = AtlParser.getDefault().parseExpression(text, lastParsingKeyWord, true);
		AtlModelAnalyser res = new AtlModelAnalyser(this, ret[0], begin, getLastKeyWord(offset
				- prefix.length()), offset);

		return res;
	}

	/**
	 * Compute the right offset from an element, according to the base offset of the model.
	 * 
	 * @param element the given element
	 * @param baseOffset the base offset
	 * @return [deboffset, endoffset]
	 * @throws BadLocationException
	 */
	public int[] getElementOffsets(EObject element, int baseOffset) throws BadLocationException {
		Object loc = AtlCompletionDataSource.eGet(element, "location"); //$NON-NLS-1$
		if (loc != null) {
			String location = loc.toString();
			location = location.replaceAll("'", ""); //$NON-NLS-1$ //$NON-NLS-2$
			int linesToAdd = document.getLineOfOffset(baseOffset);
			int columnsToAdd = baseOffset - document.getLineOffset(document.getLineOfOffset(baseOffset));
			int debLine = new Integer(location.split("-")[0].split(":")[0]).intValue() + linesToAdd; //$NON-NLS-1$ //$NON-NLS-2$
			int debColumn = new Integer(location.split("-")[0].split(":")[1]).intValue() + columnsToAdd; //$NON-NLS-1$ //$NON-NLS-2$
			int endLine = new Integer(location.split("-")[1].split(":")[0]).intValue() + linesToAdd; //$NON-NLS-1$ //$NON-NLS-2$
			int endColumn = new Integer(location.split("-")[1].split(":")[1]).intValue() + columnsToAdd; //$NON-NLS-1$ //$NON-NLS-2$
			int debOffset = document.getLineOffset(debLine - 1) + debColumn - 1;
			int endOffset = document.getLineOffset(endLine - 1) + endColumn - 1;
			return new int[] {debOffset, endOffset};

		}
		return null;
	}

	/**
	 * Extracts the prefix of the last typed characters.
	 * 
	 * @param offset the current offset
	 * @return the prefix of the last word
	 */
	public String extractPrefix(int offset) {
		int i = offset;
		if (i > document.getLength()) {
			return ""; //$NON-NLS-1$
		}
		try {
			while (i > 0) {
				char ch = document.getChar(i - 1);
				if (Character.isWhitespace(ch)) {
					break;
				}
				i--;
			}
			return document.get(i, offset - i);
		} catch (BadLocationException e) {
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * Compute the whole line of the current offset.
	 * 
	 * @param offset the current offset
	 * @return the line containing the offset, ended with the offset
	 * @throws BadLocationException
	 */
	public String getCurrentLine(int offset) throws BadLocationException {
		if (offset >= 0) {
			int lineNumber = document.getLineOfOffset(offset);
			int lineOffset = document.getLineOffset(lineNumber);
			return document.get(lineOffset, offset - lineOffset);
		}
		return null;
	}

	/**
	 * Retrieves the last typed keyword.
	 * 
	 * @param offset the current offset
	 * @return the last typed keyword
	 */
	public String getLastKeyWord(int offset) throws BadLocationException {
		int[] location = getLastKeyWordLocation(offset, HIGH_LEVEL_KEYWORDS);
		if (location[0] > 0) {
			return document.get(location[0], location[1]);
		}
		return null;
	}

	private int[] getLastKeyWordLocation(int offset, String[] keywords) throws BadLocationException {
		int bestindex = 0;
		String nearestKeyword = ""; //$NON-NLS-1$
		for (int i = 0; i < keywords.length; i++) {
			String keyword = keywords[i];
			int lastindex = getLastKeyWordLocation(offset, keyword)[0];
			if (lastindex > 0 && lastindex > bestindex) {
				bestindex = lastindex;
				nearestKeyword = keyword;
			}
		}
		return new int[] {bestindex, nearestKeyword.length()};
	}

	private int[] getLastKeyWordLocation(int offset, String keyword) throws BadLocationException {
		int lastindex = document.get().lastIndexOf(keyword, offset - 1);
		String line = getCurrentLine(lastindex);
		if (line != null) {
			if (line.indexOf("--") > -1) { //$NON-NLS-1$
				return getLastKeyWordLocation(document.get().lastIndexOf("--", offset - 1), keyword); //$NON-NLS-1$
			}
		}
		return new int[] {lastindex, keyword.length()};
	}
}
