package org.atl.eclipse.mgm;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

/**
 * @author Freddy Allilaire
 *
 * This class allows to load a model and its metamodel
 * It contains also some basic fonctions to extract informations from model
 */
public class MetaHandler {
    
    // Resource linked to the MetaModel
    private Resource mmExtent;

    // Resource linked to the Model
    private Resource mExtent;
    
    /**
     * Constructor loading metamodel and model associated to URL in parameters
     * @param URLmetaModel
     * @param URLmodel
     */
    public MetaHandler(String URLmetaModel, String URLmodel) {
    	
    	Resource.Factory myEcoreFactory = new EcoreResourceFactoryImpl();
        mmExtent = myEcoreFactory.createResource(URI.createURI(URLmetaModel));
        try {
        	mmExtent.load(new FileInputStream(URLmetaModel),Collections.EMPTY_MAP);
        } catch (IOException e) {
        	e.printStackTrace();
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
        init();
        
        URI uri = URI.createFileURI(URLmodel);
        mExtent = myEcoreFactory.createResource(uri);
        try {
        	mExtent.load(new FileInputStream(URLmodel),Collections.EMPTY_MAP);

        } catch (IOException e) {			
        	e.printStackTrace();
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    }

    public MetaHandler(String URLmetaModel, Resource model) {
    	Resource.Factory myEcoreFactory = new EcoreResourceFactoryImpl();
        mmExtent = myEcoreFactory.createResource(URI.createURI(URLmetaModel));
        try {
        	mmExtent.load(new FileInputStream(URLmetaModel),Collections.EMPTY_MAP);     	
        } catch (IOException e) {			
        	e.printStackTrace();
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
        init();
        
        mExtent = model;
    }
   
    public Set getElementsByType(Resource extent,String type) {
        Set ret = new HashSet();
		for(Iterator i = extent.getAllContents(); i.hasNext(); ) {
			EObject eo = (EObject)i.next();
			if (eo.eClass().getName().equals(type))
				ret.add(eo);
		}
		return ret;
	}

    public Set getElementsBySupertype(String type) {
    	Set ret = new HashSet();
		for(Iterator i = mExtent.getAllContents(); i.hasNext(); ) {
			EObject eo = (EObject)i.next();
			EList allSuperTypes = eo.eClass().getEAllSuperTypes();
			if (eo.eClass().getName().equals(type))
				ret.add(eo);
			else
				for (Iterator it = allSuperTypes.iterator(); it.hasNext();) {
					if (((EClass)it.next()).getName().equals(type)) {
						ret.add(eo);
						break;
					}
				}
		}
		return ret;
    }
    
    public Set getElementsByType(String type) {
    	return getElementsByType(mExtent,type);
    }

    private void init() {
    	
        for(Iterator it = getElementsByType(mmExtent,"EPackage").iterator() ; it.hasNext() ; ) {			
			EPackage p = (EPackage)it.next();
			String nsURI = p.getNsURI();
			if(nsURI == null) {
				nsURI = p.getName();
				p.setNsURI(nsURI);
			}
			EPackage.Registry.INSTANCE.put(nsURI, p);
		}
        
        for(Iterator it = getElementsByType(mmExtent,"EDataType").iterator(); it.hasNext(); ) {
            EObject eo = (EObject)it.next();
            EStructuralFeature sf;
            sf = eo.eClass().getEStructuralFeature("name");	 
            String tname = (String)eo.eGet(sf);			 
            String icn = null;
            if(tname.equals("Boolean"))
                icn = "java.lang.Boolean";
            else if(tname.equals("Double"))
                icn = "java.lang.Double";
            else if(tname.equals("Float"))
                icn = "java.lang.Float";
            else if(tname.equals("Integer"))
                icn = "java.lang.Integer";
            else if(tname.equals("String"))
                icn = "java.lang.String";
            
            if(icn != null) {
                sf = eo.eClass().getEStructuralFeature("instanceClassName");
                eo.eSet(sf, icn);                
            }
        }
    }    
    
    /**
     * Searches the MetaModel (mmExtent) for a Classifier from its name.
     * 
     * @param classifierName The name of the researched Classifier (in the MetaModel)
     * @return The Classifier object, or null if not found
     */
    public EClassifier findEClassifier (String classifierName) {
		return findEClassifierIn(classifierName, mmExtent.getContents().iterator());
	}
    
    /**
     * Searches a list of EObjects for a Classifier from its name.
     * 
     * @param classifierName The name of the researched Classifier (in the MetaModel)
     * @param it An iterator over the contents of the MetaModel
     * @return The Classifier object, or null if not found
     */
	private EClassifier findEClassifierIn(String classifierName, Iterator it) {
		EClassifier classifier = null;

		while(it.hasNext() && (classifier == null)) {
			EObject eo = (EObject)it.next();
			if(eo instanceof EPackage) {
				classifier = ((EPackage)eo).getEClassifier(classifierName);
				if(classifier == null) {
					classifier = findEClassifierIn(classifierName, ((EPackage)eo).getESubpackages().iterator());
				}
			}
		}
		
		return classifier;
	}
	
	/**
	 * Sets a structural feature of an EObject to a given new value.
	 * This method has no effect if the structural feature is not defined
	 * for the given EObject.
	 * 
	 * @param eo The Eobject to be updated
	 * @param sfName The name of a structural feature of the EObject
	 * @param newValue The value to be set the the structural feature
	 */
	public void set(EObject eo, String sfName, Object newValue) {
	    EStructuralFeature sf = eo.eClass().getEStructuralFeature(sfName);
	    if (sf == null)
	        return;
	    
	    if (sf.isMany() && !(newValue instanceof List)) {	         
	        EList list = (EList)eo.eGet(sf);
	        list.add(newValue);
	    } else {
	        eo.eSet(sf, newValue);	    
	    }
	}
	
	/**
	 * Returns the value of a structural feature of an EObject.
	 * 
	 * @param eo The EObject
	 * @param sfName The name of a structural feature of the EObject
	 * @return The value of the structural feature
	 */
	public Object get(EObject eo, String sfName) {
	    EStructuralFeature sf = eo.eClass().getEStructuralFeature(sfName);	 
	    Object ret = eo.eGet(sf);
	    if ("String".equals(sf.eClass().getName()) && ret == null )
	    	return "";
	    return ret;
	}		
	
	/**
	 * Creates a new EObject of the given class in the Model (mExtent)
	 * resource. 
	 * 
	 * @param className The Name of the class of the EObject to be created
	 * @return The created EObject
	 */
	public EObject newModelElement(String className) {		
	    EObject instance = null;
	    
	    EClassifier classifier = findEClassifier(className);
	    if (classifier instanceof EClass) {
	        instance = classifier.getEPackage().getEFactoryInstance().create((EClass)classifier);		
			mExtent.getContents().add(instance);
		}	    
		return instance;
	}
	
	/**
	 * Re-inits the Model by removing all managed objects from it.
	 *
	 */
	public void reInit() {
	    mExtent.getContents().clear();
	}
	
	/**
	 * Removes an EObject from the Model (mExtent) resource.
	 * 
	 * @param eo The object to be removed from the Model
	 */
	public void removeModelElement(EObject eo) {
		mExtent.getContents().remove(eo);
	}
	
	/**
	 * Saves the Model (mExtent)
	 * 
	 */
	public void saveModel() {
		try {
			mExtent.save(Collections.EMPTY_MAP);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * @return Returns the mmExtent.
	 */
	public Resource getMmExtent() {
		return mmExtent;
	}
	/**
	 * @return Returns the mExtent.
	 */
	public Resource getMExtent() {
		return mExtent;
	}	
}