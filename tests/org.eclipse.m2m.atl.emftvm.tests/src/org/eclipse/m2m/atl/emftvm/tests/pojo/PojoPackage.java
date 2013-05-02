/*******************************************************************************
 * Copyright (c) 2013 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.tests.pojo;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

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
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.atl.emftvm.tests.pojo.PojoFactory
 * @model kind="package"
 * @generated
 */
public class PojoPackage extends EPackageImpl {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "pojo";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "http://www.eclipse.org/m2m/atl/emftvm/test/POJO/2013";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "pojo";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final PojoPackage eINSTANCE = org.eclipse.m2m.atl.emftvm.tests.pojo.PojoPackage.init();

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.tests.pojo.PojoA <em>A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.tests.pojo.PojoA
	 * @see org.eclipse.m2m.atl.emftvm.tests.pojo.PojoPackage#getPojoA()
	 * @generated
	 */
	public static final int POJO_A = 0;

	/**
	 * The feature id for the '<em><b>BSet</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int POJO_A__BSET = 0;

	/**
	 * The feature id for the '<em><b>BList</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int POJO_A__BLIST = 1;

	/**
	 * The number of structural features of the '<em>A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int POJO_A_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.tests.pojo.PojoB <em>B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.tests.pojo.PojoB
	 * @see org.eclipse.m2m.atl.emftvm.tests.pojo.PojoPackage#getPojoB()
	 * @generated
	 */
	public static final int POJO_B = 1;

