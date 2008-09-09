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

/**
 * OCL simple type.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class OclSimpleType extends OclType {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.OclType#conformsTo(org.eclipse.m2m.atl.engine.emfvm.lib.OclType)
	 */
	public boolean conformsTo(OclType other) {
		throw new RuntimeException("OclSimpleType.conformsTo(OclType) not yet implemented");
	}
}
