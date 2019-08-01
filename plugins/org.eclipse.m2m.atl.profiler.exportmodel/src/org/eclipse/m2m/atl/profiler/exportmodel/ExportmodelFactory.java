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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage
 * @generated
 */
public interface ExportmodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExportmodelFactory eINSTANCE = org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportmodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Export Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Export Element</em>'.
	 * @generated
	 */
	ExportElement createExportElement();

	/**
	 * Returns a new object of class '<em>Profiling Operation Export</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Profiling Operation Export</em>'.
	 * @generated
	 */
	ProfilingOperationExport createProfilingOperationExport();

	/**
	 * Returns a new object of class '<em>Atl Operation Export</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Atl Operation Export</em>'.
	 * @generated
	 */
	AtlOperationExport createAtlOperationExport();

	/**
	 * Returns a new object of class '<em>Export Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Export Root</em>'.
	 * @generated
	 */
	ExportRoot createExportRoot();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExportmodelPackage getExportmodelPackage();

} //ExportmodelFactory
