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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.m2m.atl.tests.AtlTestPlugin;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Parse persisted launch configurations and run the ATL VM.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class LaunchParser {

	// transformation parameters
	private URL atlUrl;

	private URL asmUrl;

	private Map libsFromConfig;

	private List superimpose;

	private Map input;

	private Map output;

	private Map modelHandler;

	private Map path;

	private Map options;

	private String convertPath(String pathParam) {
		if (!pathParam.startsWith("uri:") && !pathParam.startsWith("#")) {
			return AtlTestPlugin.getDefault().getBaseDirectory() + pathParam;
		}
		return pathParam;
	}

	/**
	 * Parse the .launch files to set transformation parameters.
	 * 
	 * @param launchPath
	 *            the base directory path
	 * @throws Exception
	 */
	public void parseConfiguration(String launchPath) throws IOException, ParserConfigurationException,
			SAXException {

		// static variables initialization
		libsFromConfig = new HashMap();
		superimpose = new ArrayList();
		input = new HashMap();
		output = new HashMap();
		modelHandler = new HashMap();
		path = new HashMap();
		options = new HashMap();

		// parsing configuration
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		Document document = docBuilder.parse(new File(launchPath));
		Element root = (Element)document.getFirstChild();
		NodeList nodeList = root.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node instanceof Element) {
				Element element = (Element)node;
				String key = element.getAttribute("key"); //$NON-NLS-1$
				if (element.getNodeName().equals("booleanAttribute")) {
					options.put(key, element.getAttribute("value"));
				} else if (key.equals("ATL File Name")) { //$NON-NLS-1$
					String asmFilePath = element.getAttribute("value"); //$NON-NLS-1$
					atlUrl = new URL("file:" + convertPath(asmFilePath));
					if (asmFilePath.endsWith(".atl")) { //$NON-NLS-1$
						asmFilePath = asmFilePath.substring(0, asmFilePath.length() - 4) + ".asm"; //$NON-NLS-1$
					}
					asmUrl = new URL("file:" + convertPath(asmFilePath));
				} else if (key.equals("Superimpose")) { //$NON-NLS-1$
					NodeList entriesList = element.getChildNodes();
					for (int j = 0; j < entriesList.getLength(); j++) {
						Node nodeEntry = entriesList.item(j);
						if (nodeEntry instanceof Element) {
							Element entry = (Element)nodeEntry;
							URL moduleUrl = new URL("file:" + convertPath(entry.getAttribute("value"))); //$NON-NLS-1$
							superimpose.add(moduleUrl);
						}
					}
				} else if (key.equals("Libs")) { //$NON-NLS-1$
					NodeList nodes = element.getChildNodes();
					for (int j = 0; j < nodes.getLength(); j++) {
						Node nodeEntry = nodes.item(j);
						if (nodeEntry instanceof Element) {
							Element entry = (Element)nodeEntry;
							libsFromConfig
									.put(
											entry.getAttribute("key"), new URL("file:" + convertPath(entry.getAttribute("value")))); //$NON-NLS-1$ //$NON-NLS-2$
						}
					}
				} else if (key.equals("Path")) { //$NON-NLS-1$
					for (int j = 0; j < element.getChildNodes().getLength(); j++) {
						Node nodeEntry = element.getChildNodes().item(j);
						if (nodeEntry instanceof Element) {
							Element entry = (Element)nodeEntry;
							path.put(entry.getAttribute("key"), convertPath(entry.getAttribute("value")));
						}
					}
				} else if (key.equals("Input")) { //$NON-NLS-1$
					for (int j = 0; j < element.getChildNodes().getLength(); j++) {
						Node nodeEntry = element.getChildNodes().item(j);
						if (nodeEntry instanceof Element) {
							Element entry = (Element)nodeEntry;
							input.put(entry.getAttribute("key"), entry.getAttribute("value")); //$NON-NLS-1$ //$NON-NLS-2$
						}
					}
				} else if (key.equals("Output")) { //$NON-NLS-1$
					for (int j = 0; j < element.getChildNodes().getLength(); j++) {
						Node nodeEntry = element.getChildNodes().item(j);
						if (nodeEntry instanceof Element) {
							Element entry = (Element)nodeEntry;
							output.put(entry.getAttribute("key"), entry.getAttribute("value")); //$NON-NLS-1$ //$NON-NLS-2$
						}
					}
				} else if (key.equals("Model Handler")) { //$NON-NLS-1$
					for (int j = 0; j < element.getChildNodes().getLength(); j++) {
						Node nodeEntry = element.getChildNodes().item(j);
						if (nodeEntry instanceof Element) {
							Element entry = (Element)nodeEntry;
							modelHandler.put(entry.getAttribute("key"), entry.getAttribute("value")); //$NON-NLS-1$ //$NON-NLS-2$
						}
					}
				}
			}
		}
	}

	public URL getAtlUrl() {
		return atlUrl;
	}

	public URL getAsmUrl() {
		return asmUrl;
	}

	public Map getLibsFromConfig() {
		return libsFromConfig;
	}

	public List getSuperimpose() {
		return superimpose;
	}

	public Map getInput() {
		return input;
	}

	public Map getOutput() {
		return output;
	}

	public Map getModelHandler() {
		return modelHandler;
	}

	public Map getPath() {
		return path;
	}

	public Map getOptions() {
		return options;
	}

	public void setAsmUrl(URL asmUrl) {
		this.asmUrl = asmUrl;
	}

}
