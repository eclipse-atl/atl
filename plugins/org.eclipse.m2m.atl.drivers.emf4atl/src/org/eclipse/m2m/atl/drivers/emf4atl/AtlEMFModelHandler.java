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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.gmt.tcs.injector.TCSInjector;
import org.eclipse.m2m.atl.ATLPlugin;
import org.eclipse.m2m.atl.engine.injectors.xml.XMLInjector;
import org.eclipse.m2m.atl.engine.vm.AtlModelHandler;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * The model handler dedicated to EMF.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class AtlEMFModelHandler extends AtlModelHandler {

	protected boolean useIDs;

	protected boolean removeIDs;

	protected String encoding = "ISO-8859-1"; //$NON-NLS-1$

	protected ASMEMFModel mofmm;

	protected ASMEMFModel atlmm;

	// we only use a ModelLoader to make sure ASMString.inject(...) can work
	protected EMFModelLoader ml;

	private Map bimm = new HashMap();

	/**
	 * Creates a new EMF model handler.
	 */
	public AtlEMFModelHandler() {
		URL atlurl = ATLPlugin.class.getResource("resources/ATL-0.2.ecore"); //$NON-NLS-1$

		ml = new EMFModelLoader();
		ml.addInjector("xml", XMLInjector.class); //$NON-NLS-1$
		ml.addInjector("ebnf2", TCSInjector.class); //$NON-NLS-1$

		if (Platform.isRunning()) {
			// no IExtensionRegistry supported outside Eclipse
			IExtensionRegistry registry = Platform.getExtensionRegistry();
			if (registry != null) {
				IExtensionPoint point = registry.getExtensionPoint("org.eclipse.m2m.atl.engine.vm.injector"); //$NON-NLS-1$

				IExtension[] extensions = point.getExtensions();
				for (int i = 0; i < extensions.length; i++) {
					IConfigurationElement[] elements = extensions[i].getConfigurationElements();
					for (int j = 0; j < elements.length; j++) {
						try {
							ml
									.addInjector(
											elements[j].getAttribute("name"), elements[j].createExecutableExtension("class").getClass()); //$NON-NLS-1$//$NON-NLS-2$
						} catch (CoreException e) {
							ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);

						}
					}
				}
			}
		}

		mofmm = (ASMEMFModel)ml.getMOF();
		// org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel.createMOF(ml);

		try {
			atlmm = ASMEMFModel.loadASMEMFModel("ATL", mofmm, atlurl, ml); //$NON-NLS-1$
		} catch (Exception e) {
			ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.AtlModelHandler#saveModel(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel,
	 *      org.eclipse.core.resources.IProject)
	 */
	public void saveModel(final ASMModel model, IProject project) {
		saveModel(model, model.getName() + ".ecore", project); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.AtlModelHandler#saveModel(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel,
	 *      java.lang.String, org.eclipse.core.resources.IProject)
	 */
	public void saveModel(final ASMModel model, String fileName, IProject project) {
		String uri = project.getFullPath().toString() + "/" + fileName; //$NON-NLS-1$
		saveModel(model, uri);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.AtlModelHandler#saveModel(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel,
	 *      java.lang.String)
	 */
	public void saveModel(final ASMModel model, String uri) {
		if (uri.startsWith("ext:")) {
			File f = new File(uri.substring(4));
			try {
				saveModel(model, null, new FileOutputStream(f));
			} catch (FileNotFoundException e) {
				ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
		}
		saveModel(model, URI.createURI(uri), null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.AtlModelHandler#saveModel(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel,
	 *      java.io.OutputStream)
	 */
	public void saveModel(final ASMModel model, OutputStream out) {
		saveModel(model, null, out);
	}

	/**
	 * Saves the provided model in/out of the Eclipse workspace using the given relative/absolute path.
	 * 
	 * @param model
	 *            The model to save.
	 * @param path
	 *            The workspace relative path (e.g. "/ProjectXXX/fileName.ecore") if the
	 *            outputFileIsInWorkspace boolean is set to true, or the absolute path if not (e.g.
	 *            "C:/FolderXXX/fileName.ecore").
	 * @param outputFileIsInWorkspace
	 *            Indicates if the model output file is stored into the Eclipse workspace.
	 * @author Hugo Bruneliere
	 */
	public void saveModel(final ASMModel model, String path, boolean outputFileIsInWorkspace) {
		URI uri = null;
		if (outputFileIsInWorkspace) {
			uri = URI.createURI(path);
		} else {
			uri = URI.createFileURI(path);
		}
		Resource r = ((ASMEMFModel)model).getExtent();
		r.setURI(uri);

		Map options = new HashMap();
		options.put(XMIResource.OPTION_ENCODING, encoding);
		options.put(XMIResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.FALSE);

		if ((useIDs || removeIDs) && (r instanceof XMIResource)) {
			XMIResource xr = (XMIResource)r;
			int id = 1;
			Set alreadySet = new HashSet();
			for (Iterator i = r.getAllContents(); i.hasNext();) {
				EObject eo = (EObject)i.next();
				if (alreadySet.contains(eo)) {
					continue; // because sometimes a single element gets processed twice
				}
				xr.setID(eo, removeIDs ? null : ("a" + (id++))); //$NON-NLS-1$
				alreadySet.add(eo);
			}
		}

		try {
			r.save(options);
			if (outputFileIsInWorkspace) {
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.path()));
				file.setDerived(true);
			}
		} catch (IOException e) {
			ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} catch (CoreException e) {
			ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	/**
	 * Saves a model.
	 * 
	 * @param model
	 *            the model to save
	 * @param uri
	 *            the model uri
	 * @param out
	 *            the output stream
	 */
	protected void saveModel(final ASMModel model, URI uri, OutputStream out) {
		Resource r = ((ASMEMFModel)model).getExtent();
		if (uri != null) {
			r.setURI(uri);
		}
		Map options = new HashMap();
		options.put(XMIResource.OPTION_ENCODING, encoding);
		options.put(XMIResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.FALSE);

		if ((useIDs || removeIDs) && (r instanceof XMIResource)) {
			XMIResource xr = (XMIResource)r;
			int id = 1;
			Set alreadySet = new HashSet();
			for (Iterator i = r.getAllContents(); i.hasNext();) {
				EObject eo = (EObject)i.next();
				if (alreadySet.contains(eo)) {
					continue; // because sometimes a single element gets processed twice
				}
				xr.setID(eo, removeIDs ? null : ("a" + (id++))); //$NON-NLS-1$
				alreadySet.add(eo);
			}
		}

		try {
			if (out != null) {
				r.save(out, options);
			} else {
				r.save(options);
			}

			try {
				if (uri != null) {
					IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.path()));
					if (file.exists()) {
						file.setDerived(true);
					}
				}
			} catch (IllegalStateException e) {
				// workspace is closed
				ATLPlugin.log(Level.FINE, e.getLocalizedMessage(), e);
			}
		} catch (IOException e1) {
			ATLPlugin.log(Level.SEVERE, e1.getLocalizedMessage(), e1);
		} catch (CoreException e) {
			ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	public ASMModel getMof() {
		return mofmm;
	}

	public ASMModel getAtl() {
		return atlmm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.AtlModelHandler#loadModel(java.lang.String,
	 *      org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, java.io.InputStream)
	 */
	public ASMModel loadModel(String name, ASMModel metamodel, InputStream in) {
		ASMModel ret = null;

		try {
			ret = ASMEMFModel.loadASMEMFModel(name, (ASMEMFModel)metamodel, in, ml);
		} catch (Exception e) {
			ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);

		}

		return ret;
	}

	/**
	 * Loads a model.
	 * 
	 * @param name
	 *            the model name
	 * @param metamodel
	 *            the metamodel
	 * @param uri
	 *            the uri
	 * @return the loaded {@link ASMModel}
	 */
	public ASMModel loadModel(String name, ASMModel metamodel, URI uri) {
		ASMModel ret = null;

		try {
			ret = ASMEMFModel.loadASMEMFModel(name, (ASMEMFModel)metamodel, uri, ml);
		} catch (Exception e) {
			ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);

		}

		return ret;
	}

	/**
	 * Loads a model.
	 * 
	 * @param name
	 *            the model name
	 * @param metamodel
	 *            the metamodel
	 * @param uri
	 *            the uri (as String)
	 * @return the loaded {@link ASMModel}
	 */
	public ASMModel loadModel(String name, ASMModel metamodel, String uri) {
		ASMModel ret = null;

		try {
			ret = ASMEMFModel.loadASMEMFModel(name, (ASMEMFModel)metamodel, uri, ml);
		} catch (Exception e) {
			ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);

		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @deprecated
	 * @see org.eclipse.m2m.atl.engine.AtlModelHandler#newModel(java.lang.String,
	 *      org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel)
	 */
	public ASMModel newModel(String name, ASMModel metamodel) {
		ASMModel ret = null;

		try {
			ret = ASMEMFModel.newASMEMFModel(name, (ASMEMFModel)metamodel, ml);
		} catch (Exception e) {
			ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);

		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 * @see org.eclipse.m2m.atl.engine.AtlModelHandler#newModel(java.lang.String, java.lang.String,
	 *      org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel)
	 */
	public ASMModel newModel(String name, String uri, ASMModel metamodel) {
		ASMModel ret = null;
		String uriToLoad = uri;
		if (uriToLoad == null) {
			uriToLoad = name;
		}

		try {
			ret = ASMEMFModel.newASMEMFModel(name, uriToLoad, (ASMEMFModel)metamodel, ml);
		} catch (Exception e) {
			ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);

		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.AtlModelHandler#getBuiltInMetaModel(java.lang.String)
	 */
	public ASMModel getBuiltInMetaModel(String name, URL mmurl) {
		ASMModel ret = (ASMModel)bimm.get(name);

		if (ret == null) {

			try {
				ret = loadModel(name, mofmm, mmurl.openStream());
			} catch (IOException e) {
				ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);

			}
			bimm.put(name, ret);
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.AtlModelHandler#isHandling(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel)
	 */
	public boolean isHandling(ASMModel model) {
		return model instanceof ASMEMFModel;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.AtlModelHandler#disposeOfModel(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel)
	 */
	public void disposeOfModel(ASMModel model) {
		((ASMEMFModel)model).dispose();
	}

	public static ResourceSet getResourceSet() {
		return ASMEMFModel.getResourceSet();
	}

}
