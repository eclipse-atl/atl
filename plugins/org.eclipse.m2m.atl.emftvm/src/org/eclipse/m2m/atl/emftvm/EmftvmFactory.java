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
package org.eclipse.m2m.atl.emftvm;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage
 * @generated
 */
public interface EmftvmFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EmftvmFactory eINSTANCE = org.eclipse.m2m.atl.emftvm.impl.EmftvmFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Module</em>'.
	 * @generated
	 */
	Module createModule();

	/**
	 * Returns a new object of class '<em>Model Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Declaration</em>'.
	 * @generated
	 */
	ModelDeclaration createModelDeclaration();

	/**
	 * Returns a new object of class '<em>Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Field</em>'.
	 * @generated
	 */
	Field createField();

	/**
	 * Returns a new object of class '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation</em>'.
	 * @generated
	 */
	Operation createOperation();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Line Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Line Number</em>'.
	 * @generated
	 */
	LineNumber createLineNumber();

	/**
	 * Returns a new object of class '<em>Local Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Variable</em>'.
	 * @generated
	 */
	LocalVariable createLocalVariable();

	/**
	 * Returns a new object of class '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule</em>'.
	 * @generated
	 */
	Rule createRule();

	/**
	 * Returns a new object of class '<em>Input Rule Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Rule Element</em>'.
	 * @generated
	 */
	InputRuleElement createInputRuleElement();

	/**
	 * Returns a new object of class '<em>Output Rule Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Rule Element</em>'.
	 * @generated
	 */
	OutputRuleElement createOutputRuleElement();

	/**
	 * Returns a new object of class '<em>Code Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Code Block</em>'.
	 * @generated
	 */
	CodeBlock createCodeBlock();

	/**
	 * Returns a new object of class '<em>Push</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Push</em>'.
	 * @generated
	 */
	Push createPush();

	/**
	 * Returns a new object of class '<em>Pusht</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pusht</em>'.
	 * @generated
	 */
	Pusht createPusht();

	/**
	 * Returns a new object of class '<em>Pushf</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pushf</em>'.
	 * @generated
	 */
	Pushf createPushf();

	/**
	 * Returns a new object of class '<em>Pop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pop</em>'.
	 * @generated
	 */
	Pop createPop();

	/**
	 * Returns a new object of class '<em>Load</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Load</em>'.
	 * @generated
	 */
	Load createLoad();

	/**
	 * Returns a new object of class '<em>Store</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Store</em>'.
	 * @generated
	 */
	Store createStore();

	/**
	 * Returns a new object of class '<em>Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set</em>'.
	 * @generated
	 */
	Set createSet();

	/**
	 * Returns a new object of class '<em>Get</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get</em>'.
	 * @generated
	 */
	Get createGet();

	/**
	 * Returns a new object of class '<em>Get Trans</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Trans</em>'.
	 * @generated
	 */
	GetTrans createGetTrans();

	/**
	 * Returns a new object of class '<em>Set Static</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Static</em>'.
	 * @generated
	 */
	SetStatic createSetStatic();

	/**
	 * Returns a new object of class '<em>Get Static</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Static</em>'.
	 * @generated
	 */
	GetStatic createGetStatic();

	/**
	 * Returns a new object of class '<em>Findtype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Findtype</em>'.
	 * @generated
	 */
	Findtype createFindtype();

	/**
	 * Returns a new object of class '<em>Findtype S</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Findtype S</em>'.
	 * @generated
	 */
	FindtypeS createFindtypeS();

	/**
	 * Returns a new object of class '<em>New</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New</em>'.
	 * @generated
	 */
	New createNew();

	/**
	 * Returns a new object of class '<em>New S</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New S</em>'.
	 * @generated
	 */
	NewS createNewS();

	/**
	 * Returns a new object of class '<em>Delete</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delete</em>'.
	 * @generated
	 */
	Delete createDelete();

	/**
	 * Returns a new object of class '<em>Dup</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dup</em>'.
	 * @generated
	 */
	Dup createDup();

	/**
	 * Returns a new object of class '<em>Dup X1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dup X1</em>'.
	 * @generated
	 */
	DupX1 createDupX1();

	/**
	 * Returns a new object of class '<em>Swap</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Swap</em>'.
	 * @generated
	 */
	Swap createSwap();

	/**
	 * Returns a new object of class '<em>Swap X1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Swap X1</em>'.
	 * @generated
	 */
	SwapX1 createSwapX1();

	/**
	 * Returns a new object of class '<em>If</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If</em>'.
	 * @generated
	 */
	If createIf();

	/**
	 * Returns a new object of class '<em>Ifn</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifn</em>'.
	 * @generated
	 */
	Ifn createIfn();

	/**
	 * Returns a new object of class '<em>Goto</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Goto</em>'.
	 * @generated
	 */
	Goto createGoto();

	/**
	 * Returns a new object of class '<em>Iterate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterate</em>'.
	 * @generated
	 */
	Iterate createIterate();

	/**
	 * Returns a new object of class '<em>Enditerate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enditerate</em>'.
	 * @generated
	 */
	Enditerate createEnditerate();

	/**
	 * Returns a new object of class '<em>Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invoke</em>'.
	 * @generated
	 */
	Invoke createInvoke();

	/**
	 * Returns a new object of class '<em>Invoke Super</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invoke Super</em>'.
	 * @generated
	 */
	InvokeSuper createInvokeSuper();

	/**
	 * Returns a new object of class '<em>Invoke Static</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invoke Static</em>'.
	 * @generated
	 */
	InvokeStatic createInvokeStatic();

	/**
	 * Returns a new object of class '<em>Allinst</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Allinst</em>'.
	 * @generated
	 */
	Allinst createAllinst();

	/**
	 * Returns a new object of class '<em>Allinst In</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Allinst In</em>'.
	 * @generated
	 */
	AllinstIn createAllinstIn();

	/**
	 * Returns a new object of class '<em>Match</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Match</em>'.
	 * @generated
	 */
	Match createMatch();

	/**
	 * Returns a new object of class '<em>Match S</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Match S</em>'.
	 * @generated
	 */
	MatchS createMatchS();

	/**
	 * Returns a new object of class '<em>Add</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add</em>'.
	 * @generated
	 */
	Add createAdd();

	/**
	 * Returns a new object of class '<em>Remove</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remove</em>'.
	 * @generated
	 */
	Remove createRemove();

	/**
	 * Returns a new object of class '<em>Insert</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Insert</em>'.
	 * @generated
	 */
	Insert createInsert();

	/**
	 * Returns a new object of class '<em>Get Super</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Super</em>'.
	 * @generated
	 */
	GetSuper createGetSuper();

	/**
	 * Returns a new object of class '<em>Return</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Return</em>'.
	 * @generated
	 */
	Return createReturn();

	/**
	 * Returns a new object of class '<em>Getcb</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Getcb</em>'.
	 * @generated
	 */
	Getcb createGetcb();

	/**
	 * Returns a new object of class '<em>Invoke All Cbs</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invoke All Cbs</em>'.
	 * @generated
	 */
	InvokeAllCbs createInvokeAllCbs();

	/**
	 * Returns a new object of class '<em>Invoke Cb</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invoke Cb</em>'.
	 * @generated
	 */
	InvokeCb createInvokeCb();

	/**
	 * Returns a new object of class '<em>Invoke Cb S</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invoke Cb S</em>'.
	 * @generated
	 */
	InvokeCbS createInvokeCbS();

	/**
	 * Returns a new object of class '<em>Not</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not</em>'.
	 * @generated
	 */
	Not createNot();

	/**
	 * Returns a new object of class '<em>And</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And</em>'.
	 * @generated
	 */
	And createAnd();

	/**
	 * Returns a new object of class '<em>Or</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or</em>'.
	 * @generated
	 */
	Or createOr();

	/**
	 * Returns a new object of class '<em>Xor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xor</em>'.
	 * @generated
	 */
	Xor createXor();

	/**
	 * Returns a new object of class '<em>Implies</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Implies</em>'.
	 * @generated
	 */
	Implies createImplies();

	/**
	 * Returns a new object of class '<em>Ifte</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifte</em>'.
	 * @generated
	 */
	Ifte createIfte();

	/**
	 * Returns a new object of class '<em>Isnull</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Isnull</em>'.
	 * @generated
	 */
	Isnull createIsnull();

	/**
	 * Returns a new object of class '<em>Getenvtype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Getenvtype</em>'.
	 * @generated
	 */
	Getenvtype createGetenvtype();

	/**
	 * Returns a new object of class '<em>Exec Env</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exec Env</em>'.
	 * @generated
	 */
	ExecEnv createExecEnv();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	Model createModel();

	/**
	 * Returns a new object of class '<em>Metamodel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Metamodel</em>'.
	 * @generated
	 */
	Metamodel createMetamodel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EmftvmPackage getEmftvmPackage();

	/**
	 * Creates a new {@link Instruction} instance for the given <pre>opcode</pre>.
	 * @param opcode the instruction opcode.
	 * @return a new {@link Instruction} instance for the given <pre>opcode</pre>.
	 */
	Instruction createInstruction(Opcode opcode);

} //EmftvmFactory
