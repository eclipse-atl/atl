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
package org.eclipse.m2m.atl.adt.launching;

import java.util.ArrayList;
import java.util.Collection;
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
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.adt.debug.AtlDebugMessages;
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
	public static final int IS_TARGET = 1 << 4;

	/** Library type. */
	public static final int IS_LIBRARY = 1 << 5;

	private ScrolledComposite scrollContainer;

	private Composite rootContainer;

	private Combo projectsList;

	private Combo projectFilesList;

	private List sourceMetamodelsFromModule = new ArrayList();

	private List targetMetamodelsFromModule = new ArrayList();

	private List sourceModelsFromModule = new ArrayList();

	private List targetModelsFromModule = new ArrayList();

	private List librariesFromModule = new ArrayList();

	private List superimposedFromLaunchConfig = new ArrayList();

	private List nonLibraries = new ArrayList();

	private List removableMetamodels = new ArrayList();

	private List removableSourceModels = new ArrayList();

	private List removableTargetModels = new ArrayList();

	private List removableLibraries = new ArrayList();

	private Map sourceC2RelationshipFromModule = new HashMap();

	private Map targetC2RelationshipFromModule = new HashMap();

	private Group projectInformationGroup;

	private Group metamodelsGroup;

	private Group sourceModelsGroup;

	private Group targetModelsGroup;

	private Group librariesGroup;

	private Group controlGroup;

	private Map metamodelsGroupWidgets = new HashMap();

	private Map sourceModelsGroupWidgets = new HashMap();

	private Map targetModelsGroupWidgets = new HashMap();

	private Map librariesGroupWidgets = new HashMap();

	private Pattern asmToAtl = Pattern.compile("\\.asm$"); //$NON-NLS-1$

	private Pattern moduleName = Pattern.compile("^.*/(.*)\\.a(tl|sm)$"); //$NON-NLS-1$

	private Map asmFileCache = new HashMap();

	private Map metamodelLocations = new HashMap();

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

		projectInformationGroup = new Group(rootContainer, SWT.NULL);
		projectInformationGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		projectInformationGroup.setLayout(new GridLayout(2, false));
		projectInformationGroup.setText(AtlDebugMessages.getString("MainAtlTab.PROJECT")); //$NON-NLS-1$

		Label projectNameLabel = new Label(projectInformationGroup, SWT.NULL);
		projectNameLabel.setText(AtlDebugMessages.getString("MainAtlTab.PROJECTNAME")); //$NON-NLS-1$

		projectsList = new Combo(projectInformationGroup, SWT.NULL | SWT.READ_ONLY);
		projectsList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		projectsList.setItems(AtlLauncherTools.projectNames());

		Label projectFileLabel = new Label(projectInformationGroup, SWT.NULL);
		projectFileLabel.setText(AtlDebugMessages.getString("MainAtlTab.ATLFILENAME")); //$NON-NLS-1$

		projectFilesList = new Combo(projectInformationGroup, SWT.NULL | SWT.READ_ONLY);
		projectFilesList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		metamodelsGroup = new Group(rootContainer, SWT.NULL);
		metamodelsGroup.setText(AtlDebugMessages.getString("MainAtlTab.METAMODELS")); //$NON-NLS-1$
		metamodelsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		metamodelsGroup.setLayout(new GridLayout(8, false));

		sourceModelsGroup = new Group(rootContainer, SWT.NULL);
		sourceModelsGroup.setText(AtlDebugMessages.getString("MainAtlTab.SOURCEMODELS")); //$NON-NLS-1$
		sourceModelsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		sourceModelsGroup.setLayout(new GridLayout(4, false));

		targetModelsGroup = new Group(rootContainer, SWT.NULL);
		targetModelsGroup.setText(AtlDebugMessages.getString("MainAtlTab.TARGETMODELS")); //$NON-NLS-1$
		targetModelsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		targetModelsGroup.setLayout(new GridLayout(4, false));

		librariesGroup = new Group(rootContainer, SWT.NULL);
		librariesGroup.setText(AtlDebugMessages.getString("MainAtlTab.LIBRARIES")); //$NON-NLS-1$
		librariesGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		librariesGroup.setLayout(new GridLayout(4, false));

		controlGroup = new Group(rootContainer, SWT.NULL);
		controlGroup.setText(AtlDebugMessages.getString("MainAtlTab.MODIFY")); //$NON-NLS-1$
		controlGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		controlGroup.setLayout(new GridLayout(7, false));

		final Button addSourceModelBtn = new Button(controlGroup, SWT.NULL);
		addSourceModelBtn.setText(AtlDebugMessages.getString("MainAtlTab.ADDSOURCE")); //$NON-NLS-1$
		final Button addTargetModelBtn = new Button(controlGroup, SWT.NULL);
		addTargetModelBtn.setText(AtlDebugMessages.getString("MainAtlTab.ADDTARGET")); //$NON-NLS-1$
		final Button addLibBtn = new Button(controlGroup, SWT.NULL);
		addLibBtn.setText(AtlDebugMessages.getString("MainAtlTab.ADDLIB")); //$NON-NLS-1$

		projectsList.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				projectFilesList.setItems(AtlLauncherTools.fileNames(projectsList.getText()));
				updateLaunchConfigurationDialog();
			}
		});

		projectFilesList.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				rebuild();
			}
		});

		addSourceModelBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				InputDialog dlg = new InputDialog(getShell(), AtlDebugMessages
						.getString("MainAtlTab.ADDSOURCEMODEL"), //$NON-NLS-1$
						AtlDebugMessages.getString("MainAtlTab.MMNAME"), //$NON-NLS-1$
						"MM", //$NON-NLS-1$
						null);
				if (dlg.open() == InputDialog.CANCEL) {
					return;
				}
				String metamodelName = dlg.getValue();
				dlg = new InputDialog(getShell(), AtlDebugMessages.getString("MainAtlTab.ADDSOURCEMODEL"), //$NON-NLS-1$
						AtlDebugMessages.getString("MainAtlTab.MNAME"), //$NON-NLS-1$
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
			public void widgetSelected(SelectionEvent evt) {
				InputDialog dlg = new InputDialog(getShell(), AtlDebugMessages
						.getString("MainAtlTab.ADDTARGETMODEL"), //$NON-NLS-1$
						AtlDebugMessages.getString("MainAtlTab.MMNAME"), //$NON-NLS-1$
						"MM", //$NON-NLS-1$
						null);
				if (dlg.open() == InputDialog.CANCEL) {
					return;
				}
				String metamodelName = dlg.getValue();
				dlg = new InputDialog(getShell(), AtlDebugMessages.getString("MainAtlTab.ADDTARGETMODEL"), //$NON-NLS-1$
						AtlDebugMessages.getString("MainAtlTab.MNAME"), //$NON-NLS-1$
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
			public void widgetSelected(SelectionEvent evt) {
				InputDialog dlg = new InputDialog(getShell(), AtlDebugMessages
						.getString("MainAtlTab.ADDLIBRARY"), //$NON-NLS-1$
						AtlDebugMessages.getString("MainAtlTab.LIBRARYNAME"), //$NON-NLS-1$
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
	public void superimposedChanged(List superimposed) {
		superimposedFromLaunchConfig = superimposed;
		build();
		layout();
	}

	private void rebuild() {
		try {
			clear();
			build();
			initializeExtraWidgetsFrom(launchConfiguration);
			build();
			initializeWidgetValuesFrom(launchConfiguration);
			layout();
		} catch (CoreException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
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

		Map savedLibraries = configuration.getAttribute(AtlLauncherTools.LIBS, new HashMap());
		Map input = configuration.getAttribute(AtlLauncherTools.INPUT, new HashMap());
		Map output = configuration.getAttribute(AtlLauncherTools.OUTPUT, new HashMap());

		for (Iterator i = input.keySet().iterator(); i.hasNext();) {
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

		for (Iterator i = output.keySet().iterator(); i.hasNext();) {
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

		for (Iterator i = savedLibraries.keySet().iterator(); i.hasNext();) {
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

		Map savedPaths = configuration.getAttribute(AtlLauncherTools.PATH, new HashMap());
		Map savedModelHandlers = configuration.getAttribute(AtlLauncherTools.MODELHANDLER, new HashMap());
		Map savedLibraries = configuration.getAttribute(AtlLauncherTools.LIBS, new HashMap());

		for (Iterator i = savedPaths.keySet().iterator(); i.hasNext();) {
			String modelName = (String)i.next();
			if (metamodelsGroupWidgets.get(modelName) != null) {
				Map widgets = (Map)metamodelsGroupWidgets.get(modelName);
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
					if (modelHandlers.getItem(item).equals((String)savedModelHandlers.get(modelName))) {
						modelHandlers.select(item);
					}
				}

			} else {
				Map widgets = null;
				if (sourceModelsGroupWidgets.get(modelName) != null) {
					widgets = (Map)sourceModelsGroupWidgets.get(modelName);
				} else if (targetModelsGroupWidgets.get(modelName) != null) {
					widgets = (Map)targetModelsGroupWidgets.get(modelName);
				}
				if (widgets != null) {
					Text modelLocation = (Text)widgets.get("location"); //$NON-NLS-1$
					modelLocation.setText((String)savedPaths.get(modelName));
				}
			}
		}

		for (Iterator i = savedLibraries.keySet().iterator(); i.hasNext();) {
			String libraryName = (String)i.next();
			Map widgets = (Map)librariesGroupWidgets.get(libraryName);
			if (widgets != null) {
				Text libraryLocation = (Text)widgets.get("location"); //$NON-NLS-1$
				libraryLocation.setText((String)savedLibraries.get(libraryName));
			}
		}
	}

	private void calcNonLibraries() {
		nonLibraries.clear();
		String path = projectFilesList.getText();
		Matcher m = moduleName.matcher(path);
		if (m.find()) {
			nonLibraries.add(m.group(1));
		}
		for (Iterator i = superimposedFromLaunchConfig.iterator(); i.hasNext();) {
			path = (String)i.next();
			m = moduleName.matcher(path);
			if (m.find()) {
				nonLibraries.add(m.group(1));
			}
		}
	}

	private void getModelsFromATLFiles() {
		IWorkspaceRoot wsRoot = ResourcesPlugin.getWorkspace().getRoot();
		String path = projectFilesList.getText();
		IResource res = wsRoot.findMember(path);
		if (res instanceof IFile) {
			getModelsFromATLFile((IFile)res);
		}
		for (Iterator i = superimposedFromLaunchConfig.iterator(); i.hasNext();) {
			path = (String)i.next();
			path = asmToAtl.matcher(path).replaceFirst(".atl"); //$NON-NLS-1$
			res = wsRoot.findMember(path);
			if (res instanceof IFile) {
				getModelsFromATLFile((IFile)res);
			} else {
				ATLLogger.severe(AtlDebugMessages.getString("MainAtlTab.FILENOTFOUND") + path); //$NON-NLS-1$
			}
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

	private void buildMetamodelControls(Collection modelNames) {
		Iterator i = modelNames.iterator();
		while (i.hasNext()) {
			String modelName = (String)i.next();
			if (!metamodelsGroupWidgets.containsKey(modelName)) {
				metamodelsGroupWidgets.put(modelName, buildMetamodelsControls(metamodelsGroup, modelName,
						IS_SOURCE | IS_METAMODEL, removableMetamodels.contains(modelName)));
			}
		}
	}

	private void buildSourceModelControls(Collection modelNames) {
		Iterator i = modelNames.iterator();
		while (i.hasNext()) {
			String modelName = (String)i.next();
			if (!sourceModelsGroupWidgets.containsKey(modelName)) {
				String mmName = (String)sourceC2RelationshipFromModule.get(modelName);
				sourceModelsGroupWidgets.put(modelName, buildModelsAndLibrariesControls(sourceModelsGroup,
						modelName, mmName, IS_SOURCE | IS_MODEL, removableSourceModels.contains(modelName)));
			}
		}
	}

	private void buildTargetModelControls(Collection modelNames) {
		Iterator i = modelNames.iterator();
		while (i.hasNext()) {
			String modelName = (String)i.next();
			if (targetModelsGroupWidgets.get(modelName) == null) {
				String mmName = (String)targetC2RelationshipFromModule.get(modelName);
				targetModelsGroupWidgets.put(modelName, buildModelsAndLibrariesControls(targetModelsGroup,
						modelName, mmName, IS_TARGET | IS_MODEL, removableTargetModels.contains(modelName)));
			}
		}
	}

	private void buildLibraryControls(Collection libraryNames) {
		Iterator i = libraryNames.iterator();
		while (i.hasNext()) {
			String libraryName = (String)i.next();
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
	public void initializeFrom(ILaunchConfiguration configuration) {
		this.launchConfiguration = configuration;
		try {
			String projectName = configuration.getAttribute(AtlLauncherTools.PROJECTNAME, "");
			String fileName = configuration.getAttribute(AtlLauncherTools.ATLFILENAME, "");
			superimposedFromLaunchConfig = configuration.getAttribute(AtlLauncherTools.SUPERIMPOSE,
					new ArrayList());
			projectsList.setText(projectName); //$NON-NLS-1$
			projectFilesList.setItems(AtlLauncherTools.fileNames(projectName));
			projectFilesList.setText(fileName); //$NON-NLS-1$
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
		Map savedPaths = new HashMap();
		Map savedModelHandlers = new HashMap();
		Map savedLibraries = new HashMap();
		Map savedInput = new HashMap();
		Map savedOutput = new HashMap();
		Map savedType = new HashMap();

		for (Iterator it = sourceMetamodelsFromModule.iterator(); it.hasNext();) {
			String modelName = (String)it.next();
			String location = ((Text)((Map)metamodelsGroupWidgets.get(modelName)).get("metamodelLocation")).getText(); //$NON-NLS-1$
			String modelHandler = ((Combo)((Map)metamodelsGroupWidgets.get(modelName)).get("modelHandlers")).getText(); //$NON-NLS-1$
			boolean isMetametamodel = ((Button)((Map)metamodelsGroupWidgets.get(modelName))
					.get("isMetametamodel")).getSelection(); //$NON-NLS-1$
			if (isMetametamodel) {
				savedPaths.put(modelName, "#" + modelHandler); //$NON-NLS-1$
			} else {
				savedPaths.put(modelName, location);
			}
			savedModelHandlers.put(modelName, modelHandler);
		}

		for (Iterator it = targetMetamodelsFromModule.iterator(); it.hasNext();) {
			String modelName = (String)it.next();
			String location = ((Text)((Map)metamodelsGroupWidgets.get(modelName)).get("metamodelLocation")).getText(); //$NON-NLS-1$
			String modelHandler = ((Combo)((Map)metamodelsGroupWidgets.get(modelName)).get("modelHandlers")).getText(); //$NON-NLS-1$
			boolean isMetametamodel = ((Button)((Map)metamodelsGroupWidgets.get(modelName))
					.get("isMetametamodel")).getSelection(); //$NON-NLS-1$
			if (isMetametamodel) {
				savedPaths.put(modelName, "#" + modelHandler); //$NON-NLS-1$
			} else {
				savedPaths.put(modelName, location);
			}
			savedModelHandlers.put(modelName, modelHandler);
		}

		for (Iterator it = sourceModelsFromModule.iterator(); it.hasNext();) {
			String modelName = (String)it.next();
			String location = ((Text)((Map)sourceModelsGroupWidgets.get(modelName)).get("location")).getText(); //$NON-NLS-1$
			savedPaths.put(modelName, location);
		}

		for (Iterator it = targetModelsFromModule.iterator(); it.hasNext();) {
			String modelName = (String)it.next();
			String location = ((Text)((Map)targetModelsGroupWidgets.get(modelName)).get("location")).getText(); //$NON-NLS-1$
			savedPaths.put(modelName, location);
		}

		for (Iterator it = librariesFromModule.iterator(); it.hasNext();) {
			String modelName = (String)it.next();
			String location = ((Text)((Map)librariesGroupWidgets.get(modelName)).get("location")).getText(); //$NON-NLS-1$
			savedLibraries.put(modelName, location);
		}

		for (Iterator it = sourceC2RelationshipFromModule.entrySet().iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry)it.next();
			savedInput.put(entry.getKey(), entry.getValue());
			savedType.put(entry.getKey(), AtlLauncherTools.MODEL_INPUT);
			savedType.put(entry.getValue(), AtlLauncherTools.METAMODEL_INPUT);

		}

		for (Iterator it = targetC2RelationshipFromModule.entrySet().iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry)it.next();
			savedOutput.put(entry.getKey(), entry.getValue());
			savedType.put(entry.getKey(), AtlLauncherTools.MODEL_OUTPUT);
			savedType.put(entry.getValue(), AtlLauncherTools.METAMODEL_OUTPUT);
		}

		configuration.setAttribute(AtlLauncherTools.PROJECTNAME, projectsList.getText());
		configuration.setAttribute(AtlLauncherTools.ATLFILENAME, projectFilesList.getText());
		configuration.setAttribute(AtlLauncherTools.PATH, savedPaths);
		configuration.setAttribute(AtlLauncherTools.MODELHANDLER, savedModelHandlers);
		configuration.setAttribute(AtlLauncherTools.LIBS, savedLibraries);
		configuration.setAttribute(AtlLauncherTools.INPUT, savedInput);
		configuration.setAttribute(AtlLauncherTools.OUTPUT, savedOutput);
		configuration.setAttribute(AtlLauncherTools.MODELTYPE, savedType);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return AtlLauncherTools.REMOTEATLNAME;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#canSave()
	 */
	public boolean canSave() {
		if (projectsList.getText().equals("")) { //$NON-NLS-1$
			this.setErrorMessage(AtlDebugMessages.getString("MainAtlTab.GIVEPROJECTNAME")); //$NON-NLS-1$
			return false;
		}
		if (projectFilesList.getText().equals("")) { //$NON-NLS-1$
			this.setErrorMessage(AtlDebugMessages.getString("MainAtlTab.GIVETRANSFORMATIONNAME")); //$NON-NLS-1$
			return false;
		}
		for (Iterator i = metamodelsGroupWidgets.entrySet().iterator(); i.hasNext();) {
			Map.Entry entry = (Map.Entry)i.next();
			String mName = (String)entry.getKey();
			Map widgets = (Map)entry.getValue();
			Text metamodelLocation = (Text)widgets.get("metamodelLocation"); //$NON-NLS-1$
			Button isMetametamodel = (Button)widgets.get("isMetametamodel"); //$NON-NLS-1$
			if ((metamodelLocation.getText().length() == 0) && (!isMetametamodel.getSelection())) {
				this.setErrorMessage(AtlDebugMessages.getString("MainAtlTab.GIVEPATHFOR") + mName); //$NON-NLS-1$
				return false;
			}
		}
		if (!canSaveModelsGroupWidgets(sourceModelsGroupWidgets)) {
			return false;
		}
		if (!canSaveModelsGroupWidgets(targetModelsGroupWidgets)) {
			return false;
		}
		if (!canSaveModelsGroupWidgets(librariesGroupWidgets)) {
			return false;
		}
		this.setErrorMessage(null);
		return true;
	}

	/**
	 * Returns True if modelsGroupWidgets is in a correct state, false otherwise.
	 * 
	 * @param modelsGroupWidgets
	 *            input/output models or libraries widgets
	 * @return True if modelsGroupWidgets is in a correct state, false otherwise
	 */
	private boolean canSaveModelsGroupWidgets(Map modelsGroupWidgets) {
		for (Iterator i = modelsGroupWidgets.entrySet().iterator(); i.hasNext();) {
			Map.Entry entry = (Map.Entry)i.next();
			String mName = (String)entry.getKey();
			Map widgets = (Map)entry.getValue();
			Text location = (Text)widgets.get("location"); //$NON-NLS-1$
			if (location.getText().length() == 0) {
				this.setErrorMessage(AtlDebugMessages.getString("MainAtlTab.GIVEPATHFOR") + mName); //$NON-NLS-1$
				return false;
			}
		}
		return true;
	}

	public Image getImage() {
		return AtlLauncherTools.createImage(AtlLauncherTools.PATHICONATL);
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

		fileDialog.setFilterExtensions(new String[] {"*"}); //$NON-NLS-1$
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
			elementTreeSelectionDialog.setMessage(AtlDebugMessages.getString("ModelChoiceTab.CHOOSEMODEL")); //$NON-NLS-1$
			elementTreeSelectionDialog.setAllowMultiple(false);
			elementTreeSelectionDialog.setDoubleClickSelects(true);
			elementTreeSelectionDialog.addFilter(new ViewerFilter() {
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					boolean ret = false;
					if (element instanceof IContainer) {
						ret = true;
					} else if (element instanceof IFile) {
						IFile currentFile = (IFile)element;
						if (currentFile.getFileExtension() != null) {
							if (type == IS_LIBRARY) {
								ret = (currentFile.getFileExtension().toUpperCase()).equals("ASM"); //$NON-NLS-1$
							} else {
								ret = true;
							}
						}
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

	private Map buildMetamodelsControls(Group parent, final String metamodelName, final int type,
			boolean removable) {
		Map thisGroupWidgets = new HashMap();

		final Label metamodelLabel = new Label(parent, SWT.NULL);
		metamodelLabel.setText(metamodelName + ": "); //$NON-NLS-1$

		final Text metamodelLocation = new Text(parent, SWT.BORDER);
		thisGroupWidgets.put("metamodelLocation", metamodelLocation); //$NON-NLS-1$
		metamodelLocation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 6, 1));
		if (metamodelLocations != null) {
			String defaultLocation = (String)metamodelLocations.get(metamodelName);
			if (defaultLocation != null) {
				metamodelLocation.setText(defaultLocation);
			}
		}

		final Button remove = new Button(parent, SWT.NULL);
		remove.setText("X"); //$NON-NLS-1$

		if (!removable) {
			new Label(parent, SWT.NULL);
		}

		final Button isMetametamodel = new Button(parent, SWT.CHECK);
		thisGroupWidgets.put("isMetametamodel", isMetametamodel); //$NON-NLS-1$
		isMetametamodel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 2, 1));
		isMetametamodel.setText("Is metametamodel"); //$NON-NLS-1$
		isMetametamodel.setToolTipText(AtlDebugMessages.getString("MainAtlTab.MODELHANDLERCHOICE")); //$NON-NLS-1$

		final Label modelHandlerLabel = new Label(parent, SWT.NULL);
		modelHandlerLabel.setText("Model handler: "); //$NON-NLS-1$
		modelHandlerLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));

		final Combo modelHandlers = new Combo(parent, SWT.NULL | SWT.READ_ONLY);
		thisGroupWidgets.put("modelHandlers", modelHandlers); //$NON-NLS-1$
		modelHandlers.setItems(AtlLauncherTools.getModelHandlers());
		modelHandlers.select(AtlLauncherTools.getEMFKey());
		modelHandlers.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));

		final Button browseWorkspace = new Button(parent, SWT.NULL);
		browseWorkspace.setText("Workspace..."); //$NON-NLS-1$

		final Button browseFilesystem = new Button(parent, SWT.NULL);
		browseFilesystem.setText("File system..."); //$NON-NLS-1$

		final Button browseEMFRegistry = new Button(parent, SWT.NULL);
		browseEMFRegistry.setText("EMF Registry..."); //$NON-NLS-1$

		final Label filler = new Label(parent, SWT.NULL);
		filler.setLayoutData(new GridData(SWT.NULL, SWT.NULL, false, false, 1, 1));

		metamodelLocation.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (metamodelLocation.getText().startsWith("uri:")) { //$NON-NLS-1$
					modelHandlers.select(AtlLauncherTools.getEMFKey());
					// TODO Turn modelHandlers combo to enabled until UML2ATL Driver refactoring (getMof()
					// method)
					modelHandlers.setEnabled(true);
				} else {
					modelHandlers.setEnabled(true);
				}
				updateLaunchConfigurationDialog();
			}

		});

		isMetametamodel.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				metamodelLocation.setEnabled(!isMetametamodel.getSelection());
				browseWorkspace.setEnabled(!isMetametamodel.getSelection());
				browseFilesystem.setEnabled(!isMetametamodel.getSelection());
				browseEMFRegistry.setEnabled(!isMetametamodel.getSelection());
				if (isMetametamodel.getSelection()) {
					modelHandlers.setEnabled(true);
				} else {
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
			public void widgetSelected(SelectionEvent evt) {
				String path = editPath(type);
				if (path.trim().length() > 0) {
					metamodelLocation.setText(path);
				}
			}
		});

		browseFilesystem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				String path = editExternalPath(type);
				if (path.trim().length() > 0) {
					metamodelLocation.setText(path);
				}
			}
		});

		browseEMFRegistry.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				DialogUriSelection launcher = new DialogUriSelection(new Shell());
				launcher.create();
				if (launcher.open() == Dialog.OK) {
					metamodelLocation.setText("uri:" + launcher.getUriSelected()); //$NON-NLS-1$
				}
			}
		});

		final SelectionAdapter removeAdapter = new SelectionAdapter() {
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

	private Map buildModelsAndLibrariesControls(Group parent, final String modelName,
			final String metamodelName, final int type, boolean removable) {
		Map thisGroupWidgets = new HashMap();

		final Label modelLabel = new Label(parent, SWT.NULL);
		modelLabel.setText(modelName + ": "); //$NON-NLS-1$

		final Text location = new Text(parent, SWT.BORDER);
		thisGroupWidgets.put("location", location); //$NON-NLS-1$
		location.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		final Button remove = new Button(parent, SWT.NULL);
		remove.setText("X"); //$NON-NLS-1$
		thisGroupWidgets.put("remove", remove); //$NON-NLS-1$

		if (!removable) {
			new Label(parent, SWT.NULL);
		}

		final Label metamodelLabel = new Label(parent, SWT.NULL);
		if (metamodelName != null) {
			metamodelLabel.setText("conforms to " + metamodelName); //$NON-NLS-1$
		}

		final Button browseWorkspace = new Button(parent, SWT.NULL);
		browseWorkspace.setText("Workspace..."); //$NON-NLS-1$
		browseWorkspace.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));

		final Button browseFilesystem = new Button(parent, SWT.NULL);
		browseFilesystem.setText("File system..."); //$NON-NLS-1$

		final Label filler = new Label(parent, SWT.NULL);
		filler.setLayoutData(new GridData(SWT.NULL, SWT.NULL, false, false, 1, 1));

		location.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();

			}
		});

		browseWorkspace.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				String path = editPath(type);
				if (path.trim().length() > 0) {
					location.setText(path);
				}
			}
		});

		browseFilesystem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				String path = editExternalPath(type);
				if (path.trim().length() > 0) {
					location.setText(path);
				}
			}
		});

		final SelectionAdapter removeAdapter = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				if (sourceModelsGroupWidgets.get(modelName) != null) {
					sourceModelsGroupWidgets.remove(modelName);
					sourceModelsFromModule.remove(modelName);
					String mmName = (String)sourceC2RelationshipFromModule.remove(modelName);
					updateMetamodelsGroupFor(mmName);
				} else if (targetModelsGroupWidgets.get(modelName) != null) {
					targetModelsGroupWidgets.remove(modelName);
					targetModelsFromModule.remove(modelName);
					String mmName = (String)targetC2RelationshipFromModule.remove(modelName);
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
			Map widgets = (Map)metamodelsGroupWidgets.get(metamodelName);
			if (widgets != null) {
				SelectionAdapter removeAdapter = (SelectionAdapter)widgets.get("removeAdapter"); //$NON-NLS-1$
				removeAdapter.widgetSelected(null);
			}
		}
	}

	private void updateModelsGroupFor(String metamodelName) {
		for (Iterator i = sourceC2RelationshipFromModule.entrySet().iterator(); i.hasNext();) {
			Map.Entry entry = (Map.Entry)i.next();
			if (entry.getValue().equals(metamodelName)) {
				i.remove();
				Map widgets = (Map)sourceModelsGroupWidgets.get(entry.getKey());
				if (widgets != null) {
					SelectionAdapter removeAdapter = (SelectionAdapter)widgets.get("removeAdapter"); //$NON-NLS-1$
					removeAdapter.widgetSelected(null);
				}
			}
		}
		for (Iterator i = targetC2RelationshipFromModule.entrySet().iterator(); i.hasNext();) {
			Map.Entry entry = (Map.Entry)i.next();
			if (entry.getValue().equals(metamodelName)) {
				i.remove();
				Map widgets = (Map)targetModelsGroupWidgets.get(entry.getKey());
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

	private void getModelsFromATLFile(IFile file) {
		final boolean debug = false;

		AtlSourceManager sourceManager;
		if (asmFileCache.containsKey(file)) {
			sourceManager = (AtlSourceManager)asmFileCache.get(file);
			if (debug) {
				ATLLogger.info("Cached ATL File found for " + file.toString()); //$NON-NLS-1$
			}
		} else {
			sourceManager = new AtlSourceManager();
			try {
				sourceManager.updateDataSource(file.getContents());
			} catch (CoreException e) {
				ATLLogger.warning("Unable to detect meta-informations from " + file.getName());
				return;
			}
			asmFileCache.put(file, sourceManager);
			if (debug) {
				ATLLogger.info("Loaded ATL File from " + file.toString()); //$NON-NLS-1$
			}
		}

		switch (sourceManager.getATLFileType()) {
			case AtlSourceManager.ATL_FILE_TYPE_MODULE:
				for (Iterator iterator = sourceManager.getInputModels().entrySet().iterator(); iterator
						.hasNext();) {
					Entry entry = (Entry)iterator.next();
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
				for (Iterator iterator = sourceManager.getOutputModels().entrySet().iterator(); iterator
						.hasNext();) {
					Entry entry = (Entry)iterator.next();
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
				for (Iterator iterator = sourceManager.getLibrariesImports().iterator(); iterator.hasNext();) {
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
				for (Iterator iterator = sourceManager.getInputModels().entrySet().iterator(); iterator
						.hasNext();) {
					Entry entry = (Entry)iterator.next();
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
				for (Iterator iterator = sourceManager.getLibrariesImports().iterator(); iterator.hasNext();) {
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

}
