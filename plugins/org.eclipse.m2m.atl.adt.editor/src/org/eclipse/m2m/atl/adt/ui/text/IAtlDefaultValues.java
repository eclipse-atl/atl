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

import org.eclipse.swt.graphics.RGB;

/**
 * This interface stores the RGB color of every preferences values.
 */
public interface IAtlDefaultValues {

	RGB APPEARANCE_BACKGROUND_COLOR = new RGB(255, 221, 218);

	boolean APPEARANCE_CURRENT_LINE = true;

	RGB APPEARANCE_CURRENT_LINE_COLOR = new RGB(225, 235, 224);

	RGB APPEARANCE_FOREGROUND_COLOR = new RGB(0, 0, 0);

	boolean APPEARANCE_HIGHLIGHT_CURRENT_LINE = true;

	boolean APPEARANCE_HIGHLIGHT_MATCHING_BRACKETS = true;

	RGB APPEARANCE_HIGHLIGHT_MATCHING_BRACKETS_COLOR = new RGB(192, 192, 192);

	RGB APPEARANCE_LINE_NUMBER_COLOR = new RGB(0, 0, 0);

	boolean APPEARANCE_LINE_NUMBER_RULER = false;

	boolean APPEARANCE_PRINT_MARGIN = false;

	RGB APPEARANCE_PRINT_MARGIN_COLOR = new RGB(176, 180, 185);

	int APPEARANCE_PRINT_MARGIN_COLUMN = 80;

	boolean APPEARANCE_SELECTION_BACKGROUND_DEFAULT = true;

	boolean APPEARANCE_SELECTION_FOREGROUND_DEFAULT = true;

	int APPEARANCE_TAB_WIDTH = 4;

	int CODEASSIST_AUTOACTIVATION_DELAY = 500;

	boolean CODEASSIST_AUTOACTIVATION_ENABLE = false;

	String CODEASSIST_AUTOACTIVATION_TRIGGERS = " "; //$NON-NLS-1$

	boolean CODEASSIST_AUTOINSERT = false;

	boolean CODEASSIST_CASE_SENSITIVITY = false;

	boolean CODEASSIST_ORDER_PROPOSALS = false;

	RGB CODEASSIST_PARAMETERS_BACKGROUND_COLOR = new RGB(254, 241, 233);

	RGB CODEASSIST_PARAMETERS_FOREGROUND_COLOR = new RGB(0, 0, 0);

	boolean CODEASSIST_PREFIX_COMPLETION = false;

	RGB CODEASSIST_PROPOSALS_BACKGROUND_COLOR = new RGB(254, 241, 233);

	RGB CODEASSIST_PROPOSALS_FOREGROUND_COLOR = new RGB(0, 0, 0);

	RGB CODEASSIST_REPLACEMENT_BACKGROUND_COLOR = new RGB(255, 255, 0);

	RGB CODEASSIST_REPLACEMENT_FOREGROUND_COLOR = new RGB(255, 0, 0);

	boolean CODEASSIST_SHOW_VISIBLE_PROPOSALS = true;

	boolean EDITOR_BACKGROUND_COLOR_DEFAULT = true;

	boolean EDITOR_CURRENT_LINE = true;

	RGB EDITOR_CURRENT_LINE_COLOR = new RGB(225, 235, 224);

	RGB EDITOR_FIND_SCOPE_COLOR = new RGB(185, 176, 180);

	boolean EDITOR_FOREGROUND_COLOR_DEFAULT = true;

	boolean EDITOR_HIGHLIGHT_CURRENT_LINE = true;

	boolean EDITOR_HIGHLIGHT_MATCHING_BRACKETS = true;

	boolean EDITOR_SHOW_LINE_NUMBER = false;

	boolean EDITOR_SMART_BACKSPACE = true;

	boolean SYNTAX_BRACKET_BOLD = false;

	RGB SYNTAX_BRACKET_COLOR = new RGB(0, 0, 0);

	boolean SYNTAX_BRACKET_ITALIC = false;

	boolean SYNTAX_CONSTANT_BOLD = false;

	RGB SYNTAX_CONSTANT_COLOR = new RGB(0, 192, 128);

