/*******************************************************************************
 * Copyright (c) 2009 Ecole des Mines de Nantes.

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kelly Garces - initial API and implementation and/or initial documentation
 *******************************************************************************/ 

package org.eclipse.m2m.atl.research.aml.actions.popup.actions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
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
public class ActionExecuteHOT implements IObjectActionDelegate {
	
	private ISelection currSelection;
	private Shell shell;
	private EMFModelFactory emfModelFactory;
	private EMFInjector emfInjector;
	private EMFVMLauncher launcher;
	private EMFReferenceModel atlMetamodel;
	private EMFReferenceModel equalMetamodel;
	
	//private final String amlEngineBundlePath;
	
	public ActionExecuteHOT() throws ATLCoreException, IOException {
		super();
		emfModelFactory = AmlResourceManager.getDefault().getModelFactory();
		emfInjector = new EMFInjector();
		launcher = new EMFVMLauncher();
		atlMetamodel = (EMFReferenceModel) AtlParser.getDefault().getAtlMetamodel();
		equalMetamodel = AmlResourceManager.getDefault().getEqualMetamodel();
		
		
		
	}

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
		} catch (AmlUIException e) {
			MessageDialog.openError(shell, "Error", e.getMessage());
		}		

	}
	
	private void init(IFile file) throws AmlUIException {
			
	 
	 
	 
			
				String resPath = AmlUIResourceManager.getDefault().getPath(file);
				IPath wsLocation = AmlUIResourceManager.getDefault().getWsLocation(file);
				String xmlns = "mmw_match";
				try {
					EMFModel wovenM = AmlResourceManager.getDefault().loadModel(resPath, equalMetamodel);
										
					launcher.initialize(Collections.EMPTY_MAP);
					
					EObject rightModelRef = EqualModelUtils.getRightModelRef(wovenM);
					String rightModelName = (String) ModelUtils.get(rightModelRef, "name");
					String rightMPath = wsLocation.append((String) ModelUtils.get(rightModelRef, "ref")).toString();
					
					EObject leftModelRef = EqualModelUtils.getLeftModelRef(wovenM);
					String leftModelName = (String) ModelUtils.get(leftModelRef, "name");
					String leftMPath = wsLocation.append((String) ModelUtils.get(leftModelRef, "ref")).toString();
					
					IProject project = file.getProject();
					InputStream in = AmlUIResourceManager.getDefault().getAmlFile(project).getContents();
					IModel[] amlAndProblemModels = AmlCompiler.getDefault().injectAMLTextFile(in); 
					IModel amlInjected = amlAndProblemModels[0];
					//TODO centralize the logging of problems in the aml file
					String metametamodel = (String) AmlModelUtils.getDefault().getMatchingMetametamodel(amlInjected);
					
					EMFModel rightModel, leftModel;
					
					if (AmlResourceManager.KM3MMName.startsWith(metametamodel)) {	
						EMFReferenceModel km3Metamodel = AmlResourceManager.getDefault().getKM3Metamodel();
						rightModel = AmlResourceManager.getDefault().loadModel(rightMPath, km3Metamodel);
						leftModel = AmlResourceManager.getDefault().loadModel(leftMPath, km3Metamodel);
						launcher.addLibrary("SuitableMetametamodel", AmlResourceManager.getDefault().getATLLibrary("KM3Metametamodel.asm").openStream());
					} else { // Ecore
						rightModel = AmlResourceManager.getDefault().loadModel(rightMPath, emfModelFactory.getMetametamodel());
						leftModel = AmlResourceManager.getDefault().loadModel(leftMPath, emfModelFactory.getMetametamodel());
						launcher.addLibrary("SuitableMetametamodel", AmlResourceManager.getDefault().getATLLibrary("EcoreMetametamodel.asm").openStream());
					}
			 						
					
					Map<String, Object> transfOptions = new HashMap<String, Object>();
					transfOptions.put("step", true);
					
					IModel outModel = emfModelFactory.newModel(atlMetamodel);
			    	launcher.addInModel(wovenM, "IN1", "EqualMM");			    	
			    	launcher.addInModel(leftModel, "left", "Metametamodel");
			    	launcher.addInModel(rightModel, "right", "Metametamodel");			    	
			    	launcher.addOutModel(outModel, "OUT", "ATL");
			    	
			    	launcher.addLibrary("EqualMM", AmlResourceManager.getDefault().getATLLibrary("EqualMM.asm").openStream());
			    	launcher.addLibrary("Metametamodel", AmlResourceManager.getDefault().getATLLibrary("Metametamodel.asm").openStream());
			    				    				    				    	
					Map<String, Object> options = new HashMap<String, Object>();
					options.put("extensions", "match.AmwModelHandler");
					options.put("extraClasspath", "bin");
					options.put("amwModelMappings", leftModelName + "=left," + rightModelName + "=right");
					
					Bundle bundle = Platform.getBundle(AmlEnginePlugin.PLUGIN_ID);
					URL url = FileLocator.resolve(bundle.getEntry(ResourceUtils.fileSeparator));
					options.put("user.dir", url.getPath());
					
					ArrayList<InputStream> modules = new ArrayList<InputStream>();
					modules.add(AmlResourceManager.getDefault().getHOT(AmlResourceManager.mainHOTName).openStream());
					//modules.addAll(getSuperimposingModules(wovenM));
					
					launcher.launch(launcher.RUN_MODE, null, options, modules.toArray());

					ByteArrayOutputStream atlText = new ByteArrayOutputStream(); 
					AtlParser.getDefault().extract(outModel, atlText, Collections.EMPTY_MAP);
					
					Map<String, ByteArrayOutputStream> outFileMap = new HashMap<String, ByteArrayOutputStream>();
					outFileMap.put(file.getName() + ".atl", atlText);
					
					AmlUIResourceManager.getDefault().saveCompiledFiles(outFileMap, file.getProject(), file.getParent().getProjectRelativePath());
										
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ATLCoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
			
		
	}
	
		
	public Collection<InputStream> getSuperimposingModules(EMFModel wovenM) throws IOException {
		
		EList<EObject> methods = EqualModelUtils.getMethods(wovenM);
		ArrayList<InputStream> modules = new ArrayList<InputStream>();
		String methodName;
		String HOTName;
		
		InputStream MHProperties = AmlResourceManager.getDefault().getPropertiesFile("MatchingMethod-HOT.properties").openStream();
		Properties properties = new Properties();
		properties.load(MHProperties);
				    	
		
		for(Iterator<EObject> ite = methods.iterator(); ite.hasNext();){
			methodName = (String) ModelUtils.get(ite.next(), "name");
			HOTName = properties.getProperty(methodName);
			if(HOTName != null){
				URL url = AmlResourceManager.getDefault().getHOT(HOTName);
				modules.add(url.openStream());
			}
		}
		
		return modules;
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		currSelection = selection;

	}

}
