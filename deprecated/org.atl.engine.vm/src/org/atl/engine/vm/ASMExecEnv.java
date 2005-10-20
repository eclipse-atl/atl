package org.atl.engine.vm;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.atl.engine.vm.nativelib.ASMBoolean;
import org.atl.engine.vm.nativelib.ASMEnumLiteral;
import org.atl.engine.vm.nativelib.ASMInteger;
import org.atl.engine.vm.nativelib.ASMModel;
import org.atl.engine.vm.nativelib.ASMModelElement;
import org.atl.engine.vm.nativelib.ASMModule;
import org.atl.engine.vm.nativelib.ASMOclAny;
import org.atl.engine.vm.nativelib.ASMOclType;
import org.atl.engine.vm.nativelib.ASMOclUndefined;
import org.atl.engine.vm.nativelib.ASMReal;
import org.atl.engine.vm.nativelib.ASMString;
import org.atl.engine.vm.nativelib.ASMTupleType;

/**
 * An ASMExecEnv is an execution environment for ATL Stack Machine programs.
 * It holds:
 *	* the only call Stack of the machine (no multi-thread support required),
 *	* the Map of models used by the program,
 *	* the Map of program-specific operations and attribute helpers.
 *		This permits several transformations to be launched in sequence without altering one another.
 * @author Frédéric Jouault
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

	public void registerOperations(ASM asm) {
		for(Iterator i = asm.getOperations().iterator() ; i.hasNext() ; ) {
			ASMOperation op = (ASMOperation)i.next();
			String signature = op.getContext();
			if(signature.matches("^(Q|G|C|E|O|N).*$")) {
				// Sequence, Bag, Collection, Set, OrderedSet, Native type
				System.out.println("Unsupported registration: " + signature);
//			} else if(signature.startsWith("T")) {
//				System.out.println("Unsupported registration: " + signature);
			} else {
				try {
					ASMOclType type = parseType(new StringCharacterIterator(signature));
					//System.out.println("registering " + op + " on " + type);
					registerOperation(type, op);
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
	
	private ASMOclType parseType(CharacterIterator ci) throws SignatureParsingException {
		ASMOclType ret = parseTypeInternal(ci);
		
		if(ci.next() != CharacterIterator.DONE) {
			throw new SignatureParsingException("End of type signature expected at position " + ci.getIndex() + ".");
		}
		
		return ret;
	}
	
	private ASMOclType parseTypeInternal(CharacterIterator ci) throws SignatureParsingException {
		ASMOclType ret = null;
		
		switch(ci.current()) {
			case 'Q': case 'G': case 'C':	// Sequence, Bag, Collection,
			case 'E': case 'O': case 'N':	// Set, OrderedSet, Native type
				ci.next();
				//ASMOclType elementType = parseTypeInternal(ci);
				read(ci, ';');
				break;
			case 'T':						// Tuple
				ci.next();
				Map attrs = new HashMap();
				while(ci.current() != ';') {
					//ASMOclType attrType = parseTypeInternal(ci);
					String attrName = readUntil(ci, ';');
					//attrs.put(attrName, attrType);		// TODO: correct type
					attrs.put(attrName, ASMOclAny.myType);
				}
				ret = new ASMTupleType(attrs);
				break;
			case 'M':						// Metamodel Class
				ci.next();
				String mname = readUntil(ci, '!');
				String name = readUntil(ci, ';');
				ASMModel model = getModel(mname);
				if(model != null) {
					ASMModelElement ame = model.findModelElement(name);
					if(ame == null)
						throw new SignatureParsingException("ERROR: could not find model element " + name + " from " + mname);
					ret = ame;
				} else {
					System.out.println("WARNING: could not find model " + mname + ".");
				}
				break;
				
			// Primitive types, VM Types
			case 'A':		// Module
				ret = ASMModule.myType;
				ci.next();
				break;
			case 'J':		// Object => OclAny ?
				ret = ASMOclAny.myType;
				ci.next();
				break;
			case 'V':		// Void
				ret = ASMOclUndefined.myType;
				ci.next();
				break;
			case 'I':		// Integer
				ret = ASMInteger.myType;
				ci.next();
				break;
			case 'B':		// Boolean
				ret = ASMBoolean.myType;
				ci.next();
				break;
			case 'S':		// String
				ret = ASMString.myType;
				ci.next();
				break;
			case 'Z':		// String
				ret = ASMEnumLiteral.myType;
				ci.next();
				break;
			case 'D':		// Real
				ret = ASMReal.myType;
				ci.next();
				break;
			case 'L':		// Model
				ret = ASMModel.myType;
				ci.next();
				break;
			case CharacterIterator.DONE:
				throw new SignatureParsingException("End of type signature unexpected at position " + ci.getIndex() + ".");
			default:
				throw new SignatureParsingException("Unknown type code : " + ci + ".");
		}
		
		return ret;
	}
	
	private class SignatureParsingException extends Exception {
		public SignatureParsingException(String msg) {
			super(msg);
		}
	}
	
	private void registerOperation(ASMOclType type, Operation oper) {
		getOperations(type, true).put(oper.getName(), oper);
	}

	private Map getOperations(ASMOclType type, boolean createIfMissing) {
		Map ret = (Map)typeOperations.get(type);

		if(ret == null) {
			Map vmops = getVMOperations(type);
			if(createIfMissing || ((vmops != null) && !vmops.isEmpty())) {
				ret = new HashMap();
				typeOperations.put(type, ret);
				if(vmops != null)
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
		if(map != null)
			ret = (Operation)map.get(name);

		if(debug) System.out.println(this + "@" + this.hashCode() + ".getOperation(" + name + ")");
		if(ret == null) {
			if(debug) System.out.println("looking in super of this for operation " + name);
			for(Iterator i = type.getSupertypes().iterator() ; i.hasNext() && (ret == null) ; ) {
				ASMOclType st = (ASMOclType)i.next();
				ret = getOperation(st, name);
			}
		}

		return ret;
	}
	
	public void registerAttributeHelper(ASMOclType type, String name, Operation oper) {
		getAttributeInitializers(type, true).put(name, oper);
	}

	public Operation getAttributeInitializer(ASMOclType type, String name) {
		Operation ret = null;
		Map map = getAttributeInitializers(type, false);
		if(map != null)
			ret = (Operation)map.get(name);

		if(ret == null) {
			for(Iterator i = type.getSupertypes().iterator() ; i.hasNext() && (ret == null) ; ) {
				ASMOclType st = (ASMOclType)i.next();
				ret = getAttributeInitializer(st, name);
			}
		}

		return ret;		
	}

	private Map getAttributeInitializers(ASMOclType type, boolean createIfMissing) {
		Map ret = (Map)attributeInitializers.get(type);

		if(createIfMissing && (ret == null)) {
			ret = new HashMap();
			attributeInitializers.put(type, ret);
		}

		return ret;
	}
	
	private Map getHelperValues(ASMOclAny element) {
		Map ret = (Map)helperValuesByElement.get(element);
		
		if(ret == null) {
			ret = new HashMap();
			helperValuesByElement.put(element, ret);
		}
		
		return ret;
	}

	public ASMOclAny getHelperValue(StackFrame frame, ASMOclAny element, String name) {
		Map helperValues = getHelperValues(element);
		ASMOclAny ret = (ASMOclAny)helperValues.get(name);
		
		if(ret == null) {
			ASMOperation o = (ASMOperation)getAttributeInitializer(element.getType(), name);
			List args = new ArrayList();
			args.add(element);
			ret = o.exec(frame.enterFrame(o, args));
			if(cacheAttributeHelperResults)
				helperValues.put(name, ret);
		}
		
		return ret;
	}

	private boolean cacheAttributeHelperResults;
	private ASMModule asm;
	private Map typeOperations;
	private Map vmTypeOperations;
	private Map attributeInitializers;
	private Map helperValuesByElement;
}
