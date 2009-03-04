/**
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: PrettyPrinter.java,v 1.1 2009/03/04 16:06:00 wpiers Exp $
 */
package org.eclipse.gmt.tcs.extractor;

import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;


/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 *
 */
public class PrettyPrinter {

	private Map templates = new HashMap();
	private Map primitiveTemplates = new HashMap();
	private Map tokens = new HashMap();
	private Collection keywords = new ArrayList();
	private boolean kwCheckIgnoreCase;
	private String identEscStart = "\"";
	private String identEscEnd = "\"";
	private String stringDelim = "\'";
	private boolean serializeComments = true;
	private boolean usePrimitiveTemplates = false;
	private static DecimalFormatSymbols dfs = new DecimalFormatSymbols();
	private DecimalFormat df = new DecimalFormat("0.##############", dfs);
	
	private TCSExtractorStream out;
	
	private Stack priorities = new Stack();
	private Stack currentSeparator = new Stack();
	private int indentLevel = 0;
	private String indentString = "  ";
	private String curIndent = "";
	private String standardSeparator = " ";
	private String lineFeed = "\n";
		
	private ModelAdapter modelAdapter;
	
	public void prettyPrint(Object source, ModelAdapter ma, OutputStream target, Map arguments) {		
		this.modelAdapter = ma;
		
		out = (TCSExtractorStream)arguments.get("stream");
		if(out == null)
			out = new TCSExtractorPrintStream(target);
		
		String newIndentString = (String)arguments.get("indentString");
		String newStandardSeparator = (String)arguments.get("standardSeparator");
		kwCheckIgnoreCase = "true".equals(arguments.get("kwCheckIgnoreCase"));
		debug = "true".equals(arguments.get("debug"));
		debugws = "true".equals(arguments.get("debugws"));
		serializeComments = !"false".equals(arguments.get("serializeComments"));
		usePrimitiveTemplates = "true".equals(arguments.get("usePrimitiveTemplates"));
		String identEscStart = (String)arguments.get("identEscStart");
		if(identEscStart != null) {
			this.identEscStart = identEscStart;
		}
		String identEscEnd = (String)arguments.get("identEscEnd");
		if(identEscEnd != null) {
			this.identEscEnd = identEscEnd;
		}
		String identEsc = (String)arguments.get("identEsc");
		if(identEsc != null) {
			this.identEscStart = identEsc;
			this.identEscEnd = identEsc;
		}
		String stringDelim = (String)arguments.get("stringDelim");
		if(stringDelim != null) {
			this.stringDelim = stringDelim;
		}
		String decimalFormat = (String)arguments.get("decimalFormat");
		if(decimalFormat != null) {
			this.df = new DecimalFormat(decimalFormat, dfs);
		}

		
		if(newIndentString != null)
			indentString = newIndentString;
		
		if(newStandardSeparator != null)
			standardSeparator = newStandardSeparator;
		
		Object format = arguments.get("format");
		String rootName = null;
		Object rootTemplate = null;
		for(Iterator i = modelAdapter.getElementsByType(format, "Template").iterator() ; i.hasNext() ; ) {
			Object ame = i.next();
			String name = this.modelAdapter.getString(ame, "name");
			boolean isMain = false;
			if("ClassTemplate".equals(this.modelAdapter.getTypeName(ame))) {
				isMain = this.modelAdapter.getBool(ame, "isMain");
			}
			if(isMain) {
				rootName = name;
				rootTemplate = ame;
			}
			
			if(this.modelAdapter.getTypeName(ame).equals("EnumerationTemplate")) {
				Map mappings = new HashMap();
				for(Iterator j = this.modelAdapter.getCol(ame, "mappings") ; j.hasNext() ; ) {
					Object mapping = j.next();
					mappings.put(this.modelAdapter.getString(this.modelAdapter.getME(mapping, "literal"), "name"), this.modelAdapter.getME(mapping, "element"));
				}
				templates.put(name, mappings);
			} else if(this.modelAdapter.getTypeName(ame).equals("PrimitiveTemplate")) {
				primitiveTemplates.put(name, ame);
				name = this.modelAdapter.getString(ame, "typeName");
				Collection c = (Collection)templates.get(name);
				if(c == null) {
					c = new ArrayList();
					templates.put(name, c);
				}
				c.add(ame);
			} else {
				templates.put(name, ame);
			}
		}
		for(Iterator i = modelAdapter.getElementsByType(format, "Keyword").iterator() ; i.hasNext() ; ) {
			Object ame = i.next();
			String value = this.modelAdapter.getString(ame, "value");
			if(kwCheckIgnoreCase)
				value = value.toUpperCase();
			keywords.add(value);
		}
		for(Iterator i = modelAdapter.getElementsByType(format, "Token").iterator() ; i.hasNext() ; ) {
			Object ame = i.next();
			String name = this.modelAdapter.getString(ame, "name");
			tokens.put(name, ame);
//TODO:
//			if("COMMENT".equals(name)) {
//				this.modelAdapter.getCol(this.modelAdapter.getME(ame, "pattern"), "simplePatterns");
//				AMN.isa(ame, "");
//				commentToken = ame;
//			}
		}
		for(Iterator i = modelAdapter.getElementsByType(format, "Symbol").iterator() ; i.hasNext() ; ) {
			Object ame = i.next();
			String value = this.modelAdapter.getString(ame, "value");
			debug("Symbol: " + value);
			int type = TYPE_SYMBOL;
			for(Iterator j = this.modelAdapter.getCol(ame, "spaces") ; j.hasNext() ; ) {
				String l = this.modelAdapter.getEnumLiteralName(j.next());
				debug("\tLiteral: " + l);
				if(l.equals("leftSpace"))
					type += SYMBOL_LS;
				else if(l.equals("leftNone"))
					type += SYMBOL_LN;
				if(l.equals("rightSpace"))
					type += SYMBOL_RS;
				else if(l.equals("rightNone"))
					type += SYMBOL_RN;
			}
			symbols.put(value, new Integer(type));
		}

		Iterator possibleRoots = this.modelAdapter.getElementsByType(source, rootName).iterator();
		boolean isMulti = this.modelAdapter.getBool(rootTemplate, "isMulti");
		boolean first = true;
		while(possibleRoots.hasNext()) {
			Object root = possibleRoots.next();
			if(this.modelAdapter.isAModelElement(this.modelAdapter.refImmediateComposite(root)))
				continue;	// not a real root
			if((!isMulti) && (!first)) {
				System.out.println("Error: multiple possible roots found.");
				break;
			}
			priorities.push(new Integer(Integer.MAX_VALUE));
			//pushSep(" ");
			serialize(root);
			first = false;
		}
		if(first && !isMulti) {
			System.out.println("Error: no root found.");
		}
		out.close();
	}
	
