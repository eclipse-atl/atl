/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * Copyright (c) 2021 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.ant;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.util.EMFTVMUtil;

/**
 * Loads a {@link Metamodel}.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class LoadMetamodelTask extends LoadModelTask {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Model createModel(final Resource resource) {
		return EmftvmFactory.eINSTANCE.createMetamodel(resource);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void innerExecute() throws Exception {
		super.innerExecute();
		EMFTVMUtil.registerEPackages(getResourceSet());
	}

}
