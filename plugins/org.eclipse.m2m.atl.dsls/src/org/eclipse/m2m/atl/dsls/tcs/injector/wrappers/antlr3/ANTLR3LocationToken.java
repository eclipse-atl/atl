/**
 * Copyright (c) 2004, 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: ANTLR3LocationToken.java,v 1.1 2009/04/21 14:12:27 wpiers Exp $
 */
package org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonToken;

/**
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 *
 */
public class ANTLR3LocationToken extends CommonToken {

	private static final long serialVersionUID = 1779004710570761428L;
	
	public ANTLR3LocationToken(CharStream input, int type, int channel, int start, int stop) {
		super(input, type, channel, start, stop);
	}
	
	public void setEndLine(int endLine) {
		this.endLine = endLine;
	}

	public int getEndLine() {
		return endLine;
	}

	public void setEndColumn(int endColumn) {
		this.endColumn = endColumn;
	}

	public int getEndColumn() {
		return endColumn;
	}

	private int endLine;
	private int endColumn;
}