	private void pushSep(String sep) {
		currentSeparator.push(sep);
		debug("PUSHING SEPARATOR: \"" + sep + "\"");
	}
	
	private void popSep() {
		String old = (String)currentSeparator.pop();
		debug("POPING SEPARATOR: \"" + old + "\"");
	}
	 
	private void serialize(Object ame) {
		pushSep(standardSeparator);
		String typeName = this.modelAdapter.getTypeName(ame);
		debug("processing " + typeName);
		Object template = templates.get(typeName);
		if(template == null) {
			throw new TCSExtractionException("cannot find mathing template for: " + typeName, null);
		}
		String templateTypeName = this.modelAdapter.getTypeName(template);
		debug("Applying template type " + templateTypeName);
		
		if(serializeComments) {
			try {
				boolean first = true;
				boolean nl = false;
				for(Iterator i = this.modelAdapter.getCol(ame, "commentsBefore") ; i.hasNext() ; ) {
					String c = this.modelAdapter.nextString(i);
					if(c.equals("\n")) {
						nl = true;
					} else {
						debug("printing comment: \"" + c + "\"");
						if(first && !nl) {
							printComment(c);
							//out.print("SHOULD-BE-NONL");
						} else {
							printComment(c);
						}
						printWS(lineFeed + curIndent);
						first = false;
					}
				}
			} catch(Exception e) {
				System.out.println("Warning: could not get comments of " + ame + ", disabling further comments serialization");
				serializeComments = false;
			}
		}
		if(templateTypeName.equals("ClassTemplate")) {
			priorities.push(new Integer(Integer.MAX_VALUE));
			serializeSeq(ame, this.modelAdapter.getME(template, "templateSequence"));
			priorities.pop();
		} else if(templateTypeName.equals("OperatorTemplate")) {
			String sourcePropName = this.modelAdapter.getString(template, "source");
			String opPropName = this.modelAdapter.getString(template, "storeOpTo");
			String rightPropName = this.modelAdapter.getString(template, "storeRightTo");
			debug("OperatorTemplate: source = " + sourcePropName + " ; operator = " + opPropName + " ; right = " + rightPropName);

			Object r = null;
			boolean isPostfix = false;	// only valid for unary operators
			boolean isUnary = false;
			if(rightPropName != null) {
				r = this.modelAdapter.get(ame, rightPropName);
				if(r instanceof Collection) {
					isUnary = (((Collection)r).size() == 0);
				} else {
					isUnary = r == null;
				}
			} else {
				isUnary = true;
			}
			debug("rightPropName = " + rightPropName + " ; isUnary = " + isUnary);

			Object operator = null;
			if(opPropName != null) {
				String op = this.modelAdapter.getString(ame, opPropName);
				if (op == null) {
					throw new RuntimeException("Property " + opPropName + " has not been set in " + ame + " (" + this.modelAdapter.getMetaobject(ame) + ")");
				}
				for(Iterator i = this.modelAdapter.getCol(template, "operators") ; i.hasNext() && (operator == null) ; ) {
					Object opme = i.next();
					Object literal = this.modelAdapter.getME(opme, "literal");
					String opmes = null;
					if(literal == null)
						opmes = "";
					else
						opmes = this.modelAdapter.getString(literal, "value");
					int arity = this.modelAdapter.getInt(opme, "arity");
					if(op.equals(opmes)) {
						if(rightPropName != null) {
							if((isUnary && (arity == 1)) ||
									((!isUnary) && (arity == 2))) {
								operator = opme;
							}
						} else  {
							operator = opme;
							isPostfix = this.modelAdapter.getBool(opme, "isPostfix");
						}
					}
				}
				if(operator == null) {
					System.err.println("Error: could not find operator \"" + op + "\"");
				}
			} else {
				operator = this.modelAdapter.getCol(template, "operators").next();
				isUnary = this.modelAdapter.getInt(operator, "arity") == 1;
				if(isUnary) {
					isPostfix = this.modelAdapter.getBool(operator, "isPostfix");
				}
			}
			int curPrio = ((Integer)priorities.peek()).intValue();
			int priority = this.modelAdapter.getInt(this.modelAdapter.getME(operator, "priority"), "value");
			boolean paren = priority > curPrio;
			priorities.push(new Integer(priority));
			Object literal = this.modelAdapter.getME(operator, "literal");
			debug("PRIORITY = " + priority + " ; CURPRIO = " + curPrio + " ; OPERATOR = " + ((literal != null) ? this.modelAdapter.getString(literal, "value") : "") + " ; paren = " + paren);
			
			if(paren)
				printSymbol("(");

			Object source = this.modelAdapter.getME(ame, sourcePropName);
			if(isUnary) {
				if(isPostfix) {
					serialize(source);

					if(literal != null)
						printLiteral(literal);				
				} else {
					if(literal != null)
						printLiteral(literal);				
	
					serialize(source);
				}
			} else {
				serialize(source);
			
				if(literal != null)
					printLiteral(literal);
			}

			Object seq = this.modelAdapter.getME(template, "otSequence");
			if(rightPropName == null) {
				priorities.push(new Integer(Integer.MAX_VALUE));
				serializeSeq(ame, seq);
				priorities.pop();
			} else {
				if(seq != null)
					serializeSeq(ame, seq);
				if(r instanceof Collection) {
					for(Iterator i = ((Collection)r).iterator() ; i.hasNext() ; ) {
						serialize(i.next());						
					}
				} else {
					if(!isUnary)
						serialize(r);
				}
			}
			priorities.pop();
			if(paren)
				printSymbol(")");
		} else {
			error("unsupported template type: " + templateTypeName);
		}
		if(serializeComments) {
			try {
				for(Iterator i = this.modelAdapter.getCol(ame, "commentsAfter") ; i.hasNext() ; ) {
					String c = this.modelAdapter.nextString(i);
					if(c.equals("\n")) {
						
					} else {
						printComment(c);
						printWS(lineFeed + curIndent);
					}
				}
			} catch(Exception e) {
				System.out.println("Warning: could not get comments of " + ame + ", disabling further comments serialization");
				serializeComments = false;
			}
		}
		popSep();
	}
	private void serializeSeq(Object ame, Object seq) {
		if(seq != null) {
			for(Iterator i = this.modelAdapter.getCol(seq, "elements") ; i.hasNext() ; ) {
				Object e = i.next();
				serializeSeqElem(ame, e);
			}
		}
	}
	
