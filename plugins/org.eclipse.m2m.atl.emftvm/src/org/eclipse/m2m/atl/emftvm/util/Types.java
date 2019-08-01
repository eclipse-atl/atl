/*******************************************************************************
 * Copyright (c) 2011 Dennis Wagelaar, Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.trace.TracePackage;
import org.eclipse.m2m.atl.emftvm.util.NativeTypes.NativeType;

/**
 * Contains EMFTVM type definitions.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public final class Types {

	/**
	 * The OCL metamodel namespace.
	 */
	public static final String OCL_MODEL = EMFTVMUtil.NATIVE;
	/**
	 * The Ecore metamodel namespace.
	 */
	public static final String ECORE_MODEL = EcorePackage.eNAME.toUpperCase();
	/**
	 * The EMFTVM metamodel namespace.
	 */
	public static final String EMFTVM_MODEL = EmftvmPackage.eNAME.toUpperCase();
	/**
	 * The TRACE metamodel namespace.
	 */
	public static final String TRACE_MODEL = TracePackage.eNAME.toUpperCase();
	/** The OclAny type. */
	public static final String[] OCL_ANY_TYPE			= new String[]{OCL_MODEL, NativeType.OBJECT.getName()};
	/** The Boolean type. */
	public static final String[] BOOLEAN_TYPE			= new String[]{OCL_MODEL, NativeType.BOOLEAN.getName()};
	/** The Real type. */
	public static final String[] REAL_TYPE				= new String[]{OCL_MODEL, NativeType.REAL.getName()};
	/** The Integer type. */
	public static final String[] INTEGER_TYPE			= new String[]{OCL_MODEL, NativeType.INTEGER.getName()};
	/** The String type. */
	public static final String[] STRING_TYPE			= new String[]{OCL_MODEL, NativeType.STRING.getName()};
	/** The Java Class type. */
	public static final String[] JAVA_CLASS_TYPE		= new String[]{OCL_MODEL, "java.lang.Class"};
	/** The Java Collection type. */
	public static final String[] JAVA_COLLECTION_TYPE	= new String[]{OCL_MODEL, "java.util.Collection"};
	/** The Java List type. */
	public static final String[] JAVA_LIST_TYPE			= new String[]{OCL_MODEL, "java.util.List"};
	/** The Java Date type. */
	public static final String[] JAVA_DATE_TYPE			= new String[]{OCL_MODEL, "java.util.Date"};
	/** The Collection type. */
	public static final String[] COLLECTION_TYPE 		= new String[]{OCL_MODEL, NativeType.COLLECTION.getName()};
	/** The Bag type. */
	public static final String[] BAG_TYPE 				= new String[]{OCL_MODEL, NativeType.BAG.getName()};
	/** The Sequence type. */
	public static final String[] SEQUENCE_TYPE 			= new String[]{OCL_MODEL, NativeType.SEQUENCE.getName()};
	/** The Set type. */
	public static final String[] SET_TYPE 				= new String[]{OCL_MODEL, NativeType.SET.getName()};
	/** The OrderedSet type. */
	public static final String[] ORDERED_SET_TYPE 		= new String[]{OCL_MODEL, NativeType.ORDERED_SET.getName()};
	/** The Map type. */
	public static final String[] MAP_TYPE				= new String[]{OCL_MODEL, NativeType.MAP.getName()};
	/** The Tuple type. */
	public static final String[] TUPLE_TYPE				= new String[]{OCL_MODEL, NativeType.TUPLE.getName()};
	/** The Ecore EClassifier type. */
	public static final String[] CLASSIFIER_TYPE 		= new String[]{ECORE_MODEL, "EClassifier"};
	/** The Ecore EClass type. */
	public static final String[] CLASS_TYPE 			= new String[]{ECORE_MODEL, "EClass"};
	/** The 'EMFTVM!ExecEnv' type. */
	public static final String[] EXEC_ENV_TYPE 			= new String[]{EMFTVM_MODEL, "ExecEnv"};
	/** The 'TRACE!TraceLinkSet' type. */
	public static final String[] TRACE_LINK_SET_TYPE 	= new String[]{TRACE_MODEL, "TraceLinkSet"};

}
