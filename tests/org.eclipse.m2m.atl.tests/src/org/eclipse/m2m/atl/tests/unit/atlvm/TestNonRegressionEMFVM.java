/*******************************************************************************
 * Copyright (c) 2007, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - ATL tester
 *******************************************************************************/
package org.eclipse.m2m.atl.tests.unit.atlvm;

import java.util.Properties;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.service.CoreService;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.eclipse.m2m.atl.tests.unit.TestNonRegressionTransfo;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.resource.UMLResourceFactoryImpl;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * Specifies TestNonRegressionTransfo for the emfvm.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class TestNonRegressionEMFVM extends TestNonRegressionTransfo {

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.tests.unit.TestNonRegressionTransfo#getVMName()
	 */
	@Override
	protected String getVMName() {
		return "EMF-specific VM"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.tests.unit.TestNonRegressionTransfo#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Properties properties = new Properties();	
		properties.load(TestNonRegressionEMFVM.class.getResourceAsStream("TestNonRegressionEMFVM.properties")); //$NON-NLS-1$
		setProperties(properties);
		
		CoreService.registerLauncher("EMF-specific VM", EMFVMLauncher.class); //$NON-NLS-1$
		CoreService.registerFactory("EMF", EMFModelFactory.class); //$NON-NLS-1$
		CoreService.registerExtractor("EMF", EMFExtractor.class); //$NON-NLS-1$
		CoreService.registerInjector("EMF", EMFInjector.class); //$NON-NLS-1$

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				new UMLResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(UMLResource.UML_METAMODEL_URI, UMLPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/uml2/2.0.0/UML", UMLPackage.eINSTANCE); //$NON-NLS-1$
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/uml2/2.1.0/UML", UMLPackage.eINSTANCE); //$NON-NLS-1$
	}
	
}
