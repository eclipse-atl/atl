/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
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

	private static Map<String, String> parameterTypes = new HashMap<>();

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

	public Map<String, String> getParameterTypes() {
		return parameterTypes;
	}

	public String getPrefix() {
		return "ebnf";
	}

	public EMFTCSExtractor() {
		super();
	}

	public void extract(final EMFModel source, final OutputStream target, final Map<String, ?> params) {
		new PrettyPrinter().prettyPrint(source, new EMFExtractorAdapter(), target, params);
	}

	public class EMFExtractorAdapter implements ModelAdapter {

		@Override
		public Object get(final Object modelElement, final String name) {
			if (modelElement == null) {
				return null;
			} else {
				final EObject eo = (EObject)modelElement;
				final EStructuralFeature sf = eo.eClass().getEStructuralFeature(name);
				if (sf == null) {
					return null;
				}
				return eo.eGet(sf);
			}
		}

		@Override
		public boolean getBool(final Object me, final String propName) {
			boolean ret = false;
			try {
				ret = ((Boolean)get(me, propName)).booleanValue();
			} catch (final Exception e) {
				throw new RuntimeException("could not read property \"" + propName + "\" of element " + me
						+ " : " + getTypeName(me), e);
			}
			return ret;
		}

		@Override
		public boolean getBoolUndefinedIsFalse(final Object me, final String propName) {
			boolean ret = false;
			final Object v = get(me, propName);
			if (v instanceof Boolean)
				ret = ((Boolean)v).booleanValue();

			return ret;
		}

		@Override
		public Iterator<?> getCol(final Object me, final String propName) {
			return ((Collection<?>)get(me, propName)).iterator();
		}

		@Override
		public Set<?> getElementsByType(final Object model, final String typeName) {
			final EMFReferenceModel metamodel = ((EMFModel)model).getReferenceModel();
			return ((EMFModel)model).getElementsByType(metamodel.getMetaElementByName(typeName));
		}

		@Override
		public int getInt(final Object me, final String propName) {
			return ((Integer)get(me, propName)).intValue();
		}

		@Override
		public Object getME(final Object me, final String propName) {
			return get(me, propName);
		}

		@Override
		public Object getMetaobject(final Object me) {
			return ((EObject)me).eClass();
		}

		@Override
		public String getString(final Object me, final String propName) {
			String ret = null;
			Object v = get(me, propName);

			if (v != null) {
				if ((v instanceof Collection) && (((Collection<?>)v).size() == 1)) {
					v = ((Collection<?>)v).iterator().next();
				}

				if (v instanceof String) {
					ret = (String)v;
				} else if (v instanceof EEnumLiteral) {
					ret = ((EEnumLiteral)v).getName();
				}
			}

			return ret;
		}

		@Override
		public String getTypeName(final Object me) {
			return getName(((EObject)me).eClass());
		}

		@Override
		public String getName(final Object ame) {
			return getString(ame, "name");
		}

		@Override
		public Object refImmediateComposite(final Object me) {
			return ((EObject)me).eContainer();
		}

		@Override
		public boolean isAModelElement(final Object o) {
			return (o instanceof EObject);
		}

		@Override
		public Object getPropertyType(final Object f, final String propName) {
			final Object res = get(f, propName);
			if (res instanceof EObject) {
				return get(res, "eType");
			}
			return null;
		}

		@Override
		public boolean isPrimitive(final Object value) {
			return ((value instanceof String) || (value instanceof Boolean) || (value instanceof Double) || (value instanceof Integer));
		}

		@Override
		public boolean isEnumLiteral(final Object value) {
			return (value instanceof EEnumLiteral);
		}

		@Override
		public String getEnumLiteralName(final Object me) {
			return getName(me).toString();
		}

		@Override
		public String nextString(final Iterator<?> i) {
			return i.next().toString();
		}

	}

}
