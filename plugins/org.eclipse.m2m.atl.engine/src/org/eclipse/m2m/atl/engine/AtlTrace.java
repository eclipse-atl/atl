/*******************************************************************************
 * Copyright (c) 2004-2008 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andres Yie (Vrije Universiteit Brussel, Universidad de los Andes)
 *    Dennis Wagelaar (Vrije Universiteit Brussel)
 *******************************************************************************/
package org.eclipse.m2m.atl.engine;

import java.util.Iterator;
import java.util.List;

import org.eclipse.m2m.atl.engine.vm.ASMExecEnv;
import org.eclipse.m2m.atl.engine.vm.ASMInstruction;
import org.eclipse.m2m.atl.engine.vm.ASMInstructionWithOperand;
import org.eclipse.m2m.atl.engine.vm.ASMOperation;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModule;

/**
 * Adapt the ASM instructions to replace the  native TransientLinkSet and TransientLink for an EMF version
 * 
 * @author <a href="mailto:ayiegarz@vub.ac.be">Andres Yie</a>
 */
public class AtlTrace {

	private ASMExecEnv env;

	/**
	 * Creates a new AtlTrace object.
	 * 
	 * @param env
	 *            The execution environment to adapt
	 */
	public AtlTrace(ASMExecEnv env) {
		this.env = env;
	}
	
	/**
	 * Changes the type of the TransienLinksSet & TransientLink Instances.
	 * @author Andres Yie <ayiegarz@vub.ac.be>
	 */
	public void adaptModuleOperations () {
		for (Iterator i = env.getOperations(ASMModule.myType).iterator(); i.hasNext();) {
			Object operation = i.next();
			if (operation instanceof ASMOperation) {
				adaptInstructions(((ASMOperation) operation).getInstructions());
			}
		}		
	}
	
	
	/**
	 * Changes the type of the TransienLinksSet & TransientLink Instances in the received instructions.
	 * @param into
	 *            The list of instructions adapt.
	 * @author Andres Yie <ayiegarz@vub.ac.be>
	 */
	private void adaptInstructions(List instructions) {
		for (int i = 0; i < instructions.size(); i++) {
			ASMInstruction ins = (ASMInstruction)instructions.get(i);
			if ((ins.toString().equals("push TransientLinkSet")) || (ins.toString().equals("push TransientLink")) ) {
				((ASMInstructionWithOperand) instructions.get(++i)).setOperand("__TRACE");
			}
		}
	}
	
}
