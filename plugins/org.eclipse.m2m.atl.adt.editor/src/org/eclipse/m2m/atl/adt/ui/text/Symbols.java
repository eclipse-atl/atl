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
 * Symbols for the heuristic scanner.
 */
public interface Symbols {

	int TOKEN_EOF = -1;

	int TOKEN_LBRACE = 1;

	int TOKEN_RBRACE = 2;

	int TOKEN_LBRACKET = 3;

	int TOKEN_RBRACKET = 4;

	int TOKEN_LPAREN = 5;

	int TOKEN_RPAREN = 6;

	int TOKEN_SEMICOLON = 7;

	int TOKEN_OTHER = 8;

	int TOKEN_COLON = 9;

	int TOKEN_QUESTIONMARK = 10;

	int TOKEN_COMMA = 11;

	int TOKEN_EQUAL = 12;

	int TOKEN_IF = 109;

	int TOKEN_DO = 1010;

	int TOKEN_FOR = 1011;

	int TOKEN_TRY = 1012;

	int TOKEN_CASE = 1013;

	int TOKEN_ELSE = 1014;

	int TOKEN_BREAK = 1015;

	int TOKEN_CATCH = 1016;

	int TOKEN_WHILE = 1017;

	int TOKEN_RETURN = 1018;

	int TOKEN_STATIC = 1019;

	int TOKEN_SWITCH = 1020;

	int TOKEN_FINALLY = 1021;

	int TOKEN_SYNCHRONIZED = 1022;

	int TOKEN_GOTO = 1023;

	int TOKEN_DEFAULT = 1024;

	int TOKEN_NEW = 1025;

	int TOKEN_IDENT = 2000;
}
