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
package org.eclipse.m2m.atl.adt.ui.text;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.m2m.atl.adt.ui.AtlPreferenceConstants;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;

/**
 * Uses the {@link AtlHeuristicScanner}to get the indentation level for a certain position in a document.
 * <p>
 * An instance holds some internal position in the document and is therefore not threadsafe.
 * </p>
 */
public class AtlIndenter {

	/**
	 * The absolute (character-counted) indentation offset for special cases (method defs, array initializers)
	 */
	private int fAlign;

	/** The document being scanned. */
	private IDocument fDocument;

	/** The indentation accumulated by <code>findPreviousIndenationUnit</code>. */
	private int fIndent;

	/** The line of <code>fPosition</code>. */
	private int fLine;

	/** The stateful scanposition for the indentation methods. */
	private int fPosition;

	/** The previous position. */
	private int fPreviousPos;

	/**
	 * The scanner we will use to scan the document. It has to be installed on the same document as the one we
	 * get.
	 */
	private AtlHeuristicScanner fScanner;

	/** The most recent token. */
	private int fToken;

	/**
	 * Creates a new instance.
	 * 
	 * @param document
	 *            the document to scan
	 * @param scanner
	 *            the {@link AtlHeuristicScanner} to be used for scanning the document. It must be installed
	 *            on the same <code>IDocument</code>.
	 */
	public AtlIndenter(IDocument document, AtlHeuristicScanner scanner) {
		Assert.isNotNull(document);
		Assert.isNotNull(scanner);
		fDocument = document;
		fScanner = scanner;
	}

	/**
	 * Computes the indentation at <code>offset</code>.
	 * 
	 * @param offset
	 *            the offset in the document
	 * @return a String which reflects the correct indentation for the line in which offset resides, or
	 *         <code>null</code> if it cannot be determined
	 */
	public StringBuffer computeIndentation(int offset) {
		return computeIndentation(offset, false);
	}

	/**
	 * Computes the indentation at <code>offset</code>.
	 * 
	 * @param offset
	 *            the offset in the document
	 * @param assumeOpeningBrace
	 *            <code>true</code> if an opening brace should be assumed
	 * @return a String which reflects the correct indentation for the line in which offset resides, or
	 *         <code>null</code> if it cannot be determined
	 */
	public StringBuffer computeIndentation(int offset, boolean assumeOpeningBrace) {

		StringBuffer indent = getReferenceIndentation(offset, assumeOpeningBrace);

		// handle special alignment
		if (fAlign != AtlHeuristicScanner.NOT_FOUND) {
			try {
				// a special case has been detected.
				IRegion line = fDocument.getLineInformationOfOffset(fAlign);
				int lineOffset = line.getOffset();
				return createIndent(lineOffset, fAlign);
			} catch (BadLocationException e) {
				return null;
			}
		}

		if (indent == null)
			return null;

		// add additional indent
		indent.append(createIndent(fIndent));
		if (fIndent < 0)
			unindent(indent);

		return indent;
	}

	/**
	 * Creates a string that represents one indent (can be spaces or tabs..)
	 * 
	 * @return one indentation
	 */
	private StringBuffer createIndent() {
		// get a sensible default when running without the infrastructure for testing
		StringBuffer oneIndent = new StringBuffer();
		IPreferenceStore preferenceStore = AtlUIPlugin.getDefault().getPreferenceStore();
		if (preferenceStore.getBoolean(AtlPreferenceConstants.TYPING_SPACES_FOR_TABS)) {
			int length = preferenceStore.getInt(AtlPreferenceConstants.APPEARANCE_TAB_WIDTH);
			for (int i = 0; i < length; ++i)
				oneIndent.append(' ');
		} else
			oneIndent.append('\t'); // default
		return oneIndent;
	}

	/**
	 * Creates a string that represents the given number of indents (can be spaces or tabs..)
	 * 
	 * @param indent
	 *            the requested indentation level.
	 * @return the indentation specified by <code>indent</code>
	 */
	private StringBuffer createIndent(int indent) {
		StringBuffer oneIndent = createIndent();

		StringBuffer ret = new StringBuffer();
		while (indent-- > 0)
			ret.append(oneIndent);

		return ret;
	}

	/**
	 * Creates an indentation string of the length indent - start + 1, consisting of the content in
	 * <code>fDocument</code> in the range [start, indent), with every character replaced by a space except
	 * for tabs, which are kept as such.
	 * <p>
	 * Every run of the number of spaces that make up a tab are replaced by a tab character.
	 * </p>
	 * 
	 * @return the indentation corresponding to the document content specified by <code>start</code> and
	 *         <code>indent</code>
	 */
	private StringBuffer createIndent(int start, int indent) {
		final int tabLen = prefTabLength();
		StringBuffer ret = new StringBuffer();
		try {
			int spaces = 0;
			while (start < indent) {

				char ch = fDocument.getChar(start);
				if (ch == '\t') {
					ret.append('\t');
					spaces = 0;
				} else if (tabLen == -1) {
					ret.append(' ');
				} else {
					spaces++;
					if (spaces == tabLen) {
						ret.append('\t');
						spaces = 0;
					}
				}

				start++;
			}
			// remainder
			if (spaces == tabLen)
				ret.append('\t');
			else
				while (spaces-- > 0)
					ret.append(' ');

		} catch (BadLocationException e) {
		}

		return ret;
	}

	/**
	 * Returns the reference position regarding to indentation for <code>offset</code>, or
	 * <code>NOT_FOUND</code>. This method calls {@link #findReferencePosition(int, int)
	 * findReferencePosition(offset, nextChar)} where <code>nextChar</code> is the next character after
	 * <code>offset</code>.
	 * 
	 * @param offset
	 *            the offset for which the reference is computed
	 * @return the reference statement relative to which <code>offset</code> should be indented, or
	 *         {@link AtlHeuristicScanner#NOT_FOUND}
	 */
	public int findReferencePosition(int offset) {
		return findReferencePosition(offset, peekChar(offset));
	}

