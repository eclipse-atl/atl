/*******************************************************************************
 * Copyright (c) 2008, 2010 Obeo.
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

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.m2m.atl.common.ATLLaunchConstants;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.core.service.LauncherService;
import org.eclipse.m2m.atl.core.ui.vm.asm.ASMFactory;
import org.eclipse.m2m.atl.core.ui.vm.asm.ASMModelWrapper;
import org.eclipse.m2m.atl.core.ui.vm.debug.NetworkDebugger;
import org.eclipse.m2m.atl.engine.vm.ASM;
import org.eclipse.m2m.atl.engine.vm.ASMExecEnv;
import org.eclipse.m2m.atl.engine.vm.ASMInterpreter;
import org.eclipse.m2m.atl.engine.vm.ASMOperation;
import org.eclipse.m2m.atl.engine.vm.ASMStackFrame;
import org.eclipse.m2m.atl.engine.vm.ASMXMLReader;
import org.eclipse.m2m.atl.engine.vm.AtlSuperimposeModule;
import org.eclipse.m2m.atl.engine.vm.Debugger;
import org.eclipse.m2m.atl.engine.vm.SimpleDebugger;
import org.eclipse.m2m.atl.engine.vm.VMException;
import org.eclipse.m2m.atl.engine.vm.AtlSuperimposeModule.AtlSuperimposeModuleException;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModule;

/**
 * The RegularVM implementation of the {@link ILauncher}.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class RegularVMLauncher implements ILauncher {

	/** The {@link ILauncher} extension name. */
	private static final String LAUNCHER_NAME = "Regular VM"; //$NON-NLS-1$

	private Map<String, IModel> models;

	private Map<String, ASM> libraries;

	private boolean checkSameModel;

	public String getName() {
		return LAUNCHER_NAME;
	}

	private void addModel(IModel model, String name, String referenceModelName) {
		if (models.containsKey(name)) {
			ATLLogger.warning(Messages.getString(
					"RegularVMLauncher.MODEL_REGISTERED", new Object[] {name})); //$NON-NLS-1$
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
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#addInModel(org.eclipse.m2m.atl.core.IModel,
	 *      java.lang.String, java.lang.String)
	 */
	public void addInModel(IModel model, String name, String referenceModelName) {
		setCheckSameModel(model);
		model.setIsTarget(false);
		addModel(model, name, referenceModelName);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#addInOutModel(org.eclipse.m2m.atl.core.IModel,
	 *      java.lang.String, java.lang.String)
	 */
	public void addInOutModel(IModel model, String name, String referenceModelName) {
		setCheckSameModel(model);
		model.setIsTarget(true);
		addModel(model, name, referenceModelName);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#addOutModel(org.eclipse.m2m.atl.core.IModel,
	 *      java.lang.String, java.lang.String)
	 */
	public void addOutModel(IModel model, String name, String referenceModelName) {
		setCheckSameModel(model);
		model.setIsTarget(true);
		addModel(model, name, referenceModelName);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#addLibrary(java.lang.String, java.lang.Object)
	 */
	public void addLibrary(String name, Object library) {
		if (libraries.containsKey(name)) {
			ATLLogger.warning(Messages.getString(
					"RegularVMLauncher.LIBRARY_REGISTERED", new Object[] {name})); //$NON-NLS-1$
		} else {
			libraries.put(name, getASMFromObject(library));
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
		checkSameModel = !LauncherService.getBooleanOption(options.get("allowInterModelReferences"), false); //$NON-NLS-1$
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
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#launch(java.lang.String,
	 *      org.eclipse.core.runtime.IProgressMonitor, java.util.Map, java.io.InputStream[])
	 */
	public Object launch(final String mode, final IProgressMonitor monitor,
			final Map<String, Object> options, final Object... modules) {
		try {
			if (mode.equals(ILaunchManager.DEBUG_MODE)) {
				return internalLaunch(
						new NetworkDebugger(getPort((ILaunch)options.get("launch")), true), options, modules); //$NON-NLS-1$
			} else {
				return internalLaunch(new SimpleDebugger(/* step = */LauncherService.getBooleanOption(options
						.get("step"), false), //$NON-NLS-1$ 
						/* stepops = */Collections.EMPTY_LIST,
						/* deepstepops = */Collections.EMPTY_LIST,
						/* nostepops = */Collections.EMPTY_LIST,
						/* deepnostepops = */Collections.EMPTY_LIST,
						/* showStackTrace = */true, LauncherService.getBooleanOption(options
								.get("showSummary"), false), //$NON-NLS-1$
						LauncherService.getBooleanOption(options.get("profile"), false), //$NON-NLS-1$ 
						LauncherService.getBooleanOption(options.get("continueAfterError"), false)//$NON-NLS-1$ 
						), options, modules);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new VMException(null, e.getLocalizedMessage(), e);
		} catch (IllegalArgumentException e) {
			throw new VMException(null, e.getLocalizedMessage(), e);
		} catch (CoreException e) {
			throw new VMException(null, e.getLocalizedMessage(), e);
		} catch (AtlSuperimposeModuleException e) {
			throw new VMException(null, e.getLocalizedMessage(), e);
		}
	}

	private int getPort(ILaunch launch) throws CoreException {
		String portOption = ""; //$NON-NLS-1$
		if (launch != null) {
			portOption = launch.getLaunchConfiguration().getAttribute(ATLLaunchConstants.PORT,
					Integer.valueOf(ATLLaunchConstants.DEFAULT_PORT).toString());
		}
		if (portOption.equals("")) { //$NON-NLS-1$
			portOption = Integer.valueOf(ATLLaunchConstants.DEFAULT_PORT).toString();
		}
		return new Integer(portOption).intValue();
	}

	/**
	 * Launches the transformation using the specified debugger.
	 * 
	 * @param debugger
	 *            the debugger
	 * @param options
	 *            the launch options
	 * @param modules
	 *            the transformation modules
	 * @return the transformation return value
	 * @throws AtlSuperimposeModuleException
	 */
	protected Object internalLaunch(Debugger debugger, Map<String, Object> options, Object[] modules)
			throws AtlSuperimposeModuleException {
		Object ret = null;
		ASM asm = getASMFromObject(modules[0]);
		ASMModule asmModule = new ASMModule(asm);

		ASMExecEnv env = new ASMExecEnv(asmModule, debugger, !LauncherService.getBooleanOption(options
				.get("disableAttributeHelperCache"), false)); //$NON-NLS-1$ 
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

		for (int i = 1; i < modules.length; i++) {
			ASM module = getASMFromObject(modules[i]);
			AtlSuperimposeModule ami = new AtlSuperimposeModule(env, module);
			ami.adaptModuleOperations();
			env.registerOperations(module);
		}

		boolean printExecutionTime = LauncherService.getBooleanOption(
				options.get("printExecutionTime"), false); //$NON-NLS-1$ 

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
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#loadModule(java.io.InputStream)
	 */
	public Object loadModule(InputStream inputStream) {
		return new ASMXMLReader().read(inputStream);
	}

	private ASM getASMFromObject(Object module) {
		if (module instanceof InputStream) {
			return (ASM)loadModule((InputStream)module);
		} else if (module instanceof ASM) {
			return (ASM)module;
		}
		return null;
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

	private void setCheckSameModel(IModel model) {
		if (model instanceof ASMModelWrapper) {
			ASMModel asmModel = ((ASMModelWrapper)model).getAsmModel();
			asmModel.setCheckSameModel(checkSameModel);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.launch.ILauncher#getModes()
	 */
	public String[] getModes() {
		return new String[] {RUN_MODE, DEBUG_MODE,};
	}

}
