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
package org.eclipse.m2m.atl.emftvm.launcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.m2m.atl.adt.ui.common.RegisteredPackageDialog;
import org.eclipse.m2m.atl.adt.ui.common.WorkspaceFileDialog;
import org.eclipse.m2m.atl.common.ATLLaunchConstants;
import org.eclipse.m2m.atl.emftvm.ModelDeclaration;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.util.ModuleNotFoundException;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.PlatformUI;


/**
 * Main UI tab for launching EMFTVM transformations.
 * Derived from {@link org.eclipse.m2m.atl.core.ui.launch.MainAtlTab}.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class MainEMFTVMTab extends AbstractLaunchConfigurationTab {

	private ScrolledComposite scrollContainer;
	private Composite rootContainer;
	private Group moduleGroup;
	private Text moduleNameText;
	private Text modulePathText;
	private Group metamodelsGroup;
	private Group inputModelsGroup;
	private Group inoutModelsGroup;
	private Group outputModelsGroup;
	private Group controlGroup;

	private ILaunchConfiguration launchConfiguration;

	private Module module;
	private boolean moduleChanged;
	private final Map<List<String>, Module> moduleCache = new HashMap<List<String>, Module>();

	private final Map<String, Map<String, Object>> metamodelsGroupWidgets = new LinkedHashMap<String, Map<String, Object>>();
	private final Map<String, Map<String, Object>> inputModelsGroupWidgets = new LinkedHashMap<String, Map<String, Object>>();
	private final Map<String, Map<String, Object>> inoutModelsGroupWidgets = new LinkedHashMap<String, Map<String, Object>>();
	private final Map<String, Map<String, Object>> outputModelsGroupWidgets = new LinkedHashMap<String, Map<String, Object>>();

	private final Collection<String> removableMetamodels = new LinkedHashSet<String>();
	private final Collection<String> removableInputModels = new LinkedHashSet<String>();
	private final Collection<String> removableInoutModels = new LinkedHashSet<String>();
	private final Collection<String> removableOutputModels = new LinkedHashSet<String>();

	private final Map<String, String> metamodelLocations = new LinkedHashMap<String, String>();
	private final Map<String, String> inputModelLocations = new LinkedHashMap<String, String>();
	private final Map<String, String> inoutModelLocations = new LinkedHashMap<String, String>();
	private final Map<String, String> inoutModelOutLocations = new LinkedHashMap<String, String>();
	private final Map<String, String> outputModelLocations = new LinkedHashMap<String, String>();

	private final Map<String, String> metamodelOptions = new LinkedHashMap<String, String>();
	private final Map<String, String> inputModelOptions = new LinkedHashMap<String, String>();
	private final Map<String, String> inoutModelOptions = new LinkedHashMap<String, String>();
	private final Map<String, String> outputModelOptions = new LinkedHashMap<String, String>();

	/**
	 * {@inheritDoc}
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
		moduleGroup.setText("EMFTVM module");

		final Label moduleFileLabel = new Label(moduleGroup, SWT.LEFT);
		moduleFileLabel.setLayoutData(new GridData(SWT.LEFT));
		moduleFileLabel.setText("Module:");

		moduleNameText = new Text(moduleGroup, SWT.SINGLE | SWT.BORDER);
		moduleNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		moduleNameText.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (moduleChanged) {
					rebuild();
				}
			}
			public void focusGained(FocusEvent e) {
			}
		});
		moduleNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (!moduleChanged) {
					moduleChanged = true;
					PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
						public void run() {
							rebuild();
						}
					});
				}
			}
		});

		final Button browseWorkspace = new Button(moduleGroup, SWT.RIGHT);
		browseWorkspace.setText("Workspace...");
		browseWorkspace.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				final String[] extensions = new String[] {"emftvm"};
				final WorkspaceFileDialog dialog = new WorkspaceFileDialog(getShell(), extensions);
				final Object result = dialog.open() == Dialog.OK ? dialog.getFirstResult() : null;
				if ((result != null) && (result instanceof IFile)) {
					final IFile currentFile = (IFile)result;
					final IPath path = currentFile.getFullPath();
					final URI uri = URI.createPlatformResourceURI(path.toString(), true);
					final Module module = findModule(uri);
					if (module != null) {
						final String mName = module.getName();
						moduleNameText.setText(mName);
						int segments = 1;
						for (int index = mName.indexOf("::"); index > -1; index = mName.indexOf("::", index + 1)) {
							segments++;
						}
						modulePathText.setText(path.removeLastSegments(segments).toString() + '/');
					} else {
						modulePathText.setText(path.removeLastSegments(1).toString() + '/');
						moduleNameText.setText(path.removeFileExtension().lastSegment());
					}
					rebuild();
				}
			}
		});

		final Label modulePathLabel = new Label(moduleGroup, SWT.LEFT);
		modulePathLabel.setLayoutData(new GridData(SWT.LEFT));
		modulePathLabel.setText("Path:");

		modulePathText = new Text(moduleGroup, SWT.SINGLE | SWT.BORDER);
		final GridData modulePathData = new GridData(GridData.FILL_HORIZONTAL);
		modulePathData.horizontalSpan = 2;
		modulePathText.setLayoutData(modulePathData);
		modulePathText.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (moduleChanged) {
					rebuild();
				}
			}
			public void focusGained(FocusEvent e) {
			}
		});
		modulePathText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (!moduleChanged) {
					moduleChanged = true;
					PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
						public void run() {
							rebuild();
						}
					});
				}
			}
		});

		metamodelsGroup = new Group(rootContainer, SWT.NULL);
		metamodelsGroup.setText("Metamodels");
		metamodelsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		metamodelsGroup.setLayout(new GridLayout(8, false));

		inputModelsGroup = new Group(rootContainer, SWT.NULL);
		inputModelsGroup.setText("Input models");
		inputModelsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		inputModelsGroup.setLayout(new GridLayout(8, false));

		inoutModelsGroup = new Group(rootContainer, SWT.NULL);
		inoutModelsGroup.setText("In/out models");
		inoutModelsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		inoutModelsGroup.setLayout(new GridLayout(8, false));

		outputModelsGroup = new Group(rootContainer, SWT.NULL);
		outputModelsGroup.setText("Output models");
		outputModelsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		outputModelsGroup.setLayout(new GridLayout(8, false));

		controlGroup = new Group(rootContainer, SWT.NULL);
		controlGroup.setText("Modify");
		controlGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		controlGroup.setLayout(new GridLayout(7, false));

		final Button addMetaModelBtn = new Button(controlGroup, SWT.NULL);
		addMetaModelBtn.setText("Add metamodel...");
		addMetaModelBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				final InputDialog dlg = new InputDialog(getShell(),
						"Add metamodel",
						"Metaodel name",
						"MM", //$NON-NLS-1$
						null);
				if (dlg.open() == InputDialog.CANCEL) {
					return;
				}
				final String modelName = dlg.getValue();
				if (!metamodelLocations.containsKey(modelName)) {
					metamodelLocations.put(modelName, "");
					removableMetamodels.add(modelName);
					build();
					layout();
				}
			}
		});

		final Button addInputModelBtn = new Button(controlGroup, SWT.NULL);
		addInputModelBtn.setText("Add input model...");
		addInputModelBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				final InputDialog dlg = new InputDialog(getShell(),
						"Add input model",
						"Model name",
						"IN", //$NON-NLS-1$
						null);
				if (dlg.open() == InputDialog.CANCEL) {
					return;
				}
				final String modelName = dlg.getValue();
				if (!inputModelLocations.containsKey(modelName)) {
					inputModelLocations.put(modelName, "");
					removableInputModels.add(modelName);
					build();
					layout();
				}
			}
		});

		final Button addInoutModelBtn = new Button(controlGroup, SWT.NULL);
		addInoutModelBtn.setText("Add in/out model...");
		addInoutModelBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				final InputDialog dlg = new InputDialog(getShell(),
						"Add in/out model",
						"Model name",
						"M", //$NON-NLS-1$
						null);
				if (dlg.open() == InputDialog.CANCEL) {
					return;
				}
				final String modelName = dlg.getValue();
				if (!inoutModelLocations.containsKey(modelName)) {
					inoutModelLocations.put(modelName, "");
					removableInoutModels.add(modelName);
					build();
					layout();
				}
			}
		});

		final Button addOutputModelBtn = new Button(controlGroup, SWT.NULL);
		addOutputModelBtn.setText("Add output model...");
		addOutputModelBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				final InputDialog dlg = new InputDialog(getShell(),
						"Add output model",
						"Model name",
						"OUT", //$NON-NLS-1$
						null);
				if (dlg.open() == InputDialog.CANCEL) {
					return;
				}
				final String modelName = dlg.getValue();
				if (!outputModelLocations.containsKey(modelName)) {
					outputModelLocations.put(modelName, "");
					removableOutputModels.add(modelName);
					build();
					layout();
				}
			}
		});

		setControl(scrollContainer);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	/**
	 * {@inheritDoc}
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		launchConfiguration = configuration;
		try {
			String name = configuration.getAttribute(EMFTVMLaunchConstants.MODULE_NAME, "");
			String path = configuration.getAttribute(EMFTVMLaunchConstants.MODULE_PATH, "");
			final String oldPath = configuration.getAttribute(EMFTVMLaunchConstants.MODULE_FILE_NAME, "");
			if ((name.equals("") || path.equals("")) && !oldPath.equals("")) {
				// convert legacy path to new path and module name
				final int index = oldPath.lastIndexOf('/') + 1;
				path = oldPath.substring(0, index);
				final int dotIndex = oldPath.lastIndexOf('.');
				name = dotIndex < 0 ? oldPath.substring(index) : oldPath.substring(index, dotIndex); // strip file extension
			}
			if (!name.equals(moduleNameText.getText()) || !path.equals(modulePathText.getText())) {
				moduleChanged = true; // prevent rebuild() trigger
				moduleNameText.setText(name);
				modulePathText.setText(path);
			}
			rebuild();
		} catch (CoreException e) {
			EmftvmLauncherPlugin.log(e.getStatus());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(EMFTVMLaunchConstants.MODULE_NAME, moduleNameText.getText());
		configuration.setAttribute(EMFTVMLaunchConstants.MODULE_PATH, modulePathText.getText());
		configuration.removeAttribute(EMFTVMLaunchConstants.MODULE_FILE_NAME); // legacy

		if (module != null && module.eResource().getURI().isPlatformResource()) {
			// backwards compatibility with ATL debugger
			URI moduleUri = module.eResource().getURI();
			configuration.setAttribute(ATLLaunchConstants.ATL_FILE_NAME,
					moduleUri.toPlatformString(true).replaceFirst("\\.emftvm$", ".atl"));
			Iterator<Module> it = module.getEImports().iterator();
			List<Iterator<Module>> its = new ArrayList<Iterator<Module>>();
			List<String> superimpose = new ArrayList<String>();
			Set<Module> processed = new HashSet<Module>();
			processed.add(module);
			Module m = null;
			do {
				if (it.hasNext()) {
					m = it.next();
					if (!processed.contains(m)) {
						its.add(it);
						it = m.getEImports().iterator();
						URI uri = m.eResource().getURI();
						if (uri.isPlatformResource()) {
							String mPath = uri.toPlatformString(true);
							superimpose.add(mPath.replaceFirst("\\.emftvm$", ".asm"));
						}
						processed.add(m);
					}
				} else if (!its.isEmpty()) {
					it = its.remove(its.size() - 1);
				} else {
					m = null;
				}
			} while (m != null);
			configuration.setAttribute(ATLLaunchConstants.SUPERIMPOSE, superimpose);
		}

		configuration.setAttribute(EMFTVMLaunchConstants.METAMODELS, new LinkedHashMap<String, String>(metamodelLocations));
		configuration.setAttribute(EMFTVMLaunchConstants.INPUT_MODELS, new LinkedHashMap<String, String>(inputModelLocations));
		configuration.setAttribute(EMFTVMLaunchConstants.INOUT_MODELS, new LinkedHashMap<String, String>(inoutModelLocations));
		configuration.setAttribute(EMFTVMLaunchConstants.INOUT_OUT_MODELS, new LinkedHashMap<String, String>(inoutModelOutLocations));
		configuration.setAttribute(EMFTVMLaunchConstants.OUTPUT_MODELS, new LinkedHashMap<String, String>(outputModelLocations));

		configuration.setAttribute(EMFTVMLaunchConstants.METAMODEL_OPTIONS, new LinkedHashMap<String, String>(metamodelOptions));
		configuration.setAttribute(EMFTVMLaunchConstants.INPUT_MODEL_OPTIONS, new LinkedHashMap<String, String>(inputModelOptions));
		configuration.setAttribute(EMFTVMLaunchConstants.INOUT_MODEL_OPTIONS, new LinkedHashMap<String, String>(inoutModelOptions));
		configuration.setAttribute(EMFTVMLaunchConstants.OUTPUT_MODEL_OPTIONS, new LinkedHashMap<String, String>(outputModelOptions));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);

		if (modulePathText.getText().equals("")) { //$NON-NLS-1$
			setErrorMessage("No EMFTVM module given");
			return false;
		}

		for (Entry<String, Map<String, Object>> entry : metamodelsGroupWidgets.entrySet()) {
			String mName = entry.getKey();
			Map<String, Object> widgets = entry.getValue();
			Text metamodelLocation = (Text)widgets.get("metamodelLocation"); //$NON-NLS-1$
			Button isMetametamodel = (Button)widgets.get("isMetametamodel"); //$NON-NLS-1$
			if ((metamodelLocation.getText().length() == 0) && (!isMetametamodel.getSelection())) {
				setErrorMessage(String.format("No path given for %s", mName));
				return false;
			}
		}

		return canSaveGroupWidgets(inputModelsGroupWidgets) && canSaveGroupWidgets(inoutModelsGroupWidgets)
				&& canSaveGroupWidgets(outputModelsGroupWidgets) && super.isValid(launchConfig);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return "Main";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage() {
		return EmftvmLauncherImages.get(EmftvmLauncherImages.OBJ_MAIN_TAB);
	}

	private boolean canSaveGroupWidgets(Map<String, Map<String, Object>> modelsGroupWidgets) {
		for (Iterator<Entry<String, Map<String, Object>>> i = modelsGroupWidgets.entrySet().iterator(); i
				.hasNext();) {
			Entry<String, Map<String, Object>> entry = i.next();
			String mName = entry.getKey();
			Map<String, Object> widgets = entry.getValue();
			Text location = (Text)widgets.get("location"); //$NON-NLS-1$
			if (location.getText().length() == 0) {
				this.setErrorMessage(String.format("No path given for %s", mName));
				return false;
			}
		}
		this.setErrorMessage(null);
		return true;
	}

	/**
	 * Clears all widget groups and creates them again from the launch configuration.
	 */
	private void rebuild() {
		moduleChanged = false;
		try {
			clear();
			getModelsFromEMFTVMFile();
			build();
			loadValuesFrom(launchConfiguration);
			build();
			layout();
		} catch (CoreException e) {
			EmftvmLauncherPlugin.log(e.getStatus());
		}
	}

	/**
	 * Creates widget group contents from current state.
	 */
	private void build() {
		buildMetamodelControls();
		buildInputModelControls();
		buildInoutModelControls();
		buildOutputModelControls();
	}

	/**
	 * Creates metamodel widget group contents.
	 */
	private void buildMetamodelControls() {
		for (Entry<String, String> entry : metamodelLocations.entrySet()) {
			String modelName = entry.getKey();
			String modelLocation = entry.getValue();
			if (!metamodelsGroupWidgets.containsKey(modelName)) {
				metamodelsGroupWidgets.put(modelName, 
						buildMetamodelControls(
								metamodelsGroup, 
								modelName,
								modelLocation,
								removableMetamodels.contains(modelName)));
			}
		}
	}

	/**
	 * Creates input model widget group contents.
	 */
	private void buildInputModelControls() {
		for (Entry<String, String> entry : inputModelLocations.entrySet()) {
			String modelName = entry.getKey();
			String modelLocation = entry.getValue();
			if (!inputModelsGroupWidgets.containsKey(modelName)) {
				inputModelsGroupWidgets.put(modelName, 
						buildModelControls(
								inputModelsGroup,
								modelName, 
								modelLocation,
								inputModelLocations,
								inputModelOptions,
								removableInputModels.contains(modelName),
								false, false));
			}
		}
	}

	/**
	 * Creates in/out model widget group contents.
	 */
	private void buildInoutModelControls() {
		for (Entry<String, String> entry : inoutModelLocations.entrySet()) {
			String modelName = entry.getKey();
			String modelLocation = entry.getValue();
			if (!inoutModelsGroupWidgets.containsKey(modelName)) {
				inoutModelsGroupWidgets.put(modelName, 
						buildModelControls(
								inoutModelsGroup,
								modelName, 
								modelLocation,
								inoutModelLocations,
								inoutModelOptions,
								removableInoutModels.contains(modelName),
								true, true));
			}
		}
	}

	/**
	 * Creates output model widget group contents.
	 */
	private void buildOutputModelControls() {
		for (Entry<String, String> entry : outputModelLocations.entrySet()) {
			String modelName = entry.getKey();
			String modelLocation = entry.getValue();
			if (outputModelsGroupWidgets.get(modelName) == null) {
				outputModelsGroupWidgets.put(modelName, 
						buildModelControls(
								outputModelsGroup,
								modelName, 
								modelLocation,
								outputModelLocations,
								outputModelOptions,
								removableOutputModels.contains(modelName),
								true, false));
			}
		}
	}

	/**
	 * Creates widgets for a metamodel.
	 * @param parent the parent widget group
	 * @param metamodelName the metamodel name
	 * @param removable whether the metamodel can be removed from the launch configuration
	 * @return a map of created widgets
	 */
	private Map<String, Object> buildMetamodelControls(final Group parent, final String metamodelName,
			final String metamodelLocation, final boolean removable) {
		final Map<String, Object> thisGroupWidgets = new HashMap<String, Object>();

		final Label metamodelLabel = new Label(parent, SWT.NULL);
		metamodelLabel.setText(metamodelName + ":"); //$NON-NLS-1$

		final Text location = new Text(parent, SWT.BORDER);
		location.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 6, 1));
		if (metamodelLocation != null) {
			location.setText(metamodelLocation);
		}
		location.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				metamodelLocations.put(metamodelName, location.getText());
				updateLaunchConfigurationDialog();
			}
		});
		thisGroupWidgets.put("metamodelLocation", location); //$NON-NLS-1$

		final Button delete;
		if (removable) {
			delete = new Button(parent, SWT.NULL);
			delete.setText("Delete");
		} else {
			delete = null;
			new Label(parent, SWT.NULL);
		}

		final Button isMetametamodel = new Button(parent, SWT.CHECK);
		isMetametamodel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 2, 1));
		isMetametamodel.setText("Is metametamodel");
		isMetametamodel.setToolTipText("Whether this is the root metamodel (Ecore)");
		isMetametamodel.setSelection(
				EMFTVMLaunchConfigurationDelegate.getBoolOption(
						metamodelOptions, 
						metamodelName, 
						EMFTVMLaunchConstants.OPT_IS_METAMETAMODEL));
		thisGroupWidgets.put("isMetametamodel", isMetametamodel); //$NON-NLS-1$

		final Button browseWorkspace = new Button(parent, SWT.NULL);
		browseWorkspace.setText("Workspace...");
		browseWorkspace.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				final WorkspaceFileDialog dialog = new WorkspaceFileDialog(getShell(), (String[])null);
				final Object result = dialog.open() == Dialog.OK ? dialog.getFirstResult() : null;
				if ((result != null) && (result instanceof IFile)) {
					final IFile currentFile = (IFile)result;
					final String path = currentFile.getFullPath().toString();
					location.setText("platform:/resource" + path);
				}
			}
		});

		final Button browseFilesystem = new Button(parent, SWT.NULL);
		browseFilesystem.setText("File system...");
		browseFilesystem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				final FileDialog fileDialog = new FileDialog(getShell(), SWT.OPEN);
				fileDialog.setFilterExtensions(new String[] {"ecore"}); //$NON-NLS-1$
				final String fileName = fileDialog.open();
				if (fileName != null) {
					location.setText("file:/" + fileName);
				}
			}
		});

		final Button browseEMFRegistry = new Button(parent, SWT.NULL);
		browseEMFRegistry.setText("EMF registry...");
		browseEMFRegistry.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				final RegisteredPackageDialog dialog = new RegisteredPackageDialog(getShell());
				if (dialog.open() == Dialog.OK) {
					location.setText(dialog.getResultAsString());
				}
			}
		});

		final Label filler = new Label(parent, SWT.NULL);
		filler.setLayoutData(new GridData(SWT.NULL, SWT.NULL, false, false, 3, 1));

		location.setEnabled(!isMetametamodel.getSelection());
		browseWorkspace.setEnabled(!isMetametamodel.getSelection());
		browseFilesystem.setEnabled(!isMetametamodel.getSelection());
		browseEMFRegistry.setEnabled(!isMetametamodel.getSelection());

		isMetametamodel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				location.setEnabled(!isMetametamodel.getSelection());
				browseWorkspace.setEnabled(!isMetametamodel.getSelection());
				browseFilesystem.setEnabled(!isMetametamodel.getSelection());
				browseEMFRegistry.setEnabled(!isMetametamodel.getSelection());
				if (!isMetametamodel.getSelection()) {
					EMFTVMLaunchConfigurationDelegate.unsetBoolOption(
							metamodelOptions, metamodelName, EMFTVMLaunchConstants.OPT_IS_METAMETAMODEL);
					location.notifyListeners(SWT.Modify, null);
				} else {
					EMFTVMLaunchConfigurationDelegate.setBoolOption(
							metamodelOptions, metamodelName, EMFTVMLaunchConstants.OPT_IS_METAMETAMODEL);
				}
				updateLaunchConfigurationDialog();
			}
		});

		final SelectionAdapter removeAdapter = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				metamodelLocations.remove(metamodelName);
				metamodelOptions.remove(metamodelName);
				metamodelsGroupWidgets.remove(metamodelName);
				metamodelLabel.dispose();
				location.dispose();
				isMetametamodel.dispose();
				browseWorkspace.dispose();
				browseFilesystem.dispose();
				browseEMFRegistry.dispose();
				delete.dispose();
				filler.dispose();
				layout();
			}
		};
		if (removable) {
			delete.addSelectionListener(removeAdapter);
		}
		thisGroupWidgets.put("removeAdapter", removeAdapter); //$NON-NLS-1$

		return thisGroupWidgets;
	}

	/**
	 * Creates widgets for a model.
	 * @param parent the parent widget group
	 * @param modelName the model name
	 * @param modelLocation the model location (URI)
	 * @param modelLocations the map of model locations to edit
	 * @param modelOptions the map of model options to edit
	 * @param removable whether the metamodel can be removed from the launch configuration
	 * @param output whether this model is an in/out or output model
	 * @param inout whether this model is an in/out model
	 * @return a map of created widgets
	 */
	private Map<String, Object> buildModelControls(final Group parent, final String modelName,
			final String modelLocation, final Map<String, String> modelLocations, 
			final Map<String, String> modelOptions,
			final boolean removable, final boolean output, final boolean inout) {
		final Map<String, Object> thisGroupWidgets = new HashMap<String, Object>();
		final Collection<Widget> disposableWidgets = new ArrayList<Widget>();

		final Label modelLabel = new Label(parent, SWT.NULL);
		modelLabel.setText(modelName + ":"); //$NON-NLS-1$
		disposableWidgets.add(modelLabel);

		final Text location;
		final Text outLocation;
		if (inout) {
			location = new Text(parent, SWT.BORDER);
			location.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
			if (modelLocation != null) {
				location.setText(modelLocation);
			}
			location.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					modelLocations.put(modelName, location.getText());
					updateLaunchConfigurationDialog();
				}
			});
			thisGroupWidgets.put("location", location); //$NON-NLS-1$
			disposableWidgets.add(location);

			outLocation = new Text(parent, SWT.BORDER);
			outLocation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
			if (inoutModelOutLocations.get(modelName) != null) {
				outLocation.setText(inoutModelOutLocations.get(modelName));
			}
			outLocation.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					inoutModelOutLocations.put(modelName, outLocation.getText());
					updateLaunchConfigurationDialog();
				}
			});
			thisGroupWidgets.put("outLocation", outLocation); //$NON-NLS-1$
			disposableWidgets.add(outLocation);
		} else {
			location = new Text(parent, SWT.BORDER);
			location.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 6, 1));
			if (modelLocation != null) {
				location.setText(modelLocation);
			}
			location.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					modelLocations.put(modelName, location.getText());
					updateLaunchConfigurationDialog();
				}
			});
			thisGroupWidgets.put("location", location); //$NON-NLS-1$
			disposableWidgets.add(location);
			
			outLocation = null;
		}

		final Button delete;
		if (removable) {
			delete = new Button(parent, SWT.NULL);
			delete.setText("Delete");
			disposableWidgets.add(delete);
		} else {
			delete = null;
			new Label(parent, SWT.NULL);
		}

		final Button browseWorkspace = new Button(parent, SWT.NULL);
		browseWorkspace.setText("Workspace...");
		browseWorkspace.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 2, 1));
		browseWorkspace.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				final WorkspaceFileDialog dialog = new WorkspaceFileDialog(getShell(), (String[])null);
				final Object result = dialog.open() == Dialog.OK ? dialog.getFirstResult() : null;
				if ((result != null) && (result instanceof IFile)) {
					final IFile currentFile = (IFile)result;
					final String path = currentFile.getFullPath().toString();
					location.setText("platform:/resource" + path);
					if (outLocation != null) {
						outLocation.setText("platform:/resource" + path);
					}
				}
			}
		});
		disposableWidgets.add(browseWorkspace);

		final Button browseFilesystem = new Button(parent, SWT.NULL);
		browseFilesystem.setText("File system...");
		browseFilesystem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				final FileDialog fileDialog = new FileDialog(getShell(), SWT.OPEN);
				fileDialog.setFilterExtensions(new String[] {"*"}); //$NON-NLS-1$
				final String fileName = fileDialog.open();
				if (fileName != null) {
					location.setText("file:/" + fileName);
					if (outLocation != null) {
						outLocation.setText("file:/" + fileName);
					}
				}
			}
		});
		disposableWidgets.add(browseFilesystem);

		if (output) {
			
			final Button allowInterModelReferences = new Button(parent, SWT.CHECK);
			allowInterModelReferences.setText("Allow Inter-model References");
			allowInterModelReferences.setSelection(
					EMFTVMLaunchConfigurationDelegate.getBoolOption(
							modelOptions, 
							modelName, 
							EMFTVMLaunchConstants.OPT_ALLOW_INTER_MODEL_REFERENCES));
			allowInterModelReferences.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent evt) {
					if (allowInterModelReferences.getSelection()) {
						EMFTVMLaunchConfigurationDelegate.setBoolOption(
								modelOptions, modelName, EMFTVMLaunchConstants.OPT_ALLOW_INTER_MODEL_REFERENCES);
					} else {
						EMFTVMLaunchConfigurationDelegate.unsetBoolOption(
								modelOptions, modelName, EMFTVMLaunchConstants.OPT_ALLOW_INTER_MODEL_REFERENCES);
					}
					updateLaunchConfigurationDialog();
				}
			});
			thisGroupWidgets.put("allowInterModelReferences", allowInterModelReferences); //$NON-NLS-1$
			disposableWidgets.add(allowInterModelReferences);

			final Button derivedFile = new Button(parent, SWT.CHECK);
			derivedFile.setText("Set File As Derived");
			derivedFile.setSelection(
					EMFTVMLaunchConfigurationDelegate.getBoolOption(
							modelOptions, 
							modelName, 
							EMFTVMLaunchConstants.OPT_DERIVED_FILE));
			derivedFile.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent evt) {
					if (derivedFile.getSelection()) {
						EMFTVMLaunchConfigurationDelegate.setBoolOption(
								modelOptions, modelName, EMFTVMLaunchConstants.OPT_DERIVED_FILE);
					} else {
						EMFTVMLaunchConfigurationDelegate.unsetBoolOption(
								modelOptions, modelName, EMFTVMLaunchConstants.OPT_DERIVED_FILE);
					}
					updateLaunchConfigurationDialog();
				}
			});
			thisGroupWidgets.put("derivedFile", derivedFile); //$NON-NLS-1$
			disposableWidgets.add(derivedFile);
			
			if (inout) {

				final Button createNewModel = new Button(parent, SWT.CHECK);
				createNewModel.setText("Create New Model");
				createNewModel.setSelection(
						EMFTVMLaunchConfigurationDelegate.getBoolOption(
								modelOptions, 
								modelName, 
								EMFTVMLaunchConstants.OPT_CREATE_NEW_MODEL));
				location.setEnabled(!createNewModel.getSelection());
				createNewModel.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent evt) {
						location.setEnabled(!createNewModel.getSelection());
						if (createNewModel.getSelection()) {
							EMFTVMLaunchConfigurationDelegate.setBoolOption(
									modelOptions, modelName, EMFTVMLaunchConstants.OPT_CREATE_NEW_MODEL);
						} else {
							EMFTVMLaunchConfigurationDelegate.unsetBoolOption(
									modelOptions, modelName, EMFTVMLaunchConstants.OPT_CREATE_NEW_MODEL);
						}
						updateLaunchConfigurationDialog();
					}
				});
				thisGroupWidgets.put("createNewModel", createNewModel); //$NON-NLS-1$
				disposableWidgets.add(createNewModel);
				
				final Label filler = new Label(parent, SWT.NULL);
				filler.setLayoutData(new GridData(SWT.NULL, SWT.NULL, false, false, 2, 1));
				disposableWidgets.add(filler);
				
			} else {

				final Label filler = new Label(parent, SWT.NULL);
				filler.setLayoutData(new GridData(SWT.NULL, SWT.NULL, false, false, 3, 1));
				disposableWidgets.add(filler);
				
			}
			
		} else {
			
			final Label filler = new Label(parent, SWT.NULL);
			filler.setLayoutData(new GridData(SWT.NULL, SWT.NULL, false, false, 5, 1));
			disposableWidgets.add(filler);
			
		}

		final SelectionAdapter removeAdapter = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				if (inputModelsGroupWidgets.get(modelName) != null) {
					inputModelsGroupWidgets.remove(modelName);
					inputModelLocations.remove(modelName);
					removableInputModels.remove(modelName);
					inputModelOptions.remove(modelName);
				} else if (inoutModelsGroupWidgets.get(modelName) != null) {
					inoutModelsGroupWidgets.remove(modelName);
					inoutModelLocations.remove(modelName);
					inoutModelOutLocations.remove(modelName);
					removableInoutModels.remove(modelName);
					inoutModelOptions.remove(modelName);
				} else if (outputModelsGroupWidgets.get(modelName) != null) {
					outputModelsGroupWidgets.remove(modelName);
					outputModelLocations.remove(modelName);
					removableOutputModels.remove(modelName);
					outputModelOptions.remove(modelName);
				}
				for (Widget widget : disposableWidgets) {
					widget.dispose();
				}
				layout();
			}
		};
		if (removable) {
			delete.addSelectionListener(removeAdapter);
		}
		thisGroupWidgets.put("removeAdapter", removeAdapter); //$NON-NLS-1$

		return thisGroupWidgets;
	}

	/**
	 * Updates widget layout.
	 */
	private void layout() {
		metamodelsGroup.layout();
		inputModelsGroup.layout();
		inoutModelsGroup.layout();
		outputModelsGroup.layout();

		rootContainer.layout();

		scrollContainer.setMinSize(rootContainer.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		scrollContainer.layout();

		updateLaunchConfigurationDialog();
	}

	/**
	 * Initialises models from EMFTVM module file.
	 */
	private synchronized void getModelsFromEMFTVMFile() {
		if (!modulePathText.getText().equals("") && !moduleNameText.getText().equals("")) {
			final List<String> sig = new ArrayList<String>(2);
			sig.add(modulePathText.getText());
			sig.add(moduleNameText.getText());
			if (moduleCache.containsKey(sig)) {
				module = moduleCache.get(sig);
			} else {
				module = loadModule(modulePathText.getText(), moduleNameText.getText());
				moduleCache.put(sig, module);
			}
			if (module != null) {
				getModelsFromEMFTVMModule(module, new HashSet<Module>());
			}
		} else {
			module = null;
		}
	}

	/**
	 * Initialises models from EMFTVM module.
	 * @param module the module to initialise the models from
	 * @param processed the set of already processed modules
	 */
	private void getModelsFromEMFTVMModule(final Module module, final Set<Module> processed) {
		processed.add(module);
		for (Module imported : module.getEImports()) {
			if (!processed.contains(imported)) {
				getModelsFromEMFTVMModule(imported, processed);
			}
		}
		addModelsFromModelDeclarations(module.getInputModels(), inputModelLocations);
		addModelsFromModelDeclarations(module.getInoutModels(), inoutModelLocations);
		addModelsFromModelDeclarations(module.getOutputModels(), outputModelLocations);

		inputModelLocations.keySet().removeAll(inoutModelLocations.keySet());
		outputModelLocations.keySet().removeAll(inoutModelLocations.keySet());
	}
	
	/**
	 * Adds models from <code>mds</code> to <code>modelLocations</code>.
	 * @param mds
	 * @param modelLocations
	 */
	private void addModelsFromModelDeclarations(final Collection<ModelDeclaration> mds, 
			final Map<String, String> modelLocations) {
		for (ModelDeclaration md : mds) {
			String modelName = md.getModelName();
			String metamodelName = md.getMetaModelName();
			if (!modelLocations.containsKey(modelName)) {
				modelLocations.put(modelName, "");
			}
			if (!metamodelLocations.containsKey(metamodelName)) {
				metamodelLocations.put(metamodelName, "");
			}
		}
	}

	/**
	 * Loads module from <code>uri</code>, including imports.
	 * @param uri the module URI
	 * @return the loaded module
	 */
	private Module loadModule(final String path, final String name) {
		final ModuleResolver resolver = EMFTVMLaunchConfigurationDelegate.createModuleResolver(path);
		try {
			final Module module = resolver.resolveModule(name);
			final Map<String, Module> modules = new HashMap<String, Module>();
			modules.put(name, module);
			resolveImports(module, resolver, modules);
			return module;
		} catch (IllegalArgumentException e) {
			//ignore
		} catch (ModuleNotFoundException e) {
			//ignore
		}
		return null;
	}

	/**
	 * Resolves the imports list of module.
	 * @param module
	 * @param resolver
	 * @param modules the map of loaded modules
	 */
	private void resolveImports(final Module module, final ModuleResolver resolver, 
			final Map<String, Module> modules) {
		final EList<Module> eImports = module.getEImports();
		for (String imp : module.getImports()) {
			Module impModule = modules.get(imp);
			if (impModule == null) {
				impModule = resolver.resolveModule(imp);
				modules.put(imp, impModule);
				resolveImports(impModule, resolver, modules);
			}
			eImports.add(impModule);
		}
	}

	/**
	 * Clears all cached data.
	 */
	private void clear() {
		removableMetamodels.clear();
		removableInputModels.clear();
		removableInoutModels.clear();
		removableOutputModels.clear();
		
		metamodelLocations.clear();
		inputModelLocations.clear();
		inoutModelLocations.clear();
		inoutModelOutLocations.clear();
		outputModelLocations.clear();

		metamodelOptions.clear();
		inputModelOptions.clear();
		inoutModelOptions.clear();
		outputModelOptions.clear();

		metamodelsGroupWidgets.clear();
		inputModelsGroupWidgets.clear();
		inoutModelsGroupWidgets.clear();
		outputModelsGroupWidgets.clear();

		disposeGroupChildren(metamodelsGroup);
		disposeGroupChildren(inputModelsGroup);
		disposeGroupChildren(inoutModelsGroup);
		disposeGroupChildren(outputModelsGroup);
	}

	/**
	 * Disposes all controls in <code>group</code>.
	 * @param group
	 */
	private void disposeGroupChildren(Group group) {
		for (Control control : group.getChildren()) {
			control.dispose();
		}
	}

	@SuppressWarnings("unchecked")
	private void loadValuesFrom(ILaunchConfiguration configuration) throws CoreException {
		if (configuration == null) {
			return;
		}

		final Map<?, ?> meta = configuration.getAttribute(EMFTVMLaunchConstants.METAMODELS, Collections.EMPTY_MAP);
		final Map<?, ?> input = configuration.getAttribute(EMFTVMLaunchConstants.INPUT_MODELS, Collections.EMPTY_MAP);
		final Map<?, ?> inout = configuration.getAttribute(EMFTVMLaunchConstants.INOUT_MODELS, Collections.EMPTY_MAP);
		final Map<?, ?> inoutOut = configuration.getAttribute(EMFTVMLaunchConstants.INOUT_OUT_MODELS, Collections.EMPTY_MAP);
		final Map<?, ?> output = configuration.getAttribute(EMFTVMLaunchConstants.OUTPUT_MODELS, Collections.EMPTY_MAP);

		metamodelOptions.putAll(configuration.getAttribute(EMFTVMLaunchConstants.METAMODEL_OPTIONS, Collections.EMPTY_MAP));
		inputModelOptions.putAll(configuration.getAttribute(EMFTVMLaunchConstants.INPUT_MODEL_OPTIONS, Collections.EMPTY_MAP));
		inoutModelOptions.putAll(configuration.getAttribute(EMFTVMLaunchConstants.INOUT_MODEL_OPTIONS, Collections.EMPTY_MAP));
		outputModelOptions.putAll(configuration.getAttribute(EMFTVMLaunchConstants.OUTPUT_MODEL_OPTIONS, Collections.EMPTY_MAP));

		for (Entry<?,?> entry : meta.entrySet()) {
			String name = (String)entry.getKey();
			String uri = (String)entry.getValue();
			if (!metamodelLocations.containsKey(name)) {
				removableMetamodels.add(name);
			} else {
				((Text)metamodelsGroupWidgets.get(name).get("metamodelLocation")).setText(uri);
				((Button)metamodelsGroupWidgets.get(name).get("isMetametamodel")).setSelection(
						EMFTVMLaunchConfigurationDelegate.getBoolOption(
								metamodelOptions, name, EMFTVMLaunchConstants.OPT_IS_METAMETAMODEL));
			}
			metamodelLocations.put(name, uri);
		}
		
		for (Entry<?,?> entry : input.entrySet()) {
			String name = (String)entry.getKey();
			String uri = (String)entry.getValue();
			if (!inputModelLocations.containsKey(name)) {
				removableInputModels.add(name);
			} else {
				((Text)inputModelsGroupWidgets.get(name).get("location")).setText(uri);
			}
			inputModelLocations.put(name, uri);
		}
		
		for (Entry<?,?> entry : inout.entrySet()) {
			String name = (String)entry.getKey();
			String uri = (String)entry.getValue();
			if (!inoutModelOptions.containsKey(name)) {
				inoutModelOptions.put(name, 
						EMFTVMLaunchConstants.OPT_ALLOW_INTER_MODEL_REFERENCES + ' ' + 
						EMFTVMLaunchConstants.OPT_DERIVED_FILE);
			}
			if (!inoutModelLocations.containsKey(name)) {
				removableInoutModels.add(name);
			} else {
				((Text)inoutModelsGroupWidgets.get(name).get("location")).setText(uri);
				((Text)inoutModelsGroupWidgets.get(name).get("location")).setEnabled(
						!EMFTVMLaunchConfigurationDelegate.getBoolOption(
								inoutModelOptions, name, EMFTVMLaunchConstants.OPT_CREATE_NEW_MODEL));
				if (inoutOut.get(name) != null) {
					((Text)inoutModelsGroupWidgets.get(name).get("outLocation")).setText((String)inoutOut.get(name));
				} else {
					((Text)inoutModelsGroupWidgets.get(name).get("outLocation")).setText(uri);
				}
				((Button)inoutModelsGroupWidgets.get(name).get("allowInterModelReferences")).setSelection(
						EMFTVMLaunchConfigurationDelegate.getBoolOption(
								inoutModelOptions, name, EMFTVMLaunchConstants.OPT_ALLOW_INTER_MODEL_REFERENCES));
				((Button)inoutModelsGroupWidgets.get(name).get("derivedFile")).setSelection(
						EMFTVMLaunchConfigurationDelegate.getBoolOption(
								inoutModelOptions, name, EMFTVMLaunchConstants.OPT_DERIVED_FILE));
				((Button)inoutModelsGroupWidgets.get(name).get("createNewModel")).setSelection(
						EMFTVMLaunchConfigurationDelegate.getBoolOption(
								inoutModelOptions, name, EMFTVMLaunchConstants.OPT_CREATE_NEW_MODEL));
			}
			inoutModelLocations.put(name, uri);
			inoutModelOutLocations.put(name, (String)inoutOut.get(name));
		}
		
		for (Entry<?,?> entry : output.entrySet()) {
			String name = (String)entry.getKey();
			String uri = (String)entry.getValue();
			if (!outputModelOptions.containsKey(name)) {
				outputModelOptions.put(name, 
						EMFTVMLaunchConstants.OPT_ALLOW_INTER_MODEL_REFERENCES + ' ' + 
						EMFTVMLaunchConstants.OPT_DERIVED_FILE);
			}
			if (!outputModelLocations.containsKey(name)) {
				removableOutputModels.add(name);
			} else {
				((Text)outputModelsGroupWidgets.get(name).get("location")).setText(uri);
				((Button)outputModelsGroupWidgets.get(name).get("allowInterModelReferences")).setSelection(
						EMFTVMLaunchConfigurationDelegate.getBoolOption(
								outputModelOptions, name, EMFTVMLaunchConstants.OPT_ALLOW_INTER_MODEL_REFERENCES));
				((Button)outputModelsGroupWidgets.get(name).get("derivedFile")).setSelection(
						EMFTVMLaunchConfigurationDelegate.getBoolOption(
								outputModelOptions, name, EMFTVMLaunchConstants.OPT_DERIVED_FILE));
			}
			outputModelLocations.put(name, uri);
		}
	}

	/**
	 * Tries to find a {@link Module} instance in the model located at <code>uri</code>.
	 * @param uri the model uri
	 * @return the {@link Module}, or <code>null</code> if not found/loaded.
	 */
	private static Module findModule(final URI uri) {
		final ResourceSet rs = new ResourceSetImpl();
		try {
			final Resource r = rs.getResource(uri, true);
			for (EObject eo : r.getContents()) {
				if (eo instanceof Module) {
					return (Module)eo;
				}
			}
		} catch (Exception e) {
			// module cannot be loaded
		}
		return null;
	}

}
