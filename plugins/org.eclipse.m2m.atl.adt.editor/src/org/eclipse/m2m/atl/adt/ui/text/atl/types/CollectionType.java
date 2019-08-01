/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - completion system
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The ATL Collection type.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
@SuppressWarnings("serial")
public class CollectionType extends OclAnyType {

	/** The singleton instance. */
	private static CollectionType instance;

	private static List<Operation> operations;

	/** The parameter of the collection. */
	protected OclAnyType parameterType;

	/**
	 * Constructor.
	 * 
	 * @param parameter
	 *            the Collection parameter type
	 */
	public CollectionType(OclAnyType parameter) {
		super(new OclType(computeName("Collection", parameter))); //$NON-NLS-1$
		parameterType = parameter;
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
	 * Returns the collection kind.
	 * 
	 * @return the collection kind
	 */
	public String getCollectionType() {
		return "Collection"; //$NON-NLS-1$
	}

	/**
	 * Returns the collection parameter type.
	 * 
	 * @return the collection parameter type
	 */
	public OclAnyType getParameterType() {
		return parameterType;
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
					add(new Operation("isEmpty", getInstance(), BooleanType.getInstance())); //$NON-NLS-1$

					add(new Operation("notEmpty", getInstance(), BooleanType.getInstance())); //$NON-NLS-1$

					add(new Operation("size", getInstance(), IntegerType.getInstance())); //$NON-NLS-1$

					add(new Operation("asSequence", getInstance(), null) { //$NON-NLS-1$
						@Override
						public OclAnyType getType(OclAnyType context, Object... parameters) {
							if (context instanceof CollectionType) {
								CollectionType collection = (CollectionType)context;
								return new SequenceType(collection.getParameterType());
							}
							return null;
						}
					});

					add(new Operation("asSet", getInstance(), null) { //$NON-NLS-1$
						@Override
						public OclAnyType getType(OclAnyType context, Object... parameters) {
							if (context instanceof CollectionType) {
								CollectionType collection = (CollectionType)context;
								return new SetType(collection.getParameterType());
							}
							return null;
						}
					});

					add(new Operation("asOrderedSet", getInstance(), null) { //$NON-NLS-1$
						@Override
						public OclAnyType getType(OclAnyType context, Object... parameters) {
							if (context instanceof CollectionType) {
								CollectionType collection = (CollectionType)context;
								return new OrderedSetType(collection.getParameterType());
							}
							return null;
						}
					});

					add(new Operation("asBag", getInstance(), null) { //$NON-NLS-1$
						@Override
						public OclAnyType getType(OclAnyType context, Object... parameters) {
							if (context instanceof CollectionType) {
								CollectionType collection = (CollectionType)context;
								return new BagType(collection.getParameterType());
							}
							return null;
						}
					});

					add(new Operation("flatten", getInstance(), null) { //$NON-NLS-1$
						@Override
						public OclAnyType getType(OclAnyType context, Object... parameters) {
							OclAnyType type = context;
							while (type instanceof CollectionType) {
								type = ((CollectionType)type).getParameterType();
							}
							return new CollectionType(type);
						}
					});

					add(new Operation("count", getInstance(), IntegerType.getInstance(), //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("o", OclAnyType.getInstance()); //$NON-NLS-1$
								}
							}));

					add(new Operation("sum", getInstance(), OclAnyType.getInstance())); //$NON-NLS-1$

					add(new Operation("includes", getInstance(), BooleanType.getInstance(), //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("o", OclAnyType.getInstance()); //$NON-NLS-1$
								}
							}));

					add(new Operation("excludes", getInstance(), BooleanType.getInstance(), //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("o", OclAnyType.getInstance()); //$NON-NLS-1$
								}
							}));

					add(new Operation("includesAll", getInstance(), BooleanType.getInstance(), //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("c", CollectionType.getInstance()); //$NON-NLS-1$
								}
							}));

					add(new Operation("excludesAll", getInstance(), BooleanType.getInstance(), //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("c", CollectionType.getInstance()); //$NON-NLS-1$
								}
							}));

					add(new Operation("excluding", getInstance(), null, //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("o", OclAnyType.getInstance()); //$NON-NLS-1$
								}
							}));

					add(new Operation("including", getInstance(), null, //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("o", OclAnyType.getInstance()); //$NON-NLS-1$
								}
							}));
				}
			};
		}
		return operations;
	}

	/**
	 * Computes the name of the collection with the given parameter type.
	 * 
	 * @param collectionType
	 *            the collection type (Sequence, Bag, Set, OrderedSet)
	 * @param parameterType
	 *            the parameter type
	 * @return the computed name
	 */
	protected static String computeName(String collectionType, OclAnyType parameterType) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(collectionType);
		buffer.append('(');
		buffer.append(parameterType.toString());
		buffer.append(')');
		return buffer.toString();
	}

	/**
	 * Returns the default Collection type singleton.
	 * 
	 * @return the default Collection type singleton
	 */
	public static CollectionType getInstance() {
		if (instance == null) {
			instance = new CollectionType(OclAnyType.getInstance());
		}
		return instance;
	}
}
