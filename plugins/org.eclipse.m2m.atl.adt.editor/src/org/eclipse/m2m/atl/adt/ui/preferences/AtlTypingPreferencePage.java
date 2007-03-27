/*
 * Created on 22 juil. 2004
 */
package org.eclipse.m2m.atl.adt.ui.preferences;

import org.eclipse.m2m.atl.adt.ui.AtlPreferenceConstants;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author C. MONTI for ATL team
 */
public class AtlTypingPreferencePage extends AbstractPreferencePage {
	
	public AtlTypingPreferencePage() {
		super(AtlPreferencesMessages.getString("TypingPreferencePage.description"));
		
		checkBoxModel = new String[][] {
//				{ AtlPreferencesMessages.getString("TypingPreferencePage.wrapStrings"), AtlPreferenceConstants.TYPING_WRAP_STRINGS },
//				{ AtlPreferencesMessages.getString("TypingPreferencePage.escapeStrings"), AtlPreferenceConstants.TYPING_ESCAPE_STRINGS },
//				{ AtlPreferencesMessages.getString("TypingPreferencePage.smartPaste"), AtlPreferenceConstants.TYPING_SMART_PASTE },
//				{ AtlPreferencesMessages.getString("TypingPreferencePage.importsOnPaste"), AtlPreferenceConstants.TYPING_IMPORTS_ON_PASTE },
				{ AtlPreferencesMessages.getString("TypingPreferencePage.insertSpaceForTabs"),  AtlPreferenceConstants.TYPING_SPACES_FOR_TABS },
				{ AtlPreferencesMessages.getString("TypingPreferencePage.closeStrings"), AtlPreferenceConstants.TYPING_CLOSE_STRINGS },
				{ AtlPreferencesMessages.getString("TypingPreferencePage.closeBrackets"),  AtlPreferenceConstants.TYPING_CLOSE_BRACKETS },
				{ AtlPreferencesMessages.getString("TypingPreferencePage.closeBraces"),  AtlPreferenceConstants.TYPING_CLOSE_BRACES },
//				{ AtlPreferencesMessages.getString("TypingPreferencePage.typing.smartSemicolon"),  AtlPreferenceConstants.TYPING_SMART_SEMICOLON },
//				{ AtlPreferencesMessages.getString("TypingPreferencePage.typing.smartOpeningBrace"),  AtlPreferenceConstants.TYPING_SMART_OPENING_BRACE },
//				{ AtlPreferencesMessages.getString("TypingPreferencePage.typing.smartTab"),  AtlPreferenceConstants.TYPING_SMART_TAB },
		};
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createContents(Composite parent) {
		Composite control = newComposite(parent, 1);
		
		newCompositeCheckBoxes(control);
//		Composite compoCheckBoxes = newCompositeCheckBoxes(control);
		
		initialize();
		return control;
	}
	
}
