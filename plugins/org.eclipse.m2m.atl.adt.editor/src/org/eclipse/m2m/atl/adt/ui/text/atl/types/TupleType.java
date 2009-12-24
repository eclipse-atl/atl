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

import java.util.Collections;
import java.util.List;

/**
 * The ATL Tuple type.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
// TODO implement type
public final class TupleType extends OclAnyType {

	private static List<Operation> operations;

	static {
		// TODO asMap() implementation
	}

	private TupleType() {
		super(new OclType(computeName()));
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

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.OclAnyType#getOclType()
	 */
	@Override
	public OclType getOclType() {
		return oclType;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.OclAnyType#getFeatures()
	 */
	@Override
	public List<Feature> getFeatures() {
		// TODO implement direct access to Tuple attributes
		return Collections.emptyList();
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

	private static String computeName() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Tuple"); //$NON-NLS-1$
		buffer.append('(');
		// TODO display parameters
		buffer.append(')');
		return buffer.toString();
	}
}
