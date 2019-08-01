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

public class AtlCodeAssistPreferencePage extends AbstractPropertyAndPreferencePage {

	public AtlCodeAssistPreferencePage() {
		super(AtlPreferencesMessages.getString("CodeAssistPreferencePage.description")); //$NON-NLS-1$

		checkBoxModel = new String[][] {
		// { AtlPreferencesMessages.getString("CodeAssistPreferencePage.autoInsert"),
		// AtlPreferenceConstants.CODEASSIST_AUTOINSERT },
		// { AtlPreferencesMessages.getString("CodeAssistPreferencePage.autoPrefixCompletion"),
		// AtlPreferenceConstants.CODEASSIST_PREFIX_COMPLETION },
		// { AtlPreferencesMessages.getString("CodeAssistPreferencePage.showVisibleProposals"),
		// AtlPreferenceConstants.CODEASSIST_SHOW_VISIBLE_PROPOSALS },
		// { AtlPreferencesMessages.getString("CodeAssistPreferencePage.caseSensitivity"),
		// AtlPreferenceConstants.CODEASSIST_CASE_SENSITIVITY },
		// { AtlPreferencesMessages.getString("CodeAssistPreferencePage.orderProposals"),
		// AtlPreferenceConstants.CODEASSIST_ORDER_PROPOSALS },
		{
				AtlPreferencesMessages.getString("CodeAssistPreferencePage.autoActivationEnable"), AtlPreferenceConstants.CODEASSIST_AUTOACTIVATION_ENABLE} //$NON-NLS-1$
		};

		colorListModel = new String[][] {
				{
						AtlPreferencesMessages.getString("CodeAssistPreferencePage.parametersBackground"), AtlPreferenceConstants.CODEASSIST_PARAMETERS_BACKGROUND}, //$NON-NLS-1$
				{
						AtlPreferencesMessages.getString("CodeAssistPreferencePage.parametersForeground"), AtlPreferenceConstants.CODEASSIST_PARAMETERS_FOREGROUND}, //$NON-NLS-1$
				{
						AtlPreferencesMessages.getString("CodeAssistPreferencePage.proposalsBackground"), AtlPreferenceConstants.CODEASSIST_PROPOSALS_BACKGROUND}, //$NON-NLS-1$
				{
						AtlPreferencesMessages.getString("CodeAssistPreferencePage.proposalsForeground"), AtlPreferenceConstants.CODEASSIST_PROPOSALS_FOREGROUND}, //$NON-NLS-1$
				{
						AtlPreferencesMessages.getString("CodeAssistPreferencePage.replacementBackground"), AtlPreferenceConstants.CODEASSIST_REPLACEMENT_BACKGROUND}, //$NON-NLS-1$
				{
						AtlPreferencesMessages.getString("CodeAssistPreferencePage.replacementForeground"), AtlPreferenceConstants.CODEASSIST_REPLACEMENT_FOREGROUND} //$NON-NLS-1$
		};

		textFieldModel = new String[][] {
				{
						AtlPreferencesMessages.getString("CodeAssistPreferencePage.autoActivationDelay"), AtlPreferenceConstants.CODEASSIST_AUTOACTIVATION_DELAY, "5"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeAssistPreferencePage.autoActivationTriggers"), AtlPreferenceConstants.CODEASSIST_AUTOACTIVATION_TRIGGERS, "5"} //$NON-NLS-1$ //$NON-NLS-2$
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
		newCompositeTextFields(control);
		newCompositeColors(control, AtlPreferencesMessages
				.getString("CodeAssistPreferencePage.appearanceColor"), //$NON-NLS-1$
				AtlPreferencesMessages.getString("CodeAssistPreferencePage.color")); //$NON-NLS-1$
		// Composite compoCheckBoxes = newCompositeCheckBoxes(control);
		// Composite compoTextFields = newCompositeTextFields(control);
		// Composite compoColors = newCompositeColors(
		// control,
		// AtlPreferencesMessages.getString("CodeAssistPreferencePage.appearanceColor"),
		// AtlPreferencesMessages.getString("CodeAssistPreferencePage.color"));

		initialize();
		return control;
	}

}
