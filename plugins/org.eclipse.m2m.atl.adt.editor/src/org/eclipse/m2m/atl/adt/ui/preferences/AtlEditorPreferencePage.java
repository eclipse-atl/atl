package org.eclipse.m2m.atl.adt.ui.preferences;

import org.eclipse.m2m.atl.adt.ui.AtlPreferenceConstants;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * This is the page for setting the editor options.
 * 
 * @author C. MONTI for ATL Team
 */
public class AtlEditorPreferencePage extends AbstractPreferencePage {

    /**
	 * Creates a new ATL editor preference page telling to the
	 * super class the title using the resource bundle.
	 */
	public AtlEditorPreferencePage() {
		super(AtlPreferencesMessages.getString("AppearancePreferencePage.description"));

		checkBoxModel = new String[][] {
				{ AtlPreferencesMessages.getString("AppearancePreferencePage.highlightCurrentLine"), AtlPreferenceConstants.APPEARANCE_HIGHLIGHT_CURRENT_LINE },
				{ AtlPreferencesMessages.getString("AppearancePreferencePage.highlightMatchingBrackets"), AtlPreferenceConstants.APPEARANCE_HIGHLIGHT_MATCHING_BRACKETS },
				{ AtlPreferencesMessages.getString("AppearancePreferencePage.lineNumberRuler"), AtlPreferenceConstants.APPEARANCE_LINE_NUMBER_RULER },
				{ AtlPreferencesMessages.getString("AppearancePreferencePage.printMargin"), AtlPreferenceConstants.APPEARANCE_PRINT_MARGIN }
		};
		
		colorListModel = new String[][] {
				{ AtlPreferencesMessages.getString("AppearancePreferencePage.highlightCurrentLineColor"), AtlPreferenceConstants.APPEARANCE_CURRENT_LINE_COLOR },
				{ AtlPreferencesMessages.getString("AppearancePreferencePage.highlightMatchingBracketsColor"), AtlPreferenceConstants.APPEARANCE_HIGHLIGHT_MATCHING_BRACKETS_COLOR },
				{ AtlPreferencesMessages.getString("AppearancePreferencePage.lineNumberColor"), AtlPreferenceConstants.APPEARANCE_LINE_NUMBER_COLOR },
				{ AtlPreferencesMessages.getString("AppearancePreferencePage.printMarginColor"), AtlPreferenceConstants.APPEARANCE_PRINT_MARGIN_COLOR },
				{ AtlPreferencesMessages.getString("AppearancePreferencePage.selectionBackgroundColor"), AtlPreferenceConstants.APPEARANCE_SELECTION_BACKGROUND_COLOR },
				{ AtlPreferencesMessages.getString("AppearancePreferencePage.selectionForegroundColor"), AtlPreferenceConstants.APPEARANCE_SELECTION_FOREGROUND_COLOR }
		};
		
		textFieldModel = new String[][] {
				{ AtlPreferencesMessages.getString("AppearancePreferencePage.printMarginColumn"), AtlPreferenceConstants.APPEARANCE_PRINT_MARGIN_COLUMN, "5" },
				{ AtlPreferencesMessages.getString("AppearancePreferencePage.displayedTabWidth"), AtlPreferenceConstants.APPEARANCE_TAB_WIDTH, "5" }
		};
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createContents(Composite parent) {
		Composite control = newComposite(parent, 1);

		newCompositeTextFields(control);
		newCompositeCheckBoxes(control);
		newCompositeColors(
		        control,
		        AtlPreferencesMessages.getString("AppearancePreferencePage.appearanceColor"),
		        AtlPreferencesMessages.getString("AppearancePreferencePage.color"));
//		Composite compoTextFields = newCompositeTextFields(control);
//		Composite compoCheckBoxes = newCompositeCheckBoxes(control);
//		Composite compoColors = newCompositeColors(
//		        control,
//		        AtlPreferencesMessages.getString("AppearancePreferencePage.appearanceColor"),
//		        AtlPreferencesMessages.getString("AppearancePreferencePage.color"));
		
		initialize();
		return control;
	}
	
}
