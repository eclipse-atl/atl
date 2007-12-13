/*******************************************************************************
 * Copyright (c) 2004 INRIA and C-S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *    Christophe Le Camus (C-S) - initial API and implementation
 *    Sebastien Gabel (C-S) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.drivers.uml24atl;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMString;

/**
 * @author Frédéric Jouault (INRIA)
 * @author Freddy Allilaire (INRIA)
 * @author Christophe Le Camus (C-S)
 * @author Sebastien Gabel (C-S) 
 */
public class ASMUMLModel extends ASMModel {

    // true if extent was explicitly loaded and requires explicit unloading
	protected boolean unload = false;
	// nsURIs that were explicitly registered and need unregistering
	protected Set unregister = new HashSet();
	// if not null, model could not yet be loaded from URI and needs to be loaded later from this URI
	protected String resolveURI = null;
	
	private boolean checkSameModel = true;
	
	public static ASMModel getMOF() {
		return mofmm;
	}
	
	private Map modelElements = new HashMap(); 

	//ok
	public ASMModelElement getASMModelElement(EObject object) {
		ASMModelElement ret = null;
		
		synchronized(modelElements) {
			ret = (ASMModelElement)modelElements.get(object);
			if(ret == null) {
				ret = new ASMUMLModelElement(modelElements, this, object);
			}
		}
		
		return ret;
	}
	
	private Map classifiers = null;
	
	private ASMModelElement getClassifier(String name) {
		if(classifiers == null) {
			classifiers = new HashMap();
			initClassifiersInAllExtents(classifiers);
		}
		ASMModelElement ret = null;
		
		EObject eo = (EObject)classifiers.get(name);
		if(eo != null) {
			ret = getASMModelElement(eo);
		}
		
		return ret;
	}

