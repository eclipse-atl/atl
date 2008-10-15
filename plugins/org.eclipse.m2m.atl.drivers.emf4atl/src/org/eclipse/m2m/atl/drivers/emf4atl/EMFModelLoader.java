/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.drivers.emf4atl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * The EMF model loader.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class EMFModelLoader extends ModelLoader {

	private boolean useIDs;

	private boolean removeIDs;

	private String encoding = "ISO-8859-1";
	
	private ASMModel mofmm;

	/**
	 * EMFModelLoader constructor.
	 */
	public EMFModelLoader() {
		mofmm = ASMEMFModel.createMOF(this);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.ModelLoader#getMOF()
	 */
	public ASMModel getMOF() {
		return mofmm;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.ModelLoader#loadModel(java.lang.String, org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, java.io.InputStream)
	 */
	public ASMModel loadModel(String name, ASMModel metamodel, InputStream in) {
		ASMModel ret = null;

		try {
			ret = ASMEMFModel.loadASMEMFModel(name, (ASMEMFModel)metamodel, in, this);
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.ModelLoader#realLoadModel(java.lang.String, org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, java.lang.String)
	 */
	protected ASMModel realLoadModel(String name, ASMModel metamodel, String href) {
		ASMModel ret = null;

		try {
			ret = ASMEMFModel.loadASMEMFModel(name, (ASMEMFModel)metamodel, href, this);
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * @deprecated
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.ModelLoader#newModel(java.lang.String, org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel)
	 */
	public ASMModel newModel(String name, ASMModel metamodel) {
		ASMModel ret = null;

		try {
			ret = ASMEMFModel.newASMEMFModel(name, (ASMEMFModel)metamodel, this);
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.ModelLoader#newModel(java.lang.String, java.lang.String, org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel)
	 */
	public ASMModel newModel(String name, String uri, ASMModel metamodel) {
		ASMModel ret = null;

		try {
			ret = ASMEMFModel.newASMEMFModel(name, uri, (ASMEMFModel)metamodel, this);
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.ModelLoader#setParameter(java.lang.String, java.lang.Object)
	 */
	protected void setParameter(String name, Object value) {
		if ("useIDs".equals(name)) {
			if ("true".equals(value)) {
				useIDs = true;
			} else if ("false".equals(value)) {
				useIDs = false;
			}
		} else if ("removeIDs".equals(name)) {
			if ("true".equals(value)) {
				removeIDs = true;
			} else if ("false".equals(value)) {
				removeIDs = false;
			}
		} else if ("encoding".equals(name)) {
			encoding = (String)value;
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.ModelLoader#realSave(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, java.lang.String)
	 */
	protected void realSave(ASMModel model, String href) {
		Resource r = ((ASMEMFModel)model).getExtent();
		r.setURI(URI.createURI(href));

		if (useIDs || removeIDs) {
			XMIResource xr = (XMIResource)r;
			int id = 1;
			Set alreadySet = new HashSet();
			for (Iterator i = r.getAllContents(); i.hasNext();) {
				EObject eo = (EObject)i.next();
				if (alreadySet.contains(eo)) {
					continue; // because sometimes a single element gets processed twice
				}
				xr.setID(eo, removeIDs ? null : ("a" + (id++)));
				alreadySet.add(eo);
			}
		}
		try {
			Map options = new HashMap();
			options.put(XMIResource.OPTION_ENCODING, encoding);
			r.save(options);
		} catch (IOException e1) {
			ATLLogger.log(Level.SEVERE, e1.getLocalizedMessage(), e1);
		}
	}
}
