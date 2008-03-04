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
 * $Id: AbstractModel.java,v 1.1.2.1 2008/03/04 21:12:13 mbarbero Exp $
 */

package org.eclipse.m2m.atl.engine.emfvm.lib;

/**
 * 
 * @author Mikaël Barbero
 *
 */
public abstract class AbstractModel implements Model {

	protected ReferenceModel referenceModel;
	
	public boolean isTarget = false;
}
