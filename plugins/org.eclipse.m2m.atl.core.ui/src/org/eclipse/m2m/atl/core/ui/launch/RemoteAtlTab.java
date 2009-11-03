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
package org.eclipse.m2m.atl.core.ui.launch;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.m2m.atl.adt.ui.common.WorkspaceFileDialog;
import org.eclipse.m2m.atl.common.ATLLaunchConstants;
import org.eclipse.m2m.atl.core.ui.ATLCoreUIPlugin;
import org.eclipse.m2m.atl.core.ui.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * The remote ATL tab.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class RemoteAtlTab extends AbstractLaunchConfigurationTab implements ModifyListener {

	private Text textAtlFile;

	private Text textHost;

	private Text textPort;

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new GridLayout());

		Group moduleGroup = new Group(container, SWT.NULL);
		moduleGroup.setLayout(new GridLayout(2, false));
		moduleGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		moduleGroup.setText(Messages.getString("MainAtlTab.ATL_MODULE")); //$NON-NLS-1$

		textAtlFile = new Text(moduleGroup, SWT.SINGLE | SWT.BORDER);
		textAtlFile.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		final Button browseWorkspace = new Button(moduleGroup, SWT.RIGHT);
		browseWorkspace.setText(Messages.getString("MainAtlTab.WORKSPACE")); //$NON-NLS-1$
		browseWorkspace.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				WorkspaceFileDialog dialog = new WorkspaceFileDialog(getShell(),
						ATLLaunchConstants.ATL_EXTENSIONS);
				dialog.open();
				Object result = dialog.getFirstResult();
				String ret = ""; //$NON-NLS-1$
				if (result != null && result instanceof IFile) {
					IFile currentFile = (IFile)result;
					ret = currentFile.getFullPath().toString();
				}
				textAtlFile.setText(ret);
			}
		});

		textAtlFile.addModifyListener(this);

		Group connectionGroup = new Group(container, SWT.NULL);
		connectionGroup.setLayout(new GridLayout(2, false));
		connectionGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		connectionGroup.setText(Messages.getString("RemoteAtlTab.CONNECTION_PROPERTIES")); //$NON-NLS-1$

		Label labelHost = new Label(connectionGroup, SWT.NULL);
		labelHost.setText(Messages.getString("RemoteAtlTab.HOST")); //$NON-NLS-1$

		textHost = new Text(connectionGroup, SWT.SINGLE | SWT.BORDER);
		textHost.addModifyListener(this);
		textHost.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Label labelPort = new Label(connectionGroup, SWT.NULL);
		labelPort.setText(Messages.getString("RemoteAtlTab.PORT")); //$NON-NLS-1$

		textPort = new Text(connectionGroup, SWT.SINGLE | SWT.BORDER);
		textPort.addModifyListener(this);
		textPort.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		canSave();
		setControl(container);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			textAtlFile.setText(configuration.getAttribute(ATLLaunchConstants.ATL_FILE_NAME, "")); //$NON-NLS-1$
			textPort.setText(configuration.getAttribute(ATLLaunchConstants.PORT, "")); //$NON-NLS-1$
			textHost.setText(configuration.getAttribute(ATLLaunchConstants.HOST, "")); //$NON-NLS-1$
			canSave();
			updateLaunchConfigurationDialog();
		} catch (CoreException e) {
			textAtlFile.setText(""); //$NON-NLS-1$
			textPort.setText(""); //$NON-NLS-1$
			textHost.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ATLLaunchConstants.ATL_FILE_NAME, textAtlFile.getText());
		configuration.setAttribute(ATLLaunchConstants.PORT, textPort.getText());
		configuration.setAttribute(ATLLaunchConstants.HOST, textHost.getText());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return Messages.getString("RemoteAtlTab.ATL_REMOTE_CONFIGURATION"); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
	 */
	@Override
	public Image getImage() {
		return ATLCoreUIPlugin.getImage("atl_remote.gif"); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#canSave()
	 */
	@Override
	public boolean canSave() {
		if (textAtlFile.getText().equals("")) { //$NON-NLS-1$
			this.setErrorMessage(Messages.getString("RemoteAtlTab.SET_TRANSFORMATION")); //$NON-NLS-1$
			return false;
		}
		try {
			if (!textPort.getText().equals("")) { //$NON-NLS-1$
				Integer.parseInt(textPort.getText());
			}
		} catch (NumberFormatException nfe) {
			setErrorMessage(Messages.getString("RemoteAtlTab.PORT_NOT_INTEGER")); //$NON-NLS-1$
			return false;
		}
		this.setErrorMessage(null);
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
	 */
	public void modifyText(ModifyEvent e) {
		canSave();
		updateLaunchConfigurationDialog();
	}

}
