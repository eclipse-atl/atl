/*******************************************************************************
 * Copyright (c) 2009 Ecole des Mines de Nantes.

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kelly Garces - initial API and implementation and/or initial documentation
 *******************************************************************************/ 

package org.eclipse.m2m.atl.research.aml.utils;

import org.eclipse.emf.ecore.EObject;

/**
 * 
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a>
 *
 */
public class ModelUtils {

	
	public static Object get(EObject eo, String featureName) {
		return eo.eGet(eo.eClass().getEStructuralFeature(featureName));
	}

	public static void set(EObject eo, String featureName, Object value) {
		eo.eSet(eo.eClass().getEStructuralFeature(featureName), value);
	}
	
	
	
}
