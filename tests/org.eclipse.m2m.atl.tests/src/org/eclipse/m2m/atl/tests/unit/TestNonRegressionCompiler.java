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

import org.eclipse.m2m.atl.tests.unit.atlvm.TestNonRegressionEMFVM;

/**
 * Specifies TestNonRegressionTransfo for the emfvm.
 * 
 * @author William Piers <a href="mailto:william.piers@obeo.fr">william.piers@obeo.fr</a>
 */
public class TestNonRegressionCompiler extends TestNonRegressionEMFVM {

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		RECOMPILE_BEFORE_LAUNCH = true;
		setPropertiesPath("/org.eclipse.m2m.atl.tests/data/emfvm.properties");//$NON-NLS-1$
	}

}

