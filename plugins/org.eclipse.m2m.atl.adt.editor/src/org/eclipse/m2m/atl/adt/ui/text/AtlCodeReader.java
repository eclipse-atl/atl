package org.eclipse.m2m.atl.adt.ui.text;

import java.io.IOException;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.m2m.atl.adt.ui.corext.doc.SingleCharReader;

/**
 * Reads from a document either forwards or backwards. May be configured to
 * skip comments and strings.
 * 
 * @author C. MONTI for ATL team
 */
public class AtlCodeReader extends SingleCharReader {
    
    public static final int EOF = -1;
    private IDocument document;
    private int end = -1;
    private boolean forward = false;
    private int offset;
    private boolean skipComments = false;
    private boolean skipStrings = false;
    
    /*(non-Javadoc)
     * @see java.io.Reader#close()
     */
    public void close() throws IOException {
        document = null;
    }
    
    public void configureBackwardReader(IDocument document, int offset, boolean skipComments, boolean skipStrings) throws IOException {
        this.document= document;
        this.offset= offset;
        this.skipComments= skipComments;
        this.skipStrings= skipStrings;
        forward= false;
    }
    
    public void configureForwardReader(IDocument document, int offset, int length, boolean skipComments, boolean skipStrings) throws IOException {
        this.document= document;
        this.offset= offset;
        this.skipComments= skipComments;
        this.skipStrings= skipStrings;
        forward= true;
        end= Math.min(this.document.getLength(), this.offset + length);		
    }
    
    /**
     * Returns the offset of the last read character. Should only be called after read has been called.
     */
    public int getOffset() {
        return forward ? offset - 1 : offset;
    }
    
    private void gotoEndOfLine() throws BadLocationException {
        offset = document.getLineOffset(document.getLineOfOffset(offset) + 1);
    }
    
    private void gotoEndOfString() throws BadLocationException {
        while(offset < end) {
            char current = document.getChar(offset++);
            if(current == '\\') {
                // ignore escaped characters
                ++offset;
            } else if(current == '\'') {
                return;
            }
        }
    }
    
    private void gotoStartOfString() throws BadLocationException {
        while(0 < --offset) {
            char current = document.getChar(offset);
            if (current == '\'')
                if((offset < 0) || (document.getChar(offset - 1) != '\\'))
                    return;
        }
    }
    
    public int read() throws IOException {
        try {
            return forward ? readForwards() : readBackwards();
        } catch(BadLocationException x) {
            throw new IOException(x.getMessage());
        }
    }
    
    private int readBackwards() throws BadLocationException {
        while(0 < offset) {
            char current = document.getChar(--offset);
            switch(current) {
            case '\'':
                if(skipStrings) {
                    gotoStartOfString();
                    continue;
                }
            }
            return current;
        }
        return EOF;
    }

    private int readForwards() throws BadLocationException {
        while(offset < end) {
            char current = document.getChar(offset++);
            switch(current) {
            case '-':
                char next = document.getChar(offset);
                if(skipComments && (offset < end) && (next == '-')) {
                    // A single line comment starts, we go to the end of the line.
                    gotoEndOfLine();
                    continue;
                }
                break;
            case '\'':
                if(skipStrings) {
                    gotoEndOfString();
                    continue;
                }
            }
            return current;
        }
        return EOF;
    }
    
}
