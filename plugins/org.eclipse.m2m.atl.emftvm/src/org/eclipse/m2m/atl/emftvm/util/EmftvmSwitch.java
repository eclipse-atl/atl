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
				Get_trans get_trans = (Get_trans)theEObject;
				T result = caseGet_trans(get_trans);
				if (result == null) result = caseFieldInstruction(get_trans);
				if (result == null) result = caseInstruction(get_trans);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.SET_STATIC: {
				Set_static set_static = (Set_static)theEObject;
				T result = caseSet_static(set_static);
				if (result == null) result = caseFieldInstruction(set_static);
				if (result == null) result = caseInstruction(set_static);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.GET_STATIC: {
				Get_static get_static = (Get_static)theEObject;
				T result = caseGet_static(get_static);
				if (result == null) result = caseFieldInstruction(get_static);
				if (result == null) result = caseInstruction(get_static);
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
				Findtype_s findtype_s = (Findtype_s)theEObject;
				T result = caseFindtype_s(findtype_s);
				if (result == null) result = caseInstruction(findtype_s);
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
				New_s new_s = (New_s)theEObject;
				T result = caseNew_s(new_s);
				if (result == null) result = caseInstruction(new_s);
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
				Dup_x1 dup_x1 = (Dup_x1)theEObject;
				T result = caseDup_x1(dup_x1);
				if (result == null) result = caseInstruction(dup_x1);
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
				Swap_x1 swap_x1 = (Swap_x1)theEObject;
				T result = caseSwap_x1(swap_x1);
				if (result == null) result = caseInstruction(swap_x1);
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
				Invoke_super invoke_super = (Invoke_super)theEObject;
				T result = caseInvoke_super(invoke_super);
				if (result == null) result = caseInvokeOperationInstruction(invoke_super);
				if (result == null) result = caseInvokeInstruction(invoke_super);
				if (result == null) result = caseInstruction(invoke_super);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.INVOKE_STATIC: {
				Invoke_static invoke_static = (Invoke_static)theEObject;
				T result = caseInvoke_static(invoke_static);
				if (result == null) result = caseInvokeOperationInstruction(invoke_static);
				if (result == null) result = caseInvokeInstruction(invoke_static);
				if (result == null) result = caseInstruction(invoke_static);
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
				Allinst_in allinst_in = (Allinst_in)theEObject;
				T result = caseAllinst_in(allinst_in);
				if (result == null) result = caseInstruction(allinst_in);
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
				Invoke_all_cbs invoke_all_cbs = (Invoke_all_cbs)theEObject;
				T result = caseInvoke_all_cbs(invoke_all_cbs);
				if (result == null) result = caseInvokeInstruction(invoke_all_cbs);
				if (result == null) result = caseInstruction(invoke_all_cbs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.INVOKE_CB: {
				Invoke_cb invoke_cb = (Invoke_cb)theEObject;
				T result = caseInvoke_cb(invoke_cb);
				if (result == null) result = caseCodeBlockInstruction(invoke_cb);
				if (result == null) result = caseInvokeInstruction(invoke_cb);
				if (result == null) result = caseInstruction(invoke_cb);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmftvmPackage.INVOKE_CB_S: {
				Invoke_cb_s invoke_cb_s = (Invoke_cb_s)theEObject;
				T result = caseInvoke_cb_s(invoke_cb_s);
				if (result == null) result = caseInvokeInstruction(invoke_cb_s);
				if (result == null) result = caseInstruction(invoke_cb_s);
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
				Match_s match_s = (Match_s)theEObject;
				T result = caseMatch_s(match_s);
				if (result == null) result = caseInvokeInstruction(match_s);
				if (result == null) result = caseInstruction(match_s);
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
	 * Returns the result of interpreting the object as an instance of '<em>Get trans</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get trans</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGet_trans(Get_trans object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set static</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set static</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSet_static(Set_static object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get static</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get static</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGet_static(Get_static object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Findtype s</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Findtype s</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFindtype_s(Findtype_s object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>New s</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New s</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNew_s(New_s object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Dup x1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dup x1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDup_x1(Dup_x1 object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Swap x1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Swap x1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwap_x1(Swap_x1 object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Invoke super</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invoke super</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvoke_super(Invoke_super object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invoke static</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invoke static</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvoke_static(Invoke_static object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Allinst in</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Allinst in</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllinst_in(Allinst_in object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Match s</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Match s</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatch_s(Match_s object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Invoke all cbs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invoke all cbs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvoke_all_cbs(Invoke_all_cbs object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Invoke cb</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invoke cb</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvoke_cb(Invoke_cb object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invoke cb s</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invoke cb s</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvoke_cb_s(Invoke_cb_s object) {
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
