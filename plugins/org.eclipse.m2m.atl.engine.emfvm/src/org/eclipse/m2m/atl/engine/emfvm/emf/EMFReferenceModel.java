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
 * $Id: EMFReferenceModel.java,v 1.4 2008/09/23 09:37:49 wpiers Exp $
 */

package org.eclipse.m2m.atl.engine.emfvm.emf;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.drivers.emf4atl.AtlEMFModelHandler;
import org.eclipse.m2m.atl.engine.emfvm.EmfvmPlugin;
import org.eclipse.m2m.atl.engine.emfvm.lib.ReferenceModel;

/**
 * The EMF implementation of ReferenceModel.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:mikael.barbero@univ-nantes.fr">Mikael Barbero</a>
 */
public class EMFReferenceModel extends EMFModel implements ReferenceModel {

	protected static Logger logger = Logger.getLogger(EmfvmPlugin.LOGGER);

	private static ReferenceModel metametamodel;

	// nsURIs that were explicitly registered and need unregistering
	protected Set unregister = new HashSet();

	private Map metaElementByName;

	private Set referencedResources = new HashSet();

	private EMFReferenceModel(Resource resource) {
		super(resource);
	}

	/**
	 * Creates a new EMF Reference Model with the given URL. TODO: why require the referenceModel to be passed
	 * as argument when we know it is the mmm
	 * 
	 * @param referenceModel
	 *            the reference model of the new reference model
	 * @param url
	 *            the reference model url
	 * @throws IOException
	 */
	public EMFReferenceModel(ReferenceModel referenceModel, URL url) throws IOException {
		super(referenceModel, url);
		registerPackages();
		adapt();
		addAllReferencedResources(this.getResource());
	}

	/**
	 * Creates a new EMF Reference Model with the given URI.
	 * 
	 * @param referenceModel
	 *            the reference model of the new reference model
	 * @param uri
	 *            the reference model uri
	 * @throws IOException
	 */
	public EMFReferenceModel(ReferenceModel referenceModel, URI uri) throws IOException {
		super(referenceModel, uri, false);
		registerPackages();
		adapt();
		addAllReferencedResources(this.getResource());
	}

	/**
	 * Creates a new EMF Reference Model with the given Resource.
	 * 
	 * @param referenceModel
	 *            the reference model of the new reference model
	 * @param resource
	 *            the reference model resource
	 */
	public EMFReferenceModel(ReferenceModel referenceModel, Resource resource) {
		super(referenceModel, resource);
		registerPackages();
		addAllReferencedResources(this.getResource());
	}

	/**
	 * Creates a new EMF Reference Model with the given URI. TODO: - current implementation uses the regular
	 * VM package registry because it is used by the launch config. Future version may use
	 * EPackage.Registry.INSTANCE.getEPackage(uri).eResource(). It may even be better to have a common package
	 * registry for all VMs
	 * 
	 * @param referenceModel
	 *            the reference model of the new reference model
	 * @param uri
	 *            the reference model uri, as String
	 */
	public EMFReferenceModel(ReferenceModel referenceModel, String uri) {
		super(referenceModel, AtlEMFModelHandler.getResourceSet().getPackageRegistry().getEPackage(uri)
				.eResource());
		registerPackages();
		addAllReferencedResources(this.getResource());
	}

	private void registerPackages() {
		for (Iterator i = getElementsByType(EcorePackage.eINSTANCE.getEPackage()).iterator(); i.hasNext();) {
			EPackage p = (EPackage)i.next();
			String nsURI = p.getNsURI();
			if (nsURI == null) {
				nsURI = p.getName();
				p.setNsURI(nsURI);
			}
			if (!resourceSet.getPackageRegistry().containsKey(nsURI)) {
				unregister.add(nsURI);
			}
			synchronized (resourceSet) {
				resourceSet.getPackageRegistry().put(nsURI, p);
			}
		}
	}

