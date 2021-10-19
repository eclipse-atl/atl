/*******************************************************************************
 * Copyright (c) 2009, 2012, 2014 Obeo.
 * Copyright (c) 2021 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
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
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.dsls.tcs.injector.ModelAdapter;
import org.eclipse.m2m.atl.dsls.tcs.injector.ParserLauncher;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;

/**
 * A wrapper which allow to create {@link IModel} from text with TCS.
 *
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class EMFTCSInjector {

	private static Map<String, String> parameterTypes = new HashMap<>();

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

	public Map<String, String> getParameterTypes() {
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

	public Object inject(final EMFModel target, final InputStream source, final Map<Object, Object> params)
			throws IOException {
		return inject(target, new InputStreamReader(source), params);
	}

	public Object inject(final EMFModel target, final Reader source,
			final Map<Object, Object> params) throws IOException {
		final ModelAdapter targetModelAdapter = new EMFInjectorAdapter(target);

		final EMFModel problems = (EMFModel)params.get("problems");
		if (problems != null) {
			final ModelAdapter problemsModelAdapter = new EMFInjectorAdapter(problems);
			params.put("problems", problemsModelAdapter);
		}

		final EObject root = (EObject)new ParserLauncher().parse(targetModelAdapter, source, params);
		target.commitToResource();
		if(problems != null)
			problems.commitToResource();
		return root;
	}

	/**
	 * Adapts an {@link EMFModel}. Uses EMFTVM models internally, because they are more efficient for extent
	 * lookup during in-place transformation (i.e. parsing).
	 */
	public class EMFInjectorAdapter implements ModelAdapter {

		private final EMFModel emfModel;
		private final Model model;
		private final Metamodel metamodel;

		public EMFInjectorAdapter(final Object model) {
			this.emfModel = (EMFModel)model;
			if (emfModel.getResource() == null) {
				// Trigger resource creation
				final Object element = emfModel.newElement(EcorePackage.eINSTANCE.getEClass());
				emfModel.getResource().getContents().remove(element);
			}
			this.model = EmftvmFactory.eINSTANCE.createModel(emfModel.getResource());
			this.metamodel = EmftvmFactory.eINSTANCE
					.createMetamodel(emfModel.getReferenceModel().getResource());
		}

		@Override
		public Object getModel() {
			return this.emfModel;
		}

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
		public Object createElement(final String typeName) {
			return model.newElement(getTypeByName(typeName));
		}

		@Override
		public Set<?> getElementsByType(final String typeName) {
			return model.allInstancesOf(getTypeByName(typeName)).asSet();
		}

		@Override
		public void set(final Object modelElement, final String name, Object value) {
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
				final String targetType = feature.getEType().getInstanceClassName();
				if ("java.lang.Double".equals(targetType) || "java.lang.Float".equals(targetType)) { //$NON-NLS-1$ //$NON-NLS-2$
					value = Double.valueOf(((Integer)value).doubleValue());
				}
			}

			final EClassifier type = feature.getEType();
			final boolean targetIsEnum = type instanceof EEnum;

			final Object oldValue = eo.eGet(feature);
			if (oldValue instanceof Collection) {
				@SuppressWarnings("unchecked")
				final Collection<Object> oldCol = (Collection<Object>)oldValue;
				if (value instanceof Collection) {
					if (targetIsEnum) {
						final EEnum eenum = (EEnum)type;
						for (@SuppressWarnings("unchecked")
						final Iterator<Object> i = ((Collection<Object>)value).iterator(); i.hasNext();) {
							final Object v = i.next();
							oldCol.add(eenum.getEEnumLiteralByLiteral(v.toString()).getInstance());
						}
					} else {
						oldCol.addAll((Collection<?>)value);
					}
				} else {
					if (targetIsEnum) {
						final EEnum eenum = (EEnum)type;
						oldCol.add(eenum.getEEnumLiteralByLiteral(value.toString()).getInstance());
					} else {
						oldCol.add(value);
					}
				}
			} else {
				if (value instanceof Collection) {
					final Collection<?> c = (Collection<?>)value;
					if (!c.isEmpty()) {
						value = c.iterator().next();
					} else {
						value = null;
					}
				}
				if (targetIsEnum) {
					final EEnum eenum = (EEnum)type;
					if (value != null) {
						final EEnumLiteral literal = eenum.getEEnumLiteral(value.toString());
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

		@Override
		public boolean isCandidate(final Object ame, final String typeName) {
			boolean ret = false;
			final Object valueType = getTypeByName(typeName);

			final Object type = getType(ame);

			if (valueType instanceof EObject) {
				final EObject o = (EObject)valueType;
				final EObject t = (EObject)type;

				if ((o instanceof EClass) && (t instanceof EClass)) {
					try {
						ret = o.equals(t) || ((EClass)o).isSuperTypeOf((EClass)t);
					} catch (final Exception e) {
						ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
					}
				}
			}
			return ret;
		}

		@Override
		public Object getType(final Object value) {
			if (value instanceof EObject) {
				return ((EObject)value).eClass();
			} else if (value instanceof EList) {
				return ArrayList.class;
			} else {
				return value.getClass();
			}
		}

		@Override
		public boolean isAModelElement(final Object me) {
			return me instanceof EObject;
		}

		@Override
		public String getString(final Object ame, final String propName) {
			return get(ame, propName).toString();
		}

		@Override
		public Object createEnumLiteral(final String name) {
			final EEnumLiteral ret = EcoreFactoryImpl.eINSTANCE.createEEnumLiteral();
			ret.setName(name);
			return ret;
		}

		private EClass getTypeByName(final String typeName) {
			final EClassifier type = metamodel.findType(typeName);
			return type instanceof EClass ? (EClass)type : null;
		}
	}
}
