/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.launching;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionStatusDialog;

/**
 * The uri selection dialog.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class DialogUriSelection extends SelectionStatusDialog {

	private List listUri;

	private String uri = ""; //$NON-NLS-1$

	/**
	 * Constructor.
	 * 
	 * @param parent the parent shell
	 */
	public DialogUriSelection(Shell parent) {
		super(parent);
		setStatusLineAboveButtons(true);
		setShellStyle(SWT.CLOSE | SWT.APPLICATION_MODAL | SWT.DIALOG_TRIM | SWT.RESIZE);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.dialogs.SelectionStatusDialog#computeResult()
	 */
	protected void computeResult() {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createDialogArea(Composite parent) {
		Set uris = new TreeSet();
		
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = layout.marginWidth = 8;
		layout.numColumns = 1;
		layout.makeColumnsEqualWidth = false;
		container.setLayout(layout);
		GridData gd = new GridData(GridData.FILL_BOTH);
		container.setLayoutData(gd);

		new Label(container, SWT.NULL).setText("Registered EPackages: "); //$NON-NLS-1$
		listUri = new List(container, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY | SWT.H_SCROLL | SWT.V_SCROLL);
		
		for (Iterator it = ((Map)EPackage.Registry.INSTANCE).keySet().iterator(); it.hasNext();) {
			uris.add((it.next()).toString());
		}		
		
		for (Iterator it = ASMEMFModel.getResourceSet().getPackageRegistry().keySet().iterator(); it.hasNext(); ) {
			uris.add((it.next()).toString());
		}
		
		for (Iterator it = uris.iterator(); it.hasNext();) {
			listUri.add((it.next()).toString());
		}
		
		listUri.setLayoutData(new GridData(GridData.FILL_BOTH));

		applyDialogFont(container);
		return container;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.dialogs.SelectionStatusDialog#okPressed()
	 */
	protected void okPressed() {
		if (listUri.getSelectionCount() == 1) {
			uri = listUri.getSelection()[0];
		}
		super.okPressed();
	}

	public String getUriSelected() {
		return uri;
	}

}