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

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ASMProjector {

	public static void realMain(String[] args, PluginClassLoader pcl) throws Exception {
		System.out.println("ATL 0.2 Projector");
		System.out.println();

		long start = new Date().getTime();

		Map params = parseCommandLine(args);
		String plugins = (String)params.get("plugins");
		if (plugins != null) {
			String[] ss = plugins.split(",");
			for (Iterator i = Arrays.asList(ss).iterator(); i.hasNext();) {
				String plg = (String)i.next();
				ATLLogger.info("Loading plugin: " + plg);
				pcl.addLocation(plg);
			}
		}

		String modelLoaderName = (String)params.get("ModelLoader");
		if (modelLoaderName == null) {
			modelLoaderName = "MDR";
		}
		ModelLoader ml = null;
		if (modelLoaderName.equals("MDR")) {
			ml = (ModelLoader)pcl.loadClass("org.eclipse.m2m.atl.drivers.mdr4atl.MDRModelLoader")
					.newInstance();
		} else {
			ml = (ModelLoader)pcl.loadClass("org.eclipse.m2m.atl.drivers.emf4atl.EMFModelLoader")
					.newInstance();
		}

		try {
			ml.addInjector("ebnf", pcl.loadClass("org.eclipse.gmt.tcs.injector.TCSInjector"));
			ml.addInjector("ebnf2", pcl.loadClass("org.eclipse.gmt.tcs.injector.TCSInjector"));
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		try {
			ml.addExtractor("ebnf", pcl.loadClass("org.eclipse.gmt.tcs.extractor.TCSExtractor"));
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		try {
			ml.addInjector("bin", pcl.loadClass("org.atl.engine.injectors.bin.BINInjector"));
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		Map models = new HashMap();
		ASMModel MOF = ml.getMOF();
		models.put("MOF", MOF);

		loadModels("preload", params, models, ml);
		ASMModel M = loadModels("source", params, models, ml);
		String target = (String)params.get("target");

		ml.save(M, target);

		long end = new Date().getTime();
		System.out.println("Execution took " + ((end - start) / 1000.) + "s.");
	}

	// BEGIN TOOLS
	/* returns the last loaded model */
	private static ASMModel loadModels(String name, Map params, Map models, ModelLoader ml)
			throws IOException {
		ASMModel ret = null;
		String list = (String)params.get(name);
		if (list != null) {
			String[] elems = list.split(",");
			for (int i = 0; i < elems.length; i++) {
				String[] names = elems[i].split(":");
				String MName = names[0];
				String MMName = names[1];

				ASMModel MM;
				if (MMName.equals("MOF")) {
					MM = (ASMModel)models.get("MOF");
				} else {
					MM = ml.loadModel(MMName, (ASMModel)models.get("MOF"), (String)params.get(MMName));
				}
				ASMModel M = ml.loadModel(MName, MM, (String)params.get(MName));
				ret = M;
			}
		}

		return ret;
	}

	private static Map parseCommandLine(String[] args) throws Exception {
		Map parameters = new HashMap();

		for (int i = 0; i < args.length; i++) {
			if (args[i].matches("^[^=]*=.*$")) {
				String[] p = args[i].split("=");
				String s = "";
				for (int j = 1; j < p.length; j++) {
					s += ((j != 1) ? "=" : "") + p[j];
				}
				if (parameters.containsKey(p[0])) {
					parameters.put(p[0], parameters.get(p[0]) + "," + s);
				} else {
					parameters.put(p[0], s);
				}
			}
		}

		return parameters;
	}
	// END TOOLS

}
