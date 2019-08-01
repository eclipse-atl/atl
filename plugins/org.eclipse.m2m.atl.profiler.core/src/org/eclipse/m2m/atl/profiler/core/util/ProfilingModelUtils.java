/*******************************************************************************
 * Copyright (c) 2008,2009 Communication & Systems.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Arnaud Giuliani - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.profiler.core.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.m2m.atl.profiler.model.ATLOperation;
import org.eclipse.m2m.atl.profiler.model.ProfilingInstruction;
import org.eclipse.m2m.atl.profiler.model.ProfilingOperation;

/**
 * Class utility to help about statistical operations.
 * 
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 */
public final class ProfilingModelUtils {

	private ProfilingModelUtils() {
		super();
		// prevents instantiation
	}

	/**
	 * Returns the duration of the given operation.
	 * 
	 * @param op
	 *            the operation
	 * @return the duration of the given operation
	 */
	public static double getDuration(ProfilingOperation op) {
		double time = 0.0;
		time = op.getEndTime() - op.getLaunchedTime();
		time = time / 1000.0;
		return time;
	}

	/**
	 * Returns the launch memory usage.
	 * 
	 * @param op
	 *            the operation
	 * @return the memory usage
	 */
	public static long getLaunchKbytesMemUsage(ProfilingOperation op) {
		return divideLongBy1000(op.getLaunchedMemoryUsage());
	}

	/**
	 * Returns the end memory usage.
	 * 
	 * @param op
	 *            the operation
	 * @return the memory usage
	 */
	public static long getEndKbytesMemUsage(ProfilingOperation op) {
		return divideLongBy1000(op.getEndMemoryUsage());
	}

	/**
	 * Returns the max memory usage.
	 * 
	 * @param op
	 *            the operation
	 * @return the memory usage
	 */
	public static long getMaxKbytesMemUsage(ProfilingOperation op) {
		return divideLongBy1000(op.getMaxMemoryUsage());
	}

	private static long divideLongBy1000(long l) {
		long mem = 0;
		mem = l / 1000;
		return mem;
	}

	/**
	 * Returns the total time.
	 * 
	 * @param profilingInstructions
	 *            the profiling instructions
	 * @return the total time
	 */
	public static double getTotalTime(EList<ProfilingInstruction> profilingInstructions) {
		double total = 0;
		for (ProfilingInstruction pi : profilingInstructions) {
			if (pi instanceof ProfilingOperation) {
				ProfilingOperation po = (ProfilingOperation)pi;
				total += po.getEndTime() - po.getLaunchedTime();
			}
		}
		total = total / 1000.0;
		return total;
	}

	/**
	 * Returns the total instructions.
	 * 
	 * @param op
	 *            the atl operation
	 * @return the total instructions
	 */
	public static int getTotalInstruction(ATLOperation op) {
		EList<ProfilingInstruction> profilingInstructions = op.getProfilingInstructions();
		int total = 0;
		for (ProfilingInstruction pi : profilingInstructions) {
			if (pi instanceof ProfilingOperation) {
				ProfilingOperation po = (ProfilingOperation)pi;
				total += po.getTotalExecutedInstructions();
			}
		}
		return total;
	}

	/**
	 * Returns the total memory.
	 * 
	 * @param profilingInstructions
	 *            the profiling instructions
	 * @return the total memory
	 */
	public static long getTotalMemory(EList<ProfilingInstruction> profilingInstructions) {
		long total = 0;
		for (ProfilingInstruction pi : profilingInstructions) {
			if (pi instanceof ProfilingOperation) {
				ProfilingOperation po = (ProfilingOperation)pi;
				total += po.getEndMemoryUsage() - po.getLaunchedMemoryUsage();
			}
		}
		return total;
	}

	/**
	 * Returns the min in memory usage.
	 * 
	 * @param atlOp
	 *            the atl operation
	 * @return the min in memory usage
	 */
	public static long getMinInMemoryUsage(ATLOperation atlOp) {
		long minStartMem = 0;
		for (ProfilingInstruction pi : atlOp.getProfilingInstructions()) {
			if (pi instanceof ProfilingOperation) {
				ProfilingOperation pOp = (ProfilingOperation)pi;
				if (minStartMem > pOp.getLaunchedMemoryUsage() || minStartMem == 0) {
					minStartMem = pOp.getLaunchedMemoryUsage();
				}
			}
		}
		return minStartMem;
	}

	/**
	 * Returns the max out memory usage.
	 * 
	 * @param atlOp
	 *            the atl operation
	 * @return the max out memory usage
	 */
	public static long getMaxOutMemoryUsage(ATLOperation atlOp) {
		long maxEndMem = 0;
		for (ProfilingInstruction pi : atlOp.getProfilingInstructions()) {
			if (pi instanceof ProfilingOperation) {
				ProfilingOperation pOp = (ProfilingOperation)pi;
				if (maxEndMem < pOp.getEndMemoryUsage() || maxEndMem == 0) {
					maxEndMem = pOp.getEndMemoryUsage();
				}
			}
		}
		return maxEndMem;
	}

	/**
	 * Returns the max max memory usage.
	 * 
	 * @param atlOp
	 *            the atl operation
	 * @return the max max memory usage
	 */
	public static long getMaxMaxMemoryUsage(ATLOperation atlOp) {
		long maxMaxMem = 0;
		for (ProfilingInstruction pi : atlOp.getProfilingInstructions()) {
			if (pi instanceof ProfilingOperation) {
				ProfilingOperation pOp = (ProfilingOperation)pi;
				if (maxMaxMem < pOp.getMaxMemoryUsage() || maxMaxMem == 0) {
					maxMaxMem = pOp.getMaxMemoryUsage();
				}
			}
		}
		return maxMaxMem;
	}

}
