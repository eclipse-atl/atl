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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atl Operation Export</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.AtlOperationExport#getCalls <em>Calls</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.AtlOperationExport#getProfilingOperation <em>Profiling Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage#getAtlOperationExport()
 * @model
 * @generated
 */
public interface AtlOperationExport extends ExportElement {
	/**
	 * Returns the value of the '<em><b>Calls</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Calls</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calls</em>' attribute.
	 * @see #setCalls(long)
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage#getAtlOperationExport_Calls()
	 * @model required="true"
	 * @generated
	 */
	long getCalls();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.exportmodel.AtlOperationExport#getCalls <em>Calls</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Calls</em>' attribute.
	 * @see #getCalls()
	 * @generated
	 */
	void setCalls(long value);

	/**
	 * Returns the value of the '<em><b>Profiling Operation</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.profiler.exportmodel.ProfilingOperationExport}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profiling Operation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profiling Operation</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage#getAtlOperationExport_ProfilingOperation()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProfilingOperationExport> getProfilingOperation();

} // AtlOperationExport
