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
 * $Id: EMFModel.java,v 1.1.2.2 2008/03/13 16:21:45 dwagelaar Exp $
 */

package org.eclipse.m2m.atl.engine.emfvm.emf;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractModel;
import org.eclipse.m2m.atl.engine.emfvm.lib.Model;
import org.eclipse.m2m.atl.engine.emfvm.lib.ReferenceModel;

/**
 * 
 * @author Frederic Jouault
 * @author Mikael Barbero
 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
 */
public class EMFModel extends AbstractModel implements Model {

	protected static ResourceSet resourceSet;
	
	static {
		Map etfm = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		if(!etfm.containsKey("*")) {
			etfm.put("*", new XMIResourceFactoryImpl());
		}
		resourceSet = new ResourceSetImpl();
		Map loadOptions = resourceSet.getLoadOptions();
		loadOptions.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
		loadOptions.put(XMLResource.OPTION_USE_PARSER_POOL, new XMLParserPoolImpl());

	}
	
	public Resource resource;
	
	private boolean canDisposeOfEMFResource;
	private Map elementsByType = new HashMap();
	
	public EMFModel(ReferenceModel referenceModel, URL url) throws IOException {
		this(referenceModel, URI.createURI(url.toString()), false);
	}
	
	public EMFModel(ReferenceModel referenceModel, URI uri, boolean createNewModel) throws IOException {
		this.referenceModel = referenceModel;
		if (createNewModel) {			
			resource = resourceSet.createResource(uri);
		} else {
			resource = resourceSet.getResource(uri, true);
		}
		canDisposeOfEMFResource = true;
	}
	
	public EMFModel(ReferenceModel referenceModel, Resource resource) {
		this.referenceModel = referenceModel;
		this.resource = resource;
		canDisposeOfEMFResource = false;	// we did not create the resource
	}
	
	// Only to create the metametamodel
	// Needs to be called from a ReferenceModel constructor
	protected EMFModel(Resource resource) {
		this.referenceModel = (EMFReferenceModel)this;
		this.resource = resource;
		canDisposeOfEMFResource = false;
	}

	/*
	// New model
	public Model(ReferenceModel referenceModel) throws IOException {
		this.referenceModel = referenceModel;
		resource = resourceSet.createResource(URI.createURI("new-model"));
		canDisposeOfEMFResource = true;
	}
	*/

	// returned value could (actually was) a non-ordered set Set, because there is no order in theory
	// BUT keeping the same order (i.e., resource/XMI order) typically makes things simpler
	public Set getElementsByType(Object metaElement) {
		EClass ec = (EClass)metaElement;
		Set ret = (Set)elementsByType.get(ec); 
			
		if(ret == null) {
			ret = new LinkedHashSet();
		
			for(Iterator i = getContents() ; i.hasNext() ; ) {
				EObject element = (EObject)i.next();
				if(ec.isInstance(element)) {
					ret.add(element);
				}
			}
			elementsByType.put(ec, ret);
		}
		
		return ret;
	}
	
	public ReferenceModel getReferenceModel() {
		return referenceModel;
	}
	
	public Object newElement(Object metaElement) {
		EClass ec = (EClass)metaElement;
		EObject ret = null;
		ret = ec.getEPackage().getEFactoryInstance().create(ec);
		resource.getContents().add(ret);	
		return ret;
	}
	
	public Iterator getContents() {
		return resource.getAllContents();
	}

	public void save(String uri) throws IOException {
		save(URI.createURI(uri));
	}

	public void save(URI uri) throws IOException {
		commitToResource();
		
		resource.setURI(uri);
		Map options = new HashMap();
		options.put(XMLResource.OPTION_ENCODING, "ISO-8859-1");
        options.put(XMIResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.FALSE);

        // For the time being, it seems better to keep these lines commented to enable
        // usage of diff on XMI files produced by this VM and the regular VM
        //options.put(XMIResource.OPTION_FORMATTED, Boolean.TRUE);
        //options.put(XMIResource.OPTION_LINE_WIDTH, new Integer(100));
		resource.save(options);
	}
	
	public void commitToResource() {
		List toDelete = new ArrayList();
		for(Iterator i = resource.getAllContents() ; i.hasNext() ; ) {
			EObject eo = (EObject)i.next();
			//TODO Test what happens to UML2 stereotype applications (typically don't have a container)
			if(eo.eContainer() != null)
				toDelete.add(eo);
		}
		resource.getContents().removeAll(toDelete);
	}
	
	public void dispose() {
		if(canDisposeOfEMFResource) {
            resourceSet.getResources().remove(resource);
           	//resource.unload();	// can be very time-consuming, and does not seem necessary
		}
		if(this != referenceModel) {	// we clean our references, except for the metametamodel
			resource = null;
			//newElements = null;
		}
	}
}
