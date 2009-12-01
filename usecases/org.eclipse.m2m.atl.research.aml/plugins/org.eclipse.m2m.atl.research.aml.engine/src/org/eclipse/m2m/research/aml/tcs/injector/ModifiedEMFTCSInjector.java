/*******************************************************************************

 * Copyright (c) 2009 INRIA, Ecole des Mines de Nantes.

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Doux - initial API and implementation and/or initial documentation
 *******************************************************************************/ 

package org.eclipse.m2m.research.aml.tcs.injector;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.dsls.core.EMFTCSInjector;
import org.eclipse.m2m.atl.dsls.tcs.injector.ModelAdapter;
import org.eclipse.m2m.atl.dsls.tcs.injector.ParserLauncher;
/**
 * Bug correction sunclass for EMFTCSInjector
 * @author Guillaume Doux
 *
 */
public class ModifiedEMFTCSInjector extends EMFTCSInjector {

	public ModifiedEMFTCSInjector(){
		super();
	}
	
	@Override
	public Object inject(EMFModel target, InputStream source, Map params) throws IOException {
		ModelAdapter targetModelAdapter = new EMFInjectorAdapter(target);

		EMFModel problems = (EMFModel)params.get("problems");
		if (problems != null) {
			ModelAdapter problemsModelAdapter = new EMFInjectorAdapter(problems);
			params.put("problems", problemsModelAdapter);
		}

		EObject root = (EObject)new ParserLauncher().parse(targetModelAdapter, source, params);
		target.commitToResource();
		if(problems != null)
			problems.commitToResource();
		return root;
	}
}
