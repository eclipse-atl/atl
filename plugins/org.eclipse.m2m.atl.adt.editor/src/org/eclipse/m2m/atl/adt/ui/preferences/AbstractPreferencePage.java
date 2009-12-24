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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.m2m.atl.adt.ui.AtlPreferenceConstants;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This abstract class permits other preferences pages to use some classical method such creating fields
 * ofenly used.
 */
public abstract class AbstractPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	/*
	 * private static void indent(Control control) { GridData gridData = new GridData();
	 * gridData.horizontalIndent = 20; control.setLayoutData(gridData); }
	 */

	protected String[][] checkBoxModel;

	protected List colorList;

	protected String[][] colorListModel;

	protected ColorSelector colorSelector;

	protected AtlPreferenceStore fPreferenceeStore;

	protected String[][] textFieldModel;

	private Map<Button, String> checkBoxes = new HashMap<Button, String>();

	private SelectionListener checkBoxFieldListener = new SelectionListener() {
		public void widgetDefaultSelected(SelectionEvent e) {
		}

		public void widgetSelected(SelectionEvent e) {
			Button button = (Button)e.widget;
			fPreferenceeStore.setValue(checkBoxes.get(button), button.getSelection());
		}
	};

	/**
	 * List of master/slave listeners when there's a dependency.
	 * 
	 * @see #createDependency(Button, String, Control)
	 */
	private java.util.List<SelectionListener> fMasterSlaveListeners = new ArrayList<SelectionListener>();

	private ModifyListener fTextFieldListener = new ModifyListener() {
		public void modifyText(ModifyEvent e) {
			Text text = (Text)e.widget;
			fPreferenceeStore.setValue(textFields.get(text), text.getText());
		}
	};

	private Map<Text, String> textFields = new HashMap<Text, String>();

	/**
	 * Creates a new preference page with a title using the <code>PreferencePage</code> constructor. Above
	 * that, a new preference fPreferenceeStore is created to react with the default one of the
	 * <code>AtlUIPlugin</code>.
	 * 
	 * @param title
	 *            the preference page title
	 */
	public AbstractPreferencePage(String title) {
		super();
		setDescription(title);
		fPreferenceeStore = new AtlPreferenceStore(getPreferenceStore(), AtlPreferenceConstants
				.createStoreKeys());

		fPreferenceeStore.load();
		fPreferenceeStore.start();
	}

	/*
	 * private void createDependency(final Button master, String masterKey, final Control slave) {
	 * indent(slave); boolean masterState = fPreferenceeStore.getBoolean(masterKey);
	 * slave.setEnabled(masterState); SelectionListener listener = new SelectionListener() { public void
	 * widgetDefaultSelected(SelectionEvent e) { } public void widgetSelected(SelectionEvent e) {
	 * slave.setEnabled(master.getSelection()); } }; master.addSelectionListener(listener);
	 * fMasterSlaveListeners.add(listener); }
	 */

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.DialogPage#dispose()
	 */
	@Override
	public void dispose() {
		if (fPreferenceeStore != null) {
			fPreferenceeStore.stop();
			fPreferenceeStore = null;
		}

		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#doGetPreferenceStore()
	 */
	@Override
	protected IPreferenceStore doGetPreferenceStore() {
		return AtlUIPlugin.getDefault().getPreferenceStore();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#getPreferenceStore()
	 */
	@Override
	public IPreferenceStore getPreferenceStore() {
		return AtlUIPlugin.getDefault().getPreferenceStore();
	}

	/**
	 * When a selection is made, the color button handles the color sets by this selection. The default
	 * implementation does nothing.
	 */
	protected void handleColorListSelection() {
		String key = colorListModel[colorList.getSelectionIndex()][1];
		colorSelector.setColorValue(PreferenceConverter.getColor(fPreferenceeStore, key));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

	/**
	 * Initializes the preference page with the user values. The default implementation initializes all
	 * widgets lists with there user's value.
	 */
	protected void initialize() {
		initializeFieldsToUserValues();

		if ((colorListModel != null) && (colorList != null)) {
			for (int i = 0; i < colorListModel.length; ++i) {
				colorList.add(colorListModel[i][0]);
			}
			colorList.getDisplay().asyncExec(new Runnable() {
				public void run() {
					if (colorList != null && !colorList.isDisposed()) {
						colorList.select(0);
						handleColorListSelection();
					}
				}
			});
		}

		// Update slaves
		Iterator<SelectionListener> iter = fMasterSlaveListeners.iterator();
		while (iter.hasNext()) {
			SelectionListener listener = iter.next();
			listener.widgetSelected(null);
		}
	}

	/**
	 * Initializes the preference page widgets with the default values.
	 */
	protected void initializeFieldsToDefaultValues() {
		if (checkBoxes != null) {
			Iterator<Button> i = checkBoxes.keySet().iterator();
			while (i.hasNext()) {
				Button b = i.next();
				String key = checkBoxes.get(b);
				b.setSelection(fPreferenceeStore.getDefaultBoolean(key));
				fPreferenceeStore.setValue(checkBoxes.get(b), b.getSelection());
			}
		}

		if (textFields != null) {
			Iterator<Text> i = textFields.keySet().iterator();
			while (i.hasNext()) {
				Text t = i.next();
				String key = textFields.get(t);
				t.setText(fPreferenceeStore.getDefaultString(key));
				fPreferenceeStore.setValue(textFields.get(t), t.getText());
			}
		}
	}

	/**
	 * Initializes the preference page widgets with the user values.
	 */
	protected void initializeFieldsToUserValues() {
		if (checkBoxes != null) {
			Iterator<Button> i = checkBoxes.keySet().iterator();
			while (i.hasNext()) {
				Button b = i.next();
				String key = checkBoxes.get(b);
				b.setSelection(fPreferenceeStore.getBoolean(key));
			}
		}

		if (textFields != null) {
			Iterator<Text> i = textFields.keySet().iterator();
			while (i.hasNext()) {
				Text t = i.next();
				String key = textFields.get(t);
				t.setText(fPreferenceeStore.getString(key));
			}
		}
	}

	/**
	 * Creates an new checkbox instance.
	 * 
	 * @param parent
	 *            the composite in which to create the checkbox
	 * @param label
	 *            the string to set into the checkbox
	 * @return the new checkbox
	 */
	protected Button newCheckBoxField(Composite parent, String label) {
		Button res = new Button(parent, SWT.CHECK | SWT.LEAD);
		res.setText(label);
		return res;
	}

	/**
	 * Creates an new checkbox instance and stores it in a hash map. The default listener
	 * <code>checkBoxFieldListener</code> is associated with.
	 * 
	 * @param parent
	 *            the composite in which to create the checkbox
	 * @param label
	 *            the string to set into the checkbox
	 * @param key
	 *            the string key associated
	 * @return the new checkbox
	 */
	protected Button newCheckBoxField(Composite parent, String label, String key) {
		return newCheckBoxField(parent, label, key, checkBoxFieldListener);
	}

	/**
	 * Creates an new checkbox instance and stores it in a hash map. A listener is associated with.
	 * 
	 * @param parent
	 *            the composite in which to create the checkbox
	 * @param label
	 *            the string to set into the checkbox
	 * @param key
	 *            the string key associated
	 * @param sl
	 *            the selection listener associated with
	 * @return the new checkbox
	 */
	protected Button newCheckBoxField(Composite parent, String label, String key, SelectionListener sl) {
		Button res = newCheckBoxField(parent, label);
		res.addSelectionListener(sl);
		checkBoxes.put(res, key);
		return res;
	}

	/**
	 * Creates a new color list with a label and a color selector button.
	 * 
	 * @param parent
	 *            the parent composite group
	 * @param listLabel
	 *            the color list label
	 * @param buttonLabel
	 *            the color selector label
	 * @param colorListModel
	 *            the models of the color list
	 * @return the objects' list of the group
	 */
	protected Control[] newColorList(Composite parent, String listLabel, String buttonLabel,
			final String[][] colorListModel) {
		Composite compo1 = newComposite(parent, 1);
		newLabelField(compo1, listLabel);

		Composite compo2 = newComposite(compo1, 2);
		colorList = newScrollList(compo2);
		colorList.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				handleColorListSelection();
			}
		});

		Composite compo3 = newComposite(compo2, 2);
		newLabelField(compo3, buttonLabel);
		colorSelector = new ColorSelector(compo3);
		Button colorButton = colorSelector.getButton();
		colorButton.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				int i = colorList.getSelectionIndex();
				String key = colorListModel[i][1];
				PreferenceConverter.setValue(fPreferenceeStore, key, colorSelector.getColorValue());
			}
		});

		return null;
	}

	/**
	 * Creates composite control and sets the default layout data.
	 * 
	 * @param parent
	 *            the parent of the new composite
	 * @param numColumns
	 *            the number of columns for the new composite
	 * @return the newly-created coposite
	 */
	protected Composite newComposite(Composite parent, int numColumns) {
		Composite composite = new Composite(parent, SWT.NULL);

		// GridLayout
		GridLayout layout = new GridLayout();
		layout.numColumns = numColumns;
		composite.setLayout(layout);

		// GridData
		GridData data = new GridData();
		data.verticalAlignment = GridData.FILL;
		data.horizontalAlignment = GridData.FILL;
		composite.setLayoutData(data);
		return composite;
	}

	protected Composite newCompositeCheckBoxes(Composite parent) {
		Composite control = newComposite(parent, 1);
		for (int i = 0; i < checkBoxModel.length; ++i) {
			newCheckBoxField(control, checkBoxModel[i][0], checkBoxModel[i][1]);
		}
		return control;
	}

	protected Composite newCompositeColors(Composite parent, String listLabel, String buttonLabel) {
		Composite control = newComposite(parent, 2);
		newColorList(control, listLabel, buttonLabel, colorListModel);
		return control;
	}

	protected Composite newCompositeTextFields(Composite parent) {
		Composite control = newComposite(parent, 2);
		for (int i = 0; i < textFieldModel.length; ++i) {
			newLabelledTextField(control, textFieldModel[i][0],
					"", Integer.parseInt(textFieldModel[i][2]), textFieldModel[i][1]); //$NON-NLS-1$
		}
		return control;
	}

	/**
	 * Creates a new elements group with a title above the side.
	 * 
	 * @param parent
	 *            the parent of the new group
	 * @param text
	 *            the title of the new group
	 * @return the new group
	 */
	protected Group newGroup(Composite parent, String text) {
		Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
		RowLayout rowlayout = new RowLayout();
		rowlayout.type = SWT.HORIZONTAL;
		group.setLayout(rowlayout);
		group.setText(text);
		return group;
	}

	/**
	 * Utility method that creates a label instance and sets the default layout data.
	 * 
	 * @param parent
	 *            the parent for the new label
	 * @param text
	 *            the text for the new label
	 * @return the new label
	 */
	protected Label newLabelField(Composite parent, String text) {
		Label label = new Label(parent, SWT.LEFT);
		label.setText(text);
		return label;
	}

	/**
	 * Creates a new group composed by a label and an editable text field. It is designed to work on a two
	 * columns composite.
	 * 
	 * @param parent
	 *            the parent group
	 * @param label
	 *            the label of the group
	 * @param text
	 *            the default value of the text field
	 * @param limit
	 *            the maximum number of chars in the field
	 * @param key
	 *            the string key associated
	 * @return the new composed group
	 */
	protected Text newLabelledTextField(Composite parent, String label, String text, int limit, String key) {
		newLabelField(parent, label);
		return newTextField(parent, text, limit, key);
	}

	/**
	 * Utility method that creates a push button instance and sets the default layout data.
	 * 
	 * @param parent
	 *            the parent for the new button
	 * @param text
	 *            the label for the new button
	 * @return the newly-created button
	 */
	protected Button newPushButton(Composite parent, String text, SelectionListener sl) {
		Button button = new Button(parent, SWT.PUSH);
		button.setText(text);
		button.addSelectionListener(sl);
		GridData data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		button.setLayoutData(data);
		return button;
	}

	/**
	 * Utility method that creates a radio button instance and sets the default layout data.
	 * 
	 * @param parent
	 *            the parent for the new button
	 * @param text
	 *            the label for the new button
	 * @return the newly-created button
	 */
	protected Button newRadioButton(Composite parent, String text, SelectionListener sl) {
		Button button = new Button(parent, SWT.RADIO | SWT.LEFT);
		button.setText(text);
		button.addSelectionListener(sl);
		return button;
	}

	/**
	 * Creates a new scroll list.
	 * 
	 * @param parent
	 *            the parent in which the list is created
	 * @return a new empty list
	 */
	protected List newScrollList(Composite parent) {
		List res = new List(parent, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
		GridData gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_BOTH);
		gd.heightHint = convertHeightInCharsToPixels(8);
		res.setLayoutData(gd);
		return res;
	}

	/**
	 * Creates a new tab item in a tab folder.
	 * 
	 * @param parent
	 *            the parent tab folder
	 * @param text
	 *            the tab item label
	 * @param control
	 *            the page of this item
	 * @return the new tab item containing the preference page.
	 */
	protected TabItem newTabItem(TabFolder parent, String text, Control control) {
		TabItem item;
		item = new TabItem(parent, SWT.NONE);
		item.setText(text);
		item.setControl(control);
		return item;
	}

	/**
	 * Creates a new editable text field.
	 * 
	 * @param parent
	 *            the parent group
	 * @param text
	 *            the default value of the text field
	 * @param limit
	 *            the maximum number of chars in the field
	 * @return the new text field
	 */
	protected Text newTextField(Composite parent, String text, int limit) {
		Text res = new Text(parent, SWT.BORDER | SWT.SINGLE);
		res.setText(text);
		res.setTextLimit(limit);
		return res;
	}

	/**
	 * Creates a new editable text field. The default listener <code>TextFieldListener</code> is associated
	 * with.
	 * 
	 * @param parent
	 *            the parent group
	 * @param text
	 *            the default value of the text field
	 * @param limit
	 *            the maximum number of chars in the field
	 * @param key
	 *            the string key associated
	 * @return the new text field
	 */
	protected Text newTextField(Composite parent, String text, int limit, String key) {
		return newTextField(parent, text, limit, key, fTextFieldListener);
	}

	/**
	 * Creates a new editable text field. A listener is associated with.
	 * 
	 * @param parent
	 *            the parent group
	 * @param text
	 *            the default value of the text field
	 * @param limit
	 *            the maximum number of chars in the field
	 * @param key
	 *            the string key associated
	 * @param sl
	 *            the selection listener associated with
	 * @return the new text field
	 */
	protected Text newTextField(Composite parent, String text, int limit, String key, ModifyListener sl) {
		Text res = newTextField(parent, text, limit);
		res.addModifyListener(sl);
		textFields.put(res, key);
		return res;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
	 */
	@Override
	protected void performDefaults() {
		super.performDefaults();
		initializeFieldsToDefaultValues();

		if (colorListModel != null) {
			for (int i = 0; i < colorListModel.length; ++i) {
				PreferenceConverter.setValue(fPreferenceeStore, colorListModel[i][1], PreferenceConverter
						.getDefaultColor(fPreferenceeStore, colorListModel[i][1]));
			}
			handleColorListSelection();
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performOk()
	 */
	@SuppressWarnings("deprecation")
	@Override
	public boolean performOk() {
		fPreferenceeStore.propagate();
		AtlUIPlugin.getDefault().savePluginPreferences();
		return super.performOk();
	}

	/**
	 * Creates a tab of one horizontal spans.
	 * 
	 * @param parent
	 *            the parent in which the tab should be created
	 */
	protected void tabForward(Composite parent) {
		Label vfiller = new Label(parent, SWT.LEFT);

		GridData gridData = new GridData();
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.BEGINNING;
		gridData.grabExcessHorizontalSpace = false;
		gridData.verticalAlignment = GridData.CENTER;
		gridData.grabExcessVerticalSpace = false;

		vfiller.setLayoutData(gridData);
	}

}