	/**
	 * The feature id for the '<em><b>Name Set</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int POJO_B__NAME_SET = 0;

	/**
	 * The feature id for the '<em><b>Enum List</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int POJO_B__ENUM_LIST = 1;

	/**
	 * The feature id for the '<em><b>Enum Set</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int POJO_B__ENUM_SET = 2;

	/**
	 * The number of structural features of the '<em>B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int POJO_B_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.tests.pojo.TestEnum <em>Test Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.tests.pojo.TestEnum
	 * @see org.eclipse.m2m.atl.emftvm.tests.pojo.PojoPackage#getTestEnum()
	 * @generated
	 */
	public static final int TEST_ENUM = 2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pojoAEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pojoBEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum testEnumEEnum = null;

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
	 * @see org.eclipse.m2m.atl.emftvm.tests.pojo.PojoPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PojoPackage() {
		super(eNS_URI, PojoFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PojoPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PojoPackage init() {
		if (isInited) return (PojoPackage)EPackage.Registry.INSTANCE.getEPackage(PojoPackage.eNS_URI);

		// Obtain or create and register package
		PojoPackage thePojoPackage = (PojoPackage)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PojoPackage ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PojoPackage());

		isInited = true;

		// Create package meta-data objects
		thePojoPackage.createPackageContents();

		// Initialize created meta-data
		thePojoPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePojoPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PojoPackage.eNS_URI, thePojoPackage);
		return thePojoPackage;
	}


	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.tests.pojo.PojoA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.tests.pojo.PojoA
	 * @generated
	 */
	public EClass getPojoA() {
		return pojoAEClass;
	}

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.atl.emftvm.tests.pojo.PojoA#getBSet <em>BSet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>BSet</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.tests.pojo.PojoA#getBSet()
	 * @see #getPojoA()
	 * @generated
	 */
	public EReference getPojoA_BSet() {
		return (EReference)pojoAEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.atl.emftvm.tests.pojo.PojoA#getBList <em>BList</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>BList</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.tests.pojo.PojoA#getBList()
	 * @see #getPojoA()
	 * @generated
	 */
	public EReference getPojoA_BList() {
		return (EReference)pojoAEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.tests.pojo.PojoB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.tests.pojo.PojoB
	 * @generated
	 */
	public EClass getPojoB() {
		return pojoBEClass;
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.m2m.atl.emftvm.tests.pojo.PojoB#getNameSet <em>Name Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Name Set</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.tests.pojo.PojoB#getNameSet()
	 * @see #getPojoB()
	 * @generated
	 */
	public EAttribute getPojoB_NameSet() {
		return (EAttribute)pojoBEClass.getEStructuralFeatures().get(0);
	}


	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.m2m.atl.emftvm.tests.pojo.PojoB#getEnumList <em>Enum List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Enum List</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.tests.pojo.PojoB#getEnumList()
	 * @see #getPojoB()
	 * @generated
	 */
	public EAttribute getPojoB_EnumList() {
		return (EAttribute)pojoBEClass.getEStructuralFeatures().get(1);
	}


	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.m2m.atl.emftvm.tests.pojo.PojoB#getEnumSet <em>Enum Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Enum Set</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.tests.pojo.PojoB#getEnumSet()
	 * @see #getPojoB()
	 * @generated
	 */
	public EAttribute getPojoB_EnumSet() {
		return (EAttribute)pojoBEClass.getEStructuralFeatures().get(2);
	}


	/**
	 * Returns the meta object for enum '{@link org.eclipse.m2m.atl.emftvm.tests.pojo.TestEnum <em>Test Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Test Enum</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.tests.pojo.TestEnum
	 * @generated
	 */
	public EEnum getTestEnum() {
		return testEnumEEnum;
	}


	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public PojoFactory getPojoFactory() {
		return (PojoFactory)getEFactoryInstance();
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
		pojoAEClass = createEClass(POJO_A);
		createEReference(pojoAEClass, POJO_A__BSET);
		createEReference(pojoAEClass, POJO_A__BLIST);

		pojoBEClass = createEClass(POJO_B);
		createEAttribute(pojoBEClass, POJO_B__NAME_SET);
		createEAttribute(pojoBEClass, POJO_B__ENUM_LIST);
		createEAttribute(pojoBEClass, POJO_B__ENUM_SET);

		// Create enums
		testEnumEEnum = createEEnum(TEST_ENUM);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(pojoAEClass, PojoA.class, "PojoA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPojoA_BSet(), this.getPojoB(), null, "bSet", null, 0, -1, PojoA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPojoA_BList(), this.getPojoB(), null, "bList", null, 0, -1, PojoA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pojoBEClass, PojoB.class, "PojoB", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPojoB_NameSet(), ecorePackage.getEString(), "nameSet", null, 0, -1, PojoB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPojoB_EnumList(), this.getTestEnum(), "enumList", null, 0, -1, PojoB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPojoB_EnumSet(), this.getTestEnum(), "enumSet", null, 0, -1, PojoB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(testEnumEEnum, TestEnum.class, "TestEnum");
		addEEnumLiteral(testEnumEEnum, TestEnum.OPTION_A);
		addEEnumLiteral(testEnumEEnum, TestEnum.OPTION_B);

		// Create resource
		createResource(eNS_URI);
	}

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
	public interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.tests.pojo.PojoA <em>A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.tests.pojo.PojoA
		 * @see org.eclipse.m2m.atl.emftvm.tests.pojo.PojoPackage#getPojoA()
		 * @generated
		 */
		public static final EClass POJO_A = eINSTANCE.getPojoA();

		/**
		 * The meta object literal for the '<em><b>BSet</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference POJO_A__BSET = eINSTANCE.getPojoA_BSet();

		/**
		 * The meta object literal for the '<em><b>BList</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference POJO_A__BLIST = eINSTANCE.getPojoA_BList();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.tests.pojo.PojoB <em>B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.tests.pojo.PojoB
		 * @see org.eclipse.m2m.atl.emftvm.tests.pojo.PojoPackage#getPojoB()
		 * @generated
		 */
		public static final EClass POJO_B = eINSTANCE.getPojoB();

		/**
		 * The meta object literal for the '<em><b>Name Set</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute POJO_B__NAME_SET = eINSTANCE.getPojoB_NameSet();

		/**
		 * The meta object literal for the '<em><b>Enum List</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute POJO_B__ENUM_LIST = eINSTANCE.getPojoB_EnumList();

		/**
		 * The meta object literal for the '<em><b>Enum Set</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute POJO_B__ENUM_SET = eINSTANCE.getPojoB_EnumSet();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.tests.pojo.TestEnum <em>Test Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.tests.pojo.TestEnum
		 * @see org.eclipse.m2m.atl.emftvm.tests.pojo.PojoPackage#getTestEnum()
		 * @generated
		 */
		public static final EEnum TEST_ENUM = eINSTANCE.getTestEnum();

	}

} //PojoPackage
