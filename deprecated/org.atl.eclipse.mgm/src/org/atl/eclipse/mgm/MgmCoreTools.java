package org.atl.eclipse.mgm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Freddy Allilaire
 */
public class MgmCoreTools {

	private static MetaHandler handler = MgmPlugin.getDefault().getHandler();
	
	public static MetaHandler getHandler() {
		return handler;
	}
	
	public static EObject getMegamodel() {
		return (EObject)handler.getElementsByType("Megamodel").iterator().next();
	}
	
    public static EObject getArtifactByUri(String uri) {
        EObject []elts = (EObject[])handler.getElementsBySupertype("Artifact").toArray(new EObject[] {});
        for (int i = 0; i < elts.length; i++) {
            EObject elt = elts[i];
            if (handler.get(elt, "uri").equals(uri))
                return elt;
        }
        return null;
    }
    
    public static EObject getRelation(EObject artifact, String relationType) {
    	EList relationEnds = (EList)handler.get(artifact, "relationEnds");
    	for (Iterator it = relationEnds.iterator(); it.hasNext();) {
    		EObject currentRE = (EObject)it.next();
    		EObject relation = (EObject)handler.get(currentRE, "relation");
    		if (relation.eClass().getName().equals(relationType))
    			return relation;
    	}
    	return null;
    }
    
    public static EObject getOppositeArtifact(EObject relation, EObject artifact) {
    	EList relationEnds = (EList)handler.get(relation, "relationEnds");
    	for (Iterator it = relationEnds.iterator(); it.hasNext();) {
    		EObject relationEnd = (EObject)it.next();
    		EObject artifactRE = (EObject)handler.get(relationEnd, "artifact");
    		if (!artifactRE.equals(artifact))
    			return artifactRE;
    	}
    	return null;
    }
    
    public static EList getAttributes(EObject currentEObject) {
    	return currentEObject.eClass().getEAllAttributes();
    }
	
	/**
	 * returns the list of subtype's name of eClassName in the resource
	 * @param eClassName the name of the eclass
	 * @param resource
	 * @return list of String
	 */
	public static String[] getSubTypeListOf(String eClassName,Resource resource){
		List result = new ArrayList();
		if (resource != null){
			Iterator eClassesIterator = getAllEClass(resource).iterator();
			while(eClassesIterator.hasNext()){
				EClass eClass = (EClass) eClassesIterator.next();
				EList superTypes = eClass.getEAllSuperTypes();
				for(int i=0;i<superTypes.size();i++){
					EClass superType = (EClass) superTypes.get(i);
					if(isSuperTypeOf(superType,eClassName,resource))
						if(result.contains(eClass.getName())!= true)
								result.add(eClass.getName());
				}
			}
		}
		return (String[])result.toArray(new String[] {});
	}

	/**
	 * returns true if someClass extends of superType(String) in resource
	 * @param someClass the EClass to test
	 * @param superType the name of superclass
	 * @param resource
	 * @return true or false
	 */
	private static boolean isSuperTypeOf(EClass someClass, String superType, Resource resource){
		EClass superTypeEClass = getEClassByName(resource,superType);
		if (superTypeEClass == null)
			return false;
		superTypeEClass.getEAllSuperTypes();
		return superTypeEClass.isSuperTypeOf(someClass);
	}

    /**
     * returns the first class in the resource with a given name
     * @param modelResource
     * @param name
     * @return
     */
    private static EClass getEClassByName(Resource modelResource, String name){
    	if (modelResource != null){
    		for (Iterator i = modelResource.getAllContents() ;i.hasNext();){
    		    Object obj = i.next();	    		    
    		    if (obj instanceof EClass && name.equals(  ((EClass)obj).getName()) )
    		        return (EClass)obj;
    		}    		
    	}
		return null;
    }
	
	/**
     * returns all of the EClass for the resource
     * @param modelResource
     * @param name
     * @return
     */
    private static List getAllEClass(Resource modelResource){
		List eClasses = new ArrayList();
    	for (Iterator i = modelResource.getAllContents(); i.hasNext();){
		    Object obj = i.next();	    		    
		    if (obj instanceof EClass )
		        eClasses.add( (EClass)obj );
		}
		return eClasses;
    }
}
