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
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.atl.engine.AtlCompiler;
import org.eclipse.m2m.atl.engine.vm.ASM;
import org.eclipse.m2m.atl.engine.vm.ASMEmitter;
import org.eclipse.m2m.atl.engine.vm.ASMExecEnv;
import org.eclipse.m2m.atl.engine.vm.StackFrame;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMString;

/**
 * 
 * @author Frédéric Jouault
 *
 */
public abstract class OclEvaluator {
	
	private static long id = 0;
	protected EObject pbs[];

	protected ASM compile(String atl) throws Exception {
		ASM ret = null;
//		System.out.println(atl);
		AtlCompiler ac = AtlCompiler.getDefault();
		
		String key = "ID=" + id++;//$NON-NLS-1$
		ByteArrayInputStream input = new ByteArrayInputStream(atl.getBytes());
		pbs = ac.compile(input, new DummyFile(key));
		input.close();
//		for(int i = 0 ; i < pbs.length ; i++) {
//			String sev = get(pbs[i], "severity").toString();
//			System.out.println(sev + ":" + get(pbs[i], "location") + ":" + get(pbs[i], "description"));
//		}
		ret = (ASM)dumpedASMs.get(key);
		dumpedASMs.remove(key);
		return ret;
	}
	
	private static Object get(EObject o, String f) {
		EStructuralFeature sf = o.eClass().getEStructuralFeature(f);
		return o.eGet(sf);
	}
	
	private static Map dumpedASMs = new HashMap();
	
	static {
		try {
			ATLVMTools.addVMOperation(ASMEmitter.myType, ATLVMTools.toVMOperation(OclEvaluator.class, "dumpASM"));//$NON-NLS-1$
		} catch(Exception e) {
			
		}
	}

	// New VM Operations
	public static void dumpASM(StackFrame frame, ASMEmitter self, ASMString fileName) {
		self.finishOperation();
		String key = ((ASMString)((ASMExecEnv)frame.getExecEnv()).getASMModule().get(frame, "fileName")).getSymbol();//$NON-NLS-1$
		if(key.startsWith("ID=")) {//$NON-NLS-1$
			dumpedASMs.put(key, self.getASM());
		} else {
			self.dumpASM(fileName.getSymbol());
		}
	}	
}
