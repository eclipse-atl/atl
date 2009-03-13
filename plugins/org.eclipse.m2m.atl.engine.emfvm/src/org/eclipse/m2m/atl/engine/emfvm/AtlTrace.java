/*******************************************************************************
 * Copyright (c) 2009, Vrije Universiteit Brussel, Universidad de los Andes.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andres Yie (Vrije Universiteit Brussel, Universidad de los Andes)
 *    Dennis Wagelaar (Vrije Universiteit Brussel)
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm;

import java.util.Iterator;

import org.eclipse.m2m.atl.engine.emfvm.lib.ASMModule;
import org.eclipse.m2m.atl.engine.emfvm.lib.ExecEnv;

/**
 * Adapt the ASM instructions to replace the  native TransientLinkSet and TransientLink for an EMF version
 * 
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class AtlTrace {

	private ExecEnv env;

	/**
	 * Creates a new AtlTrace object.
	 * 
	 * @param env
	 *            The execution environment to adapt
	 */
	public AtlTrace(ExecEnv env) {
		this.env = env;
	}

	/**
	 * Changes the type of the TransienLinksSet & TransientLink Instances.
	 * @author Andres Yie <ayiegarz@vub.ac.be>
	 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
	 */
	public void adaptModuleOperations()  {
		for (Iterator i = env.getOperations(ASMModule.class).iterator(); i.hasNext();) {
			Object operation = i.next();
			if (operation instanceof ASMOperation) {
				adaptInstructions(((ASMOperation) operation).getBytecodes());
			}
		}		
	}

	/**
	 * Changes the type of the TransienLinksSet & TransientLink Instances in the received instructions.
	 * @param instructions
	 *            The list of instructions adapt.
	 * @author Andres Yie <ayiegarz@vub.ac.be>
	 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
	 */
	private void adaptInstructions(Bytecode[] instructions) {
		for (int i = 0; i < instructions.length; i++) {
			Bytecode ins = instructions[i];
			if ((ins.toString().equals("push TransientLinkSet")) || (ins.toString().equals("push TransientLink")) ) {
				instructions[++i].setOperand("__TRACE");
			}
		}
	}
	
}
