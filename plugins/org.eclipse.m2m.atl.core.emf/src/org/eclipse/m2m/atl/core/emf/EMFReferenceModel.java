/**
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *     Dennis Wagelaar (Vrije Universiteit Brussel)
 */

package org.eclipse.m2m.atl.core.emf;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.core.IReferenceModel;

/**
 * The EMF implementation of {@link IReferenceModel}.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class EMFReferenceModel extends EMFModel implements IReferenceModel {


	private Map<String, EObject> metaElementByName = Collections.emptyMap();
	
	private Set<Resource> referencedResources = new HashSet<Resource>();

	private Map<EClass, Set<EObject>> allElementsByType = new HashMap<EClass, Set<EObject>>();

	/**
	 * Creates a new {@link EMFReferenceModel}.
	 * 
	 * @param referenceModel
	 *            the metamodel.
	 * @param mf
	 *            the model factory that is creating this model.
	 */
	public EMFReferenceModel(EMFReferenceModel referenceModel, EMFModelFactory mf) {
		super(referenceModel, mf);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IReferenceModel#getMetaElementByName(java.lang.String)
	 */
	public Object getMetaElementByName(String name) {
		return metaElementByName.get(name);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IReferenceModel#isModelOf(java.lang.Object)
	 */
	@Override
	public boolean isModelOf(Object object) {
		final Resource res = ((EObject)object).eResource();
		if (getResource().equals(res)) {
			return true;
		}
		return getReferencedResources().contains(res);
	}

	/**
	 * Returns a {@link Set} of the elements matching the given type,
	 * including elements in {@link #getReferencedResources()}.
	 * 
	 * @param metaElement
	 *            a metatype
	 * @return a {@link Set} of the elements matching the given type
	 * 
	 * @see org.eclipse.m2m.atl.core.IModel#getElementsByType(java.lang.Object)
	 */
	public Set<EObject> getAllElementsByType(EClass metaElement) {
		Set<EObject> ret = allElementsByType.get(metaElement);
		if (ret == null) {
			ret = getElementsByType(metaElement);
			for (Resource res : getReferencedResources()) {
				for (Iterator<EObject> iterator = res.getAllContents(); iterator.hasNext();) {
					EObject element = iterator.next();
					if (metaElement.isInstance(element)) {
						ret.add(element);
					}
				}
			}
			allElementsByType.put(metaElement, ret);
		}
		return ret;
	}

	/**
	 * Registers EMF Packages.
	 */
	public void register() {
		registerPackages();
		adapt();
		addAllReferencedResources(getResource());
		metaElementByName = initMetaElementsInAllResources();
	}

	private static void register(Map<String, EObject> eClassifiers, String name, EObject classifier) {
		if (eClassifiers.containsKey(name)) {
			ATLLogger.warning(Messages.getString("EMFReferenceModel.SEVERAL_CLASSIFIERS", name)); //$NON-NLS-1$
		}
		eClassifiers.put(name, classifier);
	}

	private void adapt() {
		for (Iterator<EObject> i = getAllElementsByType(EcorePackage.eINSTANCE.getEDataType()).iterator(); i
				.hasNext();) {
			EDataType dt = (EDataType)i.next();
			String tname = dt.getName();
			String icn = null;
			if (tname.equals("Boolean")) { //$NON-NLS-1$
				icn = "boolean"; //$NON-NLS-1$
			} else if (tname.equals("Double") || tname.equals("Real")) { //$NON-NLS-1$ //$NON-NLS-2$
				icn = "java.lang.Double"; //$NON-NLS-1$
			} else if (tname.equals("Float")) { //$NON-NLS-1$
				icn = "java.lang.Float"; //$NON-NLS-1$
			} else if (tname.equals("Integer")) { //$NON-NLS-1$
				icn = "java.lang.Integer"; //$NON-NLS-1$
			} else if (tname.equals("String")) { //$NON-NLS-1$
				icn = "java.lang.String"; //$NON-NLS-1$
			}
			if (icn != null) {
				dt.setInstanceClassName(icn);
			}
		}
	}

	private void registerPackages() {
		for (Iterator<EObject> i = getElementsByType(EcorePackage.eINSTANCE.getEPackage()).iterator(); i
				.hasNext();) {
			EPackage p = (EPackage)i.next();
			String nsURI = p.getNsURI();
			if (nsURI == null) {
				nsURI = p.getName();
				p.setNsURI(nsURI);
			}
			final EMFModelFactory modelFactory = getModelFactory();
			synchronized (modelFactory.getResourceSet()) {
				modelFactory.getResourceSet().getPackageRegistry().put(nsURI, p);
			}
		}
	}

	/**
	 * Indexes all EClasses in main resource and referenced resources.
	 * 
	 * @return Map of names to EClasses
	 * @see #register(Map, String, EObject)
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	private Map<String, EObject> initMetaElementsInAllResources() {
		Map<String, EObject> eClassifiers = new HashMap<String, EObject>();
		for (Resource res : getReferencedResources()) {
			initMetaElements(eClassifiers, res.getContents().iterator(), null);
		}
		initMetaElements(eClassifiers, getResource().getContents().iterator(), null);
		return eClassifiers;
	}

	private static void initMetaElements(Map<String, EObject> eClassifiers, Iterator<EObject> i, String base) {
		while (i.hasNext()) {
			EObject eo = i.next();
			if (eo instanceof EPackage) {
				String name = ((EPackage)eo).getName();
				if (base != null) {
					name = base + "::" + name; //$NON-NLS-1$
				}
				initMetaElements(eClassifiers, ((EPackage)eo).eContents().iterator(), name);
			} else if (eo instanceof EClassifier) {
				String name = ((EClassifier)eo).getName();
				// register the classifier under its simple name
				register(eClassifiers, name, eo);
				if (base != null) {
					name = base + "::" + name; //$NON-NLS-1$
					// register the classifier under its full name
					register(eClassifiers, name, eo);
				}
			} else {
				// No meta-package or meta-class => just keep digging.
				// N.B. This situation occurs in UML2 profiles, where
				// EPackages containing EClasses are buried somewhere
				// underneath other elements.
				initMetaElements(eClassifiers, eo.eContents().iterator(), base);
			}
		}
	}

	/**
	 * Searches for and adds all resources that are referenced from the main resource to referencedResources.
	 * 
	 * @param resource
	 *            the main resource
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected void addAllReferencedResources(Resource resource) {
		Iterator<EObject> contents = resource.getAllContents();
		while (contents.hasNext()) {
			Object o = contents.next();
			if (o instanceof EClass) {
				addReferencedResourcesFor((EClass)o, new HashSet<EClass>());
			} else if (o instanceof EGenericType && ((EGenericType)o).getEClassifier() instanceof EClass) {
				addReferencedResourcesFor((EClass)((EGenericType)o).getEClassifier(), new HashSet<EClass>());
			}
		}
		getReferencedResources().remove(resource);
	}

	/**
	 * Searches for and adds all resources that are referenced from eClass to referencedResources.
	 * 
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 * @param eClass
	 * @param ignore
	 *            Set of classes to ignore for searching.
	 */
	private void addReferencedResourcesFor(EClass eClass, Set<EClass> ignore) {
		if (ignore.contains(eClass)) {
			return;
		}
		ignore.add(eClass);
		final Set<Resource> resources = getReferencedResources();
		for (EReference eRef : eClass.getEReferences()) {
			if (eRef.isContainment()) {
				EClassifier eType = eRef.getEType();
				if (eType.eResource() != null) {
					resources.add(eType.eResource());
				} else {
					ATLLogger
							.warning(Messages.getString("EMFReferenceModel.NULL_RESOURCE", eType.toString())); //$NON-NLS-1$
				}
				if (eType instanceof EClass) {
					addReferencedResourcesFor((EClass)eType, ignore);
				}
			}
		}
		for (EAttribute eAtt : eClass.getEAttributes()) {
			EClassifier eType = eAtt.getEType();
			if (eType.eResource() != null) {
				resources.add(eType.eResource());
			} else {
				ATLLogger.warning(Messages.getString("EMFReferenceModel.NULL_RESOURCE", eType.toString())); //$NON-NLS-1$
			}
		}
		for (EClass eSuper : eClass.getESuperTypes()) {
			if (eSuper.eResource() != null) {
				resources.add(eSuper.eResource());
				addReferencedResourcesFor(eSuper, ignore);
			} else {
				ATLLogger.warning(Messages.getString("EMFReferenceModel.NULL_RESOURCE", eSuper.toString())); //$NON-NLS-1$
			}
		}
	}

	/**
	 * Returns the referencedResources.
	 *
	 * @return the referencedResources
	 */
	public Set<Resource> getReferencedResources() {
		return referencedResources;
	}

}