	/**
	 * Returns the reference position regarding to indentation for <code>position</code>, or
	 * <code>NOT_FOUND</code>.<code>fIndent</code> will contain the relative indentation (in indentation
	 * units, not characters) after the call. If there is a special alignment (e.g. for a method declaration
	 * where parameters should be aligned), <code>fAlign</code> will contain the absolute position of the
	 * alignment reference in <code>fDocument</code>, otherwise <code>fAlign</code> is set to
	 * <code>AtlHeuristicScanner.NOT_FOUND</code>.
	 * 
	 * @param offset
	 *            the offset for which the reference is computed
	 * @param danglingElse
	 *            whether a dangling else should be assumed at <code>position</code>
	 * @param matchBrace
	 *            whether the position of the matching brace should be returned instead of doing code analysis
	 * @param matchParen
	 *            whether the position of the matching parenthesis should be returned instead of doing code
	 *            analysis
	 * @param matchCase
	 *            whether the position of a switch statement reference should be returned (either an earlier
	 *            case statement or the switch block brace)
	 * @return the reference statement relative to which <code>position</code> should be indented, or
	 *         {@link AtlHeuristicScanner#NOT_FOUND}
	 */
	public int findReferencePosition(int offset, boolean danglingElse, boolean matchBrace,
			boolean matchParen, boolean matchCase) {
		fIndent = 0; // the indentation modification
		fAlign = AtlHeuristicScanner.NOT_FOUND;
		fPosition = offset;

		// forward cases
		// an unindentation happens sometimes if the next token is special, namely on braces, parens and case
		// labels
		// align braces, but handle the case where we align with the method declaration start instead of
		// the opening brace.
		if (matchBrace) {
			if (skipScope(Symbols.TOKEN_LBRACE, Symbols.TOKEN_RBRACE)) {
				try {
					// align with the opening brace that is on a line by its own
					int lineOffset = fDocument.getLineOffset(fLine);
					if (lineOffset <= fPosition
							&& fDocument.get(lineOffset, fPosition - lineOffset).trim().length() == 0)
						return fPosition;
				} catch (BadLocationException e) {
					// concurrent modification - walk default path
				}
				// if the opening brace is not on the start of the line, skip to the start
				int pos = skipToStatementStart(true, true);
				fIndent = 0; // indent is aligned with reference position
				return pos;
			} else {
				// if we can't find the matching brace, the heuristic is to unindent
				// by one against the normal position
				int pos = findReferencePosition(offset, danglingElse, false, matchParen, matchCase);
				fIndent--;
				return pos;
			}
		}

		// align parenthesis'
		if (matchParen) {
			if (skipScope(Symbols.TOKEN_LPAREN, Symbols.TOKEN_RPAREN))
				return fPosition;
			else {
				// if we can't find the matching paren, the heuristic is to unindent
				// by one against the normal position
				int pos = findReferencePosition(offset, danglingElse, matchBrace, false, matchCase);
				fIndent--;
				return pos;
			}
		}

		// the only reliable way to get case labels aligned (due to many different styles of using braces in a
		// block)
		// is to go for another case statement, or the scope opening brace
		if (matchCase) {
			return matchCaseAlignment();
		}

		nextToken();
		switch (fToken) {
			case Symbols.TOKEN_RBRACE:
				// skip the block and fall through
				// if we can't complete the scope, reset the scan position
				int pos = fPosition;
				if (!skipScope()) {
					fPosition = pos;
				}
			case Symbols.TOKEN_SEMICOLON:
				// this is the 90% case: after a statement block
				// the end of the previous statement / block previous.end
				// search to the end of the statement / block before the previous; the token just after that
				// is previous.start
				return skipToStatementStart(danglingElse, false);

				// scope introduction: special treat who special is
			case Symbols.TOKEN_LPAREN:
			case Symbols.TOKEN_LBRACE:
			case Symbols.TOKEN_LBRACKET:
				return handleScopeIntroduction(offset + 1);

			case Symbols.TOKEN_EOF:
				// trap when hitting start of document
				return 0;

			case Symbols.TOKEN_EQUAL:
				// indent assignments
				fIndent = prefAssignmentIndent();
				return fPosition;

			case Symbols.TOKEN_COLON:
				// TODO handle ternary deep indentation
				fIndent = prefCaseBlockIndent();
				return fPosition;

			case Symbols.TOKEN_QUESTIONMARK:
				if (prefTernaryDeepAlign()) {
					setFirstElementAlignment(fPosition, offset + 1);
					return fPosition;
				} else {
					fIndent = prefTernaryIndent();
					return fPosition;
				}

				// indentation for blockless introducers:
			case Symbols.TOKEN_DO:
			case Symbols.TOKEN_WHILE:
			case Symbols.TOKEN_ELSE:
				fIndent = prefSimpleIndent();
				return fPosition;
			case Symbols.TOKEN_RPAREN:
				int line = fLine;
				if (skipScope(Symbols.TOKEN_LPAREN, Symbols.TOKEN_RPAREN)) {
					int scope = fPosition;
					nextToken();
					if (fToken == Symbols.TOKEN_IF || fToken == Symbols.TOKEN_WHILE
							|| fToken == Symbols.TOKEN_FOR) {
						fIndent = prefSimpleIndent();
						return fPosition;
					}
					fPosition = scope;
					if (looksLikeMethodDecl()) {
						return skipToStatementStart(danglingElse, false);
					}
				}
				// restore
				fPosition = offset;
				fLine = line;
				// else: fall through to default

			case Symbols.TOKEN_COMMA:
				// inside a list of some type
				// easy if there is already a list item before with its own indentation - we just align
				// if not: take the start of the list ( LPAREN, LBRACE, LBRACKET ) and either align or
				// indent by list-indent
			default:
				// inside whatever we don't know about: similar to the list case:
				// if we are inside a continued expression, then either align with a previous line that has
				// indentation
				// or indent from the expression start line (either a scope introducer or the start of the
				// expr).
				return skipToPreviousListItemOrListStart();

		}
	}

