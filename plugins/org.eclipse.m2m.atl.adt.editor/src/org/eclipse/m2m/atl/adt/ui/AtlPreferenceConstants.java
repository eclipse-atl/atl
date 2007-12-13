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
package org.eclipse.m2m.atl.adt.ui;

import java.util.ArrayList;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.m2m.atl.adt.ui.preferences.AtlPreferenceStore;
import org.eclipse.m2m.atl.adt.ui.text.IAtlDefaultValues;
import org.eclipse.ui.editors.text.TextEditorPreferenceConstants;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants;
import org.eclipse.ui.texteditor.AbstractTextEditor;

/**
 * This class contains methods to product a correct preference fPreferenceeStore.
 * Each new key you want to add have to be inserted as a static final string, for which one you have to
 * initialize its type and its value, and thus permit to the new preference fPreferenceeStore to catch this value
 * from the <code>createStoreKeys()</code> method.
 */
public class AtlPreferenceConstants {
	
	public static final String __BOLD_SUFFIX = ".Bold";
	public static final String __COLOR_SUFFIX = ".Color";
	public static final String __ITALIC_SUFFIX = ".Italic";
	public static final String __PREFIX = "Atl";
	
	public static final String APPEARANCE = __PREFIX + ".Appearance";
	public static final String APPEARANCE_CURRENT_LINE = AbstractDecoratedTextEditorPreferenceConstants.EDITOR_CURRENT_LINE;
	public static final String APPEARANCE_CURRENT_LINE_COLOR = AbstractDecoratedTextEditorPreferenceConstants.EDITOR_CURRENT_LINE_COLOR;
	public static final String APPEARANCE_HIGHLIGHT_CURRENT_LINE = AbstractDecoratedTextEditorPreferenceConstants.EDITOR_CURRENT_LINE;
	public static final String APPEARANCE_HIGHLIGHT_MATCHING_BRACKETS = APPEARANCE + "HighlightMatchingBrackets";
	public static final String APPEARANCE_HIGHLIGHT_MATCHING_BRACKETS_COLOR = APPEARANCE_HIGHLIGHT_MATCHING_BRACKETS + __COLOR_SUFFIX;
	public static final String APPEARANCE_LINE_NUMBER_COLOR = AbstractDecoratedTextEditorPreferenceConstants.EDITOR_LINE_NUMBER_RULER_COLOR;
	public static final String APPEARANCE_LINE_NUMBER_RULER = AbstractDecoratedTextEditorPreferenceConstants.EDITOR_LINE_NUMBER_RULER;
	public static final String APPEARANCE_PRINT_MARGIN = AbstractDecoratedTextEditorPreferenceConstants.EDITOR_PRINT_MARGIN;
	public static final String APPEARANCE_PRINT_MARGIN_COLOR = AbstractDecoratedTextEditorPreferenceConstants.EDITOR_PRINT_MARGIN_COLOR;
	public static final String APPEARANCE_PRINT_MARGIN_COLUMN = AbstractDecoratedTextEditorPreferenceConstants.EDITOR_PRINT_MARGIN_COLUMN;
	public static final String APPEARANCE_SELECTION_BACKGROUND_COLOR = AbstractDecoratedTextEditorPreferenceConstants.EDITOR_SELECTION_BACKGROUND_COLOR;
	public static final String APPEARANCE_SELECTION_BACKGROUND_DEFAULT = AbstractDecoratedTextEditorPreferenceConstants.EDITOR_SELECTION_BACKGROUND_DEFAULT_COLOR;
	public static final String APPEARANCE_SELECTION_FOREGROUND_COLOR = AbstractDecoratedTextEditorPreferenceConstants.EDITOR_SELECTION_FOREGROUND_COLOR;
	public static final String APPEARANCE_SELECTION_FOREGROUND_DEFAULT = AbstractDecoratedTextEditorPreferenceConstants.EDITOR_SELECTION_FOREGROUND_DEFAULT_COLOR;
	public static final String APPEARANCE_TAB_WIDTH = AbstractDecoratedTextEditorPreferenceConstants.EDITOR_TAB_WIDTH;
	
