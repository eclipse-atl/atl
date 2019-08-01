/*******************************************************************************
 * Copyright (c) 2006 INRIA and other.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 * 	   Matthias Bohlen - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.atl.engine.compiler.CompileTimeError;

/**
 * Utility class that translates ATL problem objects into an easily accessible {@link CompileTimeError}
 * objects.
 * 
 * @author <a href="mailto:mbohlen@mbohlen.de">Matthias Bohlen</a>
 */
public final class ProblemConverter {

	private ProblemConverter() {
	}

	/**
	 * Returns an easily readable representation of a problem that occured during compilation of an ATL
	 * script.
	 * 
	 * @param problemObject
	 *            the internal representation of the problem
	 * @return easily readable CompileTimeError object
	 */
	public static CompileTimeError convertProblem(EObject problemObject) {
		String severity = getStringFeature(problemObject, "severity"); //$NON-NLS-1$
		String location = getStringFeature(problemObject, "location"); //$NON-NLS-1$
		String description = getStringFeature(problemObject, "description"); //$NON-NLS-1$
		return new CompileTimeError(severity, location, description);
	}

	/**
	 * Gets the value of a feature (attribute) of a model object.
	 * 
	 * @param eObject
	 *            the model object
	 * @param featureName
	 *            the name of the feature
	 * @return the value of the feature
	 */
	private static String getStringFeature(EObject eObject, String featureName) {
		EStructuralFeature sfLocation = eObject.eClass().getEStructuralFeature(featureName);
		return eObject.eGet(sfLocation).toString();
	}

}
