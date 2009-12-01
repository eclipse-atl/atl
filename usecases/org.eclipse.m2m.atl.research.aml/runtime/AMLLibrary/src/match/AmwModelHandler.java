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

package match;	

import java.util.HashMap;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame;
import org.eclipse.m2m.atl.engine.emfvm.lib.ExecEnv;
import org.eclipse.m2m.atl.engine.emfvm.lib.LibExtension;
import org.eclipse.m2m.atl.engine.emfvm.lib.Operation;

/**
 * 
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a>
 *
 */
public class AmwModelHandler implements LibExtension {

	public void apply(ExecEnv execEnv, Map<String, Object> options) {
		final Map<String, String> amwModelMappings = new HashMap<String, String>();
		String s = (String)options.get("amwModelMappings");
		if(s != null) {
			for(String e : s.split(",")) {
				String mapping[] = e.split("=");
				amwModelMappings.put(mapping[0], mapping[1]);
			}
		}
		Operation op = new Operation(1, "getReferredElement") {
			public Object exec(AbstractStackFrame frame) {
				Object localVars[] = frame.getLocalVars();
				EObject linkEnd = (EObject)localVars[0];
				EObject elementRef = (EObject)get(linkEnd, "element");
				EObject modelRef = (EObject)get(elementRef, "modelRef");
				String modelName = (String)get(modelRef, "name");
				if(amwModelMappings.containsKey(modelName)) {
					modelName = amwModelMappings.get(modelName);
				}
				IModel targetModel = frame.getExecEnv().getModel(modelName);	// TODO: use properties file
				if (targetModel == null) {
					System.err.println("The modelRef name does not correspond to the name of the loaded model");
				}
				String ref = (String)get(elementRef, "ref");
				Resource model = ((EMFModel)targetModel).getResource();
				
				return  model.getEObject(ref) ;
			}
		};

		// TODO: make this generic (i.e., not dependent on the "EqualMM" name)

		for(Iterator<IModel> i = execEnv.getModels() ; i.hasNext() ; ) {
			IModel m = i.next();
			if(m instanceof IReferenceModel) {
				IReferenceModel rm = (IReferenceModel)m;
				Object wle = rm.getMetaElementByName("WLinkEnd");
				if(wle != null)
					execEnv.registerOperation(wle, op);			
			}
		}

	}

	private static Object get(EObject eo, String featureName) {
		return eo.eGet(eo.eClass().getEStructuralFeature(featureName));
	}
	
	
}