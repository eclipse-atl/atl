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
import java.util.logging.Level;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.ATLLogger;
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
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class TestNonRegressionEMFVM extends TestNonRegressionTransfo {

	protected String getVMName() {
		return "EMFVM";
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.tests.unit.TestNonRegressionTransfo#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		setPropertiesPath("/org.eclipse.m2m.atl.tests/data/emfvm.properties"); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.tests.unit.TestNonRegressionTransfo#launch()
	 */
	public double launch() throws CoreException, IOException {
		long startTime;
		long endTime;
		ASM asm = new ASMXMLReader().read(launchParser.getAsmUrl().openStream());
		Map models = new HashMap();

		for (Iterator i = launchParser.getInput().keySet().iterator(); i.hasNext();) {
			String mName = (String)i.next();
			String mmName = (String)launchParser.getInput().get(mName);

			ReferenceModel mm = (ReferenceModel)models.get(mmName);
			if (mm == null) {
				mm = loadReferenceModel(mmName, launchParser.getPath());
				models.put(mmName, mm);
			}
			Model m = new EMFModel(mm, URI.createFileURI((String)launchParser.getPath().get(mName)), false);
			models.put(mName, m);
		}

		for (Iterator i = launchParser.getOutput().keySet().iterator(); i.hasNext();) {
			String mName = (String)i.next();
			String mmName = (String)launchParser.getOutput().get(mName);

			ReferenceModel mm = (ReferenceModel)models.get(mmName);
			if (mm == null) {
				mm = loadReferenceModel(mmName, launchParser.getPath());
				models.put(mmName, mm);
			}
			AbstractModel m = new EMFModel(mm, URI.createPlatformResourceURI((String)launchParser.getPath()
					.get(mName), true), true);
			models.put(mName, m);
			m.setIsTarget(true);
		}

		try {
			Map libraries = new HashMap();
			for (Iterator i = launchParser.getLibsFromConfig().keySet().iterator(); i.hasNext();) {
				String libName = (String)i.next();
				IFile libFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
						Path.fromOSString((String)launchParser.getLibsFromConfig().get(libName)));
				ASM lib = new ASMXMLReader().read(libFile.getContents());
				libraries.put(libName, lib);
			}

			List superimpose = new ArrayList();
			for (Iterator i = launchParser.getSuperimpose().iterator(); i.hasNext();) {
				String path = (String)i.next();
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(Path.fromOSString(path));
				ASM module = new ASMXMLReader().read(file.getContents());
				superimpose.add(module);
			}

			startTime = System.currentTimeMillis();
			asm.run(models, libraries, superimpose, launchParser.getOptions());
			endTime = System.currentTimeMillis();

			for (Iterator i = launchParser.getOutput().keySet().iterator(); i.hasNext();) {
				String mName = (String)i.next();

				EMFModel m = (EMFModel)models.get(mName);
				m.save(URI.createFileURI((String)launchParser.getPath().get(mName)));
			}
		} catch (VMException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			throw e;
		} finally {
			for (Iterator i = models.values().iterator(); i.hasNext();) {
				Model model = (Model)i.next();
				model.dispose();
			}
		}

		return (endTime - startTime) / 1000.;
	}

	private ReferenceModel loadReferenceModel(String mmName, Map modelPaths) throws IOException {
		ReferenceModel ret = null;

		String path = (String)modelPaths.get(mmName);
		if (path.startsWith("#")) {
			ret = EMFReferenceModel.getMetametamodel();
		} else if (path.startsWith("uri:")) {
			ret = new EMFReferenceModel(EMFReferenceModel.getMetametamodel(), path.substring(4));
		} else {
			ret = new EMFReferenceModel(EMFReferenceModel.getMetametamodel(), URI.createFileURI(path));
		}

		return ret;
	}
}
