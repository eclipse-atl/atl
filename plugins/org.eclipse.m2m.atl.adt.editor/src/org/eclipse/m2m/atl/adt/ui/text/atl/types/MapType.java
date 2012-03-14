/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - completion system
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The ATL Map type.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:thierry.fortin@obeo.fr">Thierry Fortin</a>
 */
@SuppressWarnings("serial")
public class MapType extends OclAnyType {

	private static List<Operation> operations;

	private OclAnyType keyType;

	private OclAnyType valueType;

	/**
	 * Creates a new Map type with the given key and value types.
	 * 
	 * @param keyType
	 *            the key type
	 * @param valueType
	 *            the value type
	 */
	public MapType(OclAnyType keyType, OclAnyType valueType) {
		super(new OclType(computeName(keyType, valueType)));
		this.keyType = keyType;
		this.valueType = valueType;
	}

	public OclAnyType getKeyType() {
		return keyType;
	}

	public OclAnyType getValueType() {
		return valueType;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.org.eclipse.m2m.atl.adt.ui.text.atl.types.OclAnyType#getTypeOperations()
	 */
	@Override
	protected List<Operation> getTypeOperations() {
		if (operations == null) {
			operations = new ArrayList<Operation>() {
				{
					add(new Operation("get", getInstance(), null, //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
						{
							put("key", OclAnyType.getInstance()); //$NON-NLS-1$
						}
					}) {
						@Override
						public OclAnyType getType(OclAnyType context, Object... parameters) {
							if (context instanceof MapType) {
								return ((MapType)context).getValueType();
							}
							return null;
						}
					});
					add(new Operation("including", getInstance(), null, //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("key", OclAnyType.getInstance()); //$NON-NLS-1$
									put("val", OclAnyType.getInstance()); //$NON-NLS-1$
								}
							}
					));
					add(new Operation("union", getInstance(), null, //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("m", MapType.getInstance()); //$NON-NLS-1$
								}
							}
					));
					add(new Operation("getKeys", getInstance(), null) { //$NON-NLS-1$
						@Override
						public OclAnyType getType(OclAnyType context, Object... parameters) {
							if (context instanceof MapType) {
								return SetType.getInstance();
							}
							return null;
						}
					});
					add(new Operation("getValues", getInstance(), null) { //$NON-NLS-1$
						@Override
						public OclAnyType getType(OclAnyType context, Object... parameters) {
							if (context instanceof MapType) {
								return BagType.getInstance();
							}
							return null;
						}
					});
				}
			};
		}
		return operations;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.org.eclipse.m2m.atl.adt.ui.text.atl.types.OclAnyType#getSupertypes()
	 */
	@Override
	public OclAnyType[] getSupertypes() {
		return new OclAnyType[] {OclAnyType.getInstance()};
	}

	private static String computeName(OclAnyType keyType, OclAnyType valueType) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Map"); //$NON-NLS-1$
		buffer.append('(');
		buffer.append(keyType.toString());
		buffer.append(", "); //$NON-NLS-1$
		buffer.append(valueType.toString());
		buffer.append(')');
		return buffer.toString();
	}
}
