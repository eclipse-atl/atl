/*
 * Created on 13 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.atl.eclipse.adt.debug.core;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;

/**
 * @author jouault
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DisassemblyDocumentProvider extends TextFileDocumentProvider {

	private Map ams = new HashMap();
	/* (non-Javadoc)
	 * @see org.eclipse.ui.texteditor.AbstractDocumentProvider#createAnnotationModel(java.lang.Object)
	 * TODO: this is not a correct implementation. We keep references to every element, which means
	 * they won't be garbage collected. However, it works.
	 */
	public IAnnotationModel getAnnotationModel(Object element) {
		IAnnotationModel ret = (IAnnotationModel)ams.get(element);
		
		if(ret == null) {
			ret = new AnnotationModel();
			ams.put(element, ret);
		}
		
		return ret;
	}

}