	/**
	 * Returns the reference position regarding to indentation for <code>position</code>, or
	 * <code>NOT_FOUND</code>.
	 * <p>
	 * If <code>peekNextChar</code> is <code>true</code>, the next token after <code>offset</code> is read and
	 * taken into account when computing the indentation. Currently, if the next token is the first token on
	 * the line (i.e. only preceded by whitespace), the following tokens are specially handled:
	 * <ul>
	 * <li><code>switch</code> labels are indented relative to the switch block</li>
	 * <li>opening curly braces are aligned correctly with the introducing code</li>
	 * <li>closing curly braces are aligned properly with the introducing code of the matching opening brace</li>
	 * <li>closing parenthesis' are aligned with their opening peer</li>
	 * <li>the <code>else</code> keyword is aligned with its <code>if</code>, anything else is aligned
	 * normally (i.e. with the base of any introducing statements).</li>
	 * <li>if there is no token on the same line after <code>offset</code>, the indentation is the same as for
	 * an <code>else</code> keyword</li>
	 * </ul>
	 * 
	 * @param offset
	 *            the offset for which the reference is computed
	 * @param nextToken
	 *            the next token to assume in the document
	 * @return the reference statement relative to which <code>offset</code> should be indented, or
	 *         {@link AtlHeuristicScanner#NOT_FOUND}
	 */
	public int findReferencePosition(int offset, int nextToken) {
		boolean danglingElse = false;
		boolean unindent = false;
		boolean indent = false;
		boolean matchBrace = false;
		boolean matchParen = false;
		boolean matchCase = false;

		// account for unindenation characters already typed in, but after position
		// if they are on a line by themselves, the indentation gets adjusted
		// accordingly
		//
		// also account for a dangling else
		if (offset < fDocument.getLength()) {
			try {
				IRegion line = fDocument.getLineInformationOfOffset(offset);
				int lineOffset = line.getOffset();
				int prevPos = Math.max(offset - 1, 0);
				boolean isFirstTokenOnLine = fDocument.get(lineOffset, prevPos + 1 - lineOffset).trim()
						.length() == 0;
				int prevToken = fScanner.previousToken(prevPos, AtlHeuristicScanner.UNBOUND);
				boolean bracelessBlockStart = fScanner.isBracelessBlockStart(prevPos,
						AtlHeuristicScanner.UNBOUND);

				switch (nextToken) {
					case Symbols.TOKEN_EOF:
					case Symbols.TOKEN_ELSE:
						danglingElse = true;
						break;
					case Symbols.TOKEN_CASE:
					case Symbols.TOKEN_DEFAULT:
						if (isFirstTokenOnLine) {
							matchCase = true;
						}
						break;
					case Symbols.TOKEN_LBRACE: // for opening-brace-on-new-line style
						if (bracelessBlockStart && !prefIndentBracesForBlocks()) {
							unindent = true;
						} else if ((prevToken == Symbols.TOKEN_COLON || prevToken == Symbols.TOKEN_EQUAL || prevToken == Symbols.TOKEN_RBRACKET)
								&& !prefIndentBracesForArrays()) {
							unindent = true;
						} else if (!bracelessBlockStart && prefIndentBracesForMethods()) {
							indent = true;
						}
						break;
					case Symbols.TOKEN_RBRACE: // closing braces get unindented
						if (isFirstTokenOnLine) {
							matchBrace = true;
						}
						break;
					case Symbols.TOKEN_RPAREN:
						if (isFirstTokenOnLine) {
							matchParen = true;
						}
						break;
				}
			} catch (BadLocationException e) {
			}
		} else {
			// assume an else could come if we are at the end of file
			danglingElse = true;
		}

		int ref = findReferencePosition(offset, danglingElse, matchBrace, matchParen, matchCase);
		if (unindent) {
			fIndent--;
		}
		if (indent) {
			fIndent++;
		}
		return ref;
	}

	/**
	 * Returns the indentation of the line at <code>offset</code> as a <code>StringBuffer</code>. If the
	 * offset is not valid, the empty string is returned.
	 * 
	 * @param offset
	 *            the offset in the document
	 * @return the indentation (leading whitespace) of the line in which <code>offset</code> is located
	 */
	private StringBuffer getLeadingWhitespace(int offset) {
		StringBuffer indent = new StringBuffer();
		try {
			IRegion line = fDocument.getLineInformationOfOffset(offset);
			int lineOffset = line.getOffset();
			int nonWS = fScanner.findNonWhitespaceForwardInAnyPartition(lineOffset, lineOffset
					+ line.getLength());
			indent.append(fDocument.get(lineOffset, nonWS - lineOffset));
			return indent;
		} catch (BadLocationException e) {
			return indent;
		}
	}

	/**
	 * Computes the indentation at the reference point of <code>position</code>.
	 * 
	 * @param offset
	 *            the offset in the document
	 * @return a String which reflects the indentation at the line in which the reference position to
	 *         <code>offset</code> resides, or <code>null</code> if it cannot be determined
	 */
	public StringBuffer getReferenceIndentation(int offset) {
		return getReferenceIndentation(offset, false);
	}

	/**
	 * Computes the indentation at the reference point of <code>position</code>.
	 * 
	 * @param offset
	 *            the offset in the document
	 * @param assumeOpeningBrace
	 *            <code>true</code> if an opening brace should be assumed
	 * @return a String which reflects the indentation at the line in which the reference position to
	 *         <code>offset</code> resides, or <code>null</code> if it cannot be determined
	 */
	private StringBuffer getReferenceIndentation(int offset, boolean assumeOpeningBrace) {

		int unit;
		if (assumeOpeningBrace) {
			unit = findReferencePosition(offset, Symbols.TOKEN_LBRACE);
		} else {
			unit = findReferencePosition(offset, peekChar(offset));
		}

		// if we were unable to find anything, return null
		if (unit == AtlHeuristicScanner.NOT_FOUND) {
			return null;
		}

		return getLeadingWhitespace(unit);

	}