	private String getLineFeeds(int n) {
		String ret = "";
		
		for(int i = 0 ; i < n ; i++) {
			ret += lineFeed;
		}
		
		return ret;
	}
	
	
	/**
	 * 
	 * @param element Context model element of which to serialize a part (from source model).
	 * @param seqElem SequenceElement specifying a part of element to serialize.
	 */
	private void serializeSeqElem(Object element, Object seqElem) {
		String tn = this.modelAdapter.getTypeName(seqElem);
		debug("serializing seq elem " + tn);
		if(tn.equals("LiteralRef")) {
			Object literal = this.modelAdapter.getME(seqElem, "referredLiteral");
			printLiteral(literal);
		} else if(tn.equals("CustomSeparator")) {
			String name = this.modelAdapter.getString(seqElem, "name");
			if(name.equals("no_space")) {
				typeLast = TYPE_SYMBOL + SYMBOL_RN;
			} else if(name.equals("space")) {
				printWS(" ");
			} else if(name.equals("newline")) {
				printWS(lineFeed);
			} else if(name.equals("tab")) {
				printWS("\t");
			}
		} else if(tn.equals("Property")) {
			Object v = this.modelAdapter.get(element, this.modelAdapter.getString(seqElem, "name"));
			serializeProperty(element, v, seqElem);
		} else if(tn.equals("Block")) {
if(debugws) out.debug("<block>");
			Object nbNLBArg = getBArg(this.modelAdapter, seqElem, "NbNL");
			Object startNbNLBArg = getBArg(this.modelAdapter, seqElem, "StartNbNL");
			Object indentIncrBArg = getBArg(this.modelAdapter, seqElem, "IndentIncr");
			Object startNLBArg = getBArg(this.modelAdapter, seqElem, "StartNL");
			Object endNLBArg = getBArg(this.modelAdapter, seqElem, "EndNL");
			int indentIncr = 1;
			int nbNL = 1;
			boolean startNL = true;
			boolean endNL = true;

			if(nbNLBArg != null) {
				nbNL = this.modelAdapter.getInt(nbNLBArg, "value");
			}
			int startNbNL = nbNL;	// by default, startNbNL = nbNL
			if(startNbNLBArg != null) {
				startNbNL = this.modelAdapter.getInt(startNbNLBArg, "value");
			}
			if(indentIncrBArg != null) {
				indentIncr = this.modelAdapter.getInt(indentIncrBArg, "value");
			}
			if(startNLBArg != null) {
				startNL = this.modelAdapter.getBool(startNLBArg, "value");
			}
			if(endNLBArg != null) {
				endNL = this.modelAdapter.getBool(endNLBArg, "value");
			}
			debug("nbNL = " + nbNL + " ; indentIncr = " + indentIncr);
			indentLevel += indentIncr;
			
			for(int i = 0 ; i < indentIncr ; i++) {
				curIndent += indentString;
			}
			String nls = getLineFeeds(nbNL);
/*TODO: this was removed because of ATL filter but why was it necessary?
			if(!" ".equals(currentSeparator.peek())) {
				printWS();
			}
*/
			pushSep(nls + ((nbNL == 0) ? standardSeparator : curIndent));
if(debugws) out.debug("<BeforeFirstWS/>");
			if(startNL) {
				if(startNbNL == 0) {
					printWS("");
				} else if(nbNL == startNbNL) {
					printWS();
				} else {
					printWS(getLineFeeds(startNbNL) + curIndent);
				}
			} else {
if(debugws) out.debug("<BeforeNonStartNLWS/>");
				printWS(""); // to make sure the last item was a TYPE_SPACE
if(debugws) out.debug("<AfterNonStartNLWS/>");
			}
if(debugws) out.debug("<blockContent>");
			serializeSeq(element, this.modelAdapter.getME(seqElem, "blockSequence"));
if(debugws) out.debug("</blockContent>");
			
			indentLevel -= indentIncr;
			curIndent = curIndent.substring(0, curIndent.length() - indentString.length() * indentIncr);
			if(endNL) {
				printWS(lineFeed + curIndent);
			}
			popSep();
if(debugws) out.debug("</block>");
		} else if(tn.equals("FunctionCall")) {
			serializeSeq(element, this.modelAdapter.getME(this.modelAdapter.getME(seqElem, "calledFunction"), "functionSequence"));
		} else if(tn.equals("ConditionalElement")) {
			Object condition = this.modelAdapter.getME(seqElem, "condition");
			if(eval(element, condition)) {
				Object tseq = this.modelAdapter.getME(seqElem, "thenSequence");
				if(tseq != null) printWSBlockNoDup();
				serializeSeq(element, tseq);
			} else {
				Object eseq = this.modelAdapter.getME(seqElem, "elseSequence");
				debug("ELSE SEQ = " + eseq);
				if(eseq != null) printWSBlockNoDup();
				serializeSeq(element, eseq);
			}
		} else {
			error("unsupported: " + tn);
		}		
	}
	
