/*******************************************************************************
 * Copyright (c) 2009, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - completion system
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl.types;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * The Feature wrapper.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:thierry.fortin@obeo.fr">Thierry Fortin</a>
 */
public class Feature implements Comparable<Feature> {
	private static final String DOCUMENTATION_COMMENTS_PREFIX = "---"; //$NON-NLS-1$

	protected String name;

	private UnitType unit;

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

	protected String documentation;

	/**
	 * Creates a new feature using the given parameters.
	 * 
	 * @param unit
	 *            the atl unit containing the declaration
	 * @param declaration
	 *            the feature declaration
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
	public Feature(UnitType unit, EObject declaration, String name, OclAnyType contextType, OclAnyType type,
			boolean ordered, boolean container, int lower, int upper) {
		super();
		this.name = name;
		this.type = type;
		this.contextType = contextType;
		this.ordered = ordered;
		this.lower = lower;
		this.upper = upper;
		this.container = container;
//		this.many = upper > 1 || upper == -1;
		this.many = false; // the complete type is already defined by the helper declaration
		this.declaration = declaration;
		this.unit = unit;
		if (isMany()) {
			this.imagePath = "$nl$/icons/model_reference.gif"; //$NON-NLS-1$
		} else {
			this.imagePath = "$nl$/icons/model_attribute.gif"; //$NON-NLS-1$
		}
	}

	/**
	 * Creates a new feature from an EMF one.
	 * 
	 * @param unit
	 *            the atl unit containing the declaration
	 * @param feature
	 *            the EMF feature
	 * @param metamodelName
	 *            the metamodel name
	 */
	public Feature(UnitType unit, EStructuralFeature feature, String metamodelName) {
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
	 * @param unit
	 *            the atl unit containing the declaration
	 * @param attribute
	 *            the attribute helper model element
	 * @param context
	 *            the attribute context type
	 * @return the Feature
	 */
	public static Feature createFromAttribute(UnitType unit, EObject attribute, OclAnyType context) {
		String featureName = (String)AtlTypesProcessor.eGet(attribute, "name"); //$NON-NLS-1$
		EObject featureType = (EObject)AtlTypesProcessor.eGet(attribute, "type"); //$NON-NLS-1$
		OclAnyType type = OclAnyType.create(unit.getSourceManager(), featureType);
		if (featureName != null) {
			boolean ordered = type instanceof SequenceType || type instanceof OrderedSetType;
			int upper = 1;
			if (type instanceof CollectionType) {
				upper = -1;
			}
			Feature feature = new Feature(unit, attribute, featureName, context, type, ordered, false, 1,
					upper);
			feature.setImagePath("$nl$/icons/helper.gif"); //$NON-NLS-1$

			EObject container = attribute.eContainer();
			if (container != null) {
				container = container.eContainer();
				if (container != null) {
					String doc = getDocumentation(container);
					if (doc != null && doc.length() > 0) {
						feature.setDocumentation(doc);
					}
				}
			}
			return feature;
		}
		return null;
	}

	public UnitType getUnit() {
		return unit;
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
		information.append(" - " + getContextType()); //$NON-NLS-1$
		return information.toString();
	}

	/**
	 * Returns the information related to the operation, or null if not found.
	 * 
	 * @param context
	 *            the context type
	 * @param parameters
	 *            the operation parameter types
	 * @return the information or null if not found
	 */
	public String getDocumentation() {
		StringBuffer doc = new StringBuffer();
		doc.append(getName() + ": " + getType()); //$NON-NLS-1$
		if (documentation != null && !documentation.trim().equals("")) { //$NON-NLS-1$
			doc.append("\n\n" + documentation); //$NON-NLS-1$
		}
		return doc.toString();
		//return getInformation();
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

	/**
	 * Retrieves the comments associated with the given element.
	 * 
	 * @param element
	 *            the given ATL element
	 * @return the comments
	 */
	protected static String getDocumentation(EObject element) {
		Collection<?> comments = (Collection<?>)AtlTypesProcessor.eGet(element, "commentsBefore"); //$NON-NLS-1$
		StringBuffer buf = new StringBuffer();
		for (Object line : comments) {
			if (line.toString().startsWith(DOCUMENTATION_COMMENTS_PREFIX)) {
				buf.append(line.toString().replaceFirst(DOCUMENTATION_COMMENTS_PREFIX, "")); //$NON-NLS-1$
				buf.append('\n');
			}
		}
		return buf.toString().trim();
	}
}
