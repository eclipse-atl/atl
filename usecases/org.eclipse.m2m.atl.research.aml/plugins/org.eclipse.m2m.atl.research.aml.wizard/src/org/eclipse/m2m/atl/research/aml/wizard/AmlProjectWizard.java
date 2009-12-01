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

package org.eclipse.m2m.atl.research.aml.wizard;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.m2m.atl.research.aml.builder.AmlBuilder;
import org.eclipse.m2m.atl.research.aml.engine.AmlResourceManager;
import org.eclipse.m2m.atl.research.aml.utils.AmlUIException;
import org.eclipse.m2m.atl.research.aml.utils.AmlUIResourceManager;
import org.eclipse.m2m.atl.research.aml.utils.ResourceUtils;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

/**
 * 
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a>
 *
 */
public class AmlProjectWizard extends Wizard implements INewWizard {

	
	private static final String ATL_NATURE_ID = "org.eclipse.m2m.atl.adt.builder.atlNature";	
	private static final String AML_NATURE_ID = "org.eclipse.m2m.atl.research.aml.builder.AmlNature";
		
	private AmlProjectWizardPage page;
	
	
	public static final String atlExtention = "atl";

	public void addPages() {
		page = new AmlProjectWizardPage(null);
		addPage(page);
	}

	public AmlProjectWizard() {
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean performFinish() {
		final String name = page.getProjectName();
		
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				try {
					doFinish(name);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		return true;
	}
	
	private void doFinish (String name) throws CoreException, InterruptedException {
		

		try{
			// Get the worskspace container (IWorkspaceRoot)
			IWorkspace wks = ResourcesPlugin.getWorkspace();
			IWorkspaceRoot wksroot = wks.getRoot();

			// Create a project model instance
			IProject project = wksroot.getProject(name);
			if(!project.exists())
				project.create(null);

			// open project if necessary
			if(!project.isOpen())
				project.open(null);

			AmlUIResourceManager.getDefault().createFolder(project, AmlUIResourceManager.ATLFolderName);
			AmlUIResourceManager.getDefault().createFolder(project, AmlResourceManager.metamodelsFolderName);
			AmlUIResourceManager.getDefault().createFolder(project, AmlUIResourceManager.equalModelFolderName);
			AmlUIResourceManager.getDefault().createFolder(project, AmlUIResourceManager.modelFolderName);
			AmlUIResourceManager.getDefault().createFolder(project, AmlUIResourceManager.metricFolderName);
												
			Map subst = new HashMap();
			subst.put("AMLProgram", name);
			
		
			AmlUIResourceManager.getDefault().createFile(project, 
					ResourceUtils.getPathWithSeparator(AmlResourceManager.metamodelsFolderName, AmlResourceManager.equalMMName),
					AmlResourceManager.getDefault().getInputStream(
							ResourceUtils.getPathWithSeparator(AmlResourceManager.metamodelsFolderName, AmlResourceManager.equalMMName)
					)
				);
			
			AmlUIResourceManager.getDefault().createFile(project, 
					ResourceUtils.getPathWithSeparator(AmlResourceManager.metamodelsFolderName, AmlResourceManager.atlMMName),
					AmlResourceManager.getDefault().getInputStream(
							ResourceUtils.getPathWithSeparator(AmlResourceManager.metamodelsFolderName, AmlResourceManager.atlMMName)
					)
				);
			
			AmlUIResourceManager.getDefault().createFile(project, 
					ResourceUtils.getPathWithSeparator(AmlResourceManager.metamodelsFolderName, AmlResourceManager.KM3MMName),
					AmlResourceManager.getDefault().getInputStream(
							ResourceUtils.getPathWithSeparator(AmlResourceManager.metamodelsFolderName, AmlResourceManager.KM3MMName)
					)
				);
			
			AmlUIResourceManager.getDefault().createFile(project, name + "." + AmlUIResourceManager.amlExtention,
					AmlResourceManager.getDefault().getTemplate(
							ResourceUtils.getPathWithSeparator(AmlResourceManager.templatesFolderName, "Sample.aml"),
							subst));
						
			//
			addNature(project, AmlProjectWizard.ATL_NATURE_ID);
			addNature(project, AmlProjectWizard.AML_NATURE_ID);				
			addBuilder(project, AmlBuilder.BUILDER_ID);
			
			AmlUIResourceManager.getDefault().createFile(project,																				
					name + "." + AmlUIResourceManager.propertiesExtention,
					new ByteArrayInputStream("".getBytes()));
			
			AmlUIResourceManager.getDefault().createFile(project, 
					ResourceUtils.getPathWithSeparator(AmlUIResourceManager.metricFolderName, name + "." + AmlUIResourceManager.tableExtention),
					AmlResourceManager.getDefault().getInputStream(
							ResourceUtils.getPathWithSeparator(AmlUIResourceManager.metricFolderName, "metrics.xmi"))
				);

		}
		catch(CoreException ce){
			throw new AmlUIException(IStatus.ERROR, ce);
		} catch (IOException e) {
			throw new AmlUIException(IStatus.ERROR, e);
		}
		
		
	}
	
	
	
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}

	/**
	 * Adds a nature to a project
	 * @param project the project to add a nature to
	 * @param natureId the natureId of the nature to be added to the project
	 * @throws CoreException 
	 */
	public void addNature(IProject project, String natureId) throws CoreException {
	
	      IProjectDescription description = project.getDescription();
	      String[] natures = description.getNatureIds();
	      ArrayList<String> newNatures = new ArrayList<String>(Arrays.asList(natures));	      
	      newNatures.add(natureId);
	      
	      String[] newNaturesArray = newNatures.toArray(new String[newNatures.size()]);
	      description.setNatureIds(newNaturesArray);
	      project.setDescription(description, null);
	   
	}
	
	private void addBuilder(IProject project, String id) throws CoreException {
      IProjectDescription desc = project.getDescription();
      ICommand[] commands = desc.getBuildSpec();
      for (int i = 0; i < commands.length; ++i)
         if (commands[i].getBuilderName().equals(id))
            return;
      //add builder to project
      ICommand command = desc.newCommand();
      command.setBuilderName(id);
      ICommand[] nc = new ICommand[commands.length + 1];
      // Add it before other builders.
      System.arraycopy(commands, 0, nc, 1, commands.length);
      nc[0] = command;
      desc.setBuildSpec(nc);
      project.setDescription(desc, null);
	}
}
