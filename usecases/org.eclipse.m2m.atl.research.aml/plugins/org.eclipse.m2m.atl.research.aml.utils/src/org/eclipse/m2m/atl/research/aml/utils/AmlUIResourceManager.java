/*******************************************************************************
 * Copyright (c) 2009 Ecole des Mines de Nantes.

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kelly Garces - initial API and implementation and/or initial documentation
 *******************************************************************************/ 

package org.eclipse.m2m.atl.research.aml.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;

/**
 * 
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a>
 *
 */
public class AmlUIResourceManager {
	
	public static AmlUIResourceManager manager;
	public static final String equalModelFolderName = "EqualModels";
	public static final String modelFolderName = "Models";
	public static final String metricFolderName = "Metrics";
	public static final String ATLFolderName = "ATL";//$NON-NLS-1$
	public static final String amlExtention = "aml";
	public static final String amwExtention = "amw";
	public static final String propertiesExtention = "properties";
	public static final String tableExtention = "table";
		
	public static AmlUIResourceManager getDefault() {
		if (manager == null) {
			return new AmlUIResourceManager();
		}
		
		return manager;
	}
	
	public void deleteFolder(IProject project, String path) throws CoreException {
		IFolder folder = project.getFolder(path);
		folder.delete(true, true, null);
	}
	
	public void deleteFile(IProject project, IPath path) throws CoreException {
		IFile file = project.getFile(path);
		file.delete(true, true, null);
	}
	
	public IFolder createFolder(IProject project, String path) throws CoreException {
		IFolder folder = project.getFolder(path);
		if(!folder.exists())
			folder.create(true, true, null);
		return folder;
	}

	public IFile createFile(IProject project, String path, InputStream in) throws CoreException {
		IFile file = project.getFile(path);
		if(!file.exists()) {
			file.create(in, true, null);
		}else {
			file.setContents(in, true, true, null);
		}
		return file;
	}
	
	public void saveCompiledFiles(Map<String, ByteArrayOutputStream> files, IProject project, IPath path){
		
		try{
			for (String fileName: files.keySet()) {
				IFile outFile = project.getFile(path.append(fileName));
				ByteArrayInputStream in = new ByteArrayInputStream(files.get(fileName).toByteArray());
				if(outFile.exists()) {
					outFile.setContents(in, IFile.FORCE, null);
				} else {
					outFile.create(in, IFile.FORCE, null);
				}
				
				outFile.setDerived(false);
			}
		}
		catch(CoreException e){
			new RuntimeException("Error creating a compiled file");
		}
	}
	
	public String getPath (IResource resource) {
		return getWsLocation(resource).append(resource.getFullPath()).toString();
	}
	
	public IPath getWsLocation (IResource resource) {
		IWorkspace ws= resource.getWorkspace();
		return ws.getRoot().getLocation();
	}
	
	public IFile getAmlFile (IProject project) throws AmlUIException {
	
	IFile amlFile = project.getFile(project.getName() + "." + AmlUIResourceManager.amlExtention);
	if(!amlFile.exists()){
		throw new AmlUIException(IStatus.ERROR, "There is not an AML strategy corresponding to the project");
	}
	return amlFile;
	}
	
	public IFile getTableFile (IProject project) throws AmlUIException {
		
		IFile tableFile = project.getFolder(metricFolderName).getFile(project.getName() + "." + AmlUIResourceManager.tableExtention);
		if(!tableFile.exists()){
			throw new AmlUIException(IStatus.ERROR, "There is not a matching metric table to the project");
		}
		return tableFile;
		}

}
