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

	/** Call a procedure (i.e., an operation with no returned value). */
	public static final int PCALL = 22;

	/** List of codes. */
	public static final String[] OPCODENAMES = {"push", //$NON-NLS-1$
			"pushi", //$NON-NLS-1$
			"pushd", //$NON-NLS-1$
			"pusht", //$NON-NLS-1$
			"pushf", //$NON-NLS-1$
			"call", //$NON-NLS-1$
			"load", //$NON-NLS-1$
			"store", //$NON-NLS-1$
			"new", //$NON-NLS-1$
			"iterate", //$NON-NLS-1$
			"enditerate", //$NON-NLS-1$
			"dup", //$NON-NLS-1$
			"set", //$NON-NLS-1$
			"get", //$NON-NLS-1$
			"pop", //$NON-NLS-1$
			"getasm", //$NON-NLS-1$
			"if", //$NON-NLS-1$
			"goto", //$NON-NLS-1$
			"swap", //$NON-NLS-1$
			"findme", //$NON-NLS-1$
			"dup_x1", //$NON-NLS-1$
			"delete", //$NON-NLS-1$
			"pcall", //$NON-NLS-1$
	};

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
		if (opcode.equals("pusht")) { //$NON-NLS-1$
			this.opcode = PUSHT;
		} else if (opcode.equals("pushf")) { //$NON-NLS-1$
			this.opcode = PUSHF;
		} else if (opcode.equals("new")) { //$NON-NLS-1$
			this.opcode = NEW;
		} else if (opcode.equals("iterate")) { //$NON-NLS-1$
			this.opcode = ITERATE;
		} else if (opcode.equals("enditerate")) { //$NON-NLS-1$
			this.opcode = ENDITERATE;
		} else if (opcode.equals("dup")) { //$NON-NLS-1$
			this.opcode = DUP;
		} else if (opcode.equals("pop")) { //$NON-NLS-1$
			this.opcode = POP;
		} else if (opcode.equals("getasm")) { //$NON-NLS-1$
			this.opcode = GETASM;
		} else if (opcode.equals("swap")) { //$NON-NLS-1$
			this.opcode = SWAP;
		} else if (opcode.equals("findme")) { //$NON-NLS-1$
			this.opcode = FINDME;
		} else if (opcode.equals("dup_x1")) { //$NON-NLS-1$
			this.opcode = DUP_X1;
		} else if (opcode.equals("delete")) { //$NON-NLS-1$
			this.opcode = DELETE;
		} else {
			throw new VMException(null,Messages.getString(
					"ByteCode.UNSUPPORTEDOPCODEWOARGS", opcode)); //$NON-NLS-1$
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
		if (opcode.equals("push")) { //$NON-NLS-1$
			this.opcode = PUSH;
			this.operand = operand;
		} else if (opcode.equals("pushi")) { //$NON-NLS-1$
			this.opcode = PUSHI;
			this.operand = Integer.valueOf(operand);
		} else if (opcode.equals("pushd")) { //$NON-NLS-1$
			this.opcode = PUSHD;
			this.operand = Double.valueOf(operand);
		} else if (opcode.equals("call")) { //$NON-NLS-1$
			this.opcode = CALL;
			this.operand = getOpName(operand);
			this.value = getNbArgs(operand);
		} else if (opcode.equals("load")) { //$NON-NLS-1$
			this.opcode = LOAD;
			this.operand = operand; // for toString
			this.value = Integer.parseInt(operand);
		} else if (opcode.equals("store")) { //$NON-NLS-1$
			this.opcode = STORE;
			this.operand = operand; // for toString
			this.value = Integer.parseInt(operand);
		} else if (opcode.equals("set")) { //$NON-NLS-1$
			this.opcode = SET;
			this.operand = operand;
		} else if (opcode.equals("get")) { //$NON-NLS-1$
			this.opcode = GET;
			this.operand = operand;
		} else if (opcode.equals("if")) { //$NON-NLS-1$
			this.opcode = IF;
			this.operand = operand; // for toString
			this.value = Integer.parseInt(operand);
		} else if (opcode.equals("goto")) { //$NON-NLS-1$
			this.opcode = GOTO;
			this.operand = operand; // for toString
			this.value = Integer.parseInt(operand);
		} else if (opcode.equals("pcall")) { //$NON-NLS-1$
			this.opcode = PCALL;
			this.operand = getOpName(operand);
			this.value = getNbArgs(operand);
		} else {
			throw new VMException(null,Messages.getString(
					"ByteCode.UNSUPPORTEDOPCODEWARGS", opcode)); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return OPCODENAMES[opcode] + ((operand != null) ? " " + operand : ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	// BEGIN SIGNATURE TOOLS
	private static int getNbArgs(String s) {
		int ret = 0;
		String tmp = s;
		tmp = tmp.replaceFirst("^.*\\(", ""); //$NON-NLS-1$ //$NON-NLS-2$
		while (!tmp.startsWith(")")) { //$NON-NLS-1$
			ret++;
			tmp = removeFirst(tmp);
		}

		return ret;
	}

	private static String removeFirst(String s) {
		String simple = "^J|I|B|S|D|A|(M|N)[^;]*;|L"; //$NON-NLS-1$
		String tmp = s;
		if (s.startsWith("T")) { //$NON-NLS-1$
			tmp = tmp.substring(1);
			while (!tmp.startsWith(";")) { //$NON-NLS-1$
				tmp = removeFirst(tmp);
			}
			tmp = tmp.substring(1);
		} else if (tmp.matches("^(Q|G|C|E|O).*")) { //$NON-NLS-1$
			tmp = removeFirst(s.substring(1));
		} else {
			tmp = tmp.replaceFirst(simple, ""); //$NON-NLS-1$
		}

		return tmp;
	}

	private static String getOpName(String s) {
		return s.substring(s.indexOf(".") + 1, s.indexOf("(")); //$NON-NLS-1$ //$NON-NLS-2$
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
