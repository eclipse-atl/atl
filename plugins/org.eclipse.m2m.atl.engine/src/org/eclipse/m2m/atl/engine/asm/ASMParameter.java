/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *     Obeo - Compiler refactoring
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.asm;

/**
 * Stores an {@link ASMOperation} parameter.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ASMParameter {

	private String name;

	private String type;

	/**
	 * Creates a parameter with the given name and type.
	 * 
	 * @param name the parameter name
	 * @param type the parameter type
	 */
	public ASMParameter(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return name + " : " + type; //$NON-NLS-1$
	}
}
