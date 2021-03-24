/*******************************************************************************
 * Copyright (c) 2011-2012 Vrije Universiteit Brussel.
 * Copyright (c) 2021 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.emftvm.Add;
import org.eclipse.m2m.atl.emftvm.Allinst;
import org.eclipse.m2m.atl.emftvm.AllinstIn;
import org.eclipse.m2m.atl.emftvm.And;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.ConstantTag;
import org.eclipse.m2m.atl.emftvm.Delete;
import org.eclipse.m2m.atl.emftvm.Dup;
import org.eclipse.m2m.atl.emftvm.DupX1;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Enditerate;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.FeatureTag;
import org.eclipse.m2m.atl.emftvm.Field;
import org.eclipse.m2m.atl.emftvm.Findtype;
import org.eclipse.m2m.atl.emftvm.FindtypeS;
import org.eclipse.m2m.atl.emftvm.Get;
import org.eclipse.m2m.atl.emftvm.GetStatic;
import org.eclipse.m2m.atl.emftvm.GetSuper;
import org.eclipse.m2m.atl.emftvm.GetTrans;
import org.eclipse.m2m.atl.emftvm.Getcb;
import org.eclipse.m2m.atl.emftvm.Getenv;
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
import org.eclipse.m2m.atl.emftvm.InvokeStatic;
import org.eclipse.m2m.atl.emftvm.InvokeSuper;
import org.eclipse.m2m.atl.emftvm.Isnull;
import org.eclipse.m2m.atl.emftvm.Iterate;
import org.eclipse.m2m.atl.emftvm.LineNumber;
import org.eclipse.m2m.atl.emftvm.Load;
import org.eclipse.m2m.atl.emftvm.LocalVariable;
import org.eclipse.m2m.atl.emftvm.Match;
import org.eclipse.m2m.atl.emftvm.MatchS;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.ModelDeclaration;
import org.eclipse.m2m.atl.emftvm.ModelDeclarationTag;
import org.eclipse.m2m.atl.emftvm.ModelFactory;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.New;
import org.eclipse.m2m.atl.emftvm.NewS;
import org.eclipse.m2m.atl.emftvm.Not;
import org.eclipse.m2m.atl.emftvm.Opcode;
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
import org.eclipse.m2m.atl.emftvm.RuleMode;
import org.eclipse.m2m.atl.emftvm.Set;
import org.eclipse.m2m.atl.emftvm.SetStatic;
import org.eclipse.m2m.atl.emftvm.Store;
import org.eclipse.m2m.atl.emftvm.Swap;
import org.eclipse.m2m.atl.emftvm.SwapX1;
import org.eclipse.m2m.atl.emftvm.Xor;
import org.eclipse.m2m.atl.emftvm.util.EnumLiteral;
import org.eclipse.m2m.atl.emftvm.util.LazyBag;
import org.eclipse.m2m.atl.emftvm.util.LazyCollection;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet;
import org.eclipse.m2m.atl.emftvm.util.LazySet;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.PluginExtensionUtil;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
import org.eclipse.m2m.atl.emftvm.util.TypeHashMap;
import org.eclipse.m2m.atl.emftvm.util.TypeMap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * @generated
 */
public class EmftvmFactoryImpl extends EFactoryImpl implements EmftvmFactory {

	private static final String MODELFACTORY_EXTENSION_POINT = "org.eclipse.m2m.atl.emftvm.modelfactory";

	protected final ModelFactory defaultModelFactory = new ModelFactoryImpl();

