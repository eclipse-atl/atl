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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame;
import org.eclipse.m2m.atl.engine.emfvm.lib.ExecEnv;
import org.eclipse.m2m.atl.engine.emfvm.lib.LibExtension;
import org.eclipse.m2m.atl.engine.emfvm.lib.Operation;

/**
 * 
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a>
 *
 */
public class MatchingMetricsUtils implements LibExtension {

	@Override
	public void apply(ExecEnv execEnv, Map<String, Object> options) {
		final Map<String, String> expectedObtainedModels = new HashMap<String, String>();
		String s = (String)options.get("expectedObtainedModels");
		if(s != null) {
			for(String e : s.split(",")) {
				String mapping[] = e.split("=");
				expectedObtainedModels.put(mapping[0], mapping[1]);
			}
		}
		// TODO Auto-generated method stub
		Operation op = new Operation(1, "getRealEqualModelName") {
			public Object exec(AbstractStackFrame frame) {
				Object localVars[] = frame.getLocalVars();
				String modelName = (String)localVars[0];
				return expectedObtainedModels.get(modelName);				
			}
		};
		
		execEnv.registerOperation(String.class, op);

	}

}
