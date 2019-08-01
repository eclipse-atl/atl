/**
 * Copyright (c) 2004, 2008 INRIA.
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
package org.eclipse.m2m.atl.drivers.emf4atl.tcs.injector;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.m2m.atl.dsls.tcs.injector.ModelAdapter;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMBoolean;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMCollection;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMEnumLiteral;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMInteger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMReal;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMSequence;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMString;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 */
public class ASMModelAdapter implements ModelAdapter {
	
	private ASMModel model;
	
	public ASMModelAdapter(Object model) {
		this.model = (ASMModel)model;
	}

	public Object getModel() {
		return this.model;
	}
	
	private void actualSet(Object ame_, String propertyName, Object value) {
		ASMModelElement ame = (ASMModelElement)ame_;
		ame.set(null, propertyName, (ASMOclAny)value);
	}

	public Object get(Object ame_, String propertyName) {
		Object ret = null;
		
		ASMModelElement ame = (ASMModelElement)ame_;
		
		ret = ame.get(null, propertyName);		// TODO: adapt get
		
		 if(ret instanceof ASMInteger) {
			ret = new Integer(((ASMInteger)ret).getSymbol());
		} else if(ret instanceof ASMReal) {
			ret = new Double(((ASMReal)ret).getSymbol());
		} else if(ret instanceof ASMBoolean) {
			ret = (((ASMBoolean)ret).getSymbol() ? Boolean.TRUE : Boolean.FALSE);
		} else if(ret instanceof ASMString) {
			ret = ((ASMString)ret).getSymbol();
		} 
		
		return ret;
	}

	public Object createElement(String typeName) {
		ASMModelElement ret = null;

		ret = model.newModelElement(typeName);

		return ret;
	}

	public Set getElementsByType(String typeName) {	// TODO: adapt getElementsByType
		ASMModelElement valueType = model.getMetamodel().findModelElement(typeName);
		return model.getElementsByType(valueType);
	}

	public void set(Object ame, String prop, Object value) {
		ASMOclAny v = java2asm(value);
		if(v != null)
			actualSet(ame, prop, v);
	}
	
	private ASMOclAny java2asm(Object value) {
		ASMOclAny ret = null;

		if(value instanceof ASMModelElement) {
			ret = (ASMModelElement)value;
		} else if(value instanceof ASMEnumLiteral) {
			ret = (ASMEnumLiteral)value;
		} else if(value instanceof ASMCollection) {
			ret = (ASMCollection)value;
		} else if(value instanceof Collection) {
			ASMSequence seq = new ASMSequence();
			for(Iterator i = ((Collection)value).iterator() ; i.hasNext() ; ) {
				seq.add(java2asm(i.next()));
			}
			ret = seq;
		} else if(value instanceof Integer) {
			ret = new ASMInteger(((Integer)value).intValue());
		} else if(value instanceof Double) {
			ret = new ASMReal(((Double)value).doubleValue());
		} else if(value instanceof Boolean) {
			ret = new ASMBoolean(((Boolean)value).booleanValue());
		} else if(value instanceof String) {
			ret = new ASMString((String)value);
		} else if(value == null) {
		} else {
			//model.reportProblem("Error", "unsupported type " + value.getClass(), "?");
		}
		
		return ret;
	}
	
	public boolean isCandidate(Object ame, String typeName) {
		boolean ret = false;
		
		ASMModelElement valueType = model.getMetamodel().findModelElement(typeName);
		ret = ((ASMModelElement)ame).getType().conformsTo(valueType).getSymbol();

		return ret;
	}

	public Object getType(Object me_) {
		return ((ASMModelElement)me_).getType();
	}
	
	public boolean isAModelElement(Object me) {
		return (me instanceof ASMModelElement);
	}
	
	public String getString(Object ame, String propName) {
		return ((ASMString)get(ame, propName)).getSymbol();
	}	
	
	public Object createEnumLiteral(String name) {
		ASMEnumLiteral ret = new ASMEnumLiteral(name);
		return ret;
	}
}