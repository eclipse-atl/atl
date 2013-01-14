/*******************************************************************************
 * Copyright (c) 2013 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.constraints;

import org.eclipse.m2m.atl.emftvm.CodeBlock;

/**
 * Validates the final stack level of code blocks, which should be 0 or 1.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class ValidCodeBlockStackLevelValidator implements Validator<CodeBlock> {

	/**
	 * {@inheritDoc}
	 */
	public boolean validate(final CodeBlock cb) {
		final int stackLevel = cb.getStackLevel();
		return stackLevel >= 0 && stackLevel <= 1;
	}

}
