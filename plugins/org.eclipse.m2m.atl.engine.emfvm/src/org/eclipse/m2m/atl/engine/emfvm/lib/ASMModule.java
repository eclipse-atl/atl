/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm.lib;

import java.util.HashMap;
import java.util.Map;

/**
 * The ASM Module, which symbolizes an ATL transformation.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ASMModule implements HasFields {

	private Map<Object, Object> fields = new HashMap<Object, Object>();

	private String moduleName;

	/**
	 * Creates a new ASMModule with the given name.
	 * 
	 * @param name
	 *            the module name
	 */
	public ASMModule(String name) {
		this.moduleName = name;
	}

	/**
	 * Creates a new ASMModule.
	 */
	public ASMModule() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.HasFields#set(org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame,
	 *      java.lang.Object, java.lang.Object)
	 */
	public void set(AbstractStackFrame frame, Object name, Object value) {
		fields.put(name, value);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.HasFields#get(org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame,
	 *      java.lang.Object)
	 */
	public Object get(AbstractStackFrame frame, Object name) {
		return fields.get(name);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.HasFields#unset(org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame,
	 *      java.lang.Object)
	 */
	public void unset(AbstractStackFrame frame, Object name) {
		fields.remove(name);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (moduleName != null) {
			return moduleName + " : ASMModule"; //$NON-NLS-1$
		}
		return "thisModule"; //$NON-NLS-1$
	}

	/**
	 * Returns the map of the fields.
	 * 
	 * @return the map of the fields
	 */
	public Map<Object, Object> asMap() {
		return fields;
	}
}
