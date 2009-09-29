/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.debug.core;

import java.util.logging.Level;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IWatchExpressionDelegate;
import org.eclipse.debug.core.model.IWatchExpressionListener;
import org.eclipse.debug.core.model.IWatchExpressionResult;
import org.eclipse.m2m.atl.common.ATLLogger;

/**
 * A delegate which computes the value of a watch expression when provided a context. Watch delegates are
 * provided on a per debug model basis. Watch expressions query the appropriate delegate based on the debug
 * model of the context element. Plug-ins that wish to contribute watch expression delegates may do so using
 * the org.eclipse.debug.core.watchExpressionDelegates extension point.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class AtlWatchExpressionDelegate implements IWatchExpressionDelegate {

	/**
	 * This inner class implements IWatchExpression The result of an evaluation performed by an
	 * org.eclipse.debug.core.model.IWatchExpressionDelegate. A watch expression reports the value of the
	 * evaluation and any errors or exceptions that occurred.
	 * 
	 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
	 */
	class AtlWatchExpressionResult implements IWatchExpressionResult {

		String[] errorMessages;

		IValue value;

		DebugException de;

		public AtlWatchExpressionResult(DebugException de, String[] errorMessages, IValue value) {
			this.errorMessages = errorMessages;
			this.value = value;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.debug.core.model.IWatchExpressionResult#getValue()
		 */
		public IValue getValue() {
			return value;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.debug.core.model.IWatchExpressionResult#hasErrors()
		 */
		public boolean hasErrors() {
			return (errorMessages != null) && (errorMessages.length > 0);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.debug.core.model.IWatchExpressionResult#getErrorMessages()
		 */
		public String[] getErrorMessages() {
			return errorMessages;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.debug.core.model.IWatchExpressionResult#getExpressionText()
		 */
		public String getExpressionText() {
			try {
				return value.getValueString();
			} catch (DebugException e) {
				return null;
			}
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.debug.core.model.IWatchExpressionResult#getException()
		 */
		public DebugException getException() {
			return de;
		}

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.IWatchExpressionDelegate#evaluateExpression(java.lang.String, org.eclipse.debug.core.model.IDebugElement, org.eclipse.debug.core.model.IWatchExpressionListener)
	 */
	public void evaluateExpression(String expression, IDebugElement context, IWatchExpressionListener listener) {

		AtlStackFrame frame = null;
		if (context instanceof AtlStackFrame) {
			frame = (AtlStackFrame)context;
		} else if (context instanceof IThread) {
			try {
				frame = (AtlStackFrame)((IThread)context).getTopStackFrame();
			} catch (DebugException e) {
				ATLLogger.log(Level.INFO,e.getLocalizedMessage(), e);
			}
		}
		if (frame == null) {
			listener.watchEvaluationFinished(null);
		} else {
			AtlWatchExpressionResult atlwe = doEvaluation(frame, expression);
			listener.watchEvaluationFinished(atlwe);
		}
	}

	/**
	 * This method should evaluate the expression, the parsed expression should be sent to the ATL VM.
	 * 
	 * @return
	 */
	private AtlWatchExpressionResult doEvaluation(AtlStackFrame frame, String expression) {
		//CMD QUERY doesn't work yet
		DebugException de = null;
		String[] errorMessages = null;
		IValue value = null;

//		try {
//			List parameters = new ArrayList();
//			IVariable[] variables = frame.getVariables();
//			for (int i = 0; i < variables.length; i++) {
//				String pname = variables[i].getName();
//				if (!pname.equals("self")) { //$NON-NLS-1$
//					parameters.add(pname);
//				}
//			}
//
//			ASM asm = new OclHelper(expression, parameters).compile();
//			StringWriter sw = new StringWriter();
//			new ASMXMLWriter(new PrintWriter(sw), false).print(asm);
//			AtlDebugTarget debugTarget = (AtlDebugTarget)frame.getDebugTarget();
//			ADWPDebugger debugger = debugTarget.getDebugger();
//			Value val = debugger.request(ADWPDebugger.CMD_QUERY, Arrays.asList(new Object[] {
//					frame.getStackFrame(), StringValue.valueOf(sw.toString()),}));
//
//			value = new AtlValue(val, debugTarget);
//		} catch (DebugException e) {
//			de = e;
//		} catch (IOException e) {
//			de = new DebugException(
//					new Status(
//							Status.ERROR,
//							"org.eclipse.m2m.atl.debug.core", Status.OK, Messages.getString("AtlWatchExpressionDelegate.EXPRESSIONERROR"), e)); //$NON-NLS-1$//$NON-NLS-2$
//		}
		return new AtlWatchExpressionResult(de, errorMessages, value);
	}

}
