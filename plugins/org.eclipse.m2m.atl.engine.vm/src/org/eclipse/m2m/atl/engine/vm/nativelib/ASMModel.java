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

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * An ASMModel represents a model.
 * This is an abstraction layer for concrete model handlers such as EMF or MDR.
 * At the present time, there is no separate class for metamodels.
 * Therefore some of the methods of ASMModel only apply to metamodels.
 * TODO (for this class and ASMModelElement): separate metamodel-specific in
 * ASMMetamodel and rename some methods.
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public abstract class ASMModel extends ASMOclAny {

	private static ASMModel mof = null;
	public static ASMModel getMOF() {
		return mof;
	}

	private ModelLoader ml;
	
	public ModelLoader getModelLoader() {
		return ml;
	}
	
	public static ASMOclType myType = new ASMOclSimpleType("Model", getOclAnyType());
	public ASMModel(String name, ASMModel metamodel, boolean isTarget, ModelLoader ml) {
		super(myType);
		if(name.equals("MOF")) mof = this;
		this.name = name;
		this.ml = ml;
		if(metamodel == null) {
			this.metamodel = this;
		} else {
			this.metamodel = metamodel;
		}
		//this.metamodel.addSubModel(this);
		this.isTarget = isTarget;
	}

	public String toString() {
		return name + " : " + metamodel.name;
	}

	public Set getElementsByType(String typeName) {
		return getElementsByType(getMetamodel().findModelElement(typeName));
	}

	public abstract Set getElementsByType(ASMModelElement type);

	/** Finds a Classifier in a Metamodel. */
	public abstract ASMModelElement findModelElement(String name);

	public ASMModelElement newModelElement(String typeName) {
		return newModelElement(null, typeName);
	}
	
	public ASMModelElement newModelElement(StackFrame frame, String typeName) {
		ASMModelElement type = getMetamodel().findModelElement(typeName);
		if(type == null) {
			String msg = "no type named '" + typeName + "' in metamodel '" + metamodel.name + "'";
			if(frame == null) {
				logger.severe(msg);
//				System.out.println(msg);
			} else {
				frame.printStackTrace(msg);
			}
		}
		return newModelElement(type);
	}

	public abstract ASMModelElement newModelElement(ASMModelElement type);

	public String getName() {
		return name;
	}

	public ASMModel getMetamodel() {
		return metamodel;
	}

	// TODO remove this method
	/**
	 * @deprecated
	 */
	public void addSubModel(ASMModel subModel) {
		//subModels.put(subModel.name, subModel);
	}

	// TODO remove this method
	/**
	 * @deprecated
	 */
	public Map getSubModels() {
		return Collections.EMPTY_MAP;
		//return subModels;
	}
	
	public boolean isTarget() {
		return isTarget;
	}

	public void setIsTarget(boolean isTarget) {
		this.isTarget = isTarget;
	}

	public ASMOclAny get(StackFrame frame, String name) {
		logger.severe("ERROR !!!!!");
//		System.out.println("ERROR !!!!!");
		return null;
	}

	public void set(StackFrame frame, String name, ASMOclAny value) {
		logger.severe("ERROR !!!!!");
//		System.out.println("ERROR !!!!!");
	}

	public void save(String url) throws IOException {
		logger.severe("ERROR: save not implemented !");
//		System.out.println("ERROR: save not implemented !");
	}

	private String name;
	private ASMModel metamodel;
	//private Map subModels = new HashMap();
	private boolean isTarget;

}

