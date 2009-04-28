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
package org.eclipse.m2m.atl.adt.ui.viewsupport;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;

public class AtlEditorTickErrorUpdater implements IProblemChangedListener {

	private AtlEditor atlEditor;

	private static final String ATL_EDITOR_ERROR = "atl_file_error.gif"; //$NON-NLS-1$

	private static final String ATL_EDITOR_WARNING = "atl_file_warning.gif"; //$NON-NLS-1$

	private static final String ATL_EDITOR = "atl_file.gif"; //$NON-NLS-1$

	private Map imageCache = new HashMap();

	public AtlEditorTickErrorUpdater(AtlEditor editor) {
		atlEditor = editor;
		AtlUIPlugin.getDefault().getProblemMarkerManager().addListener(this);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.adt.ui.viewsupport.IProblemChangedListener#problemsChanged(org.eclipse.core.resources.IResource[], boolean)
	 */
	public void problemsChanged(IResource[] changedResources, boolean isMarkerChange) {
		// IFileEditorInput input= (IFileEditorInput) atlEditor.getEditorInput();
		IResource resource = atlEditor.getUnderlyingResource();
		if (resource != null && resource.isAccessible()) {
			for (int i = 0; i < changedResources.length; i++) {
				if (changedResources[i].equals(resource)) {
					updateEditorImage(resource);
				}
			}
		}
	}

	/**
	 * computes the highest severity flag for a given <code>IResource</code>
	 * 
	 * @param res
	 *            the <code>Resource</code> for which to compute the most high severity
	 * @return the highest severity flag
	 */
	private int computeHighestServityFlag(IResource res) {
		IMarker[] pbmMarkers = null;
		try {
			pbmMarkers = res.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		} catch (CoreException e) {
			System.err.println(e);
		}
		int severity = -1; // none
		if (pbmMarkers != null) {
			for (int i = 0; i < pbmMarkers.length; i++) {
				IMarker curr = pbmMarkers[i];
				severity = curr.getAttribute(IMarker.SEVERITY, -1);
				if (severity == IMarker.SEVERITY_ERROR)
					return IMarker.SEVERITY_ERROR;
			}
		}
		return severity;
	}

	public void updateEditorImage(IResource res) {
		if (res == null) {
			return;
		}

		Image titleImage = atlEditor.getTitleImage();
		if (titleImage == null) {
			return;
		}
		Image newImage = getImage(res);
		if (newImage != null && titleImage != newImage) {
			postImageChange(newImage);
		}
	}

	private Image getImage(IResource res) {
		int flag = computeHighestServityFlag(res);
		ImageDescriptor imgDesc = null;
		switch (flag) {
			case IMarker.SEVERITY_ERROR:
				imgDesc = AtlUIPlugin.getImageDescriptor(ATL_EDITOR_ERROR);
				break;
			case IMarker.SEVERITY_WARNING:
				imgDesc = AtlUIPlugin.getImageDescriptor(ATL_EDITOR_WARNING);
				break;
			default:
				imgDesc = AtlUIPlugin.getImageDescriptor(ATL_EDITOR);
		}
		if (imgDesc == null)
			return null;

		Image img = (Image)imageCache.get(imgDesc);
		if (img == null) {
			img = imgDesc.createImage();
			imageCache.put(imgDesc, img);
		}
		return img;
	}

	private void postImageChange(final Image newImage) {
		Shell shell = atlEditor.getEditorSite().getShell();
		if (shell != null && !shell.isDisposed()) {
			shell.getDisplay().syncExec(new Runnable() {
				public void run() {
					atlEditor.updateTitleImage(newImage);
				}
			});
		}
	}

	public void dispose() {
		for (Iterator images = imageCache.values().iterator(); images.hasNext();) {
			((Image)images.next()).dispose();
		}
		imageCache.clear();
		AtlUIPlugin.getDefault().getProblemMarkerManager().removeListener(this);
	}

}
