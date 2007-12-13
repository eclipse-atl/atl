/*******************************************************************************
 * Copyright (c) 2006 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frédéric Jouault (INRIA) - initial API and implementation
 *    Matthias Bohlen
 *******************************************************************************/
package org.eclipse.m2m.atl.engine;

import java.net.URL;

/**
 * The 2004 version of the ATL compiler.
 */
public class Atl2004Compiler extends AtlDefaultCompiler {

    //@Override
    protected URL getSemanticAnalyzerURL()
    {
        return Atl2004Compiler.class.getResource("resources/ATL-WFR.asm");
    }

    //@Override
    protected URL getCodegeneratorURL()
    {
        return Atl2004Compiler.class.getResource("resources/ATLToASMCompiler.asm");
    }
}
