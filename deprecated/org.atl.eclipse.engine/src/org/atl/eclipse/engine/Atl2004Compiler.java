package org.atl.eclipse.engine;

import java.net.URL;

/**
 * The 2004 version of the ATL compiler.
 * 
 * @author Matthias Bohlen (refactored)
 */
public class Atl2004Compiler extends AtlDefaultCompiler {

    @Override
    protected URL getSemanticAnalyzerURL()
    {
        return Atl2004Compiler.class.getResource("resources/ATL-WFR.asm");
    }

    @Override
    protected URL getCodegeneratorURL()
    {
        return Atl2004Compiler.class.getResource("resources/ATLToASMCompiler.asm");
    }
}
