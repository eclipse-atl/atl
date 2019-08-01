/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *     Dennis Wagelaar (Vrije Universiteit Brussel)
 *     Andres Yie (Vrije Universiteit Brussel)
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm.nativelib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * An ASMTransientLink represents an internal traceability link.
 * Other languages than ATL may be compiled to ATL VM and reuse this class.
 * They can also define their own traceability links using Maps and Tuples.
 *
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class ASMTransientLink extends ASMOclAny {

	public static ASMOclType myType = new ASMOclSimpleType("TransientLink", getOclAnyType());

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

	public Map getSourceMap() {
		return sourceElements;
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
		ASMOclAny ret = null;
//TODO: use mapsTo
//		return (ASMOclAny)self.targetElements.values().iterator().next();
		
		if(!self.targetElementsList.isEmpty()) {
			ret = (ASMOclAny)self.targetElementsList.iterator().next();
		}
		
		if(ret == null) {
			ret = new ASMOclUndefined();
		}
	
		return ret;
	}

	public static ASMOclAny getNamedTargetFromSource(StackFrame frame, ASMTransientLink self, ASMOclAny sourceElement, ASMString name) {
		return (ASMOclAny)self.targetElements.get(name.getSymbol());
	}

	public static ASMOclAny getVariable(StackFrame frame, ASMTransientLink self, ASMString name) {
		return (ASMOclAny)self.variables.get(name.getSymbol());
	}
	/**
	 * This method allows for retrieving all source elements for this link
	 * without knowing the local variable names of the rule
	 * that created the mappings. This reduces fragility.
	 * @param frame
	 * @param self
	 * @return A Map of source element names to target elements for this link.
	 * @author Andres Yie <ayiegarz@vub.ac.be>
	 */
	public static ASMMap getSourceElements(StackFrame frame, ASMTransientLink self) {
		Map map = new HashMap();
		
		// It is necessary to create a new Map in order to have the name of the variables 
		// in String
		for(Iterator i = self.sourceElements.keySet().iterator() ; i.hasNext() ; ) {
			Object name = i.next();
			map.put(new ASMString(name.toString()), self.sourceElements.get(name));
		}
		
		
		return new ASMMap(map);
	}
	
	/**
	 * This method allows for retrieving all target elements for this link
	 * without knowing the local variable names of the rule
	 * that created the mappings. This reduces fragility.
	 * @param frame
	 * @param self
	 * @return A Map of target element names to target elements for this link.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public static ASMMap getTargetElements(StackFrame frame, ASMTransientLink self) {
		Map map = new HashMap();
		

		// It is necessary to create a new Map in order to have the name of the variables 
		// in String
		for(Iterator i = self.targetElements.keySet().iterator() ; i.hasNext() ; ) {
			Object name = i.next();
			map.put(new ASMString(name.toString()), self.targetElements.get(name));
		}
		
		
		return new ASMMap(map);
	}

	private Map sourceElements = new HashMap();
	private Map targetElements = new HashMap();
	private List targetElementsList = new ArrayList();
	private Map variables = new HashMap();
	private ASMOclAny rule;
}

