/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frédéric Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm.lib;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

public class Model {
	
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
	
	protected ReferenceModel referenceModel;
	protected Resource resource;
	
	private boolean canDisposeOfEMFResource;
	public boolean isTarget = false;
	private Map elementsByType = new HashMap();
	
	public Model(ReferenceModel referenceModel, URL url) throws IOException {
		this(referenceModel, URI.createURI(url.toString()), false);
	}
	
	public Model(ReferenceModel referenceModel, URI uri, boolean createNewModel) throws IOException {
		this.referenceModel = referenceModel;
		if (createNewModel) {			
			resource = resourceSet.createResource(uri);
		} else {
			resource = resourceSet.getResource(uri, true);
		}
		canDisposeOfEMFResource = true;
	}
	
	public Model(ReferenceModel referenceModel, Resource resource) {
		this.referenceModel = referenceModel;
		this.resource = resource;
		canDisposeOfEMFResource = false;	// we did not create the resource
	}
	
	// Only to create the metametamodel
	// Needs to be called from a ReferenceModel constructor
	protected Model(Resource resource) {
		this.referenceModel = (ReferenceModel)this;
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
	public Set getElementsByType(EClass metaElement) {
		Set ret = (Set)elementsByType.get(metaElement); 
			
		if(ret == null) {
			ret = new LinkedHashSet();
		
			for(Iterator i = getContents() ; i.hasNext() ; ) {
				EObject element = (EObject)i.next();
				if(metaElement.isInstance(element)) {
					ret.add(element);
				}
			}
			elementsByType.put(metaElement, ret);
		}
		
		return ret;
	}
	
	public ReferenceModel getReferenceModel() {
		return referenceModel;
	}
	
	public EObject newElement(EClass metaElement) {
		EObject ret = null;
		ret = metaElement.getEPackage().getEFactoryInstance().create(metaElement);
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
			if(eo.eContainer() != null)
				toDelete.add(eo);
		}
		resource.getContents().removeAll(toDelete);
		try {
			applyDelayedInvocations();			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
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
	
	/**
	 * Test if the model contains the given EObject.
	 * @param eo
	 * @return <code>true</code> if the model contains the given EObject.
	 */
	public boolean contains(EObject eo) {
		for(Iterator i = resource.getAllContents() ; i.hasNext() ; ) {
			EObject current = (EObject)i.next();
			if(current.equals(eo))
				return true;
		}
		return false;
	}
	
	/*
	 * Ordered methods to delay     
	 */
	private List delayedInvocations = new ArrayList();
	
	/**
	 * Specifies that a method must be called at the end of a model creation.
	 * @param method the Java method
	 * @param self the caller Object
	 * @param opName the method name
	 * @param arguments the method arguments
	 */
	public void addDelayedInvocation(Method method, Object self, String opName, Object[] arguments) {
		addDelayedInvocation(new Invocation(method, self, opName, arguments));
	}
	
	private void addDelayedInvocation(Invocation invocation) {
		// Guarantee the applied profiles operations are the first applied
		if(invocation.opName.equals("applyProfile")) {
			delayedInvocations.add(0, invocation);
		} else {
			if (invocation.opName.equals("applyStereotype")
					|| invocation.opName.equals("applyAllStereotypes")
					|| invocation.opName.equals("applyAllRequiredStereotypes") 
			) {
				//Guarantee the applied stereotypes operations are applied before setValue and after applyProfile
				int lastApplyProfile = getLastStereotypeMethod("applyProfile", delayedInvocations);
				if (lastApplyProfile<delayedInvocations.size()-1) {
					delayedInvocations.add(lastApplyProfile+1, invocation);
				}
				else {
					delayedInvocations.add(invocation);
				}
			}
			else
				// SetValue operation follow this way
				delayedInvocations.add(invocation);
		}
	}
	
	private int getLastStereotypeMethod(String opName, List delayedInvocations) {
		int rang = 0;
		for (int i=0; i<delayedInvocations.size();i++) {
			Invocation invoc = (Invocation)(delayedInvocations.get(rang));
			if (invoc.opName.equals(opName)) {
				rang = i;
			}
		}
		return rang;
	}

	private void applyDelayedInvocations() throws InvocationTargetException, IllegalAccessException {
		for(Iterator i = delayedInvocations.iterator(); i.hasNext(); ) {
			Invocation invocation = (Invocation)i.next();
			invocation.method.invoke(invocation.self, invocation.arguments);
		}
	}
	
	private class Invocation {
		public Invocation(Method method, Object self, String opName, Object[] arguments) {
			this.method = method;
			this.self = self;
			this.opName = opName;
			this.arguments = arguments;
		}
		
		public Method method;
		public Object self;
		public String opName;
		public Object[] arguments;
	}
}
