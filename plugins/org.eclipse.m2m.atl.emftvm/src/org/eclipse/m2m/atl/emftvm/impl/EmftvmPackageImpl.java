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
package org.eclipse.m2m.atl.emftvm.impl;

import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.m2m.atl.emftvm.Add;
import org.eclipse.m2m.atl.emftvm.Allinst;
import org.eclipse.m2m.atl.emftvm.AllinstIn;
import org.eclipse.m2m.atl.emftvm.And;
import org.eclipse.m2m.atl.emftvm.BranchInstruction;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.CodeBlockInstruction;
import org.eclipse.m2m.atl.emftvm.ConstantTag;
import org.eclipse.m2m.atl.emftvm.Delete;
import org.eclipse.m2m.atl.emftvm.Dup;
import org.eclipse.m2m.atl.emftvm.DupX1;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Enditerate;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Feature;
import org.eclipse.m2m.atl.emftvm.FeatureTag;
import org.eclipse.m2m.atl.emftvm.Field;
import org.eclipse.m2m.atl.emftvm.FieldInstruction;
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
import org.eclipse.m2m.atl.emftvm.ModelDeclarationTag;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.NamedElement;
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
import org.eclipse.m2m.atl.emftvm.RuleElement;
import org.eclipse.m2m.atl.emftvm.RuleMode;
import org.eclipse.m2m.atl.emftvm.Set;
import org.eclipse.m2m.atl.emftvm.SetStatic;
import org.eclipse.m2m.atl.emftvm.Store;
import org.eclipse.m2m.atl.emftvm.Swap;
import org.eclipse.m2m.atl.emftvm.SwapX1;
import org.eclipse.m2m.atl.emftvm.TypedElement;
import org.eclipse.m2m.atl.emftvm.Xor;
import org.eclipse.m2m.atl.emftvm.trace.TracePackage;
import org.eclipse.m2m.atl.emftvm.util.EnumLiteral;
import org.eclipse.m2m.atl.emftvm.util.LazyBag;
import org.eclipse.m2m.atl.emftvm.util.LazyCollection;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet;
import org.eclipse.m2m.atl.emftvm.util.LazySet;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
import org.eclipse.m2m.atl.emftvm.util.VMMonitor;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * @generated
 */
