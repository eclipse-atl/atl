/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * Copyright (c) 2017 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tarik Idrissi (INRIA) - initial API and implementation
 *    Obeo - runnable Java generation
 *    Dennis Wagelaar
 *******************************************************************************/
package org.eclipse.m2m.atl.adt;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.adt.runner.ATLProperties;
import org.eclipse.m2m.atl.adt.runner.CreateRunnableAtlOperation;
import org.eclipse.m2m.atl.engine.MarkerMaker;
import org.eclipse.m2m.atl.engine.compiler.AtlCompiler;
import org.eclipse.m2m.atl.engine.compiler.CompilerNotFoundException;

/**
 * The ATL build visitor.
 * 
 * @author <a href="mailto:tarik.idrissi@laposte.net">Tarik Idrissi</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class AtlBuildVisitor extends AtlResourceVisitor {

	/** Contains routines to manage problem markers when compiling. */
	private MarkerMaker markerMaker = new MarkerMaker();

	private IProgressMonitor monitor;

	/**
	 * Creates the visitor.
	 * 
	 * @param monitor
	 *            the progress monitor
	 */
	public AtlBuildVisitor(final IProgressMonitor monitor) {
		this.monitor = monitor;
	}

	/**
	 * Returns <code>true</code> if the file has changed since its last build <code>false</code> otherwise.
	 * 
	 * @param resource
	 *            the tested file
	 * @return <code>true</code> if the file has changed since its last build <code>false</code> otherwise
	 */
	private boolean hasChanged(final IResource resource) {
		return resource.getLocalTimeStamp() > getBytecodeFile(resource).getLocalTimeStamp();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.resources.IResourceVisitor#visit(IResource)
	 */
	public boolean visit(final IResource resource) throws CoreException {

		final String extension = resource.getFileExtension();
		if (("atl".equals(extension) && (resource instanceof IFile)) && ((IFile)resource).getLocation().toFile().length() > 0//$NON-NLS-1$
				&& (!getBytecodeFile(resource).exists() || hasChanged(resource))) {
			final String inName = resource.getName();
			monitor.subTask(Messages.getString("AtlBuildVisitor.COMPILETASK", new Object[] {inName})); //$NON-NLS-1$
			final InputStream is = ((IFile)resource).getContents();
			try {
				final Reader r = new InputStreamReader(is, ((IFile)resource).getCharset());
				final EObject[] pbms = AtlCompiler.compile(r, getAsmFile(resource));
				markerMaker.resetPbmMarkers(resource, pbms);
				final IFile newBytecodeFile = getBytecodeFile(resource);
				if (newBytecodeFile.exists()) {
					newBytecodeFile.setDerived(true, monitor);
				}
				if (pbms.length == 0) {
					for (IFile propertyFile : getRelatedPropertyFiles((IFile)resource)) {
						if (!propertyFile.isDerived()) {
							IFile javaFile = propertyFile.getParent().getFile(
									new Path(propertyFile.getName()).removeFileExtension().addFileExtension(
											"java")); //$NON-NLS-1$
							CreateRunnableAtlOperation op = new CreateRunnableAtlOperation(propertyFile,
									javaFile);
							op.run(monitor);
						}
					}
				}
			} catch (CompilerNotFoundException cnfee) {
				IMarker marker = resource.createMarker(MarkerMaker.PROBLEM_MARKER);
				marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
				marker.setAttribute(IMarker.MESSAGE, cnfee.getMessage());
				marker.setAttribute(IMarker.LINE_NUMBER, 1);
			} catch (IOException e) {
				throw new CoreException(new Status(Status.ERROR, AdtPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
			} finally {
				try {
					is.close();
				} catch (IOException e) {
					throw new CoreException(new Status(Status.ERROR, AdtPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
				}
			}
			return false;
		}
		// return true to continue visiting children.
		return true;
	}

	private IFile[] getRelatedPropertyFiles(final IFile atlFile) throws IOException, CoreException {
		final List<IFile> res = new ArrayList<IFile>();
		for (IFile propertyFile : getAllPropertyFiles(atlFile.getParent())) {
			ATLProperties properties = new ATLProperties(propertyFile);
			IFile[] modules = properties.getTransformationFiles();
			if (modules != null && Arrays.asList(modules).contains(atlFile)) {
				res.add(propertyFile);
			}
		}
		return res.toArray(new IFile[res.size()]);
	}

	private List<IFile> getAllPropertyFiles(final IContainer container) throws CoreException {
		if (container.getProject().hasNature("org.eclipse.pde.PluginNature")) { //$NON-NLS-1$
			PropertiesVisitor visitor = new PropertiesVisitor();
			container.accept(visitor);
			return visitor.getPropertyFiles();
		}
		return Collections.emptyList();
	}

	/**
	 * A resource visitor which returns all ATL properties files contained into a resource.
	 */
	private class PropertiesVisitor implements IResourceVisitor {

		private List<IFile> propertyFiles = new ArrayList<IFile>();

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.core.resources.IResourceVisitor#visit(org.eclipse.core.resources.IResource)
		 */
		public boolean visit(final IResource resource) throws CoreException {
			if (resource instanceof IContainer) {
				return true;
			} else if (resource instanceof IFile) {
				IFile propertyFile = (IFile)resource;
				if ("properties".equals(propertyFile.getFileExtension())) { //$NON-NLS-1$
					for (IResource member : resource.getParent().members()) {
						if (member instanceof IFile && "atl".equals(member.getFileExtension())) { //$NON-NLS-1$
							if (propertyFile.getName().equalsIgnoreCase(
									member.getFullPath().removeFileExtension().addFileExtension("properties") //$NON-NLS-1$
											.lastSegment())) {
								propertyFiles.add(propertyFile);
							}
						}
					}
				}
			}
			return true;
		}

		public List<IFile> getPropertyFiles() {
			return propertyFiles;
		}

	}

}
