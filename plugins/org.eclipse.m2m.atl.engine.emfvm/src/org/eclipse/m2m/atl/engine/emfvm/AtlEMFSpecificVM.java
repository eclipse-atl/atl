/*******************************************************************************
 * Copyright (c) 2007, 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *    
 * $Id: AtlEMFSpecificVM.java,v 1.5 2008/09/02 15:29:17 wpiers Exp $
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.adt.debug.core.AtlRunTarget;
import org.eclipse.m2m.atl.adt.launching.AtlLauncherTools;
import org.eclipse.m2m.atl.adt.launching.AtlVM;
import org.eclipse.m2m.atl.adt.launching.sourcelookup.AtlSourceLocator;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.m2m.atl.engine.emfvm.emf.EMFModel;
import org.eclipse.m2m.atl.engine.emfvm.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractModel;
import org.eclipse.m2m.atl.engine.emfvm.lib.Model;
import org.eclipse.m2m.atl.engine.emfvm.lib.ReferenceModel;
import org.eclipse.m2m.atl.engine.emfvm.lib.VMException;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

// TODO:
//	- improve the way VMs are made pluggable
//		- put extension point in engine plugin, not debug
//		- make ant tasks independant of ASMModels (i.e., regular VM arguments)
/**
 * 
 * @author Frederic Jouault
 * @author Mikael Barbero
 *
 */
public class AtlEMFSpecificVM extends AtlVM {

	// launch from Regular VM arguments (used for ant tasks)
	public Object launch(URL asmUrl, Map libs, Map models, Map params, List superimps, Map options) {
		Object ret = null;

		Map actualModels = new HashMap();
		// handle metamodels first
		List targetModels = new ArrayList();
		Map referenceModelOfASMModel = new HashMap();
		for(Iterator i = models.keySet().iterator() ; i.hasNext() ; ) {
			String mName = (String)i.next();
			ASMModel m = (ASMModel)models.get(mName);
			ReferenceModel rm;
			if(m.equals(ASMEMFModel.getMOF())) {
				rm = EMFReferenceModel.getMetametamodel();
			} else if(m.getMetamodel().equals(ASMEMFModel.getMOF())) {
				rm = new EMFReferenceModel(EMFReferenceModel.getMetametamodel(), ((ASMEMFModel)m).getExtent());
				referenceModelOfASMModel.put(m, rm);
			} else {
				continue;
			}
			actualModels.put(mName, rm);
			if(m.isTarget())
				targetModels.add(rm);
		}
		// handle models second
		for(Iterator i = models.keySet().iterator() ; i.hasNext() ; ) {
			String mName = (String)i.next();
			ASMModel m = (ASMModel)models.get(mName);
			if(!m.getMetamodel().equals(ASMEMFModel.getMOF())) {
				ASMModel mm = m.getMetamodel();
			
				ReferenceModel rm = (ReferenceModel)referenceModelOfASMModel.get(mm);
				AbstractModel actualM = new EMFModel(rm, ((ASMEMFModel)m).getExtent());
				actualModels.put(mName, actualM);
				
				if(m.isTarget()) {
					targetModels.add(actualM);
					actualM.isTarget = true;
				}
			}
		}
		
		try {
			ASM asm = new ASMXMLReader().read(asmUrl.openStream());

			for(Iterator i = libs.keySet().iterator() ; i.hasNext() ; ) {
				String libName = (String)i.next();
				URL libUrl = (URL)libs.get(libName);
				ASM lib = new ASMXMLReader().read(libUrl.openStream());
				libs.put(libName, lib);
			}
			
			List superimpose = new ArrayList();
			for(Iterator i = superimps.iterator() ; i.hasNext() ; ) {
				URL url = (URL)i.next();
				ASM module = new ASMXMLReader().read(url.openStream());
				superimpose.add(module);
			}
			
			try {
				ret = asm.run(actualModels, libs, superimpose, options);
			} catch(VMException vme) {
				logger.log(Level.SEVERE, vme.getLocalizedMessage(), vme);
				throw vme;
			}
			
			for(Iterator i = targetModels.iterator() ; i.hasNext() ; ) {
				EMFModel model = (EMFModel)i.next();
				model.commitToResource();
			}
		} catch(IOException ioe) {
			logger.log(Level.SEVERE, ioe.getLocalizedMessage(), ioe);
		}

		return ret;
	}