	public static final String CODEASSIST = __PREFIX + ".CodeAssist";
	public static final String CODEASSIST_AUTOACTIVATION = CODEASSIST + ".AutoActivation";
	public static final String CODEASSIST_AUTOACTIVATION_DELAY = CODEASSIST_AUTOACTIVATION + ".Delay";
	public static final String CODEASSIST_AUTOACTIVATION_ENABLE = CODEASSIST_AUTOACTIVATION + ".Enable";
	public static final String CODEASSIST_AUTOACTIVATION_TRIGGERS = CODEASSIST_AUTOACTIVATION + ".Triggers";
	public static final String CODEASSIST_AUTOINSERT = CODEASSIST + ".AutoInsert";
	public static final String CODEASSIST_CASE_SENSITIVITY = CODEASSIST + ".CaseSensitivity";
	public static final String CODEASSIST_ORDER_PROPOSALS = CODEASSIST + ".OrderProposals";
	public static final String CODEASSIST_PARAMETERS_BACKGROUND = CODEASSIST + ".ParametersBackground";
	public static final String CODEASSIST_PARAMETERS_FOREGROUND = CODEASSIST + ".ParametersForeground";
	public static final String CODEASSIST_PREFIX_COMPLETION = CODEASSIST + ".PrefixCompletion";
	public static final String CODEASSIST_PROPOSALS_BACKGROUND = CODEASSIST + ".ProposalsBackground";
	public static final String CODEASSIST_PROPOSALS_FOREGROUND = CODEASSIST + ".ProposalsForeground";
	public static final String CODEASSIST_REPLACEMENT_BACKGROUND = CODEASSIST + ".ReplacementBackground";
	public static final String CODEASSIST_REPLACEMENT_FOREGROUND = CODEASSIST + "ReplacementForeground";
	public static final String CODEASSIST_SHOW_VISIBLE_PROPOSALS = CODEASSIST + ".ShowVisibleProposals";
	
	public static final String EDITOR = __PREFIX + ".Editor";
	public static final String EDITOR_BACKGROUND_COLOR = AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND;
	public static final String EDITOR_BACKGROUND_COLOR_DEFAULT = AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND_SYSTEM_DEFAULT;
	public static final String EDITOR_FOREGROUND_COLOR = AbstractTextEditor.PREFERENCE_COLOR_FOREGROUND;
	public static final String EDITOR_FOREGROUND_COLOR_DEFAULT = AbstractTextEditor.PREFERENCE_COLOR_FOREGROUND_SYSTEM_DEFAULT;
	public static final String EDITOR_SMART_BACKSPACE = EDITOR + ".SmartBackspace";
	
	public static final String HOVER = __PREFIX + ".Hover";
	public static final String HOVER_ANNOTATION_ROLL_OVER = HOVER + ".AnnotationRollOver";
	
