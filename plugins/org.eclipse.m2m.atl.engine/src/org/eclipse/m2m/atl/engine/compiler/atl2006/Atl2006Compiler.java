/*******************************************************************************
 * Copyright (c) 2004 INRIA and other.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *    Matthias Bohlen
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.compiler.atl2006;

import java.net.URL;

import org.eclipse.m2m.atl.engine.compiler.AtlDefaultCompiler;

/**
 * The 2006 version of the ATL compiler.
 * 
 * @author <a href="mailto:mbohlen@mbohlen.de">Matthias Bohlen</a>
 */
public class Atl2006Compiler extends AtlDefaultCompiler {

	// @Override
	protected URL getSemanticAnalyzerURL() {
		return Atl2006Compiler.class.getResource("resources/ATL-WFR.asm"); //$NON-NLS-1$
	}

	// @Override
	protected URL getCodegeneratorURL() {
		return Atl2006Compiler.class.getResource("resources/ATLToASMCompiler.asm"); //$NON-NLS-1$
	}

}
