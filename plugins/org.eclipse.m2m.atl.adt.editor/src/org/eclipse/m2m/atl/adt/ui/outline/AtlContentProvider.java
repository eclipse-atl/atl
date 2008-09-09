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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

public class AtlContentProvider implements ITreeContentProvider {
	protected TreeViewer viewer;

	private static final Object[] EMPY_ARRAY = new Object[0];

	/*
	 * Prefix for model elements attribute names: - cl: EClass - pk: EPackage - sf: EStructuralFeature
	 */
	/*
	 * private EPackage pkAtl = null; private EClass clModule = null; private EStructuralFeature
	 * sfModule_elements = null;; private EClass clRule = null; private EClass clHelper = null; private EClass
	 * clLibraryRef = null; private void init(EObject module) { pkAtl =
	 * (EPackage)module.eClass().getEPackage(); clModule = (EClass)pkAtl.getEClassifier("Module");
	 * sfModule_elements = clModule.getEStructuralFeature("elements"); clRule =
	 * (EClass)pkAtl.getEClassifier("Rule"); clHelper = (EClass)pkAtl.getEClassifier("Helper"); clLibraryRef =
	 * (EClass)pkAtl.getEClassifier("LibraryRef"); initialized = true; }
	 */

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	public Object[] getChildren(Object parentElement) {
		if (parentElement == null) {
			return EMPY_ARRAY;
		}

		if (parentElement instanceof Root) {
			return new Object[] {((Root)parentElement).getUnit()};
		}

		if (parentElement instanceof EObject) {
			EObject pe = (EObject)parentElement;
			EList children = pe.eContents();
			return children.toArray();
		}

		return EMPY_ARRAY;
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	public Object getParent(Object element) {
		EObject eo = (EObject)element;
		return eo.eContainer();
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	/**
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		viewer = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
	 *      java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = (TreeViewer)viewer;
	}

}
