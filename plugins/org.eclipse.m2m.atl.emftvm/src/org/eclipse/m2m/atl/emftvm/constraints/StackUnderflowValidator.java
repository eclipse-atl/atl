/*******************************************************************************
 * Copyright (c) 2012-2013 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.constraints;

import org.eclipse.m2m.atl.emftvm.Instruction;

/**
 * Validates the final stack level of code blocks, which should be 0 or 1.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class StackUnderflowValidator implements Validator<Instruction> {

	/**
	 * {@inheritDoc}
	 */
	public boolean validate(final Instruction i) {
		return i.getStackLevel() >= 0;
	}

}
