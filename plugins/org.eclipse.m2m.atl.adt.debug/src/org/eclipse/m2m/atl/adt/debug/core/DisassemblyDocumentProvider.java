/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.debug.core;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;

/**
 * @author Frederic Jouault
 */
public class DisassemblyDocumentProvider extends TextFileDocumentProvider {

	private Map ams = new HashMap();
	/* 
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
