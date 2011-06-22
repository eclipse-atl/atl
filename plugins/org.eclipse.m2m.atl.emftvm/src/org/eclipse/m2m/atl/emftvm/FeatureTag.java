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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Feature Tag</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getFeatureTag()
 * @model
 * @generated
 */
public enum FeatureTag implements Enumerator {
	/**
	 * The '<em><b>Field</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIELD_VALUE
	 * @generated
	 * @ordered
	 */
	FIELD(0, "Field", "Field"),

	/**
	 * The '<em><b>Static Field</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATIC_FIELD_VALUE
	 * @generated
	 * @ordered
	 */
	STATIC_FIELD(1, "StaticField", "StaticField"),

	/**
	 * The '<em><b>Operation</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPERATION_VALUE
	 * @generated
	 * @ordered
	 */
	OPERATION(2, "Operation", "Operation"),

	/**
	 * The '<em><b>Static Operation</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATIC_OPERATION_VALUE
	 * @generated
	 * @ordered
	 */
	STATIC_OPERATION(3, "StaticOperation", "StaticOperation"),

	/**
	 * The '<em><b>Query Operation</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUERY_OPERATION_VALUE
	 * @generated
	 * @ordered
	 */
	QUERY_OPERATION(4, "QueryOperation", "QueryOperation"),

	/**
	 * The '<em><b>Static Query Operation</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATIC_QUERY_OPERATION_VALUE
	 * @generated
	 * @ordered
	 */
	STATIC_QUERY_OPERATION(5, "StaticQueryOperation", "StaticQueryOperation");

	/**
	 * The '<em><b>Field</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Field</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIELD
	 * @model name="Field"
	 * @generated
	 * @ordered
	 */
	public static final int FIELD_VALUE = 0;

	/**
	 * The '<em><b>Static Field</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Static Field</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STATIC_FIELD
	 * @model name="StaticField"
	 * @generated
	 * @ordered
	 */
	public static final int STATIC_FIELD_VALUE = 1;

	/**
	 * The '<em><b>Operation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Operation</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OPERATION
	 * @model name="Operation"
	 * @generated
	 * @ordered
	 */
	public static final int OPERATION_VALUE = 2;

	/**
	 * The '<em><b>Static Operation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Static Operation</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STATIC_OPERATION
	 * @model name="StaticOperation"
	 * @generated
	 * @ordered
	 */
	public static final int STATIC_OPERATION_VALUE = 3;

	/**
	 * The '<em><b>Query Operation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Query Operation</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QUERY_OPERATION
	 * @model name="QueryOperation"
	 * @generated
	 * @ordered
	 */
	public static final int QUERY_OPERATION_VALUE = 4;

	/**
	 * The '<em><b>Static Query Operation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Static Query Operation</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STATIC_QUERY_OPERATION
	 * @model name="StaticQueryOperation"
	 * @generated
	 * @ordered
	 */
	public static final int STATIC_QUERY_OPERATION_VALUE = 5;

	/**
	 * An array of all the '<em><b>Feature Tag</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FeatureTag[] VALUES_ARRAY =
		new FeatureTag[] {
			FIELD,
			STATIC_FIELD,
			OPERATION,
			STATIC_OPERATION,
			QUERY_OPERATION,
			STATIC_QUERY_OPERATION,
		};

	/**
	 * A public read-only list of all the '<em><b>Feature Tag</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FeatureTag> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Feature Tag</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FeatureTag get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FeatureTag result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Feature Tag</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FeatureTag getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FeatureTag result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Feature Tag</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FeatureTag get(int value) {
		switch (value) {
			case FIELD_VALUE: return FIELD;
			case STATIC_FIELD_VALUE: return STATIC_FIELD;
			case OPERATION_VALUE: return OPERATION;
			case STATIC_OPERATION_VALUE: return STATIC_OPERATION;
			case QUERY_OPERATION_VALUE: return QUERY_OPERATION;
			case STATIC_QUERY_OPERATION_VALUE: return STATIC_QUERY_OPERATION;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private FeatureTag(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //FeatureTag
