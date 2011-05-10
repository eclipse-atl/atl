/*******************************************************************************
 * Copyright (c) 2007, 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *    Obeo - bag, weaving helper implementation    
 *    Dennis Wagelaar (Vrije Universiteit Brussel)
 *
 * $Id: ExecEnv.java,v 1.51 2011/05/10 15:28:17 wpiers Exp $
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm.lib;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.engine.emfvm.Messages;
import org.eclipse.m2m.atl.engine.emfvm.StackFrame;
import org.eclipse.m2m.atl.engine.emfvm.VMException;
import org.eclipse.m2m.atl.engine.emfvm.adapter.IModelAdapter;
import org.eclipse.m2m.atl.engine.emfvm.launch.ITool;

/**
 * Execution environment.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class ExecEnv {

	// TODO analyze:
	// - make static to avoid recomputing the map of nativelib operations for each launch. However, it is much
	// more convenient when not static for development: it is possible to add operations without needing to
	// restart Eclipse
	// - modularize the nativelib (e.g., by splitting into diffent classes, or methods)
	private Map<Object, Map<String, Operation>> vmTypeOperations = new HashMap<Object, Map<String, Operation>>();
	{
		Map<String, Operation> operationsByName;
		// Float
		operationsByName = new HashMap<String, Operation>();
		vmTypeOperations.put(Float.class, operationsByName);
		registerOperation(operationsByName, new Operation(2, "/") { //$NON-NLS-1$
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Float(((Number)localVars[0]).floatValue()
								/ ((Number)localVars[1]).floatValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, "*") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Float(((Number)localVars[0]).floatValue()
								* ((Number)localVars[1]).floatValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, "-") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Float(((Number)localVars[0]).floatValue()
								- ((Number)localVars[1]).floatValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, "+") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Float(((Number)localVars[0]).floatValue()
								+ ((Number)localVars[1]).floatValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, "<") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((Number)localVars[0]).floatValue() < ((Number)localVars[1])
								.floatValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, "<=") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((Number)localVars[0]).floatValue() <= ((Number)localVars[1])
								.floatValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, ">") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((Number)localVars[0]).floatValue() > ((Number)localVars[1])
								.floatValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, ">=") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((Number)localVars[0]).floatValue() >= ((Number)localVars[1])
								.floatValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, "=") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((Number)localVars[0]).floatValue() == ((Number)localVars[1])
								.floatValue());
					}
				});
		registerOperation(operationsByName, new Operation(1, "toString") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return localVars[0].toString();
					}
				});
		registerOperation(operationsByName, new Operation(1, "abs") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Float(Math.abs(((Number)localVars[0]).floatValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "round") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Integer.valueOf((int)Math.round(((Number)localVars[0]).floatValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "floor") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Integer.valueOf((int)Math.floor(((Number)localVars[0]).floatValue()));
					}
				});
		registerOperation(operationsByName, new Operation(2, "max") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Float(Math.max(((Number)localVars[0]).floatValue(),
								((Number)localVars[1]).floatValue()));
					}
				});
		registerOperation(operationsByName, new Operation(2, "min") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Float(Math.min(((Number)localVars[0]).floatValue(),
								((Number)localVars[1]).floatValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "acos") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Float(Math.acos(((Number)localVars[0]).floatValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "asin") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Float(Math.asin(((Number)localVars[0]).floatValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "atan") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Float(Math.atan(((Number)localVars[0]).floatValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "cos") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Float(Math.cos(((Number)localVars[0]).floatValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "sin") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Float(Math.sin(((Number)localVars[0]).floatValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "tan") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Float(Math.tan(((Number)localVars[0]).floatValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "toDegrees") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Float(Math.toDegrees(((Number)localVars[0]).floatValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "toRadians") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Float(Math.toRadians(((Number)localVars[0]).floatValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "exp") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Float(Math.exp(((Number)localVars[0]).floatValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "log") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Float(Math.log(((Number)localVars[0]).floatValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "sqrt") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Float(Math.sqrt(((Number)localVars[0]).floatValue()));
					}
				});
		// Real
		operationsByName = new HashMap<String, Operation>();
		vmTypeOperations.put(Double.class, operationsByName);
		registerOperation(operationsByName, new Operation(2, "/") { //$NON-NLS-1$
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Double(((Number)localVars[0]).doubleValue()
								/ ((Number)localVars[1]).doubleValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, "*") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Double(((Number)localVars[0]).doubleValue()
								* ((Number)localVars[1]).doubleValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, "-") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Double(((Number)localVars[0]).doubleValue()
								- ((Number)localVars[1]).doubleValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, "+") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Double(((Number)localVars[0]).doubleValue()
								+ ((Number)localVars[1]).doubleValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, "<") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((Number)localVars[0]).doubleValue() < ((Number)localVars[1])
								.doubleValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, "<=") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((Number)localVars[0]).doubleValue() <= ((Number)localVars[1])
								.doubleValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, ">") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((Number)localVars[0]).doubleValue() > ((Number)localVars[1])
								.doubleValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, ">=") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((Number)localVars[0]).doubleValue() >= ((Number)localVars[1])
								.doubleValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, "=") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((Number)localVars[0]).doubleValue() == ((Number)localVars[1])
								.doubleValue());
					}
				});
		registerOperation(operationsByName, new Operation(1, "toString") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return localVars[0].toString();
					}
				});
		registerOperation(operationsByName, new Operation(1, "abs") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Double(Math.abs(((Number)localVars[0]).doubleValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "round") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Integer.valueOf((int)Math.round(((Number)localVars[0]).doubleValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "floor") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Integer.valueOf((int)Math.floor(((Number)localVars[0]).doubleValue()));
					}
				});
		registerOperation(operationsByName, new Operation(2, "max") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Double(Math.max(((Number)localVars[0]).doubleValue(),
								((Number)localVars[1]).doubleValue()));
					}
				});
		registerOperation(operationsByName, new Operation(2, "min") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Double(Math.min(((Number)localVars[0]).doubleValue(),
								((Number)localVars[1]).doubleValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "acos") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Double(Math.acos(((Number)localVars[0]).doubleValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "asin") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Double(Math.asin(((Number)localVars[0]).doubleValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "atan") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Double(Math.atan(((Number)localVars[0]).doubleValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "cos") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Double(Math.cos(((Number)localVars[0]).doubleValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "sin") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Double(Math.sin(((Number)localVars[0]).doubleValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "tan") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Double(Math.tan(((Number)localVars[0]).doubleValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "toDegrees") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Double(Math.toDegrees(((Number)localVars[0]).doubleValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "toRadians") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Double(Math.toRadians(((Number)localVars[0]).doubleValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "exp") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Double(Math.exp(((Number)localVars[0]).doubleValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "log") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Double(Math.log(((Number)localVars[0]).doubleValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "sqrt") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Double(Math.sqrt(((Number)localVars[0]).doubleValue()));
					}
				});
		// Integer
		operationsByName = new HashMap<String, Operation>();
		vmTypeOperations.put(Integer.class, operationsByName);
		registerOperation(operationsByName, new Operation(2, "*") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						if (localVars[1] instanceof Integer) {
							return Integer.valueOf(((Integer)localVars[0]).intValue()
									* ((Integer)localVars[1]).intValue());
						} else {
							return new Double(((Number)localVars[0]).doubleValue()
									* ((Number)localVars[1]).doubleValue());
						}
					}
				});
		registerOperation(operationsByName, new Operation(2, "-") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						if (localVars[1] instanceof Integer) {
							return Integer.valueOf(((Integer)localVars[0]).intValue()
									- ((Integer)localVars[1]).intValue());
						} else {
							return new Double(((Number)localVars[0]).doubleValue()
									- ((Number)localVars[1]).doubleValue());
						}
					}
				});
		registerOperation(operationsByName, new Operation(2, "+") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						if (localVars[1] instanceof Integer) {
							return Integer.valueOf(((Integer)localVars[0]).intValue()
									+ ((Integer)localVars[1]).intValue());
						} else {
							return new Double(((Number)localVars[0]).doubleValue()
									+ ((Number)localVars[1]).doubleValue());
						}
					}
				});
		registerOperation(operationsByName, new Operation(2, "div") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Integer.valueOf(((Integer)localVars[0]).intValue()
								/ ((Integer)localVars[1]).intValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, "mod") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Integer.valueOf(((Integer)localVars[0]).intValue()
								% ((Integer)localVars[1]).intValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, "/") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Double(((Integer)localVars[0]).intValue()
								/ ((Number)localVars[1]).doubleValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, "<") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						if (localVars[1] instanceof Integer) {
							return Boolean.valueOf(((Integer)localVars[0]).intValue() < ((Integer)localVars[1])
									.intValue());
						} else {
							return Boolean.valueOf(((Number)localVars[0]).doubleValue() < ((Number)localVars[1])
									.doubleValue());
						}
					}
				});
		registerOperation(operationsByName, new Operation(2, "<=") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						if (localVars[1] instanceof Integer) {
							return Boolean.valueOf(((Integer)localVars[0]).intValue() <= ((Integer)localVars[1])
									.intValue());
						} else {
							return Boolean.valueOf(((Number)localVars[0]).doubleValue() <= ((Number)localVars[1])
									.doubleValue());
						}
					}
				});
		registerOperation(operationsByName, new Operation(2, ">") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						if (localVars[1] instanceof Integer) {
							return Boolean.valueOf(((Integer)localVars[0]).intValue() > ((Integer)localVars[1])
									.intValue());
						} else {
							return Boolean.valueOf(((Number)localVars[0]).doubleValue() > ((Number)localVars[1])
									.doubleValue());
						}
					}
				});
		registerOperation(operationsByName, new Operation(2, ">=") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						if (localVars[1] instanceof Integer) {
							return Boolean.valueOf(((Integer)localVars[0]).intValue() >= ((Integer)localVars[1])
									.intValue());
						} else {
							return Boolean.valueOf(((Number)localVars[0]).doubleValue() >= ((Number)localVars[1])
									.doubleValue());
						}
					}
				});
		registerOperation(operationsByName, new Operation(2, "=") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						if (localVars[1] instanceof Integer) {
							return Boolean.valueOf(((Integer)localVars[0]).intValue() == ((Integer)localVars[1])
									.intValue());
						} else {
							return Boolean.valueOf(((Number)localVars[0]).doubleValue() == ((Number)localVars[1])
									.doubleValue());
						}
					}
				});
		registerOperation(operationsByName, new Operation(2, "max") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						// TODO check Integer return
						return Integer.valueOf(Math.max(((Integer)localVars[0]).intValue(),
								((Number)localVars[1]).intValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "abs") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						// TODO check Integer return
						return Integer.valueOf(Math.abs(((Integer)localVars[0]).intValue()));
					}
				});
		registerOperation(operationsByName, new Operation(2, "min") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						// TODO check Integer return
						return Integer.valueOf(Math.min(((Integer)localVars[0]).intValue(),
								((Number)localVars[1]).intValue()));
					}
				});
		registerOperation(operationsByName, new Operation(1, "toString") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return localVars[0].toString();
					}
				});
		registerOperation(operationsByName, new Operation(1, "toHexString") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Integer.toHexString(((Integer)localVars[0]).intValue());
					}
				});
		registerOperation(operationsByName, new Operation(1, "toBinaryString") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Integer.toBinaryString(((Integer)localVars[0]).intValue());
					}
				});
		// Boolean
		operationsByName = new HashMap<String, Operation>();
		vmTypeOperations.put(Boolean.class, operationsByName);
		registerOperation(operationsByName, new Operation(1, "not") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(!((Boolean)localVars[0]).booleanValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, "and") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((Boolean)localVars[0]).booleanValue()
								&& ((Boolean)localVars[1]).booleanValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, "or") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((Boolean)localVars[0]).booleanValue()
								|| ((Boolean)localVars[1]).booleanValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, "xor") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((Boolean)localVars[0]).booleanValue()
								^ ((Boolean)localVars[1]).booleanValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, "implies") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((Boolean)localVars[0]).booleanValue() ? ((Boolean)localVars[1])
								.booleanValue() : true);
					}
				});
		// Sequence
		operationsByName = new HashMap<String, Operation>();
		vmTypeOperations.put(ArrayList.class, operationsByName);
		registerOperation(operationsByName, new Operation(3, "insertAt") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						int index = ((Integer)localVars[1]).intValue();
						List<Object> ret = new ArrayList<Object>((Collection<?>)localVars[0]);
						ret.add(index - 1, localVars[2]);
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(2, "at") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						int index = ((Integer)localVars[1]).intValue();
						return ((List<?>)localVars[0]).get(index - 1);
					}
				});
		registerOperation(operationsByName, new Operation(3, "subSequence") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						int start = ((Integer)localVars[1]).intValue();
						int end = ((Integer)localVars[2]).intValue();
						if (end >= start) {
							return new ArrayList<Object>(((List<?>)localVars[0]).subList(start - 1, end));
						} else {
							return Collections.EMPTY_LIST;
						}
					}
				});
		registerOperation(operationsByName, new Operation(2, "indexOf") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Integer.valueOf(((List<?>)localVars[0]).indexOf(localVars[1]) + 1);
					}
				});
		registerOperation(operationsByName, new Operation(2, "prepend") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						List<Object> ret = new ArrayList<Object>((Collection<?>)localVars[0]);
						ret.add(0, localVars[1]);
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(2, "including") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						List<Object> ret = new ArrayList<Object>((Collection<?>)localVars[0]);
						ret.add(localVars[1]);
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(2, "excluding") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						List<Object> ret = new ArrayList<Object>((Collection<?>)localVars[0]);
						ret.removeAll(Arrays.asList(new Object[] {localVars[1]}));
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(2, "append") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						List<Object> ret = new ArrayList<Object>((Collection<?>)localVars[0]);
						ret.add(localVars[1]);
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(2, "union") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						List<Object> ret = new ArrayList<Object>((Collection<?>)localVars[0]);
						ret.addAll((Collection<?>)localVars[1]);
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(1, "asSequence") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return localVars[0];
					}
				});
		registerOperation(operationsByName, new Operation(1, "first") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						List<?> l = (List<?>)localVars[0];
						if (l.isEmpty()) {
							return OclUndefined.SINGLETON;
						} else {
							return l.get(0);
						}
					}
				});
		registerOperation(operationsByName, new Operation(1, "last") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						List<?> l = (List<?>)localVars[0];
						if (l.isEmpty()) {
							return OclUndefined.SINGLETON;
						} else {
							return l.get(l.size() - 1);
						}
					}
				});
		registerOperation(operationsByName, new Operation(1, "flatten") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						List<Object> base = null;
						List<Object> ret = new ArrayList<Object>((Collection<?>)localVars[0]);
						boolean containsCollection;
						do {
							base = ret;
							ret = new ArrayList<Object>();
							containsCollection = false;
							for (Iterator<Object> iterator = base.iterator(); iterator.hasNext();) {
								Object object = iterator.next();
								if (object instanceof Collection<?>) {
									Collection<?> subCollection = (Collection<?>)object;
									ret.addAll(subCollection);
									Iterator<?> iterator2 = subCollection.iterator();
									while (!containsCollection && iterator2.hasNext()) {
										Object subCollectionObject = iterator2.next();
										if (subCollectionObject instanceof Collection<?>) {
											containsCollection = true;
										}
									}
								} else {
									ret.add(object);
								}
							}
						} while (containsCollection);
						return ret;
					}
				});
		// Bag
		operationsByName = new HashMap<String, Operation>();
		vmTypeOperations.put(Bag.class, operationsByName);
		registerOperation(operationsByName, new Operation(2, "including") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						Bag ret = new Bag((Collection<?>)localVars[0]);
						ret.add(localVars[1]);
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(2, "excluding") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						Bag ret = new Bag((Collection<?>)localVars[0]);
						ret.removeAll(Arrays.asList(new Object[] {localVars[1]}));
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(1, "asBag") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return localVars[0];
					}
				});
		registerOperation(operationsByName, new Operation(1, "flatten") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						Bag base = null;
						Bag ret = new Bag((Collection<?>)localVars[0]);
						boolean containsCollection;
						do {
							base = ret;
							ret = new Bag();
							containsCollection = false;
							for (Iterator<Object> iterator = base.iterator(); iterator.hasNext();) {
								Object object = iterator.next();
								if (object instanceof Collection<?>) {
									Collection<?> subCollection = (Collection<?>)object;
									ret.addAll(subCollection);
									Iterator<?> iterator2 = subCollection.iterator();
									while (!containsCollection && iterator2.hasNext()) {
										Object subCollectionObject = iterator2.next();
										if (subCollectionObject instanceof Collection<?>) {
											containsCollection = true;
										}
									}
								} else {
									ret.add(object);
								}
							}
						} while (containsCollection);
						return ret;
					}
				});
		// OrderedSet
		operationsByName = new HashMap<String, Operation>();
		vmTypeOperations.put(LinkedHashSet.class, operationsByName);
		registerOperation(operationsByName, new Operation(3, "insertAt") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						int idx = ((Integer)localVars[1]).intValue() - 1;
						LinkedHashSet<Object> ret = new LinkedHashSet<Object>();
						LinkedHashSet<?> s = (LinkedHashSet<?>)localVars[0];
						int k = 0;
						for (Iterator<?> i = s.iterator(); i.hasNext();) {
							if (k++ == idx) {
								ret.add(localVars[2]);
							}
							ret.add(i.next());
						}
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(2, "prepend") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						int idx = 0;
						LinkedHashSet<Object> ret = new LinkedHashSet<Object>();
						LinkedHashSet<?> s = (LinkedHashSet<?>)localVars[0];
						int k = 0;
						for (Iterator<?> i = s.iterator(); i.hasNext();) {
							if (k++ == idx) {
								ret.add(localVars[1]);
							}
							ret.add(i.next());
						}
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(2, "indexOf") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						LinkedHashSet<?> s = (LinkedHashSet<?>)localVars[0];
						int idx = 0;
						for (Iterator<?> iterator = s.iterator(); iterator.hasNext();) {
							idx++;
							if (iterator.next().equals(localVars[1])) {
								return idx;
							}
						}
						return 0;
					}
				});
		registerOperation(operationsByName, new Operation(3, "subOrderedSet") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						LinkedHashSet<Object> ret = new LinkedHashSet<Object>();
						LinkedHashSet<?> s = (LinkedHashSet<?>)localVars[0];
						int deb = ((Integer)localVars[1]).intValue();
						int end = ((Integer)localVars[2]).intValue();
						int idx = 0;
						for (Iterator<?> iterator = s.iterator(); iterator.hasNext();) {
							idx++;
							Object tmp = iterator.next();
							if (deb <= idx && idx <= end) {
								ret.add(tmp);
							}
						}
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(2, "including") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						LinkedHashSet<Object> ret = new LinkedHashSet<Object>((Collection<?>)localVars[0]);
						ret.add(localVars[1]);
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(2, "excluding") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						LinkedHashSet<Object> ret = new LinkedHashSet<Object>((Collection<?>)localVars[0]);
						ret.removeAll(Arrays.asList(new Object[] {localVars[1]}));
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(2, "append") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						LinkedHashSet<Object> ret = new LinkedHashSet<Object>((Collection<?>)localVars[0]);
						ret.add(localVars[1]);
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(1, "asOrderedSet") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return localVars[0];
					}
				});
		registerOperation(operationsByName, new Operation(1, "first") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return ((LinkedHashSet<?>)localVars[0]).iterator().next();
					}
				});
		registerOperation(operationsByName, new Operation(1, "last") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						LinkedHashSet<?> l = (LinkedHashSet<?>)localVars[0];
						Object ret = OclUndefined.SINGLETON;
						for (Iterator<?> i = l.iterator(); i.hasNext();) {
							ret = i.next();
						}
						return ret;
					}
				});
		// optimized version
		registerOperation(operationsByName, new Operation(2, "count") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						Object o = localVars[1];
						return ((HashSet<?>)localVars[0]).contains(o) ? Integer.valueOf(1) : Integer
								.valueOf(0);
					}
				});
		registerOperation(operationsByName, new Operation(2, "union") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						Set<Object> ret = new LinkedHashSet<Object>((Collection<?>)localVars[0]);
						ret.addAll((Collection<?>)localVars[1]);
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(1, "flatten") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						Set<Object> base = null;
						Set<Object> ret = new LinkedHashSet<Object>((Collection<?>)localVars[0]);
						boolean containsCollection;
						do {
							base = ret;
							ret = new LinkedHashSet<Object>();
							containsCollection = false;
							for (Iterator<Object> iterator = base.iterator(); iterator.hasNext();) {
								Object object = iterator.next();
								if (object instanceof Collection<?>) {
									Collection<?> subCollection = (Collection<?>)object;
									ret.addAll(subCollection);
									Iterator<?> iterator2 = subCollection.iterator();
									while (!containsCollection && iterator2.hasNext()) {
										Object subCollectionObject = iterator2.next();
										if (subCollectionObject instanceof Collection<?>) {
											containsCollection = true;
										}
									}
								} else {
									ret.add(object);
								}
							}
						} while (containsCollection);
						return ret;
					}
				});
		// Set
		operationsByName = new HashMap<String, Operation>();
		vmTypeOperations.put(HashSet.class, operationsByName);
		registerOperation(operationsByName, new Operation(2, "including") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						Set<Object> ret = new HashSet<Object>((Collection<?>)localVars[0]);
						ret.add(localVars[1]);
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(2, "excluding") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						Set<Object> ret = new HashSet<Object>((Collection<?>)localVars[0]);
						ret.removeAll(Arrays.asList(new Object[] {localVars[1]}));
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(2, "intersection") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						Set<Object> ret = new HashSet<Object>((Collection<?>)localVars[0]);
						ret.retainAll((Collection<?>)localVars[1]);
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(2, "-") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						Set<Object> ret = new HashSet<Object>((Collection<?>)localVars[0]);
						ret.removeAll((Collection<?>)localVars[1]);
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(2, "symetricDifference") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						Set<Object> ret = new HashSet<Object>((Collection<?>)localVars[0]);
						Set<Object> t = new HashSet<Object>((Collection<?>)localVars[1]);
						t.removeAll(ret);
						ret.removeAll((Collection<?>)localVars[1]);
						ret.addAll(t);
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(1, "asSet") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return localVars[0];
					}
				});
		registerOperation(operationsByName, new Operation(1, "flatten") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						Set<Object> base = null;
						Set<Object> ret = new HashSet<Object>((Collection<?>)localVars[0]);
						boolean containsCollection;
						do {
							base = ret;
							ret = new HashSet<Object>();
							containsCollection = false;
							for (Iterator<Object> iterator = base.iterator(); iterator.hasNext();) {
								Object object = iterator.next();
								if (object instanceof Collection<?>) {
									Collection<?> subCollection = (Collection<?>)object;
									ret.addAll(subCollection);
									Iterator<?> iterator2 = subCollection.iterator();
									while (!containsCollection && iterator2.hasNext()) {
										Object subCollectionObject = iterator2.next();
										if (subCollectionObject instanceof Collection<?>) {
											containsCollection = true;
										}
									}
								} else {
									ret.add(object);
								}
							}
						} while (containsCollection);
						return ret;
					}
				});
		// optimized version
		registerOperation(operationsByName, new Operation(2, "count") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						Object o = localVars[1];
						return ((HashSet<?>)localVars[0]).contains(o) ? Integer.valueOf(1) : Integer
								.valueOf(0);
					}
				});
		registerOperation(operationsByName, new Operation(2, "union") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						Set<Object> ret = new HashSet<Object>((Collection<?>)localVars[0]);
						ret.addAll((Collection<?>)localVars[1]);
						return ret;
					}
				});
		// Collection
		operationsByName = new HashMap<String, Operation>();
		vmTypeOperations.put(Collection.class, operationsByName);
		registerOperation(operationsByName, new Operation(1, "size") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Integer.valueOf(((Collection<?>)localVars[0]).size());
					}
				});
		registerOperation(operationsByName, new Operation(1, "sum") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						Collection<?> c = (Collection<?>)localVars[0];
						if (c.isEmpty()) {
							return OclUndefined.SINGLETON;
						} else {
							Iterator<?> i = c.iterator();
							Object ret = i.next();
							Operation operation = getOperation(modelAdapter.getType(ret), "+"); //$NON-NLS-1$
							if (operation == null) {
								throw new VMException(
										frame,
										Messages.getString(
												"ExecEnv.CANNOTFINDOPERATION", toPrettyPrintedString(modelAdapter.getType(ret)), "+")); //$NON-NLS-1$ //$NON-NLS-2$
							}
							while (i.hasNext()) {
								AbstractStackFrame callee = frame.newFrame(operation);
								callee.localVars[0] = ret;
								callee.localVars[1] = i.next();
								ret = operation.exec(callee.enter());
								callee.leave();
							}
							return ret;
						}
					}
				});
		registerOperation(operationsByName, new Operation(2, "includes") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((Collection<?>)localVars[0]).contains(localVars[1]));
					}
				});
		registerOperation(operationsByName, new Operation(2, "excludes") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(!((Collection<?>)localVars[0]).contains(localVars[1]));
					}
				});
		registerOperation(operationsByName, new Operation(2, "count") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						int ret = 0;
						Object o = localVars[1];
						for (Iterator<?> i = ((Collection<?>)localVars[0]).iterator(); i.hasNext();) {
							if (i.next().equals(o)) {
								ret++;
							}
						}
						return Integer.valueOf(ret);
					}
				});
		registerOperation(operationsByName, new Operation(2, "includesAll") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((Collection<?>)localVars[0])
								.containsAll((Collection<?>)localVars[1]));
					}
				});
		registerOperation(operationsByName, new Operation(2, "excludesAll") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						boolean ret = true;
						Collection<?> s = (Collection<?>)localVars[0];
						for (Iterator<?> i = ((Collection<?>)localVars[1]).iterator(); i.hasNext();) {
							ret = ret && !s.contains(i.next());
						}
						return Boolean.valueOf(ret);
					}
				});
		registerOperation(operationsByName, new Operation(1, "isEmpty") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((Collection<?>)localVars[0]).isEmpty());
					}
				});
		registerOperation(operationsByName, new Operation(1, "notEmpty") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(!((Collection<?>)localVars[0]).isEmpty());
					}
				});
		registerOperation(operationsByName, new Operation(1, "asSequence") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new ArrayList<Object>((Collection<?>)localVars[0]);
					}
				});
		registerOperation(operationsByName, new Operation(1, "asSet") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						Set<Object> ret = new HashSet<Object>((Collection<?>)localVars[0]);
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(1, "asBag") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Bag((Collection<?>)localVars[0]);
					}
				});
		registerOperation(operationsByName, new Operation(1, "asOrderedSet") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new LinkedHashSet<Object>((Collection<?>)localVars[0]);
					}
				});
		// String
		operationsByName = new HashMap<String, Operation>();
		vmTypeOperations.put(String.class, operationsByName);
		registerOperation(operationsByName, new Operation(1, "size") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Integer.valueOf(((String)localVars[0]).length());
					}
				});
		registerOperation(operationsByName, new Operation(1, "toString") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return localVars[0];
					}
				});
		registerOperation(operationsByName, new Operation(3, "regexReplaceAll") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return ((String)localVars[0]).replaceAll((String)localVars[1], (String)localVars[2]);
					}
				});
		registerOperation(operationsByName, new Operation(3, "replaceAll") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return ((String)localVars[0]).replace(((String)localVars[1]).charAt(0),
								((String)localVars[2]).charAt(0));
					}
				});
		registerOperation(operationsByName, new Operation(2, "split") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new ArrayList<String>(Arrays.asList(((String)localVars[0])
								.split((String)localVars[1])));
					}
				});
		registerOperation(operationsByName, new Operation(1, "toInteger") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Integer.valueOf((String)localVars[0]);
					}
				});
		registerOperation(operationsByName, new Operation(1, "toReal") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Double.valueOf((String)localVars[0]);
					}
				});
		registerOperation(operationsByName, new Operation(1, "toUpper") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return ((String)localVars[0]).toUpperCase();
					}
				});
		registerOperation(operationsByName, new Operation(1, "toLower") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return ((String)localVars[0]).toLowerCase();
					}
				});
		registerOperation(operationsByName, new Operation(1, "toSequence") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						String tmp = (String)localVars[0];
						List<Object> ret = new ArrayList<Object>();
						for (int i = 0; i < tmp.length(); i++) {
							ret.add("" + tmp.charAt(i)); //$NON-NLS-1$
						}
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(2, "startsWith") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((String)localVars[0]).startsWith((String)localVars[1]));
					}
				});
		registerOperation(operationsByName, new Operation(3, "substring") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return ((String)localVars[0]).substring(((Number)localVars[1]).intValue() - 1,
								((Number)localVars[2]).intValue());
					}
				});
		registerOperation(operationsByName, new Operation(2, "indexOf") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Integer.valueOf(((String)localVars[0]).indexOf((String)localVars[1]));
					}
				});
		registerOperation(operationsByName, new Operation(2, "lastIndexOf") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Integer.valueOf(((String)localVars[0]).lastIndexOf((String)localVars[1]));
					}
				});
		registerOperation(operationsByName, new Operation(2, "endsWith") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((String)localVars[0]).endsWith((String)localVars[1]));
					}
				});
		registerOperation(operationsByName, new Operation(2, "+") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return (String)localVars[0] + localVars[1];
					}
				});
		registerOperation(operationsByName, new Operation(2, "concat") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return (String)localVars[0] + localVars[1];
					}
				});
		registerOperation(operationsByName, new Operation(2, "<") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((String)localVars[0]).compareTo((String)localVars[1]) < 0);
					}
				});
		registerOperation(operationsByName, new Operation(2, "<=") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((String)localVars[0]).compareTo((String)localVars[1]) <= 0);
					}
				});
		registerOperation(operationsByName, new Operation(2, ">") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((String)localVars[0]).compareTo((String)localVars[1]) > 0);
					}
				});
		registerOperation(operationsByName, new Operation(2, ">=") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((String)localVars[0]).compareTo((String)localVars[1]) >= 0);
					}
				});
		registerOperation(operationsByName, new Operation(2, "=") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((String)localVars[0]).equals(localVars[1]));
					}
				});
		registerOperation(operationsByName, new Operation(1, "println") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						ATLLogger.info(localVars[0].toString());
						return null;
					}
				});
		registerOperation(operationsByName, new Operation(2, "writeTo") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(writeToWithCharset(frame, (String)localVars[0],
								(String)localVars[1], null));
					}
				});
		registerOperation(operationsByName, new Operation(3, "writeToWithCharset") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(writeToWithCharset(frame, (String)localVars[0],
								(String)localVars[1], (String)localVars[2]));
					}
				});
		// Tuple
		operationsByName = new HashMap<String, Operation>();
		vmTypeOperations.put(Tuple.class, operationsByName);
		registerOperation(operationsByName, new Operation(2, "=") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((Tuple)localVars[0]).equals(localVars[1]));
					}
				});
		registerOperation(operationsByName, new Operation(1, "asMap") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return ((Tuple)localVars[0]).getMap();
					}
				});
		// EnumLiteral
		operationsByName = new HashMap<String, Operation>();
		vmTypeOperations.put(EnumLiteral.class, operationsByName);
		registerOperation(operationsByName, new Operation(1, "toString") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return ((EnumLiteral)localVars[0]).toString();
					}
				});
		// OclAny
		operationsByName = new HashMap<String, Operation>();
		vmTypeOperations.put(Object.class, operationsByName);
		registerOperation(operationsByName, new Operation(1, "toString") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return toPrettyPrintedString(localVars[0]);
					}
				});
		registerOperation(operationsByName, new Operation(2, "=") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(localVars[0].equals(localVars[1]));
					}
				});
		registerOperation(operationsByName, new Operation(2, "<>") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(!localVars[0].equals(localVars[1]));
					}
				});
		registerOperation(operationsByName, new Operation(1, "oclIsUndefined") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						return Boolean.FALSE;
					}
				});
		// TODO implement missing output
		// TODO add to doc
		registerOperation(operationsByName, new Operation(2, "debug") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						if (localVars[1] != null && !"".equals(localVars[1])) { //$NON-NLS-1$
							ATLLogger.info(localVars[1] + ": " + toPrettyPrintedString(localVars[0])); //$NON-NLS-1$	
						} else {
							ATLLogger.info(toPrettyPrintedString(localVars[0]));
						}
						return localVars[0];
					}
				});
		registerOperation(operationsByName, new Operation(3, "registerWeavingHelper") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						String name = (String)localVars[1];
						String initOperationName = (String)localVars[2];
						frame.execEnv.registerWeavingHelper(localVars[0], name, initOperationName);
						return null;
					}
				});
		// OclUndefined
		operationsByName = new HashMap<String, Operation>();
		vmTypeOperations.put(OclUndefined.class, operationsByName);
		registerOperation(operationsByName, new Operation(1, "oclIsUndefined") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						return Boolean.TRUE;
					}
				});
		// fix 214871:
		// TODO better to fix it into compiler
		registerOperation(operationsByName, new Operation(3, "getNamedTargetFromSource") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						return OclUndefined.SINGLETON;
					}
				});
		// OclType
		operationsByName = new HashMap<String, Operation>();
		vmTypeOperations.put(OclType.class, operationsByName);
		registerOperation(operationsByName, new Operation(2, "setName") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						((OclType)localVars[0]).setName((String)localVars[1]);
						return null;
					}
				});
		registerOperation(operationsByName, new Operation(2, "conformsTo") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((OclType)localVars[0]).conformsTo((OclType)localVars[1]));
					}
				});

		// OclParametrizedType
		operationsByName = new HashMap<String, Operation>();
		vmTypeOperations.put(OclParametrizedType.class, operationsByName);
		registerOperation(operationsByName, new Operation(2, "setElementType") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						((OclParametrizedType)localVars[0]).setElementType(localVars[1]);
						return null;
					}
				});
		// Class
		operationsByName = new HashMap<String, Operation>();
		vmTypeOperations.put(Class.class, operationsByName);
		registerOperation(operationsByName, new Operation(3, "registerHelperAttribute") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						String name = (String)localVars[1];
						String initOperationName = (String)localVars[2];
						frame.execEnv.registerHelperAttribute(localVars[0], name, initOperationName);
						return null;
					}
				});
		registerOperation(operationsByName, new Operation(2, "conformsTo") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return Boolean.valueOf(((Class<?>)localVars[1])
								.isAssignableFrom((Class<?>)localVars[0]));
					}
				});
		// TransientLink
		operationsByName = new HashMap<String, Operation>();
		vmTypeOperations.put(TransientLink.class, operationsByName);
		registerOperation(operationsByName, new Operation(2, "setRule") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						((TransientLink)localVars[0]).setRule((String)localVars[1]);
						return null;
					}
				});
		registerOperation(operationsByName, new Operation(3, "addSourceElement") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						((TransientLink)localVars[0]).getSourceElements().put(localVars[1], localVars[2]);
						return null;
					}
				});
		registerOperation(operationsByName, new Operation(3, "addTargetElement") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						TransientLink tl = (TransientLink)localVars[0];
						tl.getTargetElements().put(localVars[1], localVars[2]);
						tl.getTargetElementsList().add(localVars[2]);
						return null;
					}
				});
		registerOperation(operationsByName, new Operation(2, "getSourceElement") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return ((TransientLink)localVars[0]).getSourceElements().get(localVars[1]);
					}
				});
		registerOperation(operationsByName, new Operation(2, "getTargetElement") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						Object ret = ((TransientLink)localVars[0]).getTargetElements().get(localVars[1]);
						if (ret == null) {
							ret = OclUndefined.SINGLETON;
						}
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(2, "getTargetFromSource") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						Object ret = ((TransientLink)localVars[0]).getTargetElementsList().iterator().next();
						if (ret == null) {
							ret = OclUndefined.SINGLETON;
						}
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(3, "getNamedTargetFromSource") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						Object ret = ((TransientLink)localVars[0]).getTargetElements().get(localVars[2]);
						if (ret == null) {
							ret = OclUndefined.SINGLETON;
						}
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(3, "addVariable") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						((TransientLink)localVars[0]).getVariables().put(localVars[1], localVars[2]);
						return null;
					}
				});
		registerOperation(operationsByName, new Operation(2, "getVariable") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return ((TransientLink)localVars[0]).getVariables().get(localVars[1]);
					}
				});
		// TransientLinkSet
		operationsByName = new HashMap<String, Operation>();
		vmTypeOperations.put(TransientLinkSet.class, operationsByName);
		registerOperation(operationsByName, new Operation(2, "addLink") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						TransientLink tl = (TransientLink)localVars[1];
						TransientLinkSet tls = (TransientLinkSet)localVars[0];
						tls.addLink(tl);
						return null;
					}
				});
		registerOperation(operationsByName, new Operation(3, "addLink2") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						TransientLink tl = (TransientLink)localVars[1];
						TransientLinkSet tls = (TransientLinkSet)localVars[0];
						boolean isDefault = ((Boolean)localVars[2]).booleanValue();
						tls.addLink2(tl, isDefault);
						return null;
					}
				});
		registerOperation(operationsByName, new Operation(2, "getLinksByRule") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return ((TransientLinkSet)localVars[0]).getLinksByRule(localVars[1]);
					}
				});
		registerOperation(operationsByName, new Operation(2, "getLinkBySourceElement") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						TransientLink ret = ((TransientLinkSet)localVars[0])
								.getLinkBySourceElement(localVars[1]);
						if (ret == null) {
							return OclUndefined.SINGLETON;
						} else {
							return ret;
						}
					}
				});
		operationsByName.put(
				"getLinkByRuleAndSourceElement", new Operation(3, "getLinkByRuleAndSourceElement") { //$NON-NLS-1$ //$NON-NLS-2$
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						TransientLink ret = ((TransientLinkSet)localVars[0]).getLinkByRuleAndSourceElement(
								localVars[1], localVars[2]);
						if (ret == null) {
							return OclUndefined.SINGLETON;
						} else {
							return ret;
						}
					}
				});
		// Map
		operationsByName = new HashMap<String, Operation>();
		vmTypeOperations.put(HashMap.class, operationsByName);
		registerOperation(operationsByName, new Operation(2, "get") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						Object ret = ((Map<?, ?>)localVars[0]).get(localVars[1]);
						if (ret == null) {
							ret = OclUndefined.SINGLETON;
						}
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(3, "including") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						Map<Object, Object> ret = new HashMap<Object, Object>((Map<?, ?>)localVars[0]);
						ret.put(localVars[1], localVars[2]);
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(1, "getKeys") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new HashSet<Object>(((Map<?, ?>)localVars[0]).keySet());
					}
				});
		registerOperation(operationsByName, new Operation(1, "getValues") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						return new Bag(((Map<?, ?>)localVars[0]).values());
					}
				});
		registerOperation(operationsByName, new Operation(2, "union") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.localVars;
						Map<Object, Object> ret = new HashMap<Object, Object>((Map<?, ?>)localVars[0]);
						ret.putAll((Map<?, ?>)localVars[1]);
						return ret;
					}
				});
	}

	private Map<Object, Map<String, Operation>> operationsByType = new HashMap<Object, Map<String, Operation>>();

	/** Stores the number of executed bytecodes. */
	private long nbExecutedBytecodes;

	/** The common model adapter. */
	private IModelAdapter modelAdapter;

	// TODO: map this to corresponding option
	private boolean cacheAttributeHelperResults = true;

	private Map<Object, Map<String, String>> weavingHelperToPersistToByType = new HashMap<Object, Map<String, String>>();

	private Map<Object, Map<String, SoftReference<?>>> helperValuesByElement = new HashMap<Object, Map<String, SoftReference<?>>>();

	private Map<Object, Map<String, Operation>> attributeInitializers = new HashMap<Object, Map<String, Operation>>();

	private Map<IModel, String> nameByModel;

	private Operation noInitializer = new Operation(0, "noInitializer") { //$NON-NLS-1$
		@Override
		public Object exec(AbstractStackFrame frame) {
			return null;
		}
	};

	/** Map of the model sorted by names. */
	private Map<String, IModel> modelsByName;

	/** Debug mode. */
	private boolean step;

	private ITool[] tools;

	/**
	 * Creates a new execenv parametrized by models.
	 * 
	 * @param models
	 *            the models map
	 * @param tools
	 *            the execution tools
	 */
	public ExecEnv(Map<String, IModel> models, ITool[] tools) {
		this.modelsByName = models;
		this.tools = tools;
		if (tools == null) {
			this.tools = new ITool[] {};
		}
		nameByModel = new HashMap<IModel, String>();
		for (Iterator<String> i = modelsByName.keySet().iterator(); i.hasNext();) {
			String name = i.next();
			IModel model = modelsByName.get(name);
			nameByModel.put(model, name);
		}
	}

	/**
	 * Steps the tools.
	 * 
	 * @param frame
	 *            the frame
	 */
	public void stepTools(AbstractStackFrame frame) {
		for (int i = 0; i < tools.length; i++) {
			tools[i].step(frame);
		}
	}

	/**
	 * Enters the tools.
	 * 
	 * @param frame
	 *            the frame
	 */
	public void enterTools(AbstractStackFrame frame) {
		for (int i = 0; i < tools.length; i++) {
			tools[i].enter(frame);
		}
	}

	/**
	 * Leaves the tools.
	 * 
	 * @param frame
	 *            the frame
	 */
	public void leaveTools(AbstractStackFrame frame) {
		for (int i = 0; i < tools.length; i++) {
			tools[i].leave(frame);
		}
	}

	/**
	 * Terminates the tools.
	 */
	public void terminateTools() {
		for (int i = 0; i < tools.length; i++) {
			tools[i].terminated();
		}
	}

	/**
	 * Initializes the execenv.
	 * 
	 * @param modelAdapterParam
	 *            the model adapter
	 */
	public void init(IModelAdapter modelAdapterParam) {
		this.modelAdapter = modelAdapterParam;
		this.modelAdapter.registerVMSupertypes(OclType.getSupertypes());
		this.modelAdapter.registerVMTypeOperations(this.vmTypeOperations);
	}

	/**
	 * Returns the model containing the element.
	 * 
	 * @param element
	 *            a model element
	 * @return the model containing the element
	 */
	public String getModelNameOf(Object element) {
		if (modelAdapter.isMetametaElement(element)) {
			return "MOF"; //$NON-NLS-1$
		}
		return nameByModel.get(getModelOf(element));
	}

	/**
	 * Returns the model name.
	 * 
	 * @param model
	 *            a model
	 * @return the model name
	 */
	public String getNameOf(IModel model) {
		return nameByModel.get(model);
	}

	/**
	 * Returns the model by name.
	 * 
	 * @param name
	 *            the model name
	 * @return the model by name
	 */
	public IModel getModel(Object name) {
		return modelsByName.get(name);
	}

	public Iterator<IModel> getModels() {
		return modelsByName.values().iterator();
	}

	/**
	 * Find an operation by its context type and name.
	 * 
	 * @param type
	 *            operation context type
	 * @param name
	 *            operation name
	 * @return the operation
	 */
	public Operation getOperation(Object type, Object name) {
		// note: debug is final, therefore there is no runtime penalty if it is false
		final boolean debug = false;
		Operation ret = null;
		Map<String, Operation> map = getOperations(type, false);
		if (map != null) {
			ret = map.get(name);
		}
		if (debug) {
			ATLLogger.info(this + "@" + this.hashCode() + ".getOperation(" + type + ", " + name + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		}
		if (ret == null) {
			if (debug) {
				ATLLogger.info(Messages.getString("ExecEnv.LOOKINGSUPERTYPES", name)); //$NON-NLS-1$
			}
			for (Iterator<Object> i = modelAdapter.getSupertypes(type).iterator(); i.hasNext()
					&& (ret == null);) {
				Object st = i.next();
				ret = getOperation(st, name);
			}
			// let us remember this operation (remark: we could also precompute this for all types)
			if (map != null) {
				map.put(name.toString(), ret);
			}
		}
		return ret;
	}

	/**
	 * Stores an attribute helper.
	 * 
	 * @param type
	 *            the attribute type
	 * @param name
	 *            the attribute name
	 * @param initOperationName
	 *            the init operation name
	 */
	public void registerHelperAttribute(Object type, String name, String initOperationName) {
		Operation op = getOperation(type, initOperationName);
		getAttributeInitializers(type, true).put(name, op);
	}

	/**
	 * Returns the attribute initializer.
	 * 
	 * @param type
	 *            the attribute type
	 * @param name
	 *            the attribute name
	 * @return the attribute initializer
	 */
	public Operation getAttributeInitializer(Object type, String name) {
		Operation ret = null;
		Map<String, Operation> map = getAttributeInitializers(type, true); // was false, but we need to
		// remember search results
		if (map != null) {
			ret = map.get(name);
		}
		if (ret == null) {
			for (Iterator<Object> i = modelAdapter.getSupertypes(type).iterator(); i.hasNext()
					&& (ret == null);) {
				Object st = i.next();
				ret = getAttributeInitializer(st, name);
			}
			// let us remember (remark: we could precompute this)
			if (map != null) {
				if (ret == null) {
					ret = noInitializer;
				}
				map.put(name, ret);
			}
		}
		if (ret == noInitializer) {
			ret = null;
		}
		return ret;
	}

	private Map<String, Operation> getAttributeInitializers(Object type, boolean createIfMissing) {
		Map<String, Operation> ret = attributeInitializers.get(type);
		if (createIfMissing && (ret == null)) {
			ret = new HashMap<String, Operation>();
			attributeInitializers.put(type, ret);
		}
		return ret;
	}

	private Map<String, SoftReference<?>> getHelperValues(Object element) {
		Map<String, SoftReference<?>> ret = helperValuesByElement.get(element);
		if (ret == null) {
			ret = new HashMap<String, SoftReference<?>>();
			helperValuesByElement.put(element, ret);
		}
		return ret;
	}

	/**
	 * Gets the value of an helper.
	 * 
	 * @param frame
	 *            the frame context
	 * @param type
	 *            the helper type
	 * @param element
	 *            the element
	 * @param name
	 *            the helper value name
	 * @return the value
	 */
	public Object getHelperValue(AbstractStackFrame frame, Object type, Object element, String name) {
		Object ret = null;

		Map<String, SoftReference<?>> helperValues = getHelperValues(element);
		SoftReference<?> sr = helperValues.get(name);
		if (sr != null) {
			ret = sr.get();
		}

		if (ret == null) {
			Operation o = getAttributeInitializer(type, name);
			if (o != null) {
				AbstractStackFrame calleeFrame = frame.newFrame(o);
				Object[] arguments = calleeFrame.localVars;
				arguments[0] = element;
				ret = o.exec(calleeFrame.enter());
				calleeFrame.leave();
				if (cacheAttributeHelperResults) {
					helperValues.put(name, new SoftReference<Object>(ret));
				}
			} else {
				// this is a weaving helper for which the value has not been set yet
				ret = OclUndefined.SINGLETON;
			}
		}
		return ret;
	}

	/**
	 * Registers operation for a given type.
	 * 
	 * @param type
	 *            the type
	 * @param oper
	 *            the operation
	 * @param name
	 *            the operation name
	 * @deprecated use {@link #registerOperation(Object, Operation)} instead
	 */
	public void registerOperation(Object type, Operation oper, String name) {
		getOperations(type, true).put(name, oper);
	}

	/**
	 * Registers operation for a given type.
	 * 
	 * @param type
	 *            the type
	 * @param oper
	 *            the operation
	 */
	public void registerOperation(Object type, Operation oper) {
		registerOperation(getOperations(type, true), oper);
	}

	private void registerOperation(Map<String, Operation> map, Operation oper) {
		map.put(oper.getName(), oper);
	}

	private Map<String, Operation> getOperations(Object type, boolean createIfMissing) {
		Map<String, Operation> ret = operationsByType.get(type);
		if (ret == null) {
			Map<String, Operation> vmops = getVMOperations(type);
			if (createIfMissing || ((vmops != null) && !vmops.isEmpty())) {
				ret = new HashMap<String, Operation>();
				operationsByType.put(type, ret);
				if (vmops != null) {
					ret.putAll(vmops);
				}
			}
		}
		return ret;
	}

	private Map<String, Operation> getVMOperations(Object type) {
		return vmTypeOperations.get(type);
	}

	/**
	 * Converts a value to a displayable string.
	 * 
	 * @param value
	 *            the value to convert
	 * @return the displayable string
	 */
	public String toPrettyPrintedString(Object value) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		prettyPrint(new PrintStream(out), value);
		return out.toString();
	}

	/**
	 * Displays a value.
	 * 
	 * @param value
	 *            the value to display
	 */
	public void prettyPrint(Object value) {
		ATLLogger.info(toPrettyPrintedString(value));
	}

	/**
	 * Displays a value.
	 * 
	 * @param out
	 *            the stream
	 * @param value
	 *            the value to display
	 */
	@SuppressWarnings("unchecked")
	public void prettyPrint(PrintStream out, Object value) {
		if (value == null) {
			out.print("<null>"); // print(null) does not work //$NON-NLS-1$
		} else if (value instanceof String) {
			out.print('\'');
			out.print(value); // TODO: escape
			out.print('\'');
		} else if (value instanceof EnumLiteral) {
			out.print('#');
			out.print(value); // TODO: escape
		} else if (value instanceof LinkedHashSet) {
			out.print("OrderedSet {"); //$NON-NLS-1$
			prettyPrintCollection(out, (Collection<?>)value);
		} else if (value instanceof HashSet) {
			out.print("Set {"); //$NON-NLS-1$
			prettyPrintCollection(out, (Collection<?>)value);
		} else if (value instanceof ArrayList) {
			out.print("Sequence {"); //$NON-NLS-1$
			prettyPrintCollection(out, (Collection<?>)value);
		} else if (value instanceof Bag) {
			out.print("Bag {"); //$NON-NLS-1$
			prettyPrintCollection(out, (Collection<?>)value);
		} else if (value instanceof Tuple) {
			out.print("Tuple {"); //$NON-NLS-1$
			boolean first = true;
			for (Iterator<Entry<Object, Object>> i = ((Tuple)value).getMap().entrySet().iterator(); i
					.hasNext();) {
				Entry<Object, Object> entry = i.next();
				if (first) {
					first = false;
				} else {
					out.print(", "); //$NON-NLS-1$
				}
				out.print(entry.getKey());
				out.print(" = "); //$NON-NLS-1$
				prettyPrint(out, entry.getValue());
			}
			out.print('}');
		} else if (value instanceof HashMap) {
			out.print("Map {"); //$NON-NLS-1$
			boolean first = true;
			for (Iterator<Entry<Object, Object>> i = ((Map<Object, Object>)value).entrySet().iterator(); i
					.hasNext();) {
				Entry<Object, Object> entry = i.next();
				if (first) {
					first = false;
				} else {
					out.print(", "); //$NON-NLS-1$
				}
				out.print('(');
				prettyPrint(out, entry.getKey());
				out.print(", "); //$NON-NLS-1$
				prettyPrint(out, entry.getValue());
				out.print(')');
			}
			out.print('}');
		} else if (value instanceof OclUndefined) {
			out.print("OclUndefined"); //$NON-NLS-1$
		} else {
			if (!modelAdapter.prettyPrint(this, out, value)) {
				out.print(value);
			}
		}
	}

	/**
	 * Display a collection.
	 * 
	 * @param out
	 *            the out stream
	 * @param col
	 *            the collection
	 */
	public void prettyPrintCollection(PrintStream out, Collection<?> col) {
		boolean first = true;
		for (Iterator<?> i = col.iterator(); i.hasNext();) {
			if (!first) {
				out.print(", "); //$NON-NLS-1$
			}
			prettyPrint(out, i.next());
			first = false;
		}
		out.print('}');
	}

	/**
	 * Finds a meta element by its name.
	 * 
	 * @param frame
	 *            the frame context
	 * @param mname
	 *            the metamodel name
	 * @param me
	 *            the model element
	 * @return the meta element
	 */
	public static Object findMetaElement(org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame frame,
			Object mname, Object me) {
		Object ret = null;
		IReferenceModel referenceModel = (IReferenceModel)frame.execEnv.getModel(mname);
		if (referenceModel != null) {
			ret = referenceModel.getMetaElementByName((String)me);
			if (ret == null) {
				throw new VMException(frame, Messages.getString("ExecEnv.CANNOTFINDCLASS", me, mname)); //$NON-NLS-1$
			}
		} else {
			throw new VMException(frame, Messages.getString("ExecEnv.CANNOTFINDMETAMODEL", mname)); //$NON-NLS-1$
		}
		return ret;
	}

	/**
	 * Creates a new element in the given frame.
	 * 
	 * @param frame
	 *            the frame context
	 * @param ec
	 *            the element type
	 * @return the new element
	 */
	public Object newElement(AbstractStackFrame frame, Object ec) {
		Object s = null;
		for (Iterator<IModel> i = getModels(); i.hasNext();) {
			IModel model = i.next();
			if (!model.isTarget()) {
				continue;
			}
			if (model.getReferenceModel().isModelOf(ec)) {
				s = model.newElement(ec);
				break;
			}
		}
		if (s == null) {
			throw new VMException(frame,
					Messages.getString("ExecEnv.CANNOTCREATE", toPrettyPrintedString(ec))); //$NON-NLS-1$
		}
		return s;
	}

	/**
	 * Creates a new element in the given frame.
	 * 
	 * @param frame
	 *            the frame context
	 * @param ec
	 *            the element type
	 * @param metamodelName
	 *            the metamodel name
	 * @return the new element
	 */
	public Object newElement(AbstractStackFrame frame, Object ec, String metamodelName) {
		Object s = null;
		IReferenceModel metamodel = (IReferenceModel)getModel(metamodelName);
		if (metamodel != null) {
			for (Iterator<IModel> i = getModels(); i.hasNext();) {
				IModel model = i.next();
				if (model.getReferenceModel().equals(metamodel) && model.isTarget()
						&& model.getReferenceModel().isModelOf(ec)) {
					s = model.newElement(ec);
					break;
				}
			}
		}
		if (s == null) {
			throw new VMException(frame,
					Messages.getString("ExecEnv.CANNOTCREATE", toPrettyPrintedString(ec))); //$NON-NLS-1$
		}
		return s;
	}

	/**
	 * Creates a new element in the given frame and the given model.
	 * 
	 * @param frame
	 *            the frame context
	 * @param ec
	 *            the element type
	 * @param modelName
	 *            the model name
	 * @return the new element
	 */
	public Object newElementIn(AbstractStackFrame frame, Object ec, String modelName) {
		Object s = null;
		IModel model = modelsByName.get(modelName);
		if (model == null) {
			throw new VMException(frame, Messages.getString("ExecEnv.MODEL_NOT_FOUND", modelName)); //$NON-NLS-1$
		}
		if (model.isTarget()) {
			s = model.newElement(ec);
		}
		if (!model.getReferenceModel().isModelOf(ec)) {
			throw new VMException(frame, Messages.getString("ExecEnv.UNABLE_TO_CREATE", ec, modelName)); //$NON-NLS-1$
		}
		if (s == null) {
			throw new VMException(frame,
					Messages.getString("ExecEnv.CANNOTCREATE", toPrettyPrintedString(ec))); //$NON-NLS-1$
		}
		return s;
	}

	/**
	 * Writes self to fileName with given character set.
	 * 
	 * @param frame
	 *            VM stack frame
	 * @param self
	 *            the string to write
	 * @param fileName
	 *            the file to write to
	 * @param charset
	 *            the character set to use, or use default when null
	 * @return true on success
	 * @throws VMException
	 *             if an {@link IOException} occurs
	 */
	private static boolean writeToWithCharset(AbstractStackFrame frame, String self, String fileName,
			String charset) throws VMException {
		boolean ret = false;
		try {
			File file = new File(fileName);
			if (file.getParentFile() != null) {
				file.getParentFile().mkdirs();
			}
			PrintStream out = null;
			if (charset == null) {
				out = new PrintStream(new BufferedOutputStream(new FileOutputStream(file)), true);
			} else {
				out = new PrintStream(new BufferedOutputStream(new FileOutputStream(file)), true, charset);
			}
			out.print(self);
			out.close();
			ret = true;
		} catch (IOException ioe) {
			throw new VMException(frame, ioe.getLocalizedMessage(), ioe);
		}
		return ret;
	}

	public Map<String, IModel> getModelsByName() {
		return modelsByName;
	}

	public boolean isStep() {
		return step;
	}

	public void setStep(boolean step) {
		this.step = step;
	}

	public IModelAdapter getModelAdapter() {
		return modelAdapter;
	}

	public long getNbExecutedBytecodes() {
		return nbExecutedBytecodes;
	}

	/**
	 * Increments the nbExecutedBytecodes.
	 */
	public void incNbExecutedBytecodes() {
		this.nbExecutedBytecodes++;
	}

	private Map<String, String> getWeavingHelperToPersistTo(Object type, boolean createIfMissing) {
		Map<String, String> ret = weavingHelperToPersistToByType.get(type);
		if (createIfMissing && (ret == null)) {
			ret = new HashMap<String, String>();
			weavingHelperToPersistToByType.put(type, ret);
		}
		return ret;
	}

	/**
	 * Returns true if there is a weaving helper for the given type and name.
	 * 
	 * @param type
	 *            the helper type
	 * @param name
	 *            the helper name
	 * @return true if there is a weaving helper for the given type and name
	 */
	public boolean isWeavingHelper(Object type, String name) {
		Map<String, String> weavingHelperToPersistTo = getWeavingHelperToPersistTo(type, false);
		if (weavingHelperToPersistTo != null) {
			return weavingHelperToPersistTo.containsKey(name);
		}
		return false;
	}

	/**
	 * Registers a weaving helper.
	 * 
	 * @param type
	 *            the helper context
	 * @param name
	 *            the helper name
	 * @param persistTo
	 *            the name of the feature to persist
	 */
	public void registerWeavingHelper(Object type, String name, String persistTo) {
		getWeavingHelperToPersistTo(type, true).put(name, persistTo);
	}

	/**
	 * Returns true if the given type has a helper with the given name.
	 * 
	 * @param type
	 *            the given type
	 * @param name
	 *            the helper name
	 * @return true if the given type has a helper with the given name
	 */
	public boolean isHelper(Object type, String name) {
		return (getAttributeInitializer(type, name) != null) || isWeavingHelper(type, name);
	}

	/**
	 * Sets an helper value (only for weaving helpers).
	 * 
	 * @param element
	 *            the helper context
	 * @param name
	 *            the helper name
	 * @param value
	 *            the value to set
	 */
	public void setHelperValue(Object element, String name, Object value) {
		Map<String, SoftReference<?>> helperValues = getHelperValues(element);
		helperValues.put(name, new SoftReference<Object>(value));
	}

	/**
	 * Ends the execution.
	 */
	public void terminated() {
		terminateTools();
		// saving persistent weaving helpers
		for (Iterator<Entry<Object, Map<String, String>>> i = weavingHelperToPersistToByType.entrySet()
				.iterator(); i.hasNext();) {
			Entry<Object, Map<String, String>> entry = i.next();
			Map<String, String> weavingHelperToPersistTo = entry.getValue();
			if (weavingHelperToPersistTo != null) {
				Object type = entry.getKey();
				if (modelAdapter.isModelElement(type)) {
					persistWeavingHelpers(type, weavingHelperToPersistTo);
				} else {
					// can only persist for model elements
				}
			}
		}
		for (IModel model : modelsByName.values()) {
			modelAdapter.finalizeModel(model);
		}
	}

	private void persistWeavingHelpers(Object type, Map<String, String> weavingHelperToPersistTo) {
		for (Iterator<Entry<String, String>> i = weavingHelperToPersistTo.entrySet().iterator(); i.hasNext();) {
			Entry<String, String> entry = i.next();
			String persistTo = entry.getValue();
			if (persistTo != null) {
				String name = entry.getKey();
				IModel metamodel = getModelOf(type);
				for (Iterator<IModel> j = getModels(); j.hasNext();) {
					IModel model = j.next();
					if (model.getReferenceModel() == metamodel) {
						for (Iterator<?> k = model.getElementsByType(type).iterator(); k.hasNext();) {
							Object ame = k.next();
							Object value = getHelperValue(null, modelAdapter.getType(ame), ame, name);
							if (!modelAdapter.isDeleted(value))
								modelAdapter.set(new StackFrame(this), ame, persistTo,
										modelAdapter.getID(value));
						}
					}
				}
			}
		}
	}

	/**
	 * Get the model of a given element.
	 * 
	 * @param element
	 *            the given element
	 * @return the model
	 */
	public IModel getModelOf(Object element) {
		for (Iterator<IModel> i = getModelsByName().values().iterator(); i.hasNext();) {
			IModel model = i.next();
			if (model.isModelOf(element)) {
				return model;
			}
		}
		return null;
	}
}
