/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frédéric Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm.lib;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
import org.eclipse.m2m.atl.engine.AtlEMFModelHandler;

public class ReferenceModel extends Model {
	
	private Map metaElementByName = null;
	
	public void dispose() {
		metaElementByName = null;
		super.dispose();
		// TODO: unregister packages
	}

	// TODO: why require the referenceModel to be passed as argument when we know it is the mmm
	public ReferenceModel(ReferenceModel referenceModel, URL url) throws IOException {
		super(referenceModel, url);
		registerPackages();
		adapt();
		addAllReferencedResources(this.resource);
	}

	public ReferenceModel(ReferenceModel referenceModel, URI uri) throws IOException {
		super(referenceModel, uri,false);
		registerPackages();
		adapt();
		addAllReferencedResources(this.resource);
	}

	public ReferenceModel(ReferenceModel referenceModel, Resource resource) {
		super(referenceModel, resource);
		registerPackages();
		addAllReferencedResources(this.resource);
	}

	// TODO:
	//	- current implementation uses the regular VM package registry because it is used by the launch config
	//	future version may use EPackage.Registry.INSTANCE.getEPackage(uri).eResource()
	//	It may even be better to have a common package registry for all VMs
	public ReferenceModel(ReferenceModel referenceModel, String uri) {
		super(referenceModel, AtlEMFModelHandler.getResourceSet().getPackageRegistry().getEPackage(uri).eResource());
		registerPackages();
		addAllReferencedResources(this.resource);
	}
	
	private void registerPackages() {
		for(Iterator i = getElementsByType(EcorePackage.eINSTANCE.getEPackage()).iterator() ; i.hasNext() ; ) {
			EPackage p = (EPackage)i.next();
			String nsURI = p.getNsURI();
			resourceSet.getPackageRegistry().put(nsURI, p);
		}		
	}

	private void adapt() {
		for(Iterator i = getElementsByType(EcorePackage.eINSTANCE.getEPackage()).iterator() ; i.hasNext() ; ) {
			EPackage p = (EPackage)i.next();
			String nsURI = p.getNsURI();
			if(nsURI == null) {
				//System.err.println("DEBUG: EPackage " + p.getName() + " in model " + model.getName() + " has no nsURI.");
				nsURI = p.getName() ;
				p.setNsURI(nsURI);
			}
			if (resourceSet.getPackageRegistry().containsKey(nsURI)) {
				if (!p.equals(resourceSet.getPackageRegistry().getEPackage(nsURI))) {
					//System.err.println("WARNING: overwriting local EMF registry entry for " + nsURI);
				}
			} else {
//				model.unregister.add(nsURI);
			}
			resourceSet.getPackageRegistry().put(nsURI, p);
		}
			//System.err.println("INFO: Registering " + nsURI + " in local EMF registry");
		for(Iterator i = getElementsByType(EcorePackage.eINSTANCE.getEDataType()).iterator() ; i.hasNext() ; ) {
			EDataType dt = (EDataType)i.next();
			String tname = dt.getName();
			String icn = null;
			if(tname.equals("Boolean")) {
				icn = "boolean";	//"java.lang.Boolean";
			} else if(tname.equals("Double")) {
				icn = "java.lang.Double";
			} else if(tname.equals("Float")) {
				icn = "java.lang.Float";
			} else if(tname.equals("Integer")) {
				icn = "java.lang.Integer";
			} else if(tname.equals("String")) {
				icn = "java.lang.String";
			}
			if(icn != null)
				dt.setInstanceClassName(icn);
		}
	}

	private ReferenceModel(Resource resource) {
		super(resource);
	}

	public EClass getMetaElementByName(String name) {
		if(metaElementByName == null) {
			synchronized (this) {
				if(metaElementByName == null) {
					// check again, since another locking thread may have initialised 'metaElementByName'
					metaElementByName = initMetaElementsInAllResources();
				}
			}
		}
		return (EClass) metaElementByName.get(name);
	}
		
	public static ReferenceModel getMetametamodel() {
		if(metametamodel == null) {
			metametamodel = new ReferenceModel(EcorePackage.eINSTANCE.eResource());
		}
		return metametamodel;
	}
	
	private static ReferenceModel metametamodel;
	
	
	private Set referencedResources = new HashSet();
	
    /**
     * Searches for and adds all resources that are
     * referenced from the main resource to referencedResources.
     * @param The main resource
     * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
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
     * Searches for and adds all resources that are
     * referenced from eClass to referencedResources.
     * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
     * @param eClass
     * @param ignore Set of classes to ignore for searching.
     */
    private void addReferencedResourcesFor(EClass eClass, Set ignore) {
		if (ignore.contains(eClass)) {
			return;
		}
		ignore.add(eClass);
		Iterator eRefs = eClass.getEReferences().iterator();
		while (eRefs.hasNext()) {
			EReference eRef = (EReference) eRefs.next();
			if (eRef.isContainment()) {
				EClassifier eType = eRef.getEType();
				if (eType.eResource() != null) {
					referencedResources.add(eType.eResource());
				} else {
					throw new RuntimeException("Resource for " + eType.toString()
							+ " is null; cannot be referenced");
				}
				if (eType instanceof EClass) {
					addReferencedResourcesFor((EClass) eType, ignore);
				}
			}
		}
		Iterator eAtts = eClass.getEAttributes().iterator();
		while (eAtts.hasNext()) {
			EAttribute eAtt = (EAttribute) eAtts.next();
			EClassifier eType = eAtt.getEType();
			if (eType.eResource() != null) {
				referencedResources.add(eType.eResource());
			} else {
				throw new RuntimeException("Resource for " + eType.toString()
						+ " is null; cannot be referenced");
			}
		}
		Iterator eSupers = eClass.getESuperTypes().iterator();
		while (eSupers.hasNext()) {
			EClass eSuper = (EClass) eSupers.next();
			if (eSuper.eResource() != null) {
				referencedResources.add(eSuper.eResource());
				addReferencedResourcesFor(eSuper, ignore);
			} else {
				throw new RuntimeException("Resource for " + eSuper.toString()
						+ " is null; cannot be referenced");
			}
		}
	}
    
    /**
     * Indexes all EClasses in main resource and
     * referenced resources.
     * @return Map of names to EClasses
     * @see #register(Map, String, EObject)
     * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
     */
	private Map initMetaElementsInAllResources() {
    	Map eClassifiers = new HashMap();
    	initMetaElements(eClassifiers, resource.getContents().iterator(), null);
        Iterator refResources = referencedResources.iterator();
        while (refResources.hasNext()) {
            initMetaElements(
            		eClassifiers,
                    ((Resource)refResources.next()).getContents().iterator(), 
                    null);
        }
        return eClassifiers;
	}
	
	private static void initMetaElements(Map eClassifiers, Iterator i, String base) {
		for( ; i.hasNext() ; ) {
			EObject eo = (EObject)i.next();
			if(eo instanceof EPackage) {
				String name = ((EPackage)eo).getName();
				if(base != null) {
					name = base + "::" + name;
				}
				initMetaElements(eClassifiers, ((EPackage)eo).eContents().iterator(), name);
			} else if(eo instanceof EClassifier) {
				String name = ((EClassifier)eo).getName();
				// register the classifier under its simple name
				register(eClassifiers, name, eo);
				if(base != null) {
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
		if(eClassifiers.containsKey(name)) {
			//TODO warning("metamodel contains several classifiers with same name: " + name);
		}
		eClassifiers.put(name, classifier);
	}
	
    /**
     * @param object The model element.
     * @return True if object is contained in this model's resource or a referenced resource.
     * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
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
