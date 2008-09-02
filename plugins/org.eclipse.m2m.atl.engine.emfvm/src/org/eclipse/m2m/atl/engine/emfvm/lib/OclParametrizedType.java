/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Fr�d�ric Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm.lib;

import org.eclipse.emf.ecore.EClass;

public class OclParametrizedType extends OclType {

	private Object elementType;
	
	public String toString() {
		return super.toString() + "(" + elementType + ")";
	}

	public Object getElementType() {
		return elementType;
	}

	public void setElementType(Object elementType) {
		this.elementType = elementType;
	}
	
	public boolean conformsTo(OclType other) {
		boolean ret = false;
		
		if(other instanceof OclParametrizedType) {
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
