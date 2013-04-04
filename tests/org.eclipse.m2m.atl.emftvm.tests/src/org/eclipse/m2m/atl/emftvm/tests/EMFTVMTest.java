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
package org.eclipse.m2m.atl.emftvm.tests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.ReferenceOrderChange;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.osgi.framework.Bundle;

/**
 * Abstract unit test base class for EMFTVM.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public abstract class EMFTVMTest extends TestCase {

	public static final String PLUGIN_ID = "org.eclipse.m2m.atl.emftvm.tests";
	public static final String PLUGIN_URI = "platform:/plugin/" + PLUGIN_ID;
	public static final String EMFTVM_PLUGIN_ID = "org.eclipse.m2m.atl.emftvm";
	public static final String EMFTVM_PLUGIN_URI = "platform:/plugin/" + EMFTVM_PLUGIN_ID;
	public static final String COMPILER_PLUGIN_ID = "org.eclipse.m2m.atl.emftvm.compiler";
	public static final String COMPILER_PLUGIN_URI = "platform:/plugin/" + COMPILER_PLUGIN_ID;
	public static final String COMMON_PLUGIN_ID = "org.eclipse.m2m.atl.common";
	public static final String COMMON_PLUGIN_URI = "platform:/plugin/" + COMMON_PLUGIN_ID;

	public static final Bundle bundle = Platform.getBundle(PLUGIN_ID);

	/**
	 * Asserts that leftResource and rightResource are equal. Uses EMF Compare.
	 * @param leftObject
	 * @param rightObject
	 */
	public static void assertEquals(Resource leftResource, Resource rightResource) {
		final Map<String, Object> options = new HashMap<String, Object>();
		options.put(MatchOptions.OPTION_IGNORE_XMI_ID, Boolean.TRUE);
		try {
			final MatchModel match = MatchService.doResourceMatch(leftResource, rightResource, options);
			assertTrue(match.getUnmatchedElements().isEmpty());
			if (!leftResource.getContents().isEmpty()) {
				assertFalse(match.getMatchedElements().isEmpty());
			}
			final DiffModel diff = DiffService.doDiff(match);
			assertTrue(diff.getOwnedElements().size() == 1);
			for (Iterator<EObject> allContents = diff.eAllContents(); allContents.hasNext();) {
				EObject de = allContents.next();
				// allow only certain kinds of diff elements
				assertTrue(de instanceof DiffGroup || de instanceof ReferenceOrderChange);
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Creates a new {@link EMFTVMTest}.
	 */
	public EMFTVMTest() {
		super();
	}

	/**
	 * Creates a new {@link EMFTVMTest}.
	 * 
	 * @param name
	 *            the test name
	 */
	public EMFTVMTest(String name) {
		super(name);
	}

}