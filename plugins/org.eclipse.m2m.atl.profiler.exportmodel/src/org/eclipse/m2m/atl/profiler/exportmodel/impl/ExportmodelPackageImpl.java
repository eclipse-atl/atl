/*******************************************************************************
 * Copyright (c) 2008,2009 Communication & Systems.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Arnaud Giuliani - initial API and implementation
 *******************************************************************************/ 
package org.eclipse.m2m.atl.profiler.exportmodel.impl;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.m2m.atl.profiler.exportmodel.AtlOperationExport;
import org.eclipse.m2m.atl.profiler.exportmodel.ExportElement;
import org.eclipse.m2m.atl.profiler.exportmodel.ExportRoot;
import org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelFactory;
import org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage;
import org.eclipse.m2m.atl.profiler.exportmodel.ProfilingOperationExport;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExportmodelPackageImpl extends EPackageImpl implements ExportmodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exportElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass profilingOperationExportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass atlOperationExportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exportRootEClass = null;

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
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExportmodelPackageImpl() {
		super(eNS_URI, ExportmodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExportmodelPackage init() {
		if (isInited) return (ExportmodelPackage)EPackage.Registry.INSTANCE.getEPackage(ExportmodelPackage.eNS_URI);

		// Obtain or create and register package
		ExportmodelPackageImpl theExportmodelPackage = (ExportmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ExportmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ExportmodelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theExportmodelPackage.createPackageContents();

		// Initialize created meta-data
		theExportmodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExportmodelPackage.freeze();

		return theExportmodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExportElement() {
		return exportElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExportElement_Name() {
		return (EAttribute)exportElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExportElement_TimExecution() {
		return (EAttribute)exportElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExportElement_Instructions() {
		return (EAttribute)exportElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExportElement_BeginMemory() {
		return (EAttribute)exportElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExportElement_MaxMemory() {
		return (EAttribute)exportElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExportElement_EndMemory() {
		return (EAttribute)exportElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExportElement_TotalTimeExecutionPercent() {
		return (EAttribute)exportElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExportElement_TotalInstructionsPercent() {
		return (EAttribute)exportElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProfilingOperationExport() {
		return profilingOperationExportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAtlOperationExport() {
		return atlOperationExportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAtlOperationExport_Calls() {
		return (EAttribute)atlOperationExportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAtlOperationExport_ProfilingOperation() {
		return (EReference)atlOperationExportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExportRoot() {
		return exportRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExportRoot_Operation() {
		return (EReference)exportRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExportRoot_TotalTime() {
		return (EAttribute)exportRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExportRoot_TotalInstructions() {
		return (EAttribute)exportRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExportmodelFactory getExportmodelFactory() {
		return (ExportmodelFactory)getEFactoryInstance();
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
		exportElementEClass = createEClass(EXPORT_ELEMENT);
		createEAttribute(exportElementEClass, EXPORT_ELEMENT__NAME);
		createEAttribute(exportElementEClass, EXPORT_ELEMENT__TIM_EXECUTION);
		createEAttribute(exportElementEClass, EXPORT_ELEMENT__INSTRUCTIONS);
		createEAttribute(exportElementEClass, EXPORT_ELEMENT__BEGIN_MEMORY);
		createEAttribute(exportElementEClass, EXPORT_ELEMENT__MAX_MEMORY);
		createEAttribute(exportElementEClass, EXPORT_ELEMENT__END_MEMORY);
		createEAttribute(exportElementEClass, EXPORT_ELEMENT__TOTAL_TIME_EXECUTION_PERCENT);
		createEAttribute(exportElementEClass, EXPORT_ELEMENT__TOTAL_INSTRUCTIONS_PERCENT);

		profilingOperationExportEClass = createEClass(PROFILING_OPERATION_EXPORT);

		atlOperationExportEClass = createEClass(ATL_OPERATION_EXPORT);
		createEAttribute(atlOperationExportEClass, ATL_OPERATION_EXPORT__CALLS);
		createEReference(atlOperationExportEClass, ATL_OPERATION_EXPORT__PROFILING_OPERATION);

		exportRootEClass = createEClass(EXPORT_ROOT);
		createEReference(exportRootEClass, EXPORT_ROOT__OPERATION);
		createEAttribute(exportRootEClass, EXPORT_ROOT__TOTAL_TIME);
		createEAttribute(exportRootEClass, EXPORT_ROOT__TOTAL_INSTRUCTIONS);
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
		profilingOperationExportEClass.getESuperTypes().add(this.getExportElement());
		atlOperationExportEClass.getESuperTypes().add(this.getExportElement());

		// Initialize classes and features; add operations and parameters
		initEClass(exportElementEClass, ExportElement.class, "ExportElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExportElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, ExportElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExportElement_TimExecution(), ecorePackage.getEDouble(), "timExecution", null, 1, 1, ExportElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExportElement_Instructions(), ecorePackage.getELong(), "instructions", null, 1, 1, ExportElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExportElement_BeginMemory(), ecorePackage.getELong(), "beginMemory", null, 1, 1, ExportElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExportElement_MaxMemory(), ecorePackage.getELong(), "maxMemory", null, 1, 1, ExportElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExportElement_EndMemory(), ecorePackage.getELong(), "endMemory", null, 1, 1, ExportElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExportElement_TotalTimeExecutionPercent(), ecorePackage.getEString(), "totalTimeExecutionPercent", null, 1, 1, ExportElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExportElement_TotalInstructionsPercent(), ecorePackage.getEString(), "totalInstructionsPercent", null, 1, 1, ExportElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(profilingOperationExportEClass, ProfilingOperationExport.class, "ProfilingOperationExport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(atlOperationExportEClass, AtlOperationExport.class, "AtlOperationExport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAtlOperationExport_Calls(), ecorePackage.getELong(), "calls", null, 1, 1, AtlOperationExport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAtlOperationExport_ProfilingOperation(), this.getProfilingOperationExport(), null, "profilingOperation", null, 0, -1, AtlOperationExport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exportRootEClass, ExportRoot.class, "ExportRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExportRoot_Operation(), this.getAtlOperationExport(), null, "operation", null, 0, -1, ExportRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExportRoot_TotalTime(), ecorePackage.getEDouble(), "totalTime", null, 1, 1, ExportRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExportRoot_TotalInstructions(), ecorePackage.getELong(), "totalInstructions", null, 1, 1, ExportRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ExportmodelPackageImpl
