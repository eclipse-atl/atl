/**
 * Copyright (C) 2009, Vrije Universiteit Brussel, Universidad de los Andes
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	Andres Yie (Vrije Universiteit Brussel, Universidad de los Andes)
 * 	Dennis Wagelaar (Vrije Universiteit Brussel)
 *
 * $Id: TraceFactory.java,v 1.1.2.1 2009/03/12 09:38:58 dwagelaar Exp $
 */
package org.eclipse.m2m.atl.trace;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.atl.trace.TracePackage
 * @generated
 */
public interface TraceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TraceFactory eINSTANCE = org.eclipse.m2m.atl.trace.impl.TraceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Transient Link Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transient Link Set</em>'.
	 * @generated
	 */
	TransientLinkSet createTransientLinkSet();

	/**
	 * Returns a new object of class '<em>Transient Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transient Link</em>'.
	 * @generated
	 */
	TransientLink createTransientLink();

	/**
	 * Returns a new object of class '<em>Transient Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transient Element</em>'.
	 * @generated
	 */
	TransientElement createTransientElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TracePackage getTracePackage();

} //TraceFactory
