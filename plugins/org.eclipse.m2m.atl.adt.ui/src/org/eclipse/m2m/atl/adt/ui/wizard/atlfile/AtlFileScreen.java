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
package org.eclipse.m2m.atl.adt.ui.wizard.atlfile;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.Messages;
import org.eclipse.m2m.atl.adt.ui.common.AbstractAtlSelection;
import org.eclipse.m2m.atl.adt.ui.common.AtlLibrarySelection;
import org.eclipse.m2m.atl.adt.ui.common.AtlModelSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

/**
 * The ATL file wizard page.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlFileScreen extends WizardPage {

	/** ATL Module name. */
	public static final String UNIT_NAME = "NAME"; //$NON-NLS-1$

	/** ATL File type. */
	public static final String UNIT_TYPE = "TYPE"; //$NON-NLS-1$

	/** The atl module file type. */
	public static final String TYPE_MODULE = "module"; //$NON-NLS-1$

	/** The atl module file type. */
	public static final String TYPE_REFINING_MODULE = "refining module"; //$NON-NLS-1$

	/** The atl query file type. */
	public static final String TYPE_QUERY = "query"; //$NON-NLS-1$

	/** The library file type. */
	public static final String TYPE_LIBRARY = "library"; //$NON-NLS-1$

	/** Paths map. */
	private Map<String, String> paths = new HashMap<String, String>();

	private Text textName;

	private Combo comboType;

	private Map<String, String> libraries = new LinkedHashMap<String, String>();

	private Map<String, String> input = new LinkedHashMap<String, String>();

	private Map<String, String> output = new LinkedHashMap<String, String>();

	private Button launchButton;

	private List inputList;

	private List outputList;

	private List libList;

	/**
	 * Constructor.
	 * 
	 * @param selection
	 *            the selection interface.
	 */
	public AtlFileScreen(ISelection selection) {
		super(Messages.getString("AtlFileScreen.Page.Name")); //$NON-NLS-1$
		setTitle(Messages.getString("AtlFileScreen.Title")); //$NON-NLS-1$
		setDescription(Messages.getString("AtlFileScreen.Page.Description")); //$NON-NLS-1$
		setImageDescriptor(AtlUIPlugin.getImageDescriptor("ATLWizard.png")); //$NON-NLS-1$
		this.setPageComplete(false);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		initializeDialogUnits(container);
		GridData data = new GridData(GridData.FILL_BOTH);
		container.setLayoutData(data);
		GridLayout layout = new GridLayout(3, false);
		container.setLayout(layout);

		// Module name
		new Label(container, SWT.NULL).setText(Messages.getString("AtlFileScreen.MODULE_NAME")); //$NON-NLS-1$
		textName = new Text(container, SWT.BORDER);
		textName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				checkValid();
			}
		});
		data = new GridData(GridData.FILL_HORIZONTAL | GridData.BEGINNING);
		textName.setLayoutData(data);
		addBlank(container);

		// File type
		new Label(container, SWT.NULL).setText(Messages.getString("AtlFileScreen.FILE_TYPE")); //$NON-NLS-1$
		comboType = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
		comboType.setItems(new String[] {TYPE_MODULE, TYPE_REFINING_MODULE, TYPE_LIBRARY, TYPE_QUERY});
		comboType.setText(TYPE_MODULE);
		data = new GridData(GridData.FILL_HORIZONTAL | GridData.BEGINNING);
		comboType.setLayoutData(data);
		addBlank(container);

		addSeparator(container);

		// Input / Output models
		data = new GridData(GridData.FILL_BOTH | GridData.VERTICAL_ALIGN_BEGINNING);
		inputList = createModelControl(
				container,
				Messages.getString("AtlFileScreen.InputModels"), //$NON-NLS-1$ 
				new AtlModelSelection(container.getShell(), Messages
						.getString("AtlFileScreen.InputModelCreation"), "IN", input, output, paths), data, input); //$NON-NLS-1$ //$NON-NLS-2$ 
		outputList = createModelControl(
				container,
				Messages.getString("AtlFileScreen.OutputModels"),//$NON-NLS-1$ 
				new AtlModelSelection(container.getShell(), Messages
						.getString("AtlFileScreen.OutputModelCreation"), "OUT", input, output, paths), data, output); //$NON-NLS-1$ //$NON-NLS-2$ 
		addSeparator(container);

		// Libraries
		data = new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_BEGINNING);
		data.heightHint = 40;
		libList = createLibControl(container, new AtlLibrarySelection(container.getShell(), Messages
				.getString("AtlFileScreen.ATLLibraryCreation"), libraries), data); //$NON-NLS-1$ 

		addSeparator(container);

		// Launch configuration
		final Label launchLabel = new Label(container, SWT.NULL);
		launchLabel.setText(Messages.getString("AtlFileScreen.CreateLc")); //$NON-NLS-1$
		data = new GridData();
		data.verticalIndent = 5;
		data.horizontalSpan = 3;
		launchLabel.setLayoutData(data);
		addBlank(container);
		launchButton = new Button(container, SWT.CHECK);
		launchButton.setText(Messages.getString("AtlFileScreen.CreateLcCheck")); //$NON-NLS-1$
		launchButton.setSelection(true);
		launchButton.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));

		comboType.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				boolean isLibrary = comboType.getText().equals(TYPE_LIBRARY);
				launchLabel.setEnabled(!isLibrary);
				launchButton.setEnabled(!isLibrary);
				launchButton.setSelection(!isLibrary);
				checkValid();
			}
		});

		container.layout();
		setControl(container);
	}

	private static String getEntryNameFromItem(String item) {
		return item.split(" : ")[0]; //$NON-NLS-1$
	}

	private void addBlank(Composite container) {
		Composite blank = new Composite(container, SWT.NULL);
		blank.setLayout(new GridLayout());
	}

	private void addSeparator(Composite container) {
		Label separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 3;
		data.verticalIndent = 5;
		separator.setLayoutData(data);
	}

	private List createModelControl(final Composite parent, final String entryLabel,
			final AbstractAtlSelection dialog, GridData listLayoutData, final Map<String, String> dataMap) {
		final Label typeLabel = new Label(parent, SWT.NONE);
		GridData data = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		data.verticalIndent = 5;
		typeLabel.setLayoutData(data);
		typeLabel.setText(entryLabel);

		final List list = new List(parent, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.MULTI);
		listLayoutData.verticalIndent = 5;
		list.setLayoutData(listLayoutData);

		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.verticalSpacing = 15;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		composite.setLayout(layout);
		data = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		data.verticalIndent = 5;
		composite.setLayoutData(data);

		final Button addIn = createButton(composite, Messages.getString("AtlFileScreen.Add")); //$NON-NLS-1$
		final Button removeIn = createButton(composite, Messages.getString("AtlFileScreen.Remove")); //$NON-NLS-1$

		removeIn.setEnabled(false);

		addIn.addSelectionListener(new SelectionAdapter() {
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent evt) {
				dialog.create();
				if (dialog.open() == Dialog.OK) {
					Object[] result = dialog.getResult();
					if (result.length == 3) {
						paths.put(result[1].toString(), result[2].toString());
						dataMap.put(result[0].toString(), result[1].toString());
					} else if (result.length == 2) {
						dataMap.put(result[0].toString(), result[1].toString());
					}
				}
				updateLists();
			}
		});

		removeIn.addSelectionListener(new SelectionAdapter() {
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent evt) {
				// list.remove(list.getSelectionIndices());
				int[] indices = list.getSelectionIndices();
				for (int i = 0; i < indices.length; i++) {
					int j = indices[i];
					Object key = getEntryNameFromItem(list.getItem(j));
					paths.remove(dataMap.get(key));
					dataMap.remove(key);
				}
				updateLists();
				removeIn.setEnabled(list.getSelection().length > 0);
			}
		});

		list.addSelectionListener(new SelectionAdapter() {
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				removeIn.setEnabled(list.getSelection().length > 0);
			}
		});

		comboType.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				boolean hasModels = comboType.getText().equals(TYPE_MODULE)
						|| comboType.getText().equals(TYPE_REFINING_MODULE);
				typeLabel.setEnabled(hasModels);
				list.setEnabled(hasModels);
				addIn.setEnabled(hasModels);
				removeIn.setEnabled(hasModels && list.getSelection().length > 0);
				checkValid();
			}
		});
		return list;
	}

	private List createLibControl(final Composite parent, final AbstractAtlSelection dialog,
			GridData listLayoutData) {
		final Label typeLabel = new Label(parent, SWT.NONE);
		GridData data = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		data.verticalIndent = 5;
		typeLabel.setLayoutData(data);
		typeLabel.setText(Messages.getString("AtlFileScreen.ATLLibrary")); //$NON-NLS-1$

		final List list = new List(parent, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.MULTI);
		listLayoutData.verticalIndent = 5;
		list.setLayoutData(listLayoutData);

		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.verticalSpacing = 15;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		composite.setLayout(layout);
		data = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		data.verticalIndent = 5;
		composite.setLayoutData(data);

		final Button addIn = createButton(composite, Messages.getString("AtlFileScreen.Add")); //$NON-NLS-1$
		final Button removeIn = createButton(composite, Messages.getString("AtlFileScreen.Remove")); //$NON-NLS-1$

		removeIn.setEnabled(false);

		addIn.addSelectionListener(new SelectionAdapter() {
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent evt) {
				dialog.create();
				if (dialog.open() == Dialog.OK) {
					libraries.put(dialog.getResult().toString(), ""); //$NON-NLS-1$
					updateLists();
				}
			}
		});

		removeIn.addSelectionListener(new SelectionAdapter() {
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent evt) {
				int[] indices = list.getSelectionIndices();
				for (int i = 0; i < indices.length; i++) {
					int j = indices[i];
					libraries.remove(getEntryNameFromItem(list.getItem(j)));
				}
				updateLists();
				removeIn.setEnabled(list.getSelection().length > 0);
			}
		});

		list.addSelectionListener(new SelectionAdapter() {
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				removeIn.setEnabled(list.getSelection().length > 0);
			}
		});

		comboType.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				boolean hasModels = comboType.getText().equals(TYPE_MODULE)
						|| comboType.getText().equals(TYPE_REFINING_MODULE);
				typeLabel.setEnabled(hasModels);
				list.setEnabled(hasModels);
				addIn.setEnabled(hasModels);
				removeIn.setEnabled(hasModels && list.getSelection().length > 0);
				checkValid();
			}
		});
		return list;
	}

	private void updateLists() {
		// input
		inputList.removeAll();
		for (Iterator<String> iterator = input.keySet().iterator(); iterator.hasNext();) {
			String modelName = iterator.next();
			String metamodelName = input.get(modelName);
			String path = paths.get(metamodelName);
			StringBuffer item = new StringBuffer(modelName + " : " + metamodelName); //$NON-NLS-1$
			if (path != null) {
				item.append(" (" + path + ")"); //$NON-NLS-1$ //$NON-NLS-2$
			}
			inputList.add(item.toString());
		}
		// output
		outputList.removeAll();
		for (Iterator<String> iterator = output.keySet().iterator(); iterator.hasNext();) {
			String modelName = iterator.next();
			String metamodelName = output.get(modelName);
			String path = paths.get(metamodelName);
			StringBuffer item = new StringBuffer(modelName + " : " + metamodelName); //$NON-NLS-1$
			if (path != null) {
				item.append(" (" + path + ")"); //$NON-NLS-1$//$NON-NLS-2$
			}
			outputList.add(item.toString());
		}
		// libraries
		libList.removeAll();
		for (Iterator<String> iterator = libraries.keySet().iterator(); iterator.hasNext();) {
			libList.add(iterator.next());
		}
		checkValid();
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
	 * Initialize the page from previous informations, if no module name has been specified.
	 * 
	 * @param name
	 *            the default module name
	 */
	public void setModuleName(String name) {
		textName.setText(name);
		textName.selectAll();
	}

	private void checkValid() {
		setPageComplete(checkUnitName() && checkModelsConsistancy());
	}

	private boolean checkUnitName() {
		String errorMessage = AbstractAtlSelection.checkIdentifier(textName.getText());
		setErrorMessage(errorMessage);
		return errorMessage == null;
	}

	private boolean checkModelsConsistancy() {
		if (comboType.getText().equals(TYPE_MODULE) || comboType.getText().equals(TYPE_REFINING_MODULE)) {
			if (input.isEmpty()) {
				setErrorMessage(Messages.getString("AtlFileWizard.INPUT_MODELS_ISSUE")); //$NON-NLS-1$
				return false;
			}
			if (output.isEmpty()) {
				setErrorMessage(Messages.getString("AtlFileWizard.OUTPUT_MODELS_ISSUE")); //$NON-NLS-1$
				return false;
			}
			if (comboType.getText().equals(TYPE_REFINING_MODULE)) {
				for (Iterator<String> iterator = input.values().iterator(); iterator.hasNext();) {
					if (output.containsValue(iterator.next())) {
						setErrorMessage(null);
						return true;
					}
				}
				setErrorMessage(Messages.getString("AtlFileWizard.REFINING_ISSUE")); //$NON-NLS-1$
				return false;
			}
		}
		setErrorMessage(null);
		return true;
	}

	/**
	 * Returns <code>true</code> if the generateLaunchConfig button is checked.
	 * 
	 * @return <code>true</code> if the generateLaunchConfig button is checked
	 */
	public boolean generateLaunchConfig() {
		return launchButton.getSelection();
	}

	protected Map<String, String> getPaths() {
		return paths;
	}

	public String getUnitName() {
		return textName.getText();
	}

	public String getUnitType() {
		return comboType.getText();
	}

	public Map<String, String> getLibraries() {
		return libraries;
	}

	public Map<String, String> getInput() {
		return input;
	}

	public Map<String, String> getOutput() {
		return output;
	}

}
