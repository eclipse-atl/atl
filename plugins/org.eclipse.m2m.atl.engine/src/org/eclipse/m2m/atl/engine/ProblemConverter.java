package org.eclipse.m2m.atl.engine;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Utility class that translates ATL problem objects into an easily
 * accessible {@link CompileTimeError} objects.
 * 
 * @author Matthias Bohlen
 *
 */
public class ProblemConverter
{
    /**
     * Returns an easily readable representation of a problem that occured
     * during compilation of an ATL script.
     * 
     * @param problemObject the internal representation of the problem
     * @return easily readable CompileTimeError object
     */
    public static CompileTimeError convertProblem(EObject problemObject) {
        String severity = getStringFeature(problemObject, "severity");
        String location = getStringFeature(problemObject, "location");
        String description = getStringFeature(problemObject, "description");
        return new CompileTimeError(severity, location, description);
    }
    
    /**
     * Gets the value of a feature (attribute) of a model object.
     * @param eObject the model object
     * @param featureName the name of the feature
     * @return the value of the feature
     */
    private static String getStringFeature (EObject eObject, String featureName) {
        EStructuralFeature sfLocation = eObject.eClass().getEStructuralFeature(featureName);
        return (String) eObject.eGet(sfLocation);
    }

}
