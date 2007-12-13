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
    
    public static final RGB APPEARANCE_BACKGROUND_COLOR = new RGB(255, 221, 218);
	public static final boolean APPEARANCE_CURRENT_LINE = true;
	public static final RGB APPEARANCE_CURRENT_LINE_COLOR = new RGB(225, 235, 224);
    public static final RGB APPEARANCE_FOREGROUND_COLOR = new RGB(0, 0, 0);
	public static final boolean APPEARANCE_HIGHLIGHT_CURRENT_LINE = true;
	public static final boolean APPEARANCE_HIGHLIGHT_MATCHING_BRACKETS = true;
	public static final RGB APPEARANCE_HIGHLIGHT_MATCHING_BRACKETS_COLOR = new RGB(192, 192, 192);
	public static final RGB APPEARANCE_LINE_NUMBER_COLOR = new RGB(0, 0, 0);
	public static final boolean APPEARANCE_LINE_NUMBER_RULER = false;
    public static final boolean APPEARANCE_PRINT_MARGIN = false;
    public static final RGB APPEARANCE_PRINT_MARGIN_COLOR = new RGB(176, 180, 185);
    public static final int APPEARANCE_PRINT_MARGIN_COLUMN = 80;
    public static final boolean APPEARANCE_SELECTION_BACKGROUND_DEFAULT = true;
    public static final boolean APPEARANCE_SELECTION_FOREGROUND_DEFAULT = true;
    public static final int APPEARANCE_TAB_WIDTH = 4;
	
	public static final int CODEASSIST_AUTOACTIVATION_DELAY = 500;
	public static final boolean CODEASSIST_AUTOACTIVATION_ENABLE = false;
	public static final String CODEASSIST_AUTOACTIVATION_TRIGGERS = " ";
    public static final boolean CODEASSIST_AUTOINSERT = false;
    public static final boolean CODEASSIST_CASE_SENSITIVITY = false;
    public static final boolean CODEASSIST_ORDER_PROPOSALS = false;
	public static final RGB CODEASSIST_PARAMETERS_BACKGROUND_COLOR = new RGB(254, 241, 233);
	public static final RGB CODEASSIST_PARAMETERS_FOREGROUND_COLOR = new RGB(0, 0, 0);
    public static final boolean CODEASSIST_PREFIX_COMPLETION = false;
	public static final RGB CODEASSIST_PROPOSALS_BACKGROUND_COLOR = new RGB(254, 241, 233);
	public static final RGB CODEASSIST_PROPOSALS_FOREGROUND_COLOR = new RGB(0, 0, 0);
	public static final RGB CODEASSIST_REPLACEMENT_BACKGROUND_COLOR = new RGB(255, 255, 0);
	public static final RGB CODEASSIST_REPLACEMENT_FOREGROUND_COLOR = new RGB(255, 0, 0);
    public static final boolean CODEASSIST_SHOW_VISIBLE_PROPOSALS = true;

	public static final boolean EDITOR_BACKGROUND_COLOR_DEFAULT = true;
	public static final boolean EDITOR_CURRENT_LINE = true;
	public static final RGB EDITOR_CURRENT_LINE_COLOR = new RGB(225, 235, 224);
	public static final RGB EDITOR_FIND_SCOPE_COLOR = new RGB(185, 176, 180);
	public static final boolean EDITOR_FOREGROUND_COLOR_DEFAULT = true;
	public static final boolean EDITOR_HIGHLIGHT_CURRENT_LINE = true;
	public static final boolean EDITOR_HIGHLIGHT_MATCHING_BRACKETS = true;
	public static final boolean EDITOR_SHOW_LINE_NUMBER = false;
	public static final boolean EDITOR_SMART_BACKSPACE = true;
	
	public static final boolean SYNTAX_BRACKET_BOLD = false;
	public static final RGB SYNTAX_BRACKET_COLOR = new RGB(0, 0, 0);
	public static final boolean SYNTAX_BRACKET_ITALIC = false;
	public static final boolean SYNTAX_CONSTANT_BOLD = false;
	public static final RGB SYNTAX_CONSTANT_COLOR = new RGB(0, 192, 128);
	public static final boolean SYNTAX_CONSTANT_ITALIC = false;
	public static final boolean SYNTAX_DEFAULT_BOLD = false;
	public static final RGB SYNTAX_DEFAULT_COLOR = new RGB(0, 0, 0);
	public static final boolean SYNTAX_DEFAULT_ITALIC = false;
	public static final boolean SYNTAX_IDENTIFIER_BOLD = false;
	public static final RGB SYNTAX_IDENTIFIER_COLOR = new RGB(0, 0, 0);
	public static final boolean SYNTAX_IDENTIFIER_ITALIC = true;
	public static final boolean SYNTAX_KEYWORD_BOLD = true;
	public static final RGB SYNTAX_KEYWORD_COLOR = new RGB(127, 0, 85);
	public static final boolean SYNTAX_KEYWORD_ITALIC = false;
	public static final boolean SYNTAX_LITERAL_BOLD = false;
	public static final RGB SYNTAX_LITERAL_COLOR = new RGB(42, 0, 255);
	public static final boolean SYNTAX_LITERAL_ITALIC = false;
	public static final boolean SYNTAX_NUMBER_BOLD = false;
	public static final RGB SYNTAX_NUMBER_COLOR = new RGB(0, 0, 0);
	public static final boolean SYNTAX_NUMBER_ITALIC = false;
	public static final boolean SYNTAX_OPERATOR_BOLD = false;
	public static final RGB SYNTAX_OPERATOR_COLOR = new RGB(0, 0, 0);
	public static final boolean SYNTAX_OPERATOR_ITALIC = false;
	public static final boolean SYNTAX_SINGLE_LINE_COMMENT_BOLD = false;
	public static final RGB SYNTAX_SINGLE_LINE_COMMENT_COLOR = new RGB(63, 127, 95);
	public static final boolean SYNTAX_SINGLE_LINE_COMMENT_ITALIC = false;
	public static final boolean SYNTAX_STRING_BOLD = false;
	public static final RGB SYNTAX_STRING_COLOR = new RGB(42, 0, 255);
	public static final boolean SYNTAX_STRING_ITALIC = false;
	public static final boolean SYNTAX_SYMBOL_BOLD = false;
	public static final RGB SYNTAX_SYMBOL_COLOR = new RGB(0, 0, 0);
	public static final boolean SYNTAX_SYMBOL_ITALIC = false;
	public static final boolean SYNTAX_TYPE_BOLD = false;
	public static final RGB SYNTAX_TYPE_COLOR = new RGB(0, 192, 0);
	public static final boolean SYNTAX_TYPE_ITALIC = false;
	
    public static final boolean TYPING_CLOSE_BRACES = true;
    public static final boolean TYPING_CLOSE_BRACKETS = true;
    public static final boolean TYPING_CLOSE_STRINGS = true;
    public static final boolean TYPING_ESCAPE_STRINGS = false;
    public static final boolean TYPING_IMPORTS_ON_PASTE = true;
    public static final boolean TYPING_SMART_OPENING_BRACE = false;
    public static final boolean TYPING_SMART_PASTE = true;
    public static final boolean TYPING_SMART_SEMICOLON = false;
    public static final boolean TYPING_SMART_TAB = true;
    public static final boolean TYPING_SPACES_FOR_TABS = false;
    public static final boolean TYPING_WRAP_STRINGS = true;
	
}
