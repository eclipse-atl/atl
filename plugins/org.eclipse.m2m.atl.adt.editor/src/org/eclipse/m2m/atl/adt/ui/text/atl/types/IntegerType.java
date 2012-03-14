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
 * The ATL Integer type.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
@SuppressWarnings("serial")
public final class IntegerType extends OclAnyType {

	/** The singleton instance. */
	private static IntegerType instance;

	private static List<Operation> operations;

	private IntegerType() {
		super(new OclType("Integer")); //$NON-NLS-1$
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
	 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.OclAnyType#getTypeOperations()
	 */
	@Override
	protected List<Operation> getTypeOperations() {
		if (operations == null) {
			operations = new ArrayList<Operation>() {
				{
					add(new Operation("abs", getInstance(), getInstance())); //$NON-NLS-1$
					add(new Operation("mod", getInstance(), getInstance())); //$NON-NLS-1$
					add(new Operation("max", getInstance(), getInstance(), //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("i", getInstance()); //$NON-NLS-1$
								}
							}));
					add(new Operation("min", getInstance(), getInstance(), //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("i", getInstance()); //$NON-NLS-1$
								}
							}));

					add(new Operation("toHexString", getInstance(), StringType.getInstance())); //$NON-NLS-1$
					add(new Operation("toBinaryString", getInstance(), StringType.getInstance())); //$NON-NLS-1$
				}
			};
		}
		return operations;
	}

	/**
	 * Returns the Integer type singleton.
	 * 
	 * @return the Integer type singleton
	 */
	public static IntegerType getInstance() {
		if (instance == null) {
			instance = new IntegerType();
		}
		return instance;
	}
}
