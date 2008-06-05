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
package org.eclipse.m2m.atl.adt.wizard.atlfile;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

/**
 * @author Freddy Allilaire
 */
public class AtlFileScreen extends WizardPage {

	final public static String NAME = "NAME";//$NON-NLS-1$
	final public static String TYPE = "TYPE";//$NON-NLS-1$
	final public static String CONTAINER = "CONTAINER";//$NON-NLS-1$
	final public static String IN = "IN";//$NON-NLS-1$
	final public static String OUT = "OUT";//$NON-NLS-1$
	final public static String LIB = "LIB";//$NON-NLS-1$
	final public static String MODULE = "module";//$NON-NLS-1$
	final public static String QUERY = "query";//$NON-NLS-1$
	final public static String LIBRARY = "library";//$NON-NLS-1$

	private ISelection selection;

	private Group groupHead;
	private Group groupIn;
	private Group groupOut;
	private Group groupLib;
	private Text textName;
	private Text textProject;
	private Combo comboType;
	private Table tableIn;
	private Table tableOut;
	private Table tableLib;

	/**
	 * 
	 * @param selection
	 */
	public AtlFileScreen(ISelection selection) {
		super("ATL File Wizard"); //$NON-NLS-1$
		setTitle("ATL File Wizard"); //$NON-NLS-1$
		setDescription(""); //$NON-NLS-1$
		this.selection = selection;
		//		System.out.println("selection: " + this.selection);
		this.setPageComplete(false);
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 * In this method, the GUI is created
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 1;
		layout.verticalSpacing = 9;

		groupHead = new Group(container, SWT.NULL);
		groupIn = new Group(container, SWT.NULL);
		groupOut = new Group(container, SWT.NULL);
		groupLib = new Group(container, SWT.NULL);

		/***********************************************************************
		 * GroupHead
		 **********************************************************************/
		layout = new GridLayout();
		layout.numColumns = 3;

		groupHead.setLayout(layout);
		groupHead.setText("HEAD"); //$NON-NLS-1$
		groupHead.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		new Label(groupHead, SWT.NULL).setText("Container"); //$NON-NLS-1$
		textProject = new Text(groupHead, SWT.BORDER);

		if (selection!=null && selection.isEmpty()==false && selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection)selection;
			if (ssel.size()>1) return;
			Object obj = ssel.getFirstElement();
			if (obj instanceof IResource) {
				IContainer selectionContainer;
				if (obj instanceof IContainer)
					selectionContainer = (IContainer)obj;
				else
					selectionContainer = ((IResource)obj).getParent();
				textProject.setText(selectionContainer.getFullPath().toOSString());
			}
		}

