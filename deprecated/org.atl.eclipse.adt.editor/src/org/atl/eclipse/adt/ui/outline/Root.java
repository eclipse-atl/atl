/*
 * Created on 14 avr. 2004
 */
package org.atl.eclipse.adt.ui.outline;

import org.eclipse.emf.ecore.EObject;

/**
 * @author idrissi
 */

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
