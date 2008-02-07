/*******************************************************************************
 * Copyright (c) 2004 INRIA and Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *    Freddy Allilaire (INRIA)
 *    Dennis Wagelaar (Vrije Universiteit Brussel)
 *******************************************************************************/
package org.eclipse.m2m.atl.drivers.emf4atl;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.eclipse.m2m.atl.engine.vm.ATLVMPlugin;
import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMString;

/**
 * @author Frédéric Jouault
 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
 */
public class ASMEMFModel extends ASMModel {

	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);

	// true if extent was explicitly loaded and requires explicit unloading
	protected boolean unload = false;
	// nsURIs that were explicitly registered and need unregistering
	protected Set unregister = new HashSet();
	// if not null, model could not yet be loaded from URI and needs to be loaded later from this URI
	protected String resolveURI = null;
	
	protected boolean checkSameModel = true;
	
	public static ASMModel getMOF() {
		return mofmm;
	}
	
	protected Map modelElements = new HashMap();

	public ASMModelElement getASMModelElement(EObject object) {
		ASMModelElement ret = (ASMModelElement)modelElements.get(object);
		if (ret == null) {
			synchronized (modelElements) {
				// check again, since another locking thread may have created a new element
				ret = (ASMModelElement)modelElements.get(object);
				if (ret == null) {
					ret = new ASMEMFModelElement(modelElements, this, object);
				}
			}
		}
		return ret;
	}
	
	private Map classifiers = null;
	
	private ASMModelElement getClassifier(String name) {
		if(classifiers == null) {
			synchronized (this) {
				if(classifiers == null) {
					// check again, since another locking thread may have initialised 'classifiers'
					classifiers = initClassifiersInAllExtents();
				}
			}
		}
		EObject eo = (EObject)classifiers.get(name);

		ASMModelElement ret = null;
		if(eo != null) {
			ret = getASMModelElement(eo);
		}
		return ret;
	}
	
    /**
     * Indexes all classifiers in main extent and
     * referenced extents.
     * @return The classifier map to build.
     * @see #register(Map, String, EObject)
     * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
     */
    private Map initClassifiersInAllExtents() {
    	Map classifiers = new HashMap();
    	initClassifiers(getExtent().getContents().iterator(), classifiers, null);
        Iterator refExtents = referencedExtents.iterator();
        while (refExtents.hasNext()) {
            initClassifiers(
                    ((Resource)refExtents.next()).getContents().iterator(), 
                    classifiers, 
                    null);
        }
        return classifiers;
    }
	
	private void initClassifiers(Iterator i, Map classifiers, String base) {
		for( ; i.hasNext() ; ) {
			EObject eo = (EObject)i.next();
			if(eo instanceof EPackage) {
				String name = ((EPackage)eo).getName();
				if(base != null) {
					name = base + "::" + name;
				}
				initClassifiers(((EPackage)eo).eContents().iterator(), classifiers, name);
			} else if(eo instanceof EClassifier) {
				String name = ((EClassifier)eo).getName();
				// register the classifier under its simple name
				register(classifiers, name, eo);
				if(base != null) {
					name = base + "::" + name;
					// register the classifier under its full name
					register(classifiers, name, eo);
				}
			} else {
                // No meta-package or meta-class => just keep digging.
                // N.B. This situation occurs in UML2 profiles, where
                // EPackages containing EClasses are buried somewhere
                // underneath other elements.
                initClassifiers(eo.eContents().iterator(), classifiers, base);
            }
		}
	}
	
	private void register(Map classifiers, String name, EObject classifier) {
		if(classifiers.containsKey(name)) {
			logger.warning("metamodel contains several classifiers with same name: " + name);
//			System.out.println("Warning: metamodel contains several classifiers with same name: " + name);
		}
		classifiers.put(name, classifier);
	}

	public ASMModelElement findModelElement(String name) {
		ASMModelElement ret = null;
		
		ret = getClassifier(name);
			
		return ret;
	}

    /**
     * @param type The type of element to search for.
     * @return The set of ASMModelElements that are instances of type.
     * @see ASMModelElement
     */
	public Set getElementsByType(ASMModelElement type) {
		Set ret = new LinkedHashSet();
		EClass t = (EClass)((ASMEMFModelElement)type).getObject();
		addElementsOfType(ret, t, getExtent());
		return ret;
	}
    
    /**
     * Adds all elements of the given type to the set.
     * @param elements The set to add to.
     * @param type The type to test for.
     * @param res The resource containing the elements.
     */
    private void addElementsOfType(Set elements, EClassifier type, Resource res) {
        for(Iterator i = res.getAllContents() ; i.hasNext() ; ) {
            EObject eo = (EObject)i.next();
            if(type.isInstance(eo)) {
                elements.add(getASMModelElement(eo));
            }
        }
    }

	public ASMModelElement newModelElement(ASMModelElement type) {
		ASMModelElement ret = null;
		
		EClass t = (EClass)((ASMEMFModelElement)type).getObject();
		EObject eo = t.getEPackage().getEFactoryInstance().create(t);
		ret = (ASMEMFModelElement)getASMModelElement(eo);
		getExtent().getContents().add(eo);
		
		return ret;
	}
	/**
	 * @param name
	 * @param metamodel
	 * @param isTarget
	 */
	protected ASMEMFModel(String name, Resource extent, ASMEMFModel metamodel, boolean isTarget, ModelLoader ml) {
		super(name, metamodel, isTarget, ml);
		this.extent = extent;
	}

	/**
	 * Simple Resource wrapping factory. 
	 * @param ml ModelLoader used to load the model if available, null otherwise.
	 */
	public static ASMEMFModel loadASMEMFModel(String name, ASMEMFModel metamodel, Resource extent, ModelLoader ml) throws Exception {
		ASMEMFModel ret = null;
		
		ret = new ASMEMFModel(name, extent, metamodel, false, ml);
        ret.addAllReferencedExtents(extent);
		ret.setIsTarget(false);
		adaptMetamodel(ret, metamodel);
		
		return ret;
	}
			
	public void dispose() {
		//System.err.println("INFO: Disposing ASMEMFModel " + getName());
		
        if (extent != null) {
            referencedExtents.clear();
            referencedExtents = null;
            for (Iterator unrs = unregister.iterator(); unrs.hasNext();) {
            	String nsURI = (String)unrs.next();
            	synchronized (resourceSet) {
                	resourceSet.getPackageRegistry().remove(nsURI);
            	}
            	//System.err.println("\tINFO: Unregistering " + nsURI + " from local EMF registry");
            	
            }
            synchronized (resourceSet) {
                resourceSet.getResources().remove(extent);
            }
            // Unload only is necessary if we would like to re-use the resource later 
            // (we do not need this behavior) 
            /*
            if (unload) {
            	extent.unload();
            }
            */
            extent = null;

            modelElements.clear();
            unregister.clear();
        }
	}
    
    public void finalize() {
        dispose();
    }
	
    /**
     * Creates a new ASMEMFModel. Do not use this method for models that
     * require a special registered factory (e.g. uml2).
     * @param name The model name. Also used as EMF model URI.
     * @param metamodel
     * @param ml
     * @return
     * @throws Exception
     * @deprecated
     */
	public static ASMEMFModel newASMEMFModel(String name, ASMEMFModel metamodel, ModelLoader ml) throws Exception {
        return newASMEMFModel(name, name, metamodel, ml);
	}
	
    /**
     * Creates a new ASMEMFModel.
     * @param name The model name. Not used by EMF.
     * @param uri The model URI. EMF uses this to determine the correct factory.
     * @param metamodel
     * @param ml
     * @return
     * @throws Exception
     * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
     */
    public static ASMEMFModel newASMEMFModel(String name, String uri, ASMEMFModel metamodel, ModelLoader ml) throws Exception {
        ASMEMFModel ret = null;
        Resource extent = null;
        
        synchronized (resourceSet) {
            extent = resourceSet.createResource(URI.createURI(uri));
        }

        ret = new ASMEMFModel(name, extent, metamodel, true, ml);
        ret.unload = true;

        return ret;
    }
    
	public static ASMEMFModel loadASMEMFModel(String name, ASMEMFModel metamodel, String url, ModelLoader ml) throws Exception {
		ASMEMFModel ret = null;
		
		if(url.startsWith("uri:")) {
			//only initialise on demand (after loading instance of this metamodel)
			String uri = url.substring(4);
			ret = new ASMEMFModel(name, null, metamodel, false, ml);
			ret.resolveURI = uri;
		} else {
			ret = loadASMEMFModel(name, metamodel, URI.createURI(url), ml);
		}
		
		return ret;
	}
	
	public static ASMEMFModel loadASMEMFModel(String name, ASMEMFModel metamodel, URL url, ModelLoader ml) throws Exception {
		ASMEMFModel ret = null;

		ret = loadASMEMFModel(name, metamodel, url.openStream(), ml);
		
		return ret;
	}
	
	public static ASMEMFModel loadASMEMFModel(String name, ASMEMFModel metamodel, URI uri, ModelLoader ml) throws Exception {
		ASMEMFModel ret = null;

		try {
			Resource extent = null;
			synchronized (resourceSet) {
	            extent = resourceSet.getResource(uri, true);
			}
			ret = new ASMEMFModel(name, extent, metamodel, true, ml);
            ret.addAllReferencedExtents(extent);
			ret.setIsTarget(false);
			ret.unload = true;
		} catch(Exception e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
		}
		adaptMetamodel(ret, metamodel);

		return ret;
	}
	
	public static ASMEMFModel loadASMEMFModel(String name, ASMEMFModel metamodel, InputStream in, ModelLoader ml) throws Exception {
		ASMEMFModel ret = newASMEMFModel(name, metamodel, ml);

		try {
			synchronized (resourceSet) {
				ret.getExtent().load(in, resourceSet.getLoadOptions());
			}
            ret.addAllReferencedExtents(ret.getExtent());
            ret.unload = true;
		} catch(Exception e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
		}
		
		adaptMetamodel(ret, metamodel);
		ret.setIsTarget(false);

		return ret;
	}
    
	protected static void adaptMetamodel(ASMEMFModel model, ASMEMFModel metamodel) {
		if(metamodel == mofmm) {
			for(Iterator i = model.getElementsByType("EPackage").iterator() ; i.hasNext() ; ) {
				ASMEMFModelElement ame = (ASMEMFModelElement)i.next();
				EPackage p = (EPackage)ame.getObject();
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
					model.unregister.add(nsURI);
				}
				synchronized (resourceSet) {
					resourceSet.getPackageRegistry().put(nsURI, p);
				}
				//System.err.println("INFO: Registering " + nsURI + " in local EMF registry");
			}
			for(Iterator i = model.getElementsByType("EDataType").iterator() ; i.hasNext() ; ) {
				ASMEMFModelElement ame = (ASMEMFModelElement)i.next();
				String tname = ((ASMString)ame.get(null, "name")).getSymbol();
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
					ame.set(null, "instanceClassName", new ASMString(icn));
			}
		}
	}
	
	public static ASMEMFModel createMOF(ModelLoader ml) {
		
		if(mofmm == null) {
			mofmm = new ASMEMFModel("MOF", EcorePackage.eINSTANCE.eResource(), null, false, ml);
		}
		
		return mofmm;
	}
	
	/**
	 * @return The EMF resource containing the model
	 */
	public Resource getExtent() {
		if ((extent == null) && (resolveURI != null)) {
			synchronized (resourceSet) {
				if (extent == null) {
					// check again, since another locking thread may have loaded the extent
					EPackage pack = resourceSet.getPackageRegistry().getEPackage(resolveURI);
					Resource r = pack.eResource();
					addAllReferencedExtents(r);
					extent = r;
				}
			}
		}
		return extent; 
	}
	
	static {
		init();
	}
	
	private static void init() {
		Map etfm = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		if(!etfm.containsKey("*")) {
			etfm.put("*", new XMIResourceFactoryImpl());
		}
		resourceSet = new ResourceSetImpl();
		// see http://www.eclipse.org/modeling/emf/docs/performance/EMFPerformanceTips.html
		Map loadOptions = resourceSet.getLoadOptions();
		loadOptions.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
		loadOptions.put(XMLResource.OPTION_USE_PARSER_POOL, new XMLParserPoolImpl());
	}
	
	public static ResourceSet getResourceSet() {
		return resourceSet;
	}
	
	public boolean equals(Object o) {
		return (o instanceof ASMEMFModel) && (((ASMEMFModel)o).extent == extent);
	}
	
	protected static ResourceSet resourceSet;

	protected static ASMEMFModel mofmm = null;
	private Resource extent;
    private Set referencedExtents = new HashSet();
	
	public boolean isCheckSameModel() {
		return checkSameModel;
	}

	public void setCheckSameModel(boolean checkSameModel) {
		this.checkSameModel = checkSameModel;
	}
    
    /**
     * Searches for and adds all Resource extents that are
     * referenced from the main extent to referencedExtents.
     * @param The main extent
     * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
     */
    protected void addAllReferencedExtents(Resource extent) {
        Iterator contents = extent.getAllContents();
        while (contents.hasNext()) {
            Object o = contents.next();
            if (o instanceof EClass) {
                addReferencedExtentsFor((EClass)o, new HashSet());
            }
        }
        referencedExtents.remove(extent);
    }
    
    /**
     * Searches for and adds all Resource extents that are
     * referenced from eClass to referencedExtents.
     * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
     * @param eClass
     * @param ignore Set of classes to ignore for searching.
     */
    private void addReferencedExtentsFor(EClass eClass, Set ignore) {
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
					referencedExtents.add(eType.eResource());
				} else {
					logger.warning("Resource for " + eType.toString()
							+ " is null; cannot be referenced");
//					System.err.println("WARNING: Resource for "
//							+ eType.toString()
//							+ " is null; cannot be referenced");
				}
				if (eType instanceof EClass) {
					addReferencedExtentsFor((EClass) eType, ignore);
				}
			}
		}
		Iterator eAtts = eClass.getEAttributes().iterator();
		while (eAtts.hasNext()) {
			EAttribute eAtt = (EAttribute) eAtts.next();
			EClassifier eType = eAtt.getEType();
			if (eType.eResource() != null) {
				referencedExtents.add(eType.eResource());
			} else {
				logger.warning("Resource for " + eType.toString()
						+ " is null; cannot be referenced");
//				System.err.println("WARNING: Resource for " + eType.toString()
//						+ " is null; cannot be referenced");
			}
		}
		Iterator eSupers = eClass.getESuperTypes().iterator();
		while (eSupers.hasNext()) {
			EClass eSuper = (EClass) eSupers.next();
			if (eSuper.eResource() != null) {
				referencedExtents.add(eSuper.eResource());
				addReferencedExtentsFor(eSuper, ignore);
			} else {
				logger.warning("Resource for " + eSuper.toString()
						+ " is null; cannot be referenced");
//				System.err.println("WARNING: Resource for " + eSuper.toString()
//						+ " is null; cannot be referenced");
			}
		}
	}
    
    /**
	 * @return The set of referenced Resources.
	 */
    public Set getReferencedExtents() {
        return referencedExtents;
    }
}