	public static final String SYNTAX = __PREFIX + ".Syntax";
	public static final String SYNTAX_BRACKET = SYNTAX + ".Bracket";
	public static final String SYNTAX_BRACKET_BOLD = SYNTAX_BRACKET + __BOLD_SUFFIX;
	public static final String SYNTAX_BRACKET_COLOR = SYNTAX_BRACKET + __COLOR_SUFFIX;
	public static final String SYNTAX_BRACKET_ITALIC = SYNTAX_BRACKET + __ITALIC_SUFFIX;
	public static final String SYNTAX_CONSTANT = SYNTAX + ".Constant";
	public static final String SYNTAX_CONSTANT_BOLD = SYNTAX_CONSTANT + __BOLD_SUFFIX;
	public static final String SYNTAX_CONSTANT_COLOR = SYNTAX_CONSTANT + __COLOR_SUFFIX;
	public static final String SYNTAX_CONSTANT_ITALIC = SYNTAX_CONSTANT + __ITALIC_SUFFIX;
	public static final String SYNTAX_DEFAULT = SYNTAX + ".Default";
	public static final String SYNTAX_DEFAULT_BOLD = SYNTAX_DEFAULT + __BOLD_SUFFIX;
	public static final String SYNTAX_DEFAULT_COLOR = SYNTAX_DEFAULT + __COLOR_SUFFIX;
	public static final String SYNTAX_DEFAULT_ITALIC = SYNTAX_DEFAULT + __ITALIC_SUFFIX;
	public static final String SYNTAX_IDENTIFIER = SYNTAX + ".Identifier";
	public static final String SYNTAX_IDENTIFIER_BOLD = SYNTAX_IDENTIFIER + __BOLD_SUFFIX;
	public static final String SYNTAX_IDENTIFIER_COLOR = SYNTAX_IDENTIFIER + __COLOR_SUFFIX;
	public static final String SYNTAX_IDENTIFIER_ITALIC = SYNTAX_IDENTIFIER + __ITALIC_SUFFIX;
	public static final String SYNTAX_KEYWORD = SYNTAX + ".Keyword";
	public static final String SYNTAX_KEYWORD_BOLD = SYNTAX_KEYWORD + __BOLD_SUFFIX;
	public static final String SYNTAX_KEYWORD_COLOR = SYNTAX_KEYWORD + __COLOR_SUFFIX;
	public static final String SYNTAX_KEYWORD_ITALIC = SYNTAX_KEYWORD + __ITALIC_SUFFIX;
	public static final String SYNTAX_LITERAL = SYNTAX + ".Literal";
	public static final String SYNTAX_LITERAL_BOLD = SYNTAX_LITERAL + __BOLD_SUFFIX;
	public static final String SYNTAX_LITERAL_COLOR = SYNTAX_LITERAL + __COLOR_SUFFIX;
	public static final String SYNTAX_LITERAL_ITALIC = SYNTAX_LITERAL + __ITALIC_SUFFIX;
	public static final String SYNTAX_NUMBER = SYNTAX + ".Number";
	public static final String SYNTAX_NUMBER_BOLD = SYNTAX_NUMBER + __BOLD_SUFFIX;
	public static final String SYNTAX_NUMBER_COLOR = SYNTAX_NUMBER + __COLOR_SUFFIX;
	public static final String SYNTAX_NUMBER_ITALIC = SYNTAX_NUMBER + __ITALIC_SUFFIX;
	public static final String SYNTAX_OPERATOR = SYNTAX + ".Operator";
	public static final String SYNTAX_OPERATOR_BOLD = SYNTAX_OPERATOR + __BOLD_SUFFIX;
	public static final String SYNTAX_OPERATOR_COLOR = SYNTAX_OPERATOR + __COLOR_SUFFIX;
	public static final String SYNTAX_OPERATOR_ITALIC = SYNTAX_OPERATOR + __ITALIC_SUFFIX;
	public static final String SYNTAX_SINGLE_LINE_COMMENT = SYNTAX + ".SingleLineComment";
	public static final String SYNTAX_SINGLE_LINE_COMMENT_BOLD = SYNTAX_SINGLE_LINE_COMMENT + __BOLD_SUFFIX;
	public static final String SYNTAX_SINGLE_LINE_COMMENT_COLOR = SYNTAX_SINGLE_LINE_COMMENT + __COLOR_SUFFIX;
	public static final String SYNTAX_SINGLE_LINE_COMMENT_ITALIC  = SYNTAX_SINGLE_LINE_COMMENT + __ITALIC_SUFFIX;
	public static final String SYNTAX_STRING = SYNTAX + ".String";
	public static final String SYNTAX_STRING_BOLD = SYNTAX_STRING + __BOLD_SUFFIX;
	public static final String SYNTAX_STRING_COLOR = SYNTAX_STRING + __COLOR_SUFFIX;
	public static final String SYNTAX_STRING_ITALIC = SYNTAX_STRING + __ITALIC_SUFFIX;
	public static final String SYNTAX_SYMBOL = SYNTAX + ".Symbol";
	public static final String SYNTAX_SYMBOL_BOLD = SYNTAX_SYMBOL + __BOLD_SUFFIX;
	public static final String SYNTAX_SYMBOL_COLOR = SYNTAX_SYMBOL + __COLOR_SUFFIX;
	public static final String SYNTAX_SYMBOL_ITALIC = SYNTAX_SYMBOL + __ITALIC_SUFFIX;
	public static final String SYNTAX_TYPE = SYNTAX + ".Type";
	public static final String SYNTAX_TYPE_BOLD = SYNTAX_TYPE + __BOLD_SUFFIX;
	public static final String SYNTAX_TYPE_COLOR = SYNTAX_TYPE + __COLOR_SUFFIX;
	public static final String SYNTAX_TYPE_ITALIC = SYNTAX_TYPE + __ITALIC_SUFFIX;
	
