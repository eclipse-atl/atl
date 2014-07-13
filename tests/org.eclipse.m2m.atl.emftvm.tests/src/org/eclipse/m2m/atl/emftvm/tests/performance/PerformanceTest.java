/*******************************************************************************
 * Copyright (c) 2013-2014 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.tests.performance;

import java.util.logging.Logger;

import org.eclipse.m2m.atl.core.service.CoreService;
import org.eclipse.m2m.atl.core.ui.vm.RegularVMLauncher;
import org.eclipse.m2m.atl.core.ui.vm.asm.ASMExtractor;
import org.eclipse.m2m.atl.core.ui.vm.asm.ASMFactory;
import org.eclipse.m2m.atl.core.ui.vm.asm.ASMInjector;
import org.eclipse.m2m.atl.drivers.emf4atl.AtlEMFModelHandler;
import org.eclipse.m2m.atl.emftvm.tests.EMFTVMTest;
import org.eclipse.m2m.atl.engine.vm.AtlModelHandler;

/**
 * EMFTVM performance test base class.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public abstract class PerformanceTest extends EMFTVMTest {

	protected static final Logger LOG = Logger.getLogger(PerformanceTest.class.getName());

	/**
	 * Creates a new {@link PerformanceTest}.
	 */
	public PerformanceTest() {
		super();
	}

	/**
	 * Creates a new {@link PerformanceTest}.
	 * @param name the test name
	 */
	public PerformanceTest(String name) {
		super(name);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();

		AtlModelHandler.registerDefaultHandler("EMF", new AtlEMFModelHandler()); //$NON-NLS-1$
		CoreService.registerLauncher("Regular VM", RegularVMLauncher.class); //$NON-NLS-1$
		CoreService.registerFactory("ASM", ASMFactory.class); //$NON-NLS-1$
		CoreService.registerExtractor("ASM", ASMExtractor.class); //$NON-NLS-1$
		CoreService.registerInjector("ASM", ASMInjector.class); //$NON-NLS-1$
	}

}