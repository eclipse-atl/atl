package org.atl.engine.vm.nativelib;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Iterator;

import org.atl.engine.vm.ASMExecEnv;
import org.atl.engine.vm.Operation;
import org.atl.engine.vm.StackFrame;

/**
 * Simple query language evaluator.
 * This is used in the present version of the compiler.
 * 
 * Recognized grammar:
 * <code>
 * exp ::= (simpleExp '+' exp) | simpleExp | INT | STRING | ('(' exp ')')
 * simpleExp ::= '$' varName:IDENT ('.' propName:IDENT ('(' ')')? ('[' ("ISA" '(' mname:IDENT '!' mename:IDENT ')') | (propName:IDENT '=' value:exp) | (index:exp) ']')*)* (',' default:exp)?;
 * IDENT ::= [A-Za-z_][A-Za-z0-9_]*;
 * VALUE ::= STRING | INT;
 * STRING ::= '[^']';
 * INT ::= [0-9]+;
 * SKIP ::= ' ' | '\t' | '\n' | '\r';
 * </code>
 * @author Frédéric Jouault
 */
public class SOTSExpression2 {

	private static final boolean debug = false;

	public SOTSExpression2(String exp) {
		this.exp = exp;
		in = new StringReader(exp);
	}

	public ASMOclAny exec(StackFrame frame, ASMTuple args) throws IOException {
if(debug) System.out.println("Trying to execute " + exp);
		ASMOclAny ret = exp(frame, args);
if(debug) System.out.println("\treturn value = " + ret);
		return ret;
	}

	private ASMOclAny exp(StackFrame frame, ASMTuple args) throws IOException {
		ASMOclAny ret = null;
		Token t = null;

		t = next();
		if(t.type == Token.LPAREN) {
			ret = exp(frame, args);
			match(Token.RPAREN);
			return ret;
		} else if((t.type == Token.STRING) || (t.type == Token.INT)) {
			ret = convValue(t);
		} else {
			unread(t);
			ret = simpleExp(frame, args);
		}
		t = next();
		if(t.type == Token.PLUS) {
			ASMOclAny right = exp(frame, args);
			if(right == null) {
				ret = null;
			} else if(ret instanceof ASMInteger) {
				ret = ASMInteger.operatorPlus(frame, (ASMInteger)ret, (ASMInteger)right);
			} else if(ret instanceof ASMString) {
				if(right instanceof ASMString) {
					ret = ASMString.operatorPlus(frame, (ASMString)ret, (ASMString)right);
				} else {
					ret = ASMString.operatorPlus(frame, (ASMString)ret, new ASMString(right.toString()));
				}
			} else {
				System.out.println("ERROR: could not add type " + ASMOclAny.oclType(frame, ret) + ".");
			}
		} else {
			unread(t);
		}

		return ret;
	}

