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

import org.eclipse.m2m.atl.engine.emfvm.Messages;
import org.eclipse.m2m.atl.engine.emfvm.VMException;

/**
 * Enumeration literal implementation.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class EnumLiteral implements HasFields {

	private String name;

	/**
	 * Creates an unnamed EnumLiteral.
	 */
	public EnumLiteral() {
	}

	/**
	 * Creates an EnumLiteral with the given name.
	 * 
	 * @param name
	 *            the name
	 */
	public EnumLiteral(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (name == null) ? "<unnamed_yet>" : name; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.HasFields#get(org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame,
	 *      java.lang.Object)
	 */
	public Object get(AbstractStackFrame frame, Object literalName) {
		if ("name".equals(literalName)) { //$NON-NLS-1$
			return this.name;
		} else {
			throw new VMException(frame, Messages.getString("EnumLiteral.ACCESSERROR", literalName)); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.HasFields#set(org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame,
	 *      java.lang.Object, java.lang.Object)
	 */
	public void set(AbstractStackFrame frame, Object literalName, Object value) {
		if ("name".equals(literalName) && (value instanceof String)) { //$NON-NLS-1$
			if (((String)value).startsWith("#")) { //$NON-NLS-1$
				this.name = ((String)value).substring(1);
			} else {
				this.name = (String)value;
			}
		} else {
			throw new VMException(frame, Messages
					.getString("EnumLiteral.ASSIGNMENTERROR", value, literalName)); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.HasFields#unset(org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame, java.lang.Object)
	 */
	public void unset(AbstractStackFrame frame, Object name) {
		// TODO implement unset
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		if (this.name != null) {
			return this.name.hashCode();	
		}
		return super.hashCode();		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg) {
		boolean ret = false;
		if (arg instanceof EnumLiteral) {
			ret = this.name.equals(arg.toString());
		}
		return ret;
	}
}
