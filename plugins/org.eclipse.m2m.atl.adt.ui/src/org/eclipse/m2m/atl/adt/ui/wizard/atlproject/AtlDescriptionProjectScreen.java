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
package org.eclipse.m2m.atl.adt.ui.wizard.atlproject;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.m2m.atl.adt.ui.Messages;
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
 * The ATL project screen page.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class AtlDescriptionProjectScreen extends WizardPage {

	private Composite container;

	private Text textProjectName;

	private Group groupProject;

	/**
	 * Constructor.
	 *
	 * @param selection the selection
	 */
	public AtlDescriptionProjectScreen(ISelection selection) {
		super("wizardPage"); //$NON-NLS-1$
		setTitle(Messages.getString("AtlDescriptionProjectScreen.1")); //$NON-NLS-1$
		setDescription(Messages.getString("AtlDescriptionProjectScreen.2")); //$NON-NLS-1$
		this.setPageComplete(false);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);

		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 1;
		layout.verticalSpacing = 9;

		/* Instanciation of all the components */

		groupProject = new Group(container, SWT.CENTER);
		groupProject.setText("ATL PROJECT"); //$NON-NLS-1$
		groupProject.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		layout = new GridLayout();
		layout.numColumns = 2;
		layout.verticalSpacing = 9;
		groupProject.setLayout(layout);

		new Label(groupProject, SWT.NULL).setText(Messages
				.getString("AtlDescriptionProjectScreen.3")); //$NON-NLS-1$
		textProjectName = new Text(groupProject, SWT.BORDER);
		textProjectName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		textProjectName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt) {
				textProjectNameKeyPressed(evt);
			}
		});

		container.layout();
		setControl(container);
	}

	public String getProjectName() {
		return textProjectName.getText();
	}

	/**
	 * When a key was released in textProjectName area, if textProjectName is empty this page is considered
	 * not complete else the page is considered complete. That is to say the button next is available.
	 *
	 * @param evt the key event
	 */
	protected void textProjectNameKeyPressed(KeyEvent evt) {
		if (textProjectName.getText().equals("")) { //$NON-NLS-1$
			this.setPageComplete(false);
		} else {
			this.setPageComplete(true);
		}
	}
}
