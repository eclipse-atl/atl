/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm.nativelib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.m2m.atl.engine.vm.ASM;
import org.eclipse.m2m.atl.engine.vm.ASMEmitter;
import org.eclipse.m2m.atl.engine.vm.ASMExecEnv;
import org.eclipse.m2m.atl.engine.vm.ASMOperation;
import org.eclipse.m2m.atl.engine.vm.ASMStackFrame;
import org.eclipse.m2m.atl.engine.vm.NativeOperation;
import org.eclipse.m2m.atl.engine.vm.NativeStackFrame;
import org.eclipse.m2m.atl.engine.vm.Operation;
import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public abstract class ASMOclType extends ASMOclAny {

	public static ASMOclType myType = new ASMOclSimpleType("OclType");

	private static Map typeOperations;

	public static Map getVMOperations() {
		if (typeOperations == null) {
			typeOperations = new HashMap();
			NativeOperation.registerOperations(ASMOclType.myType, ASMOclType.class);
			myType.setType(myType);
			NativeOperation.registerOperations(ASMOclType.myType, ASMOclSimpleType.class);

			NativeOperation.registerOperations(ASMTupleType.myType, ASMTupleType.class);
			NativeOperation.registerOperations(ASMTuple.myType, ASMTuple.class);
			NativeOperation.registerOperations(ASMModule.myType, ASMModule.class);
			NativeOperation.registerOperations(ASMTransientLinkSet.myType, ASMTransientLinkSet.class);
			NativeOperation.registerOperations(ASMTransientLink.myType, ASMTransientLink.class);
			NativeOperation.registerOperations(ASMString.myType, ASMString.class);
			NativeOperation.registerOperations(ASMSet.myType, ASMSet.class);
			NativeOperation.registerOperations(ASMSequence.myType, ASMSequence.class);
			NativeOperation.registerOperations(ASMNumber.myType, ASMReal.class);
			NativeOperation.registerOperations(ASMOclUndefined.myType, ASMOclUndefined.class);
			NativeOperation.registerOperations(ASMOclParametrizedType.myType, ASMOclParametrizedType.class);
			NativeOperation.registerOperations(getOclAnyType(), ASMOclAny.class);
			NativeOperation.registerOperations(ASMMap.myType, ASMMap.class);
			NativeOperation.registerOperations(ASMInteger.myType, ASMInteger.class);
			NativeOperation.registerOperations(ASMEnumLiteral.myType, ASMEnumLiteral.class);
			NativeOperation.registerOperations(ASMCollection.myType, ASMCollection.class);
			NativeOperation.registerOperations(ASMBoolean.myType, ASMBoolean.class);
			NativeOperation.registerOperations(ASMBag.myType, ASMBag.class);
			NativeOperation.registerOperations(ASMOrderedSet.myType, ASMOrderedSet.class);

			NativeOperation.registerOperations(ASMEmitter.myType, ASMEmitter.class, false, true, true, true);
			// TODO BUG? NativeOperation.registerOperations(ASM.myType, ASMEmitter.class, false, true, true,
			// true);
			NativeOperation.registerOperations(ASM.myType, ASM.class, false, true, true, true);
			NativeOperation.registerOperations(ASMStackFrame.myType, ASMStackFrame.class, false, true, true,
					true);
			NativeOperation.registerOperations(NativeStackFrame.myType, NativeStackFrame.class, false, true,
					true, true);
			NativeOperation.registerOperations(StackFrame.myType, StackFrame.class, false, true, true, true);
			NativeOperation.registerOperations(Operation.myType, Operation.class, false, true, true, true);
			NativeOperation.registerOperations(ASMOperation.myType, ASMOperation.class, false, true, true,
					true);
		}
		return typeOperations;
	}

	public ASMOclType(ASMOclType type) {
		super(type);
		supertypes = new ArrayList();
	}

	private static Map getVMOperations(ASMOclType type) {
		Map ret = (Map)getVMOperations().get(type);

		if (ret == null) {
			ret = new HashMap();
			getVMOperations().put(type, ret);
		}

		return ret;
	}

	// Only for VM operations
	public void registerVMOperation(Operation op) {
		getVMOperations(this).put(op.getName(), op);
	}

	public void addSupertype(ASMOclType supertype) {
		if (supertype != null) {
			supertypes.add(0, supertype);
		}
	}

	public List getSupertypes() {
		return supertypes;
	}

	public abstract ASMBoolean conformsTo(ASMOclType other);

	public abstract String getName();

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny#get(org.eclipse.m2m.atl.engine.vm.StackFrame, java.lang.String)
	 */
	public ASMOclAny get(StackFrame frame, String name) {
		ASMOclAny ret = null;

		if (name.equals("name")) {
			ret = getName(frame, this);
		} else if (name.equals("operations")) {
			ret = new ASMSet(((ASMExecEnv)frame.getExecEnv()).getOperations(this));
		} else if (name.equals("supertypes")) {
			ret = new ASMSet(supertypes);
		} else {
			ret = super.get(frame, name);
		}

		return ret;
	}

	// Native Operations below

	public static ASMString getName(StackFrame frame, ASMOclType self) {
		return new ASMString(self.getName());
	}

	public static ASMBoolean conformsTo(StackFrame frame, ASMOclType self, ASMOclType other) {
		return self.conformsTo(other);
	}

	public static void registerHelperAttribute(StackFrame frame, ASMOclType self, ASMString name,
			ASMString initOperationName) {
		ASMExecEnv aee = (ASMExecEnv)frame.getExecEnv();
		aee.registerAttributeHelper(self, name.getSymbol(), aee.getOperation(self, initOperationName
				.getSymbol()));
	}

	// persistTo may be OclUndefined for non-persistent weaving helpers, otherwise it must be a String
	public static void registerWeavingHelper(StackFrame frame, ASMOclType self, ASMString name,
			ASMOclAny persistTo) {
		ASMExecEnv aee = (ASMExecEnv)frame.getExecEnv();
		aee.registerWeavingHelper(self, name.getSymbol(), (persistTo instanceof ASMOclUndefined) ? null
				: ((ASMString)persistTo).getSymbol());
	}

	private List supertypes;
}
