package org.atl.eclipse.engine;

import java.io.InputStream;

import org.eclipse.emf.ecore.EObject;

/**
 * Eclipse-independent interface for ATL compilers.
 * 
 * @author Matthias Bohlen
 * 
 */
public interface AtlStandaloneCompiler
{
    /**
     * Compiles an ATL script and returns easily accessible error messages.
     * 
     * @param in
     *            The InputStream to get atl source from.
     * @param outputFileName
     *            Name of the file to which the ATL compiled program will be
     *            saved.
     * @return array of compiletime errors (0 length if no errors)
     */
    public CompileTimeError[] compile(InputStream in, String outputFileName);

    /**
     * Compiles an ATL script and returns easily accessible error messages.
     * 
     * @param in
     *            The InputStream to get atl source from.
     * @param outputFileName
     *            Name of the file to which the ATL compiled program will be
     *            saved.
     * @return array of compiletime errors as EObjects (0 length if no errors)
     */
    public EObject[] compileWithProblemModel(InputStream in, String outputFileName);
}
