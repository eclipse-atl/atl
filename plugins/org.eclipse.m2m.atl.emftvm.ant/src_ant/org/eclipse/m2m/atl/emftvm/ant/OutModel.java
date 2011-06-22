/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

	/**
	 * @param wspath the path to set
	 */
	public void setWspath(String wspath) {
		this.wspath = wspath;
	}

	/**
	 * @return the path
	 */
	public String getWspath() {
		return wspath;
	}

}
