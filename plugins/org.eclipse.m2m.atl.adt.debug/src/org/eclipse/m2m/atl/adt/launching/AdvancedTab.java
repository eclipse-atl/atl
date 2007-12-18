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
package org.eclipse.m2m.atl.adt.launching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.m2m.atl.adt.debug.Messages;
import org.eclipse.m2m.atl.engine.vm.ATLVMPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class AdvancedTab extends AbstractLaunchConfigurationTab implements ModifyListener, SelectionListener {

	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);

	final static String SUPERIMPOSE = "SUPERIMPOSE";//$NON-NLS-1$

    private Composite container;

    private Group groupSuperimpose;
    private Table tableSuperimpose;
    private Button buttonSuperimpose;
    private Button buttonRemoveSuperimpose;
    
	private Group groupOthersInformation;
	private Button buttonModeDebug;
	private Button buttonAllowInterModelReferences;
	private Combo atlVMs;

	private Map buttonArray = new HashMap();
	
    public void createControl(Composite parent) {

        container = new Composite(parent, SWT.NULL);

        groupSuperimpose = new Group(container, SWT.NULL);
        buttonSuperimpose = new Button(groupSuperimpose, SWT.CENTER);
        tableSuperimpose = new Table(groupSuperimpose, SWT.FULL_SELECTION | SWT.BORDER);
        buttonRemoveSuperimpose = new Button(groupSuperimpose, SWT.CENTER);

        groupOthersInformation = new Group(container,SWT.NULL);
		buttonModeDebug = new Button(groupOthersInformation,SWT.CHECK);
		buttonAllowInterModelReferences = new Button(groupOthersInformation, SWT.CHECK);
        
        GridLayout layout = new GridLayout();
        layout.numColumns = 1;
        layout.makeColumnsEqualWidth = true;
        
        GridData gd3 = new GridData(GridData.FILL_HORIZONTAL);
        groupOthersInformation.setLayoutData(gd3);
        
        container.setLayout(layout);
        
        groupSuperimpose.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        /***********************************************************************
         * GroupSuperimpose
         **********************************************************************/
        
        GridLayout groupLayout = new GridLayout();
        groupLayout.numColumns = 4;
        groupLayout.makeColumnsEqualWidth = true;

        groupSuperimpose.setLayout(groupLayout);
        
        groupSuperimpose.setText(Messages.getString("AdvancedTab.SUPERIMPOSE")); //$NON-NLS-1$

        buttonSuperimpose.setText(Messages.getString("AdvancedTab.ADD")); //$NON-NLS-1$
        buttonSuperimpose.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                addPath(AdvancedTab.SUPERIMPOSE, tableSuperimpose);
                canSave();
                updateLaunchConfigurationDialog();
            }
        });
        
        buttonRemoveSuperimpose.setText(Messages.getString("AdvancedTab.REMOVE")); //$NON-NLS-1$
        buttonRemoveSuperimpose.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent evt) {
                removePath(tableSuperimpose);
                canSave();
                updateLaunchConfigurationDialog();
            }
        });

        TableLayout tableLayout = new TableLayout();
        tableSuperimpose.setLayout(tableLayout);
        tableLayout.addColumnData(new ColumnWeightData(100));
        tableSuperimpose.setLinesVisible(true);
        tableSuperimpose.setHeaderVisible(true);

        //ModelChoiceTab.TABLELIBNAME
        TableColumn superimposeName = new TableColumn(tableSuperimpose, SWT.LEFT);
        superimposeName.setText(Messages.getString("AdvancedTab.SUPERIMPOSE")); //$NON-NLS-1$

        buttonSuperimpose.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        buttonRemoveSuperimpose.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_BEGINNING));

        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.horizontalSpan = 3;
        gd.verticalSpan = 3;
        tableSuperimpose.setLayoutData(gd);

        /** ***************************************** */
        
        /**********************
		 * Components of group3
		 **********************/

		groupOthersInformation.setText(Messages.getString("MainAtlTab.OTHERSPARAMETERS")); //$NON-NLS-1$

		buttonAllowInterModelReferences.setLayoutData(new GridData(GridData.FILL_BOTH));
		buttonAllowInterModelReferences.setText(Messages.getString("MainAtlTab.INTERMODELREFS")); //$NON-NLS-1$
		buttonAllowInterModelReferences.addSelectionListener(this);

		buttonModeDebug.setLayoutData(new GridData(GridData.FILL_BOTH));
		buttonModeDebug.setText(Messages.getString("MainAtlTab.MODEDEBUG")); //$NON-NLS-1$
		buttonModeDebug.addSelectionListener(this);
		
		checkButtonFactory();
		
        Composite groupATLVMs = new Composite(groupOthersInformation, SWT.SHADOW_NONE);
		Label atlVMLabel = new Label(groupATLVMs, SWT.NULL);
		atlVMLabel.setText("ATL Virtual Machine: ");//$NON-NLS-1$
		atlVMLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		atlVMs = new Combo(groupATLVMs, SWT.NULL | SWT.READ_ONLY);
		atlVMs.setItems(AtlVM.getVMs());
		atlVMs.select(0);
		atlVMs.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		atlVMs.addModifyListener(this);
		
		groupATLVMs.setLayout(new GridLayout(2, false));

		groupLayout = new GridLayout();
		groupLayout.numColumns = 1;
		groupLayout.makeColumnsEqualWidth = true;

		groupOthersInformation.setLayout(groupLayout);
        
        
        container.layout();
        container.pack();
        setControl(container);
        canSave();
    }

    protected void updateLaunchConfigurationDialog() {
		if (getLaunchConfigurationDialog() != null) {
			ILaunchConfigurationTab[] tabs = getLaunchConfigurationDialog().getTabs();
			for (int i = 0; i < tabs.length; i++) {
				if (tabs[i] instanceof MainAtlTab) {
					((MainAtlTab) tabs[i]).superimposedChanged(createSuperimposedList());
				}
			}
		}
    	super.updateLaunchConfigurationDialog();
    }

	private void checkButtonFactory() {
		for (int i = 0; i < AtlLauncherTools.additionalParamIds.length; i++) {
			Button newCheckButton = new Button(groupOthersInformation, SWT.CHECK);
			newCheckButton.setLayoutData(new GridData(GridData.FILL_BOTH));
			newCheckButton.setText(AtlLauncherTools.additionalParamLabels[i]);
			newCheckButton.addSelectionListener(this);
			buttonArray.put(AtlLauncherTools.additionalParamIds[i], newCheckButton);
		}
	}
    
    public String getName() {
        return AtlLauncherTools.ADVANCEDTABNAME;
    }

    public void initializeFrom(ILaunchConfiguration configuration) {
        try {
            List superimpose = configuration.getAttribute(AtlLauncherTools.SUPERIMPOSE, new ArrayList());

            tableSuperimpose.removeAll();
            for (Iterator i = superimpose.iterator(); i.hasNext();) {
                String mName = (String) i.next();
                TableItem item = new TableItem(tableSuperimpose, SWT.NONE);
                item.setText(mName);
            }
            
            buttonModeDebug.setSelection(configuration.getAttribute(AtlLauncherTools.MODEDEBUG, false));
			buttonAllowInterModelReferences.setSelection(configuration.getAttribute(AtlLauncherTools.AllowInterModelReferences, false));

			for (int item = 0; item < atlVMs.getItems().length; item++) {
				if (atlVMs.getItem(item).equals(configuration.getAttribute(AtlLauncherTools.ATLVM, ""))) {//$NON-NLS-1$
					atlVMs.select(item);
				}
			}

			for (Iterator it = buttonArray.keySet().iterator(); it.hasNext();) {
				String currentButtonName = (String)it.next();
				Button currentButton = (Button)buttonArray.get(currentButtonName);
				currentButton.setSelection(configuration.getAttribute(currentButtonName, false));
			}
			
            canSave();
            updateLaunchConfigurationDialog();
        } catch (CoreException e) {
            tableSuperimpose.removeAll();
			buttonModeDebug.setSelection(false);
			buttonAllowInterModelReferences.setSelection(true);
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//            e.printStackTrace();
        }
    }
    
    private List createSuperimposedList() {
        List superimpose = new ArrayList();
        for (int i=0; i < tableSuperimpose.getItemCount(); i++) {
            TableItem ti = tableSuperimpose.getItem(i);
            superimpose.add(ti.getText());
        }
        return superimpose;
    }

    public void performApply(ILaunchConfigurationWorkingCopy configuration) {
        configuration.setAttribute(AtlLauncherTools.SUPERIMPOSE, createSuperimposedList());
        
		configuration.setAttribute(AtlLauncherTools.AllowInterModelReferences, buttonAllowInterModelReferences.getSelection());
		configuration.setAttribute(AtlLauncherTools.MODEDEBUG, buttonModeDebug.getSelection());
		configuration.setAttribute(AtlLauncherTools.ATLVM, atlVMs.getItem(atlVMs.getSelectionIndex()));
		
		for (Iterator it = buttonArray.keySet().iterator(); it.hasNext();) {
			String currentButtonName = (String)it.next();
			Button currentButton = (Button)buttonArray.get(currentButtonName);
			configuration.setAttribute(currentButtonName, currentButton.getSelection());
		}
    }

    public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
    }
    
    /**
     * Validates tab for saving.
     * @return True if the tab information is valid for saving 
     */
    public boolean canSave() {
        if (tableSuperimpose.getItemCount() != 0) {
            for (int i=0; i < tableSuperimpose.getItemCount(); i++)
                if (tableSuperimpose.getItem(i).getText().equals("")) { //$NON-NLS-1$
                    this.setErrorMessage(Messages.getString("AdvancedTab.GIVEPATHSUPERIMPOSE")); //$NON-NLS-1$
                    return false;
                }
        }
        
        this.setErrorMessage(null);
        return true;
    }

    /**
     * Returns the icon associate with the tab
     */
    public Image getImage() {
        return AtlLauncherTools.createImage(AtlLauncherTools.PATHICONATL);
    }

    /**
     * This method adds a path to the given table. The path corresponds to a file in the workspace 
     * @param type
     * @param table
     */
    private void addPath(final String type, Table table) {
        ElementTreeSelectionDialog elementTreeSelectionDialog = new ElementTreeSelectionDialog( getShell(), new WorkbenchLabelProvider(), new WorkbenchContentProvider());
        elementTreeSelectionDialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
        elementTreeSelectionDialog.setMessage(Messages.getString("AdvancedTab.CHOOSE") + type); //$NON-NLS-1$
        elementTreeSelectionDialog.setAllowMultiple(false);
        elementTreeSelectionDialog.setDoubleClickSelects(true);
        elementTreeSelectionDialog.addFilter(new ViewerFilter() {
            public boolean select(Viewer viewer, Object parentElement, Object element) {
                boolean ret = false;

                if(element instanceof IContainer) {
                    ret = true;
                } else if(element instanceof IFile) {
                    IFile currentFile = (IFile)element;
                    if (currentFile.getFileExtension() == null)
                        return false;
                    if (type == AdvancedTab.SUPERIMPOSE)
                        ret = (currentFile.getFileExtension().toUpperCase()).equals("ASM");//$NON-NLS-1$
                    else
                        ret = true;
                }
                return ret;
            }
        });
        elementTreeSelectionDialog.setValidator(new ISelectionStatusValidator() {
            public IStatus validate(Object[] selection) {
                IStatus ret = Status.CANCEL_STATUS;

                if(selection.length == 1) {
                    if(selection[0] instanceof IFile) { // no need to verify again extension here
                        ret = Status.OK_STATUS; 
                    }
                }

                return ret;
            }               
        });
        elementTreeSelectionDialog.open();
        Object result = elementTreeSelectionDialog.getFirstResult();

        if ((result != null) && (result instanceof IFile)) {
            IFile currentFile = (IFile)result;
            TableItem item = new TableItem(table, SWT.NONE);
            item.setText(currentFile.getFullPath().toString());
        }
    }

    /**
     * Delete a path in the table
     * @param table
     */
    private void removePath(Table table) {
        int index = table.getSelectionIndex();
        if (index == -1) {
            AtlLauncherTools.messageBox(Messages.getString("AdvancedTab.CHOOSEENTRY")); //$NON-NLS-1$
            return;
        }
        table.remove(index);
    }

	public void modifyText(ModifyEvent e) {
		canSave();
		updateLaunchConfigurationDialog();
	}

	/**
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		canSave();
		updateLaunchConfigurationDialog();
	}

	/**
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
		
	}

	public Table getTableSuperimpose() {
		return tableSuperimpose;
	}

}
