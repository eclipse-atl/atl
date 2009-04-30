/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.asm.lib;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.engine.emfvm.ASMOperation;
import org.eclipse.m2m.atl.engine.emfvm.StackFrame;
import org.eclipse.m2m.atl.engine.emfvm.VMException;
import org.eclipse.m2m.atl.engine.emfvm.lib.Operation;
import org.eclipse.m2m.atl.engine.emfvm.lib.Tuple;

/**
 * Simple query language evaluator. This is used in the present version of the compiler. Recognized grammar:
 * <code>
 * exp ::= (simpleExp '+' exp) | simpleExp | INT | STRING | ('(' exp ')')
 * simpleExp ::= '$' varName:IDENT ('.' propName:IDENT ('(' ')')? ('[' ("ISA" '(' mname:IDENT '!' mename:IDENT ')') | (propName:IDENT '=' value:exp) | (index:exp) ']')*)* (',' default:exp)?;
 * IDENT ::= [A-Za-z_][A-Za-z0-9_]*;
 * VALUE ::= STRING | INT;
 * STRING ::= '[^']';
 * INT ::= [0-9]+;
 * SKIP ::= ' ' | '\t' | '\n' | '\r';
 * </code>
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class SOTSExpression2 {

	public SOTSExpression2(String exp) {
		this.exp = exp;
		in = new StringReader(exp);
	}

	public Object exec(StackFrame frame, Tuple args) throws IOException {
		return exp(frame, args);
	}

	private Object exp(StackFrame frame, Tuple args) throws IOException {
		Object ret = null;
		Token t = null;

		t = next();
		if (t.type == Token.LPAREN) {
			ret = exp(frame, args);
			match(Token.RPAREN);
			return ret;
		} else if ((t.type == Token.STRING) || (t.type == Token.INT)) {
			ret = convValue(t);
		} else {
			unread(t);
			ret = simpleExp(frame, args);
		}
		t = next();
		if (t.type == Token.PLUS) {
			Object right = exp(frame, args);
			if (right == null) {
				ret = null;
			} else if (ret instanceof Integer) {
				ret = new Integer(((Integer)ret).intValue() + ((Integer)right).intValue());
			} else if (ret instanceof String) {
				ret = ((String)ret) + right.toString();
			} else {
				ATLLogger.severe("Could not add type " + ret.getClass() + ".");
			}
		} else {
			unread(t);
		}

		return ret;
	}

	private Object simpleExp(StackFrame frame, Tuple args) throws IOException {
		Token t = null;
		Object ret = null;

		t = match(Token.IDENT);
		ret = args.get(frame, t.value);

		boolean done = false;
		do {

			t = next();
			EObject ame = null;
			ArrayList col = null;
			Object value = null;
			switch (t.type) {
				case Token.EOF:
					done = true;
					break;
				case Token.DOT:
					t = next();

					if ((t.type != Token.IDENT) && (t.type != Token.STRING))
						error(t);

					ret = toCollection(ret);

					col = new ArrayList();

					Token n = next();
					if (n.type == Token.LPAREN) {
						match(Token.RPAREN);

						for (Iterator i = ((Collection)ret).iterator(); i.hasNext();) {
							Object o = i.next();
							Object type = null;
							if (o instanceof EObject) {
								type = ((EObject)o).eClass();
							} else {
								type = o.getClass();
							}
							Operation oper = frame.getExecEnv().getOperation(type, t.value);

							if (oper != null) {
								Object v = null;
								StackFrame calleeFrame = (StackFrame)frame.newFrame(oper);
								Object[] arguments = calleeFrame.getLocalVars();
								arguments[0] = o;
								if (oper instanceof ASMOperation) {
									v = ((ASMOperation)oper).exec(calleeFrame, null);
								} else {
									v = oper.exec(calleeFrame);
								}
								col.add(v);
							} else {
								throw new VMException(frame, "Could not find operation " + t.value + " on "
										+ o);
							}

						}
					} else {
						unread(n);

						for (Iterator i = ((ArrayList)ret).iterator(); i.hasNext();) {
							ame = (EObject)i.next();
							if (t.type == Token.IDENT) {
								EStructuralFeature f = ame.eClass().getEStructuralFeature(t.value);
								Object v = ame.eGet(f);
								if (v != null)
									col.add(v);
							} else
								col.add(new String(t.value));
						}
					}
					ret = flatten(col);
					break;
				case Token.COMA:
					if ((ret == null) || ((ret instanceof ArrayList) && ((ArrayList)ret).size() == 0)) {
						value = exp(frame, args);
						ret = value;
					}
					break;
				case Token.LSQUARE:
					t = next();

					ret = toCollection(ret);
					col = new ArrayList();

					if (t.type == Token.ISA) {
						match(Token.LPAREN);
						String mname = match(Token.IDENT).value;
						match(Token.EXCL);
						String mename = match(Token.IDENT).value;
						match(Token.RPAREN);
						String expectedTypeName = mname + "!" + mename;
						for (Iterator i = ((ArrayList)ret).iterator(); i.hasNext();) {
							ame = (EObject)i.next();
							String typeName = ame.eClass().getName();
							if (typeName.equals(expectedTypeName)) {
								col.add(ame);
							}
						}
						ret = col;
					} else if (t.type == Token.INT) {
						unread(t);
						exp(frame, args);
						if (((ArrayList)ret).size() > 0)
							ret = ((ArrayList)ret).iterator().next(); // TODO: index rather than
						// first
						else
							ret = null;
					} else {
						if (t.type != Token.IDENT)
							error(t);
						String propName = t.value;
						match(Token.EQ);
						value = exp(frame, args);
						for (Iterator i = ((Collection)ret).iterator(); i.hasNext();) {
							ame = (EObject)i.next();
							EStructuralFeature f = ame.eClass().getEStructuralFeature(propName);
							if (ame.eGet(f).equals(value)) {
								col.add(ame);
							}
						}
						ret = col;
					}
					match(Token.RSQUARE);
					break;
				default:
					unread(t);
					done = true;
					break;
			}
		} while (!done);
		return ret;
	}

	private Object toCollection(Object value) {
		ArrayList ret = null;

		if (value instanceof ArrayList) {
			ret = (ArrayList)value;
		} else {
			Object elem = value;
			ret = new ArrayList();
			if (elem != null)
				ret.add(elem);
		}

		return ret;
	}

	private Object convValue(Token value) {
		Object ret = null;

		if (value.type == Token.INT) {
			ret = new Integer(java.lang.Integer.parseInt(value.value));
		} else {
			ret = new String(value.value);
		}

		return ret;
	}

	private void error(Token t) throws IOException {
		throw new IOException("ERROR: unexpected " + t);
	}

	private Token match(int type) throws IOException {
		Token ret = next();

		if (ret.type != type)
			error(ret);

		return ret;
	}

	private void unread(Token t) {
		readAhead = t;
	}

	private Token next() throws IOException {
		Token ret = null;
		String value = "";

		if (readAhead != null) {
			Token tmp = readAhead;
			readAhead = null;
			return tmp;
		}

		int c = in.read();
		switch (c) {
			case ' ':
			case '\t':
			case '\n':
			case '\r':
				do {
					in.mark(1);
					c = in.read();
				} while ((c == ' ') || (c == '\t') || (c == '\n') || (c == '\r'));
				in.reset();
				ret = next();
				break;
			case -1:
				ret = new Token(Token.EOF, "<EOF>");
				break;
			case '.':
				ret = new Token(Token.DOT, ".");
				break;
			case ',':
				ret = new Token(Token.COMA, ",");
				break;
			case '!':
				ret = new Token(Token.EXCL, "!");
				break;
			case '=':
				ret = new Token(Token.EQ, "=");
				break;
			case '+':
				ret = new Token(Token.PLUS, "+");
				break;
			case '[':
				ret = new Token(Token.LSQUARE, "[");
				break;
			case ']':
				ret = new Token(Token.RSQUARE, "]");
				break;
			case '(':
				ret = new Token(Token.LPAREN, "(");
				break;
			case ')':
				ret = new Token(Token.RPAREN, ")");
				break;
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				do {
					value += (char)c;
					in.mark(1);
					c = in.read();
				} while ((c >= '0') && (c <= '9'));
				in.reset();
				ret = new Token(Token.INT, value);
				break;
			case '\'':
				while ((c = in.read()) != '\'') {
					value += (char)c;
				}
				ret = new Token(Token.STRING, value);
				break;
			case 'A':
			case 'B':
			case 'C':
			case 'D':
			case 'E':
			case 'F':
			case 'G':
			case 'H':
			case 'I':
			case 'J':
			case 'K':
			case 'L':
			case 'M':
			case 'N':
			case 'O':
			case 'P':
			case 'Q':
			case 'R':
			case 'S':
			case 'T':
			case 'U':
			case 'V':
			case 'W':
			case 'X':
			case 'Z':
			case '_':
			case 'a':
			case 'b':
			case 'c':
			case 'd':
			case 'e':
			case 'f':
			case 'g':
			case 'h':
			case 'i':
			case 'j':
			case 'k':
			case 'l':
			case 'm':
			case 'n':
			case 'o':
			case 'p':
			case 'q':
			case 'r':
			case 's':
			case 't':
			case 'u':
			case 'v':
			case 'w':
			case 'x':
			case 'z':
				do {
					value += (char)c;
					in.mark(1);
					c = in.read();
				} while (((c >= '0') && (c <= '9')) || ((c >= 'A') && (c <= 'Z'))
						|| ((c >= 'a') && (c <= 'z')) || (c == '_'));
				in.reset();
				if (value.equals("ISA")) {
					ret = new Token(Token.ISA, value);
				} else {
					ret = new Token(Token.IDENT, value);
				}
				break;
			case '$':
				ret = next(); // ignore '$'
				break;
			default:
				ATLLogger.severe("ERROR: unexpected char \'" + (char)c + "\'.");
				break;
		}

		return ret;
	}

	private static String[] tokenNames = {"EOF", "DOT", "COMA", "EXCL", "EQ", "PLUS", "LSQUARE", "RSQUARE",
			"LPAREN", "RPAREN", "INT", "STRING", "IDENT", "ISA"};

	private class Token {
		public static final int EOF = 0;

		public static final int DOT = 1;

		public static final int COMA = 2;

		public static final int EXCL = 3;

		public static final int EQ = 4;

		public static final int PLUS = 5;

		public static final int LSQUARE = 6;

		public static final int RSQUARE = 7;

		public static final int LPAREN = 8;

		public static final int RPAREN = 9;

		public static final int INT = 10;

		public static final int STRING = 11;

		public static final int IDENT = 12;

		public static final int ISA = 13;

		public Token(int type, String value) {
			this.type = type;
			this.value = value;
		}

		public String toString() {
			return tokenNames[type] + ":" + value;
		}

		public int type;

		public String value;
	}

	private String exp;

	private Reader in;

	private Token readAhead = null;

	private Collection flatten(Collection coll) {
		Collection base = null;
		boolean containsCollection;
		do {
			base = coll;
			coll = new ArrayList();
			containsCollection = false;
			for (Iterator iterator = base.iterator(); iterator.hasNext();) {
				Object object = iterator.next();
				if (object instanceof Collection) {
					Collection subCollection = (Collection)object;
					coll.addAll(subCollection);
					Iterator iterator2 = subCollection.iterator();
					while (!containsCollection && iterator2.hasNext()) {
						Object subCollectionObject = iterator2.next();
						if (subCollectionObject instanceof Collection) {
							containsCollection = true;
						}
					}
				} else {
					coll.add(object);
				}
			}
		} while (containsCollection);
		return coll;
	}
}
