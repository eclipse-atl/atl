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
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
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

	private Map sourceElements = new HashMap();
	private Map targetElements = new HashMap();
	private List targetElementsList = new ArrayList();
	private Map variables = new HashMap();
	private ASMOclAny rule;
}