		textProject.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Button buttonBrowse = new Button(groupHead, SWT.PUSH);
		buttonBrowse.setText("Browse..."); //$NON-NLS-1$
		buttonBrowse.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleProjectBrowse();
			}
		});

		new Label(groupHead, SWT.NULL).setText("ATL Module Name"); //$NON-NLS-1$
		textName = new Text(groupHead, SWT.BORDER);
		textName.addKeyListener( new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				textNameKeyPressed(evt);
			}
		});

		GridData gdFilename = new GridData(GridData.FILL_HORIZONTAL);
		gdFilename.horizontalSpan = 2;
		textName.setLayoutData(gdFilename);

		new Label(groupHead, SWT.NULL).setText("ATL File Type"); //$NON-NLS-1$
		comboType = new Combo(groupHead, SWT.BORDER | SWT.READ_ONLY);
		comboType.setItems(new String[] {MODULE, LIBRARY, QUERY});
		comboType.setText(MODULE);
		GridData gdATLType = new GridData(GridData.FILL_HORIZONTAL);
		gdATLType.horizontalSpan = 2;
		comboType.setLayoutData(gdATLType);

		/***********************************************************************
		 * GroupIn
		 **********************************************************************/
		layout = new GridLayout();
		layout.numColumns = 5;

		groupIn.setLayout(layout);
		groupIn.setLayoutData(new GridData(GridData.FILL_BOTH));
		groupIn.setText("IN"); //$NON-NLS-1$

		new Label(groupIn, SWT.NULL).setText("Model"); //$NON-NLS-1$
		final Text inM1 = new Text(groupIn, SWT.BORDER);
		inM1.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		new Label(groupIn, SWT.NULL).setText("Metamodel"); //$NON-NLS-1$
		final Text inM2 = new Text(groupIn, SWT.BORDER);
		inM2.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		final Button buttonIn = new Button(groupIn, SWT.PUSH);
		buttonIn.setText("ADD"); //$NON-NLS-1$
		buttonIn.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		tableIn = new Table(groupIn, SWT.NULL);
		GridData gdIn = new GridData(GridData.FILL_BOTH);
		gdIn.horizontalSpan = 5;
		tableIn.setLayoutData(gdIn);
		tableIn.setLinesVisible(true);
		tableIn.setHeaderVisible(true);

		TableColumn tc = new TableColumn(tableIn, SWT.CENTER);
		tc.setText("Model"); //$NON-NLS-1$
		tc.setWidth(250);
		tc.setAlignment(SWT.CENTER);
		tc = new TableColumn(tableIn, SWT.CENTER);
		tc.setText("Metamodel"); //$NON-NLS-1$
		tc.setWidth(250);
		tc.setAlignment(SWT.CENTER);

		buttonIn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				addTextTable(tableIn, new String[] {inM1.getText(), inM2.getText()});
			}
		});
		/***********************************************************************
		 * GroupOut
		 **********************************************************************/
		layout = new GridLayout();
		layout.numColumns = 5;

		groupOut.setLayout(layout);
		groupOut.setLayoutData(new GridData(GridData.FILL_BOTH));
		groupOut.setText("OUT"); //$NON-NLS-1$

		new Label(groupOut, SWT.NULL).setText("Model"); //$NON-NLS-1$
		final Text outM1 = new Text(groupOut, SWT.BORDER);
		outM1.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		new Label(groupOut, SWT.NULL).setText("Metamodel"); //$NON-NLS-1$
		final Text outM2 = new Text(groupOut, SWT.BORDER);
		outM2.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		final Button buttonOut = new Button(groupOut, SWT.PUSH);
		buttonOut.setText("ADD"); //$NON-NLS-1$
		buttonOut.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		tableOut = new Table(groupOut, SWT.NULL);
		GridData gdOut = new GridData(GridData.FILL_BOTH);
		gdOut.horizontalSpan = 5;
		tableOut.setLayoutData(gdOut);
		tableOut.setLinesVisible(true);
		tableOut.setHeaderVisible(true);

		tc = new TableColumn(tableOut, SWT.CENTER);
		tc.setText("Model"); //$NON-NLS-1$
		tc.setWidth(250);
		tc.setAlignment(SWT.CENTER);
		tc= new TableColumn(tableOut, SWT.CENTER);
		tc.setText("Metamodel"); //$NON-NLS-1$
		tc.setWidth(250);
		tc.setAlignment(SWT.CENTER);

		buttonOut.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				addTextTable(tableOut, new String[] {outM1.getText(), outM2.getText()});
			}
		});
		/***********************************************************************
		 * GroupLib
		 **********************************************************************/
		layout = new GridLayout();
		layout.numColumns = 3;

		groupLib.setLayout(layout);
		groupLib.setLayoutData(new GridData(GridData.FILL_BOTH));
		groupLib.setText("LIB"); //$NON-NLS-1$

		new Label(groupLib, SWT.NULL).setText("LIB"); //$NON-NLS-1$
		final Text textLib = new Text(groupLib, SWT.BORDER);
		textLib.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		final Button buttonLib = new Button(groupLib, SWT.PUSH);
		buttonLib.setText("ADD"); //$NON-NLS-1$
		buttonLib.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		tableLib = new Table(groupLib, SWT.NULL);
		GridData gdLib = new GridData(GridData.FILL_BOTH);
		gdLib.horizontalSpan = 5;
		tableLib.setLayoutData(gdLib);
		tableLib.setLinesVisible(true);
		tableLib.setHeaderVisible(true);

		tc = new TableColumn(tableLib, SWT.CENTER);
		tc.setText("LIB"); //$NON-NLS-1$
		tc.setWidth(500);
		tc.setAlignment(SWT.CENTER);

		buttonLib.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				addTextTable(tableLib, new String[] {textLib.getText()});
			}
		});

		comboType.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				if (comboType.getText().equals(MODULE)) {
					groupIn.setEnabled(true);
					setEnabled(groupIn.getChildren(), true);
					groupOut.setEnabled(true);
					setEnabled(groupOut.getChildren(), true);
					groupLib.setEnabled(true);
					setEnabled(groupLib.getChildren(), true);
				}
				else if (comboType.getText().equals(LIBRARY)) {
					groupIn.setEnabled(false);
					setEnabled(groupIn.getChildren(), false);
					groupOut.setEnabled(false);
					setEnabled(groupOut.getChildren(), false);
					groupLib.setEnabled(false);
					setEnabled(groupLib.getChildren(), false);
				}
				else if (comboType.getText().equals(QUERY)) {
					groupIn.setEnabled(false);
					setEnabled(groupIn.getChildren(), false);
					groupOut.setEnabled(false);
					setEnabled(groupOut.getChildren(), false);
					groupLib.setEnabled(true);
					setEnabled(groupLib.getChildren(), true);
				}
			}
		});

		buttonIn.setEnabled(false);
		buttonOut.setEnabled(false);
		buttonLib.setEnabled(false);
		
		ModifyListener addInEnabler = new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				buttonIn.setEnabled(inM1.getText().trim() != "" && inM2.getText().trim() != "");
			}
		};
		
		ModifyListener addOutEnabler = new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				buttonOut.setEnabled(outM1.getText().trim() != "" && outM2.getText().trim() != "");
			}
		};
		
		ModifyListener addLibEnabler = new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				buttonLib.setEnabled(textLib.getText().trim() != "");
			}
		};
		
		inM1.addModifyListener(addInEnabler);
		inM2.addModifyListener(addInEnabler);
		
		outM1.addModifyListener(addOutEnabler);
		outM2.addModifyListener(addOutEnabler);
		
		textLib.addModifyListener(addLibEnabler);

		container.layout();
		setControl(container);
}

