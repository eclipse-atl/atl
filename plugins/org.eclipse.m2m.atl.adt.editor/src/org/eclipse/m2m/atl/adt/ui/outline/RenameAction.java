/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tarik Idrissi (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.outline;

import org.eclipse.jface.viewers.ISelection;

public class RenameAction extends AtlAction {
	RenameFrame rf;

	public RenameAction(ISelection is) {
		super(is);
	}

	public void run() {
		rf = new RenameFrame(this);
	}
}
