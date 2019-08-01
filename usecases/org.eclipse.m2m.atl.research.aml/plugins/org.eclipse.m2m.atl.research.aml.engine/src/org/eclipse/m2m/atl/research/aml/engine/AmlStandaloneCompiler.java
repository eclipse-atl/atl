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

import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;

/**
 * 
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a>
 *
 */

public interface AmlStandaloneCompiler {
	
	/**
	 * inject an aml text file 
	 * @param in aml text file
	 * @param file aml model
	 * @return semantic problems
	 * @throws ATLCoreException 
	 */
	
	public IModel[] injectAMLTextFile(final InputStream in) throws ATLCoreException;	
	
	public IModel injectParameterTextFile(final InputStream in);
	
	/**
	 * compiles AML code into matching model transformations and reports errors
	 * 
	 * @param in
	 */
	public IModel compileMatchingCode(IModel in);
	
	/**
	 * compiles AML code into model transformation chain code and reports errors
	 * 
	 * @param in
	 * @return pbms
	 */
	
	public IModel compileTransfChainCode(IModel in);
	
	public IModel compilePropertiesCode(IModel amlModel, IModel parameterModel);
	
	public Map<String, ByteArrayOutputStream> extractMatchingCode(IModel matchingCodeModel);
		
	public Map<String, ByteArrayOutputStream> extractTransfChainCode(IModel in);
	
	public ByteArrayOutputStream extractParameterCode(IModel parameterModel);
	
	public IReferenceModel getAmlMetamodel ();
	
	public abstract Map<String, InputStream> getMatchingLibraries();
	
	
	
}
