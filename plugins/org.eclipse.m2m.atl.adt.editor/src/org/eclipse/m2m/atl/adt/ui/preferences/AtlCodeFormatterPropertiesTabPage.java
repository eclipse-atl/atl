/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.preferences;

import java.util.Map;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

/**
 * The ATL formatter properties tab page.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlCodeFormatterPropertiesTabPage extends ModifyDialogTabPage {

	private AtlPreview fPreview;

	private Table preferencesTable;

	private TableColumn valueColumn;

	private final IDialogSettings fDialogSettings;

	public AtlCodeFormatterPropertiesTabPage(Map<String, String> workingValues) {
		super();
		this.setWorkingValues(workingValues);
		fDialogSettings = AtlUIPlugin.getDefault().getDialogSettings();
	}

	public Table getPreferencesTable() {
		return preferencesTable;
	}

	public TableColumn[] getEditableColumns() {
		return new TableColumn[] {valueColumn};
	}

	public AtlPreview getPreview() {
		return fPreview;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.preferences.ModifyDialogTabPage#initializePage()
	 */
	@Override
	protected void initializePage() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.preferences.ModifyDialogTabPage#doCreatePreferences(org.eclipse.swt.widgets.Composite,
	 *      int)
	 */
	@Override
	protected void doCreatePreferences(Composite composite, int numColumns) {
		// TODO export text
		createLabel(numColumns, composite,
				"Properties (click on a value to change it, except for built-in profiles):"); //$NON-NLS-1$
		preferencesTable = new Table(composite, SWT.BORDER);

		preferencesTable.setHeaderVisible(true);
		TableColumn propertyColumn = new TableColumn(preferencesTable, SWT.NONE);
		propertyColumn.setWidth(75);
		propertyColumn.setText("Property"); //$NON-NLS-1$
		valueColumn = new TableColumn(preferencesTable, SWT.NONE);
		valueColumn.setText("Value"); //$NON-NLS-1$
		valueColumn.setAlignment(SWT.CENTER);
		valueColumn.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				if (valueColumn.getWidth() < 50) {
					valueColumn.setWidth(50);
				}
			}
		});

		final GridData gd = createGridData(numColumns, GridData.FILL_BOTH, 0);
		gd.widthHint = 0;
		gd.heightHint = 0;
		preferencesTable.setLayoutData(gd);
		/*
		 * boolean enabled =
		 * fDialogSettings.getBoolean(AtlCodeFormatterPropertyPage.ENABLED_PROJECT_SPECIFIC_SETTINGS) ||
		 * !isProjectSpecific; preferencesTable.setEnabled(enabled);
		 */
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.adt.ui.preferences.ModifyDialogTabPage#doCreatePreviewPane(org.eclipse.swt.widgets.Composite, int)
	 */
	@Override
	protected Composite doCreatePreviewPane(Composite composite, int numColumns) {
		// TODO export text
		createLabel(numColumns - 1, composite, "Preview:"); //$NON-NLS-1$

		fShowInvisibleButton = new Button(composite, SWT.CHECK);
		fShowInvisibleButton.setText("Show invisible characters"); //$NON-NLS-1$
		fShowInvisibleButton.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, true, false));
		fShowInvisibleButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				fPreview.showInvisibleCharacters(fShowInvisibleButton.getSelection());
				fDialogSettings.put(AtlCodeFormatterPropertyPage.SHOW_INVISIBLE_PREFERENCE_KEY,
						fShowInvisibleButton.getSelection());
				doUpdatePreview();
			}
		});

		fPreview = doCreateAtlPreview(composite);
		fDefaultFocusManager.add(fPreview.getControl());

		final GridData gd = createGridData(numColumns, GridData.FILL_BOTH, 0);
		gd.widthHint = 0;
		gd.heightHint = 0;
		fPreview.getControl().setLayoutData(gd);
		fPreview.setText(AtlCodeFormatterPropertyPage.PREVIEW);

		boolean selected = fDialogSettings
				.getBoolean(AtlCodeFormatterPropertyPage.SHOW_INVISIBLE_PREFERENCE_KEY);
		fPreview.showInvisibleCharacters(selected);
		fShowInvisibleButton.setSelection(selected);
		return composite;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.adt.ui.preferences.ModifyDialogTabPage#doUpdatePreview()
	 */
	@Override
	protected void doUpdatePreview() {
		boolean showInvisible = isShowInvisible();
		fPreview.showInvisibleCharacters(showInvisible);
		fShowInvisibleButton.setSelection(showInvisible);
		fPreview.updateEditor();
	}

	private boolean isShowInvisible() {
		return fDialogSettings.getBoolean(AtlCodeFormatterPropertyPage.SHOW_INVISIBLE_PREFERENCE_KEY);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.adt.ui.preferences.ModifyDialogTabPage#doCreateAtlPreview(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected AtlPreview doCreateAtlPreview(Composite parent) {
		AtlPreview preview = new AtlPreview(fWorkingValues, parent);
		return preview;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.adt.ui.preferences.ModifyDialogTabPage#updateTab(boolean)
	 */
	@Override
	public void updateTab(boolean enabled) {
		if (!preferencesTable.isDisposed())
			preferencesTable.setEnabled(enabled);
		boolean selected = fDialogSettings
				.getBoolean(AtlCodeFormatterPropertyPage.SHOW_INVISIBLE_PREFERENCE_KEY);
		fPreview.showInvisibleCharacters(selected);
		getShowInvisibleButton().setSelection(selected);
		fPreview.updateEditor();
	}

}
