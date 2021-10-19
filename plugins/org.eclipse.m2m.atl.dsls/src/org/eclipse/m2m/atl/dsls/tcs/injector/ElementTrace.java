/**
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: ElementTrace.java,v 1.1 2009/04/21 14:12:27 wpiers Exp $
 */
package org.eclipse.m2m.atl.dsls.tcs.injector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 *
 */
public class ElementTrace {

	private final Object element;
	private Object location;
	private Map<String, Object> propertyLocations = null;

	public ElementTrace(final Object element) {
		this.element = element;
	}

	@SuppressWarnings("unchecked")
	public void addPropertyLocation(final String propertyName, final Object location) {
		if(propertyLocations == null) {
			propertyLocations = new HashMap<>();
		}
		final Object previousLocation = propertyLocations.get(propertyName);
		if(previousLocation == null) {
			propertyLocations.put(propertyName, location);
		} else if(previousLocation instanceof Collection) {
			((Collection<Object>)previousLocation).add(location);
		} else {
			final Collection<Object> c = new ArrayList<>();
			c.add(previousLocation);
			c.add(location);
			propertyLocations.put(propertyName, c);
		}
	}

	public Object getElement() {
		return element;
	}

	public void setLocation(final Object location) {
		this.location = location;
	}

	public Object getLocation() {
		return location;
	}

	public Object getPropertyLocation(final String propertyName) {
		return propertyLocations.get(propertyName);
	}
}
