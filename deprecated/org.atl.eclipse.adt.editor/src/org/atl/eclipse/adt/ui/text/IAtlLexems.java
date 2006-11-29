package org.atl.eclipse.adt.ui.text;

/**
 * This interface contains all the words of the ATL language,
 * such as keywords...
 * 
 * @author C. MONTI for ATL Team
 */
public interface IAtlLexems {
	
	public final static String[] BRACKETS	= { "(", ")", "{", "}" };
	public final static String[] CONSTANTS	= { "true", "false" };
	public final static String[] KEYWORDS	= { "not", "and", "or", "xor", "implies", "module", "create", "from", "uses", "helper", "def", "context", "rule", "using", "derived", "to", "mapsTo", "distinct", "foreach", "in", "do", "if", "then", "else", "endif", "let", "library", "query", "for", "div", "refining", "entrypoint", "endpoint", "extends", "abstract" };
	public final static String[] OPERATORS	= { ">", ".", "->", "-", "*", "/", "+", "=", ">", "<", ">=", "<=", "<>", "<-" };
	public final static String[] SYMBOLS	= { "!", ",", ";", ":", "|" };
	public final static String[] TYPES		= { "Bag", "Set", "OrderedSet", "Sequence", "Tuple", "Integer", "Real", "Boolean", "String", "TupleType" };

}
