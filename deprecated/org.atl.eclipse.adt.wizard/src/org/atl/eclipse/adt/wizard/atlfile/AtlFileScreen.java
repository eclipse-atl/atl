/*
 * Created on 16 avr. 2004
 */
package org.atl.eclipse.adt.wizard.atlfile;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
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
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * @author allilaire
 */
public class AtlFileScreen extends WizardPage {

	final public static String NAME = "NAME";
	final public static String TYPE = "TYPE";
	final public static String PROJECT = "PROJECT";
	final public static String IN = "IN";
	final public static String OUT = "OUT";
	final public static String LIB = "LIB";
	final public static String MODULE = "module";
	final public static String QUERY = "query";
	final public static String LIBRARY = "library";
		
	private ISelection selection;
	private Group groupHead;
	private Group groupIn;
	private Group groupOut;
	private Group groupLib;
	private Text textName;
	private Combo comboProject;
	private Combo comboType;
	private Table tableIn;
	private Table tableOut;
	private Table tableLib;

	/**
	 * 
	 * @param selection
	 */
	public AtlFileScreen(ISelection selection) {
		super("ATL File Wizard");
		setTitle("ATL File Wizard");
		setDescription("");
		this.selection = selection;
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
		layout.numColumns = 2;
		
		groupHead.setLayout(layout);
		groupHead.setText("HEAD");
		groupHead.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		new Label(groupHead, SWT.NULL).setText("Project Name");
		comboProject = new Combo(groupHead, SWT.BORDER | SWT.READ_ONLY);

		/**
		 * Filled combo with project names available
		 */
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		List arrayProjectName = new ArrayList();
		for (int i=0; i < root.getProjects().length; i++) {
			IProject currentProject = root.getProjects()[i];
			arrayProjectName.add(currentProject.getName());
		}
		comboProject.setItems( (String[])arrayProjectName.toArray(new String[] {}));
		
		/**
		 * Selected current project is possible
		 */
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		
		ISelection selection = page.getSelection();
//		ISelection selection = page.getSelection(IPageLayout.ID_RES_NAV);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ss = (IStructuredSelection)selection;
			Object element = ss.getFirstElement();
			if (element instanceof IResource)
				comboProject.setText(((IResource)element).getProject().getName());
		}
		if (comboProject.getText().equals(""))
			comboProject.setText(comboProject.getItem(0));
		/**
		 * 
		 */
		comboProject.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		new Label(groupHead, SWT.NULL).setText("ATL File Name");
		textName = new Text(groupHead, SWT.BORDER);
		textName.addKeyListener( new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				textNameKeyPressed(evt);
			}
		});
		textName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		new Label(groupHead, SWT.NULL).setText("ATL File Type");
		comboType = new Combo(groupHead, SWT.BORDER | SWT.READ_ONLY);
		comboType.setItems(new String[] {MODULE, LIBRARY, QUERY});
		comboType.setText(MODULE);
		comboType.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		/***********************************************************************
		 * GroupIn
		 **********************************************************************/
		layout = new GridLayout();
		layout.numColumns = 5;
		
		groupIn.setLayout(layout);
		groupIn.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		groupIn.setText("IN");
		
		new Label(groupIn, SWT.NULL).setText("IN M1");
		final Text inM1 = new Text(groupIn, SWT.BORDER);
		inM1.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		new Label(groupIn, SWT.NULL).setText("IN M2");
		final Text inM2 = new Text(groupIn, SWT.BORDER);
		inM2.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		Button buttonIn = new Button(groupIn, SWT.PUSH);
		buttonIn.setText("ADD");
		buttonIn.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		tableIn = new Table(groupIn, SWT.NULL);
		GridData gdIn = new GridData(GridData.FILL_HORIZONTAL);
		gdIn.horizontalSpan = 5;
		tableIn.setLayoutData(gdIn);
		tableIn.setLinesVisible(true);
		tableIn.setHeaderVisible(true);
		
		TableColumn tc = new TableColumn(tableIn, SWT.CENTER);
		tc.setText("M1");
		tc.setWidth(250);
		tc.setAlignment(SWT.CENTER);
		tc = new TableColumn(tableIn, SWT.CENTER);
		tc.setText("M2");
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
		groupOut.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		groupOut.setText("OUT");
		
		new Label(groupOut, SWT.NULL).setText("OUT M1");
		final Text outM1 = new Text(groupOut, SWT.BORDER);
		outM1.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		new Label(groupOut, SWT.NULL).setText("OUT M2");
		final Text outM2 = new Text(groupOut, SWT.BORDER);
		outM2.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		Button buttonOut = new Button(groupOut, SWT.PUSH);
		buttonOut.setText("ADD");
		buttonOut.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		tableOut = new Table(groupOut, SWT.NULL);
		GridData gdOut = new GridData(GridData.FILL_HORIZONTAL);
		gdOut.horizontalSpan = 5;
		tableOut.setLayoutData(gdOut);
		tableOut.setLinesVisible(true);
		tableOut.setHeaderVisible(true);
		
		tc = new TableColumn(tableOut, SWT.CENTER);
		tc.setText("M1");
		tc.setWidth(250);
		tc.setAlignment(SWT.CENTER);
		tc= new TableColumn(tableOut, SWT.CENTER);
		tc.setText("M2");
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
		groupLib.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		groupLib.setText("LIB");
		
		new Label(groupLib, SWT.NULL).setText("LIB");
		final Text textLib = new Text(groupLib, SWT.BORDER);
		textLib.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		Button buttonLib = new Button(groupLib, SWT.PUSH);
		buttonLib.setText("ADD");
		buttonLib.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		tableLib = new Table(groupLib, SWT.NULL);
		GridData gdLib = new GridData(GridData.FILL_HORIZONTAL);
		gdLib.horizontalSpan = 5;
		tableLib.setLayoutData(gdLib);
		tableLib.setLinesVisible(true);
		tableLib.setHeaderVisible(true);
		
		tc = new TableColumn(tableLib, SWT.CENTER);
		tc.setText("LIB");
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
		if (textName.getText().equals(""))
			this.setPageComplete(false);
		else
			this.setPageComplete(true);
	}
	
	public String getParameter(String parameter) {
		if (parameter.equals(NAME))
			return textName.getText();
		if (parameter.equals(TYPE))
			return comboType.getText();
		if (parameter.equals(PROJECT))
			return comboProject.getText();
		if (parameter.equals(IN)) {
			String ret = "";
			for (int i=0; i < tableIn.getItems().length; i++) {
				if (i > 0)
					ret += ", ";
				ret += tableIn.getItem(i).getText(0);
				ret += " : ";
				ret += tableIn.getItem(i).getText(1);
			}
			return ret;
		}
		if (parameter.equals(OUT)) {
			String ret = "";
			for (int i=0; i < tableOut.getItems().length; i++) {
				if (i > 0)
					ret += ", ";
				ret += tableOut.getItem(i).getText(0);
				ret += " : ";
				ret += tableOut.getItem(i).getText(1);
			}
			return ret;
		}
		if (parameter.equals(LIB)) {
			String ret = "";
			for (int i=0; i < tableLib.getItems().length; i++) {
				ret += "uses " + tableLib.getItem(i).getText(0) + ";\n";
			}
			return ret;
		}
		return null;
	}
}