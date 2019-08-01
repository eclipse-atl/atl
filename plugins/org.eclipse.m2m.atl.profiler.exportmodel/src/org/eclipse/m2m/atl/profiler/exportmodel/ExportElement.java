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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Export Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getTimExecution <em>Tim Execution</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getInstructions <em>Instructions</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getBeginMemory <em>Begin Memory</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getMaxMemory <em>Max Memory</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getEndMemory <em>End Memory</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getTotalTimeExecutionPercent <em>Total Time Execution Percent</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getTotalInstructionsPercent <em>Total Instructions Percent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage#getExportElement()
 * @model
 * @generated
 */
public interface ExportElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage#getExportElement_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Tim Execution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tim Execution</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tim Execution</em>' attribute.
	 * @see #setTimExecution(double)
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage#getExportElement_TimExecution()
	 * @model required="true"
	 * @generated
	 */
	double getTimExecution();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getTimExecution <em>Tim Execution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tim Execution</em>' attribute.
	 * @see #getTimExecution()
	 * @generated
	 */
	void setTimExecution(double value);

	/**
	 * Returns the value of the '<em><b>Instructions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instructions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instructions</em>' attribute.
	 * @see #setInstructions(long)
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage#getExportElement_Instructions()
	 * @model required="true"
	 * @generated
	 */
	long getInstructions();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getInstructions <em>Instructions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instructions</em>' attribute.
	 * @see #getInstructions()
	 * @generated
	 */
	void setInstructions(long value);

	/**
	 * Returns the value of the '<em><b>Begin Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Begin Memory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Begin Memory</em>' attribute.
	 * @see #setBeginMemory(long)
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage#getExportElement_BeginMemory()
	 * @model required="true"
	 * @generated
	 */
	long getBeginMemory();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getBeginMemory <em>Begin Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Begin Memory</em>' attribute.
	 * @see #getBeginMemory()
	 * @generated
	 */
	void setBeginMemory(long value);

	/**
	 * Returns the value of the '<em><b>Max Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Memory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Memory</em>' attribute.
	 * @see #setMaxMemory(long)
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage#getExportElement_MaxMemory()
	 * @model required="true"
	 * @generated
	 */
	long getMaxMemory();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getMaxMemory <em>Max Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Memory</em>' attribute.
	 * @see #getMaxMemory()
	 * @generated
	 */
	void setMaxMemory(long value);

	/**
	 * Returns the value of the '<em><b>End Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Memory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Memory</em>' attribute.
	 * @see #setEndMemory(long)
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage#getExportElement_EndMemory()
	 * @model required="true"
	 * @generated
	 */
	long getEndMemory();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getEndMemory <em>End Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Memory</em>' attribute.
	 * @see #getEndMemory()
	 * @generated
	 */
	void setEndMemory(long value);

	/**
	 * Returns the value of the '<em><b>Total Time Execution Percent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Time Execution Percent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Time Execution Percent</em>' attribute.
	 * @see #setTotalTimeExecutionPercent(String)
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage#getExportElement_TotalTimeExecutionPercent()
	 * @model required="true"
	 * @generated
	 */
	String getTotalTimeExecutionPercent();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getTotalTimeExecutionPercent <em>Total Time Execution Percent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Time Execution Percent</em>' attribute.
	 * @see #getTotalTimeExecutionPercent()
	 * @generated
	 */
	void setTotalTimeExecutionPercent(String value);

	/**
	 * Returns the value of the '<em><b>Total Instructions Percent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Instructions Percent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Instructions Percent</em>' attribute.
	 * @see #setTotalInstructionsPercent(String)
	 * @see org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage#getExportElement_TotalInstructionsPercent()
	 * @model required="true"
	 * @generated
	 */
	String getTotalInstructionsPercent();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.exportmodel.ExportElement#getTotalInstructionsPercent <em>Total Instructions Percent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Instructions Percent</em>' attribute.
	 * @see #getTotalInstructionsPercent()
	 * @generated
	 */
	void setTotalInstructionsPercent(String value);

} // ExportElement