	/**
	 * Handles the introduction of a new scope. The current token must be one out of
	 * <code>Symbols.TOKEN_LPAREN</code>, <code>Symbols.TOKEN_LBRACE</code>, and
	 * <code>Symbols.TOKEN_LBRACKET</code>. Returns as the reference position either the token introducing the
	 * scope or - if available - the first Atl token after that.
	 * <p>
	 * Depending on the type of scope introduction, the indentation will align (deep indenting) with the
	 * reference position (<code>fAlign</code> will be set to the reference position) or <code>fIndent</code>
	 * will be set to the number of indentation units.
	 * </p>
	 * 
	 * @param bound
	 *            the bound for the search for the first token after the scope introduction.
	 * @return
	 */
	private int handleScopeIntroduction(int bound) {
		switch (fToken) {
			// scope introduction: special treat who special is
			case Symbols.TOKEN_LPAREN:
				int pos = fPosition; // store

				// special: method declaration deep indentation
				if (looksLikeMethodDecl()) {
					if (prefMethodDeclDeepIndent())
						return setFirstElementAlignment(pos, bound);
					else {
						fIndent = prefMethodDeclIndent();
						return pos;
					}
				} else {
					fPosition = pos;
					if (looksLikeMethodCall()) {
						if (prefMethodCallDeepIndent())
							return setFirstElementAlignment(pos, bound);
						else {
							fIndent = prefMethodCallIndent();
							return pos;
						}
					} else if (prefParenthesisDeepIndent())
						return setFirstElementAlignment(pos, bound);
				}

				// normal: return the parenthesis as reference
				fIndent = prefParenthesisIndent();
				return pos;

			case Symbols.TOKEN_LBRACE:
				pos = fPosition; // store

				// special: array initializer
				if (looksLikeArrayInitializerIntro())
					if (prefArrayDeepIndent())
						return setFirstElementAlignment(pos, bound);
					else
						fIndent = prefArrayIndent();
				else
					fIndent = prefBlockIndent();

				// normal: skip to the statement start before the scope introducer
				// opening braces are often on differently ending indents than e.g. a method definition
				fPosition = pos; // restore
				return skipToStatementStart(true, true); // set to true to match the first if

			case Symbols.TOKEN_LBRACKET:
				pos = fPosition; // store

				// special: method declaration deep indentation
				if (prefArrayDimensionsDeepIndent()) {
					return setFirstElementAlignment(pos, bound);
				}

				// normal: return the bracket as reference
				fIndent = prefBracketIndent();
				return pos; // restore

			default:
				Assert.isTrue(false);
				return -1; // dummy
		}
	}

	/**
	 * while(condition); is ambiguous when parsed backwardly, as it is a valid statement by its own, so we
	 * have to check whether there is a matching do. A <code>do</code> can either be separated from the while
	 * by a block, or by a single statement, which limits our search distance.
	 * 
	 * @return <code>true</code> if the <code>while</code> currently in <code>fToken</code> has a matching
	 *         <code>do</code>.
	 */
	private boolean hasMatchingDo() {
		Assert.isTrue(fToken == Symbols.TOKEN_WHILE);
		nextToken();
		switch (fToken) {
			case Symbols.TOKEN_RBRACE:
				skipScope(); // and fall thru
			case Symbols.TOKEN_SEMICOLON:
				skipToStatementStart(false, false);
				return fToken == Symbols.TOKEN_DO;
		}
		return false;
	}

	/**
	 * Returns true if the colon at the current position is part of a conditional (ternary) expression, false
	 * otherwise.
	 * 
	 * @return true if the colon at the current position is part of a conditional
	 */
	private boolean isConditional() {
		while (true) {
			nextToken();
			switch (fToken) {

				// search for case, otherwise return true
				case Symbols.TOKEN_IDENT:
					continue;
				case Symbols.TOKEN_CASE:
					return false;

				default:
					return true;
			}
		}
	}

	/**
	 * Returns <code>true</code> if the next token received after calling <code>nextToken</code> is either an
	 * equal sign or an array designator ('[]').
	 * 
	 * @return <code>true</code> if the next elements look like the start of an array definition
	 */
	private boolean looksLikeArrayInitializerIntro() {
		nextToken();
		if (fToken == Symbols.TOKEN_EQUAL || skipBrackets()) {
			return true;
		}
		return false;
	}

	/**
	 * Returns <code>true</code> if the current tokens look like a method call header (i.e. an identifier as
	 * opposed to a keyword taking parenthesized parameters such as <code>if</code>).
	 * <p>
	 * The heuristic calls <code>nextToken</code> and expects an identifier (method name).
	 * 
	 * @return <code>true</code> if the current position looks like a method call header.
	 */
	private boolean looksLikeMethodCall() {
		nextToken();
		return fToken == Symbols.TOKEN_IDENT; // method name
	}

	/**
	 * Returns <code>true</code> if the current tokens look like a method declaration header (i.e. only the
	 * return type and method name). The heuristic calls <code>nextToken</code> and expects an identifier
	 * (method name) and a type declaration (an identifier with optional brackets) which also covers the
	 * visibility modifier of constructors; it does not recognize package visible constructors.
	 * 
	 * @return <code>true</code> if the current position looks like a method declaration header.
	 */
	private boolean looksLikeMethodDecl() {
		/*
		 * TODO This heuristic does not recognize package private constructors since those do have neither
		 * type nor visibility keywords. One option would be to go over the parameter list, but that might be
		 * empty as well - hard to do without an AST...
		 */

		nextToken();
		if (fToken == Symbols.TOKEN_IDENT) { // method name
			do {
				nextToken();
			} while (skipBrackets()); // optional brackets for array valued return types
			return fToken == Symbols.TOKEN_IDENT; // type name

		}
		return false;
	}

