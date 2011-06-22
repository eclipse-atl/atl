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

import java.io.DataOutputStream;
import java.io.IOException;

import org.eclipse.m2m.atl.emftvm.BranchInstruction;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.CodeBlockInstruction;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.FieldInstruction;
import org.eclipse.m2m.atl.emftvm.Findtype;
import org.eclipse.m2m.atl.emftvm.Ifte;
import org.eclipse.m2m.atl.emftvm.Instruction;
import org.eclipse.m2m.atl.emftvm.InvokeInstruction;
import org.eclipse.m2m.atl.emftvm.InvokeOperationInstruction;
import org.eclipse.m2m.atl.emftvm.LocalVariable;
import org.eclipse.m2m.atl.emftvm.LocalVariableInstruction;
import org.eclipse.m2m.atl.emftvm.Match;
import org.eclipse.m2m.atl.emftvm.New;
import org.eclipse.m2m.atl.emftvm.Push;
import org.eclipse.m2m.atl.emftvm.util.EmftvmSwitch;


/**
 * Saves {@link Instruction} parameters to a {@link DataOutputStream}.
 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
 */
public class SaveInstructionParametersSwitch extends EmftvmSwitch<Instruction> {

	protected final DataOutputStream outputStream;
	protected final ConstantPool constants;

	/**
	 * Creates a new {@link SaveInstructionParametersSwitch}.
	 * @param outputStream
	 * @param constants
	 */
	public SaveInstructionParametersSwitch(DataOutputStream outputStream, ConstantPool constants) {
		super();
		this.outputStream = outputStream;
		this.constants = constants;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.EmftvmSwitch#caseBranchInstruction(org.eclipse.m2m.atl.emftvm.BranchInstruction)
	 */
	@Override
	public Instruction caseBranchInstruction(BranchInstruction object) {
		try {
			final Instruction target = object.getTarget();
			if (target != null) {
				if (target.getOwningBlock() != object.getOwningBlock()) {
					throw new IllegalArgumentException(String.format(
							"Branch target outside code block for %s", object));
				}
				object.eUnset(EmftvmPackage.eINSTANCE.getBranchInstruction_Offset());
			}
			outputStream.writeInt(object.getOffset());
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
			outputStream.writeInt(constants.indexOf(object.getFieldname()));
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
			outputStream.writeInt(constants.indexOf(object.getModelname()));
			outputStream.writeInt(constants.indexOf(object.getTypename()));
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
			outputStream.writeInt(object.getArgcount());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.caseInvokeInstruction(object);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.EmftvmSwitch#caseInvokeOperationInstruction(org.eclipse.m2m.atl.emftvm.InvokeInstruction)
	 */
	@Override
	public Instruction caseInvokeOperationInstruction(InvokeOperationInstruction object) {
		try {
			outputStream.writeInt(constants.indexOf(object.getOpname()));
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
			final LocalVariable lv = object.getLocalVariable();
			if (lv != null) {
				object.eUnset(EmftvmPackage.eINSTANCE.getLocalVariableInstruction_CbOffset());
				object.eUnset(EmftvmPackage.eINSTANCE.getLocalVariableInstruction_LocalVariableIndex());
			}
			outputStream.writeInt(object.getCbOffset());
			outputStream.writeInt(object.getLocalVariableIndex());
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
			outputStream.writeInt(constants.indexOf(object.getModelname()));
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
			outputStream.writeInt(constants.indexOf(object.getValue()));
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
			outputStream.writeInt(constants.indexOf(object.getRulename()));
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
			final CodeBlock cb = object.getCodeBlock();
			if (cb != null) {
				object.eUnset(EmftvmPackage.eINSTANCE.getCodeBlockInstruction_CbIndex());
			}
			outputStream.writeInt(object.getCbIndex());
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
			final CodeBlock thenCb = object.getThenCb();
			if (thenCb != null) {
				object.eUnset(EmftvmPackage.eINSTANCE.getIfte_ThenCbIndex());
			}
			final CodeBlock elseCb = object.getElseCb();
			if (elseCb != null) {
				object.eUnset(EmftvmPackage.eINSTANCE.getIfte_ElseCbIndex());
			}
			outputStream.writeInt(object.getThenCbIndex());
			outputStream.writeInt(object.getElseCbIndex());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.caseIfte(object);
	}

}