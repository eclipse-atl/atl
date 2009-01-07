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

/**
 * Input model nested element.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class InModel {

	protected String model;

	protected String name;

	public void setModel(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
