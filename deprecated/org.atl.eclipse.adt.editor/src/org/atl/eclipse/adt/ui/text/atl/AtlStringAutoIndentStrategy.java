/*
 * Created on 27 juil. 2004
 */
package org.atl.eclipse.adt.ui.text.atl;

import org.atl.eclipse.adt.ui.AtlPreferenceConstants;
import org.atl.eclipse.adt.ui.AtlUIPlugin;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultAutoIndentStrategy;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.texteditor.ITextEditorExtension3;

/**
 * Auto indent strategy for strings
 * 
 * @author C. MONTI for ATL team
 */
public class AtlStringAutoIndentStrategy extends DefaultAutoIndentStrategy {
	
	private String fPartitioning;
	
	/**
	 * Creates a new string auto indent strategy for the given document partitioning.
	 * 
	 * @param partitioning the document partitioning
	 */
	public AtlStringAutoIndentStrategy(String partitioning) {
		super();
		fPartitioning= partitioning;
	}
	
	private void AtlStringIndentAfterNewLine(IDocument document, DocumentCommand command) throws BadLocationException {
		
		ITypedRegion partition= TextUtilities.getPartition(document, fPartitioning, command.offset, true);
		int offset= partition.getOffset();
		int length= partition.getLength();
		
		if (command.offset == offset + length && document.getChar(offset + length - 1) == '\'')
			return;
		
		String indentation= getLineIndentation(document, command.offset);
		String delimiter= TextUtilities.getDefaultLineDelimiter(document);
		
		IRegion line= document.getLineInformationOfOffset(offset);
		String string= document.get(line.getOffset(), offset - line.getOffset());
		if (string.trim().length() != 0)
			indentation += String.valueOf("\t\t");
		
		IPreferenceStore preferenceStore= AtlUIPlugin.getDefault().getPreferenceStore();
		if (isLineDelimiter(document, command.text))
			command.text= "\' +" + command.text + indentation + "\'";
		else if (command.text.length() > 1 && preferenceStore.getBoolean(AtlPreferenceConstants.TYPING_ESCAPE_STRINGS))
			command.text= getModifiedText(command.text, indentation, delimiter);		
	}
	
	/*
	 * @see org.eclipse.jface.text.IAutoIndentStrategy#customizeDocumentCommand(IDocument, DocumentCommand)
	 */
	public void customizeDocumentCommand(IDocument document, DocumentCommand command) {
		try {
			if (command.length != 0 || command.text == null)
				return;
			
			IPreferenceStore preferenceStore= AtlUIPlugin.getDefault().getPreferenceStore();
			
			if (preferenceStore.getBoolean(AtlPreferenceConstants.TYPING_WRAP_STRINGS) && isSmartMode()) {
				AtlStringIndentAfterNewLine(document, command);
			}
			
		} catch (BadLocationException e) {
		}
	}
	
	/**
	 * The input string doesn't contain any line delimiter.
	 * 
	 * @param inputString the given input string
	 * @return the displayable string.
	 */
	private String displayString(String inputString, String indentation, String delimiter) {
		
		int length = inputString.length();
		StringBuffer buffer = new StringBuffer(length);
		java.util.StringTokenizer tokenizer = new java.util.StringTokenizer(inputString, "\n\r", true);
		while (tokenizer.hasMoreTokens()){
			
			String token = tokenizer.nextToken();
			if (token.equals("\r")) {
				buffer.append("\\r");
				if (tokenizer.hasMoreTokens()) {
					token = tokenizer.nextToken();
					if (token.equals("\n")) {
						buffer.append("\\n");
						buffer.append("\' + " + delimiter);
						buffer.append(indentation);
						buffer.append("\'");
						continue;
					} else {
						buffer.append("\' + " + delimiter);
						buffer.append(indentation);
						buffer.append("\'");
					}
				} else {
					continue;
				}
			} else if (token.equals("\n")) {
				buffer.append("\\n");
				buffer.append("\' + " + delimiter);
				buffer.append(indentation);
				buffer.append("\'");
				continue;
			}	
			
			StringBuffer tokenBuffer = new StringBuffer();
			for (int i = 0; i < token.length(); i++){ 
				char c = token.charAt(i);
				switch (c) {
				case '\r' :
					tokenBuffer.append("\\r");
					break;
				case '\n' :
					tokenBuffer.append("\\n");
					break;
				case '\b' :
					tokenBuffer.append("\\b");
					break;
				case '\t' :
					// keep tabs verbatim
					tokenBuffer.append("\t");
					break;
				case '\f' :
					tokenBuffer.append("\\f");
					break;
				case '\"' :
					tokenBuffer.append("\\\"");
					break;
				case '\'' :
					tokenBuffer.append("\\'");
					break;
				case '\\' :
					tokenBuffer.append("\\\\");
					break;
				default :
					tokenBuffer.append(c);
				}
			}
			buffer.append(tokenBuffer);
		}
		return buffer.toString();
	}
	
	private String getLineIndentation(IDocument document, int offset) throws BadLocationException {
		
		// find start of line
		int adjustedOffset= (offset == document.getLength() ? offset  - 1 : offset);
		IRegion line= document.getLineInformationOfOffset(adjustedOffset);
		int start= line.getOffset();
		
		// find white spaces
		int end= findEndOfWhiteSpace(document, start, offset);
		
		return document.get(start, end - start);
	}
	
	private String getModifiedText(String string, String indentation, String delimiter) {		
		return displayString(string, indentation, delimiter);
	}
	
	private boolean isLineDelimiter(IDocument document, String text) {
		String[] delimiters= document.getLegalLineDelimiters();
		if (delimiters != null)
			return TextUtilities.equals(delimiters, text) > -1;
		return false;
	}
	
	private boolean isSmartMode() {
		IWorkbenchPage page= AtlUIPlugin.getActivePage();
		if (page != null)  {
			IEditorPart part= page.getActiveEditor(); 
			if (part instanceof ITextEditorExtension3) {
				ITextEditorExtension3 extension= (ITextEditorExtension3) part;
				return extension.getInsertMode() == ITextEditorExtension3.SMART_INSERT;
			}
		}
		return false;
	}
}
