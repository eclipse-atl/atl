/*******************************************************************************
 * Copyright (c) 2007, 2012 Obeo.
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
import java.io.InputStreamReader;
import java.io.Reader;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.engine.compiler.AtlCompiler;
import org.eclipse.m2m.atl.tests.unit.atlvm.TestNonRegressionEMFVM;

/**
 * Specifies TestNonRegressionTransfo for the emfvm.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class TestNonRegressionCompiler extends TestNonRegressionEMFVM {

	private static final String RESOURCE_PATH = "/data/other/"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.tests.unit.atlvm.TestNonRegressionEMFVM#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		recompileBeforeLaunch = true;
	}

	/**
	 * Tests for bug # 488305: Too many comments in ATL causing compilation
	 * failure.
	 */
	public void testBug488305() throws Exception {
		final File outFile = File.createTempFile("testBug488305", ".asm");
		outFile.deleteOnExit();
		final File atlFile = new File(baseDirectory.getPath() + RESOURCE_PATH + "rb.atl"); //$NON-NLS-1$
		final Reader in = new InputStreamReader(new FileInputStream(atlFile));
		try {
			final EObject[] problems = AtlCompiler.compile(in, outFile.getPath());
			assertNotNull(problems);
			assertEquals(0, problems.length);
		} finally {
			in.close();
		}
	}

}
