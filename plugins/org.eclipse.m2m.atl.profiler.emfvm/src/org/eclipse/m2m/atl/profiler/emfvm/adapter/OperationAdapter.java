/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.profiler.emfvm.adapter;

import java.util.List;

import org.eclipse.m2m.atl.engine.emfvm.lib.Operation;
import org.eclipse.m2m.atl.profiler.core.vm.IOperation;

/**
 * An EMFVM / Profiler operation wrapper.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class OperationAdapter implements IOperation {

	private Operation operation;

	/**
	 * Creates an {@link OperationAdapter} wrapping the given {@link Operation}.
	 * 
	 * @param operation
	 *            the operation to wrap
	 */
	public OperationAdapter(Operation operation) {
		this.operation = operation;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.profiler.core.vm.IOperation#getInstructions()
	 */
	public List<?> getInstructions() {
		return operation.getInstructions();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.profiler.core.vm.IOperation#getName()
	 */
	public String getName() {
		return operation.getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof OperationAdapter && ((OperationAdapter)obj).operation.equals(operation);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return operation.hashCode();
	}
}
