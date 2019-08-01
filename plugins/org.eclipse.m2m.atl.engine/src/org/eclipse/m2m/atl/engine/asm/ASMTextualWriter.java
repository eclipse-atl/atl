/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *     Obeo - Compiler refactoring
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.asm;

import java.io.PrintWriter;
import java.util.Iterator;

/**
 * Textual ATL VM bytecode serializer. There is no corresponding reader, but the resulting text makes it is
 * easier to debug ATL compiler in some cases.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ASMTextualWriter extends ASMWriter {

	private PrintWriter out;

	/**
	 * Creates a new {@link ASMTextualWriter} with the given {@link PrintWriter}.
	 * 
	 * @param out
	 *            the given {@link PrintWriter}
	 */
	public ASMTextualWriter(PrintWriter out) {
		this.out = out;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.asm.ASMWriter#print(org.eclipse.m2m.atl.engine.asm.ASM)
	 */
	public void print(ASM asm) {
		printASM(asm);
	}

	private void printASM(ASM asm) {
		String name = asm.getName();
		out.println("asm " + name + " {"); //$NON-NLS-1$ //$NON-NLS-2$
		out.println();
		for (Iterator i = asm.getFields().iterator(); i.hasNext();) {
			printField((ASMField)i.next());
		}
		for (Iterator i = asm.getOperations().iterator(); i.hasNext();) {
			printOperation((ASMOperation)i.next());
		}
		out.println("}"); //$NON-NLS-1$

	}

	private void printField(ASMField f) {
		String name = f.getName();
		String type = f.getType();
		out.println("\tdef: " + name + " : " + type + ";"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		out.println();
	}

	private void printOperation(ASMOperation op) {
		String name = op.getName();
		String context = op.getContextSignature();
		out.print("\tcontext " + context + " def: " + name + "("); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		for (Iterator i = op.getParameters().iterator(); i.hasNext();) {
			printParameter(op, (ASMParameter)i.next());
			if (i.hasNext()) {
				out.print(", "); //$NON-NLS-1$ 
			}
		}
		out.println(") {"); //$NON-NLS-1$ 
		int k = 0;
		for (Iterator i = op.getInstructions().iterator(); i.hasNext();) {
			out.print("\t\t" + conv(k) + ": "); //$NON-NLS-1$ //$NON-NLS-2$
			printInstruction(op, (ASMInstruction)i.next(), k++);
			String location = op.resolveLineNumber(k - 1);
			if (location != null) {
				out.print("\t\t// " + location); //$NON-NLS-1$
			}
			out.println();
		}
		out.println("\t}"); //$NON-NLS-1$
		out.println();
	}

	private String conv(int i) {
		if (i < 10) {
			return "000" + i; //$NON-NLS-1$
		} else if (i < 100) {
			return "00" + i; //$NON-NLS-1$
		} else if (i < 1000) {
			return "0" + i; //$NON-NLS-1$
		} else {
			return "" + i; //$NON-NLS-1$
		}
	}

	private void printParameter(ASMOperation op, ASMParameter param) {
		String name = op.resolveVariableName(Integer.parseInt(param.getName()), 0);
		String type = param.getType();
		out.print(name + " : " + type); //$NON-NLS-1$
	}

	private void printInstruction(ASMOperation op, ASMInstruction instr, int index) {
		String mn = instr.getMnemonic();
		if (instr instanceof ASMInstructionWithOperand) {
			String operand = ((ASMInstructionWithOperand)instr).getOperand();
			if (mn.equals("load") || mn.equals("store")) { //$NON-NLS-1$ //$NON-NLS-2$
				operand = op.resolveVariableName(Integer.parseInt(operand), index);
				out.print(mn + " " + operand + ";"); //$NON-NLS-1$//$NON-NLS-2$
			} else {
				out.print(mn + " '" + operand + "';"); //$NON-NLS-1$ //$NON-NLS-2$
			}
		} else {
			out.print(mn + ";"); //$NON-NLS-1$
		}
	}
}
