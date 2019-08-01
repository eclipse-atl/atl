/*******************************************************************************
 * Copyright (c) 2016-2017 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
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

	private final String context;
	private final String name;
	private final String[] argumentTypes;
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
	public MethodSignature(Class<?> context, String name, Class<?>[] argumentTypes, boolean isStatic) {
		super();
		this.context = context.getName();
		this.name = name;
		if (argumentTypes != null) {
			this.argumentTypes = new String[argumentTypes.length];
			for (int i = 0; i < argumentTypes.length; i++) {
				this.argumentTypes[i] = argumentTypes[i].getName();
			}
		} else {
			this.argumentTypes = null;
		}
		this.isStatic = isStatic;
	}

	/**
	 * Returns the method context (i.e. declaring class).
	 * 
	 * @return the context
	 */
	public String getContext() {
		return context;
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
	public String[] getArgumentTypes() {
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
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (isStatic ? 1231 : 1237);
		result = prime * result + Arrays.hashCode(argumentTypes);
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
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (isStatic != other.isStatic)
			return false;
		if (!Arrays.equals(argumentTypes, other.argumentTypes))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "MethodSignature [context=" + context + ", name=" + name + ", argumentTypes="
				+ Arrays.toString(argumentTypes) + ", isStatic=" + isStatic + "]";
	}

}
