/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.preferences;

import org.eclipse.m2m.atl.adt.ui.AtlPreferenceConstants;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class AtlTypingPreferencePage extends AbstractPropertyAndPreferencePage {

	public AtlTypingPreferencePage() {
		super(AtlPreferencesMessages.getString("TypingPreferencePage.description")); //$NON-NLS-1$

		checkBoxModel = new String[][] {
				// { AtlPreferencesMessages.getString("TypingPreferencePage.wrapStrings"),
				// AtlPreferenceConstants.TYPING_WRAP_STRINGS },
				// { AtlPreferencesMessages.getString("TypingPreferencePage.escapeStrings"),
				// AtlPreferenceConstants.TYPING_ESCAPE_STRINGS },
				// { AtlPreferencesMessages.getString("TypingPreferencePage.smartPaste"),
				// AtlPreferenceConstants.TYPING_SMART_PASTE },
				// { AtlPreferencesMessages.getString("TypingPreferencePage.importsOnPaste"),
				// AtlPreferenceConstants.TYPING_IMPORTS_ON_PASTE },
				{
						AtlPreferencesMessages.getString("TypingPreferencePage.insertSpaceForTabs"), AtlPreferenceConstants.TYPING_SPACES_FOR_TABS}, //$NON-NLS-1$
				{
						AtlPreferencesMessages.getString("TypingPreferencePage.closeStrings"), AtlPreferenceConstants.TYPING_CLOSE_STRINGS}, //$NON-NLS-1$
				{
						AtlPreferencesMessages.getString("TypingPreferencePage.closeBrackets"), AtlPreferenceConstants.TYPING_CLOSE_BRACKETS}, //$NON-NLS-1$
				{
						AtlPreferencesMessages.getString("TypingPreferencePage.closeBraces"), AtlPreferenceConstants.TYPING_CLOSE_BRACES}, //$NON-NLS-1$
				// { AtlPreferencesMessages.getString("TypingPreferencePage.typing.smartSemicolon"),
				// AtlPreferenceConstants.TYPING_SMART_SEMICOLON },
				// { AtlPreferencesMessages.getString("TypingPreferencePage.typing.smartOpeningBrace"),
				// AtlPreferenceConstants.TYPING_SMART_OPENING_BRACE },
				// { AtlPreferencesMessages.getString("TypingPreferencePage.typing.smartTab"),
				// AtlPreferenceConstants.TYPING_SMART_TAB },
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

		newCompositeCheckBoxes(control);

		initialize();
		return control;
	}

}
