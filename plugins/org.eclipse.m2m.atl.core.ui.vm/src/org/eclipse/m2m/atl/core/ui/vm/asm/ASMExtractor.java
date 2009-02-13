/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Dennis Wagelaar (Vrije Universiteit Brussel)
 *******************************************************************************/
package org.eclipse.m2m.atl.core.ui.vm.asm;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * The RegularVM adaptation of the {@link IExtractor}.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class ASMExtractor implements IExtractor {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IExtractor#extract(org.eclipse.m2m.atl.core.IModel, java.lang.String,
	 *      java.util.Map)
	 */
	public void extract(IModel targetModel, String target, Map<String, Object> options)
			throws ATLCoreException {
		extract(targetModel, target);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IExtractor#extract(org.eclipse.m2m.atl.core.IModel, java.lang.String)
	 */
	public void extract(IModel targetModel, String target) throws ATLCoreException {
		ASMModelWrapper modelWrapper = (ASMModelWrapper)targetModel;
		ASMModel asmModel = modelWrapper.getAsmModel();
		try {
			if (target.startsWith("file:/")) { //$NON-NLS-1$
				modelWrapper.getModelLoader().save(asmModel,
						URI.createFileURI(target.substring(6)).toString());
			} else if (target.startsWith("platform:/resource")) { //$NON-NLS-1$
				modelWrapper.getModelLoader().save(asmModel,
						URI.createFileURI(target.substring(18)).toString());
			}
		} catch (IOException e) {
			throw new ATLCoreException(e.getLocalizedMessage(), e);
		}
	}

}
