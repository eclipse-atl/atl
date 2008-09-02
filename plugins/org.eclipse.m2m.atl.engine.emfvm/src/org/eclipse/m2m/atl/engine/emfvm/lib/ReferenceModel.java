/**
 * Copyright (c) 2007, 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: ReferenceModel.java,v 1.5 2008/09/02 15:29:17 wpiers Exp $
 */

package org.eclipse.m2m.atl.engine.emfvm.lib;


/**
 * 
 * @author Mikael Barbero
 * @author Frederic Jouault
 *
 */
public interface ReferenceModel extends Model {

	public abstract Object getMetaElementByName(String name);

    /**
     * @param object The model element.
     * @return True if object is contained in this model's resource or a referenced resource.
     * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
     */
    public abstract boolean isModelOf(Object object);
}
