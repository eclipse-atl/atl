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

/**
 * OCL simple type.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class OclSimpleType extends OclType {

	/**
	 * Constructor.
	 * 
	 * @param name
	 *            the type name
	 */
	public OclSimpleType(String name) {
		super();
		setName(name);
	}

	/**
	 * Constructor.
	 */
	public OclSimpleType() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (obj instanceof OclSimpleType) {
			return ((OclSimpleType)obj).getName().equals(getName());

		}
		return super.equals(obj);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.OclType#conformsTo(org.eclipse.m2m.atl.engine.emfvm.lib.OclType)
	 */
	public boolean conformsTo(OclType other) {
		boolean ret = equals(other);
		if (!ret && other != null) {
			Class currentClass = getNativeClassfromOclTypeName(getName());
			Class otherClass = getNativeClassfromOclTypeName(other.getName());
			ret = otherClass.isAssignableFrom(currentClass);
		}
		return ret;
	}

}
