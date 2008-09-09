/*******************************************************************************
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.dsls;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.dsls.textsource.TextSource;

/**
 * The Resource interface.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public interface Resource {

	/**
	 * Returns a text source based on the current resource.
	 * 
	 * @return a text source based on the current resource
	 */
	TextSource asTextSource();

	/**
	 * Returns the URL of the resource.
	 * 
	 * @return the URL of the resource
	 */
	URL asURL();

	/**
	 * Returns the EMF URI of the resource.
	 * 
	 * @return the EMF URI of the resource
	 */
	URI asEMFURI();
}
