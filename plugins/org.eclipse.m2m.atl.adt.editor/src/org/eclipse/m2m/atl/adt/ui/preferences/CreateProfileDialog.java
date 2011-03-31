/*******************************************************************************
 * Copyright (c) 2000, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Obeo - code cleanup and tweaking for use within ATL
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.preferences;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.internal.ui.actions.StatusInfo;

import org.eclipse.jface.dialogs.StatusDialog;
import org.eclipse.m2m.atl.adt.ui.preferences.ProfileManager.CustomProfile;
import org.eclipse.m2m.atl.adt.ui.preferences.ProfileManager.Profile;

/**
 * The dialog to create a new profile.
 */
@SuppressWarnings("restriction")
public class CreateProfileDialog extends StatusDialog {

	private Text fNameText;
	private Combo fProfileCombo;

	private final static StatusInfo fOk = new StatusInfo();
	private final static StatusInfo fEmpty = new StatusInfo(IStatus.ERROR, "The profile name is empty");//FormatterMessages.CreateProfileDialog_status_message_profile_name_is_empty); //$NON-NLS-1$
	private final static StatusInfo fDuplicate = new StatusInfo(IStatus.ERROR, "A profile with this name already exists");//FormatterMessages.CreateProfileDialog_status_message_profile_with_this_name_already_exists); //$NON-NLS-1$

	private final ProfileManager fProfileManager;
	private final List<Profile> fSortedProfiles;
	private final String [] fSortedNames;

	private CustomProfile fCreatedProfile;

	public CreateProfileDialog(Shell parentShell, ProfileManager profileManager) {
		super(parentShell);
		fProfileManager = profileManager;
		fSortedProfiles = fProfileManager.getSortedProfiles();
		fSortedNames = fProfileManager.getSortedDisplayNames();
	}

	public void create() {
		super.create();
		// TODO export text
		setTitle("Create a new profile"); //$NON-NLS-1$
		//FormatterMessages.CreateProfileDialog_dialog_title);
	}

	public Control createDialogArea(Composite parent) {

		final int numColumns = 2;

		final Composite composite = (Composite) super.createDialogArea(parent);
		((GridLayout) composite.getLayout()).numColumns = numColumns;
		
		// Create "Profile name:" label
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = numColumns;
		gd.widthHint = convertWidthInCharsToPixels(60);
		final Label nameLabel = new Label(composite, SWT.WRAP);
		nameLabel.setText("Name of the profile:");//FormatterMessages.CreateProfileDialog_profile_name_label_text); //$NON-NLS-1$
		nameLabel.setLayoutData(gd);

		// Create text field to enter name
		gd = new GridData( GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = numColumns;
		fNameText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		fNameText.setLayoutData(gd);
		fNameText.addModifyListener( new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				doValidation();
			}
		});

		// Create "Initialize settings ..." label
		gd = new GridData();
		gd.horizontalSpan = numColumns;
		Label profileLabel = new Label(composite, SWT.WRAP);
		profileLabel.setText("Choose a base profile (for initialize settings):");//FormatterMessages.CreateProfileDialog_base_profile_label_text); //$NON-NLS-1$
		profileLabel.setLayoutData(gd);

		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = numColumns;
		fProfileCombo = new Combo(composite, SWT.DROP_DOWN | SWT.READ_ONLY);
		fProfileCombo.setLayoutData(gd);


		fProfileCombo.setItems(fSortedNames);
		fProfileCombo.setText(fProfileManager.getDefaultProfile().getName());
		updateStatus(fEmpty);

		applyDialogFont(composite);

		fNameText.setFocus();

		return composite;
	}


	/**
	 * Validate the current settings
	 */
	protected void doValidation() {
		final String name = fNameText.getText().trim();

		if (fProfileManager.containsName(name)) {
			updateStatus(fDuplicate);
			return;
		}
		if (name.length() == 0) {
			updateStatus(fEmpty);
			return;
		}
		updateStatus(fOk);
	}


	protected void okPressed() {
		if (!getStatus().isOK())
			return;

		final Map<String, String> baseSettings = new HashMap<String, String>(((Profile)fSortedProfiles.get(fProfileCombo.getSelectionIndex())).getSettings());
		final String profileName = fNameText.getText();

		fCreatedProfile = new CustomProfile(profileName, baseSettings);
		fProfileManager.addProfile(fCreatedProfile);
		super.okPressed();
	}

}
