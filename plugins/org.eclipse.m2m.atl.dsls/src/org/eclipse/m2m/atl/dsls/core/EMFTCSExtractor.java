/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.dsls.core;

import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.dsls.tcs.extractor.ModelAdapter;
import org.eclipse.m2m.atl.dsls.tcs.extractor.PrettyPrinter;

/**
 * A wrapper which allow to generate text from {@link IModel} with TCS.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class EMFTCSExtractor {

	private static Map parameterTypes = new HashMap();

	static {
		parameterTypes.put("format", "Model:TCS"); // required
		parameterTypes.put("indentString", "String"); // optional, default = "  "
		parameterTypes.put("standardSeparator", "String"); // optional, default = " "
		parameterTypes.put("kwCheckIgnoreCase", "String"); // optional, default = false
		parameterTypes.put("identEsc", "String"); // optional, default = "\"", has priority over the two
													// others below
		parameterTypes.put("identEscStart", "String"); // optional, default = "\""
		parameterTypes.put("identEscEnd", "String"); // optional, default = "\""
		parameterTypes.put("stringDelim", "String"); // optional, default = "\'"
		parameterTypes.put("debug", "String"); // optional, default = false
		parameterTypes.put("debugws", "String"); // optional, default = false
		parameterTypes.put("serializeComments", "String"); // optional, default = true
		parameterTypes.put("usePrimitiveTemplates", "String"); // optional, default = false
		parameterTypes.put("decimalFormat", "String"); // optional, default = "0.##############"
		parameterTypes.put("stream", "TCSExtractorStream");// optional, default = new
															// TCSExtractorPrintStream(target);
	}

	public Map getParameterTypes() {
		return parameterTypes;
	}

	public String getPrefix() {
		return "ebnf";
	}

	public EMFTCSExtractor() {
		super();
	}

	public void extract(EMFModel source, OutputStream target, Map params) {
		new PrettyPrinter().prettyPrint(source, new EMFExtractorAdapter(), target, params);
	}

	public class EMFExtractorAdapter implements ModelAdapter {

		public Object get(Object modelElement, String name) {
			if (modelElement == null) {
				return null;
			} else {
				EObject eo = (EObject)modelElement;
				EStructuralFeature sf = eo.eClass().getEStructuralFeature(name);
				if (sf == null) {
					return null;
				}
				return eo.eGet(sf);
			}
		}

		public boolean getBool(Object me, String propName) {
			boolean ret = false;
			try {
				ret = ((Boolean)get(me, propName)).booleanValue();
			} catch (Exception e) {
				throw new RuntimeException("could not read property \"" + propName + "\" of element " + me
						+ " : " + getTypeName(me), e);
			}
			return ret;
		}

		public boolean getBoolUndefinedIsFalse(Object me, String propName) {
			boolean ret = false;
			Object v = get(me, propName);
			if (v instanceof Boolean)
				ret = ((Boolean)v).booleanValue();

			return ret;
		}

		public Iterator getCol(Object me, String propName) {
			return ((Collection)get(me, propName)).iterator();
		}

		public Set getElementsByType(Object model, String typeName) {
			EMFReferenceModel metamodel = ((EMFModel)model).getReferenceModel();
			return ((EMFModel)model).getElementsByType(metamodel.getMetaElementByName(typeName));
		}

		public int getInt(Object me, String propName) {
			return ((Integer)get(me, propName)).intValue();
		}

		public Object getME(Object me, String propName) {
			return get(me, propName);
		}

		public Object getMetaobject(Object me) {
			return ((EObject)me).eClass();
		}

		public String getString(Object me, String propName) {
			String ret = null;
			Object v = get(me, propName);

			if (v != null) {
				if ((v instanceof Collection) && (((Collection)v).size() == 1)) {
					v = ((Collection)v).iterator().next();
				}

				if (v instanceof String) {
					ret = (String)v;
				} else if (v instanceof EEnumLiteral) {
					ret = ((EEnumLiteral)v).getName();
				}
			}

			return ret;
		}

		public String getTypeName(Object me) {
			return getName(((EObject)me).eClass());
		}

		public String getName(Object ame) {
			return getString(ame, "name");
		}

		public Object refImmediateComposite(Object me) {
			return ((EObject)me).eContainer();
		}

		public boolean isAModelElement(Object o) {
			return (o instanceof EObject);
		}

		public Object getPropertyType(Object f, String propName) {
			Object res = get(f, propName);
			if (res instanceof EObject) {
				return get(res, "eType");
			}
			return null;
		}

		public boolean isPrimitive(Object value) {
			return ((value instanceof String) || (value instanceof Boolean) || (value instanceof Double) || (value instanceof Integer));
		}

		public boolean isEnumLiteral(Object value) {
			return (value instanceof EEnumLiteral);
		}

		public String getEnumLiteralName(Object me) {
			return getName(me).toString();
		}

		public String nextString(Iterator i) {
			return i.next().toString();
		}

	}

}
