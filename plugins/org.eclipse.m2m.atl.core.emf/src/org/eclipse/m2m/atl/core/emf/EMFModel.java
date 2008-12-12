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
 * $Id: EMFModel.java,v 1.2 2008/12/12 15:40:51 wpiers Exp $
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
 * @author <a href="mailto:mikael.barbero@univ-nantes.fr">Mikael Barbero</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class EMFModel implements IModel {

	protected List<Resource> resources;

	protected EMFModelFactory modelFactory;
	
	private boolean isTarget;

	private EMFReferenceModel referenceModel;

	private Map<EClass, Set<EObject>> elementsByType = new HashMap<EClass, Set<EObject>>();

	/**
	 * Creates a new {@link EMFModel} conforming to the given {@link EMFReferenceModel}.
	 * 
	 * @param referenceModel
	 *            the metamodel
	 */
	public EMFModel(EMFReferenceModel referenceModel) {
		this.resources = new ArrayList<Resource>();
		this.referenceModel = referenceModel;
		// If the current model isn't a metametamodel
		if (referenceModel != null) {
			this.modelFactory = referenceModel.getModelFactory();	
		}		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IModel#newElement(java.lang.Object)
	 */
	public Object newElement(Object metaElement) {
		Resource mainResource = null;
		if (resources.isEmpty()) {
			mainResource = modelFactory.getResourceSet().createResource(URI.createURI("new-model")); //$NON-NLS-1$
			resources.add(mainResource);
		} else {
			mainResource = resources.get(0);
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
		Set<EObject> ret = elementsByType.get(ec);
		if (ret == null) {
			ret = new LinkedHashSet<EObject>();
			for (Resource resource : resources) {
				for (Iterator<EObject> iterator = resource.getAllContents(); iterator.hasNext();) {
					EObject element = iterator.next();
					if (ec.isInstance(element)) {
						ret.add(element);
					}
				}
			}
			elementsByType.put(ec, ret);
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
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IModel#dispose()
	 */
	public void dispose() {
		if (this != referenceModel) {
			// we clean our references, except for the metametamodel
			for (Resource resource : resources) {
				modelFactory.getResourceSet().getResources().remove(resource);
			}
		}
	}

	public List<Resource> getResources() {
		return resources;
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
	public void commitToResources() {
		for (Resource resource : resources) {
			List<EObject> toDelete = new ArrayList<EObject>();
			for (Iterator<EObject> i = resource.getAllContents(); i.hasNext();) {
				EObject eo = i.next();
				if (eo.eContainer() != null) {
					toDelete.add(eo);
				}
			}
			resource.getContents().removeAll(toDelete);
		}
	}

}
