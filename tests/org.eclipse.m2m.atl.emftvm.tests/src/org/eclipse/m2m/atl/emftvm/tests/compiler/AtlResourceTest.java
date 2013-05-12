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
package org.eclipse.m2m.atl.emftvm.tests.compiler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.emftvm.compiler.AtlResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.compiler.AtlResourceImpl;

/**
 * Tests {@link AtlResourceImpl}.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class AtlResourceTest extends TestCase {

	protected final AtlResourceFactoryImpl atlResourceFactory = new AtlResourceFactoryImpl();

	/**
	 * Test method for {@link AtlResourceImpl#load(java.io.InputStream, java.util.Map)}.
	 * 
	 * @throws IOException
	 */
	public void testLoadInputStreamMapOfQQ() throws IOException {
		final AtlResourceImpl atlResourceImpl = createAtlResource();
		assertTrue(atlResourceImpl.isTrackingModification());
		assertTrue(atlResourceImpl.getContents().isEmpty());

		final InputStream inputStream = AtlResourceTest.class.getResourceAsStream("/test-data/AnyTest.atl");
		try {
			atlResourceImpl.load(inputStream, Collections.emptyMap());
		} finally {
			inputStream.close();
		}

		assertFalse(atlResourceImpl.getContents().isEmpty());
		assertFalse(atlResourceImpl.isModified());

		final EObject query = atlResourceImpl.getContents().get(0);
		final EStructuralFeature name = query.eClass().getEStructuralFeature("name");
		query.eSet(name, "AnyTest2");
		assertTrue(atlResourceImpl.isModified());
	}

	/**
	 * Test method for {@link AtlResourceImpl#load(java.io.InputStream, java.util.Map)}.
	 * 
	 * @throws IOException
	 */
	public void testSaveOutputStreamMapOfQQ() throws IOException {
		final AtlResourceImpl atlResourceImpl = createAtlResource();
		assertTrue(atlResourceImpl.isTrackingModification());
		assertTrue(atlResourceImpl.getContents().isEmpty());

		final InputStream inputStream = AtlResourceTest.class.getResourceAsStream("/test-data/AnyTest.atl");
		final ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			final byte[] buf = new byte[1024];
			int read;
			while ((read = inputStream.read(buf)) > 0) {
				bos.write(buf, 0, read);
			}
		} finally {
			inputStream.close();
		}
		atlResourceImpl.load(new ByteArrayInputStream(bos.toByteArray()), Collections.emptyMap());

		assertFalse(atlResourceImpl.getContents().isEmpty());
		assertFalse(atlResourceImpl.isModified());

		// AtlResourceImpl should write the exact input bytes if no change occurred
		{
			final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			atlResourceImpl.save(outputStream, Collections.emptyMap());
			outputStream.flush();
			assertEquals(bos.toString(), outputStream.toString());
		}
		// Change the resource
		{
			final EObject query = atlResourceImpl.getContents().get(0);
			final EStructuralFeature name = query.eClass().getEStructuralFeature("name");
			query.eSet(name, "AnyTest2");
			assertTrue(atlResourceImpl.isModified());
		}
		// AtlResourceImpl should write different bytes if change occurred
		{
			final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			atlResourceImpl.save(outputStream, Collections.emptyMap());
			outputStream.flush();
			ATLLogger.info(outputStream.toString());
			assertFalse(bos.toString().equals(outputStream.toString()));
		}
	}

	/**
	 * Returns a new {@link AtlResourceImpl}.
	 * 
	 * @return a new {@link AtlResourceImpl}
	 */
	protected AtlResourceImpl createAtlResource() {
		final ResourceSet rs = new ResourceSetImpl();
		final AtlResourceImpl resource = (AtlResourceImpl) atlResourceFactory.createResource(URI.createURI("AtlResourceTest.atl"));
		rs.getResources().add(resource);
		return resource;
	}

}
