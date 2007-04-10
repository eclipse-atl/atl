/*
 * Created on 26 avr. 2004
 */
package org.eclipse.m2m.atl.adt.launching;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.m2m.atl.adt.debug.Messages;
import org.eclipse.m2m.atl.engine.AtlParser;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMCollection;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclUndefined;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMString;
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
 * @author allilaire
 * @author Mikael Barbero
 */
public class MainAtlTab extends AbstractLaunchConfigurationTab {
	
	private ScrolledComposite scrollContainer;
	private Composite rootContainer;
	private Combo projectsList;
	private Combo projectFilesList;
	
	private java.util.List sourceMetamodelsFromModule = new ArrayList();
	private java.util.List targetMetamodelsFromModule = new ArrayList();
	private java.util.List sourceModelsFromModule = new ArrayList();
	private java.util.List outputModelsFromModule = new ArrayList();
	private java.util.List librariesFromModule = new ArrayList();
	
	private java.util.List sourceC2RelationshipFromModule = new ArrayList();
	private java.util.List targetC2RelationshipFromModule = new ArrayList();
	
	private Group projectInformationGroup;
	private Group metamodelsGroup;
	private Group sourceModelsGroup;
	private Group targetModelsGroup;
	private Group librariesGroup;
	
	private Map metamodelsGroupWidgets = new HashMap();
	private Map sourceModelsGroupWidgets = new HashMap();
	private Map targetModelsGroupWidgets = new HashMap();
	private Map librariesGroupWidgets = new HashMap();
	
	private static int IS_METAMODEL = 1 << 1;
	private static int IS_MODEL = 1 << 2;
	private static int IS_SOURCE = 1 << 3;
	private static int IS_TARGET = 1 << 4;
	private static int IS_LIBRARY = 1 << 5;
	
