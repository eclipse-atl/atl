/*******************************************************************************
 * Copyright (c) 2006 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.ocl.core;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.m2m.atl.engine.ATLVMTools;
import org.eclipse.m2m.atl.engine.vm.ASM;
import org.eclipse.m2m.atl.engine.vm.ASMEmitter;

/**
 * ASM utility class.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public abstract class ASMRetriever {

	private static Map dumpedASMs = new HashMap();

	private static long id;

	private ASMRetriever() {
	}

	/**
	 * Return a dummy file.
	 * 
	 * @return a dummy file
	 */
	public static IFile getFile() {
		String key = "ID=" + id++; //$NON-NLS-1$
		return new DummyFile(key);
	}

	/**
	 * Retrieves an asm corresponding to a file.
	 * 
	 * @param file
	 *            a file
	 * @return the corresponding asm
	 */
	public static ASM getASM(IFile file) {
		String key = file.getLocation().toString();
		ASM ret = (ASM)dumpedASMs.get(key);
		dumpedASMs.remove(key);
		return ret;
	}

	static {
		ATLVMTools.addVMOperation(ASMEmitter.myType, ATLVMTools.toVMOperation(ASMRetriever.class, "dumpASM")); //$NON-NLS-1$
	}

	/*
	// New VM Operations
	public static void dumpASM(StackFrame frame, ASMEmitter self, ASMString fileName) {
		self.finishOperation();
		String key = ((ASMString)((ASMExecEnv)frame.getExecEnv()).getASMModule().get(frame, "fileName")).getSymbol(); //$NON-NLS-1$
		if (key.startsWith("ID=")) { //$NON-NLS-1$
			dumpedASMs.put(key, self.getASM());
		} else {
			self.dumpASM(fileName.getSymbol());
		}
	}
	*/
}
