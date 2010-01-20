/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *     Obeo - Compiler refactoring
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.asm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.m2m.atl.common.ATLLaunchConstants;

/**
 * This class represents a transformation module, which can have fields.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ASM {

	private String name;

	private String version = ATLLaunchConstants.DEFAULT_COMPILER_VERSION;

	private List fields = new ArrayList();

	private Map fieldsMap = new HashMap();

	private List operations = new ArrayList();

	private Map operationsMap = new HashMap();

	/**
	 * Creates a new ASM.
	 */
	public ASM() {
		super();
	}

	/**
	 * Creates a new ASM with the given name.
	 * 
	 * @param name
	 *            the ASM name
	 */
	public ASM(String name) {
		this();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Add a field.
	 * 
	 * @param f
	 *            the field
	 */
	public void addField(ASMField f) {
		fields.add(f);
		fieldsMap.put(f.getName(), f);
	}

	/**
	 * Returns the existing field with the given name.
	 * 
	 * @param fieldName
	 *            the given name
	 * @return the field
	 */
	public ASMField getField(String fieldName) {
		return (ASMField)fieldsMap.get(fieldName);
	}

	public List getFields() {
		return fields;
	}

	/**
	 * Add an operation.
	 * 
	 * @param o
	 *            the operation
	 */
	public void addOperation(ASMOperation o) {
		operations.add(o);
		operationsMap.put(o.getName(), o);
	}

	/**
	 * Returns the existing operation with the given name.
	 * 
	 * @param operationName
	 *            the given name
	 * @return the operation
	 */
	public ASMOperation getOperation(String operationName) {
		return (ASMOperation)operationsMap.get(operationName);
	}

	public List getOperations() {
		return operations;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersion() {
		return version;
	}
}
