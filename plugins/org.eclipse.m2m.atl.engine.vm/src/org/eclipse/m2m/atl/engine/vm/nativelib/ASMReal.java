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
package org.eclipse.m2m.atl.engine.vm.nativelib;

import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ASMReal extends ASMNumber {

	public ASMReal(double s) {
		super(myType);
		this.s = s;
	}

	public String toString() {
		return "" + s;
	}

	public double getSymbol() {
		return s;
	}

	public double asDouble() {
		return s;
	}
	
	public boolean equals(Object o) {
		return (o instanceof ASMReal) && (((ASMReal)o).s == s);
	}

	// Native Operations below

/* TODO: ATL VM does not support operation name overloading yet.
	public static ASMReal operatorMinus(StackFrame frame, ASMReal self) {
		return new ASMReal(-self.s);
	}
*/
	public static ASMReal operatorMinus(StackFrame frame, ASMReal self, ASMNumber o) {
		return new ASMReal(self.s - o.asDouble());
	}

	public static ASMReal operatorPlus(StackFrame frame, ASMReal self, ASMNumber o) {
		return new ASMReal(self.s + o.asDouble());
	}

	public static ASMReal operatorMul(StackFrame frame, ASMReal self, ASMNumber o) {
		return new ASMReal(self.s * o.asDouble());
	}

	public static ASMReal operatorDiv(StackFrame frame, ASMReal self, ASMNumber o) {
		return new ASMReal(self.s / o.asDouble());
	}

	public static ASMBoolean operatorEQ(StackFrame frame, ASMReal self, ASMNumber o) {
		return new ASMBoolean(self.s == o.asDouble());
	}

	public static ASMBoolean operatorNE(StackFrame frame, ASMReal self, ASMNumber o) {
		return new ASMBoolean(self.s != o.asDouble());
	}

	public static ASMBoolean operatorLT(StackFrame frame, ASMReal self, ASMNumber o) {
		return new ASMBoolean(self.s < o.asDouble());
	}

	public static ASMBoolean operatorLE(StackFrame frame, ASMReal self, ASMNumber o) {
		return new ASMBoolean(self.s <= o.asDouble());
	}

	public static ASMBoolean operatorGT(StackFrame frame, ASMReal self, ASMNumber o) {
		return new ASMBoolean(self.s > o.asDouble());
	}

	public static ASMBoolean operatorGE(StackFrame frame, ASMReal self, ASMNumber o) {
		return new ASMBoolean(self.s >= o.asDouble());
	}

	public static ASMString toString(StackFrame frame, ASMReal self) {
		return new ASMString("" + self.s);
	}
	
	public static ASMReal abs(StackFrame frame, ASMReal self) {
		return new ASMReal(Math.abs(self.s));
	}

	public static ASMInteger round(StackFrame frame, ASMReal self) {
		return new ASMInteger((int)Math.round(self.s));
	}

	public static ASMInteger floor(StackFrame frame, ASMReal self) {
		return new ASMInteger((int)Math.floor(self.s));
	}

	public static ASMReal max(StackFrame frame, ASMReal self, ASMNumber o) {
		return new ASMReal(Math.max(self.s, o.asDouble()));
	}

	public static ASMReal min(StackFrame frame, ASMReal self, ASMNumber o) {
		return new ASMReal(Math.min(self.s, o.asDouble()));
	}

	// Trigonometric functions, not in the OCL spec
	
	public static ASMReal acos(StackFrame frame, ASMNumber self) {
		return new ASMReal(Math.acos(self.asDouble()));
	}

	public static ASMReal asin(StackFrame frame, ASMNumber self) {
		return new ASMReal(Math.asin(self.asDouble()));
	}

	public static ASMReal atan(StackFrame frame, ASMNumber self) {
		return new ASMReal(Math.atan(self.asDouble()));
	}

	public static ASMReal cos(StackFrame frame, ASMNumber self) {
		return new ASMReal(Math.cos(self.asDouble()));
	}

	public static ASMReal sin(StackFrame frame, ASMNumber self) {
		return new ASMReal(Math.sin(self.asDouble()));
	}

	public static ASMReal tan(StackFrame frame, ASMNumber self) {
		return new ASMReal(Math.tan(self.asDouble()));
	}
	
	public static ASMReal toDegrees(StackFrame frame, ASMNumber self) {
		return new ASMReal(Math.toDegrees(self.asDouble()));
	}
	
	public static ASMReal toRadians(StackFrame frame, ASMNumber self) {
		return new ASMReal(Math.toRadians(self.asDouble()));
	}
	
	// Other mathematical functions, not in the OCL spec

	public static ASMReal exp(StackFrame frame, ASMNumber self) {
		return new ASMReal(Math.exp(self.asDouble()));
	}
	
	public static ASMReal log(StackFrame frame, ASMNumber self) {
		return new ASMReal(Math.log(self.asDouble()));
	}
	
	public static ASMReal sqrt(StackFrame frame, ASMNumber self) {
		return new ASMReal(Math.sqrt(self.asDouble()));
	}
	

	private double s;
}

