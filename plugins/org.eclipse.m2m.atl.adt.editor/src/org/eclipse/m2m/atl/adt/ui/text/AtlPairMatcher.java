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

import java.io.IOException;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.ICharacterPairMatcher;

/**
 * This class will help for matching pairs of characters.
 */
public class AtlPairMatcher implements ICharacterPairMatcher {
    
    private int anchor;
    private IDocument document;
    private int endPos;
    private int offset;
    private char[] pairs;
    private AtlCodeReader reader = new AtlCodeReader();
    private int startPos;
    
    /**
     * Creates a new instance of the ATL pair matcher.
     * 
     * @param pairs the character to match.
     */
    public AtlPairMatcher(char[] pairs) {
        this.pairs = pairs;
    }
    
    /**
     * Creates a new instance of the ATL pair matcher.
     * 
     * @param pairs the character to match.
     */
    public AtlPairMatcher(String[] pairs) {
        this.pairs = new char[pairs.length];
        for(int i = 0; i < pairs.length; ++i) {
            this.pairs[i] = pairs[i].charAt(0);
        }
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.text.source.ICharacterPairMatcher#clear()
     */
    public void clear() {
        if(reader != null) {
            try {
                reader.close();
            } catch(IOException x) {
            }
        }
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.text.source.ICharacterPairMatcher#dispose()
     */
    public void dispose() {
        clear();
        document = null;
        reader = null;
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.text.source.ICharacterPairMatcher#getAnchor()
     */
    public int getAnchor() {
        return anchor;
    }
    
    public char getMathingPair(char singleton) {
        for(int i = 0; i < pairs.length; ++i) {
            if(singleton == pairs[i]) {
                if(i % 2 == 0) {
                    return pairs[i + 1];
                } else {
                    return pairs[i - 1];
                }
            }
        }
        return 0;
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.text.source.ICharacterPairMatcher#match(org.eclipse.jface.text.IDocument, int)
     */
    public IRegion match(IDocument iDocument, int i) {
        offset = i;
        
        if(offset < 0)
            return null;
        
        document = iDocument;
        
        if((document != null) && matchPairsAt() && (startPos != endPos))
            return new Region(startPos, endPos - startPos + 1);
        
        return null;
    }
    
    protected boolean matchPairsAt() {
        int i;
        int pairIndex1= pairs.length;
        int pairIndex2= pairs.length;
        
        startPos= -1;
        endPos= -1;
        
        // get the chars preceding and following the start position
        try {
            char prevChar= document.getChar(Math.max(offset - 1, 0));
            
            // search for opening peer character next to the activation point
            for(i= 0; i < pairs.length; i= i + 2) {
                if(prevChar == pairs[i]) {
                    startPos= offset - 1;
                    pairIndex1= i;
                }
            }
            
            // search for closing peer character next to the activation point
            for(i= 1; i < pairs.length; i= i + 2) {
                if(prevChar == pairs[i]) {
                    endPos= offset - 1;
                    pairIndex2= i;
                } 
            }
            
            if(endPos > -1) {
                anchor= RIGHT;
                startPos= searchForOpeningPeer(endPos, pairs[pairIndex2 - 1], pairs[pairIndex2], document);
                if(startPos > -1)
                    return true;
                else
                    endPos= -1;
            } else if(startPos > -1) {
                anchor= LEFT;
                endPos= searchForClosingPeer(startPos, pairs[pairIndex1], pairs[pairIndex1 + 1], document);
                if(endPos > -1)
                    return true;
                else
                    startPos= -1;
            }
        } catch(BadLocationException x) {
        } catch(IOException x) {
        }
        
        return false;
    }
    
    public int searchForClosingPeer(int offset, int openingPeer, int closingPeer, IDocument document) throws IOException {
        reader.configureForwardReader(document, offset + 1, document.getLength(), true, true);
        
        int stack= 1;
        int c= reader.read();
        while(c != AtlCodeReader.EOF) {
            if(c == openingPeer && c != closingPeer)
                stack++;
            else if(c == closingPeer)
                stack--;
            
            if(stack == 0)
                return reader.getOffset();
            
            c= reader.read();
        }
        
        return  -1;
    }
    
    public int searchForOpeningPeer(int offset, int openingPeer, int closingPeer, IDocument document) throws IOException {
        reader.configureBackwardReader(document, offset, true, true);
        
        int stack= 1;
        int c= reader.read();
        while(c != AtlCodeReader.EOF) {
            if(c == closingPeer && c != openingPeer)
                stack++;
            else if(c == openingPeer)
                stack--;
            
            if(stack == 0)
                return reader.getOffset();
            
            c= reader.read();
        }
        
        return -1;
    }
    
}
