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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.adt.ui.outline.AtlEMFConstants;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

public class AtlElementProperties implements IPropertySource {

	private EObject eo;

	/**
	 * Used to build the list of property descriptors property descriptor id => property display name
	 */
	private static Map<String, String> properties = new HashMap<String, String>();

	private static final String INFO_CATEGORY = "Info"; //$NON-NLS-1$

	private static final String PROPERTY_ID_LOCATION = "location"; //$NON-NLS-1$

	private static final String PROPERTY_ID_TYPE = "type"; //$NON-NLS-1$

	private static final String PROPERTY_ID_NAME = "name"; //$NON-NLS-1$

	static {
		properties.put(PROPERTY_ID_LOCATION, "Location"); //$NON-NLS-1$
		properties.put(PROPERTY_ID_TYPE, "Type"); //$NON-NLS-1$
		properties.put(PROPERTY_ID_NAME, "Name"); //$NON-NLS-1$
	}

	public AtlElementProperties(EObject eo) {
		this.eo = eo;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.views.properties.IPropertySource#getEditableValue()
	 */
	public Object getEditableValue() {
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyDescriptors()
	 */
	public IPropertyDescriptor[] getPropertyDescriptors() {
		IPropertyDescriptor[] pds = new IPropertyDescriptor[properties.size()];
		int cpt = 0;
		for (Iterator<String> keys = properties.keySet().iterator(); keys.hasNext();) {
			String propertyId = keys.next();
			String propertyDisplayName = properties.get(propertyId);
			PropertyDescriptor pd = new PropertyDescriptor(propertyId, propertyDisplayName);
			pd.setCategory(INFO_CATEGORY);
			pds[cpt++] = pd;
		}
		return pds;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyValue(java.lang.Object)
	 */
	public Object getPropertyValue(Object id) {
		String value;
		if (id.equals(PROPERTY_ID_LOCATION))
			value = (String)eo.eGet(AtlEMFConstants.sfLocation);
		else if (id.equals(PROPERTY_ID_TYPE))
			value = eo.eClass().getName();
		else
			value = ""; //$NON-NLS-1$

		return value;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.views.properties.IPropertySource#isPropertySet(java.lang.Object)
	 */
	public boolean isPropertySet(Object id) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.views.properties.IPropertySource#resetPropertyValue(java.lang.Object)
	 */
	public void resetPropertyValue(Object id) {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.views.properties.IPropertySource#setPropertyValue(java.lang.Object, java.lang.Object)
	 */
	public void setPropertyValue(Object id, Object value) {
	}
}
