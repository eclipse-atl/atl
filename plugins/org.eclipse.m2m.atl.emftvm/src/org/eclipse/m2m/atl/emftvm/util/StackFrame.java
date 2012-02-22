/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.LineNumber;
import org.eclipse.m2m.atl.emftvm.LocalVariable;
import org.eclipse.m2m.atl.emftvm.Module;

/**
 * EMFTVM stack frame.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public final class StackFrame {

	private static final Object[] EMPTY = new Object[0];

	private final ExecEnv env;
	private final StackFrame parent;
	private final CodeBlock codeBlock;
	private final Method nativeMethod;
	private final Object[] locals;
	private final Object[] stack;
	private int sp = -1;
	private int pc = -1; // Only set when necessary

	/**
	 * Creates a new {@link StackFrame}.
	 * Use only for root frames!
	 * @param env the current {@link ExecEnv}
	 * @param codeBlock the codeBlock context for this stack frame
	 */
	public StackFrame(final ExecEnv env, final CodeBlock codeBlock) {
		this.env = env;
		this.parent = null;
		this.codeBlock = codeBlock;
		this.nativeMethod = null;
		locals = new Object[codeBlock.getMaxLocals()];
		stack = new Object[codeBlock.getMaxStack()];
	}

	/**
	 * Creates a new {@link StackFrame}.
	 * @param parent the parent stack frame, if any
	 * @param codeBlock the codeBlock context for this stack frame
	 */
	public StackFrame(final StackFrame parent, final CodeBlock codeBlock) {
		this.env = parent.env;
		this.parent = parent;
		this.codeBlock = codeBlock;
		this.nativeMethod = null;
		locals = new Object[codeBlock.getMaxLocals()];
		stack = new Object[codeBlock.getMaxStack()];
	}

	/**
	 * Creates a new {@link StackFrame}.
	 * @param parent the parent stack frame, if any
	 * @param nativeMethod the native Java method context for this stack frame
	 */
	public StackFrame(final StackFrame parent, final Method nativeMethod) {
		this.env = parent.env;
		this.parent = parent;
		this.codeBlock = null;
		this.nativeMethod = nativeMethod;
		this.locals = EMPTY;
		this.stack = EMPTY;
	}

	/**
	 * Pushes <pre>value</pre> onto the stack.
	 * @param value the value to push
	 */
	public void push(final Object value) {
		stack[++sp] = value;
	}

	/**
	 * Pops an element off the stack.
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
	 * Returns the top element of the stack.
	 * @return the top element of the stack.
	 */
	public Object peek() {
		return stack[sp];
	}

	/**
	 * Returns <code>true</code> iff the stack is empty.
	 * @return <code>true</code> iff the stack is empty.
	 */
	public boolean stackEmpty() {
		return sp == -1;
	}

	/**
	 * Returns the stack frame of cb, starting at the parent, if any, otherwise <code>null</code>.
	 * @param cb the code block
	 * @return the stack frame of cb, starting at the parent, if any, otherwise <code>null</code>
	 */
	private StackFrame getStackFrameFor(final CodeBlock cb) {
		StackFrame parent = this.parent;
		while (parent != null) {
			if (parent.codeBlock == cb) {
				return parent;
			}
			parent = parent.parent;
		}
		return null;
	}

	/**
	 * Returns the parent codeblock that lies <pre>cbOffset</pre> positions up, or <code>null</code>.
	 * @param cbOffset the codeblock offset
	 * @return the parent codeblock that lies <pre>cbOffset</pre> positions up, or <code>null</code>
	 */
	private CodeBlock getCodeBlock(final int cbOffset) {
		CodeBlock cb = this.codeBlock;
		for (int i = 0; i < cbOffset; i++) {
			cb = cb.getNestedFor();
		}
		return cb;
	}

	/**
	 * Sets local variable with given <pre>slot</pre> to <pre>value</pre>.
	 * @param cbOffset the codeblock offset
	 * @param slot the variable slot
	 * @param value the value to set
	 */
	public void setLocal(final int cbOffset, final int slot, final Object value) {
		if (cbOffset > 0) {
			try {
				final CodeBlock cb = getCodeBlock(cbOffset);
				final StackFrame parent = getStackFrameFor(cb);
				parent.locals[slot] = value;
			} catch (Exception e) {
				throw new IllegalArgumentException(String.format(
						"Cannot address super-block local variable %d from %s",
						slot, this), e);
			}
		} else {
			locals[slot] = value;
		}
	}

	/**
	 * Sets the first local variables to the given values.
	 * @param self the "self" variable value
	 * @param values the other local variable values
	 */
	public void setLocals(final Object self, final Object[] values) {
		locals[0] = self;
		System.arraycopy(values, 0, locals, 1, values.length);
	}

	/**
	 * Sets the first local variables to the given values.
	 * @param values the local variable values
	 */
	public void setLocals(final Object[] values) {
		System.arraycopy(values, 0, locals, 0, values.length);
	}

	/**
	 * Returns the local variable value with the given slot.
	 * @param cbOffset parent code block offset
	 * @param slot the local variable slot
	 * @return the local variable value with the given slot.
	 */
	public Object getLocal(final int cbOffset, final int slot) {
		if (cbOffset > 0) {
			try {
				final CodeBlock cb = getCodeBlock(cbOffset);
				final StackFrame parent = getStackFrameFor(cb);
				return parent.locals[slot];
			} catch (Exception e) {
				throw new IllegalArgumentException(String.format(
						"Cannot address super-block local variable %d from %s",
						slot, this), e);
			}
		}
		return locals[slot];
	}

	/**
	 * Loads local variable with given cbOffset and slot onto the stack.
	 * @param cbOffset code block offset
	 * @param slot the local variable slot
	 */
	public void load(final int cbOffset, final int slot) {
		stack[++sp] = getLocal(cbOffset, slot);
	}

	/**
	 * Pops top stack value into local variable with given cbOffset and slot.
	 * @param cbOffset code block offset
	 * @param slot the local variable slot
	 */
	public void store(final int cbOffset, final int slot) {
		setLocal(cbOffset, slot, stack[sp--]);
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
		sp++;						// .ab...
		final int sp1 = sp - 1;
		final int sp2 = sp1 - 1;
		stack[sp] = stack[sp1];		// aab...
		stack[sp1] = stack[sp2];	// abb...
		stack[sp2] = stack[sp];		// aba...
	}

	/**
	 * Swaps top two values on the stack.
	 */
	public void swap() {
		final Object top = stack[sp];	// ab...
		final int sp1 = sp - 1;
		stack[sp] = stack[sp1];			// bb...
		stack[sp1] = top;				// ba...
	}

	/**
	 * Swaps third value over top two values on the stack.
	 */
	public void swapX1() {
		final Object top = stack[sp];	// abc...
		final int sp1 = sp - 1;
		final int sp2 = sp - 2;
		stack[sp] = stack[sp2];			// cbc...
		stack[sp2] = stack[sp1];		// cbb...
		stack[sp1] = top;				// cab...
	}

	/**
	 * Returns the parent stack frame.
	 * @return the parent stack frame
	 */
	public StackFrame getParent() {
		return parent;
	}

	/**
	 * Returns the codeBlock.
	 * @return the codeBlock
	 */
	public CodeBlock getCodeBlock() {
		return codeBlock;
	}

	/**
	 * Returns the {@link ExecEnv}.
	 * @return the env
	 */
	public ExecEnv getEnv() {
		return env;
	}

	/**
	 * Returns the nativeMethod.
	 * @return the nativeMethod
	 */
	public Method getNativeMethod() {
		return nativeMethod;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		final CodeBlock cb = getCodeBlock();
		final Method m = getNativeMethod();
		final int loc = getLocation();
		final StringBuffer sb = new StringBuffer("at ");
		if (cb != null) {
			sb.append(cb);
		} else if (m != null) {
			sb.append(m);
		} else {
			sb.append(super.toString());
		}
		if (loc > -1) {
			sb.append('#');
			sb.append(loc);
			if (cb != null) {
				sb.append('(');
				final Module module = cb.getModule();
				if (module != null) {
					sb.append(module);
				} else {
					sb.append("<unknown>");
				}
				final String sloc = getSourceLocation();
				if (sloc != null) {
					sb.append("#[");
					sb.append(sloc);
					sb.append(']');
				}
				sb.append(')');
			}
		} else if (cb != null) {
			sb.append('(');
			final Module module = cb.getModule();
			if (module != null) {
				sb.append(module);
			} else {
				sb.append("<unknown>");
			}
			sb.append(')');
		}
		sb.append("\n\tLocal variables: ");
		if (cb != null && loc > -1) {
			sb.append('[');
			boolean first = true;
			for (int slot = 0; slot < locals.length; slot++) {
				if (!first) {
					sb.append(", ");
				}
				first = false;
				for (LocalVariable lv : cb.getLocalVariables()) {
					if (lv.getSlot() == slot && lv.getStartInstructionIndex() <= loc && lv.getEndInstructionIndex() >= loc) {
						sb.append(lv.toString());
						sb.append(" = ");
						sb.append(EMFTVMUtil.toPrettyString(locals[slot], getEnv()));
						break;
					}
				}
			}
			sb.append(']');
		} else {
			sb.append(EMFTVMUtil.toPrettyString(locals, getEnv()));
		}
		final StackFrame parent = getParent();
		if (parent != null) {
			sb.append('\n');
			sb.append(parent.toString());
		}
		return sb.toString();
	}

	/**
	 * Sets the pc.
	 * @param pc the pc to set
	 */
	public void setPc(int pc) {
		this.pc = pc;
	}

	/**
	 * Returns the pc.
	 * @return the pc
	 */
	public int getPc() {
		return pc;
	}

	/**
	 * Retrieves a new stack frame that is a sub-frame of <code>this</code>.
	 * @param cb the code block of the sub-frame
	 * @param args the arguments to pass into the sub-frame
	 * @return a new stack frame
	 */
	public StackFrame getSubFrame(final CodeBlock cb, final Object[] args) {
		final StackFrame frame = new StackFrame(this, cb);
		if (args != null) {
			frame.setLocals(args);
		}
		return frame;
	}

	/**
	 * Retrieves a new stack frame that is a sub-frame of <code>this</code>.
	 * @param cb the code block of the sub-frame
	 * @param context the <code>self</code> argument to pass into the sub-frame
	 * @param args the other arguments to pass into the sub-frame
	 * @return a new stack frame
	 */
	public StackFrame getSubFrame(final CodeBlock cb, final Object context, final Object[] args) {
		final StackFrame frame = new StackFrame(this, cb);
		if (args != null) {
			frame.setLocals(context, args);
		} else {
			frame.setLocal(0, 0, context);
		}
		return frame;
	}

	/**
	 * Prepares <code>args</code> instances of {@link CodeBlock} by setting their parent frame
	 * (for VM re-entry), and instances of {@link EnumLiteral} for conversion to the method's
	 * corresponding parameter type.
	 * Creates a sub-frame only when necessary for VM re-entry.
	 * @param method the native method to be invoked
	 * @param args the method arguments
	 * @return the sub-frame, if necessary
	 */
	public StackFrame prepareNativeArgs(final Method method, final Object[] args) {
		StackFrame subFrame = null;
		for (int i = 0; i < args.length; i++) {
			Object arg = args[i];
			if (arg instanceof CodeBlock) {
				if (subFrame == null) {
					subFrame = new StackFrame(this, method);
				}
				((CodeBlock)arg).setParentFrame(subFrame);
			} else if (arg instanceof EnumLiteral) {
				args[i] = convertEnumLiteral((EnumLiteral)arg, method.getParameterTypes()[i]);
			}
		}
		return subFrame;
	}

	/**
	 * Prepares <code>context</code> and <code>args</code> instances of {@link CodeBlock}
	 * by setting their parent frame (for VM re-entry), and instances of {@link EnumLiteral}
	 * for conversion to the method's corresponding parameter type.
	 * Creates a sub-frame only when necessary for VM re-entry.
	 * @param method the native method to be invoked
	 * @param context the method context (i.e. self)
	 * @param args the method arguments
	 * @return the sub-frame, if necessary
	 */
	public StackFrame prepareNativeArgs(final Method method, final Object context, final Object[] args) {
		StackFrame subFrame = null;
		if (context instanceof CodeBlock) {
			if (subFrame == null) {
				subFrame = new StackFrame(this, method);
			}
			((CodeBlock)context).setParentFrame(subFrame);
		} // context can never be an enumeration literal
		for (int i = 0; i < args.length; i++) {
			Object arg = args[i];
			if (arg instanceof CodeBlock) {
				if (subFrame == null) {
					subFrame = new StackFrame(this, method);
				}
				((CodeBlock)arg).setParentFrame(subFrame);
			} else if (arg instanceof EnumLiteral) {
				args[i] = convertEnumLiteral((EnumLiteral)arg, method.getParameterTypes()[i]);
			}
		}
		return subFrame;
	}

	/**
	 * Tries to convert literal to an instance of type.
	 * @param literal the enum literal to convert
	 * @param type the type to instantiate
	 * @return an instance of type, or literal if conversion failed
	 */
	private static Object convertEnumLiteral(final EnumLiteral literal, final Class<?> type) {
		if (Enumerator.class.isAssignableFrom(type)) {
			try {
				final String litName = literal.getName();
				final java.lang.reflect.Field valuesField = type.getDeclaredField("VALUES");
				final Object values = valuesField.get(null);
				if (values instanceof Collection<?>) {
					for (Object value : (Collection<?>)values) {
						if (value instanceof Enumerator) {
							if (litName.equals(((Enumerator)value).getName()) ||
								litName.equals(value.toString())) {
								return value;
							}
						}
					}
				}
			// Ignore exceptions; just don't convert here
			} catch (SecurityException e) {
				// do nothing
			} catch (NoSuchFieldException e) {
				// do nothing
			} catch (IllegalArgumentException e) {
				// do nothing
			} catch (IllegalAccessException e) {
				// do nothing
			}
		}
		return literal;
	}

	/**
	 * Gets a sequence of nested stacks (for debugger).
	 * @return the Stack list
	 */
	public LazyList<StackFrame> getStack() {
		LazyList<StackFrame> res = new LazyList<StackFrame>();
		StackFrame f = this;
		while (f != null) {
			res = res.prepend(f);
			f = f.getParent();
		}
		return res;
	}

	/**
	 * Returns the local variables map (for debugger).
	 * @return the local variables map
	 */
	public Map<String, Object> getLocalVariables() {
		final Map<String, Object> ret = new HashMap<String, Object>();
		for (int slot = 0; slot < locals.length; slot++) {
			ret.put(String.valueOf(slot), locals[slot]);
		}
		return ret;
	}

	/**
	 * Returns the local variable name at the given <code>slot</code> (for debugger).
	 * @param slot the local variable slot
	 * @return the variable name at the given slot
	 */
	public String resolveVariableName(int slot) {
		final CodeBlock cb = getCodeBlock();
		final int loc = getLocation();

		if (cb != null && loc > -1) {
			for (LocalVariable lv : cb.getLocalVariables()) {
				if (lv.getSlot() == slot && lv.getStartInstructionIndex() <= loc && lv.getEndInstructionIndex() >= loc) {
					return lv.getName();
				}
			}
		}

		return String.valueOf(slot);
	}

	/**
	 * Returns the {@link CodeBlock} (for debugger).
	 * @return the {@link CodeBlock}.
	 * @see #getCodeBlock()
	 */
	public CodeBlock getOperation() {
		CodeBlock cb = getCodeBlock();
		if (cb == null) {
			cb = getParent().getOperation();
		}
		return cb;
	}

	/**
	 * Returns the current instruction pointer value (starts at 0, for debugger).
	 * @return the current instruction pointer value
	 * @see #getPc()
	 */
	public int getLocation() {
		return getPc() - 1;
	}

	/**
	 * Returns the source code location of the current instruction location (for debugger).
	 * @return the source code location of the instruction at the current location.
	 * @see #getLocation()
	 * @see #getLineNumber()
	 */
	public String getSourceLocation() {
		final LineNumber ln = getLineNumber();
		if (ln != null) {
			return ln.toString();
		}
		return null;
	}

	/**
	 * Returns the source code line number of the current instruction location (for debugger).
	 * @return the source code line number of the instruction at the current location.
	 * @see #getLocation()
	 */
	public LineNumber getLineNumber() {
		final int location = getLocation();
		final CodeBlock cb = getCodeBlock();
		if (location > -1 && cb != null) {
			final LineNumber ln = cb.getCode().get(location).getLineNumber();
			if (ln != null) {
				return ln;
			}
		}
		return null;
	}

	/**
	 * Returns the "operation" name for this stack frame (for debugger).
	 * @return the "operation" name for this stack frame
	 */
	public String getOpName() {
		final CodeBlock cb = getCodeBlock();
		if (cb != null) {
			return cb.toString();
		}
		final Method m = getNativeMethod();
		if (m != null) {
			return m.toString();
		}
		return "<unknown>";
	}

}
