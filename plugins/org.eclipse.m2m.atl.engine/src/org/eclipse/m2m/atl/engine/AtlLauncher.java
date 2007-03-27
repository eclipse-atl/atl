/*
 * Created on 1 juin 2004
 *
 */
package org.eclipse.m2m.atl.engine;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.m2m.atl.engine.vm.ASM;
import org.eclipse.m2m.atl.engine.vm.ASMExecEnv;
import org.eclipse.m2m.atl.engine.vm.ASMInterpreter;
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
	
	/* This is the default value in case no value is specified by caller.
	 * AtlLaunchConfigurationDelegate always specifies a value and has its own default value (false).
	 * Other callers (like ant tasks), which do not support setting continueAfterErrors, will use this default value.
	 */
	private final static boolean CONTINUE_AFTER_ERRORS_DEFAULT_VALUE = true;
	
	private static AtlLauncher defaultLauncher = null;
	
	public static AtlLauncher getDefault() {
		if(defaultLauncher == null) {
			defaultLauncher = new AtlLauncher();
		}
		return defaultLauncher;
	}
	
	private AtlLauncher() {
		
	}
	
    public Object launch(URL asmurl, Map models, Map asmParams) {
		return launch(asmurl, Collections.EMPTY_MAP, models, asmParams);
	}
	
    public Object launch(URL asmurl, Map libraries, Map models, Map asmParams) {
        return launch(asmurl, libraries, models, asmParams, Collections.EMPTY_LIST);
    }

    public Object launch(URL asmurl, Map libraries, Map models, Map asmParams, List superimpose) {
		return launch(asmurl, libraries, models, asmParams, false, superimpose, CONTINUE_AFTER_ERRORS_DEFAULT_VALUE);
	}
	
    public Object launch(URL asmurl, Map libraries, Map models, Map asmParams, List superimpose, boolean continueAfterErrors) {
		return launch(asmurl, libraries, models, asmParams, false, superimpose, continueAfterErrors);
	}
	
	public Object launch(URL asmurl, Map libraries, Map models, Map asmParams, boolean step, List superimpose, boolean continueAfterErrors) {
		return launch(asmurl, libraries, models, asmParams, new SimpleDebugger(
				/* step = */ step,
				/* stepops = */ new ArrayList(),
				/* deepstepops = */ new ArrayList(),
				/* nostepops = */ new ArrayList(),
				/* deepnostepops = */ new ArrayList(),
				/* showStackTrace = */ true,
				continueAfterErrors
		), superimpose);
	}
	
	public Object debug(URL asmurl, Map libraries, Map models, Map asmParams) {
		return launch(asmurl, libraries, models, asmParams, new NetworkDebugger(6060, true));
	}
	
    public Object debug(URL asmurl, Map libraries, Map models, Map asmParams, List superimpose) {
        return launch(asmurl, libraries, models, asmParams, new NetworkDebugger(6060, true), superimpose);
    }
    
    public Object launch(URL asmurl, Map libraries, Map models, Map asmParams, Debugger debugger) {
        return launch(asmurl, libraries, models, asmParams, debugger, Collections.EMPTY_LIST);
    }

    public Object launch(URL asmurl, Map libraries, Map models, Map asmParams, Debugger debugger, List superimpose) {
		try {
			ASM asm = new ASMXMLReader().read(new BufferedInputStream(asmurl.openStream()));
			return launch(asm, libraries, models, asmParams, debugger, superimpose);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

    public Object launch(ASM asm, Map libraries, Map models, Map asmParams, Debugger debugger) {
        return launch(asm, libraries, models, asmParams, debugger, Collections.EMPTY_LIST);
    }
    
	public Object launch(ASM asm, Map libraries, Map models, Map asmParams, Debugger debugger, List superimpose) {
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
                AtlModuleInheritance ami = new AtlModuleInheritance(env, lib);
                ami.adaptModuleOperations();
				env.registerOperations(lib);
			}

            for(Iterator i = superimpose.iterator() ; i.hasNext() ; ) {
                URL url = (URL)i.next();
                ASM module = new ASMXMLReader().read(new BufferedInputStream(url.openStream()));
                AtlSuperimposeModule ami = new AtlSuperimposeModule(env, module);
                ami.adaptModuleOperations();
                env.registerOperations(module);
            }

			ASMInterpreter ai = new ASMInterpreter(asm, asmModule, env, asmParams);
			ret = ai.getReturnValue();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
}
