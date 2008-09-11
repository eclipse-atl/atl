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
 * $Id: EMFModel.java,v 1.3.2.1 2008/09/11 15:15:37 dwagelaar Exp $
 */

package org.eclipse.m2m.atl.engine.emfvm.emf;

import java.io.IOException;
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
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractModel;
import org.eclipse.m2m.atl.engine.emfvm.lib.Model;
import org.eclipse.m2m.atl.engine.emfvm.lib.ReferenceModel;

/**
 * The model implementation dedicated to EMF.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:mikael.barbero@univ-nantes.fr">Mikael Barbero</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class EMFModel extends AbstractModel implements Model {

	protected Resource resource;

	private Map elementsByType = new HashMap();

	/**
	 * Creates an EMFModel conforming to the referenceModel and based on the resource available at the
	 * specified in the url.
	 * 
	 * @param referenceModel
	 *            the metamodel
	 * @param url
	 *            the resource url
	 * @param resourceSet
	 *            the resource set into which the model must be loaded.
	 * @throws IOException
	 *             if problem during reading url
	 */
	public EMFModel(ReferenceModel referenceModel, URL url, ResourceSet resourceSet) throws IOException {
		this(referenceModel, URI.createURI(url.toString()), resourceSet, false);
	}

	/**
	 * Creates an EMFModel conforming to the referenceModel and based on the resource available at the
	 * specified in the uri. The createNewModel parameter allow to specify if the model need to be created.
	 * 
	 * @param referenceModel
	 *            the metamodel
	 * @param uri
	 *            the resource uri
	 * @param resourceSet
	 *            the resource set into which the model must be loaded.
	 * @param createNewModel
	 *            shows if the model needs to be created
	 * @throws IOException
	 *             if problem during reading url
	 */
	public EMFModel(ReferenceModel referenceModel, URI uri, ResourceSet resourceSet, boolean createNewModel) throws IOException {
		this.referenceModel = referenceModel;
		if (createNewModel) {
			resource = resourceSet.createResource(uri);
		} else {
			resource = resourceSet.getResource(uri, true);
		}
	}

	/**
	 * Creates a new EMF model based on the resource parameter and conforming to the referenceModel.
	 * 
	 * @param referenceModel
	 *            the metamodel
	 * @param resource
	 *            the resource
	 */
	public EMFModel(ReferenceModel referenceModel, Resource resource) {
		this.referenceModel = referenceModel;
		this.resource = resource;
	}

	/**
	 * Creates a new EMF model based on the resource parameter. Only to create the metametamodel, needs to be
	 * called from a ReferenceModel constructor.
	 * 
	 * @param resource
	 *            the resource
	 */
	protected EMFModel(Resource resource) {
		this.referenceModel = (EMFReferenceModel)this;
		this.resource = resource;
	}

	// returned value could (actually was) a non-ordered set Set, because there is no order in theory
	// BUT keeping the same order (i.e., resource/XMI order) typically makes things simpler
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.Model#getElementsByType(java.lang.Object)
	 */
	public Set getElementsByType(Object metaElement) {
		EClass ec = (EClass)metaElement;
		Set ret = (Set)elementsByType.get(ec);

		if (ret == null) {
			ret = new LinkedHashSet();

			for (Iterator i = getContents(); i.hasNext();) {
				EObject element = (EObject)i.next();
				if (ec.isInstance(element)) {
					ret.add(element);
				}
			}
			elementsByType.put(ec, ret);
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.Model#getReferenceModel()
	 */
	public ReferenceModel getReferenceModel() {
		return referenceModel;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.Model#newElement(java.lang.Object)
	 */
	public Object newElement(Object metaElement) {
		EClass ec = (EClass)metaElement;
		EObject ret = null;
		ret = ec.getEPackage().getEFactoryInstance().create(ec);
		resource.getContents().add(ret);
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.Model#getContents()
	 */
	public Iterator getContents() {
		return resource.getAllContents();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.Model#save(java.lang.String)
	 */
	public void save(String uri) throws IOException {
		save(URI.createURI(uri));
	}

	/**
	 * Saves a resource in the file designed by the URI.
	 * 
	 * @param uri
	 *            the uri of the file where to save the resource
	 * @throws IOException
	 *             if there are errors during saving
	 */
	public void save(URI uri) throws IOException {
		commitToResource();

		resource.setURI(uri);
		Map options = new HashMap();
		options.put(XMLResource.OPTION_ENCODING, "ISO-8859-1");
		options.put(XMIResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.FALSE);

		// For the time being, it seems better to keep these lines commented to enable
		// usage of diff on XMI files produced by this VM and the regular VM
		// options.put(XMIResource.OPTION_FORMATTED, Boolean.TRUE);
		// options.put(XMIResource.OPTION_LINE_WIDTH, new Integer(100));
		resource.save(options);
	}

	/**
	 * Commits all changes to the managed resource.
	 */
	public void commitToResource() {
		List toDelete = new ArrayList();
		for (Iterator i = resource.getAllContents(); i.hasNext();) {
			EObject eo = (EObject)i.next();
			// TODO Test what happens to UML2 stereotype applications (typically don't have a container)
			if (eo.eContainer() != null) {
				toDelete.add(eo);
			}
		}
		resource.getContents().removeAll(toDelete);
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}
}
