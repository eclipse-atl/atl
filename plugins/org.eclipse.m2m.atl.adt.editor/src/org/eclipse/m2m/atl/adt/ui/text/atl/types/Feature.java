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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;

/**
 * The Feature wrapper.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class Feature implements Comparable<Feature> {

	protected String name;

	private OclAnyType contextType;

	private OclAnyType type;

	private boolean many;

	private boolean ordered;

	private int lower;

	private int upper;

	private String imagePath;

	private boolean container;

	private String oppositeName;

	private EObject declaration;

	/**
	 * Creates a new feature using the given parameters.
	 * 
	 * @param name
	 *            the feature name
	 * @param contextType
	 *            the feature context type
	 * @param type
	 *            the feature type
	 * @param ordered
	 *            the feature "is ordered" flag
	 * @param container
	 *            the feature "is container" flag
	 * @param lower
	 *            the feature lower bound
	 * @param upper
	 *            the feature upper bound
	 */
	public Feature(EObject declaration, String name, OclAnyType contextType, OclAnyType type,
			boolean ordered, boolean container, int lower, int upper) {
		super();
		this.name = name;
		this.type = type;
		this.contextType = contextType;
		this.ordered = ordered;
		this.lower = lower;
		this.upper = upper;
		this.container = container;
		this.many = upper > 1 || upper == -1;
		this.declaration = declaration;
		if (isMany()) {
			this.imagePath = "$nl$/icons/model_reference.gif"; //$NON-NLS-1$
		} else {
			this.imagePath = "$nl$/icons/model_attribute.gif"; //$NON-NLS-1$
		}
	}

	/**
	 * Creates a new feature from an EMF one.
	 * 
	 * @param feature
	 *            the EMF feature
	 * @param metamodelName
	 *            the metamodel name
	 */
	public Feature(EStructuralFeature feature, String metamodelName) {
		super();
		this.name = feature.getName();
		this.type = ModelElementType.create(feature.getEType(), metamodelName);
		this.contextType = ModelElementType.create(feature.getEContainingClass(), metamodelName);
		this.ordered = feature.isOrdered();
		this.lower = feature.getLowerBound();
		this.upper = feature.getUpperBound();
		this.container = false;
		this.declaration = feature;
		if (feature instanceof EReference) {
			this.container = ((EReference)feature).isContainment();
			EReference opposite = ((EReference)feature).getEOpposite();
			if (opposite != null) {
				this.oppositeName = opposite.getName();
			}
		}
		this.many = upper > 1 || upper == -1;
		if (isMany()) {
			this.imagePath = "$nl$/icons/model_reference.gif"; //$NON-NLS-1$
		} else {
			this.imagePath = "$nl$/icons/model_attribute.gif"; //$NON-NLS-1$
		}
	}

	public boolean isOrdered() {
		return ordered;
	}

	public boolean isMany() {
		return many;
	}

	public String getOppositeName() {
		return oppositeName;
	}

	public boolean isContainer() {
		return container;
	}

	public String getName() {
		return name;
	}

	/**
	 * Returns the feature type.
	 * 
	 * @return the feature type
	 */
	public OclAnyType getType() {
		if (many) {
			// Keep in synchronization with VM's behaviors
			// if (ordered) {
			return new SequenceType(type);
			// } else {
			// return new BagType(type);
			// }
		}
		return type;
	}

	public EObject getDeclaration() {
		return declaration;
	}

	public OclAnyType getContextType() {
		return contextType;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Feature) {
			Feature feature = (Feature)obj;
			return name.equals(feature.name);
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}

	public int getLowerBound() {
		return lower;
	}

	public int getUpperBound() {
		return upper;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getImagePath() {
		return imagePath;
	}

	/**
	 * Utility method to initialize a Feature from an ATL model attribute helper.
	 * 
	 * @param manager
	 *            the source manager, used to map the type
	 * @param attribute
	 *            the attribute helper model element
	 * @param context
	 *            the attribute context type
	 * @return the Feature
	 */
	public static Feature createFromAttribute(AtlSourceManager manager, EObject attribute, OclAnyType context) {
		String featureName = (String)AtlTypesProcessor.eGet(attribute, "name"); //$NON-NLS-1$
		EObject featureType = (EObject)AtlTypesProcessor.eGet(attribute, "type"); //$NON-NLS-1$
		OclAnyType type = OclAnyType.create(manager, featureType);
		if (featureName != null) {
			boolean ordered = type instanceof SequenceType || type instanceof OrderedSetType;
			int upper = 1;
			if (type instanceof CollectionType) {
				upper = -1;
			}
			Feature res = new Feature(attribute, featureName, context, type, ordered, false, 1, upper);
			res.setImagePath("$nl$/icons/helper.gif"); //$NON-NLS-1$
			return res;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Feature o) {
		return toString().compareTo(o.toString());
	}

	/**
	 * Returns a description of the feature.
	 * 
	 * @return a description of the feature
	 */
	public String getInformation() {
		StringBuffer information = new StringBuffer();
		information.append(getName());
		information.append(" : "); //$NON-NLS-1$

		if (isMany()) {
			OclAnyType type = getType();
			if (type instanceof CollectionType) {
				information.append(((CollectionType)type).getParameterType());
			} else {
				// should not happen
				information.append(getType());
			}
			information.append(' ');
			if (isContainer()) {
				information.append('[');
			} else {
				information.append('{');
			}
			information.append(getLowerBound());
			information.append(".."); //$NON-NLS-1$
			if (getUpperBound() == -1) {
				information.append('*');
			} else {
				information.append(getUpperBound());
			}
			if (isContainer()) {
				information.append(']');
			} else {
				information.append('}');
			}
		} else {
			information.append(getType());
		}
		return information.toString();
	}

}
