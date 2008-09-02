/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - ATL EMFVM launcher
 *******************************************************************************/
package org.eclipse.m2m.atl.examples;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.engine.emfvm.ASM;
import org.eclipse.m2m.atl.engine.emfvm.ASMXMLReader;
import org.eclipse.m2m.atl.engine.emfvm.emf.EMFModel;
import org.eclipse.m2m.atl.engine.emfvm.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractModel;
import org.eclipse.m2m.atl.engine.emfvm.lib.Model;
import org.eclipse.m2m.atl.engine.emfvm.lib.ReferenceModel;
import org.eclipse.m2m.atl.engine.emfvm.lib.VMException;

/**
 * Launch an ATL transformation using the emfvm.
 * 
 * @author William Piers <a
 *         href="mailto:william.piers@obeo.fr">william.piers@obeo.fr</a>
 */
public class EMFVMLauncher {

	/**
	 * A method launching the EMFVM
	 * 
	 * @param asmURL
	 *            the URL of the .asm file (the compiled transformation)
	 * @param input
	 *            the map of the input models [Model name, Metamodel name]
	 * @param output
	 *            the map of the input models [Model name, Metamodel name]
	 * @param path
	 *            the map of the model paths [(Meta)Model name, path]
	 * @param libsFromConfig
	 *            the map of the libraries [library name, path]
	 * @param options
	 *            the map of the vm options
	 * @return the execution time
	 * @throws Exception
	 */
	public static double launch(URL asmURL, Map input, Map output, Map path,
			Map libsFromConfig, List superimps, Map options) throws Exception {
		long startTime;
		long endTime;
		ASM asm = new ASMXMLReader().read(asmURL.openStream());

		Map models = new HashMap();
		for (Iterator i = input.keySet().iterator(); i.hasNext();) {
			String mName = (String) i.next();
			String mmName = (String) input.get(mName);

			ReferenceModel mm = (ReferenceModel) models.get(mmName);
			if (mm == null) {
				mm = loadReferenceModel(mmName, path);
				models.put(mmName, mm);
			}
			AbstractModel m = new EMFModel(mm,
					URI.createFileURI((String) path.get(mName)), false);
			models.put(mName, m);
		}

		for (Iterator i = output.keySet().iterator(); i.hasNext();) {
			String mName = (String) i.next();
			String mmName = (String) output.get(mName);

			ReferenceModel mm = (ReferenceModel) models.get(mmName);
			if (mm == null) {
				mm = loadReferenceModel(mmName, path);
				models.put(mmName, mm);
			}
			AbstractModel m = new EMFModel(mm, URI.createPlatformResourceURI((String) path
					.get(mName), true), true);
			models.put(mName, m);
			m.isTarget = true;
		}

		try {
			Map libraries = new HashMap();
			for (Iterator i = libsFromConfig.keySet().iterator(); i.hasNext();) {
				String libName = (String) i.next();
				IFile libFile = ResourcesPlugin.getWorkspace().getRoot()
						.getFile(
								Path.fromOSString((String) libsFromConfig
										.get(libName)));
				ASM lib = new ASMXMLReader().read(libFile.getContents());
				libraries.put(libName, lib);
			}

			List superimpose = new ArrayList();
			for(Iterator i = superimps.iterator() ; i.hasNext() ; ) {
				String supPath = (String)i.next();
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(Path.fromOSString(supPath));
				ASM module = new ASMXMLReader().read(file.getContents());
				superimpose.add(module);
			}
			
			startTime = System.currentTimeMillis();
			asm.run(models, libraries,superimpose, options);
			endTime = System.currentTimeMillis();

			for (Iterator i = output.keySet().iterator(); i.hasNext();) {
				String mName = (String) i.next();

				Model m = (Model) models.get(mName);
				m.save(URI.createFileURI((String) path.get(mName)).toString());
				
			}
		} catch (VMException vme) {
			vme.printStackTrace(System.out);
			throw vme;
		} finally {
			for (Iterator i = models.values().iterator(); i.hasNext();) {
				Model model = (Model) i.next();
				model.dispose();
			}
		}

		return (endTime - startTime) / 1000.;
	}

	private static ReferenceModel loadReferenceModel(String mmName, Map modelPaths) throws IOException {
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
