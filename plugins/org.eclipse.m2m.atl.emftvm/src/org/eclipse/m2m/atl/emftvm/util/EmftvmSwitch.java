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


import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.emftvm.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * 
 * @param <T> the switched type
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage
 * @generated
 */
public class EmftvmSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EmftvmPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmftvmSwitch() {
		if (modelPackage == null) {
			modelPackage = EmftvmPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * @param theEObject the object to switch on
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * @param theEClass the {@link EClass} of <pre>theObject</pre>
	 * @param theEObject the object to switch on
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * @param classifierID the classifier ID of the {@link EClass} of <pre>theEObject</pre>
	 * @param theEObject the object to switch on
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EmftvmPackage.EXEC_ENV: {
				ExecEnv execEnv = (ExecEnv)theEObject;
				T result = caseExecEnv(execEnv);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.MODEL: {
				Model model = (Model)theEObject;
				T result = caseModel(model);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.METAMODEL: {
				Metamodel metamodel = (Metamodel)theEObject;
				T result = caseMetamodel(metamodel);
				if (result == null) result = caseModel(metamodel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.MODULE: {
				Module module = (Module)theEObject;
				T result = caseModule(module);
				if (result == null) result = caseNamedElement(module);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.MODEL_DECLARATION: {
				ModelDeclaration modelDeclaration = (ModelDeclaration)theEObject;
				T result = caseModelDeclaration(modelDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.FEATURE: {
				Feature feature = (Feature)theEObject;
				T result = caseFeature(feature);
				if (result == null) result = caseTypedElement(feature);
				if (result == null) result = caseNamedElement(feature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.FIELD: {
				Field field = (Field)theEObject;
				T result = caseField(field);
				if (result == null) result = caseFeature(field);
				if (result == null) result = caseTypedElement(field);
				if (result == null) result = caseNamedElement(field);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.OPERATION: {
				Operation operation = (Operation)theEObject;
				T result = caseOperation(operation);
				if (result == null) result = caseFeature(operation);
				if (result == null) result = caseTypedElement(operation);
				if (result == null) result = caseNamedElement(operation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = caseTypedElement(parameter);
				if (result == null) result = caseNamedElement(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.TYPED_ELEMENT: {
				TypedElement typedElement = (TypedElement)theEObject;
				T result = caseTypedElement(typedElement);
				if (result == null) result = caseNamedElement(typedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.INSTRUCTION: {
				Instruction instruction = (Instruction)theEObject;
				T result = caseInstruction(instruction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.LINE_NUMBER: {
				LineNumber lineNumber = (LineNumber)theEObject;
				T result = caseLineNumber(lineNumber);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.LOCAL_VARIABLE: {
				LocalVariable localVariable = (LocalVariable)theEObject;
				T result = caseLocalVariable(localVariable);
				if (result == null) result = caseTypedElement(localVariable);
				if (result == null) result = caseNamedElement(localVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.RULE: {
				Rule rule = (Rule)theEObject;
				T result = caseRule(rule);
				if (result == null) result = caseNamedElement(rule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.RULE_ELEMENT: {
				RuleElement ruleElement = (RuleElement)theEObject;
				T result = caseRuleElement(ruleElement);
				if (result == null) result = caseTypedElement(ruleElement);
				if (result == null) result = caseNamedElement(ruleElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.INPUT_RULE_ELEMENT: {
				InputRuleElement inputRuleElement = (InputRuleElement)theEObject;
				T result = caseInputRuleElement(inputRuleElement);
				if (result == null) result = caseRuleElement(inputRuleElement);
				if (result == null) result = caseTypedElement(inputRuleElement);
				if (result == null) result = caseNamedElement(inputRuleElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.OUTPUT_RULE_ELEMENT: {
				OutputRuleElement outputRuleElement = (OutputRuleElement)theEObject;
				T result = caseOutputRuleElement(outputRuleElement);
				if (result == null) result = caseRuleElement(outputRuleElement);
				if (result == null) result = caseTypedElement(outputRuleElement);
				if (result == null) result = caseNamedElement(outputRuleElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.CODE_BLOCK: {
				CodeBlock codeBlock = (CodeBlock)theEObject;
				T result = caseCodeBlock(codeBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.PUSH: {
				Push push = (Push)theEObject;
				T result = casePush(push);
				if (result == null) result = caseInstruction(push);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.PUSHT: {
				Pusht pusht = (Pusht)theEObject;
				T result = casePusht(pusht);
				if (result == null) result = caseInstruction(pusht);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.PUSHF: {
				Pushf pushf = (Pushf)theEObject;
				T result = casePushf(pushf);
				if (result == null) result = caseInstruction(pushf);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.POP: {
				Pop pop = (Pop)theEObject;
				T result = casePop(pop);
				if (result == null) result = caseInstruction(pop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.LOCAL_VARIABLE_INSTRUCTION: {
				LocalVariableInstruction localVariableInstruction = (LocalVariableInstruction)theEObject;
				T result = caseLocalVariableInstruction(localVariableInstruction);
				if (result == null) result = caseInstruction(localVariableInstruction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.LOAD: {
				Load load = (Load)theEObject;
				T result = caseLoad(load);
				if (result == null) result = caseLocalVariableInstruction(load);
				if (result == null) result = caseInstruction(load);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.STORE: {
				Store store = (Store)theEObject;
				T result = caseStore(store);
				if (result == null) result = caseLocalVariableInstruction(store);
				if (result == null) result = caseInstruction(store);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.FIELD_INSTRUCTION: {
				FieldInstruction fieldInstruction = (FieldInstruction)theEObject;
				T result = caseFieldInstruction(fieldInstruction);
				if (result == null) result = caseInstruction(fieldInstruction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.SET: {
				Set set = (Set)theEObject;
				T result = caseSet(set);
				if (result == null) result = caseFieldInstruction(set);
				if (result == null) result = caseInstruction(set);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.GET: {
				Get get = (Get)theEObject;
				T result = caseGet(get);
				if (result == null) result = caseFieldInstruction(get);
				if (result == null) result = caseInstruction(get);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.GET_TRANS: {
				GetTrans getTrans = (GetTrans)theEObject;
				T result = caseGetTrans(getTrans);
				if (result == null) result = caseFieldInstruction(getTrans);
				if (result == null) result = caseInstruction(getTrans);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.SET_STATIC: {
				SetStatic setStatic = (SetStatic)theEObject;
				T result = caseSetStatic(setStatic);
				if (result == null) result = caseFieldInstruction(setStatic);
				if (result == null) result = caseInstruction(setStatic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.GET_STATIC: {
				GetStatic getStatic = (GetStatic)theEObject;
				T result = caseGetStatic(getStatic);
				if (result == null) result = caseFieldInstruction(getStatic);
				if (result == null) result = caseInstruction(getStatic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.FINDTYPE: {
				Findtype findtype = (Findtype)theEObject;
				T result = caseFindtype(findtype);
				if (result == null) result = caseInstruction(findtype);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.FINDTYPE_S: {
				FindtypeS findtypeS = (FindtypeS)theEObject;
				T result = caseFindtypeS(findtypeS);
				if (result == null) result = caseInstruction(findtypeS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.NEW: {
				New new_ = (New)theEObject;
				T result = caseNew(new_);
				if (result == null) result = caseInstruction(new_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.NEW_S: {
				NewS newS = (NewS)theEObject;
				T result = caseNewS(newS);
				if (result == null) result = caseInstruction(newS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.DELETE: {
				Delete delete = (Delete)theEObject;
				T result = caseDelete(delete);
				if (result == null) result = caseInstruction(delete);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.DUP: {
				Dup dup = (Dup)theEObject;
				T result = caseDup(dup);
				if (result == null) result = caseInstruction(dup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.DUP_X1: {
				DupX1 dupX1 = (DupX1)theEObject;
				T result = caseDupX1(dupX1);
				if (result == null) result = caseInstruction(dupX1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.SWAP: {
				Swap swap = (Swap)theEObject;
				T result = caseSwap(swap);
				if (result == null) result = caseInstruction(swap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.SWAP_X1: {
				SwapX1 swapX1 = (SwapX1)theEObject;
				T result = caseSwapX1(swapX1);
				if (result == null) result = caseInstruction(swapX1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.BRANCH_INSTRUCTION: {
				BranchInstruction branchInstruction = (BranchInstruction)theEObject;
				T result = caseBranchInstruction(branchInstruction);
				if (result == null) result = caseInstruction(branchInstruction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.IF: {
				If if_ = (If)theEObject;
				T result = caseIf(if_);
				if (result == null) result = caseBranchInstruction(if_);
				if (result == null) result = caseInstruction(if_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.IFN: {
				Ifn ifn = (Ifn)theEObject;
				T result = caseIfn(ifn);
				if (result == null) result = caseBranchInstruction(ifn);
				if (result == null) result = caseInstruction(ifn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.GOTO: {
				Goto goto_ = (Goto)theEObject;
				T result = caseGoto(goto_);
				if (result == null) result = caseBranchInstruction(goto_);
				if (result == null) result = caseInstruction(goto_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.ITERATE: {
				Iterate iterate = (Iterate)theEObject;
				T result = caseIterate(iterate);
				if (result == null) result = caseBranchInstruction(iterate);
				if (result == null) result = caseInstruction(iterate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.ENDITERATE: {
				Enditerate enditerate = (Enditerate)theEObject;
				T result = caseEnditerate(enditerate);
				if (result == null) result = caseBranchInstruction(enditerate);
				if (result == null) result = caseInstruction(enditerate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.INVOKE_INSTRUCTION: {
				InvokeInstruction invokeInstruction = (InvokeInstruction)theEObject;
				T result = caseInvokeInstruction(invokeInstruction);
				if (result == null) result = caseInstruction(invokeInstruction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.INVOKE_OPERATION_INSTRUCTION: {
				InvokeOperationInstruction invokeOperationInstruction = (InvokeOperationInstruction)theEObject;
				T result = caseInvokeOperationInstruction(invokeOperationInstruction);
				if (result == null) result = caseInvokeInstruction(invokeOperationInstruction);
				if (result == null) result = caseInstruction(invokeOperationInstruction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.INVOKE: {
				Invoke invoke = (Invoke)theEObject;
				T result = caseInvoke(invoke);
				if (result == null) result = caseInvokeOperationInstruction(invoke);
				if (result == null) result = caseInvokeInstruction(invoke);
				if (result == null) result = caseInstruction(invoke);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.INVOKE_SUPER: {
				InvokeSuper invokeSuper = (InvokeSuper)theEObject;
				T result = caseInvokeSuper(invokeSuper);
				if (result == null) result = caseInvokeOperationInstruction(invokeSuper);
				if (result == null) result = caseInvokeInstruction(invokeSuper);
				if (result == null) result = caseInstruction(invokeSuper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.INVOKE_STATIC: {
				InvokeStatic invokeStatic = (InvokeStatic)theEObject;
				T result = caseInvokeStatic(invokeStatic);
				if (result == null) result = caseInvokeOperationInstruction(invokeStatic);
				if (result == null) result = caseInvokeInstruction(invokeStatic);
				if (result == null) result = caseInstruction(invokeStatic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.ALLINST: {
				Allinst allinst = (Allinst)theEObject;
				T result = caseAllinst(allinst);
				if (result == null) result = caseInstruction(allinst);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.ALLINST_IN: {
				AllinstIn allinstIn = (AllinstIn)theEObject;
				T result = caseAllinstIn(allinstIn);
				if (result == null) result = caseInstruction(allinstIn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.ISNULL: {
				Isnull isnull = (Isnull)theEObject;
				T result = caseIsnull(isnull);
				if (result == null) result = caseInstruction(isnull);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.GETENVTYPE: {
				Getenvtype getenvtype = (Getenvtype)theEObject;
				T result = caseGetenvtype(getenvtype);
				if (result == null) result = caseInstruction(getenvtype);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.NOT: {
				Not not = (Not)theEObject;
				T result = caseNot(not);
				if (result == null) result = caseInstruction(not);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.AND: {
				And and = (And)theEObject;
				T result = caseAnd(and);
				if (result == null) result = caseCodeBlockInstruction(and);
				if (result == null) result = caseInstruction(and);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.OR: {
				Or or = (Or)theEObject;
				T result = caseOr(or);
				if (result == null) result = caseCodeBlockInstruction(or);
				if (result == null) result = caseInstruction(or);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.XOR: {
				Xor xor = (Xor)theEObject;
				T result = caseXor(xor);
				if (result == null) result = caseInstruction(xor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.IMPLIES: {
				Implies implies = (Implies)theEObject;
				T result = caseImplies(implies);
				if (result == null) result = caseCodeBlockInstruction(implies);
				if (result == null) result = caseInstruction(implies);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.IFTE: {
				Ifte ifte = (Ifte)theEObject;
				T result = caseIfte(ifte);
				if (result == null) result = caseInstruction(ifte);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.RETURN: {
				Return return_ = (Return)theEObject;
				T result = caseReturn(return_);
				if (result == null) result = caseInstruction(return_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.CODE_BLOCK_INSTRUCTION: {
				CodeBlockInstruction codeBlockInstruction = (CodeBlockInstruction)theEObject;
				T result = caseCodeBlockInstruction(codeBlockInstruction);
				if (result == null) result = caseInstruction(codeBlockInstruction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.GETCB: {
				Getcb getcb = (Getcb)theEObject;
				T result = caseGetcb(getcb);
				if (result == null) result = caseCodeBlockInstruction(getcb);
				if (result == null) result = caseInstruction(getcb);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.INVOKE_ALL_CBS: {
				InvokeAllCbs invokeAllCbs = (InvokeAllCbs)theEObject;
				T result = caseInvokeAllCbs(invokeAllCbs);
				if (result == null) result = caseInvokeInstruction(invokeAllCbs);
				if (result == null) result = caseInstruction(invokeAllCbs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.INVOKE_CB: {
				InvokeCb invokeCb = (InvokeCb)theEObject;
				T result = caseInvokeCb(invokeCb);
				if (result == null) result = caseCodeBlockInstruction(invokeCb);
				if (result == null) result = caseInvokeInstruction(invokeCb);
				if (result == null) result = caseInstruction(invokeCb);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.INVOKE_CB_S: {
				InvokeCbS invokeCbS = (InvokeCbS)theEObject;
				T result = caseInvokeCbS(invokeCbS);
				if (result == null) result = caseInvokeInstruction(invokeCbS);
				if (result == null) result = caseInstruction(invokeCbS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.MATCH: {
				Match match = (Match)theEObject;
				T result = caseMatch(match);
				if (result == null) result = caseInvokeInstruction(match);
				if (result == null) result = caseInstruction(match);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.MATCH_S: {
				MatchS matchS = (MatchS)theEObject;
				T result = caseMatchS(matchS);
				if (result == null) result = caseInvokeInstruction(matchS);
				if (result == null) result = caseInstruction(matchS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.ADD: {
				Add add = (Add)theEObject;
				T result = caseAdd(add);
				if (result == null) result = caseFieldInstruction(add);
				if (result == null) result = caseInstruction(add);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.REMOVE: {
				Remove remove = (Remove)theEObject;
				T result = caseRemove(remove);
				if (result == null) result = caseFieldInstruction(remove);
				if (result == null) result = caseInstruction(remove);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.INSERT: {
				Insert insert = (Insert)theEObject;
				T result = caseInsert(insert);
				if (result == null) result = caseFieldInstruction(insert);
				if (result == null) result = caseInstruction(insert);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModule(Module object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelDeclaration(ModelDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeature(Feature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseField(Field object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperation(Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElement(TypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstruction(Instruction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Line Number</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Line Number</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLineNumber(LineNumber object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalVariable(LocalVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRule(Rule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleElement(RuleElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Rule Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Rule Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputRuleElement(InputRuleElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Rule Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Rule Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputRuleElement(OutputRuleElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Code Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Code Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCodeBlock(CodeBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Push</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Push</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePush(Push object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pusht</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pusht</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePusht(Pusht object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pushf</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pushf</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePushf(Pushf object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePop(Pop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Variable Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Variable Instruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalVariableInstruction(LocalVariableInstruction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Load</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Load</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoad(Load object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Store</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Store</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStore(Store object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Field Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Field Instruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFieldInstruction(FieldInstruction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSet(Set object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGet(Get object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Trans</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Trans</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetTrans(GetTrans object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Static</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Static</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetStatic(SetStatic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Static</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Static</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetStatic(GetStatic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Findtype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Findtype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFindtype(Findtype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Findtype S</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Findtype S</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFindtypeS(FindtypeS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>New</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNew(New object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>New S</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New S</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewS(NewS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delete</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delete</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDelete(Delete object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dup</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dup</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDup(Dup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dup X1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dup X1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDupX1(DupX1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Swap</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Swap</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwap(Swap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Swap X1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Swap X1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwapX1(SwapX1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Branch Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Branch Instruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBranchInstruction(BranchInstruction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIf(If object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifn</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifn</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfn(Ifn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Goto</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Goto</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGoto(Goto object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIterate(Iterate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enditerate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enditerate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnditerate(Enditerate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invoke Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invoke Instruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvokeInstruction(InvokeInstruction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invoke Operation Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invoke Operation Instruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvokeOperationInstruction(InvokeOperationInstruction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invoke</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvoke(Invoke object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invoke Super</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invoke Super</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvokeSuper(InvokeSuper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invoke Static</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invoke Static</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvokeStatic(InvokeStatic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Allinst</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Allinst</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllinst(Allinst object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Allinst In</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Allinst In</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllinstIn(AllinstIn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Match</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Match</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatch(Match object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Match S</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Match S</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatchS(MatchS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdd(Add object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemove(Remove object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Insert</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Insert</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInsert(Insert object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Return</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Return</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReturn(Return object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Code Block Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Code Block Instruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCodeBlockInstruction(CodeBlockInstruction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Getcb</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Getcb</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetcb(Getcb object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invoke All Cbs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invoke All Cbs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvokeAllCbs(InvokeAllCbs object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invoke Cb</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invoke Cb</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvokeCb(InvokeCb object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invoke Cb S</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invoke Cb S</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvokeCbS(InvokeCbS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNot(Not object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnd(And object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOr(Or object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXor(Xor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Implies</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implies</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImplies(Implies object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifte</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifte</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfte(Ifte object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Isnull</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Isnull</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIsnull(Isnull object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Getenvtype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Getenvtype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetenvtype(Getenvtype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exec Env</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exec Env</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecEnv(ExecEnv object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModel(Model object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Metamodel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Metamodel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetamodel(Metamodel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //EmftvmSwitch
