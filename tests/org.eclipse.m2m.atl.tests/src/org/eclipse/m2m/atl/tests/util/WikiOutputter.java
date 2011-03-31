/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - Wiki utilities
 *******************************************************************************/
package org.eclipse.m2m.atl.tests.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Utility class for outputting wiki code.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public final class WikiOutputter {

	private static final String TESTS_PATH = "results/tests.properties"; //$NON-NLS-1$

	private static final String HEADER_PATH = "results/header.txt"; //$NON-NLS-1$

	private static final String WIKI_PATH = "results/wiki_table.txt"; //$NON-NLS-1$

	private static final String BOTTOM_PATH = "results/bottom.txt"; //$NON-NLS-1$

	private static final String EMFVM_DATA_PATH = "results/EMFVM_results.xml"; //$NON-NLS-1$

	private static final String VM_DATA_PATH = "results/VM_results.xml"; //$NON-NLS-1$

	private static Map<String, String> directories = new HashMap<String, String>();

	/**
	 * Utility classes don't need to (and shouldn't) be instantiated.
	 */
	private WikiOutputter() {
		// prevents instantiation
	}

	/**
	 * This is a simple main which attempts to simplificate the management of the results. Launch, then copy
	 * an past the "wiki_table.txt" file into this :
	 * http://wiki.eclipse.org/ATL_VM_Testing#Non-regression_tests
	 * 
	 * @param args
	 *            unused
	 */
	public static void main(String[] args) {
		try {
			Map<String, String> vmResults = initResults(VM_DATA_PATH);
			Map<String, String> emfVMResults = initResults(EMFVM_DATA_PATH);

			FileWriter fw = new FileWriter(WIKI_PATH);

			fw.write(getFragment(HEADER_PATH));
			Properties tests = new Properties();
			FileInputStream fis = new FileInputStream(new File(TESTS_PATH));
			tests.load(fis);
			for (Iterator<Map.Entry<Object, Object>> iterator = tests.entrySet().iterator(); iterator.hasNext();) {
				Map.Entry<Object, Object> test = iterator.next();
				String testName = (String)test.getKey();
				String comment = (String)test.getValue();
				String emfVMTime = emfVMResults.get(testName);
				String vmTime = vmResults.get(testName);
				String directory = directories.get(testName);
				if (directory != null) {
					fw.write("|-\n"); //$NON-NLS-1$
					fw
							.write("! colspan=1 | [http://dev.eclipse.org/viewcvs/index.cgi/org.eclipse.m2m/org.eclipse.m2m.atl/tests" //$NON-NLS-1$
									+ directory.replaceAll("\\\\", "/") //$NON-NLS-1$ //$NON-NLS-2$
									+ "?root=Modeling_Project " //$NON-NLS-1$
									+ testName + "]\n"); //$NON-NLS-1$
					fw.write("! colspan=1 | <b style=\"color:green\">PASS</b>\n"); //$NON-NLS-1$
					fw.write("! colspan=1 | " + vmTime + "s.\n"); //$NON-NLS-1$ //$NON-NLS-2$
					fw.write("! colspan=1 | " + emfVMTime + "s.\n"); //$NON-NLS-1$ //$NON-NLS-2$
					fw.write("! colspan=1 | " + comment + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
			fw.write("|-\n"); //$NON-NLS-1$
			fw.write("! colspan=2 | Total time : \n"); //$NON-NLS-1$
			fw.write("! colspan=1 | " + new Double(vmResults.get("TOTAL")).floatValue() + "s.\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			fw.write("! colspan=1 | " + new Double(emfVMResults.get("TOTAL")).floatValue() + "s.\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			fw.write("|}\n\nTests realized on " + new Date() + " with :\n"); //$NON-NLS-1$ //$NON-NLS-2$
			fw.write(getFragment(BOTTOM_PATH));
			fw.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		} catch (SAXException e) {
			throw new RuntimeException(e);
		}
	}

	private static Map<String, String> initResults(String path) throws SAXException,
			ParserConfigurationException, IOException {
		Map<String, String> res = new HashMap<String, String>();
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(new File(path));
		Element rootElement = doc.getDocumentElement();
		NodeList childs = rootElement.getChildNodes();
		for (int i = 0; i < childs.getLength(); i++) {
			Node node = childs.item(i);
			if (node instanceof Element) {
				Element element = (Element)node;
				String name = element.getAttribute("name"); //$NON-NLS-1$
				res.put(name, element.getAttribute("time")); //$NON-NLS-1$
				if (directories.get(name) == null) {
					directories.put(name, element.getAttribute("directory")); //$NON-NLS-1$
				}
			}
		}
		return res;
	}

	private static String getFragment(String path) throws IOException {
		StringBuffer content = new StringBuffer();
		BufferedReader reader = new BufferedReader(new FileReader(path));
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			content.append(readData);
			buf = new char[1024];
		}
		reader.close();
		return content.toString();
	}

}
