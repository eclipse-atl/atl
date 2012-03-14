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
 * The ATL Real type.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
@SuppressWarnings("serial")
public final class RealType extends OclAnyType {

	/** The singleton instance. */
	private static RealType instance;

	private static List<Operation> operations;

	private RealType() {
		super(new OclType("Real")); //$NON-NLS-1$
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
					add(new Operation("max", getInstance(), getInstance(), new HashMap<String, OclAnyType>() { //$NON-NLS-1$
								{
									put("r", getInstance()); //$NON-NLS-1$
								}
							}));
					add(new Operation("min", getInstance(), getInstance(), new HashMap<String, OclAnyType>() { //$NON-NLS-1$
								{
									put("r", getInstance()); //$NON-NLS-1$
								}
							}));
					add(new Operation("round", getInstance(), getInstance())); //$NON-NLS-1$
					add(new Operation("floor", getInstance(), getInstance())); //$NON-NLS-1$
					add(new Operation("cos", getInstance(), getInstance())); //$NON-NLS-1$
					add(new Operation("sin", getInstance(), getInstance())); //$NON-NLS-1$
					add(new Operation("tan", getInstance(), getInstance())); //$NON-NLS-1$
					add(new Operation("asin", getInstance(), getInstance())); //$NON-NLS-1$
					add(new Operation("acos", getInstance(), getInstance())); //$NON-NLS-1$
					add(new Operation("atan", getInstance(), getInstance())); //$NON-NLS-1$
					add(new Operation("toRadians", getInstance(), getInstance())); //$NON-NLS-1$
					add(new Operation("toDegrees", getInstance(), getInstance())); //$NON-NLS-1$
					add(new Operation("exp", getInstance(), getInstance())); //$NON-NLS-1$
					add(new Operation("log", getInstance(), getInstance())); //$NON-NLS-1$
					add(new Operation("sqrt", getInstance(), getInstance())); //$NON-NLS-1$
				};
			};
		}
		return operations;
	}

	/**
	 * Returns the Real type singleton.
	 * 
	 * @return the Real type singleton
	 */
	public static RealType getInstance() {
		if (instance == null) {
			instance = new RealType();
		}
		return instance;
	}
}
