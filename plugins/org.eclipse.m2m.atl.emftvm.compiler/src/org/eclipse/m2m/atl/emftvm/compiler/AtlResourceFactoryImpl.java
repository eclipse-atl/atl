/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.compiler;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

/**
 * Creates {@link AtlResourceImpl} instances.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class AtlResourceFactoryImpl extends ResourceFactoryImpl {

	/**
	 * Creates a new {@link AtlResourceImpl} for the given <code>uri</code>.
	 * @param uri the resource's URI
	 * @return the new {@link AtlResourceImpl}
	 */
	@Override
	public Resource createResource(URI uri) {
		return new AtlResourceImpl(uri);
	}

}