	private ASMOclAny simpleExp(StackFrame frame, ASMTuple args) throws IOException {
		Token t = null;
		ASMOclAny ret = null;

		t = match(Token.IDENT);
		ret = args.get(frame, t.value);

		boolean done = false;
		do {
if(debug)
	System.out.println("\tcontext = " + ret + ((ret != null) ? " : " + ASMOclAny.oclType(frame, ret) : ""));
			t = next();
			ASMModelElement ame = null;
			ASMSequence col = null;
			ASMOclAny value = null;
			switch(t.type) {
				case Token.EOF:
					done = true;
					break;
				case Token.DOT:
					t = next();

					if((t.type != Token.IDENT) && (t.type != Token.STRING))
						error(t);

					ret = toCollection(ret);

					col = new ASMSequence();

					Token n = next();
					if(n.type == Token.LPAREN) {
						match(Token.RPAREN);

						for(Iterator i = ((ASMSequence)ret).iterator() ; i.hasNext() ; ) {
							ASMOclAny o = (ASMOclAny)i.next();
							Operation oper = ((ASMExecEnv)frame.getExecEnv()).getOperation(o.getType(), t.value);

							if(oper != null) {
								ASMOclAny v = oper.exec(frame.enterFrame(oper, Arrays.asList(new Object[] {o})));
								col.add(v);
							} else {
								frame.printStackTrace("ERROR: could not find operation " + t.value + " on " + o.getType() + " having supertypes: " + o.getType().getSupertypes());
							}

						}
					} else {
						unread(n);

						for(Iterator i = ((ASMSequence)ret).iterator() ; i.hasNext() ; ) {
							ame = (ASMModelElement)i.next();
							if(t.type == Token.IDENT) {
								ASMOclAny v = ame.get(frame, t.value);
								if(!(v instanceof ASMOclUndefined))
									col.add(v);
							} else
								col.add(new ASMString(t.value));
						}
					}
					ret = ASMSequence.flatten(frame, col);
					break;
				case Token.COMA:
//					t = next();
//					if(!(t.type == Token.INT) && !(t.type == Token.STRING)) {
//						error(t);
//					}
					if((ret == null) || ((ret instanceof ASMSequence) && (ASMSequence.size(frame, (ASMSequence)ret).getSymbol() == 0))) {
						value = exp(frame, args);
						ret = value;
					}
					break;
				case Token.LSQUARE:
					t = next();

					ret = toCollection(ret);
					col = new ASMSequence();

					if(t.type == Token.ISA) {
						match(Token.LPAREN);
						String mname = match(Token.IDENT).value;
						match(Token.EXCL);
						String mename = match(Token.IDENT).value;
						match(Token.RPAREN);
						String expectedTypeName = mname + "!" + mename;
						for(Iterator i = ((ASMSequence)ret).iterator() ; i.hasNext() ; ) {
							ame = (ASMModelElement)i.next();
							String typeName = ASMOclAny.oclType(frame, ame).toString();
							if(typeName.equals(expectedTypeName)) {
								col.add(ame);
							}
						}
						ret = col;
					} else if(t.type == Token.INT) {
						unread(t);
						int val = ((ASMInteger)exp(frame, args)).getSymbol();
						if(ASMSequence.size(frame, (ASMSequence)ret).getSymbol() > 0)
							ret = (ASMOclAny)((ASMSequence)ret).iterator().next();	// TODO: index rather than first
						else
							ret = null;
					} else {
						if(t.type != Token.IDENT)
							error(t);
						String propName = t.value;
						match(Token.EQ);
//						t = next();
//						if(!(t.type == Token.INT) && !(t.type == Token.STRING)) {
//							error(t);
//						}
//						ASMOclAny value = convValue(t);
						value = exp(frame, args);
						for(Iterator i = ((ASMCollection)ret).iterator() ; i.hasNext() ; ) {
							ame = (ASMModelElement)i.next();
							if(ame.get(frame, propName).equals(value)) {
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
		} while(!done);

if(debug) System.out.println("\tpartial return value = " + ret);
		return ret;
	}

	private ASMOclAny toCollection(ASMOclAny value) {
		ASMSequence ret = null;

		if(value instanceof ASMSequence) {
			ret = (ASMSequence)value;
		} else {
			ASMOclAny elem = value;
			ret = new ASMSequence();
			if(elem != null)
				ret.add(elem);
		}

		return ret;
	}

	private ASMOclAny convValue(Token value) {
		ASMOclAny ret = null;

		if(value.type == Token.INT) {
			ret = new ASMInteger(java.lang.Integer.parseInt(value.value));
		} else {
			ret = new ASMString(value.value);
		}

		return ret;
	}

	private void error(Token t) {
		System.out.println("ERROR: unexpected " + t);
new Exception().printStackTrace();
	}

	private Token match(int type) throws IOException {
		Token ret = next();

		if(ret.type != type)
			error(ret);

		return ret;
	}

	private void unread(Token t) {
		readAhead = t;
	}

	private Token next() throws IOException {
		Token ret = null;
		String value = "";

		if(readAhead != null) {
			Token tmp = readAhead;
			readAhead = null;
			return tmp;
		}

		int c = in.read();
		switch(c) {
			case ' ': case '\t': case '\n': case '\r':
				do {
					in.mark(1);
					c = in.read();
				} while(
					(c == ' ') || (c == '\t') ||
					(c == '\n') || (c == '\r')
				);
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
			case '0': case '1': case '2': case '3':
			case '4': case '5': case '6': case '7':
			case '8': case '9':
				do {
					value += (char)c;
					in.mark(1);
					c = in.read();
				} while((c >= '0') && (c <= '9'));
				in.reset();
				ret = new Token(Token.INT, value);
				break;
			case '\'':
				while((c = in.read()) != '\'') {
					value += (char)c;
				}
				ret = new Token(Token.STRING, value);
				break;
			case 'A': case 'B': case 'C': case 'D':
			case 'E': case 'F': case 'G': case 'H':
			case 'I': case 'J': case 'K': case 'L':
			case 'M': case 'N': case 'O': case 'P':
			case 'Q': case 'R': case 'S': case 'T':
			case 'U': case 'V': case 'W': case 'X':
			case 'Z': case '_':
			case 'a': case 'b': case 'c': case 'd':
			case 'e': case 'f': case 'g': case 'h':
			case 'i': case 'j': case 'k': case 'l':
			case 'm': case 'n': case 'o': case 'p':
			case 'q': case 'r': case 's': case 't':
			case 'u': case 'v': case 'w': case 'x':
			case 'z':
				do {
					value += (char)c;
					in.mark(1);
					c = in.read();
				} while(
					((c >= '0') && (c <= '9')) ||
					((c >= 'A') && (c <= 'Z')) ||
					((c >= 'a') && (c <= 'z')) ||
					(c == '_')
				);
				in.reset();
				if(value.equals("ISA")) {
					ret = new Token(Token.ISA, value);
				} else {
					ret = new Token(Token.IDENT, value);
				}
				break;
			case '$':
				ret = next();	// ignore '$'
				break;
			default:
				System.out.println("ERROR: unexpected char \'" + (char)c + "\'.");
				ret = next();	// trying to recover
				break;
		}

		return ret;
	}

	private static String tokenNames[] = {
		"EOF",
		"DOT",
		"COMA",
		"EXCL",
		"EQ",
		"PLUS",
		"LSQUARE",
		"RSQUARE",
		"LPAREN",
		"RPAREN",
		"INT",
		"STRING",
		"IDENT",
		"ISA"
	};

	private class Token {
		public static final int EOF	=	0;
		public static final int DOT	=	1;
		public static final int COMA	=	2;
		public static final int EXCL	=	3;
		public static final int EQ	=	4;
		public static final int PLUS	=	5;
		public static final int LSQUARE	=	6;
		public static final int RSQUARE	=	7;
		public static final int LPAREN	=	8;
		public static final int RPAREN	=	9;
		public static final int INT	=	10;
		public static final int STRING	=	11;
		public static final int IDENT	=	12;
		public static final int ISA	=	13;

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
}

