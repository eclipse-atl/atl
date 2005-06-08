/*
 * Created on 4 juin 2004
 * 
 */

package org.atl.eclipse.adt.launching;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.atl.eclipse.adt.debug.Messages;
import org.atl.eclipse.engine.AtlModelHandler;
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
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.MessageBox;
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
 * This class is a tab that appears in the ATL Configuration.
 * This tab allows to set the model and metamodel input and output.
 * For each model
 * 
 * @author allilaire
 */
public class ModelChoiceTab extends AbstractLaunchConfigurationTab {

	/** Map input : Model --> MetaModel */
	private Map input = new HashMap();
	/** Map output : Model --> MetaModel */
	private Map output = new HashMap();
	/** Map modelPath : Model/MetaModel --> Path */
	private Map modelPath = new HashMap();
	/** Map modelType : Model/MetaModel --> Type */
	private Map modelType = new HashMap();
	/** Map modelHandler : Metamodel --> ModelHandler*/
	private Map modelHandler = new HashMap();
	/** Map libPath : lib --> Path */
	private Map libPath = new HashMap();

	final static int INPUT = 0;
	final static int OUTPUT = 1;
	
	final static String MODEL = "MODEL";
	final static String METAMODEL = "METAMODEL";
	final static String LIB = "LIB";
	public final static String MODEL_OUTPUT = "MODELOUTPUT";
	public final static String MODEL_INPUT = "MODELINPUT";
	public final static String METAMODEL_OUTPUT = "METAMODELOUTPUT";
	public final static String METAMODEL_INPUT = "METAMODELINPUT";

	/*
	 * These constants represent the index of the columns in different table
	 * */
	final static int TABLEPATHNAME = 0;
	final static int TABLEPATHPATH = 1;
	final static int TABLEPATHMODELHANDLER = 2;
	final static int TABLEPATHTYPE = 3;
	
	final static int TABLEMODELNAME = 0;
	final static int TABLEMETAMODELNAME = 1;
	
	final static int TABLELIBNAME = 0;
	final static int TABLELIBPATH = 1;
	
	/*
	 * Graphic components
	 * */
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
	
	private Group groupLib;
	private Table tableLib;
	private Text textLib;
	private Label labelLib;
	private Button buttonLib;
	private Button buttonPathLib;
	private Button buttonRemoveLib;
	private Button buttonExternalPathLib;

	/**
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
		buttonIn = new Button(groupIn, SWT.NULL);
		buttonRemoveIn = new Button(groupIn, SWT.NULL);
		tableIn = new Table(groupIn, SWT.FULL_SELECTION | SWT.BORDER);
		
		groupOut = new Group(container, SWT.NULL);
		labelModelOut = new Label(groupOut, SWT.END);
		textModelOut = new Text(groupOut, SWT.BORDER);
		labelMetaModelOut = new Label(groupOut, SWT.END);
		textMetaModelOut = new Text(groupOut, SWT.BORDER);
		buttonOut = new Button(groupOut, SWT.CENTER);
		buttonRemoveOut = new Button(groupOut, SWT.NULL);
		tableOut = new Table(groupOut, SWT.FULL_SELECTION | SWT.BORDER);
		
		groupPath = new Group(container, SWT.NULL);
		tablePath = new Table(groupPath, SWT.FULL_SELECTION | SWT.BORDER);
		Composite panelTablePath = new Composite(groupPath, SWT.NULL);
		listModelHandlerAvailables = new List(panelTablePath, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
		buttonSelectModelHandler = new Button(panelTablePath, SWT.CENTER);
		buttonSetPath = new Button(panelTablePath, SWT.CENTER);
		buttonSetExternalPath = new Button(panelTablePath, SWT.CENTER);
		buttonIsMDR = new Button(panelTablePath, SWT.CENTER);
		buttonIsEMF = new Button(panelTablePath, SWT.CENTER);
		
		groupLib = new Group(container, SWT.NULL);
		labelLib = new Label(groupLib, SWT.END);
		textLib = new Text(groupLib, SWT.BORDER);
		buttonLib = new Button(groupLib, SWT.CENTER);
		tableLib = new Table(groupLib, SWT.FULL_SELECTION | SWT.BORDER);
		buttonPathLib = new Button(groupLib, SWT.CENTER);
		buttonRemoveLib = new Button(groupLib, SWT.CENTER);
		buttonExternalPathLib = new Button(groupLib, SWT.CENTER);
		
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.makeColumnsEqualWidth = true;
		
		container.setLayout(layout);
		
		GridData gdIn = new GridData(GridData.FILL_BOTH);
		GridData gdOut = new GridData(GridData.FILL_BOTH);
		GridData gdPath = new GridData(GridData.FILL_BOTH);
		GridData gdLib = new GridData(GridData.FILL_BOTH);

		groupIn.setLayoutData(gdIn);
		groupOut.setLayoutData(gdOut);
		groupPath.setLayoutData(gdPath);
		groupLib.setLayoutData(gdLib);
		
		/***********************************************************************
		 * Form layout definition
		 **********************************************************************/
		
