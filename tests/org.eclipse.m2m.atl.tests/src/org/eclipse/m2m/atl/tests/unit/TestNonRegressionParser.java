/*******************************************************************************
 * Copyright (c) 2007, 2009 Obeo.
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
import java.io.IOException;

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
		final String outputPath = directory + File.separator + directory.getName() + ".atl.xmi"; //$NON-NLS-1$
		final String expectedPath = expectedDir + File.separator + directory.getName() + ".atl.xmi"; //$NON-NLS-1$
		if (!new File(transfoPath).exists()) {
			fail("ATL file " + transfoPath + " does not exist"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		try {
			EObject result = AtlParser.getDefault().parse(new FileInputStream(transfoPath));
			ModelUtils.save(result, "file:/" + transfoPath + ".xmi"); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (IOException e) {
			fail("Failed to parse " + transfoPath); //$NON-NLS-1$
		}

		try {
			FileUtils.compareFiles(new File(outputPath), new File(expectedPath), true);
		} catch (IOException e) {
			fail(e.getMessage(),e);
		}

		info(directory.getName() + " parsed successfully"); //$NON-NLS-1$ 
	}

}