/**
 * 
 * @param controlArray
 * @param enabled
 */
private void setEnabled(Control[] controlArray, boolean enabled) {
	for (int i=0; i < controlArray.length; i++) {
		controlArray[i].setEnabled(enabled);
	}
}

/**
 * Opens the browse container file
 */
private void handleProjectBrowse() {
	ContainerSelectionDialog dialog =
		new ContainerSelectionDialog(
				getShell(),
				ResourcesPlugin.getWorkspace().getRoot(),
				false,
		"Select a container"); //$NON-NLS-1$
	if (dialog.open() == ContainerSelectionDialog.OK) {
		Object[] result = dialog.getResult();
		if (result.length == 1) {
			textProject.setText(((Path)result[0]).toOSString());
		}
	}
}	

/**
 * 
 * @param tableParam
 * @param itemAdded
 */
private void addTextTable(Table tableParam, String[] itemAdded) {
	TableItem item = new TableItem(tableParam, SWT.NONE);
	item.setText(itemAdded);
}

/**
 * 
 * @param evt
 */
protected void textNameKeyPressed(KeyEvent evt) {
	if (textName.getText().equals("")) //$NON-NLS-1$
		this.setPageComplete(false);
	else
		this.setPageComplete(true);
}

public String getParameter(String parameter) {
	if (parameter.equals(NAME))
		return textName.getText();
	if (parameter.equals(TYPE))
		return comboType.getText();
	if (parameter.equals(CONTAINER))
		return textProject.getText();
	if (parameter.equals(IN)) {
		String ret = ""; //$NON-NLS-1$
		for (int i=0; i < tableIn.getItems().length; i++) {
			if (i > 0)
				ret += ", "; //$NON-NLS-1$
			ret += tableIn.getItem(i).getText(0);
			ret += " : "; //$NON-NLS-1$
			ret += tableIn.getItem(i).getText(1);
		}
		return ret;
	}
	if (parameter.equals(OUT)) {
		String ret = ""; //$NON-NLS-1$
		for (int i=0; i < tableOut.getItems().length; i++) {
			if (i > 0)
				ret += ", "; //$NON-NLS-1$
			ret += tableOut.getItem(i).getText(0);
			ret += " : "; //$NON-NLS-1$
			ret += tableOut.getItem(i).getText(1);
		}
		return ret;
	}
	if (parameter.equals(LIB)) {
		String ret = ""; //$NON-NLS-1$
		for (int i=0; i < tableLib.getItems().length; i++) {
			ret += "uses " + tableLib.getItem(i).getText(0) + ";\n"; //$NON-NLS-1$ //$NON-NLS-2$
		}
		return ret;
	}
	return null;
}
}