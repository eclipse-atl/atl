/*
 * Created on 26 avr. 2004
 */
package org.atl.eclipse.adt.launching;

import org.atl.eclipse.adt.debug.Messages;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

/**
 * @author allilaire
 */
public class MainAtlTab extends AbstractLaunchConfigurationTab implements ModifyListener, SelectionListener {
	
	private Composite container;

	private Group groupGeneralInformation;
	private Combo listProject;
	private Label labelProject;
	private Combo listFile;
	private Label labelFile;
		
	private Group groupOthersInformation;
//	private Combo listModelHandler;
//	private Label labelModelHandler;
	private Button buttonModeDebug;
	private Button buttonAllowInterModelReferences;
	
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);

		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 1;
		layout.verticalSpacing = 9;
		layout.makeColumnsEqualWidth = true;

		groupGeneralInformation = new Group(container,SWT.NULL);
		labelProject = new Label(groupGeneralInformation,SWT.NULL);
		listProject = new Combo(groupGeneralInformation,SWT.NULL | SWT.READ_ONLY);
		labelFile = new Label(groupGeneralInformation,SWT.NULL);
		listFile = new Combo(groupGeneralInformation,SWT.NULL | SWT.READ_ONLY);

		groupOthersInformation = new Group(container,SWT.NULL);
//		labelModelHandler = new Label(groupOthersInformation,SWT.NULL);
//		listModelHandler = new Combo(groupOthersInformation, SWT.NULL | SWT.READ_ONLY);
		buttonModeDebug = new Button(groupOthersInformation,SWT.CHECK);
		buttonAllowInterModelReferences = new Button(groupOthersInformation, SWT.CHECK);
		
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		GridData gd3 = new GridData(GridData.FILL_HORIZONTAL);
		
		groupGeneralInformation.setLayoutData(gd);
		groupOthersInformation.setLayoutData(gd3);

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

		groupGeneralInformation.setText(Messages.getString("MainAtlTab.PROJECT")); //$NON-NLS-1$

		labelProject.setLayoutData(labelLData);
		labelProject.setText(Messages.getString("MainAtlTab.PROJECTNAME")); //$NON-NLS-1$

		listProject.setLayoutData(textLData);
		listProject.setItems(AtlLauncherTools.projectNames());
		
		listProject.addModifyListener(this);
		listProject.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				listFile.setItems(AtlLauncherTools.fileNames(listProject.getText()));
			}
		});
		
		labelFile.setLayoutData(label2LData);
		labelFile.setText(Messages.getString("MainAtlTab.ATLFILENAME")); //$NON-NLS-1$

		listFile.setLayoutData(text2LData);

		listFile.addModifyListener(this);
		
		groupGeneralInformation.setLayout(groupLayout);
		groupGeneralInformation.layout();
		
		/**********************
		 * Components of group3
		 **********************/

		groupOthersInformation.setText(Messages.getString("MainAtlTab.OTHERSPARAMETERS")); //$NON-NLS-1$

		buttonAllowInterModelReferences.setLayoutData(labelLData);
		buttonAllowInterModelReferences.setText("Allow inter-model references");
		buttonAllowInterModelReferences.setSelection(true);
		buttonAllowInterModelReferences.addSelectionListener(this);

		buttonModeDebug.setLayoutData(label2LData);
		buttonModeDebug.setText(Messages.getString("MainAtlTab.MODEDEBUG")); //$NON-NLS-1$
		buttonModeDebug.addSelectionListener(this);
		
		groupOthersInformation.setLayout(groupLayout);
		groupOthersInformation.layout();
		
		groupGeneralInformation.pack();
		groupOthersInformation.pack();
		
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
			listProject.setText(configuration.getAttribute(AtlLauncherTools.PROJECTNAME, ""));
			listFile.setText(configuration.getAttribute(AtlLauncherTools.ATLFILENAME, ""));
//			listModelHandler.setText(configuration.getAttribute(AtlLauncherTools.MODELHANDLER, ""));
			buttonModeDebug.setSelection(configuration.getAttribute(AtlLauncherTools.MODEDEBUG, false));
			buttonAllowInterModelReferences.setSelection(configuration.getAttribute(AtlLauncherTools.AllowInterModelReferences, true));
			canSave();
			updateLaunchConfigurationDialog();
		}
		catch (CoreException e) {
			listProject.setText("");
			listFile.setText("");
//			listModelHandler.setText("");
			buttonModeDebug.setSelection(false);
			buttonAllowInterModelReferences.setSelection(true);
			e.printStackTrace();
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
		configuration.setAttribute(AtlLauncherTools.AllowInterModelReferences, buttonAllowInterModelReferences.getSelection());
		configuration.setAttribute(AtlLauncherTools.MODEDEBUG, buttonModeDebug.getSelection());
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
		if (listProject.getText().equals("")) {
			this.setErrorMessage(Messages.getString("MainAtlTab.GIVEPROJECTNAME")); //$NON-NLS-1$
			return false;
		}
		if (listFile.getText().equals("")) {
			this.setErrorMessage(Messages.getString("MainAtlTab.GIVETRANSFORMATIONNAME")); //$NON-NLS-1$
			return false;
		}
//		if (listModelHandler.getText().equals("")) {
//			this.setErrorMessage(Messages.getString("MainAtlTab.GIVEMODELHANLER")); //$NON-NLS-1$
//			return false;
//		}
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
	
}
