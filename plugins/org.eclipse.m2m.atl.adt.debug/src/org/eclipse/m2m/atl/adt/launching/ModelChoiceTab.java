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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.m2m.atl.ATLPlugin;
import org.eclipse.m2m.atl.adt.debug.AtlDebugMessages;
import org.eclipse.m2m.atl.engine.AtlModelHandler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * This class is a tab that appears in the ATL Configuration. This tab allows to set the model and metamodel
 * input and output. For each model
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class ModelChoiceTab extends AbstractLaunchConfigurationTab {
	/** Model output notation. */
	public static final String MODEL_OUTPUT = "MODELOUTPUT"; //$NON-NLS-1$

	/** Model input notation. */
	public static final String MODEL_INPUT = "MODELINPUT"; //$NON-NLS-1$

	/** Metamodel output notation. */
	public static final String METAMODEL_OUTPUT = "METAMODELOUTPUT"; //$NON-NLS-1$

	/** Metamodel input notation. */
	public static final String METAMODEL_INPUT = "METAMODELINPUT"; //$NON-NLS-1$

	static final int INPUT = 0;

	static final int OUTPUT = 1;

	static final String MODEL = "MODEL"; //$NON-NLS-1$

	static final String METAMODEL = "METAMODEL"; //$NON-NLS-1$

	static final String LIB = "LIB"; //$NON-NLS-1$

	/*
	 * These constants represent the index of the columns in different table
	 */
	static final int TABLEPATHNAME = 0;

	static final int TABLEPATHPATH = 1;

	static final int TABLEPATHMODELHANDLER = 2;

	static final int TABLEPATHTYPE = 3;

	static final int TABLEMODELNAME = 0;

	static final int TABLEMETAMODELNAME = 1;

	static final int TABLELIBNAME = 0;

	static final int TABLELIBPATH = 1;

	/** Map input : Model --> MetaModel. */
	private Map inputModels = new HashMap();

	/** Map output : Model --> MetaModel. */
	private Map outputModels = new HashMap();

	/** Map modelPath : Model/MetaModel --> Path. */
	private Map modelPathMap = new HashMap();

	/** Map modelType : Model/MetaModel --> Type. */
	private Map modelTypeMap = new HashMap();

	/** Map modelHandler : Metamodel --> ModelHandler. */
	private Map modelHandlerMap = new HashMap();

	/** Map libPath : lib --> Path. */
	private Map libPathMap = new HashMap();

	/*
	 * Graphic components
	 */
	private Composite container;

	private Group groupIn;

	private Table tableIn;

	private Text textModelIn;

	private Label labelModelIn;

	private Text textMetaModelIn;

	private Label labelMetaModelIn;

	private Button buttonIn;

	private Button buttonRemoveIn;

	private Group groupOut;

	private Table tableOut;

	private Text textModelOut;

	private Label labelModelOut;

	private Text textMetaModelOut;

	private Label labelMetaModelOut;

	private Button buttonOut;

	private Button buttonRemoveOut;

	private Group groupPath;

	private Table tablePath;

	private Button buttonSetPath;

	private Button buttonSetExternalPath;

	private Button buttonIsMDR;

	private Button buttonIsEMF;

	private List listModelHandlerAvailables;

	private Button buttonSelectModelHandler;

	private Button buttonAffectUri;

	private Group groupLib;

	private Table tableLib;

	private Text textLib;

	private Label labelLib;

	private Button buttonLib;

	private Button buttonPathLib;

	private Button buttonRemoveLib;

	private Button buttonExternalPathLib;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {

		/*
		 * Initialisation of composants
		 */
		container = new Composite(parent, SWT.NULL);

		groupIn = new Group(container, SWT.NULL);
		labelModelIn = new Label(groupIn, SWT.END);
		textModelIn = new Text(groupIn, SWT.BORDER);
		labelMetaModelIn = new Label(groupIn, SWT.END);
		textMetaModelIn = new Text(groupIn, SWT.BORDER);
		tableIn = new Table(groupIn, SWT.FULL_SELECTION | SWT.BORDER);
		buttonIn = new Button(groupIn, SWT.NULL);
		buttonRemoveIn = new Button(groupIn, SWT.NULL);

		groupOut = new Group(container, SWT.NULL);
		labelModelOut = new Label(groupOut, SWT.END);
		textModelOut = new Text(groupOut, SWT.BORDER);
		labelMetaModelOut = new Label(groupOut, SWT.END);
		textMetaModelOut = new Text(groupOut, SWT.BORDER);
		tableOut = new Table(groupOut, SWT.FULL_SELECTION | SWT.BORDER);
		buttonOut = new Button(groupOut, SWT.CENTER);
		buttonRemoveOut = new Button(groupOut, SWT.NULL);

		groupPath = new Group(container, SWT.NULL);
		tablePath = new Table(groupPath, SWT.FULL_SELECTION | SWT.BORDER);
		listModelHandlerAvailables = new List(groupPath, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
		buttonSelectModelHandler = new Button(groupPath, SWT.CENTER);
		buttonSetPath = new Button(groupPath, SWT.CENTER);
		buttonSetExternalPath = new Button(groupPath, SWT.CENTER);
		buttonIsMDR = new Button(groupPath, SWT.CENTER);
		buttonIsEMF = new Button(groupPath, SWT.CENTER);
		buttonAffectUri = new Button(groupPath, SWT.CENTER);

		groupLib = new Group(container, SWT.NULL);
		labelLib = new Label(groupLib, SWT.END);
		textLib = new Text(groupLib, SWT.BORDER);
		buttonLib = new Button(groupLib, SWT.CENTER);
		tableLib = new Table(groupLib, SWT.FULL_SELECTION | SWT.BORDER);
		buttonPathLib = new Button(groupLib, SWT.CENTER);
		buttonExternalPathLib = new Button(groupLib, SWT.CENTER);
		buttonRemoveLib = new Button(groupLib, SWT.CENTER);

		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.makeColumnsEqualWidth = true;

		container.setLayout(layout);

		groupIn.setLayoutData(new GridData(GridData.FILL_BOTH));
		groupOut.setLayoutData(new GridData(GridData.FILL_BOTH));
		groupPath.setLayoutData(new GridData(GridData.FILL_BOTH));
		groupLib.setLayoutData(new GridData(GridData.FILL_BOTH));

		/*****************************************************************************************************
		 * GroupIn
		 ****************************************************************************************************/
		GridLayout groupLayout = new GridLayout();
		groupLayout.numColumns = 4;
		groupLayout.makeColumnsEqualWidth = true;

		groupIn.setLayout(groupLayout);

		groupIn.setText(AtlDebugMessages.getString("ModelChoiceTab.IN")); //$NON-NLS-1$

		labelModelIn.setText(AtlDebugMessages.getString("ModelChoiceTab.MODELCOLON")); //$NON-NLS-1$

		labelMetaModelIn.setText(AtlDebugMessages.getString("ModelChoiceTab.METAMODELCOLON")); //$NON-NLS-1$

		buttonIn.setText(AtlDebugMessages.getString("ModelChoiceTab.ADD")); //$NON-NLS-1$
		buttonIn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				addTextTable(evt, tableIn, textModelIn, textMetaModelIn, INPUT);
				canSave();
				updateLaunchConfigurationDialog();
			}
		});

		buttonRemoveIn.setText(AtlDebugMessages.getString("ModelChoiceTab.REMOVE")); //$NON-NLS-1$
		buttonRemoveIn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				removeTextTable(evt, tableIn);
				canSave();
				updateLaunchConfigurationDialog();
			}
		});

		tableIn.setLinesVisible(true);
		tableIn.setHeaderVisible(true);
		TableLayout tableLayout = new TableLayout();
		tableIn.setLayout(tableLayout);
		tableLayout.addColumnData(new ColumnWeightData(100));
		tableLayout.addColumnData(new ColumnWeightData(100));

		// ModelChoiceTab.TABLEMODELNAME
		TableColumn modelNameIn = new TableColumn(tableIn, SWT.CENTER);
		modelNameIn.setText(AtlDebugMessages.getString("ModelChoiceTab.MODEL")); //$NON-NLS-1$

		// ModelChoiceTab.TABLEMETAMODELNAME
		TableColumn mmodelNameIn = new TableColumn(tableIn, SWT.CENTER);
		mmodelNameIn.setText(AtlDebugMessages.getString("ModelChoiceTab.META_MODEL")); //$NON-NLS-1$

		labelModelIn.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.HORIZONTAL_ALIGN_END));
		textMetaModelIn.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.HORIZONTAL_ALIGN_BEGINNING));
		labelMetaModelIn
				.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.HORIZONTAL_ALIGN_END));
		textModelIn
				.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.HORIZONTAL_ALIGN_BEGINNING));

		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 3;
		gd.verticalSpan = 2;
		tableIn.setLayoutData(gd);

		buttonIn.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_BEGINNING));
		buttonRemoveIn.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.VERTICAL_ALIGN_BEGINNING));

		/*****************************************************************************************************
		 * GroupOut
		 ****************************************************************************************************/
		groupLayout = new GridLayout();
		groupLayout.numColumns = 4;
		groupLayout.makeColumnsEqualWidth = true;

		groupOut.setLayout(groupLayout);

		groupOut.setText(AtlDebugMessages.getString("ModelChoiceTab.OUT")); //$NON-NLS-1$

		labelModelOut.setText(AtlDebugMessages.getString("ModelChoiceTab.MODELCOLON")); //$NON-NLS-1$

		labelMetaModelOut.setText(AtlDebugMessages.getString("ModelChoiceTab.METAMODELCOLON")); //$NON-NLS-1$

		buttonOut.setText(AtlDebugMessages.getString("ModelChoiceTab.ADD")); //$NON-NLS-1$
		buttonOut.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				addTextTable(evt, tableOut, textModelOut, textMetaModelOut, OUTPUT);
				canSave();
				updateLaunchConfigurationDialog();
			}
		});

		buttonRemoveOut.setText(AtlDebugMessages.getString("ModelChoiceTab.REMOVE")); //$NON-NLS-1$
		buttonRemoveOut.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				removeTextTable(evt, tableOut);
				canSave();
				updateLaunchConfigurationDialog();
			}
		});

		tableLayout = new TableLayout();
		tableOut.setLayout(tableLayout);
		tableLayout.addColumnData(new ColumnWeightData(100));
		tableLayout.addColumnData(new ColumnWeightData(100));
		tableOut.setLinesVisible(true);
		tableOut.setHeaderVisible(true);

		// ModelChoiceTab.TABLEMODELNAME
		TableColumn modelName = new TableColumn(tableOut, SWT.CENTER);
		modelName.setText(AtlDebugMessages.getString("ModelChoiceTab.MODEL")); //$NON-NLS-1$

		// ModelChoiceTab.TABLEMETAMODELNAME
		TableColumn metaModelName = new TableColumn(tableOut, SWT.CENTER);
		metaModelName.setText(AtlDebugMessages.getString("ModelChoiceTab.META_MODEL")); //$NON-NLS-1$

		labelModelOut.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.HORIZONTAL_ALIGN_END));
		textModelOut.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.HORIZONTAL_ALIGN_BEGINNING));
		labelMetaModelOut
				.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.HORIZONTAL_ALIGN_END));
		textMetaModelOut.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.HORIZONTAL_ALIGN_BEGINNING));

		tableOut.setLayoutData(gd);

		buttonOut.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_BEGINNING));
		buttonRemoveOut.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.VERTICAL_ALIGN_BEGINNING));
		/*****************************************************************************************************
		 * GroupPath
		 ****************************************************************************************************/
		groupLayout = new GridLayout();
		groupLayout.numColumns = 4;
		groupLayout.makeColumnsEqualWidth = true;

		groupPath.setLayout(groupLayout);

		groupPath.setText(AtlDebugMessages.getString("ModelChoiceTab.PATH_EDITOR")); //$NON-NLS-1$

		buttonSetPath.setText(AtlDebugMessages.getString("ModelChoiceTab.SET_PATH")); //$NON-NLS-1$
		buttonSetPath.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				editPath(ModelChoiceTab.MODEL, tablePath);
				canSave();
				updateLaunchConfigurationDialog();
			}
		});

		buttonSetExternalPath.setText(AtlDebugMessages.getString("ModelChoiceTab.SET_EXTERNAL_PATH")); //$NON-NLS-1$
		buttonSetExternalPath.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				editExternalPath(ModelChoiceTab.MODEL, tablePath);
				canSave();
				updateLaunchConfigurationDialog();
			}
		});

		buttonIsMDR.setText("MM Is MOF-1.4"); //$NON-NLS-1$
		buttonIsMDR.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				metamodelIsMetametamodel("MDR"); //$NON-NLS-1$
				canSave();
				updateLaunchConfigurationDialog();
			}
		});

		buttonIsEMF.setText("MM is Ecore"); //$NON-NLS-1$
		buttonIsEMF.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				metamodelIsMetametamodel("EMF"); //$NON-NLS-1$
				canSave();
				updateLaunchConfigurationDialog();
			}
		});

		listModelHandlerAvailables.setItems(AtlModelHandler.getModelHandlers());

		buttonSelectModelHandler.setText("Select Model Handler"); //$NON-NLS-1$
		buttonSelectModelHandler.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				selectModelHandler();
				canSave();
				updateLaunchConfigurationDialog();
			}
		});

		buttonAffectUri.setText("Metamodel by URI"); //$NON-NLS-1$
		buttonAffectUri.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				int index = tablePath.getSelectionIndex();

				if (index == -1) {
					AtlLauncherTools
							.messageBox(AtlDebugMessages.getString("ModelChoiceTab.CHOOSE") + "Metamodel"); //$NON-NLS-1$ //$NON-NLS-2$
					return;
				}

				if (MODEL_INPUT.equals(tablePath.getItem(index).getText(TABLEPATHTYPE))
						|| MODEL_OUTPUT.equals(tablePath.getItem(index).getText(TABLEPATHTYPE))) {
					AtlLauncherTools.messageBox(AtlDebugMessages.getString("ModelChoiceTab.MMADVERTISMENT")); //$NON-NLS-1$
					return;
				}

				DialogUriSelection launcher = new DialogUriSelection(new Shell());
				launcher.create();
				if (launcher.open() == Dialog.OK) {
					uriMetametamodel(launcher.getUriSelected());
					canSave();
					updateLaunchConfigurationDialog();
				}
			}
		});

		tableLayout = new TableLayout();
		tablePath.setLayout(tableLayout);
		tableLayout.addColumnData(new ColumnWeightData(20));
		tableLayout.addColumnData(new ColumnWeightData(100));
		tableLayout.addColumnData(new ColumnWeightData(20));
		tablePath.setLinesVisible(true);
		tablePath.setHeaderVisible(true);

		// ModelChoiceTab.TABLEPATHNAME
		TableColumn modelPathName = new TableColumn(tablePath, SWT.CENTER);
		modelPathName.setText(AtlDebugMessages.getString("ModelChoiceTab.MODEL")); //$NON-NLS-1$

		// ModelChoiceTab.TABLEPATHPATH
		TableColumn pathName = new TableColumn(tablePath, SWT.LEFT);
		pathName.setText(AtlDebugMessages.getString("ModelChoiceTab.PATH")); //$NON-NLS-1$

		// ModelChoiceTab.TABLEPATHMODELHANDLER
		TableColumn modelHandler = new TableColumn(tablePath, SWT.CENTER);
		modelHandler.setText("Model Handler"); //$NON-NLS-1$

		// ModelChoiceTab.TABLEPATHTYPE
		TableColumn modelType = new TableColumn(tablePath, SWT.NULL);
		modelType.setText("Type"); //$NON-NLS-1$
		modelType.setWidth(0);
		modelType.setResizable(false);

		gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 3;
		gd.verticalSpan = 7;
		tablePath.setLayoutData(gd);
		buttonSetPath
				.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_BEGINNING));
		buttonSetExternalPath.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.VERTICAL_ALIGN_BEGINNING));
		buttonIsMDR.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_BEGINNING));
		buttonIsEMF.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_BEGINNING));
		GridData gData = new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_BEGINNING);
		gData.heightHint = listModelHandlerAvailables.getItemHeight() * 2;
		listModelHandlerAvailables.setLayoutData(gData);
		buttonSelectModelHandler.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.VERTICAL_ALIGN_BEGINNING));
		buttonAffectUri.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.VERTICAL_ALIGN_BEGINNING));

		/*****************************************************************************************************
		 * GroupLibs
		 ****************************************************************************************************/
		groupLayout = new GridLayout();
		groupLayout.numColumns = 4;
		groupLayout.makeColumnsEqualWidth = true;

		groupLib.setLayout(groupLayout);

		groupLib.setText(AtlDebugMessages.getString("ModelChoiceTab.LIBS")); //$NON-NLS-1$

		labelLib.setText(AtlDebugMessages.getString("ModelChoiceTab.LIBCOLON")); //$NON-NLS-1$

		buttonLib.setText(AtlDebugMessages.getString("ModelChoiceTab.ADD")); //$NON-NLS-1$
		buttonLib.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				addLib();
				canSave();
				updateLaunchConfigurationDialog();
			}
		});

		buttonPathLib.setText(AtlDebugMessages.getString("ModelChoiceTab.SET_PATH")); //$NON-NLS-1$
		buttonPathLib.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				editPath(ModelChoiceTab.LIB, tableLib);
				canSave();
				updateLaunchConfigurationDialog();
			}
		});

		buttonExternalPathLib.setText(AtlDebugMessages.getString("ModelChoiceTab.SET_EXTERNAL_PATH")); //$NON-NLS-1$
		buttonExternalPathLib.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				editExternalPath(ModelChoiceTab.LIB, tableLib);
				canSave();
				updateLaunchConfigurationDialog();
			}
		});

		buttonRemoveLib.setText(AtlDebugMessages.getString("ModelChoiceTab.REMOVE_LIB")); //$NON-NLS-1$
		buttonRemoveLib.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				removeLib();
				canSave();
				updateLaunchConfigurationDialog();
			}
		});

		tableLayout = new TableLayout();
		tableLib.setLayout(tableLayout);
		tableLayout.addColumnData(new ColumnWeightData(50));
		tableLayout.addColumnData(new ColumnWeightData(100));
		tableLib.setLinesVisible(true);
		tableLib.setHeaderVisible(true);

		// ModelChoiceTab.TABLELIBNAME
		TableColumn libName = new TableColumn(tableLib, SWT.CENTER);
		libName.setText(AtlDebugMessages.getString("ModelChoiceTab.LIBS")); //$NON-NLS-1$

		// ModelChoiceTab.TABLELIBPATH
		TableColumn pathLib = new TableColumn(tableLib, SWT.LEFT);
		pathLib.setText(AtlDebugMessages.getString("ModelChoiceTab.PATH")); //$NON-NLS-1$

		gd = new GridData(GridData.FILL_HORIZONTAL | GridData.HORIZONTAL_ALIGN_END);
		gd.horizontalSpan = 2;
		labelLib.setLayoutData(gd);
		textLib.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.HORIZONTAL_ALIGN_BEGINNING));
		buttonLib.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 3;
		gd.verticalSpan = 3;
		tableLib.setLayoutData(gd);

		buttonPathLib
				.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_BEGINNING));
		buttonRemoveLib.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.VERTICAL_ALIGN_BEGINNING));
		buttonExternalPathLib.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.VERTICAL_ALIGN_BEGINNING));

		/** ***************************************** */
		setControl(container);

		canSave();

	}

	/**
	 * Delete a lib in the table.
	 */
	private void removeLib() {
		int index = tableLib.getSelectionIndex();

		if (index == -1) {
			AtlLauncherTools.messageBox(AtlDebugMessages.getString("ModelChoiceTab.CHOOSEMODEL")); //$NON-NLS-1$
			return;
		}

		MessageBox msgBox = new MessageBox(this.getShell(), SWT.APPLICATION_MODAL | SWT.YES | SWT.NO);
		msgBox.setText(AtlDebugMessages.getString("ModelChoiceTab.ERROR")); //$NON-NLS-1$
		msgBox.setMessage(AtlDebugMessages.getString("ModelChoiceTab.REMOVELIB")); //$NON-NLS-1$
		if (msgBox.open() != SWT.YES) {
			return;
		}

		tableLib.remove(index);
	}

	/**
	 * Delete a model and metamodel from the table in parameter.
	 * 
	 * @param evt
	 * @param table
	 *            where the model and metamodel are deleted
	 */
	private void removeTextTable(SelectionEvent evt, Table table) {
		int index = table.getSelectionIndex();

		if (index == -1) {
			AtlLauncherTools.messageBox(AtlDebugMessages.getString("ModelChoiceTab.CHOOSEMODEL")); //$NON-NLS-1$
			return;
		}

		MessageBox msgBox = new MessageBox(this.getShell(), SWT.APPLICATION_MODAL | SWT.YES | SWT.NO);
		msgBox.setText(AtlDebugMessages.getString("ModelChoiceTab.ERROR")); //$NON-NLS-1$
		msgBox.setMessage(AtlDebugMessages.getString("ModelChoiceTab.REMOVEMODEL")); //$NON-NLS-1$
		if (msgBox.open() != SWT.YES) {
			return;
		}

		TableItem item = table.getItem(index);
		String modelName = item.getText(ModelChoiceTab.TABLEMODELNAME);
		String metaModelName = item.getText(ModelChoiceTab.TABLEMETAMODELNAME);

		int indexModel = -1;
		int indexMetaModel = -1;

		TableItem[] items = tablePath.getItems();

		if (!isMultipleInstance(modelName, ModelChoiceTab.MODEL)) {

			for (int i = 0; i < items.length; i++) {
				String nameItem = items[i].getText(ModelChoiceTab.TABLEPATHNAME);
				String typeItem = items[i].getText(ModelChoiceTab.TABLEPATHTYPE);
				if (modelName.equals(nameItem)
						&& (typeItem.equals(ModelChoiceTab.MODEL_INPUT) || typeItem
								.equals(ModelChoiceTab.MODEL_OUTPUT))) {
					indexModel = i;
				}
			}

			if (indexModel != -1) {
				tablePath.remove(indexModel);
			}
		}
		if (!isMultipleInstance(metaModelName, ModelChoiceTab.METAMODEL)) {
			items = tablePath.getItems();

			for (int i = 0; i < items.length; i++) {
				String nameItem = items[i].getText(ModelChoiceTab.TABLEPATHNAME);
				String typeItem = items[i].getText(ModelChoiceTab.TABLEPATHTYPE);
				if (metaModelName.equals(nameItem)
						&& (typeItem.equals(ModelChoiceTab.METAMODEL_INPUT) || typeItem
								.equals(ModelChoiceTab.METAMODEL_OUTPUT))) {
					indexMetaModel = i;
				}
			}

			if (indexMetaModel != -1) {
				tablePath.remove(indexMetaModel);
			}
		}
		table.remove(index);
	}

	/**
	 * Returns TRUE if text is two or more model or metamodel in table in and table out.
	 * 
	 * @param text
	 *            name of the model
	 * @param type
	 *            of the model (model/metamodel)
	 * @param table
	 *            the table where is the model
	 * @return TRUE if text is two or more model or metamodel in table in and table out
	 */
	private boolean isMultipleInstance(String text, String type) {
		int textIndex;

		if (type.equals(ModelChoiceTab.MODEL)) {
			textIndex = TABLEMODELNAME;
		} else {
			textIndex = TABLEMETAMODELNAME;
		}

		boolean ok = false;
		for (int i = 0; i < tableOut.getItemCount(); i++) {
			if (text.equals(tableOut.getItem(i).getText(textIndex))) {
				if (ok) {
					return true;
				} else {
					ok = true;
				}
			}
		}
		for (int i = 0; i < tableIn.getItemCount(); i++) {
			if (text.equals(tableIn.getItem(i).getText(textIndex))) {
				if (ok) {
					return true;
				} else {
					ok = true;
				}
			}
		}
		return false;
	}

	/**
	 * Add lib to the table Lib.
	 */
	private void addLib() {
		String lib = textLib.getText();
		if (lib.equals("")) { //$NON-NLS-1$
			AtlLauncherTools.messageBox(AtlDebugMessages.getString("ModelChoiceTab.GIVELIB")); //$NON-NLS-1$
			return;
		}

		TableItem item = new TableItem(tableLib, SWT.NONE);
		item.setText(new String[] {lib, ""}); //$NON-NLS-1$

		textLib.setText(""); //$NON-NLS-1$
	}

	private void uriMetametamodel(String uri) {
		int index = tablePath.getSelectionIndex();

		if (index == -1) {
			AtlLauncherTools.messageBox(AtlDebugMessages.getString("ModelChoiceTab.CHOOSE") + "Metamodel"); //$NON-NLS-1$ //$NON-NLS-2$
			return;
		}

		if (MODEL_INPUT.equals(tablePath.getItem(index).getText(TABLEPATHTYPE))
				|| MODEL_OUTPUT.equals(tablePath.getItem(index).getText(TABLEPATHTYPE))) {
			AtlLauncherTools.messageBox(AtlDebugMessages.getString("ModelChoiceTab.MMADVERTISMENT")); //$NON-NLS-1$
			return;
		}

		// tablePath.getItem(index).setText(TABLEPATHPATH, "uri:" + comboUriAvailable.getText());
		tablePath.getItem(index).setText(TABLEPATHPATH, "uri:" + uri); //$NON-NLS-1$
	}

	private void metamodelIsMetametamodel(String metamodel) {
		int index = tablePath.getSelectionIndex();

		if (index == -1) {
			AtlLauncherTools.messageBox(AtlDebugMessages.getString("ModelChoiceTab.CHOOSE") + "Metamodel"); //$NON-NLS-1$ //$NON-NLS-2$
			return;
		}

		if (MODEL_INPUT.equals(tablePath.getItem(index).getText(TABLEPATHTYPE))
				|| MODEL_OUTPUT.equals(tablePath.getItem(index).getText(TABLEPATHTYPE))) {
			AtlLauncherTools.messageBox(AtlDebugMessages.getString("ModelChoiceTab.MMADVERTISMENT")); //$NON-NLS-1$
			return;
		}

		tablePath.getItem(index).setText(TABLEPATHPATH, "#" + metamodel); //$NON-NLS-1$
		tablePath.getItem(index).setText(TABLEPATHMODELHANDLER, metamodel);
	}

	private void selectModelHandler() {
		int index = tablePath.getSelectionIndex();

		if (index == -1) {
			AtlLauncherTools.messageBox(AtlDebugMessages.getString("ModelChoiceTab.CHOOSE") + "Metamodel"); //$NON-NLS-1$ //$NON-NLS-2$
			return;
		}

		if (MODEL_INPUT.equals(tablePath.getItem(index).getText(TABLEPATHTYPE))
				|| MODEL_OUTPUT.equals(tablePath.getItem(index).getText(TABLEPATHTYPE))) {
			AtlLauncherTools.messageBox(AtlDebugMessages.getString("ModelChoiceTab.MMADVERTISMENT")); //$NON-NLS-1$
			return;
		}

		String[] selection = listModelHandlerAvailables.getSelection();
		if (selection.length == 1) {
			tablePath.getItem(index).setText(TABLEPATHMODELHANDLER, selection[0]);
			if (tablePath.getItem(index).getText(TABLEPATHPATH).startsWith("#")) { //$NON-NLS-1$
				tablePath.getItem(index).setText(TABLEPATHPATH, "#" + selection[0]); //$NON-NLS-1$
			}
		} else {
			AtlLauncherTools.messageBox(AtlDebugMessages.getString("ModelChoiceTab.MHSELECTION")); //$NON-NLS-1$
			return;
		}
	}

	/**
	 * This method edit the path of a model. The path can be external at the workspace
	 * 
	 * @param type
	 * @param table
	 */
	private void editExternalPath(final String type, Table table) {
		int index = table.getSelectionIndex();

		if (index == -1) {
			AtlLauncherTools.messageBox(AtlDebugMessages.getString("ModelChoiceTab.CHOOSE") + type); //$NON-NLS-1$
			return;
		}

		if (type.equals(ModelChoiceTab.MODEL)
				&& table.getItem(index).getText(ModelChoiceTab.TABLEPATHTYPE).equals(
						ModelChoiceTab.MODEL_OUTPUT)) {
			SaveAsDialog sad = new SaveAsDialog(getShell());
			sad.open();
			IPath outputPath = sad.getResult();
			if (outputPath != null) {
				TableItem item = table.getItem(index);
				item.setText(new String[] {item.getText(ModelChoiceTab.TABLEPATHNAME),
						outputPath.toFile().getName(), item.getText(TABLEPATHMODELHANDLER),
						item.getText(ModelChoiceTab.TABLEPATHTYPE),});
			} else {
				AtlLauncherTools.messageBox(AtlDebugMessages.getString("ModelChoiceTab.CHOOSE") + type); //$NON-NLS-1$
			}
		} else {
			FileDialog fileDialog = new FileDialog(this.getShell());
			fileDialog.setText(AtlDebugMessages.getString("ModelChoiceTab.CHOOSEMETAMODEL")); //$NON-NLS-1$
			fileDialog.setFilterExtensions(new String[] {"*"}); //$NON-NLS-1$
			String fileName = fileDialog.open();
			if (fileName == null) {
				return;
			}
			fileName = "ext:" + fileName; //$NON-NLS-1$

			if (fileName != null) {
				TableItem item = table.getItem(index);

				if (type.equals(ModelChoiceTab.MODEL)) {
					item
							.setText(new String[] {item.getText(ModelChoiceTab.TABLEPATHNAME), fileName,
									item.getText(TABLEPATHMODELHANDLER),
									item.getText(ModelChoiceTab.TABLEPATHTYPE),});
				} else {
					item.setText(new String[] {item.getText(ModelChoiceTab.TABLELIBNAME), fileName});
				}
			} else {
				AtlLauncherTools.messageBox(AtlDebugMessages.getString("ModelChoiceTab.CHOOSE") + type); //$NON-NLS-1$
			}
		}
	}

	/**
	 * This method edit the path of the model selected. The path corresponding the a file in the workspace
	 * 
	 * @param type
	 * @param table
	 */
	private void editPath(final String type, Table table) {
		int index = table.getSelectionIndex();

		if (index == -1) {
			AtlLauncherTools.messageBox(AtlDebugMessages.getString("ModelChoiceTab.CHOOSE") + type); //$NON-NLS-1$
			return;
		}

		if (type.equals(ModelChoiceTab.MODEL)
				&& table.getItem(index).getText(ModelChoiceTab.TABLEPATHTYPE).equals(
						ModelChoiceTab.MODEL_OUTPUT)) {
			SaveAsDialog sad = new SaveAsDialog(getShell());
			sad.open();
			IPath outputPath = sad.getResult();
			if (outputPath != null) {
				TableItem item = table.getItem(index);
				item.setText(new String[] {item.getText(ModelChoiceTab.TABLEPATHNAME), outputPath.toString(),
						item.getText(TABLEPATHMODELHANDLER), item.getText(ModelChoiceTab.TABLEPATHTYPE),});
			} else {
				AtlLauncherTools.messageBox(AtlDebugMessages.getString("ModelChoiceTab.CHOOSE") + type); //$NON-NLS-1$
			}
		} else {
			ElementTreeSelectionDialog elementTreeSelectionDialog = new ElementTreeSelectionDialog(
					getShell(), new WorkbenchLabelProvider(), new WorkbenchContentProvider());
			elementTreeSelectionDialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
			elementTreeSelectionDialog.setMessage(AtlDebugMessages.getString("ModelChoiceTab.CHOOSE") + type); //$NON-NLS-1$
			elementTreeSelectionDialog.setAllowMultiple(false);
			elementTreeSelectionDialog.setDoubleClickSelects(true);
			elementTreeSelectionDialog.addFilter(new ViewerFilter() {
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					boolean ret = false;

					if (element instanceof IContainer) {
						ret = true;
					} else if (element instanceof IFile) {
						IFile currentFile = (IFile)element;
						if (currentFile.getFileExtension() == null) {
							return false;
						}
						if (type == ModelChoiceTab.LIB) {
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
				TableItem item = table.getItem(index);
				IFile currentFile = (IFile)result;

				if (type.equals(ModelChoiceTab.MODEL)) {
					item.setText(new String[] {item.getText(ModelChoiceTab.TABLEPATHNAME),
							currentFile.getFullPath().toString(), item.getText(TABLEPATHMODELHANDLER),
							item.getText(ModelChoiceTab.TABLEPATHTYPE),});
				} else {
					item.setText(new String[] {item.getText(ModelChoiceTab.TABLELIBNAME),
							currentFile.getFullPath().toString(),});
				}
			}
		}
	}

	/**
	 * Returns TRUE if the model/metamodel is already existing in the Atl transformation.
	 * 
	 * @param name
	 *            item name
	 * @param type
	 *            item type
	 * @return TRUE if the model/metamodel is already existing in the Atl transformation
	 */
	private boolean isAlreadyInTransformation(String name, String type) {
		for (int i = 0; i < tablePath.getItemCount(); i++) {
			String nameItem = tablePath.getItem(i).getText(ModelChoiceTab.TABLEPATHNAME);
			String typeItem = tablePath.getItem(i).getText(ModelChoiceTab.TABLEPATHTYPE);
			if (name.equals(nameItem) && (typeItem.equals(type))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the type of the model in parameter.
	 * 
	 * @param type
	 * @param typeModel
	 * @return the type of the model in parameter
	 */
	private String currentType(int type, String typeModel) {
		String currentType;
		if (type == ModelChoiceTab.INPUT) {
			if (typeModel.equals(ModelChoiceTab.MODEL)) {
				currentType = ModelChoiceTab.MODEL_INPUT;
			} else {
				currentType = ModelChoiceTab.METAMODEL_INPUT;
			}
		} else if (typeModel.equals(ModelChoiceTab.MODEL)) {
			currentType = ModelChoiceTab.MODEL_OUTPUT;
		} else {
			currentType = ModelChoiceTab.METAMODEL_OUTPUT;
		}
		return currentType;
	}

	/**
	 * Returns TRUE if the tuple (model, metamodel) is already in the table.
	 * 
	 * @param mName
	 *            model name
	 * @param mmName
	 *            metamodel name
	 * @param table
	 *            where is the model and metamodel
	 * @return TRUE if the tuple (model, metamodel) is already in the table
	 */
	private boolean tupleAlreadyInTable(String mName, String mmName, Table table) {
		for (int i = 0; i < table.getItemCount(); i++) {
			if (mName.equals(table.getItem(i).getText(ModelChoiceTab.TABLEMODELNAME))
					&& mmName.equals(table.getItem(i).getText(ModelChoiceTab.TABLEMETAMODELNAME))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Add the model and metamodel to the table.
	 * 
	 * @param se
	 * @param tableParam
	 * @param model
	 * @param metaModel
	 * @param type
	 */
	private void addTextTable(SelectionEvent se, Table tableParam, Text model, Text metaModel, int type) {

		if (model.getText().equals("")) { //$NON-NLS-1$
			AtlLauncherTools.messageBox(AtlDebugMessages.getString("ModelChoiceTab.GIVEMODEL")); //$NON-NLS-1$
			return;
		}

		if (metaModel.getText().equals("")) { //$NON-NLS-1$
			AtlLauncherTools.messageBox(AtlDebugMessages.getString("ModelChoiceTab.GIVEMETAMODEL")); //$NON-NLS-1$
			return;
		}

		String modelName = model.getText();
		String metaModelName = metaModel.getText();

		if (tupleAlreadyInTable(modelName, metaModelName, tableParam)) {
			AtlLauncherTools.messageBox(AtlDebugMessages.getString("ModelChoiceTab.ALREADYINTABLE")); //$NON-NLS-1$
			return;
		}

		TableItem item = new TableItem(tableParam, SWT.NONE);
		item.setText(new String[] {modelName, metaModelName});

		String currentType = currentType(type, ModelChoiceTab.MODEL);

		if (!isAlreadyInTransformation(modelName, ModelChoiceTab.MODEL_INPUT)
				&& !isAlreadyInTransformation(modelName, ModelChoiceTab.MODEL_OUTPUT)) {
			item = new TableItem(tablePath, SWT.NONE);
			item.setText(TABLEPATHNAME, modelName);
			item.setText(TABLEPATHPATH, ""); //$NON-NLS-1$
			item.setText(TABLEPATHMODELHANDLER, ""); //$NON-NLS-1$
			item.setText(TABLEPATHTYPE, currentType);
		}

		currentType = currentType(type, ModelChoiceTab.METAMODEL);
		if (!isAlreadyInTransformation(metaModelName, ModelChoiceTab.METAMODEL_INPUT)
				&& !isAlreadyInTransformation(metaModelName, ModelChoiceTab.METAMODEL_OUTPUT)) {
			if (!isMetaModelOfRepository(metaModelName)) {
				TableItem itemPath = new TableItem(tablePath, SWT.NONE);
				itemPath.setText(TABLEPATHNAME, metaModelName);
				itemPath.setText(TABLEPATHPATH, ""); //$NON-NLS-1$
				itemPath.setText(TABLEPATHMODELHANDLER, "EMF"); //$NON-NLS-1$
				itemPath.setText(TABLEPATHTYPE, currentType);
			}
		}

		model.setText(""); //$NON-NLS-1$
		metaModel.setText(""); //$NON-NLS-1$

	}

	/**
	 * This function checks if the parameter is recognized in the repository.
	 * 
	 * @param metaModel
	 * @return
	 */
	private boolean isMetaModelOfRepository(String metaModel) {
		/*
		 * TODO isMetaModelOfRepository For the moment only metamodels MOF and ATL are recognized
		 */
		return false;
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
			Map input = configuration.getAttribute(AtlLauncherTools.INPUT, new HashMap());
			Map output = configuration.getAttribute(AtlLauncherTools.OUTPUT, new HashMap());
			Map path = configuration.getAttribute(AtlLauncherTools.PATH, new HashMap());
			Map type = configuration.getAttribute(AtlLauncherTools.MODELTYPE, new HashMap());
			Map modelHandler = configuration.getAttribute(AtlLauncherTools.MODELHANDLER, new HashMap());
			Map lib = configuration.getAttribute(AtlLauncherTools.LIBS, new HashMap());

			tableIn.removeAll();
			for (Iterator i = input.keySet().iterator(); i.hasNext();) {
				String mName = (String)i.next();
				TableItem item = new TableItem(tableIn, SWT.NONE);
				item.setText(TABLEMODELNAME, mName);
				item.setText(TABLEMETAMODELNAME, (String)input.get(mName));
			}

			tableOut.removeAll();
			for (Iterator i = output.keySet().iterator(); i.hasNext();) {
				String mName = (String)i.next();
				TableItem item = new TableItem(tableOut, SWT.NONE);
				item.setText(TABLEMODELNAME, mName);
				item.setText(TABLEMETAMODELNAME, (String)output.get(mName));
			}

			tablePath.removeAll();
			if (type.size() == path.size()) {
				for (Iterator i = path.keySet().iterator(); i.hasNext();) {
					String mName = (String)i.next();
					TableItem item = new TableItem(tablePath, SWT.NONE);
					item.setText(TABLEPATHNAME, mName);
					item.setText(TABLEPATHPATH, (String)path.get(mName));
					item.setText(TABLEPATHMODELHANDLER, (String)modelHandler.get(mName));
					item.setText(TABLEPATHTYPE, (String)type.get(mName));
				}
			}
			tableLib.removeAll();
			for (Iterator i = lib.keySet().iterator(); i.hasNext();) {
				String mName = (String)i.next();
				TableItem item = new TableItem(tableLib, SWT.NONE);
				item.setText(TABLELIBNAME, mName);
				item.setText(TABLELIBPATH, (String)lib.get(mName));
			}

			canSave();
			updateLaunchConfigurationDialog();
		} catch (CoreException e) {
			tableIn.removeAll();
			tableOut.removeAll();
			tablePath.removeAll();
			tableLib.removeAll();
			ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {

		inputModels = new HashMap();
		outputModels = new HashMap();
		modelPathMap = new HashMap();
		modelTypeMap = new HashMap();
		modelHandlerMap = new HashMap();
		libPathMap = new HashMap();

		for (int i = 0; i < tableIn.getItemCount(); i++) {
			TableItem ti = tableIn.getItem(i);
			inputModels.put(ti.getText(TABLEMODELNAME), ti.getText(TABLEMETAMODELNAME));
		}

		for (int i = 0; i < tableOut.getItemCount(); i++) {
			TableItem ti = tableOut.getItem(i);
			outputModels.put(ti.getText(TABLEMODELNAME), ti.getText(TABLEMETAMODELNAME));
		}

		for (int i = 0; i < tablePath.getItemCount(); i++) {
			TableItem ti = tablePath.getItem(i);
			modelPathMap.put(ti.getText(TABLEPATHNAME), ti.getText(TABLEPATHPATH));
			modelTypeMap.put(ti.getText(TABLEPATHNAME), ti.getText(TABLEPATHTYPE));
			modelHandlerMap.put(ti.getText(TABLEPATHNAME), ti.getText(TABLEPATHMODELHANDLER));
		}
		for (int i = 0; i < tableLib.getItemCount(); i++) {
			TableItem ti = tableLib.getItem(i);
			libPathMap.put(ti.getText(TABLELIBNAME), ti.getText(TABLELIBPATH));
		}

		configuration.setAttribute(AtlLauncherTools.INPUT, inputModels);
		configuration.setAttribute(AtlLauncherTools.OUTPUT, outputModels);
		configuration.setAttribute(AtlLauncherTools.PATH, modelPathMap);
		configuration.setAttribute(AtlLauncherTools.MODELTYPE, modelTypeMap);
		configuration.setAttribute(AtlLauncherTools.MODELHANDLER, modelHandlerMap);
		configuration.setAttribute(AtlLauncherTools.LIBS, libPathMap);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return AtlLauncherTools.MODELCHOICETABNAME;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#canSave()
	 */
	public boolean canSave() {
		if (tablePath.getItemCount() == 0) {
			this.setMessage(AtlDebugMessages.getString("ModelChoiceTab.WARNING_GIVEMODELS")); //$NON-NLS-1$
		} else {
			this.setErrorMessage(AtlDebugMessages.getString("ModelChoiceTab.GIVEPATHMODELS")); //$NON-NLS-1$
			for (int i = 0; i < tablePath.getItemCount(); i++) {
				if (tablePath.getItem(i).getText(TABLEPATHPATH).equals("")) { //$NON-NLS-1$
					return false;
				}
			}
		}

		if (tableLib.getItemCount() != 0) {
			for (int i = 0; i < tableLib.getItemCount(); i++) {
				if (tableLib.getItem(i).getText(TABLELIBPATH).equals("")) { //$NON-NLS-1$
					this.setErrorMessage(AtlDebugMessages.getString("ModelChoiceTab.GIVEPATHLIBS")); //$NON-NLS-1$
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
	public Image getImage() {
		return AtlLauncherTools.createImage(AtlLauncherTools.PATHICONATL);
	}

}
