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
package org.eclipse.m2m.atl.emftvm.trace;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Set</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getRules <em>Rules</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getDefaultSourceElements <em>Default Source Elements</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getDefaultSourceElementLists <em>Default Source Element Lists</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getTraceLinkSet()
 * @model
 * @generated
 */
public interface TraceLinkSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.trace.TracedRule}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.trace.TracedRule#getLinkSet <em>Link Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getTraceLinkSet_Rules()
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracedRule#getLinkSet
	 * @model opposite="linkSet" containment="true"
	 * @generated
	 */
	EList<TracedRule> getRules();

	/**
	 * Returns the value of the '<em><b>Default Source Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.trace.SourceElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.trace.SourceElement#getDefaultFor <em>Default For</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Source Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Source Elements</em>' reference list.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getTraceLinkSet_DefaultSourceElements()
	 * @see org.eclipse.m2m.atl.emftvm.trace.SourceElement#getDefaultFor
	 * @model opposite="defaultFor"
	 * @generated
	 */
	EList<SourceElement> getDefaultSourceElements();

	/**
	 * Returns the value of the '<em><b>Default Source Element Lists</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.trace.SourceElementList}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.trace.SourceElementList#getDefaultFor <em>Default For</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Source Element Lists</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Source Element Lists</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getTraceLinkSet_DefaultSourceElementLists()
	 * @see org.eclipse.m2m.atl.emftvm.trace.SourceElementList#getDefaultFor
	 * @model opposite="defaultFor" containment="true"
	 * @generated
	 */
	EList<SourceElementList> getDefaultSourceElementLists();

	/**
	 * <!-- begin-user-doc -->
	 * Returns the default {@link SourceElement} for the given source object.
	 * @param sourceElement the source object that the {@link SourceElement} points to
	 * @return the default {@link SourceElement} for the given source object
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SourceElement getDefaultSourceElement(Object sourceElement);

	/**
	 * <!-- begin-user-doc -->
	 * Returns the default {@link SourceElementList} for the given source objects.
	 * @param sourceElements the source objects that the {@link SourceElementList} elements point to
	 * @return the default {@link SourceElementList} for the given source objects
	 * <!-- end-user-doc -->
	 * @model sourceElementsDataType="org.eclipse.m2m.atl.emftvm.trace.JavaList<?>" sourceElementsMany="false"
	 * @generated
	 */
	SourceElementList getDefaultSourceElements(List<?> sourceElements);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	TracedRule getLinksByRule(String rule, boolean create);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void clear();

} // TraceLinkSet
