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
package org.eclipse.m2m.atl.adt.debug.ui;

import org.eclipse.core.resources.IMarker;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.texteditor.IAnnotationImageProvider;
import org.eclipse.ui.texteditor.MarkerAnnotation;

/**
 * The ATL breakpoint image provider.
 * 
 * @author <a href="mailto:tarik.idrissi@laposte.net">Tarik Idrissi</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlBreakpointImageProvider implements IAnnotationImageProvider {

	private IDebugModelPresentation fPresentation;

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.texteditor.IAnnotationImageProvider#getManagedImage(org.eclipse.jface.text.source.Annotation)
	 */
	public Image getManagedImage(Annotation annotation) {
		if (annotation instanceof MarkerAnnotation) {
			MarkerAnnotation markerAnnotation = (MarkerAnnotation)annotation;
			IMarker marker = markerAnnotation.getMarker();
			if (marker != null && marker.exists()) {
				return getPresentation().getImage(marker);
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.texteditor.IAnnotationImageProvider#getImageDescriptorId(org.eclipse.jface.text.source.Annotation)
	 */
	public String getImageDescriptorId(Annotation annotation) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.texteditor.IAnnotationImageProvider#getImageDescriptor(java.lang.String)
	 */
	public ImageDescriptor getImageDescriptor(String imageDescritporId) {
		return null;
	}

	private IDebugModelPresentation getPresentation() {
		if (fPresentation == null) {
			fPresentation = DebugUITools.newDebugModelPresentation();
		}
		return fPresentation;
	}
}
