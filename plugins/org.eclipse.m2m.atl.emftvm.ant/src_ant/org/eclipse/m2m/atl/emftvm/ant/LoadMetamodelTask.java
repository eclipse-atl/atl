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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;


/**
 * Loads a {@link Metamodel}.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 *
 */
public class LoadMetamodelTask extends LoadModelTask {

	/* (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.ant.LoadModelTask#createModel()
	 */
	@Override
	protected Model createModel() {
		return EmftvmFactory.eINSTANCE.createMetamodel();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.ant.LoadModelTask#innerExecute()
	 */
	@Override
	protected void innerExecute() throws Exception {
		super.innerExecute();
		registerEPackages();
	}

	/**
	 * Registers any dynamic EPackage URIs.
	 */
	private void registerEPackages() {
		final ResourceSet rs = getResourceSet();
		final Registry r = rs.getPackageRegistry();
		final Metamodel mm = getMetamodel(getName());
		assert mm != null;
		for (EObject o : mm.getResource().getContents()) {
			if (o instanceof EPackage) {
				EPackage p = (EPackage) o;
				r.put(p.getNsURI(), p);
			}
		}
	}

}
