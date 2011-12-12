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
package org.eclipse.m2m.atl.emftvm.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.emftvm.Add;
import org.eclipse.m2m.atl.emftvm.Allinst;
import org.eclipse.m2m.atl.emftvm.AllinstIn;
import org.eclipse.m2m.atl.emftvm.And;
import org.eclipse.m2m.atl.emftvm.BranchInstruction;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.CodeBlockInstruction;
import org.eclipse.m2m.atl.emftvm.Delete;
import org.eclipse.m2m.atl.emftvm.Dup;
import org.eclipse.m2m.atl.emftvm.DupX1;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Enditerate;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Feature;
import org.eclipse.m2m.atl.emftvm.Field;
import org.eclipse.m2m.atl.emftvm.FieldInstruction;
import org.eclipse.m2m.atl.emftvm.Findtype;
import org.eclipse.m2m.atl.emftvm.FindtypeS;
import org.eclipse.m2m.atl.emftvm.Get;
import org.eclipse.m2m.atl.emftvm.GetStatic;
import org.eclipse.m2m.atl.emftvm.GetSuper;
import org.eclipse.m2m.atl.emftvm.GetTrans;
import org.eclipse.m2m.atl.emftvm.Getcb;
import org.eclipse.m2m.atl.emftvm.Getenvtype;
import org.eclipse.m2m.atl.emftvm.Goto;
import org.eclipse.m2m.atl.emftvm.If;
import org.eclipse.m2m.atl.emftvm.Ifn;
import org.eclipse.m2m.atl.emftvm.Ifte;
import org.eclipse.m2m.atl.emftvm.Implies;
import org.eclipse.m2m.atl.emftvm.InputRuleElement;
import org.eclipse.m2m.atl.emftvm.Insert;
import org.eclipse.m2m.atl.emftvm.Instruction;
import org.eclipse.m2m.atl.emftvm.Invoke;
import org.eclipse.m2m.atl.emftvm.InvokeAllCbs;
import org.eclipse.m2m.atl.emftvm.InvokeCb;
import org.eclipse.m2m.atl.emftvm.InvokeCbS;
import org.eclipse.m2m.atl.emftvm.InvokeInstruction;
import org.eclipse.m2m.atl.emftvm.InvokeOperationInstruction;
import org.eclipse.m2m.atl.emftvm.InvokeStatic;
import org.eclipse.m2m.atl.emftvm.InvokeSuper;
import org.eclipse.m2m.atl.emftvm.Isnull;
import org.eclipse.m2m.atl.emftvm.Iterate;
import org.eclipse.m2m.atl.emftvm.LineNumber;
import org.eclipse.m2m.atl.emftvm.Load;
import org.eclipse.m2m.atl.emftvm.LocalVariable;
import org.eclipse.m2m.atl.emftvm.LocalVariableInstruction;
import org.eclipse.m2m.atl.emftvm.Match;
import org.eclipse.m2m.atl.emftvm.MatchS;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.ModelDeclaration;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.NamedElement;
import org.eclipse.m2m.atl.emftvm.New;
import org.eclipse.m2m.atl.emftvm.NewS;
import org.eclipse.m2m.atl.emftvm.Not;
import org.eclipse.m2m.atl.emftvm.Operation;
import org.eclipse.m2m.atl.emftvm.Or;
import org.eclipse.m2m.atl.emftvm.OutputRuleElement;
import org.eclipse.m2m.atl.emftvm.Parameter;
import org.eclipse.m2m.atl.emftvm.Pop;
import org.eclipse.m2m.atl.emftvm.Push;
import org.eclipse.m2m.atl.emftvm.Pushf;
import org.eclipse.m2m.atl.emftvm.Pusht;
import org.eclipse.m2m.atl.emftvm.Remove;
import org.eclipse.m2m.atl.emftvm.Return;
import org.eclipse.m2m.atl.emftvm.Rule;
import org.eclipse.m2m.atl.emftvm.RuleElement;
import org.eclipse.m2m.atl.emftvm.Set;
import org.eclipse.m2m.atl.emftvm.SetStatic;
import org.eclipse.m2m.atl.emftvm.Store;
import org.eclipse.m2m.atl.emftvm.Swap;
import org.eclipse.m2m.atl.emftvm.SwapX1;
import org.eclipse.m2m.atl.emftvm.TypedElement;
import org.eclipse.m2m.atl.emftvm.Xor;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage
 * @generated
 */
