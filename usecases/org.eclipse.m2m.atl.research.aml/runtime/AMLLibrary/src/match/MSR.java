/*******************************************************************************

 * Copyright (c) 2009 Ecole des Mines de Nantes.

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kelly Garces - initial API and implementation and/or initial documentation
 *******************************************************************************/ 

package match;

import java.util.List;

import java.util.Map;

import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame;
import org.eclipse.m2m.atl.engine.emfvm.lib.ExecEnv;
import org.eclipse.m2m.atl.engine.emfvm.lib.LibExtension;
import org.eclipse.m2m.atl.engine.emfvm.lib.Operation;

public class MSR implements LibExtension {
	public void apply(ExecEnv execEnv, Map<String, Object> options) {
		Operation opSendGetRequest = new Operation(6, "sendGetRequest") {
			
			public Object exec(AbstractStackFrame frame) {
				Object localVars[] = frame.getLocalVars();
				String msr = (String)localVars[0];
				String resultPath = (String)localVars[1];
				List terms = (List)localVars[2];
				List terms2 = (List)localVars[3];
				List leftDistractors = (List)localVars[4];
				List rightDistractors = (List)localVars[5];
				
				HTTPRequest.Instance().sendGetRequest(msr, terms, terms2, resultPath, leftDistractors, rightDistractors);
				return new Boolean(true);
			}
		};
		
		execEnv.registerOperation(String.class, opSendGetRequest);
		
		Operation opGetProperTerm = new Operation (2, "getProperTerm") {
		
			public Object exec(AbstractStackFrame frame) {
				Object localVars[] = frame.getLocalVars();
				String cad = (String)localVars[0];
				List distractors = (List)localVars[1];				
				return TermProcessor.Instance().getProperTerm(cad, distractors);
			}
		};
		
		execEnv.registerOperation(String.class, opGetProperTerm);
			
	}
}
