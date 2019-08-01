/*******************************************************************************
 * Copyright (c) 2004 INRIA and C-S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *    Christophe Le Camus (C-S) - initial API and implementation
 *    Sebastien Gabel (C-S) - initial API and implementation
 *    Dennis Wagelaar (Vrije Universiteit Brussel)
 *******************************************************************************/
package org.eclipse.m2m.atl.drivers.uml24atl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement;

/**
 * The UML implementation of ASMModel.
 *
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 * @author <a href="mailto:christophe.le-camus@c-s.fr">Christophe Le Camus</a>
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien Gabel</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public final class ASMUMLModel extends ASMEMFModel {

	private static ASMUMLModel mofmm;

	// mof metamodel shall be unique for each model handler of a given type,
	// but shall be redefined for a model handler that redefined a another model
	// handler.
	// use of static attributes is not advisable !

	private List delayedInvocations = new ArrayList();

	/**
	 * Creates a new {@link ASMUMLModel}.
	 * 
	 * @param name
	 *            the model name
	 * @param extent
	 *            the model's inner resource
	 * @param metamodel
	 *            the metamodel
	 * @param isTarget
	 *            true if the model is an output model
	 * @param ml
	 *            the model loader creating this model
	 */
	protected ASMUMLModel(String name, Resource extent, ASMEMFModel metamodel, boolean isTarget, ModelLoader ml) {
		super(name, extent, metamodel, isTarget, ml);
	}

	/**
	 * Returns the meta-metamodel.
	 * 
	 * @return the meta-metamodel.
	 */
	public static ASMModel getMOF() {
		if (mofmm == null) {
			mofmm = new ASMUMLModel("MOF", EcorePackage.eINSTANCE.eResource(),
					null, false, null);
		}
		return mofmm;
	}

	/**
	 * Creates a new {@link ASMUMLModelElement} for object.
	 * 
	 * @param object The object to wrap.
	 * @return a new {@link ASMUMLModelElement}
	 */
	protected ASMModelElement createASMModelElement(EObject object) {
		return new ASMUMLModelElement(modelElements, this, object);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel#getASMModelElement(org.eclipse.emf.ecore.EObject)
	 */
	public synchronized ASMModelElement getASMModelElement(EObject object) {
		//TODO reinstate double checked locking with final field when switching to Java 5
		ASMModelElement ret = (ASMModelElement)modelElements.get(object);
		if (ret == null) {
			ret = new ASMUMLModelElement(modelElements, this, object);
		}
		return ret;
	}

	/*
	 * // Unsupported Methods needed //
	 */
	/**
	 * Gets the last stereotype method in the delayed invocations list.
	 * 
	 * @param opName
	 *            the operation name
	 * @return the last stereotype method index
	 */
	public int getLastStereotypeMethod(String opName) {
		int rang = 0;
		for (int i = 0; i < delayedInvocations.size(); i++) {
			Invocation invoc = (Invocation)(delayedInvocations.get(rang));
			if (invoc.getOpName().equals(opName)) {
				rang = i;
			}
		}
		return rang;
	}

	/**
	 * Delays an invocation.
	 * 
	 * @param invocation
	 *            the operation invocation to delay
	 */
	public void addDelayedInvocation(Invocation invocation) {
		// Guarantee the applied profiles operations are the first applied
		if (invocation.getOpName().equals("applyProfile")) {
			delayedInvocations.add(0, invocation);
		} else {
			if (invocation.getOpName().equals("applyStereotype")
					|| invocation.getOpName().equals("applyAllStereotypes")
					|| invocation.getOpName().equals("applyAllRequiredStereotypes")) {
				// Guarantee the applied stereotypes operations are applied
				// before setValue and after applyProfile
				int lastApplyProfile = getLastStereotypeMethod("applyProfile");
				if (lastApplyProfile < delayedInvocations.size() - 1) {
					delayedInvocations.add(lastApplyProfile + 1, invocation);
				} else {
					delayedInvocations.add(invocation);
				}
			} else {
				// SetValue operation follow this way
				delayedInvocations.add(invocation);
			}
		}
	}

	/**
	 * Applies all delayed operation invocations.
	 */
	public void applyDelayedInvocations() {

		for (Iterator i = delayedInvocations.iterator(); i.hasNext();) {
			Invocation invocation = (Invocation)i.next();
			invocation.getSelf().realInvoke(invocation.getFrame(), invocation.getOpName(),
					invocation.getArguments());
		}

	}

}
