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

import java.util.logging.Level;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.m2m.atl.engine.vm.adwp.ObjectReference;

/**
 * @author Freddy Allilaire
 */

public class AtlVariable extends AtlDebugElement implements IVariable {

	// If you add a constant here, look in the AtlDebugModelPresentation if the value is not already used
	public final static int UNKNOWN = -1;
	public final static int LOCALVARIABLE = 0;
	public final static int REFERENCE = 1;
	public final static int ATTRIBUTE = 2;
	public final static int SUPERTYPE = 3;
	public final static int ELEMENT = 4;
	
	private String name;
	private String typeName;
	private int description;
	private IValue value;
	private AtlDebugTarget atlDT;
	private int idVariable = -1;
	
	public AtlVariable(String name, IValue value, AtlDebugTarget atlDT, int description) {
		super(atlDT);
		try {
			this.name = name;
			this.typeName = value.getReferenceTypeName();
			this.description = description;
			this.value = value;
			if (value instanceof AtlValue)
				if (((AtlValue)value).getValue() instanceof ObjectReference)
					this.idVariable = ((ObjectReference)(((AtlValue)value).getValue())).getId();
		}
		catch (DebugException e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
		}
		this.atlDT = atlDT;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IVariable#getValue()
	 */
	public IValue getValue() throws DebugException 
	{
		return value;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IVariable#getName()
	 */
	public String getName() throws DebugException 
	{
		return name;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IVariable#getReferenceTypeName()
	 */
	public String getReferenceTypeName() throws DebugException 
	{
		return typeName;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IVariable#hasValueChanged()
	 */
	public boolean hasValueChanged() throws DebugException 
	{
		return false;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IDebugElement#getModelIdentifier()
	 */
	public String getModelIdentifier() 
	{
		return atlDT.getModelIdentifier();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IDebugElement#getDebugTarget()
	 */
	public IDebugTarget getDebugTarget() 
	{
		return atlDT.getDebugTarget();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IDebugElement#getLaunch()
	 */
	public ILaunch getLaunch() 
	{
		return atlDT.getLaunch();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IValueModification#setValue(java.lang.String)
	 */
	public void setValue(String expression) throws DebugException 
	{		
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IValueModification#setValue(org.eclipse.debug.core.model.IValue)
	 */
	public void setValue(IValue value) throws DebugException 
	{
		this.value = (AtlValue)value;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IValueModification#supportsValueModification()
	 */
	public boolean supportsValueModification() 
	{
		return false;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IValueModification#verifyValue(java.lang.String)
	 */
	public boolean verifyValue(String expression) throws DebugException 
	{
		return false;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IValueModification#verifyValue(org.eclipse.debug.core.model.IValue)
	 */
	public boolean verifyValue(IValue value) throws DebugException 
	{
		return false;
	}
	
	/**
	 * @return Returns the superType.
	 */
	public int getDescription() {
		return description;
	}
	/**
	 * @return Returns the idVariable.
	 */
	public int getIdVariable() {
		return idVariable;
	}

}
