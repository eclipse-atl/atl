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
import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.engine.vm.adwp.ObjectReference;

/**
 * The ATL variable (for debug).
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class AtlVariable extends AtlDebugElement implements IVariable {

	// If you add a constant here, look in the AtlDebugModelPresentation if the value is not already used
	/** unknown type. */
	public static final int UNKNOWN = -1;

	/** atl local variable type. */
	public static final int LOCALVARIABLE = 0;

	/** reference type. */
	public static final int REFERENCE = 1;

	/** attribute type. */
	public static final int ATTRIBUTE = 2;

	/** supertype type. */
	public static final int SUPERTYPE = 3;

	/** model element type. */
	public static final int ELEMENT = 4;

	private String name;

	private String typeName;

	private int description;

	private IValue variableValue;

	private AtlDebugTarget atlDT;

	private int idVariable = -1;

	/**
	 * Creates an atl variable.
	 * 
	 * @param name the variable name
	 * @param value the variable value
	 * @param atlDT the debug target
	 * @param description the variable description
	 */
	public AtlVariable(String name, IValue value, AtlDebugTarget atlDT, int description) {
		super(atlDT);
		try {
			this.name = name;
			this.typeName = value.getReferenceTypeName();
			this.description = description;
			this.variableValue = value;
			if (value instanceof AtlValue) {
				if (((AtlValue)value).getValue() instanceof ObjectReference) {
					this.idVariable = ((ObjectReference)(((AtlValue)value).getValue())).getId();
				}
			}
		} catch (DebugException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		this.atlDT = atlDT;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IVariable#getValue()
	 */
	public IValue getValue() throws DebugException {
		return variableValue;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.IVariable#getName()
	 */
	public String getName() throws DebugException {
		return name;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.IVariable#getReferenceTypeName()
	 */
	public String getReferenceTypeName() throws DebugException {
		return typeName;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.IVariable#hasValueChanged()
	 */
	public boolean hasValueChanged() throws DebugException {
		return false;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.adt.debug.core.AtlDebugElement#getModelIdentifier()
	 */
	public String getModelIdentifier() {
		return atlDT.getModelIdentifier();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.adt.debug.core.AtlDebugElement#getDebugTarget()
	 */
	public IDebugTarget getDebugTarget() {
		return atlDT.getDebugTarget();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.adt.debug.core.AtlDebugElement#getLaunch()
	 */
	public ILaunch getLaunch() {
		return atlDT.getLaunch();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.IValueModification#setValue(java.lang.String)
	 */
	public void setValue(String expression) throws DebugException {
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.IValueModification#setValue(org.eclipse.debug.core.model.IValue)
	 */
	public void setValue(IValue value) throws DebugException {
		this.variableValue = value;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.IValueModification#supportsValueModification()
	 */
	public boolean supportsValueModification() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.IValueModification#verifyValue(java.lang.String)
	 */
	public boolean verifyValue(String expression) throws DebugException {
		return false;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.IValueModification#verifyValue(org.eclipse.debug.core.model.IValue)
	 */
	public boolean verifyValue(IValue value) throws DebugException {
		return false;
	}

	/**
	 * Returns the superType.
	 * 
	 * @return the superType
	 */
	public int getDescription() {
		return description;
	}

	/**
	 * Return the idVariable.
	 * 
	 * @return the idVariable.
	 */
	public int getIdVariable() {
		return idVariable;
	}

}
