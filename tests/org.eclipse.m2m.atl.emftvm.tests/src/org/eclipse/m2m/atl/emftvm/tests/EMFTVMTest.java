/*******************************************************************************
 * Copyright (c) 2013 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.tests;

import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.logging.Logger;

import junit.framework.TestCase;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.diff.DefaultDiffEngine;
import org.eclipse.emf.compare.diff.DiffBuilder;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.EMFTVMUtil;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.osgi.framework.Bundle;

/**
 * Abstract unit test base class for EMFTVM.
 * 
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
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
	 * @param leftResource
	 *            the left-hand resource to compare
	 * @param rightResource
	 *            the right-hand resource to compare
	 */
	public static void assertEquals(Resource leftResource, Resource rightResource) {
		final BasicMonitor monitor = new BasicMonitor();
		final DefaultComparisonScope scope = new DefaultComparisonScope(leftResource, rightResource, null);
		final Comparison match = DefaultMatchEngine.create(UseIdentifiers.NEVER).match(scope, monitor);
		if (!leftResource.getContents().isEmpty()) {
			assertFalse("Match model is empty: " + match.getMatches(), match.getMatches().isEmpty());
		}
		new DefaultDiffEngine(new DiffBuilder()).diff(match, monitor);
		for (Diff diff : match.getDifferences()) {
			// allow only certain kinds of diff elements
			if (diff instanceof ReferenceChange && ((ReferenceChange) diff).getKind() == DifferenceKind.CHANGE) {
				assertEquals(diff.getMatch().getLeft(), diff.getMatch().getRight(), ((ReferenceChange) diff).getReference());
			} else {
				fail("Difference found: " + diff);
			}
		}
	}

	/**
	 * Asserts that <code>left.ref</code> and <code>right.ref</code> point to equal values.
	 * 
	 * @param left
	 *            the left-hand object to compare
	 * @param right
	 *            the right-hand object to compare
	 * @param ref
	 *            the {@link EReference} of which to compare the values
	 */
	public static void assertEquals(final EObject left, final EObject right, final EReference ref) {
		if (ref.isMany()) {
			final Collection<?> leftValue = (Collection<?>) left.eGet(ref);
			final Collection<?> rightValue = (Collection<?>) right.eGet(ref);
			final String errorMsg = String.format("Different value found on %s.%s (%s) and %s.%s (%s)",
					EMFTVMUtil.toPrettyString(left, null), ref.getName(), EMFTVMUtil.toPrettyString(leftValue, null),
					EMFTVMUtil.toPrettyString(right, null), ref.getName(), EMFTVMUtil.toPrettyString(rightValue, null));
			
			assertEquals(errorMsg, leftValue.size(), rightValue.size());
			final Iterator<?> leftVs = leftValue.iterator();
			final Iterator<?> rightVs = rightValue.iterator();
			while (leftVs.hasNext()) {
				// Reference to same object by URI - only target objects are different instances
				assertSameURI(errorMsg, (EObject) leftVs.next(), (EObject) rightVs.next());
			}
		} else {
			final EObject leftValue = left == null ? null : (EObject) left.eGet(ref);
			final EObject rightValue = right == null ? null : (EObject) right.eGet(ref);
			final String errorMsg = String.format("Different value found on %s.%s (%s) and %s.%s (%s)",
					EMFTVMUtil.toPrettyString(left, null), ref.getName(), EMFTVMUtil.toPrettyString(leftValue, null),
					EMFTVMUtil.toPrettyString(right, null), ref.getName(), EMFTVMUtil.toPrettyString(rightValue, null));
			// Reference to same object by URI - only target objects are different instances
			assertSameURI(errorMsg, leftValue, rightValue);
		}
	}

	/**
	 * Asserts that <code>leftValue</code> and <code>rightValue</code> have the same EMF URI.
	 * 
	 * @param errorMsg
	 *            the error message to display on assertion failure
	 * @param leftValue
	 *            the left-hand value to compare
	 * @param rightValue
	 *            the right-hand value to compare
	 */
	private static void assertSameURI(final String errorMsg, final EObject leftValue, final EObject rightValue) {
		assertEquals(errorMsg, leftValue == null ? null : leftValue.eResource().getURI(), 
				rightValue == null ? null : rightValue.eResource().getURI());
		assertEquals(errorMsg, leftValue == null ? null : leftValue.eResource().getURIFragment(leftValue), 
				rightValue == null ? null : rightValue.eResource().getURIFragment(rightValue));
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
						.append("\tMinimum time:\t%f\t%f\n").append("\tFirst quartile:\t%f\t%f\n").append("\tMedian time:\t%f\t%f\n")
						.append("\tThird quartile:\t%f\t%f\n").append("\tMaximum time:\t%f\t%f\n")
						.append("\tTransactions per second (median):\t%f\ton\t%d\tthread(s)\n").append("\tHeap space used:\t%d\tMB")
						.toString(), prefix, min / 1E6, pureMin / 1E6, firstQuartile / 1E6, pureFirstQuartile / 1E6, median / 1E6,
				pureMedian / 1E6, thirdQuartile / 1E6, pureThirdQuartile / 1E6, max / 1E6, pureMax / 1E6, 1E9 * threadCount / median,
				threadCount, (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024)));
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

	/**
	 * Loads a {@link Model} instance for the given file name.
	 * 
	 * @param rs
	 *            the {@link ResourceSet} to use for loading
	 * @param file
	 *            the file name relative to {@value #PLUGIN_URI}.
	 * @return the {@link Model} instance for the given file name
	 */
	public Model loadTestModel(final ResourceSet rs, final String file) {
		final Model model = EmftvmFactory.eINSTANCE.createModel();
		model.setResource(rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + file, true), true));
		return model;
	}

	/**
	 * Loads a {@link Metamodel} instance for the given file name.
	 * 
	 * @param rs
	 *            the {@link ResourceSet} to use for loading
	 * @param file
	 *            the file name relative to {@value #PLUGIN_URI}.
	 * @return the {@link Metamodel} instance for the given file name
	 */
	public Metamodel loadTestMetamodel(final ResourceSet rs, final String file) {
		final Metamodel model = EmftvmFactory.eINSTANCE.createMetamodel();
		model.setResource(rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + file, true), true));
		return model;
	}

	/**
	 * Creates a new {@link Model} instance for the given file name.
	 * 
	 * @param rs
	 *            the {@link ResourceSet} to use for creating
	 * @param file
	 *            the file name relative to {@value #PLUGIN_URI}.
	 * @return the {@link Model} instance for the given file name
	 */
	public Model createTestModel(final ResourceSet rs, final String file) {
		final Model model = EmftvmFactory.eINSTANCE.createModel();
		model.setResource(rs.createResource(URI.createPlatformPluginURI(PLUGIN_ID + file, true)));
		return model;
	}

	/**
	 * Creates a new {@link ModuleResolver} for testing. Uses {@value #PLUGIN_URI} + "/test-data/" as module path.
	 * 
	 * @return a new {@link ModuleResolver} for testing
	 */
	public ModuleResolver createTestModuleResolver() {
		return new DefaultModuleResolver(PLUGIN_URI + "/test-data/", new ResourceSetImpl());
	}

}