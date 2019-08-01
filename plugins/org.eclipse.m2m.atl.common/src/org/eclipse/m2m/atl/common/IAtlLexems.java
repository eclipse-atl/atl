/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.common;

/**
 * This interface contains all the words of the ATL language, such as keywords.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public interface IAtlLexems {

	/** Brackets. */
	String[] BRACKETS = {"(", ")", "{", "}"}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

	/** Constants. */
	String[] CONSTANTS = {"true", "false"}; //$NON-NLS-1$ //$NON-NLS-2$

	/** Keywords. */
	String[] KEYWORDS = {
			"drop", "not", "and", "or", "xor", "implies", "module", "create", "from", "uses", "helper", "def", "context", "rule", "using", "derived", "to", "mapsTo", "distinct", "foreach", "in", "do", "if", "then", "else", "endif", "let", "library", "query", "for", "div", "refining", "entrypoint", "endpoint", "extends", "abstract", "unique", "lazy", "super",}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ //$NON-NLS-14$ //$NON-NLS-15$ //$NON-NLS-16$ //$NON-NLS-17$ //$NON-NLS-18$ //$NON-NLS-19$ //$NON-NLS-20$ //$NON-NLS-21$ //$NON-NLS-22$ //$NON-NLS-23$ //$NON-NLS-24$ //$NON-NLS-25$ //$NON-NLS-26$ //$NON-NLS-27$ //$NON-NLS-28$ //$NON-NLS-29$ //$NON-NLS-30$ //$NON-NLS-31$ //$NON-NLS-32$ //$NON-NLS-33$ //$NON-NLS-34$ //$NON-NLS-35$ //$NON-NLS-36$ //$NON-NLS-37$ //$NON-NLS-38$

	/** Operators. */
	String[] OPERATORS = {">", ".", "->", "-", "*", "/", "+", "=", ">", "<", ">=", "<=", "<>", "<-"}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ //$NON-NLS-14$

	/** Symbols. */
	String[] SYMBOLS = {"!", ",", ";", ":", "|"}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

	/** Types. */
	String[] TYPES = {
			"Bag", "Set", "OrderedSet", "Sequence", "Tuple", "Integer", "Real", "Boolean", "String", "TupleType", "Map", "Collection", "OclAny",}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$

	/** Abstract types. */
	String[] ABSTRACT_TYPES = {"Collection", "OclAny",}; //$NON-NLS-1$ //$NON-NLS-2$

	/** Special comments. */
	String[] SPECIAL_COMMENTS = {"-- @path", "-- @nsURI", "-- @lib", "-- @atlcompiler",}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

	/** Context keywords. */
	String[] CONTEXT_KEYWORDS = {"self", "thisModule",}; //$NON-NLS-1$ //$NON-NLS-2$

}
