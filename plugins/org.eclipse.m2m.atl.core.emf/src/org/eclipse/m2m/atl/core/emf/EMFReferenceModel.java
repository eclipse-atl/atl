/**
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: EMFReferenceModel.java,v 1.4 2008/12/12 15:40:51 wpiers Exp $
 */

package org.eclipse.m2m.atl.core.emf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.core.IReferenceModel;

/**
 * The EMF implementation of {@link IReferenceModel}.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:mikael.barbero@univ-nantes.fr">Mikael Barbero</a>
 */
public class EMFReferenceModel extends EMFModel implements IReferenceModel {

	private static EMFReferenceModel metametamodel;

	/** nsURIs that were explicitly registered and need unregistering. */
	protected Set<String> unregister = new HashSet<String>();

	private Map<String, EObject> metaElementByName;

	/**
	 * Metametamodel constructor.
	 */
	private EMFReferenceModel(EMFModelFactory modelFactory) {
		super(null);
		this.modelFactory = modelFactory;
	}

	/**
	 * Creates a new {@link EMFReferenceModel}.
	 * 
	 * @param referenceModel
	 *            the metamodel
	 */
	public EMFReferenceModel(EMFReferenceModel referenceModel) {
		super(referenceModel);
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
	public boolean isModelOf(Object object) {
		final Resource res = ((EObject)object).eResource();
		if (resources.contains(res)) {
			return true;
		}
		for (Iterator<Resource> i = resources.iterator(); i.hasNext();) {
			if (res.equals(i.next())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the Metametamodel.
	 * 
	 * @param modelFactory
	 *            the model factory used to create models.
	 * @return the Metametamodel
	 */
	public static EMFReferenceModel getMetametamodel(EMFModelFactory modelFactory) {
		if (metametamodel == null) {
			metametamodel = new EMFReferenceModel(modelFactory);
			metametamodel.getResources().add(EcorePackage.eINSTANCE.eResource());
		}
		return metametamodel;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.emf.EMFModel#dispose()
	 */
	@Override
	public void dispose() {
		metaElementByName = null;
		// unregister packages
		for (Iterator<String> unrs = unregister.iterator(); unrs.hasNext();) {
			String nsURI = unrs.next();
			synchronized (modelFactory.getResourceSet()) {
				modelFactory.getResourceSet().getPackageRegistry().remove(nsURI);
			}
		}
		// take resource out of (static) resourceSet
		synchronized (modelFactory.getResourceSet()) {
			modelFactory.getResourceSet().getResources().removeAll(resources);
		}
		resources.clear();
		super.dispose();
	}

	/**
	 * Registers EMF Packages.
	 */
	public void register() {
		registerPackages();
		adapt();
		addAllReferencedResources(resources.get(0));
		metaElementByName = initMetaElementsInAllResources();
	}

	private static void register(Map<String, EObject> eClassifiers, String name, EObject classifier) {
		if (eClassifiers.containsKey(name)) {
			ATLLogger.warning(Messages.getString("EMFReferenceModel.SEVERAL_CLASSIFIERS", name)); //$NON-NLS-1$
		}
		eClassifiers.put(name, classifier);
	}

	private void adapt() {
		for (Iterator<EObject> i = getElementsByType(EcorePackage.eINSTANCE.getEDataType()).iterator(); i
				.hasNext();) {
			EDataType dt = (EDataType)i.next();
			String tname = dt.getName();
			String icn = null;
			if (tname.equals("Boolean")) { //$NON-NLS-1$
				icn = "boolean"; //$NON-NLS-1$
			} else if (tname.equals("Double")) { //$NON-NLS-1$
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
			if (!modelFactory.getResourceSet().getPackageRegistry().containsKey(nsURI)) {
				unregister.add(nsURI);
			}
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
		initMetaElements(eClassifiers, resources.get(0).getContents().iterator(), null);
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
			}
		}
		resources.remove(resource);
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

}
