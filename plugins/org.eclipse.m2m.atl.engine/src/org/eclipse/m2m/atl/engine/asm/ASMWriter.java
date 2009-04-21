/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *     Obeo - Compiler refactoring
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.asm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An abstract {@link ASM} writer.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public abstract class ASMWriter {

	private int lastCPIndex;

	private List cp = new ArrayList();

	private Map cpMap = new HashMap();

	public abstract void print(ASM asm);

	protected int getCPIndex(String s) {
		Integer ret = (Integer)cpMap.get(s);

		if (ret == null) {
			ret = new Integer(lastCPIndex++);
			cpMap.put(s, ret);
			cp.add(s);
		}

		return ret.intValue();
	}

	protected List getConstantPool() {
		return cp;
	}
}
