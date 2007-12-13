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

/**
 * This interface contains all the words of the ATL language,
 * such as keywords...
 */
public interface IAtlLexems {
	
	public final static String[] BRACKETS	= { "(", ")", "{", "}" };
	public final static String[] CONSTANTS	= { "true", "false" };
	public final static String[] KEYWORDS	= { "not", "and", "or", "xor", "implies", "module", "create", "from", "uses", "helper", "def", "context", "rule", "using", "derived", "to", "mapsTo", "distinct", "foreach", "in", "do", "if", "then", "else", "endif", "let", "library", "query", "for", "div", "refining", "entrypoint", "endpoint", "extends", "abstract", "unique", "lazy", "super" };
	public final static String[] OPERATORS	= { ">", ".", "->", "-", "*", "/", "+", "=", ">", "<", ">=", "<=", "<>", "<-" };
	public final static String[] SYMBOLS	= { "!", ",", ";", ":", "|" };
	public final static String[] TYPES		= { "Bag", "Set", "OrderedSet", "Sequence", "Tuple", "Integer", "Real", "Boolean", "String", "TupleType" };

}
