/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tarik Idrissi (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.engine.MarkerMaker;
import org.eclipse.m2m.atl.engine.compiler.AtlCompiler;
import org.eclipse.m2m.atl.engine.compiler.CompilerNotFoundException;

/**
 * The ATL build visitor.
 * 
 * @author <a href="mailto:tarik.idrissi@laposte.net">Tarik Idrissi</a>
 */
public class AtlBuildVisitor implements IResourceVisitor {

	/** Contains routines to manage problem markers when compiling. */
	private MarkerMaker markerMaker = new MarkerMaker();

	private IProgressMonitor monitor;

	/**
	 * Creates the visitor.
	 * 
	 * @param monitor
	 *            the progress monitor
	 */
	public AtlBuildVisitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}

	/**
	 * Returns <code>true</code> if the file has changed since its last build <code>false</code>
	 * otherwise.
	 * 
	 * @param resource
	 *            the tested file
	 * @return <code>true</code> if the file has changed since its last build <code>false</code> otherwise
	 */
	private boolean hasChanged(IResource resource) {
		return resource.getLocalTimeStamp() > getAsmFile(resource).getLocalTimeStamp();
	}

	/**
	 * Returns <code>true</code> if the given resource has an associated asm file <code>false</code>
	 * otherwise.
	 * 
	 * @param resource
	 *            the resource for which to test whether it has an associated asm file
	 * @return <code>true</code> if the given resource has an associated asm file <code>false</code>
	 *         otherwise
	 */
	private boolean hasAsmFile(IResource resource) {
		return getAsmFile(resource).exists();
	}

	/**
	 * Returns <code>true</code> if the given resource has an associated asm file <code>false</code>
	 * otherwise.
	 * 
	 * @param resource
	 *            the resource for which to test whether it has an associated asm file
	 * @return <code>true</code> if the given resource has an associated asm file <code>false</code>
	 *         otherwise
	 */
	private IFile getAsmFile(IResource resource) {
		String atlFileName = resource.getName();
		String asmFileName = atlFileName.substring(0, atlFileName.lastIndexOf('.')) + ".asm"; //$NON-NLS-1$
		IFile asm = resource.getParent().getFile(new Path(asmFileName));
		return asm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.resources.IResourceVisitor#visit(org.eclipse.core.resources.IResource)
	 */
	public boolean visit(IResource resource) throws CoreException {
		String extension = resource.getFileExtension();
		if (("atl".equals(extension) && (resource instanceof IFile)) && ((IFile)resource).getLocation().toFile().length() > 0//$NON-NLS-1$
				&& (!hasAsmFile(resource) || hasChanged(resource))) {
			String inName = resource.getName();
			monitor.subTask(Messages
					.getString("AtlBuildVisitor.COMPILETASK", new Object[] {inName})); //$NON-NLS-1$
			String outName = inName.substring(0, inName.lastIndexOf('.')) + ".asm"; //$NON-NLS-1$
			IFile out = resource.getParent().getFile(new Path(outName));
			InputStream is = ((IFile)resource).getContents();
			try {
				EObject[] pbms = AtlCompiler.compile(is, out);
				markerMaker.resetPbmMarkers(resource, pbms);
				IFile asmFile = getAsmFile(resource);
				if (asmFile.exists()) {
					asmFile.setDerived(true);
				}
				is.close();
			} catch (CompilerNotFoundException cnfee) {
				IMarker marker = resource.createMarker(MarkerMaker.PROBLEM_MARKER);
				marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
				marker.setAttribute(IMarker.MESSAGE, cnfee.getMessage());
				marker.setAttribute(IMarker.LINE_NUMBER, 1);
			} catch (IOException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
			return false;
		}
		// return true to continue visiting children.
		return true;
	}

}
