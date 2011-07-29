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
 * Nested Ant model element.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public abstract class ModelElement {

	private String name;
	private String as;
	private boolean allowInterModelReferences = true;

	/**
	 * Sets the model element name.
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the model element name.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the model element alias.
	 * @return the as
	 */
	public String getAs() {
		return as;
	}

	/**
	 * Sets the model element alias.
	 * @param as the as to set
	 */
	public void setAs(String as) {
		this.as = as;
	}

	/**
	 * Returns the allowInterModelReferences (default = <code>true</code>).
	 * @return the allowInterModelReferences
	 */
	public boolean isAllowInterModelReferences() {
		return allowInterModelReferences;
	}

	/**
	 * Sets the allowInterModelReferences with the allowInterModelReferences value.
	 * @param allowInterModelReferences the allowInterModelReferences to set
	 */
	public void setAllowInterModelReferences(boolean allowInterModelReferences) {
		this.allowInterModelReferences = allowInterModelReferences;
	}

}
