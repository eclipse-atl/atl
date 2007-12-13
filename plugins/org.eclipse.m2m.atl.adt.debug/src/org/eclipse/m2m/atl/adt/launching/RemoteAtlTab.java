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

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.m2m.atl.adt.debug.Messages;
import org.eclipse.m2m.atl.engine.vm.ATLVMPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * @author Freddy Allilaire
 */
public class RemoteAtlTab extends AbstractLaunchConfigurationTab implements ModifyListener {
	
	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);

	private Composite container;

	private Group group1;
	private Combo listProject;
	private Label labelProject;
	private Combo listFile;
	private Label labelFile;
	
	private Group group2;
	private Text textHost;
	private Label labelHost;
	private Text textPort;
	private Label labelPort;

	public void createControl(Composite parent) {
		
		container = new Composite(parent, SWT.NULL);

		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 1;
		layout.verticalSpacing = 9;
		layout.makeColumnsEqualWidth = true;

		group1 = new Group(container,SWT.NULL);
		labelProject = new Label(group1,SWT.NULL);
		listProject = new Combo(group1,SWT.NULL | SWT.READ_ONLY);
		labelFile = new Label(group1,SWT.NULL);
		listFile = new Combo(group1,SWT.NULL | SWT.READ_ONLY);

		group2 = new Group(container,SWT.NULL);
		labelHost = new Label(group2,SWT.NULL);
		textHost = new Text(group2,SWT.BORDER | SWT.SINGLE);
		labelPort = new Label(group2,SWT.NULL);
		textPort = new Text(group2,SWT.BORDER | SWT.SINGLE);
		
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		GridData gd2 = new GridData(GridData.FILL_HORIZONTAL);
		
		group1.setLayoutData(gd);
		group2.setLayoutData(gd2);

		/*********************************
		 * Creation of FormData
		 ******************************* */
		
		FormData labelLData = AtlLauncherTools.createFormData(15,35,10,40);
		FormData textLData = AtlLauncherTools.createFormData(45,75,10,40); 
		FormData label2LData = AtlLauncherTools.createFormData(15,35,60,90);
		FormData text2LData = AtlLauncherTools.createFormData(45,75,60,90);
		
		FormLayout groupLayout = new FormLayout();

		/**********************
		 * Components of group1
		 **********************/

		group1.setText(Messages.getString("RemoteAtlTab.PROJECT")); //$NON-NLS-1$

		labelProject.setLayoutData(labelLData);
		labelProject.setText(Messages.getString("RemoteAtlTab.PROJECTNAME")); //$NON-NLS-1$

		listProject.setLayoutData(textLData);
		listProject.setItems(AtlLauncherTools.projectNames());
		
		listProject.addModifyListener(this);
		listProject.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				listFile.setItems(AtlLauncherTools.fileNames(listProject.getText()));
			}
		});
		
		labelFile.setLayoutData(label2LData);
		labelFile.setText(Messages.getString("RemoteAtlTab.ATLFILENAME")); //$NON-NLS-1$

		listFile.setLayoutData(text2LData);

		listFile.addModifyListener(this);
		
		group1.setLayout(groupLayout);
		group1.layout();
		
		/**********************
		 * Components of group2
		 **********************/

		group2.setText(Messages.getString("RemoteAtlTab.CONNECTIONPROPERTIES")); //$NON-NLS-1$

		labelHost.setLayoutData(labelLData);
		labelHost.setText(Messages.getString("RemoteAtlTab.HOSTNAME")); //$NON-NLS-1$

		textHost.setLayoutData(textLData);
		textHost.addModifyListener(this);
		
		labelPort.setLayoutData(label2LData);
		labelPort.setText(Messages.getString("RemoteAtlTab.PORT")); //$NON-NLS-1$

		textPort.setLayoutData(text2LData);
		textPort.addModifyListener(this);
		
		group2.setLayout(groupLayout);
		group2.layout();

		group1.pack();
		group2.pack();
		
		container.layout();
		container.pack();
		setControl(container);
		canSave();
	}
	
	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}
	
	/**
	 * Display the configuration saved
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			listProject.setText(configuration.getAttribute(AtlLauncherTools.PROJECTNAME, "")); //$NON-NLS-1$
			listFile.setText(configuration.getAttribute(AtlLauncherTools.ATLFILENAME, "")); //$NON-NLS-1$
			textPort.setText(configuration.getAttribute(AtlLauncherTools.PORT, "")); //$NON-NLS-1$
			textHost.setText(configuration.getAttribute(AtlLauncherTools.HOST, "")); //$NON-NLS-1$
			canSave();
			updateLaunchConfigurationDialog();
		}
		catch (CoreException e) {
			listProject.setText(""); //$NON-NLS-1$
			listFile.setText(""); //$NON-NLS-1$
			textPort.setText(""); //$NON-NLS-1$
			textHost.setText(""); //$NON-NLS-1$
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
		}
	}
	
	/**
	 * When the button "Apply" is pushed, this method is launched
	 * The configuration is saved.
	 * INPUT, OUTPUT and PATH
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(AtlLauncherTools.PROJECTNAME, listProject.getText());
		configuration.setAttribute(AtlLauncherTools.ATLFILENAME, listFile.getText());
		configuration.setAttribute(AtlLauncherTools.PORT, textPort.getText());
		configuration.setAttribute(AtlLauncherTools.HOST, textHost.getText());
	}

	/**
	 * Returns the name of the tab
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return AtlLauncherTools.REMOTEATLNAME;
	}

	/**
	 * @see ILaunchConfigurationTab#canSave()
	 */
	public boolean canSave() {
		if (listProject.getText().equals("")) { //$NON-NLS-1$
			this.setErrorMessage(Messages.getString("RemoteAtlTab.GIVEPROJECTNAME")); //$NON-NLS-1$
			return false;
		}
		if (listFile.getText().equals("")) { //$NON-NLS-1$
			this.setErrorMessage(Messages.getString("RemoteAtlTab.GIVETRANSFORMATIONNAME")); //$NON-NLS-1$
			return false;
		}
		try {
			if (!textPort.getText().equals("")) //$NON-NLS-1$
				Integer.parseInt(textPort.getText());
		}
		catch (NumberFormatException nfe) {
			setErrorMessage(Messages.getString("RemoteAtlTab.PORTNOTINTEGER")); //$NON-NLS-1$
			return false;
		}
		
		this.setErrorMessage(null);
		return true;
	}

	public Image getImage() {
		return AtlLauncherTools.createImage(AtlLauncherTools.PATHICONATL);
	}

	/**
	 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
	 */
	public void modifyText(ModifyEvent e) {
		canSave();
		updateLaunchConfigurationDialog();
	}
	
}
