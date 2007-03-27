/*
 * Created on 1 juin 2004
 */
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
 * Map elements are special case of AtlValue
 * There is a key and a value.
 * 
 * AtlMapValue represents this special value
 * 
 * @author allilaire
 */
public class AtlMapValue implements IValue {

	private Value key;
	private Value valueKey;
	private AtlDebugTarget atlDT;
	
	/**
	 * This AtlMapValue is built with two value (key, value) and a debug target 
	 * @param key
	 * @param value
	 * @param atlDT
	 */
	public AtlMapValue(Value key, Value value, AtlDebugTarget atlDT) {
		this.key = key;
		this.valueKey = value;
		this.atlDT = atlDT;
	}

	/**
	 * This returns the two variables composing a AtlMapValue
	 * There is the key and the value for the key
	 * */
	public IVariable[] getVariables() throws DebugException {
 		IVariable ret[] = null;
		
		List list = new ArrayList();
		list.add(new AtlVariable(AtlDebugModelConstants.KEY, new AtlValue(key, atlDT), atlDT, AtlVariable.ATTRIBUTE));
		list.add(new AtlVariable(AtlDebugModelConstants.VALUE, new AtlValue(valueKey, atlDT), atlDT, AtlVariable.ATTRIBUTE));
		ret = (IVariable[])list.toArray(new IVariable[0]);

		return ret;
	}

	/**
	 * Return the type
	 * 
	 * @see org.eclipse.debug.core.model.IValue#getReferenceTypeName()
	 */
	public String getReferenceTypeName() throws DebugException {
		return AtlDebugModelConstants.MAPELEMENT;
	}

	/**
	 * Return the value of AtlMapValue
	 * 
	 * @see org.eclipse.debug.core.model.IValue#getValueString()
	 */
	public String getValueString() throws DebugException {
		return AtlDebugModelConstants.MAPELEMENT;
	}

	/**
	 * @see org.eclipse.debug.core.model.IValue#isAllocated()
	 */
	public boolean isAllocated() throws DebugException {
		return false;
	}

	/**
	 * An AtlMapValue is always composed of two variables (key, value)
	 * 
	 * @see org.eclipse.debug.core.model.IValue#hasVariables()
	 */
	public boolean hasVariables() throws DebugException {
		return true;
	}

	/**
	 * @see org.eclipse.debug.core.model.IDebugElement#getModelIdentifier()
	 */
	public String getModelIdentifier() {
		return atlDT.getModelIdentifier();
	}

	/**
	 * @see org.eclipse.debug.core.model.IDebugElement#getDebugTarget()
	 */
	public IDebugTarget getDebugTarget() {
		return atlDT.getDebugTarget();
	}

	/**
	 * @see org.eclipse.debug.core.model.IDebugElement#getLaunch()
	 */
	public ILaunch getLaunch() {
		return atlDT.getLaunch();
	}

	/**
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public Object getAdapter(Class adapter) {
		return null;
	}

}
