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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.engine.Messages;

/**
 * The line number table contains a list of IDs (startLine:startColumn-endLine:endColumn) of source elements
 * associated to a range of asm instructions. This list is depth first (first the condition is found, then the
 * if). However, it is entered root first... so it is a LIFO. To find the source element (and its location,
 * IDs being positions) associated to an asm instruction, we just have to find the first range matching the
 * instruction.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ASMOperation {

	// BEGIN SIGNATURE TOOLS
	private static Pattern pattern1 = Pattern.compile("^.*\\("); //$NON-NLS-1$

	private static Pattern simple = Pattern.compile("^J|I|B|S|D|A|(M|N)[^;]*;|L"); //$NON-NLS-1$

	private static Pattern pattern2 = Pattern.compile("^(Q|G|C|E|O).*"); //$NON-NLS-1$

	// END SIGNATURE TOOLS

	/** Temporary storage for lineNumberEntries began but not yet ended. */
	private Map lineNumberEntries = new HashMap();

	private String lastLNE;

	/** Temporary storage for localVariableEntries began but not yet ended. */
	private Map localVariableEntries = new HashMap();

	/** List of Boolean true if slot busy. */
	private List slots = new ArrayList();

	private String name;

	private String context;

	private List parameters = new ArrayList();

	private List instructions = new ArrayList();

	private Map labels = new HashMap();

	private List lineNumberTable = new ArrayList();

	private List localVariableTable = new ArrayList();

	private ASM asm;

	public ASMOperation(ASM asm, String name) {
		this.name = name;
		this.asm = asm;
	}

	public String getName() {
		return name;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getContextSignature() {
		return context;
	}

	public void addParameter(ASMParameter parameter) {
		parameters.add(parameter);
	}

	public List getParameters() {
		return parameters;
	}

	public void addInstruction(ASMInstruction instruction) {
		instructions.add(instruction);
	}

	public void addLabeledInstruction(ASMInstructionWithOperand instruction, String labelName) {
		instructions.add(instruction);
		Label label = (Label)labels.get(labelName);

		if (label == null) {
			label = new Label(labelName);
			labels.put(labelName, label);
		}

		int index = label.getIndex();
		if (index != -1) {
			instruction.setOperand("" + index); //$NON-NLS-1$
		} else {
			label.addInstruction(instruction);
		}
	}

	public List getInstructions() {
		return instructions;
	}

	public void addLabel(String labelName) {
		Label label = (Label)labels.get(labelName);

		if (label == null) {
			label = new Label(labelName);
			labels.put(labelName, label);
		}

		label.setIndex(instructions.size());
	}

	public void addVariableInstruction(ASMInstructionWithOperand instruction, String varId) {
		LocalVariableEntry lve = (LocalVariableEntry)localVariableEntries.get(varId);
		if (lve == null) {
			ATLLogger.severe(Messages.getString(
					"ASMOperation_NO_SLOT_RESERVED", new Object[] {varId, lastLNE,})); //$NON-NLS-1$ 
		} else {
			instruction.setOperand("" + lve.slot); //$NON-NLS-1$
			instructions.add(instruction);
		}
	}

	protected class Label {

		public Label(String name) {
			this.name = name;
		}

		public int getIndex() {
			return index;
		}

		public void addInstruction(ASMInstruction i) {
			instr.add(i);
		}

		public void setIndex(int index) {
			this.index = index;
			String id = "" + index; //$NON-NLS-1$
			for (Iterator i = instr.iterator(); i.hasNext();) {
				((ASMInstructionWithOperand)i.next()).setOperand(id);
			}
		}

		public String getName() {
			return name;
		}

		private String name;

		private int index = -1;

		private ArrayList instr = new ArrayList();
	}

	public String getSignature() {
		return "<TODO>"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer(context);
		ret.append("."); //$NON-NLS-1$
		ret.append(name);
		ret.append("("); //$NON-NLS-1$
		for (Iterator i = parameters.iterator(); i.hasNext();) {
			ret.append(i.next());
			if (i.hasNext()) {
				ret.append(", "); //$NON-NLS-1$
			}
		}
		ret.append(") : ??"); //$NON-NLS-1$

		return ret.toString();
	}

	protected static int getNbArgs(String s) {
		int ret = 0;

		s = pattern1.matcher(s).replaceFirst(""); //$NON-NLS-1$
		while (!s.startsWith(")") && s.length() > 0) { //$NON-NLS-1$
			ret++;
			s = removeFirst(s);
		}

		return ret;
	}

	private static String removeFirst(String s) {
		if (s.startsWith("T")) { //$NON-NLS-1$
			s = s.substring(1);
			while (!s.startsWith(";")) { //$NON-NLS-1$
				s = removeFirst(s);
			}
			s = s.substring(1);
		} else if (pattern2.matcher(s).matches()) {
			s = removeFirst(s.substring(1));
		} else {
			s = simple.matcher(s).replaceFirst(""); //$NON-NLS-1$
		}

		return s;
	}

	protected static String getOpName(String s) {
		return s.substring(s.indexOf(".") + 1, s.indexOf("(")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	// END SIGNATURE TOOLS

	public void beginLineNumberEntry(String id) {
		lastLNE = id;
		lineNumberEntries.put(id, new LineNumberEntry(id, instructions.size(), -1));
	}

	public void endLineNumberEntry(String id) {
		LineNumberEntry lne = (LineNumberEntry)lineNumberEntries.remove(id);
		lne.end = instructions.size() - 1;
		lineNumberTable.add(lne);
	}

	public void addLineNumberEntry(String id, int begin, int end) {
		lineNumberTable.add(new LineNumberEntry(id, begin, end));
	}

	public List getLineNumberTable() {
		return lineNumberTable;
	}

	public String resolveLineNumber(int l) {
		String ret = null;

		for (Iterator i = lineNumberTable.iterator(); i.hasNext() && (ret == null);) {
			LineNumberEntry lne = (LineNumberEntry)i.next();
			if ((l >= lne.begin) && (l <= lne.end)) {
				ret = lne.id;
			}
		}

		return ret;
	}

	public class LineNumberEntry {

		public LineNumberEntry(String id, int begin, int end) {
			this.id = id;
			this.begin = begin;
			this.end = end;
		}

		public String id; /* startLine:startColumn-endLine:endColumn */

		public int begin;

		public int end;
	}

	public int beginLocalVariableEntry(String id, String name) {
		LocalVariableEntry lve = (LocalVariableEntry)localVariableEntries.get(id);
		if (lve != null) {
			throw new Error(Messages.getString("ASMOperation_USED_VARIABLE", new Object[] {id,})); //$NON-NLS-1$
		}
		int slot = reserveSlot();
		localVariableEntries.put(id, new LocalVariableEntry(slot, name, instructions.size(), -1));
		return slot;
	}

	public int endLocalVariableEntry(String id) {
		LocalVariableEntry lve = (LocalVariableEntry)localVariableEntries.remove(id);
		if (lve == null) {
			ATLLogger.severe(Messages.getString("ASMOperation_UNDEFINED_VARIABLE", new Object[] {id,})); //$NON-NLS-1$
			return -1;
		} else {
			lve.end = instructions.size() - 1;
			localVariableTable.add(lve);
			freeSlot(lve.slot);
			return lve.slot;
		}
	}

	public void addLocalVariableEntry(int slot, String name, int begin, int end) {
		localVariableTable.add(new LocalVariableEntry(slot, name, begin, end));
	}

	public List getLocalVariableTable() {
		return localVariableTable;
	}

	public String resolveVariableName(int slot, int l) {
		String ret = null;

		for (Iterator i = localVariableTable.iterator(); i.hasNext() & (ret == null);) {
			LocalVariableEntry lve = (LocalVariableEntry)i.next();

			if ((slot == lve.slot) && (l >= lve.begin) && (l <= lve.end)) {
				ret = lve.name;
			}
		}

		return ret;
	}

	public class LocalVariableEntry {

		public LocalVariableEntry(int slot, String name, int begin, int end) {
			this.slot = slot;
			this.name = name;
			this.begin = begin;
			this.end = end;
		}

		public int slot;

		public String name;

		public int begin;

		public int end;
	}

	public ASM getASM() {
		return asm;
	}

	private int reserveSlot() {
		int ret = -1;

		for (int i = 0; (i < slots.size()) && (ret == -1); i++) {
			if (!((Boolean)slots.get(i)).booleanValue()) {
				ret = i;
				slots.set(ret, new Boolean(true));
			}
		}

		if (ret == -1) {
			ret = slots.size();
			slots.add(new Boolean(true));
		}

		return ret;
	}

	private void freeSlot(int slot) {
		slots.set(slot, new Boolean(false));
	}

}
