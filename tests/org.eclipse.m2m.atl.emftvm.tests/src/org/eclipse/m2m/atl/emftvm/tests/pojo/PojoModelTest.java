/*******************************************************************************
 * Copyright (c) 2013 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.tests.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.tests.EMFTVMTest;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;

/**
 * Tests the <code>pojo.ecore</code> model using {@link Set} and {@link List} for collections instead of {@link EList}.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class PojoModelTest extends EMFTVMTest {

	private static final Logger LOG = Logger.getLogger(PojoModelTest.class.getName());

	private Metamodel pojo;
	private ModuleResolver moduleResolver;

	/**
	 * {@inheritDoc}
	 * 
	 * @throws Exception
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		pojo = EmftvmFactory.eINSTANCE.createMetamodel();
		pojo.setResource(PojoPackage.eINSTANCE.eResource());
		moduleResolver = new DefaultModuleResolver(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/POJOModel/", true).toString(),
				new ResourceSetImpl());
	}

	/**
	 * Creates a new POJO model.
	 * 
	 * @return a new POJO model
	 */
	protected Resource createPojoModel() {
		final PojoA pojoA = PojoFactory.eINSTANCE.createPojoA();
		final PojoB pojoB = PojoFactory.eINSTANCE.createPojoB();
		pojoB.getNameSet().add("PojoB");
		pojoB.getEnumList().add(TestEnum.OPTION_A);
		pojoB.getEnumList().add(TestEnum.OPTION_B);
		pojoA.getBList().add(pojoB);
		pojoA.getBSet().add(pojoB);
		final Resource res = new ResourceImpl(URI.createURI("in.pojo"));
		res.getContents().add(pojoA);
		res.getContents().add(pojoB);
		return res;
	}

	/**
	 * Creates a new Ecore model.
	 * 
	 * @return a new Ecore model
	 */
	protected Resource createEcoreModel() {
		final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName("PojoA");
		final EAttribute eAttribute = EcoreFactory.eINSTANCE.createEAttribute();
		eAttribute.setName("PojoB");
		eClass.getEStructuralFeatures().add(eAttribute);
		final Resource res = new ResourceImpl(URI.createURI("in.ecore"));
		res.getContents().add(eClass);
		return res;
	}

	/**
	 * Test method for <code>POJOToEcore.atl</code>.
	 */
	public void testPOJOToEcore() {
		final Model in = EmftvmFactory.eINSTANCE.createModel();
		in.setResource(createPojoModel());
		final Model out = EmftvmFactory.eINSTANCE.createModel();
		out.setResource(new ResourceImpl(URI.createURI("out.ecore")));

		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		env.registerMetaModel("POJO", pojo);
		env.registerInputModel("IN", in);
		env.registerOutputModel("OUT", out);
		final TimingData td = new TimingData();
		env.loadModule(moduleResolver, "POJOToEcore");
		td.finishLoading();
		env.run(td);
		td.finish();
		LOG.info("PojoModelTest#testPOJOToEcore " + td.toString());

		final Resource ref = createEcoreModel();
		assertEquals(ref, out.getResource());
	}

	/**
	 * Test method for <code>EcoreToPOJO.atl</code>.
	 */
	public void testEcoreToPOJO() {
		final Model in = EmftvmFactory.eINSTANCE.createModel();
		in.setResource(createEcoreModel());
		final Model out = EmftvmFactory.eINSTANCE.createModel();
		out.setResource(new ResourceImpl(URI.createURI("out.pojo")));

		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		env.registerMetaModel("POJO", pojo);
		env.registerInputModel("IN", in);
		env.registerOutputModel("OUT", out);
		final TimingData td = new TimingData();
		env.loadModule(moduleResolver, "EcoreToPOJO");
		td.finishLoading();
		env.run(td);
		td.finish();
		LOG.info("PojoModelTest#testEcoreToPOJO " + td.toString());

		final Resource ref = createPojoModel();
		assertEquals(ref.getContents().size(), out.getResource().getContents().size());
		assertEquals(1, ((PojoA) out.getResource().getContents().get(0)).getBList().size());
		assertEquals(1, ((PojoA) out.getResource().getContents().get(0)).getBSet().size());
		assertEquals(Collections.singleton("PojoB"), ((PojoA) out.getResource().getContents().get(0)).getBList().get(0).getNameSet());
		final List<TestEnum> enumList = new ArrayList<TestEnum>();
		enumList.add(TestEnum.OPTION_A);
		enumList.add(TestEnum.OPTION_B);
		assertEquals(enumList, ((PojoA) out.getResource().getContents().get(0)).getBList().get(0).getEnumList());
	}

}
