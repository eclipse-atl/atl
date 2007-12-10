/*******************************************************************************
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - ATL compatibility converter
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.perspective.compatibility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * An utility class for old ATL projects conversion.
 * 
 * @author William Piers <a href="mailto:william.piers@obeo.fr">william.piers@obeo.fr</a>
 */
public class CompatibilityUtils {

	private static final String oldNatureId = "org.atl.eclipse.adt.builder.atlNature";
	private static final String newNatureId = "org.eclipse.m2m.atl.adt.builder.atlNature";

	private static final String oldBuilderId = "org.atl.eclipse.adt.builder.atlBuilder";
	private static final String newBuilderId = "org.eclipse.m2m.atl.adt.builder.atlBuilder";

	private static final String oldConfigId = "org.atl.eclipse.adt.launching.atlTransformation";
	private static final String newConfigId = "org.eclipse.m2m.atl.adt.launching.atlTransformation";

	/**
	 * @return
	 * @throws CoreException
	 */
	public static IProject[] getProjects() throws CoreException {
		List res = new ArrayList();
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (int i = 0; i < projects.length; i++) {
			IProject project = projects[i];
			if (project.isOpen()) {
				String[] ids = project.getDescription().getNatureIds();
				if (arrayContains(ids, oldNatureId) && ! arrayContains(ids, newNatureId)) {
					res.add(project);	
				}
			}
		}
		return (IProject[]) res.toArray(new IProject[res.size()]);		
	}

	private static boolean arrayContains(Object[] array,Object o){
		for (int i = 0; i < array.length; i++) {
			if (o.equals(array[i]))	return true;
		}
		return false;
	}
	
	/**
	 * @param projects
	 * @throws CoreException
	 */
	public static void convertProjects(Object[] projects) throws Exception {
		for (int i = 0; i < projects.length; i++) {
			IProject project = (IProject) projects[i];

			IProjectDescription desc = project.getDescription();
			ICommand[] commands = desc.getBuildSpec();
			String[] natures = desc.getNatureIds();
			
			ICommand[] newCommands = new ICommand[commands.length];
			for (int j = 0; j < commands.length; j++) {
				ICommand command = commands[j];
				if (command.getBuilderName().equals(oldBuilderId)) {
					command.setBuilderName(newBuilderId);					
				}
				newCommands[j] = command;
			}		
			desc.setBuildSpec(newCommands);
			
			String[] newNatures = new String[natures.length];
			for (int j = 0; j < natures.length; j++) {
				String nature = natures[j];
				if (nature.equals(oldNatureId)) {
					nature = newNatureId;					
				}
				newNatures[j] = nature;
			}
			desc.setNatureIds(newNatures);
			
			project.setDescription(desc, IProject.AVOID_NATURE_CONFIG, null);

			IResource[] members = project.members();
			for (int j = 0; j < members.length; j++) {
				IResource resource = members[j];
				if ((resource instanceof IFile) && (resource.getName().endsWith(".launch"))) {
					convertConfig(resource.getLocation().toFile());
				}
			}

			project.refreshLocal(IProject.DEPTH_INFINITE,null);
		}
	}

	/**
	 * @param configurations
	 */
	private static void convertConfig(File file) throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		try {
			Document document = docBuilder.parse(file);		

			Element root = (Element) document.getFirstChild();
			if (root.getAttribute("type").equals(oldConfigId)) {
				root.setAttribute("type", newConfigId);
			}

			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			StreamResult result = new StreamResult(file);
			DOMSource source = new DOMSource(document);
			transformer.transform(source, result);
		} catch (Throwable e) {
			// nothing, if not valid, the config is not converted
		}
	}

}
