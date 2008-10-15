/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm.adwp;

import java.util.List;

import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.engine.vm.DummyDebugger;
import org.eclipse.m2m.atl.engine.vm.ExecEnv;
import org.eclipse.m2m.atl.engine.vm.Operation;
import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * A StackFrame used for debugger queries to avoid recursive debugger activations.
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ADWPStackFrame extends StackFrame {

	public ADWPStackFrame(Operation op, List args) {
		super(myType, new ExecEnv(new DummyDebugger()), op, args);
	}

	// An error during a debugger request should not trigger the debugger
	public void printStackTrace(String msg, Exception e) {
		ATLLogger.severe(msg);
	}
}

