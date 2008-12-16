/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *     Dennis Wagelaar (Vrije Universiteit Brussel)
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm.nativelib;

import java.util.Set;

import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * An ASMModel represents a model.
 * This is an abstraction layer for concrete model handlers such as EMF or MDR.
 * At the present time, there is no separate class for metamodels.
 * Therefore some of the methods of ASMModel only apply to metamodels.
 * TODO (for this class and ASMModelElement): separate metamodel-specific in
 * ASMMetamodel and rename some methods.
 *
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public abstract class ASMModel extends ASMOclAny {

	private ModelLoader ml;
	
	public ModelLoader getModelLoader() {
		return ml;
	}
	
	public static ASMOclType myType = new ASMOclSimpleType("Model", getOclAnyType());
	public ASMModel(String name, ASMModel metamodel, boolean isTarget, ModelLoader ml) {
		super(myType);
		this.name = name;
		this.ml = ml;
		if(metamodel == null) {
			this.metamodel = this;
		} else {
			this.metamodel = metamodel;
		}
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
			String msg = "No type named '" + typeName + "' in metamodel '" + metamodel.name + "'";
			if(frame == null) {
				ATLLogger.severe(msg);
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

	public boolean isTarget() {
		return isTarget;
	}

	public void setIsTarget(boolean isTarget) {
		this.isTarget = isTarget;
	}

	//TODO why re-implement get/set?
//	public ASMOclAny get(StackFrame frame, String name) {
//		logger.severe("ERROR !!!!!");
//		return null;
//	}
//
//	public void set(StackFrame frame, String name, ASMOclAny value) {
//		logger.severe("ERROR !!!!!");
//	}

	private String name;
	private ASMModel metamodel;
	private boolean isTarget;

}