	public void createControl(Composite parent) {
		scrollContainer = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		scrollContainer.setExpandHorizontal(true);
		scrollContainer.setExpandVertical(true);
				
		rootContainer = new Composite(scrollContainer, SWT.NULL);
		rootContainer.setLayout(new GridLayout(3, true));
		scrollContainer.setContent(rootContainer);
		
		projectInformationGroup = new Group(rootContainer, SWT.NULL);
		projectInformationGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		projectInformationGroup.setLayout(new GridLayout(2, false));
		projectInformationGroup.setText(Messages.getString("MainAtlTab.PROJECT"));

		Label projectNameLabel = new Label(projectInformationGroup, SWT.NULL);
		projectNameLabel.setText(Messages.getString("MainAtlTab.PROJECTNAME"));
		
		projectsList = new Combo(projectInformationGroup, SWT.NULL | SWT.READ_ONLY);
		projectsList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		projectsList.setItems(AtlLauncherTools.projectNames());
		
		Label projectFileLabel = new Label(projectInformationGroup, SWT.NULL);
		projectFileLabel.setText(Messages.getString("MainAtlTab.ATLFILENAME"));
		
		projectFilesList = new Combo(projectInformationGroup, SWT.NULL | SWT.READ_ONLY);
		projectFilesList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		metamodelsGroup = new Group(rootContainer, SWT.NULL);
		metamodelsGroup.setText("Metamodels"); 
		metamodelsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		metamodelsGroup.setLayout(new GridLayout(7, false));
		
		sourceModelsGroup = new Group(rootContainer, SWT.NULL);
		sourceModelsGroup.setText("Source Models");
		sourceModelsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		sourceModelsGroup.setLayout(new GridLayout(3, false));
		
		targetModelsGroup = new Group(rootContainer, SWT.NULL);
		targetModelsGroup.setText("Target Models");
		targetModelsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		targetModelsGroup.setLayout(new GridLayout(3, false));
		
		librariesGroup = new Group(rootContainer, SWT.NULL);
		librariesGroup.setText("Libraries");
		librariesGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		librariesGroup.setLayout(new GridLayout(3, false));	
		
		projectsList.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				projectFilesList.setItems(AtlLauncherTools.fileNames(projectsList.getText()));
				updateLaunchConfigurationDialog();
			}
		});
		
		projectFilesList.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				sourceModelsFromModule.clear();
				sourceMetamodelsFromModule.clear();
				outputModelsFromModule.clear();
				targetMetamodelsFromModule.clear();
				librariesFromModule.clear();
				
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
														
				String path = ResourcesPlugin.getWorkspace().getRoot().getRawLocation().toString() + projectFilesList.getText();
				getModelsFromATLFile(path);
				
				Iterator i = sourceMetamodelsFromModule.iterator();
				while (i.hasNext()) {
					String modelName = (String)i.next();
					if (metamodelsGroupWidgets.get(modelName) == null) {
						metamodelsGroupWidgets.put(
								modelName, 
								buildMetamodelsControls(metamodelsGroup, modelName, IS_SOURCE | IS_METAMODEL)
						);
					}
				}
				
				i = targetMetamodelsFromModule.iterator();
				while (i.hasNext()) {
					String modelName = (String)i.next();
					if (metamodelsGroupWidgets.get(modelName) == null) {
						metamodelsGroupWidgets.put(
								modelName, 
								buildMetamodelsControls(metamodelsGroup, modelName, IS_TARGET | IS_METAMODEL)
						);
					}
				}
				
				i = sourceModelsFromModule.iterator();
				while (i.hasNext()) {
					String modelName = (String)i.next();
					sourceModelsGroupWidgets.put(
							modelName, 
							buildModelsAndLibrariesControls(sourceModelsGroup, modelName, IS_SOURCE | IS_MODEL)
					);
					
				}
				
				i = outputModelsFromModule.iterator();
				while (i.hasNext()) {
					String modelName = (String)i.next();
					targetModelsGroupWidgets.put(
							modelName, 
							buildModelsAndLibrariesControls(targetModelsGroup, modelName, IS_TARGET | IS_MODEL)
					);
				}
				
				i = librariesFromModule.iterator();
				while (i.hasNext()) {
					String modelName = (String)i.next();
					librariesGroupWidgets.put(
							modelName, 
							buildModelsAndLibrariesControls(librariesGroup, modelName, IS_LIBRARY)
					);
				}
				
				metamodelsGroup.layout();
				sourceModelsGroup.layout();
				targetModelsGroup.layout();
				librariesGroup.layout();
				
				rootContainer.layout();
				
				scrollContainer.setMinSize(rootContainer.computeSize(SWT.DEFAULT, SWT.DEFAULT));
				scrollContainer.layout();
				
				updateLaunchConfigurationDialog();
			}
		});
				
		setControl(scrollContainer);
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
			projectsList.setText(configuration.getAttribute(AtlLauncherTools.PROJECTNAME, ""));
			projectFilesList.setText(configuration.getAttribute(AtlLauncherTools.ATLFILENAME, ""));

			Map savedPaths = configuration.getAttribute(AtlLauncherTools.PATH, new HashMap());
			Map savedModelHandlers = configuration.getAttribute(AtlLauncherTools.MODELHANDLER, new HashMap());
			Map savedLibraries = configuration.getAttribute(AtlLauncherTools.LIBS, new HashMap());
			
			for (Iterator i = savedPaths.keySet().iterator(); i.hasNext();) {
				String modelName = (String) i.next();
				if (metamodelsGroupWidgets.get(modelName) != null) {
					Map widgets = (Map)metamodelsGroupWidgets.get(modelName);
					Text metamodelLocation = (Text)widgets.get("metamodelLocation");
					Button isMetametamodel = (Button)widgets.get("isMetametamodel");
					Combo modelHandlers = (Combo)widgets.get("modelHandlers");
					
					if (((String)savedPaths.get(modelName)).startsWith("#")) {
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
						Text modelLocation = (Text)widgets.get("location");
						modelLocation.setText((String)savedPaths.get(modelName));
					}
				} 	
			}
			
			for (Iterator i = savedLibraries.keySet().iterator(); i.hasNext();) {
				String libraryName = (String) i.next();
				Map widgets = (Map)librariesGroupWidgets.get(libraryName);
				if (widgets != null) {
					Text libraryLocation = (Text)widgets.get("location");
					libraryLocation.setText((String)savedLibraries.get(libraryName));
				}
			}
			
			updateLaunchConfigurationDialog();
		}
		catch (CoreException e) {
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
		Map savedPaths = new HashMap();
		Map savedModelHandlers = new HashMap();
		Map savedLibraries = new HashMap();
		Map savedInput = new HashMap();
		Map savedOutput = new HashMap();
		Map savedType = new HashMap();
		
		for (Iterator it = sourceMetamodelsFromModule.iterator(); it.hasNext(); ) {
			String modelName = (String)it.next();
			String location = ((Text)((Map)metamodelsGroupWidgets.get(modelName)).get("metamodelLocation")).getText();
			String modelHandler = ((Combo)((Map)metamodelsGroupWidgets.get(modelName)).get("modelHandlers")).getText();
			boolean isMetametamodel = ((Button)((Map)metamodelsGroupWidgets.get(modelName)).get("isMetametamodel")).getSelection();
			if (isMetametamodel) {
				savedPaths.put(modelName, "#" + modelHandler);
			} else {
				savedPaths.put(modelName, location);
			}
			savedModelHandlers.put(modelName, modelHandler);
		}
		
		for (Iterator it = targetMetamodelsFromModule.iterator(); it.hasNext(); ) {
			String modelName = (String)it.next();
			String location = ((Text)((Map)metamodelsGroupWidgets.get(modelName)).get("metamodelLocation")).getText();
			String modelHandler = ((Combo)((Map)metamodelsGroupWidgets.get(modelName)).get("modelHandlers")).getText();
			boolean isMetametamodel = ((Button)((Map)metamodelsGroupWidgets.get(modelName)).get("isMetametamodel")).getSelection();
			if (isMetametamodel) {
				savedPaths.put(modelName, "#" + modelHandler);
			} else {
				savedPaths.put(modelName, location);
			}
			savedModelHandlers.put(modelName, modelHandler);
		}
		
		for (Iterator it = sourceModelsFromModule.iterator(); it.hasNext(); ) {
			String modelName = (String)it.next();
			String location = ((Text)((Map)sourceModelsGroupWidgets.get(modelName)).get("location")).getText();
			savedPaths.put(modelName, location);
		}
		
		for (Iterator it = outputModelsFromModule.iterator(); it.hasNext(); ) {
			String modelName = (String)it.next();
			String location = ((Text)((Map)targetModelsGroupWidgets.get(modelName)).get("location")).getText();
			savedPaths.put(modelName, location);
		}
		
		for (Iterator it = librariesFromModule.iterator(); it.hasNext(); ) {
			String modelName = (String)it.next();
			String location = ((Text)((Map)librariesGroupWidgets.get(modelName)).get("location")).getText();
			savedLibraries.put(modelName, location);
		}
		
		for (Iterator it = sourceC2RelationshipFromModule.iterator(); it.hasNext(); ) {
			String[] current = (String[])it.next();
			savedInput.put(current[0], current[1]);
			savedType.put(current[0], AtlLauncherTools.MODEL_INPUT);
			savedType.put(current[1], AtlLauncherTools.METAMODEL_INPUT);
			
		}
		
		for (Iterator it = targetC2RelationshipFromModule.iterator(); it.hasNext(); ) {
			String[] current = (String[])it.next();
			savedOutput.put(current[0], current[1]);
			savedType.put(current[0], AtlLauncherTools.MODEL_OUTPUT);
			savedType.put(current[1], AtlLauncherTools.METAMODEL_OUTPUT);
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
	 * Returns the name of the tab
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return AtlLauncherTools.REMOTEATLNAME;
	}

	
	/* 
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#isValid(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public boolean isValid(ILaunchConfiguration launchConfig) {		
		try {
			if (launchConfig.getAttribute(AtlLauncherTools.PROJECTNAME, "").trim().length() <= 0) {
				this.setErrorMessage("Porject name can not be empty");
				return false;
			}
			if (launchConfig.getAttribute(AtlLauncherTools.ATLFILENAME, "").trim().length() <= 0) {
				this.setErrorMessage("ATL file name can not be empty");
				return false;
			}
			
			Map paths = ((Map)launchConfig.getAttribute(AtlLauncherTools.PATH, Collections.EMPTY_MAP));
			for (Iterator it = paths.keySet().iterator(); it.hasNext(); ) {
				String modelName = (String)it.next();
				String path = (String)paths.get(modelName);
				if (path.trim().length() <= 0) {
					this.setErrorMessage("Path of model \"" + modelName + "\" can not be empty");
					return false;
				}
			}
			
			Map libs = ((Map)launchConfig.getAttribute(AtlLauncherTools.LIBS, Collections.EMPTY_MAP));
			for (Iterator it = libs.keySet().iterator(); it.hasNext(); ) {
				String libName = (String)it.next();
				String path = (String)libs.get(libName);
				if (path.trim().length() <= 0) {
					this.setErrorMessage("Path of library \"" + libName + "\" can not be empty");
					return false;
				}
			}
			this.setErrorMessage(null);
			return true;
		} catch (CoreException e) {
			e.printStackTrace();
		}
		this.setErrorMessage(null);
		return false;
	}
		
	public Image getImage() {
		return AtlLauncherTools.createImage(AtlLauncherTools.PATHICONATL);
	}
	
	/**
	 * This method edit the path of a model. The path can be external at the workspace 
	 * @param type
	 * @param table
	 */
	private String editExternalPath(final int type) {
		String ret = "";
		FileDialog fileDialog;
		
		if (type == (IS_TARGET | IS_MODEL)) {
			fileDialog = new FileDialog(this.getShell(), SWT.SAVE);
		} else {
			fileDialog = new FileDialog(this.getShell(), SWT.OPEN);
		}

		fileDialog.setFilterExtensions(new String[]{"*"});
		String fileName = fileDialog.open();
		if (fileName != null) {
			ret = "ext:" + fileName;
		}

		return ret;
	}
	
	/**
	 * This method edit the path of the model selected. The path corresponding the a file in the workspace 
	 * @param type
	 * @param table
	 */
	private String editPath(final int type) {
		String ret = "";		
		
		if (type == (IS_TARGET | IS_MODEL)) {
			SaveAsDialog sad = new SaveAsDialog(getShell());
			sad.open();
			IPath outputPath = sad.getResult();
			if (outputPath != null) {
				ret = outputPath.toString();
			}
		}
		else {
			ElementTreeSelectionDialog elementTreeSelectionDialog = new ElementTreeSelectionDialog(	getShell(), new WorkbenchLabelProvider(), new WorkbenchContentProvider());
			elementTreeSelectionDialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
			elementTreeSelectionDialog.setMessage(Messages.getString("ModelChoiceTab.CHOOSEMODEL"));
			elementTreeSelectionDialog.setAllowMultiple(false);
			elementTreeSelectionDialog.setDoubleClickSelects(true);
			elementTreeSelectionDialog.addFilter(new ViewerFilter() {
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					boolean ret = false;
					if(element instanceof IContainer) {
						ret = true;
					} else if(element instanceof IFile) {
						IFile currentFile = (IFile)element;
						if (currentFile.getFileExtension() != null) {
							if (type == IS_LIBRARY) {
								ret = (currentFile.getFileExtension().toUpperCase()).equals("ATL") ||
									  (currentFile.getFileExtension().toUpperCase()).equals("ASM");
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
					if(selection.length == 1) {
						if(selection[0] instanceof IFile) {
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
	
	
	private Map buildMetamodelsControls(Group parent, String metamodelName, final int type) {
		Map thisGroupWidgets = new HashMap();
			
		Label metamodelLabel = new Label(parent, SWT.NULL);
		metamodelLabel.setText(metamodelName + ": ");
		
		final Text metamodelLocation = new Text(parent, SWT.BORDER);
		thisGroupWidgets.put("metamodelLocation", metamodelLocation);
		metamodelLocation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 6, 1));
				
		final Button isMetametamodel = new Button(parent, SWT.CHECK);
		thisGroupWidgets.put("isMetametamodel", isMetametamodel);
		isMetametamodel.setLayoutData(new GridData(SWT.NULL, SWT.NULL, false, false, 2, 1));
		isMetametamodel.setText("Is metametamodel");
		isMetametamodel.setToolTipText("Tells if this metamodel is the metametamodel of the selected model handler.");
			
		Label modelHandlerLabel = new Label(parent, SWT.NULL);
		modelHandlerLabel.setText("Model handler: ");
		modelHandlerLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		final Combo modelHandlers = new Combo(parent, SWT.NULL | SWT.READ_ONLY);
		thisGroupWidgets.put("modelHandlers", modelHandlers);
		modelHandlers.setItems(AtlLauncherTools.getModelHandlers());
		modelHandlers.select(AtlLauncherTools.getEMFKey());
		modelHandlers.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
		
		final Button browseWorkspace = new Button(parent, SWT.NULL);
		browseWorkspace.setText("Workspace...");
		
		final Button browseFilesystem = new Button(parent, SWT.NULL);
		browseFilesystem.setText("File system...");
		
		final Button browseEMFRegistry = new Button(parent, SWT.NULL);
		browseEMFRegistry.setText("EMF Registry...");	
				
		metamodelLocation.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (metamodelLocation.getText().startsWith("uri:")) {
					modelHandlers.select(AtlLauncherTools.getEMFKey());
					modelHandlers.setEnabled(false);
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
				if ((launcher.open() == Dialog.OK)) {
					metamodelLocation.setText("uri:" + launcher.getUriSelected());
				}
			}
		});
		
		return thisGroupWidgets;
	}
	
	private Map buildModelsAndLibrariesControls(Group parent, String modelName, final int type) {
		Map thisGroupWidgets = new HashMap();
		
		Label metamodelLabel = new Label(parent, SWT.NULL);
		metamodelLabel.setText(modelName + ": ");
		
		final Text location = new Text(parent, SWT.BORDER);
		thisGroupWidgets.put("location", location);
		location.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
	
		Button browseWorkspace = new Button(parent, SWT.NULL);
		browseWorkspace.setText("Workspace...");
		browseWorkspace.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 2, 1));
		
		Button browseFilesystem = new Button(parent, SWT.NULL);
		browseFilesystem.setText("File system...");
		
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
		
		return thisGroupWidgets;
	}
	
	private void disposeGroupChildren(Group group) {
		Control[] controls = group.getChildren();
		for (int i = 0; i < controls.length; i++) {
			controls[i].dispose();
		}
	}
	
	private void getModelsFromATLFile(String path) {
		try {
			FileInputStream atlfile = new FileInputStream(new File(path));
			ASMModel atlmodel = AtlParser.getDefault().parseToModel(atlfile);
			
			Set module = atlmodel.getElementsByType("Module");
			Set query = atlmodel.getElementsByType("Query");
			
			if (module.size() > 0) {
				ASMModelElement atlModule = (ASMModelElement)module.toArray()[0];
							
				Iterator inModelsIt = ((ASMCollection)atlModule.get(null, "inModels")).iterator();
				Iterator outModelsIt = ((ASMCollection)atlModule.get(null, "outModels")).iterator();
				Iterator librariesIt = ((ASMCollection)atlModule.get(null, "libraries")).iterator();
				
				while (inModelsIt.hasNext()) {
					ASMModelElement current = (ASMModelElement)inModelsIt.next();
					if (! (current.get(null, "metamodel") instanceof ASMOclUndefined)) {
						String[] temp = {
							((ASMString)current.get(null, "name")).getSymbol(),
							((ASMString)current.get(null, "metamodel").get(null, "name")).getSymbol()
						};
						sourceModelsFromModule.add(temp[0]);
						sourceMetamodelsFromModule.add(temp[1]);
						sourceC2RelationshipFromModule.add(temp);
					} 
				}
				
				while (outModelsIt.hasNext()) {
					ASMModelElement current = (ASMModelElement)outModelsIt.next();
					if (! (current.get(null, "metamodel") instanceof ASMOclUndefined)) {
						String[] temp = {
							((ASMString)current.get(null, "name")).getSymbol(),
							((ASMString)current.get(null, "metamodel").get(null, "name")).getSymbol()
						};
						outputModelsFromModule.add(temp[0]);
						targetMetamodelsFromModule.add(temp[1]);
						targetC2RelationshipFromModule.add(temp);
					} 
				}
				
				while (librariesIt.hasNext()) {
					ASMModelElement current = (ASMModelElement)librariesIt.next();
					librariesFromModule.add(((ASMString)current.get(null, "name")).getSymbol()); 
				}					
				atlfile.close();
			} else if (query.size() > 0) {
				ASMModelElement atlQuery = (ASMModelElement)query.toArray()[0];
				Set models = atlQuery.getModel().getElementsByType("OclModel");
				for (Iterator it = models.iterator(); it.hasNext(); ) {
					ASMModelElement model = (ASMModelElement)it.next();
					String[] temp = {"IN", ((ASMString)model.get(null, "name")).getSymbol()};
					sourceModelsFromModule.add(temp[0]);
					sourceMetamodelsFromModule.add(temp[1]);
					sourceC2RelationshipFromModule.add(temp);
				}
			}
		} catch (Exception e1) {}
	}
}
