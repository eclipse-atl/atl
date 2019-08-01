/*******************************************************************************
 * Copyright (c) 2011-2012 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.tests;

import org.eclipse.m2m.atl.emftvm.tests.compiler.AtlResourceTest;
import org.eclipse.m2m.atl.emftvm.tests.compiler.CompilerTest;
import org.eclipse.m2m.atl.emftvm.tests.integration.IntegrationTest;
import org.eclipse.m2m.atl.emftvm.tests.performance.ATLtoEMFTVMPerformanceTest;
import org.eclipse.m2m.atl.emftvm.tests.performance.EcoreCopyPerformanceTest;
import org.eclipse.m2m.atl.emftvm.tests.pojo.PojoModelTest;
import org.eclipse.m2m.atl.emftvm.util.tests.ExecEnvPoolTest;
import org.eclipse.m2m.atl.emftvm.util.tests.LazyBagOnCollectionTest;
import org.eclipse.m2m.atl.emftvm.util.tests.LazyBagTest;
import org.eclipse.m2m.atl.emftvm.util.tests.LazyListOnCollectionTest;
import org.eclipse.m2m.atl.emftvm.util.tests.LazyListOnListTest;
import org.eclipse.m2m.atl.emftvm.util.tests.LazyListTest;
import org.eclipse.m2m.atl.emftvm.util.tests.LazyOrderedSetTest;
import org.eclipse.m2m.atl.emftvm.util.tests.LazySetOnSetTest;
import org.eclipse.m2m.atl.emftvm.util.tests.LazySetTest;
import org.eclipse.m2m.atl.emftvm.util.tests.OCLOperationsTest;
import org.eclipse.m2m.atl.emftvm.util.tests.StackFrameTest;
import org.eclipse.m2m.atl.emftvm.util.tests.TupleTest;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

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
		suite.addTestSuite(LazyBagOnCollectionTest.class);
		suite.addTestSuite(LazySetTest.class);
		suite.addTestSuite(LazySetOnSetTest.class);
		suite.addTestSuite(LazyOrderedSetTest.class);
		suite.addTestSuite(ExecEnvPoolTest.class);
		suite.addTestSuite(OCLOperationsTest.class);
		suite.addTestSuite(StackFrameTest.class);
		suite.addTestSuite(TupleTest.class);
		suite.addTestSuite(PojoModelTest.class);
		suite.addTestSuite(CompilerTest.class);
		suite.addTestSuite(AtlResourceTest.class);
		suite.addTestSuite(IntegrationTest.class);
		suite.addTestSuite(EcoreCopyPerformanceTest.class);
		suite.addTestSuite(ATLtoEMFTVMPerformanceTest.class);
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
