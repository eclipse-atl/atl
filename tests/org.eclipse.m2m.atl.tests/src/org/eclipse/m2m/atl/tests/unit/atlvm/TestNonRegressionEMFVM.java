/*******************************************************************************
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - ATL tester
 *******************************************************************************/
package org.eclipse.m2m.atl.tests.unit.atlvm;

import java.io.IOException;
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
import org.eclipse.m2m.atl.tests.unit.TestNonRegressionTransfo;

/**
 * Specifies TestNonRegressionTransfo for the emfvm.
 * 
 * @author William Piers <a href="mailto:william.piers@obeo.fr">william.piers@obeo.fr</a>
 */
public class TestNonRegressionEMFVM extends TestNonRegressionTransfo {

	protected String getVMName() {
		return "EMFVM";
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		setPropertiesPath("/org.eclipse.m2m.atl.tests/data/emfvm.properties");//$NON-NLS-1$
	}

	public double launch() throws Exception {
		long startTime;
		long endTime;
		ASM asm = new ASMXMLReader().read(launchParser.asmUrl.openStream());
		Map models = new HashMap();

		for(Iterator i = launchParser.input.keySet().iterator() ; i.hasNext() ; ) {
			String mName = (String)i.next();
			String mmName = (String)launchParser.input.get(mName);

			ReferenceModel mm = (ReferenceModel)models.get(mmName);
			if(mm == null) {
				mm = loadReferenceModel(mmName, launchParser.path);
				models.put(mmName, mm);
			}
			Model m = new EMFModel(
					mm, 
					URI.createFileURI((String)launchParser.path.get(mName)),
					false);			
			models.put(mName, m);
		}

		for(Iterator i = launchParser.output.keySet().iterator() ; i.hasNext() ; ) {
			String mName = (String)i.next();
			String mmName = (String)launchParser.output.get(mName);

			ReferenceModel mm = (ReferenceModel)models.get(mmName);
			if(mm == null) {
				mm = loadReferenceModel(mmName, launchParser.path);
				models.put(mmName, mm);
			}
			AbstractModel m = new EMFModel(
					mm, 
					URI.createPlatformResourceURI((String)launchParser.path.get(mName), true),
					true);		
			models.put(mName, m);
			m.isTarget = true;
		}

		try {
			Map libraries = new HashMap();
			for(Iterator i = launchParser.libsFromConfig.keySet().iterator() ; i.hasNext() ; ) {
				String libName = (String)i.next();
				IFile libFile = ResourcesPlugin.getWorkspace().getRoot().getFile(Path.fromOSString((String)launchParser.libsFromConfig.get(libName)));
				ASM lib = new ASMXMLReader().read(libFile.getContents());
				libraries.put(libName, lib);
			}

			List superimpose = new ArrayList();
			for(Iterator i = launchParser.superimpose.iterator() ; i.hasNext() ; ) {
				String path = (String)i.next();
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(Path.fromOSString(path));
				ASM module = new ASMXMLReader().read(file.getContents());
				superimpose.add(module);
			}

			startTime = System.currentTimeMillis();
			asm.run(models, libraries,superimpose, launchParser.options);
			endTime = System.currentTimeMillis();

			for(Iterator i = launchParser.output.keySet().iterator() ; i.hasNext() ; ) {
				String mName = (String)i.next();

				EMFModel m = (EMFModel)models.get(mName);			
				m.save(URI.createFileURI((String)launchParser.path.get(mName)));
			}
		} catch(VMException vme) {
			vme.printStackTrace(System.out);
			throw vme;
		} finally {
			for(Iterator i = models.values().iterator() ; i.hasNext() ; ) {
				Model model = (Model)i.next();
				model.dispose();
			}
		}

		return (endTime - startTime) / 1000.;
	}

	private ReferenceModel loadReferenceModel(String mmName, Map modelPaths) throws IOException {
		ReferenceModel ret = null;

		String path = (String)modelPaths.get(mmName);
		if(path.startsWith("#")) {
			ret = EMFReferenceModel.getMetametamodel();
		} else if(path.startsWith("uri:")){
			ret = new EMFReferenceModel(EMFReferenceModel.getMetametamodel(), path.substring(4));
		} else {
			ret = new EMFReferenceModel(EMFReferenceModel.getMetametamodel(), URI.createFileURI(path));
		}		

		return ret;
	}
}