public class EmftvmAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EmftvmPackage modelPackage;

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EmftvmSwitch<Adapter> modelSwitch =
		new EmftvmSwitch<Adapter>() {
			@Override
			public Adapter caseExecEnv(ExecEnv object) {
				return createExecEnvAdapter();
			}
			@Override
			public Adapter caseModel(Model object) {
				return createModelAdapter();
			}
			@Override
			public Adapter caseMetamodel(Metamodel object) {
				return createMetamodelAdapter();
			}
			@Override
			public Adapter caseModule(Module object) {
				return createModuleAdapter();
			}
			@Override
			public Adapter caseModelDeclaration(ModelDeclaration object) {
				return createModelDeclarationAdapter();
			}
			@Override
			public Adapter caseFeature(Feature object) {
				return createFeatureAdapter();
			}
			@Override
			public Adapter caseField(Field object) {
				return createFieldAdapter();
			}
			@Override
			public Adapter caseOperation(Operation object) {
				return createOperationAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter caseTypedElement(TypedElement object) {
				return createTypedElementAdapter();
			}
			@Override
			public Adapter caseInstruction(Instruction object) {
				return createInstructionAdapter();
			}
			@Override
			public Adapter caseLineNumber(LineNumber object) {
				return createLineNumberAdapter();
			}
			@Override
			public Adapter caseLocalVariable(LocalVariable object) {
				return createLocalVariableAdapter();
			}
			@Override
			public Adapter caseRule(Rule object) {
				return createRuleAdapter();
			}
			@Override
			public Adapter caseRuleElement(RuleElement object) {
				return createRuleElementAdapter();
			}
			@Override
			public Adapter caseInputRuleElement(InputRuleElement object) {
				return createInputRuleElementAdapter();
			}
			@Override
			public Adapter caseOutputRuleElement(OutputRuleElement object) {
				return createOutputRuleElementAdapter();
			}
			@Override
			public Adapter caseCodeBlock(CodeBlock object) {
				return createCodeBlockAdapter();
			}
			@Override
			public Adapter casePush(Push object) {
				return createPushAdapter();
			}
			@Override
			public Adapter casePusht(Pusht object) {
				return createPushtAdapter();
			}
			@Override
			public Adapter casePushf(Pushf object) {
				return createPushfAdapter();
			}
			@Override
			public Adapter casePop(Pop object) {
				return createPopAdapter();
			}
			@Override
			public Adapter caseLocalVariableInstruction(LocalVariableInstruction object) {
				return createLocalVariableInstructionAdapter();
			}
			@Override
			public Adapter caseLoad(Load object) {
				return createLoadAdapter();
			}
			@Override
			public Adapter caseStore(Store object) {
				return createStoreAdapter();
			}
			@Override
			public Adapter caseFieldInstruction(FieldInstruction object) {
				return createFieldInstructionAdapter();
			}
			@Override
			public Adapter caseSet(Set object) {
				return createSetAdapter();
			}
			@Override
			public Adapter caseGet(Get object) {
				return createGetAdapter();
			}
			@Override
			public Adapter caseGetTrans(GetTrans object) {
				return createGetTransAdapter();
			}
			@Override
			public Adapter caseSetStatic(SetStatic object) {
				return createSetStaticAdapter();
			}
			@Override
			public Adapter caseGetStatic(GetStatic object) {
				return createGetStaticAdapter();
			}
			@Override
			public Adapter caseFindtype(Findtype object) {
				return createFindtypeAdapter();
			}
			@Override
			public Adapter caseFindtypeS(FindtypeS object) {
				return createFindtypeSAdapter();
			}
			@Override
			public Adapter caseNew(New object) {
				return createNewAdapter();
			}
			@Override
			public Adapter caseNewS(NewS object) {
				return createNewSAdapter();
			}
			@Override
			public Adapter caseDelete(Delete object) {
				return createDeleteAdapter();
			}
			@Override
			public Adapter caseDup(Dup object) {
				return createDupAdapter();
			}
			@Override
			public Adapter caseDupX1(DupX1 object) {
				return createDupX1Adapter();
			}
			@Override
			public Adapter caseSwap(Swap object) {
				return createSwapAdapter();
			}
			@Override
			public Adapter caseSwapX1(SwapX1 object) {
				return createSwapX1Adapter();
			}
			@Override
			public Adapter caseBranchInstruction(BranchInstruction object) {
				return createBranchInstructionAdapter();
			}
			@Override
			public Adapter caseIf(If object) {
				return createIfAdapter();
			}
			@Override
			public Adapter caseIfn(Ifn object) {
				return createIfnAdapter();
			}
			@Override
			public Adapter caseGoto(Goto object) {
				return createGotoAdapter();
			}
			@Override
			public Adapter caseIterate(Iterate object) {
				return createIterateAdapter();
			}
			@Override
			public Adapter caseEnditerate(Enditerate object) {
				return createEnditerateAdapter();
			}
			@Override
			public Adapter caseInvokeInstruction(InvokeInstruction object) {
				return createInvokeInstructionAdapter();
			}
			@Override
			public Adapter caseInvokeOperationInstruction(InvokeOperationInstruction object) {
				return createInvokeOperationInstructionAdapter();
			}
			@Override
			public Adapter caseInvoke(Invoke object) {
				return createInvokeAdapter();
			}
			@Override
			public Adapter caseInvokeSuper(InvokeSuper object) {
				return createInvokeSuperAdapter();
			}
			@Override
			public Adapter caseInvokeStatic(InvokeStatic object) {
				return createInvokeStaticAdapter();
			}
			@Override
			public Adapter caseAllinst(Allinst object) {
				return createAllinstAdapter();
			}
			@Override
			public Adapter caseAllinstIn(AllinstIn object) {
				return createAllinstInAdapter();
			}
			@Override
			public Adapter caseIsnull(Isnull object) {
				return createIsnullAdapter();
			}
			@Override
			public Adapter caseGetenvtype(Getenvtype object) {
				return createGetenvtypeAdapter();
			}
			@Override
			public Adapter caseNot(Not object) {
				return createNotAdapter();
			}
			@Override
			public Adapter caseAnd(And object) {
				return createAndAdapter();
			}
			@Override
			public Adapter caseOr(Or object) {
				return createOrAdapter();
			}
			@Override
			public Adapter caseXor(Xor object) {
				return createXorAdapter();
			}
			@Override
			public Adapter caseImplies(Implies object) {
				return createImpliesAdapter();
			}
			@Override
			public Adapter caseIfte(Ifte object) {
				return createIfteAdapter();
			}
			@Override
			public Adapter caseReturn(Return object) {
				return createReturnAdapter();
			}
			@Override
			public Adapter caseCodeBlockInstruction(CodeBlockInstruction object) {
				return createCodeBlockInstructionAdapter();
			}
			@Override
			public Adapter caseGetcb(Getcb object) {
				return createGetcbAdapter();
			}
			@Override
			public Adapter caseInvokeAllCbs(InvokeAllCbs object) {
				return createInvokeAllCbsAdapter();
			}
			@Override
			public Adapter caseInvokeCb(InvokeCb object) {
				return createInvokeCbAdapter();
			}
			@Override
			public Adapter caseInvokeCbS(InvokeCbS object) {
				return createInvokeCbSAdapter();
			}
			@Override
			public Adapter caseMatch(Match object) {
				return createMatchAdapter();
			}
			@Override
			public Adapter caseMatchS(MatchS object) {
				return createMatchSAdapter();
			}
			@Override
			public Adapter caseAdd(Add object) {
				return createAddAdapter();
			}
			@Override
			public Adapter caseRemove(Remove object) {
				return createRemoveAdapter();
			}
			@Override
			public Adapter caseInsert(Insert object) {
				return createInsertAdapter();
			}
			@Override
			public Adapter caseGetSuper(GetSuper object) {
				return createGetSuperAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmftvmAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EmftvmPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * @param object the object for which to check the type
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Module <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Module
	 * @generated
	 */
	public Adapter createModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.ModelDeclaration <em>Model Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.ModelDeclaration
	 * @generated
	 */
	public Adapter createModelDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Feature
	 * @generated
	 */
	public Adapter createFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Field <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Field
	 * @generated
	 */
	public Adapter createFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Operation
	 * @generated
	 */
	public Adapter createOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.TypedElement
	 * @generated
	 */
	public Adapter createTypedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Instruction <em>Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Instruction
	 * @generated
	 */
	public Adapter createInstructionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.LineNumber <em>Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.LineNumber
	 * @generated
	 */
	public Adapter createLineNumberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.LocalVariable <em>Local Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.LocalVariable
	 * @generated
	 */
	public Adapter createLocalVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Rule
	 * @generated
	 */
	public Adapter createRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.RuleElement <em>Rule Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.RuleElement
	 * @generated
	 */
	public Adapter createRuleElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.InputRuleElement <em>Input Rule Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.InputRuleElement
	 * @generated
	 */
	public Adapter createInputRuleElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.OutputRuleElement <em>Output Rule Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.OutputRuleElement
	 * @generated
	 */
	public Adapter createOutputRuleElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.CodeBlock <em>Code Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock
	 * @generated
	 */
	public Adapter createCodeBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Push <em>Push</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Push
	 * @generated
	 */
	public Adapter createPushAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Pusht <em>Pusht</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Pusht
	 * @generated
	 */
	public Adapter createPushtAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Pushf <em>Pushf</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Pushf
	 * @generated
	 */
	public Adapter createPushfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Pop <em>Pop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Pop
	 * @generated
	 */
	public Adapter createPopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.LocalVariableInstruction <em>Local Variable Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.LocalVariableInstruction
	 * @generated
	 */
	public Adapter createLocalVariableInstructionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Load <em>Load</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Load
	 * @generated
	 */
	public Adapter createLoadAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Store <em>Store</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Store
	 * @generated
	 */
	public Adapter createStoreAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.FieldInstruction <em>Field Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.FieldInstruction
	 * @generated
	 */
	public Adapter createFieldInstructionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Set <em>Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Set
	 * @generated
	 */
	public Adapter createSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Get <em>Get</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Get
	 * @generated
	 */
	public Adapter createGetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.GetTrans <em>Get Trans</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.GetTrans
	 * @generated
	 */
	public Adapter createGetTransAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.SetStatic <em>Set Static</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.SetStatic
	 * @generated
	 */
	public Adapter createSetStaticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.GetStatic <em>Get Static</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.GetStatic
	 * @generated
	 */
	public Adapter createGetStaticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Findtype <em>Findtype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Findtype
	 * @generated
	 */
	public Adapter createFindtypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.FindtypeS <em>Findtype S</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.FindtypeS
	 * @generated
	 */
	public Adapter createFindtypeSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.New <em>New</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.New
	 * @generated
	 */
	public Adapter createNewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.NewS <em>New S</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.NewS
	 * @generated
	 */
	public Adapter createNewSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Delete <em>Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Delete
	 * @generated
	 */
	public Adapter createDeleteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Dup <em>Dup</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Dup
	 * @generated
	 */
	public Adapter createDupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.DupX1 <em>Dup X1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.DupX1
	 * @generated
	 */
	public Adapter createDupX1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Swap <em>Swap</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Swap
	 * @generated
	 */
	public Adapter createSwapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.SwapX1 <em>Swap X1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.SwapX1
	 * @generated
	 */
	public Adapter createSwapX1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.BranchInstruction <em>Branch Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.BranchInstruction
	 * @generated
	 */
	public Adapter createBranchInstructionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.If <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.If
	 * @generated
	 */
	public Adapter createIfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Ifn <em>Ifn</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Ifn
	 * @generated
	 */
	public Adapter createIfnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Goto <em>Goto</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Goto
	 * @generated
	 */
	public Adapter createGotoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Iterate <em>Iterate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Iterate
	 * @generated
	 */
	public Adapter createIterateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Enditerate <em>Enditerate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Enditerate
	 * @generated
	 */
	public Adapter createEnditerateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.InvokeInstruction <em>Invoke Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.InvokeInstruction
	 * @generated
	 */
	public Adapter createInvokeInstructionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.InvokeOperationInstruction <em>Invoke Operation Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.InvokeOperationInstruction
	 * @generated
	 */
	public Adapter createInvokeOperationInstructionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Invoke <em>Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Invoke
	 * @generated
	 */
	public Adapter createInvokeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.InvokeSuper <em>Invoke Super</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.InvokeSuper
	 * @generated
	 */
	public Adapter createInvokeSuperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.InvokeStatic <em>Invoke Static</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.InvokeStatic
	 * @generated
	 */
	public Adapter createInvokeStaticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Allinst <em>Allinst</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Allinst
	 * @generated
	 */
	public Adapter createAllinstAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.AllinstIn <em>Allinst In</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.AllinstIn
	 * @generated
	 */
	public Adapter createAllinstInAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Match <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Match
	 * @generated
	 */
	public Adapter createMatchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.MatchS <em>Match S</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.MatchS
	 * @generated
	 */
	public Adapter createMatchSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Add <em>Add</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Add
	 * @generated
	 */
	public Adapter createAddAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Remove <em>Remove</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Remove
	 * @generated
	 */
	public Adapter createRemoveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Insert <em>Insert</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Insert
	 * @generated
	 */
	public Adapter createInsertAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.GetSuper <em>Get Super</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.GetSuper
	 * @generated
	 */
	public Adapter createGetSuperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Return <em>Return</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Return
	 * @generated
	 */
	public Adapter createReturnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.CodeBlockInstruction <em>Code Block Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlockInstruction
	 * @generated
	 */
	public Adapter createCodeBlockInstructionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Getcb <em>Getcb</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Getcb
	 * @generated
	 */
	public Adapter createGetcbAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.InvokeAllCbs <em>Invoke All Cbs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.InvokeAllCbs
	 * @generated
	 */
	public Adapter createInvokeAllCbsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.InvokeCb <em>Invoke Cb</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.InvokeCb
	 * @generated
	 */
	public Adapter createInvokeCbAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.InvokeCbS <em>Invoke Cb S</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.InvokeCbS
	 * @generated
	 */
	public Adapter createInvokeCbSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Not <em>Not</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Not
	 * @generated
	 */
	public Adapter createNotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.And <em>And</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.And
	 * @generated
	 */
	public Adapter createAndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Or <em>Or</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Or
	 * @generated
	 */
	public Adapter createOrAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Xor <em>Xor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Xor
	 * @generated
	 */
	public Adapter createXorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Implies <em>Implies</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Implies
	 * @generated
	 */
	public Adapter createImpliesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Ifte <em>Ifte</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Ifte
	 * @generated
	 */
	public Adapter createIfteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Isnull <em>Isnull</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Isnull
	 * @generated
	 */
	public Adapter createIsnullAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Getenvtype <em>Getenvtype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Getenvtype
	 * @generated
	 */
	public Adapter createGetenvtypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.ExecEnv <em>Exec Env</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv
	 * @generated
	 */
	public Adapter createExecEnvAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Model
	 * @generated
	 */
	public Adapter createModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.atl.emftvm.Metamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.atl.emftvm.Metamodel
	 * @generated
	 */
	public Adapter createMetamodelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //EmftvmAdapterFactory
