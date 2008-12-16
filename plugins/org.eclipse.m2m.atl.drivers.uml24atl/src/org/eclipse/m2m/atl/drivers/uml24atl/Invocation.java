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
 * Stores an UML specific invocation method.
 *
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 * @author <a href="mailto:christophe.le-camus@c-s.fr">Christophe Le Camus</a>
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien Gabel</a>
 */
public class Invocation {

	private StackFrame frame;

	private ASMUMLModelElement self;

	private String opName;

	private List arguments;

	/**
	 * Creates a new delayed Invocation.
	 * 
	 * @param frame
	 *            the frame context
	 * @param self
	 *            the model element caller
	 * @param opName
	 *            the operation name
	 * @param arguments
	 *            the operation arguments
	 */
	public Invocation(StackFrame frame, ASMUMLModelElement self, String opName, List arguments) {
		this.frame = frame;
		this.self = self;
		this.opName = opName;
		this.arguments = arguments;
	}

	public StackFrame getFrame() {
		return frame;
	}

	public ASMUMLModelElement getSelf() {
		return self;
	}

	public String getOpName() {
		return opName;
	}

	public List getArguments() {
		return arguments;
	}
}
