/*******************************************************************************
 * Copyright (c) 2008,2009 Communication & Systems.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Arnaud Giuliani - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.profiler.core.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

import org.eclipse.m2m.atl.profiler.core.ProfilerModelHandler;
import org.eclipse.m2m.atl.profiler.exportmodel.AtlOperationExport;
import org.eclipse.m2m.atl.profiler.exportmodel.ExportRoot;
import org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelFactory;
import org.eclipse.m2m.atl.profiler.exportmodel.ProfilingOperationExport;
import org.eclipse.m2m.atl.profiler.model.ATLOperation;
import org.eclipse.m2m.atl.profiler.model.ProfilingInstruction;
import org.eclipse.m2m.atl.profiler.model.ProfilingModel;
import org.eclipse.m2m.atl.profiler.model.ProfilingOperation;

/**
 * Export the Profiling model to a more simple model (ExportModel).
 * 
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 */
public final class ProfilerModelExporter {

	private ProfilerModelExporter() {
		super();
		// prevents instantiation
	}

	/**
	 * Exports the profiling model.
	 * 
	 * @return the export root
	 * @throws Exception
	 */
	public static ExportRoot exportCurrentProfilingModel() throws Exception {
		ExportRoot exportModel = null;
		ProfilingModel profilingModel = ProfilerModelHandler.getInstance().getProfilingModel();

		if (profilingModel != null) {
			exportModel = ExportmodelFactory.eINSTANCE.createExportRoot();
			Map<String, ATLOperation> atlOperationRegistry = ProfilerModelHandler.getInstance()
					.getOperationRegistry();

			// register root node
			final double globalTime = (profilingModel.getEndTime() - profilingModel.getLaunchedTime()) / 1000.0;
			final long totalExecutedInstructions = profilingModel.getTotalExecutedInstructions();

			exportModel.setTotalTime(globalTime);
			exportModel.setTotalInstructions(totalExecutedInstructions);

			NumberFormat nf = DecimalFormat.getNumberInstance(Locale.ENGLISH);
			nf.setMaximumFractionDigits(3);

			NumberFormat percentFormat = DecimalFormat.getPercentInstance(Locale.ENGLISH);
			percentFormat.setMaximumFractionDigits(3);

			// foreach rule
			for (ATLOperation atlOperation : atlOperationRegistry.values()) {

				AtlOperationExport atlOperationExport = ExportmodelFactory.eINSTANCE
						.createAtlOperationExport();

				double atlOpTime = 0.0;
				long atlOpExecutedinstructions = 0;
				long atlOpInMemory = 0;
				long atlOpMaxMemory = 0;
				long atlOpMaxEndMemory = 0;

				for (ProfilingInstruction pi : atlOperation.getProfilingInstructions()) {

					if (pi instanceof ProfilingOperation) {
						ProfilingOperation profilingOperation = (ProfilingOperation)pi;

						ProfilingOperationExport profilingOperationExport = ExportmodelFactory.eINSTANCE
								.createProfilingOperationExport();
						profilingOperationExport.setName(profilingOperation.getContent());

						double duration = ProfilingModelUtils.getDuration(profilingOperation);

						profilingOperationExport.setTimExecution(duration);
						atlOpTime += duration;

						double pDuration = duration / globalTime;
						profilingOperationExport
								.setTotalTimeExecutionPercent(percentFormat.format(pDuration));

						int profOpexecutedinstructions = profilingOperation.getTotalExecutedInstructions();
						profilingOperationExport.setInstructions(profOpexecutedinstructions);
						atlOpExecutedinstructions += profOpexecutedinstructions;

						double ptotalInstructions = (double)profOpexecutedinstructions
								/ totalExecutedInstructions;
						profilingOperationExport.setTotalInstructionsPercent(percentFormat
								.format(ptotalInstructions));

						long launchKbytesMemUsage = ProfilingModelUtils
								.getLaunchKbytesMemUsage(profilingOperation);
						profilingOperationExport.setBeginMemory(launchKbytesMemUsage);
						if (atlOpInMemory == 0) {
							atlOpInMemory = launchKbytesMemUsage;
						} else if (launchKbytesMemUsage < atlOpInMemory) {
							atlOpInMemory = launchKbytesMemUsage;
						}

						long maxKbytesMemUsage = ProfilingModelUtils.getMaxKbytesMemUsage(profilingOperation);
						profilingOperationExport.setMaxMemory(maxKbytesMemUsage);
						if (atlOpMaxMemory == 0) {
							atlOpMaxMemory = maxKbytesMemUsage;
						} else if (maxKbytesMemUsage < atlOpMaxMemory) {
							atlOpMaxMemory = maxKbytesMemUsage;
						}

						long endKbytesMemUsage = ProfilingModelUtils.getEndKbytesMemUsage(profilingOperation);
						profilingOperationExport.setEndMemory(endKbytesMemUsage);
						if (atlOpMaxEndMemory == 0) {
							atlOpMaxEndMemory = endKbytesMemUsage;
						} else if (endKbytesMemUsage < atlOpMaxEndMemory) {
							atlOpMaxEndMemory = endKbytesMemUsage;
						}

						atlOperationExport.getProfilingOperation().add(profilingOperationExport);
					}
				}

				atlOperationExport.setName(atlOperation.getName());
				Double dAtlOpTime = new Double(nf.format(atlOpTime));

				atlOperationExport.setTimExecution(dAtlOpTime);
				atlOperationExport.setInstructions(atlOpExecutedinstructions);
				atlOperationExport.setBeginMemory(atlOpInMemory);
				atlOperationExport.setMaxMemory(atlOpMaxMemory);
				atlOperationExport.setEndMemory(atlOpMaxEndMemory);

				double pAtlOpExecutedinstructions = (double)atlOpExecutedinstructions
						/ totalExecutedInstructions;

				atlOperationExport.setTotalInstructionsPercent(percentFormat
						.format(pAtlOpExecutedinstructions));

				double pAtlOpTime = atlOpTime / globalTime;

				atlOperationExport.setTotalTimeExecutionPercent(percentFormat.format(pAtlOpTime));

				exportModel.getOperation().add(atlOperationExport);
			}
		}
		return exportModel;
	}

}
