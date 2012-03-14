/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.common;

import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.Messages;
import org.eclipse.m2m.atl.common.IAtlLexems;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionStatusDialog;

/**
 * An abstract selection dialog.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public abstract class AbstractAtlSelection extends SelectionStatusDialog {

	protected static final String NAMING_REGEX = "[a-zA-Z0-9]+"; //$NON-NLS-1$

	private IStatus status;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent shell
	 * @param title
	 *            the title
	 */
	public AbstractAtlSelection(Shell parent, String title) {
		super(parent);
		setTitle(title);
		setStatusLineAboveButtons(true);
		setShellStyle(SWT.CLOSE | SWT.APPLICATION_MODAL | SWT.DIALOG_TRIM | SWT.RESIZE);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.dialogs.SelectionStatusDialog#create()
	 */
	@Override
	public void create() {
		status = new Status(IStatus.OK, AtlUIPlugin.PLUGIN_ID, IStatus.OK, "", //$NON-NLS-1$
				null);
		updateStatus(status);
		super.create();
		getOkButton().setEnabled(false);
	}

	/**
	 * Displays an error.
	 * 
	 * @param message
	 *            the message
	 */
	protected void nok(String message) {
		if (Platform.isRunning()) {

			status = new Status(IStatus.ERROR, AtlUIPlugin.PLUGIN_ID, IStatus.ERROR, message, null);
			updateStatus(status);
		}
		getOkButton().setEnabled(false);

	}

	/**
	 * Updates the status to OK.
	 */
	protected void ok() {
		status = new Status(IStatus.OK, AtlUIPlugin.PLUGIN_ID, IStatus.OK, "", //$NON-NLS-1$
				null);
		updateStatus(status);
		getOkButton().setEnabled(true);
	}

	/**
	 * Displays a warning.
	 * 
	 * @param message
	 *            the warning message
	 */
	protected void warn(String message) {
		status = new Status(IStatus.WARNING, AtlUIPlugin.PLUGIN_ID, message);
		updateStatus(status);
		getOkButton().setEnabled(true);
	}

	/**
	 * Generates a default name.
	 * 
	 * @param prefix
	 *            the default prefix
	 * @param existingEntries
	 *            the existing entries
	 * @return the name
	 */
	protected String getDefaultName(final String prefix, Collection<String> existingEntries) {
		String res = prefix;
		int index = 0;
		while (existingEntries.contains(res)) {
			index++;
			res = prefix + index;
		}
		return res;
	}

	/**
	 * Checks the validity of an identifier.
	 * 
	 * @param identifier
	 *            the identifier to check
	 * @return the error message if exists, else null
	 */
	public static String checkIdentifier(String identifier) {
		String errorMessage = null;
		if (identifier == null || "".equals(identifier.trim())) { //$NON-NLS-1$
			errorMessage = Messages.getString("AbstractAtlSelection.NAMING_UNSET"); //$NON-NLS-1$
		} else if (!identifier.matches(NAMING_REGEX)) {
			errorMessage = Messages.getString("AbstractAtlSelection.NAMING_ISSUE", identifier); //$NON-NLS-1$
		} else {
			for (String s : IAtlLexems.CONSTANTS) {
				if (s.equals(identifier)) {
					errorMessage = Messages.getString("AbstractAtlSelection.NAMING_CONFLICT", s); //$NON-NLS-1$
					break;
				}
			}
			for (String s : IAtlLexems.KEYWORDS) {
				if (s.equals(identifier)) {
					errorMessage = Messages.getString("AbstractAtlSelection.NAMING_CONFLICT", s); //$NON-NLS-1$
					break;
				}
			}
			for (String s : IAtlLexems.TYPES) {
				if (s.equals(identifier)) {
					errorMessage = Messages.getString("AbstractAtlSelection.NAMING_CONFLICT", s); //$NON-NLS-1$
					break;
				}
			}
		}
		return errorMessage;
	}
}
