/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.ant;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.atl.emftvm.Model;

/**
 * Creates a new {@link Model}.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class NewModelTask extends LoadModelTask {

	/**
	 * Creates a new model from <pre>uri</pre>.
	 * @param uri the model's EMF URI
	 *
	 * @see org.eclipse.m2m.atl.emftvm.ant.LoadModelTask#loadFromURI(org.eclipse.emf.common.util.URI)
	 */
	@Override
	protected void loadFromURI(URI uri) {
		final ResourceSet rs = getResourceSet();
		final Resource r = rs.createResource(uri);
		if (r == null) {
			throw new IllegalArgumentException(String.format("Model with uri %s could not be created", uri));
		}
		final Model m = createModel();
		m.setResource(r);
		setModel(getName(), m);
	}

}
