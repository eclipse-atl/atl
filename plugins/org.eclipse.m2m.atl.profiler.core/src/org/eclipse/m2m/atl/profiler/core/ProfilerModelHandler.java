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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.profiler.core.exception.InterceptedLeavingStackFrameException;
import org.eclipse.m2m.atl.profiler.core.exception.NoRegisteredOperationFoundException;
import org.eclipse.m2m.atl.profiler.core.vm.IStackFrame;
import org.eclipse.m2m.atl.profiler.model.ATLOperation;
import org.eclipse.m2m.atl.profiler.model.Context;
import org.eclipse.m2m.atl.profiler.model.ExecutionError;
import org.eclipse.m2m.atl.profiler.model.ModelFactory;
import org.eclipse.m2m.atl.profiler.model.ProfilingInstruction;
import org.eclipse.m2m.atl.profiler.model.ProfilingModel;
import org.eclipse.m2m.atl.profiler.model.ProfilingOperation;

/**
 * Class that build the profiling model.
 * 
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 */
public final class ProfilerModelHandler {
	// access
	private static ProfilerModelHandler instance;

	// fields
	private ProfilingModel profilingModel; // the model

	private ProfilingOperation currentOperation; // current ASM operation

	private Map<String, ATLOperation> operationRegistry; // registry to check executed operations

	private int currentInstructionID;

	// debug
	private boolean seeDebugMessages;

	private boolean hasTocreateStep;

	private ProfilerModelHandler() {

	}

	/**
	 * Singleton access.
	 * 
	 * @return the {@link ProfilerModelHandler} singleton instance
	 */
	public static ProfilerModelHandler getInstance() {
		if (instance == null) {
			instance = new ProfilerModelHandler();
		}
		return instance;
	}

	/**
	 * Initialize the model.
	 */
	public void init() {
		// init profiling model
		profilingModel = ModelFactory.eINSTANCE.createProfilingModel();
		// init ref to null
		currentOperation = null;
		// init ID ref instructions
		currentInstructionID = 0;
		// operations register
		operationRegistry = new HashMap<String, ATLOperation>();
	}

