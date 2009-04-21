package org.eclipse.m2m.atl.engine.asm.lib;

import java.io.Reader;
import java.io.StringReader;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.engine.emfvm.StackFrame;
import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame;
import org.eclipse.m2m.atl.engine.emfvm.lib.ExecEnv;
import org.eclipse.m2m.atl.engine.emfvm.lib.LibExtension;
import org.eclipse.m2m.atl.engine.emfvm.lib.Operation;
import org.eclipse.m2m.atl.engine.emfvm.lib.Tuple;

public class ASMString implements LibExtension {

	public void apply(ExecEnv execEnv, Map options) {
		execEnv.registerOperation(String.class, createEvalSOTS(), "evalSOTS");
		execEnv.registerOperation(String.class, createEvalSOTSBrackets(), "evalSOTSBrackets");
	}

	public static Operation createEvalSOTS() {
		return new Operation(2) {
			public Object exec(AbstractStackFrame frame) {
				Object[] localVars = frame.getLocalVars();
				String self = (String)localVars[0];
				Tuple args = (Tuple)localVars[1];
				Object ret = null;
				try {
					ret = new SOTSExpression2(self).exec((StackFrame)frame, args);
				} catch (Exception e) {
					ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}
				return ret;
			}
		};
	}

	public static Operation createEvalSOTSBrackets() {
		return new Operation(2) {
			public Object exec(AbstractStackFrame frame) {
				Object[] localVars = frame.getLocalVars();
				String self = (String)localVars[0];
				Tuple args = (Tuple)localVars[1];

				StringBuffer ret = new StringBuffer();
				Reader in = new StringReader(self);
				int c;

				try {
					boolean done = false;
					do {
						c = in.read();
						switch (c) {
							case -1:
								done = true;
								break;
							case '{':
								StringBuffer exp = new StringBuffer();
								while ((c = in.read()) != '}') {
									exp.append((char)c);
								}
								Object result = new SOTSExpression2(exp.toString()).exec((StackFrame)frame, args);
								if (result instanceof Collection) {
									result = ((Collection)result).iterator().next();
								}
								ret.append(result.toString());
								break;
							default:
								ret.append((char)c);
								break;
						}
					} while (!done);
				} catch (Exception e) {
					ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}
				return ret.toString();
			}
		};
	}

}
