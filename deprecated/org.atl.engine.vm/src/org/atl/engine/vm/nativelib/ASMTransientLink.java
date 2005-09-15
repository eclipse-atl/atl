package org.atl.engine.vm.nativelib;

import org.atl.engine.vm.NativeOperation;
import org.atl.engine.vm.StackFrame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * An ASMTransientLink represents an internal traceability link.
 * Other languages than ATL may be compiled to ATL VM and reuse this class.
 * They can also define their own traceability links using Maps and Tuples.
 * @author Frédéric Jouault
 */
public class ASMTransientLink extends ASMOclAny {

	public static ASMOclType myType = new ASMOclSimpleType("TransientLink", getOclAnyType());
	static {
		NativeOperation.registerOperations(myType, ASMTransientLink.class);
	}

	public ASMTransientLink() {
		super(myType);
	}

	public String toString() {
		StringBuffer ret = new StringBuffer("TransientLink {");

		ret.append("rule = ");
		ret.append(rule);

		ret.append(", sourceElements = {");
		appendMap(sourceElements, ret);
		ret.append("}");

		ret.append(", targetElements = {");
		appendMap(targetElements, ret);
		ret.append("}");

		ret.append(", variables = {");
		appendMap(variables, ret);
		ret.append("}");

		ret.append("}");

		return ret.toString();
	}

	private void appendMap(Map map, StringBuffer ret) {
		for(Iterator i = map.keySet().iterator() ; i.hasNext() ; ) {
			Object name = i.next();
			ret.append(name);
			ret.append(" = ");
			ret.append(map.get(name));
			if(i.hasNext()) ret.append(", ");
		}
	}

	public Collection getSourceElements() {
		return sourceElements.values();
	}

	public Collection getTargetElements() {
		return targetElements.values();
	}

	// Native Operations Below

	public static void setRule(StackFrame frame, ASMTransientLink self, ASMOclAny rule) {
		self.rule = rule;
	}

	public static void addSourceElement(StackFrame frame, ASMTransientLink self, ASMString name, ASMOclAny element) {
		self.sourceElements.put(name.getSymbol(), element);
	}

	public static void addTargetElement(StackFrame frame, ASMTransientLink self, ASMString name, ASMOclAny element) {
		self.targetElements.put(name.getSymbol(), element);
		self.targetElementsList.add(element);
	}

	public static void addVariable(StackFrame frame, ASMTransientLink self, ASMString name, ASMOclAny value) {
		self.variables.put(name.getSymbol(), value);
	}

	public static ASMOclAny getRule(StackFrame frame, ASMTransientLink self) {
		return self.rule;
	}

	public static ASMOclAny getSourceElement(StackFrame frame, ASMTransientLink self, ASMString name) {
		return (ASMOclAny)self.sourceElements.get(name.getSymbol());
	}

	public static ASMOclAny getTargetElement(StackFrame frame, ASMTransientLink self, ASMString name) {
		return (ASMOclAny)self.targetElements.get(name.getSymbol());
	}

	public static ASMOclAny getTargetFromSource(StackFrame frame, ASMTransientLink self, ASMOclAny sourceElement) {
//TODO: use mapsTo
//		return (ASMOclAny)self.targetElements.values().iterator().next();
		return (ASMOclAny)self.targetElementsList.iterator().next();
	}

	public static ASMOclAny getNamedTargetFromSource(StackFrame frame, ASMTransientLink self, ASMOclAny sourceElement, ASMString name) {
		return (ASMOclAny)self.targetElements.get(name.getSymbol());
	}

	public static ASMOclAny getVariable(StackFrame frame, ASMTransientLink self, ASMString name) {
		return (ASMOclAny)self.variables.get(name.getSymbol());
	}

	private Map sourceElements = new HashMap();
	private Map targetElements = new HashMap();
	private List targetElementsList = new ArrayList();
	private Map variables = new HashMap();
	private ASMOclAny rule;
}

