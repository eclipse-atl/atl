/*******************************************************************************
 * Copyright (c) 2011 Obeo.
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

import org.eclipse.m2m.atl.adt.ui.editor.formatter.AtlCodeFormatter;
import org.eclipse.m2m.atl.tests.util.FileUtils;

/**
 * Launches formatter on each atl file, compare results.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class TestNonRegressionFormatter extends TestNonRegression {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.tests.unit.TestNonRegression#singleTest(java.io.File)
	 */
	@Override
	protected void singleTest(File directory) {
		for (File input : directory.listFiles()) {
			if (input.getName().endsWith(".atl")) {
				final File expected = new File(input.getPath().replaceFirst(
						"inputs", "expected")); //$NON-NLS-1$//$NON-NLS-2$
				testFile(input, expected);
			}
		}

	}

	private void testFile(final File input, final File expected) {
		String result = ""; //$NON-NLS-1$
		try {
			result = new AtlCodeFormatter().format(new FileInputStream(input));
			if (expected.exists()) {
				String expectedResult = FileUtils.readFileAsString(expected);
				expectedResult = expectedResult.replaceAll("\r\n","\n");
				result = result.replaceAll("\r\n","\n");
				assertEquals(input.getName(), expectedResult, result);
			} else {
				FileWriter fw = new FileWriter(expected);
				fw.write(result);
				fw.close();
			}
		} catch (Exception e) {
			fail(input.getName(), e);
		}
	}
}
