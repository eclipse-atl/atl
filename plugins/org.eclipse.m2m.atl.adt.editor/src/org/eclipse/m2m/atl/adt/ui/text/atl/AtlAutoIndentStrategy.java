/*
 * Created on 9 juil. 2004
 */
package org.eclipse.m2m.atl.adt.ui.text.atl;

import java.io.IOException;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultAutoIndentStrategy;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.m2m.atl.adt.ui.AtlPreferenceConstants;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditorMessages;
import org.eclipse.m2m.atl.adt.ui.text.AtlHeuristicScanner;
import org.eclipse.m2m.atl.adt.ui.text.AtlIndenter;
import org.eclipse.m2m.atl.adt.ui.text.AtlPairMatcher;
import org.eclipse.m2m.atl.adt.ui.text.IAtlLexems;
import org.eclipse.m2m.atl.adt.ui.text.IAtlPartitions;
import org.eclipse.m2m.atl.adt.ui.text.Symbols;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.texteditor.ITextEditorExtension3;

/**
 * @author C. MONTI for ATL team
 */
public class AtlAutoIndentStrategy extends DefaultAutoIndentStrategy {
	
	/**
	 * Computes an insert position for an opening brace if <code>offset</code> maps to a position in
	 * <code>document</code> with a expression in parenthesis that will take a block after the closing parenthesis.
	 * 
	 * @param document the document being modified
	 * @param offset the offset of the caret position, relative to the line start.
	 * @param partitioning the document partitioning
	 * @param max the max position
	 * @return an insert position relative to the line start if <code>line</code> contains a parenthesized expression that can be followed by a block, -1 otherwise
	 */
	private static int computeAnonymousPosition(IDocument document, int offset, String partitioning,  int max) {
		// find the opening parenthesis for every closing parenthesis on the current line after offset
		// return the position behind the closing parenthesis if it looks like a method declaration
		// or an expression for an if, while, for, catch statement
		
		AtlHeuristicScanner scanner= new AtlHeuristicScanner(document);
		int pos= offset;
		int length= max;
		int scanTo= scanner.scanForward(pos, length, '}');
		if (scanTo == -1)
			scanTo= length;
		
		int closingParen= findClosingParenToLeft(scanner, pos) - 1;
		
		while (true) {
			int startScan= closingParen + 1;
			closingParen= scanner.scanForward(startScan, scanTo, ')');
			if (closingParen == -1)
				break;
			
			int openingParen= scanner.findOpeningPeer(closingParen - 1, '(', ')');
			
			// no way an expression at the beginning of the document can mean anything
			if (openingParen < 1)
				break;
			
			// only select insert positions for parenthesis currently embracing the caret
			if (openingParen > pos)
				continue;
		}
		
		return -1;
	}
	
	/**
	 * Finds a closing parenthesis to the left of <code>position</code> in document, where that parenthesis is only
	 * separated by whitespace from <code>position</code>. If no such parenthesis can be found, <code>position</code> is returned.
	 * 
	 * @param document the document being modified
	 * @param position the first character position in <code>document</code> to be considered
	 * @param partitioning the document partitioning
	 * @return the position of a closing parenthesis left to <code>position</code> separated only by whitespace, or <code>position</code> if no parenthesis can be found
	 */
	private static int findClosingParenToLeft(AtlHeuristicScanner scanner, int position) {
		if (position < 1)
			return position;
		
		if (scanner.previousToken(position - 1, AtlHeuristicScanner.UNBOUND) == Symbols.TokenRPAREN)
			return scanner.getPosition() + 1;
		return position;
	}
	
	private static String getLineDelimiter(IDocument document) {
		try {
			if (document.getNumberOfLines() > 1)
				return document.getLineDelimiter(0);
		} catch (BadLocationException e) {
			System.out.println(e.toString());
		}
		return System.getProperty("line.separator"); //$NON-NLS-1$
	}
	private boolean fCloseBrace;
	
	private boolean fIsSmartMode;
	
	private String fPartitioning;
	
	/**
	 * Creates a new ATL auto indent strategy for the given document fPartitioning.
	 * 
	 * @param fPartitioning the document fPartitioning
	 */
	public AtlAutoIndentStrategy(String partitioning) {
		super();
		this.fPartitioning = partitioning;
	}
	
