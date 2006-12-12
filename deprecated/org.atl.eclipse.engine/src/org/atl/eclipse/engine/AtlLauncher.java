/*
 * Created on 1 juin 2004
 *
 */
package org.atl.eclipse.engine;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.atl.engine.vm.ASM;
import org.atl.engine.vm.ASMExecEnv;
import org.atl.engine.vm.ASMInterpreter;
import org.atl.engine.vm.ASMXMLReader;
import org.atl.engine.vm.Debugger;
import org.atl.engine.vm.NetworkDebugger;
import org.atl.engine.vm.SimpleDebugger;
import org.atl.engine.vm.nativelib.ASMModel;
import org.atl.engine.vm.nativelib.ASMModule;

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
	
    public Object launch(URL asmurl, Map models, Map asmParams) {
		return launch(asmurl, Collections.EMPTY_MAP, models, asmParams);
	}
	
    public Object launch(URL asmurl, Map libraries, Map models, Map asmParams) {
        return launch(asmurl, libraries, models, asmParams, Collections.EMPTY_LIST);
    }

    public Object launch(URL asmurl, Map libraries, Map models, Map asmParams, List superimpose) {
		return launch(asmurl, libraries, models, asmParams, false, superimpose);
	}
	
	public Object launch(URL asmurl, Map libraries, Map models, Map asmParams, boolean step, List superimpose) {
		return launch(asmurl, libraries, models, asmParams, new SimpleDebugger(
				/* step = */ step,
				/* stepops = */ new ArrayList(),
				/* deepstepops = */ new ArrayList(),
				/* nostepops = */ new ArrayList(),
				/* deepnostepops = */ new ArrayList(),
				/* showStackTrace = */ true
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
