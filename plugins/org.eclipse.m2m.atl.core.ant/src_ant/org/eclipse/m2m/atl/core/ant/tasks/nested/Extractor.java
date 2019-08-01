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

import java.util.HashMap;
import java.util.Map;

/**
 * Extractor nested element.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class Extractor {

	protected String name;

	private Map<String, Object> params = new HashMap<String, Object>();

	/**
	 * Adds a {@link Param}.
	 * 
	 * @param p
	 *            the parameter
	 */
	public void addConfiguredParam(Param p) {
		params.put(p.name, p.value);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Object> getParams() {
		return params;
	}

}
