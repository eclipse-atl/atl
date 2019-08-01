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
package org.eclipse.m2m.atl.profiler.core;

import java.util.Observable;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.profiler.core.exception.InterceptedLeavingStackFrameException;
import org.eclipse.m2m.atl.profiler.core.exception.NoRegisteredOperationFoundException;
import org.eclipse.m2m.atl.profiler.core.vm.IOperation;
import org.eclipse.m2m.atl.profiler.core.vm.IStackFrame;
import org.eclipse.m2m.atl.profiler.model.ATLOperation;
import org.eclipse.m2m.atl.profiler.model.ProfilingInstruction;
import org.eclipse.m2m.atl.profiler.model.ProfilingModel;
import org.eclipse.m2m.atl.profiler.model.ProfilingOperation;

/**
 * <b>ATLProfiler</b> is a component that dispatch ATL debugging information to ATLModelHandler &
 * ProfilerModelHandler. This class is used by the ProflingDebugger class.
 * 
 * @see org.eclipse.m2m.atl.profiler.core.ATLModelHandler
 * @see org.eclipse.m2m.atl.profiler.core.ProfilerModelHandler
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 */
public final class ATLProfiler extends Observable {

	private static ATLProfiler instance;

	// parameters
	private boolean seeTreeExecution;

	private boolean seeDebugMessages;

	private boolean seeRegistry;

	private ATLProfiler() {

	}

	/**
	 * Singleton access.
	 * 
	 * @return the {@link ATLProfiler} singleton
	 */
	public static ATLProfiler getInstance() {
		if (instance == null) {
			instance = new ATLProfiler();
		}
		return instance;
	}

	/**
	 * Prepare atl & profiler model handlers with the ATL model.
	 * 
	 * @param model
	 *            the ATL model
	 */
	public void initProfiler(EObject model) {
		// profiler model init & set debug mode to off
		ProfilerModelHandler.getInstance().init();
		ProfilerModelHandler.getInstance().setDebugMessages(seeDebugMessages);
		// atl model handler
		ATLModelHandler.getInstance().init();
		ATLModelHandler.getInstance().registerATLModel(model);
	}

	/**
	 * Intercept the beginning of an operation execution.<br>
	 * Delegate operation creation to {@link ProfilerModelHandler}.<br>
	 * Create entry in the operation registry ({@link ProfilerModelHandler}).
	 * 
	 * @param frame
	 *            the stack frame
	 */
	public void interceptEnter(IStackFrame frame) {
		// if (frame instanceof ASMStackFrame) {
		IOperation sfOp = frame.getIOperation();
		// format to ATL names
		String sfOpName = ATLModelHandler.getInstance().getATLName(sfOp.getName());

		// check for ATL element
		ATLOperation atlOperation = ProfilerModelHandler.getInstance().getOperationRegistry().get(sfOpName);
		EObject atlElement = null;
		if (atlOperation == null) {
			// atl element not yet linked
			atlElement = ATLModelHandler.getInstance().getATLOperationFromName(sfOpName);
		}
		// send infos for new operation in model
		ProfilerModelHandler.getInstance().newOperation(sfOpName, frame, atlOperation, atlElement);
		// }
	}

	/**
	 * Intercept the exiting of an operation execution.<br>
	 * Delegate operation closure to {@link ProfilerModelHandler}.<br>
	 * Check entry in the operation registry.
	 * 
	 * @param frame
	 *            the stack frame
	 */
	public void interceptLeave(IStackFrame frame) {
		// if (frame instanceof ASMStackFrame) {
		IOperation sfOp = frame.getIOperation();
		// format name
		String sfOpName = ATLModelHandler.getInstance().getATLName(sfOp.getName());

		// send infos for closing current frame
		try {
			ProfilerModelHandler.getInstance().closeOperation(sfOpName, frame);
		} catch (NoRegisteredOperationFoundException e) {
			e.printStackTrace();
		} catch (InterceptedLeavingStackFrameException e) {
			e.printStackTrace();
		}
		// }
	}

	/**
	 * Intercept simple instruction execution.<br>
	 * Delegate step creation to {@link ProfilerModelHandler}.<br>
	 * 
	 * @param frame
	 *            the stack frame
	 */
	public void interceptStep(IStackFrame frame) {
		ProfilerModelHandler.getInstance().makeStep(frame);
	}

