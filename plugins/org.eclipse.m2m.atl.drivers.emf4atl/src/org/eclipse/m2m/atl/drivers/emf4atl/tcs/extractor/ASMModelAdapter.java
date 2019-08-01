/**
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: ASMModelAdapter.java,v 1.1 2009/04/21 14:11:03 wpiers Exp $
 */

package org.eclipse.m2m.atl.drivers.emf4atl.tcs.extractor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.m2m.atl.dsls.tcs.extractor.ModelAdapter;
import org.eclipse.m2m.atl.engine.vm.nativelib.AMN;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMBoolean;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMCollection;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMEnumLiteral;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMInteger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMReal;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMString;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 *
 */
public class ASMModelAdapter implements ModelAdapter {

	public Object get(Object me, String propName) {
		Object ret = AMN.get((ASMModelElement)me, propName);
		
		return asm2java(ret);
	}

	private Object asm2java(Object value) {
		if (value instanceof ASMCollection) {
			Collection newC = new ArrayList();
			for(Iterator i = ((ASMCollection)value).iterator() ; i.hasNext() ; ) {
				newC.add(asm2java(i.next()));
			}
			return newC;
		} else if (value instanceof ASMString) {
			return ((ASMString)value).getSymbol();
		} else if(value instanceof ASMInteger) {
			return new Integer((((ASMInteger)value).getSymbol()));
		} else if(value instanceof ASMReal) {
			return new Double((((ASMReal)value).getSymbol()));
		} else if(value instanceof ASMBoolean) {
			return new Boolean((((ASMBoolean)value).getSymbol()));
		} 
		return value;
	}
	
	public boolean getBool(Object me, String propName) {
		return AMN.getBool((ASMModelElement)me, propName);
	}

	public boolean getBoolUndefinedIsFalse(Object me, String propName) {
		return AMN.getBoolUndefinedIsFalse((ASMModelElement)me, propName);
	}
	
	public Iterator getCol(Object me, String propName) {
		return AMN.getCol((ASMModelElement)me, propName);
	}

	public Set getElementsByType(Object model, String typeName) {
		return ((ASMModel)model).getElementsByType(typeName);
	}

	public int getInt(Object me, String propName) {
		return AMN.getInt((ASMModelElement)me, propName);
	}

	public Object getME(Object me, String propName) {
		return AMN.getME((ASMModelElement)me, propName);
	}

	public Object getMetaobject(Object me) {
		return ((ASMModelElement)me).getMetaobject();
	}

	public String getString(Object me, String propName) {		
		return AMN.getString((ASMModelElement)me, propName);
	}

	public String getTypeName(Object me) {
		return AMN.getTypeName((ASMModelElement)me);
	}

	public Object refImmediateComposite(Object me) {
		return ((ASMModelElement)me).refImmediateComposite();
	}
	
	public boolean isAModelElement(Object o) {
		return (o instanceof ASMModelElement);
	}

	public Object getPropertyType(Object f, String propName) {
		return ((ASMModelElement)f).getPropertyType(propName);
	}

	public String getName(Object me) {
		return this.getString(me, "name");
	}
	
	public boolean isPrimitive(Object value) {
		return ((value instanceof String) ||
				(value instanceof Boolean) ||
				(value instanceof Double) ||
				(value instanceof Integer));
	}

	public boolean isEnumLiteral(Object value) {
		return (value instanceof ASMEnumLiteral);
	}
	
	public String getEnumLiteralName(Object me) {
		return ((ASMEnumLiteral)me).getName();
	}

	public String nextString(Iterator i) {
		return AMN.nextString(i);
	}
}
