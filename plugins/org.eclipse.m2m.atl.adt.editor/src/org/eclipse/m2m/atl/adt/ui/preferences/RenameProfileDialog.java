/*******************************************************************************
 * Copyright (c) 2000, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Obeo - code cleanup and tweaking for use within ATL
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.preferences;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.internal.ui.actions.StatusInfo;

import org.eclipse.jface.dialogs.StatusDialog;
import org.eclipse.m2m.atl.adt.ui.preferences.ProfileManager.Profile;

/**
 * The dialog to create a new profile.
 */
@SuppressWarnings("restriction")
public class RenameProfileDialog extends StatusDialog {

	private Text fNameText;

	private final static StatusInfo fOk = new StatusInfo();
	private final static StatusInfo fEmpty = new StatusInfo(IStatus.ERROR, "The profile name is empty");//FormatterMessages.CreateProfileDialog_status_message_profile_name_is_empty); //$NON-NLS-1$
	private final static StatusInfo fDuplicate = new StatusInfo(IStatus.ERROR, "A profile with this name already exists");//FormatterMessages.CreateProfileDialog_status_message_profile_with_this_name_already_exists); //$NON-NLS-1$

	private final ProfileManager fProfileManager;
	private Profile fProfile;

	public RenameProfileDialog(Shell parentShell, Profile profile, ProfileManager profileManager) {
		super(parentShell);
		fProfileManager = profileManager;
		fProfile = profile;
	}

	public void create() {
		super.create();
		// TODO export text
		setTitle("Rename a profile"); //$NON-NLS-1$
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
		nameLabel.setText("New name for the profile \"" + fProfile.getName() + "\":");//FormatterMessages.CreateProfileDialog_profile_name_label_text); //$NON-NLS-1$ //$NON-NLS-2$
		nameLabel.setLayoutData(gd);

		// Create text field to enter name
		gd = new GridData( GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = numColumns;
		fNameText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		fNameText.setText(fProfile.getName());
		fNameText.setLayoutData(gd);
		fNameText.addModifyListener( new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				doValidation();
			}
		});

		updateStatus(fDuplicate);
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

		final String profileNewName = fNameText.getText();

		fProfile.rename(profileNewName, fProfileManager);
		super.okPressed();
	}

}
