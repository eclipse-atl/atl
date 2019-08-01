/*******************************************************************************
 * Copyright (c) 2011-2012 Dennis Wagelaar, Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util;

/**
 * EMFTVM stack.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public final class Stack {

	private final Object[] stack;
	private int sp = -1;

	/**
	 * Creates a new {@link Stack}.
	 * 
	 * @param maxStack
	 *            the maximum number of slots to allocate for this stack
	 */
	public Stack(final int maxStack) {
		stack = new Object[maxStack];
	}

	/**
	 * Pushes <code>value</code> onto the stack.
	 * 
	 * @param value
	 *            the value to push
	 */
	public void push(final Object value) {
		stack[++sp] = value;
	}

	/**
	 * Pops an element off the stack.
	 * 
	 * @return the top element of the stack.
	 */
	public Object pop() {
		return stack[sp--];
	}

	/**
	 * Pops an element off the stack without returning it.
	 */
	public void popv() {
		sp--;
	}

	/**
	 * Pops <code>n</code> elements off the stack.
	 * 
	 * @param n
	 *            the number of elements to pop
	 * @return the top <code>n</code> element of the stack.
	 */
	public Object[] pop(final int n) {
		final Object[] result = new Object[n];
		sp -= n;
		System.arraycopy(stack, sp + 1, result, 0, n);
		return result;
	}

	/**
	 * Pops <code>n</code> elements off the stack.
	 * 
	 * @param n
	 *            the number of elements to pop
	 * @param result
	 *            the target array
	 * @return the top <code>n</code> element of the stack, in <code>result</code>.
	 */
	public <T> T[] pop(final int n, T[] result) {
		sp -= n;
		System.arraycopy(stack, sp + 1, result, 0, n);
		return result;
	}

	/**
	 * Returns the top element of the stack.
	 * 
	 * @return the top element of the stack.
	 */
	public Object peek() {
		return stack[sp];
	}

	/**
	 * Returns <code>true</code> iff the stack is empty.
	 * 
	 * @return <code>true</code> iff the stack is empty.
	 */
	public boolean stackEmpty() {
		return sp == -1;
	}

	/**
	 * Duplicates top stack value onto stack.
	 */
	public void dup() {
		sp++;
		stack[sp] = stack[sp - 1];
	}

	/**
	 * Pops top two values from stack, pushes top value, then pushes original two values back.
	 */
	public void dupX1() {
		sp++; // .ab...
		final int sp1 = sp - 1;
		final int sp2 = sp1 - 1;
		stack[sp] = stack[sp1]; // aab...
		stack[sp1] = stack[sp2]; // abb...
		stack[sp2] = stack[sp]; // aba...
	}

	/**
	 * Swaps top two values on the stack.
	 */
	public void swap() {
		final Object top = stack[sp]; // ab...
		final int sp1 = sp - 1;
		stack[sp] = stack[sp1]; // bb...
		stack[sp1] = top; // ba...
	}

	/**
	 * Swaps third value over top two values on the stack.
	 */
	public void swapX1() {
		final Object top = stack[sp]; // abc...
		final int sp1 = sp - 1;
		final int sp2 = sp - 2;
		stack[sp] = stack[sp2]; // cbc...
		stack[sp2] = stack[sp1]; // cbb...
		stack[sp1] = top; // cab...
	}

}
