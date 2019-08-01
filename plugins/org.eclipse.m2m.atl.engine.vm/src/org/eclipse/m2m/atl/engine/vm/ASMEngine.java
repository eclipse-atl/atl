/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

import org.eclipse.m2m.atl.common.ATLLogger;

/**
 * ASM Engine.
 * This is the main entrypoint when using ATL from command-line.
 * It delegates to another class depending on the kind of operation
 * to perform: simple transformation or composite transformation execution,
 * or simply copy (with possible use of injectors and extractors).
 * @author Frederic Jouault 
 */
public class ASMEngine {

	public static PluginClassLoader cl = null;

	public static void main(String[] args) throws Exception {
		List locations = new ArrayList();
		locations.add(ASMEngine.class.getResource("ASMEngine.class").toString().replaceAll("!/.*", "!/"));
		cl = new PluginClassLoader(locations);
		Class main = cl.loadClass("org.eclipse.m2m.atl.engine.vm.ASMEngine");
		Method m = main.getMethod("realMain", new Class[] {String[].class, PluginClassLoader.class});
		Thread.currentThread().setContextClassLoader(cl);
		try {
			m.invoke(null, new Object[] {args, cl});
		} catch(InvocationTargetException ite) {
			ATLLogger.log(Level.SEVERE, ite.getCause().getLocalizedMessage(), ite.getCause());
		}
	}

	public static void realMain(String[] args, PluginClassLoader pcl) throws Exception {
		for(Iterator i = Arrays.asList(args).iterator() ; i.hasNext() ; ) {
			String s = (String)i.next();
			if(s.startsWith("ACT")) {
				ACTInterpreter.realMain(args, pcl);
				break;
			} else if(s.startsWith("ASM")) {
				ASMInterpreter.realMain(args, pcl);
				break;
			} else if(s.startsWith("copy")) {
				ASMProjector.realMain(args, pcl);
				break;
			}
		}
	}
}

