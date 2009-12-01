/*******************************************************************************
 * Copyright (c) 2009 Ecole des Mines de Nantes.

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kelly Garces - initial API and implementation and/or initial documentation
 *******************************************************************************/ 

package org.eclipse.m2m.atl.research.aml.wizard;

import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


/**
 * 
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a>
 *
 */
public class AmlProjectWizardPage extends WizardPage {

//	private ISelection selection;
	private Composite container;
	private Text textProjectName;

	private Group groupProject;
	
	/**
	 * Constructor
	 */
	public AmlProjectWizardPage(ISelection selection) {
		super("wizardPage");
		setTitle("AML Matching Project");
		setDescription("A name is required for your project");
//		this.selection = selection;
		this.setPageComplete(false);
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 * In this method, the GUI is created
	 */
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);

		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 1;
		layout.verticalSpacing = 9;
		
		/* Instantiation of all the components */

		groupProject = new Group(container,SWT.CENTER);
		groupProject.setText("AML MATCHING PROJECT");
		groupProject.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		layout = new GridLayout();
		layout.numColumns = 2;
		layout.verticalSpacing = 9;
		groupProject.setLayout(layout);

		new Label(groupProject,SWT.NULL).setText("Project and Strategy name");
		textProjectName = new Text(groupProject,SWT.BORDER);
		textProjectName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		textProjectName.addKeyListener( new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				validate();
			}
		});


		container.layout();
		setControl(container);
	}

	public String getProjectName() {
		return textProjectName.getText();
	}
	
	private void validate() {
		boolean isPageComplete = false;

		if (textProjectName.getText().equals("")) {
			setErrorMessage("Enter a project name");		
		} else {
			isPageComplete = true;
			setErrorMessage(null);
		}

		this.setPageComplete(isPageComplete);
	}
}