	private void adapt() {
		for (Iterator i = getElementsByType(EcorePackage.eINSTANCE.getEDataType()).iterator(); i.hasNext();) {
			EDataType dt = (EDataType)i.next();
			String tname = dt.getName();
			String icn = null;
			if (tname.equals("Boolean")) {
				icn = "boolean"; // "java.lang.Boolean";
			} else if (tname.equals("Double")) {
				icn = "java.lang.Double";
			} else if (tname.equals("Float")) {
				icn = "java.lang.Float";
			} else if (tname.equals("Integer")) {
				icn = "java.lang.Integer";
			} else if (tname.equals("String")) {
				icn = "java.lang.String";
			}
			if (icn != null) {
				dt.setInstanceClassName(icn);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.ReferenceModel#getMetaElementByName(java.lang.String)
	 */
	public Object getMetaElementByName(String name) {
		if (metaElementByName == null) {
			// synchronized (this) {
			if (metaElementByName == null) {
				// check again, since another locking thread may have initialised 'metaElementByName'
				metaElementByName = initMetaElementsInAllResources();
			}
			// }
		}
		return metaElementByName.get(name);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.emf.EMFModel#dispose()
	 */
	public void dispose() {
		referencedResources.clear();
		metaElementByName = null;
		// unregister packages
		for (Iterator unrs = unregister.iterator(); unrs.hasNext();) {
			String nsURI = (String)unrs.next();
			synchronized (resourceSet) {
				resourceSet.getPackageRegistry().remove(nsURI);
			}
		}
		// take resource out of (static) resourceSet
		synchronized (resourceSet) {
			resourceSet.getResources().remove(resource);
		}
		super.dispose();
	}

	/**
	 * Returns the Metametamodel.
	 * 
	 * @return the Metametamodel
	 */
	public static ReferenceModel getMetametamodel() {
		if (metametamodel == null) {
			metametamodel = new EMFReferenceModel(EcorePackage.eINSTANCE.eResource());
		}
		return metametamodel;
	}

	/**
	 * Indexes all EClasses in main resource and referenced resources.
	 * 
	 * @return Map of names to EClasses
	 * @see #register(Map, String, EObject)
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	private Map initMetaElementsInAllResources() {
		Map eClassifiers = new HashMap();
		initMetaElements(eClassifiers, resource.getContents().iterator(), null);
		Iterator refResources = referencedResources.iterator();
		while (refResources.hasNext()) {
			initMetaElements(eClassifiers, ((Resource)refResources.next()).getContents().iterator(), null);
		}
		return eClassifiers;
	}

	private static void initMetaElements(Map eClassifiers, Iterator i, String base) {
		for ( ; i.hasNext(); ) {
			EObject eo = (EObject)i.next();
			if (eo instanceof EPackage) {
				String name = ((EPackage)eo).getName();
				if (base != null) {
					name = base + "::" + name;
				}
				initMetaElements(eClassifiers, ((EPackage)eo).eContents().iterator(), name);
			} else if (eo instanceof EClassifier) {
				String name = ((EClassifier)eo).getName();
				// register the classifier under its simple name
				register(eClassifiers, name, eo);
				if (base != null) {
					name = base + "::" + name;
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

	private static void register(Map eClassifiers, String name, EObject classifier) {
		if (eClassifiers.containsKey(name)) {
			logger.warning("metamodel contains several classifiers with same name: " + name);
		}
		eClassifiers.put(name, classifier);
	}

	/**
	 * Searches for and adds all resources that are referenced from the main resource to referencedResources.
	 * 
	 * @param resource
	 *            the main resource
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	protected void addAllReferencedResources(Resource resource) {
		Iterator contents = resource.getAllContents();
		while (contents.hasNext()) {
			Object o = contents.next();
			if (o instanceof EClass) {
				addReferencedResourcesFor((EClass)o, new HashSet());
			}
		}
		referencedResources.remove(resource);
	}

	/**
	 * Searches for and adds all resources that are referenced from eClass to referencedResources.
	 * 
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 * @param eClass
	 * @param ignore
	 *            Set of classes to ignore for searching.
	 */
	private void addReferencedResourcesFor(EClass eClass, Set ignore) {
		if (ignore.contains(eClass)) {
			return;
		}
		ignore.add(eClass);
		Iterator eRefs = eClass.getEReferences().iterator();
		while (eRefs.hasNext()) {
			EReference eRef = (EReference)eRefs.next();
			if (eRef.isContainment()) {
				EClassifier eType = eRef.getEType();
				if (eType.eResource() != null) {
					referencedResources.add(eType.eResource());
				} else {
					logger.warning("Resource for " + eType.toString() + " is null; cannot be referenced");
				}
				if (eType instanceof EClass) {
					addReferencedResourcesFor((EClass)eType, ignore);
				}
			}
		}
		Iterator eAtts = eClass.getEAttributes().iterator();
		while (eAtts.hasNext()) {
			EAttribute eAtt = (EAttribute)eAtts.next();
			EClassifier eType = eAtt.getEType();
			if (eType.eResource() != null) {
				referencedResources.add(eType.eResource());
			} else {
				logger.warning("Resource for " + eType.toString() + " is null; cannot be referenced");
			}
		}
		Iterator eSupers = eClass.getESuperTypes().iterator();
		while (eSupers.hasNext()) {
			EClass eSuper = (EClass)eSupers.next();
			if (eSuper.eResource() != null) {
				referencedResources.add(eSuper.eResource());
				addReferencedResourcesFor(eSuper, ignore);
			} else {
				logger.warning("Resource for " + eSuper.toString() + " is null; cannot be referenced");
			}
		}
	}

	/**
	 * Returns The set of referenced Resources.
	 * 
	 * @return The set of referenced Resources
	 */
	public Set getReferencedResources() {
		return referencedResources;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param object
	 *            The model element.
	 * @return True if object is contained in this model's resource or a referenced resource.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.ReferenceModel#isModelOf(java.lang.Object)
	 */
	public boolean isModelOf(Object object) {
		if (object instanceof EObject) {
			final Resource res = ((EObject)object).eResource();
			if (res.equals(resource)) {
				return true;
			}
			for (Iterator i = referencedResources.iterator(); i.hasNext();) {
				if (res.equals(i.next())) {
					return true;
				}
			}
		}
		return false;
	}

}
