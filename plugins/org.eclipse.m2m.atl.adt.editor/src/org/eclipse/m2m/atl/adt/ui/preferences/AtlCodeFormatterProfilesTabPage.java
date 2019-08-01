/*******************************************************************************
 * Copyright (c) 2011, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.preferences;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.preferences.ProfileManager.CustomProfile;
import org.eclipse.m2m.atl.adt.ui.preferences.ProfileManager.Profile;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.List;

/**
 * The ATL formatter profiles tab page.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlCodeFormatterProfilesTabPage extends ModifyDialogTabPage {

	class ButtonController implements Observer, SelectionListener {

		public ButtonController() {
			manager.addObserver(this);
			fRemove.addSelectionListener(this);
			fNew.addSelectionListener(this);
			fImport.addSelectionListener(this);
			fExport.addSelectionListener(this);
			fExportAll.addSelectionListener(this);
			fRename.addSelectionListener(this);
			update(manager, null);
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
		 */
		public void update(Observable o, Object arg) {
			Profile selected = ((ProfileManager)o).getSelected();
			final boolean notBuiltIn = !selected.isBuiltInProfile();
			fRemove.setEnabled(notBuiltIn);
			fExport.setEnabled(notBuiltIn);
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		public void widgetSelected(SelectionEvent e) {
			final Button button = (Button)e.widget;
			if (button == fRemove)
				deleteButtonPressed();
			else if (button == fNew)
				newButtonPressed();
			else if (button == fImport)
				importButtonPressed();
			else if(button == fExport)
				exportButtonPressed();
			else if(button == fExportAll)
				exportAllButtonPressed();
			else if(button == fRename)
				renameButtonPressed();
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		public void widgetDefaultSelected(SelectionEvent e) {
		}

		/**
		 * Exports all the profiles to a file.
		 * 
		 * @since 3.6
		 */
		private void exportAllButtonPressed() {
			final FileDialog dialog = new FileDialog(fComposite.getShell(), SWT.SAVE);
			dialog.setText("Export all profiles..."); //$NON-NLS-1$
			dialog.setFilterExtensions(new String [] {"*.xml"}); //$NON-NLS-1$
			final String lastPath = fDialogSettings.get(AtlCodeFormatterPropertyPage.DIALOG_STORE_LAST_SAVE_PATH);
			if (lastPath != null) {
				dialog.setFilterPath(lastPath);
			}
			final String path = dialog.open();
			if (path == null)
				return;

			fDialogSettings.put(AtlCodeFormatterPropertyPage.DIALOG_STORE_LAST_SAVE_PATH, dialog.getFilterPath());

			final File file = new File(path);
			if (file.exists() && !MessageDialog.openQuestion(fComposite.getShell(), "Overwrite?", "Do you want to overwrite this file?")) { //$NON-NLS-1$ //$NON-NLS-2$
				return;
			}
			String encoding = ProfileStore.ENCODING;
			final IContentType type = Platform.getContentTypeManager().getContentType("org.eclipse.core.runtime.xml"); //$NON-NLS-1$
			if (type != null)
				encoding = type.getDefaultCharset();
			final Collection<Profile> profiles = new ArrayList<Profile>();
			profiles.addAll(manager.getSortedProfiles());
			try {
				store.writeProfilesToFile(profiles, file, encoding);
			} catch (CoreException e) {
				// TODO
			}
		}

		private void exportButtonPressed() {
			final FileDialog dialog = new FileDialog(fComposite.getShell(), SWT.SAVE);
			dialog.setText("Export selected profile..."); //$NON-NLS-1$
			dialog.setFilterExtensions(new String [] {"*.xml"}); //$NON-NLS-1$
			final String lastPath = fDialogSettings.get(AtlCodeFormatterPropertyPage.DIALOG_STORE_LAST_SAVE_PATH);
			if (lastPath != null) {
				dialog.setFilterPath(lastPath);
			}
			final String path = dialog.open();
			if (path == null)
				return;

			fDialogSettings.put(AtlCodeFormatterPropertyPage.DIALOG_STORE_LAST_SAVE_PATH, dialog.getFilterPath());

			final File file = new File(path);
			if (file.exists() && !MessageDialog.openQuestion(fComposite.getShell(), "Overwrite?", "Do you want to overwrite this file?")) { //$NON-NLS-1$ //$NON-NLS-2$
				return;
			}
			String encoding = ProfileStore.ENCODING;
			final IContentType type = Platform.getContentTypeManager().getContentType("org.eclipse.core.runtime.xml"); //$NON-NLS-1$
			if (type != null)
				encoding = type.getDefaultCharset();
			final Collection<Profile> profiles = new ArrayList<Profile>();
			profiles.add(manager.getSelected());
			try {
				store.writeProfilesToFile(profiles, file, encoding);
			} catch (CoreException e) {
				// TODO
				/*final String title = FormatterMessages.CodingStyleConfigurationBlock_export_profiles_error_title;
				final String message = FormatterMessages.CodingStyleConfigurationBlock_export_profiles_error_message;
				ExceptionHandler.handle(e, fComposite.getShell(), title, message);*/
			}
		}

		private void importButtonPressed() {
			final FileDialog dialog = new FileDialog(fComposite.getShell(), SWT.OPEN);
			dialog.setText("Import profiles..."); //$NON-NLS-1$
			dialog.setFilterExtensions(new String [] {"*.xml"}); //$NON-NLS-1$
			final String lastPath = fDialogSettings.get(AtlCodeFormatterPropertyPage.DIALOG_STORE_LAST_LOAD_PATH);
			if (lastPath != null) {
				dialog.setFilterPath(lastPath);
			}
			final String path = dialog.open();
			if (path == null)
				return;
			fDialogSettings.put(AtlCodeFormatterPropertyPage.DIALOG_STORE_LAST_LOAD_PATH, dialog.getFilterPath());

			final File file = new File(path);
			Collection<Profile> profiles = null;
			try {
				profiles = store.readProfilesFromFile(file);
			} catch (CoreException e) {
				// TODO
				/*final String title = "";//FormatterMessages.CodingStyleConfigurationBlock_load_profile_error_title;
				final String message = "";//FormatterMessages.CodingStyleConfigurationBlock_load_profile_error_message;
				ExceptionHandler.handle(e, fComposite.getShell(), title, message);*/
			}
			if (profiles == null || profiles.isEmpty())
				return;
			Iterator<Profile> iter = profiles.iterator();
			while (iter.hasNext()) {
				final CustomProfile profile = (CustomProfile)iter.next();

				if (manager.containsName(profile.getName())) {
					final AlreadyExistsDialog aeDialog = new AlreadyExistsDialog(fComposite.getShell(), profile, manager);
					if (aeDialog.open() != Window.OK)
						return;
				}
				manager.addProfile(profile);
			}
		}

		private void deleteButtonPressed() {
			if (MessageDialog.openQuestion(
					fComposite.getShell(),
					"Profile deletion",//FormatterMessages.CodingStyleConfigurationBlock_delete_confirmation_title, //$NON-NLS-1$
					"Do you really want to delete " + manager.getSelected().getName() + "?")) { //$NON-NLS-1$ //$NON-NLS-2$
				manager.deleteSelected();
			}
		}

		private void newButtonPressed() {
			final CreateProfileDialog p = new CreateProfileDialog(fComposite.getShell(), manager);
			if (p.open() != Window.OK)
				return;
		}

		private void renameButtonPressed() {
			final RenameProfileDialog p = new RenameProfileDialog(fComposite.getShell(), manager.getSelected(), manager);
			if (p.open() != Window.OK)
				return;
		}

	}

	private AtlPreview fPreview;
	private List profilesList;
	private ProfileManager manager;
	private ProfileStore store;
	private final IDialogSettings fDialogSettings;
	private Button fEnableProjectSpecificSettings;
	private Button fRemove;
	private Button fNew;
	private Button fImport;
	private Button fExport;
	private Button fExportAll;
	private Button fRename;
	private Composite fComposite;
	private boolean isProjectSpecific;

	public AtlCodeFormatterProfilesTabPage(ProfileManager manager, ProfileStore store,
			boolean isProjectSpecific) {
		super();
		this.manager = manager;
		this.store = store;
		this.isProjectSpecific = isProjectSpecific;
		fDialogSettings = AtlUIPlugin.getDefault().getDialogSettings();
	}

	public AtlPreview getPreview() {
		return fPreview;
	}
	public List getProfilesList() {
		return profilesList;
	}
	public ProfileManager getManager() {
		return manager;
	}
	public Button getfEnableProjectSpecificSettings() {
		return fEnableProjectSpecificSettings;
	}

	@Override
	protected void initializePage() {
	}

	@Override
	protected void doCreatePreferences(Composite composite, int numColumns) {
		// TODO export text
		createLabel(numColumns - 1, composite, "Profiles managment:"); //$NON-NLS-1$
		fComposite = composite;

		if(isProjectSpecific) {
			fEnableProjectSpecificSettings = new Button(composite, SWT.CHECK);
			fEnableProjectSpecificSettings.setText("Enable project specific settings"); //$NON-NLS-1$
			fEnableProjectSpecificSettings.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, true, false));
			fEnableProjectSpecificSettings.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					boolean enabled = fEnableProjectSpecificSettings.getSelection();
					updateTab(enabled);
				}
			});
		}

		Composite comp = new Composite(composite, SWT.NONE);
		GridData gd3 = createGridData(numColumns, GridData.FILL_BOTH, 0);
		comp.setLayoutData(gd3);
		GridLayout FCLayout = new GridLayout(numColumns, false);
		comp.setLayout(FCLayout);
		profilesList = new List(comp, SWT.SINGLE | SWT.BORDER);
		GridData gd = createGridData(numColumns-2, GridData.FILL_BOTH, 0);
		gd.verticalSpan = 7;
		profilesList.setLayoutData(gd);
		GridData gd2 = new GridData(GridData.FILL);
		gd2.verticalAlignment = SWT.FILL;
		gd2.horizontalSpan = 2;
		gd2.verticalIndent = 0;
		gd2.widthHint = 75;
		fNew = new Button(comp, SWT.NONE);
		fNew.setText("New..."); //$NON-NLS-1$
		fNew.setLayoutData(gd2);
		fImport = new Button(comp, SWT.NONE);
		fImport.setText("Import..."); //$NON-NLS-1$
		fImport.setLayoutData(gd2);
		fExport = new Button(comp, SWT.NONE);
		fExport.setText("Export..."); //$NON-NLS-1$
		fExport.setLayoutData(gd2);
		fExportAll = new Button(comp, SWT.NONE);
		fExportAll.setText("Export all..."); //$NON-NLS-1$
		fExportAll.setLayoutData(gd2);
		fRename = new Button(comp, SWT.NONE);
		fRename.setText("Rename..."); //$NON-NLS-1$
		fRename.setLayoutData(gd2);
		fRemove = new Button(comp, SWT.NONE);
		fRemove.setText("Remove"); //$NON-NLS-1$
		fRemove.setLayoutData(gd2);
		new ButtonController();

		/*if(isProjectSpecific) {
			boolean enabled = fDialogSettings.getBoolean(AtlCodeFormatterPropertyPage.ENABLED_PROJECT_SPECIFIC_SETTINGS);
			fEnableProjectSpecificSettings.setSelection(enabled);
			profilesList.setEnabled(enabled);
			fRemove.setEnabled(enabled);
			fNew.setEnabled(enabled);
			fImport.setEnabled(enabled);
			fExport.setEnabled(enabled);
			fExportAll.setEnabled(enabled);
		}*/

	}

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
				fDialogSettings.put(AtlCodeFormatterPropertyPage.SHOW_INVISIBLE_PREFERENCE_KEY, fShowInvisibleButton.getSelection());
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

		boolean selected = fDialogSettings.getBoolean(AtlCodeFormatterPropertyPage.SHOW_INVISIBLE_PREFERENCE_KEY);
		fPreview.showInvisibleCharacters(selected);
		fShowInvisibleButton.setSelection(selected);
		return composite;
	}

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

	@Override
	protected AtlPreview doCreateAtlPreview(Composite parent) {
		AtlPreview preview = new AtlPreview(this.manager.getSelected().getSettings(), parent);
		return preview;
	}

	@Override
	public void updateTab(boolean enabled) {
		if(!profilesList.isDisposed())
			profilesList.setEnabled(enabled);
		if(isProjectSpecific)
			fEnableProjectSpecificSettings.setSelection(enabled);
		boolean isNotBuiltIn = !manager.getSelected().isBuiltInProfile();
		fRemove.setEnabled(enabled && isNotBuiltIn);
		fNew.setEnabled(enabled);
		fImport.setEnabled(enabled);
		fExport.setEnabled(enabled && isNotBuiltIn);
		fExportAll.setEnabled(enabled);
		fRename.setEnabled(enabled);

		boolean selected = fDialogSettings.getBoolean(AtlCodeFormatterPropertyPage.SHOW_INVISIBLE_PREFERENCE_KEY);
		fPreview.showInvisibleCharacters(selected);
		getShowInvisibleButton().setSelection(selected);
		fPreview.updateEditor();
	}

}
