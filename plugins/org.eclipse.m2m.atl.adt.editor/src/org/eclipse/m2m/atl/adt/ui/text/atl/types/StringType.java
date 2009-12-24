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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * The ATL String type.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
@SuppressWarnings("serial")
public final class StringType extends OclAnyType {

	/** The singleton instance. */
	private static StringType instance;

	private static List<Operation> operations;

	private StringType() {
		super(new OclType("String")); //$NON-NLS-1$
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
					add(new Operation("size", getInstance(), IntegerType.getInstance())); //$NON-NLS-1$
					add(new Operation("concat", getInstance(), getInstance(), //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("s", getInstance()); //$NON-NLS-1$
								}
							}));
					add(new Operation("substring", getInstance(), getInstance(), //$NON-NLS-1$
							new LinkedHashMap<String, OclAnyType>() {
								{
									put("lower", IntegerType.getInstance()); //$NON-NLS-1$
									put("upper", IntegerType.getInstance()); //$NON-NLS-1$
								}
							}));
					add(new Operation("toInteger", getInstance(), IntegerType.getInstance())); //$NON-NLS-1$
					add(new Operation("toReal", getInstance(), RealType.getInstance())); //$NON-NLS-1$
					add(new Operation("toUpper", getInstance(), getInstance())); //$NON-NLS-1$
					add(new Operation("toLower", getInstance(), getInstance())); //$NON-NLS-1$
					add(new Operation("toSequence", getInstance(), new SequenceType(getInstance()))); //$NON-NLS-1$
					add(new Operation("trim", getInstance(), getInstance())); //$NON-NLS-1$
					add(new Operation("startsWith", getInstance(), BooleanType.getInstance(), //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("s", getInstance()); //$NON-NLS-1$
								}
							}));
					add(new Operation("endsWith", getInstance(), BooleanType.getInstance(), //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("s", getInstance()); //$NON-NLS-1$
								}
							}));
					add(new Operation("indexOf", getInstance(), IntegerType.getInstance(), //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("s", getInstance()); //$NON-NLS-1$
								}
							}));
					add(new Operation("lastIndexOf", getInstance(), IntegerType.getInstance(), //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("s", getInstance()); //$NON-NLS-1$
								}
							}));
					add(new Operation("replaceAll", getInstance(), getInstance(), //$NON-NLS-1$
							new LinkedHashMap<String, OclAnyType>() {
								{
									put("c1", getInstance()); //$NON-NLS-1$
									put("c2", getInstance()); //$NON-NLS-1$
								}
							}));
					add(new Operation("regexReplaceAll", getInstance(), getInstance(), //$NON-NLS-1$
							new LinkedHashMap<String, OclAnyType>() {
								{
									put("regex", getInstance()); //$NON-NLS-1$
									put("replacement", getInstance()); //$NON-NLS-1$
								}
							}));
					add(new Operation("split", getInstance(), new SequenceType(getInstance()), //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("regex", getInstance()); //$NON-NLS-1$
								}
							}));
					add(new Operation("println", getInstance(), getInstance())); //$NON-NLS-1$

					add(new Operation("writeTo", getInstance(), getInstance(), //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("fileName", getInstance()); //$NON-NLS-1$
								}
							}));

					add(new Operation("writeToWithCharset", getInstance(), getInstance(), //$NON-NLS-1$
							new LinkedHashMap<String, OclAnyType>() {
								{
									put("fileName", getInstance()); //$NON-NLS-1$
									put("charSet", getInstance()); //$NON-NLS-1$
								}
							}));

				}
			};
		}
		return operations;
	}

	/**
	 * Returns the String type singleton.
	 * 
	 * @return the String type singleton
	 */
	public static StringType getInstance() {
		if (instance == null) {
			instance = new StringType();
		}
		return instance;
	}

}
