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
 * $Id: TCSExtractorStream.java,v 1.1 2009/03/04 16:06:00 wpiers Exp $
 */
package org.eclipse.gmt.tcs.extractor;

/**
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 *
 */
public interface TCSExtractorStream {

	void close();

	void debug(String string);

	void printWhiteSpace(String ws);

	void printKeyword(String keyword);

	void printSymbol(String symbol);

	void printIdentifier(String ident);

	void printEscapedIdentifier(String identEscStart, String ident, String identEscEnd);

	void printBoolean(boolean v);

	void printInteger(int v);

	void printReal(String string);

	void printString(String stringDelim, String v);

	void printComment(String c);

}
