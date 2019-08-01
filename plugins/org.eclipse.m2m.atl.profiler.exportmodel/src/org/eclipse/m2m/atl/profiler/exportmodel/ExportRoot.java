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
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Export Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportRoot#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportRoot#getTotalTime <em>Total Time</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportRoot#getTotalInstructions <em>Total Instructions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage#getExportRoot()
 * @model
 * @generated
 */
public interface ExportRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.profiler.exportmodel.AtlOperationExport}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage#getExportRoot_Operation()
	 * @model containment="true"
	 * @generated
	 */
	EList<AtlOperationExport> getOperation();

	/**
	 * Returns the value of the '<em><b>Total Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Time</em>' attribute.
	 * @see #setTotalTime(double)
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage#getExportRoot_TotalTime()
	 * @model required="true"
	 * @generated
	 */
	double getTotalTime();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportRoot#getTotalTime <em>Total Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Time</em>' attribute.
	 * @see #getTotalTime()
	 * @generated
	 */
	void setTotalTime(double value);

	/**
	 * Returns the value of the '<em><b>Total Instructions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Instructions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Instructions</em>' attribute.
	 * @see #setTotalInstructions(long)
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage#getExportRoot_TotalInstructions()
	 * @model required="true"
	 * @generated
	 */
	long getTotalInstructions();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportRoot#getTotalInstructions <em>Total Instructions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Instructions</em>' attribute.
	 * @see #getTotalInstructions()
	 * @generated
	 */
	void setTotalInstructions(long value);

} // ExportRoot