	/**
	 * Returns as a reference any previous <code>switch</code> labels (<code>case</code> or
	 * <code>default</code>) or the offset of the brace that scopes the switch statement. Sets
	 * <code>fIndent</code> to <code>prefCaseIndent</code> upon a match.
	 * 
	 * @return the reference offset for a <code>switch</code> label
	 */
	private int matchCaseAlignment() {
		while (true) {
			nextToken();
			switch (fToken) {
				// invalid cases: another case label or an LBRACE must come before a case
				// -> bail out with the current position
				case Symbols.TOKEN_LPAREN:
				case Symbols.TOKEN_LBRACKET:
				case Symbols.TOKEN_EOF:
					return fPosition;
				case Symbols.TOKEN_LBRACE:
					// opening brace of switch statement
					fIndent = prefCaseIndent();
					return fPosition;
				case Symbols.TOKEN_CASE:
				case Symbols.TOKEN_DEFAULT:
					// align with previous label
					fIndent = 0;
					return fPosition;

					// scopes: skip them
				case Symbols.TOKEN_RPAREN:
				case Symbols.TOKEN_RBRACKET:
				case Symbols.TOKEN_RBRACE:
					skipScope();
					break;

				default:
					// keep searching
					continue;

			}
		}
	}

	/**
	 * Reads the next token in backward direction from the heuristic scanner and sets the fields
	 * <code>fToken, fPreviousPosition</code> and <code>fPosition</code> accordingly.
	 */
	private void nextToken() {
		nextToken(fPosition);
	}

	/**
	 * Reads the next token in backward direction of <code>start</code> from the heuristic scanner and sets
	 * the fields <code>fToken, fPreviousPosition</code> and <code>fPosition</code> accordingly.
	 */
	private void nextToken(int start) {
		fToken = fScanner.previousToken(start - 1, AtlHeuristicScanner.UNBOUND);
		fPreviousPos = start;
		fPosition = fScanner.getPosition() + 1;
		try {
			fLine = fDocument.getLineOfOffset(fPosition);
		} catch (BadLocationException e) {
			fLine = -1;
		}
	}

	/**
	 * Peeks the next char in the document that comes after <code>offset</code> on the same line as
	 * <code>offset</code>.
	 * 
	 * @param offset
	 *            the offset into document
	 * @return the token symbol of the next element, or TokenEOF if there is none
	 */
	private int peekChar(int offset) {
		if (offset < fDocument.getLength()) {
			try {
				IRegion line = fDocument.getLineInformationOfOffset(offset);
				int lineOffset = line.getOffset();
				int next = fScanner.nextToken(offset, lineOffset + line.getLength());
				return next;
			} catch (BadLocationException e) {
			}
		}
		return Symbols.TOKEN_EOF;
	}

	private boolean prefArrayDeepIndent() {
		// TODO gets preferences from code formatter
		// Plugin plugin= JavaCore.getPlugin();
		// if (plugin != null) {
		// String option=
		// JavaCore.getOption(DefaultCodeFormatterConstants.
		// FORMATTER_ALIGNMENT_FOR_EXPRESSIONS_IN_ARRAY_INITIALIZER);
		// try {
		// return DefaultCodeFormatterConstants.getIndentStyle(option) ==
		// DefaultCodeFormatterConstants.INDENT_ON_COLUMN;
		// } catch (IllegalArgumentException e) {
		// // ignore and return default
		// }
		// }
		return true;
	}

	private boolean prefArrayDimensionsDeepIndent() {
		return true; // sensible default
	}

	private int prefArrayIndent() {
		// TODO gets preferences from code formatter
		// Plugin plugin= AtlCore.getPlugin();
		// if (plugin != null) {
		// String option=
		// AtlCore.getOption(DefaultCodeFormatterConstants.
		// FORMATTER_ALIGNMENT_FOR_EXPRESSIONS_IN_ARRAY_INITIALIZER);
		// try {
		// if (DefaultCodeFormatterConstants.getIndentStyle(option) ==
		// DefaultCodeFormatterConstants.INDENT_BY_ONE)
		// return 1;
		// } catch (IllegalArgumentException e) {
		// // ignore and return default
		// }
		// }
		return prefContinuationIndent(); // default
	}

	private int prefAssignmentIndent() {
		return prefBlockIndent();
	}

	private int prefBlockIndent() {
		return 1; // sensible default
	}

	private int prefBracketIndent() {
		return prefBlockIndent();
	}

	private int prefCaseBlockIndent() {
		// TODO gets preferences from code formatter
		// Plugin plugin= AtlCore.getPlugin();
		// if (plugin != null) {
		// if
		// (DefaultCodeFormatterConstants.TRUE.equals(AtlCore.getOption(DefaultCodeFormatterConstants.
		// FORMATTER_INDENT_SWITCHSTATEMENTS_COMPARE_TO_CASES)))
		// return prefBlockIndent();
		// else
		// return 0;
		// }
		return prefBlockIndent(); // sun standard
	}

	private int prefCaseIndent() {
		// TODO gets preferences from code formatter
		// Plugin plugin= AtlCore.getPlugin();
		// if (plugin != null) {
		// if
		// (DefaultCodeFormatterConstants.TRUE.equals(AtlCore.getOption(DefaultCodeFormatterConstants.
		// FORMATTER_INDENT_SWITCHSTATEMENTS_COMPARE_TO_SWITCH)))
		// return prefBlockIndent();
		// else
		// return 0;
		// }
		return 0; // sun standard
	}

