/**
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: ParserLauncher.java,v 1.1 2009/04/21 14:12:27 wpiers Exp $
 */
package org.eclipse.m2m.atl.dsls.tcs.injector;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.m2m.atl.dsls.tcs.injector.TCSRuntime.RefSetting;
import org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.ParserWrapper;

/**
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 *
 */
public class ParserLauncher {

	private final static int DEFAULT_TAB_SIZE = 8;
	
	private List refSettings;
	private ParserWrapper parserWrapper;

	public Object parse(ModelAdapter target, InputStream in, Map arguments) throws IOException {
		Object ret = null;

		refSettings = new ArrayList();
		
		int tabSize = arguments.get("tabSize") == null ? DEFAULT_TAB_SIZE : Integer.parseInt((String)arguments.get("tabSize"));
		
		String parserGeneratorClassName = (String)arguments.get("parserGenerator");
		if(parserGeneratorClassName != null) {
			try {
				parserWrapper = (ParserWrapper)Class.forName("org.eclipse.m2m.atl.dsls.tcs.injector.wrappers." + parserGeneratorClassName + ".ParserWrapper", true, Thread.currentThread().getContextClassLoader()).newInstance();
			} catch (InstantiationException e) {
				//throw new IllegalArgumentException("Unable to instanciate parser generator with name " + parserGeneratorClassName, e);
				throw new IllegalArgumentException("Unable to instanciate parser generator with name " + parserGeneratorClassName);
			} catch (IllegalAccessException e) {
				//throw new IllegalArgumentException("Unable to access to parser generator with name " + parserGeneratorClassName, e);
				throw new IllegalArgumentException("Unable to access to parser generator with name " + parserGeneratorClassName);
			} catch (ClassNotFoundException e) {
				//throw new IllegalArgumentException("Unable to locate parser generator with name " + parserGeneratorClassName, e);
				throw new IllegalArgumentException("Unable to locate parser generator with name " + parserGeneratorClassName);
			}
		} else {
			// default parser generator
			parserWrapper = new org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ParserWrapper();
		}
		
		String nameAndProductionRule = (String)arguments.get("name");
		String ss[] = nameAndProductionRule.split("-");
		String name = ss[0];

		String productionRule = "main";
		if(ss.length > 1) {
			productionRule = ss[1];
		}

		TCSRuntime runtime = new TCSRuntime(target, parserWrapper, refSettings, arguments);
		parserWrapper.setRuntime(runtime);

		try {
			ret = parserWrapper.parse(tabSize, name, productionRule, in, arguments);
		} catch (Exception e) {
			e.printStackTrace();
		}

//		if(runtime.getNbErrors() == 0) {
			// A RefSetting that relies on imported contexts can only be executed after
			// the RefSetting importing the corresponding context (and this, recursively).
			// For now, we sort RefSettings so that all those that import a context
			// are executed first.
			// If a RefSetting that imports a context relies on imported contexts,
			// then this solution is not enough.
			// The concept of imported context should be defined cleanly first.
			Collections.sort(refSettings, new Comparator() {
				public int compare(Object o1, Object o2) {
					RefSetting rs1 = (RefSetting)o1;
					RefSetting rs2 = (RefSetting)o2;
					if(rs1.importContext && !rs2.importContext)
						return -1;	// importContext first
					else if(rs2.importContext && !rs1.importContext)
						return 1;	// importContext first
					else			// both or none are importContext
						return 0;	// don't care
				}
			});

			int nbCrashedRefSettings = 0;
			for(Iterator i = refSettings.iterator() ; i.hasNext() ; ) {
				RefSetting rs = (RefSetting)i.next();
				try {
					rs.doIt();
				} catch(Exception e) {
					nbCrashedRefSettings++;
				}
			}
			if(nbCrashedRefSettings > 0)
				//TODO: check crashes cause
				throw new IOException("Warning: " + nbCrashedRefSettings + " refSetting crashed");
//		}

		return ret;
	}
}
