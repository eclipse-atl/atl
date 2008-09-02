/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frédéric Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm;

public class Bytecode {
	
	public final static int PUSH 		= 0;
	public final static int PUSHI 		= 1;
	public final static int PUSHD 		= 2;
	public final static int PUSHT 		= 3;
	public final static int PUSHF 		= 4;
	public final static int CALL 		= 5;
	public final static int LOAD 		= 6;
	public final static int STORE 		= 7;
	public final static int NEW 		= 8;
	public final static int ITERATE 	= 9;
	public final static int ENDITERATE 	= 10;
	public final static int DUP 		= 11;
	public final static int SET 		= 12;
	public final static int GET 		= 13;
	public final static int POP 		= 14;
	public final static int GETASM 		= 15;
	public final static int IF 			= 16;
	public final static int GOTO 		= 17;
	public final static int SWAP 		= 18;
	public final static int FINDME 		= 19;
	public final static int DUP_X1 		= 20;
	public final static int DELETE		= 21;
	
	public final static String opcodeNames[] = {
		"push", "pushi", "pushd", "pusht", "pushf",
		"call", "load", "store", "new", "iterate",
		"enditerate", "dup", "set", "get", "pop",
		"getasm", "if", "goto", "swap", "findme",
		"dup_x1", "delete"
	};
	
	public String toString() {
		return opcodeNames[opcode] + ((operand != null) ? " " + operand : "");
	}
	
	public int opcode;
	public Object operand;
	
	// used for
	//	- nbArgs of call,
	//	- index of load & store,
	//	- target pc of if & goto & iterate(i.e., corresponding enditerate + 1) & enditerate (i.e., corresponding iterate + 1)
	public int value;
	//	- nesting level of iterate & enditerate
	public int value2;
	
	public Bytecode(String opcode, String operand) {
		if(opcode.equals("push")) {
			this.opcode = PUSH;
			this.operand = operand;
		} else if(opcode.equals("pushi")) {
			this.opcode = PUSHI;
			this.operand = Integer.valueOf(operand);
		} else if(opcode.equals("pushd")) {
			this.opcode = PUSHD;
			this.operand = Double.valueOf(operand);
		} else if(opcode.equals("call")) {
			this.opcode = CALL;
			this.operand = getOpName(operand);
			this.value = getNbArgs(operand);
		} else if(opcode.equals("load")) {
			this.opcode = LOAD;
			this.operand = operand;		// for toString
			this.value = Integer.parseInt(operand);
		} else if(opcode.equals("store")) {
			this.opcode = STORE;
			this.operand = operand;		// for toString
			this.value = Integer.parseInt(operand);
		} else if(opcode.equals("set")) {
			this.opcode = SET;
			this.operand = operand;
		} else if(opcode.equals("get")) {
			this.opcode = GET;
			this.operand = operand;
		} else if(opcode.equals("if")) {
			this.opcode = IF;
			this.operand = operand;		// for toString
			this.value = Integer.parseInt(operand);
		} else if(opcode.equals("goto")) {
			this.opcode = GOTO;
			this.operand = operand;		// for toString
			this.value = Integer.parseInt(operand);
		} else {
			throw new RuntimeException("unsupported opcode with argument: " + opcode);
		}
	}
	
	public Bytecode(String opcode) {
		if(opcode.equals("pusht")) {
			this.opcode = PUSHT;
		} else if(opcode.equals("pushf")) {
			this.opcode = PUSHF;
		} else if(opcode.equals("new")) {
			this.opcode = NEW;
		} else if(opcode.equals("iterate")) {
			this.opcode = ITERATE;
		} else if(opcode.equals("enditerate")) {
			this.opcode = ENDITERATE;
		} else if(opcode.equals("dup")) {
			this.opcode = DUP;
		} else if(opcode.equals("pop")) {
			this.opcode = POP;
		} else if(opcode.equals("getasm")) {
			this.opcode = GETASM;
		} else if(opcode.equals("swap")) {
			this.opcode = SWAP;
		} else if(opcode.equals("findme")) {
			this.opcode = FINDME;
		} else if(opcode.equals("dup_x1")) {
			this.opcode = DUP_X1;
		} else if(opcode.equals("delete")) {
			this.opcode = DELETE;
		} else {
			throw new RuntimeException("unsupported opcode without argument: " + opcode);
		}
	}
	
//	 BEGIN SIGNATURE TOOLS
	private static int getNbArgs(String s) {
		int ret = 0;

		s = s.replaceFirst("^.*\\(", "");
		while(!s.startsWith(")")) {
			ret++;
			 s = removeFirst(s);
		}

		return ret;
	}

	private static String removeFirst(String s) {
		String simple = "^J|I|B|S|D|A|(M|N)[^;]*;|L";

		if(s.startsWith("T")) {
			s = s.substring(1);
			while(!s.startsWith(";")) {
				s = removeFirst(s);
			}
			s = s.substring(1);
		} else if(s.matches("^(Q|G|C|E|O).*")) {
			s = removeFirst(s.substring(1));
		} else {
			s = s.replaceFirst(simple, "");
		}

		return s;
	}

	private static String getOpName(String s) {
		return s.substring(s.indexOf(".") + 1, s.indexOf("("));
	}
// END SIGNATURE TOOLS
}