		FormLayout groupLayout = new FormLayout();

		groupIn.setLayout(groupLayout);
		groupOut.setLayout(groupLayout);
		groupPath.setLayout(groupLayout);
		groupLib.setLayout(groupLayout);

		FormData labelLData = AtlLauncherTools.createFormData(0, 25, 0, 10);
		FormData textLData = AtlLauncherTools.createFormData(25, 50, 0, 10);
		FormData label2LData = AtlLauncherTools.createFormData(50, 75, 0, 10);
		FormData text2LData = AtlLauncherTools.createFormData(75, 100, 0, 10);
		FormData buttonLData = AtlLauncherTools.createFormData(80, 100, 20, 30);
		FormData buttonRemoveLData = AtlLauncherTools.createFormData(80, 100, 35, 45);
		FormData buttonMH1LData = AtlLauncherTools.createFormData(80, 100, 50, 60);
		FormData buttonMH2LData = AtlLauncherTools.createFormData(80, 100, 65, 75);
		FormData tableLData = AtlLauncherTools.createFormData(0, 70, 20, 100);
		
		/***********************************************************************
		 * GroupIn
		 **********************************************************************/
		
		groupIn.setText(Messages.getString("ModelChoiceTab.IN")); //$NON-NLS-1$

		labelModelIn.setText(Messages.getString("ModelChoiceTab.MODELCOLON")); //$NON-NLS-1$
		
		labelMetaModelIn.setText(Messages.getString("ModelChoiceTab.METAMODELCOLON")); //$NON-NLS-1$
		
