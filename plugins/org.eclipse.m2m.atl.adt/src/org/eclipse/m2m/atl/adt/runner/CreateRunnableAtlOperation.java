/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.runner;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.codegen.merge.java.JControlModel;
import org.eclipse.emf.codegen.merge.java.JMerger;
import org.eclipse.emf.codegen.merge.java.facade.ast.ASTFacadeHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.adt.AdtPlugin;
import org.eclipse.m2m.atl.adt.Messages;

/**
 * An Operation which creates / updates a runnable java file.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class CreateRunnableAtlOperation implements IWorkspaceRunnable {

	private IFile propertyFile;

	private IFile javaFile;

	/**
	 * Constructor.
	 * 
	 * @param propertyFile
	 *            the ATL properties file
	 * @param javaFile
	 *            the java runnable file
	 */
	public CreateRunnableAtlOperation(IFile propertyFile, IFile javaFile) {
		super();
		this.propertyFile = propertyFile;
		this.javaFile = javaFile;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.resources.IWorkspaceRunnable#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void run(IProgressMonitor monitor) throws CoreException {
		try {
			ATLProperties properties = new ATLProperties(propertyFile);
			properties.load(propertyFile.getContents());

			CreateRunnableData runnableData = new CreateRunnableData();
			runnableData.load(properties);
			CreatePluginData pluginData = new CreatePluginData(propertyFile.getProject().getName(), getBasePackage());
			pluginData.setRunnableData(runnableData);

			CreateRunnableJavaWriter runnableWriter = new CreateRunnableJavaWriter();
			String text = runnableWriter.generate(pluginData);
			createFile(javaFile, text, monitor);

			CreateModulePropertiesWriter propertiesWriter = new CreateModulePropertiesWriter();
			text = propertiesWriter.generate(runnableData);
			createFile(propertyFile, text, monitor);
		} catch (IOException e) {
			AdtPlugin.getDefault().getLog().log(
					new Status(IStatus.ERROR, AdtPlugin.PLUGIN_ID, e.getMessage(), e));
		}
	}

	public String getBasePackage() {
		return javaFile.getFullPath().removeFirstSegments(2).removeLastSegments(1).toString().replaceAll("/", //$NON-NLS-1$
				"\\."); //$NON-NLS-1$
	}

	/**
	 * Creates the given file and its content.
	 * 
	 * @param newFile
	 *            is the file to create
	 * @param content
	 *            is the content of the new file
	 * @param monitor
	 *            is the monitor
	 * @throws UnsupportedEncodingException
	 *             when an encoding problem has been detected
	 * @throws CoreException
	 *             contains a status object describing the cause of the exception
	 */
	private void createFile(IFile newFile, String content, IProgressMonitor monitor)
			throws UnsupportedEncodingException, CoreException, IOException {
		IFile file = newFile;
		String text = content;
		if (file.exists() && "java".equals(file.getFileExtension())) { //$NON-NLS-1$
			String jmergeFile = URI.createPlatformPluginURI(
					"org.eclipse.m2m.atl.adt/templates/atl-merge.xml", false).toString(); //$NON-NLS-1$
			JControlModel model = new JControlModel();
			ASTFacadeHelper astFacadeHelper = new ASTFacadeHelper();
			model.initialize(astFacadeHelper, jmergeFile);
			if (model.canMerge()) {
				JMerger jMerger = new JMerger(model);
				jMerger.setSourceCompilationUnit(jMerger.createCompilationUnitForContents(text));
				try {
					jMerger.setTargetCompilationUnit(jMerger
							.createCompilationUnitForInputStream(new FileInputStream(file.getLocation()
									.toFile()))); // target=last generated code
					jMerger.merge();
					text = jMerger.getTargetCompilationUnit().getContents();
				} catch (FileNotFoundException e) {
					AdtPlugin.getDefault().getLog().log(
							new Status(IStatus.ERROR, AdtPlugin.PLUGIN_ID, e.getMessage(), e));
				}
			} else {
				AdtPlugin.getDefault().getLog().log(
						new Status(IStatus.WARNING, AdtPlugin.PLUGIN_ID,
								Messages.getString("CreateRunnableAtlOperation.MERGER_FAILURE"), null)); //$NON-NLS-1$
			}
		}

		if (!file.exists() && file.getParent().exists()) {
			IResource[] members = file.getParent().members(IResource.FILE);
			for (int i = 0; i < members.length; i++) {
				if (members[i] instanceof IFile
						&& file.getName().toLowerCase().equals(members[i].getName().toLowerCase())) {
					file = (IFile)members[i];
					break;
				}
			}
		}
		if (!file.exists() || !text.equals(convertStreamToString(file.getContents()))) {
			ByteArrayInputStream javaStream = new ByteArrayInputStream(text.getBytes("UTF8")); //$NON-NLS-1$
			if (!file.exists()) {
				file.create(javaStream, true, monitor);
			} else {
				file.setContents(javaStream, true, false, monitor);
			}
		}
	}

	private static String convertStreamToString(InputStream is) throws IOException {
		StringWriter writer = new StringWriter();
		InputStreamReader reader = new InputStreamReader(is);
		BufferedReader buffer = new BufferedReader(reader);
		String line = ""; //$NON-NLS-1$
		while (null != (line = buffer.readLine())) {
			writer.write(line);
		}
		return writer.toString();
	}

}
