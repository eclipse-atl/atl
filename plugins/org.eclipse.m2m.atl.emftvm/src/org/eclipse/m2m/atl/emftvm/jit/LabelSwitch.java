/*******************************************************************************
 * Copyright (c) 2011 Dennis Wagelaar, Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.jit;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.m2m.atl.emftvm.BranchInstruction;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.Instruction;
import org.eclipse.m2m.atl.emftvm.util.EmftvmSwitch;
import org.objectweb.asm.Label;

/**
 * Computes the {@link Label}s for the {@link CodeBlock}s {@link Instruction}s.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class LabelSwitch extends EmftvmSwitch<Label> {

	private final Map<Instruction, Label> targets = new HashMap<Instruction, Label>();
	private final Map<BranchInstruction, Label> sources = new HashMap<BranchInstruction, Label>();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Label caseBranchInstruction(BranchInstruction object) {
		final Instruction target = object.getTarget();
		final Label label;
		if (targets.containsKey(target)) {
			label = targets.get(target); // reuse existing label
		} else {
			label = new Label();
			targets.put(target, label);
		}
		sources.put(object, label);
		return label;
	}

	/**
	 * Returns <code>true</code> iff there is a {@link Label} with <code>instr</code> as target.
	 * @return <code>true</code> iff there is a {@link Label} with <code>instr</code> as target
	 */
	public boolean hasWithTarget(final Instruction instr) {
		return targets.containsKey(instr);
	}

	/**
	 * Returns the {@link Label} with <code>instr</code> as target, if any.
	 * @return the {@link Label} with <code>instr</code> as target, or <code>null</code>
	 */
	public Label getFromTarget(final Instruction instr) {
		return targets.get(instr);
	}

	/**
	 * Returns <code>true</code> iff there is a {@link Label} with <code>instr</code> as source.
	 * @return <code>true</code> iff there is a {@link Label} with <code>instr</code> as source
	 */
	public boolean hasWithSource(final BranchInstruction instr) {
		return sources.containsKey(instr);
	}

	/**
	 * Returns the {@link Label} with <code>instr</code> as source, if any.
	 * @return the {@link Label} with <code>instr</code> as source, or <code>null</code>
	 */
	public Label getFromSource(final BranchInstruction instr) {
		return sources.get(instr);
	}
	
}