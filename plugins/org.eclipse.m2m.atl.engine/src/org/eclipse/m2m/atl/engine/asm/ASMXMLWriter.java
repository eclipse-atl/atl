/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 * Obeo - Compiler refactoring
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.asm;

import java.io.PrintWriter;
import java.util.Iterator;

/**
 * Writes ASM as XML.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ASMXMLWriter extends ASMWriter {

	private PrintWriter out;

	private boolean debug;

	private boolean dummy;

	/**
	 * Creates a new asm writer.
	 * 
	 * @param out
	 *            the writer
	 * @param debug
	 *            debugs instructions if true
	 */
	public ASMXMLWriter(PrintWriter out, boolean debug) {
		this.out = out;
		this.debug = debug;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.asm.ASMWriter#print(org.eclipse.m2m.atl.engine.asm.ASM)
	 */
	public void print(ASM asm) {
		dummy = true;
		printASM(asm);
		dummy = false;
		printASM(asm);
	}

	private void printASM(ASM asm) {
		String name = asm.getName();
		println("<?xml version = '1.0' encoding = 'ISO-8859-1' ?>"); //$NON-NLS-1$
		println("<asm name=\"" + getCPIndex(name) + "\">", "<!-- " + name + " -->"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		println("\t<cp>"); //$NON-NLS-1$
		int k = 0;
		for (Iterator i = getConstantPool().iterator(); i.hasNext();) {
			String s = (String)i.next();
			s = s.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
					"&quot;").replaceAll("\n", "&#10;").replaceAll("\r", "&#13;").replaceAll("\t", "&#9;"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
			println("\t\t<constant value=\"" + s + "\"/>", "<!-- " + k++ + " -->"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		}
		println("\t</cp>"); //$NON-NLS-1$
		for (Iterator i = asm.getFields().iterator(); i.hasNext();) {
			printField((ASMField)i.next());
		}
		for (Iterator i = asm.getOperations().iterator(); i.hasNext();) {
			printOperation((ASMOperation)i.next());
		}
		println("</asm>"); //$NON-NLS-1$

	}

	private void println(String s, String d) {
		if (dummy) {
			// do nothing
		} else if (debug) {
			String tabs = ""; //$NON-NLS-1$
			switch ((8 * 8 - s.replaceAll("\t", "        ").length() - 1) / 8) { //$NON-NLS-1$ //$NON-NLS-2$
				case 8:
					tabs += "\t"; //$NON-NLS-1$
				case 7:
					tabs += "\t"; //$NON-NLS-1$
				case 6:
					tabs += "\t"; //$NON-NLS-1$
				case 5:
					tabs += "\t"; //$NON-NLS-1$
				case 4:
					tabs += "\t"; //$NON-NLS-1$
				case 3:
					tabs += "\t"; //$NON-NLS-1$
				case 2:
					tabs += "\t"; //$NON-NLS-1$
				case 1:
					tabs += "\t"; //$NON-NLS-1$
				default:
					break;
			}
			out.println(s + tabs + d);
		} else {
			out.println(s);
		}
	}

	private void println(String s) {
		if (!dummy) {
			out.println(s);
		}
	}

	private void printField(ASMField f) {
		String name = f.getName();
		String type = f.getType();
		println("\t<field name=\"" + getCPIndex(name) + "\" type=\"" + getCPIndex(type) + "\"/>", "<!-- " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ name + " : " + type + " -->"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	private void printOperation(ASMOperation op) {
		String name = op.getName();
		String context = op.getContextSignature();
		println("\t<operation name=\"" + getCPIndex(name) + "\">", "<!-- " + name + " -->"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		println("\t\t<context type=\"" + getCPIndex(context) + "\"/>", "<!-- " + context + " -->"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		println("\t\t<parameters>"); //$NON-NLS-1$
		for (Iterator i = op.getParameters().iterator(); i.hasNext();) {
			printParameter((ASMParameter)i.next());
		}
		println("\t\t</parameters>"); //$NON-NLS-1$
		println("\t\t<code>"); //$NON-NLS-1$
		for (Iterator i = op.getInstructions().iterator(); i.hasNext();) {
			printInstruction((ASMInstruction)i.next());
		}
		println("\t\t</code>"); //$NON-NLS-1$
		println("\t\t<linenumbertable>"); //$NON-NLS-1$
		for (Iterator i = op.getLineNumberTable().iterator(); i.hasNext();) {
			printLineNumberEntry((ASMOperation.LineNumberEntry)i.next());
		}
		println("\t\t</linenumbertable>"); //$NON-NLS-1$
		println("\t\t<localvariabletable>"); //$NON-NLS-1$
		for (Iterator i = op.getLocalVariableTable().iterator(); i.hasNext();) {
			printLocalVariableEntry((ASMOperation.LocalVariableEntry)i.next());
		}
		println("\t\t</localvariabletable>"); //$NON-NLS-1$
		println("\t</operation>"); //$NON-NLS-1$
	}

	private void printParameter(ASMParameter param) {
		String name = param.getName();
		String type = param.getType();
		println("\t\t\t<parameter name=\"" + getCPIndex(name) + "\" type=\"" + getCPIndex(type) + "\"/>", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				"<!-- " + name + " : " + type + " -->"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	private void printInstruction(ASMInstruction instr) {
		if (instr instanceof ASMInstructionWithOperand) {
			String mn = instr.getMnemonic();
			String operand = ((ASMInstructionWithOperand)instr).getOperand();
			// if(mn.equals("if") || mn.equals("goto")) {
			// println("\t\t\t<" + instr.getMnemonic() + " arg=\"" + operand + "\"/>");
			// } else {
			println("\t\t\t<" + mn + " arg=\"" + getCPIndex(operand) + "\"/>", "<!-- " + operand + " -->"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			// }
		} else {
			println("\t\t\t<" + instr.getMnemonic() + "/>"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	private void printLineNumberEntry(ASMOperation.LineNumberEntry lne) {
		println("\t\t\t<lne id=\"" + getCPIndex(lne.id) + "\" begin=\"" + lne.begin + "\" end=\"" + lne.end //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "\"/>", "<!-- " + lne.id + " -->"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	private void printLocalVariableEntry(ASMOperation.LocalVariableEntry lve) {
		println("\t\t\t<lve slot=\"" + lve.slot + "\" name=\"" + getCPIndex(lve.name) + "\" begin=\"" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ lve.begin + "\" end=\"" + lve.end + "\"/>", "<!-- " + lve.name + " -->"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}
}
