/*******************************************************************************
 * Copyright (c) 2007, 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - ATL compatibility converter
 *     Obeo - ATL compatibility converter
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.perspective.compatibility;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * This visitor updates the launch configuration id if the current resource is an 
 * old ATL launch configuration
 * 
 * @author Freddy Allilaire
 */
public class UpdateCompatibilityVisitor implements IResourceVisitor {

	private IProgressMonitor monitor;
	
	public UpdateCompatibilityVisitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}
	
	/**
	 * If the current resource is an old ATL launch configuration,
	 * its launch configuration ID is updated with the new value.
	 */
	public boolean visit(IResource resource) throws CoreException {
		String extension = resource.getFileExtension();
		monitor.subTask("Inspecting " + resource.getName());
		
		if (("launch").equals(extension)) {
		
			File file = resource.getLocation().toFile();
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder;

			try {
				docBuilder = factory.newDocumentBuilder();
				Document document = docBuilder.parse(file);

				Element root = (Element) document.getFirstChild();
				if (root.getAttribute("type").equals(CompatibilityUtils.oldConfigId)) {
					root.setAttribute("type", CompatibilityUtils.newConfigId);
					monitor.subTask("Updating ATL launch configuration ID of " + resource.getName());
				}

				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				StreamResult result = new StreamResult(file);
				DOMSource source = new DOMSource(document);
				transformer.transform(source, result);
				
			} catch (ParserConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Throwable e) {
				// nothing, if not valid, the config is not converted
			}
		}
		
		return true;
	}

}
