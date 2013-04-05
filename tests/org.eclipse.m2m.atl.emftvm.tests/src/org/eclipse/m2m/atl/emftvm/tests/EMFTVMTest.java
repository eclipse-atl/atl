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
import java.util.SortedSet;
import java.util.logging.Logger;

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

	private static final Logger LOG = Logger.getLogger(EMFTVMTest.class.getName());

	/**
	 * Asserts that leftResource and rightResource are equal. Uses EMF Compare.
	 * 
	 * @param leftObject
	 * @param rightObject
	 */
	public static void assertEquals(Resource leftResource, Resource rightResource) {
		final Map<String, Object> options = new HashMap<String, Object>();
		options.put(MatchOptions.OPTION_IGNORE_XMI_ID, Boolean.TRUE);
		try {
			final MatchModel match = MatchService.doResourceMatch(leftResource, rightResource, options);
			assertTrue("Unmatched elements not empty: " + match.getUnmatchedElements(), match.getUnmatchedElements().isEmpty());
			if (!leftResource.getContents().isEmpty()) {
				assertFalse(match.getMatchedElements().isEmpty());
			}
			final DiffModel diff = DiffService.doDiff(match);
			assertTrue("Diff model has != 1 elements: " + diff.getOwnedElements(), diff.getOwnedElements().size() == 1);
			for (Iterator<EObject> allContents = diff.eAllContents(); allContents.hasNext();) {
				EObject de = allContents.next();
				// allow only certain kinds of diff elements
				assertTrue("Difference found: " + de, de instanceof DiffGroup || de instanceof ReferenceOrderChange);
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Processes and logs timing statistics.
	 * 
	 * @param prefix
	 *            the log message prefix string
	 * @param timings
	 *            the timings to process
	 * @param pureTimings
	 *            the pure runtime timings (without loading time)
	 * @param threadCount
	 *            the number of threads used for testing
	 */
	public static void processTimings(final String prefix, final SortedSet<Long> timings, final SortedSet<Long> pureTimings,
			final int threadCount) {
		long median = -1L;
		long firstQuartile = -1L;
		long thirdQuartile = -1L;
		long max = 0L;
		long min = Long.MAX_VALUE;
		int i = 0;
		for (long timing : timings) {
			max = Math.max(max, timing);
			min = Math.min(min, timing);
			i++;
			if (firstQuartile < 0L && i >= timings.size() / 4) {
				firstQuartile = timing;
			}
			if (median < 0L && i >= timings.size() / 2) {
				median = timing;
			}
			if (thirdQuartile < 0L && i >= timings.size() * 3 / 4) {
				thirdQuartile = timing;
			}
		}
		long pureMedian = -1L;
		long pureFirstQuartile = -1L;
		long pureThirdQuartile = -1L;
		long pureMax = 0L;
		long pureMin = Long.MAX_VALUE;
		i = 0;
		for (long timing : pureTimings) {
			pureMax = Math.max(pureMax, timing);
			pureMin = Math.min(pureMin, timing);
			i++;
			if (pureFirstQuartile < 0L && i >= pureTimings.size() / 4) {
				pureFirstQuartile = timing;
			}
			if (pureMedian < 0L && i >= pureTimings.size() / 2) {
				pureMedian = timing;
			}
			if (pureThirdQuartile < 0L && i >= pureTimings.size() * 3 / 4) {
				pureThirdQuartile = timing;
			}
		}
		final Runtime runtime = Runtime.getRuntime();
		LOG.info(String.format(
				new StringBuilder("%s\n\tDuration (msec)\tOverall runtime\tPure runtime (without loading)\n")
						.append("\tMinimum time:\t%f\t%f\n")
						.append("\tFirst quartile:\t%f\t%f\n")
						.append("\tMedian time:\t%f\t%f\n")
						.append("\tThird quartile:\t%f\t%f\n")
						.append("\tMaximum time:\t%f\t%f\n")
						.append("\tTransactions per second (median):\t%f\ton\t%d\tthread(s)\n")
						.append("\tHeap space used:\t%d\tMB")
						.toString(), 
						prefix, 
						min / 1E6, pureMin / 1E6,
						firstQuartile / 1E6, pureFirstQuartile / 1E6,
						median / 1E6, pureMedian / 1E6,
						thirdQuartile / 1E6, pureThirdQuartile / 1E6,
						max / 1E6, pureMax / 1E6,
						1E9 * threadCount / median, 
						threadCount, 
						(runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024)));
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