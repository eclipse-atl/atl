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
import java.util.Iterator;
import java.util.Map;

import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * Prototype ASMModelElement using HashMaps for storage.
 * It has not been updated for a long time and may not work without
 * some improvements.
 * @author Frédéric Jouault
 * @deprecated
 */
public class ASMHashModelElement extends ASMModelElement {

	public ASMHashModelElement(ASMModel model, ASMModelElement metaobject) {
		super(model, metaobject);
	}

	public ASMOclAny get(StackFrame frame, String name) {
		ASMOclAny ret = (ASMOclAny)slots.get(name);
		return ret;
	}

	public void set(StackFrame frame, String name, ASMOclAny value) {
		super.set(frame, name, value);
		boolean isAsso = true;

		ASMModelElement feature = getMetaobject().getAcquaintance(name);

		if(feature == null) {
			feature = lookupElementExtended(frame, getMetaobject(), new ASMString(name));
			isAsso = false;
		}

		realSet(frame, feature, name, value);
		if(isAsso) {
			ASMModelElement otherEnd = otherEnd(frame, feature);
			String otherName = ((ASMString)otherEnd.get(frame, "name")).getSymbol();
			if(value instanceof ASMHashModelElement) {
				((ASMHashModelElement)value).realSet(frame, otherEnd, otherName, this);
			} else {
				for(Iterator i = ((ASMCollection)value).iterator() ; i.hasNext() ; ) {
					((ASMHashModelElement)i.next()).realSet(frame, otherEnd, otherName, this);
				}
			}
		}
	}

	private void realSet(StackFrame frame, ASMModelElement feature, String name, ASMOclAny value) {
		int upper = ((ASMInteger)feature.get(frame, "multiplicity").get(frame, "upper")).getSymbol();
//System.out.println("Setting " + feature + "[" + upper + "] to " + value + " on " + this + " : " + this.getMetaobject());
		if(upper == 1) {
			slots.put(name, value);
		} else {
			ASMSequence c = (ASMSequence)slots.get(name);
			if(c == null) {
				c = new ASMSequence();
				slots.put(name, c);
			}
			if(value instanceof ASMCollection) {
				c.add(((ASMCollection)value).iterator());
			} else {
				c.add(value);
			}
		}
	}

	// only for metamodels...? ... Classifiers
	public ASMBoolean conformsTo(ASMOclType other) {
		return null;
	}

	private Map slots = new HashMap();

	// only for metamodels...? ... Classifiers
	public ASMModelElement getProperty(String name) {
		return null;
	}

	// only for metamodels...? ... Classifiers
	public ASMModelElement getPropertyType(String name) {
		return null;
	}
}

