/*******************************************************************************
 * Copyright (c) 2009 Ecole des Mines de Nantes.

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Kelly Garces - initial API and implementation and/or initial documentation
 *******************************************************************************/ 

package org.eclipse.m2m.atl.research.aml.actions.popup.actions;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmt.weaver.core.WeaverXMLMetadata;
import org.eclipse.gmt.weaver.core.data.WovenModelDescriptor;
import org.eclipse.gmt.weaver.plugin.util.WeaverUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.research.aml.engine.AmlCompiler;
import org.eclipse.m2m.atl.research.aml.engine.AmlModelUtils;
import org.eclipse.m2m.atl.research.aml.engine.AmlResourceManager;
import org.eclipse.m2m.atl.research.aml.utils.AmlUIException;
import org.eclipse.m2m.atl.research.aml.utils.AmlUIResourceManager;
import org.eclipse.m2m.atl.research.aml.utils.EqualModelUtils;
import org.eclipse.m2m.atl.research.aml.utils.ResourceUtils;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * 
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a>
 *
 */

public class ActionGeneratePropFile implements IObjectActionDelegate {

	private ISelection currSelection;
	private Shell shell;
 
	private final String weavingPanel = "TransformationWeavingPanelExtension";
	private final String wModelRefPanel = "DefaultWovenPanelExtension";
	
	//TODO load value from the Equal metamodel  
	
	
	/**
	 * Constructor for Action1.
	 */
	public ActionGeneratePropFile() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		IStructuredSelection iss = (IStructuredSelection)currSelection;
		IFile currentFile = (IFile)iss.getFirstElement();
		
		try {
			init(currentFile);
		} catch (AmlUIException e) {
			MessageDialog.openError(shell, "Error", e.getMessage());
		}		
	}
	
	private void init (IFile file) throws AmlUIException {
		IProject project = file.getProject();
		File propertiesFile = org.eclipse.gmt.weaver.plugin.util.WeaverUtil.getPropertyFilePath(file).toFile();
		
		
		
		
			// Config file
			
			try {
				InputStream in = AmlUIResourceManager.getDefault().getAmlFile(project).getContents();
				IModel[] amlAndProblemModels = AmlCompiler.getDefault().injectAMLTextFile(in); 
				IModel amlInjected = amlAndProblemModels[0];
				//TODO centralize the logging of aml file problems
				String metametamodel = (String) AmlModelUtils.getDefault().getMatchingMetametamodel(amlInjected);
				
				String resPath = AmlUIResourceManager.getDefault().getPath(file);
				EMFModel equalModel = AmlResourceManager.getDefault().loadModel(resPath, AmlResourceManager.getDefault().getEqualMetamodel());				
				WeaverXMLMetadata xml = new WeaverXMLMetadata(propertiesFile);
				xml.createXMLConfigFile(getModelInfos(equalModel, metametamodel, project.getName()), file.getFullPath().toString(), weavingPanel, EqualModelUtils.wmodel,
						Collections.EMPTY_LIST, Collections.EMPTY_LIST,
						ResourceUtils.getPathWithSeparator(project.getFullPath().toString(),
													  AmlResourceManager.metamodelsFolderName,
													  AmlResourceManager.equalMMName));
				IContainer fileContainer = file.getParent();
				fileContainer.refreshLocal(IResource.DEPTH_ONE, null);
			} catch (ATLCoreException e) {
				// TODO Auto-generated catch block
				throw new AmlUIException(IStatus.ERROR, "The equal model cannot be loaded");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new AmlUIException(IStatus.ERROR, e);
			} 
			
	}
	
	private List<WovenModelDescriptor> getModelInfos (EMFModel wovenM, String metametamodel, String projectName) throws AmlUIException {
				
		ArrayList<WovenModelDescriptor> modelInfos = new ArrayList<WovenModelDescriptor>();
		
			
		WovenModelDescriptor leftM = createDesc(EqualModelUtils.getLeftModelRef(wovenM), "leftM", "0", metametamodel, projectName);
		modelInfos.add(leftM);
						
		WovenModelDescriptor rightM = createDesc(EqualModelUtils.getRightModelRef(wovenM), "rightM", "1", metametamodel, projectName);
		modelInfos.add(rightM);	
		
		return modelInfos;
		
	}
	
	private WovenModelDescriptor createDesc (EObject wModelRef, String modelRefName, String id, String metametamodel, String projectName) {
		
		WovenModelDescriptor desc = new WovenModelDescriptor();
		
		String ref = (String)WeaverUtil.get(wModelRef, "ref");
		if (AmlResourceManager.KM3MMName.startsWith(metametamodel)) {
			desc.setMetamodelFile(ResourceUtils.getPathWithSeparator(projectName, AmlResourceManager.metamodelsFolderName, AmlResourceManager.KM3MMName));
			desc.setModelFile(ref);
		} else { //Ecore		
			desc.setMetamodelFile(ref);
			desc.setModelFile("null");		
		}
		
		desc.setPanel(wModelRefPanel);
		desc.setWModelRef(EqualModelUtils.wModelRefType);
		desc.setNameProperty(modelRefName);		
		desc.setReferenceName(modelRefName);
		desc.setId(id);
			
		return desc;
	}
		
	

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		currSelection = selection;
		
		
	}

}
