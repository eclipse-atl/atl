/**
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *     Dennis Wagelaar (Vrije Universiteit Brussel)
 *
 * $Id: EMFModel.java,v 1.15 2010/09/27 07:07:51 wpiers Exp $
 */

package org.eclipse.m2m.atl.core.emf;

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
import org.eclipse.m2m.atl.core.IModel;

/**
 * The EMF implementation of {@link IModel}.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class EMFModel implements IModel {

	/** The metamodel. */
	protected EMFReferenceModel referenceModel;

	protected Map<EClass, Set<EObject>> elementsByType = new HashMap<EClass, Set<EObject>>();

	private Resource resource;

	private EMFModelFactory modelFactory;

	private boolean isTarget;
	
	/**
	 * Creates a new {@link EMFModel} conforming to the given {@link EMFReferenceModel}.
	 * 
	 * @param referenceModel
	 *            the metamodel.
	 * @param mf
	 *            the model factory that is creating this model.
	 */
	public EMFModel(EMFReferenceModel referenceModel, EMFModelFactory mf) {
		this.referenceModel = referenceModel;
		this.modelFactory = mf;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IModel#newElement(java.lang.Object)
	 */
	public Object newElement(Object metaElement) {
		Resource mainResource = getResource();
		if (mainResource == null) {
			mainResource = modelFactory.getResourceSet().createResource(URI.createURI("new-model")); //$NON-NLS-1$
			// TODO [Resource.Factory issues] use the correct factory
			// MAIN ISSUE HERE...
			// resource must be created within the model creation
			setResource(mainResource);
		}
		EClass ec = (EClass)metaElement;
		EObject ret = null;
		ret = ec.getEPackage().getEFactoryInstance().create(ec);
		mainResource.getContents().add(ret);
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IModel#getReferenceModel()
	 */
	public EMFReferenceModel getReferenceModel() {
		return referenceModel;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IModel#getElementsByType(java.lang.Object)
	 */
	public Set<EObject> getElementsByType(Object metaElement) {
		EClass ec = (EClass)metaElement;
		Set<EObject> ret = null;
		if (!isTarget) {
			ret = elementsByType.get(ec);
		}
		if (ret == null) {
			ret = new LinkedHashSet<EObject>();
			final Resource res = getResource();
			if (res != null) {
				for (Iterator<EObject> iterator = res.getAllContents(); iterator.hasNext();) {
					EObject element = iterator.next();
					if (ec.isInstance(element)) {
						ret.add(element);
					}
				}
			}
			if (!isTarget) {
				elementsByType.put(ec, ret);
			}
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IModel#isTarget()
	 */
	public boolean isTarget() {
		return isTarget;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IModel#setIsTarget(boolean)
	 */
	public void setIsTarget(boolean value) {
		this.isTarget = value;
	}

	/**
	 * Returns the resource.
	 * 
	 * @return the resource
	 */
	public Resource getResource() {
		return resource;
	}

	/**
	 * Sets the resource with the resource value.
	 * 
	 * @param resource
	 *            the resource to set
	 */
	protected void setResource(Resource resource) {
		this.resource = resource;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IModel#getModelFactory()
	 */
	public EMFModelFactory getModelFactory() {
		return modelFactory;
	}

	/**
	 * Finalizes the model.
	 */
	public void commitToResource() {
		final Resource res = getResource();
		List<EObject> toDelete = new ArrayList<EObject>();
		if (res != null) {
			for (Iterator<EObject> i = res.getAllContents(); i.hasNext();) {
				EObject eo = i.next();
				if (eo.eContainer() != null) {
					toDelete.add(eo);
				}
			}
			res.getContents().removeAll(toDelete);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IReferenceModel#isModelOf(java.lang.Object)
	 */
	public boolean isModelOf(Object object) {
		if (resource == null) {
			return false;
		}
		final Resource res = ((EObject)object).eResource();
		if (getResource().equals(res)) {
			return true;
		}
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		EMFModelFactory mf = getModelFactory();
		if (mf != null) {
			mf.unload(this);
		}
		super.finalize();
	}

}
