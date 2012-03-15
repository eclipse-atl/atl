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
package org.eclipse.m2m.atl.adt.ui.preferences;

import org.eclipse.m2m.atl.adt.ui.AtlPreferenceConstants;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * This is the page for setting the editor options.
 */
public class AtlEditorPreferencePage extends AbstractPropertyAndPreferencePage {

	/**
	 * Creates a new ATL editor preference page telling to the super class the title using the resource
	 * bundle.
	 */
	public AtlEditorPreferencePage() {
		super(AtlPreferencesMessages.getString("AppearancePreferencePage.description")); //$NON-NLS-1$

		checkBoxModel = new String[][] {
				{
						AtlPreferencesMessages.getString("AppearancePreferencePage.highlightCurrentLine"), AtlPreferenceConstants.APPEARANCE_HIGHLIGHT_CURRENT_LINE}, //$NON-NLS-1$
				{
						AtlPreferencesMessages
								.getString("AppearancePreferencePage.highlightMatchingBrackets"), AtlPreferenceConstants.APPEARANCE_HIGHLIGHT_MATCHING_BRACKETS}, //$NON-NLS-1$
				{
						AtlPreferencesMessages.getString("AppearancePreferencePage.lineNumberRuler"), AtlPreferenceConstants.APPEARANCE_LINE_NUMBER_RULER}, //$NON-NLS-1$
				{
						AtlPreferencesMessages.getString("AppearancePreferencePage.printMargin"), AtlPreferenceConstants.APPEARANCE_PRINT_MARGIN} //$NON-NLS-1$
		};

		colorListModel = new String[][] {
				{
						AtlPreferencesMessages
								.getString("AppearancePreferencePage.highlightCurrentLineColor"), AtlPreferenceConstants.APPEARANCE_CURRENT_LINE_COLOR}, //$NON-NLS-1$
				{
						AtlPreferencesMessages
								.getString("AppearancePreferencePage.highlightMatchingBracketsColor"), AtlPreferenceConstants.APPEARANCE_HIGHLIGHT_MATCHING_BRACKETS_COLOR}, //$NON-NLS-1$
				{
						AtlPreferencesMessages.getString("AppearancePreferencePage.lineNumberColor"), AtlPreferenceConstants.APPEARANCE_LINE_NUMBER_COLOR}, //$NON-NLS-1$
				{
						AtlPreferencesMessages.getString("AppearancePreferencePage.printMarginColor"), AtlPreferenceConstants.APPEARANCE_PRINT_MARGIN_COLOR}, //$NON-NLS-1$
				{
						AtlPreferencesMessages.getString("AppearancePreferencePage.selectionBackgroundColor"), AtlPreferenceConstants.APPEARANCE_SELECTION_BACKGROUND_COLOR}, //$NON-NLS-1$
				{
						AtlPreferencesMessages.getString("AppearancePreferencePage.selectionForegroundColor"), AtlPreferenceConstants.APPEARANCE_SELECTION_FOREGROUND_COLOR} //$NON-NLS-1$
		};

		textFieldModel = new String[][] {
				{
						AtlPreferencesMessages.getString("AppearancePreferencePage.printMarginColumn"), AtlPreferenceConstants.APPEARANCE_PRINT_MARGIN_COLUMN, "5"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("AppearancePreferencePage.displayedTabWidth"), AtlPreferenceConstants.APPEARANCE_TAB_WIDTH, "5"} //$NON-NLS-1$ //$NON-NLS-2$
		};
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite control = newComposite(parent, 1);

		newCompositeTextFields(control);
		newCompositeCheckBoxes(control);
		newCompositeColors(control, AtlPreferencesMessages
				.getString("AppearancePreferencePage.appearanceColor"), //$NON-NLS-1$
				AtlPreferencesMessages.getString("AppearancePreferencePage.color")); //$NON-NLS-1$
		// Composite compoTextFields = newCompositeTextFields(control);
		// Composite compoCheckBoxes = newCompositeCheckBoxes(control);
		// Composite compoColors = newCompositeColors(
		// control,
		// AtlPreferencesMessages.getString("AppearancePreferencePage.appearanceColor"),
		// AtlPreferencesMessages.getString("AppearancePreferencePage.color"));

		initialize();
		return control;
	}

}
