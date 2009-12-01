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
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.eclipse.m2m.atl.projectors.xml.XMLExtractor;
import org.eclipse.m2m.atl.research.aml.engine.AmlEnginePlugin;
import org.eclipse.m2m.atl.research.aml.engine.AmlResourceManager;
import org.eclipse.m2m.atl.research.aml.utils.AmlUIResourceManager;
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
public class ActionComputeMatchingMetrics implements IObjectActionDelegate {

	private ISelection currSelection;
	private Shell shell;
	private EMFVMLauncher launcher;
	private EMFModelFactory emfModelFactory;
	private EMFInjector emfInjector;
	private EMFExtractor emfExtractor;
	private EMFReferenceModel tableMetamodel;
	private EMFReferenceModel htmlMetamodel;
	private EMFReferenceModel xmlMetamodel;
	private XMLExtractor xmlExtractor;		
	
	protected static Logger logger = Logger.getLogger(AmlEnginePlugin.LOGGER);
	
	public ActionComputeMatchingMetrics () {
		super();
		launcher = new EMFVMLauncher();
		emfModelFactory = AmlResourceManager.getDefault().getModelFactory();
		emfInjector = AmlResourceManager.getDefault().getInjec();
		emfExtractor = AmlResourceManager.getDefault().getExtractor();
		xmlExtractor = new XMLExtractor();		
		
		tableMetamodel = new EMFReferenceModel((EMFReferenceModel)emfModelFactory.getMetametamodel(), emfModelFactory);
		htmlMetamodel = new EMFReferenceModel((EMFReferenceModel) emfModelFactory.getMetametamodel(), emfModelFactory);
		xmlMetamodel = AmlResourceManager.getDefault().getXmlMetamodel();
		try {
			emfInjector.inject(tableMetamodel, AmlResourceManager.getDefault().getMetamodel("Table.ecore").openStream(), null);
			emfInjector.inject(htmlMetamodel, AmlResourceManager.getDefault().getMetamodel("HTML.ecore").openStream(), null);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} 
		
	}
	
	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();

	}

	@Override
	public void run(IAction action) {
		IStructuredSelection iss = (IStructuredSelection)currSelection;
		
		Object[] equalModels = iss.toArray();
		
		if (equalModels.length == 2) {
			IFile expectedEqualM = (IFile)equalModels[0];
			IFile obtainedEqualM = (IFile)equalModels[1];
			try {
				init(expectedEqualM, obtainedEqualM);
			} catch (Exception e) {
				MessageDialog.openError(shell, "Error", e.getMessage());
			}
		}
		
			

	}
	
	private void init (IFile expected, IFile obtained) throws Exception {
		IProject project = obtained.getProject();
		
		String pathExp = AmlUIResourceManager.getDefault().getPath(expected);
		String pathObt = AmlUIResourceManager.getDefault().getPath(obtained);
		EMFModel expectedEqualM = AmlResourceManager.getDefault().loadModel(pathExp, AmlResourceManager.getDefault().getEqualMetamodel());				
		EMFModel obtainedEqualM = AmlResourceManager.getDefault().loadModel(pathObt, AmlResourceManager.getDefault().getEqualMetamodel());
		
			
		IModel inTableM = emfModelFactory.newModel(tableMetamodel);
		IFile tableFile = AmlUIResourceManager.getDefault().getTableFile(project);
		InputStream inTable = tableFile.getContents();
		emfInjector.inject(inTableM, inTable, null);
		
		// transfo MatchingMetrics
		launcher.initialize(Collections.EMPTY_MAP);
		
		IModel outTableM = emfModelFactory.newModel(tableMetamodel);
		launcher.addInModel(expectedEqualM, "Expected", "EqualMM");
		launcher.addInModel(obtainedEqualM, "Obtained", "EqualMM");
		//launcher.addInModel(amlInjected, "Strategy", "AML");
		launcher.addInModel(inTableM, "IN", "Table");
		launcher.addOutModel(outTableM, "OUT", "Table");
		
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("extensions", "match.MatchingMetricsUtils");
		options.put("extraClasspath", "bin");
		//TODO Expected and Obtained model names are coupled to model names of transformation header 
		options.put("expectedObtainedModels", "Expected=" + expected.getName() + "," + "Obtained=" + obtained.getName());
		
		Bundle bundle = Platform.getBundle(AmlEnginePlugin.PLUGIN_ID);
		URL url = FileLocator.resolve(bundle.getEntry(ResourceUtils.fileSeparator));
		options.put("user.dir", url.getPath());
		
		
		InputStream equalMMLib = AmlResourceManager.getDefault().getATLLibrary("EqualMM.asm").openStream();
		launcher.addLibrary("equalMM", equalMMLib);
				
		InputStream matchingMetricTransfo = AmlResourceManager.getDefault().getTransformation("MatchingMetrics.asm").openStream();
		launcher.launch(launcher.RUN_MODE, null, options, matchingMetricTransfo);
		
		ByteArrayOutputStream tableStream = new ByteArrayOutputStream();
		emfExtractor.extract(outTableM, tableStream, Collections.EMPTY_MAP);
		
		//transfo Table2HTML
		launcher.initialize(Collections.EMPTY_MAP);
				
		IModel htmlM = emfModelFactory.newModel(htmlMetamodel);
		launcher.addInModel(outTableM, "IN", "Table");
		launcher.addOutModel(htmlM, "OUT", "HTML");
		
		InputStream tableHelperLib = AmlResourceManager.getDefault().getTransformation("TableHelpers.asm").openStream();
		launcher.addLibrary("TableHelpers", tableHelperLib);
		InputStream table2HtmlTransfo = AmlResourceManager.getDefault().getTransformation("Table2TabularHTML.asm").openStream();
		
		launcher.launch(launcher.RUN_MODE, null, Collections.EMPTY_MAP, table2HtmlTransfo);
		
		//transfo HTML2XML
		
		launcher.initialize(Collections.EMPTY_MAP);
		
		IModel xmlM = emfModelFactory.newModel(xmlMetamodel);
		launcher.addInModel(htmlM, "IN", "HTML");
		launcher.addOutModel(xmlM, "OUT", "XML");
		InputStream HTML2XMLTransfo = AmlResourceManager.getDefault().getTransformation("HTML2XML.asm").openStream();
		
		launcher.launch(launcher.RUN_MODE, null, Collections.EMPTY_MAP, HTML2XMLTransfo);

		//extract xml
		ByteArrayOutputStream xmlStream = new ByteArrayOutputStream();		
		xmlExtractor.extract(xmlM, xmlStream, Collections.EMPTY_MAP);
		
		Map<String, ByteArrayOutputStream> mapFiles = new HashMap<String, ByteArrayOutputStream>();
		mapFiles.put("Metrics.html", xmlStream);
		mapFiles.put(project.getName() + "." + AmlUIResourceManager.tableExtention, tableStream);
		
		AmlUIResourceManager.getDefault().saveCompiledFiles(mapFiles, project, project.getFolder(AmlUIResourceManager.metricFolderName).getProjectRelativePath());
		
	}
	
	
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		currSelection = selection;

	}

}

