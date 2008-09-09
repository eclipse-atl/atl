/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm.lib;

import org.eclipse.emf.common.util.Enumerator;

/**
 * Enumeration literal implementation.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class EnumLiteral implements HasFields {

	private String name;

	/**
	 * Creates an EnumLiteral.
	 */
	public EnumLiteral() {
	}

	public void setName(String name) {
		this.name = name;
	}

	/**{@inheritDoc}
	 *
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return name;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.HasFields#get(org.eclipse.m2m.atl.engine.emfvm.lib.StackFrame, java.lang.Object)
	 */
	public Object get(StackFrame frame, Object literalName) {
		if ("name".equals(literalName)) {
			return this.name;
		} else {
			throw new VMException(frame, "error accessing EnumLiteral." + literalName);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.HasFields#set(org.eclipse.m2m.atl.engine.emfvm.lib.StackFrame, java.lang.Object, java.lang.Object)
	 */
	public void set(StackFrame frame, Object literalName, Object value) {
		if ("name".equals(literalName) && (value instanceof String)) {
			this.name = (String)value;
		} else {
			throw new VMException(frame, "error assigning " + value + " to EnumLiteral." + literalName);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object arg) {
		boolean ret = false;
		if (arg instanceof Enumerator) {
			ret = toString().equals(((Enumerator)arg).getLiteral());
		} else if (arg instanceof EnumLiteral) {
			ret = toString().equals(arg.toString());
		}
		return ret;
	}
}
