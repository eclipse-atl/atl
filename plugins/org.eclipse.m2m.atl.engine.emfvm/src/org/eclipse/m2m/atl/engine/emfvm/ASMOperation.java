/*******************************************************************************
 * Copyright (c) 2007, 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *    Obeo - bag implementation
 *    Obeo - metamodel method support
 *    
 * $Id: ASMOperation.java,v 1.22 2009/02/13 08:43:10 wpiers Exp $
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.WeakHashMap;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame;
import org.eclipse.m2m.atl.engine.emfvm.lib.ExecEnv;
import org.eclipse.m2m.atl.engine.emfvm.lib.HasFields;
import org.eclipse.m2m.atl.engine.emfvm.lib.OclType;
import org.eclipse.m2m.atl.engine.emfvm.lib.OclUndefined;
import org.eclipse.m2m.atl.engine.emfvm.lib.Operation;

/**
 * ASM commands scheduler.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:mikael.barbero@univ-nantes.fr">Mikael Barbero</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class ASMOperation extends Operation {

	/** The max size of the Stack. */
	public static final int MAX_STACK = 100;

	/**
	 * Cache used to store methods.
	 */
	private static WeakHashMap<Class<?>, Map<String, Method>> methodCache = new WeakHashMap<Class<?>, Map<String, Method>>();

	private String name;

	private String context;

	private List<String> parameters = new ArrayList<String>();

	private Bytecode[] bytecodes;

	private int nbBytecodes;

	private int nbNestedIterates;

	private List<LineNumberEntry> lineNumberTable = new ArrayList<LineNumberEntry>();

	private List<LocalVariableEntry> localVariableTable = new ArrayList<LocalVariableEntry>();

	/**
	 * ASMOperation constructor.
	 * 
	 * @param name
	 *            operation name
	 */
	public ASMOperation(String name) {
		super(1); // maxLocals will be computed later in setBytecodes()
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.Operation#getMaxLocals()
	 */
	@Override
	public int getMaxLocals() {
		return maxLocals;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getContext() {
		return context;
	}

	/**
	 * Adds a parameter.
	 * 
	 * @param parameterName
	 *            the parameter name
	 * @param type
	 *            the parameter type
	 */
	public void addParameter(String parameterName, String type) {
		parameters.add(parameterName);
	}

	/**
	 * Adds a line number entry.
	 * 
	 * @param id
	 *            the parameter id
	 * @param begin
	 *            the begin index
	 * @param end
	 *            the end index
	 */
	public void addLineNumberEntry(String id, int begin, int end) {
		lineNumberTable.add(new LineNumberEntry(id, begin, end));
	}

	public List<LineNumberEntry> getLineNumberTable() {
		return lineNumberTable;
	}

	/**
	 * Returns the line at the specified number.
	 * 
	 * @param l
	 *            the line number
	 * @return the line at the specified number
	 */
	public String resolveLineNumber(int l) {
		String ret = null;

		for (Iterator<LineNumberEntry> i = lineNumberTable.iterator(); i.hasNext() && (ret == null);) {
			LineNumberEntry lne = i.next();
			if ((l >= lne.begin) && (l <= lne.end)) {
				ret = lne.id;
			}
		}

		return ret;
	}

	/**
	 * Stores a line number.
	 */
	private final class LineNumberEntry {

		private String id; /* startLine:startColumn-endLine:endColumn */

		private int begin;

		private int end;

		private LineNumberEntry(String id, int begin, int end) {
			this.id = id;
			this.begin = begin;
			this.end = end;
		}

	}

	/**
	 * Adds a local variable entry with the given parameters.
	 * 
	 * @param slot
	 *            the slot number
	 * @param variableName
	 *            the variable name
	 * @param begin
	 *            the begin index
	 * @param end
	 *            the end index
	 */
	public void addLocalVariableEntry(int slot, String variableName, int begin, int end) {
		localVariableTable.add(new LocalVariableEntry(slot, variableName, begin, end));
	}

	public List<LocalVariableEntry> getLocalVariableTable() {
		return localVariableTable;
	}

	/**
	 * Resolves a variable name by its slot number and its index.
	 * 
	 * @param slot
	 *            the slot number
	 * @param l
	 *            the variable index
	 * @return the variable name
	 */
	public String resolveVariableName(int slot, int l) {
		String ret = null;

		for (Iterator<LocalVariableEntry> i = localVariableTable.iterator(); i.hasNext() & (ret == null);) {
			LocalVariableEntry lve = i.next();

			if ((slot == lve.slot) && (l >= lve.begin) && (l <= lve.end)) {
				ret = lve.name;
			}
		}

		return ret;
	}

	/**
	 * Stores a local variable.
	 */
	private final class LocalVariableEntry {

		private int slot;

		private String name;

		private int begin;

		private int end;

		private LocalVariableEntry(int slot, String name, int begin, int end) {
			this.slot = slot;
			this.name = name;
			this.begin = begin;
			this.end = end;
		}
	}

	/**
	 * Sets the bytecodes for the operation.
	 * 
	 * @param bytecodes
	 *            the bytecodes to set
	 */
	public void setBytecodes(Bytecode[] bytecodes) {
		this.bytecodes = bytecodes;
		this.nbBytecodes = bytecodes.length;

		// There are at least as many local variables (excluding self) as parameters.
		// This statement is necessary because the last parameters may be unused.
		maxLocals = parameters.size();

		// pre-computes:
		// - target and nesting levels for iterate and enditerate
		// - maxLocals
		Stack<Object> stack = new Stack<Object>();
		for (int i = 0; i < nbBytecodes; i++) {
			Bytecode bytecode = bytecodes[i];
			if (bytecode.getOpcode() == Bytecode.ITERATE) {
				bytecode.setValue2(stack.size());
				stack.push(new Integer(i));
				if (bytecode.getValue2() > nbNestedIterates) {
					nbNestedIterates = bytecode.getValue2();
				}
			} else if (bytecode.getOpcode() == Bytecode.ENDITERATE) {
				int iterateIndex = ((Integer)stack.pop()).intValue();
				bytecode.setValue(iterateIndex + 1);
				bytecode.setValue2(stack.size());
				bytecodes[iterateIndex].setValue(i + 1);
			} else if ((bytecode.getOpcode() == Bytecode.LOAD) || (bytecode.getOpcode() == Bytecode.STORE)) {
				// With the new model-based ASM the variables are explicit even without debug information.
				// Therefore, we could use that information instead of analyzing loads and stores.
				if (bytecode.getValue() > maxLocals) {
					maxLocals = bytecode.getValue();
				}
			}
		}
		maxLocals++; // because the highest encountered index is maxLocals - 1
		nbNestedIterates++; // because the highest encountered nesting level is nbNestedIterates - 1
	}

	/**
	 * Returns the bytecodes.
	 * 
	 * @return The bytecodes, if any
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public Bytecode[] getBytecodes() {
		return bytecodes;
	}

	public String getName() {
		return name;
	}

	/**
	 * Executes an operation.
	 * 
	 * @param frame
	 *            the frame for execution
	 * @param monitor
	 *            the progress monitor
	 * @return the result
	 */
	public Object exec(AbstractStackFrame frame, IProgressMonitor monitor) {
		if (monitor != null) {
			if (monitor.isCanceled()) {
				throw new VMException(null, Messages.getString("ASMOperation.EXECUTION_CANCELED")); //$NON-NLS-1$
			}
		}
		final ExecEnv execEnv = frame.getExecEnv();

		// Note: debug is not initialized from a constant, and therefore has a performance impact
		// TODO: measure this impact, and possibly remove the debug code
		final boolean debug = execEnv.isStep();

		final Object[] localVars = frame.getLocalVars();
		int pc = 0;
		int fp = 0;
		final Object[] stack = new Object[MAX_STACK];
		final Iterator<?>[] nestedIterate = new Iterator[nbNestedIterates];
		Iterator<?> it;
		Object s;
		StringBuffer log = new StringBuffer();
		try {
			while (pc < nbBytecodes) {
				Bytecode bytecode = bytecodes[pc++];
				execEnv.incNbExecutedBytecodes();
				if (debug) {
					ATLLogger.info(name + ":" + (pc - 1) + "\t" + bytecode); //$NON-NLS-1$ //$NON-NLS-2$
				}
				switch (bytecode.getOpcode()) {
					case Bytecode.PUSHD:
					case Bytecode.PUSHI:
					case Bytecode.PUSH:
						stack[fp++] = bytecode.getOperand();
						break;
					case Bytecode.PUSHT:
						stack[fp++] = Boolean.TRUE;
						break;
					case Bytecode.PUSHF:
						stack[fp++] = Boolean.FALSE;
						break;
					case Bytecode.CALL:
						Object self = stack[fp - bytecode.getValue() - 1];
						if (debug) {
							log.append("\tCalling "); //$NON-NLS-1$
							log.append(frame.getExecEnv().toPrettyPrintedString(self));
							log.append("."); //$NON-NLS-1$
							log.append(bytecode.getOperand());
							log.append("("); //$NON-NLS-1$
						}
						Object type = execEnv.getModelAdapter().getType(self);
						int nbCalleeArgs = bytecode.getValue();
						Operation operation = execEnv.getOperation(type, bytecode.getOperand());

						if (operation != null) {
							StackFrame calleeFrame = (StackFrame)frame.newFrame(operation);
							Object[] arguments = calleeFrame.getLocalVars();

							boolean first = true;
							for (int i = nbCalleeArgs; i >= 1; i--) {
								arguments[i] = stack[--fp];
								if (debug) {
									if (!first) {
										log.append(", "); //$NON-NLS-1$
									}
									first = false;
									log.append(execEnv.toPrettyPrintedString(arguments[i]));
								}
							}
							if (debug) {
								log.append(")"); //$NON-NLS-1$
								ATLLogger.info(log.toString());
							}
							--fp; // pop self, that we already retrieved earlier to get the operation
							arguments[0] = self;
							if (operation instanceof ASMOperation) {
								s = ((ASMOperation)operation).exec(calleeFrame, monitor);
							} else {
								s = operation.exec(calleeFrame);
							}
						} else {
							Assert.isTrue(bytecode.getOperand() instanceof String);
							// find native method
							Object[] arguments = new Object[nbCalleeArgs];

							boolean first = true;
							for (int i = nbCalleeArgs - 1; i >= 0; i--) {
								arguments[i] = stack[--fp];
								if (debug) {
									if (!first) {
										log.append(", "); //$NON-NLS-1$
									}
									first = false;
									log.append(execEnv.toPrettyPrintedString(arguments[i]));
								}
							}
							if (debug) {
								log.append(")"); //$NON-NLS-1$
								ATLLogger.info(log.toString());
							}
							--fp; // pop self, that we already retrieved earlier to get the operation

							Method m = findMethod(self.getClass(), (String)bytecode.getOperand(),
									getTypesOf(arguments));
							if (m == null) {
								throw new VMException(
										frame,
										Messages
												.getString(
														"ASMOperation.OPERATIONNOTFOUND", execEnv.toPrettyPrintedString(self), getMethodSignature(bytecode.getOperand().toString(), getTypesOf(arguments)))); //$NON-NLS-1$)
							}
							s = execEnv.getModelAdapter().invoke(m, self, arguments);
						}

						if (s != null) {
							stack[fp++] = s;
						}
						break;
					case Bytecode.LOAD:
						stack[fp++] = localVars[bytecode.getValue()];
						break;
					case Bytecode.STORE:
						localVars[bytecode.getValue()] = stack[--fp];
						break;
					case Bytecode.SET:
						Object value = stack[--fp];
						s = stack[--fp];
						if (s instanceof HasFields) {
							((HasFields)s).set(frame, bytecode.getOperand(), value);
						} else {
							if (value instanceof Collection) {
								Collection<?> c = (Collection<?>)value;
								// TODO collections of collections have to be managed
								boolean temp = true;
								while (temp) {
									temp = c.remove(OclUndefined.SINGLETON);
								}
							} else if (value instanceof OclUndefined) { // other values are *not* wrapped
								value = null;
							}
							execEnv.getModelAdapter().set(frame, s, (String)bytecode.getOperand(), value);
						}
						break;
					case Bytecode.GET:
						s = stack[--fp];
						type = execEnv.getModelAdapter().getType(s);
						String propName = (String)bytecode.getOperand();
						Operation ai = execEnv.getAttributeInitializer(type, propName);
						if (ai != null) {
							stack[fp++] = execEnv.getHelperValue(frame, type, s, propName);
						} else if (s instanceof HasFields) {
							stack[fp++] = ((HasFields)s).get(frame, propName);
						} else {
							stack[fp++] = execEnv.getModelAdapter().get(frame, s, propName);
						}
						break;
					case Bytecode.DUP:
						s = stack[fp - 1];
						stack[fp++] = s;
						break;
					case Bytecode.DUP_X1: // ..., value2, value1 => ..., value1, value2, value1
						s = stack[fp - 1];
						stack[fp++] = s;
						stack[fp - 2] = stack[fp - 3];
						stack[fp - 3] = stack[fp - 1];
						break;
					case Bytecode.DELETE:
						s = stack[--fp];
						execEnv.getModelAdapter().delete(frame, s);
						break;
					case Bytecode.GETASM:
						stack[fp++] = frame.getAsmModule();
						break;
					case Bytecode.NEW:
						Object mname = stack[--fp];
						Object me = stack[--fp];

						if (mname.equals("#native")) { //$NON-NLS-1$
							// TODO: makes sure the Map implementation is actually faster, then get rid of
							// if-else-if implementation
							/*
							 * if(me.equals("Sequence")) { stack[fp++] = new ArrayList(); } else
							 * if(me.equals("Set")) { stack[fp++] = new HashSet(); } else
							 * if(me.equals("OrderedSet")) { stack[fp++] = new LinkedHashSet(); } else
							 * if(me.equals("Tuple")) { stack[fp++] = new Tuple(); } else
							 * if(me.equals("OclSimpleType")) { stack[fp++] = new OclSimpleType(); } else
							 * if(me.equals("OclParametrizedType")) { stack[fp++] = new OclParametrizedType();
							 * } else if(me.equals("TransientLinkSet")) { stack[fp++] = new
							 * TransientLinkSet(); } else if(me.equals("TransientLink")) { stack[fp++] = new
							 * TransientLink(); } else if(me.equals("Map")) { stack[fp++] = new HashMap(); }
							 * else { throw new VMException(frame, "cannot create " + mname + "!" + me); } /
							 */
							Class<?> c = OclType.getNativeClassfromOclTypeName(me.toString());
							if (c != null) {
								stack[fp++] = c.newInstance();
							} else {
								throw new VMException(frame, Messages.getString(
										"ASMOperation.CANNOTCREATE", new Object[] {mname, me})); //$NON-NLS-1$ 
							}
						} else {
							Object ec = ExecEnv.findMetaElement(frame, mname, me);
							stack[fp++] = execEnv.newElement(frame, ec);
						}
						break;
					case Bytecode.FINDME:
						mname = stack[--fp];
						me = stack[--fp];
						if (mname.equals("#native")) { //$NON-NLS-1$
							Class<?> c = OclType.getNativeClassfromOclTypeName(me.toString());
							if (c != null) {
								stack[fp++] = c;
							} else {
								throw new VMException(frame, Messages.getString(
										"ASMOperation.CANNOTFIND", new Object[] {mname, me})); //$NON-NLS-1$
							}
						} else {
							Object ec = ExecEnv.findMetaElement(frame, mname, me);
							stack[fp++] = ec;
						}
						break;
					case Bytecode.ITERATE:
						Collection<?> c = (Collection<?>)stack[--fp];
						it = c.iterator();
						if (it.hasNext()) {
							nestedIterate[bytecode.getValue2()] = it;
							stack[fp++] = it.next();
						} else {
							pc = bytecode.getValue();
						}

						break;
					case Bytecode.ENDITERATE:
						it = nestedIterate[bytecode.getValue2()];
						if (it.hasNext()) {
							stack[fp++] = it.next();
							pc = bytecode.getValue();
						}
						break;
					case Bytecode.POP:
						fp--;
						break;
					case Bytecode.SWAP:
						s = stack[fp - 1];
						stack[fp - 1] = stack[fp - 2];
						stack[fp - 2] = s;
						break;
					case Bytecode.IF:
						if (Boolean.TRUE.equals(stack[--fp])) {
							pc = bytecode.getValue();
						}
						break;
					case Bytecode.GOTO:
						pc = bytecode.getValue();
						break;
					default:
						throw new VMException(
								frame,
								Messages
										.getString(
												"ASMOperation.UNKNOWNBYTECODE", new Object[] {new Integer(bytecode.getOpcode())})); //$NON-NLS-1$
				}

				if (debug) {
					log = new StringBuffer();
					log.append("\tstack: "); //$NON-NLS-1$
					for (int i = 0; i < fp; i++) {
						if (i > 0) {
							log.append(", "); //$NON-NLS-1$
						}
						log.append(frame.getExecEnv().toPrettyPrintedString(stack[i]));
					}
					ATLLogger.info(log.toString());

					log = new StringBuffer();
					log.append("\tlocals: "); //$NON-NLS-1$
					boolean first = true;
					for (int i = 0; i < localVars.length; i++) {
						String vname = resolveVariableName(i, pc);
						if (vname != null) {
							if (!first) {
								log.append(", "); //$NON-NLS-1$
							}
							first = false;
							log.append(vname + "="); //$NON-NLS-1$
							log.append(frame.getExecEnv().toPrettyPrintedString(localVars[i]));
						}
					}
					ATLLogger.info(log.toString());
				}
			}
		} catch (VMException e) {
			((StackFrame)frame).setPc(pc - 1);
			throw e; // do not rewrap
		} catch (InstantiationException e) {
			((StackFrame)frame).setPc(pc - 1);
			throw new VMException(frame, e.getLocalizedMessage(), e);
		} catch (IllegalAccessException e) {
			((StackFrame)frame).setPc(pc - 1);
			throw new VMException(frame, e.getLocalizedMessage(), e);
		}

		return fp > 0 ? stack[--fp] : null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.Operation#exec(org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame)
	 */
	@Override
	public Object exec(AbstractStackFrame frame) {
		return exec(frame, null);
	}

	private static Class<?>[] getTypesOf(Object[] arguments) {
		final Class<?>[] argumentTypes = new Class[arguments.length];
		for (int i = 0; i < arguments.length; i++) {
			argumentTypes[i] = arguments[i].getClass();
		}
		return argumentTypes;
	}

	/**
	 * Looks for a method into cache and metamodel.
	 * 
	 * @param caller
	 *            The class of the method
	 * @param name
	 *            The method name
	 * @param argumentTypes
	 *            The types of all arguments
	 * @return the method if found, null otherwise
	 */
	protected static Method findMethod(Class<?> caller, String name, Class<?>[] argumentTypes) {
		final String sig = getMethodSignature(name, argumentTypes);
		Method ret = findCachedMethod(caller, sig);
		if (ret != null) {
			return ret;
		}

		Method[] methods = caller.getDeclaredMethods();
		for (int i = 0; i < (methods.length) && (ret == null); i++) {
			Method method = methods[i];
			if (method.getName().equals(name)) {
				Class<?>[] pts = method.getParameterTypes();
				if (pts.length == argumentTypes.length) {
					boolean ok = true;
					for (int j = 0; (j < pts.length) && ok; j++) {
						if (!pts[j].isAssignableFrom(argumentTypes[j])) {
							if (!(pts[j] == boolean.class && argumentTypes[j] == Boolean.class
									|| pts[j] == int.class && argumentTypes[j] == Integer.class
									|| pts[j] == char.class && argumentTypes[j] == Character.class
									|| pts[j] == long.class && argumentTypes[j] == Long.class
									|| pts[j] == float.class && argumentTypes[j] == Float.class || pts[j] == double.class
									&& argumentTypes[j] == Double.class)) {
								ok = false;
							}
						}
					}
					if (ok) {
						ret = method;
					}
				}
			}
		}

		if ((ret == null) && (caller.getSuperclass() != null)) {
			ret = findMethod(caller.getSuperclass(), name, argumentTypes);
		}

		cacheMethod(caller, sig, ret);

		return ret;
	}

	/**
	 * Find a method in the cache.
	 * 
	 * @param caller
	 *            The class of the method
	 * @param signature
	 *            The method signature
	 * @return the method
	 */
	private static Method findCachedMethod(Class<?> caller, String signature) {
		Method ret = null;
		Map<String, Method> sigMap = methodCache.get(caller);
		if (sigMap != null) {
			ret = sigMap.get(signature);
		}
		return ret;
	}

	/**
	 * Stores a method in a cache.
	 * 
	 * @param caller
	 *            The class of the method
	 * @param signature
	 *            The method signature
	 * @param method
	 *            The method to store
	 */
	private static void cacheMethod(Class<?> caller, String signature, Method method) {
		synchronized (methodCache) {
			Map<String, Method> sigMap = methodCache.get(caller);
			if (sigMap == null) {
				sigMap = new HashMap<String, Method>();
				methodCache.put(caller, sigMap);
			}
			sigMap.put(signature, method);
		}
	}

	/**
	 * Generates a String signature to store methods.
	 * 
	 * @param name
	 * @param argumentTypes
	 * @return The method signature
	 */
	private static String getMethodSignature(String name, Class<?>[] argumentTypes) {
		StringBuffer sig = new StringBuffer();
		sig.append(name);
		sig.append('(');
		for (int i = 0; i < argumentTypes.length; i++) {
			if (i > 0) {
				sig.append(',');
			}
			sig.append(argumentTypes[i].getName());
		}
		sig.append(')');
		return sig.toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.context + "." + this.name; //$NON-NLS-1$
	}
}
