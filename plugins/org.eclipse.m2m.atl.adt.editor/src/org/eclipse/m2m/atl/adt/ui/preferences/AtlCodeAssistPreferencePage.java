/*
 * Created on 22 juil. 2004
 */
package org.eclipse.m2m.atl.adt.ui.preferences;

import org.eclipse.m2m.atl.adt.ui.AtlPreferenceConstants;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author C. MONTI for ATL Team
 */
public class AtlCodeAssistPreferencePage extends AbstractPreferencePage {
	
	public AtlCodeAssistPreferencePage() {
		super(AtlPreferencesMessages.getString("CodeAssistPreferencePage.description"));
		
		checkBoxModel = new String[][] {
//				{ AtlPreferencesMessages.getString("CodeAssistPreferencePage.autoInsert"), AtlPreferenceConstants.CODEASSIST_AUTOINSERT },
//				{ AtlPreferencesMessages.getString("CodeAssistPreferencePage.autoPrefixCompletion"), AtlPreferenceConstants.CODEASSIST_PREFIX_COMPLETION },
//				{ AtlPreferencesMessages.getString("CodeAssistPreferencePage.showVisibleProposals"), AtlPreferenceConstants.CODEASSIST_SHOW_VISIBLE_PROPOSALS },
//				{ AtlPreferencesMessages.getString("CodeAssistPreferencePage.caseSensitivity"), AtlPreferenceConstants.CODEASSIST_CASE_SENSITIVITY },
//				{ AtlPreferencesMessages.getString("CodeAssistPreferencePage.orderProposals"), AtlPreferenceConstants.CODEASSIST_ORDER_PROPOSALS },
				{ AtlPreferencesMessages.getString("CodeAssistPreferencePage.autoActivationEnable"), AtlPreferenceConstants.CODEASSIST_AUTOACTIVATION_ENABLE }
		};
		
		colorListModel = new String[][] {
				{ AtlPreferencesMessages.getString("CodeAssistPreferencePage.parametersBackground"), AtlPreferenceConstants.CODEASSIST_PARAMETERS_BACKGROUND },
				{ AtlPreferencesMessages.getString("CodeAssistPreferencePage.parametersForeground"), AtlPreferenceConstants.CODEASSIST_PARAMETERS_FOREGROUND },
				{ AtlPreferencesMessages.getString("CodeAssistPreferencePage.proposalsBackground"), AtlPreferenceConstants.CODEASSIST_PROPOSALS_BACKGROUND },
				{ AtlPreferencesMessages.getString("CodeAssistPreferencePage.proposalsForeground"), AtlPreferenceConstants.CODEASSIST_PROPOSALS_FOREGROUND },
				{ AtlPreferencesMessages.getString("CodeAssistPreferencePage.replacementBackground"), AtlPreferenceConstants.CODEASSIST_REPLACEMENT_BACKGROUND },
				{ AtlPreferencesMessages.getString("CodeAssistPreferencePage.replacementForeground"), AtlPreferenceConstants.CODEASSIST_REPLACEMENT_FOREGROUND }
		};
		
		textFieldModel = new String[][] {
				{ AtlPreferencesMessages.getString("CodeAssistPreferencePage.autoActivationDelay"), AtlPreferenceConstants.CODEASSIST_AUTOACTIVATION_DELAY, "5" },
				{ AtlPreferencesMessages.getString("CodeAssistPreferencePage.autoActivationTriggers"), AtlPreferenceConstants.CODEASSIST_AUTOACTIVATION_TRIGGERS, "5" }
		};
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createContents(Composite parent) {
		Composite control = newComposite(parent, 1);

		newCompositeCheckBoxes(control);
		newCompositeTextFields(control);
		newCompositeColors(
		        control,
		        AtlPreferencesMessages.getString("CodeAssistPreferencePage.appearanceColor"),
		        AtlPreferencesMessages.getString("CodeAssistPreferencePage.color"));
//		Composite compoCheckBoxes = newCompositeCheckBoxes(control);
//		Composite compoTextFields = newCompositeTextFields(control);
//		Composite compoColors = newCompositeColors(
//		        control,
//		        AtlPreferencesMessages.getString("CodeAssistPreferencePage.appearanceColor"),
//		        AtlPreferencesMessages.getString("CodeAssistPreferencePage.color"));
		
		initialize();
		return control;
	}
	
}
