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


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.m2m.atl.profiler.exportmodel.AtlOperationExport;
import org.eclipse.m2m.atl.profiler.exportmodel.ExportElement;
import org.eclipse.m2m.atl.profiler.exportmodel.ExportRoot;
import org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelFactory;
import org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage;
import org.eclipse.m2m.atl.profiler.exportmodel.ProfilingOperationExport;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExportmodelFactoryImpl extends EFactoryImpl implements ExportmodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExportmodelFactory init() {
		try {
			ExportmodelFactory theExportmodelFactory = (ExportmodelFactory)EPackage.Registry.INSTANCE.getEFactory("http://exportmodel"); 
			if (theExportmodelFactory != null) {
				return theExportmodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExportmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExportmodelFactoryImpl() {
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
			case ExportmodelPackage.EXPORT_ELEMENT: return createExportElement();
			case ExportmodelPackage.PROFILING_OPERATION_EXPORT: return createProfilingOperationExport();
			case ExportmodelPackage.ATL_OPERATION_EXPORT: return createAtlOperationExport();
			case ExportmodelPackage.EXPORT_ROOT: return createExportRoot();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExportElement createExportElement() {
		ExportElementImpl exportElement = new ExportElementImpl();
		return exportElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfilingOperationExport createProfilingOperationExport() {
		ProfilingOperationExportImpl profilingOperationExport = new ProfilingOperationExportImpl();
		return profilingOperationExport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtlOperationExport createAtlOperationExport() {
		AtlOperationExportImpl atlOperationExport = new AtlOperationExportImpl();
		return atlOperationExport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExportRoot createExportRoot() {
		ExportRootImpl exportRoot = new ExportRootImpl();
		return exportRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExportmodelPackage getExportmodelPackage() {
		return (ExportmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExportmodelPackage getPackage() {
		return ExportmodelPackage.eINSTANCE;
	}

} //ExportmodelFactoryImpl
