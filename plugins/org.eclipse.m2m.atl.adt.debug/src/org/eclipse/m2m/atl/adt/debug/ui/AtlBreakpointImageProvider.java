/*
 * Created on 11 juin 2004
 */
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
 * @author idrissi
 */
public class AtlBreakpointImageProvider implements IAnnotationImageProvider {
	
	private IDebugModelPresentation fPresentation;

	/**
	 * @see org.eclipse.jface.text.source.IAnnotationImageProvider#getManagedImage(org.eclipse.jface.text.source.Annotation)
	 */
	public Image getManagedImage(Annotation annotation) {
		if (annotation instanceof MarkerAnnotation) {
			MarkerAnnotation markerAnnotation= (MarkerAnnotation) annotation;
			IMarker marker= markerAnnotation.getMarker();
			if (marker != null && marker.exists())
				return getPresentation().getImage(marker);
		}
		
		return null;
	}

	/**
	 * @see org.eclipse.jface.text.source.IAnnotationImageProvider#getImageDescriptorId(org.eclipse.jface.text.source.Annotation)
	 */
	public String getImageDescriptorId(Annotation annotation) {
		return null;
	}

	/**
	 * @see org.eclipse.jface.text.source.IAnnotationImageProvider#getImageDescriptor(java.lang.String)
	 */
	public ImageDescriptor getImageDescriptor(String imageDescritporId) {
		return null;
	}
	
	private IDebugModelPresentation getPresentation() {
		if (fPresentation == null) 
			fPresentation= DebugUITools.newDebugModelPresentation();
		return fPresentation;
	}
}
