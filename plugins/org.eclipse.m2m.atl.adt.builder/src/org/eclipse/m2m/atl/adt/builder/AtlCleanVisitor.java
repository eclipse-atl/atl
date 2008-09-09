/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.builder;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.m2m.atl.engine.vm.ATLVMPlugin;

/**
 * The ATL clean visitor.
 * 
 * @author <a href="mailto:tarik.idrissi@laposte.net">Tarik Idrissi</a>
 */
public class AtlCleanVisitor implements IResourceVisitor {
	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);

	private IProgressMonitor monitor;

	/**
	 * Creates the visitor.
	 * 
	 * @param monitor
	 *            the progress monitor
	 */
	public AtlCleanVisitor(IProgressMonitor monitor) {
		this.monitor = monitor;
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
		if (("atl".equals(extension) && //$NON-NLS-1$
				(resource instanceof IFile))
				&& ((IFile)resource).getLocation().toFile().length() > 0 && hasAsmFile(resource)) {

			monitor.subTask(AtlBuilderMessages.getString(
					"AtlCleanVisitor.CLEANTASK", new Object[] {resource.getName()})); //$NON-NLS-1$
			IFile asmFile = getAsmFile(resource);
			try {
				asmFile.delete(true, monitor);
			} catch (CoreException ce) {
				logger.log(Level.SEVERE, ce.getLocalizedMessage(), ce);
				return false;
			}
		}
		// return true to continue visiting children.
		return true;
	}

}
