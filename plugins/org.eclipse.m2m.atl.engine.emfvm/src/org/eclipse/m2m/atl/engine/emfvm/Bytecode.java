/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm;

/**
 * Defines the ATL VM bytecodes.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class Bytecode {

	/** Push string constant. */
	public static final int PUSH = 0;

	/** Push int constant. */
	public static final int PUSHI = 1;

	/** Push double constant. */
	public static final int PUSHD = 2;

	/** Push true boolean constant. */
	public static final int PUSHT = 3;

	/** Push false boolean constant. */
	public static final int PUSHF = 4;

	/** Call a method. */
	public static final int CALL = 5;

	/** Load value from local variable. */
	public static final int LOAD = 6;

	/** Store value into local variable. */
	public static final int STORE = 7;

	/** Call a method. */
	public static final int NEW = 8;

	/** Delimitate the beginning of iteration on collection elements. */
	public static final int ITERATE = 9;

	/** Delimitate the end of iteration on collection elements. */
	public static final int ENDITERATE = 10;

	/** Duplicate the top operand stack value. */
	public static final int DUP = 11;

	/** Set field in object. */
	public static final int SET = 12;

	/** Fetch field from object. */
	public static final int GET = 13;

	/** Pop the top operand stack value. */
	public static final int POP = 14;

	/** Fetch the asm element. */
	public static final int GETASM = 15;

	/** Branch if boolean value b is true. */
	public static final int IF = 16;

	/** Branch always. */
	public static final int GOTO = 17;

	/** Swap the two top operand stack values. */
	public static final int SWAP = 18;

	/** Fetch a classifier. */
	public static final int FINDME = 19;

	/** Duplicate the top operand stack value and insert two values down. */
	public static final int DUP_X1 = 20;

	/** Deletes an element. */
	public static final int DELETE = 21;

	/** List of codes. */
	public static final String[] OPCODENAMES = {"push", "pushi", "pushd", "pusht", "pushf", "call", "load",
			"store", "new", "iterate", "enditerate", "dup", "set", "get", "pop", "getasm", "if", "goto",
			"swap", "findme", "dup_x1", "delete",};

	/** current code. */
	private int opcode;

	/** current operand. */
	private Object operand;

	/**
	 * used for - nbArgs of call, - index of load & store, - target pc of if & goto & iterate(i.e.,
	 * corresponding enditerate + 1) & enditerate (i.e., corresponding iterate + 1).
	 */
	private int value;

	/** - nesting level of iterate & enditerate. */
	private int value2;

	/**
	 * Bytecode constructor, for bytecodes which needs an operand.
	 * 
	 * @param opcode
	 *            the bytecode name
	 */
	public Bytecode(String opcode) {
		if (opcode.equals("pusht")) {
			this.opcode = PUSHT;
		} else if (opcode.equals("pushf")) {
			this.opcode = PUSHF;
		} else if (opcode.equals("new")) {
			this.opcode = NEW;
		} else if (opcode.equals("iterate")) {
			this.opcode = ITERATE;
		} else if (opcode.equals("enditerate")) {
			this.opcode = ENDITERATE;
		} else if (opcode.equals("dup")) {
			this.opcode = DUP;
		} else if (opcode.equals("pop")) {
			this.opcode = POP;
		} else if (opcode.equals("getasm")) {
			this.opcode = GETASM;
		} else if (opcode.equals("swap")) {
			this.opcode = SWAP;
		} else if (opcode.equals("findme")) {
			this.opcode = FINDME;
		} else if (opcode.equals("dup_x1")) {
			this.opcode = DUP_X1;
		} else if (opcode.equals("delete")) {
			this.opcode = DELETE;
		} else {
			throw new RuntimeException("unsupported opcode without argument: " + opcode);
		}
	}

	/**
	 * Bytecode constructor, for bytecodes which needs an operand.
	 * 
	 * @param opcode
	 *            the bytecode name
	 * @param operand
	 *            the operand
	 */
	public Bytecode(String opcode, String operand) {
		if (opcode.equals("push")) {
			this.opcode = PUSH;
			this.operand = operand;
		} else if (opcode.equals("pushi")) {
			this.opcode = PUSHI;
			this.operand = Integer.valueOf(operand);
		} else if (opcode.equals("pushd")) {
			this.opcode = PUSHD;
			this.operand = Double.valueOf(operand);
		} else if (opcode.equals("call")) {
			this.opcode = CALL;
			this.operand = getOpName(operand);
			this.value = getNbArgs(operand);
		} else if (opcode.equals("load")) {
			this.opcode = LOAD;
			this.operand = operand; // for toString
			this.value = Integer.parseInt(operand);
		} else if (opcode.equals("store")) {
			this.opcode = STORE;
			this.operand = operand; // for toString
			this.value = Integer.parseInt(operand);
		} else if (opcode.equals("set")) {
			this.opcode = SET;
			this.operand = operand;
		} else if (opcode.equals("get")) {
			this.opcode = GET;
			this.operand = operand;
		} else if (opcode.equals("if")) {
			this.opcode = IF;
			this.operand = operand; // for toString
			this.value = Integer.parseInt(operand);
		} else if (opcode.equals("goto")) {
			this.opcode = GOTO;
			this.operand = operand; // for toString
			this.value = Integer.parseInt(operand);
		} else {
			throw new RuntimeException("unsupported opcode with argument: " + opcode);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return OPCODENAMES[opcode] + ((operand != null) ? " " + operand : "");
	}

	// BEGIN SIGNATURE TOOLS
	private static int getNbArgs(String s) {
		int ret = 0;
		String tmp = s;
		tmp = tmp.replaceFirst("^.*\\(", "");
		while (!tmp.startsWith(")")) {
			ret++;
			tmp = removeFirst(tmp);
		}

		return ret;
	}

	private static String removeFirst(String s) {
		String simple = "^J|I|B|S|D|A|(M|N)[^;]*;|L";
		String tmp = s;
		if (s.startsWith("T")) {
			tmp = tmp.substring(1);
			while (!tmp.startsWith(";")) {
				tmp = removeFirst(tmp);
			}
			tmp = tmp.substring(1);
		} else if (tmp.matches("^(Q|G|C|E|O).*")) {
			tmp = removeFirst(s.substring(1));
		} else {
			tmp = tmp.replaceFirst(simple, "");
		}

		return tmp;
	}

	private static String getOpName(String s) {
		return s.substring(s.indexOf(".") + 1, s.indexOf("("));
	}
	// END SIGNATURE TOOLS

	public int getOpcode() {
		return opcode;
	}

	public Object getOperand() {
		return operand;
	}

	public void setOperand(Object operand) {
		this.operand = operand;
	}

	public int getValue() {
		return value;
	}

	public int getValue2() {
		return value2;
	}

	public void setValue2(int value2) {
		this.value2 = value2;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
