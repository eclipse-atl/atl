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
package org.eclipse.m2m.atl.adt.ui.outline;

import java.util.logging.Level;

import org.eclipse.m2m.atl.adt.ui.editor.AtlEditorMessages;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class RenameFrame extends Composite {

	private Button ok;

	private Button cancel;

	private Text tNewName;

	private Label lNewName;

	private Canvas canvas1;

	// private RenameAction renameAction;

	public RenameFrame(RenameAction renameAction) {
		super(new Shell(Display.getDefault()), SWT.NULL);
		// this.renameAction = renameAction;
		getShell().setLayout(new org.eclipse.swt.layout.FillLayout());
		Rectangle shellBounds = getShell().computeTrim(0, 0, 552, 319);
		getShell().setSize(shellBounds.width, shellBounds.height);
		getShell().open();
		initGUI();
	}

	/**
	 * Initializes the GUI. Auto-generated code - any changes you make will disappear.
	 */
	public void initGUI() {
		try {
			preInitGUI();

			canvas1 = new Canvas(this, SWT.NULL);
			ok = new Button(canvas1, SWT.PUSH | SWT.CENTER);
			lNewName = new Label(canvas1, SWT.NULL);
			tNewName = new Text(canvas1, SWT.NULL);
			tNewName.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
					tNewNameKeyPressed(ke);
				}
			});
			cancel = new Button(canvas1, SWT.PUSH | SWT.CENTER);
			this.setSize(new org.eclipse.swt.graphics.Point(552, 319));
			final Color newSWTAppbackground = new Color(Display.getDefault(), 128, 128, 128);
			this.setBackground(newSWTAppbackground);

			GridData canvas1LData = new GridData();
			canvas1LData.verticalAlignment = GridData.CENTER;
			canvas1LData.horizontalAlignment = GridData.BEGINNING;
			canvas1LData.widthHint = 549;
			canvas1LData.heightHint = 313;
			canvas1LData.horizontalIndent = 0;
			canvas1LData.horizontalSpan = 1;
			canvas1LData.verticalSpan = 1;
			canvas1LData.grabExcessHorizontalSpace = false;
			canvas1LData.grabExcessVerticalSpace = false;
			canvas1.setLayoutData(canvas1LData);
			canvas1.setSize(new org.eclipse.swt.graphics.Point(549, 313));

			FormData okLData = new FormData();
			okLData.height = 32;
			okLData.width = 107;
			okLData.left = new FormAttachment(439, 1000, 0);
			okLData.right = new FormAttachment(634, 1000, 0);
			okLData.top = new FormAttachment(822, 1000, 0);
			okLData.bottom = new FormAttachment(924, 1000, 0);
			ok.setLayoutData(okLData);
			ok.setText("OK"); //$NON-NLS-1$
			ok.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					okWidgetSelected(evt);
				}
			});
			ok.setSize(new org.eclipse.swt.graphics.Point(107, 32));

			FormData lNewNameLData = new FormData();
			lNewNameLData.height = 28;
			lNewNameLData.width = 111;
			lNewNameLData.left = new FormAttachment(188, 1000, 0);
			lNewNameLData.right = new FormAttachment(390, 1000, 0);
			lNewNameLData.top = new FormAttachment(423, 1000, 0);
			lNewNameLData.bottom = new FormAttachment(512, 1000, 0);
			lNewName.setLayoutData(lNewNameLData);
			lNewName.setText("New name"); //$NON-NLS-1$
			lNewName.setSize(new org.eclipse.swt.graphics.Point(111, 28));

			FormData tNewNameLData = new FormData();
			tNewNameLData.height = 24;
			tNewNameLData.width = 243;
			tNewNameLData.left = new FormAttachment(438, 1000, 0);
			tNewNameLData.right = new FormAttachment(891, 1000, 0);
			tNewNameLData.top = new FormAttachment(400, 1000, 0);
			tNewNameLData.bottom = new FormAttachment(496, 1000, 0);
			tNewName.setLayoutData(tNewNameLData);
			tNewName.setSize(new org.eclipse.swt.graphics.Point(243, 24));

			FormData button1LData = new FormData();
			button1LData.height = 32;
			button1LData.width = 107;
			button1LData.left = new FormAttachment(698, 1000, 0);
			button1LData.right = new FormAttachment(893, 1000, 0);
			button1LData.top = new FormAttachment(822, 1000, 0);
			button1LData.bottom = new FormAttachment(924, 1000, 0);
			cancel.setLayoutData(button1LData);
			cancel.setText("Cancel"); //$NON-NLS-1$
			cancel.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					cancelWidgetSelected(evt);
				}
			});
			cancel.setSize(new org.eclipse.swt.graphics.Point(107, 32));
			FormLayout canvas1Layout = new FormLayout();
			canvas1.setLayout(canvas1Layout);
			canvas1Layout.marginWidth = 0;
			canvas1Layout.marginHeight = 0;
			canvas1Layout.spacing = 0;
			canvas1.layout();
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = true;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
			addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					newSWTAppbackground.dispose();
				}
			});

			postInitGUI();
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	public void preInitGUI() {
	}

	public void postInitGUI() {
		tNewName.selectAll();
		tNewName.setFocus();
	}

	protected void cancelWidgetSelected(SelectionEvent evt) {
		getShell().close();
	}

	/**
	 * this method is executed when the user confirms the refactoring either by clicking on the Ok button or
	 * by pressing enter key
	 */
	protected void confirmRename() {
		if (tNewName.getText().equals("")) { //$NON-NLS-1$
			MessageBox msg = new MessageBox(this.getShell(), SWT.ICON_ERROR);
			msg.setMessage(AtlEditorMessages.getString("RenameFrame.0")); //$NON-NLS-1$
			msg.open();
			return;
		}
		// renameAction.getElement().setName(tNewName.getText());
		getShell().close();
	}

	/**
	 * @param evt
	 *            the selectionEvent
	 */
	protected void okWidgetSelected(SelectionEvent evt) {
		confirmRename();
	}

	public void tNewNameKeyPressed(KeyEvent key) {
		if (key.keyCode == SWT.KEYPAD_CR || key.keyCode == SWT.CR)
			confirmRename();
	}
}
