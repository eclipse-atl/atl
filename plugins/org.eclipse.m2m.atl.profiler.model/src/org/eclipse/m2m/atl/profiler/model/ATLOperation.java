/*******************************************************************************
 * Copyright (c) 2008,2009 Communication & Systems.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Arnaud Giuliani - initial API and implementation
 *******************************************************************************/ 
package org.eclipse.m2m.atl.profiler.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ATL Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.ATLOperation#getCalls <em>Calls</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getATLOperation()
 * @model
 * @generated
 */
public interface ATLOperation extends ATLInstruction {
	/**
	 * Returns the value of the '<em><b>Calls</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Calls</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calls</em>' attribute.
	 * @see #setCalls(int)
	 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getATLOperation_Calls()
	 * @model required="true"
	 * @generated
	 */
	int getCalls();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.model.ATLOperation#getCalls <em>Calls</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Calls</em>' attribute.
	 * @see #getCalls()
	 * @generated
	 */
	void setCalls(int value);

} // ATLOperation
