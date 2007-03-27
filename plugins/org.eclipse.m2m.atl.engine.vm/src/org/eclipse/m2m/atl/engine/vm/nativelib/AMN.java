package org.eclipse.m2m.atl.engine.vm.nativelib;

import java.util.Iterator;

/**
 * ASMModel Navigator helpers
 * 
 * @author jouault
 *
 */
public class AMN {

	public static String getTypeName(ASMModelElement ame) {
		return getName(ame.getMetaobject());
	}

	public static String getName(ASMModelElement ame) {
		return getString(ame, "name");
	}

	public static String getString(ASMModelElement ame, String propName) {
		String ret = null;
		ASMOclAny v = get(ame, propName);
		
		if(v == null) {
			
		} else {
			if((v instanceof ASMCollection) && (((ASMCollection)v).size() == 1)) {
				v = (ASMOclAny)((ASMCollection)v).iterator().next();
			}
			
			if(v instanceof ASMString) {
				ret = ((ASMString)v).getSymbol();
			} else if(v instanceof ASMEnumLiteral) {
				ret = ((ASMEnumLiteral)v).getName();
			}
		}
		
		return ret;
	}

	public static int getInt(ASMModelElement ame, String propName) {
		return ((ASMInteger)get(ame, propName)).getSymbol();
	}

	public static boolean getBool(ASMModelElement ame, String propName) {
		boolean ret = false;
		
		try {
			ret = ((ASMBoolean)get(ame, propName)).getSymbol();
		} catch(Exception e) {
			throw new ASMModelNavigationException("could not read property \"" + propName + "\" of element " + ame + " : " + ame.getType(), e);
		}
		
		return ret;
	}

	public static boolean getBoolUndefinedIsFalse(ASMModelElement ame, String propName) {
		boolean ret = false;
		
		ASMOclAny v = get(ame, propName);
		if(v instanceof ASMBoolean)
			ret = ((ASMBoolean)v).getSymbol();
		
		return ret;
	}

	public static ASMModelElement getME(ASMModelElement ame, String propName) {
		return (ASMModelElement)get(ame, propName);
	}

	public static ASMOclAny get(ASMModelElement ame, String propName) {
		ASMOclAny ret = null;
		try {
			ret = ame.get(null, propName);
		} catch(Exception e) {
			throw new ASMModelNavigationException("could not read property \"" + propName + "\" of element " + ame + ((ame != null) ? " : " + ame.getType() : ""), e);
		}
		return (ret instanceof ASMOclUndefined) ? null : ret;
	}

	public static Iterator getCol(ASMModelElement ame, String propName) {
		return ((ASMCollection)ame.get(null, propName)).iterator();
	}
	
	public static ASMModelElement nextME(Iterator i) {
		return ((ASMModelElement)i.next());
	}
	
	public static String nextString(Iterator i) {
		return ((ASMString)i.next()).getSymbol(); 
	}

	public static boolean isa(ASMModelElement element, String otherName) {
		ASMModelElement type = element.getMetaobject();
		return c2(type, otherName);		
	}

	public static boolean c2(ASMModelElement type, String otherName) {
		return type.conformsTo(type.getModel().findModelElement(otherName)).getSymbol();		
	}
}
