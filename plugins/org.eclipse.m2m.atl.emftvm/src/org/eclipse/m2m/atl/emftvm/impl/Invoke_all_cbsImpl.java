/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
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
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Invoke_all_cbs;
import org.eclipse.m2m.atl.emftvm.Opcode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invoke all cbs</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class Invoke_all_cbsImpl extends InvokeInstructionImpl implements Invoke_all_cbs {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected Invoke_all_cbsImpl() {
		super();
		opcode = Opcode.INVOKE_ALL_CBS;
		stackProduction = 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmftvmPackage.Literals.INVOKE_ALL_CBS;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.impl.InstructionImpl#getStackProduction()
	 */
	@Override
	public int getStackProduction() {
		final CodeBlock cb = getOwningBlock();
		if (cb != null) {
			return stackProduction + cb.getNested().size();
		}
		return super.getStackProduction();
	}

} //Invoke_all_cbsImpl
