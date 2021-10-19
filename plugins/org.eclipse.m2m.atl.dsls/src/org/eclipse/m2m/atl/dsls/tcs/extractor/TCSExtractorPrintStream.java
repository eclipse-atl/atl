/**
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
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

	private final PrintStream out;

	public TCSExtractorPrintStream(final OutputStream target) {
		out = new PrintStream(target);
	}

	@Override
	public void close() {
		out.close();
	}

	@Override
	public void debug(final String string) {
		out.print(string);
	}

	@Override
	public void printBoolean(final boolean v) {
		out.print(v);
	}

	@Override
	public void printComment(final String c) {
		out.print(c);
	}

	@Override
	public void printEscapedIdentifier(final String identEscStart, final String ident, final String identEscEnd) {
		out.print(identEscStart);
		out.print(ident);
		out.print(identEscEnd);
	}

	@Override
	public void printIdentifier(final String ident) {
		out.print(ident);
	}

	@Override
	public void printInteger(final int v) {
		out.print(v);
	}

	@Override
	public void printKeyword(final String keyword) {
		out.print(keyword);
	}

	@Override
	public void printReal(final String string) {
		out.print(string);
	}

	@Override
	public void printString(final String stringDelim, final String v) {
		out.print(stringDelim);
		out.print(v);
		out.print(stringDelim);
	}

	@Override
	public void printSymbol(final String symbol) {
		out.print(symbol);
	}

	@Override
	public void printWhiteSpace(final String ws) {
		out.print(ws);
	}

}
