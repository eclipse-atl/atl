/*******************************************************************************
 * Copyright (c) 2004 INRIA and other.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.drivers.mdr4atl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;

import javax.jmi.reflect.RefObject;
import javax.jmi.reflect.RefPackage;
import javax.jmi.xmi.MalformedXMIException;

import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.netbeans.api.mdr.MDRepository;
import org.netbeans.api.xmi.XMIInputConfig;
import org.netbeans.api.xmi.XMIReader;
import org.netbeans.api.xmi.XMIReaderFactory;
import org.netbeans.api.xmi.XMIReferenceResolver;
import org.netbeans.api.xmi.XMIWriter;
import org.netbeans.api.xmi.XMIWriterFactory;

/**
 * Loads MDR models into a {@link MDRepository}. Uses a global model repository.
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class MDRModelLoader extends ModelLoader {
	
	private MDRepository rep;

	private XMIReader reader;

	private XMIWriter writer;

	private ASMModel atlmm = null;

	private Map bimm = new HashMap();

	private String xmiVersion = null;

	private String encoding = null;

	public MDRModelLoader() {
		rep = ASMMDRModel.rep;
		reader = XMIReaderFactory.getDefault().createXMIReader();
		writer = XMIWriterFactory.getDefault().createXMIWriter();
//		rep.getExtent("MOF");
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.ModelLoader#loadModel(java.lang.String, org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, java.io.InputStream)
	 */
	public ASMModel loadModel(String name, ASMModel metamodel, InputStream in)
			throws IOException {
		ASMMDRModel ret = (ASMMDRModel) newModel(name, metamodel);

		try {
			XMIInputConfig inputConfig = reader.getConfiguration();
			final XMIReferenceResolver originalReferenceResolver = inputConfig.getReferenceResolver();
			final Map elementByXmiId = new HashMap();
			final Map xmiIdByElement = new HashMap();
			inputConfig.setReferenceResolver(new XMIReferenceResolver() {

				public void register(String systemId, String xmiId, RefObject object) {
					elementByXmiId.put(xmiId, object);
					xmiIdByElement.put(object, xmiId);
					if(originalReferenceResolver != null)
						originalReferenceResolver.register(systemId, xmiId, object);
				}

				public void resolve(Client client, RefPackage extent, String systemId, XMIInputConfig configuration, Collection hrefs) throws MalformedXMIException, IOException {
					if(originalReferenceResolver != null)	// anyway, if we do nothing the default resolver will be used
						originalReferenceResolver.resolve(client, extent, systemId, configuration, hrefs);
				}
				
			});
			reader.read(in, null, ret.getPackage());
			inputConfig.setReferenceResolver(originalReferenceResolver);
			
			ret.elementByXmiId = elementByXmiId;
			ret.xmiIdByElement = xmiIdByElement;
		} catch(MalformedXMIException e) {
			throw new IOException(e.getLocalizedMessage());
		}
		ret.setIsTarget(false);
		ret.getAllAcquaintances();

		return ret;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.ModelLoader#realLoadModel(java.lang.String, org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, java.lang.String)
	 */
	protected ASMModel realLoadModel(String name, ASMModel metamodel, String href)
			throws IOException {
		ASMModel ret = null;

		final InputStream in = new File(href).toURI().toURL().openStream();
		ret = loadModel(name, metamodel, in);

		return ret;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.ModelLoader#newModel(java.lang.String, org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel)
	 */
	public ASMModel newModel(String name, ASMModel metamodel) {
		ASMModel ret = null;

		try {
	        RefPackage mextent = null;
	        String modifiedName = name;
	        int id = 0;
	        
	        while(rep.getExtent(modifiedName) != null) {
	            modifiedName = name + "_" + id++;
	        }
	        
	        if(metamodel.getName().equals("MOF")) {
	            mextent = rep.createExtent(modifiedName);
	        } else {
	            RefPackage mmextent = ((ASMMDRModel)metamodel).getPackage();
	            RefObject pack = null;
	            for(Iterator it = mmextent.refClass("Package").refAllOfClass().iterator() ; it.hasNext() ; ) {
	                pack = (RefObject)it.next();
	                if(pack.refGetValue("name").equals(metamodel.getName())) {
	                    break;
	                }
	            }       // mp now contains a package with the same name as the extent
	            // or the last package
	            mextent = rep.createExtent(modifiedName, pack);
	        }

	        ret = new ASMMDRModel(name, mextent, (ASMMDRModel)metamodel, true, this);
		} catch(Exception e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.ModelLoader#newModel(java.lang.String, java.lang.String, org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel)
	 */
	public ASMModel newModel(String name, String uri, ASMModel metamodel) {
		return newModel(name, (ASMMDRModel)metamodel);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.ModelLoader#setParameter(java.lang.String, java.lang.Object)
	 */
	protected void setParameter(String name, Object value) {
		if("xmiVersion".equals(name)) {
			xmiVersion = (String)value;
		} else if("encoding".equals(name)) {
			encoding = (String)value;
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.ModelLoader#realSave(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, java.lang.String)
	 */
	protected void realSave(ASMModel model, String href) throws IOException {
		OutputStream out = new FileOutputStream(href);
		save(model, out);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.ModelLoader#save(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, java.io.OutputStream)
	 */
	public void save(ASMModel model, OutputStream out) throws IOException {
		if(encoding != null) {
			writer.getConfiguration().setEncoding(encoding);
		}
		writer.write(out, ((ASMMDRModel)model).getPackage(), xmiVersion);
	}

	public ASMModel getMOF() {
		return ASMMDRModel.getMOF();
	}
	
	public ASMModel getATL() {
		if (atlmm == null) {
			final URL atlurl = MDRModelLoader.class.getResource("resources/ATL-0.2.xmi");//$NON-NLS-1$
			try {
				atlmm = loadModel("ATL", getMOF(), atlurl.openStream());//$NON-NLS-1$
			} catch (Exception e) {
				logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
		}
		return atlmm;
	}
	
	public ASMModel getBuiltInMetaModel(String name) {
		ASMModel ret = (ASMModel)bimm.get(name);

		if(ret == null) {
			URL mmurl = MDRModelLoader.class.getResource("resources/" + name + ".xmi");//$NON-NLS-1$//$NON-NLS-2$
			
			try {
				ret = loadModel(name, getMOF(), mmurl.openStream());
			} catch (IOException e) {
				logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
			bimm.put(name, ret);
		}

		return ret;
	}

	public void unload(ASMModel model) {
		if (model instanceof ASMMDRModel) {
			((ASMMDRModel)model).getPackage().refDelete();
		}
	}

}

