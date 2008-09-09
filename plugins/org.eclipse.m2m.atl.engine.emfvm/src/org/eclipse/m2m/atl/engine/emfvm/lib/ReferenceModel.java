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
 * $Id: ReferenceModel.java,v 1.6 2008/09/09 13:15:01 wpiers Exp $
 */

package org.eclipse.m2m.atl.engine.emfvm.lib;

/**
 * The Reference model (used to define metamodels).
 * 
 * @author <a href="mailto:mikael.barbero@univ-nantes.fr">Mikael Barbero</a>
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public interface ReferenceModel extends Model {

	/**
	 * Returns a metaelement by its name.
	 * 
	 * @param name
	 *            the metaelement name
	 * @return a metaelement by its name
	 */
	Object getMetaElementByName(String name);

	/**
	 * Returns True if object is contained in this model's resource or a referenced resource.
	 * 
	 * @param object
	 *            The model element.
	 * @return True if object is contained in this model's resource or a referenced resource.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	boolean isModelOf(Object object);
}
