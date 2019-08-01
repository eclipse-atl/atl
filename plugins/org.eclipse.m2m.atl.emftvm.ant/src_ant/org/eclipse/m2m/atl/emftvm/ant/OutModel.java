/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.ant;

/**
 * Nested Ant output model element.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class OutModel extends ModelElement {

	private String wspath;
	private String uri;

	/**
	 * Sets the output model workspace path.
	 * @param wspath the path to set
	 */
	public void setWspath(String wspath) {
		this.wspath = wspath;
	}

	/**
	 * Returns the output model workspace path.
	 * @return the path
	 */
	public String getWspath() {
		return wspath;
	}

	/**
	 * Sets the model URI.
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * Returns the model URI.
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

}
