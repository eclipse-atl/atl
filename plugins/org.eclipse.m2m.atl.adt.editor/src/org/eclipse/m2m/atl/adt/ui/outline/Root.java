/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tarik Idrissi (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.outline;

import org.eclipse.emf.ecore.EObject;

public class Root {
	private EObject unit;
	
	/*
	 * Prefix for EObject variable names:
	 * 		- cl: EClass
	 * 		- pk: EPackage
	 * 		- sf: EStructuralFeature
	 */
	
	/*EPackage pkAtl = (EPackage)module.eClass().getEPackage();
		
		EClass clRule = (EClass)pkAtl.getEClassifier("Rule");
		EClass clHelper = (EClass)pkAtl.getEClassifier("Helper");
		EClass clLibraryRef = (EClass)pkAtl.getEClassifier("LibraryRef");
		EStructuralFeature sfElements = module.eClass().getEStructuralFeature("elements");
		EList elements = (EList)module.eGet(sfElements);
		for(Iterator i = elements.iterator() ; i.hasNext() ; ) {
			EObject eo = (EObject)i.next();
			if(clRule.isInstance(eo)) {
				rules.add(new Rule(eo));
			} else if(clHelper.isInstance(eo)) {
				
			}
		}
	}*/
	
	
	
	/**
	 * Returns the wrapped EObject. 
	 * That EObject is can be an instance of 
	 * <ul>
	 *	<li>Module</li>
	 *	<li>Unit</li>
	 *	<li>library</li>
	 * </ul>
	 * @return the wrapped EObject.
	 */
	public EObject getUnit() {
		return  unit;
	}
	
	/**
	 * @param module The module to set.
	 */
	public void setUnit(EObject unit) {
		this.unit = unit;
	}
	
}
