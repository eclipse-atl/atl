/*******************************************************************************
 * Copyright (c) 2011 Dennis Wagelaar, Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.m2m.atl.emftvm.Instruction;

/**
 * Validates the final stack level of code blocks, which should be 0 or 1.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class StackUnderflowConstraint extends AbstractModelConstraint {
	
	protected final Validator<Instruction> validator = new StackUnderflowValidator();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		final EObject tgt = ctx.getTarget();
		if (tgt instanceof Instruction) {
			final Instruction i = (Instruction)tgt;
			if (!validator.validate(i)) {
				return ctx.createFailureStatus(i.getOwningBlock(), i, i.getStackLevel());
			}
		}
		return ctx.createSuccessStatus();
	}

}
