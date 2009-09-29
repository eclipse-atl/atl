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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMBoolean;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMCollection;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMInteger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMNativeObject;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclSimpleType;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclType;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMReal;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMString;

/**
 * The line number table contains a list of IDs (startLine:startColumn-endLine:endColumn) of source elements
 * associated to a range of asm instructions. This list is depth first (first the condition is found, then the
 * if). However, it is entered root first... so it is a LIFO. To find the source element (and its location,
 * IDs being positions) associated to an asm instruction, we just have to find the first range matching the
 * instruction.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ASMOperation extends Operation {

	public static ASMOclType myType = new ASMOclSimpleType("ASMOperation", getOclAnyType());

	public ASMOperation(ASM asm, String name) {
		setType(myType);
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
			instruction.setOperand("" + index);
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
			ATLLogger.severe("No slot reserved for variable: " + varId + " used at " + lastLNE + ".");
		} else {
			instruction.setOperand("" + lve.slot);
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
			String id = "" + index;
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
		return "<TODO>";
	}

	public String toString() {
		StringBuffer ret = new StringBuffer(context);

		ret.append(".");
		ret.append(name);
		ret.append("(");
		for (Iterator i = parameters.iterator(); i.hasNext();) {
			ret.append(i.next());
			if (i.hasNext())
				ret.append(", ");
		}
		ret.append(") : ??");

		return ret.toString();
	}

	public ASMOclAny exec(StackFrame frame) {
		ASMOclAny ret = null;
		realExec((ASMStackFrame)frame);
		ret = frame.leaveFrame();
		return ret;
	}

	private void realExec(ASMStackFrame frame) {
		while (frame.hasNextInstruction()) {
			ASMInstruction instr = frame.nextInstruction();
			String mn = instr.getMnemonic();
			ASMString op = null;
			String ops = null;
			if (instr instanceof ASMInstructionWithOperand) {
				ops = ((ASMInstructionWithOperand)instr).getOperand();
				op = new ASMString(ops);
			}

			frame.step();

			if (mn == "push") {
				frame.push(op);
			} else if (mn == "pop") {
				frame.pop();
			} else if (mn == "swap") {
				ASMOclAny o1 = frame.pop();
				ASMOclAny o2 = frame.pop();
				frame.push(o1);
				frame.push(o2);
			} else if (mn == "new") {
				String mname = ((ASMString)frame.pop()).getSymbol();
				String me = ((ASMString)frame.pop()).getSymbol();
				if (mname.equals("#native")) {
					Class c = ASMNativeObject.getNativeImpl(me);
					if (c != null) {
						try {
							frame.push((ASMOclAny)c.newInstance());
						} catch (Exception e) {
							frame.printStackTrace("Cannot instantiate " + me);
						}
					} else {
						frame.printStackTrace("Element " + me + " not found in native");
					}
				} else {
					ASMModel mm = frame.getModel(mname);
					for (Iterator j = frame.getExecEnv().getModels().values().iterator(); j.hasNext();) {
						ASMModel model = (ASMModel)j.next();
						if (model.getMetamodel().equals(mm) && model.isTarget()) {
							frame.push(model.newModelElement(frame, me));
							break;
						}
					}

					// for(Iterator j = frame.getModel(mname).getSubModels().values().iterator() ; j.hasNext()
					// ; ) {
					// ASMModel model = (ASMModel)j.next();
					// if(frame.getModels().containsValue(model) && model.isTarget()) {
					// frame.push(model.newModelElement(frame, me));
					// break;
					// }
					// }
				}
			} else if (mn == "call") {
				int nb = getNbArgs(ops);
				String opName = getOpName(ops);
				ArrayList arguments = new ArrayList();
				for (int j = 0; j < nb; j++)
					arguments.add(0, frame.pop());
				ASMOclAny o = frame.pop(); // self
				ASMOclAny ret = o.invoke(frame, opName, arguments);

				if (ret != null) {
					frame.push(ret);
				}
			} else if (mn.equals("supercall")) {
				int nb = getNbArgs(ops);
				String opName = getOpName(ops);
				ArrayList arguments = new ArrayList();
				for (int j = 0; j < nb; j++) {
					arguments.add(0, frame.pop());
				}
				ASMOclAny o = frame.pop(); // self
				ASMOclAny ret = o.invokeSuper(frame, opName, arguments);

				if (ret != null) {
					frame.push(ret);
				}
			} else if (mn.equals("store")) {
				frame.popVariable(ops);
			} else if (mn.equals("load")) {
				frame.pushVariable(ops);
			} else if (mn.equals("dup")) {
				frame.push(frame.peek());
			} else if (mn.equals("dup_x1")) {
				ASMOclAny val1 = frame.pop();
				ASMOclAny val2 = frame.pop();
				frame.push(val1);
				frame.push(val2);
				frame.push(val1);
			} else if (mn.equals("delete")) {
				// TODO implement a delete method for ASMModelElements
				// (frame.pop()).delete(frame, ops);
			} else if (mn.equals("findme")) {
				String mname = ((ASMString)frame.pop()).getSymbol();
				String name = ((ASMString)frame.pop()).getSymbol();
				if (mname.equals("#native")) {
					if (name.equals("String")) {
						frame.push(ASMString.myType);
					} else if (name.equals("OclAny")) {
						frame.push(ASMOclAny.myType);
					} else if (name.equals("Integer")) {
						frame.push(ASMInteger.myType);
					} else if (name.equals("Boolean")) {
						frame.push(ASMBoolean.myType);
					} else if (name.equals("Real")) {
						frame.push(ASMReal.myType);
					} else {
						frame.printStackTrace("Element " + name + " not found in native");
					}
				} else {
					ASMModel model = frame.getModel(mname);
					if (model == null) {
						frame.printStackTrace("Cannot find model " + mname);
					} else {
						ASMModelElement ame = model.findModelElement(name);
						if (ame == null) {
							frame.printStackTrace("Cannot find metamodel element " + name + " in model "
									+ mname);
						}
						frame.push(ame);
					}
				}
			} else if (mn == "get") {
				frame.push((frame.pop()).get(frame, ops));
			} else if (mn == "set") {
				ASMOclAny value = frame.pop();
				ASMOclAny o = frame.pop();
				o.set(frame, ops, value);
			} else if (mn == "pushi") {
				ASMInteger ai = new ASMInteger(Integer.parseInt(ops));
				frame.push(ai);
			} else if (mn == "pushd") {
				ASMReal ar = new ASMReal(Double.parseDouble(ops));
				frame.push(ar);
			} else if (mn == "pusht") {
				frame.push(new ASMBoolean(true));
			} else if (mn == "pushf") {
				frame.push(new ASMBoolean(false));
			} else if (mn == "enditerate") {
				return;
			} else if (mn == "if") {
				if (((ASMBoolean)frame.pop()).getSymbol()) {
					int target = Integer.parseInt(ops);
					frame.setLocation(target - 1);
				}
			} else if (mn == "goto") {
				int target = Integer.parseInt(ops);
				frame.setLocation(target - 1);
			} else if (mn == "getasm") {
				frame.push(((ASMExecEnv)frame.getExecEnv()).getASMModule());
			} else if (mn == "iterate") {
				ASMOclAny v = frame.pop();
				if (!(v instanceof ASMCollection)) {
					frame.printStackTrace("Cannot iterate on non-collection");
				}
				ASMCollection c = (ASMCollection)v; // TODO: iterate <index> (jusqu'ou iterer...) plutot que
				// enditerate
				int oldLocation = frame.getLocation();
				for (Iterator j = c.iterator(); j.hasNext();) {
					frame.push((ASMOclAny)j.next());
					// frame.step();
					realExec(frame);
					frame.setLocation(oldLocation);
				}
				int nested = 0;
				do {
					String mnc = frame.nextInstruction().getMnemonic();
					if (mnc == "enditerate") {
						if (nested == 0) {
							break;
						}
						nested--;
					} else if (mnc == "iterate") {
						nested++;
					}
				} while (true);
			} else {
				frame.printStackTrace("Instruction not implemented yet : " + mn);
			}

		}
	}

	// BEGIN SIGNATURE TOOLS
	private static Pattern pattern1 = Pattern.compile("^.*\\(");

	private static int getNbArgs(String s) {
		int ret = 0;

		s = pattern1.matcher(s).replaceFirst("");
		while (!s.startsWith(")") && s.length() > 0) {
			ret++;
			s = removeFirst(s);
		}

		return ret;
	}

	private static Pattern simple = Pattern.compile("^J|I|B|S|D|A|(M|N)[^;]*;|L");

	private static Pattern pattern2 = Pattern.compile("^(Q|G|C|E|O).*");

	private static String removeFirst(String s) {
		if (s.startsWith("T")) {
			s = s.substring(1);
			while (!s.startsWith(";")) {
				s = removeFirst(s);
			}
			s = s.substring(1);
		} else if (pattern2.matcher(s).matches()) {
			s = removeFirst(s.substring(1));
		} else {
			s = simple.matcher(s).replaceFirst("");
		}

		return s;
	}

	private static String getOpName(String s) {
		return s.substring(s.indexOf(".") + 1, s.indexOf("("));
	}

	// END SIGNATURE TOOLS

	/** Temporary storage for lineNumberEntries began but not yet ended. */
	private Map lineNumberEntries = new HashMap();

	private String lastLNE = null;

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

	/** Temporary storage for localVariableEntries began but not yet ended. */
	private Map localVariableEntries = new HashMap();

	public int beginLocalVariableEntry(String id, String name) {
		LocalVariableEntry lve = (LocalVariableEntry)localVariableEntries.get(id);
		if (lve != null) {
			throw new Error("variable id already in use: " + id);
		}
		int slot = reserveSlot();
		localVariableEntries.put(id, new LocalVariableEntry(slot, name, instructions.size(), -1));
		return slot;
	}

	public int endLocalVariableEntry(String id) {
		LocalVariableEntry lve = (LocalVariableEntry)localVariableEntries.remove(id);
		if (lve == null) {
			ATLLogger.severe("Variable id not defined: " + id);
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

	private ASMOclType contextType;

	public void setContextType(ASMOclType contextType) {
		this.contextType = contextType;
	}

	public ASMOclType getReturnType() {
		// TODO Auto-generated method stub
		return null;
	}

	public ASMOclType getContextType() {
		return contextType;
	}
}
