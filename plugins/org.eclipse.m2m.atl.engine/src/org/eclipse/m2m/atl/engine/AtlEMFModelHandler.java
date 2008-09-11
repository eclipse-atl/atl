/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
<<<<<<< AtlEMFModelHandler.java
 *    Fr�d�ric Jouault (INRIA) - initial API and implementation
=======
 *    Frederic Jouault (INRIA) - initial API and implementation
>>>>>>> 1.18
 *******************************************************************************/
package org.eclipse.m2m.atl.engine;

import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.m2m.atl.drivers.emf4atl.EMFModelLoader;
import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * The model handler dedicated to EMF.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class AtlEMFModelHandler extends AtlModelHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.AtlModelHandler#isHandling(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel)
	 */
	public boolean isHandling(ASMModel model) {
		return model instanceof ASMEMFModel;
	}

	public ModelLoader createModelLoader() {
		return new EMFModelLoader();
	}
}
