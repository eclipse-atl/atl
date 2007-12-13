/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.service.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmt.tcs.extractor.TCSExtractor;
import org.eclipse.gmt.tcs.injector.TCSInjector;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModelElement;
import org.eclipse.m2m.atl.engine.AtlEMFModelHandler;
import org.eclipse.m2m.atl.engine.AtlModelHandler;
import org.eclipse.m2m.atl.engine.MarkerMaker;
import org.eclipse.m2m.atl.engine.extractors.xml.XMLExtractor;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMEnumLiteral;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.service.core.exception.ServiceException;
import org.eclipse.osgi.util.ManifestElement;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;

/**
 * This class provides a set of util methods
 * @author Freddy Allilaire
 *
 */
public class ServiceTransformationUtil {

	public static final String XMLExtractor = "XML";
	public static final String XMIExtractor = "XMI";
	public static final String EBNFExtractor = "EBNF";
	
	public static URL getURLFromASMFile(String filePath, String pluginId) throws ServiceException {
		URL tPlatform = Platform.getBundle(pluginId).getEntry(filePath);
		try {
			return FileLocator.toFileURL(tPlatform);
		} catch (IOException e) {
			throw new ServiceException(IStatus.CANCEL, e);
		}
	}
	
	public static ASMModel loadModel(AtlModelHandler amh, String modelName, ASMModel metamodel, String path, String nsUri, boolean isM3, boolean inWorkspace, String pluginId) throws ServiceException {
		ASMModel ret = null;
		
		if((amh instanceof AtlEMFModelHandler))
			if (isM3)
				ret = amh.getMof();
			else if(nsUri != null && !nsUri.equals(""))
				// TODO delete pre-string 'uri:'
				ret = ((AtlEMFModelHandler)amh).loadModel(modelName, metamodel, "uri:" + nsUri);
			else if (inWorkspace)
				ret = ((AtlEMFModelHandler)amh).loadModel(modelName, metamodel, URI.createPlatformResourceURI(path));
			else {
				try {
					Bundle bundle = Platform.getBundle(pluginId);
					if (bundle == null)
						throw new ServiceException(IStatus.ERROR, "Plugin " + pluginId + " is not available.");
					URL urlFile = bundle.getEntry(path);
					if (urlFile == null)
						throw new ServiceException(IStatus.ERROR, "File " + path + " not found in the plugin " + pluginId + ".");
					InputStream in = urlFile.openStream();
					ret = ((AtlEMFModelHandler)amh).loadModel(modelName, metamodel, in);
				} catch (IOException e) {
					throw new ServiceException(IStatus.ERROR, e);
				}
			}
		else
			throw new ServiceException(IStatus.CANCEL, "Other model handlers are not available for the moment.");

		return ret;
	}
	
	public static void xmlExtraction(final ASMModel model, String path, AtlModelHandler amh) {
		try {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));
			
			PipedInputStream in = new PipedInputStream();
			final OutputStream out = new PipedOutputStream(in);
			
			final Map parameters = Collections.EMPTY_MAP;

			final XMLExtractor xmle = new XMLExtractor();

			new Thread() {
				public void run() {
					try {
						xmle.extract(model, out, parameters);
					} catch(Exception e) {
						e.printStackTrace();
					} finally {
						try {
							out.close();
						} catch(IOException ioe) {
							
						}
					}
				}
			}.start();
			if(file.exists())
				file.setContents(in, IFile.FORCE, null);
			else
				file.create(in, IFile.FORCE, null);
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public static void ebnfExtraction(final ASMModel model, String path, AtlModelHandler amh, Map params) {
		try {
			PipedInputStream in = new PipedInputStream();
			final OutputStream out = new PipedOutputStream(in);
			
			final TCSExtractor ebnfe = new TCSExtractor();
			
			ASMModel TCS = loadModel(AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF), "TCS", AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF).getMof(), "resources/TCS.ecore", null, false, false, "org.eclipse.m2m.atl.service.core");
			
