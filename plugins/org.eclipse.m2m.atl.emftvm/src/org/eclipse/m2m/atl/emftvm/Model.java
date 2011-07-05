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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.emftvm.util.LazyList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Model#getResource <em>Resource</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Model#isAllowInterModelReferences <em>Allow Inter Model References</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject {
	/**
	 * Returns the value of the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' attribute.
	 * @see #setResource(Resource)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getModel_Resource()
	 * @model required="true" transient="true" derived="true"
	 * @generated
	 */
	Resource getResource();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Model#getResource <em>Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' attribute.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(Resource value);

	/**
	 * Returns the value of the '<em><b>Allow Inter Model References</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Inter Model References</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Inter Model References</em>' attribute.
	 * @see #setAllowInterModelReferences(boolean)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getModel_AllowInterModelReferences()
	 * @model default="true" required="true" transient="true"
	 * @generated
	 */
	boolean isAllowInterModelReferences();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Model#isAllowInterModelReferences <em>Allow Inter Model References</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Inter Model References</em>' attribute.
	 * @see #isAllowInterModelReferences()
	 * @generated
	 */
	void setAllowInterModelReferences(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * Returns all instances of the given <pre>type</pre>.
	 * @param type the metaclass for which to find the instances
	 * @return all instances of the given <pre>type</pre>.
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.m2m.atl.emftvm.LazyList<org.eclipse.emf.ecore.EObject>"
	 * @generated
	 */
	LazyList<EObject> allInstancesOf(EClass type);

	/**
	 * <!-- begin-user-doc -->
	 * Creates a new model element of the given <pre>type</pre> in this {@link Model}.
	 * @param type the metaclass to instantiate
	 * @return a new instance of the given <pre>type</pre>
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EObject newElement(EClass type);

	/**
	 * <!-- begin-user-doc -->
	 * Deletes <pre>element</pre> from this {@link Model}.
	 * @param element the model element to delete
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void deleteElement(EObject element);

} // Model
