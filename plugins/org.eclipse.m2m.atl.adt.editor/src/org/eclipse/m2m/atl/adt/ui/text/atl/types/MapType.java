/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - completion system
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl.types;

import java.util.List;

/**
 * The ATL Map type.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
// TODO implement MapType
public class MapType extends OclAnyType {

	private static List<Operation> operations;

	private OclAnyType keyType;

	private OclAnyType valueType;

	// static {
	// operations = new HashSet<Operation>() {
	// {
	// }
	// };
	// // TODO implement get => value
	// // TODO implement including => self
	// // TODO implement union => self
	// // TODO implement getKeys => Set(key)
	// // TODO implement getValues() => Bag(value)
	// }

	/**
	 * Creates a new Map type with the given key and value types.
	 * 
	 * @param keyType
	 *            the key type
	 * @param valueType
	 *            the value type
	 */
	public MapType(OclAnyType keyType, OclAnyType valueType) {
		super(new OclType(computeName("Map"))); //$NON-NLS-1$
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
	 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.OclAnyType#getTypeOperations()
	 */
	@Override
	protected List<Operation> getTypeOperations() {
		return operations;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.OclAnyType#getSupertypes()
	 */
	@Override
	public OclAnyType[] getSupertypes() {
		return new OclAnyType[] {OclAnyType.getInstance()};
	}

	private static String computeName(String collectionType) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Map"); //$NON-NLS-1$
		buffer.append('(');
		// buffer.append(keyType.toString());
		//		buffer.append(", "); //$NON-NLS-1$
		// buffer.append(valueType.toString());
		buffer.append(')');
		return buffer.toString();
	}
}
