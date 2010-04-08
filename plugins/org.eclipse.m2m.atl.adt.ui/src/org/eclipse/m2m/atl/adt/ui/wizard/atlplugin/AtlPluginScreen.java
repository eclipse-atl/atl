/*******************************************************************************
 * Copyright (c) 2009, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.wizard.atlplugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.m2m.atl.adt.runner.CreateRunnableData;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.Messages;
import org.eclipse.m2m.atl.adt.ui.common.RegisteredPackageDialog;
import org.eclipse.m2m.atl.adt.ui.common.WorkspaceFileDialog;
import org.eclipse.m2m.atl.common.ATLLaunchConstants;
import org.eclipse.m2m.atl.core.service.CoreService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * The ATL plugin initialization wizard page.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlPluginScreen extends WizardPage {

	private static final String METAMETAMODEL_ID = "#EMF"; //$NON-NLS-1$

	private IFile defaultAtlFile;

	private CreateRunnableData runnableData;

	private Composite container;

	private Composite paramsComposite;

	private Button initFromFile;

	private Button initFromConfig;

	private Text fileText;

	private Combo configChoice;

	/**
	 * Constructor.
	 * 
	 * @param atlFile
	 *            the selected file if present.
	 */
	public AtlPluginScreen(IFile atlFile) {
		super(Messages.getString("AtlPluginScreen.Page.Name")); //$NON-NLS-1$
		setTitle(Messages.getString("AtlPluginScreen.Title")); //$NON-NLS-1$
		setDescription(Messages.getString("AtlPluginScreen.Page.Description")); //$NON-NLS-1$
		setImageDescriptor(AtlUIPlugin.getImageDescriptor("ATLWizard.png")); //$NON-NLS-1$
		this.defaultAtlFile = atlFile;
		this.setPageComplete(false);
		this.runnableData = new CreateRunnableData();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		initializeDialogUnits(container);
		container.setLayout(new GridLayout(3, false));
		container.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		initFromFile = new Button(container, SWT.RADIO);
		initFromFile.setLayoutData(new GridData(GridData.BEGINNING));
		initFromFile.setText(Messages.getString("AtlPluginScreen.INIT_FROM_FILE")); //$NON-NLS-1$

		fileText = new Text(container, SWT.BORDER);
		fileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		final Button fileButton = createButton(container, Messages.getString("AtlPluginScreen.WORKSPACE")); //$NON-NLS-1$

		initFromConfig = new Button(container, SWT.RADIO);
		initFromConfig.setText(Messages.getString("AtlPluginScreen.INIT_FROM_CONFIG")); //$NON-NLS-1$

		configChoice = new Combo(container, SWT.NULL);
		configChoice.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		for (int i = 0; i < getConfigurations().length; i++) {
			ILaunchConfiguration config = getConfigurations()[i];
			configChoice.add(config.getName());
		}
		GridData data;

		paramsComposite = new Composite(container, SWT.NULL);
		paramsComposite.setLayout(new GridLayout(1, false));
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 3;
		paramsComposite.setLayoutData(data);

		// listeners
		initFromFile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean enabled = initFromFile.getSelection();
				fileText.setEnabled(enabled);
				fileButton.setEnabled(enabled);
				if (enabled) {
					try {
						runnableData.load(fileText.getText().trim());
					} catch (IOException e1) {
						throw new RuntimeException(e1);
					} catch (CoreException e1) {
						throw new RuntimeException(e1);
					}
					updateFromParameters();
				}
				checkValid();
				super.widgetSelected(e);
			}
		});
		fileText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				try {
					runnableData.load(fileText.getText().trim());
				} catch (IOException e1) {
					throw new RuntimeException(e1);
				} catch (CoreException e1) {
					throw new RuntimeException(e1);
				}
				updateFromParameters();
				checkValid();
			}
		});
		fileButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				WorkspaceFileDialog dialog = new WorkspaceFileDialog(getShell(), "atl"); //$NON-NLS-1$
				dialog.open();
				Object result = dialog.getFirstResult();
				if ((result != null) && (result instanceof IFile)) {
					IFile currentFile = (IFile)result;
					fileText.setText(currentFile.getFullPath().toString());
				}
				super.widgetSelected(e);
			}
		});

		initFromConfig.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean enabled = initFromConfig.getSelection();
				configChoice.setEnabled(enabled);
				if (enabled) {
					try {
						ILaunchConfiguration configuration = getConfiguration(configChoice.getText());
						if (configuration != null) {
							runnableData.load(configuration);
						}
					} catch (IOException e1) {
						throw new RuntimeException(e1);
					} catch (CoreException e1) {
						throw new RuntimeException(e1);
					}
					updateFromParameters();
				}
				checkValid();
				super.widgetSelected(e);
			}
		});
		configChoice.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				try {
					ILaunchConfiguration configuration = getConfiguration(configChoice.getText());
					if (configuration != null) {
						runnableData.load(configuration);
					}
				} catch (IOException e1) {
					throw new RuntimeException(e1);
				} catch (CoreException e1) {
					throw new RuntimeException(e1);
				}
				updateFromParameters();
				checkValid();
			}
		});

		if (defaultAtlFile == null) {
			initFromConfig.setSelection(true);
		} else {
			fileText.setText(defaultAtlFile.getFullPath().toString());
			initFromFile.setSelection(true);
		}
		fileText.setEnabled(initFromFile.getSelection());
		fileButton.setEnabled(initFromFile.getSelection());
		configChoice.setEnabled(initFromConfig.getSelection());

		checkValid();
		container.layout();
		setControl(container);
	}

	public CreateRunnableData getRunnableData() {
		return runnableData;
	}

	private void updateFromParameters() {
		for (Control control : paramsComposite.getChildren()) {
			control.dispose();
		}
		for (String metamodelName : runnableData.getAllMetamodelsNames()) {
			String metamodelLocation = null;
			if (runnableData.getMetamodelLocations().containsKey(metamodelName)) {
				metamodelLocation = runnableData.getMetamodelLocations().get(metamodelName);
			}
			createMetamodelControl(paramsComposite, metamodelName, metamodelLocation);
		}
		for (String libraryName : runnableData.getAllLibrariesNames()) {
			createLibraryControl(paramsComposite, libraryName, runnableData.getLibraryLocations().get(
					libraryName));
		}

		Shell shell = getShell();
		Point shellSize = shell.getSize();
		int height = shell.computeSize(SWT.DEFAULT, SWT.DEFAULT, true).y;
		shell.setSize(shellSize.x, height);

		paramsComposite.layout();
		container.layout();
	}

	private Group createMetamodelControl(Composite parent, final String metamodelName,
			String metamodelLocation) {
		Group group = new Group(parent, SWT.NULL);

		group.setText(Messages.getString("AtlPluginScreen.METAMODEL", metamodelName)); //$NON-NLS-1$
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		group.setLayout(new GridLayout(4, false));

		final Label locationLabel = new Label(group, SWT.NULL);
		locationLabel.setText(Messages.getString("AtlPluginScreen.LOCATION")); //$NON-NLS-1$

		final Text locationText = new Text(group, SWT.BORDER);
		locationText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		if (metamodelLocation != null) {
			locationText.setText(metamodelLocation);
		}

		final Button browseEMFRegistry = new Button(group, SWT.NULL);
		browseEMFRegistry.setText(Messages.getString("AtlPluginScreen.BROWSE")); //$NON-NLS-1$

		final Button isMMMButton = new Button(group, SWT.CHECK);
		isMMMButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		isMMMButton.setText(Messages.getString("AtlPluginScreen.IS_METAMETA")); //$NON-NLS-1$

		locationText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				runnableData.updateMetamodelLocation(metamodelName, locationText.getText());
				checkValid();
			}
		});

		browseEMFRegistry.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				RegisteredPackageDialog dialog = new RegisteredPackageDialog(getShell());
				dialog.setRuntimeOnly(true);
				if (dialog.open() == Dialog.OK) {
					locationText.setText(dialog.getResultAsString());
				}
			}
		});

		isMMMButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean isMetametamodel = isMMMButton.getSelection();
				browseEMFRegistry.setEnabled(!isMetametamodel);
				locationLabel.setEnabled(!isMetametamodel);
				locationText.setEnabled(!isMetametamodel);
				if (isMetametamodel) {
					runnableData.updateMetamodelLocation(metamodelName, METAMETAMODEL_ID);
				} else {
					runnableData.updateMetamodelLocation(metamodelName, locationText.getText());
				}
				checkValid();
				super.widgetSelected(e);
			}
		});

		if (metamodelLocation != null && metamodelLocation.equals(METAMETAMODEL_ID)) {
			isMMMButton.setSelection(true);
			browseEMFRegistry.setEnabled(false);
			locationLabel.setEnabled(false);
			locationText.setEnabled(false);
			runnableData.updateMetamodelLocation(metamodelName, METAMETAMODEL_ID);
		}

		return group;
	}

	private Group createLibraryControl(Composite parent, final String libraryName, String libraryLocation) {
		Group group = new Group(parent, SWT.NULL);
		group.setText(Messages.getString("AtlPluginScreen.LIBRARY", libraryName)); //$NON-NLS-1$
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		group.setLayout(new GridLayout(3, false));

		final Label locationLabel = new Label(group, SWT.NULL);
		locationLabel.setText(Messages.getString("AtlPluginScreen.LOCATION")); //$NON-NLS-1$

		final Text locationText = new Text(group, SWT.BORDER);
		locationText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		if (libraryLocation != null) {
			locationText.setText(libraryLocation);
		}

		final Button browseWorkspace = new Button(group, SWT.NULL);
		browseWorkspace.setText(Messages.getString("AtlPluginScreen.BROWSE")); //$NON-NLS-1$

		locationText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				runnableData.updateLibraryLocation(libraryName, locationText.getText());
				checkValid();
			}
		});

		browseWorkspace.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				WorkspaceFileDialog dialog = new WorkspaceFileDialog(getShell(), "asm"); //$NON-NLS-1$
				dialog.open();
				Object result = dialog.getFirstResult();
				if ((result != null) && (result instanceof IFile)) {
					IFile currentFile = (IFile)result;
					locationText.setText(currentFile.getFullPath().toString());
				}
			}
		});

		return group;
	}

	private Button createButton(Composite parent, String text) {
		Button button = new Button(parent, SWT.PUSH);
		button.setAlignment(SWT.CENTER);
		button.setText(text);
		button.setFont(parent.getFont());
		GridData data = new GridData();
		data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.BUTTON_WIDTH);
		button.setLayoutData(data);
		return button;
	}

	/**
	 * Returns the list of the configurations.
	 * 
	 * @return the list of the configurations
	 */
	private static ILaunchConfiguration[] getConfigurations() {
		List<ILaunchConfiguration> res = new ArrayList<ILaunchConfiguration>();
		if (CoreService.isEclipseRunning()) {
			try {
				ILaunchConfiguration[] configs = DebugPlugin.getDefault().getLaunchManager()
						.getLaunchConfigurations();
				for (int i = 0; i < configs.length; i++) {
					ILaunchConfiguration config = configs[i];
					if (config.getType().getIdentifier().equals(ATLLaunchConstants.LAUNCH_CONFIGURATION_TYPE)) {
						res.add(config);
					}
				}
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
		return res.toArray(new ILaunchConfiguration[res.size()]);
	}

	/**
	 * Returns the configurations with the given name.
	 * 
	 * @return the configuration
	 */
	private static ILaunchConfiguration getConfiguration(String name) throws CoreException {
		ILaunchConfiguration[] configs = DebugPlugin.getDefault().getLaunchManager()
				.getLaunchConfigurations();
		for (int i = 0; i < configs.length; i++) {
			ILaunchConfiguration config = configs[i];
			if (config.getName().equals(name)) {
				return config;
			}
		}
		return null;
	}

	private void checkValid() {
		String errorMessage = null;
		String message = null;

		// Check for unset values
		if (initFromFile.getSelection()
				&& (fileText.getText() == null || "".equals(fileText.getText().trim()))) { //$NON-NLS-1$
			message = Messages.getString("AtlPluginScreen.UNSET_FILE"); //$NON-NLS-1$
		} else if (initFromConfig.getSelection()
				&& (configChoice.getText() == null || "".equals(configChoice.getText().trim()))) { //$NON-NLS-1$
			message = Messages.getString("AtlPluginScreen.UNSET_CONFIG"); //$NON-NLS-1$
			
		} else if (runnableData.getTransformationFiles() == null
				|| runnableData.getTransformationFiles().length == 0) {
			if (!initFromConfig.getSelection()) {
				errorMessage = Messages.getString("AtlPluginScreen.INVALID_FILE") + fileText.getText(); //$NON-NLS-1$
			} else {
				errorMessage = Messages.getString("AtlPluginScreen.INVALID_CONFIGURATION"); //$NON-NLS-1$
			}
		} else {
			// Check for transformations files validity
			for (IFile file : runnableData.getTransformationFiles()) {
				if (!file.isAccessible()) {
					errorMessage = Messages.getString("AtlPluginScreen.INVALID_FILE") + file.getFullPath(); //$NON-NLS-1$
				}
			}
			if (errorMessage == null) {
				// Check for main transformation validity
				if (!("Module".equals(runnableData.getFileType()) || "Query".equals(runnableData.getFileType()))) { //$NON-NLS-1$ //$NON-NLS-2$
					errorMessage = Messages.getString("AtlPluginScreen.CANNOT_LAUNCH"); //$NON-NLS-1$
				} else {
					List<String> missingLocations = new ArrayList<String>();
					for (Iterator<String> iterator = runnableData.getAllMetamodelsNames().iterator(); iterator
							.hasNext();) {
						String name = iterator.next();
						String location = runnableData.getMetamodelLocations().get(name);
						if (location == null || "".equals(location.trim())) { //$NON-NLS-1$
							missingLocations.add(name);
						}
					}
					for (Iterator<String> iterator = runnableData.getAllLibrariesNames().iterator(); iterator
							.hasNext();) {
						String name = iterator.next();
						String location = runnableData.getLibraryLocations().get(name);
						if (location == null || "".equals(location.trim())) { //$NON-NLS-1$
							missingLocations.add(name);
						} else {
							IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(
									new Path(location));
							if (resource == null || !resource.isAccessible()) {
								errorMessage = Messages.getString("AtlPluginScreen.UNABLE_TO_ACCESS_LIB") + location; //$NON-NLS-1$
							}
						}
					}
					if (errorMessage == null && !missingLocations.isEmpty()) {
						message = Messages.getString("AtlPluginScreen.INVALID_LOCATION"); //$NON-NLS-1$
						for (Iterator<String> iterator = missingLocations.iterator(); iterator.hasNext();) {
							String string = iterator.next();
							message += string;
							if (iterator.hasNext()) {
								message += ", "; //$NON-NLS-1$
							}
						}
					}
				}
			}
		}

		setErrorMessage(errorMessage);
		setMessage(message, IMessageProvider.INFORMATION);
		setPageComplete(message == null && errorMessage == null);
	}

}