	private void clearCachedValues() {
		fCloseBrace = AtlUIPlugin.getDefault().getPreferenceStore().getBoolean(AtlPreferenceConstants.TYPING_CLOSE_BRACES);
		fIsSmartMode= computeSmartMode();
	}
	
	private boolean closeBrace() {
		return fCloseBrace;
	}
	
	private boolean computeSmartMode() {
		IWorkbenchPage page= AtlUIPlugin.getActivePage();
		if (page != null)  {
			IEditorPart part= page.getActiveEditor(); 
			if (part instanceof ITextEditorExtension3) {
				// TODO when smart insert will be set, remove this
//				return ((ITextEditorExtension3) part).getInsertMode() == ITextEditorExtension3.SMART_INSERT;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return a string buffer containing one indent
	 */
	protected String createIndent() {
		/* TODO completed the single indenter character with the user preferences
		 * to return the correct indent.
		 */
		return "\t";
	}
	
	/**
	 * Creates an indented string buffer.
	 *  
	 * @param indents the requested indentation level
	 * @return the indented string buffer
	 */
	protected String createIndent(int indents) {
		String res = new String();
		String indent = createIndent();
		
		for(int i = 0; i < indents; ++i) {
			res.concat(indent);
		}
		
		return res;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.IAutoEditStrategy#customizeDocumentCommand(org.eclipse.jface.text.IDocument, org.eclipse.jface.text.DocumentCommand)
	 */
	public void customizeDocumentCommand(IDocument document, DocumentCommand command) {
		if (command.doit == false)
			return;
		
		clearCachedValues();
		if (!isSmartMode()) {
			super.customizeDocumentCommand(document, command);
			return;
		}
		
		if((command.length <= 0) && (command.text != null) && isLineDelimiter(document, command.text)) {
			smartIndentAfterNewLine(document, command);
		} else if (command.text.length() == 1) {
			smartIndentAfterBlockDelimiter(document, command);
		} else {
			super.customizeDocumentCommand(document, command);
		}
	}
	
	private int findMatchingOpenBracket(IDocument document, int cursorAt, char closingPeer) {
		AtlPairMatcher bracketsMatcher = new AtlPairMatcher(IAtlLexems.BRACKETS);
		char openingPeer = bracketsMatcher.getMathingPair(closingPeer);
		
		try {
			return document.getLineOfOffset(bracketsMatcher.searchForOpeningPeer(cursorAt, openingPeer, closingPeer, document));
		} catch (BadLocationException e) {
			return 0;
		} catch (IOException e) {
			return 0;
		}
	}
	//	private void smartIndentAfterNewLine(IDocument document, DocumentCommand command) {
	//		int length = document.getLength();
	//		if((command.offset == -1) && (length <= 0)) {
	//			// There's nothing to indent
	//		} else {
	//			try {
	//				int cursorAt = (command.offset == length ? command.offset - 1 : command.offset);
	//				int line = document.getLineOfOffset(cursorAt);
	//				String buffer = new String(command.text);
	//				int lineStartsAt = document.getLineOffset(line);
	//				int lineEndsAt = lineStartsAt + document.getLineLength(line);
	//				char lastChar = getLastChar(document, lineStartsAt, cursorAt);
	//				
	//				if(cursorAt <= 0) {
	//					// Nothing to do on the first character.
	//				} else if(lastChar == '{') {
	//					buffer += getIndentOfLine(document, line) + createIndent();
	//				} else if(lastChar == '}') {
	//					buffer += getIndentOfLine(document, line);
	//					//                    int bufferLength = buffer.length();
	//					//                    if(1 < bufferLength) {
	//					//                        buffer = buffer.substring(0, bufferLength - 1);
	//					//                    }
	//				} else {
	//					buffer += getIndentOfLine(document, line);
	//				}
	//				
	//				command.text = buffer;
	//			} catch(BadLocationException e) {
	//				System.out.println(AtlEditorMessages.getString("smartIndentAfterNewLine.error.badLocation"));
	//			}
	//		}
	//	}
	
	private int getBracketCount(IDocument d, int startOffset, int endOffset, boolean ignoreCloseBrackets) throws BadLocationException {
		
		int bracketCount= 0;
		while (startOffset < endOffset) {
			char curr= d.getChar(startOffset);
			startOffset++;
			switch (curr) {
			case '-' :
				if (startOffset < endOffset) {
					char next= d.getChar(startOffset);
					if (next == '-') {
						// '--'-comment: nothing to do anymore on this line
						startOffset= endOffset;
					}
				}
				break;
			case '{' :
				bracketCount++;
				ignoreCloseBrackets= false;
				break;
			case '}' :
				if (!ignoreCloseBrackets) {
					bracketCount--;
				}
				break;
			case '"' :
			case '\'' :
				startOffset= getStringEnd(d, startOffset, endOffset, curr);
				break;
			default :
			}
		}
		return bracketCount;
	}
	
	/**
	 * Returns the indent level of the given line in the document.
	 *  
	 * @param document the document parsed
	 * @param line the matching line number
	 * @return the indent level of the line
	 * @throws BadLocationException
	 */
//	private int getIndentLevel(IDocument document, int line) throws BadLocationException {
//		if(-1 < line) {
//			int start = document.getLineOffset(line);
//			int end = start + document.getLineLength(line) - 1;
//			return findEndOfWhiteSpace(document, start, end) - start;
//		}
//		return 0;
//	}
	
	/**
	 * @param document the document being parsed
	 * @param line the line being searched
	 * @return the String at line with the leading whitespace removed
	 */
	protected String getIndentOfLine(IDocument document, int line) throws BadLocationException {
		if(line > -1) {
			int start = document.getLineOffset(line);
			int end = start + document.getLineLength(line) - 1;
			int whiteEnd = findEndOfWhiteSpace(document, start, end);
			return document.get(start, whiteEnd - start);
		} else {
			return "";
		}
	}
	
	/**
	 * Gets the last character in the matching range of the document.
	 * 
	 * @param document the document parsed
	 * @param start the start offset
	 * @param end the end offset
	 * @return the last character
	 * @throws BadLocationException
	 */
//	private char getLastChar(IDocument document, int start, int end) throws BadLocationException {
//		if(start < end) {
//			String range = document.get(start, end - start);
//			String[] split = range.split(" ");
//			int length = split.length - 1;
//			if(0 <= length) {
//				String res = split[length];
//				return res.charAt(res.length() - 1);
//			}
//		}
//		return 0;
//	}
	
	private int getStringEnd(IDocument d, int offset, int endOffset, char ch) throws BadLocationException {
		while (offset < endOffset) {
			char curr= d.getChar(offset);
			offset++;
			if (curr == '\\') {
				// ignore escaped characters
				offset++;
			} else if (curr == ch) {
				return offset;
			}
		}
		return endOffset;
	}
	
	/**
	 * Returns whether or not the text ends with one of the given search strings.
	 */
	private boolean isLineDelimiter(IDocument d, String txt) {
		String[] delimiters = d.getLegalLineDelimiters();
		if (delimiters != null) {
			return TextUtilities.endsWith(delimiters, txt) > -1;
		} else {
			return false;
		}
	}
	
	private boolean isSmartMode() {
		return fIsSmartMode;
	}
	
	private void smartIndentAfterBlockDelimiter(IDocument document, DocumentCommand command) {
		if(command.text.charAt(0) == '}')
			smartIndentAfterClosingBracket(document, command);
		else if(command.text.charAt(0) == '{')
			smartIndentAfterOpeningBracket(document, command);
	}
	
	private void smartIndentAfterClosingBracket(IDocument document, DocumentCommand command) {
		try {
			int length = document.getLength();
			int cursorAt = (command.offset == length ? command.offset - 1 : command.offset);
			int line = document.getLineOfOffset(cursorAt);
			int lineStartsAt = document.getLineOffset(line);
//			int lineLength = document.getLineLength(line);
			int whiteEnd = findEndOfWhiteSpace(document, lineStartsAt, cursorAt);
			
			if(whiteEnd == cursorAt) {
				StringBuffer replaceText= new StringBuffer(getIndentOfLine(
						document, 
						findMatchingOpenBracket(document, cursorAt, command.text.charAt(0))));
				replaceText.append(document.get(whiteEnd, command.offset - whiteEnd));
				replaceText.append(command.text);
				command.length += command.offset - lineStartsAt;
				command.offset= lineStartsAt;
				command.text= replaceText.toString();
			}
		} catch (BadLocationException e) {
			System.out.println(AtlEditorMessages.getString("smartIndentAfterClosingBracket.error.badLocation"));
		}
	}
	
	/**
	 * Set the indent of a new line based on the command provided in the supplied document.
	 * 
	 * @param document the document being parsed
	 * @param command the command being performed
	 */
	
	private void smartIndentAfterNewLine(IDocument d, DocumentCommand c) {
		AtlHeuristicScanner scanner= new AtlHeuristicScanner(d);
		AtlIndenter indenter= new AtlIndenter(d, scanner);
		StringBuffer indent= indenter.computeIndentation(c.offset);
		if (indent == null)
			indent= new StringBuffer();
		
		int docLength= d.getLength();
		if (c.offset == -1 || docLength == 0)
			return;
		
		try {
			int p= (c.offset == docLength ? c.offset - 1 : c.offset);
			int line= d.getLineOfOffset(p);
			
			StringBuffer buf= new StringBuffer(c.text + indent);
			
			
			IRegion reg= d.getLineInformation(line);
			int lineEnd= reg.getOffset() + reg.getLength();
			
			int contentStart= findEndOfWhiteSpace(d, c.offset, lineEnd);
			c.length=  Math.max(contentStart - c.offset, 0);
			
			int start= reg.getOffset();
			ITypedRegion region= TextUtilities.getPartition(d, fPartitioning, start, true);
			if (IAtlPartitions.DOC.equals(region.getType()))
				start= d.getLineInformationOfOffset(region.getOffset()).getOffset();
			
			// TODO check if the brace closes a region
			if (getBracketCount(d, start, c.offset, true) > 0 && closeBrace()/* && !isClosed(d, c.offset, c.length)*/) {
				c.caretOffset= c.offset + buf.length();
				c.shiftsCaret= false;
				
				// copy old content of line behind insertion point to new line
				// unless we think we are inserting an anonymous type definition
				if (c.offset == 0 || !(computeAnonymousPosition(d, c.offset - 1, fPartitioning, lineEnd) != -1)) {
					if (lineEnd - contentStart > 0) {
						c.length=  lineEnd - c.offset;
						buf.append(d.get(contentStart, lineEnd - contentStart).toCharArray());
					}
				}
				
				buf.append(getLineDelimiter(d));
				StringBuffer reference= null;
				int nonWS= findEndOfWhiteSpace(d, start, lineEnd);
				if (nonWS < c.offset && d.getChar(nonWS) == '{')
					reference= new StringBuffer(d.get(start, nonWS - start));
				else
					reference= indenter.getReferenceIndentation(c.offset);
				if (reference != null)
					buf.append(reference);
				buf.append('}');
			}
			c.text= buf.toString();
			
		} catch (BadLocationException e) {
			System.out.println(e.toString());
		}
	}
	
	private void smartIndentAfterOpeningBracket(IDocument document, DocumentCommand command) {
		if (command.offset < 1 || document.getLength() == 0)
			return;
		
		AtlHeuristicScanner scanner= new AtlHeuristicScanner(document);
		int p= (command.offset == document.getLength() ? command.offset - 1 : command.offset);
		
		try {
			// current line
			int line= document.getLineOfOffset(p);
			int lineOffset= document.getLineOffset(line);
			
			// line of last code
			int pos= scanner.findNonWhitespaceBackward(p, AtlHeuristicScanner.UNBOUND);
			if (pos == -1)
				return;
			int lastLine= document.getLineOfOffset(pos);
			
			// only shift if the last line is further up and is a braceless block candidate
			if (lastLine < line) {
				AtlIndenter indenter= new AtlIndenter(document, scanner);
				StringBuffer indent= indenter.computeIndentation(p, true);
				String toDelete= document.get(lineOffset, command.offset - lineOffset);
				if (indent != null && !indent.toString().equals(toDelete)) {
					command.text= indent.append(command.text).toString();
					command.length += command.offset - lineOffset;
					command.offset= lineOffset;
				}
			}
		} catch (BadLocationException e) {
			System.out.println(AtlEditorMessages.getString("smartIndentAfterOpeningBracket.error.badLocation"));
		}
	}
	
}