	private boolean eval(Object context, Object condition) {
		boolean ret = true;
		
		String ctn = this.modelAdapter.getTypeName(condition);
		if(ctn.equals("AndExp")) {
			ret = true;
			for(Iterator i = this.modelAdapter.getCol(condition, "expressions") ; i.hasNext() ; ) {
				ret &= eval(context, i.next());
			}
		} else if(ctn.equals("BooleanPropertyExp")) {
			ret = this.modelAdapter.getBool(context, this.modelAdapter.getString(condition, "propertyName"));
		} else if(ctn.equals("IsDefinedExp")) {
			Object val = this.modelAdapter.get(context, this.modelAdapter.getString(condition, "propertyName"));
			if (val == null) {
				ret = false;
			} else if(val instanceof Collection) {
				ret = (((Collection)val).size() > 0);
			} else {
				ret = true;
			}
			if(this.modelAdapter.getString(condition, "propertyName").equals("superRule"))
				debug("!!!superRule: " + ret + " " + val);
		} else if(ctn.equals("OneExp")) {
			Object val = this.modelAdapter.get(context, this.modelAdapter.getString(condition, "propertyName"));
			if (val == null) {
				ret = false;
			} else if(val instanceof Collection) {
				ret = (((Collection)val).size() == 1);
			} else {
				ret = true;
			}
			if(this.modelAdapter.getString(condition, "propertyName").equals("superRule"))
				debug("!!!superRule: " + ret + " " + val);
		} else if(ctn.equals("EqualsExp")) {
			Object value = this.modelAdapter.getME(condition, "value");
			String vtn = this.modelAdapter.getTypeName(value);
			if(vtn.equals("IntegerVal")) {
				int lv = this.modelAdapter.getInt(value, "symbol");
				int pv = this.modelAdapter.getInt(context, this.modelAdapter.getString(condition, "propertyName"));
				ret = (lv == pv);
			} else if(vtn.equals("NegativeIntegerVal")) {
					int lv = -this.modelAdapter.getInt(value, "symbol");
					int pv = this.modelAdapter.getInt(context, this.modelAdapter.getString(condition, "propertyName"));
					ret = (lv == pv);
			} else if(vtn.equals("StringVal")) {
					String lv = this.modelAdapter.getString(value, "symbol");
					String pv = this.modelAdapter.getString(context, this.modelAdapter.getString(condition, "propertyName"));
					ret = (lv.equals(pv));
			} else if(vtn.equals("EnumLiteralVal")) {
				String lv = this.modelAdapter.getString(value, "name");
				String pv = this.modelAdapter.getString(context, this.modelAdapter.getString(condition, "propertyName"));
				ret = (lv.equals(pv));
			} else {
				error(vtn + " unsupported.");
			}
			//TODO: PropertyVal
		}
		
		return ret;
	}
	
