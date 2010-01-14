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
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * The ATL ModelElement type. Used to map EMF elements in this context.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ModelElementType extends OclAnyType {

	/**
	 * Creates a new ModelElement with the given OclType, which contains informations about the metamodel
	 * name, package, etc.
	 * 
	 * @param oclType
	 *            the type
	 */
	public ModelElementType(OclType oclType) {
		super(oclType);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.OclAnyType#getTypeOperations()
	 */
	@Override
	public List<Operation> getTypeOperations() {
		List<Operation> elementOperations = new ArrayList<Operation>();
		if (oclType.getClassifier() != null && oclType.getClassifier() instanceof EClass) {
			for (EOperation eOperation : ((EClass)oclType.getClassifier()).getEAllOperations()) {
				elementOperations.add(new Operation(eOperation, oclType.getMetamodelName()));
			}
		}
		return elementOperations;
	}

	/**
	 * Returns <code>true</code> if the element is abstract.
	 * 
	 * @return <code>true</code> if the element is abstract
	 */
	public boolean isAbstract() {
		if (oclType.getClassifier() != null) {
			if (oclType.getClassifier() instanceof EClass) {
				return ((EClass)oclType.getClassifier()).isAbstract();
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.OclAnyType#getFeatures()
	 */
	@Override
	public List<Feature> getFeatures() {
		List<Feature> features = new ArrayList<Feature>();
		if (oclType.getClassifier() != null && oclType.getClassifier() instanceof EClass) {
			for (EStructuralFeature eFeature : ((EClass)oclType.getClassifier()).getEAllStructuralFeatures()) {
				features.add(new Feature(eFeature, oclType.getMetamodelName()));
			}
		}
		Collections.sort(features);
		return features;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.OclAnyType#getSupertypes()
	 */
	@Override
	public OclAnyType[] getSupertypes() {
		Collection<OclAnyType> res = new ArrayList<OclAnyType>();
		res.add(OclAnyType.getInstance());
		if (oclType.getClassifier() instanceof EClass) {
			List<EClass> supertypes = ((EClass)oclType.getClassifier()).getESuperTypes();
			for (EClass supertype : supertypes) {
				OclAnyType atlSupertype = create(supertype, oclType.getMetamodelName());
				if (atlSupertype != null) {
					res.add(atlSupertype);
				}
			}
		}
		return res.toArray(new OclAnyType[res.size()]);
	}

	/**
	 * Utility method used to create a new ModelElementType from the given classifier.
	 * 
	 * @param classifier
	 *            the classifier
	 * @param metamodelName
	 *            the metamodel name
	 * @return the wrapped {@link ModelElementType}
	 */
	public static OclAnyType create(EClassifier classifier, String metamodelName) {
		if (classifier != null) {
			if (classifier instanceof EEnum) {
				return new ModelElementType(new OclType(metamodelName, classifier));
			} else if (classifier instanceof EDataType) {
				return create((EDataType)classifier);
			} else {
				return new ModelElementType(new OclType(metamodelName, classifier));
			}
		}
		return OclAnyType.getInstance();
	}

	private static OclAnyType create(EDataType dataType) {
		if (dataType.getInstanceClass() != null) {
			if (dataType.getInstanceClass().equals(String.class)) {
				return StringType.getInstance();
			} else if (dataType.getInstanceClass().equals(int.class)
					|| dataType.getInstanceClass().equals(Integer.class)) {
				return IntegerType.getInstance();
			} else if (dataType.getInstanceClass().equals(boolean.class)
					|| dataType.getInstanceClass().equals(Boolean.class)) {
				return BooleanType.getInstance();
			} else if (dataType.getInstanceClass().equals(double.class)
					|| dataType.getInstanceClass().equals(Double.class)
					|| dataType.getInstanceClass().equals(Float.class)) {
				return RealType.getInstance();
			}
		} else {
			// ATL auto mapping
			if (dataType.getName().equals("String")) { //$NON-NLS-1$
				return StringType.getInstance();
			} else if (dataType.getName().equals("Boolean")) { //$NON-NLS-1$
				return BooleanType.getInstance();
			} else if (dataType.getName().equals("Integer")) { //$NON-NLS-1$
				return IntegerType.getInstance();
			} else if (dataType.getName().equals("Float") || dataType.getName().equals("Real") //$NON-NLS-1$ //$NON-NLS-2$
					|| dataType.getName().equals("Double")) { //$NON-NLS-1$
				return RealType.getInstance();
			}
		}
		return OclAnyType.getInstance();
	}

	/**
	 * Returns a description of the model element.
	 * 
	 * @return a description of the model element
	 */
	public String getInformation() {
		StringBuffer information = new StringBuffer();
		if (isAbstract()) {
			information.append("abstract "); //$NON-NLS-1$
		}
		information.append("class "); //$NON-NLS-1$
		information.append(getOclType().getClassifier().getName());
		boolean first = true;
		for (int i = 0; i < getSupertypes().length; i++) {
			OclAnyType st = getSupertypes()[i];
			if (!OclAnyType.getInstance().equals(st)) {
				if (first) {
					information.append(" extends\n\t"); //$NON-NLS-1$
					first = false;
				} else {
					information.append(",\n\t"); //$NON-NLS-1$
				}
				information.append(st);
			}
		}
		return information.toString();
	}
}
