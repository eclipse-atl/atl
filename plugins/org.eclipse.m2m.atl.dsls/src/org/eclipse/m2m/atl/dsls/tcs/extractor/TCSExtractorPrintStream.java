/**
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: TCSExtractorPrintStream.java,v 1.1 2009/04/21 14:12:26 wpiers Exp $
 */
package org.eclipse.m2m.atl.dsls.tcs.extractor;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 *
 */
public class TCSExtractorPrintStream implements TCSExtractorStream {

	private PrintStream out;
	
	public TCSExtractorPrintStream(OutputStream target) {
		out = new PrintStream(target);
	}

	public void close() {
		out.close();
	}

	public void debug(String string) {
		out.print(string);
	}

	public void printBoolean(boolean v) {
		out.print(v);
	}

	public void printComment(String c) {
		out.print(c);
	}

	public void printEscapedIdentifier(String identEscStart, String ident, String identEscEnd) {
		out.print(identEscStart);
		out.print(ident);
		out.print(identEscEnd);
	}

	public void printIdentifier(String ident) {
		out.print(ident);
	}

	public void printInteger(int v) {
		out.print(v);
	}

	public void printKeyword(String keyword) {
		out.print(keyword);
	}

	public void printReal(String string) {
		out.print(string);
	}

	public void printString(String stringDelim, String v) {
		out.print(stringDelim);
		out.print(v);
		out.print(stringDelim);
	}

	public void printSymbol(String symbol) {
		out.print(symbol);
	}

	public void printWhiteSpace(String ws) {
		out.print(ws);
	}

}
