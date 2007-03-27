package org.eclipse.m2m.atl.adt.ui.preferences;

import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.m2m.atl.adt.ui.AtlPreferenceConstants;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

/**
 * This is the page for setting the highlight syntaxing coloration options.
 * 
 * @author C. MONTI for ATL Team
 */
public class AtlSyntaxPreferencePage extends AbstractPreferencePage {
	
	private Button backgroundColorButton;
	private ColorSelector backgroundColorSelector;
	private Button backgroundCustomRadioButton;
	private Button backgroundDefaultRadioButton;
	private Button foregroundBoldCheckBox;
	private Button foregroundColorButton;
	private Button foregroundItalicCheckBox;
	
	/**
	 * Creates a new ATL editor preference page telling to the
	 * super class the title using the resource bundle.
	 */
	public AtlSyntaxPreferencePage() {
		super(AtlPreferencesMessages.getString("SyntaxPreferencePage.description"));
		
		colorListModel = new String[][] {
				{ AtlPreferencesMessages.getString("SyntaxPreferencePage.brackets"), AtlPreferenceConstants.SYNTAX_BRACKET },
				{ AtlPreferencesMessages.getString("SyntaxPreferencePage.constants"), AtlPreferenceConstants.SYNTAX_CONSTANT },
				{ AtlPreferencesMessages.getString("SyntaxPreferencePage.identifiers"), AtlPreferenceConstants.SYNTAX_IDENTIFIER },
				{ AtlPreferencesMessages.getString("SyntaxPreferencePage.keywords"), AtlPreferenceConstants.SYNTAX_KEYWORD },
				{ AtlPreferencesMessages.getString("SyntaxPreferencePage.literals"), AtlPreferenceConstants.SYNTAX_LITERAL },
				{ AtlPreferencesMessages.getString("SyntaxPreferencePage.numbers"), AtlPreferenceConstants.SYNTAX_NUMBER },
				{ AtlPreferencesMessages.getString("SyntaxPreferencePage.operators"), AtlPreferenceConstants.SYNTAX_OPERATOR },
				{ AtlPreferencesMessages.getString("SyntaxPreferencePage.others"), AtlPreferenceConstants.SYNTAX_DEFAULT },
				{ AtlPreferencesMessages.getString("SyntaxPreferencePage.singleLineComments"), AtlPreferenceConstants.SYNTAX_SINGLE_LINE_COMMENT },
				{ AtlPreferencesMessages.getString("SyntaxPreferencePage.strings"), AtlPreferenceConstants.SYNTAX_STRING },
				{ AtlPreferencesMessages.getString("SyntaxPreferencePage.symbols"), AtlPreferenceConstants.SYNTAX_SYMBOL },
				{ AtlPreferencesMessages.getString("SyntaxPreferencePage.types"), AtlPreferenceConstants.SYNTAX_TYPE }
				};
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createContents(Composite parent) {
		Composite control = newComposite(parent, 1);
		Group background = newGroup(control, AtlPreferencesMessages.getString("SyntaxPreferencePage.backgroundColor"));
		
		SelectionListener backgroundSelectionListener = new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}
			public void widgetSelected(SelectionEvent e) {
				boolean custom = backgroundCustomRadioButton.getSelection();
				backgroundColorButton.setEnabled(custom);
				fPreferenceeStore.setValue(AtlPreferenceConstants.EDITOR_BACKGROUND_COLOR_DEFAULT, !custom);
			}
		};
		
		backgroundDefaultRadioButton = newRadioButton(background, AtlPreferencesMessages.getString("SyntaxPreferencePage.systemDefault"), backgroundSelectionListener);
		backgroundCustomRadioButton = newRadioButton(background, AtlPreferencesMessages.getString("SyntaxPreferencePage.custom"), backgroundSelectionListener);
		backgroundColorSelector = new ColorSelector(background);
		backgroundColorButton = backgroundColorSelector.getButton();
		backgroundColorButton.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}
			public void widgetSelected(SelectionEvent e) {
				PreferenceConverter.setValue(fPreferenceeStore, AtlPreferenceConstants.EDITOR_BACKGROUND_COLOR, backgroundColorSelector.getColorValue());					
			}
		});
		
		Composite foreground1 = newComposite(control, 1);
//		Label foregroundLabel = newLabelField(foreground1, AtlPreferencesMessages.getString("SyntaxPreferencePage.foregroundColor"));

		Composite foreground2 = newComposite(foreground1, 2);
		colorList = newScrollList(foreground2);
		colorList.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}
			public void widgetSelected(SelectionEvent e) {
				handleColorListSelection();
			}
		});
		
		Composite foreground3 = newComposite(foreground2, 1);
		
		Composite foreground4 = newComposite(foreground3, 2);
