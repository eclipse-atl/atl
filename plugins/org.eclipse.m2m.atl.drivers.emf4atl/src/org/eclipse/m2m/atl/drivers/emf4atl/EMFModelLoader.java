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
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.eclipse.gmt.tcs.injector.TCSInjector;
import org.eclipse.m2m.atl.engine.injectors.xml.XMLInjector;
import org.eclipse.m2m.atl.engine.vm.ATLVMPlugin;
import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMString;
import org.osgi.framework.Bundle;

/**
 * Loads EMF models into a {@link ResourceSet}. Make sure to use the same
 * model loader for all EMF models used in a model transformation!
 * Use different model loaders for different threads.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class EMFModelLoader extends ModelLoader {
	
	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);

	protected static Bundle bundle = Platform.getBundle("org.eclipse.m2m.atl.drivers.emf4atl"); //$NON-NLS-1$
	
	protected static URI mofURI = EcorePackage.eINSTANCE.eResource().getURI();
	
	protected static String atlURI = "uri:http://www.eclipse.org/gmt/2005/ATL";

	protected ResourceSet resourceSet;

	protected static ASMModel atlmm = null;
	
	protected Map bimm = new HashMap();
	
	protected boolean useIDs = false;

	protected boolean removeIDs = false;

	protected String encoding = "ISO-8859-1"; //$NON-NLS-1$
	
	protected Map saveOptions = new HashMap();
	
	private static int instanceCount = 0;
	
	/**
	 * EMFModelLoader constructor.
	 */
	public EMFModelLoader() {
		resourceSet = new ResourceSetImpl();
		// see http://www.eclipse.org/modeling/emf/docs/performance/EMFPerformanceTips.html
		Map loadOptions = resourceSet.getLoadOptions();
		loadOptions.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
		loadOptions.put(XMLResource.OPTION_USE_PARSER_POOL, new XMLParserPoolImpl());
		// add injectors
		addInjector("xml", XMLInjector.class); //$NON-NLS-1$
		addInjector("ebnf2", TCSInjector.class); //$NON-NLS-1$
		if (Platform.isRunning()) {
			//no IExtensionRegistry supported outside Eclipse
			IExtensionRegistry registry = Platform.getExtensionRegistry();
	        if (registry != null) {
				IExtensionPoint point = registry.getExtensionPoint("org.eclipse.m2m.atl.engine.injector");//$NON-NLS-1$
		
				IExtension[] extensions = point.getExtensions();		
				for(int i = 0 ; i < extensions.length ; i++){		
					IConfigurationElement[] elements = extensions[i].getConfigurationElements();
					for(int j = 0 ; j < elements.length ; j++){
						try {
							addInjector(elements[j].getAttribute("name"), elements[j].createExecutableExtension("class").getClass());//$NON-NLS-1$//$NON-NLS-2$
						} catch (CoreException e){
							logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
						}				
					}
				 }
	        }
		}
		saveOptions.put(XMIResource.OPTION_ENCODING, encoding);
		instanceCount++;
		logger.fine(this + " created (" + instanceCount + ")");
	}

	/**
	 * @return The internal {@link ResourceSet} that contains all models
	 * explicitly loaded by this loader.
	 */
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.ModelLoader#getMOF()
	 */
	public ASMModel getMOF() {
		return ASMEMFModel.getMOF();
	}

	public ASMModel getATL() {
		if (atlmm == null) {
			try {
				atlmm = loadModel("ATL", getMOF(), atlURI);
			} catch (IOException e) {
				logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
		}
		return atlmm;
	}
	
	/**
	 * @param name
	 *            the model name
	 * @param extent
	 *            the resource extent
	 * @param metamodel
	 *            the metamodel
	 * @param isTarget
	 *            true if the model is a target model
	 * @return a new ASMEMFModel with this ModelLoader.
	 */
	protected ASMEMFModel createASMEMFModel(String name, Resource extent, ASMModel metamodel, boolean isTarget) {
		return new ASMEMFModel(name, extent, (ASMEMFModel)metamodel, isTarget, this);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.ModelLoader#loadModel(java.lang.String, org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, java.io.InputStream)
	 */
	public ASMModel loadModel(String name, ASMModel metamodel, InputStream in)
			throws IOException {
		ASMEMFModel ret = null;
		
        final Resource extent = resourceSet.createResource(URI.createURI(name));
		extent.load(in, resourceSet.getLoadOptions());
        ret = createASMEMFModel(name, extent, metamodel, true);
   		adaptMetamodel(ret, (ASMEMFModel)metamodel);
   		ret.setIsTarget(false);
		
		loadedModels.put(name, ret);
		return ret;
	}
	
	public ASMEMFModel loadModel(String name, ASMModel metamodel, URI uri)
			throws IOException {
		ASMEMFModel ret = null;
		
		if (mofURI.equals(uri)) {
			ret = (ASMEMFModel) getMOF();
		} else {
			final Resource extent = resourceSet.getResource(uri, true);
			ret = createASMEMFModel(name, extent, metamodel, true);
    		adaptMetamodel(ret, (ASMEMFModel)metamodel);
			ret.setIsTarget(false);
		}

		loadedModels.put(name, ret);
		return ret;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.ModelLoader#realLoadModel(java.lang.String, org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, java.lang.String)
	 */
	protected ASMModel realLoadModel(String name, ASMModel metamodel, String href) {
		ASMEMFModel ret = null;
		
		try {
			if(href.startsWith("uri:")) {
				//only initialise on demand (after loading instance of this metamodel)
				String uri = href.substring(4);
				if (mofURI.toString().equals(uri)) {
					ret = (ASMEMFModel) getMOF();
				} else {
					ret = createASMEMFModel(name, null, metamodel, false);
					ret.resolveURI = uri;
				}
			} else {
				ret = loadModel(name, metamodel, URI.createURI(href));
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
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
		return newModel(name, name, metamodel);
	}

	public ASMModel newModel(String name, String uri, ASMModel metamodel) {
		ASMEMFModel ret = null;
		
        Resource extent = resourceSet.createResource(URI.createURI(uri));
        ret = createASMEMFModel(name, extent, metamodel, true);

		loadedModels.put(name, ret);
		return ret;
	}
	
	public ASMModel getBuiltInMetaModel(String name) {
		ASMModel ret = (ASMModel)bimm.get(name);

		if(ret == null) {
			URL resource = null;
			if (bundle == null) {
				resource = EMFModelLoader.class.getResource(
						"../../../../../../resources/" + name + ".ecore"); //$NON-NLS-1$ //$NON-NLS-2$
			} else {
				resource = bundle.getResource("resources/" + name + ".ecore"); //$NON-NLS-1$ //$NON-NLS-2$
			}

			try {
				ret = loadModel(name, getMOF(), resource.openStream());
			} catch (IOException e) {
				logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
			bimm.put(name, ret);
		}

		loadedModels.put(name, ret);
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
	protected void realSave(ASMModel model, String href)
			throws IOException {
		Resource r = ((ASMEMFModel)model).getExtent();
		if (href != null) {
			r.setURI(URI.createURI(href));
		}
		
		if(useIDs || removeIDs) {
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
			r.save(saveOptions);
			final URI uri = r.getURI();
			if (uri != null) {
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.path()));
				if (file.exists()) {
					file.setDerived(true);
				}
			}
		} catch (IllegalStateException e) {
			// workspace is closed
			throw new IOException(e.getLocalizedMessage());
		} catch (CoreException e) {
			throw new IOException(e.getLocalizedMessage());
		}
	}
	
	/**
	 * Adapts model if its metamodel is MOF, such that its NsURI is registered
	 * and primitive datatypes are mapped to Java types.
	 * @param model
	 * @param metamodel
	 * @throws IOException
	 */
	protected void adaptMetamodel(ASMEMFModel model, ASMEMFModel metamodel)
			throws IOException {
		final ASMModel mofmm = model.getModelLoader().getMOF();
		if (metamodel == mofmm) {
			for (Iterator i = model.getAllElementsByType("EPackage").iterator(); i
					.hasNext();) {
				ASMEMFModelElement ame = (ASMEMFModelElement) i.next();
				EPackage p = (EPackage) ame.getObject();
				String nsURI = p.getNsURI();
				if (nsURI == null) {
					nsURI = p.getName();
					p.setNsURI(nsURI);
				} else if (mofURI.toString().equals(nsURI)) {
					if (!((ASMEMFModel)getMOF()).getExtent().equals(p.eResource())) {
						throw new IOException("Cannot overload Ecore");
					}
				}
				synchronized (resourceSet) {
					resourceSet.getPackageRegistry().put(nsURI, p);
				}
			}
			for (Iterator i = model.getAllElementsByType("EDataType").iterator(); i
					.hasNext();) {
				ASMEMFModelElement ame = (ASMEMFModelElement) i.next();
				String tname = ((ASMString) ame.get(null, "name")).getSymbol();
				String icn = null;
				if (tname.equals("Boolean")) {
					icn = "boolean"; // "java.lang.Boolean";
				} else if (tname.equals("Double")) {
					icn = "java.lang.Double";
				} else if (tname.equals("Float")) {
					icn = "java.lang.Float";
				} else if (tname.equals("Integer")) {
					icn = "java.lang.Integer";
				} else if (tname.equals("String")) {
					icn = "java.lang.String";
				}
				if (icn != null)
					ame.set(null, "instanceClassName", new ASMString(icn));
			}
		}
	}
	
	public void finalize() {
		instanceCount--;
		logger.fine(this + " is being collected (" + instanceCount + ") : " + resourceSetToString(resourceSet));
		for (Iterator it = resourceSet.getResources().iterator(); it.hasNext();) {
			Resource r = (Resource) it.next();
			it.remove();
			finalizeResource(r);
			logger.fine(r + " is removed");
		}
	}
	
	/**
	 * Finalizes r. This implementation does nothing, but allows for overriding
	 * in subclasses.
	 * @param r
	 */
	protected void finalizeResource(Resource r) {
		//do nothing
	}
	
	private static String resourceSetToString(ResourceSet rs) {
		List ret = new ArrayList();
		for (Iterator i = rs.getResources().iterator(); i.hasNext();) {
			Resource r = (Resource) i.next();
			ret.add(r.getURI().lastSegment());
		}
		return ret.toString();
	}

	public void unload(ASMModel model) {
		if (model instanceof ASMEMFModel) {
			final ASMEMFModel emfmodel = (ASMEMFModel) model;
			final Resource r = emfmodel.getExtent();
			final EList rs = resourceSet.getResources();
			if (rs.contains(r)) {
				loadedModels.remove(model.getName());
				rs.remove(r);
				finalizeResource(r);
			}
		}
	}

}
