/*******************************************************************************
 * Copyright (c) 2007, 2011 Obeo.
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
import java.io.FileWriter;
import java.util.Properties;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import org.eclipse.m2m.atl.tests.util.FileUtils;
import org.eclipse.m2m.atl.tests.util.ModelUtils;

/**
 * Launches parsing on each atl file, compare results.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class TestNonRegressionParser extends TestNonRegression {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.tests.unit.TestNonRegression#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Properties properties = new Properties();
		properties.load(TestNonRegressionParser.class
				.getResourceAsStream("TestNonRegressionParser.properties")); //$NON-NLS-1$
		setProperties(properties);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.tests.unit.TestNonRegression#singleTest(java.io.File)
	 */
	@Override
	protected void singleTest(File directory) {
		final File expectedDir = new File(directory.getPath().replaceFirst("inputs", "expected")); //$NON-NLS-1$//$NON-NLS-2$
		final String transfoPath = directory + File.separator + directory.getName() + ".atl"; //$NON-NLS-1$
		final String expectedPath = expectedDir + File.separator + directory.getName() + ".atl.xmi"; //$NON-NLS-1$
		if (!new File(transfoPath).exists()) {
			info("ATL file " + transfoPath + " does not exist. Skipped"); //$NON-NLS-1$ //$NON-NLS-2$
			return;
		}
		try {
			EObject result = AtlParser.getDefault().parse(new FileInputStream(transfoPath));
			if (new File(expectedPath).exists()) {
				assertEquals(FileUtils.readFileAsString(new File(expectedPath)), ModelUtils.serialize(result));
			} else {
				FileWriter fw = new FileWriter(expectedPath);
				fw.write(ModelUtils.serialize(result));
				fw.close();
			}
		} catch (Exception e) {
			fail("Failed to parse " + transfoPath + ": " + e); //$NON-NLS-1$
		}
	}
}
