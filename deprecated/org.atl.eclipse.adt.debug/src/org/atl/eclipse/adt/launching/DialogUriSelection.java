/*
 * Created on 24 nov. 2004
 */
package org.atl.eclipse.adt.launching;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
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
 * @author allilaire
 */
public class DialogUriSelection extends SelectionStatusDialog {

	private List listUri;

	private String uri = "";

	/**
	 * @param parent
	 */
	public DialogUriSelection(Shell parent) {
		super(parent);
		setStatusLineAboveButtons(true);
		setShellStyle(SWT.CLOSE | SWT.APPLICATION_MODAL | SWT.DIALOG_TRIM | SWT.RESIZE);
	}

	/**
	 * @see org.eclipse.ui.dialogs.SelectionStatusDialog#computeResult()
	 */
	protected void computeResult() {

	}

	/**
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createDialogArea(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = layout.marginWidth = 8;
		layout.numColumns = 1;

		layout.makeColumnsEqualWidth = false;
		container.setLayout(layout);
		GridData gd = new GridData(GridData.FILL_BOTH);
		container.setLayoutData(gd);

		new Label(container, SWT.NULL).setText("Model Handler: ");
		listUri = new List(container, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
		
		for (Iterator it = ((Map)EPackage.Registry.INSTANCE).keySet().iterator(); it.hasNext();)
			listUri.add((it.next()).toString());
		listUri.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
				
		applyDialogFont(container);
		return container;
	}

	/**
	 * @see org.eclipse.ui.dialogs.SelectionStatusDialog#okPressed()
	 */
	protected void okPressed() {
		if (listUri.getSelectionCount() == 1)
			uri = listUri.getSelection()[0];
		super.okPressed();
	}

	public String getUriSelected() {
		return uri;
	}

}