/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Dennis Wagelaar (Vrije Universiteit Brussel)
 *******************************************************************************/
package org.eclipse.m2m.atl.core.ui.vm;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.adt.debug.core.AtlDebugTarget;
import org.eclipse.m2m.atl.adt.debug.core.AtlRunTarget;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.core.ui.vm.asm.ASMFactory;
import org.eclipse.m2m.atl.core.ui.vm.asm.ASMModelWrapper;
import org.eclipse.m2m.atl.engine.vm.ASM;
import org.eclipse.m2m.atl.engine.vm.ASMExecEnv;
import org.eclipse.m2m.atl.engine.vm.ASMInterpreter;
import org.eclipse.m2m.atl.engine.vm.ASMOperation;
import org.eclipse.m2m.atl.engine.vm.ASMStackFrame;
import org.eclipse.m2m.atl.engine.vm.ASMXMLReader;
import org.eclipse.m2m.atl.engine.vm.AtlSuperimposeModule;
import org.eclipse.m2m.atl.engine.vm.AtlSuperimposeModule.AtlSuperimposeModuleException;
import org.eclipse.m2m.atl.engine.vm.Debugger;
import org.eclipse.m2m.atl.engine.vm.NetworkDebugger;
import org.eclipse.m2m.atl.engine.vm.SimpleDebugger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModule;

