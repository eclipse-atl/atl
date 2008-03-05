/*******************************************************************************
 * Copyright (c) 2008 Obeo.
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
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Utility class for outputting wiki code.
 * 
 * @author William Piers <a href="mailto:william.piers@obeo.fr">william.piers@obeo.fr</a>
 */
public class WikiOutputter {

	private final static String testsPath = "results/tests.properties";
	private final static String headerPath = "results/header.txt";
	private final static String wikiPath = "results/wiki_table.txt";
	private final static String bottomPath = "results/bottom.txt";
	private final static String emfvmDataPath = "results/EMFVM_results.xml";
	private final static String vmDataPath = "results/VM_results.xml";

	private static Map directories = new HashMap();

	/**
	 * This is a simple main which attempts to simplificate the management of 
	 * the results. Launch, then copy an past the "wiki_table.txt" file into
	 * this : http://wiki.eclipse.org/ATL_VM_Testing#Non-regression_tests
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Map vmResults = initResults(vmDataPath);
			Map emfVMResults = initResults(emfvmDataPath);

			FileWriter fw = new FileWriter(wikiPath);

			fw.write(getFragment(headerPath));
			Properties tests = new Properties();
			FileInputStream fis = new FileInputStream(new File(testsPath));
			tests.load(fis);
			for (Iterator iterator = tests.entrySet().iterator(); iterator.hasNext();) {
				Entry test = (Entry) iterator.next();
				String testName = (String) test.getKey();
				String comment = (String) test.getValue(); 
				String emfVMTime = (String) emfVMResults.get(testName);
				String vmTime = (String) vmResults.get(testName);
				String directory = (String) directories.get(testName);
				if (directory != null) {
					fw.write("|-\n");
					fw.write("! colspan=1 | [http://dev.eclipse.org/viewcvs/index.cgi/org.eclipse.m2m/org.eclipse.m2m.atl/tests"+directory.replaceAll("\\\\","/")+"?root=Modeling_Project "+testName+"]\n");
					fw.write("! colspan=1 | <b style=\"color:green\">PASS</b>\n");
					fw.write("! colspan=1 | "+vmTime+"s.\n");
					fw.write("! colspan=1 | "+emfVMTime+"s.\n");
					fw.write("! colspan=1 | "+comment+"\n");
				}
			}
			fw.write("|-\n");
			fw.write("! colspan=2 | Total time : \n");
			fw.write("! colspan=1 | "+new Double((String)vmResults.get("TOTAL")).floatValue()+"s.\n");
			fw.write("! colspan=1 | "+new Double((String)emfVMResults.get("TOTAL")).floatValue()+"s.\n");
			fw.write("|}\n\nTests realized on "+new Date()+" with :\n");
			fw.write(getFragment(bottomPath));
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Map initResults(String path) throws Exception {
		Map res= new HashMap();
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.parse (new File(path));
		Element rootElement = doc.getDocumentElement();
		NodeList childs = rootElement.getChildNodes();
		for (int i = 0; i < childs.getLength(); i++) {
			Node node = (Node) childs.item(i);
			if (node instanceof Element) {
				Element element = (Element) node;
				String name = element.getAttribute("name");
				res.put(name, element.getAttribute("time"));
				if (directories.get(name) == null) {
					directories.put(name, element.getAttribute("directory"));
				}				
			}
		}
		return res;
	}

	private static String getFragment(String path) throws Exception {
		StringBuffer content = new StringBuffer();
		BufferedReader reader = new BufferedReader(
				new FileReader(path));
		char[] buf = new char[1024];
		int numRead=0;
		while((numRead=reader.read(buf)) != -1){
			String readData = String.valueOf(buf, 0, numRead);
			content.append(readData);
			buf = new char[1024];
		}
		reader.close();
		return content.toString();
	}

}
