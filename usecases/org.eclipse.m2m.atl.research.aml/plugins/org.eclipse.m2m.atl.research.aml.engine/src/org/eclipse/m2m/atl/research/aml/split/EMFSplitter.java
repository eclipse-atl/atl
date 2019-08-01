/*******************************************************************************
 * Copyright (c) 2009 Ecole des Mines de Nantes.

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Kelly Garces - initial API and implementation and/or initial documentation
 *******************************************************************************/ 

package org.eclipse.m2m.atl.research.aml.split;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.emf.common.util.URI;

/**
 * This implements an algorithm that splits non directed graphs. Even if the 
 * models are directed graphs the algorithm may works when the models references are bidirectional.
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a>
 *  
 */
public class EMFSplitter implements Splitter {

	
	@Override
	public Collection<IModel> split(IModel model, String containingClassName) {
		
		
		EObject e1;
		EMFModel emfModel = (EMFModel) model;
		ResourceSet resourceSet = emfModel.getModelFactory().getResourceSet();		
		Resource emfResource = emfModel.getResource();		
		EMFModelFactory modelFactory = emfModel.getModelFactory();
		
		Collection<IModel> newModels = new ArrayList<IModel>();
		
			List<EObject> list = Collections.<EObject>synchronizedList(new ArrayList<EObject>(emfResource.getContents()));
			synchronized(list) {
			
				Iterator<EObject> iteEmfModel = list.iterator();		
				int i = 0;
				while(iteEmfModel.hasNext()){
					e1 = iteEmfModel.next();
					String typeName = e1.eClass().getName();
					if (typeName.equals(containingClassName)) {
						Collection<EObject> c = new ArrayList<EObject>();
						traverse(e1, c);
						
											
						Resource newResource = resourceSet.createResource(URI.createURI("OUT_"+Integer.toString(i)));
						
						
						for(EObject e : c){
							if (e.eContainer() == null) {
								newResource.getContents().add(e);
							}
						}
						
						
						IModel ret = modelFactory.newModel(emfModel.getReferenceModel());//, );
						new EMFInjector().inject(ret, newResource);
						
						
						newModels.add(ret);
						i++;
					}
				}
			
		}
		return newModels;
	}
	
	private void traverse (EObject e, Collection<EObject> c) {
		if (c.contains(e)) {
			return;
		}
		c.add(e);
		
		for(EReference ref : e.eClass().getEAllReferences()){
				Object value = e.eGet(ref) ;
				if(value != null) {
					if (value instanceof Collection) {
						for (EObject e3 : (Collection<EObject>)value) {
							traverse(e3, c);
						}
					}
					else {					
						traverse((EObject)value, c);
					}
				}
			}	
		}

}
