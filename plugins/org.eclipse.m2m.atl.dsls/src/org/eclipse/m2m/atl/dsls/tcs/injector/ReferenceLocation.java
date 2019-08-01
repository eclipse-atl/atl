/**
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: ReferenceLocation.java,v 1.2 2009/09/24 08:19:06 wpiers Exp $
 */
package org.eclipse.m2m.atl.dsls.tcs.injector;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 *
 */
public class ReferenceLocation {

	private Object sourceLocation;
	private Object target;

	public ReferenceLocation(Object sourceLocation, Object target) {
		this.sourceLocation = sourceLocation;
		this.target = target;
	}

	public Object getSourceLocation() {
		return sourceLocation;
	}

	public Object getTarget() {
		return target;
	}
}
