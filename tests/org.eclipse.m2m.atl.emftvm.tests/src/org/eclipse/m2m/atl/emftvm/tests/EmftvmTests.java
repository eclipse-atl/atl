/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
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

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>emftvm</b></em>' package.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * @generated
 */
public class EmftvmTests extends TestSuite {

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
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new EmftvmTests("emftvm Tests");
		suite.addTestSuite(ExecEnvTest.class);
		suite.addTestSuite(ModelTest.class);
		suite.addTestSuite(MetamodelTest.class);
		suite.addTestSuite(ModuleTest.class);
		suite.addTestSuite(FieldTest.class);
		suite.addTestSuite(OperationTest.class);
		suite.addTestSuite(ParameterTest.class);
		suite.addTestSuite(LocalVariableTest.class);
		suite.addTestSuite(RuleTest.class);
		suite.addTestSuite(InputRuleElementTest.class);
		suite.addTestSuite(OutputRuleElementTest.class);
		suite.addTestSuite(CodeBlockTest.class);
		suite.addTestSuite(PushTest.class);
		suite.addTestSuite(PushtTest.class);
		suite.addTestSuite(PushfTest.class);
		suite.addTestSuite(PopTest.class);
		suite.addTestSuite(LoadTest.class);
		suite.addTestSuite(StoreTest.class);
		suite.addTestSuite(SetTest.class);
		suite.addTestSuite(GetTest.class);
		suite.addTestSuite(GetTransTest.class);
		suite.addTestSuite(SetStaticTest.class);
		suite.addTestSuite(GetStaticTest.class);
		suite.addTestSuite(FindtypeTest.class);
		suite.addTestSuite(FindtypeSTest.class);
		suite.addTestSuite(NewTest.class);
		suite.addTestSuite(NewSTest.class);
		suite.addTestSuite(DeleteTest.class);
		suite.addTestSuite(DupTest.class);
		suite.addTestSuite(DupX1Test.class);
		suite.addTestSuite(SwapTest.class);
		suite.addTestSuite(SwapX1Test.class);
		suite.addTestSuite(IfTest.class);
		suite.addTestSuite(IfnTest.class);
		suite.addTestSuite(GotoTest.class);
		suite.addTestSuite(IterateTest.class);
		suite.addTestSuite(EnditerateTest.class);
		suite.addTestSuite(InvokeTest.class);
		suite.addTestSuite(InvokeSuperTest.class);
		suite.addTestSuite(InvokeStaticTest.class);
		suite.addTestSuite(AllinstTest.class);
		suite.addTestSuite(AllinstInTest.class);
		suite.addTestSuite(IsnullTest.class);
		suite.addTestSuite(GetenvtypeTest.class);
		suite.addTestSuite(NotTest.class);
		suite.addTestSuite(AndTest.class);
		suite.addTestSuite(OrTest.class);
		suite.addTestSuite(XorTest.class);
		suite.addTestSuite(ImpliesTest.class);
		suite.addTestSuite(IfteTest.class);
		suite.addTestSuite(ReturnTest.class);
		suite.addTestSuite(GetcbTest.class);
		suite.addTestSuite(InvokeAllCbsTest.class);
		suite.addTestSuite(InvokeCbTest.class);
		suite.addTestSuite(InvokeCbSTest.class);
		suite.addTestSuite(MatchTest.class);
		suite.addTestSuite(MatchSTest.class);
		suite.addTestSuite(AddTest.class);
		suite.addTestSuite(RemoveTest.class);
		suite.addTestSuite(InsertTest.class);
		suite.addTestSuite(GetSuperTest.class);
		suite.addTestSuite(GetenvTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmftvmTests(String name) {
		super(name);
	}

} //EmftvmTests