	private void serializeProperty(Object element, Object value, Object property) {
		if(value == null) return; 
		if(value instanceof Collection) {
			Object sep = getPArg(this.modelAdapter, property, "Separator");
			if(sep != null) sep = this.modelAdapter.getME(sep, "separatorSequence");
			boolean first = true;
			for(Iterator i = ((Collection)value).iterator() ; i.hasNext() ; ) {
				if(first) {
					printWSBlockNoDup();
					first = false;
				} else {
					if(typeLast != TYPE_SPACE)
						printWS();
				}
				serializeProperty(element, i.next(), property);
				if(i.hasNext()) {
					if(sep != null) {
						serializeSeq(null, sep);
					}
				}
			}
		} else if(this.modelAdapter.isEnumLiteral(value)) {
			//error("enumeration literals cannot be properly serialized at the present time (" + enumName + ")");
			String enumName = this.modelAdapter.getName(this.modelAdapter.getPropertyType(this.modelAdapter.getMetaobject(element), this.modelAdapter.getName(property)));
			Map mappings = (Map)templates.get(enumName);
			Object seqElem = mappings.get(this.modelAdapter.getEnumLiteralName(value));
			serializeSeqElem(element, seqElem);
		} else if (this.modelAdapter.isAModelElement(value)) { 
			printWSBlockNoDup();
			Object refersTo = getPArg(this.modelAdapter, property, "RefersTo");
			if(refersTo == null) {
				serialize(value);
			} else {
				Object v = this.modelAdapter.get(value, this.modelAdapter.getString(refersTo, "propertyName"));
				Object asp = getPArg(this.modelAdapter, property, "As");
				String as = null;
				if(asp != null) {
					as = this.modelAdapter.getString(asp, "value");
				}
				serializePrimitive(v, as);
			}
		} else if(this.modelAdapter.isPrimitive(value)) {
			printWSBlockNoDup();
			Object asp = getPArg(this.modelAdapter, property, "As");
			String as = null;
			if(asp != null) {
				as = this.modelAdapter.getString(asp, "value");
			}
			serializePrimitive(value, as);
		} else {
			error("unsupported " + ((value == null) ? null : value.getClass()));
		}
	}