    /**
     * Indexes all classifiers in main extent and
     * referenced extents.
     * @param classifiers The classifier map to build.
     * @see #register(Map, String, EObject)
     * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
     */
    private void initClassifiersInAllExtents(Map classifiers) {
        initClassifiers(getExtent().getContents().iterator(), classifiers, null);
        Iterator refExtents = referencedExtents.iterator();
        while (refExtents.hasNext()) {
            initClassifiers(
                    ((Resource)refExtents.next()).getContents().iterator(), 
                    classifiers, 
                    null);
        }
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
			System.out.println("Warning: metamodel contains several classifiers with same name: " + name);
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
	//ok
	public Set getElementsByType(ASMModelElement type) {
		Set ret = new HashSet();
		EClass t = (EClass)((ASMUMLModelElement)type).getObject();
        addElementsOfType(ret, t, getExtent());
		for (Iterator i = referencedExtents.iterator(); i.hasNext() ; ) {
			Resource res = (Resource) i.next();
            addElementsOfType(ret, t, res);
		}
		
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
		
		EClass t = (EClass)((ASMUMLModelElement)type).getObject();
		EObject eo = t.getEPackage().getEFactoryInstance().create(t);
		ret = (ASMUMLModelElement)getASMModelElement(eo);
		getExtent().getContents().add(eo);
		
		return ret;
	}
	/**
	 * @param name
	 * @param metamodel
	 * @param isTarget
	 */
	private ASMUMLModel(String name, Resource extent, ASMUMLModel metamodel, boolean isTarget, ModelLoader ml) {
		super(name, metamodel, isTarget, ml);
		this.extent = extent;// MOF UML2 PRO IN OUT
	}

	/**
	 * Simple Resource wrapping factory. 
	 * @param ml ModelLoader used to load the model if available, null otherwise.
	 */
	public static ASMUMLModel loadASMUMLModel(String name, ASMUMLModel metamodel, Resource extent, ModelLoader ml) throws Exception {
		ASMUMLModel ret = null;
		
		ret = new ASMUMLModel(name, extent, metamodel, false, ml);
		
		return ret;
	}
	
	public void dispose() {
		if (extent != null) {
            referencedExtents.clear();
            referencedExtents = null;
            for (Iterator unrs = unregister.iterator(); unrs.hasNext();) {
            	String nsURI = (String)unrs.next();
            	resourceSet.getPackageRegistry().remove(nsURI);
            	
            }
            resourceSet.getResources().remove(extent);
            if (unload) {
            	extent.unload();
            }
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
     */
	public static ASMUMLModel newASMUMLModel(String name, ASMUMLModel metamodel, ModelLoader ml) throws Exception {
        return newASMUMLModel(name, name, metamodel, ml); //OUT
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
    public static ASMUMLModel newASMUMLModel(String name, String uri, ASMUMLModel metamodel, ModelLoader ml) throws Exception {
        ASMUMLModel ret = null;
        
        Resource extent = resourceSet.createResource(URI.createURI(uri));

        ret = new ASMUMLModel(name, extent, metamodel, true, ml);
        ret.unload = true;

        return ret;
    }
    
	public static ASMUMLModel loadASMUMLModel(String name, ASMUMLModel metamodel, String url, ModelLoader ml) throws Exception {
		ASMUMLModel ret = null;

		if(url.startsWith("uri:")) {
			String uri = url.substring(4);
			EPackage pack = resourceSet.getPackageRegistry().getEPackage(uri);
			if (pack == null) {
				ret = new ASMUMLModel(name, null, metamodel, false, ml);
				ret.resolveURI = uri;
			} else {
				Resource extent = pack.eResource();
				ret = new ASMUMLModel(name, extent, metamodel, false, ml);
				ret.addAllReferencedExtents();
			}
		} else {
			ret = loadASMUMLModel(name, metamodel, URI.createURI(url), ml);
		}
		
		return ret;
	}
	
	public static ASMUMLModel loadASMUMLModel(String name, ASMUMLModel metamodel, URL url, ModelLoader ml) throws Exception {
		ASMUMLModel ret = null;

		ret = loadASMUMLModel(name, metamodel, url.openStream(), ml);
		
		return ret;
	}
	
	public static ASMUMLModel loadASMUMLModel(String name, ASMUMLModel metamodel, URI uri, ModelLoader ml) throws Exception {
		ASMUMLModel ret = null;
		// PRO IN
		try {
			Resource extent = resourceSet.createResource(uri);
			extent.load(Collections.EMPTY_MAP);
			ret = new ASMUMLModel(name, extent, metamodel, true, ml);
            ret.addAllReferencedExtents();
			ret.setIsTarget(false);
			ret.unload = true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		adaptMetamodel(ret, metamodel);

		return ret;
	}
	
	public static ASMUMLModel loadASMUMLModel(String name, ASMUMLModel metamodel, InputStream in, ModelLoader ml) throws Exception {
		ASMUMLModel ret = newASMUMLModel(name, metamodel, ml);

		try {
			ret.getExtent().load(in, Collections.EMPTY_MAP);
            ret.addAllReferencedExtents();
            ret.unload = true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		adaptMetamodel(ret, metamodel);
		ret.setIsTarget(false);

		return ret;
	}
    
	private static void adaptMetamodel(ASMUMLModel model, ASMUMLModel metamodel) {
		if(metamodel == mofmm) {
			for(Iterator i = model.getElementsByType("EPackage").iterator() ; i.hasNext() ; ) {
				ASMUMLModelElement ame = (ASMUMLModelElement)i.next();
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
				resourceSet.getPackageRegistry().put(nsURI, p);
				//System.err.println("INFO: Registering " + nsURI + " in local EMF registry");
			}
			for(Iterator i = model.getElementsByType("EDataType").iterator() ; i.hasNext() ; ) {
				ASMUMLModelElement ame = (ASMUMLModelElement)i.next();
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

/*		
		reader.read(url.openStream(), url.toString(), ret.pack);
		ret.getAllAcquaintances();
*/	
	}
	
	public static ASMUMLModel createMOF(ModelLoader ml) {
		
		if(mofmm == null) {
//			Resource extent = resourceSet.createResource(URI.createURI("http://www.eclipse.org/emf/2002/Ecore"));
//			System.out.println("Actual resource class: " + extent.getClass());
//			extent.getContents().add(EcorePackage.eINSTANCE);
			mofmm = new ASMUMLModel("MOF", EcorePackage.eINSTANCE.eResource(), null, false, ml);
		}
		
		return mofmm;
	}
	
	public Resource getExtent() {
		if ((extent == null) && (resolveURI != null)) {
			EPackage pack = resourceSet.getPackageRegistry().getEPackage(resolveURI);
			extent = pack.eResource();
			addAllReferencedExtents();
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
		
	}
	
	public boolean equals(Object o) {
		return (o instanceof ASMUMLModel) && (((ASMUMLModel)o).extent == extent);
	}
	
	private static ResourceSet resourceSet;

	private static ASMUMLModel mofmm = null;
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
     * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
     */
    private void addAllReferencedExtents() {
        Iterator contents = getExtent().getAllContents();
        while (contents.hasNext()) {
            Object o = contents.next();
            if (o instanceof EClass) {
                addReferencedExtentsFor((EClass)o, new HashSet());
            }
        }
        referencedExtents.remove(getExtent());
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
                    System.err.println("WARNING: Resource for " + 
                            eType.toString() + " is null; cannot be referenced");
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
                System.err.println("WARNING: Resource for " + 
                        eType.toString() + " is null; cannot be referenced");
            }
        }
        Iterator eSupers = eClass.getESuperTypes().iterator();
        while (eSupers.hasNext()) {
            EClass eSuper = (EClass) eSupers.next();
            if (eSuper.eResource() != null) {
                referencedExtents.add(eSuper.eResource());
                addReferencedExtentsFor(eSuper, ignore);
            } else {
                System.err.println("WARNING: Resource for " + 
                       eSuper.toString() + " is null; cannot be referenced");
            }
        }
    }
    
    /**
     * @return The set of referenced Resources.
     */
    public Set getReferencedExtents() {
        return referencedExtents;
    }
    
    
    
    /*
    // Unsupported Methods needed //
     */
    
    
	private List delayedInvocations = new ArrayList();

	public int getLastStereotypeMethod(String opName, List delayedInvocations) {
		int rang = 0;
		for (int i=0; i<delayedInvocations.size();i++) {
			Invocation invoc = (Invocation)(delayedInvocations.get(rang));
			if (invoc.opName.equals(opName)) {
				rang = i;
			}
		}
		return rang;
	}
	
	public void addDelayedInvocation(Invocation invocation) {
		// Guarantee the applied profiles operations are the first applied
		if(invocation.opName.equals("applyProfile")) {
			delayedInvocations.add(0, invocation);
		} else {
			if (invocation.opName.equals("applyStereotype")
				|| invocation.opName.equals("applyAllStereotypes")
				|| invocation.opName.equals("applyAllRequiredStereotypes") 
					) {
				//Guarantee the applied stereotypes operations are applied before setValue and after applyProfile
				int lastApplyProfile = getLastStereotypeMethod("applyProfile", delayedInvocations);
				if (lastApplyProfile<delayedInvocations.size()-1) {
					delayedInvocations.add(lastApplyProfile+1, invocation);
				}
				else {
					delayedInvocations.add(invocation);
				}
			}
			else
				// SetValue operation follow this way
				delayedInvocations.add(invocation);
		}
	}
	
	public void applyDelayedInvocations() {
		
		for(Iterator i = delayedInvocations.iterator(); i.hasNext(); ) {
			Invocation invocation = (Invocation)i.next();
			invocation.self.realInvoke(invocation.frame, invocation.opName, invocation.arguments);
		}
		
	}
    
}
