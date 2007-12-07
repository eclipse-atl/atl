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
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class CompatibilityDialog extends TitleAreaDialog {

	private final static int TAB_WIDTH_IN_DLUS = 260;
	private final static int TAB_HEIGHT_IN_DLUS = 100;

	private boolean update;

	private CheckboxTableViewer fProjectsTable = null;
	private CheckboxTableViewer fConfigurationTable = null;

	/**
	 * Create an instance of this Dialog.
	 * 
	 * @param shell the shell
	 */
	public CompatibilityDialog(Shell shell, boolean update) {
		super(shell);
		this.update = update;
		setShellStyle(SWT.MAX | SWT.RESIZE | getShellStyle());
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		String title="ATL Compatibility"; 
		shell.setText(title);
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		setTitle(computeTitle());
		setMessage(computeMessage());

		// tab folder
		TabFolder tabFolder = new TabFolder(composite, SWT.NONE);

		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd.widthHint = convertHorizontalDLUsToPixels(TAB_WIDTH_IN_DLUS);
		gd.heightHint = convertVerticalDLUsToPixels(TAB_HEIGHT_IN_DLUS);
		tabFolder.setLayoutData(gd);

		// Projects tab
		TabItem projectItem = new TabItem(tabFolder, SWT.NONE);
		projectItem.setText("Projects");
		projectItem.setControl(createProjectList(tabFolder));

		// Configurations tab
		TabItem configItem = new TabItem(tabFolder, SWT.NONE);
		configItem.setText("Configurations");
		configItem.setControl(createConfigurationList(tabFolder));

		applyDialogFont(tabFolder);

		return composite;
	}

	private final Composite createProjectList(final Composite parent) {
		Composite group = new Composite(parent, SWT.NONE);
		Layout layout = new GridLayout(2, false);
		group.setLayout(layout);
		fProjectsTable = CheckboxTableViewer.newCheckList(group, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		Control table = fProjectsTable.getControl();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		table.setFont(parent.getFont());
		ProjectContentProvider provider = new ProjectContentProvider();
		fProjectsTable.setContentProvider(provider);
		fProjectsTable.setLabelProvider(new ProjectLabelProvider());
		fProjectsTable.setInput(provider);	

		addSelectionUtilities(group, fProjectsTable);
		return group;
	}

	private final Composite createConfigurationList(final Composite parent) {
		Composite group = new Composite(parent, SWT.NONE);
		Layout layout = new GridLayout(2, false);
		group.setLayout(layout);
		fConfigurationTable = CheckboxTableViewer.newCheckList(group, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		Control table = fConfigurationTable.getControl();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		table.setFont(parent.getFont());
		ConfigurationContentProvider provider = new ConfigurationContentProvider();
		fConfigurationTable.setContentProvider(provider);
		fConfigurationTable.setLabelProvider(new ConfigurationLabelProvider());
		fConfigurationTable.setInput(provider);	

		addSelectionUtilities(group, fConfigurationTable);
		return group;
	}

	private void addSelectionUtilities(Composite parent, final CheckboxTableViewer table){
		Composite group = new Composite(parent, SWT.NONE);
		Layout layout = new GridLayout();
		group.setLayout(layout);
		Button selectAll = new Button(group, SWT.CENTER);
		selectAll.setText("Select All");
		selectAll.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				table.setAllChecked(true);
			}
		});

		Button deselectAll = new Button(group, SWT.CENTER);
		deselectAll.setText("Deselect All");
		deselectAll.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				table.setAllChecked(false);
			}
		});
	}

	protected void okPressed() {
		try {
			if (update) {
				CompatibilityUtils.convertProjects(fProjectsTable.getCheckedElements(),
						CompatibilityUtils.oldNatureId, 
						CompatibilityUtils.oldBuilderId,
						CompatibilityUtils.newNatureId,
						CompatibilityUtils.newBuilderId);
				CompatibilityUtils.convertConfigs(fConfigurationTable.getCheckedElements(),
						CompatibilityUtils.oldConfigId, 
						CompatibilityUtils.newConfigId);
			} else {
				CompatibilityUtils.convertProjects(fProjectsTable.getCheckedElements(),
						CompatibilityUtils.newNatureId,
						CompatibilityUtils.newBuilderId,
						CompatibilityUtils.oldNatureId, 
						CompatibilityUtils.oldBuilderId);
				CompatibilityUtils.convertConfigs(fConfigurationTable.getCheckedElements(),
						CompatibilityUtils.newConfigId, 
						CompatibilityUtils.oldConfigId);
			}

		} catch (CoreException e) {
			e.printStackTrace();
		}
		super.okPressed();
	}

	private String computeTitle(){
		if (update) {
			return "Update ATL projects and configurations";
		} else {
			return "DEPRECATED : Revert ATL projects and configurations";
		}
	}

	private String computeMessage(){
		if (update) {
			return "This page allows to update ATL projects created with ATL anterior to 2.0.0RC2 into new ones.\n Select projects and configurations and click OK.";
		} else {
			return "This page allows to revert ATL projects created with ATL up to 2.0.0RC2 into old ones.\n Select projects and configurations and click OK.";
		}
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
				if (update) {
					return CompatibilityUtils.getProjects(CompatibilityUtils.oldNatureId);					
				} else {
					return CompatibilityUtils.getProjects(CompatibilityUtils.newNatureId);	
				}					
			} catch (CoreException e) {
				e.printStackTrace();
			}
			return null;
		}

		public void dispose() {}
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

	}

	/**
	 * Provides the labels for the projects table
	 *
	 */
	class ConfigurationLabelProvider implements ITableLabelProvider {

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
	 * Content provider for the projects table
	 */
	class ConfigurationContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			try {
				if (update) {
					return CompatibilityUtils.getConfigurations(CompatibilityUtils.oldConfigId);					
				} else {
					return CompatibilityUtils.getConfigurations(CompatibilityUtils.newConfigId);	
				}	
			} catch (CoreException e) {
				e.printStackTrace();
			}
			return null;
		}

		public void dispose() {}
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

	}
}