	private void serializePrimitive(Object value, String as) {
		if(value instanceof String) {
			boolean doDefault = true; 
			if(usePrimitiveTemplates) {
				Collection c = (Collection)templates.get("String");
				Object t = null;
				for(Iterator i = c.iterator() ; i.hasNext() && (t == null) ; ) {
					Object ame = i.next();
					if((as == null) && this.modelAdapter.getBool(ame, "isDefault")) {
						t = ame;
					} else if(this.modelAdapter.getString(ame, "name").equals(as)) {
						t = ame;
					}
				}
				if(t == null) {
					System.out.println("warning: no primitive template found for String" + ((as == null) ? "" : "as " + as));
				} else {
					String tokenName = this.modelAdapter.getString(t, "tokenName");
					Object token = tokens.get(tokenName);
					if(token != null) {
						System.out.println("Token found: " + tokenName);
						Object pattern = this.modelAdapter.getME(token, "pattern");
						String regex = "^" + buildRegex(pattern) + "$";
						System.out.println(regex);
						String val = (String)value;
						System.out.println(val);
						System.out.println(val.matches(regex));
					}
				}
			}
			if(doDefault) {
				if("stringSymbol".equals(as)) {
					printStringLiteral(cString((String)value));
				} else {
					Object template = primitiveTemplates.get(as);
					boolean orKeyword = false;
					if(template != null)
						orKeyword = this.modelAdapter.getBoolUndefinedIsFalse(template, "orKeyword");
					printIdentifier((String)value, orKeyword);
				}
			}
		} else if(value instanceof Integer) {
			printIntegerLiteral(((Integer)value).intValue());
		} else if(value instanceof Double) {
			printRealLiteral(((Double)value).doubleValue());
		} else if(value instanceof Boolean) {
			printBooleanLiteral(((Boolean)value).booleanValue());
		}
	}
	
	private static String cString(String s) {
		StringBuffer ret = new StringBuffer();

		for(int i = 0 ; i < s.length() ; i++) {
			char c = s.charAt(i);
			if(c == '\n') {
				ret.append("\\n");
			} else if(c == '\r') {
				ret.append("\\r");
			} else if(c == '\t') {
				ret.append("\\t");
			} else if(c == '\b') {
				ret.append("\\b");
			} else if(c == '\f') {
				ret.append("\\f");
			} else if((c < ' ') || ((c > '~') && (c < '¡'))) {
				ret.append("\\");
				if(c < 010)
					ret.append("0");
				if(c < 0100)
					ret.append("0");
				ret.append(java.lang.Integer.toOctalString(c));
			} else if(c == '\'') {
				ret.append("\\'");
			} else if(c == '\"') {
				ret.append("\\\"");
			} else if(c == '\\') {
				ret.append("\\\\");
			} else {
				ret.append(c);
			}
		}

		return "" + ret;
	}
	
