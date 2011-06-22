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


import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Opcode;
import org.eclipse.m2m.atl.emftvm.Push;
import org.eclipse.m2m.atl.emftvm.util.EnumLiteral;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Push</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.PushImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.PushImpl#getStringValue <em>String Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.PushImpl#getIntValue <em>Int Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.PushImpl#getDoubleValue <em>Double Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.PushImpl#getByteValue <em>Byte Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.PushImpl#getCharValue <em>Char Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.PushImpl#getFloatValue <em>Float Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.PushImpl#getShortValue <em>Short Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.PushImpl#getLongValue <em>Long Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.PushImpl#getEnumValue <em>Enum Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PushImpl extends InstructionImpl implements Push {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Object value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStringValue() <em>String Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringValue()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String STRING_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStringValue() <em>String Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringValue()
	 * @generated
	 * @ordered
	 */
	protected String stringValue = STRING_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIntValue() <em>Int Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntValue()
	 * @generated NOT
	 * @ordered
	 */
	protected static final Integer INT_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIntValue() <em>Int Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntValue()
	 * @generated
	 * @ordered
	 */
	protected Integer intValue = INT_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDoubleValue() <em>Double Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoubleValue()
	 * @generated
	 * @ordered
	 */
	protected static final Double DOUBLE_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDoubleValue() <em>Double Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoubleValue()
	 * @generated
	 * @ordered
	 */
	protected Double doubleValue = DOUBLE_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getByteValue() <em>Byte Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getByteValue()
	 * @generated
	 * @ordered
	 */
	protected static final Byte BYTE_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getByteValue() <em>Byte Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getByteValue()
	 * @generated
	 * @ordered
	 */
	protected Byte byteValue = BYTE_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCharValue() <em>Char Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharValue()
	 * @generated
	 * @ordered
	 */
	protected static final Character CHAR_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCharValue() <em>Char Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharValue()
	 * @generated
	 * @ordered
	 */
	protected Character charValue = CHAR_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFloatValue() <em>Float Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFloatValue()
	 * @generated
	 * @ordered
	 */
	protected static final Float FLOAT_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFloatValue() <em>Float Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFloatValue()
	 * @generated
	 * @ordered
	 */
	protected Float floatValue = FLOAT_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getShortValue() <em>Short Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortValue()
	 * @generated
	 * @ordered
	 */
	protected static final Short SHORT_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShortValue() <em>Short Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortValue()
	 * @generated
	 * @ordered
	 */
	protected Short shortValue = SHORT_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLongValue() <em>Long Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongValue()
	 * @generated
	 * @ordered
	 */
	protected static final Long LONG_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLongValue() <em>Long Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongValue()
	 * @generated
	 * @ordered
	 */
	protected Long longValue = LONG_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnumValue() <em>Enum Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumValue()
	 * @generated
	 * @ordered
	 */
	protected static final String ENUM_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnumValue() <em>Enum Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumValue()
	 * @generated
	 * @ordered
	 */
	protected String enumValue = ENUM_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected PushImpl() {
		super();
		opcode = Opcode.PUSH;
		stackProduction = 1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmftvmPackage.Literals.PUSH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setValue(Object newValue) {
		Object oldValue = value;
		value = newValue;
		// Update typed values to support XMI persistence
		stringValue	= (newValue instanceof String) 		? (String) 		newValue : null;
		intValue	= (newValue instanceof Integer) 	? (Integer) 	newValue : null;
		doubleValue	= (newValue instanceof Double)		? (Double) 		newValue : null;
		byteValue	= (newValue instanceof Byte)		? (Byte)		newValue : null;
		charValue	= (newValue instanceof Character) 	? (Character)	newValue : null;
		floatValue	= (newValue instanceof Float)		? (Float)		newValue : null;
		shortValue	= (newValue instanceof Short)		? (Short)		newValue : null;
		longValue	= (newValue instanceof Long)		? (Long)		newValue : null;
		enumValue	= (newValue instanceof EnumLiteral)	? ((EnumLiteral) newValue).getName() : null;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.PUSH__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String getStringValue() {
		if (value instanceof String) {
			return (String) value;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setStringValue(String newStringValue) {
		String oldStringValue = null;
		if (value instanceof String) {
			oldStringValue = (String) value;
		}
		setValue(newStringValue);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.PUSH__STRING_VALUE, oldStringValue, newStringValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Integer getIntValue() {
		if (value instanceof Integer) {
			return (Integer) value;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setIntValue(Integer newIntValue) {
		Integer oldIntValue = null;
		if (value instanceof Integer) {
			oldIntValue = (Integer) value;
		}
		setValue(newIntValue);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.PUSH__INT_VALUE, oldIntValue, newIntValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Double getDoubleValue() {
		if (value instanceof Double) {
			return (Double) value;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setDoubleValue(Double newDoubleValue) {
		Double oldDoubleValue = null;
		if (value instanceof Double) {
			oldDoubleValue = (Double) value;
		}
		setValue(newDoubleValue);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.PUSH__DOUBLE_VALUE, oldDoubleValue, newDoubleValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Byte getByteValue() {
		if (value instanceof Byte) {
			return (Byte) value;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setByteValue(Byte newByteValue) {
		Byte oldByteValue = null;
		if (value instanceof Byte) {
			oldByteValue = (Byte) value;
		}
		setValue(newByteValue);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.PUSH__BYTE_VALUE, oldByteValue, newByteValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Character getCharValue() {
		if (value instanceof Character) {
			return (Character) value;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setCharValue(Character newCharValue) {
		Character oldCharValue = null;
		if (value instanceof Character) {
			oldCharValue = (Character) value;
		}
		setValue(newCharValue);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.PUSH__CHAR_VALUE, oldCharValue, newCharValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Float getFloatValue() {
		if (value instanceof Float) {
			return (Float) value;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setFloatValue(Float newFloatValue) {
		Float oldFloatValue = null;
		if (value instanceof Float) {
			oldFloatValue = (Float) value;
		}
		setValue(newFloatValue);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.PUSH__FLOAT_VALUE, oldFloatValue, newFloatValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Short getShortValue() {
		if (value instanceof Short) {
			return (Short) value;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setShortValue(Short newShortValue) {
		Short oldShortValue = null;
		if (value instanceof Short) {
			oldShortValue = (Short) value;
		}
		setValue(newShortValue);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.PUSH__SHORT_VALUE, oldShortValue, newShortValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Long getLongValue() {
		if (value instanceof Long) {
			return (Long) value;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setLongValue(Long newLongValue) {
		Long oldLongValue = null;
		if (value instanceof Long) {
			oldLongValue = (Long) value;
		}
		setValue(newLongValue);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.PUSH__LONG_VALUE, oldLongValue, newLongValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String getEnumValue() {
		if (value instanceof EnumLiteral) {
			return ((EnumLiteral) value).getName();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setEnumValue(String newEnumValue) {
		String oldEnumValue = null;
		if (value instanceof EnumLiteral) {
			oldEnumValue = ((EnumLiteral) value).getName();
		}
		setValue(new EnumLiteral(newEnumValue));
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.PUSH__ENUM_VALUE, oldEnumValue, newEnumValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmftvmPackage.PUSH__VALUE:
				return getValue();
			case EmftvmPackage.PUSH__STRING_VALUE:
				return getStringValue();
			case EmftvmPackage.PUSH__INT_VALUE:
				return getIntValue();
			case EmftvmPackage.PUSH__DOUBLE_VALUE:
				return getDoubleValue();
			case EmftvmPackage.PUSH__BYTE_VALUE:
				return getByteValue();
			case EmftvmPackage.PUSH__CHAR_VALUE:
				return getCharValue();
			case EmftvmPackage.PUSH__FLOAT_VALUE:
				return getFloatValue();
			case EmftvmPackage.PUSH__SHORT_VALUE:
				return getShortValue();
			case EmftvmPackage.PUSH__LONG_VALUE:
				return getLongValue();
			case EmftvmPackage.PUSH__ENUM_VALUE:
				return getEnumValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmftvmPackage.PUSH__VALUE:
				setValue(newValue);
				return;
			case EmftvmPackage.PUSH__STRING_VALUE:
				setStringValue((String)newValue);
				return;
			case EmftvmPackage.PUSH__INT_VALUE:
				setIntValue((Integer)newValue);
				return;
			case EmftvmPackage.PUSH__DOUBLE_VALUE:
				setDoubleValue((Double)newValue);
				return;
			case EmftvmPackage.PUSH__BYTE_VALUE:
				setByteValue((Byte)newValue);
				return;
			case EmftvmPackage.PUSH__CHAR_VALUE:
				setCharValue((Character)newValue);
				return;
			case EmftvmPackage.PUSH__FLOAT_VALUE:
				setFloatValue((Float)newValue);
				return;
			case EmftvmPackage.PUSH__SHORT_VALUE:
				setShortValue((Short)newValue);
				return;
			case EmftvmPackage.PUSH__LONG_VALUE:
				setLongValue((Long)newValue);
				return;
			case EmftvmPackage.PUSH__ENUM_VALUE:
				setEnumValue((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmftvmPackage.PUSH__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case EmftvmPackage.PUSH__STRING_VALUE:
				setStringValue(STRING_VALUE_EDEFAULT);
				return;
			case EmftvmPackage.PUSH__INT_VALUE:
				setIntValue(INT_VALUE_EDEFAULT);
				return;
			case EmftvmPackage.PUSH__DOUBLE_VALUE:
				setDoubleValue(DOUBLE_VALUE_EDEFAULT);
				return;
			case EmftvmPackage.PUSH__BYTE_VALUE:
				setByteValue(BYTE_VALUE_EDEFAULT);
				return;
			case EmftvmPackage.PUSH__CHAR_VALUE:
				setCharValue(CHAR_VALUE_EDEFAULT);
				return;
			case EmftvmPackage.PUSH__FLOAT_VALUE:
				setFloatValue(FLOAT_VALUE_EDEFAULT);
				return;
			case EmftvmPackage.PUSH__SHORT_VALUE:
				setShortValue(SHORT_VALUE_EDEFAULT);
				return;
			case EmftvmPackage.PUSH__LONG_VALUE:
				setLongValue(LONG_VALUE_EDEFAULT);
				return;
			case EmftvmPackage.PUSH__ENUM_VALUE:
				setEnumValue(ENUM_VALUE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmftvmPackage.PUSH__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case EmftvmPackage.PUSH__STRING_VALUE:
				return STRING_VALUE_EDEFAULT == null ? stringValue != null : !STRING_VALUE_EDEFAULT.equals(stringValue);
			case EmftvmPackage.PUSH__INT_VALUE:
				return INT_VALUE_EDEFAULT == null ? intValue != null : !INT_VALUE_EDEFAULT.equals(intValue);
			case EmftvmPackage.PUSH__DOUBLE_VALUE:
				return DOUBLE_VALUE_EDEFAULT == null ? doubleValue != null : !DOUBLE_VALUE_EDEFAULT.equals(doubleValue);
			case EmftvmPackage.PUSH__BYTE_VALUE:
				return BYTE_VALUE_EDEFAULT == null ? byteValue != null : !BYTE_VALUE_EDEFAULT.equals(byteValue);
			case EmftvmPackage.PUSH__CHAR_VALUE:
				return CHAR_VALUE_EDEFAULT == null ? charValue != null : !CHAR_VALUE_EDEFAULT.equals(charValue);
			case EmftvmPackage.PUSH__FLOAT_VALUE:
				return FLOAT_VALUE_EDEFAULT == null ? floatValue != null : !FLOAT_VALUE_EDEFAULT.equals(floatValue);
			case EmftvmPackage.PUSH__SHORT_VALUE:
				return SHORT_VALUE_EDEFAULT == null ? shortValue != null : !SHORT_VALUE_EDEFAULT.equals(shortValue);
			case EmftvmPackage.PUSH__LONG_VALUE:
				return LONG_VALUE_EDEFAULT == null ? longValue != null : !LONG_VALUE_EDEFAULT.equals(longValue);
			case EmftvmPackage.PUSH__ENUM_VALUE:
				return ENUM_VALUE_EDEFAULT == null ? enumValue != null : !ENUM_VALUE_EDEFAULT.equals(enumValue);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		if (stringValue != null) {
			result.append(" (stringValue: \"");
			result.append(stringValue);
			result.append('"');
		} else if (intValue != null) {
			result.append(" (intValue: ");
			result.append(intValue);
		} else if (doubleValue != null) {
			result.append(" (doubleValue: ");
			result.append(doubleValue);
		} else if (byteValue != null) {
			result.append(" (byteValue: ");
			result.append(byteValue);
		} else if (charValue != null) {
			result.append(" (charValue: ");
			result.append(charValue);
		} else if (floatValue != null) {
			result.append(" (floatValue: ");
			result.append(floatValue);
		} else if (shortValue != null) {
			result.append(" (shortValue: ");
			result.append(shortValue);
		} else if (longValue != null) {
			result.append(" (longValue: ");
			result.append(longValue);
		} else if (enumValue != null) {
			result.append(" (enumValue: #");
			result.append(enumValue);
		} else {
			result.append(" (value: ");
			result.append(value);
		}
		result.append(')');
		return result.toString();
	}

} //PushImpl
