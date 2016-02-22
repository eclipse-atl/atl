/*******************************************************************************
 * Copyright (c) 2016 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * {@link Method} signature for EMFTVM method caching.
 * 
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public final class MethodSignature {

	private final String name;
	private final Class<?>[] argumentTypes;
	private final boolean isStatic;

	/**
	 * Creates a new {@link MethodSignature}.
	 * 
	 * @param name
	 *            the method name
	 * @param argumentTypes
	 *            the method argument types
	 * @param isStatic
	 *            whether the method is static
	 */
	public MethodSignature(String name, Class<?>[] argumentTypes, boolean isStatic) {
		super();
		this.name = name;
		this.argumentTypes = argumentTypes;
		this.isStatic = isStatic;
	}

	/**
	 * Returns the method name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the method argument types.
	 * 
	 * @return the argumentTypes
	 */
	public Class<?>[] getArgumentTypes() {
		return argumentTypes;
	}

	/**
	 * Returns whether the method is static.
	 * 
	 * @return the isStatic
	 */
	public boolean isStatic() {
		return isStatic;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(argumentTypes);
		result = prime * result + (isStatic ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MethodSignature other = (MethodSignature) obj;
		if (!Arrays.equals(argumentTypes, other.argumentTypes))
			return false;
		if (isStatic != other.isStatic)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "MethodSignature [name=" + name + ", argumentTypes=" + Arrays.toString(argumentTypes) + ", isStatic="
				+ isStatic + "]";
	}

}
