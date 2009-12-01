/*******************************************************************************
 * Copyright (c) 2009 Ecole des Mines de Nantes.

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kelly Garces - initial API and implementation and/or initial documentation
 *******************************************************************************/ 

package org.eclipse.m2m.atl.research.aml.utils;

/**
 * 
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a>
 *
 */
public class ResourceUtils {
	
	public final static String fileSeparator = System.getProperty("file.separator");
	
	public static String getPathWithSeparator(String... fragments) {
	
		String fragmentsSep = "";
		
		for (int i = 0; i < fragments.length; i++) {
			fragmentsSep = fragmentsSep + fileSeparator
					+ fragments[i];
		}
	
		return fragmentsSep;
	}
	
	

}
