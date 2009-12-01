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

package org.eclipse.m2m.atl.research.aml.builder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.engine.MarkerMaker;
import org.eclipse.m2m.atl.research.aml.engine.AmlCompiler;
import org.eclipse.m2m.atl.research.aml.engine.AmlEnginePlugin;
import org.eclipse.m2m.atl.research.aml.engine.AmlModelUtils;
import org.eclipse.m2m.atl.research.aml.utils.AmlUIResourceManager;

/**
 * 
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a>
 *
 */
public class AmlBuildVisitor implements IResourceVisitor {

	protected static Logger logger = Logger.getLogger(AmlEnginePlugin.LOGGER);

	private IProgressMonitor monitor;
	private MarkerMaker markerMaker = new MarkerMaker();

	private final static String oldInjectedAmlModel = ".old.xmi";

	public AmlBuildVisitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}

	/**
	 * Returns <code>true</code> if the file has changed since its last build
	 * <code>false</code> otherwise
	 * 
	 * @throws InterruptedException
	 */
	private boolean hasChanged(IFile resource) {
		long res1 = resource.getLocalTimeStamp();
		long res2 = getOldInjectedAml(resource).getLocalTimeStamp();
		boolean hasChanged = res1 > res2;
		return hasChanged;

	}

	/**
	 * @param resource
	 *            the resource for which to test whether it has an associated
	 *            generated folder
	 * @return <code>true</code> if the given resource has an associated
	 *         generated folder <code>false</code> otherwise
	 */
	private boolean hasOldInjectedAml(IFile strategy) {
		boolean flag = getOldInjectedAml(strategy).exists();
		return flag;
	}

	private boolean isStrategy(IFile resource) {
		String projectName = resource.getProject().getName() + "."
				+ AmlUIResourceManager.amlExtention;
		String resourceName = resource.getName();
		return projectName.equals(resourceName);
	}

	/**
	 * @param resource
	 *            the resource for which to test whether it has an associated
	 *            generated folder
	 * @return the generated folder associated to the aml file
	 */
	private IFile getOldInjectedAml(IFile resource) {
		return getSiblingFile(resource, resource.getName()
				+ oldInjectedAmlModel);

	}

	private IFile getPropertiesFile(IFile resource) {
		return getSiblingFile(resource, resource.getName().replaceAll(
				AmlUIResourceManager.amlExtention, "")
				+ AmlUIResourceManager.propertiesExtention);
	}

	/**
	 * looks for a file having the same name of resource but differing extension
	 * 
	 * @param resource
	 * @param fileNameSufix
	 * @return
	 */
	private IFile getSiblingFile(IFile resource, String fileName) {
		IProject project = resource.getProject();
		return project.getFile(fileName);
	}

	@Override
	public boolean visit(IResource resource) throws CoreException {

		if ((resource instanceof IFile)
				&& isStrategy((IFile) resource)
				&& (((IFile) resource).getLocation().toFile().length() > 0)
				&& (!hasOldInjectedAml((IFile) resource) || hasChanged((IFile) resource))) {

			String inName = resource.getName();
			monitor.subTask(org.eclipse.m2m.atl.engine.Messages
					.getString("Compiling Aml file", new Object[] {inName}));
			IProject project = resource.getProject();
			InputStream is = ((IFile) resource).getContents();
			
			try {
				
				IModel[] amlAndProblemModels = AmlCompiler.getDefault()
				.injectAMLTextFile(is); 
				IModel injectedAmlModel = amlAndProblemModels[0];
				IModel problemModel = amlAndProblemModels[1];
								
				EObject[] pbs = AmlModelUtils.getDefault().getProblems(problemModel);
				markerMaker.resetPbmMarkers(resource, pbs);
				
				createOldInjectedAml(resource, injectedAmlModel, project);
				
				if (AmlModelUtils.getDefault().hasMethodCalls(injectedAmlModel)){
				
					IFile iParameterFile = getPropertiesFile((IFile) resource);
					if (!iParameterFile.exists()) {
						logger.log(Level.SEVERE, "There is not a properties file");
						return false;
					}
					InputStream parameterFile = iParameterFile.getContents();
	
					if (pbs.length == 0) {
												
						String parameterFileName = iParameterFile.getName();
		
						IModel injectedParamModel = AmlCompiler.getDefault()
								.injectParameterTextFile(parameterFile);
		
						IFolder ATLCodeFolder = AmlUIResourceManager.getDefault()
								.createFolder(project,
										AmlUIResourceManager.ATLFolderName);
						
						//Generating Atl files
						IModel matchingCodeModel = AmlCompiler.getDefault()
								.compileMatchingCode(injectedAmlModel);
						AmlUIResourceManager.getDefault().saveCompiledFiles(
								AmlCompiler.getDefault().extractMatchingCode(
										matchingCodeModel), project,
								ATLCodeFolder.getProjectRelativePath());
						
						//Generating Ant script	
						IModel chainCodeModel = AmlCompiler.getDefault()
								.compileTransfoChainCode(injectedAmlModel);
						AmlUIResourceManager.getDefault().saveCompiledFiles(
								AmlCompiler.getDefault().extractTransfoChainCode(
										chainCodeModel), project,
								project.getProjectRelativePath());
						
						//Generating properties
						IModel parameterModel = AmlCompiler.getDefault()
								.compilePropertiesCode(injectedAmlModel,
										injectedParamModel);
						ByteArrayOutputStream newParameterFile = AmlCompiler
								.getDefault().extractParameterCode(parameterModel);
		
						Map<String, ByteArrayOutputStream> mapParameterCode = new HashMap<String, ByteArrayOutputStream>();
						mapParameterCode.put(parameterFileName, newParameterFile);
		
						AmlUIResourceManager.getDefault().saveCompiledFiles(
								mapParameterCode, project,
								project.getProjectRelativePath());
					}
					
				try {
					is.close();
					parameterFile.close();

				} catch (IOException e) {
					logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}
				return false;
				}
			} catch (ATLCoreException e1) {
				
				logger.log(Level.SEVERE, e1.getLocalizedMessage(), e1);
			} 

		}

		// return true to continue visiting children.
		return true;
	}

	private void createOldInjectedAml(IResource resource,
			IModel injectedAmlModel, IProject project) throws ATLCoreException {

		
		

			IExtractor ext = new EMFExtractor();
			ByteArrayOutputStream newParameterFile = new ByteArrayOutputStream();
			ext.extract(injectedAmlModel, newParameterFile, null);

			Map<String, ByteArrayOutputStream> mapParameterCode = new HashMap<String, ByteArrayOutputStream>();
			mapParameterCode.put(resource.getName() + oldInjectedAmlModel,
					newParameterFile);

			AmlUIResourceManager.getDefault()
					.saveCompiledFiles(mapParameterCode, project,
							project.getProjectRelativePath());

		
	}

}
