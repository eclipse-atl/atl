/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frédéric Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModule;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMSequence;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMString;

/**
 * ATL Composite Transformation Interpreter
 * The ACT is read using an XML importer and loaded into a set of Java Object.
 * This all process could be automated.
 * @author Frédéric Jouault
 */
public class ACTInterpreter {

	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);

	private static void showUsage() {
		System.out.println("Usage : org.eclipse.m2m.atl.engine.vm.ACTInterpreter ACT=<act-file> XML=<xml-meta-model> ...");
		System.out.println();
	}

	public static void realMain(String args[], PluginClassLoader pcl) throws Exception {
		System.out.println("ATL 0.2 Composite Transformation Interpreter");
		System.out.println();

		long start = new Date().getTime();

		Map params = parseCommandLine(args);
		String plugins = (String)params.get("plugins");
		if(plugins != null) {
			String ss[] = plugins.split(",");
			for(Iterator i = Arrays.asList(ss).iterator() ; i.hasNext() ; ) {
				String plg = (String)i.next();
				logger.info("Loading plugin: " + plg);
//				System.out.println("Loading plugin: " + plg);
				pcl.addLocation(plg);
			}
		}

		String modelLoaderName = (String)params.get("ModelLoader");
		if(modelLoaderName == null)
			modelLoaderName = "MDR";
		ModelLoader ml = null;
		if(modelLoaderName.equals("MDR")) {
			ml = (ModelLoader)pcl.loadClass("org.eclipse.m2m.atl.drivers.mdr4atl.MDRModelLoader").newInstance();
		} else {
			ml = (ModelLoader)pcl.loadClass("org.eclipse.m2m.atl.drivers.emf4atl.EMFModelLoader").newInstance();
		}

		String act = (String)params.get("ACT");
		params.put("ACT_LOCATION", new File(act).getParent());
		String xml = (String)params.get("XML");

		if((act == null) || (xml == null)) {
			showUsage();
			System.exit(1);
		}

		Map models = new HashMap();
		ASMModel MOF = ml.getMOF();
		models.put("MOF", MOF);
		ASMModel XML = ml.loadModel("XML", MOF, xml);
		models.put("XML", XML);

		System.out.println("Loading ACT: " + act);
		ASMModel ACT = ml.loadModel("ACT", XML, "xml:" + act);
		models.put("ACT", ACT);

		ASMModelElement ACTRoot = (ASMModelElement)ACT.getElementsByType("Root").iterator().next();
		new ACTInterpreter(pcl, ml, ACTRoot, params, models);

		long end = new Date().getTime();
		logger.info("Execution took " + ((end - start) / 1000.) + "s.");
//		System.out.println("Execution took " + ((end - start) / 1000.) + "s.");
	}
	
	public ACTInterpreter(PluginClassLoader pcl, ModelLoader ml, ASMModelElement root, Map params, Map models) throws Exception {
		ACT act = new ACT();
		load(root, act);
		logger.info("Executing ATL Composite Transformation: " + act.name);
//		System.out.println("Executing ATL Composite Transformation: " + act.name);

		Map parameters = new HashMap();
		parameters.put("ACT_LOCATION", params.get("ACT_LOCATION"));
		for(Iterator i = act.plugins.iterator() ; i.hasNext() ; ) {
			Plugin plugin = (Plugin)i.next();
			pcl.addLocation(expand(plugin.href, parameters));
		}
		try {
			ml.addInjector("ebnf", pcl.loadClass("org.eclipse.gmt.tcs.injector.TCSInjector"));
			ml.addInjector("ebnf2", pcl.loadClass("org.eclipse.gmt.tcs.injector.TCSInjector"));
		} catch(Exception e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace(System.out);
		}

		for(Iterator i = act.file_s.iterator() ; i.hasNext() ; ) {
			File_ file = (File_)i.next();
			String filehref = (String)params.get(file.name);
			if(filehref == null) {
				throw new ACTInterpreterException("ERROR: Location of file " + file.name + " not specified on command line.");
//				System.out.println("ERROR: Location of file " + file.name + " not specified on command line.");
//				System.exit(1);
			}
			if((file instanceof InFile) && !new File(filehref).exists()) {
				throw new ACTInterpreterException("ERROR: Location of input file " + file.name + ": \"" + filehref + "\" does not denote a valid file.");
//				System.out.println("ERROR: Location of input file " + file.name + ": \"" + filehref + "\" does not denote a valid file.");
//				System.exit(1);
			}
			parameters.put(file.name, filehref);
		}

		for(Iterator i = act.models.iterator() ; i.hasNext() ; ) {
			Model model = (Model)i.next();
			if(model instanceof InModel) {
				logger.info("Loading model " + model.name + "...");
//				System.out.println("Loading model " + model.name + "...");
				ASMModel m = (ASMModel)models.get(model.name);
				if(m == null) {
					String mhref = (String)params.get(model.name);
					if(mhref == null) {
						throw new ACTInterpreterException("ERROR: Location of input model " + model.name + " not specified on command line.");
//						System.out.println("ERROR: Location of input model " + model.name + " not specified on command line.");
//						System.exit(1);
					}
					ASMModel mm = (ASMModel)models.get(model.metaModel);
					if(mm == null) {
						throw new ACTInterpreterException("ERROR: Metamodel " + model.metaModel + " is not already loaded.");
//						System.out.println("ERROR: Metamodel " + model.metaModel + " is not already loaded.");
//						System.exit(1);
					}
					m = ml.loadModel(model.name, mm, mhref);
					models.put(model.name, m);
				}
			}
		}

		for(Iterator i = act.operations.iterator() ; i.hasNext() ; ) {
			Operation op = (Operation)i.next();
			if(op instanceof Import) {
				System.out.println("Importing...");
				Import im = (Import)op;
				ASMModel mm = (ASMModel)models.get(im.metaModel);
				if(mm == null) {
					throw new ACTInterpreterException("ERROR: Metamodel " + im.metaModel + " is not already loaded.");
//					System.out.println("ERROR: Metamodel " + im.metaModel + " is not already loaded.");
//					System.exit(1);
				}
				String href = expand(im.href, parameters);
				ASMModel m = ml.loadModel(im.storeTo, mm, im.kind + ":" + im.subKind + ":" + href);
				models.put(im.storeTo, m);
			} else if(op instanceof Query) {
				logger.info("Querying...");
//				System.out.println("Querying...");
				Query q = (Query)op;

				ASM asm = new ASMXMLReader().read(new BufferedInputStream(new FileInputStream(expand(q.asm, parameters))));
				ASMModule asmModule = new ASMModule(asm);

				Debugger debugger = null;
				if("network".equals(q.debug)) {
					debugger = new NetworkDebugger(6060, true);
				} else {
					boolean step = false;
					if("step".equals(q.debug)) {
						step = true;
					}
					debugger = new SimpleDebugger(
						/* step = */ step,
						/* stepops = */ new ArrayList(),
						/* deepstepops = */ new ArrayList(),
						/* nostepops = */ new ArrayList(),
						/* deepnostepops = */ new ArrayList(),
						/* showStackTrace = */ true
					);
				}
				ASMExecEnv env = new ASMExecEnv(asmModule, debugger); 

				env.addModel((ASMModel)models.get("MOF"));
				env.addModel((ASMModel)models.get("ATL"));

				for(Iterator j = q.models.iterator() ; j.hasNext() ; ) {
					Model l = (Model)j.next();
					if((l instanceof InoutModel) || (l instanceof InModel)) {
						ASMModel m = (ASMModel)models.get(l.model);
						if(m == null) {
							throw new ACTInterpreterException("ERROR: model " + l.model + " not loaded yet.");
//							System.out.println("ERROR: model " + l.model + " not loaded yet.");
//							System.exit(1);
						}
						env.addModel(l.name, m);
					} else if(l instanceof OutModel) {
						ASMModel m = (ASMModel)models.get(l.model);
						if(m == null) {
							ASMModel mm = (ASMModel)models.get(l.metaModel);
							if(mm == null) {
								throw new ACTInterpreterException("ERROR: model " + l.metaModel + " not loaded yet.");
//								System.out.println("ERROR: model " + l.metaModel + " not loaded yet.");
//								System.exit(1);
							}
							m = ml.newModel(l.model, (String)params.get(l.name), mm);
						}
						env.addModel(l.name, m);
						models.put(l.model, m);
					} else {
						logger.warning(l + " not dealt with yet.");
//						System.out.println("Warning: " + l + " not dealt with yet.");
					}
				}

				env.registerOperations(asm);
				for(Iterator j = q.librarys.iterator() ; j.hasNext() ; ) {
					Library l = (Library)j.next();

					logger.info("Loading library " + l.name + " from " + l.href + ".");
//					System.out.println("Loading library " + l.name + " from " + l.href + ".");
					ASM lib = new ASMXMLReader().read(new BufferedInputStream(new FileInputStream(expand(l.href, parameters))));
					env.registerOperations(lib);
				}

				Map asmParams = new HashMap();
				for(Iterator j = q.withParams.iterator() ; j.hasNext() ; ) {
					WithParam l = (WithParam)j.next();
					asmParams.put(l.name, expand(l.value, params));
				}

				ASMInterpreter ai = new ASMInterpreter(asm, asmModule, env, asmParams);
				Object value = ai.getReturnValue();
				if(q.writeTo != null) {
					String fileName = expand(q.writeTo, parameters);
					if(value instanceof ASMString) {
						value = ((ASMString)value).getSymbol();
					}
					PrintStream out = null;
					if(q.charset == null) {
						out = new PrintStream(new BufferedOutputStream(new FileOutputStream(fileName)), true);
					} else {
						out = new PrintStream(new BufferedOutputStream(new FileOutputStream(fileName)), true, q.charset);
					}
					out.print(value.toString());
					out.close();
				} else {
					System.out.println(value.toString());
				}
			} else if(op instanceof Transform) {
				logger.info("Transforming...");
//				System.out.println("Transforming...");
				Transform tr = (Transform)op;
				ASM asm = new ASMXMLReader().read(new BufferedInputStream(new FileInputStream(expand(tr.asm, parameters))));
				ASMModule asmModule = new ASMModule(asm);

				Debugger debugger = null;
				if("network".equals(tr.debug)) {
					debugger = new NetworkDebugger(6060, true);
				} else {
					boolean step = false;
					if("step".equals(tr.debug)) {
						step = true;
					}
					debugger = new SimpleDebugger(
						/* step = */ step,
						/* stepops = */ new ArrayList(),
						/* deepstepops = */ new ArrayList(),
						/* nostepops = */ new ArrayList(),
						/* deepnostepops = */ new ArrayList(),
						/* showStackTrace = */ true
					);
				}
				ASMExecEnv env = new ASMExecEnv(asmModule, debugger); 
				env.addModel((ASMModel)models.get("MOF"));
				env.addModel((ASMModel)models.get("ATL"));

				for(Iterator j = tr.models.iterator() ; j.hasNext() ; ) {
					Model l = (Model)j.next();
					if((l instanceof InoutModel) || (l instanceof InModel)) {
						ASMModel m = (ASMModel)models.get(l.model);
						if(m == null) {
							throw new ACTInterpreterException("ERROR: model " + l.model + " not loaded yet.");
//							System.out.println("ERROR: model " + l.model + " not loaded yet.");
//							System.exit(1);
						}
						env.addModel(l.name, m);
					} else if(l instanceof OutModel) {
						ASMModel m = (ASMModel)models.get(l.model);
						if(m == null) {
							ASMModel mm = (ASMModel)models.get(l.metaModel);
							if(mm == null) {
								throw new ACTInterpreterException("ERROR: model " + l.metaModel + " not loaded yet.");
//								System.out.println("ERROR: model " + l.metaModel + " not loaded yet.");
//								System.exit(1);
							}
							m = ml.newModel(l.model, (String)params.get(l.name), mm);
						}
						env.addModel(l.name, m);
						models.put(l.model, m);
					} else {
						logger.warning(l + " not dealt with yet.");
//						System.out.println("Warning: " + l + " not dealt with yet.");
					}
				}

				env.registerOperations(asm);
				for(Iterator j = tr.librarys.iterator() ; j.hasNext() ; ) {
					Library l = (Library)j.next();

					logger.info("Loading library " + l.name + " from " + l.href + ".");
//					System.out.println("Loading library " + l.name + " from " + l.href + ".");
					ASM lib = new ASMXMLReader().read(new BufferedInputStream(new FileInputStream(expand(l.href, parameters))));
					env.registerOperations(lib);
				}

				Map asmParams = new HashMap();
				for(Iterator j = tr.withParams.iterator() ; j.hasNext() ; ) {
					WithParam l = (WithParam)j.next();
					asmParams.put(l.name, expand(l.value, params));
				}

				new ASMInterpreter(asm, asmModule, env, asmParams);
			}
		}

		for(Iterator i = act.models.iterator() ; i.hasNext() ; ) {
			Model model = (Model)i.next();
			if(model instanceof OutModel) {
				logger.info("Saving model " + model.name + "...");
//				System.out.println("Saving model " + model.name + "...");
				String mhref = (String)params.get(model.name);
				if(mhref == null) {
					throw new ACTInterpreterException("ERROR: Location of output model " + model.name + " not specified on command line.");
//					System.out.println("ERROR: Location of output model " + model.name + " not specified on command line.");
//					System.exit(1);
				}
				ASMModel m = (ASMModel)models.get(model.name);
				if(m == null) {
					throw new ACTInterpreterException("ERROR: Model " + model.name + " is not already loaded.");
//					System.out.println("ERROR: Model " + model.name + " is not already loaded.");
//					System.exit(1);
				}
				ml.save(m, mhref);
			}
		}
	}

	private static String expand(String s, Map parameters) throws ACTInterpreterException {
		StringBuffer ret = new StringBuffer();
		String varName = "";

		int state = 0;
		for(int i = 0 ; i < s.length() ; i++) {
			char c = s.charAt(i);
			switch(state) {
				case 0:
					if(c == '$')
						state = 1;
					else
						ret.append(c);
					break;
				case 1:
					if(c == '(') {
						varName = "";
						state = 2;
					} else {
						state = 0;
					}
					break;
				case 2:
					if(c == ')') {
						String value = (String)parameters.get(varName);
						if(value == null) {
							throw new ACTInterpreterException("ERROR: Variable not initialized: " + varName);
//							System.out.println("ERROR: Variable not initialized: " + varName);
//							System.exit(1);
						}
						ret.append(value);
						state = 0;
					} else {
						varName += c;
					}
					break;
			}
		}

		return ret.toString();
	}

	/** loads an XML model into an object */
	private void load(ASMModelElement source, Object target) throws Exception {

final boolean debug = false;

		for(Iterator i = ((ASMSequence)source.get(null, "children")).iterator() ; i.hasNext() ; ) {
			ASMModelElement ame = (ASMModelElement)i.next();
			String typeName = ((ASMString)ame.getType().get(null, "name")).getSymbol();
			String name = ((ASMString)ame.get(null, "name")).getSymbol();
			if(typeName.equals("Attribute")) {
				String value = ((ASMString)ame.get(null, "value")).getSymbol();
				name = convName(name, false);
				Field f = target.getClass().getField(name);
				f.set(target, value);
			} else if(typeName.equals("Element")) {

if(debug) logger.info("For element " + name);
//if(debug) System.out.print("For element " + name);

				String cname = convName(name, true);

if(debug) logger.info(" converted into " + cname + " ");
//if(debug) System.out.print(" converted into " + cname + " ");

				Class c = Class.forName("org.eclipse.m2m.atl.engine.vm.ACTInterpreter$" + cname);

if(debug) logger.info("using class " + c);
//if(debug) System.out.println("using class " + c);

				Object value = c.getDeclaredConstructors()[0].newInstance(new Object[] {this});
				load(ame, value);
				setValue(target, value, value.getClass());
			}
		}

	}

	private static void setValue(Object target, Object value, Class valueType) throws Exception {
		String name = valueType.getName();
		name = name.replace('$', '.');
		name = name.substring(name.lastIndexOf(".") + 1);
		name = name.substring(0, 1).toLowerCase() + name.substring(1);
//System.out.println(name);
		try {
			Field f = target.getClass().getField(name);
			f.set(target, value);
		} catch(NoSuchFieldException nsfe) {
			try {
				Field f = target.getClass().getField(name + "s");
				((List)f.get(target)).add(value);
			} catch(NoSuchFieldException nsfe2) {
				Class s = valueType.getSuperclass();
				if(s == null) {
					logger.warning("Not found: " + name);
//					System.out.println("Not found: " + name);
				} else {
					setValue(target, value, s);
				}
			}
		}
	}

	private static String convName(String name, boolean isClass) {
		StringBuffer ret = new StringBuffer();

		int state = (isClass ? 0 : 1);
		for(int i = 0 ; i < name.length() ; i++) {
			char c = name.charAt(i);

			switch(state) {
				case 0:
					ret.append(("" + c).toUpperCase());
					state = 1;
					break;
				case 1:
					switch(c) {
						case '-':
							state = 0;
							break;
						default:
							ret.append(c);
							break;
					}
					break;
			}
		}

		return ret.toString();
	}

	private class ACT {
		public String name;
		public List plugins = new ArrayList();
		public List file_s = new ArrayList();
		public List models = new ArrayList();
		public List params = new ArrayList();
		public List operations = new ArrayList();
	}

	private class Plugin {
		public Plugin() {}

		public String href;
	}

