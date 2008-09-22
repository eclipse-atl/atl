/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm;

import java.io.PrintWriter;
import java.util.Iterator;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ASMXMLWriter extends ASMWriter {

	public ASMXMLWriter(PrintWriter out, boolean debug) {
		this.out = out;
		this.debug = debug;
	}

	public void print(ASM asm) {
		dummy = true;
		printASM(asm);
		dummy = false;
		printASM(asm);
	}

	private void printASM(ASM asm) {
		String name = asm.getName();
		println("<?xml version = '1.0' encoding = 'ISO-8859-1' ?>");
		println("<asm name=\"" + getCPIndex(name) + "\">", "<!-- " + name + " -->");
			println("\t<cp>");
			int k = 0;
			for(Iterator i = getConstantPool().iterator() ; i.hasNext() ; ) {
				String s = (String)i.next();
				s = s.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;").replaceAll("\n", "&#10;").replaceAll("\r", "&#13;").replaceAll("\t", "&#9;");
				println("\t\t<constant value=\"" + s + "\"/>", "<!-- " + k++ + " -->");
			}
			println("\t</cp>");
			for(Iterator i = asm.getFields().iterator() ; i.hasNext() ; ) {
				printField((ASMField)i.next());
			}
			for(Iterator i = asm.getOperations().iterator() ; i.hasNext() ; ) {
				printOperation((ASMOperation)i.next());
			}
		println("</asm>");
	
	}

	private void println(String s, String d) {
		if(dummy) {
		} else if(debug) {
			String tabs = "";
			switch((8 * 8 - s.replaceAll("\t", "        ").length() - 1) / 8) {
				case 8:	tabs += "\t";
				case 7:	tabs += "\t";
				case 6:	tabs += "\t";
				case 5:	tabs += "\t";
				case 4:	tabs += "\t";
				case 3:	tabs += "\t";
				case 2:	tabs += "\t";
				case 1:	tabs += "\t";
				default:
					break;
			}
			out.println(s + tabs + d);
		} else {
			out.println(s);
		}
	}

	private void println(String s) {
		if(!dummy) {
			out.println(s);
		}
	}

	private void printField(ASMField f) {
		String name = f.getName();
		String type = f.getType();
		println("\t<field name=\"" + getCPIndex(name) + "\" type=\"" + getCPIndex(type) + "\"/>", "<!-- " + name + " : " + type + " -->");
	}

	private void printOperation(ASMOperation op) {
		String name = op.getName();
		String context = op.getContextSignature();
		println("\t<operation name=\"" + getCPIndex(name) + "\">", "<!-- " + name + " -->");
			println("\t\t<context type=\"" + getCPIndex(context) + "\"/>", "<!-- " + context + " -->");
			println("\t\t<parameters>");
			for(Iterator i = op.getParameters().iterator() ; i.hasNext() ; ) {
				printParameter((ASMParameter)i.next());
			}
			println("\t\t</parameters>");
			println("\t\t<code>");
			for(Iterator i = op.getInstructions().iterator() ; i.hasNext() ; ) {
				printInstruction((ASMInstruction)i.next());
			}
			println("\t\t</code>");
			println("\t\t<linenumbertable>");
			for(Iterator i = op.getLineNumberTable().iterator() ; i.hasNext() ; ) {
				printLineNumberEntry((ASMOperation.LineNumberEntry)i.next());
			}
			println("\t\t</linenumbertable>");
			println("\t\t<localvariabletable>");
			for(Iterator i = op.getLocalVariableTable().iterator() ; i.hasNext() ; ) {
				printLocalVariableEntry((ASMOperation.LocalVariableEntry)i.next());
			}
			println("\t\t</localvariabletable>");
		println("\t</operation>");
	}

	private void printParameter(ASMParameter param) {
		String name = param.getName();
		String type = param.getType();
		println("\t\t\t<parameter name=\"" + getCPIndex(name) + "\" type=\"" + getCPIndex(type) + "\"/>", "<!-- " + name + " : " + type + " -->");
	}

	private void printInstruction(ASMInstruction instr) {
		if(instr instanceof ASMInstructionWithOperand) {
			String mn = instr.getMnemonic();
			String operand = ((ASMInstructionWithOperand)instr).getOperand();
//			if(mn.equals("if") || mn.equals("goto")) {
//				println("\t\t\t<" + instr.getMnemonic() + " arg=\"" + operand + "\"/>");
//			} else {
				println("\t\t\t<" + mn + " arg=\"" + getCPIndex(operand) + "\"/>", "<!-- " + operand + " -->");
//			}
		} else {
			println("\t\t\t<" + instr.getMnemonic() + "/>");
		}
	}

	private void printLineNumberEntry(ASMOperation.LineNumberEntry lne) {
		println("\t\t\t<lne id=\"" + getCPIndex(lne.id) + "\" begin=\"" + lne.begin + "\" end=\"" + lne.end  + "\"/>", "<!-- " + lne.id + " -->");
	}

	private void printLocalVariableEntry(ASMOperation.LocalVariableEntry lve) {
		println("\t\t\t<lve slot=\"" + lve.slot + "\" name=\"" + getCPIndex(lve.name) + "\" begin=\"" + lve.begin + "\" end=\"" + lve.end  + "\"/>", "<!-- " + lve.name + " -->");
	}

	private PrintWriter out;
	private boolean debug;
	private boolean dummy;
}

