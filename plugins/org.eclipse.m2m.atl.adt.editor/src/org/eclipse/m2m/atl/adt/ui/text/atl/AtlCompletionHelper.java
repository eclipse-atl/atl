/*******************************************************************************
 * Copyright (c) 2007, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - completion system
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.m2m.atl.engine.parser.AtlParser;

/**
 * The completion helper, dedicated to document parsing.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlCompletionHelper {

	/** ATL parsing triggers. */
	public static final String[] PARSING_KEYWORDS = {"rule", "helper", "query"}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

	/** Context indicators. */
	public static final String[] HIGH_LEVEL_KEYWORDS = {"rule", "helper", //$NON-NLS-1$ //$NON-NLS-2$
			"from", "to", "do", "using", "module", "library", "query",}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$

	/** Observed document. */
	private IDocument document;

	/**
	 * Creates a new helper initialized with the given text.
	 * 
	 * @param text
	 *            the text
	 */
	public AtlCompletionHelper(String text) {
		this.document = new Document(text);
	}

	/**
	 * Computes the document part to analyze, process the analysis.
	 * 
	 * @param offset
	 *            the current offset
	 * @param prefix
	 *            the current prefix
	 * @param fileContext
	 *            the current file context
	 * @return an analyser which provides contextual informations
	 * @throws BadLocationException
	 */
	public AtlModelAnalyser computeModelAnalyser(int offset, String prefix, String fileContext)
			throws BadLocationException {
		// parsed zone computation
		int begin;
		int[] lastParsingKeyWordLocation = getLastKeyWordLocation(offset - prefix.length(), PARSING_KEYWORDS);
		String lastParsingKeyWord = null;
		if (lastParsingKeyWordLocation[0] > -1) {
			// take the line from beginning
			int lineNumber = document.getLineOfOffset(lastParsingKeyWordLocation[0]);
			begin = document.getLineOffset(lineNumber);
			lastParsingKeyWord = document.get(lastParsingKeyWordLocation[0], lastParsingKeyWordLocation[1]);
		} else {
			begin = 0;
		}
		int end = offset;

		// gets the zone and correct it
		String text = document.get(begin, end - begin);

		if (text.substring(0, text.length() - prefix.length()).trim().endsWith("->")) { //$NON-NLS-1$
			text = text.substring(0, text.length() - prefix.length()).trim() + "debug()." + prefix; //$NON-NLS-1$
		}

		if (prefix.equals("")) { //$NON-NLS-1$
			text += "a"; //$NON-NLS-1$
		} else if (prefix.startsWith("'")) { //$NON-NLS-1$
			text += "'"; //$NON-NLS-1$
		}

		String lastKeyword = getLastKeyWord(offset - prefix.length());

		if ("do".equals(lastKeyword)) { //$NON-NLS-1$
			text += ";"; //$NON-NLS-1$
		}

		// if no context available, don't process parsing
		if (lastParsingKeyWord == null) {
			return new AtlModelAnalyser(this, null, begin, fileContext);
		}

		// code fragment parsing
		EObject[] ret = AtlParser.getDefault().parseExpression(text, lastParsingKeyWord);
		return new AtlModelAnalyser(this, ret[0], begin, fileContext);
	}

	/**
	 * Returns the text associated to the given element.
	 * 
	 * @param locatedElement
	 *            the located element
	 * @param baseOffset
	 *            the base offset of the element model
	 * @return the text, as String
	 * @throws BadLocationException
	 */
	public String getText(EObject locatedElement, int baseOffset) throws BadLocationException {
		int[] offset = getElementOffsets(locatedElement, baseOffset);
		if (offset != null) {
			return document.get(offset[0], offset[1] - offset[0]);
		}
		return ""; //$NON-NLS-1$
	}

	/**
	 * Compute the right offset from an element, according to the base offset of the model.
	 * 
	 * @param element
	 *            the given element
	 * @param baseOffset
	 *            the base offset
	 * @return [deboffset, endoffset]
	 * @throws BadLocationException
	 */
	public int[] getElementOffsets(EObject element, int baseOffset) throws BadLocationException {
		String location = getLocation(element);
		if (location != null) {
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
	 * Returns the element location as String.
	 * 
	 * @param element
	 *            the located element
	 * @return the element location as String
	 */
	public static String getLocation(EObject element) {
		EStructuralFeature feature = element.eClass().getEStructuralFeature("location"); //$NON-NLS-1$
		if (feature != null) {
			return (String)element.eGet(feature);
		}
		return null;
	}

	/**
	 * Retrieves the last typed keyword.
	 * 
	 * @param offset
	 *            the current offset
	 * @return the last typed keyword
	 */
	public String getLastKeyWord(int offset) throws BadLocationException {
		int[] location = getLastKeyWordLocation(offset, HIGH_LEVEL_KEYWORDS);
		if (location[0] > -1) {
			return document.get(location[0], location[1]);
		}
		return null;
	}

	/**
	 * Search the nearest element of the given offset.
	 * 
	 * @param root
	 *            the root model
	 * @param offset
	 *            the offset
	 * @param modelOffset
	 *            the root model offset
	 * @return the element
	 * @throws BadLocationException
	 */
	public EObject getLocatedElement(EObject root, int offset, int modelOffset) throws BadLocationException {
		EObject res = null;
		if (root != null) {
			TreeIterator<EObject> ti = root.eResource().getAllContents();
			int maxDebOffset = -1;
			while (ti.hasNext()) {
				EObject object = ti.next();
				int[] elementOffsets = getElementOffsets(object, modelOffset);
				if (elementOffsets != null) {
					if (elementOffsets[0] <= offset && elementOffsets[1] >= offset) {
						if (elementOffsets[0] >= maxDebOffset) {
							maxDebOffset = elementOffsets[0];
							res = object;
						}
					}
				}
			}
		}
		return res;
	}

	private int[] getLastKeyWordLocation(int offset, String[] keywords) throws BadLocationException {
		int i = offset;
		if (document != null && i <= document.getLength()) {
			StringBuffer word = new StringBuffer();
			while (i > -1) {
				if (i == 0 || !isAtlIdentifierPart(document.getChar(i - 1))) {
					for (String keyword : keywords) {
						if (word.toString().equals(keyword)) {
							int lineNumber = document.getLineOfOffset(i);
							int lineOffset = document.getLineOffset(lineNumber);
							String line = document.get(lineOffset, i - lineOffset);
							if (line.indexOf("--") > -1) { //$NON-NLS-1$
								i = document.get().lastIndexOf("--", i); //$NON-NLS-1$
								word = new StringBuffer();
							} else {
								return new int[] {i, keyword.length()};
							}
						}
					}
					word = new StringBuffer();
				} else {
					word.insert(0, document.getChar(i - 1));
				}
				i--;
			}
		}
		return new int[] {-1, 0};
	}

	/**
	 * Checks whether the given char is an ATL identifier part or not.
	 * 
	 * @param ch
	 *            the char
	 * @return <code>true</code> if the given char is an ATL identifier part
	 */
	public static boolean isAtlIdentifierPart(char ch) {
		return !Character.isWhitespace(ch) && ch != '.' && ch != '(' && ch != ')' && ch != '{' && ch != '}'
				&& ch != '.' && ch != ';' && ch != ',' && ch != ':' && ch != '|' && ch != '+' && ch != '-'
				&& ch != '<' && ch != '=' && ch != '>' && ch != '*' && ch != '/';
		// && ch != '!'
	}
}
