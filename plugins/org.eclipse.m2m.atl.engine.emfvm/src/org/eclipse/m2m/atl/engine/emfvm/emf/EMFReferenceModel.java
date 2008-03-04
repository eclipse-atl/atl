/**
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: EMFReferenceModel.java,v 1.1.2.1 2008/03/04 21:12:13 mbarbero Exp $
 */

package org.eclipse.m2m.atl.engine.emfvm.emf;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.engine.AtlEMFModelHandler;
import org.eclipse.m2m.atl.engine.emfvm.lib.ReferenceModel;

/**
 * 
 * @author Frederic Jouault
 * @author Mikael Barbero
 *
 */
public class EMFReferenceModel extends EMFModel implements ReferenceModel {

	private Map metaElementByName = null;

	// TODO: why require the referenceModel to be passed as argument when we know it is the mmm
	public EMFReferenceModel(ReferenceModel referenceModel, URL url) throws IOException {
		super(referenceModel, url);
		adapt();
	}

	public EMFReferenceModel(ReferenceModel referenceModel, URI uri) throws IOException {
		super(referenceModel, uri,false);
		adapt();
	}

	public EMFReferenceModel(ReferenceModel referenceModel, Resource resource) {
		super(referenceModel, resource);
		registerPackages();
	}

	// TODO:
	//	- current implementation uses the regular VM package registry because it is used by the launch config
	//	future version may use EPackage.Registry.INSTANCE.getEPackage(uri).eResource()
	//	It may even be better to have a common package registry for all VMs
	public EMFReferenceModel(ReferenceModel referenceModel, String uri) {
		super(referenceModel, AtlEMFModelHandler.getResourceSet().getPackageRegistry().getEPackage(uri).eResource());
		registerPackages();
	}

	private void registerPackages() {
		for(Iterator i = getElementsByType(EcorePackage.eINSTANCE.getEPackage()).iterator() ; i.hasNext() ; ) {
			EPackage p = (EPackage)i.next();
			String nsURI = p.getNsURI();
			resourceSet.getPackageRegistry().put(nsURI, p);
		}		
	}

	private void adapt() {
		for(Iterator i = getElementsByType(EcorePackage.eINSTANCE.getEPackage()).iterator() ; i.hasNext() ; ) {
			EPackage p = (EPackage)i.next();
			String nsURI = p.getNsURI();
			if(nsURI == null) {
				//System.err.println("DEBUG: EPackage " + p.getName() + " in model " + model.getName() + " has no nsURI.");
				nsURI = p.getName() ;
				p.setNsURI(nsURI);
			}
			if (resourceSet.getPackageRegistry().containsKey(nsURI)) {
				if (!p.equals(resourceSet.getPackageRegistry().getEPackage(nsURI))) {
					//System.err.println("WARNING: overwriting local EMF registry entry for " + nsURI);
				}
			} else {
//				model.unregister.add(nsURI);
			}
			resourceSet.getPackageRegistry().put(nsURI, p);
		}
		//System.err.println("INFO: Registering " + nsURI + " in local EMF registry");
		for(Iterator i = getElementsByType(EcorePackage.eINSTANCE.getEDataType()).iterator() ; i.hasNext() ; ) {
			EDataType dt = (EDataType)i.next();
			String tname = dt.getName();
			String icn = null;
			if(tname.equals("Boolean")) {
				icn = "boolean";	//"java.lang.Boolean";
			} else if(tname.equals("Double")) {
				icn = "java.lang.Double";
			} else if(tname.equals("Float")) {
				icn = "java.lang.Float";
			} else if(tname.equals("Integer")) {
				icn = "java.lang.Integer";
			} else if(tname.equals("String")) {
				icn = "java.lang.String";
			}
			if(icn != null)
				dt.setInstanceClassName(icn);
		}
	}

	private EMFReferenceModel(Resource resource) {
		super(resource);
	}

	public Object getMetaElementByName(String name) {
		if(metaElementByName == null) {
			metaElementByName = new HashMap();
			for(Iterator i = getElementsByType(EcorePackage.eINSTANCE.getEClass()).iterator() ; i.hasNext() ; ) {
				EClass metaElement = (EClass)i.next();
				metaElementByName.put(metaElement.getName(), metaElement);
				String completeName = getCompletePackageName(metaElement.getEPackage())+"::"+metaElement.getName();
				metaElementByName.put(completeName, metaElement);
			}
		}		
		return metaElementByName.get(name);
	}

	private String getCompletePackageName(EPackage p) {
		String fullPackageName = "";
		EPackage parent = p.getESuperPackage();
		if (parent != null) {
			fullPackageName += getCompletePackageName(parent) + "::" + p.getName();
		} else {
			fullPackageName = p.getName();
		}
		return fullPackageName;
	}

	public void dispose() {
		metaElementByName = null;
		super.dispose();
		// TODO: unregister packages
	}

	public static ReferenceModel getMetametamodel() {
		if(metametamodel == null) {
			metametamodel = new EMFReferenceModel(EcorePackage.eINSTANCE.eResource());
		}
		return metametamodel;
	}

	private static ReferenceModel metametamodel;

}
