/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tarik Idrissi (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.outline;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.swt.graphics.Image;

public class AtlLabelProvider extends LabelProvider {
	private boolean initialized = false;

	private Map<EClass, Reader> readers = new HashMap<EClass, Reader>();

	private Map<ImageDescriptor, Image> imageCache = new HashMap<ImageDescriptor, Image>();

	private Map<String, String> classToImages = new HashMap<String, String>();

	private Reader defaultReader = new Reader() {

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.m2m.atl.adt.ui.outline.AtlLabelProvider.Reader#getText(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public String getText(EObject object) {
			return "<default> : " + object.eClass().getName(); //$NON-NLS-1$
		}
	};

	private abstract class Reader {

		/**
		 * Returns a readable String for the given object.
		 * 
		 * @param element
		 *            the object to read
		 * @return the readable String
		 */
		public abstract String getText(EObject element);
	}

	public AtlLabelProvider() {
		initForImages();
	}

	public void initReaders() {
		readers.put(AtlEMFConstants.clRule, new Reader() {
			private EStructuralFeature name = AtlEMFConstants.clRule.getEStructuralFeature("name"); //$NON-NLS-1$

			@Override
			public String getText(EObject rule) {
				return (String)rule.eGet(name);
			}
		});
		readers.put(AtlEMFConstants.clMatchedRule, readers.get(AtlEMFConstants.clRule));
		readers.put(AtlEMFConstants.clLazyMatchedRule, readers.get(AtlEMFConstants.clRule));
		readers.put(AtlEMFConstants.clCalledRule, readers.get(AtlEMFConstants.clRule));

		readers.put(AtlEMFConstants.clHelper, new Reader() {
			private EStructuralFeature sfFeature = AtlEMFConstants.clOclFeatureDefinition
					.getEStructuralFeature("feature"); //$NON-NLS-1$

			@Override
			public String getText(EObject helper) {
				EObject featureDef = (EObject)helper.eGet(AtlEMFConstants.sfHelperDefinition);
				if (featureDef != null) {
					EObject feature = (EObject)featureDef.eGet(sfFeature);
					if (feature == null) {
						return null;
					}
					return (String)feature.eGet(feature.eClass().getEStructuralFeature("name")); //$NON-NLS-1$
				}
				return null;
			}
		});

		readers.put(AtlEMFConstants.clLibraryRef, new Reader() {
			private EStructuralFeature sfName = AtlEMFConstants.clLibraryRef.getEStructuralFeature("name"); //$NON-NLS-1$

			@Override
			public String getText(EObject libraryRef) {
				return (String)libraryRef.eGet(sfName);
			}
		});

		readers.put(AtlEMFConstants.clOclModel, new Reader() {
			private EStructuralFeature sfName = AtlEMFConstants.clOclModel.getEStructuralFeature("name"); //$NON-NLS-1$

			@Override
			public String getText(EObject oclModel) {
				return (String)oclModel.eGet(sfName);
			}
		});

		readers.put(AtlEMFConstants.clVariableDeclaration, new Reader() {
			private EStructuralFeature sfVarName = AtlEMFConstants.clVariableDeclaration
					.getEStructuralFeature("varName"); //$NON-NLS-1$

			@Override
			public String getText(EObject variableDeclaration) {
				return (String)variableDeclaration.eGet(sfVarName);
			}
		});

		readers.put(AtlEMFConstants.clUnit, new Reader() {
			private EStructuralFeature sfName = AtlEMFConstants.clUnit.getEStructuralFeature("name"); //$NON-NLS-1$

			@Override
			public String getText(EObject unit) {
				return (String)unit.eGet(sfName);
			}
		});
		readers.put(AtlEMFConstants.clModule, readers.get(AtlEMFConstants.clUnit));
		readers.put(AtlEMFConstants.clLibrary, readers.get(AtlEMFConstants.clUnit));
		readers.put(AtlEMFConstants.clQuery, readers.get(AtlEMFConstants.clUnit));

		readers.put(AtlEMFConstants.clVariableDeclaration, new Reader() {
			@Override
			public String getText(EObject rule) {
				return (String)rule.eGet(AtlEMFConstants.sfVarName);
			}
		});

		readers.put(AtlEMFConstants.clPatternElement, readers.get(AtlEMFConstants.clVariableDeclaration));
		readers.put(AtlEMFConstants.clRuleVariableDeclaration, readers
				.get(AtlEMFConstants.clVariableDeclaration));
		readers.put(AtlEMFConstants.clParameter, readers.get(AtlEMFConstants.clVariableDeclaration));
		readers.put(AtlEMFConstants.clInPatternElement, readers.get(AtlEMFConstants.clPatternElement));
		readers
				.put(AtlEMFConstants.clSimpleInPatternElement, readers
						.get(AtlEMFConstants.clInPatternElement));
		readers.put(AtlEMFConstants.clOutPatternElement, readers.get(AtlEMFConstants.clPatternElement));
		readers.put(AtlEMFConstants.clSimpleOutPatternElement, readers
				.get(AtlEMFConstants.clOutPatternElement));

	}

	private void initForText(EObject unit) {
		if (!initialized) {
			AtlEMFConstants.pkAtl = unit.eClass().getEPackage();
			AtlEMFConstants.clModule = (EClass)AtlEMFConstants.pkAtl.getEClassifier("Module"); //$NON-NLS-1$
			AtlEMFConstants.clLibrary = (EClass)AtlEMFConstants.pkAtl.getEClassifier("Library"); //$NON-NLS-1$
			AtlEMFConstants.clQuery = (EClass)AtlEMFConstants.pkAtl.getEClassifier("Query"); //$NON-NLS-1$
			AtlEMFConstants.sfModuleElements = AtlEMFConstants.clModule.getEStructuralFeature("elements"); //$NON-NLS-1$
			AtlEMFConstants.clRule = (EClass)AtlEMFConstants.pkAtl.getEClassifier("Rule"); //$NON-NLS-1$
			AtlEMFConstants.clMatchedRule = (EClass)AtlEMFConstants.pkAtl.getEClassifier("MatchedRule"); //$NON-NLS-1$
			AtlEMFConstants.clLazyMatchedRule = (EClass)AtlEMFConstants.pkAtl
					.getEClassifier("LazyMatchedRule"); //$NON-NLS-1$
			AtlEMFConstants.clCalledRule = (EClass)AtlEMFConstants.pkAtl.getEClassifier("CalledRule"); //$NON-NLS-1$
			AtlEMFConstants.clHelper = (EClass)AtlEMFConstants.pkAtl.getEClassifier("Helper"); //$NON-NLS-1$
			AtlEMFConstants.sfHelperDefinition = AtlEMFConstants.clHelper.getEStructuralFeature("definition"); //$NON-NLS-1$
			AtlEMFConstants.clLibraryRef = (EClass)AtlEMFConstants.pkAtl.getEClassifier("LibraryRef"); //$NON-NLS-1$
			AtlEMFConstants.clUnit = (EClass)AtlEMFConstants.pkAtl.getEClassifier("Unit"); //$NON-NLS-1$
			AtlEMFConstants.clPatternElement = (EClass)AtlEMFConstants.pkAtl.getEClassifier("PatternElement"); //$NON-NLS-1$
			AtlEMFConstants.clRuleVariableDeclaration = (EClass)AtlEMFConstants.pkAtl
					.getEClassifier("RuleVariableDeclaration"); //$NON-NLS-1$
			AtlEMFConstants.clInPatternElement = (EClass)AtlEMFConstants.pkAtl
					.getEClassifier("InPatternElement"); //$NON-NLS-1$
			AtlEMFConstants.clOutPatternElement = (EClass)AtlEMFConstants.pkAtl
					.getEClassifier("OutPatternElement"); //$NON-NLS-1$
			AtlEMFConstants.clSimpleInPatternElement = (EClass)AtlEMFConstants.pkAtl
					.getEClassifier("SimpleInPatternElement"); //$NON-NLS-1$
			AtlEMFConstants.clSimpleOutPatternElement = (EClass)AtlEMFConstants.pkAtl
					.getEClassifier("SimpleOutPatternElement"); //$NON-NLS-1$
			AtlEMFConstants.clInPattern = (EClass)AtlEMFConstants.pkAtl.getEClassifier("InPattern"); //$NON-NLS-1$
			AtlEMFConstants.clOutPattern = (EClass)AtlEMFConstants.pkAtl.getEClassifier("OutPattern"); //$NON-NLS-1$
			AtlEMFConstants.pkOcl = AtlEMFConstants.sfHelperDefinition.getEType().getEPackage();
			AtlEMFConstants.clOclFeatureDefinition = (EClass)AtlEMFConstants.pkOcl
					.getEClassifier("OclFeatureDefinition"); //$NON-NLS-1$
			AtlEMFConstants.clOclFeature = (EClass)AtlEMFConstants.pkOcl.getEClassifier("OclFeature"); //$NON-NLS-1$
			AtlEMFConstants.clOclModel = (EClass)AtlEMFConstants.pkOcl.getEClassifier("OclModel"); //$NON-NLS-1$
			AtlEMFConstants.clParameter = (EClass)AtlEMFConstants.pkOcl.getEClassifier("Parameter"); //$NON-NLS-1$
			AtlEMFConstants.clVariableDeclaration = (EClass)AtlEMFConstants.pkOcl
					.getEClassifier("VariableDeclaration"); //$NON-NLS-1$
			AtlEMFConstants.sfVarName = AtlEMFConstants.clVariableDeclaration
					.getEStructuralFeature("varName"); //$NON-NLS-1$
			AtlEMFConstants.clElement = (EClass)AtlEMFConstants.pkAtl.getEClassifier("LocatedElement"); //$NON-NLS-1$
			AtlEMFConstants.sfLocation = AtlEMFConstants.clElement.getEStructuralFeature("location"); //$NON-NLS-1$
			initReaders();
			initialized = true;
		}
	}

	private void initForImages() {
		classToImages.put("Library", "libs.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("Module", "module.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("Query", "query.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("OclModel", "oclModel.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("LibraryRef", "libsreference.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("Helper", "helper.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("MatchedRule", "matchedRule.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("LazyMatchedRule", "lazyRule.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("Operation", "operation.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("InPattern", "inPattern.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("OutPattern", "outPattern.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("Binding", "binding.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("Iterator", "iterator.gif"); //$NON-NLS-1$ //$NON-NLS-2$

		// classToImages.put("OclFeatureDefinition", ".gif");
		// classToImages.put("OclContextDefinition", "helper.gif");
		classToImages.put("SimpleInPatternElement", "element.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("SimpleOutPatternElement", "element.gif"); //$NON-NLS-1$ //$NON-NLS-2$

		classToImages.put("OperationCallExp", "expressionATL.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("OperatorCallExp", "expressionATL.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("NavigationOrAttributeCallExp", "expressionATL.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("EnumLiteralExp", "expressionATL.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("IteratorExp", "expressionATL.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("CollectionOperationCallExp", "expressionATL.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("IfExp", "expressionATL.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("StringExp", "expressionATL.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("VariableExp", "expressionATL.gif"); //$NON-NLS-1$ //$NON-NLS-2$

		classToImages.put("BooleanType", "type.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("OclModelElement", "type.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("StringType", "type.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		classToImages.put("TupleType", "type.gif"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Returns the images descriptor for an element of the ATL AST.
	 * 
	 * @param className
	 *            the class name for which to find the image descriptor
	 * @return the images descriptor for an element of the ATL AST
	 */
	private ImageDescriptor getImage(String className) {
		String iconName = classToImages.get(className);
		if (iconName != null) {
			return AtlUIPlugin.getImageDescriptor(iconName);
		}

		return AtlUIPlugin.getImageDescriptor("test.gif"); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {
		Image ret = null;

		if (!(element instanceof Root)) {
			EObject eo = (EObject)element;
			if (AtlEMFConstants.clUnit.isInstance(element)) {
				initForText(eo);
			}
			String className = ((EObject)element).eClass().getName();
			ImageDescriptor descriptor = getImage(className);
			ret = imageCache.get(descriptor);
			if (ret == null) {
				ret = descriptor.createImage();
				imageCache.put(descriptor, ret);
			}
		}
		return ret;
	}

	private Reader getReader(EObject eo) {
		Reader ret = null;
		ret = readers.get(eo.eClass());
		if (ret == null) {
			ret = defaultReader;
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		String ret = "default"; //$NON-NLS-1$
		if (!(element instanceof Root)) {
			EObject eo = (EObject)element;
			initForText(eo);
			ret = getReader(eo).getText(eo);
			ret += " : " + eo.eClass().getName(); //$NON-NLS-1$
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.BaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {
		for (Iterator<Image> images = imageCache.values().iterator(); images.hasNext();)
			images.next().dispose();
		imageCache.clear();
	}

	protected RuntimeException unknownElement(Object element) {
		return new RuntimeException(element.getClass().getName());
	}

}
