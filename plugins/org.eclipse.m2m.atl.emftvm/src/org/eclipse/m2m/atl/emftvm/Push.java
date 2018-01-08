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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Push</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Push#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Push#getStringValue <em>String Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Push#getIntValue <em>Int Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Push#getDoubleValue <em>Double Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Push#getByteValue <em>Byte Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Push#getCharValue <em>Char Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Push#getFloatValue <em>Float Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Push#getShortValue <em>Short Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Push#getLongValue <em>Long Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Push#getEnumValue <em>Enum Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getPush()
 * @model
 * @generated
 */
public interface Push extends Instruction {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getPush_Value()
	 * @model transient="true"
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Push#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

	/**
	 * Returns the value of the '<em><b>String Value</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Value</em>' attribute.
	 * @see #setStringValue(String)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getPush_StringValue()
	 * @model default=""
	 * @generated
	 */
	String getStringValue();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Push#getStringValue <em>String Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String Value</em>' attribute.
	 * @see #getStringValue()
	 * @generated
	 */
	void setStringValue(String value);

	/**
	 * Returns the value of the '<em><b>Int Value</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Int Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Int Value</em>' attribute.
	 * @see #setIntValue(Integer)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getPush_IntValue()
	 * @model default=""
	 * @generated
	 */
	Integer getIntValue();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Push#getIntValue <em>Int Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Int Value</em>' attribute.
	 * @see #getIntValue()
	 * @generated
	 */
	void setIntValue(Integer value);

	/**
	 * Returns the value of the '<em><b>Double Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Double Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Double Value</em>' attribute.
	 * @see #setDoubleValue(Double)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getPush_DoubleValue()
	 * @model
	 * @generated
	 */
	Double getDoubleValue();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Push#getDoubleValue <em>Double Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Double Value</em>' attribute.
	 * @see #getDoubleValue()
	 * @generated
	 */
	void setDoubleValue(Double value);

	/**
	 * Returns the value of the '<em><b>Byte Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Byte Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Byte Value</em>' attribute.
	 * @see #setByteValue(Byte)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getPush_ByteValue()
	 * @model
	 * @generated
	 */
	Byte getByteValue();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Push#getByteValue <em>Byte Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Byte Value</em>' attribute.
	 * @see #getByteValue()
	 * @generated
	 */
	void setByteValue(Byte value);

	/**
	 * Returns the value of the '<em><b>Char Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Char Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Char Value</em>' attribute.
	 * @see #setCharValue(Character)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getPush_CharValue()
	 * @model
	 * @generated
	 */
	Character getCharValue();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Push#getCharValue <em>Char Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Char Value</em>' attribute.
	 * @see #getCharValue()
	 * @generated
	 */
	void setCharValue(Character value);

	/**
	 * Returns the value of the '<em><b>Float Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Float Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Float Value</em>' attribute.
	 * @see #setFloatValue(Float)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getPush_FloatValue()
	 * @model
	 * @generated
	 */
	Float getFloatValue();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Push#getFloatValue <em>Float Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Float Value</em>' attribute.
	 * @see #getFloatValue()
	 * @generated
	 */
	void setFloatValue(Float value);

	/**
	 * Returns the value of the '<em><b>Short Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Short Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Short Value</em>' attribute.
	 * @see #setShortValue(Short)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getPush_ShortValue()
	 * @model
	 * @generated
	 */
	Short getShortValue();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Push#getShortValue <em>Short Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Short Value</em>' attribute.
	 * @see #getShortValue()
	 * @generated
	 */
	void setShortValue(Short value);

	/**
	 * Returns the value of the '<em><b>Long Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Long Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Long Value</em>' attribute.
	 * @see #setLongValue(Long)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getPush_LongValue()
	 * @model
	 * @generated
	 */
	Long getLongValue();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Push#getLongValue <em>Long Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Long Value</em>' attribute.
	 * @see #getLongValue()
	 * @generated
	 */
	void setLongValue(Long value);

	/**
	 * Returns the value of the '<em><b>Enum Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum Value</em>' attribute.
	 * @see #setEnumValue(String)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getPush_EnumValue()
	 * @model
	 * @generated
	 */
	String getEnumValue();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Push#getEnumValue <em>Enum Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enum Value</em>' attribute.
	 * @see #getEnumValue()
	 * @generated
	 */
	void setEnumValue(String value);

} // Push