			Map tempParam = new HashMap();

			tempParam.put("format", loadModel(amh, "model.tcs", TCS, (String)params.get("path"), null, false, false, (String)params.get("pluginId")));
			
			for (Iterator it = params.keySet().iterator(); it.hasNext();) {
				String paramName = (String)it.next();
				String paramType = (String)ebnfe.getParameterTypes().get(paramName);
				if (paramType != null && paramType.equals("String"))
					tempParam.put(paramName, params.get(paramName));
			}

			final Map parameters = tempParam;

			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));
			
			new Thread() {
				public void run() {
					try {
						ebnfe.extract(model, out, parameters);
					} catch(Exception e) {
						e.printStackTrace();
					} finally {
						try {
							out.close();
						} catch(IOException ioe) {
							
						}
					}
				}
			}.start();
			if(file.exists())
				file.setContents(in, IFile.FORCE, null);
			else
				file.create(in, IFile.FORCE, null);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	public static ASMModel ebnfInjection(String name, String filePath, AtlModelHandler amh, ASMModel metamodel, Map params, String parserPath, String metamodelName, String pluginId)  {

		try {
			InputStream in = Platform.getBundle(pluginId).getEntry(filePath).openStream();
			
			ASMModel model = amh.newModel(name, metamodel);
			TCSInjector ebnfi = new TCSInjector();
			
			ClassLoader oldCl = Thread.currentThread().getContextClassLoader();
			JarClassLoader loader = createLoader(pluginId, parserPath, oldCl);

			Class lexer = loader.loadClass2("org.eclipse.gmt.tcs.injector." + metamodelName + "Lexer", true);
			Class parser = loader.loadClass2("org.eclipse.gmt.tcs.injector." + metamodelName + "Parser", true);

			ebnfi.performImportation(metamodel, model, in, metamodelName, lexer, parser);
			
			in.close();
			
			return model;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	catch (IOException e1) {
			System.err.println(e1);
		}
		
		return null;
	}

	private static JarClassLoader createLoader(String pluginId, String parserPath, ClassLoader parent) {
		try {
			URL url = Platform.getBundle(pluginId).getEntry("/");
			String urlString = url.toString();

			LinkedList list = new LinkedList();
			String requires = (String)Platform.getBundle(pluginId).getHeaders().get(Constants.BUNDLE_CLASSPATH);

			if (requires == null)
				requires = parserPath;
			else if	(requires.indexOf(parserPath) == -1)
				requires += "," + parserPath;

			ManifestElement[] elements = ManifestElement.parseHeader(Constants.BUNDLE_CLASSPATH, requires);
			for (int i = 0; i < elements.length; i++) {
				ManifestElement element = elements[i];
				String libPathStr = element.getValue();
				String libUrlStr = urlString + libPathStr;
				URL libUrl = new URL(libUrlStr);
				list.add(libUrl);
			}
			URL[] libUrls = (URL[]) list.toArray(new URL[list.size()]);
			
			return new JarClassLoader(libUrls, parent);
		} catch (BundleException e) {
			e.printStackTrace();
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		}
		return null;
	}
	
	public static int applyMarkers(String path, ASMModel pbs) throws CoreException {
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));
		MarkerMaker markerMaker = new MarkerMaker();

		int nbErrors = 0;
		
		Collection pbsc = pbs.getElementsByType("Problem");
		EObject pbsa[] = new EObject[pbsc.size()];
		int k = 0;
		for(Iterator i = pbsc.iterator() ; i.hasNext() ; ) {
			ASMEMFModelElement ame = (ASMEMFModelElement)i.next();
			pbsa[k] = ame.getObject();
			if("error".equals(((ASMEnumLiteral)ame.get(null, "severity")).getName())) {
				nbErrors++;
			}
			k++;
		}
		markerMaker.resetPbmMarkers(file, pbsa);
		
		return nbErrors;
	}
	
}
