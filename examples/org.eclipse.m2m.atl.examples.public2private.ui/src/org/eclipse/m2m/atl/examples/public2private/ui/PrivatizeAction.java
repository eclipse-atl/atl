/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
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
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.m2m.atl.core.ATLCoreException;
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
		try {
			injector = CoreService.getInjector("EMF"); //$NON-NLS-1$
			extractor = CoreService.getExtractor("EMF"); //$NON-NLS-1$			
		} catch (ATLCoreException e) {
			e.printStackTrace();
		}
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
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction,
	 *      org.eclipse.ui.IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		// Getting files from selection
		IStructuredSelection iss = (IStructuredSelection)currentSelection;
		for (Iterator<?> iterator = iss.iterator(); iterator.hasNext();) {
			try {
				privatize((IFile)iterator.next());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	private void privatize(IFile file) throws Exception {
		// Defaults
		ModelFactory factory = CoreService.createModelFactory("EMF"); //$NON-NLS-1$

		// Metamodels
		umlMetamodel = factory.newReferenceModel();
		injector.inject(umlMetamodel, "http://www.eclipse.org/uml2/2.1.0/UML"); //$NON-NLS-1$
		refiningTraceMetamodel = factory.getBuiltInResource("RefiningTrace.ecore"); //$NON-NLS-1$

		// Getting launcher
		ILauncher launcher = null;
		launcher = CoreService.getLauncher("EMF-specific VM"); //$NON-NLS-1$
		launcher.initialize(Collections.<String, Object> emptyMap());

		// Creating models
		IModel refiningTraceModel = factory.newModel(refiningTraceMetamodel);
		IModel umlModel = factory.newModel(umlMetamodel);

		// Loading existing model
		injector.inject(umlModel, file.getFullPath().toString());

		// Launching
		launcher.addOutModel(refiningTraceModel, "refiningTrace", "RefiningTrace"); //$NON-NLS-1$ //$NON-NLS-2$
		launcher.addInOutModel(umlModel, "IN", "UML"); //$NON-NLS-1$ //$NON-NLS-2$

		launcher.launch(ILauncher.RUN_MODE, new NullProgressMonitor(), Collections
				.<String, Object> emptyMap(), asmURL.openStream());

		// Saving model
		extractor.extract(umlModel, file.getFullPath().toString());

		// Refresh workspace
		file.getParent().refreshLocal(IProject.DEPTH_INFINITE, null);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.currentSelection = selection;
	}
}
