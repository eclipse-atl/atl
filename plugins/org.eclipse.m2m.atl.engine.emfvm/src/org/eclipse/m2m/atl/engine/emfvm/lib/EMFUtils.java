/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frédéric Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm.lib;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class EMFUtils {
	
	// TODO: map this to allowInterModelReferences option
	private static final boolean allowInterModelReferences = false;

	public static Object get(StackFrame frame, EObject eo, String name) {
		Object ret = null;
		
		EClass ec = eo.eClass();
		try {
			if("__xmiID__".equals(name)) {
				ret = frame.execEnv.getModelOf(eo).resource.getURIFragment(eo);
			} else {
				EStructuralFeature sf = ec.getEStructuralFeature(name);
				Object val = eo.eGet(sf);
				if(val == null) val = OclUndefined.SINGLETON;
				ret = val;
			}
		} catch(Exception e) {
			throw new VMException(frame, "error accessing " + ec + "." + name);
		}

		return ret;
	}

	// TODO:
	//	- EEnumliteral implementation
	//		- could be different (faster?) when same metamodel in source and target
	//		- may be too permissive (any value for which toString returns a valid literal name works) 
	//	- should flatten nested collections
	public static void set(StackFrame frame, EObject eo, String name, Object value) {
		EStructuralFeature feature = eo.eClass().getEStructuralFeature(name);
		
		// makes it possible to use an integer to set a floating point property  
		if(value instanceof Integer) {
			String targetType = feature.getEType().getInstanceClassName();
			if("java.lang.Double".equals(targetType) || "java.lang.Float".equals(targetType)) {
				value = new Double(((Integer)value).doubleValue());
			}
		}
		
		EClassifier type = feature.getEType();
		boolean targetIsEnum = type instanceof EEnum;
		try {
			Object oldValue = eo.eGet(feature);
			if(oldValue instanceof Collection) {
				Collection oldCol = (Collection)oldValue;
				if(value instanceof Collection) {
					if(targetIsEnum) {
						EEnum eenum = (EEnum)type;
						for(Iterator i = ((Collection)value).iterator() ; i.hasNext() ; ) {
							Object v = i.next();
							oldCol.add(eenum.getEEnumLiteral(v.toString()).getInstance());							
						}
					} else if(allowInterModelReferences) {
						oldCol.addAll((Collection)value);
					} else {	// !allowIntermodelReferences
						for(Iterator i = ((Collection)value).iterator() ; i.hasNext() ; ) {
							Object v = i.next();
							if(v instanceof EObject) {
								if(frame.execEnv.getModelOf(eo) == frame.execEnv.getModelOf((EObject)v))
									oldCol.add(v);
							} else {
								oldCol.add(v);								
							}
						}
					}
				} else {
					if(targetIsEnum) {
						EEnum eenum = (EEnum)type;
						oldCol.add(eenum.getEEnumLiteral(value.toString()).getInstance());							
					} else if(allowInterModelReferences || !(value instanceof EObject)) {
						oldCol.add(value);
					} else {	// (!allowIntermodelReferences) && (value intanceof EObject)
						if(frame.execEnv.getModelOf(eo) == frame.execEnv.getModelOf((EObject)value))
							oldCol.add(value);
					}
				}
			} else {
				if(value instanceof Collection) {
					frame.execEnv.out.println("Warning: assigning a Collection to a single-valued feature");
					Collection c = (Collection)value;
					if(!c.isEmpty()) {
						value = c.iterator().next();
					} else {
						value = null;
					}
				}
				if(targetIsEnum) {
					EEnum eenum = (EEnum)type;
					eo.eSet(feature, eenum.getEEnumLiteral(value.toString()).getInstance());							
				} else if(allowInterModelReferences || !(value instanceof EObject)) {
					eo.eSet(feature, value);
				} else {	// (!allowIntermodelReferences) && (value intanceof EObject)
					if(frame.execEnv.getModelOf(eo) == frame.execEnv.getModelOf((EObject)value))
						eo.eSet(feature, value);
				}
			}
		} catch(Exception e) {
			// TODO: implement a better mechanism than println for warnings
			frame.execEnv.out.println("Warning: could not assign " + value + " to " + frame.execEnv.toPrettyPrintedString(eo) + "." + name);
		}
	}
	
	public static void delete(StackFrame frame, EObject eo) {
		EObject container = eo.eContainer();
		container.eContents().remove(eo);
	}
	
}
