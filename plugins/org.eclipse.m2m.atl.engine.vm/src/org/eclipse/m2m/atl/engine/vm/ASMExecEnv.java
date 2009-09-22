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

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMBoolean;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMEnumLiteral;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMInteger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModule;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclType;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclUndefined;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMReal;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMString;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMTupleType;

/**
 * An ASMExecEnv is an execution environment for ATL Stack Machine programs. It holds: * the only call Stack
 * of the machine (no multi-thread support required), * the Map of models used by the program, * the Map of
 * program-specific operations and attribute helpers. This permits several transformations to be launched in
 * sequence without altering one another.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ASMExecEnv extends ExecEnv {

	public ASMExecEnv(ASMModule asm, Debugger debugger) {
		this(asm, debugger, true);
	}

	public ASMExecEnv(ASMModule asm, Debugger debugger, boolean cacheAttributeHelperResults) {
		super(debugger);
		this.asm = asm;
		globalVariables.put(asm.getName(), asm);
		typeOperations = new HashMap();
		attributeInitializers = new HashMap();
		helperValuesByElement = new HashMap();
		vmTypeOperations = ASMOclType.getVMOperations();
		this.cacheAttributeHelperResults = cacheAttributeHelperResults;
	}

	public ASMModule getASMModule() {
		return asm;
	}

	public void registerOperations(ASM currentAsm) {
		for (Iterator i = currentAsm.getOperations().iterator(); i.hasNext();) {
			ASMOperation op = (ASMOperation)i.next();
			String signature = op.getContextSignature();
			if (signature.matches("^(Q|G|C|E|O|N).*$")) {
				// Sequence, Bag, Collection, Set, OrderedSet, Native type
				ATLLogger.warning("Unsupported registration: " + signature);
			} else {
				try {
					ASMOclType type = parseType(new StringCharacterIterator(signature));
					registerOperation(type, op);
					op.setContextType(type);
				} catch (SignatureParsingException spe) {
					ATLLogger.log(Level.SEVERE, spe.getLocalizedMessage(), spe);
				}
			}
		}
	}

	// read until c, including c
	// returns everything read before c
	private String readUntil(CharacterIterator ci, char c) throws SignatureParsingException {
		StringBuffer ret = new StringBuffer();

		while (ci.current() != c) {
			ret.append(ci.current());
			ci.next();
		}
		read(ci, c);

		return ret.toString();
	}

	private void read(CharacterIterator ci, char c) throws SignatureParsingException {
		if (ci.current() != c)
			throw new SignatureParsingException("Expected \'" + c + "\', found \'" + ci.current()
					+ "\' at position " + ci.getIndex() + ".");
		ci.next();
	}

	private ASMOclType parseType(CharacterIterator ci) throws SignatureParsingException {
		ASMOclType ret = parseTypeInternal(ci);

		if (ci.next() != CharacterIterator.DONE) {
			throw new SignatureParsingException("End of type signature expected at position " + ci.getIndex()
					+ ".");
		}

		return ret;
	}

	private ASMOclType parseTypeInternal(CharacterIterator ci) throws SignatureParsingException {
		ASMOclType ret = null;

		switch (ci.current()) {
			case 'Q':
			case 'G':
			case 'C': // Sequence, Bag, Collection,
			case 'E':
			case 'O':
			case 'N': // Set, OrderedSet, Native type
				ci.next();
				// ASMOclType elementType =
				parseTypeInternal(ci);
				// read(ci, ';');
				break;
			case 'T': // Tuple
				ci.next();
				Map attrs = new HashMap();
				while (ci.current() != ';') {
					// ASMOclType attrType =
					parseTypeInternal(ci);
					String attrName = readUntil(ci, ';');
					// attrs.put(attrName, attrType); // TODO: correct type
					attrs.put(attrName, ASMOclAny.myType);
				}
				ret = new ASMTupleType(attrs);
				break;
			case 'M': // Metamodel Class
				ci.next();
				String mname = readUntil(ci, '!');
				String name = readUntil(ci, ';');
				ASMModel model = getModel(mname);
				if (model != null) {
					ASMModelElement ame = model.findModelElement(name);
					if (ame == null)
						throw new SignatureParsingException("ERROR: could not find model element " + name
								+ " from " + mname);
					ret = ame;
				} else {
					ATLLogger.warning("could not find model " + mname + ".");
				}
				break;

			// Primitive types, VM Types
			case 'A': // Module
				ret = ASMModule.myType;
				ci.next();
				break;
			case 'J': // Object => OclAny ?
				ret = ASMOclAny.myType;
				ci.next();
				break;
			case 'V': // Void
				ret = ASMOclUndefined.myType;
				ci.next();
				break;
			case 'I': // Integer
				ret = ASMInteger.myType;
				ci.next();
				break;
			case 'B': // Boolean
				ret = ASMBoolean.myType;
				ci.next();
				break;
			case 'S': // String
				ret = ASMString.myType;
				ci.next();
				break;
			case 'Z': // String
				ret = ASMEnumLiteral.myType;
				ci.next();
				break;
			case 'D': // Real
				ret = ASMReal.myType;
				ci.next();
				break;
			case 'L': // Model
				ret = ASMModel.myType;
				ci.next();
				break;
			case CharacterIterator.DONE:
				throw new SignatureParsingException("End of type signature unexpected at position "
						+ ci.getIndex() + ".");
			default:
				throw new SignatureParsingException("Unknown type code : " + ci + ".");
		}

		return ret;
	}

	private class SignatureParsingException extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = -1184477079748763555L;

		public SignatureParsingException(String msg) {
			super(msg);
		}
	}

	private void registerOperation(ASMOclType type, Operation oper) {
		getOperations(type, true).put(oper.getName(), oper);
	}

	private Map getOperations(ASMOclType type, boolean createIfMissing) {
		Map ret = (Map)typeOperations.get(type);

		if (ret == null) {
			Map vmops = getVMOperations(type);
			if (createIfMissing || ((vmops != null) && !vmops.isEmpty())) {
				ret = new HashMap();
				typeOperations.put(type, ret);
				if (vmops != null)
					ret.putAll(vmops);
			}
		}

		return ret;
	}

	private Map getVMOperations(ASMOclType type) {
		return (Map)vmTypeOperations.get(type);
	}

	public Collection getOperations(ASMOclType type) {
		Collection ret = null;

		ret = getOperations(type, true).values();

		return ret;
	}

	public Operation getOperation(ASMOclType type, String name) {
		final boolean debug = false;
		Operation ret = null;
		Map map = getOperations(type, false);
		if (map != null)
			ret = (Operation)map.get(name);

		if (debug)
			ATLLogger.info(this + "@" + this.hashCode() + ".getOperation(" + name + ")");
		if (ret == null) {
			if (debug)
				ATLLogger.info("looking in super of this for operation " + name);
			for (Iterator i = type.getSupertypes().iterator(); i.hasNext() && (ret == null);) {
				ASMOclType st = (ASMOclType)i.next();
				ret = getOperation(st, name);
			}
		}

		return ret;
	}

	public void terminated() {
		getDebugger().terminated();

		// saving persistent weaving helpers
		for (Iterator i = weavingHelperToPersistToByType.entrySet().iterator(); i.hasNext();) {
			Map.Entry entry = (Map.Entry)i.next();
			Map weavingHelperToPersistTo = (Map)entry.getValue();
			if (weavingHelperToPersistTo != null) {
				Object type = entry.getKey();
				if (type instanceof ASMModelElement) {
					persistWeavingHelpers((ASMModelElement)type, weavingHelperToPersistTo);
				} else {
					// can only persist for model elements
				}
			}
		}
	}

	private void persistWeavingHelpers(ASMModelElement type, Map weavingHelperToPersistTo) {
		for (Iterator i = weavingHelperToPersistTo.entrySet().iterator(); i.hasNext();) {
			Map.Entry entry = (Map.Entry)i.next();
			String persistTo = (String)entry.getValue();
			if (persistTo != null) {
				String name = (String)entry.getKey();
				ASMModel metamodel = type.getModel();
				for (Iterator j = getModels().values().iterator(); j.hasNext();) {
					ASMModel model = (ASMModel)j.next();
					if (model.getMetamodel() == metamodel) {
						for (Iterator k = model.getElementsByType(type).iterator(); k.hasNext();) {
							ASMModelElement ame = (ASMModelElement)k.next();
							ASMOclAny value = getHelperValue(null, ame, name);
							ame.set(null, persistTo, value.get(null, "__xmiID__"));
						}
					}
				}
			}
		}
	}

	public void registerWeavingHelper(ASMOclType type, String name, String persistTo) {
		getWeavingHelperToPersistTo(type, true).put(name, persistTo);
	}

	private Map getWeavingHelperToPersistTo(ASMOclType type, boolean createIfMissing) {
		Map ret = (Map)weavingHelperToPersistToByType.get(type);

		if (createIfMissing && (ret == null)) {
			ret = new HashMap();
			weavingHelperToPersistToByType.put(type, ret);
		}

		return ret;
	}

	public void registerAttributeHelper(ASMOclType type, String name, Operation oper) {
		getAttributeInitializers(type, true).put(name, oper);
	}

	public boolean isHelper(ASMOclType type, String name) {
		return (getAttributeInitializer(type, name) != null) || isWeavingHelper(type, name);
	}

	public boolean isWeavingHelper(ASMOclType type, String name) {
		Map weavingHelperToPersitTo = getWeavingHelperToPersistTo(type, false);
		if (weavingHelperToPersitTo != null) {
			return weavingHelperToPersitTo.containsKey(name);
		} else {
			return false;
		}
	}

	private Operation getAttributeInitializer(ASMOclType type, String name) {
		Operation ret = null;
		Map map = getAttributeInitializers(type, false);
		if (map != null)
			ret = (Operation)map.get(name);

		if (ret == null) {
			for (Iterator i = type.getSupertypes().iterator(); i.hasNext() && (ret == null);) {
				ASMOclType st = (ASMOclType)i.next();
				ret = getAttributeInitializer(st, name);
			}
		}

		return ret;
	}

	private Map getAttributeInitializers(ASMOclType type, boolean createIfMissing) {
		Map ret = (Map)attributeInitializers.get(type);

		if (createIfMissing && (ret == null)) {
			ret = new HashMap();
			attributeInitializers.put(type, ret);
		}

		return ret;
	}

	private Map getHelperValues(ASMOclAny element) {
		Map ret = (Map)helperValuesByElement.get(element);

		if (ret == null) {
			ret = new HashMap();
			helperValuesByElement.put(element, ret);
		}

		return ret;
	}

	// both for attribute helpers, and weaving helpers
	public ASMOclAny getHelperValue(StackFrame frame, ASMOclAny element, String name) {
		Map helperValues = getHelperValues(element);
		ASMOclAny ret = (ASMOclAny)helperValues.get(name);

		if (ret == null) {
			ASMOperation o = (ASMOperation)getAttributeInitializer(element.getType(), name);
			if (o != null) {
				List args = new ArrayList();
				args.add(element);
				ret = o.exec(frame.enterFrame(o, args));
				if (cacheAttributeHelperResults)
					helperValues.put(name, ret);
			} else {
				ret = new ASMOclUndefined(); // this is a weaving helper for which the value has not been set
				// yet
			}
		}

		return ret;
	}

	// only for weaving helpers
	public void setHelperValue(StackFrame frame, ASMOclAny element, String name, ASMOclAny value) {
		Map helperValues = getHelperValues(element);
		helperValues.put(name, value);
	}

	private boolean cacheAttributeHelperResults;

	private ASMModule asm;

	private Map typeOperations;

	private Map vmTypeOperations;

	private Map attributeInitializers;

	private Map helperValuesByElement;

	private Map weavingHelperToPersistToByType = new HashMap();
}