		buttonIn.setText(Messages.getString("ModelChoiceTab.ADD")); //$NON-NLS-1$
		buttonIn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				addTextTable(evt, tableIn, textModelIn, textMetaModelIn, INPUT);
				canSave();
				updateLaunchConfigurationDialog();
			}
		});

		buttonRemoveIn.setText(Messages.getString("ModelChoiceTab.REMOVE")); //$NON-NLS-1$
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
		
		//ModelChoiceTab.TABLEMODELNAME
		TableColumn modelNameIn = new TableColumn(tableIn, SWT.CENTER);
		modelNameIn.setText(Messages.getString("ModelChoiceTab.MODEL")); //$NON-NLS-1$

		//ModelChoiceTab.TABLEMETAMODELNAME
		TableColumn mmodelNameIn = new TableColumn(tableIn, SWT.CENTER);
		mmodelNameIn.setText(Messages.getString("ModelChoiceTab.META_MODEL")); //$NON-NLS-1$
		
		labelModelIn.setLayoutData(labelLData);
		textMetaModelIn.setLayoutData(text2LData);
		labelMetaModelIn.setLayoutData(label2LData);
		textModelIn.setLayoutData(textLData);

		tableIn.setLayoutData(tableLData);

		buttonIn.setLayoutData(buttonLData);
		buttonRemoveIn.setLayoutData(buttonRemoveLData);
		
		/***********************************************************************
		 * GroupOut
		 **********************************************************************/

		groupOut.setText(Messages.getString("ModelChoiceTab.OUT")); //$NON-NLS-1$

		labelModelOut.setText(Messages.getString("ModelChoiceTab.MODELCOLON")); //$NON-NLS-1$

		labelMetaModelOut.setText(Messages.getString("ModelChoiceTab.METAMODELCOLON")); //$NON-NLS-1$
		
		buttonOut.setText(Messages.getString("ModelChoiceTab.ADD")); //$NON-NLS-1$
		buttonOut.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				addTextTable(evt, tableOut, textModelOut, textMetaModelOut,	OUTPUT);
				canSave();
				updateLaunchConfigurationDialog();
			}
		});
		
		buttonRemoveOut.setText(Messages.getString("ModelChoiceTab.REMOVE")); //$NON-NLS-1$
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

		//ModelChoiceTab.TABLEMODELNAME
		TableColumn modelName = new TableColumn(tableOut, SWT.CENTER);
		modelName.setText(Messages.getString("ModelChoiceTab.MODEL")); //$NON-NLS-1$
		
		//ModelChoiceTab.TABLEMETAMODELNAME
		TableColumn metaModelName = new TableColumn(tableOut, SWT.CENTER);
		metaModelName.setText(Messages.getString("ModelChoiceTab.META_MODEL")); //$NON-NLS-1$

		labelModelOut.setLayoutData(labelLData);
		textModelOut.setLayoutData(textLData);
		labelMetaModelOut.setLayoutData(label2LData);
		textMetaModelOut.setLayoutData(text2LData);

		tableOut.setLayoutData(tableLData);

		buttonOut.setLayoutData(buttonLData);
		buttonRemoveOut.setLayoutData(buttonRemoveLData);
		/***********************************************************************
		 * GroupPath
		 **********************************************************************/
		
		groupPath.setText(Messages.getString("ModelChoiceTab.PATH_EDITOR")); //$NON-NLS-1$
		
		panelTablePath.setLayoutData(AtlLauncherTools.createFormData(70, 100, 0, 100));
		
		GridLayout gd = new GridLayout();
		gd.numColumns = 1;
		panelTablePath.setLayout(gd);
		
		buttonSetPath.setText(Messages.getString("ModelChoiceTab.SET_PATH")); //$NON-NLS-1$
		buttonSetPath.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				editPath(ModelChoiceTab.MODEL, tablePath);
				canSave();
				updateLaunchConfigurationDialog();
			}
		});
		
		buttonSetExternalPath.setText(Messages.getString("ModelChoiceTab.SET_EXTERNAL_PATH")); //$NON-NLS-1$
		buttonSetExternalPath.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				editExternalPath(ModelChoiceTab.MODEL, tablePath);
				canSave();
				updateLaunchConfigurationDialog();
			}
		});
		
		buttonIsMDR.setText("MM Is MOF-1.4");
		buttonIsMDR.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				metamodelIsMetametamodel("MDR");
				canSave();
				updateLaunchConfigurationDialog();
			}
		});
		
		buttonIsEMF.setText("MM is Ecore");
		buttonIsEMF.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				metamodelIsMetametamodel("EMF");
				canSave();
				updateLaunchConfigurationDialog();
			}
		});
		
		listModelHandlerAvailables.setItems(AtlModelHandler.getModelHandlers());
		
		buttonSelectModelHandler.setText("Select Model Handler");
		buttonSelectModelHandler.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				selectModelHandler();
				canSave();
				updateLaunchConfigurationDialog();
			}
		});
		
		tableLayout = new TableLayout();
		tablePath.setLayout(tableLayout);
		tableLayout.addColumnData(new ColumnWeightData(50));
		tableLayout.addColumnData(new ColumnWeightData(100));
		tableLayout.addColumnData(new ColumnWeightData(50));
		tablePath.setLinesVisible(true);
		tablePath.setHeaderVisible(true);
		
		//ModelChoiceTab.TABLEPATHNAME
		TableColumn modelPathName = new TableColumn(tablePath, SWT.CENTER);
		modelPathName.setText(Messages.getString("ModelChoiceTab.MODEL")); //$NON-NLS-1$
		
		//ModelChoiceTab.TABLEPATHPATH
		TableColumn pathName = new TableColumn(tablePath, SWT.LEFT);
		pathName.setText(Messages.getString("ModelChoiceTab.PATH")); //$NON-NLS-1$
		
		//ModelChoiceTab.TABLEPATHMODELHANDLER
		TableColumn modelHandler = new TableColumn(tablePath, SWT.CENTER);
		modelHandler.setText("Model Handler");
		
		//ModelChoiceTab.TABLEPATHTYPE
		TableColumn modelType = new TableColumn(tablePath, SWT.NULL);
		modelType.setText("Type");
		modelType.setWidth(0);
		modelType.setResizable(false);
		
		tablePath.setLayoutData(AtlLauncherTools.createFormData(0, 70, 0, 100));
		buttonSetPath.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		buttonSetExternalPath.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		buttonIsMDR.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		buttonIsEMF.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		GridData gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.heightHint = listModelHandlerAvailables.getItemHeight() * 2;
		listModelHandlerAvailables.setLayoutData(gData);
		buttonSelectModelHandler.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		/***********************************************************************
		 * GroupLibs
		 **********************************************************************/

		groupLib.setText(Messages.getString("ModelChoiceTab.LIBS")); //$NON-NLS-1$

		labelLib.setText(Messages.getString("ModelChoiceTab.LIBCOLON")); //$NON-NLS-1$

		buttonLib.setText(Messages.getString("ModelChoiceTab.ADD")); //$NON-NLS-1$
		buttonLib.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				addLib();
				canSave();
				updateLaunchConfigurationDialog();
			}
		});
		
		buttonPathLib.setText(Messages.getString("ModelChoiceTab.SET_PATH")); //$NON-NLS-1$
		buttonPathLib.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				editPath(ModelChoiceTab.LIB, tableLib);
				canSave();
				updateLaunchConfigurationDialog();
			}
		});
		
		buttonExternalPathLib.setText(Messages.getString("ModelChoiceTab.SET_EXTERNAL_PATH")); //$NON-NLS-1$
		buttonExternalPathLib.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				editExternalPath(ModelChoiceTab.LIB, tableLib);
				canSave();
				updateLaunchConfigurationDialog();
			}
		});
		
		buttonRemoveLib.setText(Messages.getString("ModelChoiceTab.REMOVE_LIB")); //$NON-NLS-1$
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

		//ModelChoiceTab.TABLELIBNAME
		TableColumn libName = new TableColumn(tableLib, SWT.CENTER);
		libName.setText(Messages.getString("ModelChoiceTab.LIBS")); //$NON-NLS-1$

		//ModelChoiceTab.TABLELIBPATH
		TableColumn pathLib = new TableColumn(tableLib, SWT.LEFT);
		pathLib.setText(Messages.getString("ModelChoiceTab.PATH")); //$NON-NLS-1$

		labelLib.setLayoutData(labelLData);
		textLib.setLayoutData(textLData);
		buttonLib.setLayoutData(label2LData);

		tableLib.setLayoutData(tableLData);

		buttonPathLib.setLayoutData(buttonLData);
		buttonRemoveLib.setLayoutData(AtlLauncherTools.createFormData(80, 100, 50, 60));
		buttonExternalPathLib.setLayoutData(buttonRemoveLData);
		
		/** ***************************************** */
		groupIn.layout();
		groupPath.layout();
		groupOut.layout();
		groupLib.layout();
		groupIn.pack();
		groupPath.pack();
		groupOut.pack();
		groupLib.pack();
		
		container.layout();
		setControl(container);

		container.pack();
		canSave();

	}

	/**
	 * Delete a lib in the table
	 */
	private void removeLib() {
		int index = tableLib.getSelectionIndex();
		
		if (index == -1) {
			AtlLauncherTools.messageBox(Messages.getString("ModelChoiceTab.CHOOSEMODEL")); //$NON-NLS-1$
			return;
		}

		MessageBox msgBox = new MessageBox(this.getShell(),	SWT.APPLICATION_MODAL | SWT.YES | SWT.NO);
		msgBox.setText(Messages.getString("ModelChoiceTab.ERROR")); //$NON-NLS-1$
		msgBox.setMessage(Messages.getString("ModelChoiceTab.REMOVELIB")); //$NON-NLS-1$
		if (msgBox.open() != SWT.YES)
			return;

		tableLib.remove(index);
	}
	
	/**
	 * Delete a model and metamodel from the table in parameter
	 * @param evt
	 * @param table where the model and metamodel are deleted
	 */
	private void removeTextTable(SelectionEvent evt, Table table) {
		int index = table.getSelectionIndex();
		
		if (index == -1) {
			AtlLauncherTools.messageBox(Messages.getString("ModelChoiceTab.CHOOSEMODEL")); //$NON-NLS-1$
			return;
		}

		MessageBox msgBox = new MessageBox(this.getShell(),	SWT.APPLICATION_MODAL | SWT.YES | SWT.NO);
		msgBox.setText(Messages.getString("ModelChoiceTab.ERROR")); //$NON-NLS-1$
		msgBox.setMessage(Messages.getString("ModelChoiceTab.REMOVEMODEL")); //$NON-NLS-1$
		if (msgBox.open() != SWT.YES)
			return;
		
		TableItem item = table.getItem(index);
		String modelName = item.getText(ModelChoiceTab.TABLEMODELNAME);
		String metaModelName = item.getText(ModelChoiceTab.TABLEMETAMODELNAME);
		
		int indexModel = -1;
		int indexMetaModel = -1;

		TableItem items[] = tablePath.getItems();

		if (!isMultipleInstance(modelName, ModelChoiceTab.MODEL)) {
		
			for (int i=0; i<items.length; i++) {
				String nameItem = items[i].getText(ModelChoiceTab.TABLEPATHNAME);
				String typeItem = items[i].getText(ModelChoiceTab.TABLEPATHTYPE);
				if (modelName.equals(nameItem) && (typeItem.equals(ModelChoiceTab.MODEL_INPUT) || typeItem.equals(ModelChoiceTab.MODEL_OUTPUT)))
					indexModel = i;
			}
			
			if (indexModel != -1)
				tablePath.remove(indexModel);
		}
		if (!isMultipleInstance(metaModelName, ModelChoiceTab.METAMODEL)) {
			items = tablePath.getItems();
			
			for (int i=0; i<items.length; i++) {
				String nameItem = items[i].getText(ModelChoiceTab.TABLEPATHNAME);
				String typeItem = items[i].getText(ModelChoiceTab.TABLEPATHTYPE);
				if (metaModelName.equals(nameItem) && (typeItem.equals(ModelChoiceTab.METAMODEL_INPUT) || typeItem.equals(ModelChoiceTab.METAMODEL_OUTPUT)))
					indexMetaModel = i;
			}
			
			if (indexMetaModel != -1)
				tablePath.remove(indexMetaModel);
		}
		table.remove(index);
	}

	/**
	 * 
	 * @param text name of the model
	 * @param type of the model (model/metamodel)
	 * @param table the table where is the model
	 * @return TRUE if text is two or more model or metamodel in table in and table out
	 */
	private boolean isMultipleInstance(String text, String type) {
		int textIndex;

		if (type.equals(ModelChoiceTab.MODEL))
			textIndex = TABLEMODELNAME;
		else
			textIndex = TABLEMETAMODELNAME;
		
		boolean ok = false;
		for (int i=0; i < tableOut.getItemCount(); i++)
			if (text.equals(tableOut.getItem(i).getText(textIndex)))
				if (ok)
					return true;
				else
					ok = true;

		for (int i=0; i < tableIn.getItemCount(); i++)
			if (text.equals(tableIn.getItem(i).getText(textIndex)))
				if (ok)
					return true;
				else
					ok = true;
		return false;
	}
	
	/**
	 * Add lib to the table Lib
	 *
	 */
	private void addLib() {
		String lib = textLib.getText();
		if (lib.equals("")) { //$NON-NLS-1$
			AtlLauncherTools.messageBox(Messages.getString("ModelChoiceTab.GIVELIB")); //$NON-NLS-1$
			return;
		}
		
		TableItem item = new TableItem(tableLib, SWT.NONE);
		item.setText(new String[]{lib, ""}); //$NON-NLS-1$
		
		textLib.setText(""); //$NON-NLS-1$
	}
	
	private void metamodelIsMetametamodel(String metamodel) {
		int index = tablePath.getSelectionIndex();
		
		if (index == -1) {
			AtlLauncherTools.messageBox(Messages.getString("ModelChoiceTab.CHOOSE") + "Metamodel");
			return;
		}
		
		if (MODEL_INPUT.equals(tablePath.getItem(index).getText(TABLEPATHTYPE)) || MODEL_OUTPUT.equals(tablePath.getItem(index).getText(TABLEPATHTYPE))) {
			AtlLauncherTools.messageBox("This action is only available on metamodel");
			return;
		}
		
		tablePath.getItem(index).setText(TABLEPATHPATH, "#"+metamodel);
		tablePath.getItem(index).setText(TABLEPATHMODELHANDLER, metamodel);
	}
	
	private void selectModelHandler() {
		int index = tablePath.getSelectionIndex();
		
		if (index == -1) {
			AtlLauncherTools.messageBox(Messages.getString("ModelChoiceTab.CHOOSE") + "Metamodel");
			return;
		}
		
		if (MODEL_INPUT.equals(tablePath.getItem(index).getText(TABLEPATHTYPE)) || MODEL_OUTPUT.equals(tablePath.getItem(index).getText(TABLEPATHTYPE))) {
			AtlLauncherTools.messageBox("This action is only available on metamodel");
			return;
		}
		
		String selection[] = listModelHandlerAvailables.getSelection();
		if (selection.length == 1) {
			tablePath.getItem(index).setText(TABLEPATHMODELHANDLER, selection[0]);
			if (tablePath.getItem(index).getText(TABLEPATHPATH).startsWith("#"))
				tablePath.getItem(index).setText(TABLEPATHPATH, "#"+selection[0]);
		}
		else {
			AtlLauncherTools.messageBox("Please select a model handler");
			return;
		}
	}
	
	/**
	 * This method edit the path of a model. The path can be external at the workspace 
	 * @param type
	 * @param table
	 */
	private void editExternalPath(final String type, Table table) {
		int index = table.getSelectionIndex();
		
		if (index == -1) {
			AtlLauncherTools.messageBox(Messages.getString("ModelChoiceTab.CHOOSE") + type); //$NON-NLS-1$
			return;
		}

		if (type.equals(ModelChoiceTab.MODEL) && table.getItem(index).getText(ModelChoiceTab.TABLEPATHTYPE).equals(ModelChoiceTab.MODEL_OUTPUT)) {
			SaveAsDialog sad = new SaveAsDialog(getShell());
			sad.open();
			IPath outputPath = sad.getResult();
			if (outputPath != null) {
				TableItem item = table.getItem(index);
				item.setText(new String[]{item.getText(ModelChoiceTab.TABLEPATHNAME), outputPath.toFile().getName(), item.getText(TABLEPATHMODELHANDLER), item.getText(ModelChoiceTab.TABLEPATHTYPE)});
			}
			else
				AtlLauncherTools.messageBox(Messages.getString("ModelChoiceTab.CHOOSE") + type); //$NON-NLS-1$
		}
		else {
			FileDialog fileDialog = new FileDialog(this.getShell());
			fileDialog.setText(Messages.getString("ModelChoiceTab.CHOOSEMETAMODEL")); //$NON-NLS-1$
			fileDialog.setFilterExtensions(new String[]{"*.xmi", "*.ecore"}); //$NON-NLS-1$
			String fileName = fileDialog.open();
			if (fileName == null)
				return;
			fileName = "ext:" + fileName; //$NON-NLS-1$

			if ((fileName != null)) {
				TableItem item = table.getItem(index);
				
				if (type.equals(ModelChoiceTab.MODEL))
					item.setText(new String[]{item.getText(ModelChoiceTab.TABLEPATHNAME), fileName, item.getText(TABLEPATHMODELHANDLER), item.getText(ModelChoiceTab.TABLEPATHTYPE)});
				else
					item.setText(new String[]{item.getText(ModelChoiceTab.TABLELIBNAME), fileName});
			}
			else
				AtlLauncherTools.messageBox(Messages.getString("ModelChoiceTab.CHOOSE") + type); //$NON-NLS-1$
		}
	}
	
	/**
	 * This method edit the path of the model selected. The path corresponding the a file in the workspace 
	 * @param type
	 * @param table
	 */
	private void editPath(final String type, Table table) {
		int index = table.getSelectionIndex();
		
		if (index == -1) {
			AtlLauncherTools.messageBox(Messages.getString("ModelChoiceTab.CHOOSE") + type); //$NON-NLS-1$
			return;
		}

		if (type.equals(ModelChoiceTab.MODEL) && table.getItem(index).getText(ModelChoiceTab.TABLEPATHTYPE).equals(ModelChoiceTab.MODEL_OUTPUT)) {
			SaveAsDialog sad = new SaveAsDialog(getShell());
			sad.open();
			IPath outputPath = sad.getResult();
			if (outputPath != null) {
				TableItem item = table.getItem(index);
				item.setText(new String[]{item.getText(ModelChoiceTab.TABLEPATHNAME), outputPath.toString(), item.getText(TABLEPATHMODELHANDLER), item.getText(ModelChoiceTab.TABLEPATHTYPE)});
			}
			else
				AtlLauncherTools.messageBox(Messages.getString("ModelChoiceTab.CHOOSE") + type); //$NON-NLS-1$
		}
		else {
			ElementTreeSelectionDialog elementTreeSelectionDialog = new ElementTreeSelectionDialog(	getShell(), new WorkbenchLabelProvider(), new WorkbenchContentProvider());
			elementTreeSelectionDialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
			elementTreeSelectionDialog.setMessage(Messages.getString("ModelChoiceTab.CHOOSE") + type); //$NON-NLS-1$
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
						if (type ==ModelChoiceTab.LIB)
							ret = (currentFile.getFileExtension().toUpperCase()).equals("ASM");
						else
							ret = (
									(currentFile.getFileExtension().toUpperCase()).equals("XMI")
									||
									(currentFile.getFileExtension().toUpperCase()).equals("ECORE")
									);
					}
					return ret;
				}
			});
			elementTreeSelectionDialog.setValidator(new ISelectionStatusValidator() {
				public IStatus validate(Object[] selection) {
					IStatus ret = Status.CANCEL_STATUS;
					
					if(selection.length == 1) {
						if(selection[0] instanceof IFile) {	// no need to verify again extension here
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
					
					if (type.equals(ModelChoiceTab.MODEL))
						item.setText(new String[]{item.getText(ModelChoiceTab.TABLEPATHNAME), currentFile.getFullPath().toString(), item.getText(TABLEPATHMODELHANDLER), item.getText(ModelChoiceTab.TABLEPATHTYPE)});
					else
						item.setText(new String[]{item.getText(ModelChoiceTab.TABLELIBNAME), currentFile.getFullPath().toString()});
			}
		}
	}

	/**
	 * 
	 * @param name
	 * @param type
	 * @return TRUE if the model/metamodel is already existing in the Atl transformation
	 */
	private boolean isAlreadyInTransformation(String name, String type) {
		for (int i=0; i < tablePath.getItemCount(); i++) {
			String nameItem = tablePath.getItem(i).getText(ModelChoiceTab.TABLEPATHNAME);
			String typeItem = tablePath.getItem(i).getText(ModelChoiceTab.TABLEPATHTYPE);
			if (name.equals(nameItem) && (typeItem.equals(type)))
				return true;
		}
		return false;
	}

	/**
	 * 
	 * @param type
	 * @param typeModel
	 * @return the type of the model in parameter
	 */
	private String currentType( int type, String typeModel) {
		String currentType;
		if (type == ModelChoiceTab.INPUT)
			if (typeModel.equals(ModelChoiceTab.MODEL))
				currentType = ModelChoiceTab.MODEL_INPUT;
			else
				currentType = ModelChoiceTab.METAMODEL_INPUT;
		else
			if (typeModel.equals(ModelChoiceTab.MODEL))
				currentType = ModelChoiceTab.MODEL_OUTPUT;
			else
				currentType = ModelChoiceTab.METAMODEL_OUTPUT;
		return currentType;
	}
	
	/**
	 * 
	 * @param mName model name
	 * @param mmName metamodel name
	 * @param table where is the model and metamodel
	 * @return TRUE if the tuple (model, metamodel) is already in the table
	 */
	private boolean tupleAlreadyInTable(String mName, String mmName, Table table) {
		for (int i=0; i < table.getItemCount(); i++)
			if (mName.equals(table.getItem(i).getText(ModelChoiceTab.TABLEMODELNAME)) && mmName.equals(table.getItem(i).getText(ModelChoiceTab.TABLEMETAMODELNAME)))
				return true;
		
		return false;
	}
	
	/**
	 * Add the model and metamodel to the table
	 * @param se
	 * @param tableParam
	 * @param model
	 * @param metaModel
	 * @param type
	 */
	private void addTextTable(SelectionEvent se, Table tableParam, Text model, Text metaModel, int type) {

		if (model.getText().equals("")) { //$NON-NLS-1$
			AtlLauncherTools.messageBox(Messages.getString("ModelChoiceTab.GIVEMODEL")); //$NON-NLS-1$
			return;
		}
		
		if (metaModel.getText().equals("")) { //$NON-NLS-1$
			AtlLauncherTools.messageBox(Messages.getString("ModelChoiceTab.GIVEMETAMODEL")); //$NON-NLS-1$
			return;
		}
		
		String modelName = model.getText();
		String metaModelName = metaModel.getText();
		
		if (tupleAlreadyInTable(modelName, metaModelName, tableParam)) {
			AtlLauncherTools.messageBox(Messages.getString("ModelChoiceTab.ALREADYINTABLE")); //$NON-NLS-1$
			return;
		}
		
		TableItem item = new TableItem(tableParam, SWT.NONE);
		item.setText(new String[]{modelName, metaModelName});
		
		String currentType = currentType(type, ModelChoiceTab.MODEL);
		
		if (!isAlreadyInTransformation(modelName, ModelChoiceTab.MODEL_INPUT) && !isAlreadyInTransformation(modelName, ModelChoiceTab.MODEL_OUTPUT)) {
			item = new TableItem(tablePath, SWT.NONE);
			item.setText(TABLEPATHNAME, modelName);
			item.setText(TABLEPATHPATH, "");
			item.setText(TABLEPATHMODELHANDLER, "");
			item.setText(TABLEPATHTYPE, currentType);
		}
		
		currentType = currentType(type, ModelChoiceTab.METAMODEL);
		if (!isAlreadyInTransformation(metaModelName, ModelChoiceTab.METAMODEL_INPUT) && !isAlreadyInTransformation(metaModelName, ModelChoiceTab.METAMODEL_OUTPUT)) {
			if (!isMetaModelOfRepository(metaModelName)) {
				TableItem itemPath = new TableItem(tablePath, SWT.NONE);
				itemPath.setText(TABLEPATHNAME, metaModelName);
				itemPath.setText(TABLEPATHPATH, "");
				itemPath.setText(TABLEPATHMODELHANDLER, "EMF");
				itemPath.setText(TABLEPATHTYPE, currentType);
			}
		}

		model.setText(""); //$NON-NLS-1$
		metaModel.setText(""); //$NON-NLS-1$
		
	}
	
	/**
	 * This function checks if the parameter is recognized in the repository
	 * 
	 * @param metaModel
	 * @return
	 */
	private boolean isMetaModelOfRepository(String metaModel) {
		/*
		 * TODO isMetaModelOfRepository
		 * For the moment only metamodels MOF and ATL are recognized
		 */
//		if (metaModel.equals("MOF"))
//			return true;
//		if (metaModel.equals("ATL"))
//			return true;
		return false;
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
			Map input = configuration.getAttribute(AtlLauncherTools.INPUT, new HashMap());
			Map output = configuration.getAttribute(AtlLauncherTools.OUTPUT, new HashMap());
			Map path = configuration.getAttribute(AtlLauncherTools.PATH, new HashMap());
			Map type = configuration.getAttribute(AtlLauncherTools.MODELTYPE, new HashMap());
			Map modelHandler = configuration.getAttribute(AtlLauncherTools.MODELHANDLER, new HashMap());
			Map lib = configuration.getAttribute(AtlLauncherTools.LIBS, new HashMap());

			tableIn.removeAll();
			for (Iterator i = input.keySet().iterator(); i.hasNext();) {
				String mName = (String) i.next();
				TableItem item = new TableItem(tableIn, SWT.NONE);
				item.setText(TABLEMODELNAME, mName);
				item.setText(TABLEMETAMODELNAME, (String) input.get(mName));
			}
			
			tableOut.removeAll();
			for (Iterator i = output.keySet().iterator(); i.hasNext();) {
				String mName = (String) i.next();
				TableItem item = new TableItem(tableOut, SWT.NONE);
				item.setText(TABLEMODELNAME, mName);
				item.setText(TABLEMETAMODELNAME, (String) output.get(mName));
			}

			tablePath.removeAll();
			if (type.size() == path.size())
				for (Iterator i = path.keySet().iterator(); i.hasNext();) {
					String mName = (String) i.next();
					TableItem item = new TableItem(tablePath, SWT.NONE);
					item.setText(TABLEPATHNAME, mName);
					item.setText(TABLEPATHPATH, (String)path.get(mName));
					item.setText(TABLEPATHMODELHANDLER, (String)modelHandler.get(mName));
					item.setText(TABLEPATHTYPE, (String)type.get(mName));
				}
			
			tableLib.removeAll();
			for (Iterator i = lib.keySet().iterator(); i.hasNext();) {
				String mName = (String) i.next();
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

		input = new HashMap();
		output = new HashMap();
		modelPath = new HashMap();
		modelType = new HashMap();
		modelHandler = new HashMap();
		libPath = new HashMap();
		
		for (int i=0; i < tableIn.getItemCount(); i++) {
			TableItem ti = tableIn.getItem(i);
			input.put(ti.getText(TABLEMODELNAME), ti.getText(TABLEMETAMODELNAME));
		}
		
		for (int i=0; i < tableOut.getItemCount(); i++) {
			TableItem ti = tableOut.getItem(i);
			output.put(ti.getText(TABLEMODELNAME), ti.getText(TABLEMETAMODELNAME));
		}
		
		for (int i=0; i < tablePath.getItemCount(); i++) {
			TableItem ti = tablePath.getItem(i);
			modelPath.put(ti.getText(TABLEPATHNAME), ti.getText(TABLEPATHPATH));
			modelType.put(ti.getText(TABLEPATHNAME), ti.getText(TABLEPATHTYPE));
			modelHandler.put(ti.getText(TABLEPATHNAME), ti.getText(TABLEPATHMODELHANDLER));
		}
		for (int i=0; i < tableLib.getItemCount(); i++) {
			TableItem ti = tableLib.getItem(i);
			libPath.put(ti.getText(TABLELIBNAME), ti.getText(TABLELIBPATH));
		}
		
		configuration.setAttribute(AtlLauncherTools.INPUT, input);
		configuration.setAttribute(AtlLauncherTools.OUTPUT, output);
		configuration.setAttribute(AtlLauncherTools.PATH, modelPath);
		configuration.setAttribute(AtlLauncherTools.MODELTYPE, modelType);
		configuration.setAttribute(AtlLauncherTools.MODELHANDLER, modelHandler);
		configuration.setAttribute(AtlLauncherTools.LIBS, libPath);
	}

	/**
	 * Returns the name of the tab
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return AtlLauncherTools.MODELCHOICETABNAME;
	}

	/**
	 * This method is used to know if the tab is valid or not.
	 * While this method returns false, it's impossible to apply
	 */
	public boolean canSave() {
		if (tablePath.getItemCount() == 0) {
			this.setMessage(Messages.getString("ModelChoiceTab.WARNING_GIVEMODELS")); //$NON-NLS-1$
		}
		else {
			this.setErrorMessage(Messages.getString("ModelChoiceTab.GIVEPATHMODELS")); //$NON-NLS-1$
			for (int i=0; i < tablePath.getItemCount(); i++)
				if (tablePath.getItem(i).getText(TABLEPATHPATH).equals("")) //$NON-NLS-1$
					return false;
		}
		
		if (tableLib.getItemCount() != 0) {
			for (int i=0; i < tableLib.getItemCount(); i++)
				if (tablePath.getItem(i).getText(TABLELIBPATH).equals("")) { //$NON-NLS-1$
					this.setErrorMessage(Messages.getString("ModelChoiceTab.GIVEPATHLIBS")); //$NON-NLS-1$
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

}