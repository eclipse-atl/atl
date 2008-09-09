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
 * The disassembly provider class.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class DisassemblyDocumentProvider extends TextFileDocumentProvider {

	private Map ams = new HashMap();

	/**
	 * {@inheritDoc} TODO: this is not a correct implementation. We keep references to every element, which
	 * means they won't be garbage collected. However, it works.
	 * 
	 * @see org.eclipse.ui.editors.text.TextFileDocumentProvider#getAnnotationModel(java.lang.Object)
	 */
	public IAnnotationModel getAnnotationModel(Object element) {
		IAnnotationModel ret = (IAnnotationModel)ams.get(element);

		if (ret == null) {
			ret = new AnnotationModel();
			ams.put(element, ret);
		}

		return ret;
	}

}
