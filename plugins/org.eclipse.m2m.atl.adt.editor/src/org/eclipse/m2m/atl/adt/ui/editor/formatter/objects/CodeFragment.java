/*******************************************************************************
 * Copyright (c) 2011, 2012 Obeo.
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
 * An object to manage a code fragment to format.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class CodeFragment {

	private String initialCodeFragment;

	private int initialStart;

	private int initialEnd;

	private String replacementCodeFragment;

	private int replacementStart;

	private int replacementEnd;

	public CodeFragment(String initialCodeFragment, int initialStart) {
		this(initialCodeFragment, initialStart, -1, null, -1, -1);
	}

	public CodeFragment(String initialCodeFragment, int initialStart, int initialEnd,
			String replacementCodeFragment, int replacementStart, int replacementEnd) {
		this.initialCodeFragment = initialCodeFragment;
		this.initialStart = initialStart;
		this.initialEnd = initialStart + initialCodeFragment.length();
		this.replacementCodeFragment = replacementCodeFragment;
		this.setReplacementStart(replacementStart);
		this.replacementEnd = replacementEnd;
	}

	public String getInitialCodeFragment() {
		return initialCodeFragment;
	}

	public void setInitialCodeFragment(String initialCodeFragment) {
		this.initialCodeFragment = initialCodeFragment;
	}

	public int getInitialStart() {
		return initialStart;
	}

	public void setInitialStart(int initialStart) {
		this.initialStart = initialStart;
	}

	public void setInitialEnd(int initialEnd) {
		this.initialEnd = initialEnd;
	}

	public int getInitialEnd() {
		return initialEnd;
	}

	public String getReplacementCodeFragment() {
		return replacementCodeFragment;
	}

	public void setReplacementCodeFragment(String replacementCodeFragment) {
		this.replacementCodeFragment = replacementCodeFragment;
		this.replacementEnd = this.initialStart + this.replacementCodeFragment.length();
		this.replacementStart = this.replacementEnd - this.replacementCodeFragment.length();
	}

	public int getReplacementEnd() {
		return replacementEnd;
	}

	public void setReplacementEnd(int replacementEnd) {
		this.replacementEnd = replacementEnd;
	}

	public void setReplacementStart(int replacementStart) {
		this.replacementStart = replacementStart;
	}

	public int getReplacementStart() {
		return replacementStart;
	}

}
