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

import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.core.emf.EMFModel;

/**
 * 
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a>
 *
 */
public class EqualModelUtils {
	
	public static final String wmodel = "MatchModel";
	public static final String wModelRefType = "ModelRef";

	
	public static EObject getMatcher(EMFModel wovenM)  {

		  EObject matchModel = null;
		  
		  
		  
		  EClass metaElement = (EClass) wovenM.getReferenceModel().getMetaElementByName(wmodel);
		  
		  Set<EObject> matchModelSet = wovenM.getElementsByType(metaElement);
		  
		  
		  
		  for(Iterator<EObject> ite = matchModelSet.iterator(); ite.hasNext(); ite.hasNext()) { 
			  matchModel = (EObject) ite.next();
		  }
		  return matchModel;
		 
	}

	public static EObject getLeftModelRef(EMFModel wovenM) {
		EObject matcher = getMatcher(wovenM);
		
		return (EObject) ModelUtils.get(matcher, "leftM");

	}

	public static EObject getRightModelRef(EMFModel wovenM) {
		
		EObject matcher = getMatcher(wovenM);
		

		return (EObject) ModelUtils.get(matcher, "rightM");
	}
	
	/**
	 * assumes that an aml strategy decorates an equal model with its name 
	 * @param wovenM
	 * @return
	 */
	public static EList<EObject> getMethods(EMFModel wovenM) {
		
		EObject matcher = getMatcher(wovenM);
		
		return (EList<EObject>) ModelUtils.get(matcher, "methods");
	
		
	}
	

}
