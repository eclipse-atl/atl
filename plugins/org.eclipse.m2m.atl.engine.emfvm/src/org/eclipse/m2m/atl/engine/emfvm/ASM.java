/*******************************************************************************
 * Copyright (c) 2007, 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *    
 * $Id: ASM.java,v 1.2.4.1 2008/03/04 21:12:13 mbarbero Exp $
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.m2m.atl.engine.emfvm.emf.EMFModelAdapter;
import org.eclipse.m2m.atl.engine.emfvm.lib.ASMModule;
import org.eclipse.m2m.atl.engine.emfvm.lib.ExecEnv;
import org.eclipse.m2m.atl.engine.emfvm.lib.Extension;
import org.eclipse.m2m.atl.engine.emfvm.lib.ModelAdapter;
import org.eclipse.m2m.atl.engine.emfvm.lib.ReferenceModel;

/**
 * 
 * @author Frederic Jouault
 * @author Mikael Barbero
 *
 */
public class ASM {

	private String name;
	private List operations = new ArrayList();
	private List fields = new ArrayList();
	
	private ASMOperation mainOperation = null;
	
	public ASM() {
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void addField(String name, String type) {
		fields.add(name);
	}

	public void addOperation(ASMOperation operation) {
		operations.add(operation);
		if(operation.getName().equals("main") && operation.getContext().equals("A")) {
			mainOperation = operation;
		}
	}

	// TODO:
	//	- implements other options
	//	- define options somewhere (currently, best definition is in regular VM)
	public Object run(Map models, Map libraries, Map options) {
		Object ret = null;
		boolean printExecutionTime = "true".equals(options.get("printExecutionTime"));

		long startTime = System.currentTimeMillis();
		
		ExecEnv execEnv = new ExecEnv(models);
		ModelAdapter modelAdapter = new EMFModelAdapter(execEnv);
		execEnv.init(modelAdapter);
		
		if("true".equals(options.get("step")))
			execEnv.step = true;
		
		String ext = (String)options.get("extensions");
		if(ext != null) {
			ClassLoader cl = getClass().getClassLoader();

			String extraClasspath = (String)options.get("extraClasspath");
			if(extraClasspath != null) {
				String paths[] = extraClasspath.split(",");
				URL urls[] = new URL[paths.length];
				String userDir = (String)options.get("user.dir");
				if(userDir == null)
					userDir = System.getProperty("user.dir");
				for(int i = 0 ; i < paths.length ; i++) {
					try {
						urls[i] = new File(userDir, paths[i]).toURI().toURL();
					} catch (MalformedURLException e) {
						throw new RuntimeException("error while loading extra classpath entry: \"" + paths[i] +"\"", e);
					}
				}
				cl = new URLClassLoader(urls, cl);
			}
			
			String extensions[] = ext.split(",");
			for(int i = 0 ; i < extensions.length ; i++) {
				try {
					Extension extension = (Extension)cl.loadClass(extensions[i]).newInstance();
					extension.apply(execEnv, options);
				} catch (ClassNotFoundException e) {
					throw new RuntimeException("error while loading extension class: \"" + extensions[i] +"\"", e);
				} catch (InstantiationException e) {
					throw new RuntimeException("error while instantiating extension class: \"" + extensions[i] +"\"", e);
				} catch (IllegalAccessException e) {
					throw new RuntimeException("error while instantiating extension class: \"" + extensions[i] +"\"", e);
				}
			}
		}
		
		registerOperations(execEnv, operations);

		ASMModule asmModule = new ASMModule();
		StackFrame frame = new StackFrame(execEnv, asmModule, mainOperation);

		for(Iterator i = libraries.values().iterator() ; i.hasNext() ; ) {
			ASM library = (ASM)i.next();
			registerOperations(execEnv, library.operations);
			if(library.mainOperation != null)
				library.mainOperation.exec(new StackFrame(execEnv, asmModule, library.mainOperation));
		}
		
		ret = mainOperation.exec(frame);
		long endTime = System.currentTimeMillis();
		if(printExecutionTime)
			System.out.println("Executed " + name + " in " + ((endTime - startTime) / 1000.) + "s.");
		
		if("true".equals(options.get("showSummary")))
			System.out.println("Number of instructions executed: " + execEnv.nbExecutedBytecodes);
		return ret;
	}
	
	public void registerOperations(ExecEnv execEnv, List operations) {
		for(Iterator i = operations.iterator() ; i.hasNext() ; ) {
			ASMOperation op = (ASMOperation)i.next();
			String signature = op.getContext();
			if(signature.matches("^(Q|G|C|E|O|N).*$")) {
				// Sequence, Bag, Collection, Set, OrderedSet, Native type
				System.out.println("Unsupported registration: " + signature);
//				} else if(signature.startsWith("T")) {
//					System.out.println("Unsupported registration: " + signature);
			} else {
				try {
					Object type = parseType(execEnv, new StringCharacterIterator(signature));
					//System.out.println("registering " + op + " on " + type);
					execEnv.registerOperation(type, op, op.getName());
					//op.setContextType(type);
				} catch(SignatureParsingException spe) {
					spe.printStackTrace(System.out);
				}
			}
		}
	}

	// read until c, including c
	// returns everything read before c
	private String readUntil(CharacterIterator ci, char c) throws SignatureParsingException {
		StringBuffer ret = new StringBuffer();
		
		while(ci.current() != c) {
			ret.append(ci.current());
			ci.next();
		}
		read(ci, c);
		
		return ret.toString();
	}
	
	private void read(CharacterIterator ci, char c) throws SignatureParsingException {
		if(ci.current() != c)
			throw new SignatureParsingException("Expected \'" + c + "\', found \'" + ci.current() + "\' at position " + ci.getIndex() + ".");
		ci.next();
	}
	
	// Type may be java.lang.Class, EClass, OclType
	private Object parseType(ExecEnv execEnv, CharacterIterator ci) throws SignatureParsingException {
		Object ret = parseTypeInternal(execEnv, ci);
		
		if(ci.next() != CharacterIterator.DONE) {
			throw new SignatureParsingException("End of type signature expected at position " + ci.getIndex() + ".");
		}
		
		return ret;
	}
	
	private Object parseTypeInternal(ExecEnv execEnv, CharacterIterator ci) throws SignatureParsingException {
		Object ret = null;
		
		switch(ci.current()) {
//			case 'Q': case 'G': case 'C':	// Sequence, Bag, Collection,
//			case 'E': case 'O': case 'N':	// Set, OrderedSet, Native type
//				ci.next();
//				//ASMOclType elementType = parseTypeInternal(ci);
//				read(ci, ';');
//				break;
//			case 'T':						// Tuple
//				ci.next();
//				Map attrs = new HashMap();
//				while(ci.current() != ';') {
//					ASMOclType attrType = parseTypeInternal(ci);
//					String attrName = readUntil(ci, ';');
//					//attrs.put(attrName, attrType);		// TODO: correct type
//					attrs.put(attrName, ASMOclAny.myType);
//				}
//				ret = new ASMTupleType(attrs);
//				break;
			case 'M':						// Metamodel Class
				ci.next();
				String mname = readUntil(ci, '!');
				String name = readUntil(ci, ';');
				ReferenceModel model = (ReferenceModel)execEnv.getModel(mname);
				if(model != null) {
					Object ec = model.getMetaElementByName(name);
					if(ec == null)
						throw new SignatureParsingException("ERROR: could not find model element " + name + " from " + mname);
					ret = ec;
				} else {
					System.out.println("WARNING: could not find model " + mname + ".");
				}
				break;
				
			// Primitive types, VM Types
			case 'A':		// Module
				ret = ASMModule.class;
				ci.next();
				break;
			case 'J':		// Object => OclAny ?
				ret = Object.class;
				ci.next();
				break;
//			case 'V':		// Void
//				ret = ASMOclUndefined.myType;
//				ci.next();
//				break;
			case 'I':		// Integer
				ret = Integer.class;
				ci.next();
				break;
			case 'B':		// Boolean
				ret = Boolean.class;
				ci.next();
				break;
			case 'S':		// String
				ret = String.class;
				ci.next();
				break;
//			case 'Z':		// String
//				ret = ASMEnumLiteral.myType;
//				ci.next();
//				break;
			case 'D':		// Real
				ret = Double.class;
				ci.next();
				break;
//			case 'L':		// Model
//				ret = ASMModel.myType;
//				ci.next();
//				break;
			case CharacterIterator.DONE:
				throw new SignatureParsingException("End of type signature unexpected at position " + ci.getIndex() + ".");
			default:
				throw new SignatureParsingException("Unknown type code : " + ci.current() + ".");
		}
		
		return ret;
	}
	
	private class SignatureParsingException extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = 7488097967558841786L;

		public SignatureParsingException(String msg) {
			super(msg);
		}
	}
}
