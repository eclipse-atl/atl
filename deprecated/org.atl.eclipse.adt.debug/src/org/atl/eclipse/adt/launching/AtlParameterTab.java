/*
 * Created on 17 juin 2004
 */
package org.atl.eclipse.adt.launching;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * @author allilaire
 * @see org.eclipse.debug.ui.ILaunchConfigurationTab
 */

public class AtlParameterTab extends AbstractLaunchConfigurationTab {

	private Map injector = new HashMap();
	private Map extractor = new HashMap();
	
	/** Graphic components */
	private Composite container;

	private Group groupInj;
	private Table tableInj;
	private Text textInj;
	private Label labelInj;
	private Button buttonAddInj;
	private Button buttonRemoveInj;
	private Button buttonEditInj;
	
	private Group groupExt;
	private Table tableExt;
	private Text textExt;
	private Label labelExt;
	private Button buttonAddExt;
	private Button buttonRemoveExt;
	private Button buttonEditExt;

	public void createControl(Composite parent) {
		/*
		 * Initialisation of composants
		 */
		container = new Composite(parent, SWT.NULL);
		
		groupInj = new Group(container, SWT.NULL);
		labelInj = new Label(groupInj, SWT.END);
		textInj = new Text(groupInj, SWT.BORDER);
		buttonAddInj = new Button(groupInj, SWT.NULL);
		buttonRemoveInj = new Button(groupInj, SWT.NULL);
		buttonEditInj = new Button(groupInj, SWT.NULL);
		tableInj = new Table(groupInj, SWT.FULL_SELECTION | SWT.BORDER);
		
		groupExt = new Group(container, SWT.NULL);
		labelExt = new Label(groupExt, SWT.END);
		textExt = new Text(groupExt, SWT.BORDER);
		buttonAddExt = new Button(groupExt, SWT.CENTER);
		buttonRemoveExt = new Button(groupExt, SWT.NULL);
		buttonEditExt = new Button(groupExt, SWT.NULL);
		tableExt = new Table(groupExt, SWT.FULL_SELECTION | SWT.BORDER);
		
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.makeColumnsEqualWidth = true;
		
		container.setLayout(layout);
		
		GridData gdIn = new GridData(GridData.FILL_BOTH);
		GridData gdOut = new GridData(GridData.FILL_BOTH);

		groupInj.setLayoutData(gdIn);
		groupExt.setLayoutData(gdOut);
		
		/***********************************************************************
		 * Form layout definition
		 **********************************************************************/
		
		FormLayout groupLayout = new FormLayout();

		groupInj.setLayout(groupLayout);
		groupExt.setLayout(groupLayout);
		
		FormData labelLData = AtlLauncherTools.createFormData(0, 25, 0, 10);
		FormData textLData = AtlLauncherTools.createFormData(25, 50, 0, 10);
		FormData buttonLData =AtlLauncherTools. createFormData(80, 100, 20, 30);
		FormData buttonRemoveLData = AtlLauncherTools.createFormData(80, 100, 35, 45);
		FormData buttonEditLData = AtlLauncherTools.createFormData(80, 100, 50, 60);
		FormData tableLData = AtlLauncherTools.createFormData(0, 70, 20, 100);
		
		/***********************************************************************
		 * GroupInj
		 **********************************************************************/
		
		groupInj.setText("Injector");

		labelInj.setText("Injector : ");
		
		buttonAddInj.setText("Add");
		buttonAddInj.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				addItem(textInj, tableInj, AtlLauncherTools.INJECTOR);
				updateLaunchConfigurationDialog();
			}
		});

		buttonRemoveInj.setText("Remove");
		buttonRemoveInj.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				removeItem(tableInj, AtlLauncherTools.INJECTOR);
				updateLaunchConfigurationDialog();
			}
		});
		
		buttonEditInj.setText("Edit path");
		buttonEditInj.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				editPath(AtlLauncherTools.INJECTOR, tableInj);
				updateLaunchConfigurationDialog();
			}
		});
		
		// table
		tableInj.setLinesVisible(true);
		tableInj.setHeaderVisible(true);
		
		TableColumn name = new TableColumn(tableInj, SWT.CENTER);
		name.setText("Injector");
		name.setWidth(100);
		
		TableColumn age = new TableColumn(tableInj, SWT.CENTER);
		age.setText("Path");
		age.setWidth(100);

		TableColumn hiddenPathInj = new TableColumn(tableInj, SWT.CENTER);
		hiddenPathInj.setWidth(0);
		
		labelInj.setLayoutData(labelLData);
		textInj.setLayoutData(textLData);

		tableInj.setLayoutData(tableLData);

		buttonAddInj.setLayoutData(buttonLData);
		buttonRemoveInj.setLayoutData(buttonRemoveLData);
		buttonEditInj.setLayoutData(buttonEditLData);

		/***********************************************************************
		 * GroupExt
		 **********************************************************************/

		groupExt.setText("Extractor");

		labelExt.setText("Extractor : ");

		buttonAddExt.setText("Add");
		buttonAddExt.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				addItem(textExt, tableExt, AtlLauncherTools.EXTRACTOR);
				updateLaunchConfigurationDialog();
			}
		});
		
		buttonRemoveExt.setText("Remove");
		buttonRemoveExt.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				removeItem(tableExt, AtlLauncherTools.EXTRACTOR);
				updateLaunchConfigurationDialog();
			}
		});
		
		buttonEditExt.setText("Edit path");
		buttonEditExt.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				editPath(AtlLauncherTools.EXTRACTOR, tableExt);
				updateLaunchConfigurationDialog();
			}
		});
		
		// table
		tableExt.setLinesVisible(true);
		tableExt.setHeaderVisible(true);

		TableColumn modelName = new TableColumn(tableExt, SWT.CENTER);
		modelName.setText("Extractor");
		modelName.setWidth(100);
		
		TableColumn metaModelName = new TableColumn(tableExt, SWT.CENTER);
		metaModelName.setText("Path");
		metaModelName.setWidth(100);

		TableColumn hiddenPathExt = new TableColumn(tableExt, SWT.CENTER);
		hiddenPathExt.setWidth(0);
		
		labelExt.setLayoutData(labelLData);
		textExt.setLayoutData(textLData);

		tableExt.setLayoutData(tableLData);

		buttonAddExt.setLayoutData(buttonLData);
		buttonRemoveExt.setLayoutData(buttonRemoveLData);
		buttonEditExt.setLayoutData(buttonEditLData);

		/** ***************************************** */
		groupInj.layout();
		groupExt.layout();
		
		container.layout();
		setControl(container);

	}

	private void editPath(String type, Table table) {
		int index = table.getSelectionIndex();
		
		if (index == -1) {
			AtlLauncherTools.messageBox("Please, choose a " + type);
			return;
		}

		ElementTreeSelectionDialog elementTreeSelectionDialog = new ElementTreeSelectionDialog(	getShell(), new WorkbenchLabelProvider(), new WorkbenchContentProvider());
		elementTreeSelectionDialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		elementTreeSelectionDialog.setMessage("Message: choose a " + type);
		elementTreeSelectionDialog.open();
		
		Object result[] = elementTreeSelectionDialog.getResult();

		if ((result[0] != null) && (result[0] instanceof IFile)) {
			TableItem item = table.getItem(index);
			item.setText(new String[]{item.getText(0), ((IFile)result[0]).getName(), ((IFile)result[0]).getLocation().toString()});
		}
		else {
			AtlLauncherTools.messageBox("Please, choose a " + type);
		}
	}
	
	/**
	 * Delete an injector/extractor
	 */
	private void removeItem(Table table, String type) {
		int index = table.getSelectionIndex();
		
		if (index == -1) {
			AtlLauncherTools.messageBox("Please, choose a " + type);
			return;
		}

		MessageBox msgBox = new MessageBox(this.getShell(),	SWT.APPLICATION_MODAL | SWT.YES | SWT.NO);
		msgBox.setText("Error");
		msgBox.setMessage("Do you want to remove this item ?");
		msgBox.open();

		TableItem item = table.getItem(index);
		String itemName = item.getText(0);
		
		int indexLib = -1;

		TableItem items[] = table.getItems();
	
		for (int i=0; i<items.length; i++) {
			if (itemName.equals(items[i].getText(0)))
				indexLib = i;
		}

		table.remove(index);
	}
	
	/**
	 * Add injector/extractor to the table
	 *
	 */
	private void addItem(Text text, Table table, String type) {
		String item = text.getText();
		if (item.equals("")) {
			AtlLauncherTools.messageBox("Please, give a " + type);
			return;
		}
		
		TableItem ti = new TableItem(table, SWT.NONE);
		ti.setText(new String[]{item, "", ""});
		
		text.setText("");
	}

	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			Map input = configuration.getAttribute(AtlLauncherTools.INJECTOR, new HashMap());
			Map output = configuration.getAttribute(AtlLauncherTools.EXTRACTOR, new HashMap());

			tableInj.removeAll();
			for (Iterator i = input.keySet().iterator(); i.hasNext();) {
				String mName = (String) i.next();
				TableItem item = new TableItem(tableInj, SWT.NONE);
				String completePath = (String) input.get(mName);
				StringTokenizer st = new StringTokenizer(completePath, "/\\");
				String pathToDisplay = "";
				
				while (st.hasMoreTokens())
					pathToDisplay = st.nextToken();
				
				item.setText(new String[]{mName, pathToDisplay, completePath});
			}
			
			tableExt.removeAll();
			for (Iterator i = output.keySet().iterator(); i.hasNext();) {
				String mName = (String) i.next();
				TableItem item = new TableItem(tableExt, SWT.NONE);
				String completePath = (String) output.get(mName);
				StringTokenizer st = new StringTokenizer(completePath, "/\\");
				String pathToDisplay = "";
				
				while (st.hasMoreTokens())
					pathToDisplay = st.nextToken();
				
				item.setText(new String[]{mName, pathToDisplay, completePath});
			}

		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		
		for (int i=0; i < tableInj.getItemCount(); i++) {
			TableItem ti = tableInj.getItem(i);
			injector.put(ti.getText(0), ti.getText(2));
		}
		
		for (int i=0; i < tableExt.getItemCount(); i++) {
			TableItem ti = tableExt.getItem(i);
			extractor.put(ti.getText(0), ti.getText(2));
		}
		
		configuration.setAttribute(AtlLauncherTools.INJECTOR, injector);
		configuration.setAttribute(AtlLauncherTools.EXTRACTOR, extractor);
	}

	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return "ATL Configuration";
	}
	
}