	private String buildRegex(Object pattern) {
		String ret = null;
		
		String typeName = this.modelAdapter.getTypeName(pattern);
		
		if(typeName.equals("OrPattern")) {
			boolean paren = false;
			for(Iterator i = this.modelAdapter.getCol(pattern, "simplePatterns") ; i.hasNext() ; ) {
				Object p = i.next();
				if(ret == null) {
					ret = buildRegex(p);
				} else {
					paren = true;
					ret += "|" + buildRegex(p);
				}
			}
			if(paren) ret = "(" + ret + ")";
		} else if(typeName.equals("RulePattern")) {
			Object rule = this.modelAdapter.getME(pattern, "rule");
			String rtn = this.modelAdapter.getTypeName(rule);
			if(rtn.equals("WordRule")) {
				ret = "(";
				ret += buildRegex(this.modelAdapter.getME(rule, "start")); 
				ret += buildRegex(this.modelAdapter.getME(rule, "part")) + "*";
				Object end = this.modelAdapter.getME(rule, "end");
				if(end != null) {
					ret += buildRegex(end);
				}
				ret += ")";
//			} else if(rtn.equals("EndsOfLineRule")) {
			} else if(rtn.equals("MultiLineRule")) {
				ret = "(";
//startIsNotKept				ret += buildRegex(getME(rule, "start"));
				String endRegex = buildRegex(this.modelAdapter.getME(rule, "end"));
				String middleRegex = "[^" + endRegex + "]";
				Object esc = this.modelAdapter.getME(rule, "esc");
				if(esc != null) {
					String escRegex = buildRegex(esc);
					middleRegex = "(" + middleRegex + "|" + escRegex + ".)";
				}				
				ret += middleRegex + "*";
//endIsNotKept				ret += endRegex;
				ret += ")";
			} else {
				error("unsupported rule type: " + rtn);
			}
		} else if(typeName.equals("StringPattern")) {
			String name = this.modelAdapter.getString(pattern, "name");
			ret = name
						.replaceAll("\\\\", "\\\\\\\\")
						.replaceAll("\\*", "\\\\*")
						.replaceAll("\\{", "\\\\{")
						.replaceAll("\\}", "\\\\}")
						.replaceAll("\\(", "\\\\(")
						.replaceAll("\\)", "\\\\)")
						.replaceAll("\\+", "\\\\+");
		} else if(typeName.equals("ClassPattern")) {
			String name = this.modelAdapter.getString(pattern, "name");
			ret = "\\p{" + ("" + name.charAt(0)).toUpperCase() + name.substring(1) + "}";
		} else {
			error("unsupported pattern type: " + typeName);
		}
		
		return ret;
	}
	
	// Low-level serialization
	
	private final static int TYPE_KEYWORD	= 1;
	private final static int TYPE_SYMBOL	= 2;
	private final static int TYPE_IDENT		= 3;
	private final static int TYPE_BOOL		= 4;
	private final static int TYPE_INT		= 5;
	private final static int TYPE_REAL		= 6;
	private final static int TYPE_STRING	= 7;
	private final static int TYPE_SPACE		= 8;
	private final static int TYPE_COMMENT	= 9;

	
	private final static int SYMBOL_LS	= 16;						// symbol with a space before (on the Left)
	private final static int SYMBOL_RS	= 32;						// symbol with a space after (on the Right)
	private final static int SYMBOL_BS	= SYMBOL_LS + SYMBOL_RS;	// symbol with spaces Both before and after
	private final static int SYMBOL_LN	= 64;						// symbol with no space before (even if preceding symbol is RS or BS)
	private final static int SYMBOL_RN	= 128;						// symbol with no space after (even if following symbol is LS or BS)

	private int typeLast = 0;

	private void printLiteral(Object literal) { 
		String s = this.modelAdapter.getString(literal, "value");
		String ltn = this.modelAdapter.getTypeName(literal);
		if(ltn.equals("Keyword")) {
			printKeyword(s);
		} else {
			printSymbol(s);
		}
	}
	
	private void printWS(String ws) {
		debug("printing WS = \"" + ws + "\"");
		out.printWhiteSpace(ws);
		typeLast = TYPE_SPACE;
		//new Exception().printStackTrace(out);
	}

	private void printWS() {
		printWS((String)currentSeparator.peek());
	}
	
	private boolean isSymbol(int type, int test) {
		test += TYPE_SYMBOL;
		return (type & test) == test;
	}

