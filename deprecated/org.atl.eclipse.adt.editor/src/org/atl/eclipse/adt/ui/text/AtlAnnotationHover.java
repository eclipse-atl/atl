package org.atl.eclipse.adt.ui.text;

import org.eclipse.jface.text.Assert;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;

public class AtlAnnotationHover implements IAnnotationHover {

	private static class AnnotationHoverType {
	}
	
	public static final AnnotationHoverType VERTICAL_RULER_HOVER = new AnnotationHoverType();
	public static final AnnotationHoverType TEXT_RULER_HOVER = new AnnotationHoverType();
	public static final AnnotationHoverType OVERVIEW_RULER_HOVER = new AnnotationHoverType();
	private AnnotationHoverType type;
	
	public AtlAnnotationHover(AnnotationHoverType type) {
		Assert.isTrue(OVERVIEW_RULER_HOVER.equals(type) || TEXT_RULER_HOVER.equals(type) || VERTICAL_RULER_HOVER.equals(type));
		this.type = type;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.source.IAnnotationHover#getHoverInfo(org.eclipse.jface.text.source.ISourceViewer, int)
	 */
	public String getHoverInfo(ISourceViewer sourceViewer, int lineNumber) {
		return null;
	}
	
}
