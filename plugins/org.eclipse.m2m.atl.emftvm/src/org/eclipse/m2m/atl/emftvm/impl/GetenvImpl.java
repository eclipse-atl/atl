/*******************************************************************************
 * Copyright (c) 2011-2012 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Getenv;
import org.eclipse.m2m.atl.emftvm.Opcode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Getenv</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class GetenvImpl extends InstructionImpl implements Getenv {
	/**
	 * <!-- begin-user-doc -->
	 * Creates a new {@link GetenvImpl}.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected GetenvImpl() {
		super();
		opcode = Opcode.GETENV;
		stackProduction = 1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmftvmPackage.Literals.GETENV;
	}

} //GetenvImpl
