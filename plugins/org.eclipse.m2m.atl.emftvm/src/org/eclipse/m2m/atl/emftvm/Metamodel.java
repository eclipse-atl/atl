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
package org.eclipse.m2m.atl.emftvm;

import org.eclipse.emf.ecore.EClassifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metamodel</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getMetamodel()
 * @model
 * @generated
 */
public interface Metamodel extends Model {

	/**
	 * <!-- begin-user-doc -->
	 * Finds the type/metaclass with the given <pre>typeName</pre> within this {@link Metamodel}.
	 * @param typeName the type/metaclass name (may be fully qualified using '<pre>::</pre>')
	 * @return the type/metaclass with the given <pre>typeName</pre> within this {@link Metamodel}.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EClassifier findType(String typeName);

} // Metamodel
