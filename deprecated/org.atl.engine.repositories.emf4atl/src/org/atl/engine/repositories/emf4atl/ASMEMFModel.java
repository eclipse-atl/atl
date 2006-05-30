package org.atl.engine.repositories.emf4atl;

import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.atl.engine.vm.ModelLoader;
import org.atl.engine.vm.nativelib.ASMModel;
import org.atl.engine.vm.nativelib.ASMModelElement;
import org.atl.engine.vm.nativelib.ASMString;
import org.eclipse.emf.common.util.URI;
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

/**
 * @author Frédéric Jouault
 */
public class ASMEMFModel extends ASMModel {

	private boolean checkSameModel = true;
	
	public static ASMModel getMOF() {
		return mofmm;
	}
	
	private Map modelElements = new HashMap(); 

	public ASMModelElement getASMModelElement(EObject object) {
		ASMModelElement ret = null;
		
		synchronized(modelElements) {
			ret = (ASMModelElement)modelElements.get(object);
			if(ret == null) {
				ret = new ASMEMFModelElement(modelElements, this, object);
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
        initClassifiers(extent.getContents().iterator(), classifiers, null);
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
/*
	public ASMModelElement findModelElement(String name) {
		ASMModelElement ret = null;
		
		EObject eo = null;
		
		eo = findModelElementIn(name, extent.getContents().iterator());
		
		if(eo != null)
			ret = getASMModelElement(eo);
		
		return ret;
	}

	private EObject findModelElementIn(String name, Iterator i) {
		EObject ret = null;

		for( ; i.hasNext() && (ret == null); ) {
			EObject t = (EObject)i.next();
			if(t instanceof EPackage) {
				ret = ((EPackage)t).getEClassifier(name);
				if(ret == null) {
					ret = findModelElementIn(name, ((EPackage)t).getESubpackages().iterator());
				}
			}
		}
		
		return ret;
	}
*/	

    /**
     * @param type The type of element to search for.
     * @return The set of ASMModelElements that are instances of type.
     * @see ASMModelElement
     */
	public Set getElementsByType(ASMModelElement type) {
		Set ret = new HashSet();
		EClass t = (EClass)((ASMEMFModelElement)type).getObject();
        addElementsOfType(ret, t, extent);
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
		
		EClass t = (EClass)((ASMEMFModelElement)type).getObject();
		EObject eo = t.getEPackage().getEFactoryInstance().create(t);
		ret = (ASMEMFModelElement)getASMModelElement(eo);
		extent.getContents().add(eo);
		
		return ret;
	}
	/**
	 * @param name
	 * @param metamodel
	 * @param isTarget
	 */
	private ASMEMFModel(String name, Resource extent, ASMEMFModel metamodel, boolean isTarget, ModelLoader ml) {
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
		
		return ret;
	}
	
	public void dispose() {
        if (extent != null) {
            referencedExtents.clear();
            extent.unload();
            resourceSet.getResources().remove(extent);
            extent = null;
            modelElements = null;
        }
	}
    
    public void finalize() {
        dispose();
    }
	
	public static ASMEMFModel newASMEMFModel(String name, ASMEMFModel metamodel, ModelLoader ml) throws Exception {
		ASMEMFModel ret = null;
		
		Resource extent = resourceSet.createResource(URI.createURI(name));

		ret = new ASMEMFModel(name, extent, metamodel, true, ml);

		return ret;
	}
	
	public static ASMEMFModel loadASMEMFModel(String name, ASMEMFModel metamodel, String url, ModelLoader ml) throws Exception {
		ASMEMFModel ret = null;
		
		if(url.startsWith("uri:")) {
			String uri = url.substring(4);
			EPackage pack = (EPackage)EPackage.Registry.INSTANCE.getEPackage(uri);
			Resource extent = pack.eResource();
			ret = new ASMEMFModel(name, extent, metamodel, false, ml);
            ret.addAllReferencedExtents();
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
			Resource extent = resourceSet.createResource(uri);
			extent.load(Collections.EMPTY_MAP);
//            Resource extent = resourceSet.getResource(uri, true);
			ret = new ASMEMFModel(name, extent, metamodel, true, ml);
            ret.addAllReferencedExtents();
			ret.setIsTarget(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
		adaptMetamodel(ret, metamodel);

		return ret;
	}
	
	public static ASMEMFModel loadASMEMFModel(String name, ASMEMFModel metamodel, InputStream in, ModelLoader ml) throws Exception {
		ASMEMFModel ret = newASMEMFModel(name, metamodel, ml);

		try {
			ret.extent.load(in, Collections.EMPTY_MAP);
            ret.addAllReferencedExtents();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		adaptMetamodel(ret, metamodel);
		ret.setIsTarget(false);

		return ret;
	}
    
	private static void adaptMetamodel(ASMEMFModel model, ASMEMFModel metamodel) {
		if(metamodel == mofmm) {
			for(Iterator i = model.getElementsByType("EPackage").iterator() ; i.hasNext() ; ) {
				ASMEMFModelElement ame = (ASMEMFModelElement)i.next();
				EPackage p = (EPackage)ame.getObject();
				String nsURI = p.getNsURI();
				if(nsURI == null) {
					nsURI = p.getName();
					p.setNsURI(nsURI);
				}
				EPackage.Registry.INSTANCE.put(nsURI, p);
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

/*		
		reader.read(url.openStream(), url.toString(), ret.pack);
		ret.getAllAcquaintances();
*/	
	}
	
	public static ASMEMFModel createMOF(ModelLoader ml) {
		
		if(mofmm == null) {
			Resource extent = resourceSet.createResource(URI.createURI("http://www.eclipse.org/emf/2002/Ecore"));
//			System.out.println("Actual resource class: " + extent.getClass());
			extent.getContents().add(EcorePackage.eINSTANCE);
			mofmm = new ASMEMFModel("MOF", extent, null, false, ml);
		}
		
		return mofmm;
	}
	
	public Resource getExtent() {
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
//		System.out.println(Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap());
//		System.out.println(Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap());
		resourceSet = new ResourceSetImpl();
		
	}
	
	public boolean equals(Object o) {
		return (o instanceof ASMEMFModel) && (((ASMEMFModel)o).extent == extent);
	}
	
	private static ResourceSet resourceSet;

	private static ASMEMFModel mofmm = null;
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
                    System.err.println("WARNING: Resource for " + 
                            eType.toString() + " is null; cannot be referenced");
                }
                if (eType instanceof EClass) {
                    addReferencedExtentsFor((EClass) eType, ignore);
                }
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
