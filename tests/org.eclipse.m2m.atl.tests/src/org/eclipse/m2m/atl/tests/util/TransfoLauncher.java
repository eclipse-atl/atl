/*******************************************************************************
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - ATL tester
 *******************************************************************************/
package org.eclipse.m2m.atl.tests.util;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.m2m.atl.adt.launching.AtlVM;
import org.eclipse.m2m.atl.engine.AtlModelHandler;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Parse persisted launch configurations and run the ATL VM.
 * 
 * @author William Piers <a href="mailto:william.piers@obeo.fr">william.piers@obeo.fr</a>
 */
public class TransfoLauncher {

	//transformation parameters
	protected URL atlUrl;
	protected URL asmUrl;
	protected Map libsFromConfig;
	protected List superimpose;
	protected Map input;
	protected Map output;
	protected Map modelHandler;
	protected Map path;

	/**
	 * Parse the .launch files to set transformation parameters.
	 * 
	 * @param uri the .launch file uri
	 * @param testPath the base directory path
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	public void parseConfiguration(String uri) throws Exception {
		//static variables initialization
		libsFromConfig = new HashMap();
		superimpose = new ArrayList();
		input = new HashMap();
		output = new HashMap();
		modelHandler = new HashMap();
		path = new HashMap();

		//parsing configuration
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		Document document = docBuilder.parse(uri);			
		Element root = (Element) document.getFirstChild();
		NodeList nodeList = root.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node instanceof Element) {
				Element element = (Element) node;
				String key = element.getAttribute("key"); //$NON-NLS-1$
				if (key.equals("ATL File Name")) { //$NON-NLS-1$
					String asmFilePath = element.getAttribute("value"); //$NON-NLS-1$
					atlUrl = FileUtils.fileNameToURL(asmFilePath);
					if (asmFilePath.endsWith(".atl")) { //$NON-NLS-1$
						asmFilePath = asmFilePath.substring(0,asmFilePath.length() - 4)+".asm"; //$NON-NLS-1$
					}
					asmUrl = FileUtils.fileNameToURL(asmFilePath);
				} else if (key.equals("Superimpose")) { //$NON-NLS-1$
					NodeList entriesList = element.getChildNodes();
					for (int j = 0; j < entriesList.getLength(); j++) {
						Node nodeEntry = entriesList.item(j);
						if (nodeEntry instanceof Element) {
							Element entry = (Element) nodeEntry;
							URL moduleUrl = FileUtils.fileNameToURL(entry.getAttribute("value")); //$NON-NLS-1$
							superimpose.add(moduleUrl);
						}
					}				
				} else if (key.equals("Libs")) { //$NON-NLS-1$
					NodeList nodes = element.getChildNodes();
					for (int j = 0; j < nodes.getLength(); j++) {
						Node nodeEntry = nodes.item(j);
						if (nodeEntry instanceof Element) {
							Element entry = (Element) nodeEntry;
							libsFromConfig.put(entry.getAttribute("key"),FileUtils.fileNameToURL(entry.getAttribute("value")));			 //$NON-NLS-1$ //$NON-NLS-2$
						}
					}
				}
				else if (key.equals("Path")) { //$NON-NLS-1$
					for (int j = 0; j < element.getChildNodes().getLength(); j++) {
						Node nodeEntry = element.getChildNodes().item(j);
						if (nodeEntry instanceof Element) {
							Element entry = (Element) nodeEntry;
							path.put(entry.getAttribute("key"),entry.getAttribute("value"));			 //$NON-NLS-1$ //$NON-NLS-2$
						}
					}
				}			
				else if (key.equals("Input")) { //$NON-NLS-1$
					for (int j = 0; j < element.getChildNodes().getLength(); j++) {
						Node nodeEntry = element.getChildNodes().item(j);
						if (nodeEntry instanceof Element) {
							Element entry = (Element) nodeEntry;
							input.put(entry.getAttribute("key"),entry.getAttribute("value")); //$NON-NLS-1$ //$NON-NLS-2$
						}
					}
				}
				else if (key.equals("Output")) { //$NON-NLS-1$
					for (int j = 0; j < element.getChildNodes().getLength(); j++) {
						Node nodeEntry = element.getChildNodes().item(j);
						if (nodeEntry instanceof Element) {
							Element entry = (Element) nodeEntry;
							output.put(entry.getAttribute("key"),entry.getAttribute("value")); //$NON-NLS-1$ //$NON-NLS-2$
						}
					}
				}
				else if (key.equals("Model Handler")) { //$NON-NLS-1$
					for (int j = 0; j < element.getChildNodes().getLength(); j++) {
						Node nodeEntry = element.getChildNodes().item(j);
						if (nodeEntry instanceof Element) {
							Element entry = (Element) nodeEntry;
							modelHandler.put(entry.getAttribute("key"),entry.getAttribute("value"));			 //$NON-NLS-1$ //$NON-NLS-2$
						}
					}
				}
			}
		}
	}
	
	public Map getOutput() {
		return output;
	}

	public Map getPath() {
		return path;
	}

	public double run(String atlVMName) throws Exception {
		boolean checkSameModel = false;
		//model handler
		Map atlModelHandler = new HashMap();
		for (Iterator i = modelHandler.keySet().iterator(); i.hasNext();) {
			String currentModelHandler = (String)modelHandler.get(i.next());
			if (!atlModelHandler.containsKey(currentModelHandler) && !currentModelHandler.equals("")) //$NON-NLS-1$
				atlModelHandler.put(currentModelHandler, AtlModelHandler.getDefault(currentModelHandler));
		}

		Collection toDispose = new HashSet();

		Map inModel = AtlUtils.getSourceModels(input, path, modelHandler, atlModelHandler, checkSameModel, toDispose);
		Map outModel = AtlUtils.getTargetModels(output, path, modelHandler, atlModelHandler, inModel, checkSameModel, toDispose);

		Map models = new HashMap();

		for(Iterator i = inModel.keySet().iterator() ; i.hasNext() ; ) {
			String mName = (String)i.next();
			models.put(mName, inModel.get(mName));
		}

		for(Iterator i = outModel.keySet().iterator() ; i.hasNext() ; ) {
			String mName = (String)i.next();
			models.put(mName, outModel.get(mName));
		}
		
		AtlVM atlVM = AtlVM.getVM(atlVMName);		
		long startTime = System.currentTimeMillis();
		atlVM.launch(asmUrl, libsFromConfig, models, Collections.EMPTY_MAP, superimpose, Collections.EMPTY_MAP);
		long endTime = System.currentTimeMillis();
	

		// save output models
		for(Iterator i = output.keySet().iterator(); i.hasNext() ; ) {
			String mName = (String)i.next();
			ASMModel currentOutModel = (ASMModel) outModel.get(mName);
			String newPath = FileUtils.fileNameToURI((String) path.get(mName)).toString();	
			AtlModelHandler.getHandler(currentOutModel).saveModel(currentOutModel, newPath);
		}			

		for(Iterator i = toDispose.iterator() ; i.hasNext() ; ) {
			ASMModel model = (ASMModel)i.next();
			AtlModelHandler.getHandler(model).disposeOfModel(model);
		}
		
		return (endTime - startTime) / 1000.;
	}

	public URL getAtlURL(){
		return atlUrl;
	}

	public void setAsmUrl(URL asmUrl) {
		this.asmUrl = asmUrl;
	}
	
}