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
import java.io.FileInputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.engine.AtlParser;
import org.eclipse.m2m.atl.tests.util.FileUtils;
import org.eclipse.m2m.atl.tests.util.ModelUtils;

/**
 * Launches parsing on each atl file, compare results.
 * 
 * @author William Piers <a href="mailto:william.piers@obeo.fr">william.piers@obeo.fr</a>
 */
public class TestNonRegressionParser extends TestNonRegression {

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.m2m.atl.tests.unit.TestNonRegression#singleTest(java.io.File)
	 */
	protected void singleTest(File directory) {	
		System.out.print("Parsing "+directory.getName()+"...");
		final File expectedDir = new File(directory.getPath().replace(File.separator + "inputs", //$NON-NLS-1$
				File.separator + "expected")); //$NON-NLS-1$ //$NON-NLS-2$
		final String transfoPath = directory+ File.separator + directory.getName() + ".atl";	
		final String outputPath = directory+ File.separator + directory.getName() + ".atl.ecore";	
		final String expectedPath = expectedDir+ File.separator + directory.getName() + ".atl.ecore";	
		if (!new File(transfoPath).exists()) fail("atl file not found");

		try {
			EObject result = AtlParser.getDefault().parse(new FileInputStream(transfoPath));
			ModelUtils.save(result, "file:/"+transfoPath+".ecore");	
		} catch (Exception e) {
			e.printStackTrace();
			fail("parsing failed");
		}		

		try {
			FileUtils.compareFiles(new File(outputPath), new File(expectedPath), true);
			
			/* NOTE : 
			 * ======
			 * To integrate a new test, you can generate the <TEST_NAME>.atl.ecore
			 * by firstly use the following line :
			 * FileUtils.compareFiles(new File(outputPath), new File(expectedPath), false);
			 * 
			 * Test will fail but you will be able to move the <TEST_NAME>.atl.ecore file
			 * into the corresponding "expected" directory.
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("unable to compare results");
		}
		
		System.out.println("done.");
	}

}

