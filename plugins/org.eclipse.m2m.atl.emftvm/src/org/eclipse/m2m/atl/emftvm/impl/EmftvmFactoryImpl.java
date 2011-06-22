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
package org.eclipse.m2m.atl.emftvm.impl;


import java.lang.reflect.Method;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.m2m.atl.emftvm.*;
import org.eclipse.m2m.atl.emftvm.util.EnumLiteral;
import org.eclipse.m2m.atl.emftvm.util.LazyBag;
import org.eclipse.m2m.atl.emftvm.util.LazyCollection;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet;
import org.eclipse.m2m.atl.emftvm.util.LazySet;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
import org.eclipse.m2m.atl.emftvm.util.TimingData;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EmftvmFactoryImpl extends EFactoryImpl implements EmftvmFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EmftvmFactory init() {
		try {
			EmftvmFactory theEmftvmFactory = (EmftvmFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/m2m/atl/2011/EMFTVM"); 
			if (theEmftvmFactory != null) {
				return theEmftvmFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EmftvmFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmftvmFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EmftvmPackage.EXEC_ENV: return createExecEnv();
			case EmftvmPackage.MODEL: return createModel();
			case EmftvmPackage.METAMODEL: return createMetamodel();
			case EmftvmPackage.MODULE: return createModule();
			case EmftvmPackage.MODEL_DECLARATION: return createModelDeclaration();
			case EmftvmPackage.FIELD: return createField();
			case EmftvmPackage.OPERATION: return createOperation();
			case EmftvmPackage.PARAMETER: return createParameter();
			case EmftvmPackage.LINE_NUMBER: return createLineNumber();
			case EmftvmPackage.LOCAL_VARIABLE: return createLocalVariable();
			case EmftvmPackage.RULE: return createRule();
			case EmftvmPackage.INPUT_RULE_ELEMENT: return createInputRuleElement();
			case EmftvmPackage.OUTPUT_RULE_ELEMENT: return createOutputRuleElement();
			case EmftvmPackage.CODE_BLOCK: return createCodeBlock();
			case EmftvmPackage.PUSH: return createPush();
			case EmftvmPackage.PUSHT: return createPusht();
			case EmftvmPackage.PUSHF: return createPushf();
			case EmftvmPackage.POP: return createPop();
			case EmftvmPackage.LOAD: return createLoad();
			case EmftvmPackage.STORE: return createStore();
			case EmftvmPackage.SET: return createSet();
			case EmftvmPackage.GET: return createGet();
			case EmftvmPackage.GET_TRANS: return createGet_trans();
			case EmftvmPackage.SET_STATIC: return createSet_static();
			case EmftvmPackage.GET_STATIC: return createGet_static();
			case EmftvmPackage.FINDTYPE: return createFindtype();
			case EmftvmPackage.FINDTYPE_S: return createFindtype_s();
			case EmftvmPackage.NEW: return createNew();
			case EmftvmPackage.NEW_S: return createNew_s();
			case EmftvmPackage.DELETE: return createDelete();
			case EmftvmPackage.DUP: return createDup();
			case EmftvmPackage.DUP_X1: return createDup_x1();
			case EmftvmPackage.SWAP: return createSwap();
			case EmftvmPackage.SWAP_X1: return createSwap_x1();
			case EmftvmPackage.IF: return createIf();
			case EmftvmPackage.IFN: return createIfn();
			case EmftvmPackage.GOTO: return createGoto();
			case EmftvmPackage.ITERATE: return createIterate();
			case EmftvmPackage.ENDITERATE: return createEnditerate();
			case EmftvmPackage.INVOKE: return createInvoke();
			case EmftvmPackage.INVOKE_SUPER: return createInvoke_super();
			case EmftvmPackage.INVOKE_STATIC: return createInvoke_static();
			case EmftvmPackage.ALLINST: return createAllinst();
			case EmftvmPackage.ALLINST_IN: return createAllinst_in();
			case EmftvmPackage.ISNULL: return createIsnull();
			case EmftvmPackage.GETENVTYPE: return createGetenvtype();
			case EmftvmPackage.NOT: return createNot();
			case EmftvmPackage.AND: return createAnd();
			case EmftvmPackage.OR: return createOr();
			case EmftvmPackage.XOR: return createXor();
			case EmftvmPackage.IMPLIES: return createImplies();
			case EmftvmPackage.IFTE: return createIfte();
			case EmftvmPackage.RETURN: return createReturn();
			case EmftvmPackage.GETCB: return createGetcb();
			case EmftvmPackage.INVOKE_ALL_CBS: return createInvoke_all_cbs();
			case EmftvmPackage.INVOKE_CB: return createInvoke_cb();
			case EmftvmPackage.INVOKE_CB_S: return createInvoke_cb_s();
			case EmftvmPackage.MATCH: return createMatch();
			case EmftvmPackage.MATCH_S: return createMatch_s();
			case EmftvmPackage.ADD: return createAdd();
			case EmftvmPackage.REMOVE: return createRemove();
			case EmftvmPackage.INSERT: return createInsert();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case EmftvmPackage.MODEL_DECLARATION_TAG:
				return createModelDeclarationTagFromString(eDataType, initialValue);
			case EmftvmPackage.FEATURE_TAG:
				return createFeatureTagFromString(eDataType, initialValue);
			case EmftvmPackage.OPCODE:
				return createOpcodeFromString(eDataType, initialValue);
			case EmftvmPackage.RULE_MODE:
				return createRuleModeFromString(eDataType, initialValue);
			case EmftvmPackage.CONSTANT_TAG:
				return createConstantTagFromString(eDataType, initialValue);
			case EmftvmPackage.MODULE_RESOLVER:
				return createModuleResolverFromString(eDataType, initialValue);
			case EmftvmPackage.ENUM_LITERAL:
				return createEnumLiteralFromString(eDataType, initialValue);
			case EmftvmPackage.STACK_FRAME:
				return createStackFrameFromString(eDataType, initialValue);
			case EmftvmPackage.METHOD:
				return createMethodFromString(eDataType, initialValue);
			case EmftvmPackage.TIMING_DATA:
				return createTimingDataFromString(eDataType, initialValue);
			case EmftvmPackage.LAZY_COLLECTION:
				return createLazyCollectionFromString(eDataType, initialValue);
			case EmftvmPackage.LAZY_BAG:
				return createLazyBagFromString(eDataType, initialValue);
			case EmftvmPackage.LAZY_LIST:
				return createLazyListFromString(eDataType, initialValue);
			case EmftvmPackage.LAZY_ORDERED_SET:
				return createLazyOrderedSetFromString(eDataType, initialValue);
			case EmftvmPackage.LAZY_SET:
				return createLazySetFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case EmftvmPackage.MODEL_DECLARATION_TAG:
				return convertModelDeclarationTagToString(eDataType, instanceValue);
			case EmftvmPackage.FEATURE_TAG:
				return convertFeatureTagToString(eDataType, instanceValue);
			case EmftvmPackage.OPCODE:
				return convertOpcodeToString(eDataType, instanceValue);
			case EmftvmPackage.RULE_MODE:
				return convertRuleModeToString(eDataType, instanceValue);
			case EmftvmPackage.CONSTANT_TAG:
				return convertConstantTagToString(eDataType, instanceValue);
			case EmftvmPackage.MODULE_RESOLVER:
				return convertModuleResolverToString(eDataType, instanceValue);
			case EmftvmPackage.ENUM_LITERAL:
				return convertEnumLiteralToString(eDataType, instanceValue);
			case EmftvmPackage.STACK_FRAME:
				return convertStackFrameToString(eDataType, instanceValue);
			case EmftvmPackage.METHOD:
				return convertMethodToString(eDataType, instanceValue);
			case EmftvmPackage.TIMING_DATA:
				return convertTimingDataToString(eDataType, instanceValue);
			case EmftvmPackage.LAZY_COLLECTION:
				return convertLazyCollectionToString(eDataType, instanceValue);
			case EmftvmPackage.LAZY_BAG:
				return convertLazyBagToString(eDataType, instanceValue);
			case EmftvmPackage.LAZY_LIST:
				return convertLazyListToString(eDataType, instanceValue);
			case EmftvmPackage.LAZY_ORDERED_SET:
				return convertLazyOrderedSetToString(eDataType, instanceValue);
			case EmftvmPackage.LAZY_SET:
				return convertLazySetToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module createModule() {
		ModuleImpl module = new ModuleImpl();
		return module;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelDeclaration createModelDeclaration() {
		ModelDeclarationImpl modelDeclaration = new ModelDeclarationImpl();
		return modelDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Field createField() {
		FieldImpl field = new FieldImpl();
		return field;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation createOperation() {
		OperationImpl operation = new OperationImpl();
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LineNumber createLineNumber() {
		LineNumberImpl lineNumber = new LineNumberImpl();
		return lineNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalVariable createLocalVariable() {
		LocalVariableImpl localVariable = new LocalVariableImpl();
		return localVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule createRule() {
		RuleImpl rule = new RuleImpl();
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputRuleElement createInputRuleElement() {
		InputRuleElementImpl inputRuleElement = new InputRuleElementImpl();
		return inputRuleElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputRuleElement createOutputRuleElement() {
		OutputRuleElementImpl outputRuleElement = new OutputRuleElementImpl();
		return outputRuleElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock createCodeBlock() {
		CodeBlockImpl codeBlock = new CodeBlockImpl();
		return codeBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Push createPush() {
		PushImpl push = new PushImpl();
		return push;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pusht createPusht() {
		PushtImpl pusht = new PushtImpl();
		return pusht;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pushf createPushf() {
		PushfImpl pushf = new PushfImpl();
		return pushf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pop createPop() {
		PopImpl pop = new PopImpl();
		return pop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Load createLoad() {
		LoadImpl load = new LoadImpl();
		return load;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Store createStore() {
		StoreImpl store = new StoreImpl();
		return store;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Set createSet() {
		SetImpl set = new SetImpl();
		return set;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Get createGet() {
		GetImpl get = new GetImpl();
		return get;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Get_trans createGet_trans() {
		Get_transImpl get_trans = new Get_transImpl();
		return get_trans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Set_static createSet_static() {
		Set_staticImpl set_static = new Set_staticImpl();
		return set_static;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Get_static createGet_static() {
		Get_staticImpl get_static = new Get_staticImpl();
		return get_static;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Findtype createFindtype() {
		FindtypeImpl findtype = new FindtypeImpl();
		return findtype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Findtype_s createFindtype_s() {
		Findtype_sImpl findtype_s = new Findtype_sImpl();
		return findtype_s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public New createNew() {
		NewImpl new_ = new NewImpl();
		return new_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public New_s createNew_s() {
		New_sImpl new_s = new New_sImpl();
		return new_s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Delete createDelete() {
		DeleteImpl delete = new DeleteImpl();
		return delete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dup createDup() {
		DupImpl dup = new DupImpl();
		return dup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dup_x1 createDup_x1() {
		Dup_x1Impl dup_x1 = new Dup_x1Impl();
		return dup_x1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Swap createSwap() {
		SwapImpl swap = new SwapImpl();
		return swap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Swap_x1 createSwap_x1() {
		Swap_x1Impl swap_x1 = new Swap_x1Impl();
		return swap_x1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public If createIf() {
		IfImpl if_ = new IfImpl();
		return if_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ifn createIfn() {
		IfnImpl ifn = new IfnImpl();
		return ifn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Goto createGoto() {
		GotoImpl goto_ = new GotoImpl();
		return goto_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iterate createIterate() {
		IterateImpl iterate = new IterateImpl();
		return iterate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enditerate createEnditerate() {
		EnditerateImpl enditerate = new EnditerateImpl();
		return enditerate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Invoke createInvoke() {
		InvokeImpl invoke = new InvokeImpl();
		return invoke;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Invoke_super createInvoke_super() {
		Invoke_superImpl invoke_super = new Invoke_superImpl();
		return invoke_super;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Invoke_static createInvoke_static() {
		Invoke_staticImpl invoke_static = new Invoke_staticImpl();
		return invoke_static;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Allinst createAllinst() {
		AllinstImpl allinst = new AllinstImpl();
		return allinst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Allinst_in createAllinst_in() {
		Allinst_inImpl allinst_in = new Allinst_inImpl();
		return allinst_in;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Match createMatch() {
		MatchImpl match = new MatchImpl();
		return match;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Match_s createMatch_s() {
		Match_sImpl match_s = new Match_sImpl();
		return match_s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Add createAdd() {
		AddImpl add = new AddImpl();
		return add;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Remove createRemove() {
		RemoveImpl remove = new RemoveImpl();
		return remove;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Insert createInsert() {
		InsertImpl insert = new InsertImpl();
		return insert;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Invoke_all_cbs createInvoke_all_cbs() {
		Invoke_all_cbsImpl invoke_all_cbs = new Invoke_all_cbsImpl();
		return invoke_all_cbs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Return createReturn() {
		ReturnImpl return_ = new ReturnImpl();
		return return_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Getcb createGetcb() {
		GetcbImpl getcb = new GetcbImpl();
		return getcb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Invoke_cb createInvoke_cb() {
		Invoke_cbImpl invoke_cb = new Invoke_cbImpl();
		return invoke_cb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Invoke_cb_s createInvoke_cb_s() {
		Invoke_cb_sImpl invoke_cb_s = new Invoke_cb_sImpl();
		return invoke_cb_s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelDeclarationTag createModelDeclarationTagFromString(EDataType eDataType, String initialValue) {
		ModelDeclarationTag result = ModelDeclarationTag.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertModelDeclarationTagToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Not createNot() {
		NotImpl not = new NotImpl();
		return not;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public And createAnd() {
		AndImpl and = new AndImpl();
		return and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Or createOr() {
		OrImpl or = new OrImpl();
		return or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xor createXor() {
		XorImpl xor = new XorImpl();
		return xor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Implies createImplies() {
		ImpliesImpl implies = new ImpliesImpl();
		return implies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ifte createIfte() {
		IfteImpl ifte = new IfteImpl();
		return ifte;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Isnull createIsnull() {
		IsnullImpl isnull = new IsnullImpl();
		return isnull;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Getenvtype createGetenvtype() {
		GetenvtypeImpl getenvtype = new GetenvtypeImpl();
		return getenvtype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureTag createFeatureTagFromString(EDataType eDataType, String initialValue) {
		FeatureTag result = FeatureTag.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFeatureTagToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecEnv createExecEnv() {
		ExecEnvImpl execEnv = new ExecEnvImpl();
		return execEnv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model createModel() {
		ModelImpl model = new ModelImpl();
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metamodel createMetamodel() {
		MetamodelImpl metamodel = new MetamodelImpl();
		return metamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Opcode createOpcodeFromString(EDataType eDataType, String initialValue) {
		Opcode result = Opcode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOpcodeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleMode createRuleModeFromString(EDataType eDataType, String initialValue) {
		RuleMode result = RuleMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRuleModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstantTag createConstantTagFromString(EDataType eDataType, String initialValue) {
		ConstantTag result = ConstantTag.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConstantTagToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StackFrame createStackFrameFromString(EDataType eDataType, String initialValue) {
		return (StackFrame)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStackFrameToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method createMethodFromString(EDataType eDataType, String initialValue) {
		return (Method)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMethodToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimingData createTimingDataFromString(EDataType eDataType, String initialValue) {
		return (TimingData)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTimingDataToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LazyCollection<?> createLazyCollectionFromString(EDataType eDataType, String initialValue) {
		return (LazyCollection<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLazyCollectionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LazyBag<?> createLazyBagFromString(EDataType eDataType, String initialValue) {
		return (LazyBag<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLazyBagToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LazyList<?> createLazyListFromString(EDataType eDataType, String initialValue) {
		return (LazyList<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLazyListToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LazyOrderedSet<?> createLazyOrderedSetFromString(EDataType eDataType, String initialValue) {
		return (LazyOrderedSet<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLazyOrderedSetToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LazySet<?> createLazySetFromString(EDataType eDataType, String initialValue) {
		return (LazySet<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLazySetToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleResolver createModuleResolverFromString(EDataType eDataType, String initialValue) {
		return (ModuleResolver)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertModuleResolverToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumLiteral createEnumLiteralFromString(EDataType eDataType, String initialValue) {
		return (EnumLiteral)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnumLiteralToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmftvmPackage getEmftvmPackage() {
		return (EmftvmPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EmftvmPackage getPackage() {
		return EmftvmPackage.eINSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmFactory#createInstruction(org.eclipse.m2m.atl.emftvm.Opcode)
	 */
	public Instruction createInstruction(Opcode opcode) {
		switch (opcode) {
		case PUSH: return createPush();
		case PUSHT: return createPusht();
		case PUSHF: return createPushf();
		case POP: return createPop();
		case LOAD: return createLoad();
		case STORE: return createStore();
		case SET: return createSet();
		case GET: return createGet();
		case GET_TRANS: return createGet_trans();
		case SET_STATIC: return createSet_static();
		case GET_STATIC: return createGet_static();
		case FINDTYPE: return createFindtype();
		case FINDTYPE_S: return createFindtype_s();
		case NEW: return createNew();
		case NEW_S: return createNew_s();
		case DELETE: return createDelete();
		case DUP: return createDup();
		case DUP_X1: return createDup_x1();
		case SWAP: return createSwap();
		case SWAP_X1: return createSwap_x1();
		case IF: return createIf();
		case IFN: return createIfn();
		case GOTO: return createGoto();
		case ITERATE: return createIterate();
		case ENDITERATE: return createEnditerate();
		case INVOKE: return createInvoke();
		case INVOKE_SUPER: return createInvoke_super();
		case INVOKE_STATIC: return createInvoke_static();
		case ALLINST: return createAllinst();
		case ALLINST_IN: return createAllinst_in();
		case ISNULL: return createIsnull();
		case GETENVTYPE: return createGetenvtype();
		case NOT: return createNot();
		case AND: return createAnd();
		case OR: return createOr();
		case XOR: return createXor();
		case IMPLIES: return createImplies();
		case IFTE: return createIfte();
		case RETURN: return createReturn();
		case GETCB: return createGetcb();
		case INVOKE_ALL_CBS: return createInvoke_all_cbs();
		case INVOKE_CB: return createInvoke_cb();
		case INVOKE_CB_S: return createInvoke_cb_s();
		case MATCH: return createMatch();
		case MATCH_S: return createMatch_s();
		case ADD: return createAdd();
		case REMOVE: return createRemove();
		case INSERT: return createInsert();
		default:
			throw new IllegalArgumentException("The opcode '" + opcode.getName() + "' does not have a valid classifier");
		}
	}

} //EmftvmFactoryImpl
