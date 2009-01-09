/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - Public2Private standalone example
 *******************************************************************************/
package org.eclipse.m2m.atl.examples.public2private.cmd;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.resource.UMLResourceFactoryImpl;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * Privatize standalone implementation.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public final class Main {

	private static IInjector injector;

	private static IExtractor extractor;

	private static IReferenceModel umlMetamodel;

	private static IReferenceModel refiningTraceMetamodel;

	private static URL asmURL;

	static {
		// ATL public2private transformation
		asmURL = Main.class.getResource("resource/Public2Private.asm"); //$NON-NLS-1$
		injector = new EMFInjector();
		extractor = new EMFExtractor();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				new UMLResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(UMLResource.UML_METAMODEL_URI, UMLPackage.eINSTANCE);
	}

	private Main() {
		// prevents instantiation
	}

	/**
	 * Public2private command.
	 * 
	 * @param args
	 *            the uml files to privatize
	 */
	public static void main(String[] args) {
		for (File file : parseArgs(args)) {
			try {
				System.out.println("Privatizing " + file + "..."); //$NON-NLS-1$ //$NON-NLS-2$
				privatize(file);
				System.out.println("Done."); //$NON-NLS-1$
			} catch (IOException e) {
				System.err.println(e);
			} catch (ATLCoreException e) {
				System.err.println(e);
			}
		}
	}

	private static List<File> parseArgs(String[] args) {
		List<File> files = new ArrayList<File>();
		if (args.length == 0) {
			System.out.println("Usage: <this program> [uml file to privatize]"); //$NON-NLS-1$
		}
		for (int i = 0; i < args.length; i++) {
			String string = args[i];
			File file = new File(string);
			if (file.exists()) {
				files.add(file);
			} else {
				System.out.println("File " + file + " not found."); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return files;
	}

	private static void privatize(File file) throws IOException, ATLCoreException {
		// Defaults
		ModelFactory factory = new EMFModelFactory();

		// Metamodels
		umlMetamodel = factory.newReferenceModel();
		injector.inject(umlMetamodel, "uri:http://www.eclipse.org/uml2/2.1.0/UML"); //$NON-NLS-1$
		refiningTraceMetamodel = factory.getBuiltInResource("RefiningTrace"); //$NON-NLS-1$

		// Getting launcher
		ILauncher launcher = null;
		launcher = new EMFVMLauncher();
		launcher.initialize(Collections.<String, Object> emptyMap());

		// Creating models
		IModel refiningTraceModel = factory.newModel(refiningTraceMetamodel);
		IModel umlModel = factory.newModel(umlMetamodel);

		// Loading existing model
		injector.inject(umlModel, "ext:" + file.toString()); //$NON-NLS-1$

		// Launching
		launcher.addOutModel(refiningTraceModel, "refiningTrace", "RefiningTrace"); //$NON-NLS-1$ //$NON-NLS-2$
		launcher.addInOutModel(umlModel, "IN", "UML"); //$NON-NLS-1$ //$NON-NLS-2$

		launcher.launch(ILauncher.RUN_MODE, new NullProgressMonitor(), Collections
				.<String, Object> emptyMap(), new Object[] {asmURL.openStream()});

		// Saving model
		extractor.extract(umlModel, "ext:" + file.toString()); //$NON-NLS-1$
	}

}
