/*
 * Created on 1 juin 2004
 *
 */
package org.eclipse.m2m.atl.engine;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.m2m.atl.engine.vm.ASM;
import org.eclipse.m2m.atl.engine.vm.ASMExecEnv;
import org.eclipse.m2m.atl.engine.vm.ASMInterpreter;
import org.eclipse.m2m.atl.engine.vm.ASMOperation;
import org.eclipse.m2m.atl.engine.vm.ASMStackFrame;
import org.eclipse.m2m.atl.engine.vm.ASMXMLReader;
import org.eclipse.m2m.atl.engine.vm.Debugger;
import org.eclipse.m2m.atl.engine.vm.NetworkDebugger;
import org.eclipse.m2m.atl.engine.vm.SimpleDebugger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModule;

/**
 * @author JOUAULT
 *
 */
public class AtlLauncher {
	
	private static AtlLauncher defaultLauncher = null;
	
	public static AtlLauncher getDefault() {
		if(defaultLauncher == null) {
			defaultLauncher = new AtlLauncher();
		}
		return defaultLauncher;
	}
	
	private AtlLauncher() {
		
	}

//    public Object launch(URL asmurl, Map models, Map asmParams) {
//		return launch(asmurl, Collections.EMPTY_MAP, models, asmParams);
//	}
//	
//    public Object launch(URL asmurl, Map libraries, Map models, Map asmParams) {
//        return launch(asmurl, libraries, models, asmParams, Collections.EMPTY_LIST);
//    }
//
//    public Object launch(URL asmurl, Map libraries, Map models, Map asmParams, List superimpose) {
//		return launch(asmurl, libraries, models, asmParams, false, superimpose, CONTINUE_AFTER_ERRORS_DEFAULT_VALUE, Collections.EMPTY_MAP);
//	}
	
//    public Object launch(URL asmurl, Map libraries, Map models, Map asmParams, List superimpose, boolean continueAfterErrors) {
//		return launch(asmurl, libraries, models, asmParams, false, superimpose, continueAfterErrors, Collections.EMPTY_MAP);
//	}
	
	public Object launch(URL asmurl, Map libraries, Map models, Map asmParams, List superimpose, Map options) {
		return launch(asmurl, libraries, models, asmParams, superimpose, options, new SimpleDebugger(
				/* step = */ "true".equals(options.get("step")),
				/* stepops = */ new ArrayList(),
				/* deepstepops = */ new ArrayList(),
				/* nostepops = */ new ArrayList(),
				/* deepnostepops = */ new ArrayList(),
				/* showStackTrace = */ true,
				"true".equals(options.get("showSummary")),
				"true".equals(options.get("profile")),
				"true".equals(options.get("continueAfterError"))
		));
	}
	
//	public Object debug(URL asmurl, Map libraries, Map models, Map asmParams) {
//		return launch(asmurl, libraries, models, asmParams, new NetworkDebugger(6060, true));
//	}
	
    public Object debug(URL asmurl, Map libraries, Map models, Map asmParams, List superimpose, Map options) {
        return launch(asmurl, libraries, models, asmParams, superimpose, options, new NetworkDebugger(6060, true));
    }
    
    public Object launch(URL asmurl, Map libraries, Map models, Map asmParams, List superimpose, Map options, Debugger debugger) {
		try {
			ASM asm = new ASMXMLReader().read(new BufferedInputStream(asmurl.openStream()));
			return launch(asm, libraries, models, asmParams, superimpose, options, debugger);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

//    public Object launch(ASM asm, Map libraries, Map models, Map asmParams, Debugger debugger) {
//        return launch(asm, libraries, models, asmParams, debugger, Collections.EMPTY_LIST, Collections.EMPTY_MAP);
//    }
    
	public Object launch(ASM asm, Map libraries, Map models, Map asmParams, List superimpose, Map options, Debugger debugger) {
		Object ret = null;
		try {
			ASMModule asmModule = new ASMModule(asm);

			ASMExecEnv env = new ASMExecEnv(asmModule, debugger);
			
			for(Iterator i = models.keySet().iterator() ; i.hasNext() ; ) {
				String mname = (String)i.next();
				env.addModel(mname, (ASMModel)models.get(mname));
			}

			env.registerOperations(asm);
			
			for(Iterator i = libraries.keySet().iterator() ; i.hasNext() ; ) {
				String lname = (String)i.next();
				URL url = (URL)libraries.get(lname);
				ASM lib = new ASMXMLReader().read(new BufferedInputStream(url.openStream()));
				env.registerOperations(lib);
				
				// If there is a main operation, run it to register attribute helpers
				ASMOperation op = lib.getOperation("main");
				if(op != null)
					op.exec(ASMStackFrame.rootFrame(env, op, Arrays.asList(new Object[] {asmModule})));

			}

            for(Iterator i = superimpose.iterator() ; i.hasNext() ; ) {
                URL url = (URL)i.next();
                ASM module = new ASMXMLReader().read(new BufferedInputStream(url.openStream()));
                AtlSuperimposeModule ami = new AtlSuperimposeModule(env, module);
                ami.adaptModuleOperations();
                env.registerOperations(module);
            }

    		boolean printExecutionTime = "true".equals(options.get("printExecutionTime"));

    		long startTime = System.currentTimeMillis();
			ASMInterpreter ai = new ASMInterpreter(asm, asmModule, env, asmParams);
			long endTime = System.currentTimeMillis();
			if(printExecutionTime && !(debugger instanceof NetworkDebugger))
				System.out.println(asm.getName() + " executed in " + ((endTime - startTime) / 1000.) + "s.");

			ret = ai.getReturnValue();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
}
