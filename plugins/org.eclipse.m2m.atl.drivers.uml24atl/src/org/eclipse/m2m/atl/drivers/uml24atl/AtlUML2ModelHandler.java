/*******************************************************************************
 * Copyright (c) 2004 INRIA and C-S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *    Christophe Le Camus (C-S) - initial API and implementation
 *    Sebastien Gabel (C-S) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.drivers.uml24atl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.drivers.emf4atl.AtlEMFModelHandler;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * The UML2 model handler.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 * @author <a href="mailto:christophe.le-camus@c-s.fr">Christophe Le Camus</a>
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien Gabel</a>
 */
public class AtlUML2ModelHandler extends AtlEMFModelHandler {

	/**
	 * Creates a new {@link AtlUML2ModelHandler}.
	 */
	public AtlUML2ModelHandler() {
		// change of default value inherited from AtlEMFModelHandler
		this.useIDs = true;
		this.mofmm = ASMUMLModel.createMOF(null);
	}
	
	/**
	 * {@inheritDoc} TODO GB : this method was not redefined initially. However, do we have to redirect all
	 * ways to save a model to handle UML2 specificities ?
	 * 
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.AtlEMFModelHandler#saveModel(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel,
	 *      java.lang.String, boolean)
	 */
	public void saveModel(final ASMModel model, String path, boolean outputFileIsInWorkspace) {
		URI uri = null;
		if (outputFileIsInWorkspace) {
			uri = URI.createURI(path);
		} else {
			uri = URI.createFileURI(path);
		}
		this.saveModel(model, uri, null);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.AtlEMFModelHandler#saveModel(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, org.eclipse.emf.common.util.URI, java.io.OutputStream)
	 */
	protected void saveModel(final ASMModel model, URI uri, OutputStream out) {
		((ASMUMLModel)model).applyDelayedInvocations();
		XMIResource r = (XMIResource)((ASMUMLModel)model).getExtent();

		if (uri != null) {
			r.setURI(uri);
		}
		r.setXMIVersion("2.1");

		Map options = new HashMap();
		options.put(XMIResource.OPTION_ENCODING, encoding);
		options.put(XMIResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.FALSE);
		options.put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		options.put(XMIResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
		useIDs = true;
		if ((useIDs || removeIDs) && (r instanceof XMIResource)) {
			XMIResource xr = (XMIResource)r;
			int id = 1;
			Set alreadySet = new HashSet();
			for (Iterator i = r.getAllContents(); i.hasNext();) {
				EObject eo = (EObject)i.next();
				if (alreadySet.contains(eo)) {
					continue; // because sometimes a single element gets
				}
				// processed twice
				xr.setID(eo, removeIDs ? null : ("a" + (id++)));
				alreadySet.add(eo);
			}
		}

		try {
			if (out != null) {
				r.save(out, options);
			} else {
				r.save(options);
			}
			// flag dirty file
			try {
				if (uri != null) {
					IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.path()));
					if (file.exists()) {
						file.setDerived(true);
					}
				}
			} catch (IllegalStateException e) {
				// workspace is closed
				ATLLogger.log(Level.FINE, e.getLocalizedMessage(), e);
			} catch (CoreException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
		} catch (IOException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.AtlEMFModelHandler#loadModel(java.lang.String, org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, java.io.InputStream)
	 */
	public ASMModel loadModel(String name, ASMModel metamodel, InputStream in) {
		ASMModel ret = null;

		try {
			ret = ASMUMLModel.loadASMUMLModel(name, (ASMUMLModel)metamodel, in, null);
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.AtlEMFModelHandler#newModel(java.lang.String, org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel)
	 */
	public ASMModel newModel(String name, ASMModel metamodel) {
		ASMModel ret = null;

		try { // OUT
			ret = ASMUMLModel.newASMUMLModel(name, (ASMUMLModel)metamodel, null);
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 *
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.AtlEMFModelHandler#newModel(java.lang.String, java.lang.String, org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel)
	 */
	public ASMModel newModel(String name, String uri, ASMModel metamodel) {
		ASMModel ret = null;

		try {
			ret = ASMUMLModel.newASMUMLModel(name, uri, (ASMUMLModel)metamodel, null);
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.AtlEMFModelHandler#getBuiltInMetaModel(java.lang.String)
	 */
	public ASMModel getBuiltInMetaModel(String name) {
		ASMModel ret = null;

		return ret;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.AtlEMFModelHandler#isHandling(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel)
	 */
	public boolean isHandling(ASMModel model) {
		return model instanceof ASMUMLModel;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.AtlEMFModelHandler#loadModel(java.lang.String, org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, java.lang.String)
	 */
	public ASMModel loadModel(String name, ASMModel metamodel, String uri) {
		ASMModel ret = null;
		// entry point
		try { // UML2
			ret = ASMUMLModel.loadASMUMLModel(name, (ASMUMLModel)metamodel, uri, null);
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.AtlEMFModelHandler#loadModel(java.lang.String, org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, org.eclipse.emf.common.util.URI)
	 */
	public ASMModel loadModel(String name, ASMModel metamodel, URI uri) {
		ASMModel ret = null;
		// PRO
		try {
			ret = ASMUMLModel.loadASMUMLModel(name, (ASMUMLModel)metamodel, uri, null);
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		return ret;
	}
}
