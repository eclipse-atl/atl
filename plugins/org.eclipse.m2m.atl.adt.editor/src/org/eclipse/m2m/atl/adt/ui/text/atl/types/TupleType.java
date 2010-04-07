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
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * The ATL Tuple type.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
// TODO implement type
@SuppressWarnings("serial")
public final class TupleType extends OclAnyType {

	private static List<Operation> operations;

	/** The parameters of the tuple. */
	protected Map<String, OclAnyType> attributes;
	protected Map<String, EObject> eAttributes;

	static {
		// TODO asMap() implementation
	}

	public TupleType(Map<String, OclAnyType> attributes, Map<String, EObject> eAttributes) {
		super(new OclType(computeName(attributes)));
		this.attributes = attributes;
		this.eAttributes = eAttributes;
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
		// TODO check direct access to Tuple attributes implementation
		List<Feature> features = new ArrayList<Feature>();
		for(String key : this.attributes.keySet()) {
			//features.add(new Feature(null, this.eAttributes.get(key).eContainingFeature(), this.attributes.get(key).getOclType().getMetamodelName()));
			features.add(new Feature(null, this.eAttributes.get(key), key, this.oclType, this.attributes.get(key), false, false, 1, 1));
		}
		Collections.sort(features);
		return features;
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
					add(new Operation("asMap", getInstance(), null) { //$NON-NLS-1$
						@Override
						public OclAnyType getType(OclAnyType context, Object... parameters) {
							if (context instanceof TupleType) {
								//TupleType tuple = (TupleType)context;
								// TODO: see if there is a way for getting HashMap keys and values types directly from the "attributes" attribute
								return new MapType(StringType.getInstance(), OclAnyType.getInstance());
							}
							return null;
						}
					});
				}
			};
		}
		return operations;
	}

	private static String computeName(Map<String, OclAnyType> attributes) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Tuple"); //$NON-NLS-1$
		buffer.append('(');
		for(String key : attributes.keySet()) {
			buffer.append(key + ": " + attributes.get(key).toString() + ", ");
		}
		buffer.setLength(buffer.length()-2);
		// TODO check display parameters
		buffer.append(')');
		return buffer.toString();
	}
}
