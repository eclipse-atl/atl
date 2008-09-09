/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.debug.core;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.m2m.atl.engine.vm.adwp.Value;

/**
 * Map elements are special case of AtlValue There is a key and a value. AtlMapValue represents this special
 * value
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class AtlMapValue implements IValue {

	private Value key;

	private Value valueKey;

	private AtlDebugTarget atlDT;

	/**
	 * This AtlMapValue is built with two value (key, value) and a debug target.
	 * 
	 * @param key the key
	 * @param value the value
	 * @param atlDT the debug target
	 */
	public AtlMapValue(Value key, Value value, AtlDebugTarget atlDT) {
		this.key = key;
		this.valueKey = value;
		this.atlDT = atlDT;
	}

	/**
	 * {@inheritDoc} This returns the two variables composing a AtlMapValue.
	 * 
	 * @see org.eclipse.debug.core.model.IValue#getVariables()
	 */
	public IVariable[] getVariables() throws DebugException {
		IVariable[] ret = null;

		List list = new ArrayList();
		list.add(new AtlVariable(AtlDebugModelConstants.KEY, new AtlValue(key, atlDT), atlDT,
				AtlVariable.ATTRIBUTE));
		list.add(new AtlVariable(AtlDebugModelConstants.VALUE, new AtlValue(valueKey, atlDT), atlDT,
				AtlVariable.ATTRIBUTE));
		ret = (IVariable[])list.toArray(new IVariable[0]);

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IValue#getReferenceTypeName()
	 */
	public String getReferenceTypeName() throws DebugException {
		return AtlDebugModelConstants.MAPELEMENT;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IValue#getValueString()
	 */
	public String getValueString() throws DebugException {
		return AtlDebugModelConstants.MAPELEMENT;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IValue#isAllocated()
	 */
	public boolean isAllocated() throws DebugException {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IValue#hasVariables()
	 */
	public boolean hasVariables() throws DebugException {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IDebugElement#getModelIdentifier()
	 */
	public String getModelIdentifier() {
		return atlDT.getModelIdentifier();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IDebugElement#getDebugTarget()
	 */
	public IDebugTarget getDebugTarget() {
		return atlDT.getDebugTarget();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IDebugElement#getLaunch()
	 */
	public ILaunch getLaunch() {
		return atlDT.getLaunch();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public Object getAdapter(Class adapter) {
		return null;
	}

}
