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

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

public abstract class AtlOutlinePage extends Page implements IContentOutlinePage, IPostSelectionProvider {

	protected TreeViewer treeViewer;

	/**
	 * <p>
	 * Will contain the listener added to the tree viewer if this one is still null
	 * </p>
	 * <p>
	 * When tree viewer will be instantiated in method <code>createPartControl</code>it will be added these
	 * listeners
	 * </p>
	 */
	protected ListenerList selectionChangedListeners = new ListenerList();

	/**
	 * @see org.eclipse.ui.part.IPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		treeViewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		treeViewer.setUseHashlookup(true);
	}

	/**
	 * @see org.eclipse.ui.part.IPage#getControl()
	 */
	public Control getControl() {
		if (treeViewer == null) {
			return null;
		}
		return treeViewer.getControl();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.Page#setFocus()
	 */
	public void setFocus() {
		if (treeViewer != null) {
			treeViewer.getControl().setFocus();
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.viewers.IPostSelectionProvider#addPostSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
	 */
	public void addPostSelectionChangedListener(ISelectionChangedListener listener) {
		if (treeViewer != null) {
			treeViewer.addPostSelectionChangedListener(listener);
		} else {
			selectionChangedListeners.add(listener);
		}
	}

	/**
	 * @see org.eclipse.jface.viewers.IPostSelectionProvider#removePostSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
	 */
	public void removePostSelectionChangedListener(ISelectionChangedListener listener) {
		if (treeViewer != null) {
			treeViewer.removePostSelectionChangedListener(listener);
		} else {
			selectionChangedListeners.add(listener);
		}
	}

	/**
	 * @see org.eclipse.jface.viewers.ISelectionProvider#addSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
	 */
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		if (treeViewer != null) {
			treeViewer.addSelectionChangedListener(listener);
		} else {
			selectionChangedListeners.add(listener);
		}
	}

	/**
	 * @see org.eclipse.jface.viewers.ISelectionProvider#getSelection()
	 */
	public ISelection getSelection() {
		if (treeViewer == null) {
			return StructuredSelection.EMPTY;
		}
		return treeViewer.getSelection();

	}

	/**
	 * @see org.eclipse.jface.viewers.ISelectionProvider#removeSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
	 */
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		if (treeViewer != null) {
			treeViewer.removeSelectionChangedListener(listener);
		}
	}

	/**
	 * @see org.eclipse.jface.viewers.ISelectionProvider#setSelection(org.eclipse.jface.viewers.ISelection)
	 */
	public void setSelection(ISelection selection) {
		if (treeViewer != null) {
			treeViewer.setSelection(selection);
		}
	}
}