//		Label foregroundColorLabel = newLabelField(foreground4, AtlPreferencesMessages.getString("SyntaxPreferencePage.color"));
		colorSelector = new ColorSelector(foreground4);
		foregroundColorButton = colorSelector.getButton();
		foregroundColorButton.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}
			public void widgetSelected(SelectionEvent e) {
				int i = colorList.getSelectionIndex();
				String key = colorListModel[i][1];
				PreferenceConverter.setValue(fPreferenceeStore, key + AtlPreferenceConstants.__COLOR_SUFFIX, colorSelector.getColorValue());
			}
		});
		
		foregroundBoldCheckBox = newCheckBoxField(
				foreground3,
				AtlPreferencesMessages.getString("SyntaxPreferencePage.bold"));
		foregroundBoldCheckBox.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}
			public void widgetSelected(SelectionEvent e) {
				int i = colorList.getSelectionIndex();
				String key = colorListModel[i][1];
				fPreferenceeStore.setValue(key + AtlPreferenceConstants.__BOLD_SUFFIX, foregroundBoldCheckBox.getSelection());
			}
		});

		foregroundItalicCheckBox = newCheckBoxField(
				foreground3,
				AtlPreferencesMessages.getString("SyntaxPreferencePage.italic"));
		foregroundItalicCheckBox.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}
			public void widgetSelected(SelectionEvent e) {
				int i = colorList.getSelectionIndex();
				String key = colorListModel[i][1];
				fPreferenceeStore.setValue(key + AtlPreferenceConstants.__ITALIC_SUFFIX, foregroundItalicCheckBox.getSelection());
			}
		});
		
		initialize();
		return control;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.m2m.atl.adt.ui.preferences.AbstractPreferencePage#handleColorListSelection()
	 */
	protected void handleColorListSelection() {
		String key = colorListModel[colorList.getSelectionIndex()][1];
		colorSelector.setColorValue(PreferenceConverter.getColor(fPreferenceeStore, key + AtlPreferenceConstants.__COLOR_SUFFIX));
		foregroundBoldCheckBox.setSelection(fPreferenceeStore.getBoolean(key + AtlPreferenceConstants.__BOLD_SUFFIX));
		foregroundItalicCheckBox.setSelection(fPreferenceeStore.getBoolean(key + AtlPreferenceConstants.__ITALIC_SUFFIX));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.m2m.atl.adt.ui.preferences.AbstractPreferencePage#initialize()
	 */
	protected void initialize() {
		super.initialize();
		
		backgroundColorSelector.setColorValue(PreferenceConverter.getColor(fPreferenceeStore, AtlPreferenceConstants.EDITOR_BACKGROUND_COLOR));
		boolean _default_ = fPreferenceeStore.getBoolean(AtlPreferenceConstants.EDITOR_BACKGROUND_COLOR_DEFAULT);
		backgroundDefaultRadioButton.setSelection(_default_);
		backgroundCustomRadioButton.setSelection(!_default_);
		backgroundColorSelector.setEnabled(!_default_);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
	 */
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
	 */
	protected void performDefaults() {
		super.performDefaults();
		
		fPreferenceeStore.setValue(AtlPreferenceConstants.EDITOR_BACKGROUND_COLOR_DEFAULT, true);
		backgroundDefaultRadioButton.setSelection(true);
		backgroundCustomRadioButton.setSelection(false);
		backgroundColorSelector.setEnabled(false);
		
		for(int i = 0; i < colorListModel.length; ++i) {
			String key = colorListModel[i][1];
			PreferenceConverter.setValue(
					fPreferenceeStore,
					key + AtlPreferenceConstants.__COLOR_SUFFIX,
					PreferenceConverter.getDefaultColor(fPreferenceeStore, key + AtlPreferenceConstants.__COLOR_SUFFIX));
			fPreferenceeStore.setValue(
					key + AtlPreferenceConstants.__BOLD_SUFFIX,
					fPreferenceeStore.getDefaultBoolean(key + AtlPreferenceConstants.__BOLD_SUFFIX));
			fPreferenceeStore.setValue(
					key + AtlPreferenceConstants.__ITALIC_SUFFIX,
					fPreferenceeStore.getDefaultBoolean(key + AtlPreferenceConstants.__ITALIC_SUFFIX));
		}
		handleColorListSelection();
	}
	
}
