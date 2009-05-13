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
package org.eclipse.m2m.atl.engine.vm;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.m2m.atl.common.ATLLaunchConstants;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModule;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclUndefined;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMString;

/**
 * This Java class interprets ATL Stack Machine. Command-line Parameters are in the form <name>=<value>. In
 * the following descriptions, parameters are typed. * Boolean If the string value is "true" then the argument
 * will be true, false otherwise. * List<T> A List of T is a coma-separated list of T. * ModelLocation The
 * specification of the location of a model. The path to its serialized form. A ModelLocation can also specify
 * an injector to be used. * ModelSpec The specification of a model in the form <model-name> :
 * <metamodel-name>. For each model and metamodel specified in a ModelSpec there must be a specification of
 * how to load it (except for MOF). This specification is performed by specifying an additional command-line
 * argument. The name of this argument is the name of the model or metamodel and its value is a ModelLocation.
 * * ModelPath <model-name>=<path-name> Command-line parameters: * ASM : File('.asm') * copy : Boolean *
 * source-models : List(ModelSpec) * target-models : List(ModelSpec) * step : Boolean * NetworkDebugger :
 * Boolean * testReserialization : Boolean when true, the ASM file is serialized in XML, text and binary *
 * reserialize : List(ModelPath) Specifies a list of models to serialize at the end of the execution of the
 * program. This is especially usefull to reserialize source models that have been modified during the
 * execution of the program (in-place transformations). * plugins : List(File('.jar')) Specifies * ModelLoader
 * : Enumeration('EMF', 'MDR') Operation signature encoding: Type Encoding Sample Type Sample Type encoded
 * Object J Void V Integer I Boolean B String S Double D EnumLiteral Z ATL context Module A ModelElement
 * M<meta-model-name>!<element-name>; XML!Node MXML!Node; Model L Sequence(<type>) Q<type> Sequence(String) QS
 * Bag(<type>) G<type> Collection(<type>) C<type> Set(<type>) E<type> OrderedSet(<type>) O<type> Native type
 * N<name>; TransientLink NTransientLink; Tuple(name1:<type1>, T<type1>name1; Tuple(n:String,v:Integer)
 * TSn;Iv;; name2:<type2>) <type2>name2;; Tuple(m:XML!Node,b:Boolean) TMXML!Node;m;Bb;; (attribute order is
 * not relevant: TIa;Ib;; and TIb;Ia;; denote the same TupleType) Sample method signature encodings: context
 * XML!Element def: getAttrVal(name : String) : String MXML!Element;.getAttrVal(S):S context String def:
 * toBoolean() : Boolean S.toBoolean():B context String def: toIntegerFromRoman() : Integer
 * S.toIntegerFromRoman():I
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ASMInterpreter {

	private ASMOclAny returnValue;

	public static void realMain(String[] args, PluginClassLoader pcl) throws Exception {
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

		ATLLogger.info("ATL 0.2 State Machine Interpreter");
		long start = new Date().getTime();

		boolean step = "true".equals(params.get("step"));
		boolean showSummary = "true".equals(params.get("summary"));
		boolean profile = "true".equals(params.get("profile"));
		boolean showStackTrace = (params.get("showStackTrace") == null)
				|| (params.get("step").equals("true"));
		List stepops = parseOpList(params.get("stepops"));
		List deepstepops = parseOpList(params.get("deepstepops"));
		List nostepops = parseOpList(params.get("nostepops"));
		List deepnostepops = parseOpList(params.get("deepnostepops"));

		ATLLogger.info("Loading the ATL State Machine...");
		ASM asm = new ASMXMLReader().read(new BufferedInputStream(new FileInputStream(((String)params
				.get("ASM")).split(",")[0])));
		ASMModule asmModule = new ASMModule(asm);

		// BEGIN TEST ASM RESERIALIZATION
		if ("true".equals(params.get("testReserialization"))) {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.asm")));
			new ASMXMLWriter(out, true).print(asm);
			out.close();

			out = new PrintWriter(new BufferedWriter(new FileWriter("test.nodebug.asm")));
			new ASMXMLWriter(out, false).print(asm);
			out.close();

			out = new PrintWriter(new BufferedWriter(new FileWriter("test.tasm")));
			new ASMTextualWriter(out).print(asm);
			out.close();
		}
		// END TEST ASM RESERIALIZATION

		Debugger debugger = null;

		if ("true".equals(params.get("NetworkDebugger"))) {
			debugger = new NetworkDebugger(ATLLaunchConstants.DEFAULT_PORT, true);
		} else {
			debugger = new SimpleDebugger(step, stepops, deepstepops, nostepops, deepnostepops,
					showStackTrace, showSummary, profile, true);
		}
		ASMExecEnv env = new ASMExecEnv(asmModule, debugger, !"false".equals(params.get("cache")));
		env.addModel(ml.getMOF());
		String ATL = (String)params.get("ATL");
		if (ATL == null) {
			throw new ASMInterpreterException("ERROR: ATL meta-model location not given on command line.");
		}
		env.addModel(ml.loadModel("ATL", env.getModel("MOF"), ATL));
		try {
			// TODO: use a plugin mechanism to properly register injectors and extractors
			ml.addInjector("ebnf", pcl.loadClass("org.eclipse.gmt.tcs.injector.TCSInjector"));
			ml.addInjector("ebnf2", pcl.loadClass("org.eclipse.gmt.tcs.injector.TCSInjector"));
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		try {
			// TODO: use a plugin mechanism to properly register injectors and extractors
			ml.addInjector("bin", pcl.loadClass("org.atl.engine.injectors.bin.BINInjector"));
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		try {
			// TODO: use a plugin mechanism to properly register injectors and extractors
			ml.addExtractor("ebnf", pcl.loadClass("org.eclipse.gmt.tcs.injector.TCSExtractor"));
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		loadModels(env, params, ml);

		env.registerOperations(asm);

		loadLibraries(env, params, asmModule);

		long startProgram = new Date().getTime();
		ASMInterpreter asmi = new ASMInterpreter(asm, asmModule, env, params);
		long endProgram = new Date().getTime();

		if ("true".equals(params.get("inPlace"))) {
			// TODO ((ASMModel)env.getModel("IN")).save((String)params.get("OUT"));
			return;
		}
		saveModels(env, params, ml);

		if (asmi.getReturnValue() != null) {
			String storeResultTo = (String)params.get("storeResultTo");
			if (storeResultTo == null) {
				ATLLogger.info("Return value = " + asmi.getReturnValue());
				// System.out.println("Return value = " + asmi.getReturnValue());
			} else {
				FileWriter out = new FileWriter(storeResultTo);
				ASMOclAny retVal = asmi.getReturnValue();
				if (retVal instanceof ASMString) {
					out.write(((ASMString)retVal).getSymbol());
				} else {
					out.write(retVal.toString());
				}
				out.close();
			}
		}

		String reser = (String)params.get("reserialize");
		if (reser != null) {
			ATLLogger.info("Reserializing:");
			// System.out.println("Reserializing:");
			String[] resers = reser.split(",");
			for (int i = 0; i < resers.length; i++) {
				String[] t = resers[i].split("=");
				ASMModel m = env.getModel(t[0]);
				String path = t[1];
				if (path.startsWith("as ")) {
					path = (String)params.get(path.substring(3));
				}
				ATLLogger.info("\t" + m + " to " + path);
				ml.save(m, path);
			}
		}

		ATLLogger.info("End of program execution.");

		long end = new Date().getTime();
		ATLLogger.info("Overall execution took " + ((end - start) / 1000.) + "s.");
		ATLLogger
				.info("Program execution (exclusing model handler startup, program reading, xmi reading and writing) took "
						+ ((endProgram - startProgram) / 1000.) + "s.");
	}

	public ASMInterpreter(ASM asm, ASMModule asmModule, ASMExecEnv env, Map params) {
		List args = new ArrayList();
		ASMOperation op = asm.getOperation("main");
		args.add(asmModule); // self
		for (Iterator i = op.getParameters().iterator(); i.hasNext();) {
			ASMParameter p = (ASMParameter)i.next();
			String pname = p.getName();
			pname = op.resolveVariableName(Integer.parseInt(pname), 0);
			String svalue = (String)params.get(pname);
			ASMOclAny value = new ASMOclUndefined();
			if (svalue != null) {
				value = new ASMString(svalue);
			}
			args.add(value);
		}
		returnValue = op.exec(ASMStackFrame.rootFrame(env, op, args));
	}

	public ASMOclAny getReturnValue() {
		return returnValue;
	}

	// BEGIN LIBRARY TOOLS
	private static void loadLibraries(ASMExecEnv env, Map params, ASMModule asmModule) throws Exception {
		String libs = (String)params.get("libs");
		if (libs != null) {
			String[] libsa = libs.split(",");
			for (int i = 0; i < libsa.length; i++) {
				loadLibrary(env, libsa[i], (String)params.get(libsa[i]), asmModule);
			}
		}
	}

	private static void loadLibrary(ASMExecEnv env, String name, String fileName, ASMModule asmModule)
			throws FileNotFoundException {
		ATLLogger.info("Loading library " + name + " from " + fileName + ".");
		// System.out.println("Loading library " + name + " from " + fileName + ".");
		ASM lib = new ASMXMLReader().read(new BufferedInputStream(new FileInputStream(fileName)));
		env.registerOperations(lib);
		// If there is a main operation, run it to register attribute helpers
		ASMOperation op = lib.getOperation("main");
		if (op != null) {
			op.exec(ASMStackFrame.rootFrame(env, op, Arrays.asList(new Object[] {asmModule})));
		}
	}

	// END LIBRARY TOOLS

	// BEGIN MODEL TOOLS
	private static void loadModels(ASMExecEnv env, Map params, ModelLoader ml) throws Exception {
		List hashModels = parseOpList(params.get("HashModels"));

		String models = (String)params.get("preload");
		if (models != null) {
			loadModels(env, models, params, false, hashModels, ml);
		}
		models = (String)params.get("source-models");
		if (models != null) {
			loadModels(env, models, params, false, hashModels, ml);
		}
		models = (String)params.get("target-models");
		if (models != null) {
			loadModels(env, models, params, true, hashModels, ml);
		}
	}

	private static void loadModels(ASMExecEnv env, String models, Map params, boolean isTarget,
			List hashModels, ModelLoader ml) throws Exception {
		for (Iterator i = Arrays.asList(models.split(",")).iterator(); i.hasNext();) {
			String model = (String)i.next();
			String[] mAndMm = model.split(":");
			loadModel(env, mAndMm, params, isTarget, ml);
		}
	}

	/*
	 * private static void loadHashModel(ASMExecEnv env, String mAndMm[], Map params, boolean isTarget) throws
	 * Exception { ASMModel m = env.getModel(mAndMm[0]); if(m == null) { ASMModel mm =
	 * env.getModel(mAndMm[1]); if(mm == null) { String url = (String)params.get(mAndMm[1]);
	 * System.out.println("Loading meta-model " + mAndMm[1] + " from \"" + url + "\".");
	 * env.addModel(ASMMDRModel.loadASMMDRModel(mAndMm[1], (ASMMDRModel)env.getModel("MOF"), url)); // TODO:
	 * use Hash for meta-models too } if(isTarget) { System.out.println("Creating model " + mAndMm[0] + " : "
	 * + mAndMm[1]); env.addModel(ASMHashModel.newASMHashModel(mAndMm[0], env.getModel(mAndMm[1]))); } else {
	 * String url = (String)params.get(mAndMm[0]); System.out.println("Loading model " + mAndMm[0] + " : " +
	 * mAndMm[1] + " from \"" + url + "\"."); env.addModel(ASMHashModel.loadASMHashModel(mAndMm[0],
	 * env.getModel(mAndMm[1]), (String)params.get(mAndMm[0]))); } } }
	 */

	private static String getURL(Map params, String name) {
		String ret = (String)params.get(name);

		String[] parts = ret.split(",");
		ret = parts[parts.length - 1];

		return ret;
	}

	private static void loadModel(ASMExecEnv env, String[] mAndMm, Map params, boolean isTarget,
			ModelLoader ml) throws Exception {
		ASMModel m = env.getModel(mAndMm[0]);
		if (m == null) {
			ASMModel mm = env.getModel(mAndMm[1]);
			if (mm == null) {
				String url = getURL(params, mAndMm[1]);
				ATLLogger.info("Loading meta-model " + mAndMm[1] + " from \"" + url + "\".");
				env.addModel(ml.loadModel(mAndMm[1], env.getModel("MOF"), url));
			}
			if (isTarget) {
				String url = getURL(params, mAndMm[0]);
				ATLLogger.info("Creating model " + mAndMm[0] + " : " + mAndMm[1]);
				env.addModel(ml.newModel(mAndMm[0], url, env.getModel(mAndMm[1])));
			} else {
				String url = getURL(params, mAndMm[0]);
				ATLLogger.info("Loading model " + mAndMm[0] + " : " + mAndMm[1] + " from \"" + url + "\".");
				env.addModel(ml.loadModel(mAndMm[0], env.getModel(mAndMm[1]), (String)params.get(mAndMm[0])));
			}
		}
	}

	private static void saveModels(ASMExecEnv env, Map params, ModelLoader ml) throws Exception {
		String models = (String)params.get("target-models");
		if (models != null) {
			for (Iterator i = Arrays.asList(models.split(",")).iterator(); i.hasNext();) {
				String model = (String)i.next();
				String[] mAndMm = model.split(":");
				ASMModel m = env.getModel(mAndMm[0]);
				String url = getURL(params, mAndMm[0]);
				ATLLogger.info("Saving model " + mAndMm[0] + " : " + mAndMm[1] + " to \"" + url + "\".");
				ml.save(m, (String)params.get(mAndMm[0]));
			}
		}
	}

	// END MODEL TOOLS

	// BEGIN OTHER TOOLS
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
			} else if (new File(args[i]).isFile()) {
				parameters.put("ATLInstance", args[i]);
			}
		}

		return parameters;
	}

	private static List parseOpList(Object s) {
		List ret = null;

		if (s == null) {
			ret = new ArrayList();
		} else {
			ret = Arrays.asList(((String)s).split(","));
		}

		return ret;
	}
	// END OTHER TOOLS
}