	private void printDisambiguationWS() {
		if((typeLast == TYPE_KEYWORD) ||
				(typeLast == TYPE_IDENT) ||
				(typeLast == TYPE_INT) ||
				(typeLast == TYPE_REAL) ||
				(typeLast == TYPE_STRING) ||
				(typeLast == TYPE_BOOL) ||
				(isSymbol(typeLast, SYMBOL_BS)) ||
				(isSymbol(typeLast, SYMBOL_RS))) {
//			out.print("<typeLast=" + typeLast + ">");
			printWS();
		}
	}
	
	private void printWSBlockNoDup() {
		if(typeLast != TYPE_SPACE)
			if(!currentSeparator.peek().equals(" "))
				printWS();
	}
	
	private void printWSNoDup() {
		if(typeLast != TYPE_SPACE)
			printWS();
	}
	
	private void printKeyword(String keyword) {
		printDisambiguationWS();
		out.printKeyword(keyword);
		typeLast = TYPE_KEYWORD;
	}
	
	private Map symbols = new HashMap();

	private void printSymbol(String symbol) {
		Integer type = (Integer)symbols.get(symbol);
		int typeCurrent = -1;
		if(type == null) {
			typeCurrent = TYPE_SYMBOL;
		} else {
			typeCurrent = type.intValue();
		}
		if(
					((isSymbol(typeCurrent, SYMBOL_LS) || isSymbol(typeCurrent, SYMBOL_BS)) && !isSymbol(typeLast, SYMBOL_RN)) ||
					((isSymbol(typeLast, SYMBOL_RS) || isSymbol(typeLast, SYMBOL_BS)) && !isSymbol(typeCurrent, SYMBOL_LN))
		) {
			
			printWSNoDup();
		}
		out.printSymbol(symbol);
		typeLast = typeCurrent;
	}
	
//	private void printIdentifier(String ident) {
//		printIdentifier(ident, false);
//	}
	
	private void printIdentifier(String ident, boolean orKeyword) {
		printDisambiguationWS();
		boolean simpleIdent = ident.matches("[_a-zA-Z][_a-zA-Z0-9]*");
		if(simpleIdent && !orKeyword)
				simpleIdent = !keywords.contains(ident);
		if((!orKeyword) && kwCheckIgnoreCase && keywords.contains(ident.toUpperCase())) {
			simpleIdent = false;
		}
		if(simpleIdent) {
			out.printIdentifier(ident);
		} else {
			out.printEscapedIdentifier(identEscStart, ident, identEscEnd);
		}
		typeLast = TYPE_IDENT;
	}
	
	private void printBooleanLiteral(boolean v) {
		printDisambiguationWS();
		out.printBoolean(v);
		typeLast = TYPE_BOOL;
	}

	private void printIntegerLiteral(int v) {
		printDisambiguationWS();
		out.printInteger(v);
		typeLast = TYPE_INT;
	}

	static {
		dfs.setDecimalSeparator('.');
	}
	
	private void printRealLiteral(double v) {
		printDisambiguationWS();
		out.printReal(df.format(v));	// TODO: format properly
		typeLast = TYPE_REAL;
	}

	private void printStringLiteral(String v) {
		printDisambiguationWS();
		out.printString(stringDelim, v);
		typeLast = TYPE_STRING;
	}

	private void printComment(String c) {
		printDisambiguationWS();
		out.printComment(c);
		typeLast = TYPE_COMMENT;
	}

	// Source model navigation helpers.
	
	private static Object getPArg(ModelAdapter ma, Object ame, String name) {
		Object ret = null;
		
		for(Iterator i = ma.getCol(ame, "propertyArgs") ; i.hasNext() && (ret == null) ; ) {
			Object arg = i.next();
			if(ma.getTypeName(arg).equals(name + "PArg"))
				ret = arg;
		}
		
		return ret;
	}

	private static Object getBArg(ModelAdapter ma, Object ame, String name) {
		Object ret = null;
		
		for(Iterator i = ma.getCol(ame, "blockArgs") ; i.hasNext() && (ret == null) ; ) {
			Object arg = i.next();
			if(ma.getTypeName(arg).equals(name + "BArg"))
				ret = arg;
		}
		
		return ret;
	}
	
	private boolean debug = false;
	private boolean debugws = false;
	
	private void debug(String msg) {
		if(debug)
			System.out.println(msg);
	}
	
	private void error(String msg) {
		System.out.println("ERROR: " + msg);
	}
}
