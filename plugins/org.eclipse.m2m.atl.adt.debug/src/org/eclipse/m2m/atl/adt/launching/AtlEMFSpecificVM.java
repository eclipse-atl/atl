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
 * $Id: AtlEMFSpecificVM.java,v 1.2 2008/10/14 13:37:08 wpiers Exp $
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.launching;

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
import org.eclipse.m2m.atl.ATLPlugin;
import org.eclipse.m2m.atl.adt.debug.core.AtlRunTarget;
import org.eclipse.m2m.atl.adt.launching.sourcelookup.AtlSourceLocator;
import org.eclipse.m2m.atl.engine.emfvm.ASM;
import org.eclipse.m2m.atl.engine.emfvm.ASMXMLReader;
import org.eclipse.m2m.atl.engine.emfvm.emf.EMFModel;
import org.eclipse.m2m.atl.engine.emfvm.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractModel;
import org.eclipse.m2m.atl.engine.emfvm.lib.Model;
import org.eclipse.m2m.atl.engine.emfvm.lib.ReferenceModel;

// TODO:
// - improve the way VMs are made pluggable
// - put extension point in engine plugin, not debug
// - make ant tasks independant of ASMModels (i.e., regular VM arguments)

/**
 * The ATL EMFVM launcher.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:mikael.barbero@univ-nantes.fr">Mikael Barbero</a>
 */
public class AtlEMFSpecificVM extends AtlVM {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.launching.AtlVM#launch(java.net.URL, java.util.Map, java.util.Map,
	 *      java.util.Map, java.util.List, java.util.Map)
	 */
	public Object launch(URL asmUrl, Map libs, Map models, Map params, List superimps, Map options) {
		Object ret = null;
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration,
	 *      java.lang.String, org.eclipse.debug.core.ILaunch, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch,
			IProgressMonitor monitor) throws CoreException {
		launch.setSourceLocator(new AtlSourceLocator());
		AtlRunTarget mTarget = new AtlRunTarget(launch);
		launch.addDebugTarget(mTarget);
		actualLaunch(configuration, mode, launch, monitor);
		mTarget.terminate();
	}

	/**
	 * EMFVM launch method.
	 * 
	 * @param configuration
	 *            the launch configuration
	 * @param mode
	 *            the launch mode
	 * @param launch
	 *            the launch interface
	 * @param monitor
	 *            the progress monitor
	 * @throws CoreException
	 *             if there are errors during the transformation
	 */
	private void actualLaunch(ILaunchConfiguration configuration, String mode, ILaunch launch,
			IProgressMonitor monitor) throws CoreException {
		String fileName = configuration.getAttribute(AtlLauncherTools.ATLFILENAME,
				AtlLauncherTools.NULLPARAMETER);
		IFile currentAtlFile = ResourcesPlugin.getWorkspace().getRoot().getFile(Path.fromOSString(fileName));
		String extension = currentAtlFile.getFileExtension().toLowerCase();
		if (AtlLauncherTools.getExtensions().contains(extension)) {
			String currentAsmPath = currentAtlFile.getFullPath().toString().substring(0,
					currentAtlFile.getFullPath().toString().length() - extension.length())
					+ "asm";
			currentAtlFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(currentAsmPath));
		} else {
			currentAtlFile = null;
		}

		ASM asm = new ASMXMLReader().read(currentAtlFile.getContents());

		Map models = new HashMap();
		Map sourceModels = configuration.getAttribute(AtlLauncherTools.INPUT, new HashMap());
		Map targetModels = configuration.getAttribute(AtlLauncherTools.OUTPUT, new HashMap());
		Map modelPaths = configuration.getAttribute(AtlLauncherTools.PATH, new HashMap());
		Map libs = configuration.getAttribute(AtlLauncherTools.LIBS, new HashMap());
		List superimps = configuration.getAttribute(AtlLauncherTools.SUPERIMPOSE, new ArrayList());

		try {
			for (Iterator i = sourceModels.keySet().iterator(); i.hasNext();) {
				String mName = (String)i.next();
				String mmName = (String)sourceModels.get(mName);

				ReferenceModel mm = (ReferenceModel)models.get(mmName);
				if (mm == null) {
					mm = loadReferenceModel(mmName, modelPaths);
					models.put(mmName, mm);
				}
				Model m = new EMFModel(mm,
						URI.createPlatformResourceURI((String)modelPaths.get(mName), true), false);
				models.put(mName, m);
			}

			for (Iterator i = targetModels.keySet().iterator(); i.hasNext();) {
				String mName = (String)i.next();
				String mmName = (String)targetModels.get(mName);

				ReferenceModel mm = (ReferenceModel)models.get(mmName);
				if (mm == null) {
					mm = loadReferenceModel(mmName, modelPaths);
					models.put(mmName, mm);
				}
				AbstractModel m = new EMFModel(mm, URI.createPlatformResourceURI((String)modelPaths
						.get(mName), true), true);
				models.put(mName, m);
				m.setIsTarget(true);
			}

			try {
				Map options = new HashMap();
				for (int i = 0; i < AtlLauncherTools.ADDITIONAL_PARAM_IDS.length; i++) {
					boolean value = configuration.getAttribute(AtlLauncherTools.ADDITIONAL_PARAM_IDS[i], false);
					options.put(AtlLauncherTools.ADDITIONAL_PARAM_IDS[i], value ? "true" : "false");
				}

				Map libraries = new HashMap();
				for (Iterator i = libs.keySet().iterator(); i.hasNext();) {
					String libName = (String)i.next();
					IFile libFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
							Path.fromOSString((String)libs.get(libName)));
					ASM lib = new ASMXMLReader().read(libFile.getContents());
					libraries.put(libName, lib);
				}

				List superimpose = new ArrayList();
				for (Iterator i = superimps.iterator(); i.hasNext();) {
					String path = (String)i.next();
					IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(Path.fromOSString(path));
					ASM module = new ASMXMLReader().read(file.getContents());
					superimpose.add(module);
				}

				asm.run(models, libraries, superimpose, options);

				for (Iterator i = targetModels.keySet().iterator(); i.hasNext();) {
					String mName = (String)i.next();

					EMFModel m = (EMFModel)models.get(mName);
					m.save(URI.createPlatformResourceURI((String)modelPaths.get(mName), true));
				}
			} catch (Exception e) {
				ATLPlugin.log(Level.SEVERE,e.getMessage(), e);
			} finally {
				for (Iterator i = models.values().iterator(); i.hasNext();) {
					Model model = (Model)i.next();
					model.dispose();
				}
			}
		} catch (IOException ioe) {
			ATLPlugin.log(Level.SEVERE, ioe.getLocalizedMessage(), ioe);
		}

	}

	private ReferenceModel loadReferenceModel(String mmName, Map modelPaths) throws IOException {
		ReferenceModel ret = null;

		String path = (String)modelPaths.get(mmName);
		if (path.startsWith("#")) {
			ret = EMFReferenceModel.getMetametamodel();
		} else if (path.startsWith("uri:")) {
			ret = new EMFReferenceModel(EMFReferenceModel.getMetametamodel(), path.substring(4));
		} else {
			ret = new EMFReferenceModel(EMFReferenceModel.getMetametamodel(), URI.createPlatformResourceURI(
					path, true));
		}

		return ret;
	}
}
