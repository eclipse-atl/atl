/*******************************************************************************
 * Copyright (c) 2005 INRIA. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v2.0 
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors: 
 *     INRIA - Initial API and implementation
 *	   Obeo - ATL adaptation     
 ******************************************************************************/
package org.eclipse.m2m.atl.core.ant.tasks.nested;

import java.io.File;

/**
 * Superimpose nested element.
 * 
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class Superimpose {

	protected File path;
	
	public File getPath() {
		return path;
	}

	public void setPath(File path) {
		this.path = path;
	}
	
}