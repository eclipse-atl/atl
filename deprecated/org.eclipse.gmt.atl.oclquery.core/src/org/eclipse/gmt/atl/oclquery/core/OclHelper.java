package org.eclipse.gmt.atl.oclquery.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.atl.engine.vm.ASM;
import org.atl.engine.vm.ASMExecEnv;
import org.atl.engine.vm.ASMOperation;
import org.atl.engine.vm.ASMStackFrame;
import org.atl.engine.vm.Debugger;
import org.atl.engine.vm.SimpleDebugger;
import org.atl.engine.vm.StackFrame;
import org.atl.engine.vm.nativelib.ASMModel;
import org.atl.engine.vm.nativelib.ASMModule;
import org.atl.engine.vm.nativelib.ASMOclAny;

/**
 * 
 * @author Frédéric Jouault
 *
 */
public class OclHelper extends OclEvaluator {

	private String helper;
	private List parameters;
	private ASM compiledHelper;
	
	public OclHelper(String helper, List parameters) {
		this.helper = helper;
		this.parameters = parameters;
		this.compiledHelper = null;
	}

	public static ASMOclAny eval(String helper, Map arguments) throws Exception {
		List params = new ArrayList(arguments.keySet());
		List args = new ArrayList();
		for(Iterator i = params.iterator() ; i.hasNext() ; ) {
			args.add(arguments.get(i.next()));
		}
		OclHelper oh = new OclHelper(helper, params);
		return oh.eval(args);
	}
	
	public void compile() throws Exception {
		String params = "";
		for(Iterator i = parameters.iterator() ; i.hasNext() ; ) {
			if(!params.equals("")) {
				params += ", ";
			}
			params += i.next() + " : OclAny";
		}
		String query = "library test; helper def: test(" + params + ") : OclAny = " + helper + ";";
		compiledHelper = compile(query);
	}
	
	public ASMOclAny eval(List arguments) throws Exception {
		return eval(arguments, Collections.EMPTY_MAP);
	}
	
	public ASMOclAny eval(List arguments, Map models) throws Exception {
		ASMOclAny ret = null;
		
		arguments = new ArrayList(arguments);

		if(compiledHelper == null) {
			compile();
		}
		
		Debugger debugger = new SimpleDebugger(
				/* step = */ false,
				/* stepops = */ new ArrayList(),
				/* deepstepops = */ new ArrayList(),
				/* nostepops = */ new ArrayList(),
				/* deepnostepops = */ new ArrayList(),
				/* showStackTrace = */ true
		);
		ASMOperation op = compiledHelper.getOperation("test");
		ASMModule asmModule = new ASMModule(compiledHelper);
		arguments.add(0, asmModule);
		ASMExecEnv env = new ASMExecEnv(asmModule, debugger);
		for(Iterator i = models.keySet().iterator() ; i.hasNext() ; ) {
			String mname = (String)i.next();
			env.addModel(mname, (ASMModel)models.get(mname));
		}
		env.registerOperations(compiledHelper);
		StackFrame frame = ASMStackFrame.rootFrame(env, op, arguments);
		ret = op.exec(frame);
		
		return ret;
	}
}
