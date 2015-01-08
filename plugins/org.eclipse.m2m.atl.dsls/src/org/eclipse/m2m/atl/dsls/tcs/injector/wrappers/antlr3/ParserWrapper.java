/**
 * Copyright (c) 2004, 2008, 2014 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *     Dennis Wagelaar
 *
 * $Id: ParserWrapper.java,v 1.1 2009/04/21 14:12:27 wpiers Exp $
 */
package org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.m2m.atl.dsls.tcs.injector.TCSClassLoader;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class ParserWrapper extends org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.ParserWrapper {
	
	private Parser parser;
	private Lexer lexer;
	
	public ParserWrapper() {
	}
	
	public Object parse(int tabSize, String name, String productionRule, Reader isr, Map params) throws Exception {
		Class lexerClass = (Class)params.get("lexerClass");
		Class parserClass = (Class)params.get("parserClass");
		if((lexerClass == null) || (parserClass == null)) {
			URL extraClasspath[] = (URL[])params.get("extraClasspath");
			ClassLoader cl = ParserWrapper.class.getClassLoader();
			if(extraClasspath != null) {
				cl = new TCSClassLoader(extraClasspath, cl);
			}
			if(lexerClass == null) {
				try {
					lexerClass = cl.loadClass(pack + name + "_ANTLR3Lexer");
				} catch (ClassNotFoundException e) {
					throw new IllegalArgumentException("Unable to locate lexer class with name " + name);
				}
			}
			if(parserClass == null) {
				try {
					parserClass = cl.loadClass(pack + name + "_ANTLR3Parser");
				} catch (ClassNotFoundException e) {
					//throw new IllegalArgumentException("Unable to locate parser class with name " + name, e);
					throw new IllegalArgumentException("Unable to locate parser class with name " + name);
				}
			}
		}


		ANTLRReaderStream stream = new ANTLRReaderStream(isr);
		
		lexer = (Lexer)lexerClass.getDeclaredConstructor(new Class[] {CharStream.class}).newInstance(new Object[] {stream});
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		try {
			TT_NL = ((Integer)parserClass.getField("NL").get(null)).intValue();
			tokens.setTokenTypeChannel(TT_NL, 99);
			//tokens.discardTokenType(TT_NL);
		} catch(Exception e) {
		}
		try {
			TT_WS = ((Integer)parserClass.getField("WS").get(null)).intValue();
			tokens.discardTokenType(TT_WS);
		} catch(Exception e) {
		}
		try {
			TT_COMMENT = ((Integer)parserClass.getField("COMMENT").get(null)).intValue();
			tokens.setTokenTypeChannel(TT_COMMENT, 99);
			//tokens.discardTokenType(TT_COMMENT);
		} catch(Exception e) {
		}

		parser = (Parser)parserClass.getDeclaredConstructor(new Class[] {TokenStream.class}).newInstance(new Object[] {tokens});	

		Field f = parserClass.getField("ei");
		f.set(parser, runtime);

		f = lexerClass.getField("ei");
		f.set(lexer, runtime);

		Method m = parserClass.getMethod(productionRule, new Class[] {});
		Object ret = null;
		try {
			ret = m.invoke(parser, new Object[] {});
		} catch(java.lang.reflect.InvocationTargetException ite) {
			ite.getCause().printStackTrace(System.out);
		}		
		
		return ret;
	}

	public void reportError(Exception e) {
		RecognitionException re = (RecognitionException)e;
		String msg = null;
		if(re.input instanceof ANTLRStringStream) {
			msg = lexer.getErrorMessage(re, lexer.getTokenNames());			
		} else  {
			msg = parser.getErrorMessage(re, parser.getTokenNames());			
		}
		// TODO: try to use re.token to get a complete location (may not always be possible, like for lexer errors)
		runtime.reportProblem("Error", msg, re.line + ":" + (re.charPositionInLine + 1));			
	}

	/**
	 * set up a list with the comments before a model element. The list contains a set of tokens
	 * @param input
	 * @param index
	 * @return
	 */
	private List setTokenListBefore (TokenStream input, int index ){
		List cb = new ArrayList();
		if (index - 1 > 0 ) {
			for (int i = index - 1 ; i >= 0 && (
					input.get(i).getType() == TT_COMMENT || input.get(i).getType() == TT_NL) ; i--)  {
				cb.add(input.get(i));
			} 
		}
		return cb;		
	}
	
	/**
	 * sets the comments before a model element.
	 * the input is the current stream. the index is the index of the current token
	 */
	public void setCommentsBefore(Object ame, Object params_) {
		if(params_ instanceof Object[]) {
			Object params[] = (Object[])params_;
			if((params[0] == null) || (params[1] == null)) return;
			TokenStream input = (TokenStream)params[0];
			int index = ((Token)params[1]).getTokenIndex();

			setComments(setTokenListBefore(input, index), ame, true, "commentsBefore");
		}
	}
	/**
	 * set us a list with the comments after a model element. 
	 * @param input
	 * @param index
	 * @return set of tokens
	 */
	private List setTokenListAfter (TokenStream input, int index){
		List ca = new ArrayList();
		if (index + 1 > 0 ) {
			for (int i = index + 1; 
			i < input.size() && (
					input.get(i).getType() == TT_COMMENT || input.get(i).getType() == TT_NL)   	
					; i++)  {
				ca.add(input.get(i));
			}           
		}
		return ca;		
	}		
	/**
	 * 
	 * @param commentList a list with a set of tokens
	 * @param ame an ASM model element
	 * @param inverseOrder indicates if the elements of the list should be created in a normal order or on the inverse order
	 * @param elementName the name of the element that stores the comments
	 */
	private void setComments (List commentList, Object ame, boolean inverseOrder, String elementName){
		if(runtime.isKeepComments()) {
			if(commentList.size() > 0) {
				List aList = new ArrayList();
				for (Iterator tokens = commentList.iterator(); tokens.hasNext();) {
					Token token = (Token) tokens.next();
					if(token.getType() == TT_COMMENT) {
						if (inverseOrder)
							aList.add(0, token.getText());
						else
							aList.add(token.getText());
					} else if(token.getType() == TT_NL) {
						if(runtime.isKeepNL())
							if (inverseOrder)
								aList.add(0, "\n");
							else
								aList.add("\n");
					}
				}
				try {
					runtime.getTargetModelAdapter().set(ame, elementName, aList);
				} catch(Exception e) {
					runtime.reportProblem("Warning", "could not set comments of " + ame + ", disabling further comments setting", ame);
					runtime.setKeepComments(false);
				}
			}
		}
		
	}
	public void setCommentsAfter(Object ame, Object params_) {
		if(params_ instanceof Object[]) {
			Object params[] = (Object[])params_;
			if((params[0] == null) || (params[1] == null)) return;

			TokenStream input = (TokenStream)params[0];
			int index = ((Token)params[1]).getTokenIndex();

			setComments(setTokenListAfter(input, index), ame, false,"commentsAfter");

			runtime.setLastWasCreation(false);
		}
	}

	public String getLocation(Object token) {
		ANTLR3LocationToken lt = ((ANTLR3LocationToken)token);
		return lt.getLine() + ":" + (lt.getCharPositionInLine() + 1) + "-" + lt.getEndLine() + ":" + (lt.getEndColumn() + 1);
	}		

	public int getStartOffset(Object token) {
		CommonToken t = ((CommonToken)token);
		return t.getStartIndex();
	}
	
	public int getEndOffset(Object token) {
		CommonToken t = ((CommonToken)token);
		return t.getStopIndex();
	}

	public Object getLastToken() {
		return parser.getTokenStream().LT(-1);
	}
}
