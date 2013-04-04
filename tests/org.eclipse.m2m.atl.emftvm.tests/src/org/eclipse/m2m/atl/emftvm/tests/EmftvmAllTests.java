/*******************************************************************************
 * Copyright (c) 2011-2012 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.eclipse.m2m.atl.emftvm.tests.performance.PerformanceTest;
import org.eclipse.m2m.atl.emftvm.tests.pojo.PojoModelTest;
import org.eclipse.m2m.atl.emftvm.util.tests.ExecEnvPoolTest;
import org.eclipse.m2m.atl.emftvm.util.tests.LazyBagTest;
import org.eclipse.m2m.atl.emftvm.util.tests.LazyListOnCollectionTest;
import org.eclipse.m2m.atl.emftvm.util.tests.LazyListOnListTest;
import org.eclipse.m2m.atl.emftvm.util.tests.LazyListTest;
import org.eclipse.m2m.atl.emftvm.util.tests.LazyOrderedSetTest;
import org.eclipse.m2m.atl.emftvm.util.tests.LazySetTest;
import org.eclipse.m2m.atl.emftvm.util.tests.OCLOperationsTest;
import org.eclipse.m2m.atl.emftvm.util.tests.TupleTest;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>Emftvm</b></em>' model.
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * @generated
 */
public class EmftvmAllTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static Test suite() {
		TestSuite suite = new EmftvmAllTests("Emftvm Tests");
		suite.addTest(EmftvmTests.suite());
		suite.addTestSuite(LazyListTest.class);
		suite.addTestSuite(LazyListOnCollectionTest.class);
		suite.addTestSuite(LazyListOnListTest.class);
		suite.addTestSuite(LazyBagTest.class);
		suite.addTestSuite(LazySetTest.class);
		suite.addTestSuite(LazyOrderedSetTest.class);
		suite.addTestSuite(ExecEnvPoolTest.class);
		suite.addTestSuite(OCLOperationsTest.class);
		suite.addTestSuite(TupleTest.class);
		suite.addTestSuite(PojoModelTest.class);
		suite.addTestSuite(PerformanceTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmftvmAllTests(String name) {
		super(name);
	}

} //EmftvmAllTests
