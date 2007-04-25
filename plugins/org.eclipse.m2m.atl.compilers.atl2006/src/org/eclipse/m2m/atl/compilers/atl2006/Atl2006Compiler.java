package org.eclipse.m2m.atl.compilers.atl2006;

import java.net.URL;

import org.eclipse.m2m.atl.engine.AtlDefaultCompiler;

/**
 * The 2006 version of the ATL compiler.
 * 
 * @author Matthias Bohlen (refactored)
 */
public class Atl2006Compiler extends AtlDefaultCompiler {

    @Override
    protected URL getSemanticAnalyzerURL()
    {
        return Atl2006Compiler.class.getResource("resources/ATL-WFR.asm");
    }

    @Override
    protected URL getCodegeneratorURL()
    {
        return Atl2006Compiler.class.getResource("resources/ATLToASMCompiler.asm");
    }
	
}
