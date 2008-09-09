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
 * $Id: Model.java,v 1.5 2008/09/09 13:15:01 wpiers Exp $
 */

package org.eclipse.m2m.atl.engine.emfvm.lib;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/**
 * The model interface.
 * 
 * @author <a href="mailto:mikael.barbero@univ-nantes.fr">Mikael Barbero</a>
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public interface Model {
	// returned value could (actually was) a non-ordered set Set, because there is no order in theory
	// BUT keeping the same order (i.e., resource/XMI order) typically makes things simpler
	/**
	 * Returns all elements of the given type.
	 * 
	 * @param metaElement
	 *            the meta type
	 * @return all elements of the given type
	 */
	Set getElementsByType(Object metaElement);

	/**
	 * Returns the metamodel.
	 * 
	 * @return the metamodel
	 */
	ReferenceModel getReferenceModel();

	/**
	 * Creates a new element.
	 * 
	 * @param metaElement
	 *            the new element metaclass
	 * @return the new element
	 */
	Object newElement(Object metaElement);

	/**
	 * Returns the model content.
	 * 
	 * @return the model content
	 */
	Iterator getContents(); // is it necessary ?

	/**
	 * Saves the model, by uri.
	 * 
	 * @param uri
	 *            the uri
	 * @throws IOException
	 */
	void save(String uri) throws IOException;

	/**
	 * Disposes the model.
	 */
	void dispose();
}
