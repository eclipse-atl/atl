/**
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: AbstractModel.java,v 1.3 2008/09/09 13:15:01 wpiers Exp $
 */

package org.eclipse.m2m.atl.engine.emfvm.lib;

/**
 * The abstract implementation of the Model interface.
 * 
 * @author <a href="mailto:mikael.barbero@univ-nantes.fr">Mikael Barbero</a>
 */
public abstract class AbstractModel implements Model {
	
	protected ReferenceModel referenceModel;

	/** Defines if the model is an output model. */
	private boolean isTarget;

	public boolean isTarget() {
		return isTarget;
	}

	public void setIsTarget(boolean isTarget) {
		this.isTarget = isTarget;
	}

}
