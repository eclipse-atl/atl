/*******************************************************************************
 * Copyright (c) 2011, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.editor.formatter;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.m2m.atl.adt.ui.AtlPreferenceConstants;
import org.eclipse.m2m.atl.adt.ui.text.IAtlDefaultValues;

/**
 * ATL code formatter preferences.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlCodeFormatterPreferences {

	private int linesBetween;

	private int lineMaxLength;

	private int tabSpaces;

	private int spacesInsideBraces;

	private int spacesOutsideBraces;

	private int spacesBeforeArrows;

	private int spacesAfterArrows;

	private int spacesBeforeSemi;

	private int spacesAfterSemi;

	private int spacesBeforeComa;

	private int spacesAfterComa;

	private int spacesBeforeColon;

	private int spacesAfterColon;

	private int spacesBeforePoint;

	private int spacesAfterPoint;

	private int spacesBeforeOperator;

	private int spacesAfterOperator;

	private int spacesBeforeEqual;

	private int spacesAfterEqual;

	private int spacesBeforePipe;

	private int spacesAfterPipe;

	private int spacesBeforeExclamation;

	private int spacesAfterExclamation;

	private int spacesBeforeRuleBrace;

	private int spacesBeforeEndingSemi;

	private int linesAfterModule;

	private int linesAfterCreateFrom;

	private int linesAfterSpecialTags;

	private boolean cutAfterPoint;

	private int spacesAfterComment;

	private int spacesOutsideCollectionBrace;

	private int spacesInsideCollectionBrace;

	public AtlCodeFormatterPreferences() {
		setLinesBetween(IAtlDefaultValues.CODEFORMATTER_LINES_BETWEEN);
		setLineMaxLength(IAtlDefaultValues.CODEFORMATTER_LINE_MAX_LENGTH);
		setTabSpaces(IAtlDefaultValues.APPEARANCE_TAB_WIDTH);
		setSpacesOutsideBraces(IAtlDefaultValues.CODEFORMATTER_SPACES_OUTSIDE_BRACES);
		setSpacesInsideBraces(IAtlDefaultValues.CODEFORMATTER_SPACES_INSIDE_BRACES);
		setSpacesBeforeArrows(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_ARROWS);
		setSpacesAfterArrows(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_ARROWS);
		setSpacesBeforeSemi(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_SEMI);
		setSpacesAfterSemi(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_SEMI);
		setSpacesBeforeComa(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_COMA);
		setSpacesAfterComa(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_COMA);
		setSpacesBeforeColon(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_COLON);
		setSpacesAfterColon(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_COLON);
		setSpacesBeforePoint(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_POINT);
		setSpacesAfterPoint(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_POINT);
		setSpacesBeforeOperator(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_OPERATOR);
		setSpacesAfterOperator(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_OPERATOR);
		setLinesAfterModule(IAtlDefaultValues.CODEFORMATTER_LINES_AFTER_MODULE);
		setLinesAfterCreateFrom(IAtlDefaultValues.CODEFORMATTER_LINES_AFTER_CREATE_FROM);
		setLinesAfterSpecialTags(IAtlDefaultValues.CODEFORMATTER_LINES_AFTER_SPECIAL_TAGS);
		setCutAfterPoint(IAtlDefaultValues.CODEFORMATTER_CUT_AFTER_POINT);
		setSpacesBeforeEqual(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_EQUAL);
		setSpacesAfterEqual(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_EQUAL);
		setSpacesBeforePipe(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_PIPE);
		setSpacesAfterPipe(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_PIPE);
		setSpacesBeforeExclamation(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_EXCLAMATION);
		setSpacesAfterExclamation(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_EXCLAMATION);
		setSpacesBeforeRuleBrace(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_RULE_BRACE);
		setSpacesBeforeEndingSemi(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_ENDING_SEMI);
		setSpacesAfterComment(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_COMMENT);
		setSpacesOutsideCollectionBrace(IAtlDefaultValues.CODEFORMATTER_SPACES_OUTSIDE_COLLECTION_BRACE);
		setSpacesInsideCollectionBrace(IAtlDefaultValues.CODEFORMATTER_SPACES_INSIDE_COLLECTION_BRACE);
	}

	public AtlCodeFormatterPreferences(IPreferenceStore preferenceStore) {
		retrievePreferences(preferenceStore);
	}

	public AtlCodeFormatterPreferences(Map<String, String> options) {
		retrievePreferences(options);
	}

	/**
	 * Retrieves the preferences from a preference store.
	 * 
	 * @param preferenceStore
	 *            the preference store
	 */
	public void retrievePreferences(IPreferenceStore preferenceStore) {
		linesBetween = preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_LINES_BETWEEN);
		lineMaxLength = preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_LINE_MAX_LENGTH);
		tabSpaces = preferenceStore.getInt(AtlPreferenceConstants.APPEARANCE_TAB_WIDTH);
		spacesInsideBraces = preferenceStore
				.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_INSIDE_BRACES);
		spacesOutsideBraces = preferenceStore
				.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_OUTSIDE_BRACES);
		spacesBeforeArrows = preferenceStore
				.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_ARROWS);
		spacesAfterArrows = preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_ARROWS);
		spacesBeforeSemi = preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_SEMI);
		spacesAfterSemi = preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_SEMI);
		spacesBeforeComa = preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_COMA);
		spacesAfterComa = preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_COMA);
		spacesBeforeColon = preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_COLON);
		spacesAfterColon = preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_COLON);
		spacesBeforePoint = preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_POINT);
		spacesAfterPoint = preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_POINT);
		spacesBeforeOperator = preferenceStore
				.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_OPERATOR);
		spacesAfterOperator = preferenceStore
				.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_OPERATOR);
		spacesBeforeEqual = preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_EQUAL);
		spacesAfterEqual = preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_EQUAL);
		spacesBeforePipe = preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_PIPE);
		spacesAfterPipe = preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_PIPE);
		spacesBeforeExclamation = preferenceStore
				.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_EXCLAMATION);
		spacesAfterExclamation = preferenceStore
				.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_EXCLAMATION);
		spacesBeforeRuleBrace = preferenceStore
				.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_RULE_BRACE);
		spacesBeforeEndingSemi = preferenceStore
				.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_ENDING_SEMI);
		cutAfterPoint = preferenceStore.getBoolean(AtlPreferenceConstants.CODEFORMATTER_CUT_AFTER_POINT);
		spacesAfterComment = preferenceStore
				.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_COMMENT);
		spacesOutsideCollectionBrace = preferenceStore
				.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_OUTSIDE_COLLECTION_BRACE);
		spacesInsideCollectionBrace = preferenceStore
				.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_INSIDE_COLLECTION_BRACE);
		linesAfterModule = preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_LINES_AFTER_MODULE);
		linesAfterCreateFrom = preferenceStore
				.getInt(AtlPreferenceConstants.CODEFORMATTER_LINES_AFTER_CREATE_FROM);
		linesAfterSpecialTags = preferenceStore
				.getInt(AtlPreferenceConstants.CODEFORMATTER_LINES_AFTER_SPECIAL_TAGS);
	}

	/**
	 * Retrieves the preferences from an option map.
	 * 
	 * @param options
	 *            the options map
	 */
	public void retrievePreferences(Map<String, String> options) {
		String sLinesBetween = options.get(AtlPreferenceConstants.CODEFORMATTER_LINES_BETWEEN);
		if (sLinesBetween != null) {
			try {
				linesBetween = Integer.parseInt(sLinesBetween);
			} catch (NumberFormatException e) {
				setLinesBetween(IAtlDefaultValues.CODEFORMATTER_LINES_BETWEEN);
			}
		} else
			setLinesBetween(IAtlDefaultValues.CODEFORMATTER_LINES_BETWEEN);
		String sLineMaxLength = options.get(AtlPreferenceConstants.CODEFORMATTER_LINE_MAX_LENGTH);
		if (sLineMaxLength != null) {
			try {
				lineMaxLength = Integer.parseInt(sLineMaxLength);
			} catch (NumberFormatException e) {
				setLineMaxLength(IAtlDefaultValues.CODEFORMATTER_LINE_MAX_LENGTH);
			}
		} else
			setLineMaxLength(IAtlDefaultValues.CODEFORMATTER_LINE_MAX_LENGTH);
		String sTabSpaces = options.get(AtlPreferenceConstants.APPEARANCE_TAB_WIDTH);
		if (sTabSpaces != null) {
			try {
				tabSpaces = Integer.parseInt(sTabSpaces);
			} catch (NumberFormatException e) {
				setTabSpaces(IAtlDefaultValues.APPEARANCE_TAB_WIDTH);
			}
		} else
			setTabSpaces(IAtlDefaultValues.APPEARANCE_TAB_WIDTH);
		String sSpacesInsideBraces = options.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_INSIDE_BRACES);
		if (sSpacesInsideBraces != null) {
			try {
				spacesInsideBraces = Integer.parseInt(sSpacesInsideBraces);
			} catch (NumberFormatException e) {
				setSpacesInsideBraces(IAtlDefaultValues.CODEFORMATTER_SPACES_INSIDE_BRACES);
			}
		} else
			setSpacesInsideBraces(IAtlDefaultValues.CODEFORMATTER_SPACES_INSIDE_BRACES);
		String sSpacesOutsideBraces = options.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_OUTSIDE_BRACES);
		if (sSpacesOutsideBraces != null) {
			try {
				spacesOutsideBraces = Integer.parseInt(sSpacesOutsideBraces);
			} catch (NumberFormatException e) {
				setSpacesOutsideBraces(IAtlDefaultValues.CODEFORMATTER_SPACES_OUTSIDE_BRACES);
			}
		} else
			setSpacesOutsideBraces(IAtlDefaultValues.CODEFORMATTER_SPACES_OUTSIDE_BRACES);
		String sSpacesBeforeArrows = options.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_ARROWS);
		if (sSpacesBeforeArrows != null) {
			try {
				spacesBeforeArrows = Integer.parseInt(sSpacesBeforeArrows);
			} catch (NumberFormatException e) {
				setSpacesBeforeArrows(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_ARROWS);
			}
		} else
			setSpacesBeforeArrows(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_ARROWS);
		String sSpacesAfterArrows = options.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_ARROWS);
		if (sSpacesAfterArrows != null) {
			try {
				spacesAfterArrows = Integer.parseInt(sSpacesAfterArrows);
			} catch (NumberFormatException e) {
				setSpacesAfterArrows(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_ARROWS);
			}
		} else
			setSpacesAfterArrows(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_ARROWS);
		String sSpacesBeforeSemi = options.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_SEMI);
		if (sSpacesBeforeSemi != null) {
			try {
				spacesBeforeSemi = Integer.parseInt(sSpacesBeforeSemi);
			} catch (NumberFormatException e) {
				setSpacesBeforeSemi(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_SEMI);
			}
		} else
			setSpacesBeforeSemi(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_SEMI);
		String sSpacesAfterSemi = options.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_SEMI);
		if (sSpacesAfterSemi != null) {
			try {
				spacesAfterSemi = Integer.parseInt(sSpacesAfterSemi);
			} catch (NumberFormatException e) {
				setSpacesAfterSemi(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_SEMI);
			}
		} else
			setSpacesAfterSemi(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_SEMI);
		String sSpacesBeforeComa = options.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_COMA);
		if (sSpacesBeforeComa != null) {
			try {
				spacesBeforeComa = Integer.parseInt(sSpacesBeforeComa);
			} catch (NumberFormatException e) {
				setSpacesBeforeComa(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_COMA);
			}
		} else
			setSpacesBeforeComa(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_COMA);
		String sSpacesAfterComa = options.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_COMA);
		if (sSpacesAfterComa != null) {
			try {
				spacesAfterComa = Integer.parseInt(sSpacesAfterComa);
			} catch (NumberFormatException e) {
				setSpacesAfterComa(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_COMA);
			}
		} else
			setSpacesAfterComa(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_COMA);
		String sSpacesBeforeColon = options.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_COLON);
		if (sSpacesBeforeColon != null) {
			try {
				spacesBeforeColon = Integer.parseInt(sSpacesBeforeColon);
			} catch (NumberFormatException e) {
				setSpacesBeforeColon(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_COLON);
			}
		} else
			setSpacesBeforeColon(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_COLON);
		String sSpacesAfterColon = options.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_COLON);
		if (sSpacesAfterColon != null) {
			try {
				spacesAfterColon = Integer.parseInt(sSpacesAfterColon);
			} catch (NumberFormatException e) {
				setSpacesAfterColon(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_COLON);
			}
		} else
			setSpacesAfterColon(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_COLON);
		String sSpacesBeforePoint = options.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_POINT);
		if (sSpacesBeforePoint != null) {
			try {
				spacesBeforePoint = Integer.parseInt(sSpacesBeforePoint);
			} catch (NumberFormatException e) {
				setSpacesBeforePoint(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_POINT);
			}
		} else
			setSpacesBeforePoint(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_POINT);
		String sSpacesAfterPoint = options.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_POINT);
		if (sSpacesAfterPoint != null) {
			try {
				spacesAfterPoint = Integer.parseInt(sSpacesAfterPoint);
			} catch (NumberFormatException e) {
				setSpacesAfterPoint(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_POINT);
			}
		} else
			setSpacesAfterPoint(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_POINT);
		String sSpacesBeforeOperator = options
				.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_OPERATOR);
		if (sSpacesBeforeOperator != null) {
			try {
				spacesBeforeOperator = Integer.parseInt(sSpacesBeforeOperator);
			} catch (NumberFormatException e) {
				setSpacesBeforeOperator(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_OPERATOR);
			}
		} else
			setSpacesBeforeOperator(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_OPERATOR);
		String sSpacesAfterOperator = options.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_OPERATOR);
		if (sSpacesAfterOperator != null) {
			try {
				spacesAfterOperator = Integer.parseInt(sSpacesAfterOperator);
			} catch (NumberFormatException e) {
				setSpacesAfterOperator(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_OPERATOR);
			}
		} else
			setSpacesAfterOperator(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_OPERATOR);
		String sSpacesBeforeEqual = options.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_EQUAL);
		if (sSpacesBeforeEqual != null) {
			try {
				spacesBeforeEqual = Integer.parseInt(sSpacesBeforeEqual);
			} catch (NumberFormatException e) {
				setSpacesBeforeEqual(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_EQUAL);
			}
		} else
			setSpacesBeforeEqual(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_EQUAL);
		String sSpacesAfterEqual = options.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_EQUAL);
		if (sSpacesAfterEqual != null) {
			try {
				spacesAfterEqual = Integer.parseInt(sSpacesAfterEqual);
			} catch (NumberFormatException e) {
				setSpacesAfterEqual(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_EQUAL);
			}
		} else
			setSpacesAfterEqual(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_EQUAL);
		String sSpacesBeforePipe = options.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_PIPE);
		if (sSpacesBeforePipe != null) {
			try {
				spacesBeforePipe = Integer.parseInt(sSpacesBeforePipe);
			} catch (NumberFormatException e) {
				setSpacesBeforePipe(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_PIPE);
			}
		} else
			setSpacesBeforePipe(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_PIPE);
		String sSpacesAfterPipe = options.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_PIPE);
		if (sSpacesAfterPipe != null) {
			try {
				spacesAfterPipe = Integer.parseInt(sSpacesAfterPipe);
			} catch (NumberFormatException e) {
				setSpacesAfterPipe(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_PIPE);
			}
		} else
			setSpacesAfterPipe(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_PIPE);
		String sSpacesBeforeExclamation = options
				.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_EXCLAMATION);
		if (sSpacesBeforeExclamation != null) {
			try {
				spacesBeforeExclamation = Integer.parseInt(sSpacesBeforeExclamation);
			} catch (NumberFormatException e) {
				setSpacesBeforeExclamation(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_EXCLAMATION);
			}
		} else
			setSpacesBeforeExclamation(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_EXCLAMATION);
		String sSpacesAfterExclamation = options
				.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_EXCLAMATION);
		if (sSpacesAfterExclamation != null) {
			try {
				spacesAfterExclamation = Integer.parseInt(sSpacesAfterExclamation);
			} catch (NumberFormatException e) {
				setSpacesAfterExclamation(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_EXCLAMATION);
			}
		} else
			setSpacesAfterExclamation(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_EXCLAMATION);
		String sSpacesBeforeRuleBrace = options
				.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_RULE_BRACE);
		if (sSpacesBeforeRuleBrace != null) {
			try {
				spacesBeforeRuleBrace = Integer.parseInt(sSpacesBeforeRuleBrace);
			} catch (NumberFormatException e) {
				setSpacesBeforeRuleBrace(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_RULE_BRACE);
			}
		} else
			setSpacesBeforeRuleBrace(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_RULE_BRACE);
		String sSpacesBeforeEndingSemi = options
				.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_ENDING_SEMI);
		if (sSpacesBeforeEndingSemi != null) {
			try {
				spacesBeforeEndingSemi = Integer.parseInt(sSpacesBeforeEndingSemi);
			} catch (NumberFormatException e) {
				setSpacesBeforeEndingSemi(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_ENDING_SEMI);
			}
		} else
			setSpacesBeforeEndingSemi(IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_ENDING_SEMI);
		String sCutAfterPoint = options.get(AtlPreferenceConstants.CODEFORMATTER_CUT_AFTER_POINT);
		if (sCutAfterPoint != null) {
			try {
				cutAfterPoint = Boolean.parseBoolean(sCutAfterPoint);
			} catch (NumberFormatException e) {
				setCutAfterPoint(IAtlDefaultValues.CODEFORMATTER_CUT_AFTER_POINT);
			}
		} else
			setCutAfterPoint(IAtlDefaultValues.CODEFORMATTER_CUT_AFTER_POINT);
		String sSpacesAfterComment = options.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_COMMENT);
		if (sSpacesAfterComment != null) {
			try {
				spacesAfterComment = Integer.parseInt(sSpacesAfterComment);
			} catch (NumberFormatException e) {
				setSpacesAfterComment(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_COMMENT);
			}
		} else
			setSpacesAfterComment(IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_COMMENT);
		String sSpacesOutsideCollectionBrace = options
				.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_OUTSIDE_COLLECTION_BRACE);
		if (sSpacesOutsideCollectionBrace != null) {
			try {
				spacesOutsideCollectionBrace = Integer.parseInt(sSpacesOutsideCollectionBrace);
			} catch (NumberFormatException e) {
				setSpacesOutsideCollectionBrace(IAtlDefaultValues.CODEFORMATTER_SPACES_OUTSIDE_COLLECTION_BRACE);
			}
		} else
			setSpacesOutsideCollectionBrace(IAtlDefaultValues.CODEFORMATTER_SPACES_OUTSIDE_COLLECTION_BRACE);
		String sSpacesInsideCollectionBrace = options
				.get(AtlPreferenceConstants.CODEFORMATTER_SPACES_INSIDE_COLLECTION_BRACE);
		if (sSpacesInsideCollectionBrace != null) {
			try {
				spacesInsideCollectionBrace = Integer.parseInt(sSpacesInsideCollectionBrace);
			} catch (NumberFormatException e) {
				setSpacesInsideCollectionBrace(IAtlDefaultValues.CODEFORMATTER_SPACES_INSIDE_COLLECTION_BRACE);
			}
		} else
			setSpacesInsideCollectionBrace(IAtlDefaultValues.CODEFORMATTER_SPACES_INSIDE_COLLECTION_BRACE);
		String sLinesAfterModule = options.get(AtlPreferenceConstants.CODEFORMATTER_LINES_AFTER_MODULE);
		if (sLinesAfterModule != null) {
			try {
				linesAfterModule = Integer.parseInt(sLinesAfterModule);
			} catch (NumberFormatException e) {
				setLinesAfterModule(IAtlDefaultValues.CODEFORMATTER_LINES_AFTER_MODULE);
			}
		} else
			setLinesAfterModule(IAtlDefaultValues.CODEFORMATTER_LINES_AFTER_MODULE);
		String sLinesAfterCreateFrom = options
				.get(AtlPreferenceConstants.CODEFORMATTER_LINES_AFTER_CREATE_FROM);
		if (sLinesAfterCreateFrom != null) {
			try {
				linesAfterCreateFrom = Integer.parseInt(sLinesAfterCreateFrom);
			} catch (NumberFormatException e) {
				setLinesAfterCreateFrom(IAtlDefaultValues.CODEFORMATTER_LINES_AFTER_CREATE_FROM);
			}
		} else
			setLinesAfterCreateFrom(IAtlDefaultValues.CODEFORMATTER_LINES_AFTER_CREATE_FROM);
		String sLinesAfterSpecialTags = options
				.get(AtlPreferenceConstants.CODEFORMATTER_LINES_AFTER_SPECIAL_TAGS);
		if (sLinesAfterSpecialTags != null) {
			try {
				linesAfterSpecialTags = Integer.parseInt(sLinesAfterSpecialTags);
			} catch (NumberFormatException e) {
				setLinesAfterSpecialTags(IAtlDefaultValues.CODEFORMATTER_LINES_AFTER_SPECIAL_TAGS);
			}
		} else
			setLinesAfterSpecialTags(IAtlDefaultValues.CODEFORMATTER_LINES_AFTER_SPECIAL_TAGS);
	}

	public static Map<String, String> getOptions(IPreferenceStore preferenceStore) {
		HashMap<String, String> options = new HashMap<String, String>();
		options.put(AtlPreferenceConstants.CODEFORMATTER_LINES_BETWEEN,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_LINES_BETWEEN)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_LINE_MAX_LENGTH,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_LINE_MAX_LENGTH)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.APPEARANCE_TAB_WIDTH,
				"" + preferenceStore.getInt(AtlPreferenceConstants.APPEARANCE_TAB_WIDTH)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_INSIDE_BRACES,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_INSIDE_BRACES)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_OUTSIDE_BRACES,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_OUTSIDE_BRACES)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_ARROWS,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_ARROWS)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_ARROWS,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_ARROWS)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_SEMI,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_SEMI)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_SEMI,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_SEMI)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_COMA,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_COMA)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_COMA,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_COMA)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_COLON,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_COLON)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_COLON,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_COLON)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_POINT,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_POINT)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_POINT,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_POINT)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_OPERATOR,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_OPERATOR)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_OPERATOR,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_OPERATOR)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_EQUAL,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_EQUAL)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_EQUAL,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_EQUAL)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_PIPE,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_PIPE)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_PIPE,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_PIPE)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_EXCLAMATION,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_EXCLAMATION)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_EXCLAMATION,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_EXCLAMATION)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_RULE_BRACE,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_RULE_BRACE)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_ENDING_SEMI,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_ENDING_SEMI)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_CUT_AFTER_POINT,
				"" + preferenceStore.getBoolean(AtlPreferenceConstants.CODEFORMATTER_CUT_AFTER_POINT)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_COMMENT,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_COMMENT)); //$NON-NLS-1$
		options.put(
				AtlPreferenceConstants.CODEFORMATTER_SPACES_OUTSIDE_COLLECTION_BRACE,
				""		+ preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_OUTSIDE_COLLECTION_BRACE)); //$NON-NLS-1$
		options.put(
				AtlPreferenceConstants.CODEFORMATTER_SPACES_INSIDE_COLLECTION_BRACE,
				""		+ preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_SPACES_INSIDE_COLLECTION_BRACE)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_LINES_AFTER_MODULE,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_LINES_AFTER_MODULE)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_LINES_AFTER_CREATE_FROM,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_LINES_AFTER_CREATE_FROM)); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_LINES_AFTER_SPECIAL_TAGS,
				"" + preferenceStore.getInt(AtlPreferenceConstants.CODEFORMATTER_LINES_AFTER_SPECIAL_TAGS)); //$NON-NLS-1$
		return options;
	}

	public static Map<String, String> getDefaultOptions() {
		HashMap<String, String> options = new HashMap<String, String>();
		options.put(AtlPreferenceConstants.CODEFORMATTER_LINES_BETWEEN,
				"" + IAtlDefaultValues.CODEFORMATTER_LINES_BETWEEN); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_LINE_MAX_LENGTH,
				"" + IAtlDefaultValues.CODEFORMATTER_LINE_MAX_LENGTH); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.APPEARANCE_TAB_WIDTH, "" + IAtlDefaultValues.APPEARANCE_TAB_WIDTH); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_INSIDE_BRACES,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_INSIDE_BRACES); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_OUTSIDE_BRACES,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_OUTSIDE_BRACES); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_ARROWS,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_ARROWS); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_ARROWS,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_ARROWS); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_SEMI,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_SEMI); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_SEMI,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_SEMI); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_COMA,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_COMA); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_COMA,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_COMA); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_COLON,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_COLON); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_COLON,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_COLON); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_POINT,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_POINT); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_POINT,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_POINT); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_OPERATOR,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_OPERATOR); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_OPERATOR,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_OPERATOR); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_EQUAL,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_EQUAL); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_EQUAL,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_EQUAL); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_PIPE,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_PIPE); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_PIPE,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_PIPE); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_EXCLAMATION,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_EXCLAMATION); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_EXCLAMATION,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_EXCLAMATION); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_RULE_BRACE,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_RULE_BRACE); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_ENDING_SEMI,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_BEFORE_ENDING_SEMI); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_CUT_AFTER_POINT,
				"" + IAtlDefaultValues.CODEFORMATTER_CUT_AFTER_POINT); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_COMMENT,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_AFTER_COMMENT); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_OUTSIDE_COLLECTION_BRACE,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_OUTSIDE_COLLECTION_BRACE); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_SPACES_INSIDE_COLLECTION_BRACE,
				"" + IAtlDefaultValues.CODEFORMATTER_SPACES_INSIDE_COLLECTION_BRACE); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_LINES_AFTER_MODULE,
				"" + IAtlDefaultValues.CODEFORMATTER_LINES_AFTER_MODULE); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_LINES_AFTER_CREATE_FROM,
				"" + IAtlDefaultValues.CODEFORMATTER_LINES_AFTER_CREATE_FROM); //$NON-NLS-1$
		options.put(AtlPreferenceConstants.CODEFORMATTER_LINES_AFTER_SPECIAL_TAGS,
				"" + IAtlDefaultValues.CODEFORMATTER_LINES_AFTER_SPECIAL_TAGS); //$NON-NLS-1$
		return options;
	}

	public static String getChars(int n, char character) {
		String spaces = ""; //$NON-NLS-1$
		for (int i = 0; i < n; i++) {
			spaces += character;
		}
		return spaces;
	}

	public int getLineMaxLength() {
		return lineMaxLength;
	}

	public int getTabSpaces() {
		return tabSpaces;
	}

	public String getLinesSpaces() {
		return getChars(linesBetween, '\n');
	}

	public String getOpeningBracket() {
		return getChars(spacesOutsideBraces, ' ') + "(" + getChars(spacesInsideBraces, ' '); //$NON-NLS-1$
	}

	public String getClosingBracket() {
		return getChars(spacesInsideBraces, ' ') + ")" + getChars(spacesOutsideBraces, ' '); //$NON-NLS-1$
	}

	public String getBindingArrow() {
		return getChars(spacesBeforeArrows, ' ') + "<-" + getChars(spacesAfterArrows, ' '); //$NON-NLS-1$
	}

	public String getCallingArrow() {
		return getChars(spacesBeforeArrows, ' ') + "->" + getChars(spacesAfterArrows, ' '); //$NON-NLS-1$
	}

	public String getSemicolon() {
		return getChars(spacesBeforeSemi, ' ') + ";" + getChars(spacesAfterSemi, ' '); //$NON-NLS-1$
	}

	public String getComa() {
		return getChars(spacesBeforeComa, ' ') + "," + getChars(spacesAfterComa, ' '); //$NON-NLS-1$
	}

	public String getEndingComa(int tab) {
		return getChars(spacesBeforeComa, ' ') + ",\n" + getChars(tab, '\t'); //$NON-NLS-1$
	}

	public String getColon() {
		return getChars(spacesBeforeColon, ' ') + ":" + getChars(spacesAfterColon, ' '); //$NON-NLS-1$
	}

	public String getPoint() {
		return getChars(spacesBeforePoint, ' ') + "." + getChars(spacesAfterPoint, ' '); //$NON-NLS-1$
	}

	public String getEqual() {
		return getChars(spacesBeforeEqual, ' ') + "=" + getChars(spacesAfterEqual, ' '); //$NON-NLS-1$
	}

	public String getEndingEqual() {
		return getChars(spacesBeforeEqual, ' ') + "="; //$NON-NLS-1$
	}

	public String getPipe() {
		return getChars(spacesBeforePipe, ' ') + "|" + getChars(spacesAfterPipe, ' '); //$NON-NLS-1$
	}

	public String getExclamation() {
		return getChars(spacesBeforeExclamation, ' ') + "!" + getChars(spacesAfterExclamation, ' '); //$NON-NLS-1$
	}

	public String getEndingSemicolon() {
		return getChars(spacesBeforeEndingSemi, ' ') + ";"; //$NON-NLS-1$
	}

	public String getSpacesAfterComment() {
		return getChars(spacesAfterComment, ' ');
	}

	public String getOpeningCollectionBrace() {
		return getChars(spacesOutsideCollectionBrace, ' ') + "{" + getChars(spacesInsideCollectionBrace, ' '); //$NON-NLS-1$
	}

	public String getClosingCollectionBrace() {
		return getChars(spacesInsideCollectionBrace, ' ') + "}" + getChars(spacesOutsideCollectionBrace, ' '); //$NON-NLS-1$
	}

	public String getRuleBrace(int indentation) {
		String before = ""; //$NON-NLS-1$
		if (spacesBeforeRuleBrace == 1)
			before = " "; //$NON-NLS-1$
		else if (spacesBeforeRuleBrace == 2)
			before = "\n" + getChars(indentation, '\t'); //$NON-NLS-1$
		return before + "{"; //$NON-NLS-1$
	}

	public String getBeforeOperator(int indentation) {
		String before = ""; //$NON-NLS-1$
		if (spacesBeforeOperator == 1)
			before = " "; //$NON-NLS-1$
		else if (spacesBeforeOperator == 2)
			before = "\n" + getChars(indentation, '\t'); //$NON-NLS-1$
		return before;
	}

	public String getAfterOperator(int indentation) {
		String before = ""; //$NON-NLS-1$
		if (spacesAfterOperator == 1)
			before = " "; //$NON-NLS-1$
		else if (spacesAfterOperator == 2)
			before = "\n" + getChars(indentation, '\t'); //$NON-NLS-1$
		return before;
	}

	public String getLinesAfterModule() {
		return getChars(linesAfterModule, '\n');
	}

	public String getLinesAfterCreateFrom() {
		return getChars(linesAfterCreateFrom, '\n');
	}

	public String getLinesAfterSpecialTags() {
		return getChars(linesAfterSpecialTags, '\n');
	}

	public boolean isCutAfterPoint() {
		return cutAfterPoint;
	}

	private void setLineMaxLength(int lineMaxLength) {
		this.lineMaxLength = lineMaxLength;
	}

	private void setTabSpaces(int tabSpaces) {
		this.tabSpaces = tabSpaces;
	}

	private void setLinesBetween(int linesBetween) {
		this.linesBetween = linesBetween;
	}

	private void setSpacesInsideBraces(int spacesInsideBraces) {
		this.spacesInsideBraces = spacesInsideBraces;
	}

	private void setSpacesOutsideBraces(int spacesOutsideBraces) {
		this.spacesOutsideBraces = spacesOutsideBraces;
	}

	private void setSpacesBeforeArrows(int spacesBeforeArrows) {
		this.spacesBeforeArrows = spacesBeforeArrows;
	}

	private void setSpacesAfterArrows(int spacesAfterArrows) {
		this.spacesAfterArrows = spacesAfterArrows;
	}

	private void setSpacesBeforeSemi(int spacesBeforeSemi) {
		this.spacesBeforeSemi = spacesBeforeSemi;
	}

	private void setSpacesAfterSemi(int spacesAfterSemi) {
		this.spacesAfterSemi = spacesAfterSemi;
	}

	private void setSpacesBeforeComa(int spacesBeforeComa) {
		this.spacesBeforeComa = spacesBeforeComa;
	}

	private void setSpacesAfterComa(int spacesAfterComa) {
		this.spacesAfterComa = spacesAfterComa;
	}

	private void setSpacesBeforeColon(int spacesBeforeColon) {
		this.spacesBeforeColon = spacesBeforeColon;
	}

	private void setSpacesAfterColon(int spacesAfterColon) {
		this.spacesAfterColon = spacesAfterColon;
	}

	private void setSpacesBeforePoint(int spacesBeforePoint) {
		this.spacesBeforePoint = spacesBeforePoint;
	}

	private void setSpacesAfterPoint(int spacesAfterPoint) {
		this.spacesAfterPoint = spacesAfterPoint;
	}

	private void setSpacesBeforeOperator(int spacesBeforeOperator) {
		this.spacesBeforeOperator = spacesBeforeOperator;
	}

	private void setSpacesAfterOperator(int spacesAfterOperator) {
		this.spacesAfterOperator = spacesAfterOperator;
	}

	private void setLinesAfterModule(int linesAfterModule) {
		this.linesAfterModule = linesAfterModule;
	}

	private void setLinesAfterCreateFrom(int linesAfterCreateFrom) {
		this.linesAfterCreateFrom = linesAfterCreateFrom;
	}

	private void setLinesAfterSpecialTags(int linesAfterSpecialTags) {
		this.linesAfterSpecialTags = linesAfterSpecialTags;
	}

	private void setCutAfterPoint(boolean cutAfterPoint) {
		this.cutAfterPoint = cutAfterPoint;
	}

	private void setSpacesBeforeEqual(int spacesBeforeEqual) {
		this.spacesBeforeEqual = spacesBeforeEqual;
	}

	private void setSpacesAfterEqual(int spacesAfterEqual) {
		this.spacesAfterEqual = spacesAfterEqual;
	}

	private void setSpacesBeforePipe(int spacesBeforePipe) {
		this.spacesBeforePipe = spacesBeforePipe;
	}

	private void setSpacesAfterPipe(int spacesAfterPipe) {
		this.spacesAfterPipe = spacesAfterPipe;
	}

	private void setSpacesBeforeExclamation(int spacesBeforeExclamation) {
		this.spacesBeforeExclamation = spacesBeforeExclamation;
	}

	private void setSpacesAfterExclamation(int spacesAfterExclamation) {
		this.spacesAfterExclamation = spacesAfterExclamation;
	}

	private void setSpacesBeforeRuleBrace(int spacesBeforeRuleBrace) {
		this.spacesBeforeRuleBrace = spacesBeforeRuleBrace;
	}

	private void setSpacesBeforeEndingSemi(int spacesBeforeEndingSemi) {
		this.spacesBeforeEndingSemi = spacesBeforeEndingSemi;
	}

	private void setSpacesAfterComment(int spacesAfterComment) {
		this.spacesAfterComment = spacesAfterComment;
	}

	public void setSpacesOutsideCollectionBrace(int spacesOutsideCollectionBrace) {
		this.spacesOutsideCollectionBrace = spacesOutsideCollectionBrace;
	}

	public void setSpacesInsideCollectionBrace(int spacesInsideCollectionBrace) {
		this.spacesInsideCollectionBrace = spacesInsideCollectionBrace;
	}

}
