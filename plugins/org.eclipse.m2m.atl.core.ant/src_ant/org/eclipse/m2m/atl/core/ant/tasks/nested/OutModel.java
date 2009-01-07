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
 * Output model nested element.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class OutModel {

	protected String model;

	protected String name;

	protected String metamodel;

	protected String modelHandler;

	protected String factory;

	protected String path;

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getModelHandler() {
		return modelHandler;
	}

	public void setModelHandler(String modelHandler) {
		this.modelHandler = modelHandler;
	}

	public String getMetamodel() {
		return metamodel;
	}

	public void setMetamodel(String metamodel) {
		this.metamodel = metamodel;
	}

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

	/**
	 * Sets the path parameter.
	 * 
	 * @param path
	 *            The path to set.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Gets the path parameter.
	 * 
	 * @return Returns the path.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public String getPath() {
		return path;
	}

}
