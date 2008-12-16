/*******************************************************************************
 * Copyright (c) 2004 INRIA and C-S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *    Christophe Le Camus (C-S) - initial API and implementation
 *    Sebastien Gabel (C-S) - initial API and implementation
 *    Dennis Wagelaar (Vrije Universiteit Brussel)
 *******************************************************************************/
package org.eclipse.m2m.atl.drivers.uml24atl;

import org.eclipse.m2m.atl.drivers.emf4atl.AtlEMFModelHandler;
import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * The UML2 model handler.
 *
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 * @author <a href="mailto:christophe.le-camus@c-s.fr">Christophe Le Camus</a>
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien Gabel</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class AtlUML2ModelHandler extends AtlEMFModelHandler {

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.AtlEMFModelHandler#isHandling(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel)
	 */
	public boolean isHandling(ASMModel model) {
		return model instanceof ASMUMLModel;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.AtlModelHandler#createModelLoader()
	 */
	public ModelLoader createModelLoader() {
		return new UMLModelLoader();
	}
}
