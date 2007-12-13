/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frédéric Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm.nativelib;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.m2m.atl.engine.vm.ASMEmitter;

/**
 * Native Objects that can be created using "new" by VM code.
 * @author Frédéric Jouault
 */
public abstract class ASMNativeObject {

	protected static Map nativeImpl = new HashMap();
	static {
		nativeImpl.put("ASMEmitter", ASMEmitter.class);
		nativeImpl.put("Bag", ASMBag.class);
//		nativeImpl.put("Boolean", ASMBoolean.class);		// primitive
//		nativeImpl.put("Collection", ASMCollection.class);	// abstract
//		nativeImpl.put("Integer", ASMInteger.class);		// primitive
//		nativeImpl.put("Real", ASMInteger.class);		// primitive
		nativeImpl.put("EnumLiteral", ASMEnumLiteral.class);
		nativeImpl.put("Map", ASMMap.class);
//		nativeImpl.put("OclAny", ASMOclAny.class);			// abstract
		nativeImpl.put("OclParametrizedType", ASMOclParametrizedType.class);
		nativeImpl.put("OclSimpleType", ASMOclSimpleType.class);
// 		nativeImpl.put("OclType", ASMOclType.class);
		nativeImpl.put("OclUndefined", ASMOclUndefined.class);
		nativeImpl.put("OrderedSet", ASMOrderedSet.class);
		nativeImpl.put("Sequence", ASMSequence.class);
		nativeImpl.put("Set", ASMSet.class);
//		nativeImpl.put("String", ASMString.class);			// primitive
		nativeImpl.put("TransientLink", ASMTransientLink.class);
		nativeImpl.put("TransientLinkSet", ASMTransientLinkSet.class);
		nativeImpl.put("Tuple", ASMTuple.class);
		nativeImpl.put("TupleType", ASMTupleType.class);
	}

	public static Class getNativeImpl(String name) {
		return (Class)nativeImpl.get(name);
	}
}

