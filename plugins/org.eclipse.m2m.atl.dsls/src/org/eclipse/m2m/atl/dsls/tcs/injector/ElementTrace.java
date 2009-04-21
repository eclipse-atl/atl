/**
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

	private Object element;
	private Object location;
	private Map propertyLocations = null;

	public ElementTrace(Object element) {
		this.element = element;
	}

	public void addPropertyLocation(String propertyName, Object location) {
		if(propertyLocations == null) {
			propertyLocations = new HashMap();
		}
		Object previousLocation = propertyLocations.get(propertyName);
		if(previousLocation == null) {
			propertyLocations.put(propertyName, location);
		} else if(previousLocation instanceof Collection) {
			((Collection)previousLocation).add(location);
		} else {
			Collection c = new ArrayList();
			c.add(previousLocation);
			c.add(location);
			propertyLocations.put(propertyName, c);
		}
	}

	public Object getElement() {
		return element;
	}

	public void setLocation(Object location) {
		this.location = location;
	}

	public Object getLocation() {
		return location;
	}

	public Object getPropertyLocation(String propertyName) {
		return propertyLocations.get(propertyName);
	}
}
