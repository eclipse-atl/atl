/*******************************************************************************
 * Copyright (c) 2007 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault - initial API and implementation
 *    William Piers - oclType implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm.lib;

import org.eclipse.m2m.atl.engine.emfvm.Messages;
import org.eclipse.m2m.atl.engine.emfvm.VMException;


/**
 * An OCL complex type.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class OclParametrizedType extends OclType {

	private OclType elementType;

	/**
	 * Constructor.
	 * 
	 * @param name
	 *            the type name
	 * @param elementType
	 *            the type
	 */
	public OclParametrizedType(String name, Object elementType) {
		super();
		setName(name);
		setElementType(elementType);
	}

	/**
	 * Constructor.
	 */
	public OclParametrizedType() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof OclParametrizedType) {
			return ((OclParametrizedType)obj).getName().equals(getName())
					&& ((OclParametrizedType)obj).getElementType().equals(elementType);
		}
		return super.equals(obj);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.OclType#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "(" + elementType + ")"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public OclType getElementType() {
		return elementType;
	}

	/**
	 * Sets the element type.
	 * 
	 * @param elementType
	 *            the type to set
	 */
	public void setElementType(Object elementType) {
		if (elementType instanceof OclType) {
			this.elementType = (OclType)elementType;
		} else {
			OclType oclType = getOclTypeFromObject(elementType);
			if (oclType != null) {
				this.elementType = getOclTypeFromObject(elementType);
			} else {
				throw new VMException(null, Messages.getString("OclParametrizedType.UNDEFINED_PARAM_TYPE") + elementType); //$NON-NLS-1$
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.OclType#conformsTo(org.eclipse.m2m.atl.engine.emfvm.lib.OclType)
	 */
	@Override
	public boolean conformsTo(OclType other) {
		boolean ret = equals(other);
		if (!ret && other instanceof OclParametrizedType) {
			OclParametrizedType aopt = (OclParametrizedType)other;
			if ("Collection".equals(aopt.getName())) { //$NON-NLS-1$
				ret = elementType.conformsTo(aopt.getElementType());
			} else {
				ret = aopt.getName().equals(getName()) && elementType.conformsTo(aopt.getElementType());
			}
		}
		return ret;
	}
}
