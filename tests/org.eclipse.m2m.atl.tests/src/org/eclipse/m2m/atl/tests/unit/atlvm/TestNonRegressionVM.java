/*******************************************************************************
 * Copyright (c) 2007, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - ATL tester
 *******************************************************************************/
package org.eclipse.m2m.atl.tests.unit.atlvm;

import java.util.Properties;

import org.eclipse.m2m.atl.tests.unit.TestNonRegressionTransfo;

/**
 * Specifies TestNonRegressionTransfo for the vm.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class TestNonRegressionVM extends TestNonRegressionTransfo {

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.tests.unit.TestNonRegressionTransfo#getVMName()
	 */
	@Override
	protected String getVMName() {
		return "Regular VM (with debugger)"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.tests.unit.TestNonRegressionTransfo#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Properties properties = new Properties();
		properties.load(TestNonRegressionVM.class.getResourceAsStream("TestNonRegressionVM.properties")); //$NON-NLS-1$
		setProperties(properties);
	}

}
