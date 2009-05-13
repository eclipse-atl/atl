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
package org.eclipse.m2m.atl.core.ui.launch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.m2m.atl.common.ATLLaunchConstants;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.core.service.CoreService;
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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * The "advanced" tab in ATL configurations.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class AdvancedTab extends AbstractLaunchConfigurationTab {

	/** Sets generated files as derived. */
	public static final String OPTION_DERIVED = "OPTION_DERIVED"; //$NON-NLS-1$

	/** Clears console after each launch. */
	public static final String OPTION_CLEAR = "OPTION_CLEAR"; //$NON-NLS-1$

	static final String SUPERIMPOSE = "SUPERIMPOSE"; //$NON-NLS-1$

	private Composite container;

	private Group groupSuperimpose;

	private Table tableSuperimpose;

	private Button buttonSuperimpose;

	private Button buttonRemoveSuperimpose;

	private Group groupOthersInformation;

	private Combo atlVMs;

	private Text debuggerPortText;

	private Map<String, Button> buttonArray = new HashMap<String, Button>();;

	private Map<String, String> baseOptions = new LinkedHashMap<String, String>();

	private Map<String, String> defaultValues = new HashMap<String, String>();

	{
		baseOptions.put(OPTION_DERIVED, "Set generated files as derived"); //$NON-NLS-1$
		baseOptions.put(OPTION_CLEAR, "Clear console before launch"); //$NON-NLS-1$
		defaultValues.put(OPTION_DERIVED, "true"); //$NON-NLS-1$
		defaultValues.put(OPTION_CLEAR, "false"); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {

		container = new Composite(parent, SWT.NULL);

		groupSuperimpose = new Group(container, SWT.NULL);
		buttonSuperimpose = new Button(groupSuperimpose, SWT.CENTER);
		tableSuperimpose = new Table(groupSuperimpose, SWT.FULL_SELECTION | SWT.BORDER);
		buttonRemoveSuperimpose = new Button(groupSuperimpose, SWT.CENTER);

		groupOthersInformation = new Group(container, SWT.NULL);

		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.makeColumnsEqualWidth = true;

		GridData gd3 = new GridData(GridData.FILL_HORIZONTAL);
		groupOthersInformation.setLayoutData(gd3);

		container.setLayout(layout);

		groupSuperimpose.setLayoutData(new GridData(GridData.FILL_BOTH));

		/*****************************************************************************************************
		 * GroupSuperimpose
		 ****************************************************************************************************/

		GridLayout groupLayout = new GridLayout();
		groupLayout.numColumns = 4;
		groupLayout.makeColumnsEqualWidth = true;

		groupSuperimpose.setLayout(groupLayout);

		groupSuperimpose.setText(Messages.getString("AdvancedTab.SUPERIMPOSE")); //$NON-NLS-1$

		buttonSuperimpose.setText(Messages.getString("AdvancedTab.ADD")); //$NON-NLS-1$
		buttonSuperimpose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				addPath(AdvancedTab.SUPERIMPOSE, tableSuperimpose);
				updateLaunchConfigurationDialog();
			}
		});

		// buttonRemoveSuperimpose.setImage(ATLCoreUIPlugin.getImage(ATLLaunchConstants.DELETE_ICON_PATH));
		buttonRemoveSuperimpose.setText(Messages.getString("AdvancedTab.REMOVE")); //$NON-NLS-1$
		buttonRemoveSuperimpose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				removePath(tableSuperimpose);
				updateLaunchConfigurationDialog();
			}
		});

		TableLayout tableLayout = new TableLayout();
		tableSuperimpose.setLayout(tableLayout);
		tableLayout.addColumnData(new ColumnWeightData(100));
		tableSuperimpose.setLinesVisible(true);
		tableSuperimpose.setHeaderVisible(true);

		// ModelChoiceTab.TABLELIBNAME
		TableColumn superimposeName = new TableColumn(tableSuperimpose, SWT.LEFT);
		superimposeName.setText(Messages.getString("AdvancedTab.SUPERIMPOSE")); //$NON-NLS-1$

		buttonSuperimpose.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		buttonRemoveSuperimpose.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.VERTICAL_ALIGN_BEGINNING));

		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 3;
		gd.verticalSpan = 3;
		tableSuperimpose.setLayoutData(gd);

		/*****************************************************************************************************
		 * Components of group3
		 ****************************************************************************************************/

		groupOthersInformation.setText(Messages.getString("MainAtlTab.OTHERSPARAMETERS")); //$NON-NLS-1$
		
		Composite groupATLVMs = new Composite(groupOthersInformation, SWT.SHADOW_NONE);
		Label atlVMLabel = new Label(groupATLVMs, SWT.NULL);
		atlVMLabel.setText(Messages.getString("AdvancedTab.ATLVM")); //$NON-NLS-1$
		atlVMLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		atlVMs = new Combo(groupATLVMs, SWT.NULL | SWT.READ_ONLY);
		atlVMs.setItems(CoreService.getLaunchersNames());
		atlVMs.select(0);
		atlVMs.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		atlVMs.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				buildCheckButtons();
				container.layout();
				updateLaunchConfigurationDialog();
			}
		});
		if (isDebug()) {			
			Label debuggerPortLabel = new Label(groupATLVMs, SWT.NULL);
			debuggerPortLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
			debuggerPortLabel.setText(Messages.getString("AdvancedTab.DEBUGGER_PORT")); //$NON-NLS-1$
			debuggerPortText = new Text(groupATLVMs, SWT.BORDER);
			debuggerPortText.setLayoutData(new GridData(GridData.BEGINNING));
			debuggerPortText.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					updateLaunchConfigurationDialog();
				}
			});
		}
		groupATLVMs.setLayout(new GridLayout(2, false));
		
		groupLayout = new GridLayout();
		groupLayout.numColumns = 1;
		groupLayout.makeColumnsEqualWidth = true;

		groupOthersInformation.setLayout(groupLayout);

		container.layout();
		container.pack();
		setControl(container);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#updateLaunchConfigurationDialog()
	 */
	@Override
	protected void updateLaunchConfigurationDialog() {
		if (getLaunchConfigurationDialog() != null) {
			ILaunchConfigurationTab[] tabs = getLaunchConfigurationDialog().getTabs();
			for (int i = 0; i < tabs.length; i++) {
				if (tabs[i] instanceof MainAtlTab) {
					MainAtlTab mainTab = (MainAtlTab)tabs[i];
					mainTab.launcherNameChanged(getLauncherName());
					mainTab.superimposedChanged(createSuperimposedList());
				}
			}
		}
		super.updateLaunchConfigurationDialog();
	}

	private Map<String, String> getCheckButtonsValues() {
		Map<String, String> options = new HashMap<String, String>();
		for (Iterator<String> iterator = buttonArray.keySet().iterator(); iterator.hasNext();) {
			String optionId = iterator.next();
			String optionValue = new Boolean(buttonArray.get(optionId).getSelection()).toString();
			options.put(optionId, optionValue);
		}
		return options;
	}

	private void buildCheckButtons() {
		for (Iterator<Button> iterator = buttonArray.values().iterator(); iterator.hasNext();) {
			iterator.next().dispose();
		}
		buttonArray = new HashMap<String, Button>();
		Map<String, String> options = new LinkedHashMap<String, String>();
		options.putAll(baseOptions);
		options.putAll(CoreService.getLauncherOptions(atlVMs.getItem(atlVMs.getSelectionIndex())));
		for (Iterator<Map.Entry<String, String>> iterator = options.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<String, String> option = iterator.next();
			final Button newCheckButton = new Button(groupOthersInformation, SWT.CHECK);
			newCheckButton.setLayoutData(new GridData(GridData.FILL_BOTH));
			newCheckButton.setText(option.getValue());
			newCheckButton.setSelection(getDefaultValue(option.getKey()));
			newCheckButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					updateLaunchConfigurationDialog();
				}
			});
			buttonArray.put(option.getKey(), newCheckButton);
		}
	}

	private boolean getDefaultValue(String key) {
		String value = defaultValues.get(key);
		if (value != null) {
			return new Boolean(value).booleanValue();
		}
		return false;
	}

	public String getName() {
		return Messages.getString("ATLLaunchConstants.ADVANCED"); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@SuppressWarnings("unchecked")
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			List<?> superimpose = configuration.getAttribute(ATLLaunchConstants.SUPERIMPOSE,
					Collections.EMPTY_LIST);

			tableSuperimpose.removeAll();
			for (Iterator<?> i = superimpose.iterator(); i.hasNext();) {
				String mName = (String)i.next();
				TableItem item = new TableItem(tableSuperimpose, SWT.NONE);
				item.setText(mName);
			}

			if (isDebug()) {
				String port = configuration.getAttribute(ATLLaunchConstants.PORT, Integer.valueOf(
						ATLLaunchConstants.DEFAULT_PORT).toString());
				debuggerPortText.setText(port);
			}

			for (int item = 0; item < atlVMs.getItems().length; item++) {
				if (atlVMs.getItem(item)
						.equals(
								configuration.getAttribute(ATLLaunchConstants.ATL_VM,
										ATLLaunchConstants.EMF_VM_NAME))) {
					atlVMs.select(item);
				}
			}

			defaultValues.putAll(configuration.getAttribute(ATLLaunchConstants.OPTIONS, Collections
					.<String, String> emptyMap()));
			buildCheckButtons();
		} catch (CoreException e) {
			tableSuperimpose.removeAll();
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	private List<String> createSuperimposedList() {
		List<String> superimpose = new ArrayList<String>();
		for (int i = 0; i < tableSuperimpose.getItemCount(); i++) {
			TableItem ti = tableSuperimpose.getItem(i);
			superimpose.add(ti.getText());
		}
		return superimpose;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		defaultValues = getCheckButtonsValues();
		configuration.setAttribute(ATLLaunchConstants.SUPERIMPOSE, createSuperimposedList());
		configuration.setAttribute(ATLLaunchConstants.OPTIONS, defaultValues);
		configuration.setAttribute(ATLLaunchConstants.ATL_VM, atlVMs.getItem(atlVMs.getSelectionIndex()));
		if (isDebug()) {
			configuration.setAttribute(ATLLaunchConstants.PORT, debuggerPortText.getText());
		}
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
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#canSave()
	 */
	@Override
	public boolean canSave() {
		if (isDebug()) {
			String port = debuggerPortText.getText();
			try {
				Integer.valueOf(port);
			} catch (NumberFormatException e) {
				this.setErrorMessage(Messages.getString("AdvancedTab.DEBUG_PORT")); //$NON-NLS-1$
				return false;
			}
		}
		if (tableSuperimpose.getItemCount() != 0) {
			for (int i = 0; i < tableSuperimpose.getItemCount(); i++) {
				if (tableSuperimpose.getItem(i).getText().equals("")) { //$NON-NLS-1$
					this.setErrorMessage(Messages.getString("AdvancedTab.GIVEPATHSUPERIMPOSE")); //$NON-NLS-1$
					return false;
				}
			}
		}
		this.setErrorMessage(null);
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
	 */
	@Override
	public Image getImage() {
		return ATLCoreUIPlugin.getImage(ATLLaunchConstants.ATL_ICON_PATH);
	}

	/**
	 * This method adds a path to the given table. The path corresponds to a file in the workspace
	 * 
	 * @param type
	 * @param table
	 */
	private void addPath(final String type, Table table) {
		ElementTreeSelectionDialog elementTreeSelectionDialog = new ElementTreeSelectionDialog(getShell(),
				new WorkbenchLabelProvider(), new WorkbenchContentProvider());
		elementTreeSelectionDialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		elementTreeSelectionDialog.setMessage(Messages.getString("AdvancedTab.CHOOSE")); //$NON-NLS-1$
		elementTreeSelectionDialog.setTitle(Messages.getString("AdvancedTab.CHOOSE")); //$NON-NLS-1$
		elementTreeSelectionDialog.setAllowMultiple(false);
		elementTreeSelectionDialog.setDoubleClickSelects(true);
		elementTreeSelectionDialog.addFilter(new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				boolean ret = false;

				if (element instanceof IContainer) {
					ret = true;
				} else if (element instanceof IFile) {
					IFile currentFile = (IFile)element;
					if (currentFile.getFileExtension() == null) {
						return false;
					}
					if (type == AdvancedTab.SUPERIMPOSE) {
						ret = (currentFile.getFileExtension().toUpperCase()).equals("ASM"); //$NON-NLS-1$
					} else {
						ret = true;
					}
				}
				return ret;
			}
		});
		elementTreeSelectionDialog.setValidator(new ISelectionStatusValidator() {
			public IStatus validate(Object[] selection) {
				IStatus ret = Status.CANCEL_STATUS;

				if (selection.length == 1) {
					if (selection[0] instanceof IFile) { // no need to verify again extension here
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
	 * Delete a path in the table.
	 * 
	 * @param table
	 */
	private void removePath(Table table) {
		int index = table.getSelectionIndex();
		if (index == -1) {
			messageBox(container.getShell(), Messages.getString("AdvancedTab.CHOOSEENTRY")); //$NON-NLS-1$
			return;
		}
		table.remove(index);
	}

	private String getLauncherName() {
		return atlVMs.getItem(atlVMs.getSelectionIndex());
	}

	/**
	 * Display a message box with the text in parameter.
	 * 
	 * @param shell
	 *            shell
	 * @param textToDisplay
	 *            the message
	 */
	public static void messageBox(Shell shell, String textToDisplay) {
		MessageBox msgBox = new MessageBox(shell, SWT.APPLICATION_MODAL | SWT.OK);
		msgBox.setText(Messages.getString("AdvancedTab.ERROR")); //$NON-NLS-1$
		msgBox.setMessage(textToDisplay);
		msgBox.open();
	}

	private boolean isDebug() {
		return getLaunchConfigurationDialog().getMode().equals(ILaunchManager.DEBUG_MODE);
	}
}