	public static final String TYPING = __PREFIX + ".Typing";
	public static final String TYPING_CLOSE_BRACES = TYPING + ".CloseBraces";
	public static final String TYPING_CLOSE_BRACKETS = TYPING + ".ClolseBrackets";
	public static final String TYPING_CLOSE_STRINGS = TYPING + ".CloseStrings";
	public static final String TYPING_ESCAPE_STRINGS = TYPING + ".EscapeStrings";
	public static final String TYPING_IMPORTS_ON_PASTE = TYPING + ".ImportsOnPaste";
	public static final String TYPING_SMART_OPENING_BRACE = TYPING + ".SmarttOpeningBrace";
	public static final String TYPING_SMART_PASTE = TYPING + ".SmartPaste";
	public static final String TYPING_SMART_SEMICOLON = TYPING + ".SmarttSemicolon";
	public static final String TYPING_SMART_TAB = TYPING + ".SmartTab";
	public static final String TYPING_SPACES_FOR_TABS = TYPING + ".SpacesForTabs";
	public static final String TYPING_WRAP_STRINGS = TYPING + ".WrapStrings";
	
	/**
	 * This method generates a list of preference keys that can be used to initialize a new preference fPreferenceeStore.
	 * @return an array of preferences.
	 */
	public static AtlPreferenceStore.Key[] createStoreKeys() {
		ArrayList storeKeys = new ArrayList();
		
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, APPEARANCE_CURRENT_LINE));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, APPEARANCE_CURRENT_LINE_COLOR));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, APPEARANCE_HIGHLIGHT_CURRENT_LINE));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, APPEARANCE_HIGHLIGHT_MATCHING_BRACKETS));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, APPEARANCE_HIGHLIGHT_MATCHING_BRACKETS_COLOR));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, APPEARANCE_LINE_NUMBER_COLOR));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, APPEARANCE_LINE_NUMBER_RULER));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, APPEARANCE_PRINT_MARGIN));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, APPEARANCE_PRINT_MARGIN_COLOR));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.INT, APPEARANCE_PRINT_MARGIN_COLUMN));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, APPEARANCE_SELECTION_BACKGROUND_COLOR));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, APPEARANCE_SELECTION_BACKGROUND_DEFAULT));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, APPEARANCE_SELECTION_FOREGROUND_COLOR));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, APPEARANCE_SELECTION_FOREGROUND_DEFAULT));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.INT, APPEARANCE_TAB_WIDTH));
		
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.INT, CODEASSIST_AUTOACTIVATION_DELAY));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, CODEASSIST_AUTOACTIVATION_ENABLE));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, CODEASSIST_AUTOACTIVATION_TRIGGERS));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, CODEASSIST_AUTOINSERT));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, CODEASSIST_CASE_SENSITIVITY));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, CODEASSIST_ORDER_PROPOSALS));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, CODEASSIST_PARAMETERS_BACKGROUND));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, CODEASSIST_PARAMETERS_FOREGROUND));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, CODEASSIST_PREFIX_COMPLETION));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, CODEASSIST_PROPOSALS_BACKGROUND));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, CODEASSIST_PROPOSALS_FOREGROUND));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, CODEASSIST_REPLACEMENT_BACKGROUND));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, CODEASSIST_REPLACEMENT_FOREGROUND));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, CODEASSIST_SHOW_VISIBLE_PROPOSALS));
		
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, EDITOR_BACKGROUND_COLOR));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, EDITOR_BACKGROUND_COLOR_DEFAULT));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, EDITOR_FOREGROUND_COLOR));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, EDITOR_FOREGROUND_COLOR_DEFAULT));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, EDITOR_SMART_BACKSPACE));
		
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_BRACKET_BOLD));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, SYNTAX_BRACKET_COLOR));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_BRACKET_ITALIC));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_CONSTANT_BOLD));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, SYNTAX_CONSTANT_COLOR));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_CONSTANT_ITALIC));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_DEFAULT_BOLD));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, SYNTAX_DEFAULT_COLOR));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_DEFAULT_ITALIC));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_IDENTIFIER_BOLD));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, SYNTAX_IDENTIFIER_COLOR));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_IDENTIFIER_ITALIC));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_KEYWORD_BOLD));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, SYNTAX_KEYWORD_COLOR));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_KEYWORD_ITALIC));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_LITERAL_BOLD));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, SYNTAX_LITERAL_COLOR));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_LITERAL_ITALIC));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_NUMBER_BOLD));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, SYNTAX_NUMBER_COLOR));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_NUMBER_ITALIC));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_OPERATOR_BOLD));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, SYNTAX_OPERATOR_COLOR));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_OPERATOR_ITALIC));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_SINGLE_LINE_COMMENT_BOLD));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, SYNTAX_SINGLE_LINE_COMMENT_COLOR));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_SINGLE_LINE_COMMENT_ITALIC));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_STRING_BOLD));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, SYNTAX_STRING_COLOR));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_STRING_ITALIC));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_SYMBOL_BOLD));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, SYNTAX_SYMBOL_COLOR));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_SYMBOL_ITALIC));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_TYPE_BOLD));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.STRING, SYNTAX_TYPE_COLOR));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, SYNTAX_TYPE_ITALIC));
		
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, TYPING_CLOSE_BRACES));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, TYPING_CLOSE_BRACKETS));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, TYPING_CLOSE_STRINGS));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, TYPING_ESCAPE_STRINGS));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, TYPING_IMPORTS_ON_PASTE));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, TYPING_SMART_OPENING_BRACE));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, TYPING_SMART_PASTE));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, TYPING_SMART_SEMICOLON));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, TYPING_SMART_TAB));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, TYPING_SPACES_FOR_TABS));
		storeKeys.add(new AtlPreferenceStore.Key(AtlPreferenceStore.BOOLEAN, TYPING_WRAP_STRINGS));
		
		AtlPreferenceStore.Key[] keys = new AtlPreferenceStore.Key[storeKeys.size()];
		storeKeys.toArray(keys);
		return keys;
	}
	
	/**
	 * Initialize a preference fPreferenceeStore with the default values that are setting up by the inline constants.
	 * 
	 * @param fPreferenceeStore  The preference fPreferenceeStore to modify.
	 */
	public static void initializeDefaultValues(IPreferenceStore store) {
		TextEditorPreferenceConstants.initializeDefaultValues(store);
		
		store.setDefault(APPEARANCE_CURRENT_LINE, IAtlDefaultValues.APPEARANCE_CURRENT_LINE);
		PreferenceConverter.setDefault(store, APPEARANCE_CURRENT_LINE_COLOR, IAtlDefaultValues.APPEARANCE_CURRENT_LINE_COLOR);
		store.setDefault(APPEARANCE_HIGHLIGHT_CURRENT_LINE, IAtlDefaultValues.APPEARANCE_HIGHLIGHT_CURRENT_LINE);
		store.setDefault(APPEARANCE_HIGHLIGHT_MATCHING_BRACKETS, IAtlDefaultValues.APPEARANCE_HIGHLIGHT_MATCHING_BRACKETS);
		PreferenceConverter.setDefault(store, APPEARANCE_HIGHLIGHT_MATCHING_BRACKETS_COLOR, IAtlDefaultValues.APPEARANCE_HIGHLIGHT_MATCHING_BRACKETS_COLOR);
		PreferenceConverter.setDefault(store, APPEARANCE_LINE_NUMBER_COLOR, IAtlDefaultValues.APPEARANCE_LINE_NUMBER_COLOR);
		store.setDefault(APPEARANCE_LINE_NUMBER_RULER, IAtlDefaultValues.APPEARANCE_LINE_NUMBER_RULER);
		store.setDefault(APPEARANCE_PRINT_MARGIN, IAtlDefaultValues.APPEARANCE_PRINT_MARGIN);
		PreferenceConverter.setDefault(store, APPEARANCE_PRINT_MARGIN_COLOR, IAtlDefaultValues.APPEARANCE_PRINT_MARGIN_COLOR);
		store.setDefault(APPEARANCE_PRINT_MARGIN_COLUMN, IAtlDefaultValues.APPEARANCE_PRINT_MARGIN_COLUMN);
		PreferenceConverter.setDefault(store, APPEARANCE_SELECTION_BACKGROUND_COLOR, IAtlDefaultValues.APPEARANCE_BACKGROUND_COLOR);
		store.setDefault(APPEARANCE_SELECTION_BACKGROUND_DEFAULT, IAtlDefaultValues.APPEARANCE_SELECTION_BACKGROUND_DEFAULT);
		PreferenceConverter.setDefault(store, APPEARANCE_SELECTION_FOREGROUND_COLOR, IAtlDefaultValues.APPEARANCE_FOREGROUND_COLOR);
		store.setDefault(APPEARANCE_SELECTION_FOREGROUND_DEFAULT, IAtlDefaultValues.APPEARANCE_SELECTION_FOREGROUND_DEFAULT);
		store.setDefault(APPEARANCE_TAB_WIDTH, IAtlDefaultValues.APPEARANCE_TAB_WIDTH);
		
		store.setDefault(CODEASSIST_AUTOACTIVATION_DELAY, IAtlDefaultValues.CODEASSIST_AUTOACTIVATION_DELAY);
		store.setDefault(CODEASSIST_AUTOACTIVATION_ENABLE, IAtlDefaultValues.CODEASSIST_AUTOACTIVATION_ENABLE);
		store.setDefault(CODEASSIST_AUTOACTIVATION_TRIGGERS, IAtlDefaultValues.CODEASSIST_AUTOACTIVATION_TRIGGERS);
		store.setDefault(CODEASSIST_AUTOINSERT, IAtlDefaultValues.CODEASSIST_AUTOINSERT);
		store.setDefault(CODEASSIST_CASE_SENSITIVITY, IAtlDefaultValues.CODEASSIST_CASE_SENSITIVITY);
		store.setDefault(CODEASSIST_ORDER_PROPOSALS, IAtlDefaultValues.CODEASSIST_ORDER_PROPOSALS);
		PreferenceConverter.setDefault(store, CODEASSIST_PARAMETERS_BACKGROUND, IAtlDefaultValues.CODEASSIST_PARAMETERS_BACKGROUND_COLOR);
		PreferenceConverter.setDefault(store, CODEASSIST_PARAMETERS_FOREGROUND, IAtlDefaultValues.CODEASSIST_PARAMETERS_FOREGROUND_COLOR);
		store.setDefault(CODEASSIST_PREFIX_COMPLETION, IAtlDefaultValues.CODEASSIST_PREFIX_COMPLETION);
		PreferenceConverter.setDefault(store, CODEASSIST_PROPOSALS_BACKGROUND, IAtlDefaultValues.CODEASSIST_PROPOSALS_BACKGROUND_COLOR);
		PreferenceConverter.setDefault(store, CODEASSIST_PROPOSALS_FOREGROUND, IAtlDefaultValues.CODEASSIST_PROPOSALS_FOREGROUND_COLOR);
		PreferenceConverter.setDefault(store, CODEASSIST_REPLACEMENT_BACKGROUND, IAtlDefaultValues.CODEASSIST_REPLACEMENT_BACKGROUND_COLOR);
		PreferenceConverter.setDefault(store, CODEASSIST_REPLACEMENT_FOREGROUND, IAtlDefaultValues.CODEASSIST_REPLACEMENT_FOREGROUND_COLOR);
		store.setDefault(CODEASSIST_SHOW_VISIBLE_PROPOSALS, IAtlDefaultValues.CODEASSIST_SHOW_VISIBLE_PROPOSALS);
		
		store.setDefault(EDITOR_BACKGROUND_COLOR_DEFAULT, IAtlDefaultValues.EDITOR_BACKGROUND_COLOR_DEFAULT);
		store.setDefault(EDITOR_FOREGROUND_COLOR_DEFAULT, IAtlDefaultValues.EDITOR_FOREGROUND_COLOR_DEFAULT);
		store.setDefault(EDITOR_SMART_BACKSPACE, IAtlDefaultValues.EDITOR_SMART_BACKSPACE);
		
		store.setDefault(SYNTAX_BRACKET_BOLD, IAtlDefaultValues.SYNTAX_BRACKET_BOLD);
		PreferenceConverter.setDefault(store, SYNTAX_BRACKET_COLOR, IAtlDefaultValues.SYNTAX_BRACKET_COLOR);
		store.setDefault(SYNTAX_BRACKET_ITALIC, IAtlDefaultValues.SYNTAX_BRACKET_ITALIC);
		store.setDefault(SYNTAX_CONSTANT_BOLD, IAtlDefaultValues.SYNTAX_CONSTANT_BOLD);
		PreferenceConverter.setDefault(store, SYNTAX_CONSTANT_COLOR, IAtlDefaultValues.SYNTAX_CONSTANT_COLOR);
		store.setDefault(SYNTAX_CONSTANT_ITALIC, IAtlDefaultValues.SYNTAX_CONSTANT_ITALIC);
		store.setDefault(SYNTAX_DEFAULT_BOLD, IAtlDefaultValues.SYNTAX_DEFAULT_BOLD);
		PreferenceConverter.setDefault(store, SYNTAX_DEFAULT_COLOR, IAtlDefaultValues.SYNTAX_DEFAULT_COLOR);
		store.setDefault(SYNTAX_DEFAULT_ITALIC, IAtlDefaultValues.SYNTAX_DEFAULT_ITALIC);
		store.setDefault(SYNTAX_IDENTIFIER_BOLD, IAtlDefaultValues.SYNTAX_IDENTIFIER_BOLD);
		PreferenceConverter.setDefault(store, SYNTAX_IDENTIFIER_COLOR , IAtlDefaultValues.SYNTAX_IDENTIFIER_COLOR);
		store.setDefault(SYNTAX_IDENTIFIER_ITALIC, IAtlDefaultValues.SYNTAX_IDENTIFIER_ITALIC);
		store.setDefault(SYNTAX_KEYWORD_BOLD, IAtlDefaultValues.SYNTAX_KEYWORD_BOLD);
		PreferenceConverter.setDefault(store, SYNTAX_KEYWORD_COLOR , IAtlDefaultValues.SYNTAX_KEYWORD_COLOR);
		store.setDefault(SYNTAX_KEYWORD_ITALIC, IAtlDefaultValues.SYNTAX_KEYWORD_ITALIC);
		store.setDefault(SYNTAX_LITERAL_BOLD, IAtlDefaultValues.SYNTAX_LITERAL_BOLD);
		PreferenceConverter.setDefault(store, SYNTAX_LITERAL_COLOR, IAtlDefaultValues.SYNTAX_LITERAL_COLOR);
		store.setDefault(SYNTAX_LITERAL_ITALIC, IAtlDefaultValues.SYNTAX_LITERAL_ITALIC);
		store.setDefault(SYNTAX_NUMBER_BOLD, IAtlDefaultValues.SYNTAX_NUMBER_BOLD);
		PreferenceConverter.setDefault(store, SYNTAX_NUMBER_COLOR, IAtlDefaultValues.SYNTAX_NUMBER_COLOR);
		store.setDefault(SYNTAX_NUMBER_ITALIC, IAtlDefaultValues.SYNTAX_NUMBER_ITALIC);
		store.setDefault(SYNTAX_OPERATOR_BOLD, IAtlDefaultValues.SYNTAX_OPERATOR_BOLD);
		PreferenceConverter.setDefault(store, SYNTAX_OPERATOR_COLOR, IAtlDefaultValues.SYNTAX_OPERATOR_COLOR);
		store.setDefault(SYNTAX_OPERATOR_ITALIC, IAtlDefaultValues.SYNTAX_OPERATOR_ITALIC);
		store.setDefault(SYNTAX_SINGLE_LINE_COMMENT_BOLD, IAtlDefaultValues.SYNTAX_SINGLE_LINE_COMMENT_BOLD);
		PreferenceConverter.setDefault(store, SYNTAX_SINGLE_LINE_COMMENT_COLOR , IAtlDefaultValues.SYNTAX_SINGLE_LINE_COMMENT_COLOR);
		store.setDefault(SYNTAX_SINGLE_LINE_COMMENT_ITALIC, IAtlDefaultValues.SYNTAX_SINGLE_LINE_COMMENT_ITALIC);
		store.setDefault(SYNTAX_STRING_BOLD, IAtlDefaultValues.SYNTAX_STRING_BOLD);
		PreferenceConverter.setDefault(store, SYNTAX_STRING_COLOR, IAtlDefaultValues.SYNTAX_STRING_COLOR);
		store.setDefault(SYNTAX_STRING_ITALIC, IAtlDefaultValues.SYNTAX_STRING_ITALIC);
		store.setDefault(SYNTAX_SYMBOL_BOLD, IAtlDefaultValues.SYNTAX_SYMBOL_BOLD);
		PreferenceConverter.setDefault(store, SYNTAX_SYMBOL_COLOR, IAtlDefaultValues.SYNTAX_SYMBOL_COLOR);
		store.setDefault(SYNTAX_SYMBOL_ITALIC, IAtlDefaultValues.SYNTAX_SYMBOL_ITALIC);
		store.setDefault(SYNTAX_TYPE_BOLD, IAtlDefaultValues.SYNTAX_TYPE_BOLD);
		PreferenceConverter.setDefault(store, SYNTAX_TYPE_COLOR , IAtlDefaultValues.SYNTAX_TYPE_COLOR);
		store.setDefault(SYNTAX_TYPE_ITALIC, IAtlDefaultValues.SYNTAX_TYPE_ITALIC);
		
		store.setDefault(TYPING_CLOSE_BRACES, IAtlDefaultValues.TYPING_CLOSE_BRACES);
		store.setDefault(TYPING_CLOSE_BRACKETS, IAtlDefaultValues.TYPING_CLOSE_BRACKETS);
		store.setDefault(TYPING_CLOSE_STRINGS, IAtlDefaultValues.TYPING_CLOSE_STRINGS);
		store.setDefault(TYPING_ESCAPE_STRINGS, IAtlDefaultValues.TYPING_ESCAPE_STRINGS);
		store.setDefault(TYPING_IMPORTS_ON_PASTE, IAtlDefaultValues.TYPING_IMPORTS_ON_PASTE);
		store.setDefault(TYPING_SMART_OPENING_BRACE, IAtlDefaultValues.TYPING_SMART_OPENING_BRACE);
		store.setDefault(TYPING_SMART_PASTE, IAtlDefaultValues.TYPING_SMART_PASTE);
		store.setDefault(TYPING_SMART_SEMICOLON, IAtlDefaultValues.TYPING_SMART_SEMICOLON);
		store.setDefault(TYPING_SMART_TAB, IAtlDefaultValues.TYPING_SMART_TAB);
		store.setDefault(TYPING_SPACES_FOR_TABS, IAtlDefaultValues.TYPING_SPACES_FOR_TABS);
		store.setDefault(TYPING_WRAP_STRINGS, IAtlDefaultValues.TYPING_WRAP_STRINGS);
	}
	
}
