/*******************************************************************************
 * Copyright (c) 2004 INRIA and C-S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *    Christophe Le Camus (C-S) - initial API and implementation
 *    Sebastien Gabel (C-S) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.drivers.uml24atl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModelElement;
import org.eclipse.m2m.atl.engine.vm.ClassNativeOperation;
import org.eclipse.m2m.atl.engine.vm.StackFrame;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclUndefined;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMString;

/**
 * The UMLspecific implementation for {@link ASMModelElement}.
 *
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 * @author <a href="mailto:christophe.le-camus@c-s.fr">Christophe Le Camus</a>
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien Gabel</a>
 */
public class ASMUMLModelElement extends ASMEMFModelElement {

	/**
	 * Creates a new {@link ASMUMLModelElement}.
	 * 
	 * @param modelElements
	 *            the model elements map
	 * @param model
	 *            the model
	 * @param object
	 *            the {@link EObject}
	 */
	protected ASMUMLModelElement(Map modelElements, ASMModel model, EObject object) {
		super(modelElements, model, object);
	}

	/**
	 * Registers MOF operations.
	 * 
	 * @param modelelementName
	 *            the model element name
	 * @param methodName
	 *            the method name
	 * @param args
	 *            the method arguments types
	 * @throws Exception
	 */
	protected static void registerMOFOperation(String modelelementName, String methodName, Class[] args)
			throws Exception {
		List realArgs = new ArrayList(Arrays.asList(args));
		// second argument of inherited method from ASMEMFModelElement
		// is of type ASMEMFModelElement !
		realArgs.add(0, ASMEMFModelElement.class);
		realArgs.add(0, StackFrame.class);
		ClassNativeOperation no = new ClassNativeOperation(ASMUMLModelElement.class.getMethod(methodName,
				(Class[])realArgs.toArray(args)));
		// operation registerMOFOperation has been redefined here only
		// because following line is specific : ASMUMLModel.getMOF().
		ASMModelElement amme = ASMUMLModel.getMOF().findModelElement(modelelementName);
		amme.registerVMOperation(no);
	}

	/*
	 * For UML, Mof meta model is redefined (using UML2 handler), so we have to renew creation of EClass and
	 * registration of mof operations.
	 */
	static {
		try {
			// Force creation of MOF!EClass before any other (otherwise
			// MOF!Classifier gets created twice)
			ASMUMLModel.getMOF().findModelElement("EClass");

			// Operations on MOF!Classifier
			// TODO on EClassifier after having added supertypes
			registerMOFOperation("EClass", "allInstances", new Class[] {});
			registerMOFOperation("EClass", "allInstancesFrom", new Class[] {ASMString.class});
			registerMOFOperation("EClassifier", "newInstance", new Class[] {});
			registerMOFOperation("EClassifier", "newInstanceIn", new Class[] {ASMString.class});
			registerMOFOperation("EClassifier", "getInstanceById", new Class[] {ASMString.class,
					ASMString.class,});

		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	/**
	 * Creates a new instance of the given type.
	 * 
	 * @param frame
	 *            the frame context
	 * @param self
	 *            the type
	 * @return the new instance
	 */
	public static ASMModelElement newInstance(StackFrame frame, ASMUMLModelElement self) {
		ASMModelElement ret = null;
		if (self.object.eClass().getName().equals("EClass")) {
			for (Iterator j = frame.getExecEnv().getModels().values().iterator(); j.hasNext();) {
				ASMModel model = (ASMModel)j.next();
				if (model.getMetamodel().equals(self.getModel()) && model.isTarget()) {
					ret = model.newModelElement(self);
					break;
				}
			}
		}
		return ret;
	}

	/**
	 * Creates a new instance of a given type.
	 * 
	 * @param frame
	 *            the frame context
	 * @param self
	 *            the given type
	 * @param modelName
	 *            the model where to create the element
	 * @return the new element
	 */
	public static ASMModelElement newInstanceIn(StackFrame frame, ASMUMLModelElement self, ASMString modelName) {
		ASMModelElement ret = null;
		if (self.object.eClass().getName().equals("EClass")) {
			for (Iterator j = frame.getExecEnv().getModels().values().iterator(); j.hasNext();) {
				ASMModel model = (ASMModel)j.next();
				if (model.isTarget() && model.getName().equals(modelName.cString())) {
					return model.newModelElement(self);
				}
			}
		}
		return ret;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param frame
	 *            the environment
	 * @param opName the name of the operation to invoke or delay
	 * @param arguments
	 *            arguments of the method
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModelElement#invoke(org.eclipse.m2m.atl.engine.vm.StackFrame,
	 *      java.lang.String, java.util.List)
	 */
	public ASMOclAny invoke(StackFrame frame, String opName, List arguments) {
		// Do not delayed these methods
		// opName.equals("hasValue")
		// opName.equals("getValue") ||
		// opName.equals("getAppliedStereotype")
		// opName.equals("getAppliedStereotypes")
		// opName.equals("getApplicableStereotype")
		// opName.equals("isStereotypeApplicable")
		// opName.equals("isStereotypeRequired")
		// opName.equals("isStereotypeApplied")

		if (opName.equals("applyProfile") || opName.equals("applyStereotype") || opName.equals("setValue")
				|| opName.equals("applyAllRequiredStereotypes") || opName.equals("applyAllStereotypes")
				|| opName.equals("unapplyAllStereotype")
				|| opName.equals("unapplyAllNonApplicableStereotypes")) {
			((ASMUMLModel)getModel()).addDelayedInvocation(new Invocation(frame, this, opName, arguments));
			return new ASMOclUndefined();
		} else {
			return realInvoke(frame, opName, arguments);
		}
	}

	// TODO GB: This method didn't exist in class ASMUMLModelElement before
	// refactoring, perhaps is it superfluous ?
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModelElement#invokeSuper(org.eclipse.m2m.atl.engine.vm.StackFrame,
	 *      java.lang.String, java.util.List)
	 */
	public ASMOclAny invokeSuper(StackFrame frame, String opName, List arguments) {
		// Do not delayed these methods
		// opName.equals("hasValue")
		// opName.equals("getValue") ||
		// opName.equals("getAppliedStereotype")
		// opName.equals("getAppliedStereotypes")
		// opName.equals("getApplicableStereotype")
		// opName.equals("isStereotypeApplicable")
		// opName.equals("isStereotypeRequired")
		// opName.equals("isStereotypeApplied")

		if (opName.equals("applyProfile") || opName.equals("applyStereotype") || opName.equals("setValue")
				|| opName.equals("applyAllRequiredStereotypes") || opName.equals("applyAllStereotypes")
				|| opName.equals("unapplyAllStereotype")
				|| opName.equals("unapplyAllNonApplicableStereotypes")) {
			((ASMUMLModel)getModel()).addDelayedInvocation(new Invocation(frame, this, opName, arguments));
			return new ASMOclUndefined();
		} else {
			return super.invokeSuper(frame, opName, arguments);
		}
	}

	/**
	 * Immediate invocation of the operation.
	 * 
	 * @param frame
	 *            the environment
	 * @param opName
	 *            the name of the operation to invoke
	 * @param arguments
	 *            the arguments of the operation
	 * @return ASMOclAny
	 */
	public ASMOclAny realInvoke(StackFrame frame, String opName, List arguments) {
		return super.invoke(frame, opName, arguments);
	}

}