	private int prefContinuationIndent() {
		// TODO gets preferences from code formatter
		// Plugin plugin= AtlCore.getPlugin();
		// if (plugin != null) {
		// String option= AtlCore.getOption(DefaultCodeFormatterConstants.FORMATTER_CONTINUATION_INDENTATION);
		// try {
		// return Integer.parseInt(option);
		// } catch (NumberFormatException e) {
		// // ignore and return default
		// }
		// }
		return 2; // sensible default
	}

	private boolean prefIndentBracesForArrays() {
		// TODO gets preferences from code formatter
		// Plugin plugin= AtlCore.getPlugin();
		// if (plugin != null) {
		// String option=
		// AtlCore.getOption(DefaultCodeFormatterConstants.FORMATTER_BRACE_POSITION_FOR_ARRAY_INITIALIZER);
		// return option.equals(DefaultCodeFormatterConstants.NEXT_LINE_SHIFTED);
		// }
		return false; // sensible default
	}

	private boolean prefIndentBracesForBlocks() {
		// TODO gets preferences from code formatter
		// Plugin plugin= AtlCore.getPlugin();
		// if (plugin != null) {
		// String option= AtlCore.getOption(DefaultCodeFormatterConstants.FORMATTER_BRACE_POSITION_FOR_BLOCK);
		// return option.equals(DefaultCodeFormatterConstants.NEXT_LINE_SHIFTED);
		// }
		return false; // sensible default
	}

	private boolean prefIndentBracesForMethods() {
		// TODO gets preferences from code formatter
		// Plugin plugin= AtlCore.getPlugin();
		// if (plugin != null) {
		// String option=
		// AtlCore.getOption(DefaultCodeFormatterConstants.FORMATTER_BRACE_POSITION_FOR_METHOD_DECLARATION);
		// return option.equals(DefaultCodeFormatterConstants.NEXT_LINE_SHIFTED);
		// }
		return false; // sensible default
	}

	private boolean prefMethodCallDeepIndent() {
		// TODO gets preferences from code formatter
		// Plugin plugin= AtlCore.getPlugin();
		// if (plugin != null) {
		// String option=
		// AtlCore.getOption(DefaultCodeFormatterConstants.
		// FORMATTER_ALIGNMENT_FOR_ARGUMENTS_IN_METHOD_INVOCATION);
		// try {
		// return DefaultCodeFormatterConstants.getIndentStyle(option) ==
		// DefaultCodeFormatterConstants.INDENT_ON_COLUMN;
		// } catch (IllegalArgumentException e) {
		// // ignore and return default
		// }
		// }
		return false; // sensible default
	}

	private int prefMethodCallIndent() {
		// TODO gets preferences from code formatter
		// Plugin plugin= AtlCore.getPlugin();
		// if (plugin != null) {
		// String option=
		// AtlCore.getOption(DefaultCodeFormatterConstants.
		// FORMATTER_ALIGNMENT_FOR_ARGUMENTS_IN_METHOD_INVOCATION);
		// try {
		// if (DefaultCodeFormatterConstants.getIndentStyle(option) ==
		// DefaultCodeFormatterConstants.INDENT_BY_ONE)
		// return 1;
		// else
		// return prefContinuationIndent();
		// } catch (IllegalArgumentException e) {
		// // ignore and return default
		// }
		// }
		return 1; // sensible default
	}

	private boolean prefMethodDeclDeepIndent() {
		// TODO gets preferences from code formatter
		// Plugin plugin= AtlCore.getPlugin();
		// if (plugin != null) {
		// String option=
		// AtlCore.getOption(DefaultCodeFormatterConstants.
		// FORMATTER_ALIGNMENT_FOR_PARAMETERS_IN_METHOD_DECLARATION);
		// try {
		// return DefaultCodeFormatterConstants.getIndentStyle(option) ==
		// DefaultCodeFormatterConstants.INDENT_ON_COLUMN;
		// } catch (IllegalArgumentException e) {
		// // ignore and return default
		// }
		// }
		return true;
	}

	private int prefMethodDeclIndent() {
		// TODO gets preferences from code formatter
		// Plugin plugin= AtlCore.getPlugin();
		// if (plugin != null) {
		// String option=
		// AtlCore.getOption(DefaultCodeFormatterConstants.
		// FORMATTER_ALIGNMENT_FOR_PARAMETERS_IN_METHOD_DECLARATION);
		// try {
		// if (DefaultCodeFormatterConstants.getIndentStyle(option) ==
		// DefaultCodeFormatterConstants.INDENT_BY_ONE)
		// return 1;
		// else
		// return prefContinuationIndent();
		// } catch (IllegalArgumentException e) {
		// // ignore and return default
		// }
		// }
		return 1;
	}

	private boolean prefParenthesisDeepIndent() {
		// don't do parenthesis deep indentation
		// TODO gets preferences from code formatter
		// Plugin plugin= AtlCore.getPlugin();
		// if (plugin != null) {
		// String option= AtlCore.getOption(DefaultCodeFormatterConstants.FORMATTER_CONTINUATION_INDENTATION);
		// try {
		// return DefaultCodeFormatterConstants.getIndentStyle(option) ==
		// DefaultCodeFormatterConstants.INDENT_ON_COLUMN;
		// } catch (IllegalArgumentException e) {
		// // ignore and return default
		// }
		// }
		return false;
	}

	private int prefParenthesisIndent() {
		return prefContinuationIndent();
	}

	private int prefSimpleIndent() {
		return prefBlockIndent();
	}

	// TODO adjust once there are per-project settings

	private int prefTabLength() {
		int tabLen;
		AtlUIPlugin plugin = AtlUIPlugin.getDefault();
		if (plugin != null)
			if (plugin.getPreferenceStore().getBoolean(AtlPreferenceConstants.TYPING_SPACES_FOR_TABS))
				// if the formatter uses chars to mark indentation, then don't substitute any chars
				tabLen = -1; // results in no tabs being substituted for space runs
			else
				// if the formatter uses tabs to mark indentations, use the visual setting from the editor
				// to get nicely aligned indentations
				tabLen = plugin.getPreferenceStore().getInt(AtlPreferenceConstants.APPEARANCE_TAB_WIDTH);
		else
			tabLen = 4; // sensible default for testing

		return tabLen;
	}

