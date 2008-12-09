/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.core.ui.vm.asm;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * The RegularVM adaptation of the {@link IExtractor}.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ASMExtractor implements IExtractor {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IExtractor#extract(org.eclipse.m2m.atl.core.IModel, java.lang.Object,
	 *      java.util.Map)
	 */
	public void extract(IModel targetModel, Object target, Map options) {
		extract(targetModel, target);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IExtractor#extract(org.eclipse.m2m.atl.core.IModel, java.lang.Object)
	 */
	public void extract(IModel targetModel, Object target) {
		ASMModelWrapper modelWrapper = (ASMModelWrapper)targetModel;
		ASMModel asmModel = modelWrapper.getAsmModel();
		String path = (String)target;
		if (path.startsWith("ext:")) { //$NON-NLS-1$
			path = path.substring(4);
		}
		modelWrapper.getModelHandler().saveModel(asmModel, URI.createFileURI(path).toString());
	}

}
