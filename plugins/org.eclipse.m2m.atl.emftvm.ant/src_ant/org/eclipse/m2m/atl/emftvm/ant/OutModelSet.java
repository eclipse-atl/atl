/*******************************************************************************
 * Copyright (c) 2021 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.ant;

import java.io.File;

/**
 * Nested Ant output model element set.
 * 
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class OutModelSet extends ModelElement {

	private File dir;
	private String suffix;

	/**
	 * Returns the base directory.
	 * 
	 * @return the dir
	 */
	public File getDir() {
		return dir;
	}

	/**
	 * Sets the base directory.
	 * 
	 * @param dir the dir to set
	 */
	public void setDir(File dir) {
		this.dir = dir;
	}

	/**
	 * Sets the model filename suffix.
	 * 
	 * @param suffix the suffix to set
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	/**
	 * Returns the model filename suffix.
	 * 
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}

}
