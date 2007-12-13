/*******************************************************************************
 * Copyright (c) 2004 INRIA and C-S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *    Christophe Le Camus (C-S) - initial API and implementation
 *    Sebastien Gabel (C-S) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.drivers.uml24atl;

import java.util.List;

import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * @author Frédéric Jouault (INRIA)
 * @author Freddy Allilaire (INRIA)
 * @author Christophe Le Camus (C-S)
 * @author Sebastien Gabel (C-S) 
 */
public class Invocation {
	public Invocation(StackFrame frame, ASMUMLModelElement self, String opName, List arguments) {
		this.frame = frame;
		this.self = self;
		this.opName = opName;
		this.arguments = arguments;
	}
	
	public StackFrame frame;
	public ASMUMLModelElement self;
	public String opName;
	public List arguments;
}