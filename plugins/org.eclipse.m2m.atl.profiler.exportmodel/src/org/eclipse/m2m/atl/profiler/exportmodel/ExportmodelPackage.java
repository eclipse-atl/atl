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
package org.eclipse.m2m.atl.profiler.exportmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelFactory
 * @model kind="package"
 * @generated
 */
public interface ExportmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "exportmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://exportmodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "exportmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExportmodelPackage eINSTANCE = org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportElementImpl <em>Export Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportElementImpl
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportmodelPackageImpl#getExportElement()
	 * @generated
	 */
	int EXPORT_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORT_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Tim Execution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORT_ELEMENT__TIM_EXECUTION = 1;

	/**
	 * The feature id for the '<em><b>Instructions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORT_ELEMENT__INSTRUCTIONS = 2;

	/**
	 * The feature id for the '<em><b>Begin Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORT_ELEMENT__BEGIN_MEMORY = 3;

	/**
	 * The feature id for the '<em><b>Max Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORT_ELEMENT__MAX_MEMORY = 4;

	/**
	 * The feature id for the '<em><b>End Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORT_ELEMENT__END_MEMORY = 5;

	/**
	 * The feature id for the '<em><b>Total Time Execution Percent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORT_ELEMENT__TOTAL_TIME_EXECUTION_PERCENT = 6;

	/**
	 * The feature id for the '<em><b>Total Instructions Percent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORT_ELEMENT__TOTAL_INSTRUCTIONS_PERCENT = 7;

	/**
	 * The number of structural features of the '<em>Export Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORT_ELEMENT_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.profiler.exportmodel.impl.ProfilingOperationExportImpl <em>Profiling Operation Export</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.impl.ProfilingOperationExportImpl
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportmodelPackageImpl#getProfilingOperationExport()
	 * @generated
	 */
	int PROFILING_OPERATION_EXPORT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION_EXPORT__NAME = EXPORT_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Tim Execution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION_EXPORT__TIM_EXECUTION = EXPORT_ELEMENT__TIM_EXECUTION;

	/**
	 * The feature id for the '<em><b>Instructions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION_EXPORT__INSTRUCTIONS = EXPORT_ELEMENT__INSTRUCTIONS;

	/**
	 * The feature id for the '<em><b>Begin Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION_EXPORT__BEGIN_MEMORY = EXPORT_ELEMENT__BEGIN_MEMORY;

	/**
	 * The feature id for the '<em><b>Max Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION_EXPORT__MAX_MEMORY = EXPORT_ELEMENT__MAX_MEMORY;

	/**
	 * The feature id for the '<em><b>End Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION_EXPORT__END_MEMORY = EXPORT_ELEMENT__END_MEMORY;

	/**
	 * The feature id for the '<em><b>Total Time Execution Percent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION_EXPORT__TOTAL_TIME_EXECUTION_PERCENT = EXPORT_ELEMENT__TOTAL_TIME_EXECUTION_PERCENT;

	/**
	 * The feature id for the '<em><b>Total Instructions Percent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION_EXPORT__TOTAL_INSTRUCTIONS_PERCENT = EXPORT_ELEMENT__TOTAL_INSTRUCTIONS_PERCENT;

	/**
	 * The number of structural features of the '<em>Profiling Operation Export</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION_EXPORT_FEATURE_COUNT = EXPORT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.profiler.exportmodel.impl.AtlOperationExportImpl <em>Atl Operation Export</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.impl.AtlOperationExportImpl
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportmodelPackageImpl#getAtlOperationExport()
	 * @generated
	 */
	int ATL_OPERATION_EXPORT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATL_OPERATION_EXPORT__NAME = EXPORT_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Tim Execution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATL_OPERATION_EXPORT__TIM_EXECUTION = EXPORT_ELEMENT__TIM_EXECUTION;

	/**
	 * The feature id for the '<em><b>Instructions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATL_OPERATION_EXPORT__INSTRUCTIONS = EXPORT_ELEMENT__INSTRUCTIONS;

	/**
	 * The feature id for the '<em><b>Begin Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATL_OPERATION_EXPORT__BEGIN_MEMORY = EXPORT_ELEMENT__BEGIN_MEMORY;

	/**
	 * The feature id for the '<em><b>Max Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATL_OPERATION_EXPORT__MAX_MEMORY = EXPORT_ELEMENT__MAX_MEMORY;

	/**
	 * The feature id for the '<em><b>End Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATL_OPERATION_EXPORT__END_MEMORY = EXPORT_ELEMENT__END_MEMORY;

	/**
	 * The feature id for the '<em><b>Total Time Execution Percent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATL_OPERATION_EXPORT__TOTAL_TIME_EXECUTION_PERCENT = EXPORT_ELEMENT__TOTAL_TIME_EXECUTION_PERCENT;

	/**
	 * The feature id for the '<em><b>Total Instructions Percent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATL_OPERATION_EXPORT__TOTAL_INSTRUCTIONS_PERCENT = EXPORT_ELEMENT__TOTAL_INSTRUCTIONS_PERCENT;

	/**
	 * The feature id for the '<em><b>Calls</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATL_OPERATION_EXPORT__CALLS = EXPORT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Profiling Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATL_OPERATION_EXPORT__PROFILING_OPERATION = EXPORT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Atl Operation Export</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATL_OPERATION_EXPORT_FEATURE_COUNT = EXPORT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportRootImpl <em>Export Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportRootImpl
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportmodelPackageImpl#getExportRoot()
	 * @generated
	 */
	int EXPORT_ROOT = 3;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORT_ROOT__OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Total Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORT_ROOT__TOTAL_TIME = 1;

	/**
	 * The feature id for the '<em><b>Total Instructions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORT_ROOT__TOTAL_INSTRUCTIONS = 2;

	/**
	 * The number of structural features of the '<em>Export Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORT_ROOT_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement <em>Export Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Export Element</em>'.
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportElement
	 * @generated
	 */
	EClass getExportElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getName()
	 * @see #getExportElement()
	 * @generated
	 */
	EAttribute getExportElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getTimExecution <em>Tim Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tim Execution</em>'.
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getTimExecution()
	 * @see #getExportElement()
	 * @generated
	 */
	EAttribute getExportElement_TimExecution();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getInstructions <em>Instructions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instructions</em>'.
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getInstructions()
	 * @see #getExportElement()
	 * @generated
	 */
	EAttribute getExportElement_Instructions();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getBeginMemory <em>Begin Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Begin Memory</em>'.
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getBeginMemory()
	 * @see #getExportElement()
	 * @generated
	 */
	EAttribute getExportElement_BeginMemory();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getMaxMemory <em>Max Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Memory</em>'.
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getMaxMemory()
	 * @see #getExportElement()
	 * @generated
	 */
	EAttribute getExportElement_MaxMemory();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getEndMemory <em>End Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Memory</em>'.
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getEndMemory()
	 * @see #getExportElement()
	 * @generated
	 */
	EAttribute getExportElement_EndMemory();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getTotalTimeExecutionPercent <em>Total Time Execution Percent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Time Execution Percent</em>'.
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getTotalTimeExecutionPercent()
	 * @see #getExportElement()
	 * @generated
	 */
	EAttribute getExportElement_TotalTimeExecutionPercent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getTotalInstructionsPercent <em>Total Instructions Percent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Instructions Percent</em>'.
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getTotalInstructionsPercent()
	 * @see #getExportElement()
	 * @generated
	 */
	EAttribute getExportElement_TotalInstructionsPercent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.profiler.exportmodel.ProfilingOperationExport <em>Profiling Operation Export</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Profiling Operation Export</em>'.
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ProfilingOperationExport
	 * @generated
	 */
	EClass getProfilingOperationExport();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.profiler.exportmodel.AtlOperationExport <em>Atl Operation Export</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atl Operation Export</em>'.
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.AtlOperationExport
	 * @generated
	 */
	EClass getAtlOperationExport();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.exportmodel.AtlOperationExport#getCalls <em>Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Calls</em>'.
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.AtlOperationExport#getCalls()
	 * @see #getAtlOperationExport()
	 * @generated
	 */
	EAttribute getAtlOperationExport_Calls();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.profiler.exportmodel.AtlOperationExport#getProfilingOperation <em>Profiling Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Profiling Operation</em>'.
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.AtlOperationExport#getProfilingOperation()
	 * @see #getAtlOperationExport()
	 * @generated
	 */
	EReference getAtlOperationExport_ProfilingOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportRoot <em>Export Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Export Root</em>'.
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportRoot
	 * @generated
	 */
	EClass getExportRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportRoot#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operation</em>'.
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportRoot#getOperation()
	 * @see #getExportRoot()
	 * @generated
	 */
	EReference getExportRoot_Operation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportRoot#getTotalTime <em>Total Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Time</em>'.
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportRoot#getTotalTime()
	 * @see #getExportRoot()
	 * @generated
	 */
	EAttribute getExportRoot_TotalTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportRoot#getTotalInstructions <em>Total Instructions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Instructions</em>'.
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportRoot#getTotalInstructions()
	 * @see #getExportRoot()
	 * @generated
	 */
	EAttribute getExportRoot_TotalInstructions();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExportmodelFactory getExportmodelFactory();

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
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportElementImpl <em>Export Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportElementImpl
		 * @see org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportmodelPackageImpl#getExportElement()
		 * @generated
		 */
		EClass EXPORT_ELEMENT = eINSTANCE.getExportElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPORT_ELEMENT__NAME = eINSTANCE.getExportElement_Name();

		/**
		 * The meta object literal for the '<em><b>Tim Execution</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPORT_ELEMENT__TIM_EXECUTION = eINSTANCE.getExportElement_TimExecution();

		/**
		 * The meta object literal for the '<em><b>Instructions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPORT_ELEMENT__INSTRUCTIONS = eINSTANCE.getExportElement_Instructions();

		/**
		 * The meta object literal for the '<em><b>Begin Memory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPORT_ELEMENT__BEGIN_MEMORY = eINSTANCE.getExportElement_BeginMemory();

		/**
		 * The meta object literal for the '<em><b>Max Memory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPORT_ELEMENT__MAX_MEMORY = eINSTANCE.getExportElement_MaxMemory();

		/**
		 * The meta object literal for the '<em><b>End Memory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPORT_ELEMENT__END_MEMORY = eINSTANCE.getExportElement_EndMemory();

		/**
		 * The meta object literal for the '<em><b>Total Time Execution Percent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPORT_ELEMENT__TOTAL_TIME_EXECUTION_PERCENT = eINSTANCE.getExportElement_TotalTimeExecutionPercent();

		/**
		 * The meta object literal for the '<em><b>Total Instructions Percent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPORT_ELEMENT__TOTAL_INSTRUCTIONS_PERCENT = eINSTANCE.getExportElement_TotalInstructionsPercent();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.profiler.exportmodel.impl.ProfilingOperationExportImpl <em>Profiling Operation Export</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.profiler.exportmodel.impl.ProfilingOperationExportImpl
		 * @see org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportmodelPackageImpl#getProfilingOperationExport()
		 * @generated
		 */
		EClass PROFILING_OPERATION_EXPORT = eINSTANCE.getProfilingOperationExport();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.profiler.exportmodel.impl.AtlOperationExportImpl <em>Atl Operation Export</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.profiler.exportmodel.impl.AtlOperationExportImpl
		 * @see org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportmodelPackageImpl#getAtlOperationExport()
		 * @generated
		 */
		EClass ATL_OPERATION_EXPORT = eINSTANCE.getAtlOperationExport();

		/**
		 * The meta object literal for the '<em><b>Calls</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATL_OPERATION_EXPORT__CALLS = eINSTANCE.getAtlOperationExport_Calls();

		/**
		 * The meta object literal for the '<em><b>Profiling Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATL_OPERATION_EXPORT__PROFILING_OPERATION = eINSTANCE.getAtlOperationExport_ProfilingOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportRootImpl <em>Export Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportRootImpl
		 * @see org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportmodelPackageImpl#getExportRoot()
		 * @generated
		 */
		EClass EXPORT_ROOT = eINSTANCE.getExportRoot();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPORT_ROOT__OPERATION = eINSTANCE.getExportRoot_Operation();

		/**
		 * The meta object literal for the '<em><b>Total Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPORT_ROOT__TOTAL_TIME = eINSTANCE.getExportRoot_TotalTime();

		/**
		 * The meta object literal for the '<em><b>Total Instructions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPORT_ROOT__TOTAL_INSTRUCTIONS = eINSTANCE.getExportRoot_TotalInstructions();

	}

} //ExportmodelPackage
