/*******************************************************************************
 * Copyright (c) 2006 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frédéric Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.ocl.core;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.engine.ASMRetriever;
import org.eclipse.m2m.atl.engine.AtlCompiler;
import org.eclipse.m2m.atl.engine.vm.ASM;

/**
 * 
 * @author Frédéric Jouault
 *
 */
public abstract class OclEvaluator {
	
	protected EObject pbs[];

	protected ASM compile(String atl) throws Exception {
		AtlCompiler ac = AtlCompiler.getDefault();
		
		// forcing usage of ATL 2006
		atl = "-- @atlcompiler atl2006\n" + atl;
		ByteArrayInputStream input = new ByteArrayInputStream(atl.getBytes());
		IFile file = ASMRetriever.getFile();
		pbs = ac.compile(input, file);
		input.close();
//		for(int i = 0 ; i < pbs.length ; i++) {
//			String sev = get(pbs[i], "severity").toString();
//			System.out.println(sev + ":" + get(pbs[i], "location") + ":" + get(pbs[i], "description"));
//		}
		return ASMRetriever.getASM(file);
	}
}
