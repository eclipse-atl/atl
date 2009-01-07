/*******************************************************************************
 * Copyright (c) 2005 INRIA. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *     INRIA - Initial API and implementation
 *     Obeo - ATL adaptation
 *     
 ******************************************************************************/

package org.eclipse.m2m.atl.core.ant.tasks.nested;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Injector nested element.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class Injector {

	protected String name;

	private Map<String, Object> params = new HashMap<String, Object>();

	private List<Classpath> classpath = new ArrayList<Classpath>();

	/**
	 * Adds a {@link Param}.
	 * 
	 * @param p
	 *            the parameter
	 */
	public void addConfiguredParam(Param p) {
		params.put(p.name, p.value);
	}

	/**
	 * Adds a {@link Classpath}.
	 * 
	 * @param c
	 *            the classpath
	 */
	public void addConfiguredClasspath(Classpath c) {
		classpath.add(c);
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

	public List<Classpath> getClasspath() {
		return classpath;
	}

}
