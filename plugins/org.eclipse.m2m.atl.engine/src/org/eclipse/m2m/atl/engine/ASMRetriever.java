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
package org.eclipse.m2m.atl.engine;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
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
public abstract class ASMRetriever {
	
	private static long id = 0;

	public static IFile getFile() {
		String key = "ID=" + id++;//$NON-NLS-1$
		return new DummyFile(key);
	}
	
	public static ASM getASM(IFile file) {
		String key = file.getLocation().toString();
		ASM ret = (ASM)dumpedASMs.get(key);
		dumpedASMs.remove(key);
		return ret;
	}
	
	private static Map dumpedASMs = new HashMap();
	
	static {
		try {
			ATLVMTools.addVMOperation(ASMEmitter.myType, ATLVMTools.toVMOperation(ASMRetriever.class, "dumpASM"));//$NON-NLS-1$
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
