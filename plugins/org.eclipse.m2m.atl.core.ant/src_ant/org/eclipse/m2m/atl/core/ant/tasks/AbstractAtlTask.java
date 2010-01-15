/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - Ant tooling
 *******************************************************************************/
package org.eclipse.m2m.atl.core.ant.tasks;

import java.util.Map;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.ant.AtlBuildListener;
import org.eclipse.m2m.atl.core.ant.Messages;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.core.service.CoreService;

/**
 * Common ATL task:
 * <ul>
 * <li>handle atl log.</li>
 * <li>provide utility methods.</li>
 * <li>handle finalization (dispose of models).</li>
 * </ul>
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AbstractAtlTask extends Task {

	/** The launcher property name. */
	public static final String LAUNCHER_PROPERTY = "atl.launcher"; //$NON-NLS-1$

	/** Default launcher name. */
	public static final String DEFAULT_LAUNCHER = "EMF-specific VM"; //$NON-NLS-1$

	/** The result reference name. */
	public static final String RESULT_REFERENCE = "atl.launch.result"; //$NON-NLS-1$

	/** Default model handler name. */
	public static final String DEFAULT_MODEL_HANDLER = "EMF"; //$NON-NLS-1$

	/*
	 * RegularVM options.
	 * @see org.eclipse.m2m.atl.core.ui.vm.asm.ASMFactory
	 */
	/** The model handler name. */
	public static final String OPTION_MODEL_HANDLER = "modelHandlerName"; //$NON-NLS-1$

	/** The model name. */
	public static final String OPTION_MODEL_NAME = "modelName"; //$NON-NLS-1$

	/** The model path. */
	public static final String OPTION_MODEL_PATH = "path"; //$NON-NLS-1$

	/** The newModel boolean. */
	public static final String OPTION_NEW_MODEL = "newModel"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.apache.tools.ant.Task#init()
	 */
	@Override
	public void init() throws BuildException {
		AtlBuildListener.attachBuildListener(getProject());
		super.init();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.apache.tools.ant.Task#execute()
	 */
	@Override
	public void execute() throws BuildException {
		super.execute();
	}

	/**
	 * Stops the build, deletes log.
	 * 
	 * @param msg
	 *            the error message
	 * @param e
	 *            the thrown exception
	 */
	protected void error(String msg, Throwable e) {
		e.printStackTrace();
		throw new BuildException(msg, e);
	}

	/**
	 * Stops the build, deletes log.
	 * 
	 * @param msg
	 *            the error message
	 */
	protected void error(String msg) {
		throw new BuildException(msg);
	}

	/**
	 * Returns the launcher name.
	 * 
	 * @return the launcher name
	 */
	protected String getLauncherName() {
		String launcherName = getProject().getProperty(LAUNCHER_PROPERTY);
		if (launcherName == null) {
			launcherName = DEFAULT_LAUNCHER;
		}
		return launcherName;
	}

	/**
	 * Returns the launcher.
	 * 
	 * @return the launcher
	 */
	protected ILauncher getLauncher() {
		ILauncher launcher = null;
		String launcherName = getLauncherName();
		try {
			launcher = CoreService.getLauncher(launcherName);
		} catch (ATLCoreException e) {
			error(Messages.getString("AbstractAtlTask.UNABLE_TO_LOAD_LAUNCHER", launcherName), e); //$NON-NLS-1$
		}
		if (launcher == null) {
			error(Messages.getString("AbstractAtlTask.UNABLE_TO_LOAD_LAUNCHER", launcherName)); //$NON-NLS-1$
		}
		return launcher;
	}

	/**
	 * Returns the default modelFactory for this launcher.
	 * 
	 * @return the default modelFactory for this launcher
	 */
	protected ModelFactory getDefaultModelFactory() {
		ModelFactory factory = null;
		ILauncher launcher = getLauncher();
		factory = AtlBuildListener.getModelFactory(launcher.getDefaultModelFactoryName());
		return factory;
	}

	/**
	 * Creates a new {@link IModel} using the specified factory.
	 * 
	 * @param factoryName
	 *            the {@link ModelFactory} name
	 * @param modelName
	 *            the model name
	 * @param referenceModelName
	 *            the reference model name
	 * @param options
	 *            the creation options
	 * @return the new {@link IModel}
	 * @throws BuildException
	 */
	protected IModel newModel(String factoryName, String modelName, String referenceModelName,
			Map<String, Object> options) throws BuildException {
		ModelFactory factoryInstance = null;
		IModel model = null;
		factoryInstance = AtlBuildListener.getModelFactory(factoryName);
		if (factoryInstance == null) {
			error(Messages.getString("AbstractAtlTask.FACTORY_NOT_FOUND", factoryName)); //$NON-NLS-1$
		} else {
			return newModel(factoryInstance, modelName, referenceModelName, options);
		}
		return model;
	}

	/**
	 * Creates a new {@link IModel} using the specified factory.
	 * 
	 * @param factory
	 *            the {@link ModelFactory}
	 * @param modelName
	 *            the model name
	 * @param referenceModelName
	 *            the reference model name
	 * @param options
	 *            the creation options
	 * @return the new {@link IModel}
	 * @throws BuildException
	 */
	protected IModel newModel(ModelFactory factory, String modelName, String referenceModelName,
			Map<String, Object> options) throws BuildException {
		IModel model = null;
		if (referenceModelName == null) {
			error(Messages.getString("AbstractAtlTask.REFERENCE_MODEL_UNSPECIFIED")); //$NON-NLS-1$
		}
		IReferenceModel referenceModelInstance = (IReferenceModel)getProject().getReference(
				referenceModelName);
		if (referenceModelInstance == null) {
			error(Messages.getString("AbstractAtlTask.REFERENCE_MODEL_NOT_FOUND", referenceModelName)); //$NON-NLS-1$
		}
		try {
			model = factory.newModel(referenceModelInstance, options);
		} catch (ATLCoreException e) {
			error(e.getMessage(), e);
		}
		if (modelName == null) {
			error(Messages.getString("AbstractAtlTask.UNSPECIFIED_NAME")); //$NON-NLS-1$
		}
		getProject().addReference(modelName, model);
		return model;
	}

	/**
	 * Creates a new {@link IReferenceModel} using the specified factory.
	 * 
	 * @param factory
	 *            the {@link ModelFactory}
	 * @param modelName
	 *            the model name
	 * @param options
	 *            the creation options
	 * @return the new {@link IReferenceModel}
	 * @throws BuildException
	 */
	protected IReferenceModel newReferenceModel(ModelFactory factory, String modelName,
			Map<String, Object> options) throws BuildException {
		IReferenceModel referenceModel = null;
		try {
			referenceModel = factory.newReferenceModel(options);
		} catch (ATLCoreException e) {
			error(e.getMessage(), e);
		}
		if (modelName == null) {
			error(Messages.getString("AbstractAtlTask.UNSPECIFIED_NAME")); //$NON-NLS-1$
		}
		getProject().addReference(modelName, referenceModel);
		return referenceModel;
	}

}
