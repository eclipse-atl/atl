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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.engine.emfvm.VMException;
import org.eclipse.m2m.atl.research.aml.engine.AmlCompiler;
import org.eclipse.m2m.atl.research.aml.engine.AmlEnginePlugin;
import org.eclipse.m2m.atl.research.aml.engine.AmlModelUtils;
import org.eclipse.m2m.atl.research.aml.engine.AmlResourceManager;
import org.eclipse.m2m.atl.research.aml.utils.AmlUIException;
import org.eclipse.m2m.atl.research.aml.utils.AmlUIResourceManager;
import org.eclipse.m2m.atl.research.aml.utils.EqualModelUtils;
import org.eclipse.m2m.atl.research.aml.utils.ModelUtils;
import org.eclipse.m2m.atl.research.aml.utils.ResourceUtils;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.osgi.framework.Bundle;

/**
 * 
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a>
 *
 */
public class ActionGenerateEmptyEqualModel implements IObjectActionDelegate {

	private ISelection currSelection;
	private Shell shell;
	
	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();

	}

	@Override
	public void run(IAction action) {
		IStructuredSelection iss = (IStructuredSelection)currSelection;
		IFile currentFile = (IFile)iss.getFirstElement();
		
		try {
			init(currentFile);
		} catch (Exception e) {
			MessageDialog.openError(shell, "Error", e.getMessage());
		}	

	}
	
	private void init (IFile equalMFile) throws Exception {
		
		
				
			IProject project = equalMFile.getProject();
		
			InputStream in = AmlUIResourceManager.getDefault().getAmlFile(project).getContents();
			IModel[] amlAndProblemModels = AmlCompiler.getDefault().injectAMLTextFile(in); 
			IModel amlInjected = amlAndProblemModels[0];
			//TODO centralize the logging of problems in the aml file
			EObject matcher = AmlModelUtils.getDefault().getMatcher(amlInjected);
			
			
			
			String mappingModelName = equalMFile.getName().replaceAll("." + equalMFile.getFileExtension(), "");
			
			
			try {
				String leftMName = (String) AmlModelUtils.getDefault().evaluateAmlLibraryHelper("leftMMappingModel", matcher, mappingModelName);
				String rightMName = (String) AmlModelUtils.getDefault().evaluateAmlLibraryHelper("rightMMappingModel", matcher, mappingModelName);
				
				
				IFile propertiesFile = project.getFile(project.getName() + "." + AmlUIResourceManager.propertiesExtention);
				if(!propertiesFile.exists()){
					throw new AmlUIException(IStatus.ERROR, "There is not a properties file corresponding to the project");
				}
				
				Properties properties = new Properties();
				properties.load(propertiesFile.getContents());
				
				String leftMPath = (String) properties.get(leftMName);
				
				String rightMPath = (String) properties.get(rightMName);
				
				
				if(leftMPath == null || rightMPath == null) {
					throw new AmlUIException(IStatus.ERROR, "The file " + project.getName() + "." + AmlUIResourceManager.propertiesExtention + " does not contain the paths for left and right models");
				}
				
				Bundle bundle = Platform.getBundle(AmlEnginePlugin.PLUGIN_ID);
				URL url = FileLocator.resolve(bundle.getEntry(ResourceUtils.fileSeparator));
				String emptyEqualModelLoc =  url.getPath().concat(AmlResourceManager.getDefault().getTemplate("EmptyEqualModel.amw").getPath());
				
				EMFModel emptyEqualModel = AmlResourceManager.getDefault().loadModel(emptyEqualModelLoc, AmlResourceManager.getDefault().getEqualMetamodel());
				
				EObject matchModel = EqualModelUtils.getMatcher(emptyEqualModel);
				String matchModelName = leftMName + "2" + rightMName;
				ModelUtils.set(matchModel, "name", matchModelName);
				
				EObject leftMO = EqualModelUtils.getLeftModelRef(emptyEqualModel);
				ModelUtils.set(leftMO, "name", leftMName);
				ModelUtils.set(leftMO, "ref", ResourceUtils.getPathWithSeparator(project.getName(), AmlUIResourceManager.modelFolderName, leftMPath));
				
				EObject rightMO = EqualModelUtils.getRightModelRef(emptyEqualModel);
				ModelUtils.set(rightMO, "name", rightMName);
				ModelUtils.set(rightMO, "ref", ResourceUtils.getPathWithSeparator(project.getName(), AmlUIResourceManager.modelFolderName, rightMPath));
				
				ByteArrayOutputStream outNewModel = new ByteArrayOutputStream();
				
				EMFExtractor emfExtractor = AmlResourceManager.getDefault().getExtractor();
    			emfExtractor.extract(emptyEqualModel, outNewModel, Collections.EMPTY_MAP);
				
				AmlUIResourceManager.getDefault().createFile(project,
						ResourceUtils.getPathWithSeparator(equalMFile.getParent().getProjectRelativePath().toString(), mappingModelName + "." + AmlUIResourceManager.amwExtention),
						new ByteArrayInputStream(outNewModel.toByteArray()));
				
			}catch(VMException e){
				throw new AmlUIException(IStatus.ERROR, "The AML strategy does not specify any empty mapping model with the name " + mappingModelName);
			}
	
			in.close();
		
		
	}
	
	
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		currSelection = selection;

	}

}
