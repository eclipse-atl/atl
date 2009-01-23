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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.tools.ant.BuildException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.m2m.atl.common.ATLExecutionException;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.ant.AtlBuildListener;
import org.eclipse.m2m.atl.core.ant.Messages;
import org.eclipse.m2m.atl.core.ant.tasks.nested.InModel;
import org.eclipse.m2m.atl.core.ant.tasks.nested.Library;
import org.eclipse.m2m.atl.core.ant.tasks.nested.OutModel;
import org.eclipse.m2m.atl.core.ant.tasks.nested.Param;
import org.eclipse.m2m.atl.core.ant.tasks.nested.Superimpose;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.core.service.LauncherService;

/**
 * Launches an ATL transformation, using the launcher specified as property in the ant project.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ATLModelTransformationTask extends AbstractAtlTask {

	protected boolean isRefiningTraceMode;

	protected File asmPath;

	protected List<InModel> inModels = new ArrayList<InModel>();

	protected List<OutModel> outModels = new ArrayList<OutModel>();

	protected List<InModel> inoutModels = new ArrayList<InModel>();

	protected List<Library> libraries = new ArrayList<Library>();

	protected Map<String, Object> options = new HashMap<String, Object>();

	protected List<Superimpose> superimposeModules = new ArrayList<Superimpose>();

	public void setRefining(boolean isRefining) {
		this.isRefiningTraceMode = isRefining;
	}

	public void setPath(File path) {
		this.asmPath = path;
	}

	/**
	 * Adds an input model to the task.
	 * 
	 * @param model
	 *            the given model
	 */
	public void addConfiguredInModel(InModel model) {
		inModels.add(model);
	}

	/**
	 * Adds an output model to the task.
	 * 
	 * @param model
	 *            the given model
	 */
	public void addConfiguredOutModel(OutModel model) {
		Map<String, Object> modelOptions = new HashMap<String, Object>();
		modelOptions.put(OPTION_MODEL_NAME, model.getName());
		modelOptions.put(OPTION_MODEL_PATH, model.getPath());
		modelOptions.put(OPTION_NEW_MODEL, true);
		if (model.getFactory() != null) {
			newModel(model.getFactory(), model.getModel(), model.getMetamodel(), modelOptions);
		} else {
			newModel(getDefaultModelFactory(), model.getModel(), model.getMetamodel(), modelOptions);
		}
		outModels.add(model);
	}

	/**
	 * Adds an input/output model to the task.
	 * 
	 * @param model
	 *            the given model
	 */
	public void addConfiguredInoutModel(InModel model) {
		inoutModels.add(model);
	}

	/**
	 * Adds a library to the task.
	 * 
	 * @param library
	 *            the given library
	 */
	public void addConfiguredLibrary(Library library) {
		libraries.add(library);
	}

	/**
	 * Adds a superimposition module to the task.
	 * 
	 * @param superimpose
	 *            the given superimposition module
	 */
	public void addConfiguredSuperimpose(Superimpose superimpose) {
		this.superimposeModules.add(superimpose);
	}

	/**
	 * Adds an option to the task.
	 * 
	 * @param option
	 *            the given option
	 */
	public void addConfiguredOption(Param option) {
		options.put(option.getName(), option.getValue());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.ant.tasks.AbstractAtlTask#execute()
	 */
	@Override
	public void execute() throws BuildException {
		log(Messages.getString("ATLModelTransformationTask.MSG", asmPath.toString(), getLauncherName())); //$NON-NLS-1$

		ILauncher launcherInstance = getLauncher();
		launcherInstance.initialize(options);

		if (asmPath == null) {
			error(Messages.getString("ATLModelTransformationTask.UNSPECIFIED_MODULE")); //$NON-NLS-1$
		}

		for (InModel model : inModels) {
			launcherInstance.addInModel(getModelByName(model.getModel()), model.getName(),
					getMetamodelName(model.getModel()));
		}
		for (InModel model : inoutModels) {
			launcherInstance.addInOutModel(getModelByName(model.getModel()), model.getName(),
					getMetamodelName(model.getModel()));
		}
		for (OutModel model : outModels) {
			launcherInstance.addOutModel(getModelByName(model.getModel()), model.getName(), model
					.getMetamodel());
		}
		for (Library library : libraries) {
			launcherInstance.addLibrary(library.getName(), getInputStreamFromPath(library.getPath()));
		}

		try {
			if (isRefiningTraceMode) {
				ModelFactory factory = AtlBuildListener.getModelFactory(launcherInstance
						.getDefaultModelFactoryName());
				IReferenceModel refiningTraceMetamodel = factory
						.getBuiltInResource(LauncherService.REFINING_TRACE_METAMODEL);
				getProject().addReference(LauncherService.REFINING_TRACE_METAMODEL, refiningTraceMetamodel);
				Map<String, Object> modelOptions = new HashMap<String, Object>();
				modelOptions.put(OPTION_MODEL_PATH, "temp"); //$NON-NLS-1$ 
				modelOptions.put(OPTION_MODEL_NAME, LauncherService.REFINING_TRACE_MODEL);
				modelOptions.put(OPTION_NEW_MODEL, true);
				IModel refiningTraceModel = newModel(factory, LauncherService.REFINING_TRACE_MODEL,
						LauncherService.REFINING_TRACE_METAMODEL, options);
				launcherInstance.addOutModel(refiningTraceModel, LauncherService.REFINING_TRACE_MODEL,
						LauncherService.REFINING_TRACE_METAMODEL);
			}
		} catch (ATLCoreException e) {
			error(Messages.getString("ATLModelTransformationTask.UNABLE_TO_LOAD_REFINING")); //$NON-NLS-1$
		}

		InputStream[] moduleInputStreams = new InputStream[superimposeModules.size() + 1];
		int i = 0;
		moduleInputStreams[0] = getInputStreamFromPath(asmPath);
		for (Superimpose superimposedModule : superimposeModules) {
			moduleInputStreams[i++] = getInputStreamFromPath(superimposedModule.getPath());
		}

		Object transformationResult = null;
		long startTime = System.currentTimeMillis();
		try {
			transformationResult = launcherInstance.launch(ILauncher.RUN_MODE, new NullProgressMonitor(),
					options, (Object[])moduleInputStreams);
		} catch (ATLExecutionException e) {
			error(e.getMessage(), e);
		}
		long endTime = System.currentTimeMillis();
		double executionTime = (endTime - startTime) / 1000.;

		getProject().addReference(RESULT_REFERENCE, transformationResult);
		log(Messages.getString("ATLModelTransformationTask.EXECUTION_TIME", executionTime)); //$NON-NLS-1$

		super.execute();
	}

	private IModel getModelByName(String name) {
		IModel res = (IModel)getProject().getReference(name);
		if (res == null) {
			error(Messages.getString("ATLModelTransformationTask.MODEL_NOT_FOUND", name)); //$NON-NLS-1$
		}
		return res;
	}

	private String getMetamodelName(String modelName) {
		IReferenceModel res = getModelByName(modelName).getReferenceModel();
		for (Iterator<?> iterator = getProject().getReferences().entrySet().iterator(); iterator.hasNext();) {
			Entry<?, ?> entry = (Entry<?, ?>)iterator.next();
			if (entry.getValue().equals(res)) {
				return (String)entry.getKey();
			}
		}
		return null;
	}

	private InputStream getInputStreamFromPath(File path) {
		try {
			return new FileInputStream(path);
		} catch (IOException e) {
			error(Messages.getString("ATLModelTransformationTask.FILE_NOT_FOUND", path), e); //$NON-NLS-1$
		}
		return null;
	}

}
