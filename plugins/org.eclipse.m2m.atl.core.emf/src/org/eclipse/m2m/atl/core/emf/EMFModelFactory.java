/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.core.emf;

import java.util.Map;
import java.util.logging.Level;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;

/**
 * The EMF implementation of the {@link ModelFactory}.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public final class EMFModelFactory extends ModelFactory {

	/** Content type. */
	public static final String OPTION_CONTENT_TYPE = "OPTION_CONTENT_TYPE"; //$NON-NLS-1$

	private static ResourceSet resourceSet;

	static {
		init();
	}

	/**
	 * Recreates the {@link ResourceSet}.
	 */
	public static void init() {
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
		return new EMFReferenceModel(EMFReferenceModel.getMetametamodel());
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
		return new EMFModel((EMFReferenceModel)referenceModel);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.ModelFactory#getDefaultExtractor()
	 */
	@Override
	public IExtractor getDefaultExtractor() {
		return new EMFExtractor();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.ModelFactory#getDefaultInjector()
	 */
	@Override
	public IInjector getDefaultInjector() {
		return new EMFInjector();
	}

	public static ResourceSet getResourceSet() {
		return resourceSet;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.ModelFactory#getBuiltInResource(java.lang.String)
	 */
	@Override
	public IReferenceModel getBuiltInResource(String name) {
		EMFReferenceModel model = new EMFReferenceModel(EMFReferenceModel.getMetametamodel());
		String path = "org.eclipse.m2m.atl/src/org/eclipse/m2m/atl/resources/" + name + ".ecore"; //$NON-NLS-1$//$NON-NLS-2$
		Resource builtin = resourceSet.getResource(URI.createPlatformPluginURI(path, false), true);
		if (builtin == null) {
			ATLLogger.log(Level.SEVERE, Messages.getString("EMFModelFactory.BUILT_IN_NOT_FOUND"), null); //$NON-NLS-1$
			return null;
		}
		model.getResources().add(builtin);
		model.register();
		return model;
	}
}
