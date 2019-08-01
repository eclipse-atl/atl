/*******************************************************************************
 * Copyright (c) 2005 INRIA. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v2.0 
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors: 
 *     INRIA - Initial API and implementation
 *     Obeo - ATL adaptation
 *     
 ******************************************************************************/
package org.eclipse.m2m.atl.core.ant.tasks.nested;

import java.util.ArrayList;
import java.util.List;

/**
 * Classpath nested element.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class Classpath {

	private List<Pathelement> pathElements = new ArrayList<Pathelement>();

	/**
	 * Adds a {@link Pathelement}.
	 * 
	 * @param p
	 *            the path element
	 */
	public void addConfiguredPathelement(Pathelement p) {
		pathElements.add(p);
	}

	public List<Pathelement> getPathElements() {
		return pathElements;
	}
}
