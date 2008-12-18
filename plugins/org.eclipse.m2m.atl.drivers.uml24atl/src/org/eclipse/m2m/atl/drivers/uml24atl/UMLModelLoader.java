/*******************************************************************************
 * Copyright (c) 2008 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dennis Wagelaar (Vrije Universiteit Brussel) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.drivers.uml24atl;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.m2m.atl.drivers.emf4atl.EMFModelLoader;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * Loads UML models into a ResourceSet. Make sure to use the same
 * model loader for all EMF models used in a model transformation!
 * Use different model loaders for different threads.
 *
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class UMLModelLoader extends EMFModelLoader {

	/**
	 * UMLModelLoader constructor.
	 */
	public UMLModelLoader() {
		super();
		useIDs = true;
		saveOptions.put(XMIResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.FALSE);
		saveOptions.put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.EMFModelLoader#createASMEMFModel(java.lang.String, org.eclipse.emf.ecore.resource.Resource, org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, boolean)
	 */
	protected ASMEMFModel createASMEMFModel(String name, Resource extent, ASMModel metamodel, boolean isTarget) {
		return new ASMUMLModel(name, extent, (ASMEMFModel)metamodel, isTarget, this);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.EMFModelLoader#finalizeResource(org.eclipse.emf.ecore.resource.Resource)
	 */
	protected void finalizeResource(Resource r) {
		r.unload();
		ATLLogger.fine(r + " is unloaded");
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.EMFModelLoader#realSave(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, java.lang.String)
	 */
	protected void realSave(ASMModel model, String href) throws IOException {
		((ASMUMLModel)model).applyDelayedInvocations();
		super.realSave(model, href);
	}
	
}