	// direct launch from debug plugin
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		launch.setSourceLocator(new AtlSourceLocator());
		AtlRunTarget mTarget = new AtlRunTarget(launch);
		launch.addDebugTarget(mTarget);
		actualLaunch(configuration, mode, launch, monitor);
		mTarget.terminate();
	}

	private void actualLaunch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		String fileName = configuration.getAttribute(AtlLauncherTools.ATLFILENAME, AtlLauncherTools.NULLPARAMETER);
		IFile currentAtlFile = ResourcesPlugin.getWorkspace().getRoot().getFile(Path.fromOSString(fileName));
		String extension = currentAtlFile.getFileExtension().toLowerCase();
		if (AtlLauncherTools.EXTENSIONS.contains(extension)) {
			String currentAsmPath = currentAtlFile.getFullPath().toString().substring(0, currentAtlFile.getFullPath().toString().length() - extension.length()) + "asm";
			currentAtlFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(currentAsmPath));
		}
		else
			currentAtlFile = null;

		ASM asm = new ASMXMLReader().read(currentAtlFile.getContents());

		Map models = new HashMap();
		Map sourceModels = configuration.getAttribute(AtlLauncherTools.INPUT, new HashMap());
		Map targetModels = configuration.getAttribute(AtlLauncherTools.OUTPUT, new HashMap());
		Map modelPaths = configuration.getAttribute(AtlLauncherTools.PATH, new HashMap());
		Map libs = configuration.getAttribute(AtlLauncherTools.LIBS, new HashMap());
		List superimps = configuration.getAttribute(AtlLauncherTools.SUPERIMPOSE, new ArrayList());

		try {
			for(Iterator i = sourceModels.keySet().iterator() ; i.hasNext() ; ) {
				String mName = (String)i.next();
				String mmName = (String)sourceModels.get(mName);
				
				ReferenceModel mm = (ReferenceModel)models.get(mmName);
				if(mm == null) {
					mm = loadReferenceModel(mmName, modelPaths);
					models.put(mmName, mm);
				}
				Model m = new EMFModel(
						mm, 
						URI.createPlatformResourceURI((String)modelPaths.get(mName), true),
						false);			
				models.put(mName, m);
			}

			for(Iterator i = targetModels.keySet().iterator() ; i.hasNext() ; ) {
				String mName = (String)i.next();
				String mmName = (String)targetModels.get(mName);
				
				ReferenceModel mm = (ReferenceModel)models.get(mmName);
				if(mm == null) {
					mm = loadReferenceModel(mmName, modelPaths);
					models.put(mmName, mm);
				}
				AbstractModel m = new EMFModel(
						mm, 
						URI.createPlatformResourceURI((String)modelPaths.get(mName), true),
						true);		
				models.put(mName, m);
				m.isTarget = true;
			}

			try {
				Map options = new HashMap();
				for(int i = 0 ; i < AtlLauncherTools.additionalParamIds.length ; i++) {
					boolean value = configuration.getAttribute(AtlLauncherTools.additionalParamIds[i], false);
					options.put(AtlLauncherTools.additionalParamIds[i], value ? "true" : "false");
				}
				
				Map libraries = new HashMap();
				for(Iterator i = libs.keySet().iterator() ; i.hasNext() ; ) {
					String libName = (String)i.next();
					IFile libFile = ResourcesPlugin.getWorkspace().getRoot().getFile(Path.fromOSString((String)libs.get(libName)));
					ASM lib = new ASMXMLReader().read(libFile.getContents());
					libraries.put(libName, lib);
				}

				List superimpose = new ArrayList();
				for(Iterator i = superimps.iterator() ; i.hasNext() ; ) {
					String path = (String)i.next();
					IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(Path.fromOSString(path));
					ASM module = new ASMXMLReader().read(file.getContents());
					superimpose.add(module);
				}

				asm.run(models, libraries, superimpose, options);

				for(Iterator i = targetModels.keySet().iterator() ; i.hasNext() ; ) {
					String mName = (String)i.next();
					
					EMFModel m = (EMFModel)models.get(mName);			
					m.save(URI.createPlatformResourceURI((String)modelPaths.get(mName), true));
				}
			} catch(VMException vme) {
				logger.log(Level.SEVERE, vme.getLocalizedMessage(), vme);
				throw vme;
			} finally {
				for(Iterator i = models.values().iterator() ; i.hasNext() ; ) {
					Model model = (Model)i.next();
					model.dispose();
				}
			}
		} catch(IOException ioe) {
			logger.log(Level.SEVERE, ioe.getLocalizedMessage(), ioe);
		}


//					Map modelType = configuration.getAttribute(AtlLauncherTools.MODELTYPE, new HashMap());
//					Map modelHandler = configuration.getAttribute(AtlLauncherTools.MODELHANDLER, new HashMap());
//					boolean checkSameModel = !configuration.getAttribute(AtlLauncherTools.AllowInterModelReferences, false);
//		            List superimpose = configuration.getAttribute(AtlLauncherTools.SUPERIMPOSE, new ArrayList());
	}
	
	private ReferenceModel loadReferenceModel(String mmName, Map modelPaths) throws IOException {
		ReferenceModel ret = null;
		
		String path = (String)modelPaths.get(mmName);
		if(path.startsWith("#")) {
			ret = EMFReferenceModel.getMetametamodel();
		} else if(path.startsWith("uri:")){
			ret = new EMFReferenceModel(EMFReferenceModel.getMetametamodel(), path.substring(4));
		} else {
			ret = new EMFReferenceModel(EMFReferenceModel.getMetametamodel(), URI.createPlatformResourceURI(path, true));
		}		
		
		return ret;
	}
}