	private boolean prefTernaryDeepAlign() {
		// TODO gets preferences from code formatter
		// Plugin plugin= AtlCore.getPlugin();
		// if (plugin != null) {
		// String option=
		// AtlCore.getOption(DefaultCodeFormatterConstants.FORMATTER_ALIGNMENT_FOR_CONDITIONAL_EXPRESSION);
		// try {
		// return DefaultCodeFormatterConstants.getIndentStyle(option) ==
		// DefaultCodeFormatterConstants.INDENT_ON_COLUMN;
		// } catch (IllegalArgumentException e) {
		// // ignore and return default
		// }
		// }
		return false;
	}

	private int prefTernaryIndent() {
		// TODO gets preferences from code formatter
		// Plugin plugin= AtlCore.getPlugin();
		// if (plugin != null) {
		// String option=
		// AtlCore.getOption(DefaultCodeFormatterConstants.FORMATTER_ALIGNMENT_FOR_CONDITIONAL_EXPRESSION);
		// try {
		// if (DefaultCodeFormatterConstants.getIndentStyle(option) ==
		// DefaultCodeFormatterConstants.INDENT_BY_ONE)
		// return 1;
		// else
		// return prefContinuationIndent();
		// } catch (IllegalArgumentException e) {
		// // ignore and return default
		// }
		// }
		return prefContinuationIndent();
	}

	/**
	 * Sets the deep indent offset (<code>fAlign</code>) to either the offset right after
	 * <code>scopeIntroducerOffset</code> or - if available - the first Atl token after
	 * <code>scopeIntroducerOffset</code>, but before <code>bound</code>.
	 * 
	 * @param scopeIntroducerOffset
	 *            the offset of the scope introducer
	 * @param bound
	 *            the bound for the search for another element
	 * @return the reference position
	 */
	private int setFirstElementAlignment(int scopeIntroducerOffset, int bound) {
		int firstPossible = scopeIntroducerOffset + 1; // align with the first position after the scope intro
		fAlign = fScanner.findNonWhitespaceForwardInAnyPartition(firstPossible, bound);
		if (fAlign == AtlHeuristicScanner.NOT_FOUND)
			fAlign = firstPossible;
		return fAlign;
	}