	/**
	 * Intercept errors.
	 * 
	 * @param frame
	 *            the stack frame
	 * @param msg
	 *            (message)
	 * @param e
	 *            (stacktrace)
	 */
	public void interceptError(IStackFrame frame, String msg, Throwable e) {
		ProfilerModelHandler.getInstance().interceptError(frame, msg, e);
		ATLLogger.info("\nMessage : " + msg + "\nFrame : " + frame + "\nException : " + e); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * Intercept execution end.<br>
	 * Close last operation and notify profiler model to listeners components.
	 */
	public void interceptTerminated() {

		ProfilerModelHandler.getInstance().endExecution();

		// printProfilingSummary();

		ProfilingModel profilingModel = ProfilerModelHandler.getInstance().getProfilingModel();

		printTreeExecution(profilingModel, 0);

		this.setChanged();
		notifyObservers(profilingModel);
		this.clearChanged();
	}

	/**
	 * Print short profiling summary.
	 */
	public void printProfilingSummary() {
		String total = "\n===" + Messages.getString("ATLProfiler.PROFILING") + "===\n"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		// string for profiling summary
		total += profilingSummary();
		// string for registry infos
		if (seeRegistry) {
			total += registrySummary();
		}
		total += "\n===" + Messages.getString("ATLProfiler.PROFILING") + "===\n\n"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		ATLLogger.info(total);
	}

	/**
	 * Create string message for summary.
	 * 
	 * @return profiling summary
	 */
	private String profilingSummary() {
		double eta = (ProfilerModelHandler.getInstance().getProfilingModel().getEndTime() - ProfilerModelHandler
				.getInstance().getProfilingModel().getLaunchedTime()) / 1000.;
		String msg = Messages.getString("ATLProfiler.TOTAL_INSTRUCTIONS") //$NON-NLS-1$
				+ ProfilerModelHandler.getInstance().getProfilingModel().getTotalExecutedInstructions();
		msg += Messages.getString("ATLProfiler.EXECUTED_IN", new Object[] {eta,}); //$NON-NLS-1$
		return msg;
	}

	/**
	 * Return operation registry in String format.
	 * 
	 * @return
	 */
	private String registrySummary() {
		String print = Messages.getString("ATLProfiler.REGISTERED_OPERATIONS"); //$NON-NLS-1$
		for (ATLOperation op : ProfilerModelHandler.getInstance().getOperationRegistry().values()) {
			print += Messages.getString("ATLProfiler.CALL", new Object[] {op.getName(), op.getCalls(),}); //$NON-NLS-1$
		}
		print += " ---------------------------- \n"; //$NON-NLS-1$
		return print;
	}

	/**
	 * Print execution of the profiled model.
	 * 
	 * @param operation
	 *            (profiled operation)
	 * @param i
	 *            (indentation level ; begin at 0)
	 */
	private void printTreeExecution(ProfilingOperation operation, int i) {
		// print tree execution
		if (seeTreeExecution) {
			printBlanks(i);
			double time = (operation.getEndTime() - operation.getLaunchedTime()) / 1000.;
			ATLLogger
					.info(Messages
							.getString(
									"ATLProfiler.INSTRUCTIONS", new Object[] {operation.getAtlInstruction().getName(), operation.getTotalExecutedInstructions(), time,})); //$NON-NLS-1$
			i++;
			for (ProfilingInstruction inst : operation.getExecutionInstructions()) {
				printBlanks(i);
				if (inst instanceof ProfilingOperation) {
					printTreeExecution((ProfilingOperation)inst, i);
				} else {
					printProfiling(inst, i);
				}
			}
		}
	}

	/**
	 * Print profiling execution.
	 * 
	 * @see printTreeExecution
	 * @param inst
	 * @param i
	 */
	private void printProfiling(ProfilingInstruction inst, int i) {
		i++;
		printBlanks(i);
		ATLLogger.info("-inst- " + inst.getContent()); //$NON-NLS-1$
	}

	/**
	 * Print blanks for printProfiling method.
	 * 
	 * @param i
	 */
	private void printBlanks(int i) {
		while (i > 0) {
			ATLLogger.info(" "); //$NON-NLS-1$
			i--;
		}
	}
}