public class EmftvmPackageImpl extends EPackageImpl implements EmftvmPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instructionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lineNumberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputRuleElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputRuleElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass codeBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pushEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pushtEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pushfEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass popEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localVariableInstructionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loadEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fieldInstructionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getTransEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setStaticEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getStaticEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass findtypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass findtypeSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dupX1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass swapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass swapX1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass branchInstructionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gotoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enditerateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invokeInstructionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invokeOperationInstructionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invokeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invokeSuperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invokeStaticEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allinstEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allinstInEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matchSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass insertEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getSuperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getenvEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass returnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass codeBlockInstructionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getcbEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invokeAllCbsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invokeCbEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invokeCbSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum modelDeclarationTagEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass impliesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isnullEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getenvtypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum featureTagEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass execEnvEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metamodelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum opcodeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ruleModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum constantTagEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stackFrameEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType methodEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType timingDataEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType vmMonitorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType lazyCollectionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType lazyBagEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType lazyListEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType lazyOrderedSetEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType lazySetEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eJavaObjectArrayEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eObjectArrayEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eBooleanArrayEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eJavaSetEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eJavaIterableEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType classNotFoundExceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType moduleResolverEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType enumLiteralEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EmftvmPackageImpl() {
		super(eNS_URI, EmftvmFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link EmftvmPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EmftvmPackage init() {
		if (isInited) return (EmftvmPackage)EPackage.Registry.INSTANCE.getEPackage(EmftvmPackage.eNS_URI);

		// Obtain or create and register package
		EmftvmPackageImpl theEmftvmPackage = (EmftvmPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EmftvmPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EmftvmPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		TracePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEmftvmPackage.createPackageContents();

		// Initialize created meta-data
		theEmftvmPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEmftvmPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EmftvmPackage.eNS_URI, theEmftvmPackage);
		return theEmftvmPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModule() {
		return moduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModule_SourceName() {
		return (EAttribute)moduleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_Features() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_Rules() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_EImports() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModule_Imports() {
		return (EAttribute)moduleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_InputModels() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_InoutModels() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_OutputModels() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelDeclaration() {
		return modelDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelDeclaration_ModelName() {
		return (EAttribute)modelDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelDeclaration_MetaModelName() {
		return (EAttribute)modelDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelDeclaration_InputModelFor() {
		return (EReference)modelDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelDeclaration_InoutModelFor() {
		return (EReference)modelDeclarationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelDeclaration_OutputModelFor() {
		return (EReference)modelDeclarationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeature() {
		return featureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Static() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_EContext() {
		return (EReference)featureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Context() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_ContextModel() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_Module() {
		return (EReference)featureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getField() {
		return fieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getField_StaticValue() {
		return (EAttribute)fieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getField_Initialiser() {
		return (EReference)fieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getField_Rule() {
		return (EReference)fieldEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperation() {
		return operationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperation_Parameters() {
		return (EReference)operationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperation_Query() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperation_Body() {
		return (EReference)operationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameter_Operation() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedElement() {
		return typedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedElement_EType() {
		return (EReference)typedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypedElement_Type() {
		return (EAttribute)typedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypedElement_TypeModel() {
		return (EAttribute)typedElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstruction() {
		return instructionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstruction_OwningBlock() {
		return (EReference)instructionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstruction_Opcode() {
		return (EAttribute)instructionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstruction_StackProduction() {
		return (EAttribute)instructionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstruction_StackConsumption() {
		return (EAttribute)instructionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstruction_StackLevel() {
		return (EAttribute)instructionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstruction_LineNumber() {
		return (EReference)instructionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLineNumber() {
		return lineNumberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLineNumber_StartLine() {
		return (EAttribute)lineNumberEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLineNumber_StartColumn() {
		return (EAttribute)lineNumberEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLineNumber_EndLine() {
		return (EAttribute)lineNumberEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLineNumber_EndColumn() {
		return (EAttribute)lineNumberEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLineNumber_StartChar() {
		return (EAttribute)lineNumberEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLineNumber_EndChar() {
		return (EAttribute)lineNumberEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLineNumber_OwningBlock() {
		return (EReference)lineNumberEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLineNumber_Instructions() {
		return (EReference)lineNumberEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalVariable() {
		return localVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalVariable_Slot() {
		return (EAttribute)localVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalVariable_StartInstruction() {
		return (EReference)localVariableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalVariable_EndInstruction() {
		return (EReference)localVariableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalVariable_StartInstructionIndex() {
		return (EAttribute)localVariableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalVariable_EndInstructionIndex() {
		return (EAttribute)localVariableEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalVariable_OwningBlock() {
		return (EReference)localVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRule() {
		return ruleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_Module() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRule_Mode() {
		return (EAttribute)ruleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_InputElements() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_OutputElements() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_ESuperRules() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_ESubRules() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_Matcher() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_Applier() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_PostApply() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRule_SuperRules() {
		return (EAttribute)ruleEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRule_Abstract() {
		return (EAttribute)ruleEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_Fields() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRule_Default() {
		return (EAttribute)ruleEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRule_DistinctElements() {
		return (EAttribute)ruleEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRule_Unique() {
		return (EAttribute)ruleEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRule_Leaf() {
		return (EAttribute)ruleEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRule_WithLeaves() {
		return (EAttribute)ruleEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleElement() {
		return ruleElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCodeBlock() {
		return codeBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeBlock_MaxLocals() {
		return (EAttribute)codeBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeBlock_MaxStack() {
		return (EAttribute)codeBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeBlock_Code() {
		return (EReference)codeBlockEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeBlock_LineNumbers() {
		return (EReference)codeBlockEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeBlock_LocalVariables() {
		return (EReference)codeBlockEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeBlock_MatcherFor() {
		return (EReference)codeBlockEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeBlock_ApplierFor() {
		return (EReference)codeBlockEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeBlock_PostApplyFor() {
		return (EReference)codeBlockEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeBlock_BodyFor() {
		return (EReference)codeBlockEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeBlock_InitialiserFor() {
		return (EReference)codeBlockEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeBlock_Nested() {
		return (EReference)codeBlockEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeBlock_NestedFor() {
		return (EReference)codeBlockEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeBlock_ParentFrame() {
		return (EAttribute)codeBlockEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeBlock_BindingFor() {
		return (EReference)codeBlockEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPush() {
		return pushEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPush_Value() {
		return (EAttribute)pushEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPush_StringValue() {
		return (EAttribute)pushEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPush_IntValue() {
		return (EAttribute)pushEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPush_DoubleValue() {
		return (EAttribute)pushEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPush_ByteValue() {
		return (EAttribute)pushEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPush_CharValue() {
		return (EAttribute)pushEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPush_FloatValue() {
		return (EAttribute)pushEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPush_ShortValue() {
		return (EAttribute)pushEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPush_LongValue() {
		return (EAttribute)pushEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPush_EnumValue() {
		return (EAttribute)pushEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPusht() {
		return pushtEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPushf() {
		return pushfEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPop() {
		return popEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalVariableInstruction() {
		return localVariableInstructionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalVariableInstruction_CbOffset() {
		return (EAttribute)localVariableInstructionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalVariableInstruction_Slot() {
		return (EAttribute)localVariableInstructionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalVariableInstruction_LocalVariableIndex() {
		return (EAttribute)localVariableInstructionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalVariableInstruction_LocalVariable() {
		return (EReference)localVariableInstructionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoad() {
		return loadEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStore() {
		return storeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFieldInstruction() {
		return fieldInstructionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFieldInstruction_Fieldname() {
		return (EAttribute)fieldInstructionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSet() {
		return setEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGet() {
		return getEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetTrans() {
		return getTransEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetStatic() {
		return setStaticEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetStatic() {
		return getStaticEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFindtype() {
		return findtypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFindtype_Modelname() {
		return (EAttribute)findtypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFindtype_Typename() {
		return (EAttribute)findtypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFindtypeS() {
		return findtypeSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNew() {
		return newEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNew_Modelname() {
		return (EAttribute)newEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewS() {
		return newSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDelete() {
		return deleteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDup() {
		return dupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDupX1() {
		return dupX1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwap() {
		return swapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwapX1() {
		return swapX1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBranchInstruction() {
		return branchInstructionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBranchInstruction_Offset() {
		return (EAttribute)branchInstructionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranchInstruction_Target() {
		return (EReference)branchInstructionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIf() {
		return ifEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfn() {
		return ifnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGoto() {
		return gotoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIterate() {
		return iterateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnditerate() {
		return enditerateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvokeInstruction() {
		return invokeInstructionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvokeInstruction_Argcount() {
		return (EAttribute)invokeInstructionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvokeOperationInstruction() {
		return invokeOperationInstructionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvokeOperationInstruction_Opname() {
		return (EAttribute)invokeOperationInstructionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvoke() {
		return invokeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvokeSuper() {
		return invokeSuperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvokeStatic() {
		return invokeStaticEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAllinst() {
		return allinstEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAllinstIn() {
		return allinstInEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatch() {
		return matchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatch_Rulename() {
		return (EAttribute)matchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatchS() {
		return matchSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdd() {
		return addEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemove() {
		return removeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInsert() {
		return insertEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetSuper() {
		return getSuperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetenv() {
		return getenvEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReturn() {
		return returnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCodeBlockInstruction() {
		return codeBlockInstructionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeBlockInstruction_CodeBlock() {
		return (EReference)codeBlockInstructionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeBlockInstruction_CbIndex() {
		return (EAttribute)codeBlockInstructionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetcb() {
		return getcbEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvokeAllCbs() {
		return invokeAllCbsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvokeCb() {
		return invokeCbEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvokeCbS() {
		return invokeCbSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getModelDeclarationTag() {
		return modelDeclarationTagEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNot() {
		return notEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnd() {
		return andEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOr() {
		return orEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXor() {
		return xorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplies() {
		return impliesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfte() {
		return ifteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfte_ThenCbIndex() {
		return (EAttribute)ifteEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfte_ElseCbIndex() {
		return (EAttribute)ifteEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfte_ThenCb() {
		return (EReference)ifteEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfte_ElseCb() {
		return (EReference)ifteEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsnull() {
		return isnullEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetenvtype() {
		return getenvtypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFeatureTag() {
		return featureTagEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecEnv() {
		return execEnvEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecEnv_Modules() {
		return (EAttribute)execEnvEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecEnv_Matches() {
		return (EReference)execEnvEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecEnv_Traces() {
		return (EReference)execEnvEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecEnv_UniqueResults() {
		return (EAttribute)execEnvEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecEnv_JitDisabled() {
		return (EAttribute)execEnvEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecEnv_MetaModels() {
		return (EAttribute)execEnvEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecEnv_InputModels() {
		return (EAttribute)execEnvEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecEnv_InoutModels() {
		return (EAttribute)execEnvEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecEnv_OutputModels() {
		return (EAttribute)execEnvEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModel() {
		return modelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_Resource() {
		return (EAttribute)modelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_AllowInterModelReferences() {
		return (EAttribute)modelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetamodel() {
		return metamodelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleElement_Models() {
		return (EAttribute)ruleElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleElement_EModels() {
		return (EReference)ruleElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputRuleElement() {
		return inputRuleElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputRuleElement_Binding() {
		return (EReference)inputRuleElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputRuleElement_InputFor() {
		return (EReference)inputRuleElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputRuleElement() {
		return outputRuleElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputRuleElement_MapsTo() {
		return (EReference)outputRuleElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputRuleElement_OutputFor() {
		return (EReference)outputRuleElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOpcode() {
		return opcodeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRuleMode() {
		return ruleModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConstantTag() {
		return constantTagEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getStackFrame() {
		return stackFrameEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMethod() {
		return methodEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTimingData() {
		return timingDataEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getVMMonitor() {
		return vmMonitorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLazyCollection() {
		return lazyCollectionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLazyBag() {
		return lazyBagEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLazyList() {
		return lazyListEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLazyOrderedSet() {
		return lazyOrderedSetEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLazySet() {
		return lazySetEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEJavaObjectArray() {
		return eJavaObjectArrayEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEObjectArray() {
		return eObjectArrayEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEBooleanArray() {
		return eBooleanArrayEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEJavaSet() {
		return eJavaSetEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEJavaIterable() {
		return eJavaIterableEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getClassNotFoundException() {
		return classNotFoundExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getModuleResolver() {
		return moduleResolverEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEnumLiteral() {
		return enumLiteralEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmftvmFactory getEmftvmFactory() {
		return (EmftvmFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		execEnvEClass = createEClass(EXEC_ENV);
		createEAttribute(execEnvEClass, EXEC_ENV__META_MODELS);
		createEAttribute(execEnvEClass, EXEC_ENV__INPUT_MODELS);
		createEAttribute(execEnvEClass, EXEC_ENV__INOUT_MODELS);
		createEAttribute(execEnvEClass, EXEC_ENV__OUTPUT_MODELS);
		createEAttribute(execEnvEClass, EXEC_ENV__MODULES);
		createEReference(execEnvEClass, EXEC_ENV__MATCHES);
		createEReference(execEnvEClass, EXEC_ENV__TRACES);
		createEAttribute(execEnvEClass, EXEC_ENV__UNIQUE_RESULTS);
		createEAttribute(execEnvEClass, EXEC_ENV__JIT_DISABLED);

		modelEClass = createEClass(MODEL);
		createEAttribute(modelEClass, MODEL__RESOURCE);
		createEAttribute(modelEClass, MODEL__ALLOW_INTER_MODEL_REFERENCES);

		metamodelEClass = createEClass(METAMODEL);

		moduleEClass = createEClass(MODULE);
		createEAttribute(moduleEClass, MODULE__SOURCE_NAME);
		createEReference(moduleEClass, MODULE__FEATURES);
		createEReference(moduleEClass, MODULE__RULES);
		createEReference(moduleEClass, MODULE__EIMPORTS);
		createEAttribute(moduleEClass, MODULE__IMPORTS);
		createEReference(moduleEClass, MODULE__INPUT_MODELS);
		createEReference(moduleEClass, MODULE__INOUT_MODELS);
		createEReference(moduleEClass, MODULE__OUTPUT_MODELS);

		modelDeclarationEClass = createEClass(MODEL_DECLARATION);
		createEAttribute(modelDeclarationEClass, MODEL_DECLARATION__MODEL_NAME);
		createEAttribute(modelDeclarationEClass, MODEL_DECLARATION__META_MODEL_NAME);
		createEReference(modelDeclarationEClass, MODEL_DECLARATION__INPUT_MODEL_FOR);
		createEReference(modelDeclarationEClass, MODEL_DECLARATION__INOUT_MODEL_FOR);
		createEReference(modelDeclarationEClass, MODEL_DECLARATION__OUTPUT_MODEL_FOR);

		featureEClass = createEClass(FEATURE);
		createEAttribute(featureEClass, FEATURE__STATIC);
		createEReference(featureEClass, FEATURE__ECONTEXT);
		createEReference(featureEClass, FEATURE__MODULE);
		createEAttribute(featureEClass, FEATURE__CONTEXT);
		createEAttribute(featureEClass, FEATURE__CONTEXT_MODEL);

		fieldEClass = createEClass(FIELD);
		createEAttribute(fieldEClass, FIELD__STATIC_VALUE);
		createEReference(fieldEClass, FIELD__INITIALISER);
		createEReference(fieldEClass, FIELD__RULE);

		operationEClass = createEClass(OPERATION);
		createEReference(operationEClass, OPERATION__PARAMETERS);
		createEAttribute(operationEClass, OPERATION__QUERY);
		createEReference(operationEClass, OPERATION__BODY);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		parameterEClass = createEClass(PARAMETER);
		createEReference(parameterEClass, PARAMETER__OPERATION);

		typedElementEClass = createEClass(TYPED_ELEMENT);
		createEReference(typedElementEClass, TYPED_ELEMENT__ETYPE);
		createEAttribute(typedElementEClass, TYPED_ELEMENT__TYPE);
		createEAttribute(typedElementEClass, TYPED_ELEMENT__TYPE_MODEL);

		instructionEClass = createEClass(INSTRUCTION);
		createEReference(instructionEClass, INSTRUCTION__OWNING_BLOCK);
		createEAttribute(instructionEClass, INSTRUCTION__OPCODE);
		createEAttribute(instructionEClass, INSTRUCTION__STACK_PRODUCTION);
		createEAttribute(instructionEClass, INSTRUCTION__STACK_CONSUMPTION);
		createEAttribute(instructionEClass, INSTRUCTION__STACK_LEVEL);
		createEReference(instructionEClass, INSTRUCTION__LINE_NUMBER);

		lineNumberEClass = createEClass(LINE_NUMBER);
		createEAttribute(lineNumberEClass, LINE_NUMBER__START_LINE);
		createEAttribute(lineNumberEClass, LINE_NUMBER__START_COLUMN);
		createEAttribute(lineNumberEClass, LINE_NUMBER__END_LINE);
		createEAttribute(lineNumberEClass, LINE_NUMBER__END_COLUMN);
		createEAttribute(lineNumberEClass, LINE_NUMBER__START_CHAR);
		createEAttribute(lineNumberEClass, LINE_NUMBER__END_CHAR);
		createEReference(lineNumberEClass, LINE_NUMBER__OWNING_BLOCK);
		createEReference(lineNumberEClass, LINE_NUMBER__INSTRUCTIONS);

		localVariableEClass = createEClass(LOCAL_VARIABLE);
		createEAttribute(localVariableEClass, LOCAL_VARIABLE__SLOT);
		createEReference(localVariableEClass, LOCAL_VARIABLE__OWNING_BLOCK);
		createEReference(localVariableEClass, LOCAL_VARIABLE__START_INSTRUCTION);
		createEReference(localVariableEClass, LOCAL_VARIABLE__END_INSTRUCTION);
		createEAttribute(localVariableEClass, LOCAL_VARIABLE__START_INSTRUCTION_INDEX);
		createEAttribute(localVariableEClass, LOCAL_VARIABLE__END_INSTRUCTION_INDEX);

		ruleEClass = createEClass(RULE);
		createEReference(ruleEClass, RULE__MODULE);
		createEAttribute(ruleEClass, RULE__MODE);
		createEReference(ruleEClass, RULE__INPUT_ELEMENTS);
		createEReference(ruleEClass, RULE__OUTPUT_ELEMENTS);
		createEReference(ruleEClass, RULE__ESUPER_RULES);
		createEReference(ruleEClass, RULE__ESUB_RULES);
		createEReference(ruleEClass, RULE__MATCHER);
		createEReference(ruleEClass, RULE__APPLIER);
		createEReference(ruleEClass, RULE__POST_APPLY);
		createEAttribute(ruleEClass, RULE__SUPER_RULES);
		createEAttribute(ruleEClass, RULE__ABSTRACT);
		createEReference(ruleEClass, RULE__FIELDS);
		createEAttribute(ruleEClass, RULE__DEFAULT);
		createEAttribute(ruleEClass, RULE__DISTINCT_ELEMENTS);
		createEAttribute(ruleEClass, RULE__UNIQUE);
		createEAttribute(ruleEClass, RULE__LEAF);
		createEAttribute(ruleEClass, RULE__WITH_LEAVES);

		ruleElementEClass = createEClass(RULE_ELEMENT);
		createEAttribute(ruleElementEClass, RULE_ELEMENT__MODELS);
		createEReference(ruleElementEClass, RULE_ELEMENT__EMODELS);

		inputRuleElementEClass = createEClass(INPUT_RULE_ELEMENT);
		createEReference(inputRuleElementEClass, INPUT_RULE_ELEMENT__BINDING);
		createEReference(inputRuleElementEClass, INPUT_RULE_ELEMENT__INPUT_FOR);

		outputRuleElementEClass = createEClass(OUTPUT_RULE_ELEMENT);
		createEReference(outputRuleElementEClass, OUTPUT_RULE_ELEMENT__MAPS_TO);
		createEReference(outputRuleElementEClass, OUTPUT_RULE_ELEMENT__OUTPUT_FOR);

		codeBlockEClass = createEClass(CODE_BLOCK);
		createEAttribute(codeBlockEClass, CODE_BLOCK__MAX_LOCALS);
		createEAttribute(codeBlockEClass, CODE_BLOCK__MAX_STACK);
		createEReference(codeBlockEClass, CODE_BLOCK__CODE);
		createEReference(codeBlockEClass, CODE_BLOCK__LINE_NUMBERS);
		createEReference(codeBlockEClass, CODE_BLOCK__LOCAL_VARIABLES);
		createEReference(codeBlockEClass, CODE_BLOCK__MATCHER_FOR);
		createEReference(codeBlockEClass, CODE_BLOCK__APPLIER_FOR);
		createEReference(codeBlockEClass, CODE_BLOCK__POST_APPLY_FOR);
		createEReference(codeBlockEClass, CODE_BLOCK__BODY_FOR);
		createEReference(codeBlockEClass, CODE_BLOCK__INITIALISER_FOR);
		createEReference(codeBlockEClass, CODE_BLOCK__NESTED);
		createEReference(codeBlockEClass, CODE_BLOCK__NESTED_FOR);
		createEAttribute(codeBlockEClass, CODE_BLOCK__PARENT_FRAME);
		createEReference(codeBlockEClass, CODE_BLOCK__BINDING_FOR);

		pushEClass = createEClass(PUSH);
		createEAttribute(pushEClass, PUSH__VALUE);
		createEAttribute(pushEClass, PUSH__STRING_VALUE);
		createEAttribute(pushEClass, PUSH__INT_VALUE);
		createEAttribute(pushEClass, PUSH__DOUBLE_VALUE);
		createEAttribute(pushEClass, PUSH__BYTE_VALUE);
		createEAttribute(pushEClass, PUSH__CHAR_VALUE);
		createEAttribute(pushEClass, PUSH__FLOAT_VALUE);
		createEAttribute(pushEClass, PUSH__SHORT_VALUE);
		createEAttribute(pushEClass, PUSH__LONG_VALUE);
		createEAttribute(pushEClass, PUSH__ENUM_VALUE);

		pushtEClass = createEClass(PUSHT);

		pushfEClass = createEClass(PUSHF);

		popEClass = createEClass(POP);

		localVariableInstructionEClass = createEClass(LOCAL_VARIABLE_INSTRUCTION);
		createEAttribute(localVariableInstructionEClass, LOCAL_VARIABLE_INSTRUCTION__CB_OFFSET);
		createEAttribute(localVariableInstructionEClass, LOCAL_VARIABLE_INSTRUCTION__SLOT);
		createEAttribute(localVariableInstructionEClass, LOCAL_VARIABLE_INSTRUCTION__LOCAL_VARIABLE_INDEX);
		createEReference(localVariableInstructionEClass, LOCAL_VARIABLE_INSTRUCTION__LOCAL_VARIABLE);

		loadEClass = createEClass(LOAD);

		storeEClass = createEClass(STORE);

		fieldInstructionEClass = createEClass(FIELD_INSTRUCTION);
		createEAttribute(fieldInstructionEClass, FIELD_INSTRUCTION__FIELDNAME);

		setEClass = createEClass(SET);

		getEClass = createEClass(GET);

		getTransEClass = createEClass(GET_TRANS);

		setStaticEClass = createEClass(SET_STATIC);

		getStaticEClass = createEClass(GET_STATIC);

		findtypeEClass = createEClass(FINDTYPE);
		createEAttribute(findtypeEClass, FINDTYPE__MODELNAME);
		createEAttribute(findtypeEClass, FINDTYPE__TYPENAME);

		findtypeSEClass = createEClass(FINDTYPE_S);

		newEClass = createEClass(NEW);
		createEAttribute(newEClass, NEW__MODELNAME);

		newSEClass = createEClass(NEW_S);

		deleteEClass = createEClass(DELETE);

		dupEClass = createEClass(DUP);

		dupX1EClass = createEClass(DUP_X1);

		swapEClass = createEClass(SWAP);

		swapX1EClass = createEClass(SWAP_X1);

		branchInstructionEClass = createEClass(BRANCH_INSTRUCTION);
		createEAttribute(branchInstructionEClass, BRANCH_INSTRUCTION__OFFSET);
		createEReference(branchInstructionEClass, BRANCH_INSTRUCTION__TARGET);

		ifEClass = createEClass(IF);

		ifnEClass = createEClass(IFN);

		gotoEClass = createEClass(GOTO);

		iterateEClass = createEClass(ITERATE);

		enditerateEClass = createEClass(ENDITERATE);

		invokeInstructionEClass = createEClass(INVOKE_INSTRUCTION);
		createEAttribute(invokeInstructionEClass, INVOKE_INSTRUCTION__ARGCOUNT);

		invokeOperationInstructionEClass = createEClass(INVOKE_OPERATION_INSTRUCTION);
		createEAttribute(invokeOperationInstructionEClass, INVOKE_OPERATION_INSTRUCTION__OPNAME);

		invokeEClass = createEClass(INVOKE);

		invokeSuperEClass = createEClass(INVOKE_SUPER);

		invokeStaticEClass = createEClass(INVOKE_STATIC);

		allinstEClass = createEClass(ALLINST);

		allinstInEClass = createEClass(ALLINST_IN);

		isnullEClass = createEClass(ISNULL);

		getenvtypeEClass = createEClass(GETENVTYPE);

		notEClass = createEClass(NOT);

		andEClass = createEClass(AND);

		orEClass = createEClass(OR);

		xorEClass = createEClass(XOR);

		impliesEClass = createEClass(IMPLIES);

		ifteEClass = createEClass(IFTE);
		createEAttribute(ifteEClass, IFTE__THEN_CB_INDEX);
		createEAttribute(ifteEClass, IFTE__ELSE_CB_INDEX);
		createEReference(ifteEClass, IFTE__THEN_CB);
		createEReference(ifteEClass, IFTE__ELSE_CB);

		returnEClass = createEClass(RETURN);

		codeBlockInstructionEClass = createEClass(CODE_BLOCK_INSTRUCTION);
		createEAttribute(codeBlockInstructionEClass, CODE_BLOCK_INSTRUCTION__CB_INDEX);
		createEReference(codeBlockInstructionEClass, CODE_BLOCK_INSTRUCTION__CODE_BLOCK);

		getcbEClass = createEClass(GETCB);

		invokeAllCbsEClass = createEClass(INVOKE_ALL_CBS);

		invokeCbEClass = createEClass(INVOKE_CB);

		invokeCbSEClass = createEClass(INVOKE_CB_S);

		matchEClass = createEClass(MATCH);
		createEAttribute(matchEClass, MATCH__RULENAME);

		matchSEClass = createEClass(MATCH_S);

		addEClass = createEClass(ADD);

		removeEClass = createEClass(REMOVE);

		insertEClass = createEClass(INSERT);

		getSuperEClass = createEClass(GET_SUPER);

		getenvEClass = createEClass(GETENV);

		// Create enums
		modelDeclarationTagEEnum = createEEnum(MODEL_DECLARATION_TAG);
		featureTagEEnum = createEEnum(FEATURE_TAG);
		opcodeEEnum = createEEnum(OPCODE);
		ruleModeEEnum = createEEnum(RULE_MODE);
		constantTagEEnum = createEEnum(CONSTANT_TAG);

		// Create data types
		moduleResolverEDataType = createEDataType(MODULE_RESOLVER);
		enumLiteralEDataType = createEDataType(ENUM_LITERAL);
		stackFrameEDataType = createEDataType(STACK_FRAME);
		methodEDataType = createEDataType(METHOD);
		timingDataEDataType = createEDataType(TIMING_DATA);
		vmMonitorEDataType = createEDataType(VM_MONITOR);
		lazyCollectionEDataType = createEDataType(LAZY_COLLECTION);
		lazyBagEDataType = createEDataType(LAZY_BAG);
		lazyListEDataType = createEDataType(LAZY_LIST);
		lazyOrderedSetEDataType = createEDataType(LAZY_ORDERED_SET);
		lazySetEDataType = createEDataType(LAZY_SET);
		eJavaObjectArrayEDataType = createEDataType(EJAVA_OBJECT_ARRAY);
		eObjectArrayEDataType = createEDataType(EOBJECT_ARRAY);
		eBooleanArrayEDataType = createEDataType(EBOOLEAN_ARRAY);
		eJavaSetEDataType = createEDataType(EJAVA_SET);
		eJavaIterableEDataType = createEDataType(EJAVA_ITERABLE);
		classNotFoundExceptionEDataType = createEDataType(CLASS_NOT_FOUND_EXCEPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		TracePackage theTracePackage = (TracePackage)EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI);

		// Create type parameters
		addETypeParameter(lazyCollectionEDataType, "E");
		addETypeParameter(lazyBagEDataType, "E");
		addETypeParameter(lazyListEDataType, "E");
		addETypeParameter(lazyOrderedSetEDataType, "E");
		addETypeParameter(lazySetEDataType, "E");
		addETypeParameter(eJavaSetEDataType, "E");
		addETypeParameter(eJavaIterableEDataType, "E");

		// Set bounds for type parameters

		// Add supertypes to classes
		metamodelEClass.getESuperTypes().add(this.getModel());
		moduleEClass.getESuperTypes().add(this.getNamedElement());
		featureEClass.getESuperTypes().add(this.getTypedElement());
		fieldEClass.getESuperTypes().add(this.getFeature());
		operationEClass.getESuperTypes().add(this.getFeature());
		parameterEClass.getESuperTypes().add(this.getTypedElement());
		typedElementEClass.getESuperTypes().add(this.getNamedElement());
		localVariableEClass.getESuperTypes().add(this.getTypedElement());
		ruleEClass.getESuperTypes().add(this.getNamedElement());
		ruleElementEClass.getESuperTypes().add(this.getTypedElement());
		inputRuleElementEClass.getESuperTypes().add(this.getRuleElement());
		outputRuleElementEClass.getESuperTypes().add(this.getRuleElement());
		pushEClass.getESuperTypes().add(this.getInstruction());
		pushtEClass.getESuperTypes().add(this.getInstruction());
		pushfEClass.getESuperTypes().add(this.getInstruction());
		popEClass.getESuperTypes().add(this.getInstruction());
		localVariableInstructionEClass.getESuperTypes().add(this.getInstruction());
		loadEClass.getESuperTypes().add(this.getLocalVariableInstruction());
		storeEClass.getESuperTypes().add(this.getLocalVariableInstruction());
		fieldInstructionEClass.getESuperTypes().add(this.getInstruction());
		setEClass.getESuperTypes().add(this.getFieldInstruction());
		getEClass.getESuperTypes().add(this.getFieldInstruction());
		getTransEClass.getESuperTypes().add(this.getFieldInstruction());
		setStaticEClass.getESuperTypes().add(this.getFieldInstruction());
		getStaticEClass.getESuperTypes().add(this.getFieldInstruction());
		findtypeEClass.getESuperTypes().add(this.getInstruction());
		findtypeSEClass.getESuperTypes().add(this.getInstruction());
		newEClass.getESuperTypes().add(this.getInstruction());
		newSEClass.getESuperTypes().add(this.getInstruction());
		deleteEClass.getESuperTypes().add(this.getInstruction());
		dupEClass.getESuperTypes().add(this.getInstruction());
		dupX1EClass.getESuperTypes().add(this.getInstruction());
		swapEClass.getESuperTypes().add(this.getInstruction());
		swapX1EClass.getESuperTypes().add(this.getInstruction());
		branchInstructionEClass.getESuperTypes().add(this.getInstruction());
		ifEClass.getESuperTypes().add(this.getBranchInstruction());
		ifnEClass.getESuperTypes().add(this.getBranchInstruction());
		gotoEClass.getESuperTypes().add(this.getBranchInstruction());
		iterateEClass.getESuperTypes().add(this.getBranchInstruction());
		enditerateEClass.getESuperTypes().add(this.getBranchInstruction());
		invokeInstructionEClass.getESuperTypes().add(this.getInstruction());
		invokeOperationInstructionEClass.getESuperTypes().add(this.getInvokeInstruction());
		invokeEClass.getESuperTypes().add(this.getInvokeOperationInstruction());
		invokeSuperEClass.getESuperTypes().add(this.getInvokeOperationInstruction());
		invokeStaticEClass.getESuperTypes().add(this.getInvokeOperationInstruction());
		allinstEClass.getESuperTypes().add(this.getInstruction());
		allinstInEClass.getESuperTypes().add(this.getInstruction());
		isnullEClass.getESuperTypes().add(this.getInstruction());
		getenvtypeEClass.getESuperTypes().add(this.getInstruction());
		notEClass.getESuperTypes().add(this.getInstruction());
		andEClass.getESuperTypes().add(this.getCodeBlockInstruction());
		orEClass.getESuperTypes().add(this.getCodeBlockInstruction());
		xorEClass.getESuperTypes().add(this.getInstruction());
		impliesEClass.getESuperTypes().add(this.getCodeBlockInstruction());
		ifteEClass.getESuperTypes().add(this.getInstruction());
		returnEClass.getESuperTypes().add(this.getInstruction());
		codeBlockInstructionEClass.getESuperTypes().add(this.getInstruction());
		getcbEClass.getESuperTypes().add(this.getCodeBlockInstruction());
		invokeAllCbsEClass.getESuperTypes().add(this.getInvokeInstruction());
		invokeCbEClass.getESuperTypes().add(this.getCodeBlockInstruction());
		invokeCbEClass.getESuperTypes().add(this.getInvokeInstruction());
		invokeCbSEClass.getESuperTypes().add(this.getInvokeInstruction());
		matchEClass.getESuperTypes().add(this.getInvokeInstruction());
		matchSEClass.getESuperTypes().add(this.getInvokeInstruction());
		addEClass.getESuperTypes().add(this.getFieldInstruction());
		removeEClass.getESuperTypes().add(this.getFieldInstruction());
		insertEClass.getESuperTypes().add(this.getFieldInstruction());
		getSuperEClass.getESuperTypes().add(this.getFieldInstruction());
		getenvEClass.getESuperTypes().add(this.getInstruction());

		// Initialize classes and features; add operations and parameters
		initEClass(execEnvEClass, ExecEnv.class, "ExecEnv", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		EGenericType g1 = createEGenericType(theEcorePackage.getEMap());
		EGenericType g2 = createEGenericType(theEcorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getMetamodel());
		g1.getETypeArguments().add(g2);
		initEAttribute(getExecEnv_MetaModels(), g1, "metaModels", "", 1, 1, ExecEnv.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(theEcorePackage.getEMap());
		g2 = createEGenericType(theEcorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getModel());
		g1.getETypeArguments().add(g2);
		initEAttribute(getExecEnv_InputModels(), g1, "inputModels", "", 1, 1, ExecEnv.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(theEcorePackage.getEMap());
		g2 = createEGenericType(theEcorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getModel());
		g1.getETypeArguments().add(g2);
		initEAttribute(getExecEnv_InoutModels(), g1, "inoutModels", "", 1, 1, ExecEnv.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(theEcorePackage.getEMap());
		g2 = createEGenericType(theEcorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getModel());
		g1.getETypeArguments().add(g2);
		initEAttribute(getExecEnv_OutputModels(), g1, "outputModels", "", 1, 1, ExecEnv.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(theEcorePackage.getEMap());
		g2 = createEGenericType(theEcorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getModule());
		g1.getETypeArguments().add(g2);
		initEAttribute(getExecEnv_Modules(), g1, "modules", null, 1, 1, ExecEnv.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getExecEnv_Matches(), theTracePackage.getTraceLinkSet(), null, "matches", null, 1, 1, ExecEnv.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getExecEnv_Traces(), theTracePackage.getTraceLinkSet(), null, "traces", null, 1, 1, ExecEnv.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(theEcorePackage.getEMap());
		g2 = createEGenericType(theTracePackage.getTraceLink());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		initEAttribute(getExecEnv_UniqueResults(), g1, "uniqueResults", null, 1, 1, ExecEnv.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecEnv_JitDisabled(), theEcorePackage.getEBoolean(), "jitDisabled", null, 1, 1, ExecEnv.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(execEnvEClass, this.getModule(), "loadModule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModuleResolver(), "resolver", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, this.getOperation(), "findOperation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEJavaObjectArray(), "parameterTypes", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, this.getOperation(), "findOperation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, this.getOperation(), "findOperation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "parameterType", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, theEcorePackage.getEBoolean(), "hasOperation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEInt(), "argcount", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, this.getOperation(), "findStaticOperation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEJavaObjectArray(), "parameterTypes", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, this.getOperation(), "findStaticOperation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, this.getOperation(), "findStaticOperation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "parameterType", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, theEcorePackage.getEBoolean(), "hasStaticOperation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEInt(), "argcount", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, this.getField(), "findField", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, theEcorePackage.getEBoolean(), "hasField", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, this.getField(), "findStaticField", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, theEcorePackage.getEBoolean(), "hasStaticField", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, this.getRule(), "findRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, theEcorePackage.getEJavaObject(), "findType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "modelName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "typeName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getClassNotFoundException());

		op = addEOperation(execEnvEClass, theEcorePackage.getEJavaObject(), "run", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTimingData(), "timingData", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, null, "getRules", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getLazyList());
		g2 = createEGenericType(this.getRule());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(execEnvEClass, this.getModel(), "getModelOf", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, theEcorePackage.getEString(), "getModelID", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModel(), "model", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, theEcorePackage.getEString(), "getMetaModelID", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMetamodel(), "metamodel", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, null, "queueForDelete", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEObject(), "element", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStackFrame(), "frame", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(execEnvEClass, null, "deleteQueue", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, this.getModel(), "getInputModelOf", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, this.getModel(), "getInoutModelOf", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, this.getModel(), "getOutputModelOf", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(execEnvEClass, this.getVMMonitor(), "getMonitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, null, "setMonitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVMMonitor(), "monitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, null, "registerMetaModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMetamodel(), "metamodel", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, null, "registerInputModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModel(), "model", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, null, "registerInOutModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModel(), "model", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, null, "registerOutputModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModel(), "model", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(execEnvEClass, this.getMetamodel(), "getMetaModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEResource(), "resource", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModel_Resource(), theEcorePackage.getEResource(), "resource", null, 1, 1, Model.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_AllowInterModelReferences(), theEcorePackage.getEBoolean(), "allowInterModelReferences", "true", 1, 1, Model.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(modelEClass, null, "allInstancesOf", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getLazyList());
		g2 = createEGenericType(theEcorePackage.getEObject());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(modelEClass, theEcorePackage.getEObject(), "newElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(modelEClass, null, "deleteElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEObject(), "element", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(metamodelEClass, Metamodel.class, "Metamodel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(metamodelEClass, theEcorePackage.getEClassifier(), "findType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "typeName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModule_SourceName(), theEcorePackage.getEString(), "sourceName", null, 1, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_Features(), this.getFeature(), this.getFeature_Module(), "features", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_Rules(), this.getRule(), this.getRule_Module(), "rules", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_EImports(), this.getModule(), null, "eImports", null, 0, -1, Module.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getModule_Imports(), theEcorePackage.getEString(), "imports", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_InputModels(), this.getModelDeclaration(), this.getModelDeclaration_InputModelFor(), "inputModels", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_InoutModels(), this.getModelDeclaration(), this.getModelDeclaration_InoutModelFor(), "inoutModels", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_OutputModels(), this.getModelDeclaration(), this.getModelDeclaration_OutputModelFor(), "outputModels", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelDeclarationEClass, ModelDeclaration.class, "ModelDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelDeclaration_ModelName(), theEcorePackage.getEString(), "modelName", null, 1, 1, ModelDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelDeclaration_MetaModelName(), theEcorePackage.getEString(), "metaModelName", null, 1, 1, ModelDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelDeclaration_InputModelFor(), this.getModule(), this.getModule_InputModels(), "inputModelFor", null, 0, 1, ModelDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelDeclaration_InoutModelFor(), this.getModule(), this.getModule_InoutModels(), "inoutModelFor", null, 0, 1, ModelDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelDeclaration_OutputModelFor(), this.getModule(), this.getModule_OutputModels(), "outputModelFor", null, 0, 1, ModelDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureEClass, Feature.class, "Feature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeature_Static(), ecorePackage.getEBoolean(), "static", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeature_EContext(), theEcorePackage.getEClassifier(), null, "eContext", null, 0, 1, Feature.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFeature_Module(), this.getModule(), this.getModule_Features(), "module", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_Context(), theEcorePackage.getEString(), "context", null, 1, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_ContextModel(), theEcorePackage.getEString(), "contextModel", null, 1, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fieldEClass, Field.class, "Field", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getField_StaticValue(), theEcorePackage.getEJavaObject(), "staticValue", null, 0, 1, Field.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getField_Initialiser(), this.getCodeBlock(), this.getCodeBlock_InitialiserFor(), "initialiser", null, 1, 1, Field.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getField_Rule(), this.getRule(), this.getRule_Fields(), "rule", null, 0, 1, Field.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(fieldEClass, theEcorePackage.getEJavaObject(), "getValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(fieldEClass, null, "setValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(fieldEClass, theEcorePackage.getEJavaObject(), "getValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStackFrame(), "frame", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(fieldEClass, theEcorePackage.getEJavaObject(), "getStaticValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStackFrame(), "frame", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(fieldEClass, null, "clear", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperation_Parameters(), this.getParameter(), this.getParameter_Operation(), "parameters", null, 0, -1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperation_Query(), theEcorePackage.getEBoolean(), "query", null, 1, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperation_Body(), this.getCodeBlock(), this.getCodeBlock_BodyFor(), "body", null, 1, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameter_Operation(), this.getOperation(), this.getOperation_Parameters(), "operation", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typedElementEClass, TypedElement.class, "TypedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedElement_EType(), theEcorePackage.getEClassifier(), null, "eType", null, 0, 1, TypedElement.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypedElement_Type(), theEcorePackage.getEString(), "type", null, 0, 1, TypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypedElement_TypeModel(), theEcorePackage.getEString(), "typeModel", null, 0, 1, TypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(instructionEClass, Instruction.class, "Instruction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstruction_OwningBlock(), this.getCodeBlock(), this.getCodeBlock_Code(), "owningBlock", null, 1, 1, Instruction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstruction_Opcode(), this.getOpcode(), "opcode", "", 1, 1, Instruction.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstruction_StackProduction(), theEcorePackage.getEInt(), "stackProduction", "0", 1, 1, Instruction.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstruction_StackConsumption(), theEcorePackage.getEInt(), "stackConsumption", "0", 1, 1, Instruction.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstruction_StackLevel(), theEcorePackage.getEInt(), "stackLevel", "0", 1, 1, Instruction.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getInstruction_LineNumber(), this.getLineNumber(), this.getLineNumber_Instructions(), "lineNumber", null, 0, 1, Instruction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lineNumberEClass, LineNumber.class, "LineNumber", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLineNumber_StartLine(), theEcorePackage.getEInt(), "startLine", "-1", 1, 1, LineNumber.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLineNumber_StartColumn(), theEcorePackage.getEInt(), "startColumn", "-1", 1, 1, LineNumber.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLineNumber_EndLine(), theEcorePackage.getEInt(), "endLine", "-1", 1, 1, LineNumber.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLineNumber_EndColumn(), theEcorePackage.getEInt(), "endColumn", "-1", 1, 1, LineNumber.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLineNumber_StartChar(), theEcorePackage.getEInt(), "startChar", "-1", 1, 1, LineNumber.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLineNumber_EndChar(), theEcorePackage.getEInt(), "endChar", "-1", 1, 1, LineNumber.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLineNumber_OwningBlock(), this.getCodeBlock(), this.getCodeBlock_LineNumbers(), "owningBlock", null, 1, 1, LineNumber.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLineNumber_Instructions(), this.getInstruction(), this.getInstruction_LineNumber(), "instructions", null, 0, -1, LineNumber.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(localVariableEClass, LocalVariable.class, "LocalVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLocalVariable_Slot(), theEcorePackage.getEInt(), "slot", "-1", 1, 1, LocalVariable.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getLocalVariable_OwningBlock(), this.getCodeBlock(), this.getCodeBlock_LocalVariables(), "owningBlock", null, 1, 1, LocalVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLocalVariable_StartInstruction(), this.getInstruction(), null, "startInstruction", null, 0, 1, LocalVariable.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLocalVariable_EndInstruction(), this.getInstruction(), null, "endInstruction", null, 0, 1, LocalVariable.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalVariable_StartInstructionIndex(), theEcorePackage.getEInt(), "startInstructionIndex", "-1", 0, 1, LocalVariable.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalVariable_EndInstructionIndex(), theEcorePackage.getEInt(), "endInstructionIndex", "-1", 0, 1, LocalVariable.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRule_Module(), this.getModule(), this.getModule_Rules(), "module", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRule_Mode(), this.getRuleMode(), "mode", null, 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_InputElements(), this.getInputRuleElement(), this.getInputRuleElement_InputFor(), "inputElements", null, 1, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_OutputElements(), this.getOutputRuleElement(), this.getOutputRuleElement_OutputFor(), "outputElements", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_ESuperRules(), this.getRule(), this.getRule_ESubRules(), "eSuperRules", null, 0, -1, Rule.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getRule_ESubRules(), this.getRule(), this.getRule_ESuperRules(), "eSubRules", null, 0, -1, Rule.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getRule_Matcher(), this.getCodeBlock(), this.getCodeBlock_MatcherFor(), "matcher", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_Applier(), this.getCodeBlock(), this.getCodeBlock_ApplierFor(), "applier", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_PostApply(), this.getCodeBlock(), this.getCodeBlock_PostApplyFor(), "postApply", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRule_SuperRules(), theEcorePackage.getEString(), "superRules", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRule_Abstract(), theEcorePackage.getEBoolean(), "abstract", null, 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_Fields(), this.getField(), this.getField_Rule(), "fields", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRule_Default(), theEcorePackage.getEBoolean(), "default", null, 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRule_DistinctElements(), theEcorePackage.getEBoolean(), "distinctElements", null, 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRule_Unique(), theEcorePackage.getEBoolean(), "unique", null, 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRule_Leaf(), theEcorePackage.getEBoolean(), "leaf", null, 1, 1, Rule.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getRule_WithLeaves(), theEcorePackage.getEBoolean(), "withLeaves", null, 1, 1, Rule.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = addEOperation(ruleEClass, this.getField(), "findField", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(ruleEClass, theEcorePackage.getEBoolean(), "hasField", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(ruleEClass, this.getField(), "findStaticField", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(ruleEClass, theEcorePackage.getEBoolean(), "hasStaticField", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(ruleEClass, null, "registerField", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getField(), "field", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(ruleEClass, theEcorePackage.getEBoolean(), "matchSingle", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStackFrame(), "frame", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(ruleEClass, this.getEBooleanArray(), "matchRecursive", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStackFrame(), "frame", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(ruleEClass, ecorePackage.getEJavaObject(), "matchManual", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStackFrame(), "frame", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEObjectArray(), "values", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(ruleEClass, theEcorePackage.getEBoolean(), "matchOne", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStackFrame(), "frame", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theEcorePackage.getEMap());
		g2 = createEGenericType(theEcorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "valuesMap", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(ruleEClass, null, "createTraces", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStackFrame(), "frame", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(ruleEClass, theEcorePackage.getEBoolean(), "completeTraceFor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStackFrame(), "frame", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTracePackage.getTraceLink(), "trace", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(ruleEClass, null, "apply", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStackFrame(), "frame", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(ruleEClass, null, "postApply", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStackFrame(), "frame", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(ruleEClass, theEcorePackage.getEBoolean(), "applyFirst", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStackFrame(), "frame", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(ruleEClass, this.getStackFrame(), "applyFor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStackFrame(), "frame", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTracePackage.getTraceLink(), "trace", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(ruleEClass, this.getStackFrame(), "postApplyFor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStackFrame(), "frame", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTracePackage.getTraceLink(), "trace", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(ruleEClass, null, "getAllESuperRules", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getLazySet());
		g2 = createEGenericType(this.getRule());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(ruleEClass, null, "createUniqueMapping", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTracePackage.getTraceLink(), "trace", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(ruleEClass, null, "compileState", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getExecEnv(), "env", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(ruleEClass, null, "resetState", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(ruleElementEClass, RuleElement.class, "RuleElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRuleElement_Models(), theEcorePackage.getEString(), "models", null, 0, -1, RuleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleElement_EModels(), this.getModel(), null, "eModels", null, 0, -1, RuleElement.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(inputRuleElementEClass, InputRuleElement.class, "InputRuleElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputRuleElement_Binding(), this.getCodeBlock(), this.getCodeBlock_BindingFor(), "binding", null, 0, 1, InputRuleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInputRuleElement_InputFor(), this.getRule(), this.getRule_InputElements(), "inputFor", null, 0, 1, InputRuleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(inputRuleElementEClass, null, "createIterable", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getExecEnv(), "env", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getEJavaIterable());
		g2 = createEGenericType(theEcorePackage.getEObject());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(outputRuleElementEClass, OutputRuleElement.class, "OutputRuleElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputRuleElement_MapsTo(), this.getInputRuleElement(), null, "mapsTo", null, 0, -1, OutputRuleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutputRuleElement_OutputFor(), this.getRule(), this.getRule_OutputElements(), "outputFor", null, 0, 1, OutputRuleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(codeBlockEClass, CodeBlock.class, "CodeBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCodeBlock_MaxLocals(), theEcorePackage.getEInt(), "maxLocals", "-1", 1, 1, CodeBlock.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeBlock_MaxStack(), theEcorePackage.getEInt(), "maxStack", "-1", 1, 1, CodeBlock.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getCodeBlock_Code(), this.getInstruction(), this.getInstruction_OwningBlock(), "code", null, 0, -1, CodeBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeBlock_LineNumbers(), this.getLineNumber(), this.getLineNumber_OwningBlock(), "lineNumbers", null, 0, -1, CodeBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeBlock_LocalVariables(), this.getLocalVariable(), this.getLocalVariable_OwningBlock(), "localVariables", null, 0, -1, CodeBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeBlock_MatcherFor(), this.getRule(), this.getRule_Matcher(), "matcherFor", null, 0, 1, CodeBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeBlock_ApplierFor(), this.getRule(), this.getRule_Applier(), "applierFor", null, 0, 1, CodeBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeBlock_PostApplyFor(), this.getRule(), this.getRule_PostApply(), "postApplyFor", null, 0, 1, CodeBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeBlock_BodyFor(), this.getOperation(), this.getOperation_Body(), "bodyFor", null, 0, 1, CodeBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeBlock_InitialiserFor(), this.getField(), this.getField_Initialiser(), "initialiserFor", null, 0, 1, CodeBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeBlock_Nested(), this.getCodeBlock(), this.getCodeBlock_NestedFor(), "nested", null, 0, -1, CodeBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeBlock_NestedFor(), this.getCodeBlock(), this.getCodeBlock_Nested(), "nestedFor", null, 0, 1, CodeBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeBlock_ParentFrame(), this.getStackFrame(), "parentFrame", null, 0, 1, CodeBlock.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeBlock_BindingFor(), this.getInputRuleElement(), this.getInputRuleElement_Binding(), "bindingFor", null, 0, 1, CodeBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(codeBlockEClass, this.getStackFrame(), "execute", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStackFrame(), "frame", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(codeBlockEClass, theEcorePackage.getEInt(), "getStackLevel", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(codeBlockEClass, this.getModule(), "getModule", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(codeBlockEClass, this.getOperation(), "getOperation", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(codeBlockEClass, this.getField(), "getField", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(codeBlockEClass, this.getInstruction(), "getPredecessors", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getInstruction(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(codeBlockEClass, this.getInstruction(), "getAllPredecessors", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getInstruction(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(codeBlockEClass, this.getInstruction(), "getNonLoopingPredecessors", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getInstruction(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(pushEClass, Push.class, "Push", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPush_Value(), theEcorePackage.getEJavaObject(), "value", null, 0, 1, Push.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPush_StringValue(), theEcorePackage.getEString(), "stringValue", "", 0, 1, Push.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPush_IntValue(), theEcorePackage.getEIntegerObject(), "intValue", "", 0, 1, Push.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPush_DoubleValue(), theEcorePackage.getEDoubleObject(), "doubleValue", null, 0, 1, Push.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPush_ByteValue(), theEcorePackage.getEByteObject(), "byteValue", null, 0, 1, Push.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPush_CharValue(), theEcorePackage.getECharacterObject(), "charValue", null, 0, 1, Push.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPush_FloatValue(), theEcorePackage.getEFloatObject(), "floatValue", null, 0, 1, Push.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPush_ShortValue(), theEcorePackage.getEShortObject(), "shortValue", null, 0, 1, Push.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPush_LongValue(), theEcorePackage.getELongObject(), "longValue", null, 0, 1, Push.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPush_EnumValue(), theEcorePackage.getEString(), "enumValue", null, 0, 1, Push.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pushtEClass, Pusht.class, "Pusht", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pushfEClass, Pushf.class, "Pushf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(popEClass, Pop.class, "Pop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(localVariableInstructionEClass, LocalVariableInstruction.class, "LocalVariableInstruction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLocalVariableInstruction_CbOffset(), theEcorePackage.getEInt(), "cbOffset", "-1", 1, 1, LocalVariableInstruction.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalVariableInstruction_Slot(), theEcorePackage.getEInt(), "slot", "-1", 1, 1, LocalVariableInstruction.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalVariableInstruction_LocalVariableIndex(), theEcorePackage.getEInt(), "localVariableIndex", "-1", 1, 1, LocalVariableInstruction.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getLocalVariableInstruction_LocalVariable(), this.getLocalVariable(), null, "localVariable", null, 1, 1, LocalVariableInstruction.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loadEClass, Load.class, "Load", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(storeEClass, Store.class, "Store", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fieldInstructionEClass, FieldInstruction.class, "FieldInstruction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFieldInstruction_Fieldname(), theEcorePackage.getEString(), "fieldname", null, 1, 1, FieldInstruction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setEClass, Set.class, "Set", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(getEClass, Get.class, "Get", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(getTransEClass, GetTrans.class, "GetTrans", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(setStaticEClass, SetStatic.class, "SetStatic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(getStaticEClass, GetStatic.class, "GetStatic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(findtypeEClass, Findtype.class, "Findtype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFindtype_Modelname(), theEcorePackage.getEString(), "modelname", null, 1, 1, Findtype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFindtype_Typename(), theEcorePackage.getEString(), "typename", null, 1, 1, Findtype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(findtypeSEClass, FindtypeS.class, "FindtypeS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(newEClass, New.class, "New", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNew_Modelname(), theEcorePackage.getEString(), "modelname", null, 0, 1, New.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newSEClass, NewS.class, "NewS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(deleteEClass, Delete.class, "Delete", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dupEClass, Dup.class, "Dup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dupX1EClass, DupX1.class, "DupX1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(swapEClass, Swap.class, "Swap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(swapX1EClass, SwapX1.class, "SwapX1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(branchInstructionEClass, BranchInstruction.class, "BranchInstruction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBranchInstruction_Offset(), theEcorePackage.getEInt(), "offset", "-1", 1, 1, BranchInstruction.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getBranchInstruction_Target(), this.getInstruction(), null, "target", null, 1, 1, BranchInstruction.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ifEClass, If.class, "If", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ifnEClass, Ifn.class, "Ifn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(gotoEClass, Goto.class, "Goto", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iterateEClass, Iterate.class, "Iterate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(enditerateEClass, Enditerate.class, "Enditerate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(invokeInstructionEClass, InvokeInstruction.class, "InvokeInstruction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInvokeInstruction_Argcount(), theEcorePackage.getEInt(), "argcount", null, 1, 1, InvokeInstruction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(invokeOperationInstructionEClass, InvokeOperationInstruction.class, "InvokeOperationInstruction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInvokeOperationInstruction_Opname(), theEcorePackage.getEString(), "opname", null, 1, 1, InvokeOperationInstruction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(invokeEClass, Invoke.class, "Invoke", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(invokeSuperEClass, InvokeSuper.class, "InvokeSuper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(invokeStaticEClass, InvokeStatic.class, "InvokeStatic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(allinstEClass, Allinst.class, "Allinst", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(allinstInEClass, AllinstIn.class, "AllinstIn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isnullEClass, Isnull.class, "Isnull", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(getenvtypeEClass, Getenvtype.class, "Getenvtype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(notEClass, Not.class, "Not", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(andEClass, And.class, "And", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orEClass, Or.class, "Or", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xorEClass, Xor.class, "Xor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(impliesEClass, Implies.class, "Implies", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ifteEClass, Ifte.class, "Ifte", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIfte_ThenCbIndex(), theEcorePackage.getEInt(), "thenCbIndex", "-1", 1, 1, Ifte.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getIfte_ElseCbIndex(), theEcorePackage.getEInt(), "elseCbIndex", "-1", 1, 1, Ifte.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getIfte_ThenCb(), this.getCodeBlock(), null, "thenCb", null, 1, 1, Ifte.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfte_ElseCb(), this.getCodeBlock(), null, "elseCb", null, 1, 1, Ifte.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(returnEClass, Return.class, "Return", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(codeBlockInstructionEClass, CodeBlockInstruction.class, "CodeBlockInstruction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCodeBlockInstruction_CbIndex(), theEcorePackage.getEInt(), "cbIndex", "-1", 1, 1, CodeBlockInstruction.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getCodeBlockInstruction_CodeBlock(), this.getCodeBlock(), null, "codeBlock", null, 1, 1, CodeBlockInstruction.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getcbEClass, Getcb.class, "Getcb", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(invokeAllCbsEClass, InvokeAllCbs.class, "InvokeAllCbs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(invokeCbEClass, InvokeCb.class, "InvokeCb", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(invokeCbSEClass, InvokeCbS.class, "InvokeCbS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(matchEClass, Match.class, "Match", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMatch_Rulename(), theEcorePackage.getEString(), "rulename", null, 1, 1, Match.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(matchSEClass, MatchS.class, "MatchS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(addEClass, Add.class, "Add", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(removeEClass, Remove.class, "Remove", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(insertEClass, Insert.class, "Insert", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(getSuperEClass, GetSuper.class, "GetSuper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(getenvEClass, Getenv.class, "Getenv", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(modelDeclarationTagEEnum, ModelDeclarationTag.class, "ModelDeclarationTag");
		addEEnumLiteral(modelDeclarationTagEEnum, ModelDeclarationTag.INPUT);
		addEEnumLiteral(modelDeclarationTagEEnum, ModelDeclarationTag.INOUT);
		addEEnumLiteral(modelDeclarationTagEEnum, ModelDeclarationTag.OUTPUT);

		initEEnum(featureTagEEnum, FeatureTag.class, "FeatureTag");
		addEEnumLiteral(featureTagEEnum, FeatureTag.FIELD);
		addEEnumLiteral(featureTagEEnum, FeatureTag.STATIC_FIELD);
		addEEnumLiteral(featureTagEEnum, FeatureTag.OPERATION);
		addEEnumLiteral(featureTagEEnum, FeatureTag.STATIC_OPERATION);
		addEEnumLiteral(featureTagEEnum, FeatureTag.QUERY_OPERATION);
		addEEnumLiteral(featureTagEEnum, FeatureTag.STATIC_QUERY_OPERATION);

		initEEnum(opcodeEEnum, Opcode.class, "Opcode");
		addEEnumLiteral(opcodeEEnum, Opcode.PUSH);
		addEEnumLiteral(opcodeEEnum, Opcode.PUSHT);
		addEEnumLiteral(opcodeEEnum, Opcode.PUSHF);
		addEEnumLiteral(opcodeEEnum, Opcode.POP);
		addEEnumLiteral(opcodeEEnum, Opcode.LOAD);
		addEEnumLiteral(opcodeEEnum, Opcode.STORE);
		addEEnumLiteral(opcodeEEnum, Opcode.SET);
		addEEnumLiteral(opcodeEEnum, Opcode.GET);
		addEEnumLiteral(opcodeEEnum, Opcode.GET_TRANS);
		addEEnumLiteral(opcodeEEnum, Opcode.SET_STATIC);
		addEEnumLiteral(opcodeEEnum, Opcode.GET_STATIC);
		addEEnumLiteral(opcodeEEnum, Opcode.FINDTYPE);
		addEEnumLiteral(opcodeEEnum, Opcode.FINDTYPE_S);
		addEEnumLiteral(opcodeEEnum, Opcode.NEW);
		addEEnumLiteral(opcodeEEnum, Opcode.NEW_S);
		addEEnumLiteral(opcodeEEnum, Opcode.DELETE);
		addEEnumLiteral(opcodeEEnum, Opcode.DUP);
		addEEnumLiteral(opcodeEEnum, Opcode.DUP_X1);
		addEEnumLiteral(opcodeEEnum, Opcode.SWAP);
		addEEnumLiteral(opcodeEEnum, Opcode.SWAP_X1);
		addEEnumLiteral(opcodeEEnum, Opcode.IF);
		addEEnumLiteral(opcodeEEnum, Opcode.IFN);
		addEEnumLiteral(opcodeEEnum, Opcode.GOTO);
		addEEnumLiteral(opcodeEEnum, Opcode.ITERATE);
		addEEnumLiteral(opcodeEEnum, Opcode.ENDITERATE);
		addEEnumLiteral(opcodeEEnum, Opcode.INVOKE);
		addEEnumLiteral(opcodeEEnum, Opcode.INVOKE_SUPER);
		addEEnumLiteral(opcodeEEnum, Opcode.INVOKE_STATIC);
		addEEnumLiteral(opcodeEEnum, Opcode.ALLINST);
		addEEnumLiteral(opcodeEEnum, Opcode.ALLINST_IN);
		addEEnumLiteral(opcodeEEnum, Opcode.ISNULL);
		addEEnumLiteral(opcodeEEnum, Opcode.GETENVTYPE);
		addEEnumLiteral(opcodeEEnum, Opcode.NOT);
		addEEnumLiteral(opcodeEEnum, Opcode.AND);
		addEEnumLiteral(opcodeEEnum, Opcode.OR);
		addEEnumLiteral(opcodeEEnum, Opcode.XOR);
		addEEnumLiteral(opcodeEEnum, Opcode.IMPLIES);
		addEEnumLiteral(opcodeEEnum, Opcode.IFTE);
		addEEnumLiteral(opcodeEEnum, Opcode.RETURN);
		addEEnumLiteral(opcodeEEnum, Opcode.GETCB);
		addEEnumLiteral(opcodeEEnum, Opcode.INVOKE_ALL_CBS);
		addEEnumLiteral(opcodeEEnum, Opcode.INVOKE_CB);
		addEEnumLiteral(opcodeEEnum, Opcode.INVOKE_CB_S);
		addEEnumLiteral(opcodeEEnum, Opcode.MATCH);
		addEEnumLiteral(opcodeEEnum, Opcode.MATCH_S);
		addEEnumLiteral(opcodeEEnum, Opcode.ADD);
		addEEnumLiteral(opcodeEEnum, Opcode.REMOVE);
		addEEnumLiteral(opcodeEEnum, Opcode.INSERT);
		addEEnumLiteral(opcodeEEnum, Opcode.GET_SUPER);
		addEEnumLiteral(opcodeEEnum, Opcode.GETENV);

		initEEnum(ruleModeEEnum, RuleMode.class, "RuleMode");
		addEEnumLiteral(ruleModeEEnum, RuleMode.MANUAL);
		addEEnumLiteral(ruleModeEEnum, RuleMode.AUTOMATIC_SINGLE);
		addEEnumLiteral(ruleModeEEnum, RuleMode.AUTOMATIC_RECURSIVE);

		initEEnum(constantTagEEnum, ConstantTag.class, "ConstantTag");
		addEEnumLiteral(constantTagEEnum, ConstantTag.STRING);
		addEEnumLiteral(constantTagEEnum, ConstantTag.INTEGER);
		addEEnumLiteral(constantTagEEnum, ConstantTag.DOUBLE);
		addEEnumLiteral(constantTagEEnum, ConstantTag.BYTE);
		addEEnumLiteral(constantTagEEnum, ConstantTag.CHARACTER);
		addEEnumLiteral(constantTagEEnum, ConstantTag.FLOAT);
		addEEnumLiteral(constantTagEEnum, ConstantTag.SHORT);
		addEEnumLiteral(constantTagEEnum, ConstantTag.LONG);
		addEEnumLiteral(constantTagEEnum, ConstantTag.ENUM_LITERAL);
		addEEnumLiteral(constantTagEEnum, ConstantTag.NULL);

		// Initialize data types
		initEDataType(moduleResolverEDataType, ModuleResolver.class, "ModuleResolver", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(enumLiteralEDataType, EnumLiteral.class, "EnumLiteral", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(stackFrameEDataType, StackFrame.class, "StackFrame", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(methodEDataType, Method.class, "Method", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(timingDataEDataType, TimingData.class, "TimingData", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(vmMonitorEDataType, VMMonitor.class, "VMMonitor", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(lazyCollectionEDataType, LazyCollection.class, "LazyCollection", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(lazyBagEDataType, LazyBag.class, "LazyBag", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(lazyListEDataType, LazyList.class, "LazyList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(lazyOrderedSetEDataType, LazyOrderedSet.class, "LazyOrderedSet", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(lazySetEDataType, LazySet.class, "LazySet", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eJavaObjectArrayEDataType, Object[].class, "EJavaObjectArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eObjectArrayEDataType, EObject[].class, "EObjectArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eBooleanArrayEDataType, boolean[].class, "EBooleanArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eJavaSetEDataType, java.util.Set.class, "EJavaSet", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eJavaIterableEDataType, Iterable.class, "EJavaIterable", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(classNotFoundExceptionEDataType, ClassNotFoundException.class, "ClassNotFoundException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EmftvmPackageImpl
