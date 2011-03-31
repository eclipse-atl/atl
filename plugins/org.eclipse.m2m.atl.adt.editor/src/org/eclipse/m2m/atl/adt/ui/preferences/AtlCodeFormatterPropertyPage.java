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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.m2m.atl.adt.ui.AtlPreferenceConstants;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.editor.formatter.AtlCodeFormatterPreferences;
import org.eclipse.m2m.atl.adt.ui.preferences.ProfileManager.BuiltInProfile;
import org.eclipse.m2m.atl.adt.ui.preferences.ProfileManager.Profile;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osgi.service.prefs.BackingStoreException;

/**
 * The ATL formatter property page.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlCodeFormatterPropertyPage extends AbstractPropertyAndPreferencePage implements IWorkbenchPreferencePage, Observer, SelectionListener {

	private class StoreUpdater implements Observer {

		public StoreUpdater() {
			manager.addObserver(this);
		}

		public void update(Observable o, Object arg) {
			try {
				// fPreferenceListenerEnabled = false;
				final int value = ((Integer)arg).intValue();
				switch (value) {
					case ProfileManager.PROFILE_DELETED_EVENT:
					case ProfileManager.PROFILE_RENAMED_EVENT:
					case ProfileManager.PROFILE_CREATED_EVENT:
					case ProfileManager.SETTINGS_CHANGED_EVENT:
						try {
							fProfileStore.writeProfiles(manager.getSortedProfiles(), fInstanceScope);
							manager.commitChanges(fCurrContext);
							if (!fCurrContext.equals(fInstanceScope)) {
								try {
									fCurrContext.getNode(AtlUIPlugin.getPluginId()).flush();
								} catch (BackingStoreException e) {
									//
								}
							}
						} catch (CoreException x) {
							//
						}
						break;
					case ProfileManager.SELECTION_CHANGED_EVENT:
						manager.commitChanges(fCurrContext);
						if (!fCurrContext.equals(fInstanceScope)) {
							try {
								fCurrContext.getNode(AtlUIPlugin.getPluginId()).flush();
							} catch (BackingStoreException e) {
								//
							}
						}
						break;
				}
			} finally {
				// fPreferenceListenerEnabled = true;
			}
		}
	}

	private class PropertiesTableListener implements Listener {

		private List<TableColumn> editableColumns;

		private TableEditor editor;

		public PropertiesTableListener(TableEditor editor, TableColumn... editableColumns) {
			this.editableColumns = new ArrayList<TableColumn>();
			for (TableColumn col : editableColumns)
				this.editableColumns.add(col);
			this.editor = editor;
		}

		public boolean isEditableColumn(Table table, int i) {
			for (TableColumn col : editableColumns) {
				if (table.getColumn(i).equals(col))
					return true;
			}
			return false;
		}

		public void handleEvent(Event event) {
			if (activeProfile instanceof BuiltInProfile)
				return;
			Table table = (Table)event.widget;
			Rectangle clientArea = table.getClientArea();
			Point pt = new Point(event.x, event.y);
			int index = table.getTopIndex();
			while (index < table.getItemCount()) {
				boolean visible = false;
				final TableItem item = table.getItem(index);
				for (int i = 0; i < table.getColumnCount(); i++) {
					Rectangle rect = item.getBounds(i);
					if (rect.contains(pt)) {
						if (!isEditableColumn(table, i))
							return;
						table.setSelection(index);
						String text = item.getText(i);
						if (!text.equals("true") && !text.equals("false")) //$NON-NLS-1$ //$NON-NLS-2$
							createTextFieldAt(i, table, item);
						else
							createBooleanListAt(i, table, item);
						return;
					}
					if (!visible && rect.intersects(clientArea)) {
						visible = true;
					}
				}
				if (!visible)
					return;
				index++;
			}
		}

		private void createBooleanListAt(final int i, Table table, final TableItem item) {
			final Combo booleanList = new Combo(table, SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
			booleanList.add("true"); //$NON-NLS-1$
			booleanList.add("false"); //$NON-NLS-1$
			booleanList.setData(item);
			Listener listListener = new Listener() {
				public void handleEvent(final Event e) {
					String value = booleanList.getText();
					switch (e.type) {
						case SWT.FocusOut:
							item.setText(i, value);
							booleanList.dispose();
							preview.updateEditor();
							break;
						case SWT.Traverse:
							switch (e.detail) {
								case SWT.TRAVERSE_RETURN:
									item.setText(i, value);
									preview.updateEditor();
								case SWT.TRAVERSE_ESCAPE:
									e.doit = false;
									booleanList.dispose();
							}
							break;
					}
				}
			};
			booleanList.addListener(SWT.FocusOut, listListener);
			booleanList.addListener(SWT.Traverse, listListener);
			booleanList.addSelectionListener(fPropertyTableListener2);
			editor.setEditor(booleanList, item, i);
			int selection = 0;
			if (item.getText(i).equals("false")) //$NON-NLS-1$
				selection = 1;
			booleanList.select(selection);
			booleanList.setFocus();
		}

		private void createTextFieldAt(final int i, Table table, final TableItem item) {
			final Text textField = new Text(table, SWT.NONE);
			textField.addListener(SWT.Verify, new Listener() {
				public void handleEvent(Event e) {
					String string = e.text;
					char[] chars = new char[string.length()];
					string.getChars(0, chars.length, chars, 0);
					for (int i = 0; i < chars.length; i++) {
						if (!('0' <= chars[i] && chars[i] <= '9') && chars[i] != '-') {
							e.doit = false;
							return;
						}
					}
				}
			});
			textField.setData(item);
			Listener textListener = new Listener() {
				public void handleEvent(final Event e) {
					switch (e.type) {
						case SWT.FocusOut:
							item.setText(i, textField.getText());
							textField.dispose();
							preview.updateEditor();
							break;
						case SWT.Traverse:
							switch (e.detail) {
								case SWT.TRAVERSE_RETURN:
									item.setText(i, textField.getText());
									preview.updateEditor();
								case SWT.TRAVERSE_ESCAPE:
									textField.dispose();
									e.doit = false;
							}
							break;
					}
				}
			};
			textField.addListener(SWT.FocusOut, textListener);
			textField.addListener(SWT.Traverse, textListener);
			textField.addModifyListener(fPropertyTableListener);
			editor.setEditor(textField, item, i);
			textField.setText(item.getText(i));
			textField.selectAll();
			textField.setFocus();
		}

	}

	private Profile activeProfile;

	private AtlCodeFormatterProfilesTabPage profilesTabPage;

	private AtlCodeFormatterPropertiesTabPage propertiesTabPage;

	private ProfileManager manager;

	private ModifyListener fPropertyTableListener;

	private SelectionListener fPropertyTableListener2;

	private TabFolder fTabFolder;

	private final List<IModifyDialogTabPage> fTabPages;

	public static final String PREVIEW = "-- @nsURI MM1 = http://www.my.site/path/to/my/MM1\n" //$NON-NLS-1$
			+ "-- @path MM2 = /MyProject/MM2.ecore\n" //$NON-NLS-1$
			+ "\n" //$NON-NLS-1$
			+ "module MyModule;\n" //$NON-NLS-1$
			+ "\n" //$NON-NLS-1$
			+ "create OUT: MM1 from IN: MM2;\n" //$NON-NLS-1$
			+ "\n" //$NON-NLS-1$
			+ "--- This is a special helper comment\n" //$NON-NLS-1$
			+ "helper def: simpleHelper: String =\n" //$NON-NLS-1$
			+ "let letVar : String = 'A first let variable' in\n" //$NON-NLS-1$
			+ "let letVar2 : String = 'Another let variable' in\n" //$NON-NLS-1$
			+ "	if true then\n" //$NON-NLS-1$
			+ "			letVar\n" //$NON-NLS-1$
			+ "		else\n" //$NON-NLS-1$
			+ "			letVar2\n" //$NON-NLS-1$
			+ "		endif\n" //$NON-NLS-1$
			+ "	and\n" //$NON-NLS-1$
			+ "	true;\n" //$NON-NLS-1$
			+ "\n" //$NON-NLS-1$
			//+ "--[NOWRAP] This is a comment that is not being wrapped even if it is longer than the maximum authorized line length\n" //$NON-NLS-1$
			+ "helper def: simpleParametersHelper(t1: String, t2: Integer, t3: Integer):\n" //$NON-NLS-1$
			+ "		Sequence(TupleType(a: Integer, b: String)) =\n" //$NON-NLS-1$
			+ "	t1 <= 'This is a string'\n" //$NON-NLS-1$
			+ "	and\n" //$NON-NLS-1$
			+ "	t2 = 5 / 1-- A comment\n" //$NON-NLS-1$
			+ "	; -- Another comment\n" //$NON-NLS-1$
			+ "\n" //$NON-NLS-1$
			+ "helper context String def: simpleContextHelper(t1: String, t2: Integer): OclAny =\n" //$NON-NLS-1$
			+ "	t1 = 't1'\n" //$NON-NLS-1$
			+ "	and\n" //$NON-NLS-1$
			+ "	t2 = 5 + 1;\n" //$NON-NLS-1$
			+ "\n" //$NON-NLS-1$
			+ "-- This is a normal comment\n" //$NON-NLS-1$
			+ "--- This is a special rule comment\n" //$NON-NLS-1$
			+ "rule MyRule {\n" //$NON-NLS-1$
			+ "	from\n" //$NON-NLS-1$
			+ "		input2: MM1!MyClass in IN (\n" //$NON-NLS-1$
			+ "			true\n" //$NON-NLS-1$
			+ "		)\n" //$NON-NLS-1$
			+ "	to\n" //$NON-NLS-1$
			+ "		output: MM2!MyClass2 (\n" //$NON-NLS-1$
			+ "			name <- input.name -> toString(),\n" //$NON-NLS-1$
			+ "			abstract <- false\n" //$NON-NLS-1$
			+ "		),\n" //$NON-NLS-1$
			+ "		output2: MM2!MyClass2 (\n" //$NON-NLS-1$
			+ "			name <- 'Test'\n" //$NON-NLS-1$
			+ "		)\n" //$NON-NLS-1$
			+ "	do {\n" //$NON-NLS-1$
			+ "		\n" //$NON-NLS-1$
			+ "	}\n" //$NON-NLS-1$
			+ "}\n"; //$NON-NLS-1$

	/*
	 * private boolean fPreferenceListenerEnabled; private IPreferenceChangeListener fPreferenceListener;
	 */
	public static final String PROFILES_KEY = AtlUIPlugin.getPluginId() + ".preferences.formatter.profiles"; //$NON-NLS-1$

	public static final String CURRENT_PROFILE_KEY = AtlUIPlugin.getPluginId()
			+ ".preferences.formatter.current_profile"; //$NON-NLS-1$

	public static final String LAST_TAB_FOCUS = AtlUIPlugin.getPluginId()
			+ ".preferences.formatter.last_tab_focus"; //$NON-NLS-1$

	public static final String SHOW_INVISIBLE_PREFERENCE_KEY = AtlUIPlugin.getPluginId()
			+ ".preferences.formatter.show_invisible"; //$NON-NLS-1$

	public static final String PROJECT_SPECIFIC_SETTINGS_ENABLED = AtlUIPlugin.getPluginId()
			+ ".preferences.formatter.project_specific_settings_enabled"; //$NON-NLS-1$

	public static final String DIALOG_STORE_LAST_LOAD_PATH = AtlUIPlugin.getPluginId()
			+ ".preferences.formatter.lastloadpath"; //$NON-NLS-1$

	public static final String DIALOG_STORE_LAST_SAVE_PATH = AtlUIPlugin.getPluginId()
			+ ".preferences.formatter.lastsavepath"; //$NON-NLS-1$

	private ProfileStore fProfileStore;

	private IScopeContext fCurrContext;

	private IScopeContext fInstanceScope;

	private IProject fProject;

	private final IDialogSettings fDialogSettings;

	public AtlCodeFormatterPropertyPage() {
		super(AtlPreferencesMessages.getString("CodeFormatterPreferencePage.description")); //$NON-NLS-1$
		fTabPages = new ArrayList<IModifyDialogTabPage>();
		fDialogSettings = AtlUIPlugin.getDefault().getDialogSettings();

		properties = new String[][] {
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.linesBetween"), AtlPreferenceConstants.CODEFORMATTER_LINES_BETWEEN, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.linesAfterModule"), AtlPreferenceConstants.CODEFORMATTER_LINES_AFTER_MODULE, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.linesAfterCreateFrom"), AtlPreferenceConstants.CODEFORMATTER_LINES_AFTER_CREATE_FROM, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.linesAfterSpecialTags"), AtlPreferenceConstants.CODEFORMATTER_LINES_AFTER_SPECIAL_TAGS, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.lineMaxLength"), AtlPreferenceConstants.CODEFORMATTER_LINE_MAX_LENGTH, "5"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.spacesInsideBraces"), AtlPreferenceConstants.CODEFORMATTER_SPACES_INSIDE_BRACES, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.spacesOutsideBraces"), AtlPreferenceConstants.CODEFORMATTER_SPACES_OUTSIDE_BRACES, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.spacesBeforeArrows"), AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_ARROWS, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.spacesAfterArrows"), AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_ARROWS, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.spacesBeforeSemi"), AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_SEMI, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.spacesAfterSemi"), AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_SEMI, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.spacesBeforeComa"), AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_COMA, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.spacesAfterComa"), AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_COMA, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.spacesBeforeColon"), AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_COLON, "5"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.spacesAfterColon"), AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_COLON, "5"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.spacesBeforePoint"), AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_POINT, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.spacesAfterPoint"), AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_POINT, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.spacesBeforeOperator"), AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_OPERATOR, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.spacesAfterOperator"), AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_OPERATOR, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.spacesBeforeEqual"), AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_EQUAL, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.spacesAfterEqual"), AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_EQUAL, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.spacesBeforePipe"), AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_PIPE, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.spacesAfterPipe"), AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_PIPE, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages
								.getString("CodeFormatterPreferencePage.spacesBeforeExclamation"), AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_EXCLAMATION, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages
								.getString("CodeFormatterPreferencePage.spacesAfterExclamation"), AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_EXCLAMATION, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.spacesBeforeRuleBrace"), AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_RULE_BRACE, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages
								.getString("CodeFormatterPreferencePage.spacesBeforeEndingSemi"), AtlPreferenceConstants.CODEFORMATTER_SPACES_BEFORE_ENDING_SEMI, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.cutAfterPoint"), AtlPreferenceConstants.CODEFORMATTER_CUT_AFTER_POINT, "5"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages.getString("CodeFormatterPreferencePage.spacesAfterComment"), AtlPreferenceConstants.CODEFORMATTER_SPACES_AFTER_COMMENT, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages
								.getString("CodeFormatterPreferencePage.spacesOutsideCollectionBrace"), AtlPreferenceConstants.CODEFORMATTER_SPACES_OUTSIDE_COLLECTION_BRACE, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
				{
						AtlPreferencesMessages
								.getString("CodeFormatterPreferencePage.spacesInsideCollectionBrace"), AtlPreferenceConstants.CODEFORMATTER_SPACES_INSIDE_COLLECTION_BRACE, "3"}, //$NON-NLS-1$ //$NON-NLS-2$
		};
	}

	@Override
	protected Control createContents(Composite parent) {
		PreferencesAccess access = PreferencesAccess.getOriginalPreferences();
		fInstanceScope = access.getInstanceScope();
		boolean isProjectSpecific = false;
		if (fProject != null) {
			fCurrContext = access.getProjectScope(fProject);
			isProjectSpecific = true;
		} else {
			fCurrContext = fInstanceScope;
		}

		initializeSettings();

		fProfileStore = new ProfileStore(PROFILES_KEY);
		manager = AtlCodeFormatterProfileManager
				.getCurrentProfileManager(fCurrContext, access, fProfileStore);
		activeProfile = manager.getSelected();
		fillPreferenceeStore(activeProfile.getSettings());
		new StoreUpdater();
		Composite composite = newComposite(parent, 1);
		Composite nameComposite = new Composite(composite, SWT.NONE);
		nameComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		nameComposite.setLayout(new GridLayout(3, false));
		fTabFolder = new TabFolder(composite, SWT.NONE);
		fTabFolder.setFont(composite.getFont());
		fTabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		fTabFolder.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				final TabItem tabItem = (TabItem)e.item;
				final ModifyDialogTabPage page = (ModifyDialogTabPage)tabItem.getData();
				if (page != null) {
					updateTab(page);
				}
				if (fTabPages.indexOf(page) != -1)
					fDialogSettings.put(LAST_TAB_FOCUS, fTabPages.indexOf(page));
				// page.makeVisible();
			}
		});
		int lastTab = fDialogSettings.getInt(LAST_TAB_FOCUS);
		Map<String, String> options = activeProfile.getSettings();// AtlCodeFormatterPreferences.getOptions(fPreferenceeStore);
		profilesTabPage = new AtlCodeFormatterProfilesTabPage(manager, fProfileStore, isProjectSpecific);
		addTabPage("Profiles", profilesTabPage); //$NON-NLS-1$
		newProfilesList(profilesTabPage.getPreview());
		if (profilesTabPage.getfEnableProjectSpecificSettings() != null)
			profilesTabPage.getfEnableProjectSpecificSettings().addSelectionListener(this);
		updateTab(profilesTabPage);
		manager.addObserver(this);
		manager.addObserver(profilesTabPage.getPreview());
		propertiesTabPage = new AtlCodeFormatterPropertiesTabPage(options);
		addTabPage("Edition", propertiesTabPage); //$NON-NLS-1$
		newPropertiesTable(propertiesTabPage.getPreview(), propertiesTabPage.getEditableColumns());
		updateTab(propertiesTabPage);
		manager.addObserver(propertiesTabPage.getPreview());

		fTabFolder.setSelection(lastTab);
		applyDialogFont(composite);
		return composite;
	}

	protected void initializeSettings() {
		if (fDialogSettings.get(LAST_TAB_FOCUS) == null) {
			fDialogSettings.put(LAST_TAB_FOCUS, 0);
		}
		if (fDialogSettings.get(SHOW_INVISIBLE_PREFERENCE_KEY) == null) {
			fDialogSettings.put(SHOW_INVISIBLE_PREFERENCE_KEY, false);
		}
	}

	protected void updateTab(ModifyDialogTabPage page) {
		preview = page.getPreview();
		preview.setWorkingValues(AtlCodeFormatterPreferences.getOptions(fPreferenceeStore));
		boolean enabled = isProjectSpecificSettingsEnabled() || (fCurrContext.equals(fInstanceScope));
		page.updateTab(enabled);
	}

	protected final void addTabPage(String title, IModifyDialogTabPage tabPage) {
		final TabItem tabItem = new TabItem(fTabFolder, SWT.NONE);
		// applyDialogFont(tabItem.getControl());
		tabItem.setText(title);
		tabItem.setData(tabPage);
		tabItem.setControl(tabPage.createContents(fTabFolder));
		fTabPages.add(tabPage);
	}

	protected void newPropertiesTable(AtlPreview atlPreview, TableColumn... editableColumns) {
		preview = atlPreview;
		updatePropertiesTable();
		TableEditor tableEditor = new TableEditor(propertiesTabPage.getPreferencesTable());
		tableEditor.horizontalAlignment = SWT.LEFT;
		tableEditor.grabHorizontal = true;
		propertiesTabPage.getPreferencesTable().addListener(SWT.MouseDown,
				new PropertiesTableListener(tableEditor, editableColumns));
		fPropertyTableListener = new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text text = (Text)e.widget;
				TableItem item = (TableItem)text.getData();
				Map<String, String> workingValues = preview.getWorkingValues();
				String value = text.getText();
				String key = tableProperties.get(item);
				workingValues.put(key, value);
				fPreferenceeStore.setValue(key, value);
			}
		};
		fPropertyTableListener2 = new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				Combo list = (Combo)e.widget;
				TableItem item = (TableItem)list.getData();
				Map<String, String> workingValues = preview.getWorkingValues();
				String value = list.getText();
				String key = tableProperties.get(item);
				workingValues.put(key, value);
				fPreferenceeStore.setValue(key, value);
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};
	}

	protected void newProfilesList(AtlPreview atlPreview) {
		preview = atlPreview;
		SelectionListener profileChangedListener = new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				org.eclipse.swt.widgets.List list = (org.eclipse.swt.widgets.List)e.widget;
				setSelectedProfile(list);
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};
		updateProfilesList();
		profilesTabPage.getProfilesList().addSelectionListener(profileChangedListener);
	}

	public void setSelectedProfile(org.eclipse.swt.widgets.List list) {
		String selectionText = list.getItem(list.getSelectionIndex());
		Profile selectedProfile = (Profile)list.getData(selectionText);
		activeProfile = selectedProfile;
		manager.setSelected(activeProfile);
		preview.setWorkingValues(activeProfile.getSettings());
		for (String key : activeProfile.getSettings().keySet()) {
			String value = activeProfile.getSettings().get(key);
			fPreferenceeStore.setValue(key, value);
		}
		preview.updateEditor();
	}

	public void updateProfilesList() {
		profilesTabPage.getProfilesList().removeAll();
		int i = 0;
		for (Profile profile : manager.getSortedProfiles()) {
			profilesTabPage.getProfilesList().add(profile.getName());
			profilesTabPage.getProfilesList().setData(profile.getName(), profile);
			if (profile == manager.getSelected())
				profilesTabPage.getProfilesList().setSelection(i);
			i++;
		}
	}

	public void updatePropertiesTable() {
		Map<String, String> workingValues = manager.getSelected().getSettings();
		Map<String, String> defaultSettings = AtlCodeFormatterPreferences.getDefaultOptions();
		propertiesTabPage.getPreferencesTable().removeAll();
		tableProperties.clear();
		for (int i = 0; i < properties.length; ++i) {
			TableItem item = new TableItem(propertiesTabPage.getPreferencesTable(), SWT.NONE);
			String key = properties[i][1];
			tableProperties.put(item, key);
			String value = workingValues.get(key);
			if (value == null) {
				value = defaultSettings.get(key);
				fPreferenceeStore.setToDefault(key);
			}
			if (value.trim().equals("")) //$NON-NLS-1$
				value = "0"; //$NON-NLS-1$
			item.setText(new String[] {properties[i][0], value});
		}
		for (TableColumn column : propertiesTabPage.getPreferencesTable().getColumns()) {
			column.pack();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
	 */
	@Override
	protected void performDefaults() {
		if (isProjectSpecificSettingsEnabled() || fCurrContext.equals(fInstanceScope))
			super.performDefaults();
		updateTab(profilesTabPage);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.preferences.AbstractPropertyAndPreferencePage#performOk()
	 */
	public boolean performOk() {
		activeProfile.setSettings(AtlCodeFormatterPreferences.getOptions(fPreferenceeStore));
		if (!isProjectSpecificSettingsEnabled() && !fCurrContext.equals(fInstanceScope)) {
			PreferencesAccess access = PreferencesAccess.getOriginalPreferences();
			manager = AtlCodeFormatterProfileManager.getCurrentProfileManager(fInstanceScope, access,
					fProfileStore);
			fillPreferenceeStore(manager.getSelected().getSettings());
		}
		return super.performOk();
	}

	public void fillPreferenceeStore(Map<String, String> settings) {
		for (String key : settings.keySet())
			fPreferenceeStore.setValue(key, settings.get(key));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable o, Object arg) {
		activeProfile = manager.getSelected();
		updateProfilesList();
		updatePropertiesTable();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.dialogs.PropertyPage#setElement(org.eclipse.core.runtime.IAdaptable)
	 */
	public void setElement(IAdaptable element) {
		fProject = (IProject)element.getAdapter(IResource.class);
	}

	public void widgetSelected(SelectionEvent e) {
		IEclipsePreferences uiPreferences = fCurrContext.getNode(AtlUIPlugin.getPluginId());
		uiPreferences.put(PROJECT_SPECIFIC_SETTINGS_ENABLED, "" + ((Button)e.widget).getSelection()); //$NON-NLS-1$
		try {
			uiPreferences.flush();
		} catch (BackingStoreException e1) {
			//
		}
	}

	public void widgetDefaultSelected(SelectionEvent e) {
	}

	public boolean isProjectSpecificSettingsEnabled() {
		return fCurrContext.getNode(AtlUIPlugin.getPluginId()).getBoolean(PROJECT_SPECIFIC_SETTINGS_ENABLED,
				false);
	}

}
