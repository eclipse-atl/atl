/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *     Obeo - Compiler refactoring
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.asm;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;

import org.eclipse.m2m.atl.engine.compiler.AtlDefaultCompiler;

/**
 * This class is used by ATL compiler to create an ASM file.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ASMEmitter {

	private ASMOperation currentOperation;

	private ASM asm;

	public static final String DIRECT_COMPILATION = "DIRECT_COMPILATION"; //$NON-NLS-1$

	/**
	 * Creates a new {@link ASMEmitter}.
	 */
	public ASMEmitter() {
	}

	/**
	 * Wraps to ASM methods.
	 * 
	 * @see ASM
	 * @param name
	 *            the {@link ASM} name
	 */
	public void newASM(String name) {
		asm = new ASM(name);
	}

	/**
	 * Wraps to ASM methods.
	 * 
	 * @see ASM
	 */
	public void newUnnamedASM() {
		asm = new ASM();
	}

	/**
	 * Wraps to ASM methods.
	 * 
	 * @see ASM
	 * @param name
	 *            the {@link ASM} name
	 */
	public void setName(String name) {
		asm.setName(name);
	}

	/**
	 * Wraps to ASM methods.
	 * 
	 * @see ASM
	 * @param name
	 *            the {@link ASMField} name
	 * @param type
	 *            the {@link ASMField} type
	 */
	public void addField(String name, String type) {
		asm.addField(new ASMField(name, type));
	}

	/**
	 * Finish the current Operation.
	 */
	public void finishOperation() {
		if (currentOperation != null) {
			currentOperation.endLocalVariableEntry("self");
			for (Iterator i = currentOperation.getParameters().iterator(); i.hasNext();) {
				ASMParameter p = (ASMParameter)i.next();
				int slot = currentOperation.endLocalVariableEntry(p.getName());
				p.setName("" + slot);
			}
			currentOperation = null;
		}
	}

	public void addOperation(String name) {
		finishOperation();
		currentOperation = new ASMOperation(asm, name);
		asm.addOperation(currentOperation);
		currentOperation.beginLocalVariableEntry("self", "self");
	}

	public void addOperationWithoutLVE(String name) {
		currentOperation = new ASMOperation(asm, name);
		asm.addOperation(currentOperation);
	}

	public void setContext(String type) {
		currentOperation.setContext(type);
	}

	public void addParameter(String name, String type) {
		currentOperation.addParameter(new ASMParameter(name, type));
		currentOperation.beginLocalVariableEntry(name, name);
	}

	public void addParameterWithoutLVE(String name, String type) {
		currentOperation.addParameter(new ASMParameter(name, type));
	}

	public void beginLineNumberEntry(String id) {
		currentOperation.beginLineNumberEntry(id);
	}

	public void endLineNumberEntry(String id) {
		currentOperation.endLineNumberEntry(id);
	}

	public void addLineNumberEntry(String id, int begin, int end) {
		currentOperation.addLineNumberEntry(id, begin, end);
	}

	public void beginLocalVariableEntry(String id, String name) {
		currentOperation.beginLocalVariableEntry(id, name);
	}

	public void endLocalVariableEntry(String id) {
		currentOperation.endLocalVariableEntry(id);
	}

	public void addLocalVariableEntry(int slot, String name, int begin, int end) {
		currentOperation.addLocalVariableEntry(slot, name, begin, end);
	}

	public void emitSimple(String mnemonic) {
		if (!mnemonic.equals("nop")) {
			currentOperation.addInstruction(new ASMInstruction(mnemonic));
		}
	}

	public void emit(String mnemonic, String param) {
		if (mnemonic.equals("nop")) {
		} else if (mnemonic.equals("if") || mnemonic.equals("goto")) {
			currentOperation.addLabeledInstruction(new ASMInstructionWithOperand(mnemonic, null), param);
		} else if (mnemonic.equals("label")) {
			currentOperation.addLabel(param);
		} else if (mnemonic.equals("store") || mnemonic.equals("load")) {
			currentOperation.addVariableInstruction(new ASMInstructionWithOperand(mnemonic, null), param);
		} else {
			currentOperation.addInstruction(new ASMInstructionWithOperand(mnemonic, param));
		}
	}

	public void emitWithoutLabel(String mnemonic, String param) {
		if (!mnemonic.equals("nop")) {
			currentOperation.addInstruction(new ASMInstructionWithOperand(mnemonic, param));
		}
	}

	public ASM getASM() {
		return asm;
	}

	/**
	 * Writes the {@link ASM} to a file.
	 * 
	 * @param fileName
	 *            the file where to write
	 */
	public void dumpASM(String fileName) {
		finishOperation();
		if (fileName.equals(DIRECT_COMPILATION)) {
			OutputStream os = AtlDefaultCompiler.getCompilationOutputStream();
			if (os != null) {
				PrintWriter out = new PrintWriter(os);
				new ASMXMLWriter(out, false).print(asm);
				out.close();
			} else {
				throw new ASMEmitterException("Output stream not found"); //$NON-NLS-1$
			}
		} else {
			try {
				PrintWriter out = new PrintWriter(new FileWriter(fileName));
				new ASMXMLWriter(out, false).print(asm);
				out.close();
			} catch (IOException ioe) {
				throw new ASMEmitterException(ioe.getLocalizedMessage(), ioe);
			}
		}
	}
}
