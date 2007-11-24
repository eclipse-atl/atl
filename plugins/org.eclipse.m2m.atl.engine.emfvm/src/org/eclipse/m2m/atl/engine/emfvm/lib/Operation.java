/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frédéric Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm.lib;


public abstract class Operation {

	public int maxLocals;
	
	public Operation(int maxLocals) {
		this.maxLocals = maxLocals;
	}
	
	public abstract Object exec(StackFrame frame);

	public int getMaxLocals() {
		return maxLocals;
	}

}
