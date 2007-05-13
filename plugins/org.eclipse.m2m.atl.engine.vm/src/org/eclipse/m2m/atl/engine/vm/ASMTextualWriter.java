package org.eclipse.m2m.atl.engine.vm;

import java.io.PrintWriter;
import java.util.Iterator;

/**
 * Textual ATL VM bytecode serializer.
 * There is no corresponding reader, but the resulting text
 * makes it is easier to debug ATL compiler in some cases.
 * @author Frédéric Jouault
 */
public class ASMTextualWriter extends ASMWriter {

	public ASMTextualWriter(PrintWriter out) {
		this.out = out;
	}

	public void print(ASM asm) {
		printASM(asm);
	}

	private void printASM(ASM asm) {
		String name = asm.getName();
		out.println("asm " + name + " {");
		out.println();
			for(Iterator i = asm.getFields().iterator() ; i.hasNext() ; ) {
				printField((ASMField)i.next());
			}
			for(Iterator i = asm.getOperations().iterator() ; i.hasNext() ; ) {
				printOperation((ASMOperation)i.next());
			}
		out.println("}");
	
	}

	private void printField(ASMField f) {
		String name = f.getName();
		String type = f.getType();
		out.println("\tdef: " + name + " : " + type + ";");
		out.println();
	}

	private void printOperation(ASMOperation op) {
		String name = op.getName();
		String context = op.getContextSignature();
		out.print("\tcontext " + context + " def: " + name + "(");
			for(Iterator i = op.getParameters().iterator() ; i.hasNext() ; ) {
				printParameter(op, (ASMParameter)i.next());
				if(i.hasNext())
					out.print(", ");
			}
			out.println(") {");
			int k = 0;
//			Map lneByBegin = new HashMap();
//			Map lneByEnd = new HashMap();
//			for(Iterator i = op.getLineNumberTable().iterator() ; i.hasNext() ; ) {
//				LineNumberEntry lne = (LineNumberEntry)i.next();
//				lneByBegin.put(new Integer(lne.begin), lne);
//				lneByEnd.put(new Integer(lne.end), lne);
//			}
			for(Iterator i = op.getInstructions().iterator() ; i.hasNext() ; ) {
//				LineNumberEntry lne = (LineNumberEntry)lneByBegin.get(new Integer(k));
//				if(lne != null) {
//					out.println("\t  location \"" + lne.id + "\" {");
//				}
				out.print("\t\t" + conv(k) + ": ");
				printInstruction(op, (ASMInstruction)i.next(), k++);
				String location = op.resolveLineNumber(k - 1);
				if(location != null)
					out.print("\t\t// " + location);
				out.println();
				
//				lne = (LineNumberEntry)lneByBegin.get(new Integer(k - 1));
//				if(lne != null) {
//					out.print("\t    }");
//				}
			}
		out.println("\t}");
		out.println();
	}

	private String conv(int i) {
		if(i < 10)
			return "000" + i;
		else if(i < 100)
			return "00" + i;
		else if(i < 1000)
			return "0" + i;
		else
			return "" + i;
	}

	private void printParameter(ASMOperation op, ASMParameter param) {
		String name = op.resolveVariableName(Integer.parseInt(param.getName()), 0);
		String type = param.getType();
		out.print(name + " : " + type);
	}

	private void printInstruction(ASMOperation op, ASMInstruction instr, int index) {
		String mn = instr.getMnemonic();
		if(instr instanceof ASMInstructionWithOperand) {
			String operand = ((ASMInstructionWithOperand)instr).getOperand();
			if(mn.equals("load") || mn.equals("store")) {
				operand = op.resolveVariableName(Integer.parseInt(operand), index);
				out.print(mn + " " + operand + ";");
			} else {
				out.print(mn + " '" + operand + "';");
			}
		} else {
			out.print(mn + ";");
		}
	}

	private PrintWriter out;
}

