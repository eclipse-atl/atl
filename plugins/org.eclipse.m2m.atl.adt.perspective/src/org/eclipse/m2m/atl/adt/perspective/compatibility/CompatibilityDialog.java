/*******************************************************************************
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - ATL compatibility converter
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.perspective.compatibility;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.m2m.atl.adt.perspective.AtlPerspectivePlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.IWorkbenchWindow;

/**
 * An UI class for old ATL projects conversion.
 * 
 * @author William Piers <a href="mailto:william.piers@obeo.fr">william.piers@obeo.fr</a>
 */
public class CompatibilityDialog extends TitleAreaDialog {

	private CheckboxTableViewer fProjectsTable = null;
	private CheckboxTableViewer fConfTable = null;

	/**
	 * Create an instance of this Dialog.
	 * 
	 * @param shell the shell
	 */
	public CompatibilityDialog(Shell shell, IWorkbenchWindow window) {
		super(shell);
		setShellStyle(SWT.MAX | SWT.RESIZE | getShellStyle());
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		String title="ATL Compatibility"; 
		shell.setText(title);
	}

	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		setTitle("Update ATL projects and configurations");
		setMessage("This page allows to update ATL projects created with ATL anterior to 2.0.0RC2 into new ones.\n Select elements to convert and click OK.");

		// tab folder
		TabFolder tabFolder = new TabFolder(area, SWT.NONE);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// Projects tab
		Composite projectsComposite = new Composite(tabFolder, SWT.NONE);
		projectsComposite.setLayout(new GridLayout(2,false));
		projectsComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
		TabItem projectItem = new TabItem(tabFolder, SWT.NONE);
		projectItem.setText("Projects");
		projectItem.setControl(projectsComposite);
		
		//creates the projects table
		fProjectsTable = CheckboxTableViewer.newCheckList(projectsComposite, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		fProjectsTable.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
		ProjectContentProvider provider = new ProjectContentProvider();
		fProjectsTable.setContentProvider(provider);
		fProjectsTable.setLabelProvider(new ProjectLabelProvider());
		fProjectsTable.setInput(provider);	

		//create select/deselect commands
		Composite buttonsGroup = new Composite(projectsComposite, SWT.MAX);
		buttonsGroup.setLayout(new GridLayout());

		Button selectAll = new Button(buttonsGroup, SWT.CENTER);
		selectAll.setText("Select All");
		selectAll.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				fProjectsTable.setAllChecked(true);
			}
		});

		Button deselectAll = new Button(buttonsGroup, SWT.CENTER);
		deselectAll.setText("Deselect All");
		deselectAll.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				fProjectsTable.setAllChecked(false);
			}
		});
		
		// Configuration tab
		Composite confComposite = new Composite(tabFolder, SWT.NONE);
		confComposite.setLayout(new GridLayout(2,false));
		confComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
		TabItem confItem = new TabItem(tabFolder, SWT.NONE);
		confItem.setText("Configurations");
		confItem.setControl(confComposite);
		
		//creates the conf table
		fConfTable = CheckboxTableViewer.newCheckList(confComposite, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		fConfTable.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
		ConfContentProvider confProvider = new ConfContentProvider();
		fConfTable.setContentProvider(confProvider);
		fConfTable.setLabelProvider(new ConfLabelProvider());
		fConfTable.setInput(confProvider);	

		//create select/deselect commands
		Composite confButtonsGroup = new Composite(confComposite, SWT.MAX);
		confButtonsGroup.setLayout(new GridLayout());

		Button confSelectAll = new Button(confButtonsGroup, SWT.CENTER);
		confSelectAll.setText("Select All");
		confSelectAll.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				fConfTable.setAllChecked(true);
			}
		});

		Button confDeselectAll = new Button(confButtonsGroup, SWT.CENTER);
		confDeselectAll.setText("Deselect All");
		confDeselectAll.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				fConfTable.setAllChecked(false);
			}
		});
		
		return tabFolder;
	}

	protected void okPressed() {
		try {
			CompatibilityUtils.convertProjects(fProjectsTable.getCheckedElements());
			CompatibilityUtils.convertConfigurations(fConfTable.getCheckedElements());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.okPressed();
	}

	/**
	 * Provides the labels for the projects table
	 *
	 */
	class ProjectLabelProvider implements ITableLabelProvider {

		public Image getColumnImage(Object element, int columnIndex) {
			return AtlPerspectivePlugin.getImage("atl_project.png");
		}

		public String getColumnText(Object element, int columnIndex) {
			return ((IProject) element).getName();
		}

		public void addListener(ILabelProviderListener listener) {}

		public void dispose() {}

		public boolean isLabelProperty(Object element, String property) {return false;}
		public void removeListener(ILabelProviderListener listener) {}		
	}

	/**
	 * Content provider for the projects table
	 */
	class ProjectContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			try {
				return CompatibilityUtils.getProjects();					
			} catch (CoreException e) {
				e.printStackTrace();
			}
			return null;
		}

		public void dispose() {}
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

	}
	
	/**
	 * Provides the labels for the configuration table
	 *
	 */
	class ConfLabelProvider implements ITableLabelProvider {

		public Image getColumnImage(Object element, int columnIndex) {
			return AtlPerspectivePlugin.getImage("atl_logo.gif");
		}

		public String getColumnText(Object element, int columnIndex) {
			return ((ILaunchConfiguration) element).getName();
		}

		public void addListener(ILabelProviderListener listener) {}

		public void dispose() {}

		public boolean isLabelProperty(Object element, String property) {return false;}
		public void removeListener(ILabelProviderListener listener) {}		
	}

	/**
	 * Content provider for the conf table
	 */
	class ConfContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			try {
				return CompatibilityUtils.getConfigurations();					
			} catch (CoreException e) {
				e.printStackTrace();
			}
			return null;
		}

		public void dispose() {}
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

	}
}