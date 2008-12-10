/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - Public2Private example IDE
 *******************************************************************************/
package org.eclipse.m2m.atl.examples.public2private.ui;

import java.net.URL;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.core.service.CoreService;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.osgi.framework.Bundle;

/**
 * Privatize action implementation.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class PrivatizeAction implements IObjectActionDelegate {

	private static ModelFactory factory;

	private static IInjector injector;

	private static IExtractor extractor;

	private static IReferenceModel umlMetamodel;

	private static IReferenceModel refiningTraceMetamodel;

	private static URL asmURL;

	private ISelection currentSelection;

	static {
		// ATL public2private transformation
		Bundle bundle = Platform.getBundle("org.eclipse.m2m.atl.examples.public2private"); //$NON-NLS-1$
		asmURL = bundle.getEntry("transformation/Public2Private.asm"); //$NON-NLS-1$

		// Defaults
		try {
			factory = CoreService.getModelFactory("EMF"); //$NON-NLS-1$
		} catch (CoreException e) {
			e.printStackTrace();
		}
		injector = factory.getDefaultInjector();
		extractor = factory.getDefaultExtractor();

		// Metamodels
		umlMetamodel = factory.newReferenceModel();
		injector.inject(umlMetamodel, "uri:http://www.eclipse.org/uml2/2.1.0/UML"); //$NON-NLS-1$
		refiningTraceMetamodel = factory.getBuiltInResource("RefiningTrace"); //$NON-NLS-1$
	}

	/**
	 * Constructor for Action1.
	 */
	public PrivatizeAction() {
		super();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction, org.eclipse.ui.IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		// Getting file from selection
		IStructuredSelection iss = (IStructuredSelection)currentSelection;
		IFile currentFile = (IFile)iss.getFirstElement();
		String artifactUri = currentFile.getFullPath().toString();

		// Getting launcher
		ILauncher launcher = null;
		try {
			launcher = CoreService.getLauncher("EMFVM"); //$NON-NLS-1$
			launcher.initialize(Collections.<String, Object> emptyMap());
		} catch (CoreException e) {
			e.printStackTrace();
		}

		// Creating models
		IModel refiningTraceModel = factory.newModel(refiningTraceMetamodel);
		IModel umlModel = factory.newModel(umlMetamodel);

		// Loading existing model
		injector.inject(umlModel, artifactUri);

		// Launching
		launcher.addOutModel(refiningTraceModel, "refiningTrace", "RefiningTrace"); //$NON-NLS-1$ //$NON-NLS-2$
		launcher.addInOutModel(umlModel, "IN", "UML"); //$NON-NLS-1$ //$NON-NLS-2$
		try {
			launcher.launch(Collections.<String, Object> emptyMap(), new Object[] {asmURL.openStream()});
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		// Saving model
		extractor.extract(umlModel, artifactUri);

		// Disposing models
		umlModel.dispose();
		refiningTraceModel.dispose();

		// Refresh workspace
		try {
			currentFile.getParent().refreshLocal(IProject.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.currentSelection = selection;
	}
}