//	private class Param {
//		public Param() {}
//
//		public String name;
//		public String type;
//	}

	private abstract class File_ {
		public File_() {}

		public String name;
	}

	private class InFile extends File_ {
		public InFile() {}
	}

//	private class OutFile extends File_ {
//		public OutFile() {}
//	}

	private class WithParam {
		public WithParam() {}

		public String name;
		public String type;
		public String value;
	}

	private abstract class Model {
		public String name;
		public String model;
		public String metaModel;
	}

	private class InModel extends Model {
		public InModel() {}
	}

	private class OutModel extends Model {
		public OutModel() {}
	}

	private class InoutModel extends Model {
		public InoutModel() {}
	}

	private class Library {
		public Library() {}

		public String name;
		public String href;
	}

	private abstract class Operation {

	}

	private class Transform extends Operation {
		public Transform() {}

		public String asm;
		public String debug;
		public List models = new ArrayList();
		public List librarys = new ArrayList();
		public List withParams = new ArrayList();
	}

	private class Query extends Operation {
		public Query() {}

		public String asm;
		public String debug;
		public String writeTo;
		public String charset;
		public List models = new ArrayList();
		public List librarys = new ArrayList();
		public List withParams = new ArrayList();
	}

	private class Import extends Operation {
		public Import() {}

		public String kind;
		public String subKind;
		public String metaModel;
		public String href;
		public String storeTo;
	}

// BEGIN TOOLS
	private static Map parseCommandLine(String args[]) throws Exception {
		Map parameters = new HashMap();

		for(int i = 0 ; i < args.length ; i++) {
			if(args[i].matches("^[^=]*=.*$")) {
				String p[] = args[i].split("=");
				String s = "";
				for(int j = 1 ; j < p.length ; j++)
					s += ((j != 1) ? "=" : "") + p[j];

				if(parameters.containsKey(p[0])) {
					parameters.put(p[0], parameters.get(p[0]) + "," + s);
				} else {
					parameters.put(p[0], s);
				}
			} else {
			}
		}

		return  parameters;
	}
// END TOOLS

}

