/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * Copyright (c) 2017 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *    Dennis Wagelaar
 *******************************************************************************/
package org.eclipse.m2m.atl.adt;

import java.util.logging.Level;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.m2m.atl.common.ATLLogger;

/**
 * The ATL clean visitor.
 * 
 * @author <a href="mailto:tarik.idrissi@laposte.net">Tarik Idrissi</a>
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class AtlCleanVisitor extends AtlResourceVisitor {

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
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.resources.IResourceVisitor#visit(org.eclipse.core.resources.IResource)
	 */
	public boolean visit(IResource resource) throws CoreException {
		boolean result = true;
		String extension = resource.getFileExtension();
		if (("atl".equals(extension) && //$NON-NLS-1$
				(resource instanceof IFile)) && ((IFile)resource).getLocation().toFile().length() > 0
				&& getBytecodeFile(resource).exists()) {

			monitor.subTask(
					Messages.getString("AtlCleanVisitor.CLEANTASK", new Object[] {resource.getName()})); //$NON-NLS-1$
			result &= deleteFile(getAsmFile(resource));
			result &= deleteFile(getEmftvmFile(resource));
		}
		// return true to continue visiting children.
		return result;
	}

	/**
	 * Deletes the given file
	 * 
	 * @param file
	 *            the file to delete
	 * @return <code>true</code> if successful, <code>false</code> otherwise
	 */
	private boolean deleteFile(final IFile file) {
		try {
			if (file.exists()) {
				file.delete(true, monitor);
			}
		} catch (CoreException ce) {
			ATLLogger.log(Level.SEVERE, ce.getLocalizedMessage(), ce);
			return false;
		}
		return true;
	}

}
