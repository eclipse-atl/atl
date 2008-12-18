/*******************************************************************************
 * Copyright (c) 2004 INRIA and Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Mikael Barbero (INRIA) - initial API and implementation
 *    Freddy Allilaire (INRIA)
 *    Dennis Wagelaar (Vrije Universiteit Brussel)
 *    William Piers (Obeo)
 *******************************************************************************/
package org.eclipse.m2m.atl.core.ui.launch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.core.ui.ATLCoreUIPlugin;
import org.eclipse.m2m.atl.core.ui.Messages;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
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
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * The main ATL tab.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 * @author <a href="mailto:mikael.barbero@univ-nantes.fr">Mikael Barbero</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class MainAtlTab extends AbstractLaunchConfigurationTab {

	/** Metamodel type. */
	public static final int IS_METAMODEL = 1 << 1;

	/** Model type. */
	public static final int IS_MODEL = 1 << 2;

	/** Source type. */
	public static final int IS_SOURCE = 1 << 3;

	/** Target type. */
	public static final int IS_TARGET = 1 << 5;

	/** Library type. */
	public static final int IS_LIBRARY = 1 << 6;

	/** Module type. */
	public static final int IS_MODULE = 1 << 7;

	private ScrolledComposite scrollContainer;

	private Composite rootContainer;

	private List<String> sourceMetamodelsFromModule = new ArrayList<String>();

	private List<String> targetMetamodelsFromModule = new ArrayList<String>();

	private List<String> sourceModelsFromModule = new ArrayList<String>();

	private List<String> targetModelsFromModule = new ArrayList<String>();

	private List<String> librariesFromModule = new ArrayList<String>();

	private List<String> superimposedFromAdvancedTab = new ArrayList<String>();

	private String launcherNameFromAdvancedTab;

	private List<String> nonLibraries = new ArrayList<String>();

	private List<String> removableMetamodels = new ArrayList<String>();

	private List<String> removableSourceModels = new ArrayList<String>();

	private List<String> removableTargetModels = new ArrayList<String>();

	private List<String> removableLibraries = new ArrayList<String>();

	private Map<String, String> sourceC2RelationshipFromModule = new HashMap<String, String>();

	private Map<String, String> targetC2RelationshipFromModule = new HashMap<String, String>();

	private Group moduleGroup;

	private Group metamodelsGroup;

	private Group sourceModelsGroup;

	private Group targetModelsGroup;

	private Group librariesGroup;

	private Group controlGroup;

	private Map<String, Map<String, Object>> metamodelsGroupWidgets = new HashMap<String, Map<String, Object>>();

	private Map<String, Map<String, Object>> sourceModelsGroupWidgets = new HashMap<String, Map<String, Object>>();

	private Map<String, Map<String, Object>> targetModelsGroupWidgets = new HashMap<String, Map<String, Object>>();

	private Map<String, Map<String, Object>> librariesGroupWidgets = new HashMap<String, Map<String, Object>>();

	private Pattern asmToAtl = Pattern.compile("\\.asm$"); //$NON-NLS-1$

	private Pattern moduleName = Pattern.compile("^.*/(.*)\\.a(tl|sm)$"); //$NON-NLS-1$

	private Map<IFile, AtlSourceManager> asmFileCache = new HashMap<IFile, AtlSourceManager>();

	private Map<String, String> metamodelLocations = new HashMap<String, String>();

	private Text atlPathText;

	private boolean isRefining;

	private String atlcompiler;

	private String currentAtlPath;

	private ILaunchConfiguration launchConfiguration;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		scrollContainer = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		scrollContainer.setExpandHorizontal(true);
		scrollContainer.setExpandVertical(true);

		rootContainer = new Composite(scrollContainer, SWT.NULL);
		rootContainer.setLayout(new GridLayout());
		scrollContainer.setContent(rootContainer);

		moduleGroup = new Group(rootContainer, SWT.NULL);
		moduleGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		moduleGroup.setLayout(new GridLayout(3, false));
		moduleGroup.setText(Messages.getString("MainAtlTab.ATL_MODULE")); //$NON-NLS-1$

		atlPathText = new Text(moduleGroup, SWT.SINGLE | SWT.BORDER);
		atlPathText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		atlPathText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (!atlPathText.getText().equals(currentAtlPath)) {
					rebuild();
				}
			}
		});

		final Button browseWorkspace = new Button(moduleGroup, SWT.RIGHT);
		browseWorkspace.setText(Messages.getString("MainAtlTab.WORKSPACE")); //$NON-NLS-1$

		atlPathText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});

		browseWorkspace.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				String path = editPath(IS_MODULE);
				if (path.trim().length() > 0) {
					atlPathText.setText(path);
				}
			}
		});

		metamodelsGroup = new Group(rootContainer, SWT.NULL);
		metamodelsGroup.setText(Messages.getString("MainAtlTab.METAMODELS")); //$NON-NLS-1$
		metamodelsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		metamodelsGroup.setLayout(new GridLayout(8, false));

		sourceModelsGroup = new Group(rootContainer, SWT.NULL);
		sourceModelsGroup.setText(Messages.getString("MainAtlTab.SOURCEMODELS")); //$NON-NLS-1$
		sourceModelsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		sourceModelsGroup.setLayout(new GridLayout(4, false));

		targetModelsGroup = new Group(rootContainer, SWT.NULL);
		targetModelsGroup.setText(Messages.getString("MainAtlTab.TARGETMODELS")); //$NON-NLS-1$
		targetModelsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		targetModelsGroup.setLayout(new GridLayout(4, false));

		librariesGroup = new Group(rootContainer, SWT.NULL);
		librariesGroup.setText(Messages.getString("MainAtlTab.LIBRARIES")); //$NON-NLS-1$
		librariesGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		librariesGroup.setLayout(new GridLayout(4, false));

		controlGroup = new Group(rootContainer, SWT.NULL);
		controlGroup.setText(Messages.getString("MainAtlTab.MODIFY")); //$NON-NLS-1$
		controlGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		controlGroup.setLayout(new GridLayout(7, false));

		final Button addSourceModelBtn = new Button(controlGroup, SWT.NULL);
		addSourceModelBtn.setText(Messages.getString("MainAtlTab.ADDSOURCE")); //$NON-NLS-1$
		final Button addTargetModelBtn = new Button(controlGroup, SWT.NULL);
		addTargetModelBtn.setText(Messages.getString("MainAtlTab.ADDTARGET")); //$NON-NLS-1$
		final Button addLibBtn = new Button(controlGroup, SWT.NULL);
		addLibBtn.setText(Messages.getString("MainAtlTab.ADDLIB")); //$NON-NLS-1$

		addSourceModelBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				InputDialog dlg = new InputDialog(getShell(),
						Messages.getString("MainAtlTab.ADDSOURCEMODEL"), //$NON-NLS-1$
						Messages.getString("MainAtlTab.MMNAME"), //$NON-NLS-1$
						"MM", //$NON-NLS-1$
						null);
				if (dlg.open() == InputDialog.CANCEL) {
					return;
				}
				String metamodelName = dlg.getValue();
				dlg = new InputDialog(getShell(), Messages.getString("MainAtlTab.ADDSOURCEMODEL"), //$NON-NLS-1$
						Messages.getString("MainAtlTab.MNAME"), //$NON-NLS-1$
						"IN", //$NON-NLS-1$
						null);
				if (dlg.open() == InputDialog.CANCEL) {
					return;
				}
				String modelName = dlg.getValue();
				if (!sourceMetamodelsFromModule.contains(metamodelName)) {
					sourceMetamodelsFromModule.add(metamodelName);
					if (!targetMetamodelsFromModule.contains(metamodelName)) {
						removableMetamodels.add(metamodelName);
					}
				}
				if (!sourceModelsFromModule.contains(modelName)) {
					sourceModelsFromModule.add(modelName);
					sourceC2RelationshipFromModule.put(modelName, metamodelName);
					removableSourceModels.add(modelName);
				}
				build();
				layout();
			}
		});

		addTargetModelBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				InputDialog dlg = new InputDialog(getShell(),
						Messages.getString("MainAtlTab.ADDTARGETMODEL"), //$NON-NLS-1$
						Messages.getString("MainAtlTab.MMNAME"), //$NON-NLS-1$
						"MM", //$NON-NLS-1$
						null);
				if (dlg.open() == InputDialog.CANCEL) {
					return;
				}
				String metamodelName = dlg.getValue();
				dlg = new InputDialog(getShell(), Messages.getString("MainAtlTab.ADDTARGETMODEL"), //$NON-NLS-1$
						Messages.getString("MainAtlTab.MNAME"), //$NON-NLS-1$
						"OUT", //$NON-NLS-1$
						null);
				if (dlg.open() == InputDialog.CANCEL) {
					return;
				}
				String modelName = dlg.getValue();
				if (!targetMetamodelsFromModule.contains(metamodelName)) {
					targetMetamodelsFromModule.add(metamodelName);
					if (!sourceMetamodelsFromModule.contains(metamodelName)) {
						removableMetamodels.add(metamodelName);
					}
				}
				if (!targetModelsFromModule.contains(modelName)) {
					targetModelsFromModule.add(modelName);
					targetC2RelationshipFromModule.put(modelName, metamodelName);
					removableTargetModels.add(modelName);
				}
				build();
				layout();
			}
		});

		addLibBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				InputDialog dlg = new InputDialog(getShell(), Messages.getString("MainAtlTab.ADDLIBRARY"), //$NON-NLS-1$
						Messages.getString("MainAtlTab.LIBRARYNAME"), //$NON-NLS-1$
						"LIB", //$NON-NLS-1$
						null);
				if (dlg.open() == InputDialog.CANCEL) {
					return;
				}
				String libName = dlg.getValue();
				if (!librariesFromModule.contains(libName)) {
					librariesFromModule.add(libName);
					removableLibraries.add(libName);
				}
				build();
				layout();
			}
		});

		setControl(scrollContainer);
	}

	/**
	 * Handles changes in the list of superimposed modules.
	 * 
	 * @param superimposed
	 *            the list of superimposed modules
	 */
	public void superimposedChanged(List<String> superimposed) {
		superimposedFromAdvancedTab = superimposed;
	}

	/**
	 * Handles launcher name change.
	 * 
	 * @param launcherName
	 *            the launcher name
	 */
	public void launcherNameChanged(String launcherName) {
		if (!launcherName.equals(launcherNameFromAdvancedTab)) {
			launcherNameFromAdvancedTab = launcherName;
			boolean visible = launcherName.equals(ATLLaunchConstants.REGULAR_VM_NAME);
			for (Iterator<Map<String, Object>> it = metamodelsGroupWidgets.values().iterator(); it.hasNext();) {
				Map<String, Object> map = it.next();
				Combo combo = (Combo)map.get("modelHandlers"); //$NON-NLS-1$
				combo.setVisible(visible);
				Label label = (Label)map.get("modelHandlerLabel"); //$NON-NLS-1$
				label.setVisible(visible);
			}
		}
	}

	private void clear() {
		sourceModelsFromModule.clear();
		sourceMetamodelsFromModule.clear();
		targetModelsFromModule.clear();
		targetMetamodelsFromModule.clear();
		librariesFromModule.clear();
		removableMetamodels.clear();
		removableSourceModels.clear();
		removableTargetModels.clear();
		removableLibraries.clear();

		sourceC2RelationshipFromModule.clear();
		targetC2RelationshipFromModule.clear();

		metamodelsGroupWidgets.clear();
		sourceModelsGroupWidgets.clear();
		targetModelsGroupWidgets.clear();
		librariesGroupWidgets.clear();

		disposeGroupChildren(metamodelsGroup);
		disposeGroupChildren(sourceModelsGroup);
		disposeGroupChildren(targetModelsGroup);
		disposeGroupChildren(librariesGroup);
	}

	private void initializeExtraWidgetsFrom(ILaunchConfiguration configuration) throws CoreException {
		if (configuration == null) {
			return;
		}

		Map<?, ?> savedLibraries = configuration.getAttribute(ATLLaunchConstants.LIBS, Collections.EMPTY_MAP);
		Map<?, ?> input = configuration.getAttribute(ATLLaunchConstants.INPUT, Collections.EMPTY_MAP);
		Map<?, ?> output = configuration.getAttribute(ATLLaunchConstants.OUTPUT, Collections.EMPTY_MAP);

		for (Iterator<?> i = input.keySet().iterator(); i.hasNext();) {
			String mName = (String)i.next();
			String mmName = (String)input.get(mName);
			if (!sourceMetamodelsFromModule.contains(mmName)) {
				sourceMetamodelsFromModule.add(mmName);
				if (!targetMetamodelsFromModule.contains(mmName)) {
					removableMetamodels.add(mmName);
				}
			}
			if (!sourceModelsFromModule.contains(mName)) {
				sourceModelsFromModule.add(mName);
				sourceC2RelationshipFromModule.put(mName, mmName);
				removableSourceModels.add(mName);
			}
		}

		for (Iterator<?> i = output.keySet().iterator(); i.hasNext();) {
			String mName = (String)i.next();
			String mmName = (String)output.get(mName);
			if (!targetMetamodelsFromModule.contains(mmName)) {
				targetMetamodelsFromModule.add(mmName);
				if (!sourceMetamodelsFromModule.contains(mmName)) {
					removableMetamodels.add(mmName);
				}
			}
			if (!targetModelsFromModule.contains(mName)) {
				targetModelsFromModule.add(mName);
				targetC2RelationshipFromModule.put(mName, mmName);
				removableTargetModels.add(mName);
			}
		}

		for (Iterator<?> i = savedLibraries.keySet().iterator(); i.hasNext();) {
			String libraryName = (String)i.next();
			if (!librariesFromModule.contains(libraryName)) {
				librariesFromModule.add(libraryName);
				removableLibraries.add(libraryName);
			}
		}
	}

	private void initializeWidgetValuesFrom(ILaunchConfiguration configuration) throws CoreException {
		if (configuration == null) {
			return;
		}

		Map<?, ?> savedPaths = configuration.getAttribute(ATLLaunchConstants.PATH, Collections.EMPTY_MAP);
		Map<?, ?> savedModelHandlers = configuration.getAttribute(ATLLaunchConstants.MODEL_HANDLER,
				Collections.EMPTY_MAP);
		Map<?, ?> savedLibraries = configuration.getAttribute(ATLLaunchConstants.LIBS, Collections.EMPTY_MAP);

		for (Iterator<?> i = savedPaths.keySet().iterator(); i.hasNext();) {
			String modelName = (String)i.next();
			if (metamodelsGroupWidgets.get(modelName) != null) {
				Map<String, Object> widgets = metamodelsGroupWidgets.get(modelName);
				Text metamodelLocation = (Text)widgets.get("metamodelLocation"); //$NON-NLS-1$
				Button isMetametamodel = (Button)widgets.get("isMetametamodel"); //$NON-NLS-1$
				Combo modelHandlers = (Combo)widgets.get("modelHandlers"); //$NON-NLS-1$

				if (((String)savedPaths.get(modelName)).startsWith("#")) { //$NON-NLS-1$
					isMetametamodel.setSelection(true);
					isMetametamodel.notifyListeners(SWT.Selection, null);
				} else {
					metamodelLocation.setText((String)savedPaths.get(modelName));
				}

				for (int item = 0; item < modelHandlers.getItems().length; item++) {
					if (modelHandlers.getItem(item).equals(savedModelHandlers.get(modelName))) {
						modelHandlers.select(item);
					} else {
						selectEMFModelHandler(modelHandlers);
					}
				}

			} else {
				Map<String, Object> widgets = null;
				if (sourceModelsGroupWidgets.get(modelName) != null) {
					widgets = sourceModelsGroupWidgets.get(modelName);
				} else if (targetModelsGroupWidgets.get(modelName) != null) {
					widgets = targetModelsGroupWidgets.get(modelName);
				}
				if (widgets != null) {
					Text modelLocation = (Text)widgets.get("location"); //$NON-NLS-1$
					modelLocation.setText((String)savedPaths.get(modelName));
				}
			}
		}

		for (Iterator<?> i = savedLibraries.keySet().iterator(); i.hasNext();) {
			String libraryName = (String)i.next();
			Map<String, Object> widgets = librariesGroupWidgets.get(libraryName);
			if (widgets != null) {
				Text libraryLocation = (Text)widgets.get("location"); //$NON-NLS-1$
				libraryLocation.setText((String)savedLibraries.get(libraryName));
			}
		}
	}

	private void calcNonLibraries() {
		nonLibraries.clear();
		String path = atlPathText.getText();
		Matcher m = moduleName.matcher(path);
		if (m.find()) {
			nonLibraries.add(m.group(1));
		}
		for (Iterator<String> i = superimposedFromAdvancedTab.iterator(); i.hasNext();) {
			path = i.next();
			m = moduleName.matcher(path);
			if (m.find()) {
				nonLibraries.add(m.group(1));
			}
		}
	}

	private void getModelsFromATLFiles() {
		IWorkspaceRoot wsRoot = ResourcesPlugin.getWorkspace().getRoot();
		String path = atlPathText.getText();
		IResource res = wsRoot.findMember(path);
		if (res instanceof IFile) {
			getModelsFromATLFile((IFile)res);
		}
		for (Iterator<String> i = superimposedFromAdvancedTab.iterator(); i.hasNext();) {
			path = i.next();
			path = asmToAtl.matcher(path).replaceFirst(".atl"); //$NON-NLS-1$
			res = wsRoot.findMember(path);
			if (res instanceof IFile) {
				getModelsFromATLFile((IFile)res);
			} else {
				ATLLogger.severe(Messages.getString("MainAtlTab.FILENOTFOUND") + path); //$NON-NLS-1$
			}
		}
	}

	private void rebuild() {
		try {
			clear();
			build();
			initializeExtraWidgetsFrom(launchConfiguration);
			build();
			initializeWidgetValuesFrom(launchConfiguration);
			layout();
		} catch (CoreException ex) {
			ATLLogger.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
		}
	}

	private void build() {
		calcNonLibraries();
		getModelsFromATLFiles();
		buildMetamodelControls(sourceMetamodelsFromModule);
		buildMetamodelControls(targetMetamodelsFromModule);
		buildSourceModelControls(sourceModelsFromModule);
		buildTargetModelControls(targetModelsFromModule);
		buildLibraryControls(librariesFromModule);
	}

	private void buildMetamodelControls(Collection<String> modelNames) {
		for (String modelName : modelNames) {
			if (!metamodelsGroupWidgets.containsKey(modelName)) {
				metamodelsGroupWidgets.put(modelName, buildMetamodelsControls(metamodelsGroup, modelName,
						IS_SOURCE | IS_METAMODEL, removableMetamodels.contains(modelName)));
			}
		}
	}

	private void buildSourceModelControls(Collection<String> modelNames) {
		for (String modelName : modelNames) {
			if (!sourceModelsGroupWidgets.containsKey(modelName)) {
				String mmName = sourceC2RelationshipFromModule.get(modelName);
				sourceModelsGroupWidgets.put(modelName, buildModelsAndLibrariesControls(sourceModelsGroup,
						modelName, mmName, IS_SOURCE | IS_MODEL, removableSourceModels.contains(modelName)));
			}
		}
	}

	private void buildTargetModelControls(Collection<String> modelNames) {
		for (String modelName : modelNames) {
			if (targetModelsGroupWidgets.get(modelName) == null) {
				String mmName = targetC2RelationshipFromModule.get(modelName);
				targetModelsGroupWidgets.put(modelName, buildModelsAndLibrariesControls(targetModelsGroup,
						modelName, mmName, IS_TARGET | IS_MODEL, removableTargetModels.contains(modelName)));
			}
		}
	}

	private void buildLibraryControls(Collection<String> libraryNames) {
		for (String libraryName : libraryNames) {
			if (librariesGroupWidgets.get(libraryName) == null) {
				librariesGroupWidgets.put(libraryName, buildModelsAndLibrariesControls(librariesGroup,
						libraryName, null, IS_LIBRARY, removableLibraries.contains(libraryName)));
			}
		}
	}

	private void layout() {
		metamodelsGroup.layout();
		sourceModelsGroup.layout();
		targetModelsGroup.layout();
		librariesGroup.layout();

		rootContainer.layout();

		scrollContainer.setMinSize(rootContainer.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		scrollContainer.layout();

		canSave();
		updateLaunchConfigurationDialog();
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
	@SuppressWarnings("unchecked")
	public void initializeFrom(ILaunchConfiguration configuration) {
		this.launchConfiguration = configuration;
		try {
			String fileName = configuration.getAttribute(ATLLaunchConstants.ATL_FILE_NAME, ""); //$NON-NLS-1$
			superimposedFromAdvancedTab = configuration.getAttribute(ATLLaunchConstants.SUPERIMPOSE,
					Collections.EMPTY_LIST);
			launcherNameFromAdvancedTab = configuration.getAttribute(ATLLaunchConstants.ATL_VM,
					ATLLaunchConstants.REGULAR_VM_NAME);

			atlPathText.setText(fileName);
			currentAtlPath = fileName;
		} catch (CoreException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		rebuild();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		Map<String, String> savedPaths = new HashMap<String, String>();
		Map<String, String> savedModelHandlers = new HashMap<String, String>();
		Map<String, String> savedLibraries = new HashMap<String, String>();
		Map<String, String> savedInput = new HashMap<String, String>();
		Map<String, String> savedOutput = new HashMap<String, String>();
		Map<String, String> savedType = new HashMap<String, String>();

		for (Iterator<String> it = sourceMetamodelsFromModule.iterator(); it.hasNext();) {
			String modelName = it.next();
			String location = ((Text)(metamodelsGroupWidgets.get(modelName)).get("metamodelLocation")).getText(); //$NON-NLS-1$
			String modelHandler = ((Combo)(metamodelsGroupWidgets.get(modelName)).get("modelHandlers")).getText(); //$NON-NLS-1$
			boolean isMetametamodel = ((Button)(metamodelsGroupWidgets.get(modelName)).get("isMetametamodel")).getSelection(); //$NON-NLS-1$
			if (isMetametamodel) {
				savedPaths.put(modelName, "#" + modelHandler); //$NON-NLS-1$
			} else {
				savedPaths.put(modelName, location);
			}
			savedModelHandlers.put(modelName, modelHandler);
		}

		for (Iterator<String> it = targetMetamodelsFromModule.iterator(); it.hasNext();) {
			String modelName = it.next();
			String location = ((Text)(metamodelsGroupWidgets.get(modelName)).get("metamodelLocation")).getText(); //$NON-NLS-1$
			String modelHandler = ((Combo)(metamodelsGroupWidgets.get(modelName)).get("modelHandlers")).getText(); //$NON-NLS-1$
			boolean isMetametamodel = ((Button)(metamodelsGroupWidgets.get(modelName)).get("isMetametamodel")).getSelection(); //$NON-NLS-1$
			if (isMetametamodel) {
				savedPaths.put(modelName, "#" + modelHandler); //$NON-NLS-1$
			} else {
				savedPaths.put(modelName, location);
			}
			savedModelHandlers.put(modelName, modelHandler);
		}

		for (Iterator<String> it = sourceModelsFromModule.iterator(); it.hasNext();) {
			String modelName = it.next();
			String location = ((Text)(sourceModelsGroupWidgets.get(modelName)).get("location")).getText(); //$NON-NLS-1$
			savedPaths.put(modelName, location);
		}

		for (Iterator<String> it = targetModelsFromModule.iterator(); it.hasNext();) {
			String modelName = it.next();
			String location = ((Text)(targetModelsGroupWidgets.get(modelName)).get("location")).getText(); //$NON-NLS-1$
			savedPaths.put(modelName, location);
		}

		for (Iterator<String> it = librariesFromModule.iterator(); it.hasNext();) {
			String modelName = it.next();
			String location = ((Text)(librariesGroupWidgets.get(modelName)).get("location")).getText(); //$NON-NLS-1$
			savedLibraries.put(modelName, location);
		}

		for (Iterator<Entry<String, String>> it = sourceC2RelationshipFromModule.entrySet().iterator(); it
				.hasNext();) {
			Entry<String, String> entry = it.next();
			savedInput.put(entry.getKey(), entry.getValue());
			savedType.put(entry.getKey(), ATLLaunchConstants.MODEL_INPUT);
			savedType.put(entry.getValue(), ATLLaunchConstants.METAMODEL_INPUT);

		}

		for (Iterator<Entry<String, String>> it = targetC2RelationshipFromModule.entrySet().iterator(); it
				.hasNext();) {
			Entry<String, String> entry = it.next();
			savedOutput.put(entry.getKey(), entry.getValue());
			savedType.put(entry.getKey(), ATLLaunchConstants.MODEL_OUTPUT);
			savedType.put(entry.getValue(), ATLLaunchConstants.METAMODEL_OUTPUT);
		}

		configuration.setAttribute(ATLLaunchConstants.ATL_FILE_NAME, atlPathText.getText());
		configuration.setAttribute(ATLLaunchConstants.PATH, savedPaths);
		configuration.setAttribute(ATLLaunchConstants.MODEL_HANDLER, savedModelHandlers);
		configuration.setAttribute(ATLLaunchConstants.LIBS, savedLibraries);
		configuration.setAttribute(ATLLaunchConstants.INPUT, savedInput);
		configuration.setAttribute(ATLLaunchConstants.OUTPUT, savedOutput);
		configuration.setAttribute(ATLLaunchConstants.MODEL_TYPE, savedType);
		configuration.setAttribute(ATLLaunchConstants.IS_REFINING, isRefining);
		configuration.setAttribute(ATLLaunchConstants.ATL_COMPILER, atlcompiler);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return ATLLaunchConstants.MAIN_ATL_TAB_NAME;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#canSave()
	 */
	@Override
	public boolean canSave() {
		boolean ret = true;
		if (atlPathText.getText().equals("")) { //$NON-NLS-1$
			this.setErrorMessage(Messages.getString("MainAtlTab.GIVETRANSFORMATIONNAME")); //$NON-NLS-1$
			ret = false;
		}
		for (Iterator<Entry<String, Map<String, Object>>> i = metamodelsGroupWidgets.entrySet().iterator(); i
				.hasNext();) {
			Entry<String, Map<String, Object>> entry = i.next();
			String mName = entry.getKey();
			Map<String, Object> widgets = entry.getValue();
			Text metamodelLocation = (Text)widgets.get("metamodelLocation"); //$NON-NLS-1$
			Button isMetametamodel = (Button)widgets.get("isMetametamodel"); //$NON-NLS-1$
			if ((metamodelLocation.getText().length() == 0) && (!isMetametamodel.getSelection())) {
				this.setErrorMessage(Messages.getString("MainAtlTab.GIVEPATHFOR") + mName); //$NON-NLS-1$
				ret = false;
			}
		}
		if (!canSaveModelsGroupWidgets(sourceModelsGroupWidgets)
				|| !canSaveModelsGroupWidgets(targetModelsGroupWidgets)
				|| !canSaveModelsGroupWidgets(librariesGroupWidgets)) {
			ret = false;
		}
		this.setErrorMessage(null);
		return ret;
	}

	/**
	 * Returns True if modelsGroupWidgets is in a correct state, false otherwise.
	 * 
	 * @param modelsGroupWidgets
	 *            input/output models or libraries widgets
	 * @return True if modelsGroupWidgets is in a correct state, false otherwise
	 */
	private boolean canSaveModelsGroupWidgets(Map<String, Map<String, Object>> modelsGroupWidgets) {
		for (Iterator<Entry<String, Map<String, Object>>> i = modelsGroupWidgets.entrySet().iterator(); i
				.hasNext();) {
			Entry<String, Map<String, Object>> entry = i.next();
			String mName = entry.getKey();
			Map<String, Object> widgets = entry.getValue();
			Text location = (Text)widgets.get("location"); //$NON-NLS-1$
			if (location.getText().length() == 0) {
				this.setErrorMessage(Messages.getString("MainAtlTab.GIVEPATHFOR") + mName); //$NON-NLS-1$
				return false;
			}
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
	 */
	@Override
	public Image getImage() {
		return ATLCoreUIPlugin.createImage(ATLLaunchConstants.ATL_ICON_PATH);
	}

	/**
	 * This method edit the path of a model. The path can be external at the workspace
	 * 
	 * @param type
	 * @param table
	 */
	private String editExternalPath(final int type) {
		String ret = ""; //$NON-NLS-1$
		FileDialog fileDialog;

		if (type == (IS_TARGET | IS_MODEL)) {
			fileDialog = new FileDialog(this.getShell(), SWT.SAVE);
		} else {
			fileDialog = new FileDialog(this.getShell(), SWT.OPEN);
		}

		if (type == IS_MODULE) {
			String[] extensions = new String[ATLLaunchConstants.ATL_EXTENSIONS.length];
			for (int i = 0; i < ATLLaunchConstants.ATL_EXTENSIONS.length; i++) {
				extensions[i] = "*." + ATLLaunchConstants.ATL_EXTENSIONS[i]; //$NON-NLS-1$
			}
			fileDialog.setFilterExtensions(extensions);
		} else {
			fileDialog.setFilterExtensions(new String[] {"*"}); //$NON-NLS-1$
		}
		String fileName = fileDialog.open();
		if (fileName != null) {
			ret = "ext:" + fileName; //$NON-NLS-1$
		}

		return ret;
	}

	/**
	 * This method edit the path of the model selected. The path corresponding the a file in the workspace
	 * 
	 * @param type
	 * @param table
	 */
	private String editPath(final int type) {
		String ret = ""; //$NON-NLS-1$

		if (type == (IS_TARGET | IS_MODEL)) {
			SaveAsDialog sad = new SaveAsDialog(getShell());
			sad.open();
			IPath outputPath = sad.getResult();
			if (outputPath != null) {
				ret = outputPath.toString();
			}
		} else {
			ElementTreeSelectionDialog elementTreeSelectionDialog = new ElementTreeSelectionDialog(
					getShell(), new WorkbenchLabelProvider(), new WorkbenchContentProvider());
			elementTreeSelectionDialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
			elementTreeSelectionDialog.setMessage(Messages.getString("MainAtlTab.SELECT_FILE")); //$NON-NLS-1$
			elementTreeSelectionDialog.setAllowMultiple(false);
			elementTreeSelectionDialog.setDoubleClickSelects(true);
			elementTreeSelectionDialog.addFilter(new ViewerFilter() {
				@Override
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					boolean ret = false;
					try {
						String[] extensions = null;
						if (type == IS_MODULE) {
							extensions = ATLLaunchConstants.ATL_EXTENSIONS;
						} else if (type == IS_LIBRARY) {
							extensions = new String[] {"asm"}; //$NON-NLS-1$
						}
						ret = isATLResource((IResource)element, extensions);
					} catch (CoreException e) {
						ATLLogger.warning(e.getMessage());
					}
					return ret;
				}
			});
			elementTreeSelectionDialog.setValidator(new ISelectionStatusValidator() {
				public IStatus validate(Object[] selection) {
					IStatus ret = Status.CANCEL_STATUS;
					if (selection.length == 1) {
						if (selection[0] instanceof IFile) {
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
				ret = currentFile.getFullPath().toString();
			}
		}
		return ret;
	}

	private static boolean isATLResource(IResource resource, String[] extensions) throws CoreException {
		if (resource instanceof IContainer) {
			if (((IContainer)resource).isAccessible()) {
				IResource[] members = ((IContainer)resource).members();
				for (IResource member : members) {
					if (isATLResource(member, extensions)) {
						return true;
					}
				}
			}
		} else if (resource instanceof IFile) {
			IFile currentFile = (IFile)resource;
			if (extensions == null) {
				return true;
			} else if (currentFile.getFileExtension() != null) {
				for (int i = 0; i < extensions.length; i++) {
					String extension = extensions[i];
					if (currentFile.getFileExtension().toUpperCase().equals(extension.toUpperCase())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private Map<String, Object> buildMetamodelsControls(Group parent, final String metamodelName,
			final int type, boolean removable) {
		Map<String, Object> thisGroupWidgets = new HashMap<String, Object>();

		final Label metamodelLabel = new Label(parent, SWT.NULL);
		metamodelLabel.setText(metamodelName + ": "); //$NON-NLS-1$

		final Text metamodelLocation = new Text(parent, SWT.BORDER);
		thisGroupWidgets.put("metamodelLocation", metamodelLocation); //$NON-NLS-1$
		metamodelLocation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 6, 1));
		if (metamodelLocations != null) {
			String defaultLocation = metamodelLocations.get(metamodelName);
			if (defaultLocation != null) {
				metamodelLocation.setText(defaultLocation);
			}
		}

		final Button remove = new Button(parent, SWT.NULL);
		remove.setText(Messages.getString("MainAtlTab.DELETE")); //$NON-NLS-1$

		if (!removable) {
			new Label(parent, SWT.NULL);
		}

		final Button isMetametamodel = new Button(parent, SWT.CHECK);
		thisGroupWidgets.put("isMetametamodel", isMetametamodel); //$NON-NLS-1$
		isMetametamodel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 2, 1));
		isMetametamodel.setText(Messages.getString("MainAtlTab.IS_METAMETA")); //$NON-NLS-1$
		isMetametamodel.setToolTipText(Messages.getString("MainAtlTab.MODELHANDLERCHOICE")); //$NON-NLS-1$

		final Label modelHandlerLabel = new Label(parent, SWT.NULL);
		thisGroupWidgets.put("modelHandlerLabel", modelHandlerLabel); //$NON-NLS-1$
		modelHandlerLabel.setText(Messages.getString("MainAtlTab.MODEL_HANDLER")); //$NON-NLS-1$
		modelHandlerLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		final Combo modelHandlers = new Combo(parent, SWT.NULL | SWT.READ_ONLY);
		thisGroupWidgets.put("modelHandlers", modelHandlers); //$NON-NLS-1$
		modelHandlers.setItems(getModelHandlers());
		selectEMFModelHandler(modelHandlers);
		modelHandlers.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));

		modelHandlers.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});

		boolean modelHandlersEnabled = launcherNameFromAdvancedTab.equals(ATLLaunchConstants.REGULAR_VM_NAME);

		modelHandlerLabel.setVisible(modelHandlersEnabled);
		modelHandlers.setVisible(modelHandlersEnabled);

		final Button browseWorkspace = new Button(parent, SWT.NULL);
		browseWorkspace.setText(Messages.getString("MainAtlTab.WORKSPACE")); //$NON-NLS-1$

		final Button browseFilesystem = new Button(parent, SWT.NULL);
		browseFilesystem.setText(Messages.getString("MainAtlTab.FILE_SYSTEM")); //$NON-NLS-1$

		final Button browseEMFRegistry = new Button(parent, SWT.NULL);
		browseEMFRegistry.setText(Messages.getString("MainAtlTab.EMF_REGISTRY")); //$NON-NLS-1$

		final Label filler = new Label(parent, SWT.NULL);
		filler.setLayoutData(new GridData(SWT.NULL, SWT.NULL, false, false, 1, 1));

		metamodelLocation.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (metamodelLocation.getText().startsWith("uri:")) { //$NON-NLS-1$
					selectEMFModelHandler(modelHandlers);
				}
				updateLaunchConfigurationDialog();
			}

		});

		isMetametamodel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				metamodelLocation.setEnabled(!isMetametamodel.getSelection());
				browseWorkspace.setEnabled(!isMetametamodel.getSelection());
				browseFilesystem.setEnabled(!isMetametamodel.getSelection());
				browseEMFRegistry.setEnabled(!isMetametamodel.getSelection());
				if (!isMetametamodel.getSelection()) {
					metamodelLocation.notifyListeners(SWT.Modify, null);
				}
				updateLaunchConfigurationDialog();
			}
		});

		modelHandlers.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});

		browseWorkspace.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				String path = editPath(type);
				if (path.trim().length() > 0) {
					metamodelLocation.setText(path);
				}
			}
		});

		browseFilesystem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				String path = editExternalPath(type);
				if (path.trim().length() > 0) {
					metamodelLocation.setText(path);
				}
			}
		});

		browseEMFRegistry.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				DialogUriSelection launcher = new DialogUriSelection(new Shell());
				launcher.create();
				if (launcher.open() == Dialog.OK) {
					metamodelLocation.setText("uri:" + launcher.getUriSelected()); //$NON-NLS-1$
				}
			}
		});

		final SelectionAdapter removeAdapter = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				metamodelsGroupWidgets.remove(metamodelName);
				sourceMetamodelsFromModule.remove(metamodelName);
				targetMetamodelsFromModule.remove(metamodelName);
				updateModelsGroupFor(metamodelName);
				metamodelLabel.dispose();
				metamodelLocation.dispose();
				isMetametamodel.dispose();
				modelHandlerLabel.dispose();
				modelHandlers.dispose();
				browseWorkspace.dispose();
				browseFilesystem.dispose();
				browseEMFRegistry.dispose();
				remove.dispose();
				filler.dispose();
				layout();
			}
		};
		remove.addSelectionListener(removeAdapter);
		thisGroupWidgets.put("removeAdapter", removeAdapter); //$NON-NLS-1$

		if (!removable) {
			remove.dispose();
		}

		return thisGroupWidgets;
	}

	private Map<String, Object> buildModelsAndLibrariesControls(Group parent, final String modelName,
			final String metamodelName, final int type, boolean removable) {
		Map<String, Object> thisGroupWidgets = new HashMap<String, Object>();

		final Label modelLabel = new Label(parent, SWT.NULL);
		modelLabel.setText(modelName + ": "); //$NON-NLS-1$

		final Text location = new Text(parent, SWT.BORDER);
		thisGroupWidgets.put("location", location); //$NON-NLS-1$
		location.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		final Button remove = new Button(parent, SWT.NULL);
		remove.setText(Messages.getString("MainAtlTab.DELETE")); //$NON-NLS-1$
		thisGroupWidgets.put("remove", remove); //$NON-NLS-1$

		if (!removable) {
			new Label(parent, SWT.NULL);
		}

		final Label metamodelLabel = new Label(parent, SWT.NULL);
		if (metamodelName != null) {
			metamodelLabel.setText(Messages.getString("MainAtlTab.CONFORMS_TO") + metamodelName); //$NON-NLS-1$
		}

		final Button browseWorkspace = new Button(parent, SWT.NULL);
		browseWorkspace.setText(Messages.getString("MainAtlTab.WORKSPACE")); //$NON-NLS-1$
		browseWorkspace.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));

		final Button browseFilesystem = new Button(parent, SWT.NULL);
		browseFilesystem.setText(Messages.getString("MainAtlTab.FILE_SYSTEM")); //$NON-NLS-1$

		final Label filler = new Label(parent, SWT.NULL);
		filler.setLayoutData(new GridData(SWT.NULL, SWT.NULL, false, false, 1, 1));

		location.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();

			}
		});

		browseWorkspace.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				String path = editPath(type);
				if (path.trim().length() > 0) {
					location.setText(path);
				}
			}
		});

		browseFilesystem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				String path = editExternalPath(type);
				if (path.trim().length() > 0) {
					location.setText(path);
				}
			}
		});

		final SelectionAdapter removeAdapter = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				if (sourceModelsGroupWidgets.get(modelName) != null) {
					sourceModelsGroupWidgets.remove(modelName);
					sourceModelsFromModule.remove(modelName);
					String mmName = sourceC2RelationshipFromModule.remove(modelName);
					updateMetamodelsGroupFor(mmName);
				} else if (targetModelsGroupWidgets.get(modelName) != null) {
					targetModelsGroupWidgets.remove(modelName);
					targetModelsFromModule.remove(modelName);
					String mmName = targetC2RelationshipFromModule.remove(modelName);
					updateMetamodelsGroupFor(mmName);
				} else {
					librariesGroupWidgets.remove(modelName);
					librariesFromModule.remove(modelName);
				}
				modelLabel.dispose();
				metamodelLabel.dispose();
				location.dispose();
				browseWorkspace.dispose();
				browseFilesystem.dispose();
				remove.dispose();
				filler.dispose();
				layout();
			}
		};
		remove.addSelectionListener(removeAdapter);
		thisGroupWidgets.put("removeAdapter", removeAdapter); //$NON-NLS-1$

		if (!removable) {
			remove.dispose();
		}

		return thisGroupWidgets;
	}

	private void updateMetamodelsGroupFor(String metamodelName) {
		if (!sourceC2RelationshipFromModule.values().contains(metamodelName)
				&& !targetC2RelationshipFromModule.values().contains(metamodelName)) {
			Map<String, Object> widgets = metamodelsGroupWidgets.get(metamodelName);
			if (widgets != null) {
				SelectionAdapter removeAdapter = (SelectionAdapter)widgets.get("removeAdapter"); //$NON-NLS-1$
				removeAdapter.widgetSelected(null);
			}
		}
	}

	private void updateModelsGroupFor(String metamodelName) {
		for (Iterator<Entry<String, String>> i = sourceC2RelationshipFromModule.entrySet().iterator(); i
				.hasNext();) {
			Entry<String, String> entry = i.next();
			if (entry.getValue().equals(metamodelName)) {
				i.remove();
				Map<String, Object> widgets = sourceModelsGroupWidgets.get(entry.getKey());
				if (widgets != null) {
					SelectionAdapter removeAdapter = (SelectionAdapter)widgets.get("removeAdapter"); //$NON-NLS-1$
					removeAdapter.widgetSelected(null);
				}
			}
		}
		for (Iterator<Entry<String, String>> i = targetC2RelationshipFromModule.entrySet().iterator(); i
				.hasNext();) {
			Entry<String, String> entry = i.next();
			if (entry.getValue().equals(metamodelName)) {
				i.remove();
				Map<String, Object> widgets = targetModelsGroupWidgets.get(entry.getKey());
				if (widgets != null) {
					SelectionAdapter removeAdapter = (SelectionAdapter)widgets.get("removeAdapter"); //$NON-NLS-1$
					removeAdapter.widgetSelected(null);
				}
			}
		}
	}

	private void disposeGroupChildren(Group group) {
		Control[] controls = group.getChildren();
		for (int i = 0; i < controls.length; i++) {
			controls[i].dispose();
		}
	}

	@SuppressWarnings("unchecked")
	private void getModelsFromATLFile(IFile file) {
		AtlSourceManager sourceManager;
		if (asmFileCache.containsKey(file)) {
			sourceManager = asmFileCache.get(file);
		} else {
			sourceManager = new AtlSourceManager();
			try {
				sourceManager.updateDataSource(file.getContents());
			} catch (CoreException e) {
				return;
			}
			asmFileCache.put(file, sourceManager);
		}

		atlcompiler = sourceManager.getAtlCompiler();

		switch (sourceManager.getATLFileType()) {
			case AtlSourceManager.ATL_FILE_TYPE_MODULE:
				isRefining = sourceManager.isRefining();
				for (Iterator<?> iterator = sourceManager.getInputModels().entrySet().iterator(); iterator
						.hasNext();) {
					Entry<?, ?> entry = (Entry<?, ?>)iterator.next();
					String modelName = (String)entry.getKey();
					String metamodelName = (String)entry.getValue();

					if (!sourceMetamodelsFromModule.contains(metamodelName)) {
						sourceMetamodelsFromModule.add(metamodelName);
					}
					if (!sourceModelsFromModule.contains(modelName)) {
						sourceModelsFromModule.add(modelName);
						sourceC2RelationshipFromModule.put(modelName, metamodelName);
					}

				}
				for (Iterator<?> iterator = sourceManager.getOutputModels().entrySet().iterator(); iterator
						.hasNext();) {
					Entry<?, ?> entry = (Entry<?, ?>)iterator.next();
					String modelName = (String)entry.getKey();
					String metamodelName = (String)entry.getValue();
					if (!targetMetamodelsFromModule.contains(metamodelName)) {
						targetMetamodelsFromModule.add(metamodelName);
					}
					if (!targetModelsFromModule.contains(modelName)) {
						targetModelsFromModule.add(modelName);
						targetC2RelationshipFromModule.put(modelName, metamodelName);
					}
				}

				for (Iterator<?> iterator = sourceManager.getLibrariesImports().iterator(); iterator
						.hasNext();) {
					String library = (String)iterator.next();
					if (nonLibraries.contains(library)) {
						continue;
					}
					if (!librariesFromModule.contains(library)) {
						librariesFromModule.add(library);
					}
				}
				break;
			case AtlSourceManager.ATL_FILE_TYPE_QUERY:
				for (Iterator<?> iterator = sourceManager.getInputModels().entrySet().iterator(); iterator
						.hasNext();) {
					Entry<?, ?> entry = (Entry<?, ?>)iterator.next();
					String modelName = (String)entry.getKey();
					String metamodelName = (String)entry.getValue();
					if (!sourceMetamodelsFromModule.contains(metamodelName)) {
						sourceMetamodelsFromModule.add(metamodelName);
					}
					if (!sourceModelsFromModule.contains(modelName)) {
						sourceModelsFromModule.add(modelName);
						sourceC2RelationshipFromModule.put(modelName, metamodelName);
					}
				}
				for (Iterator<?> iterator = sourceManager.getLibrariesImports().iterator(); iterator
						.hasNext();) {
					String library = (String)iterator.next();
					if (nonLibraries.contains(library)) {
						continue;
					}
					if (!librariesFromModule.contains(library)) {
						librariesFromModule.add(library);
					}
				}
				break;
			default:
				break;
		}
		metamodelLocations = sourceManager.getMetamodelLocations();
	}

	/**
	 * Returns the model handlers ids.
	 * 
	 * @return the model handlers ids
	 */
	private static String[] getModelHandlers() {
		List<String> mhs = new ArrayList<String>();
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point = registry.getExtensionPoint("org.eclipse.m2m.atl.engine.vm.modelhandler"); //$NON-NLS-1$

		IExtension[] extensions = point.getExtensions();
		for (int i = 0; i < extensions.length; i++) {
			IConfigurationElement[] elements = extensions[i].getConfigurationElements();
			for (int j = 0; j < elements.length; j++) {
				mhs.add(elements[j].getAttribute("name")); //$NON-NLS-1$
			}
		}
		Collections.sort(mhs);
		return mhs.toArray(new String[] {});
	}

	private void selectEMFModelHandler(Combo modelHandlers) {
		for (int j = 0; j < modelHandlers.getItems().length; j++) {
			if (modelHandlers.getItems()[j].equals(ATLLaunchConstants.DEFAULT_MODEL_HANDLER_NAME)) {
				modelHandlers.select(j);
				break;
			}
		}
	}

}
