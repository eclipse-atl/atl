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

import java.util.Map;
import java.util.Set;

/**
 * Provides extra functionality for finding supertypes of keys representing types.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 *
 * @param <K>
 * @param <V>
 */
public interface TypeMap<K, V> extends Map<K, V> {

	/**
	 * @param key
	 * @return this key or a supertype key if contained, or <code>null</code> if neither is not contained
	 * @see #containsKey(Object)
	 */
	Object findKey(Object key);

	/**
	 * Finds this key, if contained, and any contained supertype keys. 
	 * @param key
	 * @param keys the collection in which to store the found keys
	 * @see #containsKey(Object)
	 */
	void findAllKeys(Object key, Set<Object> keys);

}