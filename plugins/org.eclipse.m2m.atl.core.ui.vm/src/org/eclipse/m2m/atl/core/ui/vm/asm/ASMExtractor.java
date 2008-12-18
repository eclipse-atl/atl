/*******************************************************************************
 * Copyright (c) 2008 Obeo.
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
import java.util.logging.Level;

import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.common.ATLLogger;
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
	 * @see org.eclipse.m2m.atl.core.IExtractor#extract(org.eclipse.m2m.atl.core.IModel, java.lang.Object,
	 *      java.util.Map)
	 */
	public void extract(IModel targetModel, Object target, Map<String, Object> options) {
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
		try {
			modelWrapper.getModelLoader().save(asmModel, URI.createFileURI(path).toString());
		} catch (IOException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

}
