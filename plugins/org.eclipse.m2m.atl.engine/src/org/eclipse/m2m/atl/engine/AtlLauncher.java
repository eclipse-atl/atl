/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frédéric Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.m2m.atl.engine.vm.ASM;
import org.eclipse.m2m.atl.engine.vm.ASMExecEnv;
import org.eclipse.m2m.atl.engine.vm.ASMInterpreter;
import org.eclipse.m2m.atl.engine.vm.ASMOperation;
import org.eclipse.m2m.atl.engine.vm.ASMStackFrame;
import org.eclipse.m2m.atl.engine.vm.ASMXMLReader;
import org.eclipse.m2m.atl.engine.vm.ATLVMPlugin;
import org.eclipse.m2m.atl.engine.vm.Debugger;
import org.eclipse.m2m.atl.engine.vm.NetworkDebugger;
import org.eclipse.m2m.atl.engine.vm.SimpleDebugger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModule;

/**
 * @author Frederic Jouault
 *
 */
public class AtlLauncher {
	
	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);
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

	/**
	 * Backward compatible launch method. Leaves upgrade window.
	 * @param asmurl URL to the .asm transformation module
	 * @param libraries Map of library names mapped to URLs of their .asm files
	 * @param models Map of model names mapped to (input and output) ASMModels
	 * @param asmParams Voodoo parameters - always use Collections.EMPTY_MAP
	 * @param superimpose List of URLs to superimposed .asm transformation modules
	 * @deprecated
	 */
    public Object launch(URL asmurl, Map libraries, Map models, Map asmParams, List superimpose) {
		return launch(asmurl, libraries, models, asmParams, superimpose, Collections.EMPTY_MAP);
	}
	
//    public Object launch(URL asmurl, Map libraries, Map models, Map asmParams, List superimpose, boolean continueAfterErrors) {
//		return launch(asmurl, libraries, models, asmParams, false, superimpose, continueAfterErrors, Collections.EMPTY_MAP);
//	}
	
    /**
     * New launch method. Not backward compatible with previous versions of ATL.
     */
	public Object launch(URL asmurl, Map libraries, Map models, Map asmParams, List superimpose, Map options) {
		return launch(asmurl, libraries, models, asmParams, superimpose, options, new SimpleDebugger(
				/* step = */ "true".equals(options.get("step")), //$NON-NLS-1$ //$NON-NLS-2$
				/* stepops = */ new ArrayList(),
				/* deepstepops = */ new ArrayList(),
				/* nostepops = */ new ArrayList(),
				/* deepnostepops = */ new ArrayList(),
				/* showStackTrace = */ true,
				"true".equals(options.get("showSummary")), //$NON-NLS-1$ //$NON-NLS-2$
				"true".equals(options.get("profile")), //$NON-NLS-1$ //$NON-NLS-2$
				"true".equals(options.get("continueAfterError")) //$NON-NLS-1$ //$NON-NLS-2$
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
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
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

			ASMExecEnv env = new ASMExecEnv(asmModule, debugger, !"true".equals(options.get("disableAttributeHelperCache"))); //$NON-NLS-1$ //$NON-NLS-2$
			env.addPermission("file.read");
			env.addPermission("file.write");
			
			for(Iterator i = models.keySet().iterator() ; i.hasNext() ; ) {
				String mname = (String)i.next();
				env.addModel(mname, (ASMModel)models.get(mname));
			}
			
			for(Iterator i = libraries.keySet().iterator() ; i.hasNext() ; ) {
				String lname = (String)i.next();
				Object libASMOrURL = libraries.get(lname);
				ASM lib;
				if(libASMOrURL instanceof URL) {
					URL url = (URL)libASMOrURL;
					lib = new ASMXMLReader().read(new BufferedInputStream(url.openStream()));
				} else {
					lib = (ASM)libASMOrURL;
				}
				env.registerOperations(lib);
				
				// If there is a main operation, run it to register attribute helpers
				ASMOperation op = lib.getOperation("main"); //$NON-NLS-1$
				if(op != null)
					op.exec(ASMStackFrame.rootFrame(env, op, Arrays.asList(new Object[] {asmModule})));
			}

			// Register module operations AFTER lib operations to avoid overwriting 'main'
			env.registerOperations(asm);

            for(Iterator i = superimpose.iterator() ; i.hasNext() ; ) {
                URL url = (URL)i.next();
                ASM module = new ASMXMLReader().read(new BufferedInputStream(url.openStream()));
                AtlSuperimposeModule ami = new AtlSuperimposeModule(env, module);
                ami.adaptModuleOperations();
                env.registerOperations(module);
            }

    		boolean printExecutionTime = "true".equals(options.get("printExecutionTime")); //$NON-NLS-1$ //$NON-NLS-2$

    		long startTime = System.currentTimeMillis();
			ASMInterpreter ai = new ASMInterpreter(asm, asmModule, env, asmParams);
			long endTime = System.currentTimeMillis();
			if(printExecutionTime && !(debugger instanceof NetworkDebugger)) {
				logger.info(asm.getName() + " executed in " + ((endTime - startTime) / 1000.) + "s."); //$NON-NLS-1$ //$NON-NLS-2$
//				System.out.println(asm.getName() + " executed in " + ((endTime - startTime) / 1000.) + "s.");
			}

			ret = ai.getReturnValue();
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
		}
		
		return ret;
	}
}
