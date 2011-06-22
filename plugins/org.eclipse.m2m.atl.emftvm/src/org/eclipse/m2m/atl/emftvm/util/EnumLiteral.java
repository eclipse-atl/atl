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
package org.eclipse.m2m.atl.emftvm.util;

import java.io.Serializable;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;

/**
 * Generic enumeration literal.
 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
 */
public final class EnumLiteral implements Serializable {

	private static final long serialVersionUID = 7503527808770330739L;

	private final String name;

	/**
	 * Creates a new {@link EnumLiteral}.
	 * @param name the literal name
	 */
	public EnumLiteral(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(getClass().getSimpleName());
		buf.append('(');
		buf.append(getName());
		buf.append(')');
		return buf.toString();
	}

	/**
	 * @param eEnum
	 * @return the type-safe enumeration literal for eEnum
	 * @throws IllegalArgumentException if not found
	 */
	public Enumerator getEnumerator(final EEnum eEnum) {
		final String name = getName();
		EEnumLiteral ret = eEnum.getEEnumLiteralByLiteral(name);
		if (ret == null) {
			ret = eEnum.getEEnumLiteral(name);
		}
		if (ret == null) {
			throw new IllegalArgumentException(String.format(
					"Enumeration literal %s not found in %s", name, eEnum));
		}
		return ret.getInstance();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnumLiteral other = (EnumLiteral) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
