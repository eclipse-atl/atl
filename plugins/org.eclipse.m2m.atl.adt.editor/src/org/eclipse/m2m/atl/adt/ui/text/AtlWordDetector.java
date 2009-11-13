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

import org.eclipse.jface.text.rules.IWordDetector;

/**
 * This class allows to check if a parsed word is an ATL one or not. This is the same method as for all other
 * languages.
 */
public class AtlWordDetector implements IWordDetector {

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.text.rules.IWordDetector#isWordStart(char)
	 */
	public boolean isWordStart(char c) {
		return Character.isLetter(c) || (c == '_');
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.text.rules.IWordDetector#isWordPart(char)
	 */
	public boolean isWordPart(char c) {
		return Character.isLetterOrDigit(c) || (c == '_');
	}

}
