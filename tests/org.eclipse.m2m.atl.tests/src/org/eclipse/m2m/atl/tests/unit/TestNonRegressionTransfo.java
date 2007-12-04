/*******************************************************************************
 * Copyright (c) 2007 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - ATL tester
 *******************************************************************************/
package org.eclipse.m2m.atl.tests.unit;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.m2m.atl.tests.AtlTestPlugin;
import org.eclipse.m2m.atl.tests.suite.AllTests;
import org.eclipse.m2m.atl.tests.util.FileUtils;
import org.eclipse.m2m.atl.tests.util.ModelUtils;
import org.eclipse.m2m.atl.tests.util.TransfoLauncher;

/**
 * Test if the results models are still the same as expected.
 * 
 * @author William Piers <a href="mailto:william.piers@obeo.fr">william.piers@obeo.fr</a>
 */
public abstract class TestNonRegressionTransfo extends TestNonRegression {
	
	private String vmName = null;
	private TransfoLauncher launcher = new TransfoLauncher();

	/* (non-Javadoc)
	 * @see org.eclipse.m2m.atl.tests.unit.TestNonRegression#singleTest(java.io.File)
	 */
	protected void singleTest(File directory) {
		if (vmName == null) {
			fail("VM name must be specified.");
		}
		System.out.print("Launching "+directory.getName()+"... ");
		
		final File expectedDir = new File(directory.getPath().replace(File.separator + "inputs", //$NON-NLS-1$
				File.separator + "expected")); //$NON-NLS-1$ //$NON-NLS-2$
		String[] expectedPaths = expectedDir.list();
		final String buildURI = directory+ File.separator + directory.getName() + ".launch";	
		
		if (!new File(buildURI).exists()) fail("launch config not found");
		if (launcher == null) fail("launcher not found");
		
		try {
			launcher.parseConfiguration(buildURI);
		} catch (Exception e) {
			e.printStackTrace();
			fail("incorrect configuration");
		} 

		/*
		 * TRANSFORMATION LAUNCH 
		 * 
		 */
		double executionTime = 0;
		try {
			executionTime = launcher.run(vmName);
			//executionTime = launcher.run("EMF-specific VM");
		} catch (Exception e) {
			e.printStackTrace();
			fail("transformation failed");
		}
		System.out.println(executionTime+"s.");

		/*
		 * RESULTS COMPARISON 
		 * 
		 */
		
		Map output = launcher.getOutput();
		//metamodels registration for emf comparison
		for (Iterator iter = output.values().iterator(); iter.hasNext();) {
			String metaid = (String) iter.next();
			String metapath = (String) launcher.getPath().get(metaid);
			try {
				ModelUtils.registerMetamodel(FileUtils.fileNameToURI(metapath), AtlTestPlugin.getResourceSet());					
			} catch (IOException e) {
				e.printStackTrace();
				fail("unable to register output metamodels");
			}		
		}
		
		for (Iterator iter = output.keySet().iterator(); iter.hasNext();) {
			String outputid = (String) iter.next();
			String outputPath = (String) launcher.getPath().get(outputid);
			String expectedPath = null;
			for (int j = 0; j < expectedPaths.length; j++) {
				if (outputPath.endsWith(expectedPaths[j])) {
					expectedPath = expectedDir+"\\"+expectedPaths[j];
				}					
			}			
			if (expectedPath == null) fail("expected path for "+outputPath+" not found");
			try {
				outputPath = FileUtils.getTestCommonDirectory()+outputPath;
				ModelUtils.compareModels(new File(outputPath), new File(expectedPath), true, true);
			} catch (Exception e) {
				e.printStackTrace();
				fail("unable to compare results");
			}

		}

		AllTests.addVMResult(this, directory, new Double(executionTime));
	}

	protected void setVmName(String vmName) {
		this.vmName = vmName;
	}

	public String getVmName() {
		return vmName;
	}

}

