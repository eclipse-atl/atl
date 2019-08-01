/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Dennis Wagelaar
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.debug.ui;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTarget;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * Creates a toggle breakpoint adapter factory. This factory is used to create a new ATL breakpoint.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class AtlBreakpointAdapterFactory implements IAdapterFactory {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object, java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public <T> T getAdapter(final Object adaptableObject, final Class<T> adapterType) {
		T adapter = null;
		if (adaptableObject instanceof ITextEditor) {
			final ITextEditor editorPart = (ITextEditor)adaptableObject;
			final IResource resource = (IResource)editorPart.getEditorInput().getAdapter(IResource.class);
			if (resource != null && "atl".equals(resource.getFileExtension())) { //$NON-NLS-1$
				if (adapterType.equals(IToggleBreakpointsTarget.class)) {
					adapter = (T) new AtlBreakpointAdapter();
				}
			}
		}
		return adapter;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
	 */
	public Class<?>[] getAdapterList() {
		return new Class<?>[] {IToggleBreakpointsTarget.class};
	}

}
