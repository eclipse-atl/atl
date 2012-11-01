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
package org.eclipse.m2m.atl.emftvm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.atl.emftvm.EmftvmFactory
 * @model kind="package"
 * @generated
 */
public interface EmftvmPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "emftvm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/m2m/atl/2011/EMFTVM";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "emftvm";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EmftvmPackage eINSTANCE = org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.NamedElementImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.ModuleImpl <em>Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.ModuleImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getModule()
	 * @generated
	 */
	int MODULE = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.TypedElementImpl <em>Typed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.TypedElementImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getTypedElement()
	 * @generated
	 */
	int TYPED_ELEMENT = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.FeatureImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.FieldImpl <em>Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.FieldImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getField()
	 * @generated
	 */
	int FIELD = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.OperationImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.ParameterImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.InstructionImpl <em>Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.InstructionImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getInstruction()
	 * @generated
	 */
	int INSTRUCTION = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.LineNumberImpl <em>Line Number</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.LineNumberImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getLineNumber()
	 * @generated
	 */
	int LINE_NUMBER = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.LocalVariableImpl <em>Local Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.LocalVariableImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getLocalVariable()
	 * @generated
	 */
	int LOCAL_VARIABLE = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.RuleImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getRule()
	 * @generated
	 */
	int RULE = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.RuleElementImpl <em>Rule Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.RuleElementImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getRuleElement()
	 * @generated
	 */
	int RULE_ELEMENT = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.CodeBlockImpl <em>Code Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.CodeBlockImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getCodeBlock()
	 * @generated
	 */
	int CODE_BLOCK = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.PushImpl <em>Push</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.PushImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getPush()
	 * @generated
	 */
	int PUSH = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.PushtImpl <em>Pusht</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.PushtImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getPusht()
	 * @generated
	 */
	int PUSHT = 20;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.PushfImpl <em>Pushf</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.PushfImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getPushf()
	 * @generated
	 */
	int PUSHF = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.PopImpl <em>Pop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.PopImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getPop()
	 * @generated
	 */
	int POP = 22;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.LocalVariableInstructionImpl <em>Local Variable Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.LocalVariableInstructionImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getLocalVariableInstruction()
	 * @generated
	 */
	int LOCAL_VARIABLE_INSTRUCTION = 23;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.LoadImpl <em>Load</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.LoadImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getLoad()
	 * @generated
	 */
	int LOAD = 24;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.StoreImpl <em>Store</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.StoreImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getStore()
	 * @generated
	 */
	int STORE = 25;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.FieldInstructionImpl <em>Field Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.FieldInstructionImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getFieldInstruction()
	 * @generated
	 */
	int FIELD_INSTRUCTION = 26;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.SetImpl <em>Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.SetImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getSet()
	 * @generated
	 */
	int SET = 27;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.GetImpl <em>Get</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.GetImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getGet()
	 * @generated
	 */
	int GET = 28;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.GetTransImpl <em>Get Trans</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.GetTransImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getGetTrans()
	 * @generated
	 */
	int GET_TRANS = 29;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.SetStaticImpl <em>Set Static</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.SetStaticImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getSetStatic()
	 * @generated
	 */
	int SET_STATIC = 30;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.GetStaticImpl <em>Get Static</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.GetStaticImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getGetStatic()
	 * @generated
	 */
	int GET_STATIC = 31;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.FindtypeImpl <em>Findtype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.FindtypeImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getFindtype()
	 * @generated
	 */
	int FINDTYPE = 32;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.FindtypeSImpl <em>Findtype S</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.FindtypeSImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getFindtypeS()
	 * @generated
	 */
	int FINDTYPE_S = 33;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.NewImpl <em>New</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.NewImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getNew()
	 * @generated
	 */
	int NEW = 34;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.NewSImpl <em>New S</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.NewSImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getNewS()
	 * @generated
	 */
	int NEW_S = 35;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.DeleteImpl <em>Delete</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.DeleteImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getDelete()
	 * @generated
	 */
	int DELETE = 36;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.DupImpl <em>Dup</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.DupImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getDup()
	 * @generated
	 */
	int DUP = 37;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.DupX1Impl <em>Dup X1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.DupX1Impl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getDupX1()
	 * @generated
	 */
	int DUP_X1 = 38;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.SwapImpl <em>Swap</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.SwapImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getSwap()
	 * @generated
	 */
	int SWAP = 39;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.BranchInstructionImpl <em>Branch Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.BranchInstructionImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getBranchInstruction()
	 * @generated
	 */
	int BRANCH_INSTRUCTION = 41;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.IfImpl <em>If</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.IfImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getIf()
	 * @generated
	 */
	int IF = 42;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.IfnImpl <em>Ifn</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.IfnImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getIfn()
	 * @generated
	 */
	int IFN = 43;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.GotoImpl <em>Goto</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.GotoImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getGoto()
	 * @generated
	 */
	int GOTO = 44;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.IterateImpl <em>Iterate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.IterateImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getIterate()
	 * @generated
	 */
	int ITERATE = 45;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.EnditerateImpl <em>Enditerate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.EnditerateImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getEnditerate()
	 * @generated
	 */
	int ENDITERATE = 46;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.InvokeInstructionImpl <em>Invoke Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.InvokeInstructionImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getInvokeInstruction()
	 * @generated
	 */
	int INVOKE_INSTRUCTION = 47;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.InvokeImpl <em>Invoke</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.InvokeImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getInvoke()
	 * @generated
	 */
	int INVOKE = 49;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.InvokeSuperImpl <em>Invoke Super</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.InvokeSuperImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getInvokeSuper()
	 * @generated
	 */
	int INVOKE_SUPER = 50;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.InvokeStaticImpl <em>Invoke Static</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.InvokeStaticImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getInvokeStatic()
	 * @generated
	 */
	int INVOKE_STATIC = 51;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.AllinstImpl <em>Allinst</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.AllinstImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getAllinst()
	 * @generated
	 */
	int ALLINST = 52;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.AllinstInImpl <em>Allinst In</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.AllinstInImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getAllinstIn()
	 * @generated
	 */
	int ALLINST_IN = 53;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.MatchImpl <em>Match</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.MatchImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getMatch()
	 * @generated
	 */
	int MATCH = 68;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.NotImpl <em>Not</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.NotImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getNot()
	 * @generated
	 */
	int NOT = 56;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.IsnullImpl <em>Isnull</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.IsnullImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getIsnull()
	 * @generated
	 */
	int ISNULL = 54;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.ExecEnvImpl <em>Exec Env</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.ExecEnvImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getExecEnv()
	 * @generated
	 */
	int EXEC_ENV = 0;

	/**
	 * The feature id for the '<em><b>Meta Models</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_ENV__META_MODELS = 0;

	/**
	 * The feature id for the '<em><b>Input Models</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_ENV__INPUT_MODELS = 1;

	/**
	 * The feature id for the '<em><b>Inout Models</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_ENV__INOUT_MODELS = 2;

	/**
	 * The feature id for the '<em><b>Output Models</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_ENV__OUTPUT_MODELS = 3;

	/**
	 * The feature id for the '<em><b>Modules</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_ENV__MODULES = 4;

	/**
	 * The feature id for the '<em><b>Matches</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_ENV__MATCHES = 5;

	/**
	 * The feature id for the '<em><b>Traces</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_ENV__TRACES = 6;

	/**
	 * The feature id for the '<em><b>Unique Results</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_ENV__UNIQUE_RESULTS = 7;

	/**
	 * The feature id for the '<em><b>Jit Disabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_ENV__JIT_DISABLED = 8;

	/**
	 * The feature id for the '<em><b>Current Phase</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_ENV__CURRENT_PHASE = 9;

	/**
	 * The number of structural features of the '<em>Exec Env</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_ENV_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.ModelImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 1;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__RESOURCE = 0;

	/**
	 * The feature id for the '<em><b>Allow Inter Model References</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ALLOW_INTER_MODEL_REFERENCES = 1;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.MetamodelImpl <em>Metamodel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.MetamodelImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getMetamodel()
	 * @generated
	 */
	int METAMODEL = 2;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL__RESOURCE = MODEL__RESOURCE;

	/**
	 * The feature id for the '<em><b>Allow Inter Model References</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL__ALLOW_INTER_MODEL_REFERENCES = MODEL__ALLOW_INTER_MODEL_REFERENCES;

	/**
	 * The number of structural features of the '<em>Metamodel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_FEATURE_COUNT = MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Source Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__SOURCE_NAME = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__FEATURES = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__RULES = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>EImports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EIMPORTS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__IMPORTS = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Input Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__INPUT_MODELS = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Inout Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__INOUT_MODELS = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Output Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__OUTPUT_MODELS = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.ModelDeclarationImpl <em>Model Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.ModelDeclarationImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getModelDeclaration()
	 * @generated
	 */
	int MODEL_DECLARATION = 4;

	/**
	 * The feature id for the '<em><b>Model Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION__MODEL_NAME = 0;

	/**
	 * The feature id for the '<em><b>Meta Model Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION__META_MODEL_NAME = 1;

	/**
	 * The feature id for the '<em><b>Input Model For</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION__INPUT_MODEL_FOR = 2;

	/**
	 * The feature id for the '<em><b>Inout Model For</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION__INOUT_MODEL_FOR = 3;

	/**
	 * The feature id for the '<em><b>Output Model For</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION__OUTPUT_MODEL_FOR = 4;

	/**
	 * The number of structural features of the '<em>Model Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_FEATURE_COUNT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__ETYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__TYPE_MODEL = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__ETYPE = TYPED_ELEMENT__ETYPE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Type Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__TYPE_MODEL = TYPED_ELEMENT__TYPE_MODEL;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__STATIC = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>EContext</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__ECONTEXT = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Module</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__MODULE = TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__CONTEXT = TYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Context Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__CONTEXT_MODEL = TYPED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__NAME = FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__ETYPE = FEATURE__ETYPE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__TYPE = FEATURE__TYPE;

	/**
	 * The feature id for the '<em><b>Type Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__TYPE_MODEL = FEATURE__TYPE_MODEL;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__STATIC = FEATURE__STATIC;

	/**
	 * The feature id for the '<em><b>EContext</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__ECONTEXT = FEATURE__ECONTEXT;

	/**
	 * The feature id for the '<em><b>Module</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__MODULE = FEATURE__MODULE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__CONTEXT = FEATURE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Context Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__CONTEXT_MODEL = FEATURE__CONTEXT_MODEL;

	/**
	 * The feature id for the '<em><b>Static Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__STATIC_VALUE = FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initialiser</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__INITIALISER = FEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__RULE = FEATURE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_FEATURE_COUNT = FEATURE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__ETYPE = FEATURE__ETYPE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__TYPE = FEATURE__TYPE;

	/**
	 * The feature id for the '<em><b>Type Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__TYPE_MODEL = FEATURE__TYPE_MODEL;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__STATIC = FEATURE__STATIC;

	/**
	 * The feature id for the '<em><b>EContext</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__ECONTEXT = FEATURE__ECONTEXT;

	/**
	 * The feature id for the '<em><b>Module</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__MODULE = FEATURE__MODULE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__CONTEXT = FEATURE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Context Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__CONTEXT_MODEL = FEATURE__CONTEXT_MODEL;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__PARAMETERS = FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__QUERY = FEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__BODY = FEATURE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = FEATURE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__ETYPE = TYPED_ELEMENT__ETYPE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Type Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE_MODEL = TYPED_ELEMENT__TYPE_MODEL;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__OPERATION = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION__OWNING_BLOCK = 0;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION__OPCODE = 1;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION__STACK_PRODUCTION = 2;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION__STACK_CONSUMPTION = 3;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION__STACK_LEVEL = 4;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION__LINE_NUMBER = 5;

	/**
	 * The number of structural features of the '<em>Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_FEATURE_COUNT = 6;

	/**
	 * The feature id for the '<em><b>Start Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_NUMBER__START_LINE = 0;

	/**
	 * The feature id for the '<em><b>Start Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_NUMBER__START_COLUMN = 1;

	/**
	 * The feature id for the '<em><b>End Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_NUMBER__END_LINE = 2;

	/**
	 * The feature id for the '<em><b>End Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_NUMBER__END_COLUMN = 3;

	/**
	 * The feature id for the '<em><b>Start Char</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_NUMBER__START_CHAR = 4;

	/**
	 * The feature id for the '<em><b>End Char</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_NUMBER__END_CHAR = 5;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_NUMBER__OWNING_BLOCK = 6;

	/**
	 * The feature id for the '<em><b>Instructions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_NUMBER__INSTRUCTIONS = 7;

	/**
	 * The number of structural features of the '<em>Line Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_NUMBER_FEATURE_COUNT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE__ETYPE = TYPED_ELEMENT__ETYPE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Type Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE__TYPE_MODEL = TYPED_ELEMENT__TYPE_MODEL;

	/**
	 * The feature id for the '<em><b>Slot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE__SLOT = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE__OWNING_BLOCK = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Start Instruction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE__START_INSTRUCTION = TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>End Instruction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE__END_INSTRUCTION = TYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Start Instruction Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE__START_INSTRUCTION_INDEX = TYPED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>End Instruction Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE__END_INSTRUCTION_INDEX = TYPED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Local Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Module</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__MODULE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__MODE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Input Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__INPUT_ELEMENTS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Output Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__OUTPUT_ELEMENTS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>ESuper Rules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__ESUPER_RULES = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>ESub Rules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__ESUB_RULES = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Matcher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__MATCHER = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Applier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__APPLIER = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Post Apply</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__POST_APPLY = NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Super Rules</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__SUPER_RULES = NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__ABSTRACT = NAMED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__FIELDS = NAMED_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__DEFAULT = NAMED_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Distinct Elements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__DISTINCT_ELEMENTS = NAMED_ELEMENT_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__UNIQUE = NAMED_ELEMENT_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__LEAF = NAMED_ELEMENT_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>With Leaves</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__WITH_LEAVES = NAMED_ELEMENT_FEATURE_COUNT + 16;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_ELEMENT__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_ELEMENT__ETYPE = TYPED_ELEMENT__ETYPE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_ELEMENT__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Type Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_ELEMENT__TYPE_MODEL = TYPED_ELEMENT__TYPE_MODEL;

	/**
	 * The feature id for the '<em><b>Models</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_ELEMENT__MODELS = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>EModels</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_ELEMENT__EMODELS = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Rule Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_ELEMENT_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.InputRuleElementImpl <em>Input Rule Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.InputRuleElementImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getInputRuleElement()
	 * @generated
	 */
	int INPUT_RULE_ELEMENT = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_RULE_ELEMENT__NAME = RULE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_RULE_ELEMENT__ETYPE = RULE_ELEMENT__ETYPE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_RULE_ELEMENT__TYPE = RULE_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Type Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_RULE_ELEMENT__TYPE_MODEL = RULE_ELEMENT__TYPE_MODEL;

	/**
	 * The feature id for the '<em><b>Models</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_RULE_ELEMENT__MODELS = RULE_ELEMENT__MODELS;

	/**
	 * The feature id for the '<em><b>EModels</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_RULE_ELEMENT__EMODELS = RULE_ELEMENT__EMODELS;

	/**
	 * The feature id for the '<em><b>Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_RULE_ELEMENT__BINDING = RULE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input For</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_RULE_ELEMENT__INPUT_FOR = RULE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Input Rule Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_RULE_ELEMENT_FEATURE_COUNT = RULE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.OutputRuleElementImpl <em>Output Rule Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.OutputRuleElementImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getOutputRuleElement()
	 * @generated
	 */
	int OUTPUT_RULE_ELEMENT = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_RULE_ELEMENT__NAME = RULE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_RULE_ELEMENT__ETYPE = RULE_ELEMENT__ETYPE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_RULE_ELEMENT__TYPE = RULE_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Type Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_RULE_ELEMENT__TYPE_MODEL = RULE_ELEMENT__TYPE_MODEL;

	/**
	 * The feature id for the '<em><b>Models</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_RULE_ELEMENT__MODELS = RULE_ELEMENT__MODELS;

	/**
	 * The feature id for the '<em><b>EModels</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_RULE_ELEMENT__EMODELS = RULE_ELEMENT__EMODELS;

	/**
	 * The feature id for the '<em><b>Maps To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_RULE_ELEMENT__MAPS_TO = RULE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output For</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_RULE_ELEMENT__OUTPUT_FOR = RULE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Output Rule Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_RULE_ELEMENT_FEATURE_COUNT = RULE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Max Locals</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK__MAX_LOCALS = 0;

	/**
	 * The feature id for the '<em><b>Max Stack</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK__MAX_STACK = 1;

	/**
	 * The feature id for the '<em><b>Code</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK__CODE = 2;

	/**
	 * The feature id for the '<em><b>Line Numbers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK__LINE_NUMBERS = 3;

	/**
	 * The feature id for the '<em><b>Local Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK__LOCAL_VARIABLES = 4;

	/**
	 * The feature id for the '<em><b>Matcher For</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK__MATCHER_FOR = 5;

	/**
	 * The feature id for the '<em><b>Applier For</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK__APPLIER_FOR = 6;

	/**
	 * The feature id for the '<em><b>Post Apply For</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK__POST_APPLY_FOR = 7;

	/**
	 * The feature id for the '<em><b>Body For</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK__BODY_FOR = 8;

	/**
	 * The feature id for the '<em><b>Initialiser For</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK__INITIALISER_FOR = 9;

	/**
	 * The feature id for the '<em><b>Nested</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK__NESTED = 10;

	/**
	 * The feature id for the '<em><b>Nested For</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK__NESTED_FOR = 11;

	/**
	 * The feature id for the '<em><b>Parent Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK__PARENT_FRAME = 12;

	/**
	 * The feature id for the '<em><b>Binding For</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK__BINDING_FOR = 13;

	/**
	 * The number of structural features of the '<em>Code Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK_FEATURE_COUNT = 14;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH__VALUE = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>String Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH__STRING_VALUE = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Int Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH__INT_VALUE = INSTRUCTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Double Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH__DOUBLE_VALUE = INSTRUCTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Byte Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH__BYTE_VALUE = INSTRUCTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Char Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH__CHAR_VALUE = INSTRUCTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Float Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH__FLOAT_VALUE = INSTRUCTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Short Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH__SHORT_VALUE = INSTRUCTION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Long Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH__LONG_VALUE = INSTRUCTION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Enum Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH__ENUM_VALUE = INSTRUCTION_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Push</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSHT__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSHT__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSHT__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSHT__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSHT__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSHT__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The number of structural features of the '<em>Pusht</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSHT_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSHF__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSHF__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSHF__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSHF__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSHF__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSHF__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The number of structural features of the '<em>Pushf</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSHF_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POP__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POP__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POP__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POP__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POP__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POP__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The number of structural features of the '<em>Pop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POP_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_INSTRUCTION__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_INSTRUCTION__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_INSTRUCTION__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_INSTRUCTION__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_INSTRUCTION__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_INSTRUCTION__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Cb Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_INSTRUCTION__CB_OFFSET = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Slot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_INSTRUCTION__SLOT = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Local Variable Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_INSTRUCTION__LOCAL_VARIABLE_INDEX = INSTRUCTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Local Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_INSTRUCTION__LOCAL_VARIABLE = INSTRUCTION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Local Variable Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_INSTRUCTION_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD__OWNING_BLOCK = LOCAL_VARIABLE_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD__OPCODE = LOCAL_VARIABLE_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD__STACK_PRODUCTION = LOCAL_VARIABLE_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD__STACK_CONSUMPTION = LOCAL_VARIABLE_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD__STACK_LEVEL = LOCAL_VARIABLE_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD__LINE_NUMBER = LOCAL_VARIABLE_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Cb Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD__CB_OFFSET = LOCAL_VARIABLE_INSTRUCTION__CB_OFFSET;

	/**
	 * The feature id for the '<em><b>Slot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD__SLOT = LOCAL_VARIABLE_INSTRUCTION__SLOT;

	/**
	 * The feature id for the '<em><b>Local Variable Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD__LOCAL_VARIABLE_INDEX = LOCAL_VARIABLE_INSTRUCTION__LOCAL_VARIABLE_INDEX;

	/**
	 * The feature id for the '<em><b>Local Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD__LOCAL_VARIABLE = LOCAL_VARIABLE_INSTRUCTION__LOCAL_VARIABLE;

	/**
	 * The number of structural features of the '<em>Load</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_FEATURE_COUNT = LOCAL_VARIABLE_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE__OWNING_BLOCK = LOCAL_VARIABLE_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE__OPCODE = LOCAL_VARIABLE_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE__STACK_PRODUCTION = LOCAL_VARIABLE_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE__STACK_CONSUMPTION = LOCAL_VARIABLE_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE__STACK_LEVEL = LOCAL_VARIABLE_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE__LINE_NUMBER = LOCAL_VARIABLE_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Cb Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE__CB_OFFSET = LOCAL_VARIABLE_INSTRUCTION__CB_OFFSET;

	/**
	 * The feature id for the '<em><b>Slot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE__SLOT = LOCAL_VARIABLE_INSTRUCTION__SLOT;

	/**
	 * The feature id for the '<em><b>Local Variable Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE__LOCAL_VARIABLE_INDEX = LOCAL_VARIABLE_INSTRUCTION__LOCAL_VARIABLE_INDEX;

	/**
	 * The feature id for the '<em><b>Local Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE__LOCAL_VARIABLE = LOCAL_VARIABLE_INSTRUCTION__LOCAL_VARIABLE;

	/**
	 * The number of structural features of the '<em>Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE_FEATURE_COUNT = LOCAL_VARIABLE_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_INSTRUCTION__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_INSTRUCTION__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_INSTRUCTION__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_INSTRUCTION__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_INSTRUCTION__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_INSTRUCTION__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Fieldname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_INSTRUCTION__FIELDNAME = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Field Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_INSTRUCTION_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET__OWNING_BLOCK = FIELD_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET__OPCODE = FIELD_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET__STACK_PRODUCTION = FIELD_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET__STACK_CONSUMPTION = FIELD_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET__STACK_LEVEL = FIELD_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET__LINE_NUMBER = FIELD_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Fieldname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET__FIELDNAME = FIELD_INSTRUCTION__FIELDNAME;

	/**
	 * The number of structural features of the '<em>Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FEATURE_COUNT = FIELD_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET__OWNING_BLOCK = FIELD_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET__OPCODE = FIELD_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET__STACK_PRODUCTION = FIELD_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET__STACK_CONSUMPTION = FIELD_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET__STACK_LEVEL = FIELD_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET__LINE_NUMBER = FIELD_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Fieldname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET__FIELDNAME = FIELD_INSTRUCTION__FIELDNAME;

	/**
	 * The number of structural features of the '<em>Get</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FEATURE_COUNT = FIELD_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TRANS__OWNING_BLOCK = FIELD_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TRANS__OPCODE = FIELD_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TRANS__STACK_PRODUCTION = FIELD_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TRANS__STACK_CONSUMPTION = FIELD_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TRANS__STACK_LEVEL = FIELD_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TRANS__LINE_NUMBER = FIELD_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Fieldname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TRANS__FIELDNAME = FIELD_INSTRUCTION__FIELDNAME;

	/**
	 * The number of structural features of the '<em>Get Trans</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TRANS_FEATURE_COUNT = FIELD_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATIC__OWNING_BLOCK = FIELD_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATIC__OPCODE = FIELD_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATIC__STACK_PRODUCTION = FIELD_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATIC__STACK_CONSUMPTION = FIELD_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATIC__STACK_LEVEL = FIELD_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATIC__LINE_NUMBER = FIELD_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Fieldname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATIC__FIELDNAME = FIELD_INSTRUCTION__FIELDNAME;

	/**
	 * The number of structural features of the '<em>Set Static</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATIC_FEATURE_COUNT = FIELD_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATIC__OWNING_BLOCK = FIELD_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATIC__OPCODE = FIELD_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATIC__STACK_PRODUCTION = FIELD_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATIC__STACK_CONSUMPTION = FIELD_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATIC__STACK_LEVEL = FIELD_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATIC__LINE_NUMBER = FIELD_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Fieldname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATIC__FIELDNAME = FIELD_INSTRUCTION__FIELDNAME;

	/**
	 * The number of structural features of the '<em>Get Static</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATIC_FEATURE_COUNT = FIELD_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDTYPE__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDTYPE__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDTYPE__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDTYPE__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDTYPE__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDTYPE__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Modelname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDTYPE__MODELNAME = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Typename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDTYPE__TYPENAME = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Findtype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDTYPE_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDTYPE_S__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDTYPE_S__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDTYPE_S__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDTYPE_S__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDTYPE_S__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDTYPE_S__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The number of structural features of the '<em>Findtype S</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDTYPE_S_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Modelname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW__MODELNAME = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>New</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_S__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_S__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_S__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_S__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_S__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_S__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The number of structural features of the '<em>New S</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_S_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The number of structural features of the '<em>Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUP__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUP__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUP__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUP__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUP__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUP__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The number of structural features of the '<em>Dup</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUP_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUP_X1__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUP_X1__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUP_X1__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUP_X1__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUP_X1__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUP_X1__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The number of structural features of the '<em>Dup X1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUP_X1_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The number of structural features of the '<em>Swap</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.SwapX1Impl <em>Swap X1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.SwapX1Impl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getSwapX1()
	 * @generated
	 */
	int SWAP_X1 = 40;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_X1__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_X1__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_X1__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_X1__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_X1__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_X1__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The number of structural features of the '<em>Swap X1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_X1_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_INSTRUCTION__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_INSTRUCTION__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_INSTRUCTION__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_INSTRUCTION__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_INSTRUCTION__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_INSTRUCTION__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_INSTRUCTION__OFFSET = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_INSTRUCTION__TARGET = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Branch Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_INSTRUCTION_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__OWNING_BLOCK = BRANCH_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__OPCODE = BRANCH_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__STACK_PRODUCTION = BRANCH_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__STACK_CONSUMPTION = BRANCH_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__STACK_LEVEL = BRANCH_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__LINE_NUMBER = BRANCH_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__OFFSET = BRANCH_INSTRUCTION__OFFSET;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__TARGET = BRANCH_INSTRUCTION__TARGET;

	/**
	 * The number of structural features of the '<em>If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_FEATURE_COUNT = BRANCH_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFN__OWNING_BLOCK = BRANCH_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFN__OPCODE = BRANCH_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFN__STACK_PRODUCTION = BRANCH_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFN__STACK_CONSUMPTION = BRANCH_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFN__STACK_LEVEL = BRANCH_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFN__LINE_NUMBER = BRANCH_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFN__OFFSET = BRANCH_INSTRUCTION__OFFSET;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFN__TARGET = BRANCH_INSTRUCTION__TARGET;

	/**
	 * The number of structural features of the '<em>Ifn</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFN_FEATURE_COUNT = BRANCH_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__OWNING_BLOCK = BRANCH_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__OPCODE = BRANCH_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__STACK_PRODUCTION = BRANCH_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__STACK_CONSUMPTION = BRANCH_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__STACK_LEVEL = BRANCH_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__LINE_NUMBER = BRANCH_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__OFFSET = BRANCH_INSTRUCTION__OFFSET;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__TARGET = BRANCH_INSTRUCTION__TARGET;

	/**
	 * The number of structural features of the '<em>Goto</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_FEATURE_COUNT = BRANCH_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE__OWNING_BLOCK = BRANCH_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE__OPCODE = BRANCH_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE__STACK_PRODUCTION = BRANCH_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE__STACK_CONSUMPTION = BRANCH_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE__STACK_LEVEL = BRANCH_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE__LINE_NUMBER = BRANCH_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE__OFFSET = BRANCH_INSTRUCTION__OFFSET;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE__TARGET = BRANCH_INSTRUCTION__TARGET;

	/**
	 * The number of structural features of the '<em>Iterate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_FEATURE_COUNT = BRANCH_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDITERATE__OWNING_BLOCK = BRANCH_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDITERATE__OPCODE = BRANCH_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDITERATE__STACK_PRODUCTION = BRANCH_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDITERATE__STACK_CONSUMPTION = BRANCH_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDITERATE__STACK_LEVEL = BRANCH_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDITERATE__LINE_NUMBER = BRANCH_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDITERATE__OFFSET = BRANCH_INSTRUCTION__OFFSET;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDITERATE__TARGET = BRANCH_INSTRUCTION__TARGET;

	/**
	 * The number of structural features of the '<em>Enditerate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDITERATE_FEATURE_COUNT = BRANCH_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_INSTRUCTION__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_INSTRUCTION__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_INSTRUCTION__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_INSTRUCTION__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_INSTRUCTION__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_INSTRUCTION__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Argcount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_INSTRUCTION__ARGCOUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Invoke Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_INSTRUCTION_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.InvokeOperationInstructionImpl <em>Invoke Operation Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.InvokeOperationInstructionImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getInvokeOperationInstruction()
	 * @generated
	 */
	int INVOKE_OPERATION_INSTRUCTION = 48;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_OPERATION_INSTRUCTION__OWNING_BLOCK = INVOKE_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_OPERATION_INSTRUCTION__OPCODE = INVOKE_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_OPERATION_INSTRUCTION__STACK_PRODUCTION = INVOKE_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_OPERATION_INSTRUCTION__STACK_CONSUMPTION = INVOKE_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_OPERATION_INSTRUCTION__STACK_LEVEL = INVOKE_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_OPERATION_INSTRUCTION__LINE_NUMBER = INVOKE_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Argcount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_OPERATION_INSTRUCTION__ARGCOUNT = INVOKE_INSTRUCTION__ARGCOUNT;

	/**
	 * The feature id for the '<em><b>Opname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_OPERATION_INSTRUCTION__OPNAME = INVOKE_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Invoke Operation Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_OPERATION_INSTRUCTION_FEATURE_COUNT = INVOKE_INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__OWNING_BLOCK = INVOKE_OPERATION_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__OPCODE = INVOKE_OPERATION_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__STACK_PRODUCTION = INVOKE_OPERATION_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__STACK_CONSUMPTION = INVOKE_OPERATION_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__STACK_LEVEL = INVOKE_OPERATION_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__LINE_NUMBER = INVOKE_OPERATION_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Argcount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__ARGCOUNT = INVOKE_OPERATION_INSTRUCTION__ARGCOUNT;

	/**
	 * The feature id for the '<em><b>Opname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__OPNAME = INVOKE_OPERATION_INSTRUCTION__OPNAME;

	/**
	 * The number of structural features of the '<em>Invoke</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_FEATURE_COUNT = INVOKE_OPERATION_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_SUPER__OWNING_BLOCK = INVOKE_OPERATION_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_SUPER__OPCODE = INVOKE_OPERATION_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_SUPER__STACK_PRODUCTION = INVOKE_OPERATION_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_SUPER__STACK_CONSUMPTION = INVOKE_OPERATION_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_SUPER__STACK_LEVEL = INVOKE_OPERATION_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_SUPER__LINE_NUMBER = INVOKE_OPERATION_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Argcount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_SUPER__ARGCOUNT = INVOKE_OPERATION_INSTRUCTION__ARGCOUNT;

	/**
	 * The feature id for the '<em><b>Opname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_SUPER__OPNAME = INVOKE_OPERATION_INSTRUCTION__OPNAME;

	/**
	 * The number of structural features of the '<em>Invoke Super</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_SUPER_FEATURE_COUNT = INVOKE_OPERATION_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_STATIC__OWNING_BLOCK = INVOKE_OPERATION_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_STATIC__OPCODE = INVOKE_OPERATION_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_STATIC__STACK_PRODUCTION = INVOKE_OPERATION_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_STATIC__STACK_CONSUMPTION = INVOKE_OPERATION_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_STATIC__STACK_LEVEL = INVOKE_OPERATION_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_STATIC__LINE_NUMBER = INVOKE_OPERATION_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Argcount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_STATIC__ARGCOUNT = INVOKE_OPERATION_INSTRUCTION__ARGCOUNT;

	/**
	 * The feature id for the '<em><b>Opname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_STATIC__OPNAME = INVOKE_OPERATION_INSTRUCTION__OPNAME;

	/**
	 * The number of structural features of the '<em>Invoke Static</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_STATIC_FEATURE_COUNT = INVOKE_OPERATION_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLINST__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLINST__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLINST__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLINST__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLINST__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLINST__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The number of structural features of the '<em>Allinst</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLINST_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLINST_IN__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLINST_IN__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLINST_IN__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLINST_IN__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLINST_IN__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLINST_IN__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The number of structural features of the '<em>Allinst In</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLINST_IN_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISNULL__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.MatchSImpl <em>Match S</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.MatchSImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getMatchS()
	 * @generated
	 */
	int MATCH_S = 69;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISNULL__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISNULL__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISNULL__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISNULL__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISNULL__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The number of structural features of the '<em>Isnull</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISNULL_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.GetenvtypeImpl <em>Getenvtype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.GetenvtypeImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getGetenvtype()
	 * @generated
	 */
	int GETENVTYPE = 55;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETENVTYPE__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETENVTYPE__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETENVTYPE__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETENVTYPE__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETENVTYPE__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETENVTYPE__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The number of structural features of the '<em>Getenvtype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETENVTYPE_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The number of structural features of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.AndImpl <em>And</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.AndImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getAnd()
	 * @generated
	 */
	int AND = 57;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.OrImpl <em>Or</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.OrImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getOr()
	 * @generated
	 */
	int OR = 58;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.XorImpl <em>Xor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.XorImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getXor()
	 * @generated
	 */
	int XOR = 59;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.ImpliesImpl <em>Implies</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.ImpliesImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getImplies()
	 * @generated
	 */
	int IMPLIES = 60;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.IfteImpl <em>Ifte</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.IfteImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getIfte()
	 * @generated
	 */
	int IFTE = 61;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.ReturnImpl <em>Return</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.ReturnImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getReturn()
	 * @generated
	 */
	int RETURN = 62;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.CodeBlockInstructionImpl <em>Code Block Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.CodeBlockInstructionImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getCodeBlockInstruction()
	 * @generated
	 */
	int CODE_BLOCK_INSTRUCTION = 63;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK_INSTRUCTION__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK_INSTRUCTION__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK_INSTRUCTION__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK_INSTRUCTION__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK_INSTRUCTION__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK_INSTRUCTION__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Cb Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK_INSTRUCTION__CB_INDEX = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Code Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK_INSTRUCTION__CODE_BLOCK = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Code Block Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK_INSTRUCTION_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__OWNING_BLOCK = CODE_BLOCK_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__OPCODE = CODE_BLOCK_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__STACK_PRODUCTION = CODE_BLOCK_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__STACK_CONSUMPTION = CODE_BLOCK_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__STACK_LEVEL = CODE_BLOCK_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__LINE_NUMBER = CODE_BLOCK_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Cb Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__CB_INDEX = CODE_BLOCK_INSTRUCTION__CB_INDEX;

	/**
	 * The feature id for the '<em><b>Code Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__CODE_BLOCK = CODE_BLOCK_INSTRUCTION__CODE_BLOCK;

	/**
	 * The number of structural features of the '<em>And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_COUNT = CODE_BLOCK_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__OWNING_BLOCK = CODE_BLOCK_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__OPCODE = CODE_BLOCK_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__STACK_PRODUCTION = CODE_BLOCK_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__STACK_CONSUMPTION = CODE_BLOCK_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__STACK_LEVEL = CODE_BLOCK_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__LINE_NUMBER = CODE_BLOCK_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Cb Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__CB_INDEX = CODE_BLOCK_INSTRUCTION__CB_INDEX;

	/**
	 * The feature id for the '<em><b>Code Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__CODE_BLOCK = CODE_BLOCK_INSTRUCTION__CODE_BLOCK;

	/**
	 * The number of structural features of the '<em>Or</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_COUNT = CODE_BLOCK_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The number of structural features of the '<em>Xor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES__OWNING_BLOCK = CODE_BLOCK_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES__OPCODE = CODE_BLOCK_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES__STACK_PRODUCTION = CODE_BLOCK_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES__STACK_CONSUMPTION = CODE_BLOCK_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES__STACK_LEVEL = CODE_BLOCK_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES__LINE_NUMBER = CODE_BLOCK_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Cb Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES__CB_INDEX = CODE_BLOCK_INSTRUCTION__CB_INDEX;

	/**
	 * The feature id for the '<em><b>Code Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES__CODE_BLOCK = CODE_BLOCK_INSTRUCTION__CODE_BLOCK;

	/**
	 * The number of structural features of the '<em>Implies</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_FEATURE_COUNT = CODE_BLOCK_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFTE__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFTE__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFTE__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFTE__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFTE__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFTE__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Then Cb Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFTE__THEN_CB_INDEX = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Else Cb Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFTE__ELSE_CB_INDEX = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Then Cb</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFTE__THEN_CB = INSTRUCTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Else Cb</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFTE__ELSE_CB = INSTRUCTION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Ifte</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFTE_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The number of structural features of the '<em>Return</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.GetcbImpl <em>Getcb</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.GetcbImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getGetcb()
	 * @generated
	 */
	int GETCB = 64;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETCB__OWNING_BLOCK = CODE_BLOCK_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETCB__OPCODE = CODE_BLOCK_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETCB__STACK_PRODUCTION = CODE_BLOCK_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETCB__STACK_CONSUMPTION = CODE_BLOCK_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETCB__STACK_LEVEL = CODE_BLOCK_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETCB__LINE_NUMBER = CODE_BLOCK_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Cb Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETCB__CB_INDEX = CODE_BLOCK_INSTRUCTION__CB_INDEX;

	/**
	 * The feature id for the '<em><b>Code Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETCB__CODE_BLOCK = CODE_BLOCK_INSTRUCTION__CODE_BLOCK;

	/**
	 * The number of structural features of the '<em>Getcb</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETCB_FEATURE_COUNT = CODE_BLOCK_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.InvokeCbImpl <em>Invoke Cb</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.InvokeCbImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getInvokeCb()
	 * @generated
	 */
	int INVOKE_CB = 66;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.InvokeCbSImpl <em>Invoke Cb S</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.InvokeCbSImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getInvokeCbS()
	 * @generated
	 */
	int INVOKE_CB_S = 67;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.InvokeAllCbsImpl <em>Invoke All Cbs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.InvokeAllCbsImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getInvokeAllCbs()
	 * @generated
	 */
	int INVOKE_ALL_CBS = 65;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_ALL_CBS__OWNING_BLOCK = INVOKE_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_ALL_CBS__OPCODE = INVOKE_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_ALL_CBS__STACK_PRODUCTION = INVOKE_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_ALL_CBS__STACK_CONSUMPTION = INVOKE_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_ALL_CBS__STACK_LEVEL = INVOKE_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_ALL_CBS__LINE_NUMBER = INVOKE_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Argcount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_ALL_CBS__ARGCOUNT = INVOKE_INSTRUCTION__ARGCOUNT;

	/**
	 * The number of structural features of the '<em>Invoke All Cbs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_ALL_CBS_FEATURE_COUNT = INVOKE_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_CB__OWNING_BLOCK = CODE_BLOCK_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_CB__OPCODE = CODE_BLOCK_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_CB__STACK_PRODUCTION = CODE_BLOCK_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_CB__STACK_CONSUMPTION = CODE_BLOCK_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_CB__STACK_LEVEL = CODE_BLOCK_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_CB__LINE_NUMBER = CODE_BLOCK_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Cb Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_CB__CB_INDEX = CODE_BLOCK_INSTRUCTION__CB_INDEX;

	/**
	 * The feature id for the '<em><b>Code Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_CB__CODE_BLOCK = CODE_BLOCK_INSTRUCTION__CODE_BLOCK;

	/**
	 * The feature id for the '<em><b>Argcount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_CB__ARGCOUNT = CODE_BLOCK_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Invoke Cb</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_CB_FEATURE_COUNT = CODE_BLOCK_INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_CB_S__OWNING_BLOCK = INVOKE_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_CB_S__OPCODE = INVOKE_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_CB_S__STACK_PRODUCTION = INVOKE_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_CB_S__STACK_CONSUMPTION = INVOKE_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_CB_S__STACK_LEVEL = INVOKE_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_CB_S__LINE_NUMBER = INVOKE_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Argcount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_CB_S__ARGCOUNT = INVOKE_INSTRUCTION__ARGCOUNT;

	/**
	 * The number of structural features of the '<em>Invoke Cb S</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_CB_S_FEATURE_COUNT = INVOKE_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__OWNING_BLOCK = INVOKE_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__OPCODE = INVOKE_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__STACK_PRODUCTION = INVOKE_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__STACK_CONSUMPTION = INVOKE_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__STACK_LEVEL = INVOKE_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__LINE_NUMBER = INVOKE_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Argcount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__ARGCOUNT = INVOKE_INSTRUCTION__ARGCOUNT;

	/**
	 * The feature id for the '<em><b>Rulename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__RULENAME = INVOKE_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Match</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_FEATURE_COUNT = INVOKE_INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_S__OWNING_BLOCK = INVOKE_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_S__OPCODE = INVOKE_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_S__STACK_PRODUCTION = INVOKE_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_S__STACK_CONSUMPTION = INVOKE_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_S__STACK_LEVEL = INVOKE_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_S__LINE_NUMBER = INVOKE_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Argcount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_S__ARGCOUNT = INVOKE_INSTRUCTION__ARGCOUNT;

	/**
	 * The number of structural features of the '<em>Match S</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_S_FEATURE_COUNT = INVOKE_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.AddImpl <em>Add</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.AddImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getAdd()
	 * @generated
	 */
	int ADD = 70;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__OWNING_BLOCK = FIELD_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__OPCODE = FIELD_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__STACK_PRODUCTION = FIELD_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__STACK_CONSUMPTION = FIELD_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__STACK_LEVEL = FIELD_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__LINE_NUMBER = FIELD_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Fieldname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__FIELDNAME = FIELD_INSTRUCTION__FIELDNAME;

	/**
	 * The number of structural features of the '<em>Add</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FEATURE_COUNT = FIELD_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.RemoveImpl <em>Remove</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.RemoveImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getRemove()
	 * @generated
	 */
	int REMOVE = 71;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE__OWNING_BLOCK = FIELD_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE__OPCODE = FIELD_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE__STACK_PRODUCTION = FIELD_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE__STACK_CONSUMPTION = FIELD_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE__STACK_LEVEL = FIELD_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE__LINE_NUMBER = FIELD_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Fieldname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE__FIELDNAME = FIELD_INSTRUCTION__FIELDNAME;

	/**
	 * The number of structural features of the '<em>Remove</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_FEATURE_COUNT = FIELD_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.InsertImpl <em>Insert</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.InsertImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getInsert()
	 * @generated
	 */
	int INSERT = 72;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSERT__OWNING_BLOCK = FIELD_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSERT__OPCODE = FIELD_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSERT__STACK_PRODUCTION = FIELD_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSERT__STACK_CONSUMPTION = FIELD_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSERT__STACK_LEVEL = FIELD_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSERT__LINE_NUMBER = FIELD_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Fieldname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSERT__FIELDNAME = FIELD_INSTRUCTION__FIELDNAME;

	/**
	 * The number of structural features of the '<em>Insert</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSERT_FEATURE_COUNT = FIELD_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.GetSuperImpl <em>Get Super</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.GetSuperImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getGetSuper()
	 * @generated
	 */
	int GET_SUPER = 73;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SUPER__OWNING_BLOCK = FIELD_INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SUPER__OPCODE = FIELD_INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SUPER__STACK_PRODUCTION = FIELD_INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SUPER__STACK_CONSUMPTION = FIELD_INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SUPER__STACK_LEVEL = FIELD_INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SUPER__LINE_NUMBER = FIELD_INSTRUCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Fieldname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SUPER__FIELDNAME = FIELD_INSTRUCTION__FIELDNAME;

	/**
	 * The number of structural features of the '<em>Get Super</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SUPER_FEATURE_COUNT = FIELD_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.impl.GetenvImpl <em>Getenv</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.GetenvImpl
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getGetenv()
	 * @generated
	 */
	int GETENV = 74;

	/**
	 * The feature id for the '<em><b>Owning Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETENV__OWNING_BLOCK = INSTRUCTION__OWNING_BLOCK;

	/**
	 * The feature id for the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETENV__OPCODE = INSTRUCTION__OPCODE;

	/**
	 * The feature id for the '<em><b>Stack Production</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETENV__STACK_PRODUCTION = INSTRUCTION__STACK_PRODUCTION;

	/**
	 * The feature id for the '<em><b>Stack Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETENV__STACK_CONSUMPTION = INSTRUCTION__STACK_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Stack Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETENV__STACK_LEVEL = INSTRUCTION__STACK_LEVEL;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETENV__LINE_NUMBER = INSTRUCTION__LINE_NUMBER;

	/**
	 * The number of structural features of the '<em>Getenv</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETENV_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.ModelDeclarationTag <em>Model Declaration Tag</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ModelDeclarationTag
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getModelDeclarationTag()
	 * @generated
	 */
	int MODEL_DECLARATION_TAG = 75;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.FeatureTag <em>Feature Tag</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.FeatureTag
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getFeatureTag()
	 * @generated
	 */
	int FEATURE_TAG = 76;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.Opcode <em>Opcode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Opcode
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getOpcode()
	 * @generated
	 */
	int OPCODE = 77;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.RuleMode <em>Rule Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.RuleMode
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getRuleMode()
	 * @generated
	 */
	int RULE_MODE = 78;


	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.ConstantTag <em>Constant Tag</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ConstantTag
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getConstantTag()
	 * @generated
	 */
	int CONSTANT_TAG = 79;


	/**
	 * The meta object id for the '<em>Stack Frame</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.util.StackFrame
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getStackFrame()
	 * @generated
	 */
	int STACK_FRAME = 82;


	/**
	 * The meta object id for the '<em>Method</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.reflect.Method
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getMethod()
	 * @generated
	 */
	int METHOD = 83;

	/**
	 * The meta object id for the '<em>Timing Data</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.util.TimingData
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getTimingData()
	 * @generated
	 */
	int TIMING_DATA = 84;

	/**
	 * The meta object id for the '<em>VM Monitor</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.util.VMMonitor
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getVMMonitor()
	 * @generated
	 */
	int VM_MONITOR = 85;

	/**
	 * The meta object id for the '<em>Lazy Collection</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getLazyCollection()
	 * @generated
	 */
	int LAZY_COLLECTION = 86;

	/**
	 * The meta object id for the '<em>Lazy Bag</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.util.LazyBag
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getLazyBag()
	 * @generated
	 */
	int LAZY_BAG = 87;

	/**
	 * The meta object id for the '<em>Lazy List</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.util.LazyList
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getLazyList()
	 * @generated
	 */
	int LAZY_LIST = 88;

	/**
	 * The meta object id for the '<em>Lazy Ordered Set</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getLazyOrderedSet()
	 * @generated
	 */
	int LAZY_ORDERED_SET = 89;

	/**
	 * The meta object id for the '<em>Lazy Set</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.util.LazySet
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getLazySet()
	 * @generated
	 */
	int LAZY_SET = 90;

	/**
	 * The meta object id for the '<em>EJava Object Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getEJavaObjectArray()
	 * @generated
	 */
	int EJAVA_OBJECT_ARRAY = 91;

	/**
	 * The meta object id for the '<em>EObject Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getEObjectArray()
	 * @generated
	 */
	int EOBJECT_ARRAY = 92;

	/**
	 * The meta object id for the '<em>EBoolean Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getEBooleanArray()
	 * @generated
	 */
	int EBOOLEAN_ARRAY = 93;

	/**
	 * The meta object id for the '<em>EJava Set</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Set
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getEJavaSet()
	 * @generated
	 */
	int EJAVA_SET = 94;

	/**
	 * The meta object id for the '<em>EJava Iterable</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Iterable
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getEJavaIterable()
	 * @generated
	 */
	int EJAVA_ITERABLE = 95;

	/**
	 * The meta object id for the '<em>Class Not Found Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.ClassNotFoundException
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getClassNotFoundException()
	 * @generated
	 */
	int CLASS_NOT_FOUND_EXCEPTION = 96;

	/**
	 * The meta object id for the '<em>Module Resolver</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.util.ModuleResolver
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getModuleResolver()
	 * @generated
	 */
	int MODULE_RESOLVER = 80;


	/**
	 * The meta object id for the '<em>Enum Literal</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.util.EnumLiteral
	 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getEnumLiteral()
	 * @generated
	 */
	int ENUM_LITERAL = 81;


	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Module <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Module
	 * @generated
	 */
	EClass getModule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Module#getSourceName <em>Source Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Name</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Module#getSourceName()
	 * @see #getModule()
	 * @generated
	 */
	EAttribute getModule_SourceName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.emftvm.Module#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Module#getFeatures()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_Features();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.emftvm.Module#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Module#getRules()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_Rules();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.atl.emftvm.Module#getEImports <em>EImports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>EImports</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Module#getEImports()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_EImports();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.m2m.atl.emftvm.Module#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Imports</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Module#getImports()
	 * @see #getModule()
	 * @generated
	 */
	EAttribute getModule_Imports();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.emftvm.Module#getInputModels <em>Input Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Models</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Module#getInputModels()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_InputModels();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.emftvm.Module#getInoutModels <em>Inout Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inout Models</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Module#getInoutModels()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_InoutModels();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.emftvm.Module#getOutputModels <em>Output Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Models</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Module#getOutputModels()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_OutputModels();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.ModelDeclaration <em>Model Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Declaration</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.ModelDeclaration
	 * @generated
	 */
	EClass getModelDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.ModelDeclaration#getModelName <em>Model Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Name</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.ModelDeclaration#getModelName()
	 * @see #getModelDeclaration()
	 * @generated
	 */
	EAttribute getModelDeclaration_ModelName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.ModelDeclaration#getMetaModelName <em>Meta Model Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Meta Model Name</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.ModelDeclaration#getMetaModelName()
	 * @see #getModelDeclaration()
	 * @generated
	 */
	EAttribute getModelDeclaration_MetaModelName();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.ModelDeclaration#getInputModelFor <em>Input Model For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Input Model For</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.ModelDeclaration#getInputModelFor()
	 * @see #getModelDeclaration()
	 * @generated
	 */
	EReference getModelDeclaration_InputModelFor();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.ModelDeclaration#getInoutModelFor <em>Inout Model For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Inout Model For</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.ModelDeclaration#getInoutModelFor()
	 * @see #getModelDeclaration()
	 * @generated
	 */
	EReference getModelDeclaration_InoutModelFor();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.ModelDeclaration#getOutputModelFor <em>Output Model For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Output Model For</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.ModelDeclaration#getOutputModelFor()
	 * @see #getModelDeclaration()
	 * @generated
	 */
	EReference getModelDeclaration_OutputModelFor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Feature#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Feature#isStatic()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Static();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.atl.emftvm.Feature#getEContext <em>EContext</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EContext</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Feature#getEContext()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_EContext();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Feature#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Context</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Feature#getContext()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Context();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Feature#getContextModel <em>Context Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Context Model</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Feature#getContextModel()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_ContextModel();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.Feature#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Module</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Feature#getModule()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Module();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Field <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Field
	 * @generated
	 */
	EClass getField();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Field#getStaticValue <em>Static Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static Value</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Field#getStaticValue()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_StaticValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.atl.emftvm.Field#getInitialiser <em>Initialiser</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initialiser</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Field#getInitialiser()
	 * @see #getField()
	 * @generated
	 */
	EReference getField_Initialiser();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.Field#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Rule</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Field#getRule()
	 * @see #getField()
	 * @generated
	 */
	EReference getField_Rule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.emftvm.Operation#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Operation#getParameters()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Operation#isQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Query</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Operation#isQuery()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_Query();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.atl.emftvm.Operation#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Operation#getBody()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.Parameter#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Operation</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Parameter#getOperation()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Operation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.TypedElement
	 * @generated
	 */
	EClass getTypedElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.atl.emftvm.TypedElement#getEType <em>EType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EType</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.TypedElement#getEType()
	 * @see #getTypedElement()
	 * @generated
	 */
	EReference getTypedElement_EType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.TypedElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.TypedElement#getType()
	 * @see #getTypedElement()
	 * @generated
	 */
	EAttribute getTypedElement_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.TypedElement#getTypeModel <em>Type Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Model</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.TypedElement#getTypeModel()
	 * @see #getTypedElement()
	 * @generated
	 */
	EAttribute getTypedElement_TypeModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Instruction <em>Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instruction</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Instruction
	 * @generated
	 */
	EClass getInstruction();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.Instruction#getOwningBlock <em>Owning Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Block</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Instruction#getOwningBlock()
	 * @see #getInstruction()
	 * @generated
	 */
	EReference getInstruction_OwningBlock();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Instruction#getOpcode <em>Opcode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Opcode</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Instruction#getOpcode()
	 * @see #getInstruction()
	 * @generated
	 */
	EAttribute getInstruction_Opcode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Instruction#getStackProduction <em>Stack Production</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stack Production</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Instruction#getStackProduction()
	 * @see #getInstruction()
	 * @generated
	 */
	EAttribute getInstruction_StackProduction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Instruction#getStackConsumption <em>Stack Consumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stack Consumption</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Instruction#getStackConsumption()
	 * @see #getInstruction()
	 * @generated
	 */
	EAttribute getInstruction_StackConsumption();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Instruction#getStackLevel <em>Stack Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stack Level</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Instruction#getStackLevel()
	 * @see #getInstruction()
	 * @generated
	 */
	EAttribute getInstruction_StackLevel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.atl.emftvm.Instruction#getLineNumber <em>Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Line Number</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Instruction#getLineNumber()
	 * @see #getInstruction()
	 * @generated
	 */
	EReference getInstruction_LineNumber();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.LineNumber <em>Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line Number</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.LineNumber
	 * @generated
	 */
	EClass getLineNumber();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.LineNumber#getStartLine <em>Start Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Line</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.LineNumber#getStartLine()
	 * @see #getLineNumber()
	 * @generated
	 */
	EAttribute getLineNumber_StartLine();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.LineNumber#getStartColumn <em>Start Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Column</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.LineNumber#getStartColumn()
	 * @see #getLineNumber()
	 * @generated
	 */
	EAttribute getLineNumber_StartColumn();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.LineNumber#getEndLine <em>End Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Line</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.LineNumber#getEndLine()
	 * @see #getLineNumber()
	 * @generated
	 */
	EAttribute getLineNumber_EndLine();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.LineNumber#getEndColumn <em>End Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Column</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.LineNumber#getEndColumn()
	 * @see #getLineNumber()
	 * @generated
	 */
	EAttribute getLineNumber_EndColumn();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.LineNumber#getStartChar <em>Start Char</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Char</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.LineNumber#getStartChar()
	 * @see #getLineNumber()
	 * @generated
	 */
	EAttribute getLineNumber_StartChar();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.LineNumber#getEndChar <em>End Char</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Char</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.LineNumber#getEndChar()
	 * @see #getLineNumber()
	 * @generated
	 */
	EAttribute getLineNumber_EndChar();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.LineNumber#getOwningBlock <em>Owning Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Block</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.LineNumber#getOwningBlock()
	 * @see #getLineNumber()
	 * @generated
	 */
	EReference getLineNumber_OwningBlock();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.atl.emftvm.LineNumber#getInstructions <em>Instructions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Instructions</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.LineNumber#getInstructions()
	 * @see #getLineNumber()
	 * @generated
	 */
	EReference getLineNumber_Instructions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.LocalVariable <em>Local Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Variable</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.LocalVariable
	 * @generated
	 */
	EClass getLocalVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getSlot <em>Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slot</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.LocalVariable#getSlot()
	 * @see #getLocalVariable()
	 * @generated
	 */
	EAttribute getLocalVariable_Slot();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getStartInstruction <em>Start Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start Instruction</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.LocalVariable#getStartInstruction()
	 * @see #getLocalVariable()
	 * @generated
	 */
	EReference getLocalVariable_StartInstruction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getEndInstruction <em>End Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End Instruction</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.LocalVariable#getEndInstruction()
	 * @see #getLocalVariable()
	 * @generated
	 */
	EReference getLocalVariable_EndInstruction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getStartInstructionIndex <em>Start Instruction Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Instruction Index</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.LocalVariable#getStartInstructionIndex()
	 * @see #getLocalVariable()
	 * @generated
	 */
	EAttribute getLocalVariable_StartInstructionIndex();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getEndInstructionIndex <em>End Instruction Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Instruction Index</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.LocalVariable#getEndInstructionIndex()
	 * @see #getLocalVariable()
	 * @generated
	 */
	EAttribute getLocalVariable_EndInstructionIndex();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getOwningBlock <em>Owning Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Block</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.LocalVariable#getOwningBlock()
	 * @see #getLocalVariable()
	 * @generated
	 */
	EReference getLocalVariable_OwningBlock();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.Rule#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Module</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getModule()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Module();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Rule#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getMode()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_Mode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.emftvm.Rule#getInputElements <em>Input Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Elements</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getInputElements()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_InputElements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.emftvm.Rule#getOutputElements <em>Output Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Elements</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getOutputElements()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_OutputElements();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.atl.emftvm.Rule#getESuperRules <em>ESuper Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>ESuper Rules</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getESuperRules()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_ESuperRules();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.atl.emftvm.Rule#getESubRules <em>ESub Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>ESub Rules</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getESubRules()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_ESubRules();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.atl.emftvm.Rule#getMatcher <em>Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Matcher</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getMatcher()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Matcher();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.atl.emftvm.Rule#getApplier <em>Applier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Applier</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getApplier()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Applier();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.atl.emftvm.Rule#getPostApply <em>Post Apply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Post Apply</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getPostApply()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_PostApply();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.m2m.atl.emftvm.Rule#getSuperRules <em>Super Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Super Rules</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getSuperRules()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_SuperRules();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Rule#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Rule#isAbstract()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_Abstract();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.emftvm.Rule#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fields</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getFields()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Fields();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Rule#isDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Rule#isDefault()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_Default();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Rule#isDistinctElements <em>Distinct Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Distinct Elements</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Rule#isDistinctElements()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_DistinctElements();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Rule#isUnique <em>Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unique</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Rule#isUnique()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_Unique();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Rule#isLeaf <em>Leaf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Leaf</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Rule#isLeaf()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_Leaf();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Rule#isWithLeaves <em>With Leaves</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>With Leaves</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Rule#isWithLeaves()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_WithLeaves();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.RuleElement <em>Rule Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Element</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.RuleElement
	 * @generated
	 */
	EClass getRuleElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.CodeBlock <em>Code Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Block</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock
	 * @generated
	 */
	EClass getCodeBlock();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getMaxLocals <em>Max Locals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Locals</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getMaxLocals()
	 * @see #getCodeBlock()
	 * @generated
	 */
	EAttribute getCodeBlock_MaxLocals();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getMaxStack <em>Max Stack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Stack</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getMaxStack()
	 * @see #getCodeBlock()
	 * @generated
	 */
	EAttribute getCodeBlock_MaxStack();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Code</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getCode()
	 * @see #getCodeBlock()
	 * @generated
	 */
	EReference getCodeBlock_Code();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getLineNumbers <em>Line Numbers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Line Numbers</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getLineNumbers()
	 * @see #getCodeBlock()
	 * @generated
	 */
	EReference getCodeBlock_LineNumbers();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getLocalVariables <em>Local Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Local Variables</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getLocalVariables()
	 * @see #getCodeBlock()
	 * @generated
	 */
	EReference getCodeBlock_LocalVariables();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getMatcherFor <em>Matcher For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Matcher For</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getMatcherFor()
	 * @see #getCodeBlock()
	 * @generated
	 */
	EReference getCodeBlock_MatcherFor();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getApplierFor <em>Applier For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Applier For</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getApplierFor()
	 * @see #getCodeBlock()
	 * @generated
	 */
	EReference getCodeBlock_ApplierFor();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getPostApplyFor <em>Post Apply For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Post Apply For</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getPostApplyFor()
	 * @see #getCodeBlock()
	 * @generated
	 */
	EReference getCodeBlock_PostApplyFor();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getBodyFor <em>Body For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Body For</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getBodyFor()
	 * @see #getCodeBlock()
	 * @generated
	 */
	EReference getCodeBlock_BodyFor();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getInitialiserFor <em>Initialiser For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Initialiser For</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getInitialiserFor()
	 * @see #getCodeBlock()
	 * @generated
	 */
	EReference getCodeBlock_InitialiserFor();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getNested <em>Nested</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nested</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getNested()
	 * @see #getCodeBlock()
	 * @generated
	 */
	EReference getCodeBlock_Nested();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getNestedFor <em>Nested For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Nested For</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getNestedFor()
	 * @see #getCodeBlock()
	 * @generated
	 */
	EReference getCodeBlock_NestedFor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getParentFrame <em>Parent Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent Frame</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getParentFrame()
	 * @see #getCodeBlock()
	 * @generated
	 */
	EAttribute getCodeBlock_ParentFrame();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getBindingFor <em>Binding For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Binding For</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getBindingFor()
	 * @see #getCodeBlock()
	 * @generated
	 */
	EReference getCodeBlock_BindingFor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Push <em>Push</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Push</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Push
	 * @generated
	 */
	EClass getPush();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Push#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Push#getValue()
	 * @see #getPush()
	 * @generated
	 */
	EAttribute getPush_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Push#getStringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Value</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Push#getStringValue()
	 * @see #getPush()
	 * @generated
	 */
	EAttribute getPush_StringValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Push#getIntValue <em>Int Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Int Value</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Push#getIntValue()
	 * @see #getPush()
	 * @generated
	 */
	EAttribute getPush_IntValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Push#getDoubleValue <em>Double Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Double Value</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Push#getDoubleValue()
	 * @see #getPush()
	 * @generated
	 */
	EAttribute getPush_DoubleValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Push#getByteValue <em>Byte Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Byte Value</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Push#getByteValue()
	 * @see #getPush()
	 * @generated
	 */
	EAttribute getPush_ByteValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Push#getCharValue <em>Char Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Char Value</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Push#getCharValue()
	 * @see #getPush()
	 * @generated
	 */
	EAttribute getPush_CharValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Push#getFloatValue <em>Float Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Float Value</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Push#getFloatValue()
	 * @see #getPush()
	 * @generated
	 */
	EAttribute getPush_FloatValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Push#getShortValue <em>Short Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Short Value</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Push#getShortValue()
	 * @see #getPush()
	 * @generated
	 */
	EAttribute getPush_ShortValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Push#getLongValue <em>Long Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Long Value</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Push#getLongValue()
	 * @see #getPush()
	 * @generated
	 */
	EAttribute getPush_LongValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Push#getEnumValue <em>Enum Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enum Value</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Push#getEnumValue()
	 * @see #getPush()
	 * @generated
	 */
	EAttribute getPush_EnumValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Pusht <em>Pusht</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pusht</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Pusht
	 * @generated
	 */
	EClass getPusht();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Pushf <em>Pushf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pushf</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Pushf
	 * @generated
	 */
	EClass getPushf();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Pop <em>Pop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pop</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Pop
	 * @generated
	 */
	EClass getPop();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.LocalVariableInstruction <em>Local Variable Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Variable Instruction</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.LocalVariableInstruction
	 * @generated
	 */
	EClass getLocalVariableInstruction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.LocalVariableInstruction#getCbOffset <em>Cb Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cb Offset</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.LocalVariableInstruction#getCbOffset()
	 * @see #getLocalVariableInstruction()
	 * @generated
	 */
	EAttribute getLocalVariableInstruction_CbOffset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.LocalVariableInstruction#getSlot <em>Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slot</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.LocalVariableInstruction#getSlot()
	 * @see #getLocalVariableInstruction()
	 * @generated
	 */
	EAttribute getLocalVariableInstruction_Slot();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.LocalVariableInstruction#getLocalVariableIndex <em>Local Variable Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Local Variable Index</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.LocalVariableInstruction#getLocalVariableIndex()
	 * @see #getLocalVariableInstruction()
	 * @generated
	 */
	EAttribute getLocalVariableInstruction_LocalVariableIndex();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.atl.emftvm.LocalVariableInstruction#getLocalVariable <em>Local Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Local Variable</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.LocalVariableInstruction#getLocalVariable()
	 * @see #getLocalVariableInstruction()
	 * @generated
	 */
	EReference getLocalVariableInstruction_LocalVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Load <em>Load</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Load</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Load
	 * @generated
	 */
	EClass getLoad();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Store <em>Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Store</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Store
	 * @generated
	 */
	EClass getStore();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.FieldInstruction <em>Field Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field Instruction</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.FieldInstruction
	 * @generated
	 */
	EClass getFieldInstruction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.FieldInstruction#getFieldname <em>Fieldname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fieldname</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.FieldInstruction#getFieldname()
	 * @see #getFieldInstruction()
	 * @generated
	 */
	EAttribute getFieldInstruction_Fieldname();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Set <em>Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Set
	 * @generated
	 */
	EClass getSet();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Get <em>Get</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Get
	 * @generated
	 */
	EClass getGet();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.GetTrans <em>Get Trans</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Trans</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.GetTrans
	 * @generated
	 */
	EClass getGetTrans();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.SetStatic <em>Set Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Static</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.SetStatic
	 * @generated
	 */
	EClass getSetStatic();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.GetStatic <em>Get Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Static</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.GetStatic
	 * @generated
	 */
	EClass getGetStatic();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Findtype <em>Findtype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Findtype</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Findtype
	 * @generated
	 */
	EClass getFindtype();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Findtype#getModelname <em>Modelname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modelname</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Findtype#getModelname()
	 * @see #getFindtype()
	 * @generated
	 */
	EAttribute getFindtype_Modelname();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Findtype#getTypename <em>Typename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Typename</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Findtype#getTypename()
	 * @see #getFindtype()
	 * @generated
	 */
	EAttribute getFindtype_Typename();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.FindtypeS <em>Findtype S</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Findtype S</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.FindtypeS
	 * @generated
	 */
	EClass getFindtypeS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.New <em>New</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.New
	 * @generated
	 */
	EClass getNew();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.New#getModelname <em>Modelname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modelname</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.New#getModelname()
	 * @see #getNew()
	 * @generated
	 */
	EAttribute getNew_Modelname();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.NewS <em>New S</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New S</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.NewS
	 * @generated
	 */
	EClass getNewS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Delete <em>Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Delete
	 * @generated
	 */
	EClass getDelete();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Dup <em>Dup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dup</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Dup
	 * @generated
	 */
	EClass getDup();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.DupX1 <em>Dup X1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dup X1</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.DupX1
	 * @generated
	 */
	EClass getDupX1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Swap <em>Swap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Swap</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Swap
	 * @generated
	 */
	EClass getSwap();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.SwapX1 <em>Swap X1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Swap X1</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.SwapX1
	 * @generated
	 */
	EClass getSwapX1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.BranchInstruction <em>Branch Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Branch Instruction</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.BranchInstruction
	 * @generated
	 */
	EClass getBranchInstruction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.BranchInstruction#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.BranchInstruction#getOffset()
	 * @see #getBranchInstruction()
	 * @generated
	 */
	EAttribute getBranchInstruction_Offset();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.atl.emftvm.BranchInstruction#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.BranchInstruction#getTarget()
	 * @see #getBranchInstruction()
	 * @generated
	 */
	EReference getBranchInstruction_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.If <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.If
	 * @generated
	 */
	EClass getIf();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Ifn <em>Ifn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ifn</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Ifn
	 * @generated
	 */
	EClass getIfn();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Goto <em>Goto</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goto</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Goto
	 * @generated
	 */
	EClass getGoto();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Iterate <em>Iterate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterate</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Iterate
	 * @generated
	 */
	EClass getIterate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Enditerate <em>Enditerate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enditerate</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Enditerate
	 * @generated
	 */
	EClass getEnditerate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.InvokeInstruction <em>Invoke Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invoke Instruction</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.InvokeInstruction
	 * @generated
	 */
	EClass getInvokeInstruction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.InvokeInstruction#getArgcount <em>Argcount</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Argcount</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.InvokeInstruction#getArgcount()
	 * @see #getInvokeInstruction()
	 * @generated
	 */
	EAttribute getInvokeInstruction_Argcount();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.InvokeOperationInstruction <em>Invoke Operation Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invoke Operation Instruction</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.InvokeOperationInstruction
	 * @generated
	 */
	EClass getInvokeOperationInstruction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.InvokeOperationInstruction#getOpname <em>Opname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Opname</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.InvokeOperationInstruction#getOpname()
	 * @see #getInvokeOperationInstruction()
	 * @generated
	 */
	EAttribute getInvokeOperationInstruction_Opname();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Invoke <em>Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invoke</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Invoke
	 * @generated
	 */
	EClass getInvoke();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.InvokeSuper <em>Invoke Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invoke Super</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.InvokeSuper
	 * @generated
	 */
	EClass getInvokeSuper();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.InvokeStatic <em>Invoke Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invoke Static</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.InvokeStatic
	 * @generated
	 */
	EClass getInvokeStatic();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Allinst <em>Allinst</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Allinst</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Allinst
	 * @generated
	 */
	EClass getAllinst();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.AllinstIn <em>Allinst In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Allinst In</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.AllinstIn
	 * @generated
	 */
	EClass getAllinstIn();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Match <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Match</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Match
	 * @generated
	 */
	EClass getMatch();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Match#getRulename <em>Rulename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rulename</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Match#getRulename()
	 * @see #getMatch()
	 * @generated
	 */
	EAttribute getMatch_Rulename();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.MatchS <em>Match S</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Match S</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.MatchS
	 * @generated
	 */
	EClass getMatchS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Add <em>Add</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Add
	 * @generated
	 */
	EClass getAdd();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Remove <em>Remove</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Remove
	 * @generated
	 */
	EClass getRemove();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Insert <em>Insert</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Insert</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Insert
	 * @generated
	 */
	EClass getInsert();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.GetSuper <em>Get Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Super</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.GetSuper
	 * @generated
	 */
	EClass getGetSuper();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Getenv <em>Getenv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Getenv</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Getenv
	 * @generated
	 */
	EClass getGetenv();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Return <em>Return</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Return</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Return
	 * @generated
	 */
	EClass getReturn();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.CodeBlockInstruction <em>Code Block Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Block Instruction</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlockInstruction
	 * @generated
	 */
	EClass getCodeBlockInstruction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.atl.emftvm.CodeBlockInstruction#getCodeBlock <em>Code Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Code Block</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlockInstruction#getCodeBlock()
	 * @see #getCodeBlockInstruction()
	 * @generated
	 */
	EReference getCodeBlockInstruction_CodeBlock();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.CodeBlockInstruction#getCbIndex <em>Cb Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cb Index</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlockInstruction#getCbIndex()
	 * @see #getCodeBlockInstruction()
	 * @generated
	 */
	EAttribute getCodeBlockInstruction_CbIndex();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Getcb <em>Getcb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Getcb</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Getcb
	 * @generated
	 */
	EClass getGetcb();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.InvokeAllCbs <em>Invoke All Cbs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invoke All Cbs</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.InvokeAllCbs
	 * @generated
	 */
	EClass getInvokeAllCbs();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.InvokeCb <em>Invoke Cb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invoke Cb</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.InvokeCb
	 * @generated
	 */
	EClass getInvokeCb();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.InvokeCbS <em>Invoke Cb S</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invoke Cb S</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.InvokeCbS
	 * @generated
	 */
	EClass getInvokeCbS();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.m2m.atl.emftvm.ModelDeclarationTag <em>Model Declaration Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Model Declaration Tag</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.ModelDeclarationTag
	 * @generated
	 */
	EEnum getModelDeclarationTag();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Not <em>Not</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Not
	 * @generated
	 */
	EClass getNot();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.And <em>And</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.And
	 * @generated
	 */
	EClass getAnd();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Or <em>Or</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Or
	 * @generated
	 */
	EClass getOr();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Xor <em>Xor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xor</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Xor
	 * @generated
	 */
	EClass getXor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Implies <em>Implies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implies</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Implies
	 * @generated
	 */
	EClass getImplies();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Ifte <em>Ifte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ifte</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Ifte
	 * @generated
	 */
	EClass getIfte();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Ifte#getThenCbIndex <em>Then Cb Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Then Cb Index</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Ifte#getThenCbIndex()
	 * @see #getIfte()
	 * @generated
	 */
	EAttribute getIfte_ThenCbIndex();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Ifte#getElseCbIndex <em>Else Cb Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Else Cb Index</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Ifte#getElseCbIndex()
	 * @see #getIfte()
	 * @generated
	 */
	EAttribute getIfte_ElseCbIndex();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.atl.emftvm.Ifte#getThenCb <em>Then Cb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Then Cb</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Ifte#getThenCb()
	 * @see #getIfte()
	 * @generated
	 */
	EReference getIfte_ThenCb();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.atl.emftvm.Ifte#getElseCb <em>Else Cb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Else Cb</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Ifte#getElseCb()
	 * @see #getIfte()
	 * @generated
	 */
	EReference getIfte_ElseCb();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Isnull <em>Isnull</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Isnull</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Isnull
	 * @generated
	 */
	EClass getIsnull();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Getenvtype <em>Getenvtype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Getenvtype</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Getenvtype
	 * @generated
	 */
	EClass getGetenvtype();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.m2m.atl.emftvm.FeatureTag <em>Feature Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Feature Tag</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.FeatureTag
	 * @generated
	 */
	EEnum getFeatureTag();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.ExecEnv <em>Exec Env</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exec Env</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv
	 * @generated
	 */
	EClass getExecEnv();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getModules <em>Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modules</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getModules()
	 * @see #getExecEnv()
	 * @generated
	 */
	EAttribute getExecEnv_Modules();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getMatches <em>Matches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Matches</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getMatches()
	 * @see #getExecEnv()
	 * @generated
	 */
	EReference getExecEnv_Matches();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getTraces <em>Traces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Traces</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getTraces()
	 * @see #getExecEnv()
	 * @generated
	 */
	EReference getExecEnv_Traces();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getUniqueResults <em>Unique Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unique Results</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getUniqueResults()
	 * @see #getExecEnv()
	 * @generated
	 */
	EAttribute getExecEnv_UniqueResults();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#isJitDisabled <em>Jit Disabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jit Disabled</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#isJitDisabled()
	 * @see #getExecEnv()
	 * @generated
	 */
	EAttribute getExecEnv_JitDisabled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getCurrentPhase <em>Current Phase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Phase</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getCurrentPhase()
	 * @see #getExecEnv()
	 * @generated
	 */
	EAttribute getExecEnv_CurrentPhase();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getMetaModels <em>Meta Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Meta Models</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getMetaModels()
	 * @see #getExecEnv()
	 * @generated
	 */
	EAttribute getExecEnv_MetaModels();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getInputModels <em>Input Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input Models</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getInputModels()
	 * @see #getExecEnv()
	 * @generated
	 */
	EAttribute getExecEnv_InputModels();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getInoutModels <em>Inout Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inout Models</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getInoutModels()
	 * @see #getExecEnv()
	 * @generated
	 */
	EAttribute getExecEnv_InoutModels();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getOutputModels <em>Output Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output Models</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getOutputModels()
	 * @see #getExecEnv()
	 * @generated
	 */
	EAttribute getExecEnv_OutputModels();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Model#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Model#getResource()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Resource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.Model#isAllowInterModelReferences <em>Allow Inter Model References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allow Inter Model References</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Model#isAllowInterModelReferences()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_AllowInterModelReferences();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.Metamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metamodel</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Metamodel
	 * @generated
	 */
	EClass getMetamodel();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.m2m.atl.emftvm.RuleElement#getModels <em>Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Models</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.RuleElement#getModels()
	 * @see #getRuleElement()
	 * @generated
	 */
	EAttribute getRuleElement_Models();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.atl.emftvm.RuleElement#getEModels <em>EModels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>EModels</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.RuleElement#getEModels()
	 * @see #getRuleElement()
	 * @generated
	 */
	EReference getRuleElement_EModels();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.InputRuleElement <em>Input Rule Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Rule Element</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.InputRuleElement
	 * @generated
	 */
	EClass getInputRuleElement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.atl.emftvm.InputRuleElement#getBinding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Binding</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.InputRuleElement#getBinding()
	 * @see #getInputRuleElement()
	 * @generated
	 */
	EReference getInputRuleElement_Binding();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.InputRuleElement#getInputFor <em>Input For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Input For</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.InputRuleElement#getInputFor()
	 * @see #getInputRuleElement()
	 * @generated
	 */
	EReference getInputRuleElement_InputFor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.OutputRuleElement <em>Output Rule Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Rule Element</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.OutputRuleElement
	 * @generated
	 */
	EClass getOutputRuleElement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.atl.emftvm.OutputRuleElement#getMapsTo <em>Maps To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Maps To</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.OutputRuleElement#getMapsTo()
	 * @see #getOutputRuleElement()
	 * @generated
	 */
	EReference getOutputRuleElement_MapsTo();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.OutputRuleElement#getOutputFor <em>Output For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Output For</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.OutputRuleElement#getOutputFor()
	 * @see #getOutputRuleElement()
	 * @generated
	 */
	EReference getOutputRuleElement_OutputFor();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.m2m.atl.emftvm.Opcode <em>Opcode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Opcode</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.Opcode
	 * @generated
	 */
	EEnum getOpcode();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.m2m.atl.emftvm.RuleMode <em>Rule Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Rule Mode</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.RuleMode
	 * @generated
	 */
	EEnum getRuleMode();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.m2m.atl.emftvm.ConstantTag <em>Constant Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Constant Tag</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.ConstantTag
	 * @generated
	 */
	EEnum getConstantTag();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.m2m.atl.emftvm.util.StackFrame <em>Stack Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Stack Frame</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.util.StackFrame
	 * @model instanceClass="org.eclipse.m2m.atl.emftvm.util.StackFrame"
	 * @generated
	 */
	EDataType getStackFrame();

	/**
	 * Returns the meta object for data type '{@link java.lang.reflect.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Method</em>'.
	 * @see java.lang.reflect.Method
	 * @model instanceClass="java.lang.reflect.Method"
	 * @generated
	 */
	EDataType getMethod();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.m2m.atl.emftvm.util.TimingData <em>Timing Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Timing Data</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.util.TimingData
	 * @model instanceClass="org.eclipse.m2m.atl.emftvm.util.TimingData"
	 * @generated
	 */
	EDataType getTimingData();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.m2m.atl.emftvm.util.VMMonitor <em>VM Monitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>VM Monitor</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.util.VMMonitor
	 * @model instanceClass="org.eclipse.m2m.atl.emftvm.util.VMMonitor" serializeable="false"
	 * @generated
	 */
	EDataType getVMMonitor();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.m2m.atl.emftvm.util.LazyCollection <em>Lazy Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Lazy Collection</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection
	 * @model instanceClass="org.eclipse.m2m.atl.emftvm.util.LazyCollection" typeParameters="E"
	 * @generated
	 */
	EDataType getLazyCollection();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.m2m.atl.emftvm.util.LazyBag <em>Lazy Bag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Lazy Bag</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.util.LazyBag
	 * @model instanceClass="org.eclipse.m2m.atl.emftvm.util.LazyBag" typeParameters="E"
	 * @generated
	 */
	EDataType getLazyBag();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.m2m.atl.emftvm.util.LazyList <em>Lazy List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Lazy List</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.util.LazyList
	 * @model instanceClass="org.eclipse.m2m.atl.emftvm.util.LazyList" typeParameters="E"
	 * @generated
	 */
	EDataType getLazyList();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet <em>Lazy Ordered Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Lazy Ordered Set</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet
	 * @model instanceClass="org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet" typeParameters="E"
	 * @generated
	 */
	EDataType getLazyOrderedSet();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.m2m.atl.emftvm.util.LazySet <em>Lazy Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Lazy Set</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.util.LazySet
	 * @model instanceClass="org.eclipse.m2m.atl.emftvm.util.LazySet" typeParameters="E"
	 * @generated
	 */
	EDataType getLazySet();

	/**
	 * Returns the meta object for data type '<em>EJava Object Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EJava Object Array</em>'.
	 * @model instanceClass="java.lang.Object[]"
	 * @generated
	 */
	EDataType getEJavaObjectArray();

	/**
	 * Returns the meta object for data type '<em>EObject Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EObject Array</em>'.
	 * @model instanceClass="org.eclipse.emf.ecore.EObject[]"
	 * @generated
	 */
	EDataType getEObjectArray();

	/**
	 * Returns the meta object for data type '<em>EBoolean Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EBoolean Array</em>'.
	 * @model instanceClass="boolean[]"
	 * @generated
	 */
	EDataType getEBooleanArray();

	/**
	 * Returns the meta object for data type '{@link java.util.Set <em>EJava Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EJava Set</em>'.
	 * @see java.util.Set
	 * @model instanceClass="java.util.Set" typeParameters="E"
	 * @generated
	 */
	EDataType getEJavaSet();

	/**
	 * Returns the meta object for data type '{@link java.lang.Iterable <em>EJava Iterable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EJava Iterable</em>'.
	 * @see java.lang.Iterable
	 * @model instanceClass="java.lang.Iterable" typeParameters="E"
	 * @generated
	 */
	EDataType getEJavaIterable();

	/**
	 * Returns the meta object for data type '{@link java.lang.ClassNotFoundException <em>Class Not Found Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Class Not Found Exception</em>'.
	 * @see java.lang.ClassNotFoundException
	 * @model instanceClass="java.lang.ClassNotFoundException"
	 * @generated
	 */
	EDataType getClassNotFoundException();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.m2m.atl.emftvm.util.ModuleResolver <em>Module Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Module Resolver</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.util.ModuleResolver
	 * @model instanceClass="org.eclipse.m2m.atl.emftvm.util.ModuleResolver"
	 * @generated
	 */
	EDataType getModuleResolver();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.m2m.atl.emftvm.util.EnumLiteral <em>Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Enum Literal</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.util.EnumLiteral
	 * @model instanceClass="org.eclipse.m2m.atl.emftvm.util.EnumLiteral"
	 * @generated
	 */
	EDataType getEnumLiteral();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EmftvmFactory getEmftvmFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.ModuleImpl <em>Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.ModuleImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getModule()
		 * @generated
		 */
		EClass MODULE = eINSTANCE.getModule();

		/**
		 * The meta object literal for the '<em><b>Source Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE__SOURCE_NAME = eINSTANCE.getModule_SourceName();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__FEATURES = eINSTANCE.getModule_Features();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__RULES = eINSTANCE.getModule_Rules();

		/**
		 * The meta object literal for the '<em><b>EImports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__EIMPORTS = eINSTANCE.getModule_EImports();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE__IMPORTS = eINSTANCE.getModule_Imports();

		/**
		 * The meta object literal for the '<em><b>Input Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__INPUT_MODELS = eINSTANCE.getModule_InputModels();

		/**
		 * The meta object literal for the '<em><b>Inout Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__INOUT_MODELS = eINSTANCE.getModule_InoutModels();

		/**
		 * The meta object literal for the '<em><b>Output Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__OUTPUT_MODELS = eINSTANCE.getModule_OutputModels();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.ModelDeclarationImpl <em>Model Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.ModelDeclarationImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getModelDeclaration()
		 * @generated
		 */
		EClass MODEL_DECLARATION = eINSTANCE.getModelDeclaration();

		/**
		 * The meta object literal for the '<em><b>Model Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_DECLARATION__MODEL_NAME = eINSTANCE.getModelDeclaration_ModelName();

		/**
		 * The meta object literal for the '<em><b>Meta Model Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_DECLARATION__META_MODEL_NAME = eINSTANCE.getModelDeclaration_MetaModelName();

		/**
		 * The meta object literal for the '<em><b>Input Model For</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_DECLARATION__INPUT_MODEL_FOR = eINSTANCE.getModelDeclaration_InputModelFor();

		/**
		 * The meta object literal for the '<em><b>Inout Model For</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_DECLARATION__INOUT_MODEL_FOR = eINSTANCE.getModelDeclaration_InoutModelFor();

		/**
		 * The meta object literal for the '<em><b>Output Model For</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_DECLARATION__OUTPUT_MODEL_FOR = eINSTANCE.getModelDeclaration_OutputModelFor();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.FeatureImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__STATIC = eINSTANCE.getFeature_Static();

		/**
		 * The meta object literal for the '<em><b>EContext</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__ECONTEXT = eINSTANCE.getFeature_EContext();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__CONTEXT = eINSTANCE.getFeature_Context();

		/**
		 * The meta object literal for the '<em><b>Context Model</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__CONTEXT_MODEL = eINSTANCE.getFeature_ContextModel();

		/**
		 * The meta object literal for the '<em><b>Module</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__MODULE = eINSTANCE.getFeature_Module();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.FieldImpl <em>Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.FieldImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getField()
		 * @generated
		 */
		EClass FIELD = eINSTANCE.getField();

		/**
		 * The meta object literal for the '<em><b>Static Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD__STATIC_VALUE = eINSTANCE.getField_StaticValue();

		/**
		 * The meta object literal for the '<em><b>Initialiser</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIELD__INITIALISER = eINSTANCE.getField_Initialiser();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIELD__RULE = eINSTANCE.getField_Rule();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.OperationImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__PARAMETERS = eINSTANCE.getOperation_Parameters();

		/**
		 * The meta object literal for the '<em><b>Query</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__QUERY = eINSTANCE.getOperation_Query();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__BODY = eINSTANCE.getOperation_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.NamedElementImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.ParameterImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__OPERATION = eINSTANCE.getParameter_Operation();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.TypedElementImpl <em>Typed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.TypedElementImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getTypedElement()
		 * @generated
		 */
		EClass TYPED_ELEMENT = eINSTANCE.getTypedElement();

		/**
		 * The meta object literal for the '<em><b>EType</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT__ETYPE = eINSTANCE.getTypedElement_EType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT__TYPE = eINSTANCE.getTypedElement_Type();

		/**
		 * The meta object literal for the '<em><b>Type Model</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT__TYPE_MODEL = eINSTANCE.getTypedElement_TypeModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.InstructionImpl <em>Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.InstructionImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getInstruction()
		 * @generated
		 */
		EClass INSTRUCTION = eINSTANCE.getInstruction();

		/**
		 * The meta object literal for the '<em><b>Owning Block</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTRUCTION__OWNING_BLOCK = eINSTANCE.getInstruction_OwningBlock();

		/**
		 * The meta object literal for the '<em><b>Opcode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTRUCTION__OPCODE = eINSTANCE.getInstruction_Opcode();

		/**
		 * The meta object literal for the '<em><b>Stack Production</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTRUCTION__STACK_PRODUCTION = eINSTANCE.getInstruction_StackProduction();

		/**
		 * The meta object literal for the '<em><b>Stack Consumption</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTRUCTION__STACK_CONSUMPTION = eINSTANCE.getInstruction_StackConsumption();

		/**
		 * The meta object literal for the '<em><b>Stack Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTRUCTION__STACK_LEVEL = eINSTANCE.getInstruction_StackLevel();

		/**
		 * The meta object literal for the '<em><b>Line Number</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTRUCTION__LINE_NUMBER = eINSTANCE.getInstruction_LineNumber();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.LineNumberImpl <em>Line Number</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.LineNumberImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getLineNumber()
		 * @generated
		 */
		EClass LINE_NUMBER = eINSTANCE.getLineNumber();

		/**
		 * The meta object literal for the '<em><b>Start Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINE_NUMBER__START_LINE = eINSTANCE.getLineNumber_StartLine();

		/**
		 * The meta object literal for the '<em><b>Start Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINE_NUMBER__START_COLUMN = eINSTANCE.getLineNumber_StartColumn();

		/**
		 * The meta object literal for the '<em><b>End Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINE_NUMBER__END_LINE = eINSTANCE.getLineNumber_EndLine();

		/**
		 * The meta object literal for the '<em><b>End Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINE_NUMBER__END_COLUMN = eINSTANCE.getLineNumber_EndColumn();

		/**
		 * The meta object literal for the '<em><b>Start Char</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINE_NUMBER__START_CHAR = eINSTANCE.getLineNumber_StartChar();

		/**
		 * The meta object literal for the '<em><b>End Char</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINE_NUMBER__END_CHAR = eINSTANCE.getLineNumber_EndChar();

		/**
		 * The meta object literal for the '<em><b>Owning Block</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINE_NUMBER__OWNING_BLOCK = eINSTANCE.getLineNumber_OwningBlock();

		/**
		 * The meta object literal for the '<em><b>Instructions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINE_NUMBER__INSTRUCTIONS = eINSTANCE.getLineNumber_Instructions();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.LocalVariableImpl <em>Local Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.LocalVariableImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getLocalVariable()
		 * @generated
		 */
		EClass LOCAL_VARIABLE = eINSTANCE.getLocalVariable();

		/**
		 * The meta object literal for the '<em><b>Slot</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_VARIABLE__SLOT = eINSTANCE.getLocalVariable_Slot();

		/**
		 * The meta object literal for the '<em><b>Start Instruction</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCAL_VARIABLE__START_INSTRUCTION = eINSTANCE.getLocalVariable_StartInstruction();

		/**
		 * The meta object literal for the '<em><b>End Instruction</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCAL_VARIABLE__END_INSTRUCTION = eINSTANCE.getLocalVariable_EndInstruction();

		/**
		 * The meta object literal for the '<em><b>Start Instruction Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_VARIABLE__START_INSTRUCTION_INDEX = eINSTANCE.getLocalVariable_StartInstructionIndex();

		/**
		 * The meta object literal for the '<em><b>End Instruction Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_VARIABLE__END_INSTRUCTION_INDEX = eINSTANCE.getLocalVariable_EndInstructionIndex();

		/**
		 * The meta object literal for the '<em><b>Owning Block</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCAL_VARIABLE__OWNING_BLOCK = eINSTANCE.getLocalVariable_OwningBlock();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.RuleImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Module</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__MODULE = eINSTANCE.getRule_Module();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__MODE = eINSTANCE.getRule_Mode();

		/**
		 * The meta object literal for the '<em><b>Input Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__INPUT_ELEMENTS = eINSTANCE.getRule_InputElements();

		/**
		 * The meta object literal for the '<em><b>Output Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__OUTPUT_ELEMENTS = eINSTANCE.getRule_OutputElements();

		/**
		 * The meta object literal for the '<em><b>ESuper Rules</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__ESUPER_RULES = eINSTANCE.getRule_ESuperRules();

		/**
		 * The meta object literal for the '<em><b>ESub Rules</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__ESUB_RULES = eINSTANCE.getRule_ESubRules();

		/**
		 * The meta object literal for the '<em><b>Matcher</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__MATCHER = eINSTANCE.getRule_Matcher();

		/**
		 * The meta object literal for the '<em><b>Applier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__APPLIER = eINSTANCE.getRule_Applier();

		/**
		 * The meta object literal for the '<em><b>Post Apply</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__POST_APPLY = eINSTANCE.getRule_PostApply();

		/**
		 * The meta object literal for the '<em><b>Super Rules</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__SUPER_RULES = eINSTANCE.getRule_SuperRules();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__ABSTRACT = eINSTANCE.getRule_Abstract();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__FIELDS = eINSTANCE.getRule_Fields();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__DEFAULT = eINSTANCE.getRule_Default();

		/**
		 * The meta object literal for the '<em><b>Distinct Elements</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__DISTINCT_ELEMENTS = eINSTANCE.getRule_DistinctElements();

		/**
		 * The meta object literal for the '<em><b>Unique</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__UNIQUE = eINSTANCE.getRule_Unique();

		/**
		 * The meta object literal for the '<em><b>Leaf</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__LEAF = eINSTANCE.getRule_Leaf();

		/**
		 * The meta object literal for the '<em><b>With Leaves</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__WITH_LEAVES = eINSTANCE.getRule_WithLeaves();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.RuleElementImpl <em>Rule Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.RuleElementImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getRuleElement()
		 * @generated
		 */
		EClass RULE_ELEMENT = eINSTANCE.getRuleElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.CodeBlockImpl <em>Code Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.CodeBlockImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getCodeBlock()
		 * @generated
		 */
		EClass CODE_BLOCK = eINSTANCE.getCodeBlock();

		/**
		 * The meta object literal for the '<em><b>Max Locals</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_BLOCK__MAX_LOCALS = eINSTANCE.getCodeBlock_MaxLocals();

		/**
		 * The meta object literal for the '<em><b>Max Stack</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_BLOCK__MAX_STACK = eINSTANCE.getCodeBlock_MaxStack();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_BLOCK__CODE = eINSTANCE.getCodeBlock_Code();

		/**
		 * The meta object literal for the '<em><b>Line Numbers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_BLOCK__LINE_NUMBERS = eINSTANCE.getCodeBlock_LineNumbers();

		/**
		 * The meta object literal for the '<em><b>Local Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_BLOCK__LOCAL_VARIABLES = eINSTANCE.getCodeBlock_LocalVariables();

		/**
		 * The meta object literal for the '<em><b>Matcher For</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_BLOCK__MATCHER_FOR = eINSTANCE.getCodeBlock_MatcherFor();

		/**
		 * The meta object literal for the '<em><b>Applier For</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_BLOCK__APPLIER_FOR = eINSTANCE.getCodeBlock_ApplierFor();

		/**
		 * The meta object literal for the '<em><b>Post Apply For</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_BLOCK__POST_APPLY_FOR = eINSTANCE.getCodeBlock_PostApplyFor();

		/**
		 * The meta object literal for the '<em><b>Body For</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_BLOCK__BODY_FOR = eINSTANCE.getCodeBlock_BodyFor();

		/**
		 * The meta object literal for the '<em><b>Initialiser For</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_BLOCK__INITIALISER_FOR = eINSTANCE.getCodeBlock_InitialiserFor();

		/**
		 * The meta object literal for the '<em><b>Nested</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_BLOCK__NESTED = eINSTANCE.getCodeBlock_Nested();

		/**
		 * The meta object literal for the '<em><b>Nested For</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_BLOCK__NESTED_FOR = eINSTANCE.getCodeBlock_NestedFor();

		/**
		 * The meta object literal for the '<em><b>Parent Frame</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_BLOCK__PARENT_FRAME = eINSTANCE.getCodeBlock_ParentFrame();

		/**
		 * The meta object literal for the '<em><b>Binding For</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_BLOCK__BINDING_FOR = eINSTANCE.getCodeBlock_BindingFor();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.PushImpl <em>Push</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.PushImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getPush()
		 * @generated
		 */
		EClass PUSH = eINSTANCE.getPush();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUSH__VALUE = eINSTANCE.getPush_Value();

		/**
		 * The meta object literal for the '<em><b>String Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUSH__STRING_VALUE = eINSTANCE.getPush_StringValue();

		/**
		 * The meta object literal for the '<em><b>Int Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUSH__INT_VALUE = eINSTANCE.getPush_IntValue();

		/**
		 * The meta object literal for the '<em><b>Double Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUSH__DOUBLE_VALUE = eINSTANCE.getPush_DoubleValue();

		/**
		 * The meta object literal for the '<em><b>Byte Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUSH__BYTE_VALUE = eINSTANCE.getPush_ByteValue();

		/**
		 * The meta object literal for the '<em><b>Char Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUSH__CHAR_VALUE = eINSTANCE.getPush_CharValue();

		/**
		 * The meta object literal for the '<em><b>Float Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUSH__FLOAT_VALUE = eINSTANCE.getPush_FloatValue();

		/**
		 * The meta object literal for the '<em><b>Short Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUSH__SHORT_VALUE = eINSTANCE.getPush_ShortValue();

		/**
		 * The meta object literal for the '<em><b>Long Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUSH__LONG_VALUE = eINSTANCE.getPush_LongValue();

		/**
		 * The meta object literal for the '<em><b>Enum Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUSH__ENUM_VALUE = eINSTANCE.getPush_EnumValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.PushtImpl <em>Pusht</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.PushtImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getPusht()
		 * @generated
		 */
		EClass PUSHT = eINSTANCE.getPusht();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.PushfImpl <em>Pushf</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.PushfImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getPushf()
		 * @generated
		 */
		EClass PUSHF = eINSTANCE.getPushf();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.PopImpl <em>Pop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.PopImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getPop()
		 * @generated
		 */
		EClass POP = eINSTANCE.getPop();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.LocalVariableInstructionImpl <em>Local Variable Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.LocalVariableInstructionImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getLocalVariableInstruction()
		 * @generated
		 */
		EClass LOCAL_VARIABLE_INSTRUCTION = eINSTANCE.getLocalVariableInstruction();

		/**
		 * The meta object literal for the '<em><b>Cb Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_VARIABLE_INSTRUCTION__CB_OFFSET = eINSTANCE.getLocalVariableInstruction_CbOffset();

		/**
		 * The meta object literal for the '<em><b>Slot</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_VARIABLE_INSTRUCTION__SLOT = eINSTANCE.getLocalVariableInstruction_Slot();

		/**
		 * The meta object literal for the '<em><b>Local Variable Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_VARIABLE_INSTRUCTION__LOCAL_VARIABLE_INDEX = eINSTANCE.getLocalVariableInstruction_LocalVariableIndex();

		/**
		 * The meta object literal for the '<em><b>Local Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCAL_VARIABLE_INSTRUCTION__LOCAL_VARIABLE = eINSTANCE.getLocalVariableInstruction_LocalVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.LoadImpl <em>Load</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.LoadImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getLoad()
		 * @generated
		 */
		EClass LOAD = eINSTANCE.getLoad();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.StoreImpl <em>Store</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.StoreImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getStore()
		 * @generated
		 */
		EClass STORE = eINSTANCE.getStore();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.FieldInstructionImpl <em>Field Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.FieldInstructionImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getFieldInstruction()
		 * @generated
		 */
		EClass FIELD_INSTRUCTION = eINSTANCE.getFieldInstruction();

		/**
		 * The meta object literal for the '<em><b>Fieldname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD_INSTRUCTION__FIELDNAME = eINSTANCE.getFieldInstruction_Fieldname();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.SetImpl <em>Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.SetImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getSet()
		 * @generated
		 */
		EClass SET = eINSTANCE.getSet();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.GetImpl <em>Get</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.GetImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getGet()
		 * @generated
		 */
		EClass GET = eINSTANCE.getGet();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.GetTransImpl <em>Get Trans</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.GetTransImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getGetTrans()
		 * @generated
		 */
		EClass GET_TRANS = eINSTANCE.getGetTrans();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.SetStaticImpl <em>Set Static</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.SetStaticImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getSetStatic()
		 * @generated
		 */
		EClass SET_STATIC = eINSTANCE.getSetStatic();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.GetStaticImpl <em>Get Static</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.GetStaticImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getGetStatic()
		 * @generated
		 */
		EClass GET_STATIC = eINSTANCE.getGetStatic();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.FindtypeImpl <em>Findtype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.FindtypeImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getFindtype()
		 * @generated
		 */
		EClass FINDTYPE = eINSTANCE.getFindtype();

		/**
		 * The meta object literal for the '<em><b>Modelname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FINDTYPE__MODELNAME = eINSTANCE.getFindtype_Modelname();

		/**
		 * The meta object literal for the '<em><b>Typename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FINDTYPE__TYPENAME = eINSTANCE.getFindtype_Typename();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.FindtypeSImpl <em>Findtype S</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.FindtypeSImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getFindtypeS()
		 * @generated
		 */
		EClass FINDTYPE_S = eINSTANCE.getFindtypeS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.NewImpl <em>New</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.NewImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getNew()
		 * @generated
		 */
		EClass NEW = eINSTANCE.getNew();

		/**
		 * The meta object literal for the '<em><b>Modelname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW__MODELNAME = eINSTANCE.getNew_Modelname();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.NewSImpl <em>New S</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.NewSImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getNewS()
		 * @generated
		 */
		EClass NEW_S = eINSTANCE.getNewS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.DeleteImpl <em>Delete</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.DeleteImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getDelete()
		 * @generated
		 */
		EClass DELETE = eINSTANCE.getDelete();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.DupImpl <em>Dup</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.DupImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getDup()
		 * @generated
		 */
		EClass DUP = eINSTANCE.getDup();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.DupX1Impl <em>Dup X1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.DupX1Impl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getDupX1()
		 * @generated
		 */
		EClass DUP_X1 = eINSTANCE.getDupX1();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.SwapImpl <em>Swap</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.SwapImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getSwap()
		 * @generated
		 */
		EClass SWAP = eINSTANCE.getSwap();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.SwapX1Impl <em>Swap X1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.SwapX1Impl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getSwapX1()
		 * @generated
		 */
		EClass SWAP_X1 = eINSTANCE.getSwapX1();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.BranchInstructionImpl <em>Branch Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.BranchInstructionImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getBranchInstruction()
		 * @generated
		 */
		EClass BRANCH_INSTRUCTION = eINSTANCE.getBranchInstruction();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BRANCH_INSTRUCTION__OFFSET = eINSTANCE.getBranchInstruction_Offset();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRANCH_INSTRUCTION__TARGET = eINSTANCE.getBranchInstruction_Target();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.IfImpl <em>If</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.IfImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getIf()
		 * @generated
		 */
		EClass IF = eINSTANCE.getIf();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.IfnImpl <em>Ifn</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.IfnImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getIfn()
		 * @generated
		 */
		EClass IFN = eINSTANCE.getIfn();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.GotoImpl <em>Goto</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.GotoImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getGoto()
		 * @generated
		 */
		EClass GOTO = eINSTANCE.getGoto();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.IterateImpl <em>Iterate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.IterateImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getIterate()
		 * @generated
		 */
		EClass ITERATE = eINSTANCE.getIterate();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.EnditerateImpl <em>Enditerate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.EnditerateImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getEnditerate()
		 * @generated
		 */
		EClass ENDITERATE = eINSTANCE.getEnditerate();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.InvokeInstructionImpl <em>Invoke Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.InvokeInstructionImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getInvokeInstruction()
		 * @generated
		 */
		EClass INVOKE_INSTRUCTION = eINSTANCE.getInvokeInstruction();

		/**
		 * The meta object literal for the '<em><b>Argcount</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVOKE_INSTRUCTION__ARGCOUNT = eINSTANCE.getInvokeInstruction_Argcount();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.InvokeOperationInstructionImpl <em>Invoke Operation Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.InvokeOperationInstructionImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getInvokeOperationInstruction()
		 * @generated
		 */
		EClass INVOKE_OPERATION_INSTRUCTION = eINSTANCE.getInvokeOperationInstruction();

		/**
		 * The meta object literal for the '<em><b>Opname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVOKE_OPERATION_INSTRUCTION__OPNAME = eINSTANCE.getInvokeOperationInstruction_Opname();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.InvokeImpl <em>Invoke</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.InvokeImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getInvoke()
		 * @generated
		 */
		EClass INVOKE = eINSTANCE.getInvoke();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.InvokeSuperImpl <em>Invoke Super</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.InvokeSuperImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getInvokeSuper()
		 * @generated
		 */
		EClass INVOKE_SUPER = eINSTANCE.getInvokeSuper();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.InvokeStaticImpl <em>Invoke Static</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.InvokeStaticImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getInvokeStatic()
		 * @generated
		 */
		EClass INVOKE_STATIC = eINSTANCE.getInvokeStatic();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.AllinstImpl <em>Allinst</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.AllinstImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getAllinst()
		 * @generated
		 */
		EClass ALLINST = eINSTANCE.getAllinst();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.AllinstInImpl <em>Allinst In</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.AllinstInImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getAllinstIn()
		 * @generated
		 */
		EClass ALLINST_IN = eINSTANCE.getAllinstIn();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.MatchImpl <em>Match</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.MatchImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getMatch()
		 * @generated
		 */
		EClass MATCH = eINSTANCE.getMatch();

		/**
		 * The meta object literal for the '<em><b>Rulename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH__RULENAME = eINSTANCE.getMatch_Rulename();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.MatchSImpl <em>Match S</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.MatchSImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getMatchS()
		 * @generated
		 */
		EClass MATCH_S = eINSTANCE.getMatchS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.AddImpl <em>Add</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.AddImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getAdd()
		 * @generated
		 */
		EClass ADD = eINSTANCE.getAdd();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.RemoveImpl <em>Remove</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.RemoveImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getRemove()
		 * @generated
		 */
		EClass REMOVE = eINSTANCE.getRemove();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.InsertImpl <em>Insert</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.InsertImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getInsert()
		 * @generated
		 */
		EClass INSERT = eINSTANCE.getInsert();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.GetSuperImpl <em>Get Super</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.GetSuperImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getGetSuper()
		 * @generated
		 */
		EClass GET_SUPER = eINSTANCE.getGetSuper();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.GetenvImpl <em>Getenv</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.GetenvImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getGetenv()
		 * @generated
		 */
		EClass GETENV = eINSTANCE.getGetenv();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.InvokeAllCbsImpl <em>Invoke All Cbs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.InvokeAllCbsImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getInvokeAllCbs()
		 * @generated
		 */
		EClass INVOKE_ALL_CBS = eINSTANCE.getInvokeAllCbs();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.ReturnImpl <em>Return</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.ReturnImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getReturn()
		 * @generated
		 */
		EClass RETURN = eINSTANCE.getReturn();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.CodeBlockInstructionImpl <em>Code Block Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.CodeBlockInstructionImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getCodeBlockInstruction()
		 * @generated
		 */
		EClass CODE_BLOCK_INSTRUCTION = eINSTANCE.getCodeBlockInstruction();

		/**
		 * The meta object literal for the '<em><b>Code Block</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_BLOCK_INSTRUCTION__CODE_BLOCK = eINSTANCE.getCodeBlockInstruction_CodeBlock();

		/**
		 * The meta object literal for the '<em><b>Cb Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_BLOCK_INSTRUCTION__CB_INDEX = eINSTANCE.getCodeBlockInstruction_CbIndex();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.GetcbImpl <em>Getcb</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.GetcbImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getGetcb()
		 * @generated
		 */
		EClass GETCB = eINSTANCE.getGetcb();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.InvokeCbImpl <em>Invoke Cb</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.InvokeCbImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getInvokeCb()
		 * @generated
		 */
		EClass INVOKE_CB = eINSTANCE.getInvokeCb();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.InvokeCbSImpl <em>Invoke Cb S</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.InvokeCbSImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getInvokeCbS()
		 * @generated
		 */
		EClass INVOKE_CB_S = eINSTANCE.getInvokeCbS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.ModelDeclarationTag <em>Model Declaration Tag</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.ModelDeclarationTag
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getModelDeclarationTag()
		 * @generated
		 */
		EEnum MODEL_DECLARATION_TAG = eINSTANCE.getModelDeclarationTag();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.NotImpl <em>Not</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.NotImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getNot()
		 * @generated
		 */
		EClass NOT = eINSTANCE.getNot();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.AndImpl <em>And</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.AndImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getAnd()
		 * @generated
		 */
		EClass AND = eINSTANCE.getAnd();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.OrImpl <em>Or</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.OrImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getOr()
		 * @generated
		 */
		EClass OR = eINSTANCE.getOr();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.XorImpl <em>Xor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.XorImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getXor()
		 * @generated
		 */
		EClass XOR = eINSTANCE.getXor();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.ImpliesImpl <em>Implies</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.ImpliesImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getImplies()
		 * @generated
		 */
		EClass IMPLIES = eINSTANCE.getImplies();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.IfteImpl <em>Ifte</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.IfteImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getIfte()
		 * @generated
		 */
		EClass IFTE = eINSTANCE.getIfte();

		/**
		 * The meta object literal for the '<em><b>Then Cb Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IFTE__THEN_CB_INDEX = eINSTANCE.getIfte_ThenCbIndex();

		/**
		 * The meta object literal for the '<em><b>Else Cb Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IFTE__ELSE_CB_INDEX = eINSTANCE.getIfte_ElseCbIndex();

		/**
		 * The meta object literal for the '<em><b>Then Cb</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IFTE__THEN_CB = eINSTANCE.getIfte_ThenCb();

		/**
		 * The meta object literal for the '<em><b>Else Cb</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IFTE__ELSE_CB = eINSTANCE.getIfte_ElseCb();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.IsnullImpl <em>Isnull</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.IsnullImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getIsnull()
		 * @generated
		 */
		EClass ISNULL = eINSTANCE.getIsnull();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.GetenvtypeImpl <em>Getenvtype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.GetenvtypeImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getGetenvtype()
		 * @generated
		 */
		EClass GETENVTYPE = eINSTANCE.getGetenvtype();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.FeatureTag <em>Feature Tag</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.FeatureTag
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getFeatureTag()
		 * @generated
		 */
		EEnum FEATURE_TAG = eINSTANCE.getFeatureTag();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.ExecEnvImpl <em>Exec Env</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.ExecEnvImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getExecEnv()
		 * @generated
		 */
		EClass EXEC_ENV = eINSTANCE.getExecEnv();

		/**
		 * The meta object literal for the '<em><b>Modules</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_ENV__MODULES = eINSTANCE.getExecEnv_Modules();

		/**
		 * The meta object literal for the '<em><b>Matches</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXEC_ENV__MATCHES = eINSTANCE.getExecEnv_Matches();

		/**
		 * The meta object literal for the '<em><b>Traces</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXEC_ENV__TRACES = eINSTANCE.getExecEnv_Traces();

		/**
		 * The meta object literal for the '<em><b>Unique Results</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_ENV__UNIQUE_RESULTS = eINSTANCE.getExecEnv_UniqueResults();

		/**
		 * The meta object literal for the '<em><b>Jit Disabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_ENV__JIT_DISABLED = eINSTANCE.getExecEnv_JitDisabled();

		/**
		 * The meta object literal for the '<em><b>Current Phase</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_ENV__CURRENT_PHASE = eINSTANCE.getExecEnv_CurrentPhase();

		/**
		 * The meta object literal for the '<em><b>Meta Models</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_ENV__META_MODELS = eINSTANCE.getExecEnv_MetaModels();

		/**
		 * The meta object literal for the '<em><b>Input Models</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_ENV__INPUT_MODELS = eINSTANCE.getExecEnv_InputModels();

		/**
		 * The meta object literal for the '<em><b>Inout Models</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_ENV__INOUT_MODELS = eINSTANCE.getExecEnv_InoutModels();

		/**
		 * The meta object literal for the '<em><b>Output Models</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_ENV__OUTPUT_MODELS = eINSTANCE.getExecEnv_OutputModels();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.ModelImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__RESOURCE = eINSTANCE.getModel_Resource();

		/**
		 * The meta object literal for the '<em><b>Allow Inter Model References</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__ALLOW_INTER_MODEL_REFERENCES = eINSTANCE.getModel_AllowInterModelReferences();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.MetamodelImpl <em>Metamodel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.MetamodelImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getMetamodel()
		 * @generated
		 */
		EClass METAMODEL = eINSTANCE.getMetamodel();

		/**
		 * The meta object literal for the '<em><b>Models</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_ELEMENT__MODELS = eINSTANCE.getRuleElement_Models();

		/**
		 * The meta object literal for the '<em><b>EModels</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_ELEMENT__EMODELS = eINSTANCE.getRuleElement_EModels();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.InputRuleElementImpl <em>Input Rule Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.InputRuleElementImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getInputRuleElement()
		 * @generated
		 */
		EClass INPUT_RULE_ELEMENT = eINSTANCE.getInputRuleElement();

		/**
		 * The meta object literal for the '<em><b>Binding</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_RULE_ELEMENT__BINDING = eINSTANCE.getInputRuleElement_Binding();

		/**
		 * The meta object literal for the '<em><b>Input For</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_RULE_ELEMENT__INPUT_FOR = eINSTANCE.getInputRuleElement_InputFor();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.impl.OutputRuleElementImpl <em>Output Rule Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.OutputRuleElementImpl
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getOutputRuleElement()
		 * @generated
		 */
		EClass OUTPUT_RULE_ELEMENT = eINSTANCE.getOutputRuleElement();

		/**
		 * The meta object literal for the '<em><b>Maps To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_RULE_ELEMENT__MAPS_TO = eINSTANCE.getOutputRuleElement_MapsTo();

		/**
		 * The meta object literal for the '<em><b>Output For</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_RULE_ELEMENT__OUTPUT_FOR = eINSTANCE.getOutputRuleElement_OutputFor();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.Opcode <em>Opcode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.Opcode
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getOpcode()
		 * @generated
		 */
		EEnum OPCODE = eINSTANCE.getOpcode();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.RuleMode <em>Rule Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.RuleMode
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getRuleMode()
		 * @generated
		 */
		EEnum RULE_MODE = eINSTANCE.getRuleMode();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.ConstantTag <em>Constant Tag</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.ConstantTag
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getConstantTag()
		 * @generated
		 */
		EEnum CONSTANT_TAG = eINSTANCE.getConstantTag();

		/**
		 * The meta object literal for the '<em>Stack Frame</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.util.StackFrame
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getStackFrame()
		 * @generated
		 */
		EDataType STACK_FRAME = eINSTANCE.getStackFrame();

		/**
		 * The meta object literal for the '<em>Method</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.reflect.Method
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getMethod()
		 * @generated
		 */
		EDataType METHOD = eINSTANCE.getMethod();

		/**
		 * The meta object literal for the '<em>Timing Data</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.util.TimingData
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getTimingData()
		 * @generated
		 */
		EDataType TIMING_DATA = eINSTANCE.getTimingData();

		/**
		 * The meta object literal for the '<em>VM Monitor</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.util.VMMonitor
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getVMMonitor()
		 * @generated
		 */
		EDataType VM_MONITOR = eINSTANCE.getVMMonitor();

		/**
		 * The meta object literal for the '<em>Lazy Collection</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getLazyCollection()
		 * @generated
		 */
		EDataType LAZY_COLLECTION = eINSTANCE.getLazyCollection();

		/**
		 * The meta object literal for the '<em>Lazy Bag</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyBag
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getLazyBag()
		 * @generated
		 */
		EDataType LAZY_BAG = eINSTANCE.getLazyBag();

		/**
		 * The meta object literal for the '<em>Lazy List</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyList
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getLazyList()
		 * @generated
		 */
		EDataType LAZY_LIST = eINSTANCE.getLazyList();

		/**
		 * The meta object literal for the '<em>Lazy Ordered Set</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getLazyOrderedSet()
		 * @generated
		 */
		EDataType LAZY_ORDERED_SET = eINSTANCE.getLazyOrderedSet();

		/**
		 * The meta object literal for the '<em>Lazy Set</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.util.LazySet
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getLazySet()
		 * @generated
		 */
		EDataType LAZY_SET = eINSTANCE.getLazySet();

		/**
		 * The meta object literal for the '<em>EJava Object Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getEJavaObjectArray()
		 * @generated
		 */
		EDataType EJAVA_OBJECT_ARRAY = eINSTANCE.getEJavaObjectArray();

		/**
		 * The meta object literal for the '<em>EObject Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getEObjectArray()
		 * @generated
		 */
		EDataType EOBJECT_ARRAY = eINSTANCE.getEObjectArray();

		/**
		 * The meta object literal for the '<em>EBoolean Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getEBooleanArray()
		 * @generated
		 */
		EDataType EBOOLEAN_ARRAY = eINSTANCE.getEBooleanArray();

		/**
		 * The meta object literal for the '<em>EJava Set</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Set
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getEJavaSet()
		 * @generated
		 */
		EDataType EJAVA_SET = eINSTANCE.getEJavaSet();

		/**
		 * The meta object literal for the '<em>EJava Iterable</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Iterable
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getEJavaIterable()
		 * @generated
		 */
		EDataType EJAVA_ITERABLE = eINSTANCE.getEJavaIterable();

		/**
		 * The meta object literal for the '<em>Class Not Found Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.ClassNotFoundException
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getClassNotFoundException()
		 * @generated
		 */
		EDataType CLASS_NOT_FOUND_EXCEPTION = eINSTANCE.getClassNotFoundException();

		/**
		 * The meta object literal for the '<em>Module Resolver</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.util.ModuleResolver
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getModuleResolver()
		 * @generated
		 */
		EDataType MODULE_RESOLVER = eINSTANCE.getModuleResolver();

		/**
		 * The meta object literal for the '<em>Enum Literal</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.util.EnumLiteral
		 * @see org.eclipse.m2m.atl.emftvm.impl.EmftvmPackageImpl#getEnumLiteral()
		 * @generated
		 */
		EDataType ENUM_LITERAL = eINSTANCE.getEnumLiteral();

	}

} //EmftvmPackage
