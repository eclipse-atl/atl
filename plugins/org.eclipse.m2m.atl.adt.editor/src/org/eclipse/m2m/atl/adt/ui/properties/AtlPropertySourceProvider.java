/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tarik Idrissi (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.properties;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;

public class AtlPropertySourceProvider implements IPropertySourceProvider {

	/**
	 * @see org.eclipse.ui.views.properties.IPropertySourceProvider#getPropertySource(java.lang.Object)
	 */
	public IPropertySource getPropertySource(Object object) {
		if (object instanceof EObject) {
			EObject eo = (EObject)object;
			return new AtlElementProperties(eo);
		}
		return null;
	}
}