	boolean SYNTAX_CONSTANT_ITALIC = false;

	boolean SYNTAX_DEFAULT_BOLD = false;

	RGB SYNTAX_DEFAULT_COLOR = new RGB(0, 0, 0);

	boolean SYNTAX_DEFAULT_ITALIC = false;

	boolean SYNTAX_IDENTIFIER_BOLD = false;

	RGB SYNTAX_IDENTIFIER_COLOR = new RGB(0, 0, 0);

	boolean SYNTAX_IDENTIFIER_ITALIC = true;

	boolean SYNTAX_KEYWORD_BOLD = true;

	RGB SYNTAX_KEYWORD_COLOR = new RGB(127, 0, 85);

	boolean SYNTAX_KEYWORD_ITALIC = false;

	boolean SYNTAX_BOLD_KEYWORD_BOLD = true;

	RGB SYNTAX_BOLD_KEYWORD_COLOR = new RGB(0, 0, 0);

	boolean SYNTAX_BOLD_KEYWORD_ITALIC = true;

	boolean SYNTAX_CONTEXT_KEYWORD_BOLD = true;

	RGB SYNTAX_CONTEXT_KEYWORD_COLOR = new RGB(129, 46, 156);

	boolean SYNTAX_CONTEXT_KEYWORD_ITALIC = false;

	boolean SYNTAX_LITERAL_BOLD = false;

	RGB SYNTAX_LITERAL_COLOR = new RGB(42, 0, 255);

	boolean SYNTAX_LITERAL_ITALIC = false;

	boolean SYNTAX_NUMBER_BOLD = false;

	RGB SYNTAX_NUMBER_COLOR = new RGB(0, 0, 0);

	boolean SYNTAX_NUMBER_ITALIC = false;

	boolean SYNTAX_OPERATOR_BOLD = false;

	RGB SYNTAX_OPERATOR_COLOR = new RGB(0, 0, 0);

	boolean SYNTAX_OPERATOR_ITALIC = false;

	boolean SYNTAX_SINGLE_LINE_COMMENT_BOLD = false;

	RGB SYNTAX_SINGLE_LINE_COMMENT_COLOR = new RGB(63, 127, 95);

	boolean SYNTAX_SINGLE_LINE_COMMENT_ITALIC = false;

	boolean SYNTAX_SINGLE_LINE_SPECIAL_COMMENT_BOLD = false;

	RGB SYNTAX_SINGLE_LINE_SPECIAL_COMMENT_COLOR = new RGB(63, 95, 191);

	boolean SYNTAX_SINGLE_LINE_SPECIAL_COMMENT_ITALIC = false;

	boolean SYNTAX_STRING_BOLD = false;

	RGB SYNTAX_STRING_COLOR = new RGB(42, 0, 255);

	boolean SYNTAX_STRING_ITALIC = false;

	boolean SYNTAX_SYMBOL_BOLD = false;

	RGB SYNTAX_SYMBOL_COLOR = new RGB(0, 0, 0);

	boolean SYNTAX_SYMBOL_ITALIC = false;

	boolean SYNTAX_TYPE_BOLD = false;

	RGB SYNTAX_TYPE_COLOR = new RGB(0, 192, 0);

	boolean SYNTAX_TYPE_ITALIC = false;

	boolean SYNTAX_ABSTRACT_TYPE_BOLD = false;

	RGB SYNTAX_ABSTRACT_TYPE_COLOR = new RGB(0, 192, 0);

	boolean SYNTAX_ABSTRACT_TYPE_ITALIC = true;

	boolean TYPING_CLOSE_BRACES = true;

	boolean TYPING_CLOSE_BRACKETS = true;

	boolean TYPING_CLOSE_STRINGS = true;

	boolean TYPING_ESCAPE_STRINGS = false;

	boolean TYPING_IMPORTS_ON_PASTE = true;

	boolean TYPING_SMART_OPENING_BRACE = false;

	boolean TYPING_SMART_PASTE = true;

	boolean TYPING_SMART_SEMICOLON = false;

	boolean TYPING_SMART_TAB = true;

	boolean TYPING_SPACES_FOR_TABS = false;

	boolean TYPING_WRAP_STRINGS = true;

}
