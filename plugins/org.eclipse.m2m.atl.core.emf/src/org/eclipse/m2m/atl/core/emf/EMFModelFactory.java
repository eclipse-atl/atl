/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Dennis Wagelaar (Vrije Universiteit Brussel)
 *******************************************************************************/
package org.eclipse.m2m.atl.core.emf;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.common.ATLResourceProvider;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;

/**
 * The EMF implementation of the {@link ModelFactory}.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public final class EMFModelFactory extends ModelFactory {

	/** The model factory name which is also the extractor/injector name. */
	public static final String MODEL_FACTORY_NAME = "EMF"; //$NON-NLS-1$

	/** Content type. */
	public static final String OPTION_CONTENT_TYPE = "OPTION_CONTENT_TYPE"; //$NON-NLS-1$

	private ResourceSet resourceSet;

	/**
	 * Creates a new {@link EMFModelFactory} and initialize the {@link ResourceSet}.
	 */
	public EMFModelFactory() {
		super();
		Map<String, Object> etfm = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		if (!etfm.containsKey("*")) { //$NON-NLS-1$
			etfm.put("*", new XMIResourceFactoryImpl()); //$NON-NLS-1$
		}
		resourceSet = new ResourceSetImpl();
		Map<Object, Object> loadOptions = resourceSet.getLoadOptions();
		loadOptions.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
		loadOptions.put(XMLResource.OPTION_USE_PARSER_POOL, new XMLParserPoolImpl());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.ModelFactory#newReferenceModel(java.util.Map)
	 */
	@Override
	public IReferenceModel newReferenceModel(Map<String, Object> options) {
		return newReferenceModel();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.ModelFactory#newReferenceModel()
	 */
	@Override
	public IReferenceModel newReferenceModel() {
		return new EMFReferenceModel(EMFReferenceModel.getMetametamodel(this), this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.ModelFactory#newModel(org.eclipse.m2m.atl.core.IReferenceModel,
	 *      java.util.Map)
	 */
	@Override
	public IModel newModel(IReferenceModel referenceModel, Map<String, Object> options) {
		return newModel(referenceModel);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.ModelFactory#newModel(org.eclipse.m2m.atl.core.IReferenceModel)
	 */
	@Override
	public IModel newModel(IReferenceModel referenceModel) {
		return new EMFModel((EMFReferenceModel)referenceModel, this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.ModelFactory#getDefaultExtractorName()
	 */
	@Override
	public String getDefaultExtractorName() {
		return MODEL_FACTORY_NAME;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.ModelFactory#getDefaultInjectorName()
	 */
	@Override
	public String getDefaultInjectorName() {
		return MODEL_FACTORY_NAME;
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.ModelFactory#getBuiltInResource(java.lang.String)
	 */
	@Override
	public IReferenceModel getBuiltInResource(String name) {
		EMFReferenceModel model = new EMFReferenceModel(EMFReferenceModel.getMetametamodel(this), this);
		URL url = ATLResourceProvider.getURL(name); //$NON-NLS-1$ //$NON-NLS-2$
		Resource builtin = resourceSet.createResource(URI.createURI(name));
		try {
			builtin.load(url.openStream(), Collections.EMPTY_MAP);	
		} catch (IOException e) {
			ATLLogger.log(Level.SEVERE, Messages.getString("EMFModelFactory.BUILT_IN_NOT_FOUND"), e); //$NON-NLS-1$
		}		
		if (builtin == null) {
			ATLLogger.severe(Messages.getString("EMFModelFactory.BUILT_IN_NOT_FOUND")); //$NON-NLS-1$
			return null;
		}
		model.setResource(builtin);
		model.register();
		return model;
	}
	
	/**
	 * Removes the model's {@link Resource} from the {@link ResourceSet} and
	 * calls {@link #finalizeResource(Resource)}.
	 * 
	 * @param model The model of which to remove the {@link Resource}.
	 */
	public void unload(EMFModel model) {
		final Resource r = model.getResource();
		final EList<Resource> resources = getResourceSet().getResources();
		if (resources.contains(r)) {
			resources.remove(r);
			finalizeResource(r);
		}
	}

	/**
	 * Finalizes r. This implementation does nothing, but allows for overriding
	 * in subclasses.
	 * 
	 * @param r The resource to finalize.
	 */
	protected void finalizeResource(Resource r) {
		//do nothing
	}
}
