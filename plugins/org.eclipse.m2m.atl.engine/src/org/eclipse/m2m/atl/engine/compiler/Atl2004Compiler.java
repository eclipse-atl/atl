/*******************************************************************************
 * Copyright (c) 2006 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *    Matthias Bohlen
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.compiler;

import java.net.URL;

/**
 * The 2004 version of the ATL compiler.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:mbohlen@mbohlen.de">Matthias Bohlen</a>
 */
public class Atl2004Compiler extends AtlDefaultCompiler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.compiler.AtlDefaultCompiler#getSemanticAnalyzerURL()
	 */
	protected URL getSemanticAnalyzerURL() {
		return Atl2004Compiler.class.getResource("resources/ATL-WFR.asm"); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.compiler.AtlDefaultCompiler#getCodegeneratorURL()
	 */
	protected URL getCodegeneratorURL() {
		return Atl2004Compiler.class.getResource("resources/ATLToASMCompiler.asm"); //$NON-NLS-1$
	}
}