	private TypeMap<Class<?>, ModelFactory> modelFactoryRegistry;

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
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * @return the default factory implementation.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EmftvmFactory init() {
		try {
			final EmftvmFactory theEmftvmFactory = (EmftvmFactory)EPackage.Registry.INSTANCE.getEFactory(EmftvmPackage.eNS_URI);
			if (theEmftvmFactory != null) {
				return theEmftvmFactory;
			}
		}
		catch (final Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EmftvmFactoryImpl();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(final EClass eClass) {
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
		case EmftvmPackage.GET_TRANS: return createGetTrans();
		case EmftvmPackage.SET_STATIC: return createSetStatic();
		case EmftvmPackage.GET_STATIC: return createGetStatic();
		case EmftvmPackage.FINDTYPE: return createFindtype();
		case EmftvmPackage.FINDTYPE_S: return createFindtypeS();
		case EmftvmPackage.NEW: return createNew();
		case EmftvmPackage.NEW_S: return createNewS();
		case EmftvmPackage.DELETE: return createDelete();
		case EmftvmPackage.DUP: return createDup();
		case EmftvmPackage.DUP_X1: return createDupX1();
		case EmftvmPackage.SWAP: return createSwap();
		case EmftvmPackage.SWAP_X1: return createSwapX1();
		case EmftvmPackage.IF: return createIf();
		case EmftvmPackage.IFN: return createIfn();
		case EmftvmPackage.GOTO: return createGoto();
		case EmftvmPackage.ITERATE: return createIterate();
		case EmftvmPackage.ENDITERATE: return createEnditerate();
		case EmftvmPackage.INVOKE: return createInvoke();
		case EmftvmPackage.INVOKE_SUPER: return createInvokeSuper();
		case EmftvmPackage.INVOKE_STATIC: return createInvokeStatic();
		case EmftvmPackage.ALLINST: return createAllinst();
		case EmftvmPackage.ALLINST_IN: return createAllinstIn();
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
		case EmftvmPackage.INVOKE_ALL_CBS: return createInvokeAllCbs();
		case EmftvmPackage.INVOKE_CB: return createInvokeCb();
		case EmftvmPackage.INVOKE_CB_S: return createInvokeCbS();
		case EmftvmPackage.MATCH: return createMatch();
		case EmftvmPackage.MATCH_S: return createMatchS();
		case EmftvmPackage.ADD: return createAdd();
		case EmftvmPackage.REMOVE: return createRemove();
		case EmftvmPackage.INSERT: return createInsert();
		case EmftvmPackage.GET_SUPER: return createGetSuper();
		case EmftvmPackage.GETENV: return createGetenv();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(final EDataType eDataType, final String initialValue) {
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
		case EmftvmPackage.EJAVA_OBJECT_ARRAY:
			return createEJavaObjectArrayFromString(eDataType, initialValue);
		case EmftvmPackage.EOBJECT_ARRAY:
			return createEObjectArrayFromString(eDataType, initialValue);
		case EmftvmPackage.EBOOLEAN_ARRAY:
			return createEBooleanArrayFromString(eDataType, initialValue);
		case EmftvmPackage.EJAVA_SET:
			return createEJavaSetFromString(eDataType, initialValue);
		case EmftvmPackage.EJAVA_ITERABLE:
			return createEJavaIterableFromString(eDataType, initialValue);
		case EmftvmPackage.CLASS_NOT_FOUND_EXCEPTION:
			return createClassNotFoundExceptionFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(final EDataType eDataType, final Object instanceValue) {
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
		case EmftvmPackage.EJAVA_OBJECT_ARRAY:
			return convertEJavaObjectArrayToString(eDataType, instanceValue);
		case EmftvmPackage.EOBJECT_ARRAY:
			return convertEObjectArrayToString(eDataType, instanceValue);
		case EmftvmPackage.EBOOLEAN_ARRAY:
			return convertEBooleanArrayToString(eDataType, instanceValue);
		case EmftvmPackage.EJAVA_SET:
			return convertEJavaSetToString(eDataType, instanceValue);
		case EmftvmPackage.EJAVA_ITERABLE:
			return convertEJavaIterableToString(eDataType, instanceValue);
		case EmftvmPackage.CLASS_NOT_FOUND_EXCEPTION:
			return convertClassNotFoundExceptionToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module createModule() {
		final ModuleImpl module = new ModuleImpl();
		return module;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelDeclaration createModelDeclaration() {
		final ModelDeclarationImpl modelDeclaration = new ModelDeclarationImpl();
		return modelDeclaration;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Field createField() {
		final FieldImpl field = new FieldImpl();
		return field;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation createOperation() {
		final OperationImpl operation = new OperationImpl();
		return operation;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		final ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LineNumber createLineNumber() {
		final LineNumberImpl lineNumber = new LineNumberImpl();
		return lineNumber;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalVariable createLocalVariable() {
		final LocalVariableImpl localVariable = new LocalVariableImpl();
		return localVariable;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule createRule() {
		final RuleImpl rule = new RuleImpl();
		return rule;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputRuleElement createInputRuleElement() {
		final InputRuleElementImpl inputRuleElement = new InputRuleElementImpl();
		return inputRuleElement;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputRuleElement createOutputRuleElement() {
		final OutputRuleElementImpl outputRuleElement = new OutputRuleElementImpl();
		return outputRuleElement;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock createCodeBlock() {
		final CodeBlockImpl codeBlock = new CodeBlockImpl();
		return codeBlock;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Push createPush() {
		final PushImpl push = new PushImpl();
		return push;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pusht createPusht() {
		final PushtImpl pusht = new PushtImpl();
		return pusht;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pushf createPushf() {
		final PushfImpl pushf = new PushfImpl();
		return pushf;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pop createPop() {
		final PopImpl pop = new PopImpl();
		return pop;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Load createLoad() {
		final LoadImpl load = new LoadImpl();
		return load;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Store createStore() {
		final StoreImpl store = new StoreImpl();
		return store;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Set createSet() {
		final SetImpl set = new SetImpl();
		return set;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Get createGet() {
		final GetImpl get = new GetImpl();
		return get;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetTrans createGetTrans() {
		final GetTransImpl getTrans = new GetTransImpl();
		return getTrans;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetStatic createSetStatic() {
		final SetStaticImpl setStatic = new SetStaticImpl();
		return setStatic;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetStatic createGetStatic() {
		final GetStaticImpl getStatic = new GetStaticImpl();
		return getStatic;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Findtype createFindtype() {
		final FindtypeImpl findtype = new FindtypeImpl();
		return findtype;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FindtypeS createFindtypeS() {
		final FindtypeSImpl findtypeS = new FindtypeSImpl();
		return findtypeS;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public New createNew() {
		final NewImpl new_ = new NewImpl();
		return new_;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewS createNewS() {
		final NewSImpl newS = new NewSImpl();
		return newS;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Delete createDelete() {
		final DeleteImpl delete = new DeleteImpl();
		return delete;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dup createDup() {
		final DupImpl dup = new DupImpl();
		return dup;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DupX1 createDupX1() {
		final DupX1Impl dupX1 = new DupX1Impl();
		return dupX1;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Swap createSwap() {
		final SwapImpl swap = new SwapImpl();
		return swap;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwapX1 createSwapX1() {
		final SwapX1Impl swapX1 = new SwapX1Impl();
		return swapX1;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public If createIf() {
		final IfImpl if_ = new IfImpl();
		return if_;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ifn createIfn() {
		final IfnImpl ifn = new IfnImpl();
		return ifn;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Goto createGoto() {
		final GotoImpl goto_ = new GotoImpl();
		return goto_;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iterate createIterate() {
		final IterateImpl iterate = new IterateImpl();
		return iterate;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enditerate createEnditerate() {
		final EnditerateImpl enditerate = new EnditerateImpl();
		return enditerate;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Invoke createInvoke() {
		final InvokeImpl invoke = new InvokeImpl();
		return invoke;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvokeSuper createInvokeSuper() {
		final InvokeSuperImpl invokeSuper = new InvokeSuperImpl();
		return invokeSuper;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvokeStatic createInvokeStatic() {
		final InvokeStaticImpl invokeStatic = new InvokeStaticImpl();
		return invokeStatic;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Allinst createAllinst() {
		final AllinstImpl allinst = new AllinstImpl();
		return allinst;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllinstIn createAllinstIn() {
		final AllinstInImpl allinstIn = new AllinstInImpl();
		return allinstIn;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Match createMatch() {
		final MatchImpl match = new MatchImpl();
		return match;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchS createMatchS() {
		final MatchSImpl matchS = new MatchSImpl();
		return matchS;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Add createAdd() {
		final AddImpl add = new AddImpl();
		return add;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Remove createRemove() {
		final RemoveImpl remove = new RemoveImpl();
		return remove;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Insert createInsert() {
		final InsertImpl insert = new InsertImpl();
		return insert;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetSuper createGetSuper() {
		final GetSuperImpl getSuper = new GetSuperImpl();
		return getSuper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Getenv createGetenv() {
		final GetenvImpl getenv = new GetenvImpl();
		return getenv;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Return createReturn() {
		final ReturnImpl return_ = new ReturnImpl();
		return return_;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Getcb createGetcb() {
		final GetcbImpl getcb = new GetcbImpl();
		return getcb;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvokeAllCbs createInvokeAllCbs() {
		final InvokeAllCbsImpl invokeAllCbs = new InvokeAllCbsImpl();
		return invokeAllCbs;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvokeCb createInvokeCb() {
		final InvokeCbImpl invokeCb = new InvokeCbImpl();
		return invokeCb;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvokeCbS createInvokeCbS() {
		final InvokeCbSImpl invokeCbS = new InvokeCbSImpl();
		return invokeCbS;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelDeclarationTag createModelDeclarationTagFromString(final EDataType eDataType, final String initialValue) {
		final ModelDeclarationTag result = ModelDeclarationTag.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertModelDeclarationTagToString(final EDataType eDataType, final Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Not createNot() {
		final NotImpl not = new NotImpl();
		return not;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public And createAnd() {
		final AndImpl and = new AndImpl();
		return and;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Or createOr() {
		final OrImpl or = new OrImpl();
		return or;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xor createXor() {
		final XorImpl xor = new XorImpl();
		return xor;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Implies createImplies() {
		final ImpliesImpl implies = new ImpliesImpl();
		return implies;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ifte createIfte() {
		final IfteImpl ifte = new IfteImpl();
		return ifte;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Isnull createIsnull() {
		final IsnullImpl isnull = new IsnullImpl();
		return isnull;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Getenvtype createGetenvtype() {
		final GetenvtypeImpl getenvtype = new GetenvtypeImpl();
		return getenvtype;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureTag createFeatureTagFromString(final EDataType eDataType, final String initialValue) {
		final FeatureTag result = FeatureTag.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFeatureTagToString(final EDataType eDataType, final Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecEnv createExecEnv() {
		final ExecEnvImpl execEnv = new ExecEnvImpl();
		return execEnv;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model createModel() {
		final ModelImpl model = new ModelImpl();
		return model;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metamodel createMetamodel() {
		final MetamodelImpl metamodel = new MetamodelImpl();
		return metamodel;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Opcode createOpcodeFromString(final EDataType eDataType, final String initialValue) {
		final Opcode result = Opcode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOpcodeToString(final EDataType eDataType, final Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleMode createRuleModeFromString(final EDataType eDataType, final String initialValue) {
		final RuleMode result = RuleMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRuleModeToString(final EDataType eDataType, final Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstantTag createConstantTagFromString(final EDataType eDataType, final String initialValue) {
		final ConstantTag result = ConstantTag.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConstantTagToString(final EDataType eDataType, final Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StackFrame createStackFrameFromString(final EDataType eDataType, final String initialValue) {
		return (StackFrame)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStackFrameToString(final EDataType eDataType, final Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method createMethodFromString(final EDataType eDataType, final String initialValue) {
		return (Method)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMethodToString(final EDataType eDataType, final Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimingData createTimingDataFromString(final EDataType eDataType, final String initialValue) {
		return (TimingData)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTimingDataToString(final EDataType eDataType, final Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LazyCollection<?> createLazyCollectionFromString(final EDataType eDataType, final String initialValue) {
		return (LazyCollection<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLazyCollectionToString(final EDataType eDataType, final Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LazyBag<?> createLazyBagFromString(final EDataType eDataType, final String initialValue) {
		return (LazyBag<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLazyBagToString(final EDataType eDataType, final Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LazyList<?> createLazyListFromString(final EDataType eDataType, final String initialValue) {
		return (LazyList<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLazyListToString(final EDataType eDataType, final Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LazyOrderedSet<?> createLazyOrderedSetFromString(final EDataType eDataType, final String initialValue) {
		return (LazyOrderedSet<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLazyOrderedSetToString(final EDataType eDataType, final Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LazySet<?> createLazySetFromString(final EDataType eDataType, final String initialValue) {
		return (LazySet<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLazySetToString(final EDataType eDataType, final Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object[] createEJavaObjectArrayFromString(final EDataType eDataType, final String initialValue) {
		return (Object[])super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEJavaObjectArrayToString(final EDataType eDataType, final Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject[] createEObjectArrayFromString(final EDataType eDataType, final String initialValue) {
		return (EObject[])super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEObjectArrayToString(final EDataType eDataType, final Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean[] createEBooleanArrayFromString(final EDataType eDataType, final String initialValue) {
		return (boolean[])super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEBooleanArrayToString(final EDataType eDataType, final Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public java.util.Set<?> createEJavaSetFromString(final EDataType eDataType, final String initialValue) {
		return (java.util.Set<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEJavaSetToString(final EDataType eDataType, final Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iterable<?> createEJavaIterableFromString(final EDataType eDataType, final String initialValue) {
		return (Iterable<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEJavaIterableToString(final EDataType eDataType, final Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassNotFoundException createClassNotFoundExceptionFromString(final EDataType eDataType, final String initialValue) {
		return (ClassNotFoundException)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertClassNotFoundExceptionToString(final EDataType eDataType, final Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleResolver createModuleResolverFromString(final EDataType eDataType, final String initialValue) {
		return (ModuleResolver)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertModuleResolverToString(final EDataType eDataType, final Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumLiteral createEnumLiteralFromString(final EDataType eDataType, final String initialValue) {
		return (EnumLiteral)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnumLiteralToString(final EDataType eDataType, final Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmftvmPackage getEmftvmPackage() {
		return (EmftvmPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EmftvmPackage getPackage() {
		return EmftvmPackage.eINSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	public Instruction createInstruction(final Opcode opcode) {
		switch (opcode) {
		case PUSH: return createPush();
		case PUSHT: return createPusht();
		case PUSHF: return createPushf();
		case POP: return createPop();
		case LOAD: return createLoad();
		case STORE: return createStore();
		case SET: return createSet();
		case GET: return createGet();
		case GET_TRANS: return createGetTrans();
		case SET_STATIC: return createSetStatic();
		case GET_STATIC: return createGetStatic();
		case FINDTYPE: return createFindtype();
		case FINDTYPE_S: return createFindtypeS();
		case NEW: return createNew();
		case NEW_S: return createNewS();
		case DELETE: return createDelete();
		case DUP: return createDup();
		case DUP_X1: return createDupX1();
		case SWAP: return createSwap();
		case SWAP_X1: return createSwapX1();
		case IF: return createIf();
		case IFN: return createIfn();
		case GOTO: return createGoto();
		case ITERATE: return createIterate();
		case ENDITERATE: return createEnditerate();
		case INVOKE: return createInvoke();
		case INVOKE_SUPER: return createInvokeSuper();
		case INVOKE_STATIC: return createInvokeStatic();
		case ALLINST: return createAllinst();
		case ALLINST_IN: return createAllinstIn();
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
		case INVOKE_ALL_CBS: return createInvokeAllCbs();
		case INVOKE_CB: return createInvokeCb();
		case INVOKE_CB_S: return createInvokeCbS();
		case MATCH: return createMatch();
		case MATCH_S: return createMatchS();
		case ADD: return createAdd();
		case REMOVE: return createRemove();
		case INSERT: return createInsert();
		case GET_SUPER: return createGetSuper();
		case GETENV: return createGetenv();
		default:
			throw new IllegalArgumentException("The opcode '" + opcode.getName() + "' does not have a valid classifier");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Model createModel(final Resource resource) {
		final TypeMap<Class<?>, ModelFactory> modelFactoryRegistry = getModelFactoryRegistry();
		final Object key = modelFactoryRegistry.findKey(resource.getClass());
		if (key != null) {
			return modelFactoryRegistry.get(key).createModel(resource);
		}
		return defaultModelFactory.createModel(resource);
	}

	/**
	 * {@inheritDoc}
	 */
	public Metamodel createMetamodel(final Resource resource) {
		final TypeMap<Class<?>, ModelFactory> modelFactoryRegistry = getModelFactoryRegistry();
		final Object key = modelFactoryRegistry.findKey(resource.getClass());
		if (key != null) {
			return modelFactoryRegistry.get(key).createMetamodel(resource);
		}
		return defaultModelFactory.createMetamodel(resource);
	}

	/**
	 * @return the modelFactoryRegistry
	 */
	protected TypeMap<Class<?>, ModelFactory> getModelFactoryRegistry() {
		if (modelFactoryRegistry == null) {
			modelFactoryRegistry = createModelFactoryRegistry();
		}
		return modelFactoryRegistry;
	}

	private TypeMap<Class<?>, ModelFactory> createModelFactoryRegistry() {
		PluginExtensionUtil peUtil;
		try {
			peUtil = (PluginExtensionUtil) Class.forName(PluginExtensionUtil.IMPL).newInstance();
			return peUtil.createModelFactoryRegistry();
		} catch (final InstantiationException e) {
			ATLLogger.fine(e.getMessage());
		} catch (final IllegalAccessException e) {
			ATLLogger.fine(e.getMessage());
		} catch (final ClassNotFoundException e) {
			ATLLogger.fine(e.getMessage());
		}
		return new TypeHashMap<Class<?>, ModelFactory>();
	}

} //EmftvmFactoryImpl
