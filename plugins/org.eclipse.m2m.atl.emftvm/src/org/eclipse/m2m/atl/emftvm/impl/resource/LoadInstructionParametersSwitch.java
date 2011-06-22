/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.impl.resource;

import java.io.DataInputStream;
import java.io.IOException;

import org.eclipse.m2m.atl.emftvm.BranchInstruction;
import org.eclipse.m2m.atl.emftvm.CodeBlockInstruction;
import org.eclipse.m2m.atl.emftvm.FieldInstruction;
import org.eclipse.m2m.atl.emftvm.Findtype;
import org.eclipse.m2m.atl.emftvm.Ifte;
import org.eclipse.m2m.atl.emftvm.Instruction;
import org.eclipse.m2m.atl.emftvm.InvokeInstruction;
import org.eclipse.m2m.atl.emftvm.InvokeOperationInstruction;
import org.eclipse.m2m.atl.emftvm.LocalVariableInstruction;
import org.eclipse.m2m.atl.emftvm.Match;
import org.eclipse.m2m.atl.emftvm.New;
import org.eclipse.m2m.atl.emftvm.Push;
import org.eclipse.m2m.atl.emftvm.util.EmftvmSwitch;


/**
 * Loads {@link Instruction} parameters from a {@link DataInputStream}.
 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
 */
public class LoadInstructionParametersSwitch extends EmftvmSwitch<Instruction> {

	protected final DataInputStream inputStream;
	protected final ConstantPool constants;

	/**
	 * Creates a new {@link LoadInstructionParametersSwitch}.
	 * @param inputStream
	 * @param constants
	 */
	public LoadInstructionParametersSwitch(DataInputStream inputStream, ConstantPool constants) {
		super();
		this.inputStream = inputStream;
		this.constants = constants;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.EmftvmSwitch#caseBranchInstruction(org.eclipse.m2m.atl.emftvm.BranchInstruction)
	 */
	@Override
	public Instruction caseBranchInstruction(BranchInstruction object) {
		try {
			final int offset = inputStream.readInt();
			object.setOffset(offset);
			// Cannot safely set target instruction yet
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.caseBranchInstruction(object);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.EmftvmSwitch#caseFieldInstruction(org.eclipse.m2m.atl.emftvm.FieldInstruction)
	 */
	@Override
	public Instruction caseFieldInstruction(FieldInstruction object) {
		try {
			object.setFieldname((String) constants.get(inputStream.readInt()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.caseFieldInstruction(object);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.EmftvmSwitch#caseFindtype(org.eclipse.m2m.atl.emftvm.Findtype)
	 */
	@Override
	public Instruction caseFindtype(Findtype object) {
		try {
			object.setModelname((String) constants.get(inputStream.readInt()));
			object.setTypename((String) constants.get(inputStream.readInt()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.caseFindtype(object);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.EmftvmSwitch#caseInvokeInstruction(org.eclipse.m2m.atl.emftvm.InvokeInstruction)
	 */
	@Override
	public Instruction caseInvokeInstruction(InvokeInstruction object) {
		try {
			object.setArgcount(inputStream.readInt());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.caseInvokeInstruction(object);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.EmftvmSwitch#caseInvokeOperationInstruction(org.eclipse.m2m.atl.emftvm.InvokeOperationInstruction)
	 */
	@Override
	public Instruction caseInvokeOperationInstruction(InvokeOperationInstruction object) {
		try {
			object.setOpname((String) constants.get(inputStream.readInt()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.caseInvokeOperationInstruction(object);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.EmftvmSwitch#caseLocalVariableInstruction(org.eclipse.m2m.atl.emftvm.LocalVariableInstruction)
	 */
	@Override
	public Instruction caseLocalVariableInstruction(
			LocalVariableInstruction object) {
		try {
			object.setCbOffset(inputStream.readInt());
			object.setLocalVariableIndex(inputStream.readInt());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.caseLocalVariableInstruction(object);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.EmftvmSwitch#caseNew(org.eclipse.m2m.atl.emftvm.New)
	 */
	@Override
	public Instruction caseNew(New object) {
		try {
			object.setModelname((String) constants.get(inputStream.readInt()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.caseNew(object);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.EmftvmSwitch#casePush(org.eclipse.m2m.atl.emftvm.Push)
	 */
	@Override
	public Instruction casePush(Push object) {
		try {
			object.setValue(constants.get(inputStream.readInt()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.casePush(object);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.EmftvmSwitch#caseMatch(org.eclipse.m2m.atl.emftvm.Match)
	 */
	@Override
	public Instruction caseMatch(Match object) {
		try {
			object.setRulename((String) constants.get(inputStream.readInt()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.caseMatch(object);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.EmftvmSwitch#caseCodeBlockInstruction(org.eclipse.m2m.atl.emftvm.CodeBlockInstruction)
	 */
	@Override
	public Instruction caseCodeBlockInstruction(CodeBlockInstruction object) {
		try {
			 // cannot resolve codeblock reference here, as nested code blocks are loaded after this codeblock
			object.setCbIndex(inputStream.readInt());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.caseCodeBlockInstruction(object);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.EmftvmSwitch#caseIfte(org.eclipse.m2m.atl.emftvm.Ifte)
	 */
	@Override
	public Instruction caseIfte(Ifte object) {
		try {
			 // cannot resolve codeblock reference here, as nested code blocks are loaded after this codeblock
			object.setThenCbIndex(inputStream.readInt());
			object.setElseCbIndex(inputStream.readInt());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.caseIfte(object);
	}

}