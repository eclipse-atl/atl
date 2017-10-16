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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.Path;

/**
 * Abstract ATL {@link IResourceVisitor}.
 * 
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public abstract class AtlResourceVisitor implements IResourceVisitor {

	/**
	 * Returns the associated asm file for the given resource.
	 * 
	 * @param resource
	 *            the resource for which to retrieve the associated asm file
	 * @return the associated asm file for the given resource
	 */
	protected IFile getAsmFile(final IResource resource) {
		final String atlFileName = resource.getName();
		final String asmFileName = atlFileName.substring(0, atlFileName.lastIndexOf('.')) + ".asm"; //$NON-NLS-1$
		final IFile asm = resource.getParent().getFile(new Path(asmFileName));
		return asm;
	}

	/**
	 * Returns the associated emftvm file for the given resource.
	 * 
	 * @param resource
	 *            the resource for which to retrieve the associated emftvm file
	 * @return the associated emftvm file for the given resource
	 */
	protected IFile getEmftvmFile(final IResource resource) {
		final String atlFileName = resource.getName();
		final String emftvmFileName = atlFileName.substring(0, atlFileName.lastIndexOf('.')) + ".emftvm"; //$NON-NLS-1$
		final IFile emftvmFile = resource.getParent().getFile(new Path(emftvmFileName));
		return emftvmFile;
	}

	/**
	 * Returns the associated bytecode (asm/emftvm) file for the given resource. Defaults to asm, unless the
	 * emftvm file exists.
	 * 
	 * @param resource
	 *            the resource for which to retrieve the associated bytecode file
	 * @return the associated bytecode (asm/emftvm) file for the given resource
	 */
	protected IFile getBytecodeFile(final IResource resource) {
		final IFile emftvmFile = getEmftvmFile(resource);
		return emftvmFile.exists() ? emftvmFile : getAsmFile(resource);
	}

}
