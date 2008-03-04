/**
 * Copyright (c) 2007, 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: ReferenceModel.java,v 1.2.4.1 2008/03/04 21:12:13 mbarbero Exp $
 */

package org.eclipse.m2m.atl.engine.emfvm.lib;

/**
 * 
 * @author Mikael Barbero
 * @author Frederic Jouault
 *
 */
public interface ReferenceModel extends Model {

	public abstract Object getMetaElementByName(String name);
}
