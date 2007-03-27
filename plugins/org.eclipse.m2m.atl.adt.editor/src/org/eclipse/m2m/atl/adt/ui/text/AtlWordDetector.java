package org.eclipse.m2m.atl.adt.ui.text;

import org.eclipse.jface.text.rules.IWordDetector;

/**
 * This class allows to check if a parsed word is an ATL one or not.
 * This is the same method as for all other languages.
 *  
 * @author C. MONTI for ATL Team
 */
public class AtlWordDetector implements IWordDetector {
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.rules.IWordDetector#isWordStart(char)
	 */
	public boolean isWordStart(char c) {
		return Character.isLetter(c) || (c == '_');
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.rules.IWordDetector#isWordPart(char)
	 */
	public boolean isWordPart(char c) {
		return Character.isLetterOrDigit(c) || (c == '_');
	}
	
}