	/**
	 * Create new operation node or start with the root model.
	 * 
	 * @param sfOpName
	 *            the operation name
	 * @param frame
	 *            the frame
	 * @param atlOperation
	 *            the atl operation
	 * @param atlElement
	 *            the atl {@link EObject}
	 */
	public void newOperation(String sfOpName, IStackFrame frame, ATLOperation atlOperation, EObject atlElement) {

		// placing current operation node
		if (currentOperation == null) {
			// currentOperation empty => need to init to root
			currentOperation = profilingModel;
			profilingModel.setModelName(sfOpName);
		} else {
			// new operation node for currentOperation
			ProfilingOperation operation = ModelFactory.eINSTANCE.createProfilingOperation();
			operation.setParentOperation(currentOperation);
			currentOperation.getExecutionInstructions().add(operation);
			currentOperation = operation;
		}
		// execution informations
		currentInstructionID++;
		currentOperation.setInstructionID(currentInstructionID);
		currentOperation.setTotalExecutedInstructions(0);
		currentOperation.getStackFrames().add(frame);
		currentOperation.setLaunchedTime(System.currentTimeMillis());
		currentOperation.setContent("" + frame.getIOperation().getName()); //$NON-NLS-1$
		currentOperation.setHasError(false);

		// see if its a helper
		if (currentOperation.getContent().startsWith("__match")) { //$NON-NLS-1$
			currentOperation.setMatchingOperation(true);
		} else {
			currentOperation.setMatchingOperation(false);
		}

		fillContext(frame);

		// atl operation
		if (atlOperation == null) {
			// create operation
			atlOperation = ModelFactory.eINSTANCE.createATLOperation();
			// give atl name
			atlOperation.setName(sfOpName);
			// register operation
			operationRegistry.put(atlOperation.getName(), atlOperation);

			if (seeDebugMessages) {
				ATLLogger.info("*** registered operation <" + atlOperation.getName() + "," + atlOperation //$NON-NLS-1$//$NON-NLS-2$
						+ ">"); //$NON-NLS-1$
			}

			// link with ATL Model
			atlOperation.setATLElementRef(atlElement);

			if (seeDebugMessages) {
				ATLLogger.info("*** linked to atl element : " + atlOperation.getATLElementRef()); //$NON-NLS-1$
			}

		}
		atlOperation.setCalls(atlOperation.getCalls() + 1);

		// links
		currentOperation.setAtlInstruction(atlOperation);
		atlOperation.getProfilingInstructions().add(currentOperation);

		// memory usage
		long mem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		currentOperation.setLaunchedMemoryUsage(mem);

		// print
		if (seeDebugMessages) {
			ATLLogger.info("<" + atlOperation.getName() + "> beginning ..."); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * Fill context of profiling instruction from IStackFrame.
	 * 
	 * @param frame
	 */
	private void fillContext(IStackFrame frame) {
		for (Object s : frame.getLocalVariables().values().toArray()) {

			if (!s.toString().equals("[]")) { //$NON-NLS-1$
				Context c = ModelFactory.eINSTANCE.createContext();
				c.setContent(s.toString());
				currentOperation.getContext().add(c);
			}
		}
	}

	/***
	 * Prepare error object to show in the execution display.
	 * 
	 * @param frame
	 *            the frame
	 * @param msg
	 *            the error message
	 * @param e
	 *            the exception
	 */
	public void interceptError(IStackFrame frame, String msg, Throwable e) {

		if (msg != null && msg.length() > 0) {
			ExecutionError error = ModelFactory.eINSTANCE.createExecutionError();
			error.setMessage(msg);
			error.setFrames("" + frame); //$NON-NLS-1$
			currentOperation.getExecutionErrors().add(error);
		}

		if (!currentOperation.isHasError()) {
			currentOperation.setHasError(true);
			ProfilingOperation parentOp = currentOperation.getParentOperation();
			while (parentOp != null) {
				parentOp.setHasError(true);
				parentOp = parentOp.getParentOperation();
			}
		}
	}

	/**
	 * Close execution with current operation node.
	 * 
	 * @param sfOpName
	 *            the operation name
	 * @param frame
	 *            the frame
	 * @throws NoRegisteredOperationFoundException
	 * @throws InterceptedLeavingStackFrameException
	 */
	public void closeOperation(String sfOpName, IStackFrame frame)
			throws NoRegisteredOperationFoundException, InterceptedLeavingStackFrameException {

		// get related atl op
		ATLOperation atlOperation = operationRegistry.get(sfOpName);

		// checks
		if (atlOperation == null) {
			throw new NoRegisteredOperationFoundException(Messages.getString(
					"ProfilerModelHandler.OPERATION_NOT_FOUND", sfOpName)); //$NON-NLS-1$
		}

		if (!sfOpName.equals(currentOperation.getAtlInstruction().getName())) {
			throw new InterceptedLeavingStackFrameException(
					Messages
							.getString(
									"ProfilerModelHandler.LEAVING_STACK", sfOpName, currentOperation.getAtlInstruction().getName())); //$NON-NLS-1$
		}
		// register times & count executed instructions
		currentOperation.setTotalExecutedInstructions(countInstructions(currentOperation));

		currentOperation.setEndTime(System.currentTimeMillis());

		// print
		if (seeDebugMessages) {
			ATLLogger
					.info(Messages
							.getString(
									"ProfilerModelHandler.TERMINATED", sfOpName, currentOperation.getTotalExecutedInstructions())); //$NON-NLS-1$
		}

		long mem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		currentOperation.setEndMemoryUsage(mem);

		long maxMem = 0;
		if (maxMem < currentOperation.getLaunchedMemoryUsage()) {
			maxMem = currentOperation.getLaunchedMemoryUsage();
		} else if (maxMem < currentOperation.getEndMemoryUsage()) {
			maxMem = currentOperation.getEndMemoryUsage();
		}

		for (ProfilingInstruction pi : currentOperation.getExecutionInstructions()) {
			long tempMaxMem;
			if (pi instanceof ProfilingOperation) {
				ProfilingOperation po = (ProfilingOperation)pi;
				tempMaxMem = po.getMaxMemoryUsage();
			} else {
				tempMaxMem = pi.getLaunchedMemoryUsage();
			}

			if (tempMaxMem > maxMem) {
				maxMem = tempMaxMem;
			}
		}

		currentOperation.setMaxMemoryUsage(maxMem);
		// get the parent node operation
		currentOperation = currentOperation.getParentOperation();
	}

	/**
	 * Execute simple asm instruction.
	 * 
	 * @param frame
	 *            the frame
	 */
	public void makeStep(IStackFrame frame) {
		currentInstructionID++;
		long mem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		// Warning - can cause some Java Heap Size Memory exception
		if (hasTocreateStep) {
			// execution
			ProfilingInstruction instr = ModelFactory.eINSTANCE.createProfilingInstruction();
			instr.setInstructionID(currentInstructionID);
			instr.setLaunchedTime(System.currentTimeMillis());
			instr.getStackFrames().add(frame);
			instr.setContent(frame.getIOperation().getInstructions().get(frame.getLocation()).toString());
			// no link instr % atl
			instr.setLaunchedMemoryUsage(mem);

			currentOperation.getExecutionInstructions().add(instr);
		} else {
			if (mem > currentOperation.getMaxMemoryUsage()) {
				currentOperation.setMaxMemoryUsage(mem);
			}
			if (mem > currentOperation.getEndMemoryUsage()) {
				currentOperation.setEndMemoryUsage(mem);
			}
		}

		// update execution informations
		currentOperation.setTotalExecutedInstructions(currentOperation.getTotalExecutedInstructions() + 1);

	}

	/**
	 * Ends profiling execution.
	 */
	public void endExecution() {
		currentOperation = profilingModel;
	}

	/**
	 * Count total instructions for an operation.
	 * 
	 * @param op
	 *            profiling operation
	 * @return count
	 */
	private int countInstructions(ProfilingOperation op) {
		int result = 0;
		result += op.getTotalExecutedInstructions();
		for (ProfilingInstruction i : op.getExecutionInstructions()) {
			if (i instanceof ProfilingOperation) {
				ProfilingOperation tmpOp = (ProfilingOperation)i;
				result += tmpOp.getTotalExecutedInstructions();
			}
		}
		return result;
	}

	/**
	 * Returns the total time.
	 * 
	 * @return the total time
	 */
	public double getModelTotalTime() {
		ProfilingOperation pOp = getMainOperation();
		Double time = new Double((pOp.getEndTime() - pOp.getLaunchedTime()) / 1000.0);
		return time;
	}

	/**
	 * Returns the total instructions count.
	 * 
	 * @return the total instructions count
	 */
	public long getModelTotalInstructions() {
		ProfilingOperation po = getMainOperation();
		return po.getTotalExecutedInstructions();
	}

	private ProfilingOperation getMainOperation() {
		ATLOperation op = operationRegistry.get("main"); //$NON-NLS-1$
		ProfilingOperation po = (ProfilingOperation)op.getProfilingInstructions().get(0);
		return po;
	}

	// getters & setters
	public ProfilingModel getProfilingModel() {
		return profilingModel;
	}

	public void setProfilingModel(ProfilingModel profilingModel) {
		this.profilingModel = profilingModel;
	}

	public Map<String, ATLOperation> getOperationRegistry() {
		return operationRegistry;
	}

	public boolean isDebugMessages() {
		return seeDebugMessages;
	}

	public void setDebugMessages(boolean debugMessages) {
		this.seeDebugMessages = debugMessages;
	}

	public boolean isHasTocreateStep() {
		return hasTocreateStep;
	}

	public void setHasTocreateStep(boolean hasTocreateStep) {
		this.hasTocreateStep = hasTocreateStep;
	}
}
