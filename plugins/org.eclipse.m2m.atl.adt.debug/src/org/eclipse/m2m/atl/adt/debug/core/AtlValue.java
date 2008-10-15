/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.debug.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.engine.vm.adwp.BooleanValue;
import org.eclipse.m2m.atl.engine.vm.adwp.IntegerValue;
import org.eclipse.m2m.atl.engine.vm.adwp.NullValue;
import org.eclipse.m2m.atl.engine.vm.adwp.ObjectReference;
import org.eclipse.m2m.atl.engine.vm.adwp.RealValue;
import org.eclipse.m2m.atl.engine.vm.adwp.StringValue;
import org.eclipse.m2m.atl.engine.vm.adwp.Value;

/**
 * ATL Value (for debug).
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class AtlValue extends AtlDebugElement implements IValue {

	String typeName;

	String asString;

	Value value;

	ObjectReference asType;

	AtlDebugTarget atlDT;

	/**
	 * Constructor.
	 *  
	 * @param value the value
	 * @param atlDT the debug target
	 * @param asType the reference
	 */
	public AtlValue(Value value, ObjectReference asType, AtlDebugTarget atlDT) {
		this(value, atlDT);
		this.asType = asType;
		this.typeName = getTypeName(value, asType);
		asString = value.toString();
	}

	/**
	 * Constructor.
	 *  
	 * @param value the value
	 * @param atlDT the debug target
	 */
	public AtlValue(Value value, AtlDebugTarget atlDT) {
		super(atlDT);
		this.value = value;
		this.atlDT = atlDT;
		this.typeName = getTypeName(value);
		if (typeName.equals("EnumLiteral")) { //$NON-NLS-1$
			asString = ((StringValue)(((ObjectReference)value).call("toString", Collections.EMPTY_LIST))).getValue(); //$NON-NLS-1$
		} else {
			asString = value.toString();
		}
	}

	static String getTypeName(Value value) {
		return getTypeName(value, null);
	}

	static String getTypeName(Value value, ObjectReference asType) {
		String ret = null;

		if (value instanceof BooleanValue) {
			ret = "Boolean"; //$NON-NLS-1$
		}
		if (value instanceof IntegerValue) {
			ret = "Integer"; //$NON-NLS-1$
		}
		if (value instanceof RealValue) {
			ret = "Real"; //$NON-NLS-1$
		}
		if (value instanceof StringValue) {
			ret = "String"; //$NON-NLS-1$
		}
		if (value instanceof NullValue) {
			ret = "Null"; //$NON-NLS-1$
		}
		if (value instanceof ObjectReference) {
			ObjectReference or = (ObjectReference)value;
			Object v = asType;
			if (v == null) {
				v = or.call("oclType", new ArrayList()); //$NON-NLS-1$
			}
			if (v instanceof ObjectReference) {
				or = (ObjectReference)v;
				ret = ((StringValue)or.call("getName", new ArrayList())).getValue(); //$NON-NLS-1$
			} else {
				ret = "ObjectReference"; //$NON-NLS-1$
			}
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IValue#getReferenceTypeName()
	 */
	public String getReferenceTypeName() throws DebugException {
		return typeName;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IValue#getValueString()
	 */
	public String getValueString() throws DebugException {
		return asString;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IValue#isAllocated()
	 */
	public boolean isAllocated() throws DebugException {
		return true;
	}

	private IVariable[] getProperties(ObjectReference orValue, ObjectReference type, String supertypesName,
			String contentsName, String referenceName, String attributeName) throws DebugException {
		IVariable[] ret = null;
		List list = new ArrayList();

		// Add supertypes
		ObjectReference supertypes = (ObjectReference)type.get(supertypesName); // Sequence
		int n = ((IntegerValue)supertypes.call("size", new ArrayList()))//$NON-NLS-1$
				.getValue();
		for (int i = 1; i <= n; i++) {
			ObjectReference element = (ObjectReference)supertypes.call(
					"at", Arrays.asList(new Object[] {IntegerValue.valueOf(i)})); //$NON-NLS-1$  
			list.add(new AtlVariable(
					"<supertype>", new AtlValue(value, element, atlDT), atlDT, AtlVariable.SUPERTYPE)); //$NON-NLS-1$
		}

		// Add StructuralFeatures in contents
		ObjectReference contents = (ObjectReference)type.get(contentsName); // Sequence
		n = ((IntegerValue)contents.call("size", new ArrayList())).getValue(); //$NON-NLS-1$
		for (int i = 1; i <= n; i++) {
			ObjectReference element = (ObjectReference)contents.call(
					"at", Arrays.asList(new Object[] {IntegerValue.valueOf(i)})); //$NON-NLS-1$
			String tn = getTypeName(element);
			if (tn.equals(referenceName)) {
				String en = ((StringValue)element.get("name")).getValue(); //$NON-NLS-1$
				Value varValue = orValue.get(en);
				list.add(new AtlVariable(en, new AtlValue(varValue, atlDT), atlDT, AtlVariable.REFERENCE));
			} else if (tn.equals(attributeName)) {
				String en = ((StringValue)element.get("name")).getValue(); //$NON-NLS-1$
				Value varValue = orValue.get(en);
				list.add(new AtlVariable(en, new AtlValue(varValue, atlDT), atlDT, AtlVariable.ATTRIBUTE));
			}
		}
		ret = (IVariable[])list.toArray(new IVariable[0]);

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IValue#getVariables()
	 */
	public IVariable[] getVariables() throws DebugException {
		IVariable[] ret = null;

		if (value instanceof ObjectReference) {
			ObjectReference orValue = (ObjectReference)value;
			Value v = asType;
			if (v == null) {
				v = orValue.call("oclType", new ArrayList()); //$NON-NLS-1$
			}
			if (v instanceof ObjectReference) {
				ObjectReference type = (ObjectReference)v;
				String ttn = getTypeName(type);
				if (ttn.equals("MOF!Class")) { //$NON-NLS-1$
					ret = getProperties(orValue, type,
							"supertypes", "contents", "MOF!Reference", "MOF!Attribute"); //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$
				} else if (ttn.equals("MOF!EClass")) { //$NON-NLS-1$
					ret = getProperties(orValue, type,
							"eSuperTypes", "eStructuralFeatures", "MOF!EReference", "MOF!EAttribute"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				} else {
					String tn = typeName;
					if (tn.equals("Sequence")) { //$NON-NLS-1$
						ret = doSequence(orValue);
					} else if (tn.equals("Set")) { //$NON-NLS-1$
						orValue = (ObjectReference)orValue.call("asSequence", new ArrayList()); //$NON-NLS-1$
						ret = doSequence(orValue);
					} else if (tn.equals("Bag")) { //$NON-NLS-1$
						orValue = (ObjectReference)orValue.call("asSequence", new ArrayList()); //$NON-NLS-1$
						ret = doSequence(orValue);
					} else if (tn.equals("OrderedSet")) { //$NON-NLS-1$
						orValue = (ObjectReference)orValue.call("asSequence", new ArrayList()); //$NON-NLS-1$
						ret = doSequence(orValue);
					} else if (tn.equals("Map")) { //$NON-NLS-1$
						ret = doMap(orValue, false);
					} else if (tn.startsWith("TupleType(")) { //$NON-NLS-1$
						ObjectReference map = (ObjectReference)orValue.call("asMap", new ArrayList()); //$NON-NLS-1$
						ret = doMap(map, true);
					} else if (tn.equals("Module")) {
						ObjectReference map = (ObjectReference)orValue.call("asMap", new ArrayList()); //$NON-NLS-1$
						ret = doMap(map, true);
					}
				}
			}

		}

		if (ret == null) {
			ret = new IVariable[] {};
		}

		return ret;
	}

	private IVariable[] doMap(ObjectReference orValue, boolean useKeyAsName) {
		IVariable[] ret = null;
		ObjectReference keys = (ObjectReference)orValue.call("getKeys", new ArrayList()); //$NON-NLS-1$

		keys = (ObjectReference)keys.call("asSequence", new ArrayList()); //$NON-NLS-1$

		List list = new ArrayList();
		int n = ((IntegerValue)keys.call("size", new ArrayList())).getValue(); //$NON-NLS-1$
		for (int i = 1; i <= n; i++) {
			Value varKey = (Value)keys.call("at", Arrays.asList(new Object[] {IntegerValue.valueOf(i)})); //$NON-NLS-1$
			Value varValue = (Value)orValue.call("get", Arrays.asList(new Object[] {varKey})); //$NON-NLS-1$

			if (useKeyAsName) {
				list.add(new AtlVariable(((StringValue)varKey).getValue(), new AtlValue(varValue, atlDT),
						atlDT, AtlVariable.ATTRIBUTE));
			} else {
				list
						.add(new AtlVariable(
								"Map[" + i + "]", new AtlMapValue(varKey, varValue, atlDT), atlDT, AtlVariable.ELEMENT)); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		ret = (IVariable[])list.toArray(new IVariable[0]);
		if (ret.length == 0) {
			ret = null;
		}
		return ret;
	}

	/**
	 * This method returns an array of IVariable From an object reference, the variable of this object
	 * reference are returned.
	 * 
	 * @param orValue
	 *            the referenced value
	 * @return an array of IVariable From an object reference, the variable of this object reference are
	 *         returned
	 */
	private IVariable[] doSequence(ObjectReference orValue) {
		IVariable[] ret = null;
		List list = new ArrayList();

		int n = ((IntegerValue)orValue.call("size", new ArrayList())).getValue(); //$NON-NLS-1$
		for (int i = 1; i <= n; i++) {
			Value varValue = (Value)orValue.call("at", Arrays.asList(new Object[] {IntegerValue.valueOf(i)})); //$NON-NLS-1$
			list
					.add(new AtlVariable(
							"[" + i + "]", new AtlValue(varValue, atlDT), atlDT, AtlVariable.ELEMENT)); //$NON-NLS-1$ //$NON-NLS-2$
		}
		ret = (IVariable[])list.toArray(new IVariable[0]);
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IValue#hasVariables()
	 */
	public boolean hasVariables() throws DebugException {
		return getVariables() != null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.debug.core.AtlDebugElement#getModelIdentifier()
	 */
	public String getModelIdentifier() {
		return atlDT.getModelIdentifier();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.debug.core.AtlDebugElement#getDebugTarget()
	 */
	public IDebugTarget getDebugTarget() {
		return atlDT.getDebugTarget();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.debug.core.AtlDebugElement#getLaunch()
	 */
	public ILaunch getLaunch() {
		return atlDT.getLaunch();
	}

	/**
	 * Returns the ATL value.
	 * 
	 * @return the ATL value
	 */
	public Value getValue() {
		return value;
	}

	/**
	 * Returns <code>true</code> if the value has variables or <code>false</code> elsewhere.
	 * 
	 * @return <code>true</code> if the value has variables or <code>false</code> elsewhere
	 */
	public boolean isContainer() {
		try {
			hasVariables();
		} catch (DebugException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		return false;
	}

}
