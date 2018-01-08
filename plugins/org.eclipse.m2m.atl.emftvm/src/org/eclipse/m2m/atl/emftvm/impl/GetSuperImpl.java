/**
 * (C) 2011 Dennis Wagelaar, Vrije Universiteit Brussel
 */
package org.eclipse.m2m.atl.emftvm.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.GetSuper;
import org.eclipse.m2m.atl.emftvm.Opcode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Get Super</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class GetSuperImpl extends FieldInstructionImpl implements GetSuper {
	/**
	 * <!-- begin-user-doc -->
	 * Creates a new {@link GetSuperImpl}.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected GetSuperImpl() {
		super();
		opcode = Opcode.GET_SUPER;
		stackConsumption = 1;
		stackProduction = 1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the {@link EClass} that correspond to this metaclass.
	 * @return the {@link EClass} that correspond to this metaclass.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmftvmPackage.Literals.GET_SUPER;
	}

} //GetSuperImpl
