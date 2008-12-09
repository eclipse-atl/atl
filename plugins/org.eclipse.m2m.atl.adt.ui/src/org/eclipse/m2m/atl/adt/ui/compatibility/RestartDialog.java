/*******************************************************************************
 * Copyright (c) 2000, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Obeo - adaptation for Atl compatibility menu
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.compatibility;

import org.eclipse.core.runtime.IProduct;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.m2m.atl.adt.ui.Messages;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.update.operations.OperationsManager;

/**
 * A dialog which prompts the user to restart after an update operation and provides Yes, No, Continue
 * buttons.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class RestartDialog extends MessageDialog {
	private static final int CONTINUE = 2;

	private static final String[] YES_NO = new String[] {IDialogConstants.YES_LABEL,
			IDialogConstants.NO_LABEL,};

	private static final String[] YES_NO_APPLY = new String[] {IDialogConstants.YES_LABEL,
			IDialogConstants.NO_LABEL, Messages.getString("RestartDialog.0"),}; //$NON-NLS-1$

	private int buttonId;

	/**
	 * Creates a new dialog.
	 * 
	 * @see MessageDialog#MessageDialog(org.eclipse.swt.widgets.Shell, java.lang.String,
	 *      org.eclipse.swt.graphics.Image, java.lang.String, int, java.lang.String[], int)
	 *      
	 * @param parent the parent shell
	 * @param title the dialog title
	 * @param message the dialog message
	 * @param restartNeeded true if need to restart eclipse
	 */
	public RestartDialog(Shell parent, String title, String message, boolean restartNeeded) {
		super(parent, title, null, // accept the default window icon
				message, QUESTION, restartNeeded ? YES_NO : YES_NO_APPLY, 0); // yes is the default
	}

	/**
	 * Convenience method to open the Yes/No/Continue question dialog.
	 * 
	 * @param parent
	 *            the parent shell of the dialog, or <code>null</code> if none
	 * @param restartIsReallyNeeded
	 *            when false, the changes are applied to the current config
	 * @return <code>true</code> if the user presses YES <code>false</code> otherwise
	 */
	public static boolean openQuestion(Shell parent, boolean restartIsReallyNeeded) {
		String title = Messages.getString("RestartDialog.1"); //$NON-NLS-1$
		IProduct product = Platform.getProduct();
		String productName = product != null && product.getName() != null ? product.getName() : "application"; //$NON-NLS-1$
		String message = NLS
				.bind(
						restartIsReallyNeeded ? Messages.getString("RestartDialog.3") : Messages.getString("RestartDialog.4"), productName); //$NON-NLS-1$ //$NON-NLS-2$
		RestartDialog dialog = new RestartDialog(parent, title, message, restartIsReallyNeeded);
		int button = dialog.open();
		if (button == 2) {
			OperationsManager.applyChangesNow();
		}
		return button == 0; // Yes
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.dialogs.MessageDialog#buttonPressed(int)
	 */
	protected void buttonPressed(int id) {
		if (id == 2) {
			buttonId = CONTINUE;
		}

		super.buttonPressed(id);
	}

	/**
	 * Returns the user's selection, <code>null</code> if the user hasn't chosen yet.
	 * 
	 * @return the user's selection or <code>null</code>
	 */
	public int getResult() {
		return buttonId;
	}
}
