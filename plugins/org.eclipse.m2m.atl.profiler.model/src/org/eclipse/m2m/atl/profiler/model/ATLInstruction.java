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
package org.eclipse.m2m.atl.profiler.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ATL Instruction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.ATLInstruction#getATLElementRef <em>ATL Element Ref</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.ATLInstruction#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.ATLInstruction#getProfilingInstructions <em>Profiling Instructions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getATLInstruction()
 * @model
 * @generated
 */
public interface ATLInstruction extends EObject {
	/**
	 * Returns the value of the '<em><b>ATL Element Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ATL Element Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ATL Element Ref</em>' attribute.
	 * @see #setATLElementRef(Object)
	 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getATLInstruction_ATLElementRef()
	 * @model required="true"
	 * @generated
	 */
	Object getATLElementRef();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.model.ATLInstruction#getATLElementRef <em>ATL Element Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ATL Element Ref</em>' attribute.
	 * @see #getATLElementRef()
	 * @generated
	 */
	void setATLElementRef(Object value);

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
	 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getATLInstruction_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.model.ATLInstruction#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Profiling Instructions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profiling Instructions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profiling Instructions</em>' reference list.
	 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getATLInstruction_ProfilingInstructions()
	 * @model
	 * @generated
	 */
	EList<ProfilingInstruction> getProfilingInstructions();

} // ATLInstruction