	/**
	 * Skips brackets if the current token is a RBRACKET. There can be nothing but whitespace in between, this
	 * is only to be used for <code>[]</code> elements.
	 * 
	 * @return <code>true</code> if a <code>[]</code> could be scanned, the current token is left at the
	 *         LBRACKET.
	 */
	private boolean skipBrackets() {
		if (fToken == Symbols.TOKEN_RBRACKET) {
			nextToken();
			if (fToken == Symbols.TOKEN_LBRACKET) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Skips over the next <code>if</code> keyword. The current token when calling this method must be an
	 * <code>else</code> keyword. Returns <code>true</code> if a matching <code>if</code> could be found,
	 * <code>false</code> otherwise. The cursor (<code>fPosition</code>) is set to the offset of the
	 * <code>if</code> token.
	 * 
	 * @return <code>true</code> if a matching <code>if</code> token was found, <code>false</code> otherwise
	 */
	private boolean skipNextIF() {
		Assert.isTrue(fToken == Symbols.TOKEN_ELSE);

		while (true) {
			nextToken();
			switch (fToken) {
				// scopes: skip them
				case Symbols.TOKEN_RPAREN:
				case Symbols.TOKEN_RBRACKET:
				case Symbols.TOKEN_RBRACE:
					skipScope();
					break;

				case Symbols.TOKEN_IF:
					// found it, return
					return true;
				case Symbols.TOKEN_ELSE:
					// recursively skip else-if blocks
					skipNextIF();
					break;

				// shortcut scope starts
				case Symbols.TOKEN_LPAREN:
				case Symbols.TOKEN_LBRACE:
				case Symbols.TOKEN_LBRACKET:
				case Symbols.TOKEN_EOF:
					return false;
			}
		}
	}

	/**
	 * Skips a scope and positions the cursor (<code>fPosition</code>) on the token that opens the scope.
	 * Returns <code>true</code> if a matching peer could be found, <code>false</code> otherwise. The current
	 * token when calling must be one out of <code>Symbols.TOKEN_RPAREN</code>,
	 * <code>Symbols.TOKEN_RBRACE</code>, and <code>Symbols.TOKEN_RBRACKET</code>.
	 * 
	 * @return <code>true</code> if a matching peer was found, <code>false</code> otherwise
	 */
	private boolean skipScope() {
		switch (fToken) {
			case Symbols.TOKEN_RPAREN:
				return skipScope(Symbols.TOKEN_LPAREN, Symbols.TOKEN_RPAREN);
			case Symbols.TOKEN_RBRACKET:
				return skipScope(Symbols.TOKEN_LBRACKET, Symbols.TOKEN_RBRACKET);
			case Symbols.TOKEN_RBRACE:
				return skipScope(Symbols.TOKEN_LBRACE, Symbols.TOKEN_RBRACE);
			default:
				Assert.isTrue(false);
				return false;
		}
	}

	/**
	 * Scans tokens for the matching opening peer. The internal cursor (<code>fPosition</code>) is set to the
	 * offset of the opening peer if found.
	 * 
	 * @return <code>true</code> if a matching token was found, <code>false</code> otherwise
	 */
	private boolean skipScope(int openToken, int closeToken) {

		int depth = 1;

		while (true) {
			nextToken();

			if (fToken == closeToken) {
				depth++;
			} else if (fToken == openToken) {
				depth--;
				if (depth == 0) {
					return true;
				}
			} else if (fToken == Symbols.TOKEN_EOF) {
				return false;
			}
		}
	}

	/**
	 * Returns the reference position for a list element. The algorithm tries to match any previous
	 * indentation on the same list. If there is none, the reference position returned is determined depending
	 * on the type of list: The indentation will either match the list scope introducer (e.g. for method
	 * declarations), so called deep indents, or simply increase the indentation by a number of standard
	 * indents. See also {@link #handleScopeIntroduction(int)}.
	 * 
	 * @return the reference position for a list item: either a previous list item that has its own
	 *         indentation, or the list introduction start.
	 */
	private int skipToPreviousListItemOrListStart() {
		int startLine = fLine;
		int startPosition = fPosition;
		while (true) {
			nextToken();

			// if any line item comes with its own indentation, adapt to it
			if (fLine < startLine) {
				try {
					int lineOffset = fDocument.getLineOffset(startLine);
					int bound = Math.min(fDocument.getLength(), startPosition + 1);
					fAlign = fScanner.findNonWhitespaceForwardInAnyPartition(lineOffset, bound);
				} catch (BadLocationException e) {
					// ignore and return just the position
				}
				return startPosition;
			}

			switch (fToken) {
				// scopes: skip them
				case Symbols.TOKEN_RPAREN:
				case Symbols.TOKEN_RBRACKET:
				case Symbols.TOKEN_RBRACE:
					skipScope();
					break;

				// scope introduction: special treat who special is
				case Symbols.TOKEN_LPAREN:
				case Symbols.TOKEN_LBRACE:
				case Symbols.TOKEN_LBRACKET:
					return handleScopeIntroduction(startPosition + 1);

				case Symbols.TOKEN_SEMICOLON:
					return fPosition;
				case Symbols.TOKEN_QUESTIONMARK:
					if (prefTernaryDeepAlign()) {
						setFirstElementAlignment(fPosition - 1, fPosition + 1);
						return fPosition;
					} else {
						fIndent = prefTernaryIndent();
						return fPosition;
					}
				case Symbols.TOKEN_EOF:
					return 0;

			}
		}
	}

	/**
	 * Skips to the start of a statement that ends at the current position.
	 * 
	 * @param danglingElse
	 *            whether to indent aligned with the last <code>if</code>
	 * @param isInBlock
	 *            whether the current position is inside a block, which limits the search scope to the next
	 *            scope introducer
	 * @return the reference offset of the start of the statement
	 */
	private int skipToStatementStart(boolean danglingElse, boolean isInBlock) {
		while (true) {
			nextToken();

			if (isInBlock) {
				switch (fToken) {
					// exit on all block introducers
					case Symbols.TOKEN_IF:
					case Symbols.TOKEN_ELSE:
					case Symbols.TOKEN_SYNCHRONIZED:
					case Symbols.TOKEN_COLON:
					case Symbols.TOKEN_STATIC:
					case Symbols.TOKEN_CATCH:
					case Symbols.TOKEN_DO:
					case Symbols.TOKEN_WHILE:
					case Symbols.TOKEN_FINALLY:
					case Symbols.TOKEN_FOR:
					case Symbols.TOKEN_TRY:
						return fPosition;

					case Symbols.TOKEN_SWITCH:
						fIndent = prefCaseIndent();
						return fPosition;
				}
			}

			switch (fToken) {
				// scope introduction through: LPAREN, LBRACE, LBRACKET
				// search stop on SEMICOLON, RBRACE, COLON, EOF
				// -> the next token is the start of the statement (i.e. previousPos when backward scanning)
				case Symbols.TOKEN_LPAREN:
				case Symbols.TOKEN_LBRACE:
				case Symbols.TOKEN_LBRACKET:
				case Symbols.TOKEN_SEMICOLON:
				case Symbols.TOKEN_EOF:
					return fPreviousPos;

				case Symbols.TOKEN_COLON:
					int pos = fPreviousPos;
					if (!isConditional())
						return pos;
					break;

				case Symbols.TOKEN_RBRACE:
					// RBRACE is a little tricky: it can be the end of an array definition, but
					// usually it is the end of a previous block
					pos = fPreviousPos; // store state
					if (skipScope() && looksLikeArrayInitializerIntro())
						continue; // it's an array
					else
						return pos; // it's not - do as with all the above

					// scopes: skip them
				case Symbols.TOKEN_RPAREN:
				case Symbols.TOKEN_RBRACKET:
					pos = fPreviousPos;
					if (skipScope())
						break;
					else
						return pos;

					// IF / ELSE: align the position after the conditional block with the if
					// so we are ready for an else, except if danglingElse is false
					// in order for this to work, we must skip an else to its if
				case Symbols.TOKEN_IF:
					if (danglingElse)
						return fPosition;
					else
						break;
				case Symbols.TOKEN_ELSE:
					// skip behind the next if, as we have that one covered
					pos = fPosition;
					if (skipNextIF())
						break;
					else
						return pos;

				case Symbols.TOKEN_DO:
					// align the WHILE position with its do
					return fPosition;

				case Symbols.TOKEN_WHILE:
					// this one is tricky: while can be the start of a while loop
					// or the end of a do - while
					pos = fPosition;
					if (hasMatchingDo()) {
						// continue searching from the DO on
						break;
					} else {
						// continue searching from the WHILE on
						fPosition = pos;
						break;
					}
				default:
					// keep searching

			}

		}
	}

	/**
	 * Reduces indentation in <code>indent</code> by one indentation unit.
	 * 
	 * @param indent
	 *            the indentation to be modified
	 */
	private void unindent(StringBuffer indent) {
		CharSequence oneIndent = createIndent();
		int i = indent.lastIndexOf(oneIndent.toString());
		if (i != -1) {
			indent.delete(i, i + oneIndent.length());
		}
	}

}
