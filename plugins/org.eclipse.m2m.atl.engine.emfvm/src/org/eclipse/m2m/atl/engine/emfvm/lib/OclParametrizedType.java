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

import org.eclipse.emf.ecore.EClass;

/**
 * An OCL complex type.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class OclParametrizedType extends OclType {

	private Object elementType;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.OclType#toString()
	 */
	public String toString() {
		return super.toString() + "(" + elementType + ")";
	}

	public Object getElementType() {
		return elementType;
	}

	public void setElementType(Object elementType) {
		this.elementType = elementType;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.OclType#conformsTo(org.eclipse.m2m.atl.engine.emfvm.lib.OclType)
	 */
	public boolean conformsTo(OclType other) {
		boolean ret = false;

		if (other instanceof OclParametrizedType) {
			final OclParametrizedType aopt = (OclParametrizedType)other;
			final String oname = aopt.getName();
			if ((oname.equals("Collection")) || (oname.equals(getName()))) {
				if ((elementType instanceof EClass) && (aopt.elementType instanceof EClass)) {
					ret = ((EClass)aopt.elementType).isSuperTypeOf((EClass)elementType);
				} else if ((elementType instanceof Class) && (aopt.elementType instanceof Class)) {
					ret = ((Class)aopt.elementType).isAssignableFrom((Class)elementType);
				}
			}
		}

		return ret;
	}
}
