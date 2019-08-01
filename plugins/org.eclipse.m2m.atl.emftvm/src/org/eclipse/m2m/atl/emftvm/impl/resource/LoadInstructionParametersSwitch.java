/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
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
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class LoadInstructionParametersSwitch extends EmftvmSwitch<Instruction> {

	protected final DataInputStream inputStream;
	protected final ConstantPool constants;

	/**
	 * Creates a new {@link LoadInstructionParametersSwitch}.
	 * @param inputStream the input stream
	 * @param constants the constant pool
	 */
	public LoadInstructionParametersSwitch(DataInputStream inputStream, ConstantPool constants) {
		super();
		this.inputStream = inputStream;
		this.constants = constants;
	}

	/**
	 * {@inheritDoc}
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Instruction caseFieldInstruction(FieldInstruction object) {
		try {
			object.setFieldname((String)constants.get(inputStream.readInt()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.caseFieldInstruction(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Instruction caseFindtype(Findtype object) {
		try {
			object.setModelname((String)constants.get(inputStream.readInt()));
			object.setTypename((String)constants.get(inputStream.readInt()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.caseFindtype(object);
	}

	/**
	 * {@inheritDoc}
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Instruction caseInvokeOperationInstruction(InvokeOperationInstruction object) {
		try {
			object.setOpname((String)constants.get(inputStream.readInt()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.caseInvokeOperationInstruction(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Instruction caseLocalVariableInstruction(
			LocalVariableInstruction object) {
		try {
			object.setCbOffset(inputStream.readInt());
			object.setLocalVariableIndex(inputStream.readInt());
			object.getLocalVariable(); // force initialisation
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.caseLocalVariableInstruction(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Instruction caseNew(New object) {
		try {
			object.setModelname((String)constants.get(inputStream.readInt()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.caseNew(object);
	}

	/**
	 * {@inheritDoc}
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Instruction caseMatch(Match object) {
		try {
			object.setRulename((String)constants.get(inputStream.readInt()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.caseMatch(object);
	}

	/**
	 * {@inheritDoc}
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

	/**
	 * {@inheritDoc}
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