/**
 * The RegularVM implementation of the {@link ILauncher}.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class RegularVMLauncher implements ILauncher {

	private static final String LAUNCHER_NAME = "RegularVM"; //$NON-NLS-1$

	private Map<String, IModel> models;

	private Map<String, ASM> libraries;

	public String getName() {
		return LAUNCHER_NAME;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#addInModel(org.eclipse.m2m.atl.core.IModel,
	 *      java.lang.String, java.lang.String)
	 */
	public void addInModel(IModel model, String name, String referenceModelName) {
		if (models.containsKey(name)) {
			ATLLogger.warning(Messages.getString(
					"RegularVMLauncher.MODEL_EVER_REGISTERED", new Object[] {name})); //$NON-NLS-1$
		} else {
			models.put(name, model);
		}
		if (!models.containsKey(referenceModelName)) {
			models.put(referenceModelName, model.getReferenceModel());
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#addInOutModel(org.eclipse.m2m.atl.core.IModel,
	 *      java.lang.String, java.lang.String)
	 */
	public void addInOutModel(IModel model, String name, String referenceModelName) {
		model.setIsTarget(true);
		addInModel(model, name, referenceModelName);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#addOutModel(org.eclipse.m2m.atl.core.IModel,
	 *      java.lang.String, java.lang.String)
	 */
	public void addOutModel(IModel model, String name, String referenceModelName) {
		model.setIsTarget(true);
		addInModel(model, name, referenceModelName);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param library
	 *            the library module {@link InputStream}
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#addLibrary(java.lang.String, java.lang.Object)
	 */
	public void addLibrary(String name, Object library) {
		if (libraries.containsKey(name)) {
			ATLLogger.warning(Messages.getString(
					"RegularVMLauncher.LIBRARY_EVER_REGISTERED", new Object[] {name})); //$NON-NLS-1$
		} else {
			ASMXMLReader reader = new ASMXMLReader();
			ASM asmLibrary = reader.read((InputStream)library);
			libraries.put(name, asmLibrary);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#initialize(java.util.Map)
	 */
	public void initialize(Map<String, Object> options) {
		models = new HashMap<String, IModel>();
		libraries = new HashMap<String, ASM>();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#getDefaultModelFactoryName()
	 */
	public String getDefaultModelFactoryName() {
		return ASMFactory.MODEL_FACTORY_NAME;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#launch(java.util.Map, java.lang.Object[])
	 */
	public Object launch(final Map<String, Object> options, final Object... modules) {
		return launch(ILauncher.RUN_MODE, options, modules);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#launch(java.lang.String, java.util.Map,
	 *      java.lang.Object[])
	 */
	public Object launch(final String mode, final Map<String, Object> options, final Object... modules) {
		IDebugTarget mTarget = null;
		ILaunch launchParam = (ILaunch)options.get("launch"); //$NON-NLS-1$
		try {
			/*
			 * If the mode chosen was Debug, an ATLDebugTarget was created
			 */
			if (mode.equals(ILaunchManager.DEBUG_MODE)) {
				if (launchParam != null) {
					// link between the debug target and the source locator
					launchParam.setSourceLocator(new AtlSourceLocator());
					mTarget = new AtlDebugTarget(launchParam);
				}
				Thread th = new Thread() {
					@Override
					public void run() {
						launch(new NetworkDebugger(6060, true), options, modules);
					}
				};
				th.start();
				if (launchParam != null) {
					((AtlDebugTarget)mTarget).start();
					launchParam.addDebugTarget(mTarget);
				}
			} else {
				if (launchParam != null) {
					// Run mode
					launchParam.setSourceLocator(new AtlSourceLocator());
					mTarget = new AtlRunTarget(launchParam);
					launchParam.addDebugTarget(mTarget);
				}
				launch(new SimpleDebugger(/* step = */"true".equals(options.get("step")), //$NON-NLS-1$ //$NON-NLS-2$
						/* stepops = */Collections.EMPTY_LIST,
						/* deepstepops = */Collections.EMPTY_LIST,
						/* nostepops = */Collections.EMPTY_LIST,
						/* deepnostepops = */Collections.EMPTY_LIST,
						/* showStackTrace = */true, "true".equals(options.get("showSummary")), //$NON-NLS-1$ //$NON-NLS-2$
						"true".equals(options.get("profile")), //$NON-NLS-1$ //$NON-NLS-2$
						"true".equals(options.get("continueAfterError")) //$NON-NLS-1$ //$NON-NLS-2$
						), options, modules);
				if (launchParam != null) {
					mTarget.terminate();
				}
			}
		} catch (DebugException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		return null;
	}

	private Object launch(Debugger debugger, Map<String, Object> options, Object[] modules) {
		Object ret = null;
		ASM asm = new ASMXMLReader().read(new BufferedInputStream((InputStream)modules[0]));
		ASMModule asmModule = new ASMModule(asm);

		ASMExecEnv env = new ASMExecEnv(asmModule, debugger,
				!"true".equals(options.get("disableAttributeHelperCache"))); //$NON-NLS-1$ //$NON-NLS-2$
		env.addPermission("file.read"); //$NON-NLS-1$
		env.addPermission("file.write"); //$NON-NLS-1$

		for (Iterator<String> i = models.keySet().iterator(); i.hasNext();) {
			String mname = i.next();
			env.addModel(mname, ((ASMModelWrapper)models.get(mname)).getAsmModel());
		}

		for (Iterator<String> i = libraries.keySet().iterator(); i.hasNext();) {
			String lname = i.next();
			ASM lib = libraries.get(lname);
			env.registerOperations(lib);

			// If there is a main operation, run it to register attribute helpers
			ASMOperation op = lib.getOperation("main"); //$NON-NLS-1$
			if (op != null) {
				op.exec(ASMStackFrame.rootFrame(env, op, Arrays.asList(new Object[] {asmModule})));
			}
		}

		// Register module operations AFTER lib operations to avoid overwriting 'main'
		env.registerOperations(asm);

		try {
			for (int i = 1; i < modules.length; i++) {
				InputStream is = (InputStream)modules[i];
				ASM module = new ASMXMLReader().read(new BufferedInputStream(is));
				AtlSuperimposeModule ami = new AtlSuperimposeModule(env, module);
				ami.adaptModuleOperations();
				env.registerOperations(module);
			}
		} catch (AtlSuperimposeModuleException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		boolean printExecutionTime = "true".equals(options.get("printExecutionTime")); //$NON-NLS-1$ //$NON-NLS-2$

		long startTime = System.currentTimeMillis();
		ASMInterpreter ai = new ASMInterpreter(asm, asmModule, env, options);
		long endTime = System.currentTimeMillis();
		if (printExecutionTime && !(debugger instanceof NetworkDebugger)) {
			ATLLogger.info(asm.getName() + " executed in " + ((endTime - startTime) / 1000.) + "s."); //$NON-NLS-1$ //$NON-NLS-2$
		}

		ret = ai.getReturnValue();

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#getModel(java.lang.String)
	 */
	public IModel getModel(String modelName) {
		return models.get(modelName);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#getLibrary(java.lang.String)
	 */
	public Object getLibrary(String libraryName) {
		return libraries.get(libraryName);
	}
}
