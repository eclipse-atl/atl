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
package org.eclipse.m2m.atl.tests.unit;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.m2m.atl.tests.AtlTestPlugin;
import org.eclipse.m2m.atl.tests.AtlTestsMessages;
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
			fail(AtlTestsMessages.getString("TestNonRegressionTransfo.0")); //$NON-NLS-1$
		}
		System.out.print(AtlTestsMessages.getString("TestNonRegressionTransfo.1")+directory.getName()+AtlTestsMessages.getString("TestNonRegressionTransfo.2")); //$NON-NLS-1$ //$NON-NLS-2$
		final String buildURI = directory+ File.separator + directory.getName() + ".launch";	 //$NON-NLS-1$

		if (!new File(buildURI).exists()) fail(AtlTestsMessages.getString("TestNonRegressionTransfo.3")); //$NON-NLS-1$
		if (launcher == null) fail(AtlTestsMessages.getString("TestNonRegressionTransfo.4")); //$NON-NLS-1$
		
		try {
			launcher.parseConfiguration(buildURI);
		} catch (Exception e) {
			e.printStackTrace();
			fail(AtlTestsMessages.getString("TestNonRegressionTransfo.5")); //$NON-NLS-1$
		} 

		/*
		 * TRANSFORMATION LAUNCH 
		 * 
		 */
		double executionTime = 0;
		try {
			executionTime = launcher.run(vmName);
		} catch (Exception e) {
			e.printStackTrace();
			fail(AtlTestsMessages.getString("TestNonRegressionTransfo.6")); //$NON-NLS-1$
		}
		System.out.println(executionTime+"s."); //$NON-NLS-1$

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
				fail(AtlTestsMessages.getString("TestNonRegressionTransfo.7")); //$NON-NLS-1$
			}		
		}
		
		for (Iterator iter = output.keySet().iterator(); iter.hasNext();) {
			String outputid = (String) iter.next();
			String outputPath = (String) launcher.getPath().get(outputid);
			String expectedPath = FileUtils.getTestCommonDirectory()+outputPath.replaceFirst("inputs","expected"); //$NON-NLS-1$ //$NON-NLS-2$
			try {
				outputPath = FileUtils.getTestCommonDirectory()+outputPath;
				ModelUtils.compareModels(new File(outputPath), new File(expectedPath), true, true);
			} catch (Exception e) {
				e.printStackTrace();
				fail(AtlTestsMessages.getString("TestNonRegressionTransfo.8")); //$NON-NLS-1$
			}
		}
		AllTests.addVMResult(this, directory, new Double(executionTime));
		AtlTestPlugin.getResourceSet().getResources().clear();
	}

	protected void setVmName(String vmName) {
		this.vmName = vmName;
	}

	public String getVmName() {
		return vmName;
	}

}

