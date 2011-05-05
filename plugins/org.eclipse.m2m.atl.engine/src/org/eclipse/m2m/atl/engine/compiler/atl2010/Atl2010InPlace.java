/*******************************************************************************
 * Copyright (c) 2010 INRIA and other.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *    Salvador Martinez Perez
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.compiler.atl2010;

import java.net.URL;

import org.eclipse.m2m.atl.engine.compiler.AtlDefaultCompiler;

/**
 * The 2010 in-place version of the ATL compiler.
 * 
 * @author <a href="mailto:Salvador.Martinez_Perez@inria.fr">Salvador Martinez Perez</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class Atl2010InPlace extends AtlDefaultCompiler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.compiler.AtlDefaultCompiler#getCodegeneratorURL()
	 */
	protected URL getCodegeneratorURL() {
		return Atl2010InPlace.class.getResource("resources/ATLToASMCompiler.asm");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.compiler.AtlDefaultCompiler#getSemanticAnalyzerURL()
	 */
	protected URL getSemanticAnalyzerURL() {
		return Atl2010InPlace.class.getResource("resources/ATL-WFR.asm");
	}

}
