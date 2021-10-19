/**
 * Copyright (c) 2004, 2008, 2014 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     INRIA - initial API and implementation
 *     Dennis Wagelaar
 *
 * $Id: ParserWrapper.java,v 1.1 2009/04/21 14:12:27 wpiers Exp $
 */
package org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3;

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

	@Override
	public Object parse(final int tabSize, final String name, final String productionRule, final Reader isr,
			final Map<?, ?> params) throws Exception {
		Class<?> lexerClass = (Class<?>)params.get("lexerClass");
		Class<?> parserClass = (Class<?>)params.get("parserClass");
		if((lexerClass == null) || (parserClass == null)) {
			final URL extraClasspath[] = (URL[])params.get("extraClasspath");
			ClassLoader cl = ParserWrapper.class.getClassLoader();
			if(extraClasspath != null) {
				cl = new TCSClassLoader(extraClasspath, cl);
			}
			if(lexerClass == null) {
				try {
					lexerClass = cl.loadClass(pack + name + "_ANTLR3Lexer");
				} catch (final ClassNotFoundException e) {
					throw new IllegalArgumentException("Unable to locate lexer class with name " + name);
				}
			}
			if(parserClass == null) {
				try {
					parserClass = cl.loadClass(pack + name + "_ANTLR3Parser");
				} catch (final ClassNotFoundException e) {
					//throw new IllegalArgumentException("Unable to locate parser class with name " + name, e);
					throw new IllegalArgumentException("Unable to locate parser class with name " + name);
				}
			}
		}


		final ANTLRReaderStream stream = new ANTLRReaderStream(isr);

		lexer = (Lexer)lexerClass.getDeclaredConstructor(new Class[] {CharStream.class}).newInstance(new Object[] {stream});

		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		try {
			TT_NL = ((Integer)parserClass.getField("NL").get(null)).intValue();
			tokens.setTokenTypeChannel(TT_NL, 99);
			//tokens.discardTokenType(TT_NL);
		} catch(final Exception e) {
		}
		try {
			TT_WS = ((Integer)parserClass.getField("WS").get(null)).intValue();
			tokens.discardTokenType(TT_WS);
		} catch(final Exception e) {
		}
		try {
			TT_COMMENT = ((Integer)parserClass.getField("COMMENT").get(null)).intValue();
			tokens.setTokenTypeChannel(TT_COMMENT, 99);
			//tokens.discardTokenType(TT_COMMENT);
		} catch(final Exception e) {
		}

		parser = (Parser)parserClass.getDeclaredConstructor(new Class[] {TokenStream.class}).newInstance(new Object[] {tokens});

		Field f = parserClass.getField("ei");
		f.set(parser, runtime);

		f = lexerClass.getField("ei");
		f.set(lexer, runtime);

		final Method m = parserClass.getMethod(productionRule, new Class[] {});
		Object ret = null;
		try {
			ret = m.invoke(parser, new Object[] {});
		} catch(final java.lang.reflect.InvocationTargetException ite) {
			ite.getCause().printStackTrace(System.out);
		}

		return ret;
	}

	@Override
	public void reportError(final Exception e) {
		final RecognitionException re = (RecognitionException)e;
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
	private List<Token> setTokenListBefore(final TokenStream input, final int index) {
		final List<Token> cb = new ArrayList<>();
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
	@Override
	public void setCommentsBefore(final Object ame, final Object params_) {
		if(params_ instanceof Object[]) {
			final Object params[] = (Object[])params_;
			if((params[0] == null) || (params[1] == null)) return;
			final TokenStream input = (TokenStream)params[0];
			final int index = ((Token)params[1]).getTokenIndex();

			setComments(setTokenListBefore(input, index), ame, true, "commentsBefore");
		}
	}
	/**
	 * set us a list with the comments after a model element.
	 * @param input
	 * @param index
	 * @return set of tokens
	 */
	private List<Token> setTokenListAfter(final TokenStream input, final int index) {
		final List<Token> ca = new ArrayList<>();
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
	private void setComments(final List<Token> commentList, final Object ame, final boolean inverseOrder,
			final String elementName) {
		if(runtime.isKeepComments()) {
			if(commentList.size() > 0) {
				final List<String> aList = new ArrayList<>();
				for (final Iterator<Token> tokens = commentList.iterator(); tokens.hasNext();) {
					final Token token = tokens.next();
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
				} catch(final Exception e) {
					runtime.reportProblem("Warning", "could not set comments of " + ame + ", disabling further comments setting", ame);
					runtime.setKeepComments(false);
				}
			}
		}

	}
	@Override
	public void setCommentsAfter(final Object ame, final Object params_) {
		if(params_ instanceof Object[]) {
			final Object params[] = (Object[])params_;
			if((params[0] == null) || (params[1] == null)) return;

			final TokenStream input = (TokenStream)params[0];
			final int index = ((Token)params[1]).getTokenIndex();

			setComments(setTokenListAfter(input, index), ame, false,"commentsAfter");

			runtime.setLastWasCreation(false);
		}
	}

	@Override
	public String getLocation(final Object token) {
		final ANTLR3LocationToken lt = ((ANTLR3LocationToken)token);
		return lt.getLine() + ":" + (lt.getCharPositionInLine() + 1) + "-" + lt.getEndLine() + ":" + (lt.getEndColumn() + 1);
	}

	@Override
	public int getStartOffset(final Object token) {
		final CommonToken t = ((CommonToken)token);
		return t.getStartIndex();
	}

	@Override
	public int getEndOffset(final Object token) {
		final CommonToken t = ((CommonToken)token);
		return t.getStopIndex();
	}

	@Override
	public Object getLastToken() {
		return parser.getTokenStream().LT(-1);
	}
}
