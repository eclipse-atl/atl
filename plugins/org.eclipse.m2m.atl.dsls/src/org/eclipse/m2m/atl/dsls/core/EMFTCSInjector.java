/*******************************************************************************
 * Copyright (c) 2009, 2012, 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Dennis Wagelaar
 *******************************************************************************/
package org.eclipse.m2m.atl.dsls.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.dsls.tcs.injector.ModelAdapter;
import org.eclipse.m2m.atl.dsls.tcs.injector.ParserLauncher;

/**
 * A wrapper which allow to create {@link IModel} from text with TCS.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class EMFTCSInjector {

	private static Map parameterTypes = new HashMap();

	static {
		parameterTypes.put("name", "String"); // required
		parameterTypes.put("keepNL", "String"); // optional, default = false
		parameterTypes.put("keepLocation", "String"); // optional, default = true
		parameterTypes.put("keepComments", "String"); // optional, default = true
		parameterTypes.put("tabSize", "String"); // optional, default = 8
		parameterTypes.put("parserGenerator", "String");// optional, default = "antlr3"
		parameterTypes.put("hyperlinks", "Map"); // optional, default = null
		parameterTypes.put("trace", "Map"); // optional, default = null
		parameterTypes.put("locationByElement", "Map"); // optional, default = null
		parameterTypes.put("problems", "Model:Problem");// optional, default = null

		// Useful when the lexer and/or parser cannot be resolved from here
		parameterTypes.put("lexerClass", "Class"); // optional, default = null
		parameterTypes.put("parserClass", "Class"); // optional, default = null
	}

	public Map getParameterTypes() {
		return parameterTypes;
	}

	public String getPrefix() {
		return "ebnf2";
	}

	protected ModelAdapter problemsModelAdapter;

	protected ModelAdapter targetModelAdapter;

	public EMFTCSInjector() {
		super();
	}

	public Object inject(EMFModel target, InputStream source, Map params) throws IOException {
		return inject(target, new InputStreamReader(source), params);
	}

	public Object inject(EMFModel target, Reader source, Map params) throws IOException {
		ModelAdapter targetModelAdapter = new EMFInjectorAdapter(target);

		EMFModel problems = (EMFModel)params.get("problems");
		if (problems != null) {
			ModelAdapter problemsModelAdapter = new EMFInjectorAdapter(problems);
			params.put("problems", problemsModelAdapter);
		}

		EObject root = (EObject)new ParserLauncher().parse(targetModelAdapter, source, params);
		target.commitToResource();
		if(problems != null)
			problems.commitToResource();
		return root;
	}

	public class EMFInjectorAdapter implements ModelAdapter {

		private EMFModel model;

		public EMFInjectorAdapter(Object model) {
			this.model = (EMFModel)model;
		}

		public Object getModel() {
			return this.model;
		}

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

		public Object createElement(String typeName) {
			return model.newElement(getTypeByName(typeName));
		}

		public Set getElementsByType(String typeName) {
			return model.getElementsByType(getTypeByName(typeName));
		}

		public void set(Object modelElement, String name, Object value) {
			if (value == null) {
				return;
			}

			final EObject eo = (EObject)modelElement;

			final EStructuralFeature feature = eo.eClass().getEStructuralFeature(name);

			if (feature == null) {
				return;
			}

			// makes it possible to use an integer to set a floating point property
			if (value instanceof Integer) {
				String targetType = feature.getEType().getInstanceClassName();
				if ("java.lang.Double".equals(targetType) || "java.lang.Float".equals(targetType)) { //$NON-NLS-1$ //$NON-NLS-2$
					value = new Double(((Integer)value).doubleValue());
				}
			}

			EClassifier type = feature.getEType();
			boolean targetIsEnum = type instanceof EEnum;

			Object oldValue = eo.eGet(feature);
			if (oldValue instanceof Collection) {
				Collection oldCol = (Collection)oldValue;
				if (value instanceof Collection) {
					if (targetIsEnum) {
						EEnum eenum = (EEnum)type;
						for (Iterator i = ((Collection)value).iterator(); i.hasNext();) {
							Object v = i.next();
							oldCol.add(eenum.getEEnumLiteralByLiteral(v.toString()).getInstance());
						}
					} else {
						oldCol.addAll((Collection)value);
					}
				} else {
					if (targetIsEnum) {
						EEnum eenum = (EEnum)type;
						oldCol.add(eenum.getEEnumLiteralByLiteral(value.toString()).getInstance());
					} else {
						oldCol.add(value);
					}
				}
			} else {
				if (value instanceof Collection) {
					Collection c = (Collection)value;
					if (!c.isEmpty()) {
						value = c.iterator().next();
					} else {
						value = null;
					}
				}
				if (targetIsEnum) {
					EEnum eenum = (EEnum)type;
					if (value != null) {
						EEnumLiteral literal = eenum.getEEnumLiteral(value.toString());
						if (literal != null) {
							eo.eSet(feature, literal.getInstance());
						} else {
							return;
						}
					}
				} else {
					eo.eSet(feature, value);
				}
			}
		}

		public boolean isCandidate(Object ame, String typeName) {
			boolean ret = false;
			Object valueType = getTypeByName(typeName);

			Object type = getType(ame);

			if (valueType instanceof EObject) {
				final EObject o = (EObject)valueType;
				final EObject t = (EObject)type;

				if ((o instanceof EClass) && (t instanceof EClass)) {
					try {
						ret = o.equals(t) || ((EClass)o).isSuperTypeOf((EClass)t);
					} catch (Exception e) {
						ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
					}
				}
			}
			return ret;
		}

		public Object getType(Object value) {
			if (value instanceof EObject) {
				return ((EObject)value).eClass();
			} else if (value instanceof EList) {
				return ArrayList.class;
			} else {
				return value.getClass();
			}
		}

		public boolean isAModelElement(Object me) {
			return me instanceof EObject;
		}

		public String getString(Object ame, String propName) {
			return get(ame, propName).toString();
		}

		public Object createEnumLiteral(String name) {
			EEnumLiteral ret = EcoreFactoryImpl.eINSTANCE.createEEnumLiteral();
			ret.setName(name);
			return ret;
		}

		private Object getTypeByName(String typeName) {
			return model.getReferenceModel().getMetaElementByName(typeName);
		}
	}
}
