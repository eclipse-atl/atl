/*******************************************************************************
 * Copyright (c) 2009 Ecole des Mines de Nantes.

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Kelly Garces - initial API and implementation and/or initial documentation
 *******************************************************************************/ 

package org.eclipse.m2m.atl.research.aml.engine;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.logging.Logger;

import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;

/**
 * 
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a>
 *
 */

public class AmlCompiler {
	
	protected static Logger logger = Logger.getLogger(AmlEnginePlugin.LOGGER);

	private static AmlCompiler defaultCompiler = null;
	
	public static AmlCompiler getDefault() {
		if(defaultCompiler == null) {
			defaultCompiler = new AmlCompiler();
		}
		return defaultCompiler;
	}

	public IModel compileMatchingCode(IModel in) {
        
        return getCompiler().compileMatchingCode(in);
	}
	
	
	public IModel compileTransfoChainCode(IModel in) {
        
        return getCompiler().compileTransfChainCode(in);

	}
	
	public IModel compilePropertiesCode(IModel amlModel, IModel paramModel) {
        
        return getCompiler().compilePropertiesCode(amlModel, paramModel);

	}
	
	public IModel[] injectAMLTextFile(final InputStream in) throws ATLCoreException {
		
		return getCompiler().injectAMLTextFile(in);
		
	}
	
	public IModel injectParameterTextFile(InputStream in) {
		
		return getCompiler().injectParameterTextFile(in);
		
	}
	
	public Map<String, ByteArrayOutputStream> extractMatchingCode(IModel in){
		return getCompiler().extractMatchingCode(in);
	}
		
	public Map<String, ByteArrayOutputStream> extractTransfoChainCode(IModel in){
		return getCompiler().extractTransfChainCode(in);
	}
	
	public ByteArrayOutputStream extractParameterCode(IModel parameterModel){
		return getCompiler().extractParameterCode(parameterModel);
	}
	
	
	public IReferenceModel getAmlMetamodel () {
		return getCompiler().getAmlMetamodel();
	}
	private static AmlStandaloneCompiler compiler;

	/**
     * Searches for the correct implementation of {@link AmlStandaloneCompiler}
     * which is independent of Eclipse platform stuff like IFile, IResource, etc.
     * 
	 * @param compilerName name of the compiler to search for
	 * @return the compiler which was found
	 */
	public static AmlStandaloneCompiler getCompiler() {
		if(compiler == null) { 
			compiler = new Aml2009Compiler();
		}
		return compiler;
	}
	

}
