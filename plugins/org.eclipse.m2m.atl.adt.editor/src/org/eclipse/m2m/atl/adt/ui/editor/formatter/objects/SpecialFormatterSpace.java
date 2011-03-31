/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.editor.formatter.objects;

/**
 * An utility to manage spaces.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class SpecialFormatterSpace {

	public final static SpecialFormatterSpace NEW_LINE_SPACE = new SpecialFormatterSpace(1, "\n"); //$NON-NLS-1$
	public final static SpecialFormatterSpace ONE_SPACE_SPACE = new SpecialFormatterSpace(2, " "); //$NON-NLS-1$
	public final static SpecialFormatterSpace NO_SPACE_SPACE = new SpecialFormatterSpace(3, ""); //$NON-NLS-1$

	private int value;
	private String chars;

	private SpecialFormatterSpace(int value, String chars) {
		this.value = value;
		this.chars = chars;
	}

	public static SpecialFormatterSpace getSpecial(int value) {
		switch(value) {
			case 1:
				return NEW_LINE_SPACE;
			case 2:
				return ONE_SPACE_SPACE;
			case 3:
				return NO_SPACE_SPACE;
			default:
				return ONE_SPACE_SPACE;
		}
	}

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getChars() {
		return chars;
	}
	public void setChars(String chars) {
		this.chars = chars;
	}

}
